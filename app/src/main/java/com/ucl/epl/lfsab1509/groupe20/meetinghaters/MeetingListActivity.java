package com.ucl.epl.lfsab1509.groupe20.meetinghaters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.ArrayList;


public class MeetingListActivity extends AppCompatActivity {

    MeetingApp appInstance = MeetingApp.getAppInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        recyclerView.setAdapter(new RecyclerAdapter(generateMeetingList()));

    }

    private ArrayList<MeetingItem> generateMeetingList(){

        ArrayList<MeetingItem> meetings = new ArrayList<>();
        //We generate the list of meeting in this place
        JsonRequestHelper request = new JsonRequestHelper(
                Request.Method.GET,
                appInstance.remoteDBHandler.apiMeetingURL(),
                null, //GET REQUEST so no JSONObject to pass
                appInstance.myDBHandler.getToken(),
                appInstance.myDBHandler.getUser(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //TODO
                    }
                }
        );
        /*meetings.add(new MeetingItem("P4", "A short meeting", "Start at 12h20", "End at 12h30", "Reaumur"));
        meetings.add(new MeetingItem("P4 Assistant", "Another short meeting", "Start at 14h20", "End at 14h35", "Paul Otlet"));*/
        return meetings;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
