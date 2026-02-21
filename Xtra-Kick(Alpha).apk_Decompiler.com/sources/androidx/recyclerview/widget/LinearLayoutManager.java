package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public class LinearLayoutManager extends q1 implements e2 {
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public final boolean D = true;
    public int E = -1;
    public int F = RecyclerView.UNDEFINED_DURATION;
    public t0 G = null;
    public final p0 H = new p0();
    public final q0 I = new q0();
    public final int J = 2;
    public final int[] K = new int[2];

    /* renamed from: w  reason: collision with root package name */
    public int f1917w = 1;

    /* renamed from: x  reason: collision with root package name */
    public r0 f1918x;

    /* renamed from: y  reason: collision with root package name */
    public y0 f1919y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f1920z;

    public LinearLayoutManager(int i10) {
        o1(i10);
        m((String) null);
        if (this.A) {
            this.A = false;
            y0();
        }
    }

    public final void A0(int i10) {
        this.E = i10;
        this.F = RecyclerView.UNDEFINED_DURATION;
        t0 t0Var = this.G;
        if (t0Var != null) {
            t0Var.f2196h = -1;
        }
        y0();
    }

    public final View B(int i10) {
        int H2 = H();
        if (H2 == 0) {
            return null;
        }
        int O = i10 - q1.O(G(0));
        if (O >= 0 && O < H2) {
            View G2 = G(O);
            if (q1.O(G2) == i10) {
                return G2;
            }
        }
        return super.B(i10);
    }

    public int B0(int i10, y1 y1Var, g2 g2Var) {
        if (this.f1917w == 0) {
            return 0;
        }
        return m1(i10, y1Var, g2Var);
    }

    public r1 C() {
        return new r1(-2, -2);
    }

    public final boolean I0() {
        boolean z10;
        if (this.f2155t == 1073741824 || this.f2154s == 1073741824) {
            return false;
        }
        int H2 = H();
        int i10 = 0;
        while (true) {
            if (i10 >= H2) {
                z10 = false;
                break;
            }
            ViewGroup.LayoutParams layoutParams = G(i10).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public void K0(RecyclerView recyclerView, int i10) {
        u0 u0Var = new u0(recyclerView.getContext());
        u0Var.f1983a = i10;
        L0(u0Var);
    }

    public boolean M0() {
        return this.G == null && this.f1920z == this.C;
    }

    public void N0(g2 g2Var, int[] iArr) {
        boolean z10;
        int i10;
        int i11;
        if (g2Var.f2018a != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = this.f1919y.k();
        } else {
            i10 = 0;
        }
        if (this.f1918x.f2177f == -1) {
            i11 = 0;
        } else {
            i11 = i10;
            i10 = 0;
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public void O0(g2 g2Var, r0 r0Var, i0 i0Var) {
        int i10 = r0Var.f2175d;
        if (i10 >= 0 && i10 < g2Var.b()) {
            i0Var.a(i10, Math.max(0, r0Var.f2178g));
        }
    }

    public final int P0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        T0();
        y0 y0Var = this.f1919y;
        boolean z10 = !this.D;
        return n2.a(g2Var, y0Var, W0(z10), V0(z10), this, this.D);
    }

    public final int Q0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        T0();
        y0 y0Var = this.f1919y;
        boolean z10 = !this.D;
        return n2.b(g2Var, y0Var, W0(z10), V0(z10), this, this.D, this.B);
    }

    public final int R0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        T0();
        y0 y0Var = this.f1919y;
        boolean z10 = !this.D;
        return n2.c(g2Var, y0Var, W0(z10), V0(z10), this, this.D);
    }

    public final int S0(int i10) {
        if (i10 == 1) {
            return (this.f1917w != 1 && g1()) ? 1 : -1;
        }
        if (i10 == 2) {
            return (this.f1917w != 1 && g1()) ? -1 : 1;
        }
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 == 130 && this.f1917w == 1) {
                        return 1;
                    }
                    return RecyclerView.UNDEFINED_DURATION;
                } else if (this.f1917w == 0) {
                    return 1;
                } else {
                    return RecyclerView.UNDEFINED_DURATION;
                }
            } else if (this.f1917w == 1) {
                return -1;
            } else {
                return RecyclerView.UNDEFINED_DURATION;
            }
        } else if (this.f1917w == 0) {
            return -1;
        } else {
            return RecyclerView.UNDEFINED_DURATION;
        }
    }

    public final void T0() {
        if (this.f1918x == null) {
            this.f1918x = new r0();
        }
    }

    public final boolean U() {
        return true;
    }

    public final int U0(y1 y1Var, r0 r0Var, g2 g2Var, boolean z10) {
        boolean z11;
        int i10 = r0Var.f2174c;
        int i11 = r0Var.f2178g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                r0Var.f2178g = i11 + i10;
            }
            j1(y1Var, r0Var);
        }
        int i12 = r0Var.f2174c + r0Var.f2179h;
        while (true) {
            if (!r0Var.f2183l && i12 <= 0) {
                break;
            }
            int i13 = r0Var.f2175d;
            if (i13 < 0 || i13 >= g2Var.b()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                break;
            }
            q0 q0Var = this.I;
            q0Var.f2139a = 0;
            q0Var.f2140b = false;
            q0Var.f2141c = false;
            q0Var.f2142d = false;
            h1(y1Var, g2Var, r0Var, q0Var);
            if (!q0Var.f2140b) {
                int i14 = r0Var.f2173b;
                int i15 = q0Var.f2139a;
                r0Var.f2173b = (r0Var.f2177f * i15) + i14;
                if (!q0Var.f2141c || r0Var.f2182k != null || !g2Var.f2024g) {
                    r0Var.f2174c -= i15;
                    i12 -= i15;
                }
                int i16 = r0Var.f2178g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + i15;
                    r0Var.f2178g = i17;
                    int i18 = r0Var.f2174c;
                    if (i18 < 0) {
                        r0Var.f2178g = i17 + i18;
                    }
                    j1(y1Var, r0Var);
                }
                if (z10 && q0Var.f2142d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - r0Var.f2174c;
    }

    public final View V0(boolean z10) {
        int i10;
        int i11;
        if (this.B) {
            i11 = H();
            i10 = 0;
        } else {
            i10 = H() - 1;
            i11 = -1;
        }
        return a1(i10, i11, z10);
    }

    public final View W0(boolean z10) {
        int i10;
        int i11;
        if (this.B) {
            i10 = -1;
            i11 = H() - 1;
        } else {
            i10 = H();
            i11 = 0;
        }
        return a1(i11, i10, z10);
    }

    public final int X0() {
        View a12 = a1(0, H(), false);
        if (a12 == null) {
            return -1;
        }
        return q1.O(a12);
    }

    public final int Y0() {
        View a12 = a1(H() - 1, -1, false);
        if (a12 == null) {
            return -1;
        }
        return q1.O(a12);
    }

    public final View Z0(int i10, int i11) {
        int i12;
        int i13;
        T0();
        if ((i11 > i10 ? 1 : i11 < i10 ? (char) 65535 : 0) == 0) {
            return G(i10);
        }
        if (this.f1919y.f(G(i10)) < this.f1919y.j()) {
            i13 = 16644;
            i12 = 16388;
        } else {
            i13 = 4161;
            i12 = 4097;
        }
        return (this.f1917w == 0 ? this.f2145j : this.f2146k).q(i10, i11, i13, i12);
    }

    public final View a1(int i10, int i11, boolean z10) {
        T0();
        return (this.f1917w == 0 ? this.f2145j : this.f2146k).q(i10, i11, z10 ? 24579 : 320, 320);
    }

    public final void b0(RecyclerView recyclerView) {
    }

    public View b1(y1 y1Var, g2 g2Var, boolean z10, boolean z11) {
        int i10;
        int i11;
        int i12;
        T0();
        int H2 = H();
        if (z11) {
            i12 = H() - 1;
            i11 = -1;
            i10 = -1;
        } else {
            i11 = H2;
            i12 = 0;
            i10 = 1;
        }
        int b10 = g2Var.b();
        int j10 = this.f1919y.j();
        int h10 = this.f1919y.h();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i12 != i11) {
            View G2 = G(i12);
            int O = q1.O(G2);
            int f10 = this.f1919y.f(G2);
            int d10 = this.f1919y.d(G2);
            if (O >= 0 && O < b10) {
                if (!((r1) G2.getLayoutParams()).w()) {
                    boolean z12 = d10 <= j10 && f10 < j10;
                    boolean z13 = f10 >= h10 && d10 > h10;
                    if (!z12 && !z13) {
                        return G2;
                    }
                    if (z10) {
                        if (!z13) {
                            if (view != null) {
                            }
                            view = G2;
                        }
                    } else if (!z12) {
                        if (view != null) {
                        }
                        view = G2;
                    }
                    view2 = G2;
                } else if (view3 == null) {
                    view3 = G2;
                }
            }
            i12 += i10;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public View c0(View view, int i10, y1 y1Var, g2 g2Var) {
        int S0;
        View view2;
        View view3;
        l1();
        if (H() == 0 || (S0 = S0(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        T0();
        q1(S0, (int) (((float) this.f1919y.k()) * 0.33333334f), false, g2Var);
        r0 r0Var = this.f1918x;
        r0Var.f2178g = RecyclerView.UNDEFINED_DURATION;
        r0Var.f2172a = false;
        U0(y1Var, r0Var, g2Var, true);
        if (S0 == -1) {
            if (this.B) {
                view2 = Z0(H() - 1, -1);
            } else {
                view2 = Z0(0, H());
            }
        } else if (this.B) {
            view2 = Z0(0, H());
        } else {
            view2 = Z0(H() - 1, -1);
        }
        if (S0 == -1) {
            view3 = f1();
        } else {
            view3 = e1();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    public final int c1(int i10, y1 y1Var, g2 g2Var, boolean z10) {
        int h10;
        int h11 = this.f1919y.h() - i10;
        if (h11 <= 0) {
            return 0;
        }
        int i11 = -m1(-h11, y1Var, g2Var);
        int i12 = i10 + i11;
        if (!z10 || (h10 = this.f1919y.h() - i12) <= 0) {
            return i11;
        }
        this.f1919y.o(h10);
        return h10 + i11;
    }

    public final PointF d(int i10) {
        if (H() == 0) {
            return null;
        }
        boolean z10 = false;
        int i11 = 1;
        if (i10 < q1.O(G(0))) {
            z10 = true;
        }
        if (z10 != this.B) {
            i11 = -1;
        }
        return this.f1917w == 0 ? new PointF((float) i11, 0.0f) : new PointF(0.0f, (float) i11);
    }

    public final void d0(AccessibilityEvent accessibilityEvent) {
        super.d0(accessibilityEvent);
        if (H() > 0) {
            accessibilityEvent.setFromIndex(X0());
            accessibilityEvent.setToIndex(Y0());
        }
    }

    public final int d1(int i10, y1 y1Var, g2 g2Var, boolean z10) {
        int j10;
        int j11 = i10 - this.f1919y.j();
        if (j11 <= 0) {
            return 0;
        }
        int i11 = -m1(j11, y1Var, g2Var);
        int i12 = i10 + i11;
        if (!z10 || (j10 = i12 - this.f1919y.j()) <= 0) {
            return i11;
        }
        this.f1919y.o(-j10);
        return i11 - j10;
    }

    public final View e1() {
        return G(this.B ? 0 : H() - 1);
    }

    public final View f1() {
        return G(this.B ? H() - 1 : 0);
    }

    public final boolean g1() {
        return M() == 1;
    }

    public void h1(y1 y1Var, g2 g2Var, r0 r0Var, q0 q0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        boolean z11;
        View b10 = r0Var.b(y1Var);
        if (b10 == null) {
            q0Var.f2140b = true;
            return;
        }
        r1 r1Var = (r1) b10.getLayoutParams();
        if (r0Var.f2182k == null) {
            boolean z12 = this.B;
            if (r0Var.f2177f == -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z12 == z11) {
                l(b10, -1, false);
            } else {
                l(b10, 0, false);
            }
        } else {
            boolean z13 = this.B;
            if (r0Var.f2177f == -1) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13 == z10) {
                l(b10, -1, true);
            } else {
                l(b10, 0, true);
            }
        }
        r1 r1Var2 = (r1) b10.getLayoutParams();
        Rect itemDecorInsetsForChild = this.f2144i.getItemDecorInsetsForChild(b10);
        int I2 = q1.I(this.f2156u, this.f2154s, getPaddingRight() + getPaddingLeft() + r1Var2.leftMargin + r1Var2.rightMargin + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + 0, r1Var2.width, o());
        int I3 = q1.I(this.f2157v, this.f2155t, getPaddingBottom() + getPaddingTop() + r1Var2.topMargin + r1Var2.bottomMargin + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + 0, r1Var2.height, p());
        if (H0(b10, I2, I3, r1Var2)) {
            b10.measure(I2, I3);
        }
        q0Var.f2139a = this.f1919y.e(b10);
        if (this.f1917w == 1) {
            if (g1()) {
                i13 = this.f2156u - getPaddingRight();
                i14 = i13 - this.f1919y.p(b10);
            } else {
                i14 = getPaddingLeft();
                i13 = this.f1919y.p(b10) + i14;
            }
            int i16 = r0Var.f2177f;
            i10 = r0Var.f2173b;
            if (i16 == -1) {
                i15 = i14;
                i11 = i10;
                i10 -= q0Var.f2139a;
            } else {
                i15 = i14;
                i11 = q0Var.f2139a + i10;
            }
            i12 = i15;
        } else {
            int paddingTop = getPaddingTop();
            i11 = this.f1919y.p(b10) + paddingTop;
            int i17 = r0Var.f2177f;
            int i18 = r0Var.f2173b;
            if (i17 == -1) {
                i12 = i18 - q0Var.f2139a;
                int i19 = paddingTop;
                i13 = i18;
                i10 = i19;
            } else {
                int i20 = q0Var.f2139a + i18;
                i12 = i18;
                i10 = paddingTop;
                i13 = i20;
            }
        }
        q1.W(b10, i12, i10, i13, i11);
        if (r1Var.w() || r1Var.v()) {
            q0Var.f2141c = true;
        }
        q0Var.f2142d = b10.hasFocusable();
    }

    public void i1(y1 y1Var, g2 g2Var, p0 p0Var, int i10) {
    }

    public final void j1(y1 y1Var, r0 r0Var) {
        if (r0Var.f2172a && !r0Var.f2183l) {
            int i10 = r0Var.f2178g;
            int i11 = r0Var.f2180i;
            if (r0Var.f2177f == -1) {
                int H2 = H();
                if (i10 >= 0) {
                    int g10 = (this.f1919y.g() - i10) + i11;
                    if (this.B) {
                        for (int i12 = 0; i12 < H2; i12++) {
                            View G2 = G(i12);
                            if (this.f1919y.f(G2) < g10 || this.f1919y.n(G2) < g10) {
                                k1(y1Var, 0, i12);
                                return;
                            }
                        }
                        return;
                    }
                    int i13 = H2 - 1;
                    for (int i14 = i13; i14 >= 0; i14--) {
                        View G3 = G(i14);
                        if (this.f1919y.f(G3) < g10 || this.f1919y.n(G3) < g10) {
                            k1(y1Var, i13, i14);
                            return;
                        }
                    }
                }
            } else if (i10 >= 0) {
                int i15 = i10 - i11;
                int H3 = H();
                if (this.B) {
                    int i16 = H3 - 1;
                    for (int i17 = i16; i17 >= 0; i17--) {
                        View G4 = G(i17);
                        if (this.f1919y.d(G4) > i15 || this.f1919y.m(G4) > i15) {
                            k1(y1Var, i16, i17);
                            return;
                        }
                    }
                    return;
                }
                for (int i18 = 0; i18 < H3; i18++) {
                    View G5 = G(i18);
                    if (this.f1919y.d(G5) > i15 || this.f1919y.m(G5) > i15) {
                        k1(y1Var, 0, i18);
                        return;
                    }
                }
            }
        }
    }

    public final void k1(y1 y1Var, int i10, int i11) {
        if (i10 != i11) {
            if (i11 > i10) {
                while (true) {
                    i11--;
                    if (i11 >= i10) {
                        View G2 = G(i11);
                        if (G(i11) != null) {
                            k kVar = this.f2143h;
                            int f10 = kVar.f(i11);
                            e1 e1Var = kVar.f2063a;
                            View childAt = e1Var.f1972a.getChildAt(f10);
                            if (childAt != null) {
                                if (kVar.f2064b.f(f10)) {
                                    kVar.k(childAt);
                                }
                                e1Var.c(f10);
                            }
                        }
                        y1Var.j(G2);
                    } else {
                        return;
                    }
                }
            } else {
                while (i10 > i11) {
                    View G3 = G(i10);
                    if (G(i10) != null) {
                        k kVar2 = this.f2143h;
                        int f11 = kVar2.f(i10);
                        e1 e1Var2 = kVar2.f2063a;
                        View childAt2 = e1Var2.f1972a.getChildAt(f11);
                        if (childAt2 != null) {
                            if (kVar2.f2064b.f(f11)) {
                                kVar2.k(childAt2);
                            }
                            e1Var2.c(f11);
                        }
                    }
                    y1Var.j(G3);
                    i10--;
                }
            }
        }
    }

    public final void l1() {
        this.B = (this.f1917w == 1 || !g1()) ? this.A : !this.A;
    }

    public final void m(String str) {
        if (this.G == null) {
            super.m(str);
        }
    }

    public final int m1(int i10, y1 y1Var, g2 g2Var) {
        if (H() == 0 || i10 == 0) {
            return 0;
        }
        T0();
        this.f1918x.f2172a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int abs = Math.abs(i10);
        q1(i11, abs, true, g2Var);
        r0 r0Var = this.f1918x;
        int U0 = U0(y1Var, r0Var, g2Var, false) + r0Var.f2178g;
        if (U0 < 0) {
            return 0;
        }
        if (abs > U0) {
            i10 = i11 * U0;
        }
        this.f1919y.o(-i10);
        this.f1918x.f2181j = i10;
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x022f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0190  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void n0(androidx.recyclerview.widget.y1 r18, androidx.recyclerview.widget.g2 r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            androidx.recyclerview.widget.t0 r3 = r0.G
            r4 = -1
            if (r3 != 0) goto L_0x000f
            int r3 = r0.E
            if (r3 == r4) goto L_0x0019
        L_0x000f:
            int r3 = r19.b()
            if (r3 != 0) goto L_0x0019
            r17.u0(r18)
            return
        L_0x0019:
            androidx.recyclerview.widget.t0 r3 = r0.G
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x002a
            int r3 = r3.f2196h
            if (r3 < 0) goto L_0x0025
            r7 = 1
            goto L_0x0026
        L_0x0025:
            r7 = 0
        L_0x0026:
            if (r7 == 0) goto L_0x002a
            r0.E = r3
        L_0x002a:
            r17.T0()
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2172a = r6
            r17.l1()
            androidx.recyclerview.widget.RecyclerView r3 = r0.f2144i
            if (r3 != 0) goto L_0x003a
        L_0x0038:
            r3 = 0
            goto L_0x0049
        L_0x003a:
            android.view.View r3 = r3.getFocusedChild()
            if (r3 == 0) goto L_0x0038
            androidx.recyclerview.widget.k r8 = r0.f2143h
            boolean r8 = r8.j(r3)
            if (r8 == 0) goto L_0x0049
            goto L_0x0038
        L_0x0049:
            androidx.recyclerview.widget.p0 r8 = r0.H
            boolean r9 = r8.f2127e
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == 0) goto L_0x0081
            int r9 = r0.E
            if (r9 != r4) goto L_0x0081
            androidx.recyclerview.widget.t0 r9 = r0.G
            if (r9 == 0) goto L_0x005a
            goto L_0x0081
        L_0x005a:
            if (r3 == 0) goto L_0x0251
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.f(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.h()
            if (r9 >= r11) goto L_0x0078
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.d(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.j()
            if (r9 > r11) goto L_0x0251
        L_0x0078:
            int r9 = androidx.recyclerview.widget.q1.O(r3)
            r8.b(r3, r9)
            goto L_0x0251
        L_0x0081:
            r8.c()
            boolean r3 = r0.B
            boolean r9 = r0.C
            r3 = r3 ^ r9
            r8.f2126d = r3
            boolean r3 = r2.f2024g
            if (r3 != 0) goto L_0x018b
            int r3 = r0.E
            if (r3 != r4) goto L_0x0095
            goto L_0x018b
        L_0x0095:
            if (r3 < 0) goto L_0x0187
            int r9 = r19.b()
            if (r3 < r9) goto L_0x009f
            goto L_0x0187
        L_0x009f:
            int r3 = r0.E
            r8.f2124b = r3
            androidx.recyclerview.widget.t0 r9 = r0.G
            if (r9 == 0) goto L_0x00ce
            int r11 = r9.f2196h
            if (r11 < 0) goto L_0x00ad
            r11 = 1
            goto L_0x00ae
        L_0x00ad:
            r11 = 0
        L_0x00ae:
            if (r11 == 0) goto L_0x00ce
            boolean r3 = r9.f2198j
            r8.f2126d = r3
            if (r3 == 0) goto L_0x00c2
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.h()
            androidx.recyclerview.widget.t0 r9 = r0.G
            int r9 = r9.f2197i
            goto L_0x0178
        L_0x00c2:
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.j()
            androidx.recyclerview.widget.t0 r9 = r0.G
            int r9 = r9.f2197i
            goto L_0x0182
        L_0x00ce:
            int r9 = r0.F
            if (r9 != r10) goto L_0x016a
            android.view.View r3 = r0.B(r3)
            if (r3 == 0) goto L_0x0138
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.e(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.k()
            if (r9 <= r11) goto L_0x00e8
            goto L_0x0156
        L_0x00e8:
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.f(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.j()
            int r9 = r9 - r11
            if (r9 >= 0) goto L_0x0103
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.j()
            r8.f2125c = r3
            r8.f2126d = r6
            goto L_0x0185
        L_0x0103:
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.h()
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.d(r3)
            int r9 = r9 - r11
            if (r9 >= 0) goto L_0x011d
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.h()
            r8.f2125c = r3
            r8.f2126d = r5
            goto L_0x0185
        L_0x011d:
            boolean r9 = r8.f2126d
            if (r9 == 0) goto L_0x012f
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r3 = r9.d(r3)
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.l()
            int r9 = r9 + r3
            goto L_0x0135
        L_0x012f:
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.f(r3)
        L_0x0135:
            r8.f2125c = r9
            goto L_0x0185
        L_0x0138:
            int r3 = r17.H()
            if (r3 <= 0) goto L_0x0156
            android.view.View r3 = r0.G(r6)
            int r3 = androidx.recyclerview.widget.q1.O(r3)
            int r9 = r0.E
            if (r9 >= r3) goto L_0x014c
            r3 = 1
            goto L_0x014d
        L_0x014c:
            r3 = 0
        L_0x014d:
            boolean r9 = r0.B
            if (r3 != r9) goto L_0x0153
            r3 = 1
            goto L_0x0154
        L_0x0153:
            r3 = 0
        L_0x0154:
            r8.f2126d = r3
        L_0x0156:
            boolean r3 = r8.f2126d
            if (r3 == 0) goto L_0x0161
            androidx.recyclerview.widget.y0 r3 = r8.f2123a
            int r3 = r3.h()
            goto L_0x0167
        L_0x0161:
            androidx.recyclerview.widget.y0 r3 = r8.f2123a
            int r3 = r3.j()
        L_0x0167:
            r8.f2125c = r3
            goto L_0x0185
        L_0x016a:
            boolean r3 = r0.B
            r8.f2126d = r3
            if (r3 == 0) goto L_0x017a
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.h()
            int r9 = r0.F
        L_0x0178:
            int r3 = r3 - r9
            goto L_0x0183
        L_0x017a:
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.j()
            int r9 = r0.F
        L_0x0182:
            int r3 = r3 + r9
        L_0x0183:
            r8.f2125c = r3
        L_0x0185:
            r3 = 1
            goto L_0x018c
        L_0x0187:
            r0.E = r4
            r0.F = r10
        L_0x018b:
            r3 = 0
        L_0x018c:
            if (r3 == 0) goto L_0x0190
            goto L_0x024f
        L_0x0190:
            int r3 = r17.H()
            if (r3 != 0) goto L_0x0198
            goto L_0x022b
        L_0x0198:
            androidx.recyclerview.widget.RecyclerView r3 = r0.f2144i
            if (r3 != 0) goto L_0x019e
        L_0x019c:
            r3 = 0
            goto L_0x01ad
        L_0x019e:
            android.view.View r3 = r3.getFocusedChild()
            if (r3 == 0) goto L_0x019c
            androidx.recyclerview.widget.k r9 = r0.f2143h
            boolean r9 = r9.j(r3)
            if (r9 == 0) goto L_0x01ad
            goto L_0x019c
        L_0x01ad:
            if (r3 == 0) goto L_0x01d8
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.recyclerview.widget.r1 r9 = (androidx.recyclerview.widget.r1) r9
            boolean r11 = r9.w()
            if (r11 != 0) goto L_0x01cd
            int r11 = r9.u()
            if (r11 < 0) goto L_0x01cd
            int r9 = r9.u()
            int r11 = r19.b()
            if (r9 >= r11) goto L_0x01cd
            r9 = 1
            goto L_0x01ce
        L_0x01cd:
            r9 = 0
        L_0x01ce:
            if (r9 == 0) goto L_0x01d8
            int r9 = androidx.recyclerview.widget.q1.O(r3)
            r8.b(r3, r9)
            goto L_0x0229
        L_0x01d8:
            boolean r3 = r0.f1920z
            boolean r9 = r0.C
            if (r3 == r9) goto L_0x01df
            goto L_0x022b
        L_0x01df:
            boolean r3 = r8.f2126d
            android.view.View r3 = r0.b1(r1, r2, r3, r9)
            if (r3 == 0) goto L_0x022b
            int r9 = androidx.recyclerview.widget.q1.O(r3)
            r8.a(r3, r9)
            boolean r9 = r2.f2024g
            if (r9 != 0) goto L_0x0229
            boolean r9 = r17.M0()
            if (r9 == 0) goto L_0x0229
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.f(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r3 = r11.d(r3)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.j()
            androidx.recyclerview.widget.y0 r12 = r0.f1919y
            int r12 = r12.h()
            if (r3 > r11) goto L_0x0216
            if (r9 >= r11) goto L_0x0216
            r13 = 1
            goto L_0x0217
        L_0x0216:
            r13 = 0
        L_0x0217:
            if (r9 < r12) goto L_0x021d
            if (r3 <= r12) goto L_0x021d
            r3 = 1
            goto L_0x021e
        L_0x021d:
            r3 = 0
        L_0x021e:
            if (r13 != 0) goto L_0x0222
            if (r3 == 0) goto L_0x0229
        L_0x0222:
            boolean r3 = r8.f2126d
            if (r3 == 0) goto L_0x0227
            r11 = r12
        L_0x0227:
            r8.f2125c = r11
        L_0x0229:
            r3 = 1
            goto L_0x022c
        L_0x022b:
            r3 = 0
        L_0x022c:
            if (r3 == 0) goto L_0x022f
            goto L_0x024f
        L_0x022f:
            boolean r3 = r8.f2126d
            if (r3 == 0) goto L_0x023a
            androidx.recyclerview.widget.y0 r3 = r8.f2123a
            int r3 = r3.h()
            goto L_0x0240
        L_0x023a:
            androidx.recyclerview.widget.y0 r3 = r8.f2123a
            int r3 = r3.j()
        L_0x0240:
            r8.f2125c = r3
            boolean r3 = r0.C
            if (r3 == 0) goto L_0x024c
            int r3 = r19.b()
            int r3 = r3 + r4
            goto L_0x024d
        L_0x024c:
            r3 = 0
        L_0x024d:
            r8.f2124b = r3
        L_0x024f:
            r8.f2127e = r5
        L_0x0251:
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r9 = r3.f2181j
            if (r9 < 0) goto L_0x0259
            r9 = 1
            goto L_0x025a
        L_0x0259:
            r9 = -1
        L_0x025a:
            r3.f2177f = r9
            int[] r3 = r0.K
            r3[r6] = r6
            r3[r5] = r6
            r0.N0(r2, r3)
            r9 = r3[r6]
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.j()
            int r11 = r11 + r9
            r3 = r3[r5]
            int r3 = java.lang.Math.max(r6, r3)
            androidx.recyclerview.widget.y0 r9 = r0.f1919y
            int r9 = r9.q()
            int r9 = r9 + r3
            boolean r3 = r2.f2024g
            if (r3 == 0) goto L_0x02ba
            int r3 = r0.E
            if (r3 == r4) goto L_0x02ba
            int r12 = r0.F
            if (r12 == r10) goto L_0x02ba
            android.view.View r3 = r0.B(r3)
            if (r3 == 0) goto L_0x02ba
            boolean r10 = r0.B
            if (r10 == 0) goto L_0x02a5
            androidx.recyclerview.widget.y0 r10 = r0.f1919y
            int r10 = r10.h()
            androidx.recyclerview.widget.y0 r12 = r0.f1919y
            int r3 = r12.d(r3)
            int r10 = r10 - r3
            int r3 = r0.F
            goto L_0x02b4
        L_0x02a5:
            androidx.recyclerview.widget.y0 r10 = r0.f1919y
            int r3 = r10.f(r3)
            androidx.recyclerview.widget.y0 r10 = r0.f1919y
            int r10 = r10.j()
            int r3 = r3 - r10
            int r10 = r0.F
        L_0x02b4:
            int r10 = r10 - r3
            if (r10 <= 0) goto L_0x02b9
            int r11 = r11 + r10
            goto L_0x02ba
        L_0x02b9:
            int r9 = r9 - r10
        L_0x02ba:
            boolean r3 = r8.f2126d
            if (r3 == 0) goto L_0x02c3
            boolean r3 = r0.B
            if (r3 == 0) goto L_0x02c7
            goto L_0x02c9
        L_0x02c3:
            boolean r3 = r0.B
            if (r3 == 0) goto L_0x02c9
        L_0x02c7:
            r3 = -1
            goto L_0x02ca
        L_0x02c9:
            r3 = 1
        L_0x02ca:
            r0.i1(r1, r2, r8, r3)
            r17.A(r18)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            androidx.recyclerview.widget.y0 r10 = r0.f1919y
            int r10 = r10.i()
            if (r10 != 0) goto L_0x02e4
            androidx.recyclerview.widget.y0 r10 = r0.f1919y
            int r10 = r10.g()
            if (r10 != 0) goto L_0x02e4
            r10 = 1
            goto L_0x02e5
        L_0x02e4:
            r10 = 0
        L_0x02e5:
            r3.f2183l = r10
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.getClass()
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2180i = r6
            boolean r3 = r8.f2126d
            if (r3 == 0) goto L_0x0339
            int r3 = r8.f2124b
            int r10 = r8.f2125c
            r0.s1(r3, r10)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r11
            r0.U0(r1, r3, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r10 = r3.f2173b
            int r11 = r3.f2175d
            int r3 = r3.f2174c
            if (r3 <= 0) goto L_0x030d
            int r9 = r9 + r3
        L_0x030d:
            int r3 = r8.f2124b
            int r12 = r8.f2125c
            r0.r1(r3, r12)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r9
            int r9 = r3.f2175d
            int r12 = r3.f2176e
            int r9 = r9 + r12
            r3.f2175d = r9
            r0.U0(r1, r3, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r9 = r3.f2173b
            int r3 = r3.f2174c
            if (r3 <= 0) goto L_0x037f
            r0.s1(r11, r10)
            androidx.recyclerview.widget.r0 r10 = r0.f1918x
            r10.f2179h = r3
            r0.U0(r1, r10, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r10 = r3.f2173b
            goto L_0x037f
        L_0x0339:
            int r3 = r8.f2124b
            int r10 = r8.f2125c
            r0.r1(r3, r10)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r9
            r0.U0(r1, r3, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r9 = r3.f2173b
            int r10 = r3.f2175d
            int r3 = r3.f2174c
            if (r3 <= 0) goto L_0x0352
            int r11 = r11 + r3
        L_0x0352:
            int r3 = r8.f2124b
            int r12 = r8.f2125c
            r0.s1(r3, r12)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r11
            int r11 = r3.f2175d
            int r12 = r3.f2176e
            int r11 = r11 + r12
            r3.f2175d = r11
            r0.U0(r1, r3, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r11 = r3.f2173b
            int r3 = r3.f2174c
            if (r3 <= 0) goto L_0x037e
            r0.r1(r10, r9)
            androidx.recyclerview.widget.r0 r9 = r0.f1918x
            r9.f2179h = r3
            r0.U0(r1, r9, r2, r6)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            int r3 = r3.f2173b
            r9 = r3
        L_0x037e:
            r10 = r11
        L_0x037f:
            int r3 = r17.H()
            if (r3 <= 0) goto L_0x03a3
            boolean r3 = r0.B
            boolean r11 = r0.C
            r3 = r3 ^ r11
            if (r3 == 0) goto L_0x0397
            int r3 = r0.c1(r9, r1, r2, r5)
            int r10 = r10 + r3
            int r9 = r9 + r3
            int r3 = r0.d1(r10, r1, r2, r6)
            goto L_0x03a1
        L_0x0397:
            int r3 = r0.d1(r10, r1, r2, r5)
            int r10 = r10 + r3
            int r9 = r9 + r3
            int r3 = r0.c1(r9, r1, r2, r6)
        L_0x03a1:
            int r10 = r10 + r3
            int r9 = r9 + r3
        L_0x03a3:
            boolean r3 = r2.f2028k
            if (r3 == 0) goto L_0x0442
            int r3 = r17.H()
            if (r3 == 0) goto L_0x0442
            boolean r3 = r2.f2024g
            if (r3 != 0) goto L_0x0442
            boolean r3 = r17.M0()
            if (r3 != 0) goto L_0x03b9
            goto L_0x0442
        L_0x03b9:
            java.util.List r3 = r1.f2253d
            int r11 = r3.size()
            android.view.View r12 = r0.G(r6)
            int r12 = androidx.recyclerview.widget.q1.O(r12)
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x03ca:
            if (r13 >= r11) goto L_0x03fd
            java.lang.Object r16 = r3.get(r13)
            r5 = r16
            androidx.recyclerview.widget.k2 r5 = (androidx.recyclerview.widget.k2) r5
            boolean r16 = r5.isRemoved()
            if (r16 == 0) goto L_0x03db
            goto L_0x03f8
        L_0x03db:
            int r7 = r5.getLayoutPosition()
            if (r7 >= r12) goto L_0x03e3
            r7 = 1
            goto L_0x03e4
        L_0x03e3:
            r7 = 0
        L_0x03e4:
            boolean r6 = r0.B
            if (r7 == r6) goto L_0x03ea
            r6 = -1
            goto L_0x03eb
        L_0x03ea:
            r6 = 1
        L_0x03eb:
            androidx.recyclerview.widget.y0 r7 = r0.f1919y
            android.view.View r5 = r5.itemView
            int r5 = r7.e(r5)
            if (r6 != r4) goto L_0x03f7
            int r14 = r14 + r5
            goto L_0x03f8
        L_0x03f7:
            int r15 = r15 + r5
        L_0x03f8:
            int r13 = r13 + 1
            r5 = 1
            r6 = 0
            goto L_0x03ca
        L_0x03fd:
            androidx.recyclerview.widget.r0 r4 = r0.f1918x
            r4.f2182k = r3
            if (r14 <= 0) goto L_0x041f
            android.view.View r3 = r17.f1()
            int r3 = androidx.recyclerview.widget.q1.O(r3)
            r0.s1(r3, r10)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r14
            r4 = 0
            r3.f2174c = r4
            r5 = 0
            r3.a(r5)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r0.U0(r1, r3, r2, r4)
            goto L_0x0420
        L_0x041f:
            r4 = 0
        L_0x0420:
            if (r15 <= 0) goto L_0x043d
            android.view.View r3 = r17.e1()
            int r3 = androidx.recyclerview.widget.q1.O(r3)
            r0.r1(r3, r9)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r3.f2179h = r15
            r3.f2174c = r4
            r5 = 0
            r3.a(r5)
            androidx.recyclerview.widget.r0 r3 = r0.f1918x
            r0.U0(r1, r3, r2, r4)
            goto L_0x043e
        L_0x043d:
            r5 = 0
        L_0x043e:
            androidx.recyclerview.widget.r0 r1 = r0.f1918x
            r1.f2182k = r5
        L_0x0442:
            boolean r1 = r2.f2024g
            if (r1 != 0) goto L_0x044f
            androidx.recyclerview.widget.y0 r1 = r0.f1919y
            int r2 = r1.k()
            r1.f2271b = r2
            goto L_0x0452
        L_0x044f:
            r8.c()
        L_0x0452:
            boolean r1 = r0.C
            r0.f1920z = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.n0(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2):void");
    }

    public final void n1(int i10, int i11) {
        this.E = i10;
        this.F = i11;
        t0 t0Var = this.G;
        if (t0Var != null) {
            t0Var.f2196h = -1;
        }
        y0();
    }

    public final boolean o() {
        return this.f1917w == 0;
    }

    public void o0(g2 g2Var) {
        this.G = null;
        this.E = -1;
        this.F = RecyclerView.UNDEFINED_DURATION;
        this.H.c();
    }

    public final void o1(int i10) {
        if (i10 == 0 || i10 == 1) {
            m((String) null);
            if (i10 != this.f1917w || this.f1919y == null) {
                y0 b10 = z0.b(this, i10);
                this.f1919y = b10;
                this.H.f2123a = b10;
                this.f1917w = i10;
                y0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(h.i("invalid orientation:", i10));
    }

    public final boolean p() {
        return this.f1917w == 1;
    }

    public final void p0(Parcelable parcelable) {
        if (parcelable instanceof t0) {
            t0 t0Var = (t0) parcelable;
            this.G = t0Var;
            if (this.E != -1) {
                t0Var.f2196h = -1;
            }
            y0();
        }
    }

    public void p1(boolean z10) {
        m((String) null);
        if (this.C != z10) {
            this.C = z10;
            y0();
        }
    }

    public final Parcelable q0() {
        if (this.G != null) {
            return new t0(this.G);
        }
        t0 t0Var = new t0();
        if (H() > 0) {
            T0();
            boolean z10 = this.f1920z ^ this.B;
            t0Var.f2198j = z10;
            if (z10) {
                View e12 = e1();
                t0Var.f2197i = this.f1919y.h() - this.f1919y.d(e12);
                t0Var.f2196h = q1.O(e12);
            } else {
                View f12 = f1();
                t0Var.f2196h = q1.O(f12);
                t0Var.f2197i = this.f1919y.f(f12) - this.f1919y.j();
            }
        } else {
            t0Var.f2196h = -1;
        }
        return t0Var;
    }

    public final void q1(int i10, int i11, boolean z10, g2 g2Var) {
        boolean z11;
        int i12;
        int i13;
        r0 r0Var = this.f1918x;
        boolean z12 = false;
        int i14 = 1;
        if (this.f1919y.i() == 0 && this.f1919y.g() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        r0Var.f2183l = z11;
        this.f1918x.f2177f = i10;
        int[] iArr = this.K;
        iArr[0] = 0;
        iArr[1] = 0;
        N0(g2Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        if (i10 == 1) {
            z12 = true;
        }
        r0 r0Var2 = this.f1918x;
        if (z12) {
            i12 = max2;
        } else {
            i12 = max;
        }
        r0Var2.f2179h = i12;
        if (!z12) {
            max = max2;
        }
        r0Var2.f2180i = max;
        if (z12) {
            r0Var2.f2179h = this.f1919y.q() + i12;
            View e12 = e1();
            r0 r0Var3 = this.f1918x;
            if (this.B) {
                i14 = -1;
            }
            r0Var3.f2176e = i14;
            int O = q1.O(e12);
            r0 r0Var4 = this.f1918x;
            r0Var3.f2175d = O + r0Var4.f2176e;
            r0Var4.f2173b = this.f1919y.d(e12);
            i13 = this.f1919y.d(e12) - this.f1919y.h();
        } else {
            View f12 = f1();
            r0 r0Var5 = this.f1918x;
            r0Var5.f2179h = this.f1919y.j() + r0Var5.f2179h;
            r0 r0Var6 = this.f1918x;
            if (!this.B) {
                i14 = -1;
            }
            r0Var6.f2176e = i14;
            int O2 = q1.O(f12);
            r0 r0Var7 = this.f1918x;
            r0Var6.f2175d = O2 + r0Var7.f2176e;
            r0Var7.f2173b = this.f1919y.f(f12);
            i13 = (-this.f1919y.f(f12)) + this.f1919y.j();
        }
        r0 r0Var8 = this.f1918x;
        r0Var8.f2174c = i11;
        if (z10) {
            r0Var8.f2174c = i11 - i13;
        }
        r0Var8.f2178g = i13;
    }

    public final void r1(int i10, int i11) {
        this.f1918x.f2174c = this.f1919y.h() - i11;
        r0 r0Var = this.f1918x;
        r0Var.f2176e = this.B ? -1 : 1;
        r0Var.f2175d = i10;
        r0Var.f2177f = 1;
        r0Var.f2173b = i11;
        r0Var.f2178g = RecyclerView.UNDEFINED_DURATION;
    }

    public final void s(int i10, int i11, g2 g2Var, i0 i0Var) {
        if (this.f1917w != 0) {
            i10 = i11;
        }
        if (H() != 0 && i10 != 0) {
            T0();
            q1(i10 > 0 ? 1 : -1, Math.abs(i10), true, g2Var);
            O0(g2Var, this.f1918x, i0Var);
        }
    }

    public final void s1(int i10, int i11) {
        this.f1918x.f2174c = i11 - this.f1919y.j();
        r0 r0Var = this.f1918x;
        r0Var.f2175d = i10;
        r0Var.f2176e = this.B ? 1 : -1;
        r0Var.f2177f = -1;
        r0Var.f2173b = i11;
        r0Var.f2178g = RecyclerView.UNDEFINED_DURATION;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(int r7, androidx.recyclerview.widget.i0 r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.t0 r0 = r6.G
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L_0x0013
            int r4 = r0.f2196h
            if (r4 < 0) goto L_0x000d
            r5 = 1
            goto L_0x000e
        L_0x000d:
            r5 = 0
        L_0x000e:
            if (r5 == 0) goto L_0x0013
            boolean r0 = r0.f2198j
            goto L_0x0022
        L_0x0013:
            r6.l1()
            boolean r0 = r6.B
            int r4 = r6.E
            if (r4 != r2) goto L_0x0022
            if (r0 == 0) goto L_0x0021
            int r4 = r7 + -1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x0025
            r1 = -1
        L_0x0025:
            r0 = 0
        L_0x0026:
            int r2 = r6.J
            if (r0 >= r2) goto L_0x0035
            if (r4 < 0) goto L_0x0035
            if (r4 >= r7) goto L_0x0035
            r8.a(r4, r3)
            int r4 = r4 + r1
            int r0 = r0 + 1
            goto L_0x0026
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.t(int, androidx.recyclerview.widget.i0):void");
    }

    public final int u(g2 g2Var) {
        return P0(g2Var);
    }

    public int v(g2 g2Var) {
        return Q0(g2Var);
    }

    public int w(g2 g2Var) {
        return R0(g2Var);
    }

    public final int x(g2 g2Var) {
        return P0(g2Var);
    }

    public int y(g2 g2Var) {
        return Q0(g2Var);
    }

    public int z(g2 g2Var) {
        return R0(g2Var);
    }

    public int z0(int i10, y1 y1Var, g2 g2Var) {
        if (this.f1917w == 1) {
            return 0;
        }
        return m1(i10, y1Var, g2Var);
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        p1 P = q1.P(context, attributeSet, i10, i11);
        o1(P.f2128a);
        boolean z10 = P.f2130c;
        m((String) null);
        if (z10 != this.A) {
            this.A = z10;
            y0();
        }
        p1(P.f2131d);
    }
}
