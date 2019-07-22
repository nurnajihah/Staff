package sg.edu.rp.c346.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ViewIncompleteTaskActivity extends AppCompatActivity {

    Button btnBack;
    TextView tvTask, tvTaskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_incompletetask);

        btnBack = findViewById(R.id.btnBack);
        tvTask = findViewById(R.id.tvTask);
        tvTaskName = findViewById(R.id.tvTaskName);

        Intent intent = getIntent();
        Task t = (Task) intent.getSerializableExtra("task");
        tvTaskName.setText(t.getName());

        RequestParams params = new RequestParams();
        params.add("id", String.valueOf(t.getId()));

        final AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/smacbiz/getTaskbyID.php", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject task = (JSONObject) response.get(i);
                        String name = task.getString("name");
                        String type = task.getString("type");
                        String user_incharge = task.getString("user_incharge");
                        String percent_of_uic = String.valueOf(task.getLong("percent_of_uic"));
                        String liaison_person = task.getString("liaison_person");
                        String percent_of_lp = String.valueOf(task.getLong("percent_of_lp"));
                        String price = String.valueOf(task.getLong("price"));
                        String complete = String.valueOf(task.getBoolean("complete"));
                        String billed = String.valueOf(task.getBoolean("billed"));
                        String due_date = task.getString("due_date");
                        tvTask.setText("Name: " + name + "\n" + "Type: " + type + "\n" + "User In Charge: " + user_incharge + "\n"
                                + "Percent of UIC: " + percent_of_uic + "\n" + "Liaison Person: " + liaison_person + "\n"
                                + "Percent of LP: " + percent_of_lp + "\n" + "Price: " + price +"\n" + "Client: " + client + "\n"
                                + "Complete: " + complete + "\n" + "Billed: " + billed + "\n" + "Due Date: " + due_date);
                    }

                } catch (JSONException e) {
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), IncompleteTaskActivity.class);
                startActivity(i);
            }
        });
    }
}
