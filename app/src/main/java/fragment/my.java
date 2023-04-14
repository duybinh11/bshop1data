package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bshop1.MainActivity2;
import com.example.bshop1.R;

import Model.User;

public class my extends Fragment {

    User user;
    TextView tvId,tvUser,tvOld,tvAddress,tvPhone;
    ImageView img;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         user =((MainActivity2)getActivity()).user;
         tvId = view.findViewById(R.id.tvId);
         tvUser = view.findViewById(R.id.tvUser);
         tvOld = view.findViewById(R.id.tvOld);
         tvAddress = view.findViewById(R.id.tvAddress);
         tvPhone = view.findViewById(R.id.tvPhone);
         img = view.findViewById(R.id.imgImg);
         StringBuilder stringBuilder = new StringBuilder();
         stringBuilder.append("http://192.168.141.220/shop/img/");
         stringBuilder.append(user.getAvatar());

         tvId.setText(String.valueOf(user.getId()));
         tvUser.setText(user.getUser());
         tvOld.setText(String.valueOf(user.getOld()));
         tvAddress.setText(user.getAddress());
         tvPhone.setText(user.getPhone());
         Glide.with(this).load(stringBuilder.toString()).into(img);
    }
}