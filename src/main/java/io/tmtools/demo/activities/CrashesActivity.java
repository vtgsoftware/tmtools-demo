package io.tmtools.demo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import io.tmtools.demo.R;

public class CrashesActivity extends Activity {

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.image_action_bar_crashes_back:
                    onBackPressed();
                    break;
                case R.id.label_activity_crashes_tools_first:
                    Log.d(TAG, mNullObject.toString());
                case R.id.label_activity_crashes_tools_second:
                    generateOOM();
                case R.id.label_activity_crashes_tools_third:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            View res = findViewById(R.id.action_activity_main_mls);
                            res.invalidate();
                        }
                    }).start();
            }
        }
    };

    private Object mNullObject = null;

    private static final String TAG = CrashesActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crashes);

        init();
    }

    private void init(){
        findViewById(R.id.image_action_bar_crashes_back).setOnClickListener(mOnClickListener);
        findViewById(R.id.label_activity_crashes_tools_first).setOnClickListener(mOnClickListener);
        findViewById(R.id.label_activity_crashes_tools_second).setOnClickListener(mOnClickListener);
        findViewById(R.id.label_activity_crashes_tools_third).setOnClickListener(mOnClickListener);
    }

    private void generateOOM() {
        throw new IllegalArgumentException();
    }
}
