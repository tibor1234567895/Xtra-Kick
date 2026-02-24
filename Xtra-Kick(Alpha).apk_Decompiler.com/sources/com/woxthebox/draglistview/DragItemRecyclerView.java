package com.woxthebox.draglistview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.k2;
import androidx.recyclerview.widget.o1;
import androidx.recyclerview.widget.q1;
import com.woxthebox.draglistview.AutoScroller;

public class DragItemRecyclerView extends RecyclerView implements AutoScroller.AutoScrollListener {
    /* access modifiers changed from: private */
    public DragItemAdapter mAdapter;
    private AutoScroller mAutoScroller;
    private boolean mCanNotDragAboveTop;
    private boolean mCanNotDragBelowBottom;
    private boolean mClipToPadding;
    private boolean mDisableReorderWhenDragging;
    private DragItemCallback mDragCallback;
    private boolean mDragEnabled = true;
    /* access modifiers changed from: private */
    public DragItem mDragItem;
    private long mDragItemId = -1;
    /* access modifiers changed from: private */
    public int mDragItemPosition;
    private DragState mDragState = DragState.DRAG_ENDED;
    /* access modifiers changed from: private */
    public Drawable mDropTargetBackgroundDrawable;
    /* access modifiers changed from: private */
    public Drawable mDropTargetForegroundDrawable;
    /* access modifiers changed from: private */
    public boolean mHoldChangePosition;
    private DragItemListener mListener;
    private boolean mScrollingEnabled = true;
    private float mStartY;
    private int mTouchSlop;

    public interface DragItemCallback {
        boolean canDragItemAtPosition(int i10);

        boolean canDropItemAtPosition(int i10);
    }

    public interface DragItemListener {
        void onDragEnded(int i10);

        void onDragStarted(int i10, float f10, float f11);

        void onDragging(int i10, float f10, float f11);
    }

    public enum DragState {
        DRAG_STARTED,
        DRAGGING,
        DRAG_ENDED
    }

    public DragItemRecyclerView(Context context) {
        super(context, (AttributeSet) null);
        init();
    }

