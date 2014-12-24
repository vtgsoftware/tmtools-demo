package io.tmtools.demo.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import io.tmtools.demo.R;
import io.tmtools.services.mls.activities.MLSActivity;

public class MLSDemoActivity extends MLSActivity {

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.image_action_bar_mls_back:
                onBackPressed();
                break;
                case R.id.image_action_bar_mls_menu:
                    openOptionsMenu();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mls);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mls, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_menu_activity_mls_first:
                break;
            case R.id.item_menu_activity_mls_second:
                break;
            case R.id.item_menu_activity_mls_third:
                break;
        }
        return true;
    }

    private void init(){
        findViewById(R.id.image_action_bar_mls_back).setOnClickListener(mOnClickListener);
        findViewById(R.id.image_action_bar_mls_menu).setOnClickListener(mOnClickListener);
    }
}
