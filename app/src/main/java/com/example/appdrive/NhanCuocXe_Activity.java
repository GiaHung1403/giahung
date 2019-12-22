package com.example.appdrive;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class NhanCuocXe_Activity extends AppCompatActivity  {
    Button btn_Nhan_Cuoc;
    TextView user,userName,shop, shopName,dem ;
    private RequestQueue requestQueue;
    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 71000;
    private int userID;
    private boolean timeRunning ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_cuoc_xe_);
        btn_Nhan_Cuoc=(Button)findViewById(R.id.btnNhan_Cuoc);
        user = findViewById(R.id.txtChi_Tiet_Diem_Don);
        userName = findViewById(R.id.txtTom_Tat_Diem_Don);
        shop = findViewById(R.id.txtChi_Tiet_Diem_Den);
        shopName = findViewById(R.id.txtTom_Tat_Diem_Den);
        dem = findViewById(R.id.dem);
        final Random myRandom = new Random();
        userID =  myRandom.nextInt(3);
        requestQueue  = Volley.newRequestQueue(this);
        jsonParse();
        btn_Nhan_Cuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NhanCuocXe_Activity.this,DonKhach_Activity.class);
                NhanCuocXe_Activity.this.startActivity(intent);
            }
        });


        startTime();


    }

    public  void jsonParse() {
        String url = "https://api.myjson.com/bins/e40x8";
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("shipper");
                    for(int i = 0 ; i < jsonArray.length();i++)
                    {
                        JSONObject shipIF = jsonArray.getJSONObject(i);

                        String shop1 = shipIF.getString("shop address");
                        String shopName1 = shipIF.getString("shop name");
                        String user1 = shipIF.getString("user address");
                        String userName1 = shipIF.getString("user name");

                        user.setText(user1);
                        userName.setText(userName1);
                        shop.setText(shop1);
                        shopName.setText(shopName1);

                        //Log.d(TAG, "onMapReady: map is ready");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

    public void startTime()
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished ;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timeRunning = true;
    }
    public void stopTimer()
    {
        countDownTimer.cancel();
        timeRunning =false;
    }

    public void updateTimer()
    {
        //int a = (int) timeLeftInMilliseconds / 60000;
        int b = (int) timeLeftInMilliseconds % 60000/1000;

        String timeLeftText;
        timeLeftText = "";
        if(b<10) timeLeftText+="0";
        timeLeftText+=b;

        dem.setText(timeLeftText);
        if(b == 0)
            finish();
    }
}
