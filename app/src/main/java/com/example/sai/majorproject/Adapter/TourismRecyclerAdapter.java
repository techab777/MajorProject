package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.sai.majorproject.Activities.TourismDetailActivity;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.TourismPlaceMaster;
import com.example.sai.majorproject.R;

import java.util.List;

public class TourismRecyclerAdapter extends RecyclerView.Adapter<TourismRecyclerAdapter.MyViewHolder> {
   Context context;
   List<TourismPlaceMaster> tourismPlaceMasters;

    public TourismRecyclerAdapter(Context context, List<TourismPlaceMaster> tourismPlaceMasters) {
        this.context = context;
        this.tourismPlaceMasters = tourismPlaceMasters;
    }

    @NonNull
    @Override
    public TourismRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.tourism_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }
    @Override
    public int getItemCount() {
        return tourismPlaceMasters.size();
    }

    public void onBindViewHolder(@NonNull TourismRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        TourismPlaceMaster tourismPlaceMaster=tourismPlaceMasters.get(position);
        String path=UrlConstants.ImageUrl+tourismPlaceMaster.place_header_image;
        myViewHolder.tourism_txt.setText(tourismPlaceMaster.getPlace_name());
        Glide.with(context).load(path).into(myViewHolder.tourism_img);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView tourism_img;
        TextView tourism_txt;
        CardView tourism_cardview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tourism_img=(ImageView)itemView.findViewById(R.id.tourism_img);
            tourism_txt=(TextView)itemView.findViewById(R.id.tourism_txt);
            tourism_cardview=(CardView)itemView.findViewById(R.id.tourism_cardview);
            tourism_cardview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId()==tourism_cardview.getId()){
                TourismPlaceMaster tourismPlaceMaster=tourismPlaceMasters.get(getAdapterPosition());
                Intent intent=new Intent(context, TourismDetailActivity.class);
                intent.putExtra("placemodel",tourismPlaceMaster);
                context.startActivity(intent);
            }
        }
    }
/*
    private Bitmap getImageFromName(String imageName)
    {

        final Bitmap[] bitmap = new Bitmap[1];
        ImageRequest imageRequest=new ImageRequest(UrlConstants.ImageUrl,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap image) {
                        bitmap[0] =image;
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(imageRequest);

        return bitmap[0];
    }*/

}

