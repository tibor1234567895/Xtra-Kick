package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.woxthebox.draglistview.R;
import h4.g;
import hb.h0;
import i0.m;
import i0.n;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import l0.f;
import m0.c1;
import m0.i0;
import m0.o0;
import m0.t;
import m0.u;
import ma.r;
import n0.b;
import q.k;
import s0.a;

public class RecyclerView extends ViewGroup implements t {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    static final boolean DEBUG = false;
    private static final float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final h2 sDefaultEdgeEffectFactory = new h2();
    static final Interpolator sQuinticInterpolator = new d1();
    m2 mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    g1 mAdapter;
    b mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private j1 mChildDrawingOrderCallback;
    k mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private k1 mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    k0 mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private u1 mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    n1 mItemAnimator;
    private l1 mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<o1> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    q1 mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final a2 mObserver;
    private List<s1> mOnChildAttachStateListeners;
    private t1 mOnFlingListener;
    private final ArrayList<u1> mOnItemTouchListeners;
    final List<k2> mPendingAccessibilityImportanceChange;
    c2 mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    i0 mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final y1 mRecycler;
    z1 mRecyclerListener;
    final List<z1> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private v1 mScrollListener;
    private List<v1> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private u mScrollingChildHelper;
    final g2 mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final j2 mViewFlinger;
    private final c3 mViewInfoProcessCallback;
    final d3 mViewInfoStore;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            int[] r1 = new int[r0]
            r2 = 16843830(0x1010436, float:2.369658E-38)
            r3 = 0
            r1[r3] = r2
            NESTED_SCROLLING_ATTRS = r1
            r1 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r1 = java.lang.Math.log(r1)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r1 = r1 / r4
            float r1 = (float) r1
            DECELERATION_RATE = r1
            int r1 = android.os.Build.VERSION.SDK_INT
            FORCE_INVALIDATE_DISPLAY_LIST = r3
            r2 = 23
            if (r1 < r2) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r1
            POST_UPDATES_ON_ANIMATION = r0
            ALLOW_THREAD_GAP_WORK = r0
            FORCE_ABS_FOCUS_SEARCH_DIRECTION = r3
            IGNORE_DETACHED_FOCUSED_CHILD = r3
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r1[r3] = r2
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r1[r0] = r2
            java.lang.Class r0 = java.lang.Integer.TYPE
            r2 = 2
            r1[r2] = r0
            r2 = 3
            r1[r2] = r0
            LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = r1
            androidx.recyclerview.widget.d1 r0 = new androidx.recyclerview.widget.d1
            r0.<init>()
            sQuinticInterpolator = r0
            androidx.recyclerview.widget.h2 r0 = new androidx.recyclerview.widget.h2
            r0.<init>()
            sDefaultEdgeEffectFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public static int b(int i10, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i11) {
        if (i10 > 0 && edgeEffect != null && h0.e0(edgeEffect) != DECELERATION_RATE) {
            int round = Math.round(h0.i1(edgeEffect, (((float) (-i10)) * FLING_DESTRETCH_FACTOR) / ((float) i11), 0.5f) * (((float) (-i11)) / FLING_DESTRETCH_FACTOR));
            if (round != i10) {
                edgeEffect.finish();
            }
            return i10 - round;
        } else if (i10 >= 0 || edgeEffect2 == null || h0.e0(edgeEffect2) == DECELERATION_RATE) {
            return i10;
        } else {
            float f10 = (float) i11;
            float f11 = (((float) i10) * FLING_DESTRETCH_FACTOR) / f10;
            int round2 = Math.round(h0.i1(edgeEffect2, f11, 0.5f) * (f10 / FLING_DESTRETCH_FACTOR));
            if (round2 != i10) {
                edgeEffect2.finish();
            }
            return i10 - round2;
        }
    }

