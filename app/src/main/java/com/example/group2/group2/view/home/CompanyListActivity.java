package com.example.group2.group2.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.example.group2.group2.BuildConfig;
import com.example.group2.group2.R;
import com.example.group2.group2.model.CompanyModel;
import com.example.group2.group2.utils.Util;

import java.util.ArrayList;

public class CompanyListActivity extends AppCompatActivity implements CompanyListRecyclerViewAdapter.OnCompanyListClickListeners {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        if (BuildConfig.DEBUG) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<CompanyModel> companyModels = Util.getCompanyList();
        recyclerView.setAdapter(new CompanyListRecyclerViewAdapter(companyModels, this));
    }


    @Override
    public void onItemClick(CompanyModel companyModel) {
        Intent intent = new Intent();
        intent.putExtra("CompanyModel", companyModel);
        setResult(RESULT_OK, intent);
        finish();
    }
}
