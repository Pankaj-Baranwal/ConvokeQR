package com.example.pankaj.convokeqr.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pankaj.convokeqr.R;
import com.example.pankaj.convokeqr.fragment.QRScanner;

import github.nisrulz.qreader.QRDataListener;
import github.nisrulz.qreader.QREader;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {
    Button checkin, _150, _300;
    LinearLayout qr_fragment_wrapper;
    QRScanner qrScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        checkin = findViewById(R.id.checkin);
        _150 = findViewById(R.id._150);
        _300 = findViewById(R.id._300);
        qrScanner = (QRScanner) getFragmentManager().findFragmentById(R.id.qr_scanner_fragment);
        qr_fragment_wrapper = findViewById(R.id.qr_fragment_wrapper);
        checkin.setOnClickListener(this);
        _150.setOnClickListener(this);
        _300.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        qr_fragment_wrapper.setVisibility(View.VISIBLE);
        switch (view.getId()){
            case R.id.checkin:

                break;
            case R.id._150:

                break;
            case R.id._300:

                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
