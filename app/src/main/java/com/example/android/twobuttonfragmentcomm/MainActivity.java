package com.example.android.twobuttonfragmentcomm;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstCommsCallback, SecondFragment.SecondCommsCallback {

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.firstFrame, firstFragment);
        ft.add(R.id.secondFrame, secondFragment);
        ft.commit();
    }


    @Override
    public void sayMessageOne(String message) {
        secondFragment.setText(message);
    }

    @Override
    public void sayMessageTwo(String message) {
        firstFragment.setText(message);
    }

}
