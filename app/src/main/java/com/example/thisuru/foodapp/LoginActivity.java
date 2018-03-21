package com.example.thisuru.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";


    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });


    }

    /**
     * Validate credencials
     * @param userName
     * @param userPassword
     */
    private void validate(String userName,String userPassword){
        Log.v(TAG, "un " + userName + " pw "+ userPassword);
        if((userName.equals("User") ) && (userPassword.equals("1234"))){
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }
}
