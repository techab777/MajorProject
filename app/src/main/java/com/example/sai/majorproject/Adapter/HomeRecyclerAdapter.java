package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.sai.majorproject.Constants.UrlConstants;
import com.example.sai.majorproject.DataModel.HomeDataModel;
import com.example.sai.majorproject.Fragments.TourismFragment;
import com.example.sai.majorproject.R;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.MyViewHolder> {
   Context context;
   List<HomeDataModel> homeDataModels;
    final  float BLUR_RADIUS=5f;

    public HomeRecyclerAdapter(Context context, List<HomeDataModel> homeDataModels) {
        this.context = context;
        this.homeDataModels = homeDataModels;
    }

    @NonNull
    @Override
    public HomeRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_item_layout,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeRecyclerAdapter.MyViewHolder myViewHolder, int position) {
        HomeDataModel homeDataModel=homeDataModels.get(position);
        final String path= UrlConstants.HomeImageUrl+homeDataModel.home_categorie_image;
        myViewHolder.txt_home.setText(homeDataModel.getHome_categorie());
        /*Volley.newRequestQueue(context).add(new ImageRequest(path, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                // Do something with loaded bitmap...
                Glide.with(context).load(blur(bitmap)).into(myViewHolder.img_home);
            }
        }, 1024, 1024, null, null));
        */
        Glide.with(context).load(path).into(myViewHolder.img_home);
    }

    @Override
    public int getItemCount() {
        return homeDataModels.size();
    }


    public Bitmap blur(Bitmap image) {
        if (null == image)
        {
            return  null;
        }else {
            Bitmap outputBitmap = Bitmap.createBitmap(image);
            final RenderScript renderScript =RenderScript.create(context);
            Allocation tmpIn = Allocation.createFromBitmap(renderScript,image);
            Allocation tmpout = Allocation.createFromBitmap(renderScript,outputBitmap);
            //intrinsic gausian blur filte


            ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create
                    (renderScript, Element.U8_4(renderScript));
            theIntrinsic.setRadius(BLUR_RADIUS);
            theIntrinsic.setInput(tmpIn);
            theIntrinsic.forEach(tmpout);
            tmpout.copyTo(outputBitmap);
            return outputBitmap;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_home;
        TextView txt_home;
        CardView home_cardview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_home=(ImageView)itemView.findViewById(R.id.img_home);
            txt_home=(TextView)itemView.findViewById(R.id.txt_home);
            home_cardview=(CardView)itemView.findViewById(R.id.home_cardview);

            home_cardview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId()==home_cardview.getId()){
                HomeDataModel homeDataModel=homeDataModels.get(getAdapterPosition());
               // Intent intent=new Intent(context, TourismFragment.class);
               // context.startActivity(intent);
            }
        }
    }


}
