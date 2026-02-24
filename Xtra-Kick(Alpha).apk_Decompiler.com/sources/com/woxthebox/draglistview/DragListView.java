package com.woxthebox.draglistview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.r;
import com.woxthebox.draglistview.DragItemAdapter;
import com.woxthebox.draglistview.DragItemRecyclerView;
import com.woxthebox.draglistview.swipe.ListSwipeHelper;

public class DragListView extends FrameLayout {
    private DragItem mDragItem;
    /* access modifiers changed from: private */
    public DragListCallback mDragListCallback;
    /* access modifiers changed from: private */
    public DragListListener mDragListListener;
    /* access modifiers changed from: private */
    public DragItemRecyclerView mRecyclerView;
    private ListSwipeHelper mSwipeHelper;
    /* access modifiers changed from: private */
    public float mTouchX;
    /* access modifiers changed from: private */
    public float mTouchY;

    public interface DragListCallback {
        boolean canDragItemAtPosition(int i10);

        boolean canDropItemAtPosition(int i10);
    }

    public static abstract class DragListCallbackAdapter implements DragListCallback {
        public boolean canDragItemAtPosition(int i10) {
            return true;
        }

        public boolean canDropItemAtPosition(int i10) {
            return true;
        }
    }

    public interface DragListListener {
        void onItemDragEnded(int i10, int i11);

        void onItemDragStarted(int i10);

        void onItemDragging(int i10, float f10, float f11);
    }

    public static abstract class DragListListenerAdapter implements DragListListener {
        public void onItemDragEnded(int i10, int i11) {
        }

        public void onItemDragStarted(int i10) {
        }

        public void onItemDragging(int i10, float f10, float f11) {
        }
    }

    public DragListView(Context context) {
        super(context);
    }

