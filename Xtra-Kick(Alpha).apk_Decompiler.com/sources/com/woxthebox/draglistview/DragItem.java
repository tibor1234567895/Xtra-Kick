package com.woxthebox.draglistview;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

public class DragItem {
    protected static final int ANIMATION_DURATION = 250;
    private float mAnimationDx;
    private float mAnimationDy;
    private boolean mCanDragHorizontally = true;
    private boolean mCanDragVertically = true;
    private View mDragView;
    private float mOffsetX;
    private float mOffsetY;
    private float mPosTouchDx;
    private float mPosTouchDy;
    private float mPosX;
    private float mPosY;
    private View mRealDragView;
    private float mRealStartX;
    private float mRealStartY;
    private boolean mSnapToTouch = true;

    public DragItem(Context context) {
        this.mDragView = new View(context);
        hide();
    }

    private void show() {
        this.mDragView.setVisibility(0);
    }

    private void updatePosition() {
        if (this.mCanDragHorizontally) {
            View view = this.mDragView;
            view.setX(((this.mPosX + this.mOffsetX) + this.mAnimationDx) - (((float) view.getMeasuredWidth()) / 2.0f));
        }
        if (this.mCanDragVertically) {
            View view2 = this.mDragView;
            view2.setY(((this.mPosY + this.mOffsetY) + this.mAnimationDy) - (((float) view2.getMeasuredHeight()) / 2.0f));
        }
        this.mDragView.invalidate();
    }

    public boolean canDragHorizontally() {
        return this.mCanDragHorizontally;
    }

    public boolean canDragVertically() {
        return this.mCanDragVertically;
    }

    public void endDrag(View view, AnimatorListenerAdapter animatorListenerAdapter) {
        onEndDragAnimation(this.mDragView);
        float measuredWidth = (((float) this.mDragView.getMeasuredWidth()) / 2.0f) + (view.getX() - (((float) (this.mDragView.getMeasuredWidth() - view.getMeasuredWidth())) / 2.0f));
        float y10 = view.getY() - (((float) (this.mDragView.getMeasuredHeight() - view.getMeasuredHeight())) / 2.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("X", new float[]{this.mPosX, measuredWidth}), PropertyValuesHolder.ofFloat("Y", new float[]{this.mPosY, (((float) this.mDragView.getMeasuredHeight()) / 2.0f) + y10})});
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder.setDuration(250);
        ofPropertyValuesHolder.addListener(animatorListenerAdapter);
        ofPropertyValuesHolder.start();
    }

    public View getDragItemView() {
        return this.mDragView;
    }

    public View getRealDragView() {
        return this.mRealDragView;
    }

    public float getX() {
        return this.mPosX;
    }

    public float getY() {
        return this.mPosY;
    }

    public void hide() {
        this.mDragView.setVisibility(8);
        this.mRealDragView = null;
    }

    public boolean isDragging() {
        return this.mDragView.getVisibility() == 0;
    }

    public boolean isSnapToTouch() {
        return this.mSnapToTouch;
    }

    public void onBindDragView(View view, View view2) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        view2.setBackground(new BitmapDrawable(view.getResources(), createBitmap));
    }

    public void onEndDragAnimation(View view) {
    }

    public void onMeasureDragView(View view, View view2) {
        view2.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
        view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
    }

    public void onStartDragAnimation(View view) {
    }

    public void setAnimationDY(float f10) {
        this.mAnimationDy = f10;
        updatePosition();
    }

    public void setAnimationDx(float f10) {
        this.mAnimationDx = f10;
        updatePosition();
    }

    public void setCanDragHorizontally(boolean z10) {
        this.mCanDragHorizontally = z10;
    }

    public void setCanDragVertically(boolean z10) {
        this.mCanDragVertically = z10;
    }

    public void setOffset(float f10, float f11) {
        this.mOffsetX = f10;
        this.mOffsetY = f11;
        updatePosition();
    }

    public void setPosition(float f10, float f11) {
        if (this.mCanDragHorizontally) {
            this.mPosX = f10 + this.mPosTouchDx;
        } else {
            float f12 = this.mRealStartX;
            this.mPosX = f12;
            View view = this.mDragView;
            view.setX(f12 - (((float) view.getMeasuredWidth()) / 2.0f));
        }
        if (this.mCanDragVertically) {
            this.mPosY = f11 + this.mPosTouchDy;
        } else {
            float f13 = this.mRealStartY;
            this.mPosY = f13;
            View view2 = this.mDragView;
            view2.setY(f13 - (((float) view2.getMeasuredHeight()) / 2.0f));
        }
        updatePosition();
    }

    public void setSnapToTouch(boolean z10) {
        this.mSnapToTouch = z10;
    }

    public void setX(float f10) {
        this.mPosX = f10;
        updatePosition();
    }

    public void setY(float f10) {
        this.mPosY = f10;
        updatePosition();
    }

    public void startDrag(View view, float f10, float f11) {
        show();
        this.mRealDragView = view;
        onBindDragView(view, this.mDragView);
        onMeasureDragView(view, this.mDragView);
        onStartDragAnimation(this.mDragView);
        this.mRealStartX = (((float) this.mDragView.getMeasuredWidth()) / 2.0f) + (view.getX() - (((float) (this.mDragView.getMeasuredWidth() - view.getMeasuredWidth())) / 2.0f));
        float measuredHeight = (((float) this.mDragView.getMeasuredHeight()) / 2.0f) + (view.getY() - (((float) (this.mDragView.getMeasuredHeight() - view.getMeasuredHeight())) / 2.0f));
        this.mRealStartY = measuredHeight;
        if (this.mSnapToTouch) {
            this.mPosTouchDx = 0.0f;
            this.mPosTouchDy = 0.0f;
            setPosition(f10, f11);
            setAnimationDx(this.mRealStartX - f10);
            setAnimationDY(this.mRealStartY - f11);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("AnimationDx", new float[]{this.mAnimationDx, 0.0f}), PropertyValuesHolder.ofFloat("AnimationDY", new float[]{this.mAnimationDy, 0.0f})});
            ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
            ofPropertyValuesHolder.setDuration(250);
            ofPropertyValuesHolder.start();
            return;
        }
        this.mPosTouchDx = this.mRealStartX - f10;
        this.mPosTouchDy = measuredHeight - f11;
        setPosition(f10, f11);
    }

    public DragItem(Context context, int i10) {
        this.mDragView = View.inflate(context, i10, (ViewGroup) null);
        hide();
    }
}
