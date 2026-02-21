package com.woxthebox.draglistview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.o1;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.r;
import com.woxthebox.draglistview.AutoScroller;
import com.woxthebox.draglistview.ColumnProperties;
import com.woxthebox.draglistview.DragItemAdapter;
import com.woxthebox.draglistview.DragItemRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public class BoardView extends HorizontalScrollView implements AutoScroller.AutoScrollListener {
    private static final int SCROLL_ANIMATION_DURATION = 325;
    private AutoScroller mAutoScroller;
    /* access modifiers changed from: private */
    public BoardCallback mBoardCallback;
    private int mBoardEdge = 0;
    /* access modifiers changed from: private */
    public BoardListener mBoardListener;
    /* access modifiers changed from: private */
    public LinearLayout mColumnLayout;
    private int mColumnSpacing = 0;
    private int mColumnWidth;
    /* access modifiers changed from: private */
    public int mCurrentColumn;
    /* access modifiers changed from: private */
    public DragItemRecyclerView mCurrentRecyclerView;
    /* access modifiers changed from: private */
    public DragItem mDragColumn;
    /* access modifiers changed from: private */
    public int mDragColumnStartPosition;
    private float mDragColumnStartScrollX;
    private boolean mDragEnabled = true;
    /* access modifiers changed from: private */
    public DragItem mDragItem;
    /* access modifiers changed from: private */
    public int mDragStartColumn;
    /* access modifiers changed from: private */
    public int mDragStartRow;
    private ArrayList<View> mFooters = new ArrayList<>();
    private GestureDetector mGestureDetector;
    private boolean mHasLaidOut;
    private ArrayList<View> mHeaders = new ArrayList<>();
    /* access modifiers changed from: private */
    public int mLastDragColumn = -1;
    /* access modifiers changed from: private */
    public int mLastDragRow = -1;
    /* access modifiers changed from: private */
    public ArrayList<DragItemRecyclerView> mLists = new ArrayList<>();
    /* access modifiers changed from: private */
    public FrameLayout mRootLayout;
    private SavedState mSavedState;
    private Scroller mScroller;
    private ColumnSnapPosition mSnapPosition = ColumnSnapPosition.CENTER;
    private boolean mSnapToColumnInLandscape = false;
    private boolean mSnapToColumnWhenDragging = true;
    private boolean mSnapToColumnWhenScrolling = true;
    /* access modifiers changed from: private */
    public float mTouchX;
    /* access modifiers changed from: private */
    public float mTouchY;

    /* renamed from: com.woxthebox.draglistview.BoardView$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.woxthebox.draglistview.BoardView$ColumnSnapPosition[] r0 = com.woxthebox.draglistview.BoardView.ColumnSnapPosition.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition = r0
                com.woxthebox.draglistview.BoardView$ColumnSnapPosition r1 = com.woxthebox.draglistview.BoardView.ColumnSnapPosition.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition     // Catch:{ NoSuchFieldError -> 0x001d }
                com.woxthebox.draglistview.BoardView$ColumnSnapPosition r1 = com.woxthebox.draglistview.BoardView.ColumnSnapPosition.CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.woxthebox.draglistview.BoardView$ColumnSnapPosition r1 = com.woxthebox.draglistview.BoardView.ColumnSnapPosition.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.BoardView.AnonymousClass8.<clinit>():void");
        }
    }

    public interface BoardCallback {
        boolean canDragColumnAtPosition(int i10);

        boolean canDragItemAtPosition(int i10, int i11);

        boolean canDropColumnAtPosition(int i10, int i11);

        boolean canDropItemAtPosition(int i10, int i11, int i12, int i13);
    }

    public interface BoardListener {
        void onColumnDragChangedPosition(int i10, int i11);

        void onColumnDragEnded(int i10, int i11);

        void onColumnDragStarted(int i10);

        void onFocusedColumnChanged(int i10, int i11);

        void onItemChangedColumn(int i10, int i11);

        void onItemChangedPosition(int i10, int i11, int i12, int i13);

        void onItemDragEnded(int i10, int i11, int i12, int i13);

        void onItemDragStarted(int i10, int i11);
    }

    public static abstract class BoardListenerAdapter implements BoardListener {
        public void onColumnDragChangedPosition(int i10, int i11) {
        }

        public void onColumnDragEnded(int i10, int i11) {
        }

        public void onColumnDragStarted(int i10) {
        }

        public void onFocusedColumnChanged(int i10, int i11) {
        }

        public void onItemChangedColumn(int i10, int i11) {
        }

        public void onItemChangedPosition(int i10, int i11, int i12, int i13) {
        }

        public void onItemDragEnded(int i10, int i11, int i12, int i13) {
        }

        public void onItemDragStarted(int i10, int i11) {
        }
    }

    public enum ColumnSnapPosition {
        LEFT,
        CENTER,
        RIGHT
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private int mStartColumn;
        private float mStartScrollX;

        private GestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            this.mStartScrollX = (float) BoardView.this.getScrollX();
            this.mStartColumn = BoardView.this.mCurrentColumn;
            return super.onDown(motionEvent);
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            int access$2100 = BoardView.this.getClosestSnapColumn();
            int i10 = this.mStartColumn;
            int i11 = 0;
            boolean z10 = (access$2100 > i10 && f10 > 0.0f) || (access$2100 < i10 && f10 < 0.0f);
            if (this.mStartScrollX == ((float) BoardView.this.getScrollX())) {
                access$2100 = this.mStartColumn;
            } else if (this.mStartColumn == access$2100 || z10) {
                access$2100 = f10 < 0.0f ? access$2100 + 1 : access$2100 - 1;
            }
            if (access$2100 < 0 || access$2100 > BoardView.this.mLists.size() - 1) {
                if (access$2100 >= 0) {
                    i11 = BoardView.this.mLists.size() - 1;
                }
                access$2100 = i11;
            }
            BoardView.this.scrollToColumn(access$2100, true);
            return true;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        };
        public int currentColumn;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.currentColumn = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.currentColumn);
        }

        private SavedState(Parcelable parcelable, int i10) {
            super(parcelable);
            this.currentColumn = i10;
        }
    }

    public BoardView(Context context) {
        super(context);
    }

    private DragItemRecyclerView addColumnTo(int i10, ColumnProperties columnProperties) {
        int i11;
        if (i10 <= getColumnCount()) {
            final DragItemRecyclerView dragItemRecyclerView = (DragItemRecyclerView) LayoutInflater.from(getContext()).inflate(R.layout.drag_item_recycler_view, this, false);
            dragItemRecyclerView.setId(getColumnCount());
            dragItemRecyclerView.setHorizontalScrollBarEnabled(false);
            dragItemRecyclerView.setVerticalScrollBarEnabled(false);
            dragItemRecyclerView.setMotionEventSplittingEnabled(false);
            dragItemRecyclerView.setDragItem(this.mDragItem);
            dragItemRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
            q1 layoutManager = columnProperties.getLayoutManager();
            if (layoutManager == null) {
                getContext();
                layoutManager = new LinearLayoutManager(1);
            }
            dragItemRecyclerView.setLayoutManager(layoutManager);
            dragItemRecyclerView.setBackgroundColor(columnProperties.getItemsSectionBackgroundColor());
            dragItemRecyclerView.setHasFixedSize(columnProperties.hasFixedItemSize());
            List<o1> itemDecorations = columnProperties.getItemDecorations();
            for (int i12 = 0; i12 < itemDecorations.size(); i12++) {
                dragItemRecyclerView.addItemDecoration(itemDecorations.get(i12));
            }
            dragItemRecyclerView.setItemAnimator(new r());
            dragItemRecyclerView.setDragItemListener(new DragItemRecyclerView.DragItemListener() {
                public void onDragEnded(int i10) {
                    int unused = BoardView.this.mLastDragColumn = -1;
                    int unused2 = BoardView.this.mLastDragRow = -1;
                    if (BoardView.this.mBoardListener != null) {
                        BoardView.this.mBoardListener.onItemDragEnded(BoardView.this.mDragStartColumn, BoardView.this.mDragStartRow, BoardView.this.getColumnOfList(dragItemRecyclerView), i10);
                    }
                }

                public void onDragStarted(int i10, float f10, float f11) {
                    BoardView boardView = BoardView.this;
                    int unused = boardView.mDragStartColumn = boardView.getColumnOfList(dragItemRecyclerView);
                    int unused2 = BoardView.this.mDragStartRow = i10;
                    DragItemRecyclerView unused3 = BoardView.this.mCurrentRecyclerView = dragItemRecyclerView;
                    BoardView.this.mDragItem.setOffset(((View) BoardView.this.mCurrentRecyclerView.getParent()).getX(), BoardView.this.mCurrentRecyclerView.getY());
                    if (BoardView.this.mBoardListener != null) {
                        BoardView.this.mBoardListener.onItemDragStarted(BoardView.this.mDragStartColumn, BoardView.this.mDragStartRow);
                    }
                    BoardView.this.invalidate();
                }

                public void onDragging(int i10, float f10, float f11) {
                    int access$800 = BoardView.this.getColumnOfList(dragItemRecyclerView);
                    boolean z10 = (access$800 == BoardView.this.mLastDragColumn && i10 == BoardView.this.mLastDragRow) ? false : true;
                    if (BoardView.this.mBoardListener != null && z10) {
                        int unused = BoardView.this.mLastDragColumn = access$800;
                        int unused2 = BoardView.this.mLastDragRow = i10;
                        BoardView.this.mBoardListener.onItemChangedPosition(BoardView.this.mDragStartColumn, BoardView.this.mDragStartRow, access$800, i10);
                    }
                }
            });
            dragItemRecyclerView.setDragItemCallback(new DragItemRecyclerView.DragItemCallback() {
                public boolean canDragItemAtPosition(int i10) {
                    return BoardView.this.mBoardCallback == null || BoardView.this.mBoardCallback.canDragItemAtPosition(BoardView.this.getColumnOfList(dragItemRecyclerView), i10);
                }

                public boolean canDropItemAtPosition(int i10) {
                    return BoardView.this.mBoardCallback == null || BoardView.this.mBoardCallback.canDropItemAtPosition(BoardView.this.mDragStartColumn, BoardView.this.mDragStartRow, BoardView.this.getColumnOfList(dragItemRecyclerView), i10);
                }
            });
            DragItemAdapter dragItemAdapter = columnProperties.getDragItemAdapter();
            dragItemAdapter.setDragStartedListener(new DragItemAdapter.DragStartCallback() {
                public boolean isDragging() {
                    return dragItemRecyclerView.isDragging();
                }

                public boolean startDrag(View view, long j10) {
                    DragItemRecyclerView dragItemRecyclerView = dragItemRecyclerView;
                    return dragItemRecyclerView.startDrag(view, j10, BoardView.this.getRelativeViewTouchX((View) dragItemRecyclerView.getParent()), BoardView.this.getRelativeViewTouchY(dragItemRecyclerView));
                }
            });
            dragItemRecyclerView.setAdapter(dragItemAdapter);
            dragItemRecyclerView.setDragEnabled(this.mDragEnabled);
            dragItemRecyclerView.setBackgroundDrawable(columnProperties.getColumnBackgroundDrawable());
            Integer columnWidth = columnProperties.getColumnWidth();
            if (columnWidth != null) {
                i11 = columnWidth.intValue();
            } else {
                i11 = this.mColumnWidth;
            }
            Integer valueOf = Integer.valueOf(i11);
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setBackgroundColor(columnProperties.getColumnBackgroundColor());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(valueOf.intValue(), -1));
            View header = columnProperties.getHeader();
            if (header == null) {
                header = new View(getContext());
                header.setVisibility(8);
            }
            linearLayout.addView(header);
            this.mHeaders.add(header);
            linearLayout.addView(dragItemRecyclerView);
            this.mLists.add(i10, dragItemRecyclerView);
            View footer = columnProperties.getFooter();
            if (footer == null) {
                footer = new View(getContext());
                footer.setVisibility(8);
            }
            linearLayout.addView(footer);
            this.mFooters.add(footer);
            this.mColumnLayout.addView(linearLayout, i10);
            updateBoardSpaces();
            setupColumnDragListener(columnProperties.getColumnDragView(), dragItemRecyclerView);
            return dragItemRecyclerView;
        }
        throw new IllegalArgumentException("Index is out of bounds");
    }

    private void endDragColumn() {
        DragItem dragItem = this.mDragColumn;
        dragItem.endDrag(dragItem.getRealDragView(), new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BoardView.this.mDragColumn.getRealDragView().setAlpha(1.0f);
                BoardView.this.mDragColumn.hide();
                BoardView.this.mRootLayout.removeView(BoardView.this.mDragColumn.getDragItemView());
                if (BoardView.this.mBoardListener != null) {
                    BoardListener access$500 = BoardView.this.mBoardListener;
                    int access$600 = BoardView.this.mDragColumnStartPosition;
                    BoardView boardView = BoardView.this;
                    access$500.onColumnDragEnded(access$600, boardView.getColumnOfList(boardView.mCurrentRecyclerView));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getClosestSnapColumn() {
        /*
            r8 = this;
            r0 = 0
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            r3 = 0
        L_0x0006:
            java.util.ArrayList<com.woxthebox.draglistview.DragItemRecyclerView> r4 = r8.mLists
            int r4 = r4.size()
            if (r2 >= r4) goto L_0x006c
            java.util.ArrayList<com.woxthebox.draglistview.DragItemRecyclerView> r4 = r8.mLists
            java.lang.Object r4 = r4.get(r2)
            com.woxthebox.draglistview.DragItemRecyclerView r4 = (com.woxthebox.draglistview.DragItemRecyclerView) r4
            android.view.ViewParent r4 = r4.getParent()
            android.view.View r4 = (android.view.View) r4
            int[] r5 = com.woxthebox.draglistview.BoardView.AnonymousClass8.$SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition
            com.woxthebox.draglistview.BoardView$ColumnSnapPosition r6 = r8.mSnapPosition
            int r6 = r6.ordinal()
            r5 = r5[r6]
            r6 = 1
            if (r5 == r6) goto L_0x0058
            r6 = 2
            if (r5 == r6) goto L_0x0040
            r6 = 3
            if (r5 == r6) goto L_0x0031
            r4 = 0
            goto L_0x0065
        L_0x0031:
            int r5 = r8.getScrollX()
            int r6 = r8.getMeasuredWidth()
            int r6 = r6 + r5
            int r4 = r4.getRight()
            int r4 = r4 - r6
            goto L_0x0061
        L_0x0040:
            int r5 = r8.getScrollX()
            int r7 = r8.getMeasuredWidth()
            int r7 = r7 / r6
            int r7 = r7 + r5
            int r4 = r4.getLeft()
            int r5 = r8.mColumnWidth
            int r5 = r5 / r6
            int r5 = r5 + r4
            int r5 = r5 - r7
            int r4 = java.lang.Math.abs(r5)
            goto L_0x0065
        L_0x0058:
            int r5 = r8.getScrollX()
            int r4 = r4.getLeft()
            int r4 = r4 - r5
        L_0x0061:
            int r4 = java.lang.Math.abs(r4)
        L_0x0065:
            if (r4 >= r1) goto L_0x0069
            r3 = r2
            r1 = r4
        L_0x0069:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.BoardView.getClosestSnapColumn():int");
    }

    /* access modifiers changed from: private */
    public int getColumnOfList(DragItemRecyclerView dragItemRecyclerView) {
        int i10 = 0;
        for (int i11 = 0; i11 < this.mLists.size(); i11++) {
            if (this.mLists.get(i11) == dragItemRecyclerView) {
                i10 = i11;
            }
        }
        return i10;
    }

    private int getCurrentColumn(float f10) {
        for (int i10 = 0; i10 < this.mLists.size(); i10++) {
            View view = (View) this.mLists.get(i10).getParent();
            if (((float) view.getLeft()) <= f10 && ((float) view.getRight()) > f10) {
                return i10;
            }
        }
        return 0;
    }

    private DragItemRecyclerView getCurrentRecyclerView(float f10) {
        Iterator<DragItemRecyclerView> it = this.mLists.iterator();
        while (it.hasNext()) {
            DragItemRecyclerView next = it.next();
            View view = (View) next.getParent();
            if (((float) view.getLeft()) <= f10 && ((float) view.getRight()) > f10) {
                return next;
            }
        }
        return this.mCurrentRecyclerView;
    }

    /* access modifiers changed from: private */
    public float getRelativeViewTouchX(View view) {
        return (this.mTouchX + ((float) getScrollX())) - ((float) view.getLeft());
    }

    /* access modifiers changed from: private */
    public float getRelativeViewTouchY(View view) {
        return this.mTouchY - ((float) view.getTop());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r5 != 3) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.util.ArrayList<com.woxthebox.draglistview.DragItemRecyclerView> r0 = r4.mLists
            int r0 = r0.size()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            float r0 = r5.getX()
            r4.mTouchX = r0
            float r0 = r5.getY()
            r4.mTouchY = r0
            boolean r0 = r4.isDragging()
            r2 = 3
            r3 = 1
            if (r0 == 0) goto L_0x005d
            int r5 = r5.getAction()
            if (r5 == r3) goto L_0x0036
            r0 = 2
            if (r5 == r0) goto L_0x002a
            if (r5 == r2) goto L_0x0036
            goto L_0x005c
        L_0x002a:
            com.woxthebox.draglistview.AutoScroller r5 = r4.mAutoScroller
            boolean r5 = r5.isAutoScrolling()
            if (r5 != 0) goto L_0x005c
            r4.updateScrollPosition()
            goto L_0x005c
        L_0x0036:
            com.woxthebox.draglistview.AutoScroller r5 = r4.mAutoScroller
            r5.stopAutoScroll()
            boolean r5 = r4.isDraggingColumn()
            if (r5 == 0) goto L_0x0045
            r4.endDragColumn()
            goto L_0x004a
        L_0x0045:
            com.woxthebox.draglistview.DragItemRecyclerView r5 = r4.mCurrentRecyclerView
            r5.onDragEnded()
        L_0x004a:
            boolean r5 = r4.snapToColumnWhenScrolling()
            if (r5 == 0) goto L_0x0059
            com.woxthebox.draglistview.DragItemRecyclerView r5 = r4.mCurrentRecyclerView
            int r5 = r4.getColumnOfList(r5)
            r4.scrollToColumn(r5, r3)
        L_0x0059:
            r4.invalidate()
        L_0x005c:
            return r3
        L_0x005d:
            boolean r0 = r4.snapToColumnWhenScrolling()
            if (r0 == 0) goto L_0x006c
            android.view.GestureDetector r0 = r4.mGestureDetector
            boolean r0 = r0.onTouchEvent(r5)
            if (r0 == 0) goto L_0x006c
            return r3
        L_0x006c:
            int r5 = r5.getAction()
            if (r5 == 0) goto L_0x0085
            if (r5 == r3) goto L_0x0077
            if (r5 == r2) goto L_0x0077
            goto L_0x0092
        L_0x0077:
            boolean r5 = r4.snapToColumnWhenScrolling()
            if (r5 == 0) goto L_0x0092
            int r5 = r4.getClosestSnapColumn()
            r4.scrollToColumn(r5, r3)
            goto L_0x0092
        L_0x0085:
            android.widget.Scroller r5 = r4.mScroller
            boolean r5 = r5.isFinished()
            if (r5 != 0) goto L_0x0092
            android.widget.Scroller r5 = r4.mScroller
            r5.forceFinished(r3)
        L_0x0092:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.BoardView.handleTouchEvent(android.view.MotionEvent):boolean");
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BoardView);
        this.mColumnSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoardView_columnSpacing, 0);
        this.mBoardEdge = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BoardView_boardEdges, 0);
        obtainStyledAttributes.recycle();
    }

    private boolean isDragging() {
        DragItemRecyclerView dragItemRecyclerView = this.mCurrentRecyclerView;
        return dragItemRecyclerView != null && (dragItemRecyclerView.isDragging() || isDraggingColumn());
    }

    private boolean isDraggingColumn() {
        return this.mCurrentRecyclerView != null && this.mDragColumn.isDragging();
    }

    private void moveColumn(int i10, int i11) {
        this.mLists.add(i11, this.mLists.remove(i10));
        this.mHeaders.add(i11, this.mHeaders.remove(i10));
        this.mFooters.add(i11, this.mFooters.remove(i10));
        final View childAt = this.mColumnLayout.getChildAt(i10);
        final View childAt2 = this.mColumnLayout.getChildAt(i11);
        this.mColumnLayout.removeViewAt(i10);
        this.mColumnLayout.addView(childAt, i11);
        updateBoardSpaces();
        this.mColumnLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
                BoardView.this.mColumnLayout.removeOnLayoutChangeListener(this);
                View view2 = childAt2;
                view2.setTranslationX((view2.getTranslationX() + ((float) childAt.getLeft())) - ((float) childAt2.getLeft()));
                childAt2.animate().translationX(0.0f).setDuration(350).start();
            }
        });
        BoardListener boardListener = this.mBoardListener;
        if (boardListener != null) {
            boardListener.onColumnDragChangedPosition(i10, i11);
        }
    }

    private void setupColumnDragListener(View view, final DragItemRecyclerView dragItemRecyclerView) {
        if (view != null) {
            view.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (BoardView.this.mBoardCallback != null && !BoardView.this.mBoardCallback.canDragColumnAtPosition(BoardView.this.getColumnOfList(dragItemRecyclerView))) {
                        return false;
                    }
                    BoardView boardView = BoardView.this;
                    boardView.startDragColumn(dragItemRecyclerView, boardView.mTouchX, BoardView.this.mTouchY);
                    return true;
                }
            });
        }
    }

    private boolean snapToColumnWhenDragging() {
        boolean z10 = getResources().getConfiguration().orientation == 1;
        if (this.mSnapToColumnWhenDragging) {
            return z10 || this.mSnapToColumnInLandscape;
        }
        return false;
    }

    private boolean snapToColumnWhenScrolling() {
        boolean z10 = getResources().getConfiguration().orientation == 1;
        if (this.mSnapToColumnWhenScrolling) {
            return z10 || this.mSnapToColumnInLandscape;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void startDragColumn(DragItemRecyclerView dragItemRecyclerView, float f10, float f11) {
        this.mDragColumnStartScrollX = (float) getScrollX();
        this.mCurrentRecyclerView = dragItemRecyclerView;
        View childAt = this.mColumnLayout.getChildAt(getColumnOfList(dragItemRecyclerView));
        this.mDragColumn.startDrag(childAt, f10, f11);
        this.mRootLayout.addView(this.mDragColumn.getDragItemView());
        childAt.setAlpha(0.0f);
        if (this.mBoardListener != null) {
            int columnOfList = getColumnOfList(this.mCurrentRecyclerView);
            this.mDragColumnStartPosition = columnOfList;
            this.mBoardListener.onColumnDragStarted(columnOfList);
        }
    }

    private void updateBoardSpaces() {
        int columnCount = getColumnCount();
        int i10 = this.mColumnSpacing / 2;
        for (int i11 = 0; i11 < columnCount; i11++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mColumnLayout.getChildAt(i11).getLayoutParams();
            if (i11 == 0) {
                layoutParams.leftMargin = this.mBoardEdge;
            } else {
                int i12 = columnCount - 1;
                layoutParams.leftMargin = i10;
                if (i11 == i12) {
                    layoutParams.rightMargin = this.mBoardEdge;
                }
            }
            layoutParams.rightMargin = i10;
        }
    }

    private void updateScrollPosition() {
        AutoScroller autoScroller;
        AutoScroller.ScrollDirection scrollDirection;
        Object removeDragItemAndEnd;
        if (isDraggingColumn()) {
            DragItemRecyclerView currentRecyclerView = getCurrentRecyclerView(this.mTouchX + ((float) getScrollX()));
            DragItemRecyclerView dragItemRecyclerView = this.mCurrentRecyclerView;
            if (dragItemRecyclerView != currentRecyclerView) {
                int columnOfList = getColumnOfList(dragItemRecyclerView);
                int columnOfList2 = getColumnOfList(currentRecyclerView);
                BoardCallback boardCallback = this.mBoardCallback;
                if (boardCallback == null || boardCallback.canDropColumnAtPosition(columnOfList, columnOfList2)) {
                    moveColumn(columnOfList, columnOfList2);
                }
            }
            this.mDragColumn.setPosition((this.mTouchX + ((float) getScrollX())) - this.mDragColumnStartScrollX, this.mTouchY);
        } else {
            DragItemRecyclerView currentRecyclerView2 = getCurrentRecyclerView(this.mTouchX + ((float) getScrollX()));
            DragItemRecyclerView dragItemRecyclerView2 = this.mCurrentRecyclerView;
            if (dragItemRecyclerView2 != currentRecyclerView2) {
                int columnOfList3 = getColumnOfList(dragItemRecyclerView2);
                int columnOfList4 = getColumnOfList(currentRecyclerView2);
                long dragItemId = this.mCurrentRecyclerView.getDragItemId();
                int dragPositionForY = currentRecyclerView2.getDragPositionForY(getRelativeViewTouchY(currentRecyclerView2));
                BoardCallback boardCallback2 = this.mBoardCallback;
                if ((boardCallback2 == null || boardCallback2.canDropItemAtPosition(this.mDragStartColumn, this.mDragStartRow, columnOfList4, dragPositionForY)) && (removeDragItemAndEnd = this.mCurrentRecyclerView.removeDragItemAndEnd()) != null) {
                    this.mCurrentRecyclerView = currentRecyclerView2;
                    currentRecyclerView2.addDragItemAndStart(getRelativeViewTouchY(currentRecyclerView2), removeDragItemAndEnd, dragItemId);
                    this.mDragItem.setOffset((float) ((View) this.mCurrentRecyclerView.getParent()).getLeft(), (float) this.mCurrentRecyclerView.getTop());
                    BoardListener boardListener = this.mBoardListener;
                    if (boardListener != null) {
                        boardListener.onItemChangedColumn(columnOfList3, columnOfList4);
                    }
                }
            }
            DragItemRecyclerView dragItemRecyclerView3 = this.mCurrentRecyclerView;
            dragItemRecyclerView3.onDragging(getRelativeViewTouchX((View) dragItemRecyclerView3.getParent()), getRelativeViewTouchY(this.mCurrentRecyclerView));
        }
        boolean z10 = true;
        if (getResources().getConfiguration().orientation != 1) {
            z10 = false;
        }
        float f10 = ((float) getResources().getDisplayMetrics().widthPixels) * (z10 ? 0.06f : 0.14f);
        if (this.mTouchX > ((float) getWidth()) - f10 && getScrollX() < this.mColumnLayout.getWidth()) {
            autoScroller = this.mAutoScroller;
            scrollDirection = AutoScroller.ScrollDirection.LEFT;
        } else if (this.mTouchX >= f10 || getScrollX() <= 0) {
            this.mAutoScroller.stopAutoScroll();
            invalidate();
        } else {
            autoScroller = this.mAutoScroller;
            scrollDirection = AutoScroller.ScrollDirection.RIGHT;
        }
        autoScroller.startAutoScroll(scrollDirection);
        invalidate();
    }

    public DragItemRecyclerView addColumn(DragItemAdapter dragItemAdapter, View view, View view2, boolean z10) {
        getContext();
        return addColumn(dragItemAdapter, view, view2, z10, new LinearLayoutManager(1));
    }

    public void addItem(int i10, int i11, Object obj, boolean z10) {
        if (!isDragging() && this.mLists.size() > i10 && this.mLists.get(i10).getAdapter().getItemCount() >= i11) {
            ((DragItemAdapter) this.mLists.get(i10).getAdapter()).addItem(i11, obj);
            if (z10) {
                scrollToItem(i10, i11, false);
            }
        }
    }

    public void clearBoard() {
        for (int size = this.mLists.size() - 1; size >= 0; size--) {
            this.mColumnLayout.removeViewAt(size);
            this.mHeaders.remove(size);
            this.mFooters.remove(size);
            this.mLists.remove(size);
        }
    }

    public void computeScroll() {
        float f10;
        float f11;
        DragItem dragItem;
        if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (!(getScrollX() == currX && getScrollY() == currY)) {
                scrollTo(currX, currY);
            }
            if (this.mAutoScroller.isAutoScrolling() && isDragging()) {
                if (isDraggingColumn()) {
                    dragItem = this.mDragColumn;
                    f11 = (this.mTouchX + ((float) getScrollX())) - this.mDragColumnStartScrollX;
                    f10 = this.mTouchY;
                } else {
                    dragItem = this.mDragItem;
                    f11 = getRelativeViewTouchX((View) this.mCurrentRecyclerView.getParent());
                    f10 = getRelativeViewTouchY(this.mCurrentRecyclerView);
                }
                dragItem.setPosition(f11, f10);
            }
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        } else if (!snapToColumnWhenScrolling()) {
            super.computeScroll();
        }
    }

    public DragItemAdapter getAdapter(int i10) {
        if (i10 < 0 || i10 >= this.mLists.size()) {
            return null;
        }
        return (DragItemAdapter) this.mLists.get(i10).getAdapter();
    }

    public int getColumnCount() {
        return this.mLists.size();
    }

    public int getColumnOfFooter(View view) {
        for (int i10 = 0; i10 < this.mFooters.size(); i10++) {
            if (this.mFooters.get(i10) == view) {
                return i10;
            }
        }
        return -1;
    }

    public int getColumnOfHeader(View view) {
        for (int i10 = 0; i10 < this.mHeaders.size(); i10++) {
            if (this.mHeaders.get(i10) == view) {
                return i10;
            }
        }
        return -1;
    }

    public int getFocusedColumn() {
        if (!snapToColumnWhenScrolling()) {
            return 0;
        }
        return this.mCurrentColumn;
    }

    public View getFooterView(int i10) {
        return this.mFooters.get(i10);
    }

    public View getHeaderView(int i10) {
        return this.mHeaders.get(i10);
    }

    public int getItemCount() {
        Iterator<DragItemRecyclerView> it = this.mLists.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += it.next().getAdapter().getItemCount();
        }
        return i10;
    }

    public RecyclerView getRecyclerView(int i10) {
        if (i10 < 0 || i10 >= this.mLists.size()) {
            return null;
        }
        return this.mLists.get(i10);
    }

    public DragItemRecyclerView insertColumn(DragItemAdapter dragItemAdapter, int i10, View view, View view2, boolean z10) {
        getContext();
        return insertColumn(dragItemAdapter, i10, view, view2, z10, new LinearLayoutManager(1));
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void moveItem(int i10, int i11, int i12, int i13, boolean z10) {
        if (!isDragging() && this.mLists.size() > i10 && this.mLists.get(i10).getAdapter().getItemCount() > i11 && this.mLists.size() > i12 && this.mLists.get(i12).getAdapter().getItemCount() >= i13) {
            ((DragItemAdapter) this.mLists.get(i12).getAdapter()).addItem(i13, ((DragItemAdapter) this.mLists.get(i10).getAdapter()).removeItem(i11));
            if (z10) {
                scrollToItem(i12, i13, false);
            }
        }
    }

    public void onAutoScrollColumnBy(int i10) {
        if (isDragging()) {
            int i11 = this.mCurrentColumn + i10;
            if (i10 != 0 && i11 >= 0 && i11 < this.mLists.size()) {
                scrollToColumn(i11, true);
            }
            updateScrollPosition();
            return;
        }
        this.mAutoScroller.stopAutoScroll();
    }

    public void onAutoScrollPositionBy(int i10, int i11) {
        if (isDragging()) {
            scrollBy(i10, i11);
            updateScrollPosition();
            return;
        }
        this.mAutoScroller.stopAutoScroll();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        Resources resources = getResources();
        boolean z10 = true;
        if (resources.getConfiguration().orientation != 1) {
            z10 = false;
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        this.mColumnWidth = z10 ? (int) (((double) displayMetrics.widthPixels) * 0.87d) : (int) (displayMetrics.density * 320.0f);
        this.mGestureDetector = new GestureDetector(getContext(), new GestureListener());
        this.mScroller = new Scroller(getContext(), new DecelerateInterpolator(1.1f));
        AutoScroller autoScroller = new AutoScroller(getContext(), this);
        this.mAutoScroller = autoScroller;
        autoScroller.setAutoScrollMode(snapToColumnWhenDragging() ? AutoScroller.AutoScrollMode.COLUMN : AutoScroller.AutoScrollMode.POSITION);
        this.mDragItem = new DragItem(getContext());
        DragItem dragItem = new DragItem(getContext());
        this.mDragColumn = dragItem;
        dragItem.setSnapToTouch(false);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mRootLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.mColumnLayout = linearLayout;
        linearLayout.setOrientation(0);
        this.mColumnLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        this.mColumnLayout.setMotionEventSplittingEnabled(false);
        this.mRootLayout.addView(this.mColumnLayout);
        this.mRootLayout.addView(this.mDragItem.getDragItemView());
        addView(this.mRootLayout);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return handleTouchEvent(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        SavedState savedState;
        super.onLayout(z10, i10, i11, i12, i13);
        updateBoardSpaces();
        if (!this.mHasLaidOut && (savedState = this.mSavedState) != null) {
            this.mCurrentColumn = savedState.currentColumn;
            this.mSavedState = null;
            post(new Runnable() {
                public void run() {
                    BoardView boardView = BoardView.this;
                    boardView.scrollToColumn(boardView.mCurrentColumn, false);
                }
            });
        }
        this.mHasLaidOut = true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), snapToColumnWhenScrolling() ? this.mCurrentColumn : getClosestSnapColumn());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return handleTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void removeColumn(int i10) {
        if (i10 >= 0 && this.mLists.size() > i10) {
            this.mColumnLayout.removeViewAt(i10);
            this.mHeaders.remove(i10);
            this.mFooters.remove(i10);
            this.mLists.remove(i10);
            updateBoardSpaces();
        }
    }

    public void removeItem(int i10, int i11) {
        if (!isDragging() && this.mLists.size() > i10 && this.mLists.get(i10).getAdapter().getItemCount() > i11) {
            ((DragItemAdapter) this.mLists.get(i10).getAdapter()).removeItem(i11);
        }
    }

    public void replaceItem(int i10, int i11, Object obj, boolean z10) {
        if (!isDragging() && this.mLists.size() > i10 && this.mLists.get(i10).getAdapter().getItemCount() > i11) {
            DragItemAdapter dragItemAdapter = (DragItemAdapter) this.mLists.get(i10).getAdapter();
            dragItemAdapter.removeItem(i11);
            dragItemAdapter.addItem(i11, obj);
            if (z10) {
                scrollToItem(i10, i11, false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scrollToColumn(int r11, boolean r12) {
        /*
            r10 = this;
            java.util.ArrayList<com.woxthebox.draglistview.DragItemRecyclerView> r0 = r10.mLists
            int r0 = r0.size()
            if (r0 > r11) goto L_0x0009
            return
        L_0x0009:
            java.util.ArrayList<com.woxthebox.draglistview.DragItemRecyclerView> r0 = r10.mLists
            java.lang.Object r0 = r0.get(r11)
            com.woxthebox.draglistview.DragItemRecyclerView r0 = (com.woxthebox.draglistview.DragItemRecyclerView) r0
            android.view.ViewParent r0 = r0.getParent()
            android.view.View r0 = (android.view.View) r0
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int[] r2 = com.woxthebox.draglistview.BoardView.AnonymousClass8.$SwitchMap$com$woxthebox$draglistview$BoardView$ColumnSnapPosition
            com.woxthebox.draglistview.BoardView$ColumnSnapPosition r3 = r10.mSnapPosition
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 1
            r4 = 0
            if (r2 == r3) goto L_0x0058
            r5 = 2
            if (r2 == r5) goto L_0x003f
            r5 = 3
            if (r2 == r5) goto L_0x0033
            r0 = 0
            goto L_0x005f
        L_0x0033:
            int r0 = r0.getRight()
            int r1 = r1.rightMargin
            int r0 = r0 + r1
            int r1 = r10.getMeasuredWidth()
            goto L_0x005e
        L_0x003f:
            int r2 = r10.getMeasuredWidth()
            int r6 = r0.getMeasuredWidth()
            int r2 = r2 - r6
            int r6 = r1.leftMargin
            int r2 = r2 - r6
            int r6 = r1.rightMargin
            int r2 = r2 - r6
            int r2 = r2 / r5
            int r0 = r0.getLeft()
            int r1 = r1.leftMargin
            int r0 = r0 - r1
            int r0 = r0 - r2
            goto L_0x005f
        L_0x0058:
            int r0 = r0.getLeft()
            int r1 = r1.leftMargin
        L_0x005e:
            int r0 = r0 - r1
        L_0x005f:
            android.widget.FrameLayout r1 = r10.mRootLayout
            int r1 = r1.getMeasuredWidth()
            int r2 = r10.getMeasuredWidth()
            int r1 = r1 - r2
            if (r0 >= 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = r0
        L_0x006e:
            if (r4 <= r1) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r1 = r4
        L_0x0072:
            int r0 = r10.getScrollX()
            if (r0 == r1) goto L_0x00a2
            android.widget.Scroller r0 = r10.mScroller
            r0.forceFinished(r3)
            if (r12 == 0) goto L_0x009b
            android.widget.Scroller r4 = r10.mScroller
            int r5 = r10.getScrollX()
            int r6 = r10.getScrollY()
            int r12 = r10.getScrollX()
            int r7 = r1 - r12
            r8 = 0
            r9 = 325(0x145, float:4.55E-43)
            r4.startScroll(r5, r6, r7, r8, r9)
            java.util.WeakHashMap r12 = m0.c1.f10054a
            m0.i0.k(r10)
            goto L_0x00a2
        L_0x009b:
            int r12 = r10.getScrollY()
            r10.scrollTo(r1, r12)
        L_0x00a2:
            int r12 = r10.mCurrentColumn
            r10.mCurrentColumn = r11
            com.woxthebox.draglistview.BoardView$BoardListener r0 = r10.mBoardListener
            if (r0 == 0) goto L_0x00af
            if (r12 == r11) goto L_0x00af
            r0.onFocusedColumnChanged(r12, r11)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.BoardView.scrollToColumn(int, boolean):void");
    }

    public void scrollToItem(int i10, int i11, boolean z10) {
        if (!isDragging() && this.mLists.size() > i10 && this.mLists.get(i10).getAdapter().getItemCount() > i11) {
            this.mScroller.forceFinished(true);
            scrollToColumn(i10, z10);
            if (z10) {
                this.mLists.get(i10).smoothScrollToPosition(i11);
            } else {
                this.mLists.get(i10).scrollToPosition(i11);
            }
        }
    }

    public void setBoardCallback(BoardCallback boardCallback) {
        this.mBoardCallback = boardCallback;
    }

    public void setBoardEdge(int i10) {
        this.mBoardEdge = i10;
        updateBoardSpaces();
    }

    public void setBoardListener(BoardListener boardListener) {
        this.mBoardListener = boardListener;
    }

    public void setColumnSnapPosition(ColumnSnapPosition columnSnapPosition) {
        this.mSnapPosition = columnSnapPosition;
    }

    public void setColumnSpacing(int i10) {
        this.mColumnSpacing = i10;
        updateBoardSpaces();
    }

    public void setColumnWidth(int i10) {
        this.mColumnWidth = i10;
    }

    public void setCustomColumnDragItem(DragItem dragItem) {
        DragItem dragItem2 = dragItem != null ? dragItem : new DragItem(getContext());
        if (dragItem == null) {
            dragItem2.setSnapToTouch(false);
        }
        this.mDragColumn = dragItem2;
    }

    public void setCustomDragItem(DragItem dragItem) {
        DragItem dragItem2 = dragItem != null ? dragItem : new DragItem(getContext());
        if (dragItem == null) {
            dragItem2.setSnapToTouch(true);
        }
        this.mDragItem = dragItem2;
        this.mRootLayout.removeViewAt(1);
        this.mRootLayout.addView(this.mDragItem.getDragItemView());
    }

    public void setDragEnabled(boolean z10) {
        this.mDragEnabled = z10;
        if (this.mLists.size() > 0) {
            Iterator<DragItemRecyclerView> it = this.mLists.iterator();
            while (it.hasNext()) {
                it.next().setDragEnabled(this.mDragEnabled);
            }
        }
    }

    public void setSnapDragItemToTouch(boolean z10) {
        this.mDragItem.setSnapToTouch(z10);
    }

    public void setSnapToColumnInLandscape(boolean z10) {
        this.mSnapToColumnInLandscape = z10;
        this.mAutoScroller.setAutoScrollMode(snapToColumnWhenDragging() ? AutoScroller.AutoScrollMode.COLUMN : AutoScroller.AutoScrollMode.POSITION);
    }

    public void setSnapToColumnWhenDragging(boolean z10) {
        this.mSnapToColumnWhenDragging = z10;
        this.mAutoScroller.setAutoScrollMode(snapToColumnWhenDragging() ? AutoScroller.AutoScrollMode.COLUMN : AutoScroller.AutoScrollMode.POSITION);
    }

    public void setSnapToColumnsWhenScrolling(boolean z10) {
        this.mSnapToColumnWhenScrolling = z10;
    }

    public BoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public int getItemCount(int i10) {
        if (this.mLists.size() > i10) {
            return this.mLists.get(i10).getAdapter().getItemCount();
        }
        return 0;
    }

    public void moveItem(long j10, int i10, int i11, boolean z10) {
        for (int i12 = 0; i12 < this.mLists.size(); i12++) {
            g1 adapter = this.mLists.get(i12).getAdapter();
            int itemCount = adapter.getItemCount();
            for (int i13 = 0; i13 < itemCount; i13++) {
                if (adapter.getItemId(i13) == j10) {
                    moveItem(i12, i13, i10, i11, z10);
                    return;
                }
            }
        }
    }

    public BoardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(attributeSet);
    }

    public DragItemRecyclerView addColumn(DragItemAdapter dragItemAdapter, View view, View view2, boolean z10, q1 q1Var) {
        return addColumnTo(getColumnCount(), ColumnProperties.Builder.newBuilder(dragItemAdapter).setHeader(view).setColumnDragView(view2).setHasFixedItemSize(z10).setLayoutManager(q1Var).build());
    }

    public DragItemRecyclerView insertColumn(DragItemAdapter dragItemAdapter, int i10, View view, View view2, boolean z10, q1 q1Var) {
        return addColumnTo(i10, ColumnProperties.Builder.newBuilder(dragItemAdapter).setHeader(view).setColumnDragView(view2).setHasFixedItemSize(z10).setLayoutManager(q1Var).build());
    }

    public void addColumn(ColumnProperties columnProperties) {
        addColumnTo(getColumnCount(), columnProperties);
    }

    public void insertColumn(int i10, ColumnProperties columnProperties) {
        addColumnTo(i10, columnProperties);
    }
}
