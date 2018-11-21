package com.example.sai.majorproject.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sai.majorproject.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

public class OrganizationStepTwoFragment extends Fragment implements Step, View.OnClickListener {
    EditText edt_org_address,edt_org_info,edt_org_website;
    TextView txt_org_license;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.org_steptwo_form,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edt_org_address=(EditText)view.findViewById(R.id.edt_org_address);
        edt_org_info=(EditText)view.findViewById(R.id.edt_org_info);
        edt_org_website=(EditText)view.findViewById(R.id.edt_org_website);
        txt_org_license=(EditText)view.findViewById(R.id.txt_org_license);

        txt_org_license.setOnClickListener(this);
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==txt_org_license.getId()){

        }
    }
}
