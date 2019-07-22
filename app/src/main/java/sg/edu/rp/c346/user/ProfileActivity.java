package sg.edu.rp.c346.user;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ProfileActivity extends AppCompatActivity {

    Button btnLogout;
    TextView tvStaffName, tvProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        btnLogout = findViewById(R.id.btnLogout);
        tvStaffName = findViewById(R.id.tvStaffName);
        tvProfile = findViewById(R.id.tvProfile);

        Menu menu = bottomNav.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.task:
                        menuItem.setChecked(true);
                        Intent intent1 = new Intent (ProfileActivity.this, IncompleteTaskActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.alert:
                        menuItem.setChecked(true);
                        Intent intent2 = new Intent(ProfileActivity.this, AlertActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.profile:
                        break;
                }
                return false;
            }
        });

        RequestParams params = new RequestParams();
        Staff s = new Staff();
        params.add("id", String.valueOf(s.getId()));

        final AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://smac-biz.000webhostapp.com/SmacBiz/getStaff.php", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject staff = (JSONObject) response.get(i);
                        String name = staff.getString("name");
                        String email = staff.getString("email");
                        String contact = String.valueOf(staff.getInt("contact"));
                        String role_name = staff.getString("role_name");
                        String status = String.valueOf(staff.getBoolean("status"));
                        tvStaffName.setText(name);
                        tvProfile.setText("Email: " + email + "\n" + "Contact Number: " + contact + "\n"
                                            + "Role: " + role_name + "\n" + "Status: " + status);
                    }
                } catch (JSONException e) {
                }
            }
        });
    }
}
