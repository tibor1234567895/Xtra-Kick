package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.l0;
import m0.q2;
import m0.t;
import q0.f;
import t0.c;
import x7.d;
import x7.g;
import x7.i;
import x7.j;
import x7.l;
import x7.m;
import x7.o;
import x7.p;
import z.a;
import z.b;
import z.e;

public class AppBarLayout extends LinearLayout implements a {
    public static final /* synthetic */ int F = 0;
    public final TimeInterpolator A;
    public int[] B;
    public Drawable C;
    public final float D;
    public Behavior E;

    /* renamed from: h  reason: collision with root package name */
    public int f3579h;

    /* renamed from: i  reason: collision with root package name */
    public int f3580i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f3581j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f3582k = -1;

    /* renamed from: l  reason: collision with root package name */
    public boolean f3583l;

    /* renamed from: m  reason: collision with root package name */
    public int f3584m = 0;

    /* renamed from: n  reason: collision with root package name */
    public q2 f3585n;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList f3586o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3587p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3588q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3589r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f3590s;

    /* renamed from: t  reason: collision with root package name */
    public int f3591t;

    /* renamed from: u  reason: collision with root package name */
    public WeakReference f3592u;

    /* renamed from: v  reason: collision with root package name */
    public final ColorStateList f3593v;

    /* renamed from: w  reason: collision with root package name */
    public ValueAnimator f3594w;

    /* renamed from: x  reason: collision with root package name */
    public x7.a f3595x;

    /* renamed from: y  reason: collision with root package name */
    public final ArrayList f3596y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public final long f3597z;

    public static class BaseBehavior<T extends AppBarLayout> extends l {

        /* renamed from: j  reason: collision with root package name */
        public int f3598j;

        /* renamed from: k  reason: collision with root package name */
        public int f3599k;

        /* renamed from: l  reason: collision with root package name */
        public ValueAnimator f3600l;

        /* renamed from: m  reason: collision with root package name */
        public f f3601m;

        /* renamed from: n  reason: collision with root package name */
        public WeakReference f3602n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f3603o;

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
        }

