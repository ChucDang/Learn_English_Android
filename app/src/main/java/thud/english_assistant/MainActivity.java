package thud.english_assistant;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import thud.english_assistant.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        1. Gọi inflate() sẽ tạo ra một lớp binding và đồng thời một instance của
//        lớp này sẽ được sử dụng
//        2. getRoot() lấy một tham chiếu tới view gốc. ở đây là activity_main
//        3. setContentView() sẽ kích hoạt view lên màn hình.
        setSupportActionBar(binding.appBarMain.toolbar);
//        Bắt sự kiện Click vào icon dấu cộng góc phải dưới của màn hình
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }

        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        //AppBarConfiguration.Builde Truyền vào toàn bộ item trong menu như là một tập các ID,
        // xác định như là một tập các trang cấp cao nhất.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
    // Ghi đè để chỉ định một menu tùy chỉnh để thổi phồng các tài nguyên trong menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}