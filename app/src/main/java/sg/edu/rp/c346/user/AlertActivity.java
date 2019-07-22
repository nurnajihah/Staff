package sg.edu.rp.c346.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class AlertActivity extends AppCompatActivity {

    ListView lvAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        lvAlert = findViewById(R.id.lvAlert);

        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.task:
                        menuItem.setChecked(true);
                        Intent intent1 = new Intent (AlertActivity.this, IncompleteTaskActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.alert:
                        break;

                    case R.id.profile:
                        menuItem.setChecked(true);
                        Intent intent2 = new Intent(AlertActivity.this, ProfileActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }
}
