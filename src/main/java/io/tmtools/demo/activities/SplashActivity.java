package io.tmtools.demo.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import io.tmtools.activitites.TMTHomeActivity;
import io.tmtools.demo.R;

public class SplashActivity extends TMTHomeActivity {

    private Dialog mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initLoading();
        showLoading();
    }

    private void initLoading() {
        mProgressBar = new Dialog(this, android.R.style.Theme_Translucent);
        mProgressBar.setCancelable(false);
        View view = getLayoutInflater().inflate(R.layout.dialog_progress, null);
        mProgressBar.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mProgressBar.setTitle(null);
        mProgressBar.setCancelable(false);
        mProgressBar.setContentView(view);
    }

    private void showLoading() {
        if (!mProgressBar.isShowing() && !isFinishing()) {
            mProgressBar.show();
        }
    }

    private void hideLoading() {
        if (mProgressBar.isShowing() && !isFinishing()) {
            mProgressBar.dismiss();
        }
    }

    @Override
    protected void onTMTWorkCompleted() {
        hideLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1000);
    }
}
