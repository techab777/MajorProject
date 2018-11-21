package com.example.sai.majorproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sai.majorproject.DataModel.TourismPlaceMaster;
import com.example.sai.majorproject.Manifest;
import com.example.sai.majorproject.R;
import com.example.sai.majorproject.Utilities.UtilityMethods;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import org.w3c.dom.Text;

public class TourismDetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt_history;
    AppBarLayout tourism_appbar;
    Toolbar tourism_toolbar;
    CollapsingToolbarLayout tourism_toolbar_layout;
    FloatingActionButton tourism_floating_btn;
    SliderLayout sliderLayout;
    TourismPlaceMaster tourismPlaceMaster;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tourism_detail_layout);

        tourismPlaceMaster= (TourismPlaceMaster) getIntent().getSerializableExtra("placemodel");

        Toast.makeText(this, tourismPlaceMaster.place_name, Toast.LENGTH_SHORT).show();
        txt_history=(TextView)findViewById(R.id.txt_history);
        txt_history.setText(tourismPlaceMaster.getPlace_history());
        tourism_appbar=(AppBarLayout)findViewById(R.id.tourism_appbar);
        tourism_toolbar=(Toolbar)findViewById(R.id.tourism_toolbar);
        tourism_floating_btn=(FloatingActionButton)findViewById(R.id.tourism_floating_btn);
        tourism_toolbar_layout=(CollapsingToolbarLayout)findViewById(R.id.tourism_toolbar_layout);
        sliderLayout=(SliderLayout)findViewById(R.id.sliderLayout);
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.DROP);
        sliderLayout.setScrollTimeInSec(1);
        tourism_floating_btn.setOnClickListener(this);

        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},100);
        setSliderViews();

    }
    private void setSliderViews(){
        for (int i=0;i<=3;i++){
            SliderView sliderView=new SliderView(this);
            switch (i){
                case 0:sliderView.setImageUrl("http://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 1:sliderView.setImageUrl("http://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&dpr=750&w=1260");
                    break;
                case 2:sliderView.setImageUrl("http://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
                case 3:sliderView.setImageUrl("http://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderView.setDescription("setDescription"+(i+1));
            final int finalI=i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {

                    Toast.makeText(TourismDetailActivity.this, "This is slider"+(finalI+1), Toast.LENGTH_SHORT).show();
                }
            });
            //at last add this view in your layout
            sliderLayout.addSliderView(sliderView);

            }
        }

    @Override
    public void onClick(View view) {

        if (view.getId()==tourism_floating_btn.getId())
        {
            UtilityMethods.startNewActivity(this,TourismPlaceMapActivity.class);
        }
    }
}

