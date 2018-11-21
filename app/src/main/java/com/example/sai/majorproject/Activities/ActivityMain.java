package com.example.sai.majorproject.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.sai.majorproject.Fragments.EducationFragment;
import com.example.sai.majorproject.Fragments.HealthcareFragment;
import com.example.sai.majorproject.Fragments.HomeFragment;
import com.example.sai.majorproject.Fragments.HotelRestorentFragment;
import com.example.sai.majorproject.Fragments.ResidentialFragment;
import com.example.sai.majorproject.Fragments.ServicesFragment;
import com.example.sai.majorproject.Fragments.SoppingFragment;
import com.example.sai.majorproject.Fragments.TourismFragment;
import com.example.sai.majorproject.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar tab_toolbar;
    private TabLayout tab_tabLayout;
    private ViewPager tab_viewpager;
    ViewPageAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_layout);

        tab_toolbar=(Toolbar) findViewById(R.id.tab_toolbar);
        setSupportActionBar(tab_toolbar);

        getSupportActionBar().setTitle("Categories");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, tab_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tab_viewpager=(ViewPager)findViewById(R.id.tab_viewpager);
        setupViewPager(tab_viewpager);

        tab_tabLayout=(TabLayout)findViewById(R.id.tab_tablayout);
        tab_tabLayout.setupWithViewPager(tab_viewpager);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void setupViewPager(ViewPager viewPager){

        ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment(),"Home");
        adapter.addFragment(new TourismFragment(),"Tourism");
        adapter.addFragment(new SoppingFragment(),"Shopping");
        adapter.addFragment(new EducationFragment(),"Education");
        adapter.addFragment(new HealthcareFragment(),"Healthcare");
        adapter.addFragment(new ServicesFragment(),"Services");
        adapter.addFragment(new ResidentialFragment(),"Residential");
        adapter.addFragment(new HotelRestorentFragment(),"Hotel&Restorent");

        viewPager.setAdapter(adapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        if (menuItem.getItemId()==R.id.nav_business)
        {
            String list[]={"School/College/Institute/Hospital","Service","Residential","Hotel/Restrurant"};
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setSingleChoiceItems(R.array.list_bussiness_type, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setTitle("Select Bussiness Type");

            builder.create().show();

            return true;
        }

        return true;
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList=new ArrayList<>();
        private final List<String>fragmentTitleList=new ArrayList<>();

        public ViewPageAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            return fragmentTitleList.get(position);
        }


        @Override
        public int getCount()
        {
            return fragmentList.size();
        }


        public void addFragment(Fragment fragment,String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
            }
    }

    public void add()
    {

    }
}
