package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface amaticFont = Typeface.createFromAsset(getAssets(), "fonts/Amatic.ttf");
        mAppNameTextView.setTypeface(amaticFont);

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindRestaurantsButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}