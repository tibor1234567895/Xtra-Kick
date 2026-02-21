package com.woxthebox.draglistview.swipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import com.woxthebox.draglistview.swipe.ListSwipeHelper;

public class ListSwipeItem extends RelativeLayout {
    private float mFlingSpeed;
    private View mLeftView;
    private int mLeftViewId;
    private float mMaxLeftTranslationX = Float.MAX_VALUE;
    private float mMaxRightTranslationX = Float.MAX_VALUE;
    private View mRightView;
    private int mRightViewId;
    private float mStartSwipeTranslationX;
    private SwipeDirection mSwipeDirection = SwipeDirection.LEFT_AND_RIGHT;
    private SwipeInStyle mSwipeInStyle = SwipeInStyle.APPEAR;
    /* access modifiers changed from: private */
    public ListSwipeHelper.OnSwipeListener mSwipeListener;
    private boolean mSwipeStarted;
    /* access modifiers changed from: private */
    public SwipeState mSwipeState = SwipeState.IDLE;
    /* access modifiers changed from: private */
    public float mSwipeTranslationX;
    private View mSwipeView;
    private int mSwipeViewId;
    /* access modifiers changed from: private */
    public k2 mViewHolder;

    public enum SwipeDirection {
        LEFT,
        RIGHT,
        LEFT_AND_RIGHT,
        NONE
    }

    public enum SwipeInStyle {
        APPEAR,
        SLIDE
    }

    public enum SwipeState {
        IDLE,
        SWIPING,
        ANIMATING
    }

    public ListSwipeItem(Context context) {
        super(context);
    }

