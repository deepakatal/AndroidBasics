package basics.com.dee.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import basics.com.dee.main.R;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        buttonNext = (Button) findViewById(R.id.nextButtonFirstActivity);
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.nextButtonFirstActivity) {
            intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        }

    }
}
