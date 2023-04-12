package fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bshop1.BanChayAdapter;
import com.example.bshop1.NewAdapter;
import com.example.bshop1.R;
import com.example.bshop1.Search;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import Api.ApiClient;
import Api.ApiService;

import Model.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends Fragment {
    ImageSlider imsl;
    TextView tvSearch;
    RecyclerView rccvBanChay,rccvNew;
    List<Item> itemListBanChay,itemListNew;
    SwipeRefreshLayout swipeRefreshLayout;
    GridView gv;
    List<SlideModel> slideModelList;
    List<String> stringList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        initImageSlide();
        initBanChay();
        initNew();
        swipeRefreshLayout.setOnRefreshListener(lamMoi);
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Search.class);
                startActivity(intent);
            }
        });

    }



    @SuppressLint("ResourceAsColor")
    public void anhXa(View view){
        itemListNew = new ArrayList<>();
        rccvNew = view.findViewById(R.id.rccvNew);
        itemListBanChay = new ArrayList<>();
        rccvBanChay = view.findViewById(R.id.rccvBanChay);
        imsl = view.findViewById(R.id.imsl);
        slideModelList = new ArrayList<>();
        tvSearch = view.findViewById(R.id.tvSearch);
        swipeRefreshLayout = view.findViewById(R.id.refresh);
    }
    public void initImageSlide(){
        ApiClient.getRetrofit().create(ApiService.class).getImg().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                stringList = new ArrayList<>(response.body());
                for (int i = 0; i <stringList.size() ; i++) {
                    slideModelList.add(new SlideModel(stringList.get(i),null));
                }
                imsl.setImageList(slideModelList);
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(getContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void initBanChay(){
        itemListBanChay.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListBanChay.add(new Item(2,"Banh",R.drawable.food));
        itemListBanChay.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListBanChay.add(new Item(2,"Banh",R.drawable.food));
        itemListBanChay.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListBanChay.add(new Item(2,"Banh",R.drawable.food));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        BanChayAdapter banChayAdapter = new BanChayAdapter(itemListBanChay);
        rccvBanChay.setLayoutManager(linearLayoutManager);
        rccvBanChay.setAdapter(banChayAdapter);
    }
    public void initNew(){
        //add data
        itemListNew.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListNew.add(new Item(2,"Banh",R.drawable.food));
        itemListNew.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListNew.add(new Item(2,"Banh",R.drawable.food));
        itemListNew.add(new Item(1 ,"Clother",R.drawable.clother));
        itemListNew.add(new Item(2,"Banh",R.drawable.food));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        NewAdapter adapter = new NewAdapter(itemListNew);
        rccvNew.setLayoutManager(linearLayoutManager);
        rccvNew.setAdapter(adapter);
    }
    SwipeRefreshLayout.OnRefreshListener lamMoi = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast.makeText(getContext(), "loading", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        }
    };

}