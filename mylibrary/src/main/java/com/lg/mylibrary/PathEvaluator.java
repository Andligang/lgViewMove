package com.lg.mylibrary;

import android.animation.TypeEvaluator;

public class PathEvaluator implements TypeEvaluator<PathPoint> {
    @Override
    public PathPoint evaluate(float t, PathPoint startValue, PathPoint endValue) {
        float x, y;
        if (endValue.mOperation == PathPoint.CUBIC) {
            float oneMinusT = 1 - t;
            x = oneMinusT * oneMinusT * oneMinusT * startValue.mX +
                    3 * oneMinusT * oneMinusT * t * endValue.mControl0X +
                    3 * oneMinusT * t * t * endValue.mControl1X +
                    t * t * t * endValue.mX;
            y = oneMinusT * oneMinusT * oneMinusT * startValue.mY +
                    3 * oneMinusT * oneMinusT * t * endValue.mControl0Y +
                    3 * oneMinusT * t * t * endValue.mControl1Y +
                    t * t * t * endValue.mY;
        } else if (endValue.mOperation == PathPoint.LINE) {
            x = startValue.mX + t * (endValue.mX - startValue.mX);
            y = startValue.mY + t * (endValue.mY - startValue.mY);
        } else {
            x = endValue.mX;
            y = endValue.mY;
        }
        return PathPoint.moveTo(x, y);
    }
}
