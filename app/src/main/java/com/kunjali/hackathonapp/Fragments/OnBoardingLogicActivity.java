package com.kunjali.hackathonapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import me.relex.circleindicator.CircleIndicator3;

public class OnBoardingLogicActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TextView txtSkip, txtNext;
    private OnboardingAdapter adapter;
    private CircleIndicator3 indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_logic);

        viewPager = findViewById(R.id.viewPager);
        txtSkip = findViewById(R.id.txtSkip);
        txtNext = findViewById(R.id.txtNext);
        indicator = findViewById(R.id.indicator);

        adapter = new OnboardingAdapter(this);

        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

        txtSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingLogicActivity.this, LoginActivity.class));
                finish();
            }
        });

        txtNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() < adapter.getItemCount() - 1) {

                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);

                } else {

                    startActivity(new Intent(OnBoardingLogicActivity.this, LoginActivity.class));
                    finish();

                }
            }
        });

        viewPager.registerOnPageChangeCallback(
                new ViewPager2.OnPageChangeCallback() {

                    @Override
                    public void onPageSelected(int position) {
                        super.onPageSelected(position);

                        if (position == adapter.getItemCount() - 1) {
                            txtNext.setText("Get Started");
                        } else {
                            txtNext.setText("Next");
                        }
                    }
                }
        );
    }
}