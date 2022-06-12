package ca.t10.blinddev.it.smartblindaddon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);
        Button applyBtn = (Button) findViewById(R.id.apply_settings_button);
    applyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }
    public void startMainActivity()
    {
        Intent intent = new Intent (SettingsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}