package com.example.sai.majorproject.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sai.majorproject.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrganizationStepThreeFragment extends Fragment implements Step{
    CircleImageView img_org_logo;
    Button btn_submit;
    TextView txt_org_name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.org_stepthree_form,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img_org_logo=(CircleImageView)view.findViewById(R.id.img_org_logo);
        btn_submit=(Button)view.findViewById(R.id.btn_submit);
        txt_org_name=(TextView)view.findViewById(R.id.txt_org_name);
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
}
