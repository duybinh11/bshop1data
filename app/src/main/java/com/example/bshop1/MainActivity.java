package com.example.bshop1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import Api.ApiClient;
import Api.ApiService;
import Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnSignUp;
    EditText edtUser,edtPass;
    CheckBox checkBox;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        btnLogin.setOnClickListener(AC_BTN);
        btnSignUp.setOnClickListener(AC_BTN);
        initAccount();
    }
    public void anhXa(){

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        checkBox = findViewById(R.id.cb);
    }

    View.OnClickListener AC_BTN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnLogin:{
                    ApiClient.getRetrofit().create(ApiService.class).getUser(edtUser.getText().toString(),edtPass.getText().toString())
                            .enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            user = response.body();
                            if(checkBox.isChecked()){
                                remember(edtUser.getText().toString(),edtPass.getText().toString(),true);
                            }else{
                                remember(edtUser.getText().toString(),edtPass.getText().toString(),false);
                            }
                            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                            intent.putExtra("account",user);
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "sai", Toast.LENGTH_SHORT).show();
                        }
                    });

                    break;
                }
                case R.id.btnSignUp:{
                    Intent intent = new Intent(MainActivity.this,SignUp.class);
                    startActivityForResult(intent,10);
                    break;
                }
            }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == RESULT_OK ){
            String user = data.getStringExtra("user");
            String pass = data.getStringExtra("pass");
            edtUser.setText(user);
            edtPass.setText(pass);
        }
    }
    public void remember(String user,String pass,boolean check){
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if(!check){
            editor.clear();
        }else{
            editor.putString("username", user);
            editor.putString("password", pass);
            editor.putBoolean("check", check);
        }
        editor.commit();
    }
    public void initAccount(){
        SharedPreferences sharedPref = getSharedPreferences("my_prefs", MODE_PRIVATE);
        boolean check = sharedPref.getBoolean("check",false);
        if (check){
            String username = sharedPref.getString("username", "");
            String password = sharedPref.getString("password", "");
            edtUser.setText(username);
            edtPass.setText(password);
            checkBox.setChecked(true);
        }

    }
}