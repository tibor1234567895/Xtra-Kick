package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.media.h;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.google.gson.internal.bind.l;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import n0.i;

public class GridLayoutManager extends LinearLayoutManager {
    public boolean L = false;
    public int M = -1;
    public int[] N;
    public View[] O;
    public final SparseIntArray P = new SparseIntArray();
    public final SparseIntArray Q = new SparseIntArray();
    public final l0 R = new l0();
    public final Rect S = new Rect();

    public GridLayoutManager(int i10) {
        super(1);
        z1(i10);
    }

    public final void A1() {
        int i10;
        int i11;
        if (this.f1917w == 1) {
            i11 = this.f2156u - getPaddingRight();
            i10 = getPaddingLeft();
        } else {
            i11 = this.f2157v - getPaddingBottom();
            i10 = getPaddingTop();
        }
        t1(i11 - i10);
    }

    public final int B0(int i10, y1 y1Var, g2 g2Var) {
        A1();
        View[] viewArr = this.O;
        if (viewArr == null || viewArr.length != this.M) {
            this.O = new View[this.M];
        }
        return super.B0(i10, y1Var, g2Var);
    }

    public final r1 C() {
        return this.f1917w == 0 ? new m0(-2, -1) : new m0(-1, -2);
    }

    public final r1 D(Context context, AttributeSet attributeSet) {
        return new m0(context, attributeSet);
    }

    public final r1 E(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new m0((ViewGroup.MarginLayoutParams) layoutParams) : new m0(layoutParams);
    }

