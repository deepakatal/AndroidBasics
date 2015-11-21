package basics.com.dee.intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import basics.com.dee.main.R;

public class ImplicitIntentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewImplicitIntentActivity;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);


        listViewImplicitIntentActivity = (ListView) findViewById(R.id.listViewImplicitIntentActivity);

        String[] values = new String[]{
                "1) Show all system Alarms",
                "2) Open GitHub repository webpage",
                "3) Call T-Mobile Customer Care",
                "4) Start Timer for 100 seconds",
                "5) Start Camera",
                "6) Open Map of 'NYC'",
                "7) Listen to songs of 'Eminem'",
                "8) Search about 'android' on system apps"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listViewImplicitIntentActivity.setAdapter(adapter);
        listViewImplicitIntentActivity.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                break;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/deepakatal/AndroidBasics"));
                break;
            case 2:
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1-877-296-1018 "));
                break;

            case 3:
                intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Timer Example")
                        .putExtra(AlarmClock.EXTRA_LENGTH, 100);
                break;
            case 4:
                intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?40.7127,74.0059(New York City)"));
                break;
            case 6:

                intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS,
                        MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, "Eminem");
                intent.putExtra(SearchManager.QUERY, "Eminem");
                break;
            case 7:
                intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, "android");
                break;
            default:
                Toast.makeText(getApplicationContext(), "Wrong Position Selected! ", Toast.LENGTH_LONG).show();
                break;
        }

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
