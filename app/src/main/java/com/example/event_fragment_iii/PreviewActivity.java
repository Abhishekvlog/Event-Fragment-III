package com.example.event_fragment_iii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PreviewActivity extends AppCompatActivity {
    private TextView TvTitle;
    private TextView TvDescription;
    private TextView TvStartDate;
    private TextView TvStartTime;
    private TextView TvEndDate;
    private TextView TvEndTime;
    private TextView TvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initView();
        getDataFromIntent();
    }

    private void getDataFromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("Model");
        TvTitle.setText(model.getTitle());
        TvDescription.setText(model.getDescription());
        TvStartDate.setText(model.getStartDate());
        TvStartTime.setText(model.getStartTime());
        TvEndDate.setText(model.getEndDate());
        TvEndTime.setText(model.getEndTime());
        TvPrice.setText(model.getPrice());
    }

    private void initView() {
        TvTitle = findViewById(R.id.TvEventTitle);
        TvDescription = findViewById(R.id.TvEvenDesc);
        TvStartDate= findViewById(R.id.TvEventstartdate);
        TvStartTime = findViewById(R.id.TvEventstarttime);
        TvEndDate = findViewById(R.id.TvEventenddate);
        TvEndTime = findViewById(R.id.TvEventendtime);
        TvPrice = findViewById(R.id.TvPrice);
    }
}