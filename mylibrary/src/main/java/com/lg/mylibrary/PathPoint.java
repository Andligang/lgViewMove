package com.lg.mylibrary;

public class PathPoint {
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CUBIC = 2;

    protected int mOperation;

    public float mX, mY;
    float mControl0X, mControl1X;
    float mControl0Y, mControl1Y;

    public PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    public PathPoint(int operation, float c0x, float c0y, float c1x, float c1y, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
        mControl0X = c0x;
        mControl0Y = c0y;
        mControl1X = c1x;
        mControl1Y = c1y;
    }

    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }

    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    public static PathPoint cubicTo(float c0x, float c0y, float c1x, float c1y, float x, float y) {
        return new PathPoint(CUBIC, c0x, c0y, c1x, c1y, x, y);
    }
}
