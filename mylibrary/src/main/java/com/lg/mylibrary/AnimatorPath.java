package com.lg.mylibrary;

import android.animation.ObjectAnimator;
import android.view.View;

import java.util.ArrayList;

public class AnimatorPath {

    ArrayList<PathPoint> points = new ArrayList<>();
    private View mView;

    public void moveTo(float x, float y) {
        points.add(PathPoint.moveTo(x, y));
    }

    public void lineTo(float x, float y) {
        points.add(PathPoint.lineTo(x, y));
    }

    public void cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        points.add(PathPoint.cubicTo(c0x, c0y, c1x, c1y, x, y));
    }

    public void startAnimation(View v, int i) {
        mView = v;
        ObjectAnimator animator = ObjectAnimator.ofObject(this, "haha", new PathEvaluator(), points.toArray());
        animator.setDuration(i);
        animator.start();
    }

    public void setHaha(PathPoint point) {
        mView.setTranslationX(point.mX);
        mView.setTranslationY(point.mY);
    }
}