    public static void clearNestedRecyclerViewIfNotNested(k2 k2Var) {
        Reference reference = k2Var.mNestedRecyclerView;
        if (reference != null) {
            Object obj = reference.get();
            while (true) {
                View view = (View) obj;
                while (true) {
                    if (view == null) {
                        k2Var.mNestedRecyclerView = null;
                        return;
                    } else if (view != k2Var.itemView) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i10));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    public static k2 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((r1) view.getLayoutParams()).f2184h;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        r1 r1Var = (r1) view.getLayoutParams();
        Rect rect2 = r1Var.f2185i;
        rect.set((view.getLeft() - rect2.left) - r1Var.leftMargin, (view.getTop() - rect2.top) - r1Var.topMargin, view.getRight() + rect2.right + r1Var.rightMargin, view.getBottom() + rect2.bottom + r1Var.bottomMargin);
    }

    private u getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new u(this);
        }
        return this.mScrollingChildHelper;
    }

    private int l(int i10, float f10) {
        float i12;
        EdgeEffect edgeEffect;
        float width = f10 / ((float) getWidth());
        float height = ((float) i10) / ((float) getHeight());
        EdgeEffect edgeEffect2 = this.mTopGlow;
        float f11 = DECELERATION_RATE;
        if (edgeEffect2 == null || h0.e0(edgeEffect2) == DECELERATION_RATE) {
            EdgeEffect edgeEffect3 = this.mBottomGlow;
            if (!(edgeEffect3 == null || h0.e0(edgeEffect3) == DECELERATION_RATE)) {
                if (canScrollVertically(1)) {
                    edgeEffect = this.mBottomGlow;
                } else {
                    i12 = h0.i1(this.mBottomGlow, height, 1.0f - width);
                    if (h0.e0(this.mBottomGlow) == DECELERATION_RATE) {
                        this.mBottomGlow.onRelease();
                    }
                    f11 = i12;
                    invalidate();
                }
            }
            return Math.round(f11 * ((float) getHeight()));
        } else if (canScrollVertically(-1)) {
            edgeEffect = this.mTopGlow;
        } else {
            i12 = -h0.i1(this.mTopGlow, -height, width);
            if (h0.e0(this.mTopGlow) == DECELERATION_RATE) {
                this.mTopGlow.onRelease();
            }
            f11 = i12;
            invalidate();
            return Math.round(f11 * ((float) getHeight()));
        }
        edgeEffect.onRelease();
        invalidate();
        return Math.round(f11 * ((float) getHeight()));
    }

    public final void a(k2 k2Var) {
        boolean z10;
        View view = k2Var.itemView;
        if (view.getParent() == this) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.mRecycler.n(getChildViewHolder(view));
        if (k2Var.isTmpDetached()) {
            this.mChildHelper.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        k kVar = this.mChildHelper;
        if (!z10) {
            kVar.a(view, -1, true);
            return;
        }
        int indexOfChild = kVar.f2063a.f1972a.indexOfChild(view);
        if (indexOfChild >= 0) {
            kVar.f2064b.h(indexOfChild);
            kVar.i(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public void absorbGlows(int i10, int i11) {
        if (i10 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i10);
            }
        } else if (i10 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i10);
            }
        }
        if (i11 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i11);
            }
        }
        if (i10 != 0 || i11 != 0) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.getClass();
        }
        super.addFocusables(arrayList, i10, i11);
    }

    public void addItemDecoration(o1 o1Var) {
        addItemDecoration(o1Var, -1);
    }

    public void addOnChildAttachStateChangeListener(s1 s1Var) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(s1Var);
    }

    public void addOnItemTouchListener(u1 u1Var) {
        this.mOnItemTouchListeners.add(u1Var);
    }

    public void addOnScrollListener(v1 v1Var) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(v1Var);
    }

    public void addRecyclerListener(z1 z1Var) {
        f.a("'listener' arg cannot be null.", z1Var != null);
        this.mRecyclerListeners.add(z1Var);
    }

    public void animateAppearance(k2 k2Var, m1 m1Var, m1 m1Var2) {
        k2Var.setIsRecyclable(false);
        if (this.mItemAnimator.a(k2Var, m1Var, m1Var2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(k2 k2Var, m1 m1Var, m1 m1Var2) {
        a(k2Var);
        k2Var.setIsRecyclable(false);
        if (this.mItemAnimator.c(k2Var, m1Var, m1Var2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException(h.h(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        throw new IllegalStateException(h.h(this, h.q(str)));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(h.h(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(h.h(this, new StringBuilder(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(k2 k2Var) {
        n1 n1Var = this.mItemAnimator;
        return n1Var == null || n1Var.g(k2Var, k2Var.getUnmodifiedPayloads());
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof r1) && this.mLayout.q((r1) layoutParams);
    }

    public void clearOldPositions() {
        int h10 = this.mChildHelper.h();
        for (int i10 = 0; i10 < h10; i10++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i10));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        y1 y1Var = this.mRecycler;
        ArrayList arrayList = y1Var.f2252c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((k2) arrayList.get(i11)).clearOldPosition();
        }
        ArrayList arrayList2 = y1Var.f2250a;
        int size2 = arrayList2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ((k2) arrayList2.get(i12)).clearOldPosition();
        }
        ArrayList arrayList3 = y1Var.f2251b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i13 = 0; i13 < size3; i13++) {
                ((k2) y1Var.f2251b.get(i13)).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<s1> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<v1> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.o()) {
            return this.mLayout.u(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.o()) {
            return this.mLayout.v(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.o()) {
            return this.mLayout.w(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.p()) {
            return this.mLayout.x(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.p()) {
            return this.mLayout.y(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        q1 q1Var = this.mLayout;
        if (q1Var != null && q1Var.p()) {
            return this.mLayout.z(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i10, int i11) {
        boolean z10;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i10 <= 0) {
            z10 = false;
        } else {
            this.mLeftGlow.onRelease();
            z10 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i10 < 0) {
            this.mRightGlow.onRelease();
            z10 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i11 > 0) {
            this.mTopGlow.onRelease();
            z10 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i11 < 0) {
            this.mBottomGlow.onRelease();
            z10 |= this.mBottomGlow.isFinished();
        }
        if (z10) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public int consumeFlingInHorizontalStretch(int i10) {
        return b(i10, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInVerticalStretch(int i10) {
        return b(i10, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        boolean z10;
        boolean z11;
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            int i10 = n.f7952a;
            m.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            m.b();
        } else if (this.mAdapterHelper.g()) {
            b bVar = this.mAdapterHelper;
            int i11 = bVar.f1938f;
            boolean z12 = false;
            if ((4 & i11) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if ((i11 & 11) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    int i12 = n.f7952a;
                    m.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.j();
                    if (!this.mLayoutWasDefered) {
                        int e10 = this.mChildHelper.e();
                        int i13 = 0;
                        while (true) {
                            if (i13 < e10) {
                                k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i13));
                                if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                                    z12 = true;
                                    break;
                                }
                                i13++;
                            } else {
                                break;
                            }
                        }
                        if (z12) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.b();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    m.b();
                }
            }
            if (bVar.g()) {
                int i14 = n.f7952a;
                m.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                m.b();
            }
        }
    }

    public final void d() {
        View view;
        k2 k2Var;
        boolean z10;
        boolean z11;
        int i10;
        int id;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f2026i = false;
        startInterceptRequestLayout();
        d3 d3Var = this.mViewInfoStore;
        d3Var.f1966a.clear();
        d3Var.f1967b.b();
        onEnterLayoutOrScroll();
        j();
        if (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        if (view == null) {
            k2Var = null;
        } else {
            k2Var = findContainingViewHolder(view);
        }
        long j10 = -1;
        if (k2Var == null) {
            g2 g2Var = this.mState;
            g2Var.f2030m = -1;
            g2Var.f2029l = -1;
            g2Var.f2031n = -1;
        } else {
            g2 g2Var2 = this.mState;
            if (this.mAdapter.hasStableIds()) {
                j10 = k2Var.getItemId();
            }
            g2Var2.f2030m = j10;
            g2 g2Var3 = this.mState;
            if (this.mDataSetHasChangedAfterLayout) {
                i10 = -1;
            } else if (k2Var.isRemoved()) {
                i10 = k2Var.mOldPosition;
            } else {
                i10 = k2Var.getAbsoluteAdapterPosition();
            }
            g2Var3.f2029l = i10;
            g2 g2Var4 = this.mState;
            View view2 = k2Var.itemView;
            loop0:
            while (true) {
                id = view2.getId();
                while (true) {
                    if (view2.isFocused() || !(view2 instanceof ViewGroup) || !view2.hasFocus()) {
                        g2Var4.f2031n = id;
                    } else {
                        view2 = ((ViewGroup) view2).getFocusedChild();
                        if (view2.getId() != -1) {
                        }
                    }
                }
            }
            g2Var4.f2031n = id;
        }
        g2 g2Var5 = this.mState;
        if (!g2Var5.f2027j || !this.mItemsChanged) {
            z10 = false;
        } else {
            z10 = true;
        }
        g2Var5.f2025h = z10;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        g2Var5.f2024g = g2Var5.f2028k;
        g2Var5.f2022e = this.mAdapter.getItemCount();
        g(this.mMinMaxLayoutPositions);
        if (this.mState.f2027j) {
            int e10 = this.mChildHelper.e();
            for (int i11 = 0; i11 < e10; i11++) {
                k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i11));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    n1 n1Var = this.mItemAnimator;
                    n1.e(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    n1Var.getClass();
                    m1 m1Var = new m1();
                    View view3 = childViewHolderInt.itemView;
                    m1Var.f2084a = view3.getLeft();
                    m1Var.f2085b = view3.getTop();
                    view3.getRight();
                    view3.getBottom();
                    k kVar = this.mViewInfoStore.f1966a;
                    b3 b3Var = (b3) kVar.getOrDefault(childViewHolderInt, (Object) null);
                    if (b3Var == null) {
                        b3Var = b3.a();
                        kVar.put(childViewHolderInt, b3Var);
                    }
                    b3Var.f1947b = m1Var;
                    b3Var.f1946a |= 4;
                    if (this.mState.f2025h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f1967b.g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f2028k) {
            saveOldPositions();
            g2 g2Var6 = this.mState;
            boolean z12 = g2Var6.f2023f;
            g2Var6.f2023f = false;
            this.mLayout.n0(this.mRecycler, g2Var6);
            this.mState.f2023f = z12;
            for (int i12 = 0; i12 < this.mChildHelper.e(); i12++) {
                k2 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i12));
                if (!childViewHolderInt2.shouldIgnore()) {
                    b3 b3Var2 = (b3) this.mViewInfoStore.f1966a.getOrDefault(childViewHolderInt2, (Object) null);
                    if (b3Var2 == null || (b3Var2.f1946a & 4) == 0) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11) {
                        n1.e(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        n1 n1Var2 = this.mItemAnimator;
                        childViewHolderInt2.getUnmodifiedPayloads();
                        n1Var2.getClass();
                        m1 m1Var2 = new m1();
                        View view4 = childViewHolderInt2.itemView;
                        m1Var2.f2084a = view4.getLeft();
                        m1Var2.f2085b = view4.getTop();
                        view4.getRight();
                        view4.getBottom();
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, m1Var2);
                        } else {
                            k kVar2 = this.mViewInfoStore.f1966a;
                            b3 b3Var3 = (b3) kVar2.getOrDefault(childViewHolderInt2, (Object) null);
                            if (b3Var3 == null) {
                                b3Var3 = b3.a();
                                kVar2.put(childViewHolderInt2, b3Var3);
                            }
                            b3Var3.f1946a |= 2;
                            b3Var3.f1947b = m1Var2;
                        }
                    }
                }
            }
        }
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f2021d = 2;
    }

    public void defaultOnMeasure(int i10, int i11) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = c1.f10054a;
        setMeasuredDimension(q1.r(i10, paddingRight, i0.e(this)), q1.r(i11, getPaddingBottom() + getPaddingTop(), i0.d(this)));
    }

    public void dispatchChildAttached(View view) {
        k2 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        g1 g1Var = this.mAdapter;
        if (!(g1Var == null || childViewHolderInt == null)) {
            g1Var.onViewAttachedToWindow(childViewHolderInt);
        }
        List<s1> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            int size = list.size() - 1;
            while (size >= 0) {
                ((g) this.mOnChildAttachStateListeners.get(size)).getClass();
                r1 r1Var = (r1) view.getLayoutParams();
                if (r1Var.width == -1 && r1Var.height == -1) {
                    size--;
                } else {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        }
    }

    public void dispatchChildDetached(View view) {
        k2 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        g1 g1Var = this.mAdapter;
        if (!(g1Var == null || childViewHolderInt == null)) {
            g1Var.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<s1> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).getClass();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0362, code lost:
        if (r15.mChildHelper.j(r0) == false) goto L_0x03fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03c0, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0376  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03e1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchLayout() {
        /*
            r15 = this;
            androidx.recyclerview.widget.g1 r0 = r15.mAdapter
            java.lang.String r1 = "RecyclerView"
            if (r0 != 0) goto L_0x000c
            java.lang.String r0 = "No adapter attached; skipping layout"
            android.util.Log.w(r1, r0)
            return
        L_0x000c:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "No layout manager attached; skipping layout"
            android.util.Log.e(r1, r0)
            return
        L_0x0016:
            androidx.recyclerview.widget.g2 r0 = r15.mState
            r2 = 0
            r0.f2026i = r2
            boolean r0 = r15.mLastAutoMeasureSkippedDueToExact
            r3 = 1
            if (r0 == 0) goto L_0x0032
            int r0 = r15.mLastAutoMeasureNonExactMeasuredWidth
            int r4 = r15.getWidth()
            if (r0 != r4) goto L_0x0030
            int r0 = r15.mLastAutoMeasureNonExactMeasuredHeight
            int r4 = r15.getHeight()
            if (r0 == r4) goto L_0x0032
        L_0x0030:
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            r15.mLastAutoMeasureNonExactMeasuredWidth = r2
            r15.mLastAutoMeasureNonExactMeasuredHeight = r2
            r15.mLastAutoMeasureSkippedDueToExact = r2
            androidx.recyclerview.widget.g2 r4 = r15.mState
            int r4 = r4.f2021d
            if (r4 != r3) goto L_0x0043
            r15.d()
            goto L_0x0077
        L_0x0043:
            androidx.recyclerview.widget.b r4 = r15.mAdapterHelper
            java.util.ArrayList r5 = r4.f1935c
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0057
            java.util.ArrayList r4 = r4.f1934b
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0057
            r4 = 1
            goto L_0x0058
        L_0x0057:
            r4 = 0
        L_0x0058:
            if (r4 != 0) goto L_0x0077
            if (r0 != 0) goto L_0x0077
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            int r0 = r0.f2156u
            int r4 = r15.getWidth()
            if (r0 != r4) goto L_0x0077
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            int r0 = r0.f2157v
            int r4 = r15.getHeight()
            if (r0 == r4) goto L_0x0071
            goto L_0x0077
        L_0x0071:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            r0.C0(r15)
            goto L_0x007f
        L_0x0077:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            r0.C0(r15)
            r15.e()
        L_0x007f:
            androidx.recyclerview.widget.g2 r0 = r15.mState
            r4 = 4
            r0.a(r4)
            r15.startInterceptRequestLayout()
            r15.onEnterLayoutOrScroll()
            androidx.recyclerview.widget.g2 r0 = r15.mState
            r0.f2021d = r3
            boolean r0 = r0.f2027j
            r5 = 0
            if (r0 == 0) goto L_0x02a8
            androidx.recyclerview.widget.k r0 = r15.mChildHelper
            int r0 = r0.e()
            int r0 = r0 - r3
        L_0x009b:
            if (r0 < 0) goto L_0x0207
            androidx.recyclerview.widget.k r6 = r15.mChildHelper
            android.view.View r6 = r6.d(r0)
            androidx.recyclerview.widget.k2 r6 = getChildViewHolderInt(r6)
            boolean r7 = r6.shouldIgnore()
            if (r7 == 0) goto L_0x00af
            goto L_0x0201
        L_0x00af:
            long r7 = r15.getChangedHolderKey(r6)
            androidx.recyclerview.widget.n1 r9 = r15.mItemAnimator
            r9.getClass()
            androidx.recyclerview.widget.m1 r9 = new androidx.recyclerview.widget.m1
            r9.<init>()
            android.view.View r10 = r6.itemView
            int r11 = r10.getLeft()
            r9.f2084a = r11
            int r11 = r10.getTop()
            r9.f2085b = r11
            r10.getRight()
            r10.getBottom()
            androidx.recyclerview.widget.d3 r10 = r15.mViewInfoStore
            q.i r10 = r10.f1967b
            java.lang.Object r10 = r10.e(r7, r5)
            androidx.recyclerview.widget.k2 r10 = (androidx.recyclerview.widget.k2) r10
            r11 = 8
            if (r10 == 0) goto L_0x01e7
            boolean r12 = r10.shouldIgnore()
            if (r12 != 0) goto L_0x01e7
            androidx.recyclerview.widget.d3 r12 = r15.mViewInfoStore
            q.k r12 = r12.f1966a
            java.lang.Object r12 = r12.getOrDefault(r10, r5)
            androidx.recyclerview.widget.b3 r12 = (androidx.recyclerview.widget.b3) r12
            if (r12 == 0) goto L_0x00f8
            int r12 = r12.f1946a
            r12 = r12 & r3
            if (r12 == 0) goto L_0x00f8
            r12 = 1
            goto L_0x00f9
        L_0x00f8:
            r12 = 0
        L_0x00f9:
            androidx.recyclerview.widget.d3 r13 = r15.mViewInfoStore
            q.k r13 = r13.f1966a
            java.lang.Object r13 = r13.getOrDefault(r6, r5)
            androidx.recyclerview.widget.b3 r13 = (androidx.recyclerview.widget.b3) r13
            if (r13 == 0) goto L_0x010c
            int r13 = r13.f1946a
            r3 = r3 & r13
            if (r3 == 0) goto L_0x010c
            r3 = 1
            goto L_0x010d
        L_0x010c:
            r3 = 0
        L_0x010d:
            if (r12 == 0) goto L_0x0113
            if (r10 != r6) goto L_0x0113
            goto L_0x01e7
        L_0x0113:
            androidx.recyclerview.widget.d3 r13 = r15.mViewInfoStore
            androidx.recyclerview.widget.m1 r4 = r13.a(r10, r4)
            androidx.recyclerview.widget.d3 r13 = r15.mViewInfoStore
            q.k r13 = r13.f1966a
            java.lang.Object r14 = r13.getOrDefault(r6, r5)
            androidx.recyclerview.widget.b3 r14 = (androidx.recyclerview.widget.b3) r14
            if (r14 != 0) goto L_0x012c
            androidx.recyclerview.widget.b3 r14 = androidx.recyclerview.widget.b3.a()
            r13.put(r6, r14)
        L_0x012c:
            r14.f1948c = r9
            int r9 = r14.f1946a
            r9 = r9 | r11
            r14.f1946a = r9
            androidx.recyclerview.widget.d3 r9 = r15.mViewInfoStore
            androidx.recyclerview.widget.m1 r9 = r9.a(r6, r11)
            if (r4 != 0) goto L_0x01bd
            androidx.recyclerview.widget.k r3 = r15.mChildHelper
            int r3 = r3.e()
            r4 = 0
        L_0x0142:
            if (r4 >= r3) goto L_0x019c
            androidx.recyclerview.widget.k r9 = r15.mChildHelper
            android.view.View r9 = r9.d(r4)
            androidx.recyclerview.widget.k2 r9 = getChildViewHolderInt(r9)
            if (r9 != r6) goto L_0x0151
            goto L_0x0199
        L_0x0151:
            long r11 = r15.getChangedHolderKey(r9)
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0199
            androidx.recyclerview.widget.g1 r0 = r15.mAdapter
            java.lang.String r1 = " \n View Holder 2:"
            if (r0 == 0) goto L_0x017f
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x017f
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:"
            r2.<init>(r3)
            r2.append(r9)
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = android.support.v4.media.h.h(r15, r2)
            r0.<init>(r1)
            throw r0
        L_0x017f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:"
            r2.<init>(r3)
            r2.append(r9)
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = android.support.v4.media.h.h(r15, r2)
            r0.<init>(r1)
            throw r0
        L_0x0199:
            int r4 = r4 + 1
            goto L_0x0142
        L_0x019c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Problem while matching changed view holders with the newones. The pre-layout information for the change holder "
            r3.<init>(r4)
            r3.append(r10)
            java.lang.String r4 = " cannot be found but it is necessary for "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = r15.exceptionLabel()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r1, r3)
            goto L_0x0201
        L_0x01bd:
            r10.setIsRecyclable(r2)
            if (r12 == 0) goto L_0x01c5
            r15.a(r10)
        L_0x01c5:
            if (r10 == r6) goto L_0x01db
            if (r3 == 0) goto L_0x01cc
            r15.a(r6)
        L_0x01cc:
            r10.mShadowedHolder = r6
            r15.a(r10)
            androidx.recyclerview.widget.y1 r3 = r15.mRecycler
            r3.n(r10)
            r6.setIsRecyclable(r2)
            r6.mShadowingHolder = r10
        L_0x01db:
            androidx.recyclerview.widget.n1 r3 = r15.mItemAnimator
            boolean r3 = r3.b(r10, r6, r4, r9)
            if (r3 == 0) goto L_0x0201
            r15.postAnimationRunner()
            goto L_0x0201
        L_0x01e7:
            androidx.recyclerview.widget.d3 r3 = r15.mViewInfoStore
            q.k r3 = r3.f1966a
            java.lang.Object r4 = r3.getOrDefault(r6, r5)
            androidx.recyclerview.widget.b3 r4 = (androidx.recyclerview.widget.b3) r4
            if (r4 != 0) goto L_0x01fa
            androidx.recyclerview.widget.b3 r4 = androidx.recyclerview.widget.b3.a()
            r3.put(r6, r4)
        L_0x01fa:
            r4.f1948c = r9
            int r3 = r4.f1946a
            r3 = r3 | r11
            r4.f1946a = r3
        L_0x0201:
            int r0 = r0 + -1
            r3 = 1
            r4 = 4
            goto L_0x009b
        L_0x0207:
            androidx.recyclerview.widget.d3 r0 = r15.mViewInfoStore
            androidx.recyclerview.widget.c3 r1 = r15.mViewInfoProcessCallback
            q.k r0 = r0.f1966a
            int r3 = r0.f13081j
        L_0x020f:
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x02a8
            java.lang.Object r4 = r0.h(r3)
            androidx.recyclerview.widget.k2 r4 = (androidx.recyclerview.widget.k2) r4
            java.lang.Object r6 = r0.j(r3)
            androidx.recyclerview.widget.b3 r6 = (androidx.recyclerview.widget.b3) r6
            int r7 = r6.f1946a
            r8 = r7 & 3
            r9 = 3
            if (r8 != r9) goto L_0x0227
            goto L_0x022f
        L_0x0227:
            r8 = r7 & 1
            if (r8 == 0) goto L_0x0241
            androidx.recyclerview.widget.m1 r7 = r6.f1947b
            if (r7 != 0) goto L_0x023e
        L_0x022f:
            r7 = r1
            androidx.recyclerview.widget.e1 r7 = (androidx.recyclerview.widget.e1) r7
            androidx.recyclerview.widget.RecyclerView r7 = r7.f1972a
            androidx.recyclerview.widget.q1 r8 = r7.mLayout
            android.view.View r4 = r4.itemView
            androidx.recyclerview.widget.y1 r7 = r7.mRecycler
            r8.w0(r4, r7)
            goto L_0x029b
        L_0x023e:
            androidx.recyclerview.widget.m1 r8 = r6.f1948c
            goto L_0x027d
        L_0x0241:
            r8 = r7 & 14
            r9 = 14
            if (r8 != r9) goto L_0x0248
            goto L_0x028f
        L_0x0248:
            r8 = r7 & 12
            r9 = 12
            if (r8 != r9) goto L_0x0276
            androidx.recyclerview.widget.m1 r7 = r6.f1947b
            androidx.recyclerview.widget.m1 r8 = r6.f1948c
            r9 = r1
            androidx.recyclerview.widget.e1 r9 = (androidx.recyclerview.widget.e1) r9
            r9.getClass()
            r4.setIsRecyclable(r2)
            androidx.recyclerview.widget.RecyclerView r9 = r9.f1972a
            boolean r10 = r9.mDataSetHasChangedAfterLayout
            if (r10 == 0) goto L_0x026a
            androidx.recyclerview.widget.n1 r10 = r9.mItemAnimator
            boolean r4 = r10.b(r4, r4, r7, r8)
            if (r4 == 0) goto L_0x029b
            goto L_0x0272
        L_0x026a:
            androidx.recyclerview.widget.n1 r10 = r9.mItemAnimator
            boolean r4 = r10.d(r4, r7, r8)
            if (r4 == 0) goto L_0x029b
        L_0x0272:
            r9.postAnimationRunner()
            goto L_0x029b
        L_0x0276:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x028b
            androidx.recyclerview.widget.m1 r7 = r6.f1947b
            r8 = r5
        L_0x027d:
            r9 = r1
            androidx.recyclerview.widget.e1 r9 = (androidx.recyclerview.widget.e1) r9
            androidx.recyclerview.widget.RecyclerView r9 = r9.f1972a
            androidx.recyclerview.widget.y1 r10 = r9.mRecycler
            r10.n(r4)
            r9.animateDisappearance(r4, r7, r8)
            goto L_0x029b
        L_0x028b:
            r7 = r7 & 8
            if (r7 == 0) goto L_0x029b
        L_0x028f:
            androidx.recyclerview.widget.m1 r7 = r6.f1947b
            androidx.recyclerview.widget.m1 r8 = r6.f1948c
            r9 = r1
            androidx.recyclerview.widget.e1 r9 = (androidx.recyclerview.widget.e1) r9
            androidx.recyclerview.widget.RecyclerView r9 = r9.f1972a
            r9.animateAppearance(r4, r7, r8)
        L_0x029b:
            r6.f1946a = r2
            r6.f1947b = r5
            r6.f1948c = r5
            s.f r4 = androidx.recyclerview.widget.b3.f1945d
            r4.e(r6)
            goto L_0x020f
        L_0x02a8:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            androidx.recyclerview.widget.y1 r1 = r15.mRecycler
            r0.v0(r1)
            androidx.recyclerview.widget.g2 r0 = r15.mState
            int r1 = r0.f2022e
            r0.f2019b = r1
            r15.mDataSetHasChangedAfterLayout = r2
            r15.mDispatchItemsChangedEvent = r2
            r0.f2027j = r2
            r0.f2028k = r2
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            r0.f2148m = r2
            androidx.recyclerview.widget.y1 r0 = r15.mRecycler
            java.util.ArrayList r0 = r0.f2251b
            if (r0 == 0) goto L_0x02ca
            r0.clear()
        L_0x02ca:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            boolean r1 = r0.f2153r
            if (r1 == 0) goto L_0x02d9
            r0.f2152q = r2
            r0.f2153r = r2
            androidx.recyclerview.widget.y1 r0 = r15.mRecycler
            r0.o()
        L_0x02d9:
            androidx.recyclerview.widget.q1 r0 = r15.mLayout
            androidx.recyclerview.widget.g2 r1 = r15.mState
            r0.o0(r1)
            r15.onExitLayoutOrScroll()
            r15.stopInterceptRequestLayout(r2)
            androidx.recyclerview.widget.d3 r0 = r15.mViewInfoStore
            q.k r1 = r0.f1966a
            r1.clear()
            q.i r0 = r0.f1967b
            r0.b()
            int[] r0 = r15.mMinMaxLayoutPositions
            r1 = r0[r2]
            r3 = 1
            r4 = r0[r3]
            r15.g(r0)
            int[] r0 = r15.mMinMaxLayoutPositions
            r6 = r0[r2]
            if (r6 != r1) goto L_0x0308
            r0 = r0[r3]
            if (r0 == r4) goto L_0x0307
            goto L_0x0308
        L_0x0307:
            r3 = 0
        L_0x0308:
            if (r3 == 0) goto L_0x030d
            r15.dispatchOnScrolled(r2, r2)
        L_0x030d:
            boolean r0 = r15.mPreserveFocusAfterLayout
            r3 = -1
            if (r0 == 0) goto L_0x03fa
            androidx.recyclerview.widget.g1 r0 = r15.mAdapter
            if (r0 == 0) goto L_0x03fa
            boolean r0 = r15.hasFocus()
            if (r0 == 0) goto L_0x03fa
            int r0 = r15.getDescendantFocusability()
            r1 = 393216(0x60000, float:5.51013E-40)
            if (r0 == r1) goto L_0x03fa
            int r0 = r15.getDescendantFocusability()
            r1 = 131072(0x20000, float:1.83671E-40)
            if (r0 != r1) goto L_0x0335
            boolean r0 = r15.isFocused()
            if (r0 == 0) goto L_0x0335
            goto L_0x03fa
        L_0x0335:
            boolean r0 = r15.isFocused()
            if (r0 != 0) goto L_0x0366
            android.view.View r0 = r15.getFocusedChild()
            boolean r1 = IGNORE_DETACHED_FOCUSED_CHILD
            if (r1 == 0) goto L_0x035c
            android.view.ViewParent r1 = r0.getParent()
            if (r1 == 0) goto L_0x034f
            boolean r1 = r0.hasFocus()
            if (r1 != 0) goto L_0x035c
        L_0x034f:
            androidx.recyclerview.widget.k r0 = r15.mChildHelper
            int r0 = r0.e()
            if (r0 != 0) goto L_0x0366
            r15.requestFocus()
            goto L_0x03fa
        L_0x035c:
            androidx.recyclerview.widget.k r1 = r15.mChildHelper
            boolean r0 = r1.j(r0)
            if (r0 != 0) goto L_0x0366
            goto L_0x03fa
        L_0x0366:
            androidx.recyclerview.widget.g2 r0 = r15.mState
            long r0 = r0.f2030m
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x037f
            androidx.recyclerview.widget.g1 r0 = r15.mAdapter
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x037f
            androidx.recyclerview.widget.g2 r0 = r15.mState
            long r0 = r0.f2030m
            androidx.recyclerview.widget.k2 r0 = r15.findViewHolderForItemId(r0)
            goto L_0x0380
        L_0x037f:
            r0 = r5
        L_0x0380:
            if (r0 == 0) goto L_0x0398
            androidx.recyclerview.widget.k r1 = r15.mChildHelper
            android.view.View r6 = r0.itemView
            boolean r1 = r1.j(r6)
            if (r1 != 0) goto L_0x0398
            android.view.View r1 = r0.itemView
            boolean r1 = r1.hasFocusable()
            if (r1 != 0) goto L_0x0395
            goto L_0x0398
        L_0x0395:
            android.view.View r5 = r0.itemView
            goto L_0x03df
        L_0x0398:
            androidx.recyclerview.widget.k r0 = r15.mChildHelper
            int r0 = r0.e()
            if (r0 <= 0) goto L_0x03df
            androidx.recyclerview.widget.g2 r0 = r15.mState
            int r1 = r0.f2029l
            r6 = -1
            if (r1 == r6) goto L_0x03a8
            r2 = r1
        L_0x03a8:
            int r0 = r0.b()
            r1 = r2
        L_0x03ad:
            if (r1 >= r0) goto L_0x03c5
            androidx.recyclerview.widget.k2 r6 = r15.findViewHolderForAdapterPosition(r1)
            if (r6 != 0) goto L_0x03b6
            goto L_0x03c5
        L_0x03b6:
            android.view.View r7 = r6.itemView
            boolean r7 = r7.hasFocusable()
            if (r7 == 0) goto L_0x03c2
            android.view.View r0 = r6.itemView
        L_0x03c0:
            r5 = r0
            goto L_0x03df
        L_0x03c2:
            int r1 = r1 + 1
            goto L_0x03ad
        L_0x03c5:
            int r0 = java.lang.Math.min(r0, r2)
        L_0x03c9:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x03df
            androidx.recyclerview.widget.k2 r1 = r15.findViewHolderForAdapterPosition(r0)
            if (r1 != 0) goto L_0x03d4
            goto L_0x03df
        L_0x03d4:
            android.view.View r2 = r1.itemView
            boolean r2 = r2.hasFocusable()
            if (r2 == 0) goto L_0x03c9
            android.view.View r0 = r1.itemView
            goto L_0x03c0
        L_0x03df:
            if (r5 == 0) goto L_0x03fa
            androidx.recyclerview.widget.g2 r0 = r15.mState
            int r0 = r0.f2031n
            long r1 = (long) r0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x03f7
            android.view.View r0 = r5.findViewById(r0)
            if (r0 == 0) goto L_0x03f7
            boolean r1 = r0.isFocusable()
            if (r1 == 0) goto L_0x03f7
            r5 = r0
        L_0x03f7:
            r5.requestFocus()
        L_0x03fa:
            androidx.recyclerview.widget.g2 r0 = r15.mState
            r0.f2030m = r3
            r1 = -1
            r0.f2029l = r1
            r0.f2031n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayout():void");
    }

    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return getScrollingChildHelper().a(f10, f11, z10);
    }

    public boolean dispatchNestedPreFling(float f10, float f11) {
        return getScrollingChildHelper().b(f10, f11);
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2, 0);
    }

    public final void dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void dispatchOnScrollStateChanged(int i10) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.r0(i10);
        }
        onScrollStateChanged(i10);
        v1 v1Var = this.mScrollListener;
        if (v1Var != null) {
            v1Var.onScrollStateChanged(this, i10);
        }
        List<v1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i10);
            }
        }
    }

    public void dispatchOnScrolled(int i10, int i11) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i10, scrollY - i11);
        onScrolled(i10, i11);
        v1 v1Var = this.mScrollListener;
        if (v1Var != null) {
            v1Var.onScrolled(this, i10, i11);
        }
        List<v1> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i10, i11);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i10;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            k2 k2Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (k2Var.itemView.getParent() == this && !k2Var.shouldIgnore() && (i10 = k2Var.mPendingAccessibilityState) != -1) {
                View view = k2Var.itemView;
                WeakHashMap weakHashMap = c1.f10054a;
                i0.s(view, i10);
                k2Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z10;
        float f10;
        float f11;
        int i10;
        boolean z11;
        boolean z12;
        int i11;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z13 = false;
        for (int i12 = 0; i12 < size; i12++) {
            this.mItemDecorations.get(i12).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z14 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z10 = false;
        } else {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i11 = getPaddingBottom();
            } else {
                i11 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + i11), DECELERATION_RATE);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 == null || !edgeEffect2.draw(canvas)) {
                z10 = false;
            } else {
                z10 = true;
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 == null || !edgeEffect4.draw(canvas)) {
                z12 = false;
            } else {
                z12 = true;
            }
            z10 |= z12;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i10 = getPaddingTop();
            } else {
                i10 = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate((float) i10, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 == null || !edgeEffect6.draw(canvas)) {
                z11 = false;
            } else {
                z11 = true;
            }
            z10 |= z11;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                f11 = (float) (getPaddingRight() + (-getWidth()));
                f10 = (float) (getPaddingBottom() + (-getHeight()));
            } else {
                f11 = (float) (-getWidth());
                f10 = (float) (-getHeight());
            }
            canvas.translate(f11, f10);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z13 = true;
            }
            z10 |= z13;
            canvas.restoreToCount(save4);
        }
        if (z10 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.k()) {
            z14 = z10;
        }
        if (z14) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j10) {
        return super.drawChild(canvas, view, j10);
    }

    public final void e() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.f2022e = this.mAdapter.getItemCount();
        this.mState.f2020c = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.f1954j;
            if (parcelable != null) {
                this.mLayout.p0(parcelable);
            }
            this.mPendingSavedState = null;
        }
        g2 g2Var = this.mState;
        g2Var.f2024g = false;
        this.mLayout.n0(this.mRecycler, g2Var);
        g2 g2Var2 = this.mState;
        g2Var2.f2023f = false;
        g2Var2.f2027j = g2Var2.f2027j && this.mItemAnimator != null;
        g2Var2.f2021d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    public void ensureBottomGlow() {
        int i10;
        int i11;
        if (this.mBottomGlow == null) {
            EdgeEffect a10 = this.mEdgeEffectFactory.a(this);
            this.mBottomGlow = a10;
            if (this.mClipToPadding) {
                i11 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i10 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i11 = getMeasuredWidth();
                i10 = getMeasuredHeight();
            }
            a10.setSize(i11, i10);
        }
    }

    public void ensureLeftGlow() {
        int i10;
        int i11;
        if (this.mLeftGlow == null) {
            EdgeEffect a10 = this.mEdgeEffectFactory.a(this);
            this.mLeftGlow = a10;
            if (this.mClipToPadding) {
                i11 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i10 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i11 = getMeasuredHeight();
                i10 = getMeasuredWidth();
            }
            a10.setSize(i11, i10);
        }
    }

    public void ensureRightGlow() {
        int i10;
        int i11;
        if (this.mRightGlow == null) {
            EdgeEffect a10 = this.mEdgeEffectFactory.a(this);
            this.mRightGlow = a10;
            if (this.mClipToPadding) {
                i11 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i10 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i11 = getMeasuredHeight();
                i10 = getMeasuredWidth();
            }
            a10.setSize(i11, i10);
        }
    }

    public void ensureTopGlow() {
        int i10;
        int i11;
        if (this.mTopGlow == null) {
            EdgeEffect a10 = this.mEdgeEffectFactory.a(this);
            this.mTopGlow = a10;
            if (this.mClipToPadding) {
                i11 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i10 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i11 = getMeasuredWidth();
                i10 = getMeasuredHeight();
            }
            a10.setSize(i11, i10);
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final boolean f(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i10 = 0;
        while (i10 < size) {
            u1 u1Var = this.mOnItemTouchListeners.get(i10);
            if (!u1Var.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i10++;
            } else {
                this.mInterceptingOnItemTouchListener = u1Var;
                return true;
            }
        }
        return false;
    }

    public final void fillRemainingScrollValues(g2 g2Var) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f2058j;
            overScroller.getFinalX();
            overScroller.getCurrX();
            g2Var.getClass();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        g2Var.getClass();
    }

    public View findChildViewUnder(float f10, float f11) {
        for (int e10 = this.mChildHelper.e() - 1; e10 >= 0; e10--) {
            View d10 = this.mChildHelper.d(e10);
            float translationX = d10.getTranslationX();
            float translationY = d10.getTranslationY();
            if (f10 >= ((float) d10.getLeft()) + translationX && f10 <= ((float) d10.getRight()) + translationX && f11 >= ((float) d10.getTop()) + translationY && f11 <= ((float) d10.getBottom()) + translationY) {
                return d10;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public k2 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public k2 findViewHolderForAdapterPosition(int i10) {
        k2 k2Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int h10 = this.mChildHelper.h();
        for (int i11 = 0; i11 < h10; i11++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i11));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i10) {
                if (!this.mChildHelper.j(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                k2Var = childViewHolderInt;
            }
        }
        return k2Var;
    }

    public k2 findViewHolderForItemId(long j10) {
        g1 g1Var = this.mAdapter;
        k2 k2Var = null;
        if (g1Var != null && g1Var.hasStableIds()) {
            int h10 = this.mChildHelper.h();
            for (int i10 = 0; i10 < h10; i10++) {
                k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i10));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j10) {
                    if (!this.mChildHelper.j(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    k2Var = childViewHolderInt;
                }
            }
        }
        return k2Var;
    }

    public k2 findViewHolderForLayoutPosition(int i10) {
        return findViewHolderForPosition(i10, false);
    }

    @Deprecated
    public k2 findViewHolderForPosition(int i10) {
        return findViewHolderForPosition(i10, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.q1 r0 = r7.mLayout
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r8 = "RecyclerView"
            java.lang.String r9 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument."
            android.util.Log.e(r8, r9)
            return r1
        L_0x000d:
            boolean r2 = r7.mLayoutSuppressed
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = r0.o()
            androidx.recyclerview.widget.q1 r2 = r7.mLayout
            boolean r2 = r2.p()
            if (r0 == 0) goto L_0x0026
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0027
        L_0x0026:
            r8 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0031
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0032
        L_0x0031:
            r9 = 0
        L_0x0032:
            if (r8 != 0) goto L_0x0037
            if (r9 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r3 = 0
            if (r8 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            if (r4 == 0) goto L_0x005c
            float r4 = hb.h0.e0(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.p(r4, r5, r6)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r8 = r7.mLeftGlow
            r8.onAbsorb(r5)
        L_0x0058:
            r8 = 0
        L_0x0059:
            r4 = r8
            r8 = 0
            goto L_0x007b
        L_0x005c:
            android.widget.EdgeEffect r4 = r7.mRightGlow
            if (r4 == 0) goto L_0x007a
            float r4 = hb.h0.e0(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mRightGlow
            int r5 = r7.getWidth()
            boolean r4 = r7.p(r4, r8, r5)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r4 = r7.mRightGlow
            r4.onAbsorb(r8)
            goto L_0x0058
        L_0x007a:
            r4 = 0
        L_0x007b:
            if (r9 == 0) goto L_0x00bc
            android.widget.EdgeEffect r5 = r7.mTopGlow
            if (r5 == 0) goto L_0x009e
            float r5 = hb.h0.e0(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            android.widget.EdgeEffect r3 = r7.mTopGlow
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.p(r3, r5, r6)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r9 = r7.mTopGlow
            r9.onAbsorb(r5)
        L_0x009b:
            r9 = 0
        L_0x009c:
            r3 = 0
            goto L_0x00be
        L_0x009e:
            android.widget.EdgeEffect r5 = r7.mBottomGlow
            if (r5 == 0) goto L_0x00bc
            float r5 = hb.h0.e0(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            int r5 = r7.getHeight()
            boolean r3 = r7.p(r3, r9, r5)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            r3.onAbsorb(r9)
            goto L_0x009b
        L_0x00bc:
            r3 = r9
            r9 = 0
        L_0x00be:
            if (r4 != 0) goto L_0x00c2
            if (r9 == 0) goto L_0x00dd
        L_0x00c2:
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.j2 r5 = r7.mViewFlinger
            r5.a(r4, r9)
        L_0x00dd:
            r5 = 1
            if (r8 != 0) goto L_0x00e8
            if (r3 != 0) goto L_0x00e8
            if (r4 != 0) goto L_0x00e6
            if (r9 == 0) goto L_0x00e7
        L_0x00e6:
            r1 = 1
        L_0x00e7:
            return r1
        L_0x00e8:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x012b
            if (r0 != 0) goto L_0x00f7
            if (r2 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r6 = 0
            goto L_0x00f8
        L_0x00f7:
            r6 = 1
        L_0x00f8:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.t1 r9 = r7.mOnFlingListener
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.a(r8, r3)
            if (r9 == 0) goto L_0x0106
            return r5
        L_0x0106:
            if (r6 == 0) goto L_0x012b
            if (r2 == 0) goto L_0x010c
            r0 = r0 | 2
        L_0x010c:
            r7.startNestedScroll(r0, r5)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.j2 r0 = r7.mViewFlinger
            r0.a(r8, r9)
            return r5
        L_0x012b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0173, code lost:
        if (r3 > 0) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x018a, code lost:
        if (r6 > 0) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x018d, code lost:
        if (r3 < 0) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0190, code lost:
        if (r6 < 0) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0199, code lost:
        if ((r6 * r1) <= 0) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a2, code lost:
        if ((r6 * r1) >= 0) goto L_0x01a6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            r13 = this;
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            r0.getClass()
            androidx.recyclerview.widget.g1 r0 = r13.mAdapter
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001b
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            if (r0 == 0) goto L_0x001b
            boolean r0 = r13.isComputingLayout()
            if (r0 != 0) goto L_0x001b
            boolean r0 = r13.mLayoutSuppressed
            if (r0 != 0) goto L_0x001b
            r0 = 1
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            r4 = 33
            r5 = 17
            r6 = 0
            r7 = 2
            if (r0 == 0) goto L_0x009b
            if (r15 == r7) goto L_0x002c
            if (r15 != r2) goto L_0x009b
        L_0x002c:
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x004a
            if (r15 != r7) goto L_0x0039
            r0 = 130(0x82, float:1.82E-43)
            goto L_0x003b
        L_0x0039:
            r0 = 33
        L_0x003b:
            android.view.View r8 = r3.findNextFocus(r13, r14, r0)
            if (r8 != 0) goto L_0x0043
            r8 = 1
            goto L_0x0044
        L_0x0043:
            r8 = 0
        L_0x0044:
            boolean r9 = FORCE_ABS_FOCUS_SEARCH_DIRECTION
            if (r9 == 0) goto L_0x004b
            r15 = r0
            goto L_0x004b
        L_0x004a:
            r8 = 0
        L_0x004b:
            if (r8 != 0) goto L_0x007b
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            boolean r0 = r0.o()
            if (r0 == 0) goto L_0x007b
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            int r0 = r0.M()
            if (r0 != r2) goto L_0x005f
            r0 = 1
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            if (r15 != r7) goto L_0x0064
            r8 = 1
            goto L_0x0065
        L_0x0064:
            r8 = 0
        L_0x0065:
            r0 = r0 ^ r8
            if (r0 == 0) goto L_0x006b
            r0 = 66
            goto L_0x006d
        L_0x006b:
            r0 = 17
        L_0x006d:
            android.view.View r8 = r3.findNextFocus(r13, r14, r0)
            if (r8 != 0) goto L_0x0075
            r8 = 1
            goto L_0x0076
        L_0x0075:
            r8 = 0
        L_0x0076:
            boolean r9 = FORCE_ABS_FOCUS_SEARCH_DIRECTION
            if (r9 == 0) goto L_0x007b
            r15 = r0
        L_0x007b:
            if (r8 == 0) goto L_0x0096
            r13.consumePendingUpdateOperations()
            android.view.View r0 = r13.findContainingItemView(r14)
            if (r0 != 0) goto L_0x0087
            return r6
        L_0x0087:
            r13.startInterceptRequestLayout()
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            androidx.recyclerview.widget.y1 r8 = r13.mRecycler
            androidx.recyclerview.widget.g2 r9 = r13.mState
            r0.c0(r14, r15, r8, r9)
            r13.stopInterceptRequestLayout(r1)
        L_0x0096:
            android.view.View r0 = r3.findNextFocus(r13, r14, r15)
            goto L_0x00bf
        L_0x009b:
            android.view.View r3 = r3.findNextFocus(r13, r14, r15)
            if (r3 != 0) goto L_0x00be
            if (r0 == 0) goto L_0x00be
            r13.consumePendingUpdateOperations()
            android.view.View r0 = r13.findContainingItemView(r14)
            if (r0 != 0) goto L_0x00ad
            return r6
        L_0x00ad:
            r13.startInterceptRequestLayout()
            androidx.recyclerview.widget.q1 r0 = r13.mLayout
            androidx.recyclerview.widget.y1 r3 = r13.mRecycler
            androidx.recyclerview.widget.g2 r8 = r13.mState
            android.view.View r0 = r0.c0(r14, r15, r3, r8)
            r13.stopInterceptRequestLayout(r1)
            goto L_0x00bf
        L_0x00be:
            r0 = r3
        L_0x00bf:
            if (r0 == 0) goto L_0x00d6
            boolean r3 = r0.hasFocusable()
            if (r3 != 0) goto L_0x00d6
            android.view.View r1 = r13.getFocusedChild()
            if (r1 != 0) goto L_0x00d2
            android.view.View r14 = super.focusSearch(r14, r15)
            return r14
        L_0x00d2:
            r13.m(r0, r6)
            return r14
        L_0x00d6:
            if (r0 == 0) goto L_0x01a6
            if (r0 == r13) goto L_0x01a6
            if (r0 != r14) goto L_0x00de
            goto L_0x01a6
        L_0x00de:
            android.view.View r3 = r13.findContainingItemView(r0)
            if (r3 != 0) goto L_0x00e6
            goto L_0x01a7
        L_0x00e6:
            if (r14 != 0) goto L_0x00ea
            goto L_0x01a4
        L_0x00ea:
            android.view.View r3 = r13.findContainingItemView(r14)
            if (r3 != 0) goto L_0x00f2
            goto L_0x01a4
        L_0x00f2:
            android.graphics.Rect r3 = r13.mTempRect
            int r6 = r14.getWidth()
            int r8 = r14.getHeight()
            r3.set(r1, r1, r6, r8)
            android.graphics.Rect r3 = r13.mTempRect2
            int r6 = r0.getWidth()
            int r8 = r0.getHeight()
            r3.set(r1, r1, r6, r8)
            android.graphics.Rect r1 = r13.mTempRect
            r13.offsetDescendantRectToMyCoords(r14, r1)
            android.graphics.Rect r1 = r13.mTempRect2
            r13.offsetDescendantRectToMyCoords(r0, r1)
            androidx.recyclerview.widget.q1 r1 = r13.mLayout
            int r1 = r1.M()
            if (r1 != r2) goto L_0x0120
            r1 = -1
            goto L_0x0121
        L_0x0120:
            r1 = 1
        L_0x0121:
            android.graphics.Rect r3 = r13.mTempRect
            int r6 = r3.left
            android.graphics.Rect r8 = r13.mTempRect2
            int r9 = r8.left
            if (r6 < r9) goto L_0x012f
            int r10 = r3.right
            if (r10 > r9) goto L_0x0137
        L_0x012f:
            int r10 = r3.right
            int r11 = r8.right
            if (r10 >= r11) goto L_0x0137
            r6 = 1
            goto L_0x0144
        L_0x0137:
            int r10 = r3.right
            int r11 = r8.right
            if (r10 > r11) goto L_0x013f
            if (r6 < r11) goto L_0x0143
        L_0x013f:
            if (r6 <= r9) goto L_0x0143
            r6 = -1
            goto L_0x0144
        L_0x0143:
            r6 = 0
        L_0x0144:
            int r9 = r3.top
            int r10 = r8.top
            if (r9 < r10) goto L_0x014e
            int r11 = r3.bottom
            if (r11 > r10) goto L_0x0156
        L_0x014e:
            int r11 = r3.bottom
            int r12 = r8.bottom
            if (r11 >= r12) goto L_0x0156
            r3 = 1
            goto L_0x0163
        L_0x0156:
            int r3 = r3.bottom
            int r8 = r8.bottom
            if (r3 > r8) goto L_0x015e
            if (r9 < r8) goto L_0x0162
        L_0x015e:
            if (r9 <= r10) goto L_0x0162
            r3 = -1
            goto L_0x0163
        L_0x0162:
            r3 = 0
        L_0x0163:
            if (r15 == r2) goto L_0x019c
            if (r15 == r7) goto L_0x0193
            if (r15 == r5) goto L_0x0190
            if (r15 == r4) goto L_0x018d
            r1 = 66
            if (r15 == r1) goto L_0x018a
            r1 = 130(0x82, float:1.82E-43)
            if (r15 != r1) goto L_0x0176
            if (r3 <= 0) goto L_0x01a6
            goto L_0x01a4
        L_0x0176:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid direction: "
            r0.<init>(r1)
            r0.append(r15)
            java.lang.String r15 = android.support.v4.media.h.h(r13, r0)
            r14.<init>(r15)
            throw r14
        L_0x018a:
            if (r6 <= 0) goto L_0x01a6
            goto L_0x01a4
        L_0x018d:
            if (r3 >= 0) goto L_0x01a6
            goto L_0x01a4
        L_0x0190:
            if (r6 >= 0) goto L_0x01a6
            goto L_0x01a4
        L_0x0193:
            if (r3 > 0) goto L_0x01a4
            if (r3 != 0) goto L_0x01a6
            int r6 = r6 * r1
            if (r6 <= 0) goto L_0x01a6
            goto L_0x01a4
        L_0x019c:
            if (r3 < 0) goto L_0x01a4
            if (r3 != 0) goto L_0x01a6
            int r6 = r6 * r1
            if (r6 >= 0) goto L_0x01a6
        L_0x01a4:
            r1 = 1
            goto L_0x01a7
        L_0x01a6:
            r1 = 0
        L_0x01a7:
            if (r1 == 0) goto L_0x01aa
            goto L_0x01ae
        L_0x01aa:
            android.view.View r0 = super.focusSearch(r14, r15)
        L_0x01ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g(int[] iArr) {
        int e10 = this.mChildHelper.e();
        if (e10 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = UNDEFINED_DURATION;
        for (int i12 = 0; i12 < e10; i12++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i12));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i10) {
                    i10 = layoutPosition;
                }
                if (layoutPosition > i11) {
                    i11 = layoutPosition;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            return q1Var.C();
        }
        throw new IllegalStateException(h.h(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            return q1Var.D(getContext(), attributeSet);
        }
        throw new IllegalStateException(h.h(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g1 getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(k2 k2Var) {
        if (k2Var.hasAnyOfTheFlags(524) || !k2Var.isBound()) {
            return -1;
        }
        b bVar = this.mAdapterHelper;
        int i10 = k2Var.mPosition;
        ArrayList arrayList = bVar.f1934b;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            a aVar = (a) arrayList.get(i11);
            int i12 = aVar.f1925a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = aVar.f1926b;
                    if (i13 <= i10) {
                        int i14 = aVar.f1928d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = aVar.f1926b;
                    if (i15 == i10) {
                        i10 = aVar.f1928d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (aVar.f1928d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (aVar.f1926b <= i10) {
                i10 += aVar.f1928d;
            }
        }
        return i10;
    }

    public int getBaseline() {
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            return super.getBaseline();
        }
        q1Var.getClass();
        return -1;
    }

    public long getChangedHolderKey(k2 k2Var) {
        return this.mAdapter.hasStableIds() ? k2Var.getItemId() : (long) k2Var.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        k2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildDrawingOrder(int i10, int i11) {
        return super.getChildDrawingOrder(i10, i11);
    }

    public long getChildItemId(View view) {
        k2 childViewHolderInt;
        g1 g1Var = this.mAdapter;
        if (g1Var == null || !g1Var.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        k2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public k2 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public m2 getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public k1 getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public n1 getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        r1 r1Var = (r1) view.getLayoutParams();
        boolean z10 = r1Var.f2186j;
        Rect rect = r1Var.f2185i;
        if (!z10) {
            return rect;
        }
        if (this.mState.f2024g && (r1Var.v() || r1Var.f2184h.isInvalid())) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i10).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i11 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i11 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        r1Var.f2186j = false;
        return rect;
    }

    public o1 getItemDecorationAt(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 >= 0 && i10 < itemDecorationCount) {
            return this.mItemDecorations.get(i10);
        }
        throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public q1 getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public t1 getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public x1 getRecycledViewPool() {
        return this.mRecycler.c();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public final void h(int i10, int i11, MotionEvent motionEvent) {
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i12 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean o10 = q1Var.o();
            boolean p10 = this.mLayout.p();
            boolean z10 = p10 ? o10 | true : o10;
            float height = motionEvent == null ? ((float) getHeight()) / 2.0f : motionEvent.getY();
            float width = motionEvent == null ? ((float) getWidth()) / 2.0f : motionEvent.getX();
            int k10 = i10 - k(i10, height);
            int l10 = i11 - l(i11, width);
            startNestedScroll(z10 ? 1 : 0, 1);
            if (dispatchNestedPreScroll(o10 ? k10 : 0, p10 ? l10 : 0, this.mReusableIntPair, this.mScrollOffset, 1)) {
                int[] iArr2 = this.mReusableIntPair;
                k10 -= iArr2[0];
                l10 -= iArr2[1];
            }
            int i13 = o10 ? k10 : 0;
            if (p10) {
                i12 = l10;
            }
            scrollByInternal(i13, i12, motionEvent, 1);
            k0 k0Var = this.mGapWorker;
            if (!(k0Var == null || (k10 == 0 && l10 == 0))) {
                k0Var.a(this, k10, l10);
            }
            stopNestedScroll(1);
        }
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    public final void i(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i10);
            int x10 = (int) (motionEvent.getX(i10) + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY(i10) + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
        }
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new b(new e1(this));
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(h.h(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new g0(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            q1 q1Var = this.mLayout;
            if (q1Var != null) {
                q1Var.m("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        n1 n1Var = this.mItemAnimator;
        return n1Var != null && n1Var.k();
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f10142d;
    }

    public final void j() {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            b bVar = this.mAdapterHelper;
            bVar.l(bVar.f1934b);
            bVar.l(bVar.f1935c);
            bVar.f1938f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.i0();
            }
        }
        if (this.mItemAnimator == null || !this.mLayout.M0()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.mAdapterHelper.j();
        } else {
            this.mAdapterHelper.c();
        }
        if (this.mItemsAddedOrRemoved || this.mItemsChanged) {
            z11 = true;
        } else {
            z11 = false;
        }
        g2 g2Var = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || ((!(z14 = this.mDataSetHasChangedAfterLayout) && !z11 && !this.mLayout.f2148m) || (z14 && !this.mAdapter.hasStableIds()))) {
            z12 = false;
        } else {
            z12 = true;
        }
        g2Var.f2027j = z12;
        g2 g2Var2 = this.mState;
        if (g2Var2.f2027j && z11 && !this.mDataSetHasChangedAfterLayout) {
            if (this.mItemAnimator == null || !this.mLayout.M0()) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13) {
                z15 = true;
            }
        }
        g2Var2.f2028k = z15;
    }

    public void jumpToPositionForSmoothScroller(int i10) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.A0(i10);
            awakenScrollBars();
        }
    }

    public final int k(int i10, float f10) {
        float i12;
        EdgeEffect edgeEffect;
        float height = f10 / ((float) getHeight());
        float width = ((float) i10) / ((float) getWidth());
        EdgeEffect edgeEffect2 = this.mLeftGlow;
        float f11 = DECELERATION_RATE;
        if (edgeEffect2 == null || h0.e0(edgeEffect2) == DECELERATION_RATE) {
            EdgeEffect edgeEffect3 = this.mRightGlow;
            if (!(edgeEffect3 == null || h0.e0(edgeEffect3) == DECELERATION_RATE)) {
                if (canScrollHorizontally(1)) {
                    edgeEffect = this.mRightGlow;
                } else {
                    i12 = h0.i1(this.mRightGlow, width, height);
                    if (h0.e0(this.mRightGlow) == DECELERATION_RATE) {
                        this.mRightGlow.onRelease();
                    }
                    f11 = i12;
                    invalidate();
                }
            }
            return Math.round(f11 * ((float) getWidth()));
        } else if (canScrollHorizontally(-1)) {
            edgeEffect = this.mLeftGlow;
        } else {
            i12 = -h0.i1(this.mLeftGlow, -width, 1.0f - height);
            if (h0.e0(this.mLeftGlow) == DECELERATION_RATE) {
                this.mLeftGlow.onRelease();
            }
            f11 = i12;
            invalidate();
            return Math.round(f11 * ((float) getWidth()));
        }
        edgeEffect.onRelease();
        invalidate();
        return Math.round(f11 * ((float) getWidth()));
    }

    public final void m(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof r1) {
            r1 r1Var = (r1) layoutParams;
            if (!r1Var.f2186j) {
                Rect rect = this.mTempRect;
                int i10 = rect.left;
                Rect rect2 = r1Var.f2185i;
                rect.left = i10 - rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.x0(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    public void markItemDecorInsetsDirty() {
        int h10 = this.mChildHelper.h();
        for (int i10 = 0; i10 < h10; i10++) {
            ((r1) this.mChildHelper.g(i10).getLayoutParams()).f2186j = true;
        }
        ArrayList arrayList = this.mRecycler.f2252c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            r1 r1Var = (r1) ((k2) arrayList.get(i11)).itemView.getLayoutParams();
            if (r1Var != null) {
                r1Var.f2186j = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int h10 = this.mChildHelper.h();
        for (int i10 = 0; i10 < h10; i10++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i10));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        y1 y1Var = this.mRecycler;
        ArrayList arrayList = y1Var.f2252c;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            k2 k2Var = (k2) arrayList.get(i11);
            if (k2Var != null) {
                k2Var.addFlags(6);
                k2Var.addChangePayload((Object) null);
            }
        }
        g1 g1Var = y1Var.f2258i.mAdapter;
        if (g1Var == null || !g1Var.hasStableIds()) {
            y1Var.h();
        }
    }

    public final void n() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z10 = false;
        stopNestedScroll(0);
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z10 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z10 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z10 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z10 |= this.mBottomGlow.isFinished();
        }
        if (z10) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public void nestedScrollBy(int i10, int i11) {
        h(i10, i11, (MotionEvent) null);
    }

    public final void o(g1 g1Var, boolean z10, boolean z11) {
        g1 g1Var2 = this.mAdapter;
        if (g1Var2 != null) {
            g1Var2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z10 || z11) {
            removeAndRecycleViews();
        }
        b bVar = this.mAdapterHelper;
        bVar.l(bVar.f1934b);
        bVar.l(bVar.f1935c);
        int i10 = 0;
        bVar.f1938f = 0;
        g1 g1Var3 = this.mAdapter;
        this.mAdapter = g1Var;
        if (g1Var != null) {
            g1Var.registerAdapterDataObserver(this.mObserver);
            g1Var.onAttachedToRecyclerView(this);
        }
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.Z();
        }
        y1 y1Var = this.mRecycler;
        g1 g1Var4 = this.mAdapter;
        y1Var.f2250a.clear();
        y1Var.h();
        y1Var.g(g1Var3, true);
        x1 c10 = y1Var.c();
        if (g1Var3 != null) {
            c10.f2233b--;
        }
        if (!z10 && c10.f2233b == 0) {
            while (true) {
                SparseArray sparseArray = c10.f2232a;
                if (i10 >= sparseArray.size()) {
                    break;
                }
                w1 w1Var = (w1) sparseArray.valueAt(i10);
                Iterator it = w1Var.f2225a.iterator();
                while (it.hasNext()) {
                    h0.u(((k2) it.next()).itemView);
                }
                w1Var.f2225a.clear();
                i10++;
            }
        }
        if (g1Var4 != null) {
            c10.f2233b++;
        } else {
            c10.getClass();
        }
        y1Var.f();
        this.mState.f2023f = true;
    }

    public void offsetChildrenHorizontal(int i10) {
        int e10 = this.mChildHelper.e();
        for (int i11 = 0; i11 < e10; i11++) {
            this.mChildHelper.d(i11).offsetLeftAndRight(i10);
        }
    }

    public void offsetChildrenVertical(int i10) {
        int e10 = this.mChildHelper.e();
        for (int i11 = 0; i11 < e10; i11++) {
            this.mChildHelper.d(i11).offsetTopAndBottom(i10);
        }
    }

    public void offsetPositionRecordsForInsert(int i10, int i11) {
        int h10 = this.mChildHelper.h();
        for (int i12 = 0; i12 < h10; i12++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i10) {
                childViewHolderInt.offsetPosition(i11, false);
                this.mState.f2023f = true;
            }
        }
        ArrayList arrayList = this.mRecycler.f2252c;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            k2 k2Var = (k2) arrayList.get(i13);
            if (k2Var != null && k2Var.mPosition >= i10) {
                k2Var.offsetPosition(i11, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int h10 = this.mChildHelper.h();
        int i19 = -1;
        if (i10 < i11) {
            i14 = i10;
            i13 = i11;
            i12 = -1;
        } else {
            i13 = i10;
            i14 = i11;
            i12 = 1;
        }
        for (int i20 = 0; i20 < h10; i20++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i20));
            if (childViewHolderInt != null && (i18 = childViewHolderInt.mPosition) >= i14 && i18 <= i13) {
                if (i18 == i10) {
                    childViewHolderInt.offsetPosition(i11 - i10, false);
                } else {
                    childViewHolderInt.offsetPosition(i12, false);
                }
                this.mState.f2023f = true;
            }
        }
        y1 y1Var = this.mRecycler;
        y1Var.getClass();
        if (i10 < i11) {
            i16 = i10;
            i15 = i11;
        } else {
            i15 = i10;
            i16 = i11;
            i19 = 1;
        }
        ArrayList arrayList = y1Var.f2252c;
        int size = arrayList.size();
        for (int i21 = 0; i21 < size; i21++) {
            k2 k2Var = (k2) arrayList.get(i21);
            if (k2Var != null && (i17 = k2Var.mPosition) >= i16 && i17 <= i15) {
                if (i17 == i10) {
                    k2Var.offsetPosition(i11 - i10, false);
                } else {
                    k2Var.offsetPosition(i19, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i10, int i11, boolean z10) {
        int i12 = i10 + i11;
        int h10 = this.mChildHelper.h();
        for (int i13 = 0; i13 < h10; i13++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i14 = childViewHolderInt.mPosition;
                if (i14 >= i12) {
                    childViewHolderInt.offsetPosition(-i11, z10);
                } else if (i14 >= i10) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i10 - 1, -i11, z10);
                }
                this.mState.f2023f = true;
            }
        }
        y1 y1Var = this.mRecycler;
        ArrayList arrayList = y1Var.f2252c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                k2 k2Var = (k2) arrayList.get(size);
                if (k2Var != null) {
                    int i15 = k2Var.mPosition;
                    if (i15 >= i12) {
                        k2Var.offsetPosition(-i11, z10);
                    } else if (i15 >= i10) {
                        k2Var.addFlags(8);
                        y1Var.i(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r1 >= 30.0f) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L_0x0015
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L_0x0015
            r2 = 1
            goto L_0x0016
        L_0x0015:
            r2 = 0
        L_0x0016:
            r5.mFirstLayoutComplete = r2
            androidx.recyclerview.widget.y1 r2 = r5.mRecycler
            r2.f()
            androidx.recyclerview.widget.q1 r2 = r5.mLayout
            if (r2 == 0) goto L_0x0026
            r2.f2149n = r1
            r2.a0(r5)
        L_0x0026:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L_0x006d
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.k0.f2066l
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.k0 r1 = (androidx.recyclerview.widget.k0) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L_0x0066
            androidx.recyclerview.widget.k0 r1 = new androidx.recyclerview.widget.k0
            r1.<init>()
            r5.mGapWorker = r1
            java.util.WeakHashMap r1 = m0.c1.f10054a
            android.view.Display r1 = m0.j0.b(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L_0x0058
            if (r1 == 0) goto L_0x0058
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r1 = 1114636288(0x42700000, float:60.0)
        L_0x005a:
            androidx.recyclerview.widget.k0 r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f2070j = r3
            r0.set(r2)
        L_0x0066:
            androidx.recyclerview.widget.k0 r0 = r5.mGapWorker
            java.util.ArrayList r0 = r0.f2068h
            r0.add(r5)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onDetachedFromWindow() {
        k0 k0Var;
        super.onDetachedFromWindow();
        n1 n1Var = this.mItemAnimator;
        if (n1Var != null) {
            n1Var.j();
        }
        stopScroll();
        this.mIsAttached = false;
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.f2149n = false;
            q1Var.b0(this);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        do {
        } while (b3.f1945d.j() != null);
        y1 y1Var = this.mRecycler;
        int i10 = 0;
        while (true) {
            ArrayList arrayList = y1Var.f2252c;
            if (i10 >= arrayList.size()) {
                break;
            }
            h0.u(((k2) arrayList.get(i10)).itemView);
            i10++;
        }
        y1Var.g(y1Var.f2258i.mAdapter, false);
        Iterator it = h0.b0(this).iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            a aVar = (a) view.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new a();
                view.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList2 = aVar.f13971a;
            int d10 = r.d(arrayList2);
            if (-1 < d10) {
                h.y(arrayList2.get(d10));
                throw null;
            }
        }
        if (ALLOW_THREAD_GAP_WORK && (k0Var = this.mGapWorker) != null) {
            k0Var.f2068h.remove(this);
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mItemDecorations.get(i10).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f10;
        float f11;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f11 = this.mLayout.p() ? -motionEvent.getAxisValue(9) : DECELERATION_RATE;
                if (this.mLayout.o()) {
                    f10 = motionEvent.getAxisValue(10);
                    if (!(f11 == DECELERATION_RATE && f10 == DECELERATION_RATE)) {
                        h((int) (f10 * this.mScaledHorizontalScrollFactor), (int) (f11 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    f10 = motionEvent.getAxisValue(26);
                    if (this.mLayout.p()) {
                        f11 = -f10;
                    } else if (this.mLayout.o()) {
                        f11 = DECELERATION_RATE;
                        h((int) (f10 * this.mScaledHorizontalScrollFactor), (int) (f11 * this.mScaledVerticalScrollFactor), motionEvent);
                    }
                }
                f11 = DECELERATION_RATE;
            }
            f10 = DECELERATION_RATE;
            h((int) (f10 * this.mScaledHorizontalScrollFactor), (int) (f11 * this.mScaledVerticalScrollFactor), motionEvent);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (f(motionEvent)) {
            n();
            setScrollState(0);
            return true;
        }
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            return false;
        }
        boolean o10 = q1Var.o();
        boolean p10 = this.mLayout.p();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x10 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x10;
            this.mInitialTouchX = x10;
            int y10 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y10;
            this.mInitialTouchY = y10;
            EdgeEffect edgeEffect = this.mLeftGlow;
            if (edgeEffect == null || h0.e0(edgeEffect) == DECELERATION_RATE || canScrollHorizontally(-1)) {
                z10 = false;
            } else {
                h0.i1(this.mLeftGlow, DECELERATION_RATE, 1.0f - (motionEvent.getY() / ((float) getHeight())));
                z10 = true;
            }
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (!(edgeEffect2 == null || h0.e0(edgeEffect2) == DECELERATION_RATE || canScrollHorizontally(1))) {
                h0.i1(this.mRightGlow, DECELERATION_RATE, motionEvent.getY() / ((float) getHeight()));
                z10 = true;
            }
            EdgeEffect edgeEffect3 = this.mTopGlow;
            if (!(edgeEffect3 == null || h0.e0(edgeEffect3) == DECELERATION_RATE || canScrollVertically(-1))) {
                h0.i1(this.mTopGlow, DECELERATION_RATE, motionEvent.getX() / ((float) getWidth()));
                z10 = true;
            }
            EdgeEffect edgeEffect4 = this.mBottomGlow;
            if (!(edgeEffect4 == null || h0.e0(edgeEffect4) == DECELERATION_RATE || canScrollVertically(1))) {
                h0.i1(this.mBottomGlow, DECELERATION_RATE, 1.0f - (motionEvent.getX() / ((float) getWidth())));
                z10 = true;
            }
            if (z10 || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (p10) {
                o10 |= true;
            }
            startNestedScroll(o10 ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x11 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y11 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i10 = x11 - this.mInitialTouchX;
                int i11 = y11 - this.mInitialTouchY;
                if (!o10 || Math.abs(i10) <= this.mTouchSlop) {
                    z11 = false;
                } else {
                    this.mLastTouchX = x11;
                    z11 = true;
                }
                if (p10 && Math.abs(i11) > this.mTouchSlop) {
                    this.mLastTouchY = y11;
                    z11 = true;
                }
                if (z11) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            n();
            setScrollState(0);
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x12;
            this.mInitialTouchX = x12;
            int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y12;
            this.mInitialTouchY = y12;
        } else if (actionMasked == 6) {
            i(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14 = n.f7952a;
        m.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        m.b();
        this.mFirstLayoutComplete = true;
    }

    public void onMeasure(int i10, int i11) {
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            defaultOnMeasure(i10, i11);
            return;
        }
        boolean z10 = false;
        if (q1Var.U()) {
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            this.mLayout.f2144i.defaultOnMeasure(i10, i11);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z10 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z10;
            if (!z10 && this.mAdapter != null) {
                if (this.mState.f2021d == 1) {
                    d();
                }
                this.mLayout.D0(i10, i11);
                this.mState.f2026i = true;
                e();
                this.mLayout.F0(i10, i11);
                if (this.mLayout.I0()) {
                    this.mLayout.D0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f2026i = true;
                    e();
                    this.mLayout.F0(i10, i11);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.f2144i.defaultOnMeasure(i10, i11);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                j();
                onExitLayoutOrScroll();
                g2 g2Var = this.mState;
                if (g2Var.f2028k) {
                    g2Var.f2024g = true;
                } else {
                    this.mAdapterHelper.c();
                    this.mState.f2024g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f2028k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            g1 g1Var = this.mAdapter;
            if (g1Var != null) {
                this.mState.f2022e = g1Var.getItemCount();
            } else {
                this.mState.f2022e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.f2144i.defaultOnMeasure(i10, i11);
            stopInterceptRequestLayout(false);
            this.mState.f2024g = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i10, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c2 c2Var = (c2) parcelable;
        this.mPendingSavedState = c2Var;
        super.onRestoreInstanceState(c2Var.f14484h);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable;
        c2 c2Var = new c2(super.onSaveInstanceState());
        c2 c2Var2 = this.mPendingSavedState;
        if (c2Var2 != null) {
            c2Var.f1954j = c2Var2.f1954j;
        } else {
            q1 q1Var = this.mLayout;
            if (q1Var != null) {
                parcelable = q1Var.q0();
            } else {
                parcelable = null;
            }
            c2Var.f1954j = parcelable;
        }
        return c2Var;
    }

    public void onScrollStateChanged(int i10) {
    }

    public void onScrolled(int i10, int i11) {
    }

    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12 || i11 != i13) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x020d
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x020d
        L_0x000f:
            androidx.recyclerview.widget.u1 r0 = r6.mInterceptingOnItemTouchListener
            r9 = 1
            r1 = 3
            if (r0 != 0) goto L_0x0022
            int r0 = r18.getAction()
            if (r0 != 0) goto L_0x001d
            r0 = 0
            goto L_0x0031
        L_0x001d:
            boolean r0 = r17.f(r18)
            goto L_0x0031
        L_0x0022:
            r0.onTouchEvent(r6, r7)
            int r0 = r18.getAction()
            if (r0 == r1) goto L_0x002d
            if (r0 != r9) goto L_0x0030
        L_0x002d:
            r0 = 0
            r6.mInterceptingOnItemTouchListener = r0
        L_0x0030:
            r0 = 1
        L_0x0031:
            if (r0 == 0) goto L_0x003a
            r17.n()
            r6.setScrollState(r8)
            return r9
        L_0x003a:
            androidx.recyclerview.widget.q1 r0 = r6.mLayout
            if (r0 != 0) goto L_0x003f
            return r8
        L_0x003f:
            boolean r10 = r0.o()
            androidx.recyclerview.widget.q1 r0 = r6.mLayout
            boolean r11 = r0.p()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0053
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0053:
            int r0 = r18.getActionMasked()
            int r2 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0063
            int[] r3 = r6.mNestedOffsets
            r3[r9] = r8
            r3[r8] = r8
        L_0x0063:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r3 = r6.mNestedOffsets
            r4 = r3[r8]
            float r4 = (float) r4
            r3 = r3[r9]
            float r3 = (float) r3
            r12.offsetLocation(r4, r3)
            r3 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01e1
            if (r0 == r9) goto L_0x019f
            r4 = 2
            if (r0 == r4) goto L_0x00ae
            if (r0 == r1) goto L_0x00a6
            r1 = 5
            if (r0 == r1) goto L_0x008a
            r1 = 6
            if (r0 == r1) goto L_0x0085
            goto L_0x0202
        L_0x0085:
            r17.i(r18)
            goto L_0x0202
        L_0x008a:
            int r0 = r7.getPointerId(r2)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r2)
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r2)
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x0202
        L_0x00a6:
            r17.n()
            r6.setScrollState(r8)
            goto L_0x0202
        L_0x00ae:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00d1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.<init>(r1)
            int r1 = r6.mScrollPointerId
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00d1:
            float r1 = r7.getX(r0)
            float r1 = r1 + r3
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r3
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x0116
            if (r10 == 0) goto L_0x00fc
            int r2 = r6.mTouchSlop
            if (r0 <= 0) goto L_0x00f3
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00f8
        L_0x00f3:
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00f8:
            if (r0 == 0) goto L_0x00fc
            r2 = 1
            goto L_0x00fd
        L_0x00fc:
            r2 = 0
        L_0x00fd:
            if (r11 == 0) goto L_0x0111
            int r3 = r6.mTouchSlop
            if (r1 <= 0) goto L_0x0109
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x010e
        L_0x0109:
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x010e:
            if (r1 == 0) goto L_0x0111
            r2 = 1
        L_0x0111:
            if (r2 == 0) goto L_0x0116
            r6.setScrollState(r9)
        L_0x0116:
            int r2 = r6.mScrollState
            if (r2 != r9) goto L_0x0202
            int[] r2 = r6.mReusableIntPair
            r2[r8] = r8
            r2[r9] = r8
            float r2 = r18.getY()
            int r2 = r6.k(r0, r2)
            int r15 = r0 - r2
            float r0 = r18.getX()
            int r0 = r6.l(r1, r0)
            int r16 = r1 - r0
            if (r10 == 0) goto L_0x0138
            r1 = r15
            goto L_0x0139
        L_0x0138:
            r1 = 0
        L_0x0139:
            if (r11 == 0) goto L_0x013e
            r2 = r16
            goto L_0x013f
        L_0x013e:
            r2 = 0
        L_0x013f:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x016e
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x016e:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0180
            r1 = r15
            goto L_0x0181
        L_0x0180:
            r1 = 0
        L_0x0181:
            if (r11 == 0) goto L_0x0185
            r2 = r0
            goto L_0x0186
        L_0x0185:
            r2 = 0
        L_0x0186:
            boolean r1 = r6.scrollByInternal(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0193
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0193:
            androidx.recyclerview.widget.k0 r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x0202
            if (r15 != 0) goto L_0x019b
            if (r0 == 0) goto L_0x0202
        L_0x019b:
            r1.a(r6, r15, r0)
            goto L_0x0202
        L_0x019f:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            int r1 = r6.mMaxFlingVelocity
            float r1 = (float) r1
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r2, r1)
            r0 = 0
            if (r10 == 0) goto L_0x01bb
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x01bc
        L_0x01bb:
            r1 = 0
        L_0x01bc:
            if (r11 == 0) goto L_0x01c8
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01c9
        L_0x01c8:
            r2 = 0
        L_0x01c9:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01d1
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01d9
        L_0x01d1:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01dc
        L_0x01d9:
            r6.setScrollState(r8)
        L_0x01dc:
            r17.n()
            r8 = 1
            goto L_0x0202
        L_0x01e1:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r3
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r11 == 0) goto L_0x01ff
            r10 = r10 | 2
        L_0x01ff:
            r6.startNestedScroll(r10, r8)
        L_0x0202:
            if (r8 != 0) goto L_0x0209
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x0209:
            r12.recycle()
            return r9
        L_0x020d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(EdgeEffect edgeEffect, int i10, int i11) {
        if (i10 > 0) {
            return true;
        }
        float e02 = h0.e0(edgeEffect) * ((float) i11);
        double log = Math.log((double) ((((float) Math.abs(-i10)) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION)));
        double d10 = (double) DECELERATION_RATE;
        if (((float) (Math.exp((d10 / (d10 - 1.0d)) * log) * ((double) (this.mPhysicalCoef * SCROLL_FRICTION)))) < e02) {
            return true;
        }
        return false;
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            Runnable runnable = this.mItemAnimatorRunner;
            WeakHashMap weakHashMap = c1.f10054a;
            i0.m(this, runnable);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z10) {
        this.mDispatchItemsChangedEvent = z10 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(k2 k2Var, m1 m1Var) {
        k2Var.setFlags(0, 8192);
        if (this.mState.f2025h && k2Var.isUpdated() && !k2Var.isRemoved() && !k2Var.shouldIgnore()) {
            this.mViewInfoStore.f1967b.g(getChangedHolderKey(k2Var), k2Var);
        }
        k kVar = this.mViewInfoStore.f1966a;
        b3 b3Var = (b3) kVar.getOrDefault(k2Var, (Object) null);
        if (b3Var == null) {
            b3Var = b3.a();
            kVar.put(k2Var, b3Var);
        }
        b3Var.f1947b = m1Var;
        b3Var.f1946a |= 4;
    }

    public void removeAndRecycleViews() {
        n1 n1Var = this.mItemAnimator;
        if (n1Var != null) {
            n1Var.j();
        }
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.u0(this.mRecycler);
            this.mLayout.v0(this.mRecycler);
        }
        y1 y1Var = this.mRecycler;
        y1Var.f2250a.clear();
        y1Var.h();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAnimatingView(android.view.View r6) {
        /*
            r5 = this;
            r5.startInterceptRequestLayout()
            androidx.recyclerview.widget.k r0 = r5.mChildHelper
            androidx.recyclerview.widget.e1 r1 = r0.f2063a
            androidx.recyclerview.widget.RecyclerView r2 = r1.f1972a
            int r2 = r2.indexOfChild(r6)
            r3 = -1
            if (r2 != r3) goto L_0x0014
            r0.k(r6)
            goto L_0x0025
        L_0x0014:
            androidx.recyclerview.widget.j r3 = r0.f2064b
            boolean r4 = r3.d(r2)
            if (r4 == 0) goto L_0x0027
            r3.f(r2)
            r0.k(r6)
            r1.c(r2)
        L_0x0025:
            r0 = 1
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            if (r0 == 0) goto L_0x0038
            androidx.recyclerview.widget.k2 r6 = getChildViewHolderInt(r6)
            androidx.recyclerview.widget.y1 r1 = r5.mRecycler
            r1.n(r6)
            androidx.recyclerview.widget.y1 r1 = r5.mRecycler
            r1.k(r6)
        L_0x0038:
            r6 = r0 ^ 1
            r5.stopInterceptRequestLayout(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.removeAnimatingView(android.view.View):boolean");
    }

    public void removeDetachedView(View view, boolean z10) {
        k2 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb2 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb2.append(childViewHolderInt);
                throw new IllegalArgumentException(h.h(this, sb2));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z10);
    }

    public void removeItemDecoration(o1 o1Var) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.m("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(o1Var);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i10) {
        int itemDecorationCount = getItemDecorationCount();
        if (i10 < 0 || i10 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i10 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i10));
    }

    public void removeOnChildAttachStateChangeListener(s1 s1Var) {
        List<s1> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(s1Var);
        }
    }

    public void removeOnItemTouchListener(u1 u1Var) {
        this.mOnItemTouchListeners.remove(u1Var);
        if (this.mInterceptingOnItemTouchListener == u1Var) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(v1 v1Var) {
        List<v1> list = this.mScrollListeners;
        if (list != null) {
            list.remove(v1Var);
        }
    }

    public void removeRecyclerListener(z1 z1Var) {
        this.mRecyclerListeners.remove(z1Var);
    }

    public void repositionShadowingViews() {
        k2 k2Var;
        int e10 = this.mChildHelper.e();
        for (int i10 = 0; i10 < e10; i10++) {
            View d10 = this.mChildHelper.d(i10);
            k2 childViewHolder = getChildViewHolder(d10);
            if (!(childViewHolder == null || (k2Var = childViewHolder.mShadowingHolder) == null)) {
                View view = k2Var.itemView;
                int left = d10.getLeft();
                int top = d10.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        boolean z10;
        f2 f2Var = this.mLayout.f2147l;
        boolean z11 = true;
        if (f2Var == null || !f2Var.f1987e) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10 && !isComputingLayout()) {
            z11 = false;
        }
        if (!z11 && view2 != null) {
            m(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        return this.mLayout.x0(this, view, rect, z10, false);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        int size = this.mOnItemTouchListeners.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.mOnItemTouchListeners.get(i10).onRequestDisallowInterceptTouchEvent(z10);
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int h10 = this.mChildHelper.h();
        for (int i10 = 0; i10 < h10; i10++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i10));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i10, int i11) {
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean o10 = q1Var.o();
            boolean p10 = this.mLayout.p();
            if (o10 || p10) {
                if (!o10) {
                    i10 = 0;
                }
                if (!p10) {
                    i11 = 0;
                }
                scrollByInternal(i10, i11, (MotionEvent) null, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scrollByInternal(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            r17 = this;
            r8 = r17
            r9 = r18
            r10 = r19
            r17.consumePendingUpdateOperations()
            androidx.recyclerview.widget.g1 r0 = r8.mAdapter
            r11 = 1
            r12 = 0
            if (r0 == 0) goto L_0x0028
            int[] r0 = r8.mReusableIntPair
            r0[r12] = r12
            r0[r11] = r12
            r8.scrollStep(r9, r10, r0)
            int[] r0 = r8.mReusableIntPair
            r1 = r0[r12]
            r0 = r0[r11]
            int r2 = r9 - r1
            int r3 = r10 - r0
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r3
            goto L_0x002d
        L_0x0028:
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x002d:
            java.util.ArrayList<androidx.recyclerview.widget.o1> r0 = r8.mItemDecorations
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0038
            r17.invalidate()
        L_0x0038:
            int[] r7 = r8.mReusableIntPair
            r7[r12] = r12
            r7[r11] = r12
            int[] r5 = r8.mScrollOffset
            r0 = r17
            r1 = r14
            r2 = r13
            r3 = r15
            r4 = r16
            r6 = r21
            r0.dispatchNestedScroll(r1, r2, r3, r4, r5, r6, r7)
            int[] r0 = r8.mReusableIntPair
            r1 = r0[r12]
            int r15 = r15 - r1
            r0 = r0[r11]
            int r2 = r16 - r0
            if (r1 != 0) goto L_0x005c
            if (r0 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r0 = 0
            goto L_0x005d
        L_0x005c:
            r0 = 1
        L_0x005d:
            int r1 = r8.mLastTouchX
            int[] r3 = r8.mScrollOffset
            r4 = r3[r12]
            int r1 = r1 - r4
            r8.mLastTouchX = r1
            int r1 = r8.mLastTouchY
            r3 = r3[r11]
            int r1 = r1 - r3
            r8.mLastTouchY = r1
            int[] r1 = r8.mNestedOffsets
            r5 = r1[r12]
            int r5 = r5 + r4
            r1[r12] = r5
            r4 = r1[r11]
            int r4 = r4 + r3
            r1[r11] = r4
            int r1 = r17.getOverScrollMode()
            r3 = 2
            if (r1 == r3) goto L_0x0119
            if (r20 == 0) goto L_0x0116
            int r1 = r20.getSource()
            r3 = 8194(0x2002, float:1.1482E-41)
            r1 = r1 & r3
            if (r1 != r3) goto L_0x008d
            r1 = 1
            goto L_0x008e
        L_0x008d:
            r1 = 0
        L_0x008e:
            if (r1 != 0) goto L_0x0116
            float r1 = r20.getX()
            float r3 = (float) r15
            float r4 = r20.getY()
            float r2 = (float) r2
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00b6
            r17.ensureLeftGlow()
            android.widget.EdgeEffect r7 = r8.mLeftGlow
            float r15 = -r3
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r15 = r15 / r11
            int r11 = r17.getHeight()
            float r11 = (float) r11
            float r4 = r4 / r11
            float r4 = r5 - r4
            goto L_0x00cc
        L_0x00b6:
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d1
            r17.ensureRightGlow()
            android.widget.EdgeEffect r7 = r8.mRightGlow
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r15 = r3 / r11
            int r11 = r17.getHeight()
            float r11 = (float) r11
            float r4 = r4 / r11
        L_0x00cc:
            hb.h0.i1(r7, r15, r4)
            r4 = 1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            int r7 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ec
            r17.ensureTopGlow()
            android.widget.EdgeEffect r4 = r8.mTopGlow
            float r5 = -r2
            int r7 = r17.getHeight()
            float r7 = (float) r7
            float r5 = r5 / r7
            int r7 = r17.getWidth()
            float r7 = (float) r7
            float r1 = r1 / r7
            hb.h0.i1(r4, r5, r1)
            goto L_0x0106
        L_0x00ec:
            int r7 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x0107
            r17.ensureBottomGlow()
            android.widget.EdgeEffect r4 = r8.mBottomGlow
            int r7 = r17.getHeight()
            float r7 = (float) r7
            float r7 = r2 / r7
            int r11 = r17.getWidth()
            float r11 = (float) r11
            float r1 = r1 / r11
            float r5 = r5 - r1
            hb.h0.i1(r4, r7, r5)
        L_0x0106:
            r4 = 1
        L_0x0107:
            if (r4 != 0) goto L_0x0111
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0111
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0116
        L_0x0111:
            java.util.WeakHashMap r1 = m0.c1.f10054a
            m0.i0.k(r17)
        L_0x0116:
            r17.considerReleasingGlowsOnScroll(r18, r19)
        L_0x0119:
            if (r14 != 0) goto L_0x011d
            if (r13 == 0) goto L_0x0120
        L_0x011d:
            r8.dispatchOnScrolled(r14, r13)
        L_0x0120:
            boolean r1 = r17.awakenScrollBars()
            if (r1 != 0) goto L_0x0129
            r17.invalidate()
        L_0x0129:
            if (r0 != 0) goto L_0x0132
            if (r14 != 0) goto L_0x0132
            if (r13 == 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            r11 = 0
            goto L_0x0133
        L_0x0132:
            r11 = 1
        L_0x0133:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent, int):boolean");
    }

    public void scrollStep(int i10, int i11, int[] iArr) {
        int i12;
        int i13;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i14 = n.f7952a;
        m.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i10 != 0) {
            i12 = this.mLayout.z0(i10, this.mRecycler, this.mState);
        } else {
            i12 = 0;
        }
        if (i11 != 0) {
            i13 = this.mLayout.B0(i11, this.mRecycler, this.mState);
        } else {
            i13 = 0;
        }
        m.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i12;
            iArr[1] = i13;
        }
    }

    public void scrollTo(int i10, int i11) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i10) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            q1 q1Var = this.mLayout;
            if (q1Var == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            q1Var.A0(i10);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(m2 m2Var) {
        this.mAccessibilityDelegate = m2Var;
        c1.p(this, m2Var);
    }

    public void setAdapter(g1 g1Var) {
        setLayoutFrozen(false);
        o(g1Var, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j1 j1Var) {
        if (j1Var != null) {
            setChildrenDrawingOrderEnabled(false);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(k2 k2Var, int i10) {
        if (isComputingLayout()) {
            k2Var.mPendingAccessibilityState = i10;
            this.mPendingAccessibilityImportanceChange.add(k2Var);
            return false;
        }
        View view = k2Var.itemView;
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(view, i10);
        return true;
    }

    public void setClipToPadding(boolean z10) {
        if (z10 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z10;
        super.setClipToPadding(z10);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k1 k1Var) {
        k1Var.getClass();
        this.mEdgeEffectFactory = k1Var;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z10) {
        this.mHasFixedSize = z10;
    }

    public void setItemAnimator(n1 n1Var) {
        n1 n1Var2 = this.mItemAnimator;
        if (n1Var2 != null) {
            n1Var2.j();
            this.mItemAnimator.f2096a = null;
        }
        this.mItemAnimator = n1Var;
        if (n1Var != null) {
            n1Var.f2096a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i10) {
        y1 y1Var = this.mRecycler;
        y1Var.f2254e = i10;
        y1Var.o();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z10) {
        suppressLayout(z10);
    }

    public void setLayoutManager(q1 q1Var) {
        e1 e1Var;
        RecyclerView recyclerView;
        if (q1Var != this.mLayout) {
            stopScroll();
            int i10 = 0;
            if (this.mLayout != null) {
                n1 n1Var = this.mItemAnimator;
                if (n1Var != null) {
                    n1Var.j();
                }
                this.mLayout.u0(this.mRecycler);
                this.mLayout.v0(this.mRecycler);
                y1 y1Var = this.mRecycler;
                y1Var.f2250a.clear();
                y1Var.h();
                if (this.mIsAttached) {
                    q1 q1Var2 = this.mLayout;
                    q1Var2.f2149n = false;
                    q1Var2.b0(this);
                }
                this.mLayout.G0((RecyclerView) null);
                this.mLayout = null;
            } else {
                y1 y1Var2 = this.mRecycler;
                y1Var2.f2250a.clear();
                y1Var2.h();
            }
            k kVar = this.mChildHelper;
            kVar.f2064b.g();
            ArrayList arrayList = kVar.f2065c;
            int size = arrayList.size();
            while (true) {
                size--;
                e1Var = kVar.f2063a;
                if (size < 0) {
                    break;
                }
                e1Var.getClass();
                k2 childViewHolderInt = getChildViewHolderInt((View) arrayList.get(size));
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(e1Var.f1972a);
                }
                arrayList.remove(size);
            }
            int b10 = e1Var.b();
            while (true) {
                recyclerView = e1Var.f1972a;
                if (i10 >= b10) {
                    break;
                }
                View childAt = recyclerView.getChildAt(i10);
                recyclerView.dispatchChildDetached(childAt);
                childAt.clearAnimation();
                i10++;
            }
            recyclerView.removeAllViews();
            this.mLayout = q1Var;
            if (q1Var != null) {
                if (q1Var.f2144i == null) {
                    q1Var.G0(this);
                    if (this.mIsAttached) {
                        q1 q1Var3 = this.mLayout;
                        q1Var3.f2149n = true;
                        q1Var3.a0(this);
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder("LayoutManager ");
                    sb2.append(q1Var);
                    sb2.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(h.h(q1Var.f2144i, sb2));
                }
            }
            this.mRecycler.o();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z10) {
        u scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f10142d) {
            WeakHashMap weakHashMap = c1.f10054a;
            o0.z(scrollingChildHelper.f10141c);
        }
        scrollingChildHelper.f10142d = z10;
    }

    public void setOnFlingListener(t1 t1Var) {
        this.mOnFlingListener = t1Var;
    }

    @Deprecated
    public void setOnScrollListener(v1 v1Var) {
        this.mScrollListener = v1Var;
    }

    public void setPreserveFocusAfterLayout(boolean z10) {
        this.mPreserveFocusAfterLayout = z10;
    }

    public void setRecycledViewPool(x1 x1Var) {
        y1 y1Var = this.mRecycler;
        RecyclerView recyclerView = y1Var.f2258i;
        y1Var.g(recyclerView.mAdapter, false);
        x1 x1Var2 = y1Var.f2256g;
        if (x1Var2 != null) {
            x1Var2.f2233b--;
        }
        y1Var.f2256g = x1Var;
        if (!(x1Var == null || recyclerView.getAdapter() == null)) {
            y1Var.f2256g.f2233b++;
        }
        y1Var.f();
    }

    @Deprecated
    public void setRecyclerListener(z1 z1Var) {
    }

    public void setScrollState(int i10) {
        f2 f2Var;
        if (i10 != this.mScrollState) {
            this.mScrollState = i10;
            if (i10 != 2) {
                j2 j2Var = this.mViewFlinger;
                j2Var.f2062n.removeCallbacks(j2Var);
                j2Var.f2058j.abortAnimation();
                q1 q1Var = this.mLayout;
                if (!(q1Var == null || (f2Var = q1Var.f2147l) == null)) {
                    f2Var.g();
                }
            }
            dispatchOnScrollStateChanged(i10);
        }
    }

    public void setScrollingTouchSlop(int i10) {
        int i11;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 != 0) {
            if (i10 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i10 + "; using default value");
            } else {
                i11 = viewConfiguration.getScaledPagingTouchSlop();
                this.mTouchSlop = i11;
            }
        }
        i11 = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = i11;
    }

    public void setViewCacheExtension(i2 i2Var) {
        this.mRecycler.f2257h = i2Var;
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i10;
        int i11 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i10 = b.a(accessibilityEvent);
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            i11 = i10;
        }
        this.mEatenAccessibilityChangeFlags |= i11;
        return true;
    }

    public void smoothScrollBy(int i10, int i11) {
        smoothScrollBy(i10, i11, (Interpolator) null);
    }

    public void smoothScrollToPosition(int i10) {
        if (!this.mLayoutSuppressed) {
            q1 q1Var = this.mLayout;
            if (q1Var == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                q1Var.K0(this, i10);
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i10 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i10;
        if (i10 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i10) {
        return getScrollingChildHelper().h(i10, 0);
    }

    public void stopInterceptRequestLayout(boolean z10) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z10 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z10 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    public void stopScroll() {
        f2 f2Var;
        setScrollState(0);
        j2 j2Var = this.mViewFlinger;
        j2Var.f2062n.removeCallbacks(j2Var);
        j2Var.f2058j.abortAnimation();
        q1 q1Var = this.mLayout;
        if (q1Var != null && (f2Var = q1Var.f2147l) != null) {
            f2Var.g();
        }
    }

    public final void suppressLayout(boolean z10) {
        if (z10 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z10) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DECELERATION_RATE, DECELERATION_RATE, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void viewRangeUpdate(int i10, int i11, Object obj) {
        int i12;
        int i13;
        int h10 = this.mChildHelper.h();
        int i14 = i11 + i10;
        for (int i15 = 0; i15 < h10; i15++) {
            View g10 = this.mChildHelper.g(i15);
            k2 childViewHolderInt = getChildViewHolderInt(g10);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i13 = childViewHolderInt.mPosition) >= i10 && i13 < i14) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((r1) g10.getLayoutParams()).f2186j = true;
            }
        }
        y1 y1Var = this.mRecycler;
        ArrayList arrayList = y1Var.f2252c;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                k2 k2Var = (k2) arrayList.get(size);
                if (k2Var != null && (i12 = k2Var.mPosition) >= i10 && i12 < i14) {
                    k2Var.addFlags(2);
                    y1Var.i(size);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x020c A[Catch:{ NoSuchMethodException -> 0x0254, ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0215 A[Catch:{ NoSuchMethodException -> 0x0254, ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RecyclerView(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            r9 = r18
            r10 = r19
            r16.<init>(r17, r18, r19)
            androidx.recyclerview.widget.a2 r0 = new androidx.recyclerview.widget.a2
            r0.<init>(r7)
            r7.mObserver = r0
            androidx.recyclerview.widget.y1 r0 = new androidx.recyclerview.widget.y1
            r0.<init>(r7)
            r7.mRecycler = r0
            androidx.recyclerview.widget.d3 r0 = new androidx.recyclerview.widget.d3
            r0.<init>()
            r7.mViewInfoStore = r0
            androidx.recyclerview.widget.c1 r0 = new androidx.recyclerview.widget.c1
            r11 = 0
            r0.<init>(r7, r11)
            r7.mUpdateChildViewsRunnable = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.mTempRect = r0
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.mTempRect2 = r0
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r7.mTempRectF = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.mRecyclerListeners = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.mItemDecorations = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r7.mOnItemTouchListeners = r0
            r7.mInterceptRequestLayoutDepth = r11
            r7.mDataSetHasChangedAfterLayout = r11
            r7.mDispatchItemsChangedEvent = r11
            r7.mLayoutOrScrollCounter = r11
            r7.mDispatchScrollCounter = r11
            androidx.recyclerview.widget.h2 r0 = sDefaultEdgeEffectFactory
            r7.mEdgeEffectFactory = r0
            androidx.recyclerview.widget.r r0 = new androidx.recyclerview.widget.r
            r0.<init>()
            r7.mItemAnimator = r0
            r7.mScrollState = r11
            r0 = -1
            r7.mScrollPointerId = r0
            r1 = 1
            r7.mScaledHorizontalScrollFactor = r1
            r7.mScaledVerticalScrollFactor = r1
            r12 = 1
            r7.mPreserveFocusAfterLayout = r12
            androidx.recyclerview.widget.j2 r1 = new androidx.recyclerview.widget.j2
            r1.<init>(r7)
            r7.mViewFlinger = r1
            boolean r1 = ALLOW_THREAD_GAP_WORK
            if (r1 == 0) goto L_0x0085
            androidx.recyclerview.widget.i0 r1 = new androidx.recyclerview.widget.i0
            r1.<init>()
            goto L_0x0086
        L_0x0085:
            r1 = 0
        L_0x0086:
            r7.mPrefetchRegistry = r1
            androidx.recyclerview.widget.g2 r1 = new androidx.recyclerview.widget.g2
            r1.<init>()
            r7.mState = r1
            r7.mItemsAddedOrRemoved = r11
            r7.mItemsChanged = r11
            androidx.recyclerview.widget.e1 r1 = new androidx.recyclerview.widget.e1
            r1.<init>(r7)
            r7.mItemAnimatorListener = r1
            r7.mPostedAnimatorRunner = r11
            r14 = 2
            int[] r1 = new int[r14]
            r7.mMinMaxLayoutPositions = r1
            int[] r1 = new int[r14]
            r7.mScrollOffset = r1
            int[] r1 = new int[r14]
            r7.mNestedOffsets = r1
            int[] r1 = new int[r14]
            r7.mReusableIntPair = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r7.mPendingAccessibilityImportanceChange = r1
            androidx.recyclerview.widget.c1 r1 = new androidx.recyclerview.widget.c1
            r1.<init>(r7, r12)
            r7.mItemAnimatorRunner = r1
            r7.mLastAutoMeasureNonExactMeasuredWidth = r11
            r7.mLastAutoMeasureNonExactMeasuredHeight = r11
            androidx.recyclerview.widget.e1 r1 = new androidx.recyclerview.widget.e1
            r1.<init>(r7)
            r7.mViewInfoProcessCallback = r1
            r7.setScrollContainer(r12)
            r7.setFocusableInTouchMode(r12)
            android.view.ViewConfiguration r1 = android.view.ViewConfiguration.get(r17)
            int r2 = r1.getScaledTouchSlop()
            r7.mTouchSlop = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 < r3) goto L_0x00e3
            java.lang.reflect.Method r4 = m0.f1.f10074a
            float r4 = m0.d1.a(r1)
            goto L_0x00e7
        L_0x00e3:
            float r4 = m0.f1.a(r1, r8)
        L_0x00e7:
            r7.mScaledHorizontalScrollFactor = r4
            if (r2 < r3) goto L_0x00f0
            float r4 = m0.d1.b(r1)
            goto L_0x00f4
        L_0x00f0:
            float r4 = m0.f1.a(r1, r8)
        L_0x00f4:
            r7.mScaledVerticalScrollFactor = r4
            int r4 = r1.getScaledMinimumFlingVelocity()
            r7.mMinFlingVelocity = r4
            int r1 = r1.getScaledMaximumFlingVelocity()
            r7.mMaxFlingVelocity = r1
            android.content.res.Resources r1 = r17.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            float r1 = r1.density
            r4 = 1126170624(0x43200000, float:160.0)
            float r1 = r1 * r4
            r4 = 1136724797(0x43c10b3d, float:386.0878)
            float r1 = r1 * r4
            r4 = 1062668861(0x3f570a3d, float:0.84)
            float r1 = r1 * r4
            r7.mPhysicalCoef = r1
            int r1 = r16.getOverScrollMode()
            if (r1 != r14) goto L_0x0124
            r1 = 1
            goto L_0x0125
        L_0x0124:
            r1 = 0
        L_0x0125:
            r7.setWillNotDraw(r1)
            androidx.recyclerview.widget.n1 r1 = r7.mItemAnimator
            androidx.recyclerview.widget.l1 r4 = r7.mItemAnimatorListener
            r1.f2096a = r4
            r16.initAdapterManager()
            androidx.recyclerview.widget.k r1 = new androidx.recyclerview.widget.k
            androidx.recyclerview.widget.e1 r4 = new androidx.recyclerview.widget.e1
            r4.<init>(r7)
            r1.<init>(r4)
            r7.mChildHelper = r1
            java.util.WeakHashMap r1 = m0.c1.f10054a
            if (r2 < r3) goto L_0x0146
            int r1 = m0.s0.b(r16)
            goto L_0x0147
        L_0x0146:
            r1 = 0
        L_0x0147:
            r15 = 8
            if (r1 != 0) goto L_0x0150
            if (r2 < r3) goto L_0x0150
            m0.s0.l(r7, r15)
        L_0x0150:
            int r1 = m0.i0.c(r16)
            if (r1 != 0) goto L_0x0159
            m0.i0.s(r7, r12)
        L_0x0159:
            android.content.Context r1 = r16.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            r7.mAccessibilityManager = r1
            androidx.recyclerview.widget.m2 r1 = new androidx.recyclerview.widget.m2
            r1.<init>(r7)
            r7.setAccessibilityDelegateCompat(r1)
            int[] r3 = q3.a.f13323a
            android.content.res.TypedArray r6 = r8.obtainStyledAttributes(r9, r3, r10, r11)
            r1 = r16
            r2 = r17
            r4 = r18
            r5 = r6
            r13 = r6
            r6 = r19
            m0.c1.o(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = r13.getString(r15)
            int r2 = r13.getInt(r14, r0)
            if (r2 != r0) goto L_0x0191
            r0 = 262144(0x40000, float:3.67342E-40)
            r7.setDescendantFocusability(r0)
        L_0x0191:
            boolean r0 = r13.getBoolean(r12, r12)
            r7.mClipToPadding = r0
            r0 = 3
            boolean r2 = r13.getBoolean(r0, r11)
            r7.mEnableFastScroller = r2
            r3 = 4
            if (r2 == 0) goto L_0x01bb
            r2 = 6
            android.graphics.drawable.Drawable r2 = r13.getDrawable(r2)
            android.graphics.drawable.StateListDrawable r2 = (android.graphics.drawable.StateListDrawable) r2
            r4 = 7
            android.graphics.drawable.Drawable r4 = r13.getDrawable(r4)
            android.graphics.drawable.Drawable r5 = r13.getDrawable(r3)
            android.graphics.drawable.StateListDrawable r5 = (android.graphics.drawable.StateListDrawable) r5
            r6 = 5
            android.graphics.drawable.Drawable r6 = r13.getDrawable(r6)
            r7.initFastScroller(r2, r4, r5, r6)
        L_0x01bb:
            r13.recycle()
            java.lang.String r2 = ": Could not instantiate the LayoutManager: "
            if (r1 == 0) goto L_0x030d
            java.lang.String r1 = r1.trim()
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x030d
            char r4 = r1.charAt(r11)
            r5 = 46
            if (r4 != r5) goto L_0x01e1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r17.getPackageName()
            r4.append(r5)
            goto L_0x01ff
        L_0x01e1:
            java.lang.String r4 = "."
            boolean r4 = r1.contains(r4)
            if (r4 == 0) goto L_0x01ea
            goto L_0x0206
        L_0x01ea:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class<androidx.recyclerview.widget.RecyclerView> r6 = androidx.recyclerview.widget.RecyclerView.class
            java.lang.Package r6 = r6.getPackage()
            java.lang.String r6 = r6.getName()
            r4.append(r6)
            r4.append(r5)
        L_0x01ff:
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x0206:
            boolean r4 = r16.isInEditMode()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            if (r4 == 0) goto L_0x0215
            java.lang.Class r4 = r16.getClass()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            goto L_0x0219
        L_0x0215:
            java.lang.ClassLoader r4 = r17.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
        L_0x0219:
            java.lang.Class r4 = java.lang.Class.forName(r1, r11, r4)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.Class<androidx.recyclerview.widget.q1> r5 = androidx.recyclerview.widget.q1.class
            java.lang.Class r4 = r4.asSubclass(r5)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.Class<?>[] r5 = LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE     // Catch:{ NoSuchMethodException -> 0x023d }
            java.lang.reflect.Constructor r5 = r4.getConstructor(r5)     // Catch:{ NoSuchMethodException -> 0x023d }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x023d }
            r3[r11] = r8     // Catch:{ NoSuchMethodException -> 0x023d }
            r3[r12] = r9     // Catch:{ NoSuchMethodException -> 0x023d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r19)     // Catch:{ NoSuchMethodException -> 0x023d }
            r3[r14] = r6     // Catch:{ NoSuchMethodException -> 0x023d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)     // Catch:{ NoSuchMethodException -> 0x023d }
            r3[r0] = r6     // Catch:{ NoSuchMethodException -> 0x023d }
            r13 = r3
            goto L_0x0246
        L_0x023d:
            r0 = move-exception
            r3 = r0
            java.lang.Class[] r0 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x0254 }
            java.lang.reflect.Constructor r5 = r4.getConstructor(r0)     // Catch:{ NoSuchMethodException -> 0x0254 }
            r13 = 0
        L_0x0246:
            r5.setAccessible(r12)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.Object r0 = r5.newInstance(r13)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            androidx.recyclerview.widget.q1 r0 = (androidx.recyclerview.widget.q1) r0     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            r7.setLayoutManager(r0)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            goto L_0x030d
        L_0x0254:
            r0 = move-exception
            r0.initCause(r3)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            r4.<init>()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.String r5 = r18.getPositionDescription()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.String r5 = ": Error creating LayoutManager "
            r4.append(r5)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            r4.append(r1)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            java.lang.String r4 = r4.toString()     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            r3.<init>(r4, r0)     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
            throw r3     // Catch:{ ClassNotFoundException -> 0x02ee, InvocationTargetException -> 0x02d1, InstantiationException -> 0x02b4, IllegalAccessException -> 0x0295, ClassCastException -> 0x0276 }
        L_0x0276:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getPositionDescription()
            r3.append(r4)
            java.lang.String r4 = ": Class is not a LayoutManager "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L_0x0295:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getPositionDescription()
            r3.append(r4)
            java.lang.String r4 = ": Cannot access non-public constructor "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L_0x02b4:
            r0 = move-exception
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r18.getPositionDescription()
            r4.append(r5)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1, r0)
            throw r3
        L_0x02d1:
            r0 = move-exception
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r18.getPositionDescription()
            r4.append(r5)
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1, r0)
            throw r3
        L_0x02ee:
            r0 = move-exception
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r18.getPositionDescription()
            r3.append(r4)
            java.lang.String r4 = ": Unable to find LayoutManager "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L_0x030d:
            int[] r3 = NESTED_SCROLLING_ATTRS
            android.content.res.TypedArray r0 = r8.obtainStyledAttributes(r9, r3, r10, r11)
            r1 = r16
            r2 = r17
            r4 = r18
            r5 = r0
            r6 = r19
            m0.c1.o(r1, r2, r3, r4, r5, r6)
            boolean r1 = r0.getBoolean(r11, r12)
            r0.recycle()
            r7.setNestedScrollingEnabled(r1)
            r0 = 2131362164(0x7f0a0174, float:1.83441E38)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r7.setTag(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addItemDecoration(o1 o1Var, int i10) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            q1Var.m("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i10 < 0) {
            this.mItemDecorations.add(o1Var);
        } else {
            this.mItemDecorations.add(i10, o1Var);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return getScrollingChildHelper().c(i10, i11, iArr, iArr2, i12);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return getScrollingChildHelper().e(i10, i11, i12, i13, iArr, 0, (int[]) null);
    }

    public k2 findViewHolderForPosition(int i10, boolean z10) {
        int h10 = this.mChildHelper.h();
        k2 k2Var = null;
        for (int i11 = 0; i11 < h10; i11++) {
            k2 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i11));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z10) {
                    if (childViewHolderInt.mPosition != i10) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i10) {
                    continue;
                }
                if (!this.mChildHelper.j(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                k2Var = childViewHolderInt;
            }
        }
        return k2Var;
    }

    public boolean hasNestedScrollingParent(int i10) {
        return getScrollingChildHelper().g(i10);
    }

    public void onExitLayoutOrScroll(boolean z10) {
        int i10 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i10;
        if (i10 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z10) {
                int i11 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i11 != 0 && isAccessibilityEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    b.b(obtain, i11);
                    sendAccessibilityEventUnchecked(obtain);
                }
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator) {
        smoothScrollBy(i10, i11, interpolator, UNDEFINED_DURATION);
    }

    public boolean startNestedScroll(int i10, int i11) {
        return getScrollingChildHelper().h(i10, i11);
    }

    public void stopNestedScroll(int i10) {
        getScrollingChildHelper().i(i10);
    }

    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return getScrollingChildHelper().e(i10, i11, i12, i13, iArr, i14, (int[]) null);
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12) {
        smoothScrollBy(i10, i11, interpolator, i12, false);
    }

    public void smoothScrollBy(int i10, int i11, Interpolator interpolator, int i12, boolean z10) {
        q1 q1Var = this.mLayout;
        if (q1Var == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i13 = 0;
            if (!q1Var.o()) {
                i10 = 0;
            }
            if (!this.mLayout.p()) {
                i11 = 0;
            }
            if (i10 != 0 || i11 != 0) {
                if (i12 == Integer.MIN_VALUE || i12 > 0) {
                    if (z10) {
                        if (i10 != 0) {
                            i13 = 1;
                        }
                        if (i11 != 0) {
                            i13 |= 2;
                        }
                        startNestedScroll(i13, 1);
                    }
                    this.mViewFlinger.c(i10, i11, interpolator, i12);
                    return;
                }
                scrollBy(i10, i11);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        q1 q1Var = this.mLayout;
        if (q1Var != null) {
            return q1Var.E(layoutParams);
        }
        throw new IllegalStateException(h.h(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }
}