    private DragItemRecyclerView createRecyclerView() {
        DragItemRecyclerView dragItemRecyclerView = (DragItemRecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.drag_item_recycler_view, this, false);
        dragItemRecyclerView.setMotionEventSplittingEnabled(false);
        dragItemRecyclerView.setItemAnimator(new r());
        dragItemRecyclerView.setVerticalScrollBarEnabled(false);
        dragItemRecyclerView.setHorizontalScrollBarEnabled(false);
        dragItemRecyclerView.setDragItemListener(new DragItemRecyclerView.DragItemListener() {
            private int mDragStartPosition;

            public void onDragEnded(int i10) {
                if (DragListView.this.mDragListListener != null) {
                    DragListView.this.mDragListListener.onItemDragEnded(this.mDragStartPosition, i10);
                }
            }

            public void onDragStarted(int i10, float f10, float f11) {
                DragListView.this.getParent().requestDisallowInterceptTouchEvent(true);
                this.mDragStartPosition = i10;
                if (DragListView.this.mDragListListener != null) {
                    DragListView.this.mDragListListener.onItemDragStarted(i10);
                }
            }

            public void onDragging(int i10, float f10, float f11) {
                if (DragListView.this.mDragListListener != null) {
                    DragListView.this.mDragListListener.onItemDragging(i10, f10, f11);
                }
            }
        });
        dragItemRecyclerView.setDragItemCallback(new DragItemRecyclerView.DragItemCallback() {
            public boolean canDragItemAtPosition(int i10) {
                return DragListView.this.mDragListCallback == null || DragListView.this.mDragListCallback.canDragItemAtPosition(i10);
            }

            public boolean canDropItemAtPosition(int i10) {
                return DragListView.this.mDragListCallback == null || DragListView.this.mDragListCallback.canDropItemAtPosition(i10);
            }
        });
        return dragItemRecyclerView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r0 != 3) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            float r0 = r4.getX()
            r3.mTouchX = r0
            float r0 = r4.getY()
            r3.mTouchY = r0
            boolean r0 = r3.isDragging()
            if (r0 == 0) goto L_0x0034
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == r1) goto L_0x002e
            r2 = 2
            if (r0 == r2) goto L_0x0020
            r4 = 3
            if (r0 == r4) goto L_0x002e
            goto L_0x0033
        L_0x0020:
            com.woxthebox.draglistview.DragItemRecyclerView r0 = r3.mRecyclerView
            float r2 = r4.getX()
            float r4 = r4.getY()
            r0.onDragging(r2, r4)
            goto L_0x0033
        L_0x002e:
            com.woxthebox.draglistview.DragItemRecyclerView r4 = r3.mRecyclerView
            r4.onDragEnded()
        L_0x0033:
            return r1
        L_0x0034:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.DragListView.handleTouchEvent(android.view.MotionEvent):boolean");
    }

    public DragItemAdapter getAdapter() {
        DragItemRecyclerView dragItemRecyclerView = this.mRecyclerView;
        if (dragItemRecyclerView != null) {
            return (DragItemAdapter) dragItemRecyclerView.getAdapter();
        }
        return null;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public boolean isDragEnabled() {
        return this.mRecyclerView.isDragEnabled();
    }

    public boolean isDragging() {
        return this.mRecyclerView.isDragging();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.mDragItem = new DragItem(getContext());
        DragItemRecyclerView createRecyclerView = createRecyclerView();
        this.mRecyclerView = createRecyclerView;
        createRecyclerView.setDragItem(this.mDragItem);
        addView(this.mRecyclerView);
        addView(this.mDragItem.getDragItemView());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return handleTouchEvent(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return handleTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void resetSwipedViews(View view) {
        ListSwipeHelper listSwipeHelper = this.mSwipeHelper;
        if (listSwipeHelper != null) {
            listSwipeHelper.resetSwipedViews(view);
        }
    }

    public void setAdapter(DragItemAdapter dragItemAdapter, boolean z10) {
        this.mRecyclerView.setHasFixedSize(z10);
        this.mRecyclerView.setAdapter(dragItemAdapter);
        dragItemAdapter.setDragStartedListener(new DragItemAdapter.DragStartCallback() {
            public boolean isDragging() {
                return DragListView.this.mRecyclerView.isDragging();
            }

            public boolean startDrag(View view, long j10) {
                return DragListView.this.mRecyclerView.startDrag(view, j10, DragListView.this.mTouchX, DragListView.this.mTouchY);
            }
        });
    }

    public void setCanDragHorizontally(boolean z10) {
        this.mDragItem.setCanDragHorizontally(z10);
    }

    public void setCanDragVertically(boolean z10) {
        this.mDragItem.setCanDragVertically(z10);
    }

    public void setCanNotDragAboveTopItem(boolean z10) {
        this.mRecyclerView.setCanNotDragAboveTopItem(z10);
    }

    public void setCanNotDragBelowBottomItem(boolean z10) {
        this.mRecyclerView.setCanNotDragBelowBottomItem(z10);
    }

    public void setCustomDragItem(DragItem dragItem) {
        removeViewAt(1);
        if (dragItem == null) {
            dragItem = new DragItem(getContext());
        }
        dragItem.setCanDragHorizontally(this.mDragItem.canDragHorizontally());
        dragItem.setCanDragVertically(this.mDragItem.canDragVertically());
        dragItem.setSnapToTouch(this.mDragItem.isSnapToTouch());
        this.mDragItem = dragItem;
        this.mRecyclerView.setDragItem(dragItem);
        addView(this.mDragItem.getDragItemView());
    }

    public void setDisableReorderWhenDragging(boolean z10) {
        this.mRecyclerView.setDisableReorderWhenDragging(z10);
    }

    public void setDragEnabled(boolean z10) {
        this.mRecyclerView.setDragEnabled(z10);
    }

    public void setDragListCallback(DragListCallback dragListCallback) {
        this.mDragListCallback = dragListCallback;
    }

    public void setDragListListener(DragListListener dragListListener) {
        this.mDragListListener = dragListListener;
    }

    public void setDropTargetDrawables(Drawable drawable, Drawable drawable2) {
        this.mRecyclerView.setDropTargetDrawables(drawable, drawable2);
    }

    public void setLayoutManager(q1 q1Var) {
        this.mRecyclerView.setLayoutManager(q1Var);
    }

    public void setScrollingEnabled(boolean z10) {
        this.mRecyclerView.setScrollingEnabled(z10);
    }

    public void setSnapDragItemToTouch(boolean z10) {
        this.mDragItem.setSnapToTouch(z10);
    }

    public void setSwipeListener(ListSwipeHelper.OnSwipeListener onSwipeListener) {
        ListSwipeHelper listSwipeHelper = this.mSwipeHelper;
        if (listSwipeHelper == null) {
            this.mSwipeHelper = new ListSwipeHelper(getContext().getApplicationContext(), onSwipeListener);
        } else {
            listSwipeHelper.setSwipeListener(onSwipeListener);
        }
        this.mSwipeHelper.detachFromRecyclerView();
        if (onSwipeListener != null) {
            this.mSwipeHelper.attachToRecyclerView(this.mRecyclerView);
        }
    }

    public void swapAdapter(DragItemAdapter dragItemAdapter, boolean z10) {
        this.mRecyclerView.swapAdapter(dragItemAdapter, z10);
        dragItemAdapter.setDragStartedListener(new DragItemAdapter.DragStartCallback() {
            public boolean isDragging() {
                return DragListView.this.mRecyclerView.isDragging();
            }

            public boolean startDrag(View view, long j10) {
                return DragListView.this.mRecyclerView.startDrag(view, j10, DragListView.this.mTouchX, DragListView.this.mTouchY);
            }
        });
    }

    public DragListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
