package com.example.bshop1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCart extends AppCompatActivity {
    ImageView img;
    TextView tvName,tvCost,tvSL;
    EditText edtSLMua;
    Button btnBuy,btnCannel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        anhXa();
    }
    public void anhXa(){
        img = findViewById(R.id.img);
        tvName = findViewById(R.id.tvName);
        tvCost = findViewById(R.id.tvCost);
        tvSL = findViewById(R.id.tvSL);
        edtSLMua = findViewById(R.id.edtSlMua);
        btnBuy = findViewById(R.id.btnBuy);
        btnCannel = findViewById(R.id.btnCannel);
    }

}