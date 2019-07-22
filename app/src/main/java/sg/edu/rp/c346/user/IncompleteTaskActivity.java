package sg.edu.rp.c346.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class IncompleteTaskActivity extends AppCompatActivity {

    Switch aSwitch;
    private ListView lvTasks;
    ArrayList<Task> alTask = new ArrayList<>();
    ArrayAdapter<Task> aaTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incomplete_task);

        aSwitch = findViewById(R.id.switchTask);
        lvTasks = findViewById(R.id.lvTasks);
        aaTask = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, alTask);
        lvTasks.setAdapter(aaTask);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/smacbiz/getTask.php", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject task = response.getJSONObject(i);
                        Task t = new Task(task.getInt("task_id"), task.getString("name"));
                        alTask.add(t);
                    }
                } catch (JSONException e) {
                    aaTask.notifyDataSetChanged();

                }
            }
        });

        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Task t = alTask.get(position);
                Intent intent = new Intent(getApplicationContext(), ViewIncompleteTaskActivity.class);
                intent.putExtra("task", t);
                startActivity(intent);
            }
        });

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
                        Intent intent1 = new Intent(IncompleteTaskActivity.this, AlertActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.profile:
                        bottomNav.setItemBackgroundResource(R.color.colorPrimary);
                        menuItem.setChecked(true);
                        Intent intent2 = new Intent(IncompleteTaskActivity.this, ProfileActivity.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CompletedTaskActivity.class);
                startActivity(i);
            }
        });
    }
}
