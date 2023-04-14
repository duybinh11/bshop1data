package fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bshop1.CartAdapter;
import com.example.bshop1.R;

import java.util.ArrayList;
import java.util.List;

import Model.ItemCart;


public class cart extends Fragment {
    List<ItemCart> itemListCart;

    RecyclerView rccvCart;
    CartAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        initRecycleView();
        removeItemCart();
    }
    public void anhXa(View view){
        itemListCart = new ArrayList<>();
        itemListCart.add(new ItemCart(R.drawable.food,1,"Ao",10,4));
        itemListCart.add(new ItemCart(R.drawable.clother,1,"Quan",15,4));
        itemListCart.add(new ItemCart(R.drawable.mu,1,"giay",10,3));
        itemListCart.add(new ItemCart(R.drawable.chelsea,1,"dep",11,4));
        itemListCart.add(new ItemCart(R.drawable.liver,1,"tui",16,5));
        itemListCart.add(new ItemCart(R.drawable.phpa,1,"mu",10,4));
        rccvCart = view.findViewById(R.id.rccvCart);
    }
    public void initRecycleView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        rccvCart.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(itemListCart);
        rccvCart.setAdapter(adapter);
    }
    public void removeItemCart(){
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                itemListCart.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(rccvCart);
    }


}