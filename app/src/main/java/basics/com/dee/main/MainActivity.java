package basics.com.dee.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import basics.com.dee.intent.FirstActivity;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listViewMain;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewMain = (ListView) findViewById(R.id.listViewMain);

        String[] values = new String[]{"1) Simple Activity Intent Example"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listViewMain.setAdapter(adapter);
        listViewMain.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                intent = new Intent(this, FirstActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        "Wrong Position Selected! ", Toast.LENGTH_LONG)
                        .show();
                break;
        }

    }
}
