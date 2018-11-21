package com.example.sai.majorproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

import java.util.List;

public class OrganizationStepperAdapter extends AbstractFragmentStepAdapter {

    private Context context;
    List<Fragment> fragmentList;

    public OrganizationStepperAdapter(@NonNull FragmentManager fm, @NonNull Context context, List<Fragment> listFrag) {
        super(fm, context);
        this.context=context;
        this.fragmentList=listFrag;
    }

    @Override
    public Step createStep(int position) {
        return (Step) fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
