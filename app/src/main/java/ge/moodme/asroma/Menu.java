package ge.moodme.asroma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;

public class Menu extends AppCompatActivity {

    private final String TAG = "Menu Message";
    private final String[] categories = {"My Moodies","Team", "Legends", "Management"};
    private  Toolbar menuToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initiateWidgets ();
        Log.i(TAG, "onCreate");
    }

    void initiateWidgets (){
        /*widget declaration and init for menu page*/
        menuToolBar = (Toolbar) findViewById(R.id.menu_appbar);
        ListView menuList = (ListView)findViewById(R.id.listViewMenu);
        ListAdapter menuAdapter = new CustomMenuAdapter(this, categories);

        /* Set properties to widget views */
        setSupportActionBar(menuToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.ic_action_camera);

        menuList.setAdapter(menuAdapter);
    }

    public void imageGalleryOpen(View view){

        Intent pictureSelectorIntent = new Intent(Intent.ACTION_PICK);

        File galleryDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String galleryDirectoryPath =  galleryDirectory.getPath();

        Uri data = Uri.parse(galleryDirectoryPath);

        pictureSelectorIntent.setDataAndType(data, "image/*");

       // startActivityForResult(pictureSelectorIntent,IMAGE_GALLERY_REQUEST);
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

    private void callCamera(){
        Intent camera =  new Intent(getApplicationContext(), ge.moodme.asroma.Camera.class);
        startActivity(camera);
    }
}