    private float getTranslateToXPosition(float f10, float f11, float f12) {
        int measuredWidth;
        int i10 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
        if (i10 == 0 && Math.abs(f10 - f11) < ((float) (getMeasuredWidth() / 3))) {
            return f10;
        }
        if (f11 >= 0.0f) {
            if (f10 == 0.0f) {
                if (f12 < 0.0f) {
                    return 0.0f;
                }
            } else if (i10 <= 0) {
                return 0.0f;
            }
            measuredWidth = getMeasuredWidth();
        } else if (i10 > 0) {
            return 0.0f;
        } else {
            measuredWidth = -getMeasuredWidth();
        }
        return (float) measuredWidth;
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ListSwipeItem);
        this.mSwipeViewId = obtainStyledAttributes.getResourceId(R.styleable.ListSwipeItem_swipeViewId, -1);
        this.mLeftViewId = obtainStyledAttributes.getResourceId(R.styleable.ListSwipeItem_leftViewId, -1);
        this.mRightViewId = obtainStyledAttributes.getResourceId(R.styleable.ListSwipeItem_rightViewId, -1);
        obtainStyledAttributes.recycle();
    }

    public void animateToSwipeTranslationX(float f10, Animator.AnimatorListener... animatorListenerArr) {
        float f11 = this.mSwipeTranslationX;
        if (f10 != f11) {
            this.mSwipeState = SwipeState.ANIMATING;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "SwipeTranslationX", new float[]{f11, f10});
            ofFloat.setDuration(250);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            for (Animator.AnimatorListener animatorListener : animatorListenerArr) {
                if (animatorListener != null) {
                    ofFloat.addListener(animatorListener);
                }
            }
            ofFloat.start();
        }
    }

    public float getMaxLeftTranslationX() {
        return Math.min(this.mMaxLeftTranslationX, (float) getMeasuredWidth());
    }

    public float getMaxRightTranslationX() {
        return Math.min(this.mMaxRightTranslationX, (float) getMeasuredWidth());
    }

    public SwipeDirection getSupportedSwipeDirection() {
        return this.mSwipeDirection;
    }

    public SwipeDirection getSwipedDirection() {
        return this.mSwipeState != SwipeState.IDLE ? SwipeDirection.NONE : this.mSwipeView.getTranslationX() == (-getMaxLeftTranslationX()) ? SwipeDirection.LEFT : this.mSwipeView.getTranslationX() == getMaxRightTranslationX() ? SwipeDirection.RIGHT : SwipeDirection.NONE;
    }

    public void handleSwipeMove(float f10, k2 k2Var) {
        if (!isAnimating()) {
            this.mSwipeState = SwipeState.SWIPING;
            if (!this.mSwipeStarted) {
                this.mSwipeStarted = true;
                this.mViewHolder = k2Var;
                k2Var.setIsRecyclable(false);
            }
            swipeTranslationByX(f10);
        }
    }

    public void handleSwipeMoveStarted(ListSwipeHelper.OnSwipeListener onSwipeListener) {
        this.mStartSwipeTranslationX = this.mSwipeTranslationX;
        this.mSwipeListener = onSwipeListener;
    }

    public void handleSwipeUp(Animator.AnimatorListener animatorListener) {
        if (!isAnimating() && this.mSwipeStarted) {
            AnonymousClass2 r02 = new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    SwipeState unused = ListSwipeItem.this.mSwipeState = SwipeState.IDLE;
                    if (ListSwipeItem.this.mSwipeTranslationX == 0.0f) {
                        ListSwipeItem.this.resetSwipe(false);
                    }
                    if (ListSwipeItem.this.mViewHolder != null) {
                        ListSwipeItem.this.mViewHolder.setIsRecyclable(true);
                    }
                }
            };
            if (this.mFlingSpeed != 0.0f || Math.abs(this.mStartSwipeTranslationX - this.mSwipeTranslationX) >= ((float) (getMeasuredWidth() / 3))) {
                animateToSwipeTranslationX(getTranslateToXPosition(this.mStartSwipeTranslationX, this.mSwipeTranslationX, this.mFlingSpeed), r02, animatorListener);
            } else {
                animateToSwipeTranslationX(this.mStartSwipeTranslationX, r02, animatorListener);
            }
            this.mStartSwipeTranslationX = 0.0f;
            this.mFlingSpeed = 0.0f;
        }
    }

    public boolean isAnimating() {
        return this.mSwipeState == SwipeState.ANIMATING;
    }

    public boolean isSwipeStarted() {
        return this.mSwipeStarted;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mSwipeView = findViewById(this.mSwipeViewId);
        this.mLeftView = findViewById(this.mLeftViewId);
        this.mRightView = findViewById(this.mRightViewId);
        View view = this.mLeftView;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = this.mRightView;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    public void resetSwipe(boolean z10) {
        if (!isAnimating() && this.mSwipeStarted) {
            if (this.mSwipeTranslationX != 0.0f) {
                if (z10) {
                    animateToSwipeTranslationX(0.0f, new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            SwipeState unused = ListSwipeItem.this.mSwipeState = SwipeState.IDLE;
                            ListSwipeHelper.OnSwipeListener unused2 = ListSwipeItem.this.mSwipeListener = null;
                        }
                    });
                    k2 k2Var = this.mViewHolder;
                    if (k2Var != null && !k2Var.isRecyclable()) {
                        this.mViewHolder.setIsRecyclable(true);
                    }
                    this.mViewHolder = null;
                    this.mFlingSpeed = 0.0f;
                    this.mStartSwipeTranslationX = 0.0f;
                    this.mSwipeStarted = false;
                }
                setSwipeTranslationX(0.0f);
                this.mSwipeState = SwipeState.IDLE;
            }
            this.mSwipeListener = null;
            k2 k2Var2 = this.mViewHolder;
            this.mViewHolder.setIsRecyclable(true);
            this.mViewHolder = null;
            this.mFlingSpeed = 0.0f;
            this.mStartSwipeTranslationX = 0.0f;
            this.mSwipeStarted = false;
        }
    }

    public void setFlingSpeed(float f10) {
        this.mFlingSpeed = f10;
    }

    public void setMaxLeftTranslationX(float f10) {
        this.mMaxLeftTranslationX = Math.abs(f10);
    }

    public void setMaxRightTranslationX(float f10) {
        this.mMaxRightTranslationX = Math.abs(f10);
    }

    public void setSupportedSwipeDirection(SwipeDirection swipeDirection) {
        this.mSwipeDirection = swipeDirection;
    }

    public void setSwipeInStyle(SwipeInStyle swipeInStyle) {
        this.mSwipeInStyle = swipeInStyle;
    }

    public void setSwipeListener(ListSwipeHelper.OnSwipeListener onSwipeListener) {
        this.mSwipeListener = onSwipeListener;
    }

    public void setSwipeTranslationX(float f10) {
        View view;
        SwipeDirection swipeDirection = this.mSwipeDirection;
        if ((swipeDirection == SwipeDirection.LEFT && f10 > 0.0f) || ((swipeDirection == SwipeDirection.RIGHT && f10 < 0.0f) || swipeDirection == SwipeDirection.NONE)) {
            f10 = 0.0f;
        }
        float min = Math.min(f10, getMaxRightTranslationX());
        this.mSwipeTranslationX = min;
        float max = Math.max(min, -getMaxLeftTranslationX());
        this.mSwipeTranslationX = max;
        if (max != this.mSwipeView.getTranslationX()) {
            this.mSwipeView.setTranslationX(this.mSwipeTranslationX);
            ListSwipeHelper.OnSwipeListener onSwipeListener = this.mSwipeListener;
            if (onSwipeListener != null) {
                onSwipeListener.onItemSwiping(this, this.mSwipeTranslationX);
            }
            float f11 = this.mSwipeTranslationX;
            if (f11 < 0.0f) {
                if (this.mSwipeInStyle == SwipeInStyle.SLIDE) {
                    this.mRightView.setTranslationX(((float) getMeasuredWidth()) + this.mSwipeTranslationX);
                }
                this.mRightView.setVisibility(0);
            } else if (f11 > 0.0f) {
                if (this.mSwipeInStyle == SwipeInStyle.SLIDE) {
                    this.mLeftView.setTranslationX(((float) (-getMeasuredWidth())) + this.mSwipeTranslationX);
                }
                this.mLeftView.setVisibility(0);
                view = this.mRightView;
                view.setVisibility(4);
            } else {
                this.mRightView.setVisibility(4);
            }
            view = this.mLeftView;
            view.setVisibility(4);
        }
    }

    public void setTag(Object obj) {
        super.setTag(obj);
        k2 k2Var = this.mViewHolder;
        if (k2Var != null && k2Var.isRecyclable()) {
            resetSwipe(false);
        }
    }

    public void swipeTranslationByX(float f10) {
        setSwipeTranslationX(this.mSwipeTranslationX + f10);
    }

    public ListSwipeItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public ListSwipeItem(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(attributeSet);
    }
}
