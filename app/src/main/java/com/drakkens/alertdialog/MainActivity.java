package com.drakkens.alertdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    private GestureDetectorCompat gestureDetectorCompat;
    private GestureDetectorCompat gestureDetector;


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Single Tap!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Double Tap!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Event on Double Tap!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Pressed!", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Still Pressing", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Released", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(getApplicationContext(), "Scrolling", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "Long Press!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(getApplicationContext(), "Fling", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);


    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            AlertDialog aD = new AlertDialog.Builder(this).setTitle("Hello!").setMessage("I'm a Dialog!").create();
            aD.show();

        });


        gestureDetectorCompat = new GestureDetectorCompat(getApplicationContext(), this);
        gestureDetectorCompat.setOnDoubleTapListener(this);

        gestureDetector = new GestureDetectorCompat(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
            private final String TAG = "Gesture Detector";
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Toast.makeText(getApplicationContext(), "Fling (Gesture Detector)", Toast.LENGTH_SHORT).show();
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public boolean onDown(MotionEvent e) {
                Toast.makeText(getApplicationContext(), "Down (Gesture Detector)", Toast.LENGTH_SHORT).show();
                return super.onDown(e);
            }
        });

    }
}

