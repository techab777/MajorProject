package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.ShoppingHomeModel;
import com.example.sai.majorproject.R;

import java.util.List;

public class ShoppingHomeAdapter extends RecyclerView.Adapter<ShoppingHomeAdapter.MyViewHolder> {
    Context context;
    List<ShoppingHomeModel> shoppingHomeModels;

    public ShoppingHomeAdapter(Context context,List<ShoppingHomeModel> shoppingHomeModels){
        this.context=context;
        this.shoppingHomeModels=shoppingHomeModels;
    }
    @NonNull
    @Override
    public ShoppingHomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingHomeAdapter.MyViewHolder myViewHolder, int position) {
        ShoppingHomeModel shoppingHomeModel=shoppingHomeModels.get(position);
        myViewHolder.txt_shopping_type.setText(shoppingHomeModel.getShopping_categorie());

    }

    @Override
    public int getItemCount() {
        return shoppingHomeModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img_shopping;
        TextView  txt_shopping_type;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img_shopping=(ImageView)itemView.findViewById(R.id.img_home);
            txt_shopping_type=(TextView)itemView.findViewById(R.id.txt_home);
            img_shopping.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
