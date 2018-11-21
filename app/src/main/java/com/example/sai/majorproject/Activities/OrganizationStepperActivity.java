package com.example.sai.majorproject.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.sai.majorproject.Adapter.OrganizationStepperAdapter;
import com.example.sai.majorproject.Fragments.OrganizationStepOneFragment;
import com.example.sai.majorproject.Fragments.OrganizationStepThreeFragment;
import com.example.sai.majorproject.Fragments.OrganizationStepTwoFragment;
import com.example.sai.majorproject.R;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.List;

public class OrganizationStepperActivity extends AppCompatActivity implements StepperLayout.StepperListener {
    StepperLayout stepperLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.org_stepper_layout);

        stepperLayout=(StepperLayout)findViewById(R.id.org_stepper);
        final List<Fragment> listFrag=new ArrayList<>();

        listFrag.add(new OrganizationStepOneFragment());
        listFrag.add(new OrganizationStepTwoFragment());
        listFrag.add(new OrganizationStepThreeFragment());

        stepperLayout.setAdapter(new OrganizationStepperAdapter
                (getSupportFragmentManager(),this,listFrag));
        stepperLayout.setListener(this);

    }

    @Override
    public void onCompleted(View completeButton) {

    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {

    }
}
