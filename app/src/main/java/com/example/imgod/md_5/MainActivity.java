package com.example.imgod.md_5;

import android.animation.Animator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardview_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        cardview_1.setOnClickListener(this);
    }

    private void initView() {
        cardview_1 = (CardView) findViewById(R.id.cardview_1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardview_1:
                startAnimation(cardview_1);
                break;
        }
    }

    private void startAnimation(View view) {
        //因为CircularReveal动画是api21之后才有的,所以加个判断语句,免得崩溃
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cicular_R = view.getHeight() / 2 > view.getWidth() / 2 ? view.getHeight() / 2 : view.getWidth() / 2;
            Animator animator = ViewAnimationUtils.createCircularReveal(view, (int) view.getWidth() / 2, (int) view.getHeight() / 2, 0, cicular_R);
            animator.setDuration(1000);
            animator.start();
        } else {
            Toast.makeText(this, "SDK版本太低,请升级", Toast.LENGTH_SHORT).show();
        }

    }

}
