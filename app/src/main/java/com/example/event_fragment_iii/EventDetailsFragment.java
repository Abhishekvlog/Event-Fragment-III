package com.example.event_fragment_iii;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventDetailsFragment extends Fragment {
    private EditText mEtTitle;
    private EditText mEtDescribe;
    private Button mBTnNext;
    private CommunicationListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    private void initView(View view) {
        mEtTitle = view.findViewById(R.id.EtEvent);
        mEtDescribe = view.findViewById(R.id.EtDecription);
        mBTnNext = view.findViewById(R.id.BtnNext);
        mBTnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = mEtTitle.getText().toString();
                String Description = mEtDescribe.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Title",Title);
                bundle.putString("Describe",Description);
                if (listener != null){
                    listener.launchTimeAndDateFragment(bundle);
                }
            }
        });
    }
}