package com.homehijack.homehijacking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText editTextID = (EditText) findViewById(R.id.signUpID);
        EditText editTextEmail = (EditText) findViewById(R.id.signUpEmail);
        EditText editTextPassword = (EditText) findViewById(R.id.signUpPassword);
        EditText editTextName = (EditText) findViewById(R.id.signUpName);
        EditText editTextNickname =(EditText)  findViewById(R.id.signUpNickname);
        EditText editTextPhone = (EditText) findViewById(R.id.signUpPhone);
        EditText editTextAddress = (EditText) findViewById(R.id.signUpAddress);
        Button buttonSignUp = (Button) findViewById(R.id.signUpBtSignUp);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        RadioButton radioButton;

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String id = editTextID.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String password = editTextPassword.getText().toString();
                final String name = editTextName.getText().toString();
                final String nickname = editTextNickname.getText().toString();
                final String phone = editTextPhone.getText().toString();
                final String address = editTextAddress.getText().toString();

                final boolean isHost;

                final int num = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(num);
                final String host = radioButton.getText().toString();
                if(host.equals("호스트")){
                    isHost = true;
                }else{
                    isHost = false;
                }

                System.out.println(id);
                System.out.println(email);
                System.out.println(password);
                System.out.println(name);
                System.out.println(nickname);
                System.out.println(phone);
                System.out.println(address);
                System.out.println(isHost);
            }
        });
    }

}