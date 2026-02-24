package androidx.recyclerview.widget;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public final class j2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public int f2056h;

    /* renamed from: i  reason: collision with root package name */
    public int f2057i;

    /* renamed from: j  reason: collision with root package name */
    public OverScroller f2058j;

    /* renamed from: k  reason: collision with root package name */
    public Interpolator f2059k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2060l = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2061m = false;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2062n;

    public j2(RecyclerView recyclerView) {
        this.f2062n = recyclerView;
        Interpolator interpolator = RecyclerView.sQuinticInterpolator;
        this.f2059k = interpolator;
        this.f2058j = new OverScroller(recyclerView.getContext(), interpolator);
    }

    public final void a(int i10, int i11) {
        RecyclerView recyclerView = this.f2062n;
        recyclerView.setScrollState(2);
        this.f2057i = 0;
        this.f2056h = 0;
        Interpolator interpolator = this.f2059k;
        Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
        if (interpolator != interpolator2) {
            this.f2059k = interpolator2;
            this.f2058j = new OverScroller(recyclerView.getContext(), interpolator2);
        }
        this.f2058j.fling(0, 0, i10, i11, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        b();
    }

    public final void b() {
        if (this.f2060l) {
            this.f2061m = true;
            return;
        }
        RecyclerView recyclerView = this.f2062n;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = c1.f10054a;
        i0.m(recyclerView, this);
    }

    public final void c(int i10, int i11, Interpolator interpolator, int i12) {
        boolean z10;
        int i13;
        RecyclerView recyclerView = this.f2062n;
        if (i12 == Integer.MIN_VALUE) {
            int abs = Math.abs(i10);
            int abs2 = Math.abs(i11);
            if (abs > abs2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                i13 = recyclerView.getWidth();
            } else {
                i13 = recyclerView.getHeight();
            }
            if (!z10) {
                abs = abs2;
            }
            i12 = Math.min((int) (((((float) abs) / ((float) i13)) + 1.0f) * 300.0f), 2000);
        }
        int i14 = i12;
        if (interpolator == null) {
            interpolator = RecyclerView.sQuinticInterpolator;
        }
        if (this.f2059k != interpolator) {
            this.f2059k = interpolator;
            this.f2058j = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f2057i = 0;
        this.f2056h = 0;
        recyclerView.setScrollState(2);
        this.f2058j.startScroll(0, 0, i10, i11, i14);
        if (Build.VERSION.SDK_INT < 23) {
            this.f2058j.computeScrollOffset();
        }
        b();
    }

    public final void run() {
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i14;
        RecyclerView recyclerView = this.f2062n;
        if (recyclerView.mLayout == null) {
            recyclerView.removeCallbacks(this);
            this.f2058j.abortAnimation();
            return;
        }
        this.f2061m = false;
        this.f2060l = true;
        recyclerView.consumePendingUpdateOperations();
        OverScroller overScroller = this.f2058j;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            this.f2056h = currX;
            this.f2057i = currY;
            int consumeFlingInHorizontalStretch = recyclerView.consumeFlingInHorizontalStretch(currX - this.f2056h);
            int consumeFlingInVerticalStretch = recyclerView.consumeFlingInVerticalStretch(currY - this.f2057i);
            int[] iArr = recyclerView.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (recyclerView.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, (int[]) null, 1)) {
                int[] iArr2 = recyclerView.mReusableIntPair;
                consumeFlingInHorizontalStretch -= iArr2[0];
                consumeFlingInVerticalStretch -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
            }
            if (recyclerView.mAdapter != null) {
                int[] iArr3 = recyclerView.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                int[] iArr4 = recyclerView.mReusableIntPair;
                int i15 = iArr4[0];
                int i16 = iArr4[1];
                int i17 = consumeFlingInHorizontalStretch - i15;
                int i18 = consumeFlingInVerticalStretch - i16;
                f2 f2Var = recyclerView.mLayout.f2147l;
                if (f2Var != null && !f2Var.f1986d && f2Var.f1987e) {
                    int b10 = recyclerView.mState.b();
                    if (b10 == 0) {
                        f2Var.g();
                    } else {
                        if (f2Var.f1983a >= b10) {
                            f2Var.f1983a = b10 - 1;
                        }
                        f2Var.b(i15, i16);
                    }
                }
                i13 = i16;
                i12 = i15;
                i11 = i17;
                i10 = i18;
            } else {
                i11 = consumeFlingInHorizontalStretch;
                i10 = consumeFlingInVerticalStretch;
                i13 = 0;
                i12 = 0;
            }
            if (!recyclerView.mItemDecorations.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr5 = recyclerView.mReusableIntPair;
            iArr5[0] = 0;
            iArr5[1] = 0;
            recyclerView.dispatchNestedScroll(i12, i13, i11, i10, (int[]) null, 1, iArr5);
            int[] iArr6 = recyclerView.mReusableIntPair;
            int i19 = i11 - iArr6[0];
            int i20 = i10 - iArr6[1];
            if (!(i12 == 0 && i13 == 0)) {
                recyclerView.dispatchOnScrolled(i12, i13);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            if (overScroller.getCurrX() == overScroller.getFinalX()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (overScroller.getCurrY() == overScroller.getFinalY()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (overScroller.isFinished() || ((z10 || i19 != 0) && (z11 || i20 != 0))) {
                z12 = true;
            } else {
                z12 = false;
            }
            f2 f2Var2 = recyclerView.mLayout.f2147l;
            if (f2Var2 == null || !f2Var2.f1986d) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13 || !z12) {
                b();
                k0 k0Var = recyclerView.mGapWorker;
                if (k0Var != null) {
                    k0Var.a(recyclerView, i12, i13);
                }
            } else {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i19 < 0) {
                        i14 = -currVelocity;
                    } else if (i19 > 0) {
                        i14 = currVelocity;
                    } else {
                        i14 = 0;
                    }
                    if (i20 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i20 <= 0) {
                        currVelocity = 0;
                    }
                    recyclerView.absorbGlows(i14, currVelocity);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    i0 i0Var = recyclerView.mPrefetchRegistry;
                    int[] iArr7 = i0Var.f2047c;
                    if (iArr7 != null) {
                        Arrays.fill(iArr7, -1);
                    }
                    i0Var.f2048d = 0;
                }
            }
        }
        f2 f2Var3 = recyclerView.mLayout.f2147l;
        if (f2Var3 != null && f2Var3.f1986d) {
            f2Var3.b(0, 0);
        }
        this.f2060l = false;
        if (this.f2061m) {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = c1.f10054a;
            i0.m(recyclerView, this);
            return;
        }
        recyclerView.setScrollState(0);
        recyclerView.stopNestedScroll(1);
    }
}
