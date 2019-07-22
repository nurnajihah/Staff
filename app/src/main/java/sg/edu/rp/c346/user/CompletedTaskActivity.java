package sg.edu.rp.c346.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

public class CompletedTaskActivity extends AppCompatActivity {

    Switch aSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_task);

        aSwitch = findViewById(R.id.switchTask);

        final BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.task:
                        break;

                    case R.id.alert:
                        bottomNav.setItemBackgroundResource(R.color.colorPrimary);
                        menuItem.setChecked(true);
                        Intent intent1 = new Intent (getApplicationContext(),AlertActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.profile:
                        bottomNav.setItemBackgroundResource(R.color.colorPrimary);
                        menuItem.setChecked(true);
                        Intent intent2 = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IncompleteTaskActivity.class);
                startActivity(i);
            }
        });
    }
}
