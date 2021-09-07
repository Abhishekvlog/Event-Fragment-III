package com.example.event_fragment_iii;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PriceDetailsFragment extends Fragment {
    private EditText mETCurrency;
    private EditText mETPrice;
    private Button mBtnPreview;
    private CommunicationListener listener;
    private String Title;
    private String Description;
    private String StartDate;
    private String EndDate;
    private String StartTime;
    private String EndTime;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            Title = getArguments().getString("Title");
            Description = getArguments().getString("Describe");
            StartDate = getArguments().getString("startDate");
            StartTime = getArguments().getString("startTime");
            EndDate = getArguments().getString("endDate");
            EndTime = getArguments().getString("endTime");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mETCurrency = view.findViewById(R.id.EtCurrency);
        mETPrice = view.findViewById(R.id.Etprice);
        mBtnPreview = view.findViewById(R.id.BtnPriceDetail);

        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String price = mETPrice.getText().toString();
                Model model = new Model(Title,Description,StartDate,EndDate,StartTime,EndTime,price);
                Intent intent = new Intent(getActivity(),PreviewActivity.class);
                intent.putExtra("Model", model);
                startActivity(intent);

            }
        });
    }
}