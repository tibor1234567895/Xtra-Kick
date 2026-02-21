package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;

public class StaggeredGridLayoutManager extends q1 implements e2 {
    public int A;
    public int B;
    public final o0 C;
    public boolean D;
    public boolean E;
    public BitSet F;
    public int G;
    public int H;
    public final v2 I;
    public final int J;
    public boolean K;
    public boolean L;
    public x2 M;
    public final Rect N;
    public final r2 O;
    public final boolean P;
    public int[] Q;
    public final c0 R;

    /* renamed from: w  reason: collision with root package name */
    public int f1921w = -1;

    /* renamed from: x  reason: collision with root package name */
    public y2[] f1922x;

    /* renamed from: y  reason: collision with root package name */
    public z0 f1923y;

    /* renamed from: z  reason: collision with root package name */
    public z0 f1924z;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.D = false;
        this.E = false;
        this.G = -1;
        this.H = RecyclerView.UNDEFINED_DURATION;
        v2 v2Var = new v2();
        this.I = v2Var;
        this.J = 2;
        this.N = new Rect();
        this.O = new r2(this);
        this.P = true;
        this.R = new c0(1, this);
        p1 P2 = q1.P(context, attributeSet, i10, i11);
        int i12 = P2.f2128a;
        if (i12 == 0 || i12 == 1) {
            m((String) null);
            if (i12 != this.A) {
                this.A = i12;
                z0 z0Var = this.f1923y;
                this.f1923y = this.f1924z;
                this.f1924z = z0Var;
                y0();
            }
            int i13 = P2.f2129b;
            m((String) null);
            if (i13 != this.f1921w) {
                v2Var.a();
                y0();
                this.f1921w = i13;
                this.F = new BitSet(this.f1921w);
                this.f1922x = new y2[this.f1921w];
                for (int i14 = 0; i14 < this.f1921w; i14++) {
                    this.f1922x[i14] = new y2(this, i14);
                }
                y0();
            }
            boolean z10 = P2.f2130c;
            m((String) null);
            x2 x2Var = this.M;
            if (!(x2Var == null || x2Var.f2242o == z10)) {
                x2Var.f2242o = z10;
            }
            this.D = z10;
            y0();
            this.C = new o0();
            this.f1923y = z0.b(this, this.A);
            this.f1924z = z0.b(this, 1 - this.A);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public static int p1(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    public final void A0(int i10) {
        x2 x2Var = this.M;
        if (!(x2Var == null || x2Var.f2235h == i10)) {
            x2Var.f2238k = null;
            x2Var.f2237j = 0;
            x2Var.f2235h = -1;
            x2Var.f2236i = -1;
        }
        this.G = i10;
        this.H = RecyclerView.UNDEFINED_DURATION;
        y0();
    }

    public final int B0(int i10, y1 y1Var, g2 g2Var) {
        return l1(i10, y1Var, g2Var);
    }

    public final r1 C() {
        return this.A == 0 ? new s2(-2, -1) : new s2(-1, -2);
    }

    public final r1 D(Context context, AttributeSet attributeSet) {
        return new s2(context, attributeSet);
    }

    public final r1 E(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new s2((ViewGroup.MarginLayoutParams) layoutParams) : new s2(layoutParams);
    }

    public final void E0(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.A == 1) {
            int height = rect.height() + paddingBottom;
            RecyclerView recyclerView = this.f2144i;
            WeakHashMap weakHashMap = c1.f10054a;
            i13 = q1.r(i11, height, i0.d(recyclerView));
            i12 = q1.r(i10, (this.B * this.f1921w) + paddingRight, i0.e(this.f2144i));
        } else {
            int width = rect.width() + paddingRight;
            RecyclerView recyclerView2 = this.f2144i;
            WeakHashMap weakHashMap2 = c1.f10054a;
            i12 = q1.r(i10, width, i0.e(recyclerView2));
            i13 = q1.r(i11, (this.B * this.f1921w) + paddingBottom, i0.d(this.f2144i));
        }
        this.f2144i.setMeasuredDimension(i12, i13);
    }

    public final void K0(RecyclerView recyclerView, int i10) {
        u0 u0Var = new u0(recyclerView.getContext());
        u0Var.f1983a = i10;
        L0(u0Var);
    }

    public final boolean M0() {
        return this.M == null;
    }

    public final int N0(int i10) {
        if (H() == 0) {
            return this.E ? 1 : -1;
        }
        return (i10 < X0()) != this.E ? -1 : 1;
    }

    public final boolean O0() {
        int i10;
        if (!(H() == 0 || this.J == 0 || !this.f2149n)) {
            if (this.E) {
                i10 = Y0();
                X0();
            } else {
                i10 = X0();
                Y0();
            }
            if (i10 == 0 && c1() != null) {
                this.I.a();
                this.f2148m = true;
                y0();
                return true;
            }
        }
        return false;
    }

    public final int P0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        z0 z0Var = this.f1923y;
        boolean z10 = this.P;
        return n2.a(g2Var, z0Var, U0(!z10), T0(!z10), this, this.P);
    }

