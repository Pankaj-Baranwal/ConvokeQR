package com.example.pankaj.convokeqr.activity;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pankaj.convokeqr.R;
import com.example.pankaj.convokeqr.fragment.Options;
import com.example.pankaj.convokeqr.fragment.QRScanner;

public class OptionsActivity extends AppCompatActivity implements Options.OnOptionFragmentInteractionListener, QRScanner.OnQRFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_wrapper, new Options());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onOptionFragmentInteraction(String string) {
        callQRFragment(string);
    }

    void callQRFragment(String param){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_wrapper, QRScanner.newInstance(param)).commit();
    }

    @Override
    public void onQRFragmentInteraction(String string) {
        
    }
}
