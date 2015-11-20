package basics.com.dee.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import basics.com.dee.main.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonNext = (Button) findViewById(R.id.prevButtonSecondActivity);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prevButtonSecondActivity) {
            intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        }

    }
}
