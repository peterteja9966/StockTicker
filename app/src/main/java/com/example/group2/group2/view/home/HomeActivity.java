package com.example.group2.group2.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.example.group2.group2.BuildConfig;
import com.example.group2.group2.R;
import com.example.group2.group2.model.CompanyModel;

public class HomeActivity extends AppCompatActivity {

    private static final int REQUEST_COUNTRY = 100;

    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(BuildConfig.DEBUG){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        FloatingActionButton actionButton = findViewById(R.id.fab);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CompanyListActivity.class);
                startActivityForResult(intent, REQUEST_COUNTRY);
            }
        });

        homeFragment = HomeFragment.newInstance(1);
        addFragment(R.id.flContainer, homeFragment, HomeFragment.class.getCanonicalName());
    }

    protected void addFragment(@IdRes int containerViewId,
                               @NonNull Fragment fragment,
                               @NonNull String fragmentTag) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_COUNTRY && resultCode == RESULT_OK) {
            CompanyModel companyModel = data.getParcelableExtra("CompanyModel");
            if (homeFragment != null) {
                homeFragment.loadStockData(companyModel);
            }
        }
    }
}
