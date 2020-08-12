package app.com.kietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bottomNavigationView;
        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        final FloatingActionButton dashboardBtn = findViewById(R.id.dashboardFAB);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dashboardBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00b4d8")));

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new DashboardFragment())
                        .commit();
                Toast.makeText(getApplicationContext(),"Dashboard", Toast.LENGTH_SHORT).show();

                int size = bottomNavigationView.getMenu().size();
                for (int i = 0; i < size; i++) {
                    bottomNavigationView.getMenu().getItem(i).setChecked(false);
                }

            }
        });

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
            bottomNavigationView.setSelectedItemId(R.id.home_menu);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        final FloatingActionButton dashboardBtn = findViewById(R.id.dashboardFAB);
        dashboardBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#dee2e6")));


        int id = item.getItemId();

        switch (id){

            case R.id.profile_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new ProfileFragment())
                        .commit();
                Toast.makeText(this,"profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.home_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new HomeFragment())
                        .commit();
                Toast.makeText(this,"home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.notification_menu:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,new NotificationFragment())
                        .commit();
                Toast.makeText(this,"notification", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }






//    @Override
//    public void onBackPressed() {
//        if(navDrwLayout.isDrawerOpen(GravityCompat.START)){
//            navDrwLayout.closeDrawer(GravityCompat.START);
//        }
//        else {
//            super.onBackPressed();
//        }
//    }
}