    public final void E0(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.N == null) {
            super.E0(rect, i10, i11);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f1917w == 1) {
            int height = rect.height() + paddingBottom;
            RecyclerView recyclerView = this.f2144i;
            WeakHashMap weakHashMap = c1.f10054a;
            i13 = q1.r(i11, height, i0.d(recyclerView));
            int[] iArr = this.N;
            i12 = q1.r(i10, iArr[iArr.length - 1] + paddingRight, i0.e(this.f2144i));
        } else {
            int width = rect.width() + paddingRight;
            RecyclerView recyclerView2 = this.f2144i;
            WeakHashMap weakHashMap2 = c1.f10054a;
            i12 = q1.r(i10, width, i0.e(recyclerView2));
            int[] iArr2 = this.N;
            i13 = q1.r(i11, iArr2[iArr2.length - 1] + paddingBottom, i0.d(this.f2144i));
        }
        this.f2144i.setMeasuredDimension(i12, i13);
    }

    public final int J(y1 y1Var, g2 g2Var) {
        if (this.f1917w == 1) {
            return this.M;
        }
        if (g2Var.b() < 1) {
            return 0;
        }
        return v1(g2Var.b() - 1, y1Var, g2Var) + 1;
    }

    public final boolean M0() {
        return this.G == null && !this.L;
    }

    public final void O0(g2 g2Var, r0 r0Var, i0 i0Var) {
        boolean z10;
        int i10 = this.M;
        int i11 = 0;
        while (i11 < this.M) {
            int i12 = r0Var.f2175d;
            if (i12 < 0 || i12 >= g2Var.b()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && i10 > 0) {
                i0Var.a(r0Var.f2175d, Math.max(0, r0Var.f2178g));
                this.R.getClass();
                i10--;
                r0Var.f2175d += r0Var.f2176e;
                i11++;
            } else {
                return;
            }
        }
    }

    public final int R(y1 y1Var, g2 g2Var) {
        if (this.f1917w == 0) {
            return this.M;
        }
        if (g2Var.b() < 1) {
            return 0;
        }
        return v1(g2Var.b() - 1, y1Var, g2Var) + 1;
    }

    public final View b1(y1 y1Var, g2 g2Var, boolean z10, boolean z11) {
        int i10;
        int i11;
        int H = H();
        int i12 = 1;
        if (z11) {
            i11 = H() - 1;
            i10 = -1;
            i12 = -1;
        } else {
            i10 = H;
            i11 = 0;
        }
        int b10 = g2Var.b();
        T0();
        int j10 = this.f1919y.j();
        int h10 = this.f1919y.h();
        View view = null;
        View view2 = null;
        while (i11 != i10) {
            View G = G(i11);
            int O2 = q1.O(G);
            if (O2 >= 0 && O2 < b10 && w1(O2, y1Var, g2Var) == 0) {
                if (((r1) G.getLayoutParams()).w()) {
                    if (view2 == null) {
                        view2 = G;
                    }
                } else if (this.f1919y.f(G) < h10 && this.f1919y.d(G) >= j10) {
                    return G;
                } else {
                    if (view == null) {
                        view = G;
                    }
                }
            }
            i11 += i12;
        }
        return view != null ? view : view2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00df, code lost:
        if (r13 == r5) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x010e, code lost:
        if (r13 == r5) goto L_0x0110;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View c0(android.view.View r23, int r24, androidx.recyclerview.widget.y1 r25, androidx.recyclerview.widget.g2 r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            androidx.recyclerview.widget.RecyclerView r3 = r0.f2144i
            r4 = 0
            r5 = r23
            if (r3 != 0) goto L_0x000f
        L_0x000d:
            r3 = r4
            goto L_0x001f
        L_0x000f:
            android.view.View r3 = r3.findContainingItemView(r5)
            if (r3 != 0) goto L_0x0016
        L_0x0015:
            goto L_0x000d
        L_0x0016:
            androidx.recyclerview.widget.k r6 = r0.f2143h
            boolean r6 = r6.j(r3)
            if (r6 == 0) goto L_0x001f
            goto L_0x0015
        L_0x001f:
            if (r3 != 0) goto L_0x0022
            return r4
        L_0x0022:
            android.view.ViewGroup$LayoutParams r6 = r3.getLayoutParams()
            androidx.recyclerview.widget.m0 r6 = (androidx.recyclerview.widget.m0) r6
            int r7 = r6.f2082l
            int r6 = r6.f2083m
            int r6 = r6 + r7
            android.view.View r5 = super.c0(r23, r24, r25, r26)
            if (r5 != 0) goto L_0x0034
            return r4
        L_0x0034:
            r5 = r24
            int r5 = r0.S0(r5)
            r9 = 1
            if (r5 != r9) goto L_0x003f
            r5 = 1
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            boolean r10 = r0.B
            if (r5 == r10) goto L_0x0046
            r5 = 1
            goto L_0x0047
        L_0x0046:
            r5 = 0
        L_0x0047:
            r10 = -1
            if (r5 == 0) goto L_0x0052
            int r5 = r22.H()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0059
        L_0x0052:
            int r5 = r22.H()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0059:
            int r13 = r0.f1917w
            if (r13 != r9) goto L_0x0065
            boolean r13 = r22.g1()
            if (r13 == 0) goto L_0x0065
            r13 = 1
            goto L_0x0066
        L_0x0065:
            r13 = 0
        L_0x0066:
            int r14 = r0.v1(r5, r1, r2)
            r10 = r5
            r16 = r12
            r8 = -1
            r9 = 0
            r12 = 0
            r15 = -1
            r5 = r4
        L_0x0072:
            if (r10 == r11) goto L_0x0151
            r17 = r11
            int r11 = r0.v1(r10, r1, r2)
            android.view.View r1 = r0.G(r10)
            if (r1 != r3) goto L_0x0082
            goto L_0x0151
        L_0x0082:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0098
            if (r11 == r14) goto L_0x0098
            if (r4 == 0) goto L_0x008e
            goto L_0x0151
        L_0x008e:
            r18 = r3
            r21 = r5
            r19 = r9
            r20 = 1
            goto L_0x0141
        L_0x0098:
            android.view.ViewGroup$LayoutParams r11 = r1.getLayoutParams()
            androidx.recyclerview.widget.m0 r11 = (androidx.recyclerview.widget.m0) r11
            int r2 = r11.f2082l
            r18 = r3
            int r3 = r11.f2083m
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00b0
            if (r2 != r7) goto L_0x00b0
            if (r3 != r6) goto L_0x00b0
            return r1
        L_0x00b0:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00b8
            if (r4 == 0) goto L_0x00c0
        L_0x00b8:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00c3
            if (r5 != 0) goto L_0x00c3
        L_0x00c0:
            r21 = r5
            goto L_0x00e1
        L_0x00c3:
            int r19 = java.lang.Math.max(r2, r7)
            int r20 = java.lang.Math.min(r3, r6)
            r21 = r5
            int r5 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00e7
            if (r5 <= r9) goto L_0x00d8
            goto L_0x00e1
        L_0x00d8:
            if (r5 != r9) goto L_0x0112
            if (r2 <= r15) goto L_0x00de
            r5 = 1
            goto L_0x00df
        L_0x00de:
            r5 = 0
        L_0x00df:
            if (r13 != r5) goto L_0x0112
        L_0x00e1:
            r19 = r9
            r5 = 1
            r20 = 1
            goto L_0x0117
        L_0x00e7:
            if (r4 != 0) goto L_0x0112
            r19 = r9
            android.support.v4.media.n r9 = r0.f2145j
            boolean r9 = r9.u(r1)
            if (r9 == 0) goto L_0x00fd
            android.support.v4.media.n r9 = r0.f2146k
            boolean r9 = r9.u(r1)
            if (r9 == 0) goto L_0x00fd
            r9 = 1
            goto L_0x00fe
        L_0x00fd:
            r9 = 0
        L_0x00fe:
            r20 = 1
            r9 = r9 ^ 1
            if (r9 == 0) goto L_0x0116
            if (r5 <= r12) goto L_0x0107
            goto L_0x0110
        L_0x0107:
            if (r5 != r12) goto L_0x0116
            if (r2 <= r8) goto L_0x010d
            r5 = 1
            goto L_0x010e
        L_0x010d:
            r5 = 0
        L_0x010e:
            if (r13 != r5) goto L_0x0116
        L_0x0110:
            r5 = 1
            goto L_0x0117
        L_0x0112:
            r19 = r9
            r20 = 1
        L_0x0116:
            r5 = 0
        L_0x0117:
            if (r5 == 0) goto L_0x0141
            boolean r5 = r1.hasFocusable()
            if (r5 == 0) goto L_0x0130
            int r4 = r11.f2082l
            int r3 = java.lang.Math.min(r3, r6)
            int r2 = java.lang.Math.max(r2, r7)
            int r9 = r3 - r2
            r15 = r4
            r5 = r21
            r4 = r1
            goto L_0x0145
        L_0x0130:
            int r5 = r11.f2082l
            int r3 = java.lang.Math.min(r3, r6)
            int r2 = java.lang.Math.max(r2, r7)
            int r12 = r3 - r2
            r8 = r5
            r9 = r19
            r5 = r1
            goto L_0x0145
        L_0x0141:
            r9 = r19
            r5 = r21
        L_0x0145:
            int r10 = r10 + r16
            r1 = r25
            r2 = r26
            r11 = r17
            r3 = r18
            goto L_0x0072
        L_0x0151:
            r21 = r5
            if (r4 == 0) goto L_0x0156
            goto L_0x0158
        L_0x0156:
            r4 = r21
        L_0x0158:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c0(android.view.View, int, androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2):android.view.View");
    }

    public final void e0(y1 y1Var, g2 g2Var, i iVar) {
        super.e0(y1Var, g2Var, iVar);
        iVar.h(GridView.class.getName());
    }

    public final void g0(y1 y1Var, g2 g2Var, View view, i iVar) {
        int i10;
        int i11;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof m0)) {
            f0(view, iVar);
            return;
        }
        m0 m0Var = (m0) layoutParams;
        int v12 = v1(m0Var.u(), y1Var, g2Var);
        int i12 = 1;
        if (this.f1917w == 0) {
            int i13 = m0Var.f2082l;
            i12 = m0Var.f2083m;
            i11 = 1;
            int i14 = i13;
            i10 = v12;
            v12 = i14;
        } else {
            i10 = m0Var.f2082l;
            i11 = m0Var.f2083m;
        }
        iVar.i(l.c(v12, i12, i10, i11, false));
    }

    public final void h0(int i10, int i11) {
        l0 l0Var = this.R;
        l0Var.c();
        l0Var.f2095b.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h1(androidx.recyclerview.widget.y1 r19, androidx.recyclerview.widget.g2 r20, androidx.recyclerview.widget.r0 r21, androidx.recyclerview.widget.q0 r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            androidx.recyclerview.widget.y0 r5 = r0.f1919y
            int r6 = r5.f2249d
            androidx.recyclerview.widget.q1 r5 = r5.f2270a
            switch(r6) {
                case 0: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0017
        L_0x0014:
            int r5 = r5.f2155t
            goto L_0x0019
        L_0x0017:
            int r5 = r5.f2154s
        L_0x0019:
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 1
            if (r5 == r6) goto L_0x0020
            r6 = 1
            goto L_0x0021
        L_0x0020:
            r6 = 0
        L_0x0021:
            int r9 = r18.H()
            if (r9 <= 0) goto L_0x002e
            int[] r9 = r0.N
            int r10 = r0.M
            r9 = r9[r10]
            goto L_0x002f
        L_0x002e:
            r9 = 0
        L_0x002f:
            if (r6 == 0) goto L_0x0034
            r18.A1()
        L_0x0034:
            int r10 = r3.f2176e
            if (r10 != r7) goto L_0x003a
            r10 = 1
            goto L_0x003b
        L_0x003a:
            r10 = 0
        L_0x003b:
            int r11 = r0.M
            if (r10 != 0) goto L_0x004c
            int r11 = r3.f2175d
            int r11 = r0.w1(r11, r1, r2)
            int r12 = r3.f2175d
            int r12 = r0.x1(r12, r1, r2)
            int r11 = r11 + r12
        L_0x004c:
            r12 = 0
        L_0x004d:
            int r13 = r0.M
            if (r12 >= r13) goto L_0x00a3
            int r13 = r3.f2175d
            if (r13 < 0) goto L_0x005d
            int r14 = r20.b()
            if (r13 >= r14) goto L_0x005d
            r13 = 1
            goto L_0x005e
        L_0x005d:
            r13 = 0
        L_0x005e:
            if (r13 == 0) goto L_0x00a3
            if (r11 <= 0) goto L_0x00a3
            int r13 = r3.f2175d
            int r14 = r0.x1(r13, r1, r2)
            int r15 = r0.M
            if (r14 > r15) goto L_0x007e
            int r11 = r11 - r14
            if (r11 >= 0) goto L_0x0070
            goto L_0x00a3
        L_0x0070:
            android.view.View r13 = r3.b(r1)
            if (r13 != 0) goto L_0x0077
            goto L_0x00a3
        L_0x0077:
            android.view.View[] r14 = r0.O
            r14[r12] = r13
            int r12 = r12 + 1
            goto L_0x004d
        L_0x007e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Item at position "
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r3 = " requires "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = " spans but GridLayoutManager has only "
            r2.append(r3)
            int r3 = r0.M
            java.lang.String r4 = " spans."
            java.lang.String r2 = android.support.v4.media.h.o(r2, r3, r4)
            r1.<init>(r2)
            throw r1
        L_0x00a3:
            if (r12 != 0) goto L_0x00a8
            r4.f2140b = r7
            return
        L_0x00a8:
            if (r10 == 0) goto L_0x00b1
            r7 = 0
            r11 = 0
            r13 = 1
            r11 = r12
            r13 = 0
            r14 = 1
            goto L_0x00b6
        L_0x00b1:
            int r7 = r12 + -1
            r11 = -1
            r13 = 0
            r14 = -1
        L_0x00b6:
            if (r7 == r11) goto L_0x00d3
            android.view.View[] r15 = r0.O
            r15 = r15[r7]
            android.view.ViewGroup$LayoutParams r16 = r15.getLayoutParams()
            r8 = r16
            androidx.recyclerview.widget.m0 r8 = (androidx.recyclerview.widget.m0) r8
            int r15 = androidx.recyclerview.widget.q1.O(r15)
            int r15 = r0.x1(r15, r1, r2)
            r8.f2083m = r15
            r8.f2082l = r13
            int r13 = r13 + r15
            int r7 = r7 + r14
            goto L_0x00b6
        L_0x00d3:
            r1 = 0
            r2 = 0
            r7 = 0
        L_0x00d6:
            if (r2 >= r12) goto L_0x0128
            android.view.View[] r8 = r0.O
            r8 = r8[r2]
            java.util.List r11 = r3.f2182k
            if (r11 != 0) goto L_0x00ed
            if (r10 == 0) goto L_0x00e8
            r11 = -1
            r13 = 0
            r0.l(r8, r11, r13)
            goto L_0x00fa
        L_0x00e8:
            r13 = 0
            r0.l(r8, r13, r13)
            goto L_0x00fa
        L_0x00ed:
            r13 = 0
            r11 = -1
            if (r10 == 0) goto L_0x00f6
            r14 = 1
            r0.l(r8, r11, r14)
            goto L_0x00fa
        L_0x00f6:
            r11 = 1
            r0.l(r8, r13, r11)
        L_0x00fa:
            android.graphics.Rect r11 = r0.S
            r0.n(r8, r11)
            r0.y1(r8, r5, r13)
            androidx.recyclerview.widget.y0 r11 = r0.f1919y
            int r11 = r11.e(r8)
            if (r11 <= r7) goto L_0x010b
            r7 = r11
        L_0x010b:
            android.view.ViewGroup$LayoutParams r11 = r8.getLayoutParams()
            androidx.recyclerview.widget.m0 r11 = (androidx.recyclerview.widget.m0) r11
            androidx.recyclerview.widget.y0 r13 = r0.f1919y
            int r8 = r13.p(r8)
            float r8 = (float) r8
            r13 = 1065353216(0x3f800000, float:1.0)
            float r8 = r8 * r13
            int r11 = r11.f2083m
            float r11 = (float) r11
            float r8 = r8 / r11
            int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r11 <= 0) goto L_0x0125
            r1 = r8
        L_0x0125:
            int r2 = r2 + 1
            goto L_0x00d6
        L_0x0128:
            if (r6 == 0) goto L_0x0155
            int r2 = r0.M
            float r2 = (float) r2
            float r1 = r1 * r2
            int r1 = java.lang.Math.round(r1)
            int r1 = java.lang.Math.max(r1, r9)
            r0.t1(r1)
            r1 = 0
            r2 = 0
            r7 = 0
        L_0x013d:
            if (r1 >= r12) goto L_0x0155
            android.view.View[] r2 = r0.O
            r2 = r2[r1]
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 1
            r0.y1(r2, r5, r6)
            androidx.recyclerview.widget.y0 r5 = r0.f1919y
            int r2 = r5.e(r2)
            if (r2 <= r7) goto L_0x0152
            r7 = r2
        L_0x0152:
            int r1 = r1 + 1
            goto L_0x013d
        L_0x0155:
            r1 = 0
        L_0x0156:
            if (r1 >= r12) goto L_0x01c3
            android.view.View[] r2 = r0.O
            r2 = r2[r1]
            androidx.recyclerview.widget.y0 r5 = r0.f1919y
            int r5 = r5.e(r2)
            if (r5 == r7) goto L_0x01bf
            android.view.ViewGroup$LayoutParams r5 = r2.getLayoutParams()
            androidx.recyclerview.widget.m0 r5 = (androidx.recyclerview.widget.m0) r5
            android.graphics.Rect r6 = r5.f2185i
            int r8 = r6.top
            int r9 = r6.bottom
            int r8 = r8 + r9
            int r9 = r5.topMargin
            int r8 = r8 + r9
            int r9 = r5.bottomMargin
            int r8 = r8 + r9
            int r9 = r6.left
            int r6 = r6.right
            int r9 = r9 + r6
            int r6 = r5.leftMargin
            int r9 = r9 + r6
            int r6 = r5.rightMargin
            int r9 = r9 + r6
            int r6 = r5.f2082l
            int r10 = r5.f2083m
            int r6 = r0.u1(r6, r10)
            int r10 = r0.f1917w
            r11 = 1
            if (r10 != r11) goto L_0x019f
            int r5 = r5.width
            r10 = 1073741824(0x40000000, float:2.0)
            r11 = 0
            int r5 = androidx.recyclerview.widget.q1.I(r6, r10, r9, r5, r11)
            int r6 = r7 - r8
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r10)
            goto L_0x01af
        L_0x019f:
            r11 = 0
            r10 = 1073741824(0x40000000, float:2.0)
            int r9 = r7 - r9
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            int r5 = r5.height
            int r6 = androidx.recyclerview.widget.q1.I(r6, r10, r8, r5, r11)
            r5 = r9
        L_0x01af:
            android.view.ViewGroup$LayoutParams r8 = r2.getLayoutParams()
            androidx.recyclerview.widget.r1 r8 = (androidx.recyclerview.widget.r1) r8
            boolean r8 = r0.J0(r2, r5, r6, r8)
            if (r8 == 0) goto L_0x01c0
            r2.measure(r5, r6)
            goto L_0x01c0
        L_0x01bf:
            r11 = 0
        L_0x01c0:
            int r1 = r1 + 1
            goto L_0x0156
        L_0x01c3:
            r11 = 0
            r4.f2139a = r7
            int r1 = r0.f1917w
            r2 = 1
            if (r1 != r2) goto L_0x01dc
            int r1 = r3.f2177f
            r2 = -1
            if (r1 != r2) goto L_0x01d5
            int r1 = r3.f2173b
            int r2 = r1 - r7
            goto L_0x01d9
        L_0x01d5:
            int r2 = r3.f2173b
            int r1 = r2 + r7
        L_0x01d9:
            r3 = 0
            r5 = 0
            goto L_0x01ef
        L_0x01dc:
            r1 = -1
            int r2 = r3.f2177f
            if (r2 != r1) goto L_0x01e8
            int r1 = r3.f2173b
            int r2 = r1 - r7
            r3 = r1
            r5 = r2
            goto L_0x01ed
        L_0x01e8:
            int r1 = r3.f2173b
            int r7 = r7 + r1
            r5 = r1
            r3 = r7
        L_0x01ed:
            r2 = 0
            r1 = 0
        L_0x01ef:
            r8 = 0
        L_0x01f0:
            if (r8 >= r12) goto L_0x0266
            android.view.View[] r6 = r0.O
            r6 = r6[r8]
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.recyclerview.widget.m0 r7 = (androidx.recyclerview.widget.m0) r7
            int r9 = r0.f1917w
            r10 = 1
            if (r9 != r10) goto L_0x0231
            boolean r3 = r18.g1()
            if (r3 == 0) goto L_0x021e
            int r3 = r18.getPaddingLeft()
            int[] r5 = r0.N
            int r9 = r0.M
            int r10 = r7.f2082l
            int r9 = r9 - r10
            r5 = r5[r9]
            int r3 = r3 + r5
            androidx.recyclerview.widget.y0 r5 = r0.f1919y
            int r5 = r5.p(r6)
            int r5 = r3 - r5
            goto L_0x0248
        L_0x021e:
            int r3 = r18.getPaddingLeft()
            int[] r5 = r0.N
            int r9 = r7.f2082l
            r5 = r5[r9]
            int r5 = r5 + r3
            androidx.recyclerview.widget.y0 r3 = r0.f1919y
            int r3 = r3.p(r6)
            int r3 = r3 + r5
            goto L_0x0248
        L_0x0231:
            int r1 = r18.getPaddingTop()
            int[] r2 = r0.N
            int r9 = r7.f2082l
            r2 = r2[r9]
            int r1 = r1 + r2
            androidx.recyclerview.widget.y0 r2 = r0.f1919y
            int r2 = r2.p(r6)
            int r2 = r2 + r1
            r17 = r2
            r2 = r1
            r1 = r17
        L_0x0248:
            androidx.recyclerview.widget.q1.W(r6, r5, r2, r3, r1)
            boolean r9 = r7.w()
            if (r9 != 0) goto L_0x0257
            boolean r7 = r7.v()
            if (r7 == 0) goto L_0x025a
        L_0x0257:
            r7 = 1
            r4.f2141c = r7
        L_0x025a:
            boolean r7 = r4.f2142d
            boolean r6 = r6.hasFocusable()
            r6 = r6 | r7
            r4.f2142d = r6
            int r8 = r8 + 1
            goto L_0x01f0
        L_0x0266:
            android.view.View[] r1 = r0.O
            r2 = 0
            java.util.Arrays.fill(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.h1(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2, androidx.recyclerview.widget.r0, androidx.recyclerview.widget.q0):void");
    }

    public final void i0() {
        l0 l0Var = this.R;
        l0Var.c();
        l0Var.f2095b.clear();
    }

    public final void i1(y1 y1Var, g2 g2Var, p0 p0Var, int i10) {
        boolean z10;
        A1();
        if (g2Var.b() > 0 && !g2Var.f2024g) {
            if (i10 == 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int w12 = w1(p0Var.f2124b, y1Var, g2Var);
            if (z10) {
                while (w12 > 0) {
                    int i11 = p0Var.f2124b;
                    if (i11 <= 0) {
                        break;
                    }
                    int i12 = i11 - 1;
                    p0Var.f2124b = i12;
                    w12 = w1(i12, y1Var, g2Var);
                }
            } else {
                int b10 = g2Var.b() - 1;
                int i13 = p0Var.f2124b;
                while (i13 < b10) {
                    int i14 = i13 + 1;
                    int w13 = w1(i14, y1Var, g2Var);
                    if (w13 <= w12) {
                        break;
                    }
                    i13 = i14;
                    w12 = w13;
                }
                p0Var.f2124b = i13;
            }
        }
        View[] viewArr = this.O;
        if (viewArr == null || viewArr.length != this.M) {
            this.O = new View[this.M];
        }
    }

    public final void j0(int i10, int i11) {
        l0 l0Var = this.R;
        l0Var.c();
        l0Var.f2095b.clear();
    }

    public final void k0(int i10, int i11) {
        l0 l0Var = this.R;
        l0Var.c();
        l0Var.f2095b.clear();
    }

    public final void m0(RecyclerView recyclerView, int i10, int i11) {
        l0 l0Var = this.R;
        l0Var.c();
        l0Var.f2095b.clear();
    }

    public void n0(y1 y1Var, g2 g2Var) {
        boolean z10 = g2Var.f2024g;
        SparseIntArray sparseIntArray = this.Q;
        SparseIntArray sparseIntArray2 = this.P;
        if (z10) {
            int H = H();
            for (int i10 = 0; i10 < H; i10++) {
                m0 m0Var = (m0) G(i10).getLayoutParams();
                int u10 = m0Var.u();
                sparseIntArray2.put(u10, m0Var.f2083m);
                sparseIntArray.put(u10, m0Var.f2082l);
            }
        }
        super.n0(y1Var, g2Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    public final void o0(g2 g2Var) {
        super.o0(g2Var);
        this.L = false;
    }

    public final void p1(boolean z10) {
        if (!z10) {
            super.p1(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final boolean q(r1 r1Var) {
        return r1Var instanceof m0;
    }

    public final void t1(int i10) {
        int i11;
        int[] iArr = this.N;
        int i12 = this.M;
        if (!(iArr != null && iArr.length == i12 + 1 && iArr[iArr.length - 1] == i10)) {
            iArr = new int[(i12 + 1)];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i10 / i12;
        int i15 = i10 % i12;
        int i16 = 0;
        for (int i17 = 1; i17 <= i12; i17++) {
            i13 += i15;
            if (i13 <= 0 || i12 - i13 >= i15) {
                i11 = i14;
            } else {
                i11 = i14 + 1;
                i13 -= i12;
            }
            i16 += i11;
            iArr[i17] = i16;
        }
        this.N = iArr;
    }

    public final int u1(int i10, int i11) {
        if (this.f1917w != 1 || !g1()) {
            int[] iArr = this.N;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.N;
        int i12 = this.M;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public final int v(g2 g2Var) {
        return Q0(g2Var);
    }

    public final int v1(int i10, y1 y1Var, g2 g2Var) {
        boolean z10 = g2Var.f2024g;
        l0 l0Var = this.R;
        if (!z10) {
            return l0Var.a(i10, this.M);
        }
        int b10 = y1Var.b(i10);
        if (b10 != -1) {
            return l0Var.a(b10, this.M);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    public final int w(g2 g2Var) {
        return R0(g2Var);
    }

    public final int w1(int i10, y1 y1Var, g2 g2Var) {
        boolean z10 = g2Var.f2024g;
        l0 l0Var = this.R;
        if (!z10) {
            int i11 = this.M;
            l0Var.getClass();
            return i10 % i11;
        }
        int i12 = this.Q.get(i10, -1);
        if (i12 != -1) {
            return i12;
        }
        int b10 = y1Var.b(i10);
        if (b10 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
            return 0;
        }
        int i13 = this.M;
        l0Var.getClass();
        return b10 % i13;
    }

    public final int x1(int i10, y1 y1Var, g2 g2Var) {
        boolean z10 = g2Var.f2024g;
        l0 l0Var = this.R;
        if (!z10) {
            l0Var.getClass();
            return 1;
        }
        int i11 = this.P.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        if (y1Var.b(i10) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
            return 1;
        }
        l0Var.getClass();
        return 1;
    }

    public final int y(g2 g2Var) {
        return Q0(g2Var);
    }

    public final void y1(View view, int i10, boolean z10) {
        int i11;
        int i12;
        boolean z11;
        m0 m0Var = (m0) view.getLayoutParams();
        Rect rect = m0Var.f2185i;
        int i13 = rect.top + rect.bottom + m0Var.topMargin + m0Var.bottomMargin;
        int i14 = rect.left + rect.right + m0Var.leftMargin + m0Var.rightMargin;
        int u12 = u1(m0Var.f2082l, m0Var.f2083m);
        if (this.f1917w == 1) {
            i11 = q1.I(u12, i10, i14, m0Var.width, false);
            i12 = q1.I(this.f1919y.k(), this.f2155t, i13, m0Var.height, true);
        } else {
            int I = q1.I(u12, i10, i13, m0Var.height, false);
            int I2 = q1.I(this.f1919y.k(), this.f2154s, i14, m0Var.width, true);
            i12 = I;
            i11 = I2;
        }
        r1 r1Var = (r1) view.getLayoutParams();
        if (z10) {
            z11 = J0(view, i11, i12, r1Var);
        } else {
            z11 = H0(view, i11, i12, r1Var);
        }
        if (z11) {
            view.measure(i11, i12);
        }
    }

    public final int z(g2 g2Var) {
        return R0(g2Var);
    }

    public final int z0(int i10, y1 y1Var, g2 g2Var) {
        A1();
        View[] viewArr = this.O;
        if (viewArr == null || viewArr.length != this.M) {
            this.O = new View[this.M];
        }
        return super.z0(i10, y1Var, g2Var);
    }

    public final void z1(int i10) {
        if (i10 != this.M) {
            this.L = true;
            if (i10 >= 1) {
                this.M = i10;
                this.R.c();
                y0();
                return;
            }
            throw new IllegalArgumentException(h.i("Span count should be at least 1. Provided ", i10));
        }
    }

    public GridLayoutManager(int i10, int i11) {
        super(1);
        z1(i10);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        z1(q1.P(context, attributeSet, i10, i11).f2129b);
    }
}
