package com.example.bshop1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.IOException;

import Api.ApiClient;
import Api.ApiService;
import Model.User;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    EditText edtUser,edtPass1,edtPass2,edtAdress,edtSdt,edtOld;
    TextView tvGalery;
    ImageView img;
    Button btnCofirm,btnCannel;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        anhXa();
        acBtnGalery();
        acBtnConfirm();
    }
    public void anhXa(){
        tvGalery = findViewById(R.id.tvGalery);
        img = findViewById(R.id.imgAvatar);
        edtOld = findViewById(R.id.edtOld);
        edtUser = findViewById(R.id.edtUser);
        edtPass1 = findViewById(R.id.edtPass1);
        edtPass2 = findViewById(R.id.edtPass2);
        edtAdress = findViewById(R.id.edtAddress);
        edtSdt = findViewById(R.id.edtPhone);
        btnCofirm = findViewById(R.id.btnConfirm);
        btnCannel = findViewById(R.id.btnCannel);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
    }

    private void acBtnGalery() {
        tvGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,10);
            }
        });
    }
    public void acBtnConfirm(){
        btnCofirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File(getRealPathFromURI(uri));
                String user = edtUser.getText().toString();
                String pass1 = edtPass1.getText().toString();
                String pass2 = edtPass2.getText().toString();
                int old = Integer.valueOf(edtOld.getText().toString());
                String address = edtAdress.getText().toString();
                String phone = edtSdt.getText().toString();
                String img = file.getName();
                if(pass1.equals(pass2 )){


                    RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                    MultipartBody.Part imagePart = MultipartBody.Part.createFormData("avatar", file.getName(), requestBody);
                    ApiClient.getRetrofit().create(ApiService.class).postUser(user,pass1,old,address,phone,img).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                String x = response.body().string();
                                Toast.makeText(SignUp.this, x, Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(SignUp.this, t.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                    ApiClient.getRetrofit().create(ApiService.class).putImg(imagePart).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {}
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(SignUp.this, t.toString(), Toast.LENGTH_SHORT).show();
                            Log.d("loi111",t.toString());
                        }
                    });
                    Intent intent = new Intent(SignUp.this,MainActivity.class);
                    intent.putExtra("user",user);
                    intent.putExtra("pass",pass1);
                    setResult(RESULT_OK,intent);
                    finish();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && data != null){
            uri = data.getData();
            img.setImageURI(uri);
        }
    }

    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }

}