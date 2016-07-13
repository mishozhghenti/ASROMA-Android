package ge.moodme.asroma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        setupToolbar();
        setupWidgets ();
    }

    void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.about_appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_action_back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void setupWidgets (){
        TextView textView = (TextView) findViewById(R.id.terms_n_conditions);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView1 = (TextView) findViewById(R.id.privacy_policy);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tutorial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
           case R.id.action_tutorial:
                onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