    public final int Q0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        z0 z0Var = this.f1923y;
        boolean z10 = this.P;
        return n2.b(g2Var, z0Var, U0(!z10), T0(!z10), this, this.P, this.E);
    }

    public final int R0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        z0 z0Var = this.f1923y;
        boolean z10 = this.P;
        return n2.c(g2Var, z0Var, U0(!z10), T0(!z10), this, this.P);
    }

    public final int S0(y1 y1Var, o0 o0Var, g2 g2Var) {
        int i10;
        int i11;
        boolean z10;
        int i12;
        int i13;
        boolean z11;
        y2 y2Var;
        boolean z12;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        y1 y1Var2 = y1Var;
        o0 o0Var2 = o0Var;
        int i23 = 1;
        this.F.set(0, this.f1921w, true);
        o0 o0Var3 = this.C;
        if (o0Var3.f2115i) {
            if (o0Var2.f2111e == 1) {
                i10 = Integer.MAX_VALUE;
            } else {
                i10 = RecyclerView.UNDEFINED_DURATION;
            }
        } else if (o0Var2.f2111e == 1) {
            i10 = o0Var2.f2113g + o0Var2.f2108b;
        } else {
            i10 = o0Var2.f2112f - o0Var2.f2108b;
        }
        int i24 = o0Var2.f2111e;
        for (int i25 = 0; i25 < this.f1921w; i25++) {
            if (!this.f1922x[i25].f2259a.isEmpty()) {
                o1(this.f1922x[i25], i24, i10);
            }
        }
        if (this.E) {
            i11 = this.f1923y.h();
        } else {
            i11 = this.f1923y.j();
        }
        boolean z13 = false;
        while (true) {
            int i26 = o0Var2.f2109c;
            if (i26 < 0 || i26 >= g2Var.b()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && (o0Var3.f2115i || !this.F.isEmpty())) {
                View d10 = y1Var2.d(o0Var2.f2109c);
                o0Var2.f2109c += o0Var2.f2110d;
                s2 s2Var = (s2) d10.getLayoutParams();
                int u10 = s2Var.u();
                v2 v2Var = this.I;
                int[] iArr = v2Var.f2222a;
                if (iArr == null || u10 >= iArr.length) {
                    i13 = -1;
                } else {
                    i13 = iArr[u10];
                }
                if (i13 == -1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    if (f1(o0Var2.f2111e)) {
                        i22 = this.f1921w - i23;
                        i21 = -1;
                        i20 = -1;
                    } else {
                        i21 = this.f1921w;
                        i22 = 0;
                        i20 = 1;
                    }
                    y2 y2Var2 = null;
                    if (o0Var2.f2111e == i23) {
                        int j10 = this.f1923y.j();
                        int i27 = Integer.MAX_VALUE;
                        while (i22 != i21) {
                            y2 y2Var3 = this.f1922x[i22];
                            int f10 = y2Var3.f(j10);
                            if (f10 < i27) {
                                i27 = f10;
                                y2Var2 = y2Var3;
                            }
                            i22 += i20;
                        }
                    } else {
                        int h10 = this.f1923y.h();
                        int i28 = RecyclerView.UNDEFINED_DURATION;
                        while (i22 != i21) {
                            y2 y2Var4 = this.f1922x[i22];
                            int i29 = y2Var4.i(h10);
                            if (i29 > i28) {
                                y2Var2 = y2Var4;
                                i28 = i29;
                            }
                            i22 += i20;
                        }
                    }
                    y2Var = y2Var2;
                    v2Var.b(u10);
                    v2Var.f2222a[u10] = y2Var.f2263e;
                } else {
                    y2Var = this.f1922x[i13];
                }
                s2Var.f2195l = y2Var;
                if (o0Var2.f2111e == 1) {
                    z12 = false;
                    l(d10, -1, false);
                } else {
                    z12 = false;
                    l(d10, 0, false);
                }
                if (this.A == 1) {
                    i15 = q1.I(this.B, this.f2154s, z12 ? 1 : 0, s2Var.width, z12);
                    i14 = q1.I(this.f2157v, this.f2155t, getPaddingBottom() + getPaddingTop(), s2Var.height, true);
                } else {
                    i15 = q1.I(this.f2156u, this.f2154s, getPaddingRight() + getPaddingLeft(), s2Var.width, true);
                    i14 = q1.I(this.B, this.f2155t, 0, s2Var.height, false);
                }
                Rect rect = this.N;
                n(d10, rect);
                s2 s2Var2 = (s2) d10.getLayoutParams();
                int p12 = p1(i15, s2Var2.leftMargin + rect.left, s2Var2.rightMargin + rect.right);
                int p13 = p1(i14, s2Var2.topMargin + rect.top, s2Var2.bottomMargin + rect.bottom);
                if (H0(d10, p12, p13, s2Var2)) {
                    d10.measure(p12, p13);
                }
                if (o0Var2.f2111e == 1) {
                    i17 = y2Var.f(i11);
                    i16 = this.f1923y.e(d10) + i17;
                } else {
                    i16 = y2Var.i(i11);
                    i17 = i16 - this.f1923y.e(d10);
                }
                int i30 = o0Var2.f2111e;
                y2 y2Var5 = s2Var.f2195l;
                y2Var5.getClass();
                if (i30 == 1) {
                    s2 s2Var3 = (s2) d10.getLayoutParams();
                    s2Var3.f2195l = y2Var5;
                    ArrayList arrayList = y2Var5.f2259a;
                    arrayList.add(d10);
                    y2Var5.f2261c = RecyclerView.UNDEFINED_DURATION;
                    if (arrayList.size() == 1) {
                        y2Var5.f2260b = RecyclerView.UNDEFINED_DURATION;
                    }
                    if (s2Var3.w() || s2Var3.v()) {
                        y2Var5.f2262d = y2Var5.f2264f.f1923y.e(d10) + y2Var5.f2262d;
                    }
                } else {
                    s2 s2Var4 = (s2) d10.getLayoutParams();
                    s2Var4.f2195l = y2Var5;
                    ArrayList arrayList2 = y2Var5.f2259a;
                    arrayList2.add(0, d10);
                    y2Var5.f2260b = RecyclerView.UNDEFINED_DURATION;
                    if (arrayList2.size() == 1) {
                        y2Var5.f2261c = RecyclerView.UNDEFINED_DURATION;
                    }
                    if (s2Var4.w() || s2Var4.v()) {
                        y2Var5.f2262d = y2Var5.f2264f.f1923y.e(d10) + y2Var5.f2262d;
                    }
                }
                if (!d1() || this.A != 1) {
                    i18 = this.f1924z.j() + (y2Var.f2263e * this.B);
                    i19 = this.f1924z.e(d10) + i18;
                } else {
                    i19 = this.f1924z.h() - (((this.f1921w - 1) - y2Var.f2263e) * this.B);
                    i18 = i19 - this.f1924z.e(d10);
                }
                if (this.A == 1) {
                    int i31 = i18;
                    i18 = i17;
                    i17 = i31;
                    int i32 = i19;
                    i19 = i16;
                    i16 = i32;
                }
                q1.W(d10, i17, i18, i16, i19);
                o1(y2Var, o0Var3.f2111e, i10);
                h1(y1Var2, o0Var3);
                if (o0Var3.f2114h && d10.hasFocusable()) {
                    this.F.set(y2Var.f2263e, false);
                }
                i23 = 1;
                z13 = true;
            }
        }
        if (!z13) {
            h1(y1Var2, o0Var3);
        }
        if (o0Var3.f2111e == -1) {
            i12 = this.f1923y.j() - a1(this.f1923y.j());
        } else {
            i12 = Z0(this.f1923y.h()) - this.f1923y.h();
        }
        if (i12 > 0) {
            return Math.min(o0Var2.f2108b, i12);
        }
        return 0;
    }

    public final View T0(boolean z10) {
        int j10 = this.f1923y.j();
        int h10 = this.f1923y.h();
        View view = null;
        for (int H2 = H() - 1; H2 >= 0; H2--) {
            View G2 = G(H2);
            int f10 = this.f1923y.f(G2);
            int d10 = this.f1923y.d(G2);
            if (d10 > j10 && f10 < h10) {
                if (d10 <= h10 || !z10) {
                    return G2;
                }
                if (view == null) {
                    view = G2;
                }
            }
        }
        return view;
    }

    public final boolean U() {
        return this.J != 0;
    }

    public final View U0(boolean z10) {
        int j10 = this.f1923y.j();
        int h10 = this.f1923y.h();
        int H2 = H();
        View view = null;
        for (int i10 = 0; i10 < H2; i10++) {
            View G2 = G(i10);
            int f10 = this.f1923y.f(G2);
            if (this.f1923y.d(G2) > j10 && f10 < h10) {
                if (f10 >= j10 || !z10) {
                    return G2;
                }
                if (view == null) {
                    view = G2;
                }
            }
        }
        return view;
    }

    public final void V0(y1 y1Var, g2 g2Var, boolean z10) {
        int h10;
        int Z0 = Z0(RecyclerView.UNDEFINED_DURATION);
        if (Z0 != Integer.MIN_VALUE && (h10 = this.f1923y.h() - Z0) > 0) {
            int i10 = h10 - (-l1(-h10, y1Var, g2Var));
            if (z10 && i10 > 0) {
                this.f1923y.o(i10);
            }
        }
    }

    public final void W0(y1 y1Var, g2 g2Var, boolean z10) {
        int j10;
        int a12 = a1(Integer.MAX_VALUE);
        if (a12 != Integer.MAX_VALUE && (j10 = a12 - this.f1923y.j()) > 0) {
            int l12 = j10 - l1(j10, y1Var, g2Var);
            if (z10 && l12 > 0) {
                this.f1923y.o(-l12);
            }
        }
    }

    public final void X(int i10) {
        super.X(i10);
        for (int i11 = 0; i11 < this.f1921w; i11++) {
            y2 y2Var = this.f1922x[i11];
            int i12 = y2Var.f2260b;
            if (i12 != Integer.MIN_VALUE) {
                y2Var.f2260b = i12 + i10;
            }
            int i13 = y2Var.f2261c;
            if (i13 != Integer.MIN_VALUE) {
                y2Var.f2261c = i13 + i10;
            }
        }
    }

    public final int X0() {
        if (H() == 0) {
            return 0;
        }
        return q1.O(G(0));
    }

    public final void Y(int i10) {
        super.Y(i10);
        for (int i11 = 0; i11 < this.f1921w; i11++) {
            y2 y2Var = this.f1922x[i11];
            int i12 = y2Var.f2260b;
            if (i12 != Integer.MIN_VALUE) {
                y2Var.f2260b = i12 + i10;
            }
            int i13 = y2Var.f2261c;
            if (i13 != Integer.MIN_VALUE) {
                y2Var.f2261c = i13 + i10;
            }
        }
    }

    public final int Y0() {
        int H2 = H();
        if (H2 == 0) {
            return 0;
        }
        return q1.O(G(H2 - 1));
    }

    public final void Z() {
        this.I.a();
        for (int i10 = 0; i10 < this.f1921w; i10++) {
            this.f1922x[i10].b();
        }
    }

    public final int Z0(int i10) {
        int f10 = this.f1922x[0].f(i10);
        for (int i11 = 1; i11 < this.f1921w; i11++) {
            int f11 = this.f1922x[i11].f(i10);
            if (f11 > f10) {
                f10 = f11;
            }
        }
        return f10;
    }

    public final int a1(int i10) {
        int i11 = this.f1922x[0].i(i10);
        for (int i12 = 1; i12 < this.f1921w; i12++) {
            int i13 = this.f1922x[i12].i(i10);
            if (i13 < i11) {
                i11 = i13;
            }
        }
        return i11;
    }

    public final void b0(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f2144i;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.R);
        }
        for (int i10 = 0; i10 < this.f1921w; i10++) {
            this.f1922x[i10].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b1(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.E
            if (r0 == 0) goto L_0x0009
            int r0 = r7.Y0()
            goto L_0x000d
        L_0x0009:
            int r0 = r7.X0()
        L_0x000d:
            r1 = 8
            if (r10 != r1) goto L_0x001a
            if (r8 >= r9) goto L_0x0016
            int r2 = r9 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r8 + 1
            r3 = r9
            goto L_0x001d
        L_0x001a:
            int r2 = r8 + r9
        L_0x001c:
            r3 = r8
        L_0x001d:
            androidx.recyclerview.widget.v2 r4 = r7.I
            r4.c(r3)
            r5 = 1
            if (r10 == r5) goto L_0x0036
            r6 = 2
            if (r10 == r6) goto L_0x0032
            if (r10 == r1) goto L_0x002b
            goto L_0x0039
        L_0x002b:
            r4.e(r8, r5)
            r4.d(r9, r5)
            goto L_0x0039
        L_0x0032:
            r4.e(r8, r9)
            goto L_0x0039
        L_0x0036:
            r4.d(r8, r9)
        L_0x0039:
            if (r2 > r0) goto L_0x003c
            return
        L_0x003c:
            boolean r8 = r7.E
            if (r8 == 0) goto L_0x0045
            int r8 = r7.X0()
            goto L_0x0049
        L_0x0045:
            int r8 = r7.Y0()
        L_0x0049:
            if (r3 > r8) goto L_0x004e
            r7.y0()
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b1(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004a, code lost:
        if (r8.A == 1) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        if (r8.A == 0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005e, code lost:
        if (d1() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006a, code lost:
        if (d1() == false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View c0(android.view.View r9, int r10, androidx.recyclerview.widget.y1 r11, androidx.recyclerview.widget.g2 r12) {
        /*
            r8 = this;
            int r0 = r8.H()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            androidx.recyclerview.widget.RecyclerView r0 = r8.f2144i
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            r9 = r1
            goto L_0x001e
        L_0x000e:
            android.view.View r9 = r0.findContainingItemView(r9)
            if (r9 != 0) goto L_0x0015
            goto L_0x000c
        L_0x0015:
            androidx.recyclerview.widget.k r0 = r8.f2143h
            boolean r0 = r0.j(r9)
            if (r0 == 0) goto L_0x001e
            goto L_0x000c
        L_0x001e:
            if (r9 != 0) goto L_0x0021
            return r1
        L_0x0021:
            r8.k1()
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            if (r10 == r3) goto L_0x0061
            r4 = 2
            if (r10 == r4) goto L_0x0055
            r4 = 17
            if (r10 == r4) goto L_0x004d
            r4 = 33
            if (r10 == r4) goto L_0x0048
            r4 = 66
            if (r10 == r4) goto L_0x0043
            r4 = 130(0x82, float:1.82E-43)
            if (r10 == r4) goto L_0x003e
            goto L_0x0052
        L_0x003e:
            int r10 = r8.A
            if (r10 != r3) goto L_0x0052
            goto L_0x006c
        L_0x0043:
            int r10 = r8.A
            if (r10 != 0) goto L_0x0052
            goto L_0x006c
        L_0x0048:
            int r10 = r8.A
            if (r10 != r3) goto L_0x0052
            goto L_0x006e
        L_0x004d:
            int r10 = r8.A
            if (r10 != 0) goto L_0x0052
            goto L_0x006e
        L_0x0052:
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x006f
        L_0x0055:
            int r10 = r8.A
            if (r10 != r3) goto L_0x005a
            goto L_0x006c
        L_0x005a:
            boolean r10 = r8.d1()
            if (r10 == 0) goto L_0x006c
            goto L_0x006e
        L_0x0061:
            int r10 = r8.A
            if (r10 != r3) goto L_0x0066
            goto L_0x006e
        L_0x0066:
            boolean r10 = r8.d1()
            if (r10 == 0) goto L_0x006e
        L_0x006c:
            r10 = 1
            goto L_0x006f
        L_0x006e:
            r10 = -1
        L_0x006f:
            if (r10 != r0) goto L_0x0072
            return r1
        L_0x0072:
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            androidx.recyclerview.widget.s2 r0 = (androidx.recyclerview.widget.s2) r0
            r0.getClass()
            androidx.recyclerview.widget.y2 r0 = r0.f2195l
            if (r10 != r3) goto L_0x0084
            int r4 = r8.Y0()
            goto L_0x0088
        L_0x0084:
            int r4 = r8.X0()
        L_0x0088:
            r8.n1(r4, r12)
            r8.m1(r10)
            androidx.recyclerview.widget.o0 r5 = r8.C
            int r6 = r5.f2110d
            int r6 = r6 + r4
            r5.f2109c = r6
            androidx.recyclerview.widget.z0 r6 = r8.f1923y
            int r6 = r6.k()
            float r6 = (float) r6
            r7 = 1051372203(0x3eaaaaab, float:0.33333334)
            float r6 = r6 * r7
            int r6 = (int) r6
            r5.f2108b = r6
            r5.f2114h = r3
            r6 = 0
            r5.f2107a = r6
            r8.S0(r11, r5, r12)
            boolean r11 = r8.E
            r8.K = r11
            android.view.View r11 = r0.g(r4, r10)
            if (r11 == 0) goto L_0x00b9
            if (r11 == r9) goto L_0x00b9
            return r11
        L_0x00b9:
            boolean r11 = r8.f1(r10)
            if (r11 == 0) goto L_0x00d4
            int r11 = r8.f1921w
            int r11 = r11 - r3
        L_0x00c2:
            if (r11 < 0) goto L_0x00e9
            androidx.recyclerview.widget.y2[] r12 = r8.f1922x
            r12 = r12[r11]
            android.view.View r12 = r12.g(r4, r10)
            if (r12 == 0) goto L_0x00d1
            if (r12 == r9) goto L_0x00d1
            return r12
        L_0x00d1:
            int r11 = r11 + -1
            goto L_0x00c2
        L_0x00d4:
            r11 = 0
        L_0x00d5:
            int r12 = r8.f1921w
            if (r11 >= r12) goto L_0x00e9
            androidx.recyclerview.widget.y2[] r12 = r8.f1922x
            r12 = r12[r11]
            android.view.View r12 = r12.g(r4, r10)
            if (r12 == 0) goto L_0x00e6
            if (r12 == r9) goto L_0x00e6
            return r12
        L_0x00e6:
            int r11 = r11 + 1
            goto L_0x00d5
        L_0x00e9:
            boolean r11 = r8.D
            r11 = r11 ^ r3
            if (r10 != r2) goto L_0x00f0
            r12 = 1
            goto L_0x00f1
        L_0x00f0:
            r12 = 0
        L_0x00f1:
            if (r11 != r12) goto L_0x00f5
            r11 = 1
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r11 == 0) goto L_0x00fd
            int r12 = r0.c()
            goto L_0x0101
        L_0x00fd:
            int r12 = r0.d()
        L_0x0101:
            android.view.View r12 = r8.B(r12)
            if (r12 == 0) goto L_0x010a
            if (r12 == r9) goto L_0x010a
            return r12
        L_0x010a:
            boolean r10 = r8.f1(r10)
            if (r10 == 0) goto L_0x0137
            int r10 = r8.f1921w
            int r10 = r10 - r3
        L_0x0113:
            if (r10 < 0) goto L_0x0158
            int r12 = r0.f2263e
            if (r10 != r12) goto L_0x011a
            goto L_0x0134
        L_0x011a:
            androidx.recyclerview.widget.y2[] r12 = r8.f1922x
            if (r11 == 0) goto L_0x0125
            r12 = r12[r10]
            int r12 = r12.c()
            goto L_0x012b
        L_0x0125:
            r12 = r12[r10]
            int r12 = r12.d()
        L_0x012b:
            android.view.View r12 = r8.B(r12)
            if (r12 == 0) goto L_0x0134
            if (r12 == r9) goto L_0x0134
            return r12
        L_0x0134:
            int r10 = r10 + -1
            goto L_0x0113
        L_0x0137:
            int r10 = r8.f1921w
            if (r6 >= r10) goto L_0x0158
            androidx.recyclerview.widget.y2[] r10 = r8.f1922x
            if (r11 == 0) goto L_0x0146
            r10 = r10[r6]
            int r10 = r10.c()
            goto L_0x014c
        L_0x0146:
            r10 = r10[r6]
            int r10 = r10.d()
        L_0x014c:
            android.view.View r10 = r8.B(r10)
            if (r10 == 0) goto L_0x0155
            if (r10 == r9) goto L_0x0155
            return r10
        L_0x0155:
            int r6 = r6 + 1
            goto L_0x0137
        L_0x0158:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c0(android.view.View, int, androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00cb, code lost:
        if (r10 == r11) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        if (r10 == r11) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e1, code lost:
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View c1() {
        /*
            r13 = this;
            int r0 = r13.H()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r13.f1921w
            r2.<init>(r3)
            int r3 = r13.f1921w
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r13.A
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r13.d1()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r13.E
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x0100
            android.view.View r7 = r13.G(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.s2 r8 = (androidx.recyclerview.widget.s2) r8
            androidx.recyclerview.widget.y2 r9 = r8.f2195l
            int r9 = r9.f2263e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x00b1
            androidx.recyclerview.widget.y2 r9 = r8.f2195l
            boolean r10 = r13.E
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == 0) goto L_0x006a
            int r10 = r9.f2261c
            if (r10 == r11) goto L_0x0051
            goto L_0x0056
        L_0x0051:
            r9.a()
            int r10 = r9.f2261c
        L_0x0056:
            androidx.recyclerview.widget.z0 r11 = r13.f1923y
            int r11 = r11.h()
            if (r10 >= r11) goto L_0x00a6
            java.util.ArrayList r10 = r9.f2259a
            int r11 = r10.size()
            int r11 = r11 - r1
            java.lang.Object r10 = r10.get(r11)
            goto L_0x0098
        L_0x006a:
            int r10 = r9.f2260b
            if (r10 == r11) goto L_0x006f
            goto L_0x008a
        L_0x006f:
            java.util.ArrayList r10 = r9.f2259a
            java.lang.Object r10 = r10.get(r4)
            android.view.View r10 = (android.view.View) r10
            androidx.recyclerview.widget.s2 r11 = androidx.recyclerview.widget.y2.h(r10)
            androidx.recyclerview.widget.StaggeredGridLayoutManager r12 = r9.f2264f
            androidx.recyclerview.widget.z0 r12 = r12.f1923y
            int r10 = r12.f(r10)
            r9.f2260b = r10
            r11.getClass()
            int r10 = r9.f2260b
        L_0x008a:
            androidx.recyclerview.widget.z0 r11 = r13.f1923y
            int r11 = r11.j()
            if (r10 <= r11) goto L_0x00a6
            java.util.ArrayList r10 = r9.f2259a
            java.lang.Object r10 = r10.get(r4)
        L_0x0098:
            android.view.View r10 = (android.view.View) r10
            r9.getClass()
            androidx.recyclerview.widget.s2 r9 = androidx.recyclerview.widget.y2.h(r10)
            r9.getClass()
            r9 = 1
            goto L_0x00a7
        L_0x00a6:
            r9 = 0
        L_0x00a7:
            if (r9 == 0) goto L_0x00aa
            return r7
        L_0x00aa:
            androidx.recyclerview.widget.y2 r9 = r8.f2195l
            int r9 = r9.f2263e
            r2.clear(r9)
        L_0x00b1:
            int r0 = r0 + r5
            if (r0 == r6) goto L_0x002e
            android.view.View r9 = r13.G(r0)
            boolean r10 = r13.E
            if (r10 == 0) goto L_0x00ce
            androidx.recyclerview.widget.z0 r10 = r13.f1923y
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.z0 r11 = r13.f1923y
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x00cb
            return r7
        L_0x00cb:
            if (r10 != r11) goto L_0x00e1
            goto L_0x00df
        L_0x00ce:
            androidx.recyclerview.widget.z0 r10 = r13.f1923y
            int r10 = r10.f(r7)
            androidx.recyclerview.widget.z0 r11 = r13.f1923y
            int r11 = r11.f(r9)
            if (r10 <= r11) goto L_0x00dd
            return r7
        L_0x00dd:
            if (r10 != r11) goto L_0x00e1
        L_0x00df:
            r10 = 1
            goto L_0x00e2
        L_0x00e1:
            r10 = 0
        L_0x00e2:
            if (r10 == 0) goto L_0x002e
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.s2 r9 = (androidx.recyclerview.widget.s2) r9
            androidx.recyclerview.widget.y2 r8 = r8.f2195l
            int r8 = r8.f2263e
            androidx.recyclerview.widget.y2 r9 = r9.f2195l
            int r9 = r9.f2263e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00f7
            r8 = 1
            goto L_0x00f8
        L_0x00f7:
            r8 = 0
        L_0x00f8:
            if (r3 >= 0) goto L_0x00fc
            r9 = 1
            goto L_0x00fd
        L_0x00fc:
            r9 = 0
        L_0x00fd:
            if (r8 == r9) goto L_0x002e
            return r7
        L_0x0100:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c1():android.view.View");
    }

    public final PointF d(int i10) {
        int N0 = N0(i10);
        PointF pointF = new PointF();
        if (N0 == 0) {
            return null;
        }
        if (this.A == 0) {
            pointF.x = (float) N0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) N0;
        }
        return pointF;
    }

    public final void d0(AccessibilityEvent accessibilityEvent) {
        super.d0(accessibilityEvent);
        if (H() > 0) {
            View U0 = U0(false);
            View T0 = T0(false);
            if (U0 != null && T0 != null) {
                int O2 = q1.O(U0);
                int O3 = q1.O(T0);
                if (O2 < O3) {
                    accessibilityEvent.setFromIndex(O2);
                    accessibilityEvent.setToIndex(O3);
                    return;
                }
                accessibilityEvent.setFromIndex(O3);
                accessibilityEvent.setToIndex(O2);
            }
        }
    }

    public final boolean d1() {
        return M() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03f0, code lost:
        if (O0() != false) goto L_0x03f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e1(androidx.recyclerview.widget.y1 r17, androidx.recyclerview.widget.g2 r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            androidx.recyclerview.widget.x2 r3 = r0.M
            r4 = -1
            androidx.recyclerview.widget.r2 r5 = r0.O
            if (r3 != 0) goto L_0x0011
            int r3 = r0.G
            if (r3 == r4) goto L_0x001e
        L_0x0011:
            int r3 = r18.b()
            if (r3 != 0) goto L_0x001e
            r16.u0(r17)
            r5.a()
            return
        L_0x001e:
            boolean r3 = r5.f2192e
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x002f
            int r3 = r0.G
            if (r3 != r4) goto L_0x002f
            androidx.recyclerview.widget.x2 r3 = r0.M
            if (r3 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r3 = 0
            goto L_0x0030
        L_0x002f:
            r3 = 1
        L_0x0030:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = r5.f2194g
            androidx.recyclerview.widget.v2 r9 = r0.I
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == 0) goto L_0x01f9
            r5.a()
            androidx.recyclerview.widget.x2 r11 = r0.M
            if (r11 == 0) goto L_0x00c0
            int r12 = r11.f2237j
            r13 = 0
            if (r12 <= 0) goto L_0x0087
            int r14 = r0.f1921w
            if (r12 != r14) goto L_0x0079
            r11 = 0
        L_0x0049:
            int r12 = r0.f1921w
            if (r11 >= r12) goto L_0x0087
            androidx.recyclerview.widget.y2[] r12 = r0.f1922x
            r12 = r12[r11]
            r12.b()
            androidx.recyclerview.widget.x2 r12 = r0.M
            int[] r14 = r12.f2238k
            r14 = r14[r11]
            if (r14 == r10) goto L_0x006e
            boolean r12 = r12.f2243p
            if (r12 == 0) goto L_0x0067
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.h()
            goto L_0x006d
        L_0x0067:
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.j()
        L_0x006d:
            int r14 = r14 + r12
        L_0x006e:
            androidx.recyclerview.widget.y2[] r12 = r0.f1922x
            r12 = r12[r11]
            r12.f2260b = r14
            r12.f2261c = r14
            int r11 = r11 + 1
            goto L_0x0049
        L_0x0079:
            r11.f2238k = r13
            r11.f2237j = r7
            r11.f2239l = r7
            r11.f2240m = r13
            r11.f2241n = r13
            int r12 = r11.f2236i
            r11.f2235h = r12
        L_0x0087:
            androidx.recyclerview.widget.x2 r11 = r0.M
            boolean r12 = r11.f2244q
            r0.L = r12
            boolean r11 = r11.f2242o
            r0.m(r13)
            androidx.recyclerview.widget.x2 r12 = r0.M
            if (r12 == 0) goto L_0x009c
            boolean r13 = r12.f2242o
            if (r13 == r11) goto L_0x009c
            r12.f2242o = r11
        L_0x009c:
            r0.D = r11
            r16.y0()
            r16.k1()
            androidx.recyclerview.widget.x2 r11 = r0.M
            int r12 = r11.f2235h
            if (r12 == r4) goto L_0x00af
            r0.G = r12
            boolean r12 = r11.f2243p
            goto L_0x00b1
        L_0x00af:
            boolean r12 = r0.E
        L_0x00b1:
            r5.f2190c = r12
            int r12 = r11.f2239l
            if (r12 <= r6) goto L_0x00c7
            int[] r12 = r11.f2240m
            r9.f2222a = r12
            java.util.List r11 = r11.f2241n
            r9.f2223b = r11
            goto L_0x00c7
        L_0x00c0:
            r16.k1()
            boolean r11 = r0.E
            r5.f2190c = r11
        L_0x00c7:
            boolean r11 = r2.f2024g
            if (r11 != 0) goto L_0x01ba
            int r11 = r0.G
            if (r11 != r4) goto L_0x00d1
            goto L_0x01ba
        L_0x00d1:
            if (r11 < 0) goto L_0x01b6
            int r12 = r18.b()
            if (r11 < r12) goto L_0x00db
            goto L_0x01b6
        L_0x00db:
            androidx.recyclerview.widget.x2 r11 = r0.M
            if (r11 == 0) goto L_0x00f0
            int r12 = r11.f2235h
            if (r12 == r4) goto L_0x00f0
            int r11 = r11.f2237j
            if (r11 >= r6) goto L_0x00e8
            goto L_0x00f0
        L_0x00e8:
            r5.f2189b = r10
            int r11 = r0.G
            r5.f2188a = r11
            goto L_0x01b4
        L_0x00f0:
            int r11 = r0.G
            android.view.View r11 = r0.B(r11)
            if (r11 == 0) goto L_0x0178
            boolean r12 = r0.E
            if (r12 == 0) goto L_0x0101
            int r12 = r16.Y0()
            goto L_0x0105
        L_0x0101:
            int r12 = r16.X0()
        L_0x0105:
            r5.f2188a = r12
            int r12 = r0.H
            if (r12 == r10) goto L_0x0130
            boolean r12 = r5.f2190c
            if (r12 == 0) goto L_0x011f
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.h()
            int r13 = r0.H
            int r12 = r12 - r13
            androidx.recyclerview.widget.z0 r13 = r0.f1923y
            int r11 = r13.d(r11)
            goto L_0x012e
        L_0x011f:
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.j()
            int r13 = r0.H
            int r12 = r12 + r13
            androidx.recyclerview.widget.z0 r13 = r0.f1923y
            int r11 = r13.f(r11)
        L_0x012e:
            int r12 = r12 - r11
            goto L_0x0172
        L_0x0130:
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.e(r11)
            androidx.recyclerview.widget.z0 r13 = r0.f1923y
            int r13 = r13.k()
            if (r12 <= r13) goto L_0x0150
            boolean r11 = r5.f2190c
            if (r11 == 0) goto L_0x0149
            androidx.recyclerview.widget.z0 r11 = r0.f1923y
            int r11 = r11.h()
            goto L_0x0160
        L_0x0149:
            androidx.recyclerview.widget.z0 r11 = r0.f1923y
            int r11 = r11.j()
            goto L_0x0160
        L_0x0150:
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.f(r11)
            androidx.recyclerview.widget.z0 r13 = r0.f1923y
            int r13 = r13.j()
            int r12 = r12 - r13
            if (r12 >= 0) goto L_0x0163
            int r11 = -r12
        L_0x0160:
            r5.f2189b = r11
            goto L_0x01b4
        L_0x0163:
            androidx.recyclerview.widget.z0 r12 = r0.f1923y
            int r12 = r12.h()
            androidx.recyclerview.widget.z0 r13 = r0.f1923y
            int r11 = r13.d(r11)
            int r12 = r12 - r11
            if (r12 >= 0) goto L_0x0175
        L_0x0172:
            r5.f2189b = r12
            goto L_0x01b4
        L_0x0175:
            r5.f2189b = r10
            goto L_0x01b4
        L_0x0178:
            int r11 = r0.G
            r5.f2188a = r11
            int r12 = r0.H
            if (r12 != r10) goto L_0x019d
            int r11 = r0.N0(r11)
            if (r11 != r6) goto L_0x0188
            r11 = 1
            goto L_0x0189
        L_0x0188:
            r11 = 0
        L_0x0189:
            r5.f2190c = r11
            if (r11 == 0) goto L_0x0194
            androidx.recyclerview.widget.z0 r11 = r8.f1923y
            int r11 = r11.h()
            goto L_0x019a
        L_0x0194:
            androidx.recyclerview.widget.z0 r11 = r8.f1923y
            int r11 = r11.j()
        L_0x019a:
            r5.f2189b = r11
            goto L_0x01b2
        L_0x019d:
            boolean r11 = r5.f2190c
            if (r11 == 0) goto L_0x01a9
            androidx.recyclerview.widget.z0 r11 = r8.f1923y
            int r11 = r11.h()
            int r11 = r11 - r12
            goto L_0x01b0
        L_0x01a9:
            androidx.recyclerview.widget.z0 r11 = r8.f1923y
            int r11 = r11.j()
            int r11 = r11 + r12
        L_0x01b0:
            r5.f2189b = r11
        L_0x01b2:
            r5.f2191d = r6
        L_0x01b4:
            r11 = 1
            goto L_0x01bb
        L_0x01b6:
            r0.G = r4
            r0.H = r10
        L_0x01ba:
            r11 = 0
        L_0x01bb:
            if (r11 == 0) goto L_0x01be
            goto L_0x01f7
        L_0x01be:
            boolean r11 = r0.K
            int r12 = r18.b()
            if (r11 == 0) goto L_0x01da
            int r11 = r16.H()
        L_0x01ca:
            int r11 = r11 + r4
            if (r11 < 0) goto L_0x01f2
            android.view.View r13 = r0.G(r11)
            int r13 = androidx.recyclerview.widget.q1.O(r13)
            if (r13 < 0) goto L_0x01ca
            if (r13 >= r12) goto L_0x01ca
            goto L_0x01f3
        L_0x01da:
            int r11 = r16.H()
            r13 = 0
        L_0x01df:
            if (r13 >= r11) goto L_0x01f2
            android.view.View r14 = r0.G(r13)
            int r14 = androidx.recyclerview.widget.q1.O(r14)
            if (r14 < 0) goto L_0x01ef
            if (r14 >= r12) goto L_0x01ef
            r13 = r14
            goto L_0x01f3
        L_0x01ef:
            int r13 = r13 + 1
            goto L_0x01df
        L_0x01f2:
            r13 = 0
        L_0x01f3:
            r5.f2188a = r13
            r5.f2189b = r10
        L_0x01f7:
            r5.f2192e = r6
        L_0x01f9:
            androidx.recyclerview.widget.x2 r11 = r0.M
            if (r11 != 0) goto L_0x0214
            int r11 = r0.G
            if (r11 != r4) goto L_0x0214
            boolean r11 = r5.f2190c
            boolean r12 = r0.K
            if (r11 != r12) goto L_0x020f
            boolean r11 = r16.d1()
            boolean r12 = r0.L
            if (r11 == r12) goto L_0x0214
        L_0x020f:
            r9.a()
            r5.f2191d = r6
        L_0x0214:
            int r9 = r16.H()
            if (r9 <= 0) goto L_0x02bf
            androidx.recyclerview.widget.x2 r9 = r0.M
            if (r9 == 0) goto L_0x0222
            int r9 = r9.f2237j
            if (r9 >= r6) goto L_0x02bf
        L_0x0222:
            boolean r9 = r5.f2191d
            if (r9 == 0) goto L_0x0241
            r3 = 0
        L_0x0227:
            int r8 = r0.f1921w
            if (r3 >= r8) goto L_0x02bf
            androidx.recyclerview.widget.y2[] r8 = r0.f1922x
            r8 = r8[r3]
            r8.b()
            int r8 = r5.f2189b
            if (r8 == r10) goto L_0x023e
            androidx.recyclerview.widget.y2[] r9 = r0.f1922x
            r9 = r9[r3]
            r9.f2260b = r8
            r9.f2261c = r8
        L_0x023e:
            int r3 = r3 + 1
            goto L_0x0227
        L_0x0241:
            if (r3 != 0) goto L_0x025f
            int[] r3 = r5.f2193f
            if (r3 != 0) goto L_0x0248
            goto L_0x025f
        L_0x0248:
            r3 = 0
        L_0x0249:
            int r8 = r0.f1921w
            if (r3 >= r8) goto L_0x02bf
            androidx.recyclerview.widget.y2[] r8 = r0.f1922x
            r8 = r8[r3]
            r8.b()
            int[] r9 = r5.f2193f
            r9 = r9[r3]
            r8.f2260b = r9
            r8.f2261c = r9
            int r3 = r3 + 1
            goto L_0x0249
        L_0x025f:
            r3 = 0
        L_0x0260:
            int r9 = r0.f1921w
            if (r3 >= r9) goto L_0x029e
            androidx.recyclerview.widget.y2[] r9 = r0.f1922x
            r9 = r9[r3]
            boolean r11 = r0.E
            int r12 = r5.f2189b
            if (r11 == 0) goto L_0x0273
            int r13 = r9.f(r10)
            goto L_0x0277
        L_0x0273:
            int r13 = r9.i(r10)
        L_0x0277:
            r9.b()
            if (r13 != r10) goto L_0x027d
            goto L_0x029b
        L_0x027d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r14 = r9.f2264f
            if (r11 == 0) goto L_0x0289
            androidx.recyclerview.widget.z0 r15 = r14.f1923y
            int r15 = r15.h()
            if (r13 < r15) goto L_0x029b
        L_0x0289:
            if (r11 != 0) goto L_0x0294
            androidx.recyclerview.widget.z0 r11 = r14.f1923y
            int r11 = r11.j()
            if (r13 <= r11) goto L_0x0294
            goto L_0x029b
        L_0x0294:
            if (r12 == r10) goto L_0x0297
            int r13 = r13 + r12
        L_0x0297:
            r9.f2261c = r13
            r9.f2260b = r13
        L_0x029b:
            int r3 = r3 + 1
            goto L_0x0260
        L_0x029e:
            androidx.recyclerview.widget.y2[] r3 = r0.f1922x
            int r9 = r3.length
            int[] r11 = r5.f2193f
            if (r11 == 0) goto L_0x02a8
            int r11 = r11.length
            if (r11 >= r9) goto L_0x02af
        L_0x02a8:
            androidx.recyclerview.widget.y2[] r8 = r8.f1922x
            int r8 = r8.length
            int[] r8 = new int[r8]
            r5.f2193f = r8
        L_0x02af:
            r8 = 0
        L_0x02b0:
            if (r8 >= r9) goto L_0x02bf
            int[] r11 = r5.f2193f
            r12 = r3[r8]
            int r12 = r12.i(r10)
            r11[r8] = r12
            int r8 = r8 + 1
            goto L_0x02b0
        L_0x02bf:
            r16.A(r17)
            androidx.recyclerview.widget.o0 r3 = r0.C
            r3.f2107a = r7
            androidx.recyclerview.widget.z0 r8 = r0.f1924z
            int r8 = r8.k()
            int r9 = r0.f1921w
            int r9 = r8 / r9
            r0.B = r9
            androidx.recyclerview.widget.z0 r9 = r0.f1924z
            int r9 = r9.i()
            android.view.View.MeasureSpec.makeMeasureSpec(r8, r9)
            int r8 = r5.f2188a
            r0.n1(r8, r2)
            boolean r8 = r5.f2190c
            if (r8 == 0) goto L_0x02ee
            r0.m1(r4)
            r0.S0(r1, r3, r2)
            r0.m1(r6)
            goto L_0x02f7
        L_0x02ee:
            r0.m1(r6)
            r0.S0(r1, r3, r2)
            r0.m1(r4)
        L_0x02f7:
            int r4 = r5.f2188a
            int r8 = r3.f2110d
            int r4 = r4 + r8
            r3.f2109c = r4
            r0.S0(r1, r3, r2)
            androidx.recyclerview.widget.z0 r3 = r0.f1924z
            int r3 = r3.i()
            r4 = 1073741824(0x40000000, float:2.0)
            if (r3 != r4) goto L_0x030d
            goto L_0x03b1
        L_0x030d:
            int r3 = r16.H()
            r4 = 0
            r8 = 0
        L_0x0313:
            if (r8 >= r3) goto L_0x0335
            android.view.View r9 = r0.G(r8)
            androidx.recyclerview.widget.z0 r11 = r0.f1924z
            int r11 = r11.e(r9)
            float r11 = (float) r11
            int r12 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x0325
            goto L_0x0332
        L_0x0325:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.s2 r9 = (androidx.recyclerview.widget.s2) r9
            r9.getClass()
            float r4 = java.lang.Math.max(r4, r11)
        L_0x0332:
            int r8 = r8 + 1
            goto L_0x0313
        L_0x0335:
            int r8 = r0.B
            int r9 = r0.f1921w
            float r9 = (float) r9
            float r4 = r4 * r9
            int r4 = java.lang.Math.round(r4)
            androidx.recyclerview.widget.z0 r9 = r0.f1924z
            int r9 = r9.i()
            if (r9 != r10) goto L_0x0352
            androidx.recyclerview.widget.z0 r9 = r0.f1924z
            int r9 = r9.k()
            int r4 = java.lang.Math.min(r4, r9)
        L_0x0352:
            int r9 = r0.f1921w
            int r9 = r4 / r9
            r0.B = r9
            androidx.recyclerview.widget.z0 r9 = r0.f1924z
            int r9 = r9.i()
            android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
            int r4 = r0.B
            if (r4 != r8) goto L_0x0366
            goto L_0x03b1
        L_0x0366:
            r4 = 0
        L_0x0367:
            if (r4 >= r3) goto L_0x03b1
            android.view.View r9 = r0.G(r4)
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.recyclerview.widget.s2 r10 = (androidx.recyclerview.widget.s2) r10
            r10.getClass()
            boolean r11 = r16.d1()
            if (r11 == 0) goto L_0x0398
            int r11 = r0.A
            if (r11 != r6) goto L_0x0398
            int r11 = r0.f1921w
            int r12 = r11 + -1
            androidx.recyclerview.widget.y2 r10 = r10.f2195l
            int r10 = r10.f2263e
            int r12 = r12 - r10
            int r12 = -r12
            int r13 = r0.B
            int r12 = r12 * r13
            int r11 = r11 - r6
            int r11 = r11 - r10
            int r10 = -r11
            int r10 = r10 * r8
            int r12 = r12 - r10
            r9.offsetLeftAndRight(r12)
            goto L_0x03ae
        L_0x0398:
            androidx.recyclerview.widget.y2 r10 = r10.f2195l
            int r10 = r10.f2263e
            int r11 = r0.B
            int r11 = r11 * r10
            int r10 = r10 * r8
            int r12 = r0.A
            int r11 = r11 - r10
            if (r12 != r6) goto L_0x03ab
            r9.offsetLeftAndRight(r11)
            goto L_0x03ae
        L_0x03ab:
            r9.offsetTopAndBottom(r11)
        L_0x03ae:
            int r4 = r4 + 1
            goto L_0x0367
        L_0x03b1:
            int r3 = r16.H()
            if (r3 <= 0) goto L_0x03c8
            boolean r3 = r0.E
            if (r3 == 0) goto L_0x03c2
            r0.V0(r1, r2, r6)
            r0.W0(r1, r2, r7)
            goto L_0x03c8
        L_0x03c2:
            r0.W0(r1, r2, r6)
            r0.V0(r1, r2, r7)
        L_0x03c8:
            if (r19 == 0) goto L_0x03f3
            boolean r3 = r2.f2024g
            if (r3 != 0) goto L_0x03f3
            int r3 = r0.J
            if (r3 == 0) goto L_0x03e0
            int r3 = r16.H()
            if (r3 <= 0) goto L_0x03e0
            android.view.View r3 = r16.c1()
            if (r3 == 0) goto L_0x03e0
            r3 = 1
            goto L_0x03e1
        L_0x03e0:
            r3 = 0
        L_0x03e1:
            if (r3 == 0) goto L_0x03f3
            androidx.recyclerview.widget.RecyclerView r3 = r0.f2144i
            if (r3 == 0) goto L_0x03ec
            androidx.recyclerview.widget.c0 r4 = r0.R
            r3.removeCallbacks(r4)
        L_0x03ec:
            boolean r3 = r16.O0()
            if (r3 == 0) goto L_0x03f3
            goto L_0x03f4
        L_0x03f3:
            r6 = 0
        L_0x03f4:
            boolean r3 = r2.f2024g
            if (r3 == 0) goto L_0x03fb
            r5.a()
        L_0x03fb:
            boolean r3 = r5.f2190c
            r0.K = r3
            boolean r3 = r16.d1()
            r0.L = r3
            if (r6 == 0) goto L_0x040d
            r5.a()
            r0.e1(r1, r2, r7)
        L_0x040d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.e1(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2, boolean):void");
    }

    public final boolean f1(int i10) {
        if (this.A == 0) {
            return (i10 == -1) != this.E;
        }
        return ((i10 == -1) == this.E) == d1();
    }

    public final void g1(int i10, g2 g2Var) {
        int i11;
        int i12;
        if (i10 > 0) {
            i12 = Y0();
            i11 = 1;
        } else {
            i12 = X0();
            i11 = -1;
        }
        o0 o0Var = this.C;
        o0Var.f2107a = true;
        n1(i12, g2Var);
        m1(i11);
        o0Var.f2109c = i12 + o0Var.f2110d;
        o0Var.f2108b = Math.abs(i10);
    }

    public final void h0(int i10, int i11) {
        b1(i10, i11, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r6.f2111e == -1) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h1(androidx.recyclerview.widget.y1 r5, androidx.recyclerview.widget.o0 r6) {
        /*
            r4 = this;
            boolean r0 = r6.f2107a
            if (r0 == 0) goto L_0x007c
            boolean r0 = r6.f2115i
            if (r0 == 0) goto L_0x000a
            goto L_0x007c
        L_0x000a:
            int r0 = r6.f2108b
            r1 = -1
            if (r0 != 0) goto L_0x001f
            int r0 = r6.f2111e
            if (r0 != r1) goto L_0x0019
        L_0x0013:
            int r6 = r6.f2113g
        L_0x0015:
            r4.i1(r6, r5)
            goto L_0x007c
        L_0x0019:
            int r6 = r6.f2112f
        L_0x001b:
            r4.j1(r6, r5)
            goto L_0x007c
        L_0x001f:
            int r0 = r6.f2111e
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0050
            int r0 = r6.f2112f
            androidx.recyclerview.widget.y2[] r1 = r4.f1922x
            r1 = r1[r2]
            int r1 = r1.i(r0)
        L_0x002f:
            int r2 = r4.f1921w
            if (r3 >= r2) goto L_0x0041
            androidx.recyclerview.widget.y2[] r2 = r4.f1922x
            r2 = r2[r3]
            int r2 = r2.i(r0)
            if (r2 <= r1) goto L_0x003e
            r1 = r2
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x002f
        L_0x0041:
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0045
            goto L_0x0013
        L_0x0045:
            int r1 = r6.f2113g
            int r6 = r6.f2108b
            int r6 = java.lang.Math.min(r0, r6)
            int r6 = r1 - r6
            goto L_0x0015
        L_0x0050:
            int r0 = r6.f2113g
            androidx.recyclerview.widget.y2[] r1 = r4.f1922x
            r1 = r1[r2]
            int r1 = r1.f(r0)
        L_0x005a:
            int r2 = r4.f1921w
            if (r3 >= r2) goto L_0x006c
            androidx.recyclerview.widget.y2[] r2 = r4.f1922x
            r2 = r2[r3]
            int r2 = r2.f(r0)
            if (r2 >= r1) goto L_0x0069
            r1 = r2
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x005a
        L_0x006c:
            int r0 = r6.f2113g
            int r1 = r1 - r0
            if (r1 >= 0) goto L_0x0072
            goto L_0x0019
        L_0x0072:
            int r0 = r6.f2112f
            int r6 = r6.f2108b
            int r6 = java.lang.Math.min(r1, r6)
            int r6 = r6 + r0
            goto L_0x001b
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h1(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.o0):void");
    }

    public final void i0() {
        this.I.a();
        y0();
    }

    public final void i1(int i10, y1 y1Var) {
        int H2 = H() - 1;
        while (H2 >= 0) {
            View G2 = G(H2);
            if (this.f1923y.f(G2) >= i10 && this.f1923y.n(G2) >= i10) {
                s2 s2Var = (s2) G2.getLayoutParams();
                s2Var.getClass();
                if (s2Var.f2195l.f2259a.size() != 1) {
                    y2 y2Var = s2Var.f2195l;
                    ArrayList arrayList = y2Var.f2259a;
                    int size = arrayList.size();
                    View view = (View) arrayList.remove(size - 1);
                    s2 h10 = y2.h(view);
                    h10.f2195l = null;
                    if (h10.w() || h10.v()) {
                        y2Var.f2262d -= y2Var.f2264f.f1923y.e(view);
                    }
                    if (size == 1) {
                        y2Var.f2260b = RecyclerView.UNDEFINED_DURATION;
                    }
                    y2Var.f2261c = RecyclerView.UNDEFINED_DURATION;
                    w0(G2, y1Var);
                    H2--;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void j0(int i10, int i11) {
        b1(i10, i11, 8);
    }

    public final void j1(int i10, y1 y1Var) {
        while (H() > 0) {
            View G2 = G(0);
            if (this.f1923y.d(G2) <= i10 && this.f1923y.m(G2) <= i10) {
                s2 s2Var = (s2) G2.getLayoutParams();
                s2Var.getClass();
                if (s2Var.f2195l.f2259a.size() != 1) {
                    y2 y2Var = s2Var.f2195l;
                    ArrayList arrayList = y2Var.f2259a;
                    View view = (View) arrayList.remove(0);
                    s2 h10 = y2.h(view);
                    h10.f2195l = null;
                    if (arrayList.size() == 0) {
                        y2Var.f2261c = RecyclerView.UNDEFINED_DURATION;
                    }
                    if (h10.w() || h10.v()) {
                        y2Var.f2262d -= y2Var.f2264f.f1923y.e(view);
                    }
                    y2Var.f2260b = RecyclerView.UNDEFINED_DURATION;
                    w0(G2, y1Var);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void k0(int i10, int i11) {
        b1(i10, i11, 2);
    }

    public final void k1() {
        this.E = (this.A == 1 || !d1()) ? this.D : !this.D;
    }

    public final int l1(int i10, y1 y1Var, g2 g2Var) {
        if (H() == 0 || i10 == 0) {
            return 0;
        }
        g1(i10, g2Var);
        o0 o0Var = this.C;
        int S0 = S0(y1Var, o0Var, g2Var);
        if (o0Var.f2108b >= S0) {
            i10 = i10 < 0 ? -S0 : S0;
        }
        this.f1923y.o(-i10);
        this.K = this.E;
        o0Var.f2108b = 0;
        h1(y1Var, o0Var);
        return i10;
    }

    public final void m(String str) {
        if (this.M == null) {
            super.m(str);
        }
    }

    public final void m0(RecyclerView recyclerView, int i10, int i11) {
        b1(i10, i11, 4);
    }

    public final void m1(int i10) {
        o0 o0Var = this.C;
        o0Var.f2111e = i10;
        int i11 = 1;
        if (this.E != (i10 == -1)) {
            i11 = -1;
        }
        o0Var.f2110d = i11;
    }

    public final void n0(y1 y1Var, g2 g2Var) {
        e1(y1Var, g2Var, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n1(int r5, androidx.recyclerview.widget.g2 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.o0 r0 = r4.C
            r1 = 0
            r0.f2108b = r1
            r0.f2109c = r5
            androidx.recyclerview.widget.f2 r2 = r4.f2147l
            r3 = 1
            if (r2 == 0) goto L_0x0012
            boolean r2 = r2.f1987e
            if (r2 == 0) goto L_0x0012
            r2 = 1
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0033
            int r6 = r6.f2018a
            r2 = -1
            if (r6 == r2) goto L_0x0033
            boolean r2 = r4.E
            if (r6 >= r5) goto L_0x0020
            r5 = 1
            goto L_0x0021
        L_0x0020:
            r5 = 0
        L_0x0021:
            if (r2 != r5) goto L_0x002a
            androidx.recyclerview.widget.z0 r5 = r4.f1923y
            int r5 = r5.k()
            goto L_0x0034
        L_0x002a:
            androidx.recyclerview.widget.z0 r5 = r4.f1923y
            int r5 = r5.k()
            r6 = r5
            r5 = 0
            goto L_0x0035
        L_0x0033:
            r5 = 0
        L_0x0034:
            r6 = 0
        L_0x0035:
            androidx.recyclerview.widget.RecyclerView r2 = r4.f2144i
            if (r2 == 0) goto L_0x003f
            boolean r2 = r2.mClipToPadding
            if (r2 == 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            if (r2 == 0) goto L_0x0055
            androidx.recyclerview.widget.z0 r2 = r4.f1923y
            int r2 = r2.j()
            int r2 = r2 - r6
            r0.f2112f = r2
            androidx.recyclerview.widget.z0 r6 = r4.f1923y
            int r6 = r6.h()
            int r6 = r6 + r5
            r0.f2113g = r6
            goto L_0x0061
        L_0x0055:
            androidx.recyclerview.widget.z0 r2 = r4.f1923y
            int r2 = r2.g()
            int r2 = r2 + r5
            r0.f2113g = r2
            int r5 = -r6
            r0.f2112f = r5
        L_0x0061:
            r0.f2114h = r1
            r0.f2107a = r3
            androidx.recyclerview.widget.z0 r5 = r4.f1923y
            int r5 = r5.i()
            if (r5 != 0) goto L_0x0076
            androidx.recyclerview.widget.z0 r5 = r4.f1923y
            int r5 = r5.g()
            if (r5 != 0) goto L_0x0076
            r1 = 1
        L_0x0076:
            r0.f2115i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.n1(int, androidx.recyclerview.widget.g2):void");
    }

    public final boolean o() {
        return this.A == 0;
    }

    public final void o0(g2 g2Var) {
        this.G = -1;
        this.H = RecyclerView.UNDEFINED_DURATION;
        this.M = null;
        this.O.a();
    }

    public final void o1(y2 y2Var, int i10, int i11) {
        int i12 = y2Var.f2262d;
        if (i10 == -1) {
            int i13 = y2Var.f2260b;
            if (i13 == Integer.MIN_VALUE) {
                View view = (View) y2Var.f2259a.get(0);
                s2 h10 = y2.h(view);
                y2Var.f2260b = y2Var.f2264f.f1923y.f(view);
                h10.getClass();
                i13 = y2Var.f2260b;
            }
            if (i13 + i12 > i11) {
                return;
            }
        } else {
            int i14 = y2Var.f2261c;
            if (i14 == Integer.MIN_VALUE) {
                y2Var.a();
                i14 = y2Var.f2261c;
            }
            if (i14 - i12 < i11) {
                return;
            }
        }
        this.F.set(y2Var.f2263e, false);
    }

    public final boolean p() {
        return this.A == 1;
    }

    public final void p0(Parcelable parcelable) {
        if (parcelable instanceof x2) {
            x2 x2Var = (x2) parcelable;
            this.M = x2Var;
            if (this.G != -1) {
                x2Var.f2238k = null;
                x2Var.f2237j = 0;
                x2Var.f2235h = -1;
                x2Var.f2236i = -1;
                x2Var.f2238k = null;
                x2Var.f2237j = 0;
                x2Var.f2239l = 0;
                x2Var.f2240m = null;
                x2Var.f2241n = null;
            }
            y0();
        }
    }

    public final boolean q(r1 r1Var) {
        return r1Var instanceof s2;
    }

    public final Parcelable q0() {
        int i10;
        View view;
        int i11;
        int i12;
        int[] iArr;
        if (this.M != null) {
            return new x2(this.M);
        }
        x2 x2Var = new x2();
        x2Var.f2242o = this.D;
        x2Var.f2243p = this.K;
        x2Var.f2244q = this.L;
        v2 v2Var = this.I;
        if (v2Var == null || (iArr = v2Var.f2222a) == null) {
            x2Var.f2239l = 0;
        } else {
            x2Var.f2240m = iArr;
            x2Var.f2239l = iArr.length;
            x2Var.f2241n = v2Var.f2223b;
        }
        int i13 = -1;
        if (H() > 0) {
            if (this.K) {
                i10 = Y0();
            } else {
                i10 = X0();
            }
            x2Var.f2235h = i10;
            if (this.E) {
                view = T0(true);
            } else {
                view = U0(true);
            }
            if (view != null) {
                i13 = q1.O(view);
            }
            x2Var.f2236i = i13;
            int i14 = this.f1921w;
            x2Var.f2237j = i14;
            x2Var.f2238k = new int[i14];
            for (int i15 = 0; i15 < this.f1921w; i15++) {
                if (this.K) {
                    i11 = this.f1922x[i15].f(RecyclerView.UNDEFINED_DURATION);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f1923y.h();
                    } else {
                        x2Var.f2238k[i15] = i11;
                    }
                } else {
                    i11 = this.f1922x[i15].i(RecyclerView.UNDEFINED_DURATION);
                    if (i11 != Integer.MIN_VALUE) {
                        i12 = this.f1923y.j();
                    } else {
                        x2Var.f2238k[i15] = i11;
                    }
                }
                i11 -= i12;
                x2Var.f2238k[i15] = i11;
            }
        } else {
            x2Var.f2235h = -1;
            x2Var.f2236i = -1;
            x2Var.f2237j = 0;
        }
        return x2Var;
    }

    public final void r0(int i10) {
        if (i10 == 0) {
            O0();
        }
    }

    public final void s(int i10, int i11, g2 g2Var, i0 i0Var) {
        o0 o0Var;
        boolean z10;
        int i12;
        int i13;
        if (this.A != 0) {
            i10 = i11;
        }
        if (H() != 0 && i10 != 0) {
            g1(i10, g2Var);
            int[] iArr = this.Q;
            if (iArr == null || iArr.length < this.f1921w) {
                this.Q = new int[this.f1921w];
            }
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int i16 = this.f1921w;
                o0Var = this.C;
                if (i14 >= i16) {
                    break;
                }
                if (o0Var.f2110d == -1) {
                    i13 = o0Var.f2112f;
                    i12 = this.f1922x[i14].i(i13);
                } else {
                    i13 = this.f1922x[i14].f(o0Var.f2113g);
                    i12 = o0Var.f2113g;
                }
                int i17 = i13 - i12;
                if (i17 >= 0) {
                    this.Q[i15] = i17;
                    i15++;
                }
                i14++;
            }
            Arrays.sort(this.Q, 0, i15);
            int i18 = 0;
            while (i18 < i15) {
                int i19 = o0Var.f2109c;
                if (i19 < 0 || i19 >= g2Var.b()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (z10) {
                    i0Var.a(o0Var.f2109c, this.Q[i18]);
                    o0Var.f2109c += o0Var.f2110d;
                    i18++;
                } else {
                    return;
                }
            }
        }
    }

    public final int u(g2 g2Var) {
        return P0(g2Var);
    }

    public final int v(g2 g2Var) {
        return Q0(g2Var);
    }

    public final int w(g2 g2Var) {
        return R0(g2Var);
    }

    public final int x(g2 g2Var) {
        return P0(g2Var);
    }

    public final int y(g2 g2Var) {
        return Q0(g2Var);
    }

    public final int z(g2 g2Var) {
        return R0(g2Var);
    }

    public final int z0(int i10, y1 y1Var, g2 g2Var) {
        return l1(i10, y1Var, g2Var);
    }
}
