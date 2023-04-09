package com.example.bshop1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText edtUser,edtPass1,edtPass2,edtAdress,edtSdt;
    Button btnCofirm,btnCannel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        anhXa();
        btnCofirm.setOnClickListener(AC_BTN);
    }
    public void anhXa(){
        edtUser = findViewById(R.id.edtUser);
        edtPass1 = findViewById(R.id.edtPass1);
        edtPass2 = findViewById(R.id.edtPass2);
        edtAdress = findViewById(R.id.edtAddress);
        edtSdt = findViewById(R.id.edtPhone);
        btnCofirm = findViewById(R.id.btnConfirm);
        btnCannel = findViewById(R.id.btnCannel);
    }

    View.OnClickListener AC_BTN = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnConfirm:{
                    String user = edtUser.getText().toString();
                    String pass1 = edtPass1.getText().toString();
                    String pass2 = edtPass2.getText().toString();
                    String address = edtAdress.getText().toString();
                    String phone = edtSdt.getText().toString();
                    if(!check_pass(pass1,pass2)){
                        Toast.makeText(SignUp.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(SignUp.this, MainActivity.class);
                        intent.putExtra("user",user);
                        intent.putExtra("pass",pass1);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                    break;
                }
                case R.id.btnCannel:{
                    finish();
                    break;
                }
            }
        }
    };
    public boolean check_pass(String a,String b){
        if(a.equals(b)){
            return true;
        }
        return  false;
    }
}