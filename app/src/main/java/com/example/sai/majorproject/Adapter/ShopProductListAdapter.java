package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sai.majorproject.DataModel.ShopProductInfoModel;
import com.example.sai.majorproject.R;

import java.util.List;

public class ShopProductListAdapter extends RecyclerView.Adapter<ShopProductListAdapter.MyViewHolder> {
    Context context;
    List<ShopProductInfoModel> shopProductInfoModels;


    public ShopProductListAdapter(Context context,List<ShopProductInfoModel> shopProductInfoModels){

        this.context=context;
        this.shopProductInfoModels=shopProductInfoModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.shop_product_list_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        ShopProductInfoModel shopProductInfoModel=shopProductInfoModels.get(position);

        myViewHolder.txt_productName.setText(shopProductInfoModel.getProduct_name());
        myViewHolder.txt_productRating.setText(shopProductInfoModel.getProduct_rating());
        myViewHolder.txt_offer.setText(shopProductInfoModel.getProduct_offer());
        myViewHolder.txt_productPrize.setText(String.valueOf(shopProductInfoModel.getProduct_prize()));

    }

    @Override
    public int getItemCount() {
        return shopProductInfoModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_productName,txt_productPrize,txt_productRating,txt_offer;
        ImageView img_product,img_order;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_productName=(TextView)itemView.findViewById(R.id.txt_productname);
            txt_productPrize=(TextView)itemView.findViewById(R.id.txt_productprize);
            txt_productRating=(TextView)itemView.findViewById(R.id.txt_rating);
            txt_offer=(TextView)itemView.findViewById(R.id.txt_offer);
            img_order=(ImageView)itemView.findViewById(R.id.img_rating);
            img_product=(ImageView)itemView.findViewById(R.id.img_shopproduct);
        }
    }
    private void add()
    {

    }
}