        public static void C(KeyEvent keyEvent, View view, AppBarLayout appBarLayout) {
            if (keyEvent.getAction() == 0 || keyEvent.getAction() == 1) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19 || keyCode == 280 || keyCode == 92) {
                    if (((double) view.getScrollY()) < ((double) view.getMeasuredHeight()) * 0.1d) {
                        appBarLayout.setExpanded(true);
                    }
                } else if ((keyCode == 20 || keyCode == 281 || keyCode == 93) && view.getScrollY() > 0) {
                    appBarLayout.setExpanded(false);
                }
            }
        }

        public static View D(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof t) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void I(androidx.coordinatorlayout.widget.CoordinatorLayout r7, com.google.android.material.appbar.AppBarLayout r8, int r9, int r10, boolean r11) {
            /*
                int r0 = java.lang.Math.abs(r9)
                int r1 = r8.getChildCount()
                r2 = 0
                r3 = 0
            L_0x000a:
                r4 = 0
                if (r3 >= r1) goto L_0x0021
                android.view.View r5 = r8.getChildAt(r3)
                int r6 = r5.getTop()
                if (r0 < r6) goto L_0x001e
                int r6 = r5.getBottom()
                if (r0 > r6) goto L_0x001e
                goto L_0x0022
            L_0x001e:
                int r3 = r3 + 1
                goto L_0x000a
            L_0x0021:
                r5 = r4
            L_0x0022:
                r0 = 1
                if (r5 == 0) goto L_0x005e
                android.view.ViewGroup$LayoutParams r1 = r5.getLayoutParams()
                x7.g r1 = (x7.g) r1
                int r1 = r1.f16722a
                r3 = r1 & 1
                if (r3 == 0) goto L_0x005e
                java.util.WeakHashMap r3 = m0.c1.f10054a
                int r3 = m0.i0.d(r5)
                if (r10 <= 0) goto L_0x004b
                r10 = r1 & 12
                if (r10 == 0) goto L_0x004b
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L_0x005e
                goto L_0x005c
            L_0x004b:
                r10 = r1 & 2
                if (r10 == 0) goto L_0x005e
                int r9 = -r9
                int r10 = r5.getBottom()
                int r10 = r10 - r3
                int r1 = r8.getTopInset()
                int r10 = r10 - r1
                if (r9 < r10) goto L_0x005e
            L_0x005c:
                r9 = 1
                goto L_0x005f
            L_0x005e:
                r9 = 0
            L_0x005f:
                boolean r10 = r8.f3590s
                if (r10 == 0) goto L_0x006b
                android.view.View r9 = D(r7)
                boolean r9 = r8.f(r9)
            L_0x006b:
                boolean r9 = r8.e(r9)
                if (r11 != 0) goto L_0x00ad
                if (r9 == 0) goto L_0x00b0
                z.j r9 = r7.f1186i
                q.k r9 = r9.f17343b
                java.lang.Object r9 = r9.getOrDefault(r8, r4)
                java.util.List r9 = (java.util.List) r9
                java.util.ArrayList r7 = r7.f1188k
                r7.clear()
                if (r9 == 0) goto L_0x0087
                r7.addAll(r9)
            L_0x0087:
                int r9 = r7.size()
                r10 = 0
            L_0x008c:
                if (r10 >= r9) goto L_0x00ab
                java.lang.Object r11 = r7.get(r10)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                z.e r11 = (z.e) r11
                z.b r11 = r11.f17322a
                boolean r1 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r1 == 0) goto L_0x00a8
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r7 = r11.f16740f
                if (r7 == 0) goto L_0x00ab
                r2 = 1
                goto L_0x00ab
            L_0x00a8:
                int r10 = r10 + 1
                goto L_0x008c
            L_0x00ab:
                if (r2 == 0) goto L_0x00b0
            L_0x00ad:
                r8.jumpDrawablesToCurrentState()
            L_0x00b0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.I(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public final void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
            int i11;
            int abs = Math.abs(t() - i10);
            float abs2 = Math.abs(0.0f);
            float f10 = (float) abs;
            if (abs2 > 0.0f) {
                i11 = Math.round((f10 / abs2) * 1000.0f) * 3;
            } else {
                i11 = (int) (((f10 / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            int t10 = t();
            if (t10 == i10) {
                ValueAnimator valueAnimator = this.f3600l;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f3600l.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f3600l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f3600l = valueAnimator3;
                valueAnimator3.setInterpolator(w7.a.f16157e);
                this.f3600l.addUpdateListener(new a(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.f3600l.setDuration((long) Math.min(i11, 600));
            this.f3600l.setIntValues(new int[]{t10, i10});
            this.f3600l.start();
        }

        public final void E(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10, int[] iArr) {
            int i11;
            int i12;
            if (i10 != 0) {
                if (i10 < 0) {
                    int i13 = -appBarLayout.getTotalScrollRange();
                    i12 = i13;
                    i11 = appBarLayout.getDownNestedPreScrollRange() + i13;
                } else {
                    i12 = -appBarLayout.getUpNestedPreScrollRange();
                    i11 = 0;
                }
                if (i12 != i11) {
                    iArr[1] = z(coordinatorLayout, appBarLayout, t() - i10, i12, i11);
                }
            }
            if (appBarLayout.f3590s) {
                appBarLayout.e(appBarLayout.f(view));
            }
        }

        public final f F(Parcelable parcelable, AppBarLayout appBarLayout) {
            boolean z10;
            boolean z11;
            int s10 = s();
            int childCount = appBarLayout.getChildCount();
            boolean z12 = false;
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = appBarLayout.getChildAt(i10);
                int bottom = childAt.getBottom() + s10;
                if (childAt.getTop() + s10 > 0 || bottom < 0) {
                    i10++;
                } else {
                    if (parcelable == null) {
                        parcelable = c.f14483i;
                    }
                    f fVar = new f(parcelable);
                    if (s10 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    fVar.f3641k = z10;
                    if (z10 || (-s10) < appBarLayout.getTotalScrollRange()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    fVar.f3640j = z11;
                    fVar.f3642l = i10;
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (bottom == appBarLayout.getTopInset() + i0.d(childAt)) {
                        z12 = true;
                    }
                    fVar.f3644n = z12;
                    fVar.f3643m = ((float) bottom) / ((float) childAt.getHeight());
                    return fVar;
                }
            }
            return null;
        }

        public final void G(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            boolean z10;
            boolean z11;
            boolean z12;
            boolean z13;
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int t10 = t() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i10 = 0;
            while (true) {
                z10 = true;
                if (i10 >= childCount) {
                    i10 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i10);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                g gVar = (g) childAt.getLayoutParams();
                if ((gVar.f16722a & 32) == 32) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    top -= gVar.topMargin;
                    bottom += gVar.bottomMargin;
                }
                int i11 = -t10;
                if (top <= i11 && bottom >= i11) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i10);
                g gVar2 = (g) childAt2.getLayoutParams();
                int i12 = gVar2.f16722a;
                if ((i12 & 17) == 17) {
                    int i13 = -childAt2.getTop();
                    int i14 = -childAt2.getBottom();
                    if (i10 == 0) {
                        WeakHashMap weakHashMap = c1.f10054a;
                        if (i0.b(appBarLayout) && i0.b(childAt2)) {
                            i13 -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i12 & 2) == 2) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        WeakHashMap weakHashMap2 = c1.f10054a;
                        i14 += i0.d(childAt2);
                    } else {
                        if ((i12 & 5) == 5) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            WeakHashMap weakHashMap3 = c1.f10054a;
                            int d10 = i0.d(childAt2) + i14;
                            if (t10 < d10) {
                                i13 = d10;
                            } else {
                                i14 = d10;
                            }
                        }
                    }
                    if ((i12 & 32) != 32) {
                        z10 = false;
                    }
                    if (z10) {
                        i13 += gVar2.topMargin;
                        i14 -= gVar2.bottomMargin;
                    }
                    if (t10 < (i14 + i13) / 2) {
                        i13 = i14;
                    }
                    B(coordinatorLayout, appBarLayout, h0.a.a(i13 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void H(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View view;
            boolean z10;
            boolean z11;
            boolean z12;
            c1.m(coordinatorLayout, n0.g.f10904f.a());
            boolean z13 = false;
            c1.i(coordinatorLayout, 0);
            c1.m(coordinatorLayout, n0.g.f10905g.a());
            c1.i(coordinatorLayout, 0);
            if (appBarLayout.getTotalScrollRange() != 0) {
                int childCount = coordinatorLayout.getChildCount();
                int i10 = 0;
                while (true) {
                    if (i10 >= childCount) {
                        view = null;
                        break;
                    }
                    view = coordinatorLayout.getChildAt(i10);
                    if (((e) view.getLayoutParams()).f17322a instanceof ScrollingViewBehavior) {
                        break;
                    }
                    i10++;
                }
                View view2 = view;
                if (view2 != null) {
                    int childCount2 = appBarLayout.getChildCount();
                    int i11 = 0;
                    while (true) {
                        z10 = true;
                        if (i11 >= childCount2) {
                            z11 = false;
                            break;
                        } else if (((g) appBarLayout.getChildAt(i11).getLayoutParams()).f16722a != 0) {
                            z11 = true;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (z11) {
                        if (c1.c(coordinatorLayout) != null) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (!z12) {
                            c1.p(coordinatorLayout, new b(this));
                        }
                        if (t() != (-appBarLayout.getTotalScrollRange())) {
                            c1.n(coordinatorLayout, n0.g.f10904f, new d(appBarLayout, false));
                            z13 = true;
                        }
                        if (t() != 0) {
                            if (view2.canScrollVertically(-1)) {
                                int i12 = -appBarLayout.getDownNestedPreScrollRange();
                                if (i12 != 0) {
                                    c1.n(coordinatorLayout, n0.g.f10905g, new c(this, coordinatorLayout, appBarLayout, view2, i12));
                                }
                            } else {
                                c1.n(coordinatorLayout, n0.g.f10905g, new d(appBarLayout, true));
                            }
                            this.f3603o = z10;
                        }
                        z10 = z13;
                        this.f3603o = z10;
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean h(androidx.coordinatorlayout.widget.CoordinatorLayout r5, android.view.View r6, int r7) {
            /*
                r4 = this;
                com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
                super.h(r5, r6, r7)
                int r7 = r6.getPendingAction()
                com.google.android.material.appbar.f r0 = r4.f3601m
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0053
                r3 = r7 & 8
                if (r3 != 0) goto L_0x0053
                boolean r7 = r0.f3640j
                if (r7 == 0) goto L_0x001d
                int r7 = r6.getTotalScrollRange()
                int r7 = -r7
                goto L_0x006b
            L_0x001d:
                boolean r7 = r0.f3641k
                if (r7 == 0) goto L_0x0022
                goto L_0x0078
            L_0x0022:
                int r7 = r0.f3642l
                android.view.View r7 = r6.getChildAt(r7)
                int r0 = r7.getBottom()
                int r0 = -r0
                com.google.android.material.appbar.f r3 = r4.f3601m
                boolean r3 = r3.f3644n
                if (r3 == 0) goto L_0x003e
                int r7 = m0.i0.d(r7)
                int r3 = r6.getTopInset()
                int r3 = r3 + r7
                int r3 = r3 + r0
                goto L_0x004f
            L_0x003e:
                int r7 = r7.getHeight()
                float r7 = (float) r7
                com.google.android.material.appbar.f r3 = r4.f3601m
                float r3 = r3.f3643m
                float r7 = r7 * r3
                int r7 = java.lang.Math.round(r7)
                int r3 = r7 + r0
            L_0x004f:
                r4.A(r5, r6, r3)
                goto L_0x007b
            L_0x0053:
                if (r7 == 0) goto L_0x007b
                r0 = r7 & 4
                if (r0 == 0) goto L_0x005b
                r0 = 1
                goto L_0x005c
            L_0x005b:
                r0 = 0
            L_0x005c:
                r3 = r7 & 2
                if (r3 == 0) goto L_0x006f
                int r7 = r6.getUpNestedPreScrollRange()
                int r7 = -r7
                if (r0 == 0) goto L_0x006b
                r4.B(r5, r6, r7)
                goto L_0x007b
            L_0x006b:
                r4.A(r5, r6, r7)
                goto L_0x007b
            L_0x006f:
                r7 = r7 & r2
                if (r7 == 0) goto L_0x007b
                if (r0 == 0) goto L_0x0078
                r4.B(r5, r6, r1)
                goto L_0x007b
            L_0x0078:
                r4.A(r5, r6, r1)
            L_0x007b:
                r6.f3584m = r1
                r7 = 0
                r4.f3601m = r7
                int r7 = r4.s()
                int r0 = r6.getTotalScrollRange()
                int r0 = -r0
                int r7 = h0.a.a(r7, r0, r1)
                x7.o r0 = r4.f16741a
                if (r0 == 0) goto L_0x009b
                int r3 = r0.f16746d
                if (r3 == r7) goto L_0x009d
                r0.f16746d = r7
                r0.a()
                goto L_0x009d
            L_0x009b:
                r4.f16742b = r7
            L_0x009d:
                int r7 = r4.s()
                I(r5, r6, r7, r1, r2)
                int r7 = r4.s()
                r6.c(r7)
                r4.H(r5, r6)
                android.view.View r5 = D(r5)
                if (r5 == 0) goto L_0x00cb
                int r7 = android.os.Build.VERSION.SDK_INT
                r0 = 28
                if (r7 < r0) goto L_0x00c3
                x7.b r7 = new x7.b
                r7.<init>(r4, r5, r6)
                r5.addOnUnhandledKeyEventListener(r7)
                goto L_0x00cb
            L_0x00c3:
                x7.c r7 = new x7.c
                r7.<init>(r4, r5, r6)
                r5.setOnKeyListener(r7)
            L_0x00cb:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.h(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
        }

        public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((e) appBarLayout.getLayoutParams()).height != -2) {
                return false;
            }
            coordinatorLayout.s(appBarLayout, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        public final /* bridge */ /* synthetic */ void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i10, int i11, int[] iArr, int i12) {
            E(coordinatorLayout, (AppBarLayout) view, view2, i11, iArr);
        }

        public final void l(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i12 < 0) {
                CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                AppBarLayout appBarLayout2 = appBarLayout;
                iArr[1] = z(coordinatorLayout2, appBarLayout2, t() - i12, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i12 == 0) {
                H(coordinatorLayout, appBarLayout);
            }
        }

        public final void n(View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof f) {
                f fVar = this.f3601m;
                this.f3601m = (f) parcelable;
                return;
            }
            this.f3601m = null;
        }

        public final Parcelable o(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            f F = F(absSavedState, (AppBarLayout) view);
            if (F == null) {
                return absSavedState;
            }
            return F;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
            if (r3 != false) goto L_0x002b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean p(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6, int r7) {
            /*
                r2 = this;
                com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
                r6 = r6 & 2
                r0 = 0
                if (r6 == 0) goto L_0x002c
                boolean r6 = r4.f3590s
                r1 = 1
                if (r6 != 0) goto L_0x002b
                int r6 = r4.getTotalScrollRange()
                if (r6 == 0) goto L_0x0014
                r6 = 1
                goto L_0x0015
            L_0x0014:
                r6 = 0
            L_0x0015:
                if (r6 == 0) goto L_0x0028
                int r3 = r3.getHeight()
                int r5 = r5.getHeight()
                int r3 = r3 - r5
                int r4 = r4.getHeight()
                if (r3 > r4) goto L_0x0028
                r3 = 1
                goto L_0x0029
            L_0x0028:
                r3 = 0
            L_0x0029:
                if (r3 == 0) goto L_0x002c
            L_0x002b:
                r0 = 1
            L_0x002c:
                if (r0 == 0) goto L_0x0035
                android.animation.ValueAnimator r3 = r2.f3600l
                if (r3 == 0) goto L_0x0035
                r3.cancel()
            L_0x0035:
                r3 = 0
                r2.f3602n = r3
                r2.f3599k = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.p(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int, int):boolean");
        }

        public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i10) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f3599k == 0 || i10 == 1) {
                G(coordinatorLayout, appBarLayout);
                if (appBarLayout.f3590s) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.f3602n = new WeakReference(view2);
        }

        public final int t() {
            return s() + this.f3598j;
        }

        public final boolean v(View view) {
            View view2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference weakReference = this.f3602n;
            if (weakReference == null || ((view2 = (View) weakReference.get()) != null && view2.isShown() && !view2.canScrollVertically(-1))) {
                return true;
            }
            return false;
        }

        public final int w(View view) {
            return -((AppBarLayout) view).getDownNestedScrollRange();
        }

        public final int x(View view) {
            return ((AppBarLayout) view).getTotalScrollRange();
        }

        public final void y(View view, CoordinatorLayout coordinatorLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            G(coordinatorLayout, appBarLayout);
            if (appBarLayout.f3590s) {
                appBarLayout.e(appBarLayout.f(D(coordinatorLayout)));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0152  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int z(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, int r21, int r22, int r23) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                r2 = r22
                r3 = r20
                com.google.android.material.appbar.AppBarLayout r3 = (com.google.android.material.appbar.AppBarLayout) r3
                int r4 = r18.t()
                r5 = 0
                if (r2 == 0) goto L_0x0158
                if (r4 < r2) goto L_0x0158
                r6 = r23
                if (r4 > r6) goto L_0x0158
                int r2 = h0.a.a(r21, r22, r23)
                if (r4 == r2) goto L_0x015a
                boolean r6 = r3.f3583l
                if (r6 == 0) goto L_0x0094
                int r6 = java.lang.Math.abs(r2)
                int r7 = r3.getChildCount()
                r8 = 0
            L_0x002a:
                if (r8 >= r7) goto L_0x0094
                android.view.View r9 = r3.getChildAt(r8)
                android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
                x7.g r10 = (x7.g) r10
                android.view.animation.Interpolator r11 = r10.f16724c
                int r12 = r9.getTop()
                if (r6 < r12) goto L_0x0091
                int r12 = r9.getBottom()
                if (r6 > r12) goto L_0x0091
                if (r11 == 0) goto L_0x0094
                int r7 = r10.f16722a
                r8 = r7 & 1
                if (r8 == 0) goto L_0x0063
                int r8 = r9.getHeight()
                int r12 = r10.topMargin
                int r8 = r8 + r12
                int r10 = r10.bottomMargin
                int r8 = r8 + r10
                int r8 = r8 + r5
                r7 = r7 & 2
                if (r7 == 0) goto L_0x0064
                java.util.WeakHashMap r7 = m0.c1.f10054a
                int r7 = m0.i0.d(r9)
                int r8 = r8 - r7
                goto L_0x0064
            L_0x0063:
                r8 = 0
            L_0x0064:
                java.util.WeakHashMap r7 = m0.c1.f10054a
                boolean r7 = m0.i0.b(r9)
                if (r7 == 0) goto L_0x0071
                int r7 = r3.getTopInset()
                int r8 = r8 - r7
            L_0x0071:
                if (r8 <= 0) goto L_0x0094
                int r7 = r9.getTop()
                int r6 = r6 - r7
                float r7 = (float) r8
                float r6 = (float) r6
                float r6 = r6 / r7
                float r6 = r11.getInterpolation(r6)
                float r6 = r6 * r7
                int r6 = java.lang.Math.round(r6)
                int r7 = java.lang.Integer.signum(r2)
                int r8 = r9.getTop()
                int r8 = r8 + r6
                int r8 = r8 * r7
                goto L_0x0095
            L_0x0091:
                int r8 = r8 + 1
                goto L_0x002a
            L_0x0094:
                r8 = r2
            L_0x0095:
                x7.o r6 = r0.f16741a
                r7 = 1
                if (r6 == 0) goto L_0x00a7
                int r9 = r6.f16746d
                if (r9 == r8) goto L_0x00a5
                r6.f16746d = r8
                r6.a()
                r6 = 1
                goto L_0x00aa
            L_0x00a5:
                r6 = 0
                goto L_0x00aa
            L_0x00a7:
                r0.f16742b = r8
                goto L_0x00a5
            L_0x00aa:
                int r9 = r4 - r2
                int r8 = r2 - r8
                r0.f3598j = r8
                if (r6 == 0) goto L_0x0140
                r8 = 0
            L_0x00b3:
                int r10 = r3.getChildCount()
                if (r8 >= r10) goto L_0x0140
                android.view.View r10 = r3.getChildAt(r8)
                android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
                x7.g r10 = (x7.g) r10
                x7.f r11 = r10.f16723b
                if (r11 == 0) goto L_0x013c
                int r10 = r10.f16722a
                r10 = r10 & r7
                if (r10 == 0) goto L_0x013c
                android.view.View r10 = r3.getChildAt(r8)
                int r12 = r18.s()
                float r12 = (float) r12
                android.graphics.Rect r13 = r11.f16720a
                r10.getDrawingRect(r13)
                r3.offsetDescendantRectToMyCoords(r10, r13)
                int r14 = r3.getTopInset()
                int r14 = -r14
                r13.offset(r5, r14)
                int r14 = r13.top
                float r14 = (float) r14
                float r12 = java.lang.Math.abs(r12)
                float r14 = r14 - r12
                r12 = 0
                int r15 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
                if (r15 > 0) goto L_0x0133
                int r15 = r13.height()
                float r15 = (float) r15
                float r15 = r14 / r15
                float r15 = java.lang.Math.abs(r15)
                r16 = 1065353216(0x3f800000, float:1.0)
                int r17 = (r15 > r12 ? 1 : (r15 == r12 ? 0 : -1))
                if (r17 >= 0) goto L_0x0104
                goto L_0x010c
            L_0x0104:
                int r12 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
                if (r12 <= 0) goto L_0x010b
                r12 = 1065353216(0x3f800000, float:1.0)
                goto L_0x010c
            L_0x010b:
                r12 = r15
            L_0x010c:
                float r14 = -r14
                float r12 = r16 - r12
                float r12 = r12 * r12
                float r16 = r16 - r12
                int r12 = r13.height()
                float r12 = (float) r12
                r13 = 1050253722(0x3e99999a, float:0.3)
                float r12 = r12 * r13
                float r12 = r12 * r16
                float r14 = r14 - r12
                r10.setTranslationY(r14)
                android.graphics.Rect r11 = r11.f16721b
                r10.getDrawingRect(r11)
                float r12 = -r14
                int r12 = (int) r12
                r11.offset(r5, r12)
                java.util.WeakHashMap r12 = m0.c1.f10054a
                m0.k0.c(r10, r11)
                goto L_0x013c
            L_0x0133:
                java.util.WeakHashMap r11 = m0.c1.f10054a
                r11 = 0
                m0.k0.c(r10, r11)
                r10.setTranslationY(r12)
            L_0x013c:
                int r8 = r8 + 1
                goto L_0x00b3
            L_0x0140:
                if (r6 != 0) goto L_0x0149
                boolean r6 = r3.f3583l
                if (r6 == 0) goto L_0x0149
                r1.i(r3)
            L_0x0149:
                int r6 = r18.s()
                r3.c(r6)
                if (r2 >= r4) goto L_0x0153
                r7 = -1
            L_0x0153:
                I(r1, r3, r2, r7, r5)
                r5 = r9
                goto L_0x015a
            L_0x0158:
                r0.f3598j = r5
            L_0x015a:
                r0.H(r1, r3)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends m {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v7.a.C);
            this.f16740f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        public final boolean b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            int i10;
            b bVar = ((e) view2.getLayoutParams()).f17322a;
            if (bVar instanceof BaseBehavior) {
                int bottom = (view2.getBottom() - view.getTop()) + ((BaseBehavior) bVar).f3598j + this.f16739e;
                if (this.f16740f == 0) {
                    i10 = 0;
                } else {
                    float w10 = w(view2);
                    int i11 = this.f16740f;
                    i10 = h0.a.a((int) (w10 * ((float) i11)), 0, i11);
                }
                c1.k(view, bottom - i10);
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.f3590s) {
                    appBarLayout.e(appBarLayout.f(view));
                }
            }
            return false;
        }

        public final void e(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                c1.m(coordinatorLayout, n0.g.f10904f.a());
                c1.i(coordinatorLayout, 0);
                c1.m(coordinatorLayout, n0.g.f10905g.a());
                c1.i(coordinatorLayout, 0);
                c1.p(coordinatorLayout, (m0.c) null);
            }
        }

        public final boolean m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout appBarLayout;
            ArrayList k10 = coordinatorLayout.k(view);
            int size = k10.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    appBarLayout = null;
                    break;
                }
                View view2 = (View) k10.get(i10);
                if (view2 instanceof AppBarLayout) {
                    appBarLayout = (AppBarLayout) view2;
                    break;
                }
                i10++;
            }
            if (appBarLayout != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f16737c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayout.d(false, !z10, true);
                    return true;
                }
            }
            return false;
        }

        public final AppBarLayout v(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) arrayList.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final float w(View view) {
            int i10;
            int i11;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                b bVar = ((e) appBarLayout.getLayoutParams()).f17322a;
                if (bVar instanceof BaseBehavior) {
                    i10 = ((BaseBehavior) bVar).t();
                } else {
                    i10 = 0;
                }
                if ((downNestedPreScrollRange == 0 || totalScrollRange + i10 > downNestedPreScrollRange) && (i11 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) i10) / ((float) i11)) + 1.0f;
                }
            }
            return 0.0f;
        }

        public final int x(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return view.getMeasuredHeight();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(android.content.Context r15, android.util.AttributeSet r16) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r2 = 2130968642(0x7f040042, float:1.7545943E38)
            r3 = 2132018095(0x7f1403af, float:1.9674487E38)
            r4 = r15
            android.content.Context r3 = a9.a.a(r15, r0, r2, r3)
            r14.<init>(r3, r0, r2)
            r8 = -1
            r1.f3580i = r8
            r1.f3581j = r8
            r1.f3582k = r8
            r9 = 0
            r1.f3584m = r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f3596y = r2
            android.content.Context r10 = r14.getContext()
            r11 = 1
            r14.setOrientation(r11)
            int r12 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r2 = r14.getOutlineProvider()
            android.view.ViewOutlineProvider r3 = android.view.ViewOutlineProvider.BACKGROUND
            if (r2 != r3) goto L_0x0039
            android.view.ViewOutlineProvider r2 = android.view.ViewOutlineProvider.BOUNDS
            r14.setOutlineProvider(r2)
        L_0x0039:
            r6 = 2132018095(0x7f1403af, float:1.9674487E38)
            android.content.Context r13 = r14.getContext()
            int[] r4 = x7.p.f16747a
            int[] r7 = new int[r9]
            r5 = 2130968642(0x7f040042, float:1.7545943E38)
            r2 = r13
            r3 = r16
            android.content.res.TypedArray r2 = m8.r.d(r2, r3, r4, r5, r6, r7)
            boolean r3 = r2.hasValue(r9)     // Catch:{ all -> 0x0154 }
            if (r3 == 0) goto L_0x005f
            int r3 = r2.getResourceId(r9, r9)     // Catch:{ all -> 0x0154 }
            android.animation.StateListAnimator r3 = android.animation.AnimatorInflater.loadStateListAnimator(r13, r3)     // Catch:{ all -> 0x0154 }
            r14.setStateListAnimator(r3)     // Catch:{ all -> 0x0154 }
        L_0x005f:
            r2.recycle()
            int[] r4 = v7.a.f15932a
            r6 = 2132018095(0x7f1403af, float:1.9674487E38)
            int[] r7 = new int[r9]
            r5 = 2130968642(0x7f040042, float:1.7545943E38)
            r2 = r10
            r3 = r16
            android.content.res.TypedArray r0 = m8.r.d(r2, r3, r4, r5, r6, r7)
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r9)
            java.util.WeakHashMap r3 = m0.c1.f10054a
            m0.i0.q(r14, r2)
            r2 = 6
            android.content.res.ColorStateList r2 = q8.d.a(r10, r0, r2)
            r1.f3593v = r2
            android.graphics.drawable.Drawable r3 = r14.getBackground()
            boolean r3 = r3 instanceof android.graphics.drawable.ColorDrawable
            if (r3 == 0) goto L_0x00c6
            android.graphics.drawable.Drawable r3 = r14.getBackground()
            android.graphics.drawable.ColorDrawable r3 = (android.graphics.drawable.ColorDrawable) r3
            t8.i r4 = new t8.i
            r4.<init>()
            int r3 = r3.getColor()
            android.content.res.ColorStateList r3 = android.content.res.ColorStateList.valueOf(r3)
            r4.k(r3)
            if (r2 == 0) goto L_0x00b9
            boolean r3 = r1.f3589r
            if (r3 == 0) goto L_0x00aa
            r3 = 255(0xff, float:3.57E-43)
            goto L_0x00ab
        L_0x00aa:
            r3 = 0
        L_0x00ab:
            r4.setAlpha(r3)
            r4.k(r2)
            x7.a r2 = new x7.a
            r2.<init>(r14, r9, r4)
            r1.f3595x = r2
            goto L_0x00c3
        L_0x00b9:
            r4.i(r10)
            x7.a r2 = new x7.a
            r2.<init>(r14, r11, r4)
            r1.f3595x = r2
        L_0x00c3:
            m0.i0.q(r14, r4)
        L_0x00c6:
            android.content.res.Resources r2 = r14.getResources()
            r3 = 2131427330(0x7f0b0002, float:1.8476273E38)
            int r2 = r2.getInteger(r3)
            r3 = 2130969443(0x7f040363, float:1.7547568E38)
            int r2 = n8.a.c(r10, r3, r2)
            long r2 = (long) r2
            r1.f3597z = r2
            android.view.animation.LinearInterpolator r2 = w7.a.f16153a
            r3 = 2130969461(0x7f040375, float:1.7547605E38)
            android.animation.TimeInterpolator r2 = n8.a.d(r10, r3, r2)
            r1.A = r2
            r2 = 4
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x00f4
            boolean r2 = r0.getBoolean(r2, r9)
            r14.d(r2, r9, r9)
        L_0x00f4:
            r2 = 3
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x0103
            int r2 = r0.getDimensionPixelSize(r2, r9)
            float r2 = (float) r2
            x7.p.a(r14, r2)
        L_0x0103:
            r2 = 26
            if (r12 < r2) goto L_0x0122
            r2 = 2
            boolean r3 = r0.hasValue(r2)
            if (r3 == 0) goto L_0x0115
            boolean r2 = r0.getBoolean(r2, r9)
            r14.setKeyboardNavigationCluster(r2)
        L_0x0115:
            boolean r2 = r0.hasValue(r11)
            if (r2 == 0) goto L_0x0122
            boolean r2 = r0.getBoolean(r11, r9)
            r14.setTouchscreenBlocksFocus(r2)
        L_0x0122:
            android.content.res.Resources r2 = r14.getResources()
            r3 = 2131165278(0x7f07005e, float:1.7944769E38)
            float r2 = r2.getDimension(r3)
            r1.D = r2
            r2 = 5
            boolean r2 = r0.getBoolean(r2, r9)
            r1.f3590s = r2
            r2 = 7
            int r2 = r0.getResourceId(r2, r8)
            r1.f3591t = r2
            r2 = 8
            android.graphics.drawable.Drawable r2 = r0.getDrawable(r2)
            r14.setStatusBarForeground(r2)
            r0.recycle()
            b4.e0 r0 = new b4.e0
            r2 = 17
            r0.<init>(r2, r14)
            m0.o0.u(r14, r0)
            return
        L_0x0154:
            r0 = move-exception
            r2.recycle()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static g a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new g((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public final void b() {
        f fVar;
        Behavior behavior = this.E;
        if (behavior == null || this.f3580i == -1 || this.f3584m != 0) {
            fVar = null;
        } else {
            fVar = behavior.F(c.f14483i, this);
        }
        this.f3580i = -1;
        this.f3581j = -1;
        this.f3582k = -1;
        if (fVar != null) {
            Behavior behavior2 = this.E;
            if (behavior2.f3601m == null) {
                behavior2.f3601m = fVar;
            }
        }
    }

    public final void c(int i10) {
        int i11;
        int i12;
        this.f3579h = i10;
        if (!willNotDraw()) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
        ArrayList arrayList = this.f3586o;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i13 = 0; i13 < size; i13++) {
                d dVar = (d) this.f3586o.get(i13);
                if (dVar != null) {
                    CollapsingToolbarLayout collapsingToolbarLayout = ((j) dVar).f16729a;
                    collapsingToolbarLayout.F = i10;
                    q2 q2Var = collapsingToolbarLayout.H;
                    if (q2Var != null) {
                        i11 = q2Var.e();
                    } else {
                        i11 = 0;
                    }
                    int childCount = collapsingToolbarLayout.getChildCount();
                    for (int i14 = 0; i14 < childCount; i14++) {
                        View childAt = collapsingToolbarLayout.getChildAt(i14);
                        i iVar = (i) childAt.getLayoutParams();
                        o b10 = CollapsingToolbarLayout.b(childAt);
                        int i15 = iVar.f16727a;
                        if (i15 == 1) {
                            i12 = h0.a.a(-i10, 0, ((collapsingToolbarLayout.getHeight() - CollapsingToolbarLayout.b(childAt).f16744b) - childAt.getHeight()) - ((i) childAt.getLayoutParams()).bottomMargin);
                        } else if (i15 != 2) {
                        } else {
                            i12 = Math.round(((float) (-i10)) * iVar.f16728b);
                        }
                        if (b10.f16746d != i12) {
                            b10.f16746d = i12;
                            b10.a();
                        }
                    }
                    collapsingToolbarLayout.d();
                    if (collapsingToolbarLayout.f3619w != null && i11 > 0) {
                        WeakHashMap weakHashMap2 = c1.f10054a;
                        i0.k(collapsingToolbarLayout);
                    }
                    int height = collapsingToolbarLayout.getHeight();
                    WeakHashMap weakHashMap3 = c1.f10054a;
                    int d10 = (height - i0.d(collapsingToolbarLayout)) - i11;
                    float scrimVisibleHeightTrigger = (float) (height - collapsingToolbarLayout.getScrimVisibleHeightTrigger());
                    float f10 = (float) d10;
                    float min = Math.min(1.0f, scrimVisibleHeightTrigger / f10);
                    m8.d dVar2 = collapsingToolbarLayout.f3614r;
                    dVar2.f10725d = min;
                    dVar2.f10727e = f.f(1.0f, min, 0.5f, min);
                    dVar2.f10729f = collapsingToolbarLayout.F + d10;
                    dVar2.p(((float) Math.abs(i10)) / f10);
                }
            }
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    public final void d(boolean z10, boolean z11, boolean z12) {
        int i10 = 0;
        int i11 = (z10 ? 1 : 2) | (z11 ? 4 : 0);
        if (z12) {
            i10 = 8;
        }
        this.f3584m = i11 | i10;
        requestLayout();
    }

    public final void draw(Canvas canvas) {
        boolean z10;
        super.draw(canvas);
        if (this.C == null || getTopInset() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f3579h));
            this.C.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z10) {
        float f10;
        float f11;
        if (!(!this.f3587p) || this.f3589r == z10) {
            return false;
        }
        this.f3589r = z10;
        refreshDrawableState();
        if (!this.f3590s || !(getBackground() instanceof t8.i)) {
            return true;
        }
        float f12 = 0.0f;
        if (this.f3593v != null) {
            if (z10) {
                f10 = 0.0f;
            } else {
                f10 = 255.0f;
            }
            if (z10) {
                f12 = 255.0f;
            }
        } else {
            float f13 = this.D;
            if (z10) {
                f11 = 0.0f;
            } else {
                f11 = f13;
            }
            if (z10) {
                f12 = f13;
            }
        }
        ValueAnimator valueAnimator = this.f3594w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f10, f12});
        this.f3594w = ofFloat;
        ofFloat.setDuration(this.f3597z);
        this.f3594w.setInterpolator(this.A);
        x7.a aVar = this.f3595x;
        if (aVar != null) {
            this.f3594w.addUpdateListener(aVar);
        }
        this.f3594w.start();
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(android.view.View r5) {
        /*
            r4 = this;
            java.lang.ref.WeakReference r0 = r4.f3592u
            r1 = -1
            r2 = 0
            if (r0 != 0) goto L_0x0031
            int r0 = r4.f3591t
            if (r0 == r1) goto L_0x0031
            if (r5 == 0) goto L_0x0011
            android.view.View r0 = r5.findViewById(r0)
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            if (r0 != 0) goto L_0x0028
            android.view.ViewParent r3 = r4.getParent()
            boolean r3 = r3 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0028
            android.view.ViewParent r0 = r4.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r3 = r4.f3591t
            android.view.View r0 = r0.findViewById(r3)
        L_0x0028:
            if (r0 == 0) goto L_0x0031
            java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference
            r3.<init>(r0)
            r4.f3592u = r3
        L_0x0031:
            java.lang.ref.WeakReference r0 = r4.f3592u
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r0.get()
            r2 = r0
            android.view.View r2 = (android.view.View) r2
        L_0x003c:
            if (r2 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r5 = r2
        L_0x0040:
            if (r5 == 0) goto L_0x0050
            boolean r0 = r5.canScrollVertically(r1)
            if (r0 != 0) goto L_0x004e
            int r5 = r5.getScrollY()
            if (r5 <= 0) goto L_0x0050
        L_0x004e:
            r5 = 1
            goto L_0x0051
        L_0x0050:
            r5 = 0
        L_0x0051:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.f(android.view.View):boolean");
    }

    public final boolean g() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8) {
            return false;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        if (!i0.b(childAt)) {
            return true;
        }
        return false;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }

    public b getBehavior() {
        Behavior behavior = new Behavior();
        this.E = behavior;
        return behavior;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.f3581j
            r1 = -1
            if (r0 == r1) goto L_0x0006
            return r0
        L_0x0006:
            int r0 = r9.getChildCount()
            int r0 = r0 + -1
            r1 = 0
            r2 = 0
        L_0x000e:
            if (r0 < 0) goto L_0x0069
            android.view.View r3 = r9.getChildAt(r0)
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x001d
            goto L_0x0066
        L_0x001d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            x7.g r4 = (x7.g) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.f16722a
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L_0x0063
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L_0x003f
            java.util.WeakHashMap r4 = m0.c1.f10054a
            int r4 = m0.i0.d(r3)
        L_0x003d:
            int r4 = r4 + r7
            goto L_0x004e
        L_0x003f:
            r4 = r6 & 2
            if (r4 == 0) goto L_0x004c
            java.util.WeakHashMap r4 = m0.c1.f10054a
            int r4 = m0.i0.d(r3)
            int r4 = r5 - r4
            goto L_0x003d
        L_0x004c:
            int r4 = r7 + r5
        L_0x004e:
            if (r0 != 0) goto L_0x0061
            java.util.WeakHashMap r6 = m0.c1.f10054a
            boolean r3 = m0.i0.b(r3)
            if (r3 == 0) goto L_0x0061
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L_0x0061:
            int r2 = r2 + r4
            goto L_0x0066
        L_0x0063:
            if (r2 <= 0) goto L_0x0066
            goto L_0x0069
        L_0x0066:
            int r0 = r0 + -1
            goto L_0x000e
        L_0x0069:
            int r0 = java.lang.Math.max(r1, r2)
            r9.f3581j = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f3582k;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredHeight = gVar.topMargin + gVar.bottomMargin + childAt.getMeasuredHeight();
                int i13 = gVar.f16722a;
                if ((i13 & 1) == 0) {
                    break;
                }
                i12 += measuredHeight;
                if ((i13 & 2) != 0) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    i12 -= i0.d(childAt);
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f3582k = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f3591t;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = c1.f10054a;
        int d10 = i0.d(this);
        if (d10 == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                d10 = i0.d(getChildAt(childCount - 1));
            } else {
                d10 = 0;
            }
            if (d10 == 0) {
                return getHeight() / 3;
            }
        }
        return (d10 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f3584m;
    }

    public Drawable getStatusBarForeground() {
        return this.C;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        q2 q2Var = this.f3585n;
        if (q2Var != null) {
            return q2Var.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f3580i;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i13 = gVar.f16722a;
                if ((i13 & 1) == 0) {
                    break;
                }
                int i14 = measuredHeight + gVar.topMargin + gVar.bottomMargin + i12;
                if (i11 == 0) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (i0.b(childAt)) {
                        i14 -= getTopInset();
                    }
                }
                i12 = i14;
                if ((i13 & 2) != 0) {
                    WeakHashMap weakHashMap2 = c1.f10054a;
                    i12 -= i0.d(childAt);
                    break;
                }
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f3580i = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t8.j.c(this);
    }

    public final int[] onCreateDrawableState(int i10) {
        if (this.B == null) {
            this.B = new int[4];
        }
        int[] iArr = this.B;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f3588q;
        iArr[0] = z10 ? R.attr.state_liftable : -2130969710;
        iArr[1] = (!z10 || !this.f3589r) ? -2130969711 : R.attr.state_lifted;
        iArr[2] = z10 ? R.attr.state_collapsible : -2130969706;
        iArr[3] = (!z10 || !this.f3589r) ? -2130969705 : R.attr.state_collapsed;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f3592u;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f3592u = null;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        boolean z12;
        super.onLayout(z10, i10, i11, i12, i13);
        WeakHashMap weakHashMap = c1.f10054a;
        boolean z13 = true;
        if (i0.b(this) && g()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                c1.k(getChildAt(childCount), topInset);
            }
        }
        b();
        this.f3583l = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            } else if (((g) getChildAt(i14).getLayoutParams()).f16724c != null) {
                this.f3583l = true;
                break;
            } else {
                i14++;
            }
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f3587p) {
            if (!this.f3590s) {
                int childCount3 = getChildCount();
                int i15 = 0;
                while (true) {
                    if (i15 >= childCount3) {
                        z11 = false;
                        break;
                    }
                    int i16 = ((g) getChildAt(i15).getLayoutParams()).f16722a;
                    if ((i16 & 1) != 1 || (i16 & 10) == 0) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    if (z12) {
                        z11 = true;
                        break;
                    }
                    i15++;
                }
                if (!z11) {
                    z13 = false;
                }
            }
            if (this.f3588q != z13) {
                this.f3588q = z13;
                refreshDrawableState();
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (i0.b(this) && g()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = h0.a.a(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i11));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        b();
    }

    public void setElevation(float f10) {
        super.setElevation(f10);
        t8.j.b(this, f10);
    }

    public void setExpanded(boolean z10) {
        WeakHashMap weakHashMap = c1.f10054a;
        d(z10, l0.c(this), true);
    }

    public void setLiftOnScroll(boolean z10) {
        this.f3590s = z10;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f3591t = -1;
        if (view == null) {
            WeakReference weakReference = this.f3592u;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f3592u = null;
            return;
        }
        this.f3592u = new WeakReference(view);
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f3591t = i10;
        WeakReference weakReference = this.f3592u;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f3592u = null;
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f3587p = z10;
    }

    public void setOrientation(int i10) {
        if (i10 == 1) {
            super.setOrientation(i10);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.C;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.C = drawable3;
            boolean z11 = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.C.setState(getDrawableState());
                }
                Drawable drawable4 = this.C;
                WeakHashMap weakHashMap = c1.f10054a;
                f0.d.c(drawable4, j0.d(this));
                Drawable drawable5 = this.C;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable5.setVisible(z10, false);
                this.C.setCallback(this);
            }
            if (this.C != null && getTopInset() > 0) {
                z11 = true;
            }
            setWillNotDraw(!z11);
            WeakHashMap weakHashMap2 = c1.f10054a;
            i0.k(this);
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(h.a.a(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        p.a(this, f10);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.C;
    }

    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public final LinearLayout.LayoutParams m9generateDefaultLayoutParams() {
        return new g();
    }

    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public final LinearLayout.LayoutParams m10generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }
}
