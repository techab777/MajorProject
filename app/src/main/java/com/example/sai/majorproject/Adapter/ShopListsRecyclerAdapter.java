package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.ShopInfoModel;
import com.example.sai.majorproject.R;

import java.util.List;

public class ShopListsRecyclerAdapter extends RecyclerView.Adapter<ShopListsRecyclerAdapter.MyViewHolder>{
   Context context;
   List<ShopInfoModel> shopInfoModels;

   public ShopListsRecyclerAdapter(Context context,List<ShopInfoModel> shopInfoModels){

       this.context=context;
       this.shopInfoModels=shopInfoModels;
   }

    @NonNull
    @Override
    public ShopListsRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.shop_list_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopListsRecyclerAdapter.MyViewHolder myViewHolder, int position) {
       ShopInfoModel shopInfoModel=shopInfoModels.get(position);
       myViewHolder.txt_Shopname.setText(shopInfoModel.getShop_Name());
       myViewHolder.txt_ShopAddress.setText(shopInfoModel.getShop_Address());
       myViewHolder.txt_Catogries.setText(shopInfoModel.getShop_catogeies());
       myViewHolder.txt_rating.setText(shopInfoModel.getShop_rating());

    }

    @Override
    public int getItemCount()
    {
        return shopInfoModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt_Shopname,txt_ShopAddress,txt_Catogries,txt_rating;
        ImageView img_ShopItemList;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_Shopname=(TextView)itemView.findViewById(R.id.txt_shoplistitemname);
            txt_ShopAddress=(TextView)itemView.findViewById(R.id.txt_shoplistitemaddress);
            txt_Catogries=(TextView)itemView.findViewById(R.id.txt_shoplistitemcatogeries);
            txt_rating=(TextView)itemView.findViewById(R.id.txt_shopitemlistrating);
            img_ShopItemList=(ImageView)itemView.findViewById(R.id.img_shoplistitem);
        }
    }
}
