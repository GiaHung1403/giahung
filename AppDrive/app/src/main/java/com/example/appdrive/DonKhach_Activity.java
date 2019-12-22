package com.example.appdrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DonKhach_Activity extends AppCompatActivity {
    Button btnXacNhanDonKhach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_khach_);
        btnXacNhanDonKhach=(Button)findViewById(R.id.btnXacNhanDonKhach);
        btnXacNhanDonKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DonKhach_Activity.this,KhachXuongXe_Activity.class);
                DonKhach_Activity.this.startActivity(intent);
            }
        });
    }
}
