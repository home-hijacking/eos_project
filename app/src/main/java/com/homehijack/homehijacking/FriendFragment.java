package com.homehijack.homehijacking;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.homehijack.homehijacking.ui.login.LoginActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class FriendFragment extends Fragment {

    ViewGroup viewGroup;
    private RecyclerView recyclerView;
    private FriendAdapter friendAdapter;
    private ArrayList<Friend> list = new ArrayList<>();
    private FloatingActionButton floatingActionButton;


    public FriendFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_friend, container, false);

        recyclerView = (RecyclerView) viewGroup.findViewById(R.id.rcv_friend);
        friendAdapter = new FriendAdapter(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(friendAdapter);
        floatingActionButton = (FloatingActionButton) viewGroup.findViewById(R.id.fab_add_friend);


        list.clear();

        list.add(new Friend("윤건우","윤건우 주소", "inticoy@gmail.com", false));
        list.add(new Friend("유석원","유석원 주소", "cactus@gmail.com", false));
        list.add(new Friend("윤무원","윤무원 주소", "muwony@gmail.com", true));

        friendAdapter.setOnItemClickListener(new FriendAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                //TODO: 클릭했을시 방정보 acticity 뜨도록

                Intent intent = new Intent(getActivity(), RoomInfo.class);
                startActivity(intent);

//                list.add(new Friend("윤건우", "알아서 뭐해", "xxxx@gmail.com", true));
//                friendAdapter.notifyDataSetChanged();
            }
        });




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                list.add(new Friend("윤건우", "알아서 뭐해", "xxxx@gmail.com", true));
//                friendAdapter.notifyDataSetChanged();
            }
        });

        return viewGroup;
    }
}