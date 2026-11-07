package com.reelmonster.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final int OVERLAY_PERMISSION_REQ_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = findViewById(R.id.btn_start);
        TextView statText = findViewById(R.id.txt_stats);

        int count = getSharedPreferences("ReelData", MODE_PRIVATE).getInt("today_count", 0);
        statText.setText("Today: " + count + " reels (" + count + " mins lost)");

        startBtn.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            } else {
                startService(new Intent(MainActivity.this, FloatingMonsterService.class));
                Toast.makeText(this, "Monster Activated! Open Insta or YouTube", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}