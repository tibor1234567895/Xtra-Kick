package com.woxthebox.draglistview.swipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u1;
import androidx.recyclerview.widget.v1;
import com.woxthebox.draglistview.swipe.ListSwipeItem;

public class ListSwipeHelper extends v1 implements u1 {
    private GestureDetector mGestureDetector;
    private GestureListener mGestureListener = new GestureListener();
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public OnSwipeListener mSwipeListener;
    /* access modifiers changed from: private */
    public ListSwipeItem mSwipeView;
    /* access modifiers changed from: private */
    public int mTouchSlop;

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean mSwipeStarted;

        private GestureListener() {
        }

        private boolean canStartSwipe(MotionEvent motionEvent, MotionEvent motionEvent2) {
            return (motionEvent == null || motionEvent2 == null || ListSwipeHelper.this.mSwipeView == null || ListSwipeHelper.this.mRecyclerView.getScrollState() != 0 || ListSwipeHelper.this.mSwipeView.getSupportedSwipeDirection() == ListSwipeItem.SwipeDirection.NONE) ? false : true;
        }

        public boolean isSwipeStarted() {
            return this.mSwipeStarted;
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.mSwipeStarted = false;
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (!canStartSwipe(motionEvent, motionEvent2)) {
                return false;
            }
            ListSwipeHelper.this.mSwipeView.setFlingSpeed(f10);
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (motionEvent == null || motionEvent2 == null || ListSwipeHelper.this.mSwipeView == null || ListSwipeHelper.this.mRecyclerView.getScrollState() != 0) {
                return false;
            }
            float abs = Math.abs(motionEvent2.getX() - motionEvent.getX());
            float abs2 = Math.abs(motionEvent2.getY() - motionEvent.getY());
            if (!this.mSwipeStarted && abs > ((float) (ListSwipeHelper.this.mTouchSlop * 2)) && abs * 0.5f > abs2) {
                this.mSwipeStarted = true;
                ListSwipeHelper.this.mRecyclerView.requestDisallowInterceptTouchEvent(true);
                ListSwipeHelper.this.mSwipeView.handleSwipeMoveStarted(ListSwipeHelper.this.mSwipeListener);
                if (ListSwipeHelper.this.mSwipeListener != null) {
                    ListSwipeHelper.this.mSwipeListener.onItemSwipeStarted(ListSwipeHelper.this.mSwipeView);
                }
            }
            if (this.mSwipeStarted) {
                ListSwipeHelper.this.mSwipeView.handleSwipeMove(-f10, ListSwipeHelper.this.mRecyclerView.getChildViewHolder(ListSwipeHelper.this.mSwipeView));
            }
            return this.mSwipeStarted;
        }
    }

    public interface OnSwipeListener {
        void onItemSwipeEnded(ListSwipeItem listSwipeItem, ListSwipeItem.SwipeDirection swipeDirection);

        void onItemSwipeStarted(ListSwipeItem listSwipeItem);

        void onItemSwiping(ListSwipeItem listSwipeItem, float f10);
    }

    public static abstract class OnSwipeListenerAdapter implements OnSwipeListener {
        public void onItemSwipeEnded(ListSwipeItem listSwipeItem, ListSwipeItem.SwipeDirection swipeDirection) {
        }

        public void onItemSwipeStarted(ListSwipeItem listSwipeItem) {
        }

        public void onItemSwiping(ListSwipeItem listSwipeItem, float f10) {
        }
    }

    public ListSwipeHelper(Context context, OnSwipeListener onSwipeListener) {
        this.mSwipeListener = onSwipeListener;
        this.mGestureDetector = new GestureDetector(context, this.mGestureListener);
    }

    private void handleTouch(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (findChildViewUnder instanceof ListSwipeItem) {
                ListSwipeItem listSwipeItem = (ListSwipeItem) findChildViewUnder;
                if (listSwipeItem.getSupportedSwipeDirection() != ListSwipeItem.SwipeDirection.NONE) {
                    this.mSwipeView = listSwipeItem;
                }
            }
        } else if (action == 1 || action == 3) {
            final ListSwipeItem listSwipeItem2 = this.mSwipeView;
            if (listSwipeItem2 != null) {
                listSwipeItem2.handleSwipeUp(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (listSwipeItem2.isSwipeStarted()) {
                            ListSwipeHelper.this.resetSwipedViews(listSwipeItem2);
                        }
                        if (ListSwipeHelper.this.mSwipeListener != null) {
                            OnSwipeListener access$100 = ListSwipeHelper.this.mSwipeListener;
                            ListSwipeItem listSwipeItem = listSwipeItem2;
                            access$100.onItemSwipeEnded(listSwipeItem, listSwipeItem.getSwipedDirection());
                        }
                    }
                });
            } else {
                resetSwipedViews((View) null);
            }
            this.mSwipeView = null;
            this.mRecyclerView.requestDisallowInterceptTouchEvent(false);
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        recyclerView.addOnItemTouchListener(this);
        this.mRecyclerView.addOnScrollListener(this);
        this.mTouchSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    }

    public void detachFromRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this);
            this.mRecyclerView.removeOnScrollListener(this);
        }
        this.mRecyclerView = null;
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        handleTouch(recyclerView, motionEvent);
        return this.mGestureListener.isSwipeStarted();
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        resetSwipedViews((View) null);
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        handleTouch(recyclerView, motionEvent);
    }

    public void resetSwipedViews(View view) {
        int childCount = this.mRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.mRecyclerView.getChildAt(i10);
            if ((childAt instanceof ListSwipeItem) && childAt != view) {
                ((ListSwipeItem) childAt).resetSwipe(true);
            }
        }
    }

    public void setSwipeListener(OnSwipeListener onSwipeListener) {
        this.mSwipeListener = onSwipeListener;
    }
}
