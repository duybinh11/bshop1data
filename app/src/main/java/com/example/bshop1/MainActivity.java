package com.example.bshop1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnSignUp;
    static final int CODE = 10;
    EditText edtUser,edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        btnLogin.setOnClickListener(AC_BTN);
        btnSignUp.setOnClickListener(AC_BTN);
    }
    public void anhXa(){
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
    }

    View.OnClickListener AC_BTN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLogin:{
                    if(edtUser.getText().toString().equals("a") && edtPass.getText().toString().equals("a")){
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                    break;
                }
                case R.id.btnSignUp:{
                    Intent intent = new Intent(MainActivity.this,SignUp.class);
                    startActivityForResult(intent,CODE);
                    break;
                }
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE && resultCode == RESULT_OK ){
            String user = data.getStringExtra("user");
            String pass = data.getStringExtra("pass");
            edtUser.setText(user);
            edtPass.setText(pass);
        }
    }
}