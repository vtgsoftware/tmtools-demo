package io.tmtools.demo.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import io.tmtools.demo.R;

public class MainActivity extends Activity {

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.action_activity_main_mls:
                    Intent intentMLS = new Intent(MainActivity.this , MLSDemoActivity.class);
                    startActivity(intentMLS);
                    break;
                case R.id.action_activity_main_crashes:
                    Intent intentCrashes = new Intent(MainActivity.this , CrashesActivity.class);
                    startActivity(intentCrashes);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initActionBar();
    }

    private void init(){
        findViewById(R.id.action_activity_main_mls).setOnClickListener(mOnClickListener);
        findViewById(R.id.action_activity_main_crashes).setOnClickListener(mOnClickListener);
    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();
        if(actionBar != null) {
            ActionBar.LayoutParams layout = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
            View view = getLayoutInflater().inflate(R.layout.action_bar, null, false);
            actionBar.setCustomView(view, layout);
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }
}
