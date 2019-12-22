package com.example.appdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NhanCuocXe_Activity extends AppCompatActivity {
    Button btn_Nhan_Cuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_cuoc_xe_);
        btn_Nhan_Cuoc=(Button)findViewById(R.id.btnNhan_Cuoc);
        btn_Nhan_Cuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NhanCuocXe_Activity.this,DonKhach_Activity.class);
                NhanCuocXe_Activity.this.startActivity(intent);
            }
        });
    }
}
