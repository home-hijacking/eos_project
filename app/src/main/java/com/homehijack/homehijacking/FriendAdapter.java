package com.homehijack.homehijacking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.Holder> {
    private Context context;
    private ArrayList<Friend> list = new ArrayList<>();

    private OnItemClickListener onItemClickListener = null;
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = (OnItemClickListener) listener;
    }

    public FriendAdapter(Context context, ArrayList<Friend> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FriendAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull FriendAdapter.Holder holder, int position) {
        int itemPosition = position;
        String host;
        holder.tvName.setText(list.get(itemPosition).name);
        holder.tvAddress.setText(list.get(itemPosition).address);
        if (list.get(itemPosition).isHost) {
            host = "호스트";
        } else {
            host = "게스트";
        }

        holder.tvIsHost.setText(host);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvIsHost;

        public Holder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            tvIsHost = (TextView) view.findViewById(R.id.tvHost);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position!= RecyclerView.NO_POSITION){
                        if(onItemClickListener != null){
                            onItemClickListener.onItemClick(v, position);
                        }
                    }
                }
            });

        }
    }
}
