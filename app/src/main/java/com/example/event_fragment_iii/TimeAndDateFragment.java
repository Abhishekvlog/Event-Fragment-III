package com.example.event_fragment_iii;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TimeAndDateFragment extends Fragment {
    private String title,description;
    private EditText startDate,endDate,startTime,endTime;
    private Button BtnNextTime;
    private CommunicationListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            title=getArguments().getString("Title");
            description=getArguments().getString("Describe");


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener= (CommunicationListener) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        startDate=view.findViewById(R.id.EtStartDate);
        endDate=view.findViewById(R.id.EtEndDate);
        startTime=view.findViewById(R.id.EtStartTime);
        endTime=view.findViewById(R.id.EtEndTime);
        BtnNextTime=view.findViewById(R.id.BtnPreNext);
        BtnNextTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strtDate=startDate.getText().toString();
                String enddatee=endDate.getText().toString();
                String srttime=startTime.getText().toString();
                String endtimee=endTime.getText().toString();
                title=getArguments().getString("title");
                description=getArguments().getString("Describe");
                Bundle bundle=new Bundle();
                bundle.putString("Title",title);
                bundle.putString("Describe",description);
                bundle.putString("startDate",strtDate);
                bundle.putString("endDate",enddatee);
                bundle.putString("startTime",srttime);
                bundle.putString("endTime",endtimee);

                if (listener!=null){
                    listener.launchPriceDetailFragment(bundle);
                }
            }
        });
    }
}