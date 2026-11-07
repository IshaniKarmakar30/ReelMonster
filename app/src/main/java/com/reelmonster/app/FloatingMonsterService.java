package com.reelmonster.app;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class FloatingMonsterService extends Service {
    private WindowManager windowManager;
    private View floatingView;
    private int reelCount = 0;
    private SharedPreferences prefs;

    private final String[] dialogues = {
            "Yum! Another reel eaten!",
            "Burp. Your study says hi..",
            "15 mins gone already?",
            "Still scrolling? Put me down!",
            "I'm getting too fat! 🍔"
    };

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = getSharedPreferences("ReelData", MODE_PRIVATE);
        reelCount = prefs.getInt("today_count", 0);

        floatingView = LayoutInflater.from(this).inflate(R.layout.layout_floating_monster, null);

        int layoutType = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :
                WindowManager.LayoutParams.TYPE_PHONE;

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layoutType,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT
        );

        params.gravity = Gravity.TOP | Gravity.START;
        params.x = 50;
        params.y = 200;

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(floatingView, params);

        TextView countText = floatingView.findViewById(R.id.count_badge);
        TextView speechText = floatingView.findViewById(R.id.speech_bubble);
        View avatar = floatingView.findViewById(R.id.monster_avatar);

        countText.setText(String.valueOf(reelCount));

        floatingView.setOnTouchListener(new View.OnTouchListener() {
            private int initialX, initialY;
            private float initialTouchX, initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);
                        windowManager.updateViewLayout(floatingView, params);
                        return true;

                    case MotionEvent.ACTION_UP:
                        if (Math.abs(event.getRawX() - initialTouchX) < 10 && Math.abs(event.getRawY() - initialTouchY) < 10) {
                            reelCount++;
                            countText.setText(String.valueOf(reelCount));
                            prefs.edit().putInt("today_count", reelCount).apply();

                            speechText.setVisibility(View.VISIBLE);
                            speechText.setText(dialogues[reelCount % dialogues.length]);

                            float scale = Math.min(1.0f + (reelCount * 0.03f), 1.6f);
                            avatar.setScaleX(scale);
                            avatar.setScaleY(scale);
                        }
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (floatingView != null) windowManager.removeView(floatingView);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
