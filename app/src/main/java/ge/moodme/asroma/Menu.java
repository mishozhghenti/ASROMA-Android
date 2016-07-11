package ge.moodme.asroma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.app.Activity;
import android.widget.Toast;
import android.view.View;

public class Menu extends AppCompatActivity {

    private final String TAG = "Menu Message";
    private final String[] categories = {"Team", "Legends", "Management"};
    private  Toolbar menuToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initiateWidgets ();
        Log.i(TAG, "onCreate");
    }

    void initiateWidgets (){
        menuToolBar = (Toolbar) findViewById(R.id.menu_appbar);
        setSupportActionBar(menuToolBar);
        getSupportActionBar().setIcon(R.drawable.ic_action_camera);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        if (curId == R.id.about) {
            goAbout();
        }

        return true;
    }

    private void goAbout() {
        Intent about = new Intent(getApplicationContext(), ge.moodme.asroma.About.class);
        startActivity(about);
    }
}

