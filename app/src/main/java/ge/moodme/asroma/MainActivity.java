package ge.moodme.asroma;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Main Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "on run");
                Intent goToLogin = new Intent(getApplicationContext(), ge.moodme.asroma.Menu.class);
                startActivity(goToLogin);
                Log.i(TAG, "menu switch sucessful");
                finish();
                Log.i(TAG, "ok!");
            }
        }, 2000);
    }

   /* @Override
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

        //noinsp   ection SimplifiableIfStatement
        if (id == Android.) {
          //  return true;
        //}

        return super.onOptionsItemSelected(item);
    }*/
}
