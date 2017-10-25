package com.example.pankaj.convokeqr.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.pankaj.convokeqr.R;
import com.example.pankaj.convokeqr.application.VolleyHandling;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.pankaj.convokeqr.util.Constants.BASE_URL;

public class SignInActivity extends AppCompatActivity {
    EditText username, userid;
    Button submit;
    String submit_url = BASE_URL + "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = findViewById(R.id.username);
        userid = findViewById(R.id.userid);
        submit = findViewById(R.id.signin);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().length() == 0)
                    Toast.makeText(SignInActivity.this, "USERNAME is compulsory", Toast.LENGTH_SHORT).show();
                else if (userid.getText().toString().length() == 0)
                    Toast.makeText(SignInActivity.this, "USERID is compulsory", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, OptionsActivity.class);
                    startActivity(intent);
                    finish();
                }
//                    submitData(username.getText().toString(), userid.getText().toString());
            }
        });
    }

    void submitData(final String username, final String user_id){
        StringRequest request = new StringRequest(Request.Method.POST, submit_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.length() > 0){
                    Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this, OptionsActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(SignInActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("username", username);
                params.put("userid", user_id);
                return params;
            }
        };

        VolleyHandling.getInstance().addToRequestQueue(request, "signin");
    }
}

//    StringRequest stringRequest = new StringRequest(
//            Request.Method.GET,
//            url,
//            new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    // Do something with response string
//                    mTextView.setText(response);
//                    requestQueue.stop();
//                }
//            },
//            new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    // Do something when get error
//                    Snackbar.make(mCLayout,"Error.",Snackbar.LENGTH_LONG).show();
//                    requestQueue.stop();
//                }
//            }
//    );