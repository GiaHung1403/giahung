package com.example.appdrive;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    Button btnStart;
    Switch a ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottom_nav_menu=findViewById(R.id.nav_bottom);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        btnStart=(Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rd =new Random();
                int i=rd.nextInt((5-1+1)+1);
                switch(i){
                    case 1:
                        btnStart.setBackgroundColor(999999);
                    case 2:
                        btnStart.setBackgroundColor(9999);
                }

            }
        });

        a = findViewById(R.id.swithMode);
        a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Intent intent = new Intent(MainActivity.this,NhanCuocXe_Activity.class);
                    startActivity(intent);
                }
                else
                {
                    showDialogDelete();
                }
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_LichSu, R.id.nav_ViTaiXe, R.id.nav_KiemTra,
                R.id.nav_CaiDat, R.id.nav_HoTro,R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottom_nav_menu , navController);
//         Xử lý sự kiện khi tà̀i xế nhấn nút nhận đơn hàng
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentNhanDonHang fragment_nhan_Don_Hang= new fragmentNhanDonHang();
//        fragmentTransaction.add(R.id.nav_host_fragment,fragment_nhan_Don_Hang);
//        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void showDialogDelete() {

        final android.app.AlertDialog.Builder diaDelete = new android.app.AlertDialog.Builder(MainActivity.this);
        diaDelete.setTitle("Warning!!");
        diaDelete.setMessage("Bạn có chắc muốn ngừng nhận khách!!!");
        diaDelete.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                try
                {
                    Toast.makeText(MainActivity.this , "Đã ngừng nhận khách",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {

                }
            }
        });
        diaDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        diaDelete.show();
    }
}
