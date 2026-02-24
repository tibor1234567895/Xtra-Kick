package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TouchObserverFrameLayout extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public View.OnTouchListener f3833h;

    public TouchObserverFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f3833h;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f3833h = onTouchListener;
    }
}
