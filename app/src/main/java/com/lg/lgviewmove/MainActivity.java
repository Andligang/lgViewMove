package com.lg.lgviewmove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.lg.mylibrary.AnimatorPath;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 点我
     */
    private TextView mText;
    private int sScreenWidth, sScreenHeight;
    private int textW, textH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        DisplayMetrics mDisplayMetrics = getResources().getDisplayMetrics();
        sScreenWidth = mDisplayMetrics.widthPixels;
        sScreenHeight = mDisplayMetrics.heightPixels;
    }

    private void initView() {
        mText = (TextView) findViewById(R.id.text);
        mText.setOnClickListener(this);
        int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mText.measure(width, height);
        textW = mText.getMeasuredWidth(); // 获取宽度
        textH = mText.getMeasuredHeight();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:
                AnimatorPath mPath = new AnimatorPath();
                mPath.moveTo(0, 0);
                mPath.lineTo(200, 160);
                mPath.cubicTo(300, 300, 400, 400, 600, 200);
                mPath.lineTo(sScreenWidth - textW, 200);
                mPath.startAnimation(v, 2000);
                break;
        }
    }

}