    private void init() {
        this.mAutoScroller = new AutoScroller(getContext(), this);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        addItemDecoration(new o1() {
            private void drawDecoration(Canvas canvas, RecyclerView recyclerView, Drawable drawable) {
                if (DragItemRecyclerView.this.mAdapter != null && DragItemRecyclerView.this.mAdapter.getDropTargetId() != -1 && drawable != null) {
                    for (int i10 = 0; i10 < recyclerView.getChildCount(); i10++) {
                        View childAt = recyclerView.getChildAt(i10);
                        int childAdapterPosition = DragItemRecyclerView.this.getChildAdapterPosition(childAt);
                        if (childAdapterPosition != -1 && DragItemRecyclerView.this.mAdapter.getItemId(childAdapterPosition) == DragItemRecyclerView.this.mAdapter.getDropTargetId()) {
                            drawable.setBounds(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                            drawable.draw(canvas);
                        }
                    }
                }
            }

            public void onDraw(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
                onDraw(canvas, recyclerView);
                drawDecoration(canvas, recyclerView, DragItemRecyclerView.this.mDropTargetBackgroundDrawable);
            }

            public void onDrawOver(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
                onDrawOver(canvas, recyclerView);
                drawDecoration(canvas, recyclerView, DragItemRecyclerView.this.mDropTargetForegroundDrawable);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onDragItemAnimationEnd() {
        this.mAdapter.setDragItemId(-1);
        this.mAdapter.setDropTargetId(-1);
        this.mAdapter.notifyDataSetChanged();
        this.mDragState = DragState.DRAG_ENDED;
        DragItemListener dragItemListener = this.mListener;
        if (dragItemListener != null) {
            dragItemListener.onDragEnded(this.mDragItemPosition);
        }
        this.mDragItemId = -1;
        this.mDragItem.hide();
        setEnabled(true);
        invalidate();
    }

    private boolean shouldChangeItemPosition(int i10) {
        int i11;
        if (this.mHoldChangePosition || (i11 = this.mDragItemPosition) == -1 || i11 == i10) {
            return false;
        }
        if ((this.mCanNotDragAboveTop && i10 == 0) || (this.mCanNotDragBelowBottom && i10 == this.mAdapter.getItemCount() - 1)) {
            return false;
        }
        DragItemCallback dragItemCallback = this.mDragCallback;
        return dragItemCallback == null || dragItemCallback.canDropItemAtPosition(i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0134, code lost:
        if (r9.itemView.getTop() >= r1) goto L_0x014e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014c, code lost:
        if (r9.itemView.getLeft() >= r6) goto L_0x014e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0188  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateDragPositionAndScroll() {
        /*
            r11 = this;
            com.woxthebox.draglistview.DragItem r0 = r11.mDragItem
            float r0 = r0.getX()
            com.woxthebox.draglistview.DragItem r1 = r11.mDragItem
            float r1 = r1.getY()
            android.view.View r0 = r11.findChildView(r0, r1)
            int r1 = r11.getChildLayoutPosition(r0)
            r2 = -1
            if (r1 == r2) goto L_0x01c5
            if (r0 != 0) goto L_0x001b
            goto L_0x01c5
        L_0x001b:
            androidx.recyclerview.widget.q1 r2 = r11.getLayoutManager()
            boolean r2 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x002f
            androidx.recyclerview.widget.q1 r2 = r11.getLayoutManager()
            boolean r2 = r2 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r2 != 0) goto L_0x002f
            r2 = 1
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            if (r2 == 0) goto L_0x0083
            android.view.ViewGroup$LayoutParams r2 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            int r5 = r0.getMeasuredHeight()
            int r6 = r2.topMargin
            int r5 = r5 + r6
            int r6 = r2.bottomMargin
            int r5 = r5 + r6
            int r6 = r0.getTop()
            int r2 = r2.topMargin
            int r6 = r6 - r2
            int r2 = r5 / 2
            int r2 = r2 + r6
            int r6 = r11.mDragItemPosition
            int r7 = r11.getChildLayoutPosition(r0)
            if (r6 >= r7) goto L_0x0056
            r6 = 1
            goto L_0x0057
        L_0x0056:
            r6 = 0
        L_0x0057:
            if (r6 == 0) goto L_0x0065
            com.woxthebox.draglistview.DragItem r6 = r11.mDragItem
            float r6 = r6.getY()
            float r2 = (float) r2
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0072
            goto L_0x0070
        L_0x0065:
            com.woxthebox.draglistview.DragItem r6 = r11.mDragItem
            float r6 = r6.getY()
            float r2 = (float) r2
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0072
        L_0x0070:
            r2 = 1
            goto L_0x0073
        L_0x0072:
            r2 = 0
        L_0x0073:
            com.woxthebox.draglistview.DragItem r6 = r11.mDragItem
            android.view.View r6 = r6.getDragItemView()
            int r6 = r6.getMeasuredHeight()
            if (r5 <= r6) goto L_0x0083
            if (r2 != 0) goto L_0x0083
            int r1 = r11.mDragItemPosition
        L_0x0083:
            androidx.recyclerview.widget.q1 r2 = r11.getLayoutManager()
            androidx.recyclerview.widget.LinearLayoutManager r2 = (androidx.recyclerview.widget.LinearLayoutManager) r2
            boolean r5 = r11.shouldChangeItemPosition(r1)
            if (r5 == 0) goto L_0x00d4
            boolean r5 = r11.mDisableReorderWhenDragging
            if (r5 == 0) goto L_0x00a2
            com.woxthebox.draglistview.DragItemAdapter r5 = r11.mAdapter
            long r6 = r5.getItemId(r1)
            r5.setDropTargetId(r6)
            com.woxthebox.draglistview.DragItemAdapter r1 = r11.mAdapter
            r1.notifyDataSetChanged()
            goto L_0x00d4
        L_0x00a2:
            int r5 = r2.X0()
            android.view.View r6 = r2.B(r5)
            com.woxthebox.draglistview.DragItemAdapter r7 = r11.mAdapter
            int r8 = r11.mDragItemPosition
            r7.changeItemPosition(r8, r1)
            r11.mDragItemPosition = r1
            int r1 = r2.f1917w
            if (r1 != r4) goto L_0x00c4
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r1 = r1.topMargin
            int r6 = r6.getTop()
            goto L_0x00d0
        L_0x00c4:
            android.view.ViewGroup$LayoutParams r1 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r1 = r1.leftMargin
            int r6 = r6.getLeft()
        L_0x00d0:
            int r6 = r6 - r1
            r2.n1(r5, r6)
        L_0x00d4:
            boolean r1 = r11.mClipToPadding
            if (r1 == 0) goto L_0x00dd
            int r1 = r11.getPaddingTop()
            goto L_0x00de
        L_0x00dd:
            r1 = 0
        L_0x00de:
            boolean r5 = r11.mClipToPadding
            if (r5 == 0) goto L_0x00ec
            int r5 = r11.getHeight()
            int r6 = r11.getPaddingBottom()
            int r5 = r5 - r6
            goto L_0x00f0
        L_0x00ec:
            int r5 = r11.getHeight()
        L_0x00f0:
            boolean r6 = r11.mClipToPadding
            if (r6 == 0) goto L_0x00f9
            int r6 = r11.getPaddingLeft()
            goto L_0x00fa
        L_0x00f9:
            r6 = 0
        L_0x00fa:
            boolean r7 = r11.mClipToPadding
            if (r7 == 0) goto L_0x0108
            int r7 = r11.getWidth()
            int r8 = r11.getPaddingRight()
            int r7 = r7 - r8
            goto L_0x010c
        L_0x0108:
            int r7 = r11.getWidth()
        L_0x010c:
            com.woxthebox.draglistview.DragItemAdapter r8 = r11.mAdapter
            int r8 = r8.getItemCount()
            int r8 = r8 - r4
            androidx.recyclerview.widget.k2 r8 = r11.findViewHolderForLayoutPosition(r8)
            androidx.recyclerview.widget.k2 r9 = r11.findViewHolderForLayoutPosition(r3)
            int r10 = r2.f1917w
            if (r10 != r4) goto L_0x0137
            if (r8 == 0) goto L_0x012b
            android.view.View r6 = r8.itemView
            int r6 = r6.getBottom()
            if (r6 > r5) goto L_0x012b
            r5 = 1
            goto L_0x012c
        L_0x012b:
            r5 = 0
        L_0x012c:
            if (r9 == 0) goto L_0x014f
            android.view.View r6 = r9.itemView
            int r6 = r6.getTop()
            if (r6 < r1) goto L_0x014f
            goto L_0x014e
        L_0x0137:
            if (r8 == 0) goto L_0x0143
            android.view.View r1 = r8.itemView
            int r1 = r1.getRight()
            if (r1 > r7) goto L_0x0143
            r5 = 1
            goto L_0x0144
        L_0x0143:
            r5 = 0
        L_0x0144:
            if (r9 == 0) goto L_0x014f
            android.view.View r1 = r9.itemView
            int r1 = r1.getLeft()
            if (r1 < r6) goto L_0x014f
        L_0x014e:
            r3 = 1
        L_0x014f:
            int r1 = r2.f1917w
            if (r1 != r4) goto L_0x0188
            com.woxthebox.draglistview.DragItem r1 = r11.mDragItem
            float r1 = r1.getY()
            int r2 = r11.getHeight()
            int r4 = r0.getHeight()
            int r4 = r4 / 2
            int r2 = r2 - r4
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x0170
            if (r5 != 0) goto L_0x0170
            com.woxthebox.draglistview.AutoScroller r0 = r11.mAutoScroller
            com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.UP
            goto L_0x01a4
        L_0x0170:
            com.woxthebox.draglistview.DragItem r1 = r11.mDragItem
            float r1 = r1.getY()
            int r0 = r0.getHeight()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01c0
            if (r3 != 0) goto L_0x01c0
            com.woxthebox.draglistview.AutoScroller r0 = r11.mAutoScroller
            com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.DOWN
            goto L_0x01a4
        L_0x0188:
            com.woxthebox.draglistview.DragItem r1 = r11.mDragItem
            float r1 = r1.getX()
            int r2 = r11.getWidth()
            int r4 = r0.getWidth()
            int r4 = r4 / 2
            int r2 = r2 - r4
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x01a8
            if (r5 != 0) goto L_0x01a8
            com.woxthebox.draglistview.AutoScroller r0 = r11.mAutoScroller
            com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.LEFT
        L_0x01a4:
            r0.startAutoScroll(r1)
            goto L_0x01c5
        L_0x01a8:
            com.woxthebox.draglistview.DragItem r1 = r11.mDragItem
            float r1 = r1.getX()
            int r0 = r0.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x01c0
            if (r3 != 0) goto L_0x01c0
            com.woxthebox.draglistview.AutoScroller r0 = r11.mAutoScroller
            com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.RIGHT
            goto L_0x01a4
        L_0x01c0:
            com.woxthebox.draglistview.AutoScroller r0 = r11.mAutoScroller
            r0.stopAutoScroll()
        L_0x01c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.DragItemRecyclerView.updateDragPositionAndScroll():void");
    }

    public void addDragItemAndStart(float f10, Object obj, long j10) {
        int dragPositionForY = getDragPositionForY(f10);
        this.mDragState = DragState.DRAG_STARTED;
        this.mDragItemId = j10;
        this.mAdapter.setDragItemId(j10);
        this.mAdapter.addItem(dragPositionForY, obj);
        this.mDragItemPosition = dragPositionForY;
        this.mHoldChangePosition = true;
        postDelayed(new Runnable() {
            public void run() {
                boolean unused = DragItemRecyclerView.this.mHoldChangePosition = false;
            }
        }, getItemAnimator().f2100e);
        invalidate();
    }

    public View findChildView(float f10, float f11) {
        int childCount = getChildCount();
        if (f11 <= 0.0f && childCount > 0) {
            return getChildAt(0);
        }
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (f10 >= ((float) (childAt.getLeft() - marginLayoutParams.leftMargin)) && f10 <= ((float) (childAt.getRight() + marginLayoutParams.rightMargin)) && f11 >= ((float) (childAt.getTop() - marginLayoutParams.topMargin)) && f11 <= ((float) (childAt.getBottom() + marginLayoutParams.bottomMargin))) {
                return childAt;
            }
        }
        return null;
    }

    public long getDragItemId() {
        return this.mDragItemId;
    }

    public int getDragPositionForY(float f10) {
        View findChildView = findChildView(0.0f, f10);
        int childLayoutPosition = (findChildView != null || getChildCount() <= 0) ? getChildLayoutPosition(findChildView) : getChildLayoutPosition(getChildAt(getChildCount() - 1)) + 1;
        if (childLayoutPosition == -1) {
            return 0;
        }
        return childLayoutPosition;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public boolean isDragging() {
        return this.mDragState != DragState.DRAG_ENDED;
    }

    public void onAutoScrollColumnBy(int i10) {
    }

    public void onAutoScrollPositionBy(int i10, int i11) {
        if (isDragging()) {
            scrollBy(i10, i11);
            updateDragPositionAndScroll();
            return;
        }
        this.mAutoScroller.stopAutoScroll();
    }

    public void onDragEnded() {
        if (this.mDragState != DragState.DRAG_ENDED) {
            this.mAutoScroller.stopAutoScroll();
            setEnabled(false);
            if (this.mDisableReorderWhenDragging) {
                DragItemAdapter dragItemAdapter = this.mAdapter;
                int positionForItemId = dragItemAdapter.getPositionForItemId(dragItemAdapter.getDropTargetId());
                if (positionForItemId != -1) {
                    this.mAdapter.swapItems(this.mDragItemPosition, positionForItemId);
                    this.mDragItemPosition = positionForItemId;
                }
                this.mAdapter.setDropTargetId(-1);
            }
            post(new Runnable() {
                public void run() {
                    DragItemRecyclerView dragItemRecyclerView = DragItemRecyclerView.this;
                    final k2 findViewHolderForAdapterPosition = dragItemRecyclerView.findViewHolderForAdapterPosition(dragItemRecyclerView.mDragItemPosition);
                    if (findViewHolderForAdapterPosition != null) {
                        if (DragItemRecyclerView.this.getItemAnimator() != null) {
                            DragItemRecyclerView.this.getItemAnimator().i(findViewHolderForAdapterPosition);
                        }
                        DragItemRecyclerView.this.mDragItem.endDrag(findViewHolderForAdapterPosition.itemView, new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                findViewHolderForAdapterPosition.itemView.setAlpha(1.0f);
                                DragItemRecyclerView.this.onDragItemAnimationEnd();
                            }
                        });
                        return;
                    }
                    DragItemRecyclerView.this.onDragItemAnimationEnd();
                }
            });
        }
    }

    public void onDragging(float f10, float f11) {
        if (this.mDragState != DragState.DRAG_ENDED) {
            this.mDragState = DragState.DRAGGING;
            this.mDragItemPosition = this.mAdapter.getPositionForItemId(this.mDragItemId);
            this.mDragItem.setPosition(f10, f11);
            if (!this.mAutoScroller.isAutoScrolling()) {
                updateDragPositionAndScroll();
            }
            DragItemListener dragItemListener = this.mListener;
            if (dragItemListener != null) {
                dragItemListener.onDragging(this.mDragItemPosition, f10, f11);
            }
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mScrollingEnabled) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mStartY = motionEvent.getY();
        } else if (action == 2 && ((double) Math.abs(motionEvent.getY() - this.mStartY)) > ((double) this.mTouchSlop) * 0.5d) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public Object removeDragItemAndEnd() {
        if (this.mDragItemPosition == -1) {
            return null;
        }
        this.mAutoScroller.stopAutoScroll();
        Object removeItem = this.mAdapter.removeItem(this.mDragItemPosition);
        this.mAdapter.setDragItemId(-1);
        this.mDragState = DragState.DRAG_ENDED;
        this.mDragItemId = -1;
        invalidate();
        return removeItem;
    }

    public void setAdapter(g1 g1Var) {
        if (!isInEditMode()) {
            if (!(g1Var instanceof DragItemAdapter)) {
                throw new RuntimeException("Adapter must extend DragItemAdapter");
            } else if (!g1Var.hasStableIds()) {
                throw new RuntimeException("Adapter must have stable ids");
            }
        }
        super.setAdapter(g1Var);
        this.mAdapter = (DragItemAdapter) g1Var;
    }

    public void setCanNotDragAboveTopItem(boolean z10) {
        this.mCanNotDragAboveTop = z10;
    }

    public void setCanNotDragBelowBottomItem(boolean z10) {
        this.mCanNotDragBelowBottom = z10;
    }

    public void setClipToPadding(boolean z10) {
        super.setClipToPadding(z10);
        this.mClipToPadding = z10;
    }

    public void setDisableReorderWhenDragging(boolean z10) {
        this.mDisableReorderWhenDragging = z10;
    }

    public void setDragEnabled(boolean z10) {
        this.mDragEnabled = z10;
    }

    public void setDragItem(DragItem dragItem) {
        this.mDragItem = dragItem;
    }

    public void setDragItemCallback(DragItemCallback dragItemCallback) {
        this.mDragCallback = dragItemCallback;
    }

    public void setDragItemListener(DragItemListener dragItemListener) {
        this.mListener = dragItemListener;
    }

    public void setDropTargetDrawables(Drawable drawable, Drawable drawable2) {
        this.mDropTargetBackgroundDrawable = drawable;
        this.mDropTargetForegroundDrawable = drawable2;
    }

    public void setLayoutManager(q1 q1Var) {
        super.setLayoutManager(q1Var);
        if (!(q1Var instanceof LinearLayoutManager)) {
            throw new RuntimeException("Layout must be an instance of LinearLayoutManager");
        }
    }

    public void setScrollingEnabled(boolean z10) {
        this.mScrollingEnabled = z10;
    }

    public boolean startDrag(View view, long j10, float f10, float f11) {
        int positionForItemId = this.mAdapter.getPositionForItemId(j10);
        if (!this.mDragEnabled || ((this.mCanNotDragAboveTop && positionForItemId == 0) || (this.mCanNotDragBelowBottom && positionForItemId == this.mAdapter.getItemCount() - 1))) {
            return false;
        }
        DragItemCallback dragItemCallback = this.mDragCallback;
        if (dragItemCallback != null && !dragItemCallback.canDragItemAtPosition(positionForItemId)) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(false);
        this.mDragState = DragState.DRAG_STARTED;
        this.mDragItemId = j10;
        this.mDragItem.startDrag(view, f10, f11);
        this.mDragItemPosition = positionForItemId;
        updateDragPositionAndScroll();
        this.mAdapter.setDragItemId(this.mDragItemId);
        this.mAdapter.notifyDataSetChanged();
        DragItemListener dragItemListener = this.mListener;
        if (dragItemListener != null) {
            dragItemListener.onDragStarted(this.mDragItemPosition, this.mDragItem.getX(), this.mDragItem.getY());
        }
        invalidate();
        return true;
    }

    public void swapAdapter(g1 g1Var, boolean z10) {
        if (!isInEditMode()) {
            if (!(g1Var instanceof DragItemAdapter)) {
                throw new RuntimeException("Adapter must extend DragItemAdapter");
            } else if (!g1Var.hasStableIds()) {
                throw new RuntimeException("Adapter must have stable ids");
            }
        }
        setLayoutFrozen(false);
        o(g1Var, true, z10);
        processDataSetCompletelyChanged(true);
        requestLayout();
        this.mAdapter = (DragItemAdapter) g1Var;
    }

    public DragItemRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        init();
    }

    public DragItemRecyclerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }
}
