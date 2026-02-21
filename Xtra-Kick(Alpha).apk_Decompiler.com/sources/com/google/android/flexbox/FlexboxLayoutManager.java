package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e2;
import androidx.recyclerview.widget.g2;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.r1;
import androidx.recyclerview.widget.u0;
import androidx.recyclerview.widget.y0;
import androidx.recyclerview.widget.y1;
import androidx.recyclerview.widget.z0;
import java.util.ArrayList;
import java.util.List;
import u7.a;
import u7.c;
import u7.d;
import u7.f;
import u7.i;
import u7.k;
import u7.l;
import u7.n;

public class FlexboxLayoutManager extends q1 implements a, e2 {
    public static final Rect U = new Rect();
    public boolean A;
    public boolean B;
    public List C = new ArrayList();
    public final f D = new f(this);
    public y1 E;
    public g2 F;
    public l G;
    public final i H;
    public y0 I;
    public y0 J;
    public n K;
    public int L;
    public int M;
    public int N;
    public int O;
    public final SparseArray P;
    public final Context Q;
    public View R;
    public int S;
    public final d T;

    /* renamed from: w  reason: collision with root package name */
    public int f3575w;

    /* renamed from: x  reason: collision with root package name */
    public int f3576x;

    /* renamed from: y  reason: collision with root package name */
    public int f3577y;

    /* renamed from: z  reason: collision with root package name */
    public final int f3578z = -1;

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlexboxLayoutManager(android.content.Context r4, android.util.AttributeSet r5, int r6, int r7) {
        /*
            r3 = this;
            r3.<init>()
            r0 = -1
            r3.f3578z = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r3.C = r1
            u7.f r1 = new u7.f
            r1.<init>(r3)
            r3.D = r1
            u7.i r1 = new u7.i
            r1.<init>(r3)
            r3.H = r1
            r3.L = r0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.M = r2
            r3.N = r2
            r3.O = r2
            android.util.SparseArray r2 = new android.util.SparseArray
            r2.<init>()
            r3.P = r2
            r3.S = r0
            u7.d r0 = new u7.d
            r0.<init>()
            r3.T = r0
            androidx.recyclerview.widget.p1 r5 = androidx.recyclerview.widget.q1.P(r4, r5, r6, r7)
            int r6 = r5.f2128a
            r7 = 0
            r0 = 1
            if (r6 == 0) goto L_0x004a
            if (r6 == r0) goto L_0x0042
            goto L_0x0056
        L_0x0042:
            boolean r5 = r5.f2130c
            if (r5 == 0) goto L_0x0048
            r5 = 3
            goto L_0x0053
        L_0x0048:
            r5 = 2
            goto L_0x0053
        L_0x004a:
            boolean r5 = r5.f2130c
            if (r5 == 0) goto L_0x0052
            r3.d1(r0)
            goto L_0x0056
        L_0x0052:
            r5 = 0
        L_0x0053:
            r3.d1(r5)
        L_0x0056:
            int r5 = r3.f3576x
            if (r5 == r0) goto L_0x0074
            if (r5 == 0) goto L_0x005d
            goto L_0x006a
        L_0x005d:
            r3.t0()
            java.util.List r5 = r3.C
            r5.clear()
            u7.i.b(r1)
            r1.f15410d = r7
        L_0x006a:
            r3.f3576x = r0
            r5 = 0
            r3.I = r5
            r3.J = r5
            r3.y0()
        L_0x0074:
            int r5 = r3.f3577y
            r6 = 4
            if (r5 == r6) goto L_0x008b
            r3.t0()
            java.util.List r5 = r3.C
            r5.clear()
            u7.i.b(r1)
            r1.f15410d = r7
            r3.f3577y = r6
            r3.y0()
        L_0x008b:
            r3.Q = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public static boolean V(int i10, int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (i12 > 0 && i10 != i12) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i10;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i10;
        }
        return true;
    }

    private boolean e1(View view, int i10, int i11, k kVar) {
        return view.isLayoutRequested() || !this.f2150o || !V(view.getWidth(), i10, kVar.width) || !V(view.getHeight(), i11, kVar.height);
    }

    public final void A0(int i10) {
        this.L = i10;
        this.M = RecyclerView.UNDEFINED_DURATION;
        n nVar = this.K;
        if (nVar != null) {
            nVar.f15434h = -1;
        }
        y0();
    }

    public final int B0(int i10, y1 y1Var, g2 g2Var) {
        if (j() || (this.f3576x == 0 && !j())) {
            int a12 = a1(i10, y1Var, g2Var);
            this.P.clear();
            return a12;
        }
        int b12 = b1(i10);
        this.H.f15410d += b12;
        this.J.o(-b12);
        return b12;
    }

    public final r1 C() {
        return new k();
    }

    public final r1 D(Context context, AttributeSet attributeSet) {
        return new k(context, attributeSet);
    }

    public final void K0(RecyclerView recyclerView, int i10) {
        u0 u0Var = new u0(recyclerView.getContext());
        u0Var.f1983a = i10;
        L0(u0Var);
    }

    public final int N0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        int b10 = g2Var.b();
        Q0();
        View S0 = S0(b10);
        View U0 = U0(b10);
        if (g2Var.b() == 0 || S0 == null || U0 == null) {
            return 0;
        }
        return Math.min(this.I.k(), this.I.d(U0) - this.I.f(S0));
    }

    public final int O0(g2 g2Var) {
        if (H() == 0) {
            return 0;
        }
        int b10 = g2Var.b();
        View S0 = S0(b10);
        View U0 = U0(b10);
        if (!(g2Var.b() == 0 || S0 == null || U0 == null)) {
            int O2 = q1.O(S0);
            int O3 = q1.O(U0);
            int abs = Math.abs(this.I.d(U0) - this.I.f(S0));
            int[] iArr = this.D.f15394c;
            int i10 = iArr[O2];
            if (!(i10 == 0 || i10 == -1)) {
                return Math.round((((float) i10) * (((float) abs) / ((float) ((iArr[O3] - i10) + 1)))) + ((float) (this.I.j() - this.I.f(S0))));
            }
        }
        return 0;
    }

    public final int P0(g2 g2Var) {
        int i10;
        if (H() == 0) {
            return 0;
        }
        int b10 = g2Var.b();
        View S0 = S0(b10);
        View U0 = U0(b10);
        if (g2Var.b() == 0 || S0 == null || U0 == null) {
            return 0;
        }
        View W0 = W0(0, H());
        int i11 = -1;
        if (W0 == null) {
            i10 = -1;
        } else {
            i10 = q1.O(W0);
        }
        View W02 = W0(H() - 1, -1);
        if (W02 != null) {
            i11 = q1.O(W02);
        }
        return (int) ((((float) Math.abs(this.I.d(U0) - this.I.f(S0))) / ((float) ((i11 - i10) + 1))) * ((float) g2Var.b()));
    }

    public final void Q0() {
        y0 y0Var;
        if (this.I == null) {
            if (!j() ? this.f3576x != 0 : this.f3576x == 0) {
                this.I = z0.a(this);
                y0Var = z0.c(this);
            } else {
                this.I = z0.c(this);
                y0Var = z0.a(this);
            }
            this.J = y0Var;
        }
    }

    public final int R0(y1 y1Var, g2 g2Var, l lVar) {
        boolean z10;
        int i10;
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Rect rect;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z12;
        int i23;
        int i24;
        int i25;
        f fVar;
        Rect rect2;
        int i26;
        int i27;
        int i28;
        int i29;
        y1 y1Var2 = y1Var;
        l lVar2 = lVar;
        int i30 = lVar2.f15429f;
        if (i30 != Integer.MIN_VALUE) {
            int i31 = lVar2.f15424a;
            if (i31 < 0) {
                lVar2.f15429f = i30 + i31;
            }
            c1(y1Var2, lVar2);
        }
        int i32 = lVar2.f15424a;
        boolean j10 = j();
        int i33 = i32;
        int i34 = 0;
        while (true) {
            if (i33 <= 0 && !this.G.f15425b) {
                break;
            }
            List list = this.C;
            int i35 = lVar2.f15427d;
            if (i35 < 0 || i35 >= g2Var.b() || (i29 = lVar2.f15426c) < 0 || i29 >= list.size()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                break;
            }
            c cVar = (c) this.C.get(lVar2.f15426c);
            lVar2.f15427d = cVar.f15384o;
            boolean j11 = j();
            f fVar2 = this.D;
            Rect rect3 = U;
            i iVar = this.H;
            if (j11) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i36 = this.f2156u;
                int i37 = lVar2.f15428e;
                if (lVar2.f15432i == -1) {
                    i37 -= cVar.f15376g;
                }
                int i38 = lVar2.f15427d;
                float f10 = (float) iVar.f15410d;
                float f11 = ((float) paddingLeft) - f10;
                float f12 = ((float) (i36 - paddingRight)) - f10;
                float max = Math.max(0.0f, 0.0f);
                int i39 = cVar.f15377h;
                i12 = i32;
                i11 = i33;
                int i40 = i38;
                int i41 = 0;
                while (i40 < i38 + i39) {
                    View a10 = a(i40);
                    if (a10 == null) {
                        i25 = i41;
                        z12 = j10;
                        i21 = i34;
                        i23 = i37;
                        i24 = i38;
                        rect2 = rect3;
                        fVar = fVar2;
                        i22 = i39;
                    } else {
                        int i42 = i38;
                        int i43 = lVar2.f15432i;
                        n(a10, rect3);
                        Rect rect4 = rect3;
                        if (i43 == 1) {
                            l(a10, -1, false);
                        } else {
                            l(a10, i41, false);
                            i41++;
                        }
                        f fVar3 = fVar2;
                        long j12 = fVar2.f15395d[i40];
                        int i44 = (int) j12;
                        int i45 = (int) (j12 >> 32);
                        k kVar = (k) a10.getLayoutParams();
                        if (e1(a10, i44, i45, kVar)) {
                            a10.measure(i44, i45);
                        }
                        float N2 = f11 + ((float) (q1.N(a10) + kVar.leftMargin));
                        float Q2 = f12 - ((float) (q1.Q(a10) + kVar.rightMargin));
                        int S2 = q1.S(a10) + i37;
                        if (this.A) {
                            int round = Math.round(Q2) - a10.getMeasuredWidth();
                            int round2 = Math.round(Q2);
                            i24 = i42;
                            i26 = a10.getMeasuredHeight() + S2;
                            i28 = round;
                            i27 = round2;
                        } else {
                            int round3 = Math.round(N2);
                            i27 = a10.getMeasuredWidth() + Math.round(N2);
                            i26 = a10.getMeasuredHeight() + S2;
                            i24 = i42;
                            i28 = round3;
                        }
                        i25 = i41;
                        rect2 = rect4;
                        z12 = j10;
                        i23 = i37;
                        k kVar2 = kVar;
                        fVar = fVar3;
                        i21 = i34;
                        i22 = i39;
                        fVar3.o(a10, cVar, i28, S2, i27, i26);
                        float Q3 = ((float) (q1.Q(a10) + a10.getMeasuredWidth() + kVar2.rightMargin)) + max + N2;
                        f12 = Q2 - (((float) (q1.N(a10) + (a10.getMeasuredWidth() + kVar2.leftMargin))) + max);
                        f11 = Q3;
                    }
                    i40++;
                    rect3 = rect2;
                    fVar2 = fVar;
                    i41 = i25;
                    i38 = i24;
                    i37 = i23;
                    j10 = z12;
                    i39 = i22;
                    i34 = i21;
                }
                z11 = j10;
                i10 = i34;
                lVar2.f15426c += this.G.f15432i;
                i13 = cVar.f15376g;
            } else {
                i12 = i32;
                z11 = j10;
                i11 = i33;
                i10 = i34;
                Rect rect5 = rect3;
                f fVar4 = fVar2;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int i46 = this.f2157v;
                int i47 = lVar2.f15428e;
                if (lVar2.f15432i == -1) {
                    int i48 = cVar.f15376g;
                    int i49 = i47 - i48;
                    i14 = i47 + i48;
                    i47 = i49;
                } else {
                    i14 = i47;
                }
                int i50 = lVar2.f15427d;
                float f13 = (float) iVar.f15410d;
                float f14 = ((float) paddingTop) - f13;
                float f15 = ((float) (i46 - paddingBottom)) - f13;
                float max2 = Math.max(0.0f, 0.0f);
                int i51 = cVar.f15377h;
                int i52 = i50;
                int i53 = 0;
                while (i52 < i50 + i51) {
                    View a11 = a(i52);
                    if (a11 == null) {
                        rect = rect5;
                        i17 = i51;
                        i16 = i52;
                        i15 = i50;
                    } else {
                        i17 = i51;
                        long j13 = fVar4.f15395d[i52];
                        int i54 = i52;
                        int i55 = (int) j13;
                        int i56 = (int) (j13 >> 32);
                        k kVar3 = (k) a11.getLayoutParams();
                        if (e1(a11, i55, i56, kVar3)) {
                            a11.measure(i55, i56);
                        }
                        float S3 = f14 + ((float) (q1.S(a11) + kVar3.topMargin));
                        float F2 = f15 - ((float) (q1.F(a11) + kVar3.rightMargin));
                        int i57 = lVar2.f15432i;
                        n(a11, rect5);
                        if (i57 == 1) {
                            rect = rect5;
                            l(a11, -1, false);
                        } else {
                            rect = rect5;
                            l(a11, i53, false);
                            i53++;
                        }
                        int i58 = i53;
                        int N3 = q1.N(a11) + i47;
                        int Q4 = i14 - q1.Q(a11);
                        boolean z13 = this.A;
                        if (z13) {
                            if (this.B) {
                                N3 = Q4 - a11.getMeasuredWidth();
                                i19 = Math.round(F2) - a11.getMeasuredHeight();
                                i18 = Math.round(F2);
                                i20 = N3;
                            } else {
                                i19 = Math.round(S3);
                                int round4 = Math.round(S3);
                                i20 = Q4 - a11.getMeasuredWidth();
                                i18 = a11.getMeasuredHeight() + round4;
                            }
                        } else if (this.B) {
                            i19 = Math.round(F2) - a11.getMeasuredHeight();
                            Q4 = a11.getMeasuredWidth() + N3;
                            i18 = Math.round(F2);
                            i20 = N3;
                        } else {
                            i19 = Math.round(S3);
                            Q4 = a11.getMeasuredWidth() + N3;
                            i18 = a11.getMeasuredHeight() + Math.round(S3);
                            i20 = N3;
                        }
                        View view = a11;
                        i16 = i54;
                        i15 = i50;
                        fVar4.p(a11, cVar, z13, i20, i19, Q4, i18);
                        float F3 = ((float) (q1.F(view) + view.getMeasuredHeight() + kVar3.topMargin)) + max2 + S3;
                        f15 = F2 - (((float) (q1.S(view) + (view.getMeasuredHeight() + kVar3.bottomMargin))) + max2);
                        f14 = F3;
                        i53 = i58;
                    }
                    i52 = i16 + 1;
                    rect5 = rect;
                    i51 = i17;
                    i50 = i15;
                }
                lVar2.f15426c += this.G.f15432i;
                i13 = cVar.f15376g;
            }
            i34 = i10 + i13;
            if (z11 || !this.A) {
                lVar2.f15428e += cVar.f15376g * lVar2.f15432i;
            } else {
                lVar2.f15428e -= cVar.f15376g * lVar2.f15432i;
            }
            i33 = i11 - cVar.f15376g;
            y1 y1Var3 = y1Var;
            i32 = i12;
            j10 = z11;
        }
        int i59 = i32;
        int i60 = i34;
        int i61 = lVar2.f15424a - i60;
        lVar2.f15424a = i61;
        int i62 = lVar2.f15429f;
        if (i62 != Integer.MIN_VALUE) {
            int i63 = i62 + i60;
            lVar2.f15429f = i63;
            if (i61 < 0) {
                lVar2.f15429f = i63 + i61;
            }
            c1(y1Var, lVar2);
        }
        return i59 - lVar2.f15424a;
    }

    public final View S0(int i10) {
        int i11;
        View X0 = X0(0, H(), i10);
        if (X0 == null || (i11 = this.D.f15394c[q1.O(X0)]) == -1) {
            return null;
        }
        return T0(X0, (c) this.C.get(i11));
    }

    public final View T0(View view, c cVar) {
        boolean j10 = j();
        int i10 = cVar.f15377h;
        for (int i11 = 1; i11 < i10; i11++) {
            View G2 = G(i11);
            if (!(G2 == null || G2.getVisibility() == 8)) {
                if (!this.A || j10) {
                    if (this.I.f(view) <= this.I.f(G2)) {
                    }
                } else if (this.I.d(view) >= this.I.d(G2)) {
                }
                view = G2;
            }
        }
        return view;
    }

    public final boolean U() {
        return true;
    }

    public final View U0(int i10) {
        View X0 = X0(H() - 1, -1, i10);
        if (X0 == null) {
            return null;
        }
        return V0(X0, (c) this.C.get(this.D.f15394c[q1.O(X0)]));
    }

    public final View V0(View view, c cVar) {
        boolean j10 = j();
        int H2 = (H() - cVar.f15377h) - 1;
        for (int H3 = H() - 2; H3 > H2; H3--) {
            View G2 = G(H3);
            if (!(G2 == null || G2.getVisibility() == 8)) {
                if (!this.A || j10) {
                    if (this.I.d(view) >= this.I.d(G2)) {
                    }
                } else if (this.I.f(view) <= this.I.f(G2)) {
                }
                view = G2;
            }
        }
        return view;
    }

    public final View W0(int i10, int i11) {
        int i12;
        boolean z10;
        boolean z11;
        if (i11 > i10) {
            i12 = 1;
        } else {
            i12 = -1;
        }
        while (i10 != i11) {
            View G2 = G(i10);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = this.f2156u - getPaddingRight();
            int paddingBottom = this.f2157v - getPaddingBottom();
            int left = (G2.getLeft() - q1.N(G2)) - ((r1) G2.getLayoutParams()).leftMargin;
            int top = (G2.getTop() - q1.S(G2)) - ((r1) G2.getLayoutParams()).topMargin;
            int Q2 = q1.Q(G2) + G2.getRight() + ((r1) G2.getLayoutParams()).rightMargin;
            int F2 = q1.F(G2) + G2.getBottom() + ((r1) G2.getLayoutParams()).bottomMargin;
            boolean z12 = false;
            if (left >= paddingRight || Q2 >= paddingLeft) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (top >= paddingBottom || F2 >= paddingTop) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                z12 = true;
            }
            if (z12) {
                return G2;
            }
            i10 += i12;
        }
        return null;
    }

    public final View X0(int i10, int i11, int i12) {
        int i13;
        int O2;
        Q0();
        if (this.G == null) {
            this.G = new l(0);
        }
        int j10 = this.I.j();
        int h10 = this.I.h();
        if (i11 > i10) {
            i13 = 1;
        } else {
            i13 = -1;
        }
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View G2 = G(i10);
            if (G2 != null && (O2 = q1.O(G2)) >= 0 && O2 < i12) {
                if (((r1) G2.getLayoutParams()).w()) {
                    if (view2 == null) {
                        view2 = G2;
                    }
                } else if (this.I.f(G2) >= j10 && this.I.d(G2) <= h10) {
                    return G2;
                } else {
                    if (view == null) {
                        view = G2;
                    }
                }
            }
            i10 += i13;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public final int Y0(int i10, y1 y1Var, g2 g2Var, boolean z10) {
        int i11;
        int h10;
        if (!j() && this.A) {
            int j10 = i10 - this.I.j();
            if (j10 <= 0) {
                return 0;
            }
            i11 = a1(j10, y1Var, g2Var);
        } else {
            int h11 = this.I.h() - i10;
            if (h11 <= 0) {
                return 0;
            }
            i11 = -a1(-h11, y1Var, g2Var);
        }
        int i12 = i10 + i11;
        if (!z10 || (h10 = this.I.h() - i12) <= 0) {
            return i11;
        }
        this.I.o(h10);
        return h10 + i11;
    }

    public final void Z() {
        t0();
    }

    public final int Z0(int i10, y1 y1Var, g2 g2Var, boolean z10) {
        int i11;
        int j10;
        if (j() || !this.A) {
            int j11 = i10 - this.I.j();
            if (j11 <= 0) {
                return 0;
            }
            i11 = -a1(j11, y1Var, g2Var);
        } else {
            int h10 = this.I.h() - i10;
            if (h10 <= 0) {
                return 0;
            }
            i11 = a1(-h10, y1Var, g2Var);
        }
        int i12 = i10 + i11;
        if (!z10 || (j10 = i12 - this.I.j()) <= 0) {
            return i11;
        }
        this.I.o(-j10);
        return i11 - j10;
    }

    public final View a(int i10) {
        View view = (View) this.P.get(i10);
        return view != null ? view : this.E.d(i10);
    }

    public final void a0(RecyclerView recyclerView) {
        this.R = (View) recyclerView.getParent();
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a1(int r19, androidx.recyclerview.widget.y1 r20, androidx.recyclerview.widget.g2 r21) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.H()
            r2 = 0
            if (r1 == 0) goto L_0x01f0
            if (r19 != 0) goto L_0x000d
            goto L_0x01f0
        L_0x000d:
            r18.Q0()
            u7.l r1 = r0.G
            r3 = 1
            r1.f15433j = r3
            boolean r1 = r18.j()
            if (r1 != 0) goto L_0x0021
            boolean r1 = r0.A
            if (r1 == 0) goto L_0x0021
            r1 = 1
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            r4 = -1
            if (r1 == 0) goto L_0x0028
            if (r19 >= 0) goto L_0x002c
            goto L_0x002a
        L_0x0028:
            if (r19 <= 0) goto L_0x002c
        L_0x002a:
            r5 = 1
            goto L_0x002d
        L_0x002c:
            r5 = -1
        L_0x002d:
            int r6 = java.lang.Math.abs(r19)
            u7.l r7 = r0.G
            r7.f15432i = r5
            boolean r7 = r18.j()
            int r8 = r0.f2156u
            int r9 = r0.f2154s
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r9)
            int r9 = r0.f2157v
            int r10 = r0.f2155t
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r10)
            if (r7 != 0) goto L_0x0051
            boolean r10 = r0.A
            if (r10 == 0) goto L_0x0051
            r10 = 1
            goto L_0x0052
        L_0x0051:
            r10 = 0
        L_0x0052:
            u7.f r15 = r0.D
            if (r5 != r3) goto L_0x012d
            int r11 = r18.H()
            int r11 = r11 - r3
            android.view.View r11 = r0.G(r11)
            if (r11 != 0) goto L_0x0063
            goto L_0x01c6
        L_0x0063:
            u7.l r12 = r0.G
            androidx.recyclerview.widget.y0 r13 = r0.I
            int r13 = r13.d(r11)
            r12.f15428e = r13
            int r12 = androidx.recyclerview.widget.q1.O(r11)
            int[] r13 = r15.f15394c
            r13 = r13[r12]
            java.util.List r14 = r0.C
            java.lang.Object r13 = r14.get(r13)
            u7.c r13 = (u7.c) r13
            android.view.View r11 = r0.V0(r11, r13)
            u7.l r13 = r0.G
            r13.f15431h = r3
            int r12 = r12 + r3
            r13.f15427d = r12
            int[] r14 = r15.f15394c
            int r3 = r14.length
            if (r3 > r12) goto L_0x0090
            r13.f15426c = r4
            goto L_0x0094
        L_0x0090:
            r3 = r14[r12]
            r13.f15426c = r3
        L_0x0094:
            if (r10 == 0) goto L_0x00b9
            androidx.recyclerview.widget.y0 r3 = r0.I
            int r3 = r3.f(r11)
            r13.f15428e = r3
            u7.l r3 = r0.G
            androidx.recyclerview.widget.y0 r10 = r0.I
            int r10 = r10.f(r11)
            int r10 = -r10
            androidx.recyclerview.widget.y0 r11 = r0.I
            int r11 = r11.j()
            int r11 = r11 + r10
            r3.f15429f = r11
            u7.l r3 = r0.G
            int r10 = r3.f15429f
            int r10 = java.lang.Math.max(r10, r2)
            goto L_0x00d0
        L_0x00b9:
            androidx.recyclerview.widget.y0 r3 = r0.I
            int r3 = r3.d(r11)
            r13.f15428e = r3
            u7.l r3 = r0.G
            androidx.recyclerview.widget.y0 r10 = r0.I
            int r10 = r10.d(r11)
            androidx.recyclerview.widget.y0 r11 = r0.I
            int r11 = r11.h()
            int r10 = r10 - r11
        L_0x00d0:
            r3.f15429f = r10
            u7.l r3 = r0.G
            int r3 = r3.f15426c
            if (r3 == r4) goto L_0x00e2
            java.util.List r4 = r0.C
            int r4 = r4.size()
            r10 = 1
            int r4 = r4 - r10
            if (r3 <= r4) goto L_0x01be
        L_0x00e2:
            u7.l r3 = r0.G
            int r3 = r3.f15427d
            int r4 = r18.getFlexItemCount()
            if (r3 > r4) goto L_0x01be
            u7.l r3 = r0.G
            int r4 = r3.f15429f
            int r14 = r6 - r4
            u7.d r11 = r0.T
            r4 = 0
            r11.f15388a = r4
            r11.f15389b = r2
            if (r14 <= 0) goto L_0x01be
            u7.f r10 = r0.D
            if (r7 == 0) goto L_0x010f
            int r3 = r3.f15427d
            java.util.List r4 = r0.C
            r16 = -1
            r12 = r8
            r13 = r9
            r7 = r15
            r15 = r3
            r17 = r4
            r10.b(r11, r12, r13, r14, r15, r16, r17)
            goto L_0x011d
        L_0x010f:
            r7 = r15
            int r15 = r3.f15427d
            java.util.List r3 = r0.C
            r16 = -1
            r12 = r9
            r13 = r8
            r17 = r3
            r10.b(r11, r12, r13, r14, r15, r16, r17)
        L_0x011d:
            u7.l r3 = r0.G
            int r3 = r3.f15427d
            r7.h(r8, r9, r3)
            u7.l r3 = r0.G
            int r3 = r3.f15427d
            r7.u(r3)
            goto L_0x01be
        L_0x012d:
            r7 = r15
            android.view.View r3 = r0.G(r2)
            if (r3 != 0) goto L_0x0136
            goto L_0x01c6
        L_0x0136:
            u7.l r8 = r0.G
            androidx.recyclerview.widget.y0 r9 = r0.I
            int r9 = r9.f(r3)
            r8.f15428e = r9
            int r8 = androidx.recyclerview.widget.q1.O(r3)
            int[] r9 = r7.f15394c
            r9 = r9[r8]
            java.util.List r11 = r0.C
            java.lang.Object r9 = r11.get(r9)
            u7.c r9 = (u7.c) r9
            android.view.View r3 = r0.T0(r3, r9)
            u7.l r9 = r0.G
            r11 = 1
            r9.f15431h = r11
            int[] r7 = r7.f15394c
            r7 = r7[r8]
            if (r7 != r4) goto L_0x0160
            r7 = 0
        L_0x0160:
            if (r7 <= 0) goto L_0x0174
            java.util.List r4 = r0.C
            int r9 = r7 + -1
            java.lang.Object r4 = r4.get(r9)
            u7.c r4 = (u7.c) r4
            u7.l r9 = r0.G
            int r4 = r4.f15377h
            int r8 = r8 - r4
            r9.f15427d = r8
            goto L_0x0176
        L_0x0174:
            r9.f15427d = r4
        L_0x0176:
            u7.l r4 = r0.G
            if (r7 <= 0) goto L_0x017d
            r8 = 1
            int r7 = r7 - r8
            goto L_0x017e
        L_0x017d:
            r7 = 0
        L_0x017e:
            r4.f15426c = r7
            androidx.recyclerview.widget.y0 r7 = r0.I
            if (r10 == 0) goto L_0x01a6
            int r7 = r7.d(r3)
            r4.f15428e = r7
            u7.l r4 = r0.G
            androidx.recyclerview.widget.y0 r7 = r0.I
            int r3 = r7.d(r3)
            androidx.recyclerview.widget.y0 r7 = r0.I
            int r7 = r7.h()
            int r3 = r3 - r7
            r4.f15429f = r3
            u7.l r3 = r0.G
            int r4 = r3.f15429f
            int r4 = java.lang.Math.max(r4, r2)
            r3.f15429f = r4
            goto L_0x01be
        L_0x01a6:
            int r7 = r7.f(r3)
            r4.f15428e = r7
            u7.l r4 = r0.G
            androidx.recyclerview.widget.y0 r7 = r0.I
            int r3 = r7.f(r3)
            int r3 = -r3
            androidx.recyclerview.widget.y0 r7 = r0.I
            int r7 = r7.j()
            int r7 = r7 + r3
            r4.f15429f = r7
        L_0x01be:
            u7.l r3 = r0.G
            int r4 = r3.f15429f
            int r4 = r6 - r4
            r3.f15424a = r4
        L_0x01c6:
            u7.l r3 = r0.G
            int r4 = r3.f15429f
            r7 = r20
            r8 = r21
            int r3 = r0.R0(r7, r8, r3)
            int r3 = r3 + r4
            if (r3 >= 0) goto L_0x01d6
            return r2
        L_0x01d6:
            if (r1 == 0) goto L_0x01de
            if (r6 <= r3) goto L_0x01e3
            int r1 = -r5
            int r1 = r1 * r3
            goto L_0x01e5
        L_0x01de:
            if (r6 <= r3) goto L_0x01e3
            int r1 = r5 * r3
            goto L_0x01e5
        L_0x01e3:
            r1 = r19
        L_0x01e5:
            androidx.recyclerview.widget.y0 r2 = r0.I
            int r3 = -r1
            r2.o(r3)
            u7.l r2 = r0.G
            r2.f15430g = r1
            return r1
        L_0x01f0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.a1(int, androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2):int");
    }

    public final int b(View view, int i10, int i11) {
        int i12;
        int i13;
        if (j()) {
            i12 = q1.N(view);
            i13 = q1.Q(view);
        } else {
            i12 = q1.S(view);
            i13 = q1.F(view);
        }
        return i13 + i12;
    }

    public final void b0(RecyclerView recyclerView) {
    }

    public final int b1(int i10) {
        int i11;
        int i12;
        int i13;
        boolean z10 = false;
        if (H() == 0 || i10 == 0) {
            return 0;
        }
        Q0();
        boolean j10 = j();
        View view = this.R;
        if (j10) {
            i11 = view.getWidth();
        } else {
            i11 = view.getHeight();
        }
        if (j10) {
            i12 = this.f2156u;
        } else {
            i12 = this.f2157v;
        }
        if (M() == 1) {
            z10 = true;
        }
        i iVar = this.H;
        if (z10) {
            int abs = Math.abs(i10);
            if (i10 < 0) {
                return -Math.min((i12 + iVar.f15410d) - i11, abs);
            }
            i13 = iVar.f15410d;
            if (i13 + i10 <= 0) {
                return i10;
            }
        } else if (i10 > 0) {
            return Math.min((i12 - iVar.f15410d) - i11, i10);
        } else {
            i13 = iVar.f15410d;
            if (i13 + i10 >= 0) {
                return i10;
            }
        }
        return -i13;
    }

    public final int c(int i10, int i11, int i12) {
        return q1.I(this.f2157v, this.f2155t, i11, i12, p());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r5 = r0 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c1(androidx.recyclerview.widget.y1 r12, u7.l r13) {
        /*
            r11 = this;
            boolean r0 = r13.f15433j
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r0 = r13.f15432i
            r1 = 0
            r2 = 1
            r3 = -1
            u7.f r4 = r11.D
            if (r0 != r3) goto L_0x00ba
            int r0 = r13.f15429f
            if (r0 >= 0) goto L_0x0014
            goto L_0x016b
        L_0x0014:
            int r0 = r11.H()
            if (r0 != 0) goto L_0x001c
            goto L_0x016b
        L_0x001c:
            int r5 = r0 + -1
            android.view.View r6 = r11.G(r5)
            if (r6 != 0) goto L_0x0026
            goto L_0x016b
        L_0x0026:
            int[] r4 = r4.f15394c
            int r6 = androidx.recyclerview.widget.q1.O(r6)
            r4 = r4[r6]
            if (r4 != r3) goto L_0x0032
            goto L_0x016b
        L_0x0032:
            java.util.List r3 = r11.C
            java.lang.Object r3 = r3.get(r4)
            u7.c r3 = (u7.c) r3
            r6 = r5
        L_0x003b:
            if (r6 < 0) goto L_0x0089
            android.view.View r7 = r11.G(r6)
            if (r7 != 0) goto L_0x0044
            goto L_0x0086
        L_0x0044:
            int r8 = r13.f15429f
            boolean r9 = r11.j()
            if (r9 != 0) goto L_0x0059
            boolean r9 = r11.A
            if (r9 == 0) goto L_0x0059
            androidx.recyclerview.widget.y0 r9 = r11.I
            int r9 = r9.d(r7)
            if (r9 > r8) goto L_0x006a
            goto L_0x0068
        L_0x0059:
            androidx.recyclerview.widget.y0 r9 = r11.I
            int r9 = r9.f(r7)
            androidx.recyclerview.widget.y0 r10 = r11.I
            int r10 = r10.g()
            int r10 = r10 - r8
            if (r9 < r10) goto L_0x006a
        L_0x0068:
            r8 = 1
            goto L_0x006b
        L_0x006a:
            r8 = 0
        L_0x006b:
            if (r8 == 0) goto L_0x0089
            int r8 = r3.f15384o
            int r7 = androidx.recyclerview.widget.q1.O(r7)
            if (r8 != r7) goto L_0x0086
            if (r4 > 0) goto L_0x0079
            r0 = r6
            goto L_0x0089
        L_0x0079:
            int r0 = r13.f15432i
            int r4 = r4 + r0
            java.util.List r0 = r11.C
            java.lang.Object r0 = r0.get(r4)
            u7.c r0 = (u7.c) r0
            r3 = r0
            r0 = r6
        L_0x0086:
            int r6 = r6 + -1
            goto L_0x003b
        L_0x0089:
            if (r5 < r0) goto L_0x016b
            android.view.View r13 = r11.G(r5)
            android.view.View r1 = r11.G(r5)
            if (r1 == 0) goto L_0x00b4
            androidx.recyclerview.widget.k r1 = r11.f2143h
            int r2 = r1.f(r5)
            androidx.recyclerview.widget.e1 r3 = r1.f2063a
            androidx.recyclerview.widget.RecyclerView r4 = r3.f1972a
            android.view.View r4 = r4.getChildAt(r2)
            if (r4 != 0) goto L_0x00a6
            goto L_0x00b4
        L_0x00a6:
            androidx.recyclerview.widget.j r6 = r1.f2064b
            boolean r6 = r6.f(r2)
            if (r6 == 0) goto L_0x00b1
            r1.k(r4)
        L_0x00b1:
            r3.c(r2)
        L_0x00b4:
            r12.j(r13)
            int r5 = r5 + -1
            goto L_0x0089
        L_0x00ba:
            int r0 = r13.f15429f
            if (r0 >= 0) goto L_0x00c0
            goto L_0x016b
        L_0x00c0:
            int r0 = r11.H()
            if (r0 != 0) goto L_0x00c8
            goto L_0x016b
        L_0x00c8:
            android.view.View r5 = r11.G(r1)
            if (r5 != 0) goto L_0x00d0
            goto L_0x016b
        L_0x00d0:
            int[] r4 = r4.f15394c
            int r5 = androidx.recyclerview.widget.q1.O(r5)
            r4 = r4[r5]
            if (r4 != r3) goto L_0x00dc
            goto L_0x016b
        L_0x00dc:
            java.util.List r5 = r11.C
            java.lang.Object r5 = r5.get(r4)
            u7.c r5 = (u7.c) r5
            r6 = 0
        L_0x00e5:
            if (r6 >= r0) goto L_0x013a
            android.view.View r7 = r11.G(r6)
            if (r7 != 0) goto L_0x00ee
            goto L_0x0137
        L_0x00ee:
            int r8 = r13.f15429f
            boolean r9 = r11.j()
            if (r9 != 0) goto L_0x010a
            boolean r9 = r11.A
            if (r9 == 0) goto L_0x010a
            androidx.recyclerview.widget.y0 r9 = r11.I
            int r9 = r9.g()
            androidx.recyclerview.widget.y0 r10 = r11.I
            int r10 = r10.f(r7)
            int r9 = r9 - r10
            if (r9 > r8) goto L_0x0114
            goto L_0x0112
        L_0x010a:
            androidx.recyclerview.widget.y0 r9 = r11.I
            int r9 = r9.d(r7)
            if (r9 > r8) goto L_0x0114
        L_0x0112:
            r8 = 1
            goto L_0x0115
        L_0x0114:
            r8 = 0
        L_0x0115:
            if (r8 == 0) goto L_0x013a
            int r8 = r5.f15385p
            int r7 = androidx.recyclerview.widget.q1.O(r7)
            if (r8 != r7) goto L_0x0137
            java.util.List r3 = r11.C
            int r3 = r3.size()
            int r3 = r3 - r2
            if (r4 < r3) goto L_0x012a
            r3 = r6
            goto L_0x013a
        L_0x012a:
            int r3 = r13.f15432i
            int r4 = r4 + r3
            java.util.List r3 = r11.C
            java.lang.Object r3 = r3.get(r4)
            u7.c r3 = (u7.c) r3
            r5 = r3
            r3 = r6
        L_0x0137:
            int r6 = r6 + 1
            goto L_0x00e5
        L_0x013a:
            if (r3 < 0) goto L_0x016b
            android.view.View r13 = r11.G(r3)
            android.view.View r0 = r11.G(r3)
            if (r0 == 0) goto L_0x0165
            androidx.recyclerview.widget.k r0 = r11.f2143h
            int r1 = r0.f(r3)
            androidx.recyclerview.widget.e1 r2 = r0.f2063a
            androidx.recyclerview.widget.RecyclerView r4 = r2.f1972a
            android.view.View r4 = r4.getChildAt(r1)
            if (r4 != 0) goto L_0x0157
            goto L_0x0165
        L_0x0157:
            androidx.recyclerview.widget.j r5 = r0.f2064b
            boolean r5 = r5.f(r1)
            if (r5 == 0) goto L_0x0162
            r0.k(r4)
        L_0x0162:
            r2.c(r1)
        L_0x0165:
            r12.j(r13)
            int r3 = r3 + -1
            goto L_0x013a
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.c1(androidx.recyclerview.widget.y1, u7.l):void");
    }

    public final PointF d(int i10) {
        View G2;
        if (H() == 0 || (G2 = G(0)) == null) {
            return null;
        }
        int i11 = i10 < q1.O(G2) ? -1 : 1;
        return j() ? new PointF(0.0f, (float) i11) : new PointF((float) i11, 0.0f);
    }

    public final void d1(int i10) {
        if (this.f3575w != i10) {
            t0();
            this.f3575w = i10;
            this.I = null;
            this.J = null;
            this.C.clear();
            i iVar = this.H;
            i.b(iVar);
            iVar.f15410d = 0;
            y0();
        }
    }

    public final void e(View view, int i10, int i11, c cVar) {
        int i12;
        int i13;
        n(view, U);
        if (j()) {
            i12 = q1.N(view);
            i13 = q1.Q(view);
        } else {
            i12 = q1.S(view);
            i13 = q1.F(view);
        }
        int i14 = i13 + i12;
        cVar.f15374e += i14;
        cVar.f15375f += i14;
    }

    public final void f(c cVar) {
    }

    public final void f1(int i10) {
        int i11 = -1;
        View W0 = W0(H() - 1, -1);
        if (W0 != null) {
            i11 = q1.O(W0);
        }
        if (i10 < i11) {
            int H2 = H();
            f fVar = this.D;
            fVar.j(H2);
            fVar.k(H2);
            fVar.i(H2);
            if (i10 < fVar.f15394c.length) {
                this.S = i10;
                View G2 = G(0);
                if (G2 != null) {
                    this.L = q1.O(G2);
                    if (j() || !this.A) {
                        this.M = this.I.f(G2) - this.I.j();
                        return;
                    }
                    this.M = this.I.q() + this.I.d(G2);
                }
            }
        }
    }

    public final View g(int i10) {
        return a(i10);
    }

    public final void g1(i iVar, boolean z10, boolean z11) {
        l lVar;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z12 = false;
        if (z11) {
            if (j()) {
                i13 = this.f2155t;
            } else {
                i13 = this.f2154s;
            }
            l lVar2 = this.G;
            if (i13 == 0 || i13 == Integer.MIN_VALUE) {
                z12 = true;
            }
            lVar2.f15425b = z12;
        } else {
            this.G.f15425b = false;
        }
        if (j() || !this.A) {
            lVar = this.G;
            i11 = this.I.h();
            i10 = iVar.f15409c;
        } else {
            lVar = this.G;
            i11 = iVar.f15409c;
            i10 = getPaddingRight();
        }
        lVar.f15424a = i11 - i10;
        l lVar3 = this.G;
        lVar3.f15427d = iVar.f15407a;
        lVar3.f15431h = 1;
        lVar3.f15432i = 1;
        lVar3.f15428e = iVar.f15409c;
        lVar3.f15429f = RecyclerView.UNDEFINED_DURATION;
        lVar3.f15426c = iVar.f15408b;
        if (z10 && this.C.size() > 1 && (i12 = iVar.f15408b) >= 0 && i12 < this.C.size() - 1) {
            l lVar4 = this.G;
            lVar4.f15426c++;
            lVar4.f15427d += ((c) this.C.get(iVar.f15408b)).f15377h;
        }
    }

    public final int getAlignContent() {
        return 5;
    }

    public final int getAlignItems() {
        return this.f3577y;
    }

    public final int getFlexDirection() {
        return this.f3575w;
    }

    public final int getFlexItemCount() {
        return this.F.b();
    }

    public final List getFlexLinesInternal() {
        return this.C;
    }

    public final int getFlexWrap() {
        return this.f3576x;
    }

    public final int getLargestMainSize() {
        if (this.C.size() == 0) {
            return 0;
        }
        int size = this.C.size();
        int i10 = RecyclerView.UNDEFINED_DURATION;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = Math.max(i10, ((c) this.C.get(i11)).f15374e);
        }
        return i10;
    }

    public final int getMaxLine() {
        return this.f3578z;
    }

    public final int getSumOfCrossSize() {
        int size = this.C.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += ((c) this.C.get(i11)).f15376g;
        }
        return i10;
    }

    public final void h(View view, int i10) {
        this.P.put(i10, view);
    }

    public final void h0(int i10, int i11) {
        f1(i10);
    }

    public final void h1(i iVar, boolean z10, boolean z11) {
        l lVar;
        int i10;
        int i11;
        int i12;
        boolean z12 = false;
        if (z11) {
            if (j()) {
                i12 = this.f2155t;
            } else {
                i12 = this.f2154s;
            }
            l lVar2 = this.G;
            if (i12 == 0 || i12 == Integer.MIN_VALUE) {
                z12 = true;
            }
            lVar2.f15425b = z12;
        } else {
            this.G.f15425b = false;
        }
        if (j() || !this.A) {
            lVar = this.G;
            i10 = iVar.f15409c;
        } else {
            lVar = this.G;
            i10 = this.R.getWidth() - iVar.f15409c;
        }
        lVar.f15424a = i10 - this.I.j();
        l lVar3 = this.G;
        lVar3.f15427d = iVar.f15407a;
        lVar3.f15431h = 1;
        lVar3.f15432i = -1;
        lVar3.f15428e = iVar.f15409c;
        lVar3.f15429f = RecyclerView.UNDEFINED_DURATION;
        int i13 = iVar.f15408b;
        lVar3.f15426c = i13;
        if (z10 && i13 > 0 && this.C.size() > (i11 = iVar.f15408b)) {
            l lVar4 = this.G;
            lVar4.f15426c--;
            lVar4.f15427d -= ((c) this.C.get(i11)).f15377h;
        }
    }

    public final int i(int i10, int i11, int i12) {
        return q1.I(this.f2156u, this.f2154s, i11, i12, o());
    }

    public final boolean j() {
        int i10 = this.f3575w;
        return i10 == 0 || i10 == 1;
    }

    public final void j0(int i10, int i11) {
        f1(Math.min(i10, i11));
    }

    public final int k(View view) {
        int i10;
        int i11;
        if (j()) {
            i11 = q1.S(view);
            i10 = q1.F(view);
        } else {
            i11 = q1.N(view);
            i10 = q1.Q(view);
        }
        return i10 + i11;
    }

    public final void k0(int i10, int i11) {
        f1(i10);
    }

    public final void l0(int i10) {
        f1(i10);
    }

    public final void m0(RecyclerView recyclerView, int i10, int i11) {
        f1(i10);
        f1(i10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r0.f3576x == 2) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005f, code lost:
        if (r0.f3576x == 2) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0307  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n0(androidx.recyclerview.widget.y1 r26, androidx.recyclerview.widget.g2 r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r0.E = r1
            r0.F = r2
            int r3 = r27.b()
            if (r3 != 0) goto L_0x0015
            boolean r4 = r2.f2024g
            if (r4 == 0) goto L_0x0015
            return
        L_0x0015:
            int r4 = r25.M()
            int r5 = r0.f3575w
            r6 = 1
            r7 = 0
            r8 = 2
            if (r5 == 0) goto L_0x0056
            if (r5 == r6) goto L_0x004a
            if (r5 == r8) goto L_0x003b
            r9 = 3
            if (r5 == r9) goto L_0x002a
            r0.A = r7
            goto L_0x0063
        L_0x002a:
            if (r4 != r6) goto L_0x002e
            r4 = 1
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            r0.A = r4
            int r5 = r0.f3576x
            if (r5 != r8) goto L_0x0038
            r4 = r4 ^ r6
            r0.A = r4
        L_0x0038:
            r0.B = r6
            goto L_0x0066
        L_0x003b:
            if (r4 != r6) goto L_0x003f
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            r0.A = r4
            int r5 = r0.f3576x
            if (r5 != r8) goto L_0x0063
            r4 = r4 ^ r6
            r0.A = r4
            goto L_0x0063
        L_0x004a:
            if (r4 == r6) goto L_0x004e
            r4 = 1
            goto L_0x004f
        L_0x004e:
            r4 = 0
        L_0x004f:
            r0.A = r4
            int r4 = r0.f3576x
            if (r4 != r8) goto L_0x0063
            goto L_0x0061
        L_0x0056:
            if (r4 != r6) goto L_0x005a
            r4 = 1
            goto L_0x005b
        L_0x005a:
            r4 = 0
        L_0x005b:
            r0.A = r4
            int r4 = r0.f3576x
            if (r4 != r8) goto L_0x0063
        L_0x0061:
            r4 = 1
            goto L_0x0064
        L_0x0063:
            r4 = 0
        L_0x0064:
            r0.B = r4
        L_0x0066:
            r25.Q0()
            u7.l r4 = r0.G
            if (r4 != 0) goto L_0x0074
            u7.l r4 = new u7.l
            r4.<init>(r7)
            r0.G = r4
        L_0x0074:
            u7.f r4 = r0.D
            r4.j(r3)
            r4.k(r3)
            r4.i(r3)
            u7.l r5 = r0.G
            r5.f15433j = r7
            u7.n r5 = r0.K
            if (r5 == 0) goto L_0x0094
            int r8 = r5.f15434h
            if (r8 < 0) goto L_0x008f
            if (r8 >= r3) goto L_0x008f
            r9 = 1
            goto L_0x0090
        L_0x008f:
            r9 = 0
        L_0x0090:
            if (r9 == 0) goto L_0x0094
            r0.L = r8
        L_0x0094:
            u7.i r15 = r0.H
            boolean r8 = r15.f15412f
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = -1
            if (r8 == 0) goto L_0x00a3
            int r8 = r0.L
            if (r8 != r10) goto L_0x00a3
            if (r5 == 0) goto L_0x022f
        L_0x00a3:
            u7.i.b(r15)
            u7.n r5 = r0.K
            boolean r8 = r2.f2024g
            if (r8 != 0) goto L_0x0197
            int r8 = r0.L
            if (r8 != r10) goto L_0x00b2
            goto L_0x0197
        L_0x00b2:
            if (r8 < 0) goto L_0x0193
            int r11 = r27.b()
            if (r8 < r11) goto L_0x00bc
            goto L_0x0193
        L_0x00bc:
            int r8 = r0.L
            r15.f15407a = r8
            int[] r11 = r4.f15394c
            r8 = r11[r8]
            r15.f15408b = r8
            u7.n r8 = r0.K
            if (r8 == 0) goto L_0x00ea
            int r11 = r27.b()
            int r8 = r8.f15434h
            if (r8 < 0) goto L_0x00d6
            if (r8 >= r11) goto L_0x00d6
            r8 = 1
            goto L_0x00d7
        L_0x00d6:
            r8 = 0
        L_0x00d7:
            if (r8 == 0) goto L_0x00ea
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.j()
            int r5 = r5.f15435i
            int r8 = r8 + r5
            r15.f15409c = r8
            r15.f15413g = r6
            r15.f15408b = r10
            goto L_0x0191
        L_0x00ea:
            int r5 = r0.M
            if (r5 != r9) goto L_0x0172
            int r5 = r0.L
            android.view.View r5 = r0.B(r5)
            if (r5 == 0) goto L_0x0155
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.e(r5)
            androidx.recyclerview.widget.y0 r11 = r0.I
            int r11 = r11.k()
            if (r8 <= r11) goto L_0x0105
            goto L_0x016e
        L_0x0105:
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.f(r5)
            androidx.recyclerview.widget.y0 r11 = r0.I
            int r11 = r11.j()
            int r8 = r8 - r11
            if (r8 >= 0) goto L_0x0120
            androidx.recyclerview.widget.y0 r5 = r0.I
            int r5 = r5.j()
            r15.f15409c = r5
            r15.f15411e = r7
            goto L_0x0191
        L_0x0120:
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.h()
            androidx.recyclerview.widget.y0 r11 = r0.I
            int r11 = r11.d(r5)
            int r8 = r8 - r11
            if (r8 >= 0) goto L_0x013a
            androidx.recyclerview.widget.y0 r5 = r0.I
            int r5 = r5.h()
            r15.f15409c = r5
            r15.f15411e = r6
            goto L_0x0191
        L_0x013a:
            boolean r8 = r15.f15411e
            if (r8 == 0) goto L_0x014c
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r5 = r8.d(r5)
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.l()
            int r8 = r8 + r5
            goto L_0x0152
        L_0x014c:
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.f(r5)
        L_0x0152:
            r15.f15409c = r8
            goto L_0x0191
        L_0x0155:
            int r5 = r25.H()
            if (r5 <= 0) goto L_0x016e
            android.view.View r5 = r0.G(r7)
            if (r5 == 0) goto L_0x016e
            int r5 = androidx.recyclerview.widget.q1.O(r5)
            int r8 = r0.L
            if (r8 >= r5) goto L_0x016b
            r5 = 1
            goto L_0x016c
        L_0x016b:
            r5 = 0
        L_0x016c:
            r15.f15411e = r5
        L_0x016e:
            u7.i.a(r15)
            goto L_0x0191
        L_0x0172:
            boolean r5 = r25.j()
            if (r5 != 0) goto L_0x0186
            boolean r5 = r0.A
            if (r5 == 0) goto L_0x0186
            int r5 = r0.M
            androidx.recyclerview.widget.y0 r8 = r0.I
            int r8 = r8.q()
            int r5 = r5 - r8
            goto L_0x018f
        L_0x0186:
            androidx.recyclerview.widget.y0 r5 = r0.I
            int r5 = r5.j()
            int r8 = r0.M
            int r5 = r5 + r8
        L_0x018f:
            r15.f15409c = r5
        L_0x0191:
            r5 = 1
            goto L_0x0198
        L_0x0193:
            r0.L = r10
            r0.M = r9
        L_0x0197:
            r5 = 0
        L_0x0198:
            if (r5 == 0) goto L_0x019c
            goto L_0x022d
        L_0x019c:
            int r5 = r25.H()
            if (r5 != 0) goto L_0x01a4
            goto L_0x0222
        L_0x01a4:
            boolean r5 = r15.f15411e
            if (r5 == 0) goto L_0x01b1
            int r5 = r27.b()
            android.view.View r5 = r0.U0(r5)
            goto L_0x01b9
        L_0x01b1:
            int r5 = r27.b()
            android.view.View r5 = r0.S0(r5)
        L_0x01b9:
            if (r5 == 0) goto L_0x0222
            com.google.android.flexbox.FlexboxLayoutManager r8 = r15.f15414h
            int r11 = r8.f3576x
            if (r11 != 0) goto L_0x01c4
            androidx.recyclerview.widget.y0 r11 = r8.J
            goto L_0x01c6
        L_0x01c4:
            androidx.recyclerview.widget.y0 r11 = r8.I
        L_0x01c6:
            boolean r12 = r8.j()
            if (r12 != 0) goto L_0x01de
            boolean r12 = r8.A
            if (r12 == 0) goto L_0x01de
            boolean r12 = r15.f15411e
            if (r12 == 0) goto L_0x01d9
            int r12 = r11.f(r5)
            goto L_0x01e6
        L_0x01d9:
            int r11 = r11.d(r5)
            goto L_0x01f0
        L_0x01de:
            boolean r12 = r15.f15411e
            if (r12 == 0) goto L_0x01ec
            int r12 = r11.d(r5)
        L_0x01e6:
            int r11 = r11.l()
            int r11 = r11 + r12
            goto L_0x01f0
        L_0x01ec:
            int r11 = r11.f(r5)
        L_0x01f0:
            r15.f15409c = r11
            int r5 = androidx.recyclerview.widget.q1.O(r5)
            r15.f15407a = r5
            r15.f15413g = r7
            u7.f r11 = r8.D
            int[] r11 = r11.f15394c
            if (r5 == r10) goto L_0x0201
            goto L_0x0202
        L_0x0201:
            r5 = 0
        L_0x0202:
            r5 = r11[r5]
            if (r5 == r10) goto L_0x0207
            goto L_0x0208
        L_0x0207:
            r5 = 0
        L_0x0208:
            r15.f15408b = r5
            java.util.List r5 = r8.C
            int r5 = r5.size()
            int r11 = r15.f15408b
            if (r5 <= r11) goto L_0x0220
            java.util.List r5 = r8.C
            java.lang.Object r5 = r5.get(r11)
            u7.c r5 = (u7.c) r5
            int r5 = r5.f15384o
            r15.f15407a = r5
        L_0x0220:
            r5 = 1
            goto L_0x0223
        L_0x0222:
            r5 = 0
        L_0x0223:
            if (r5 == 0) goto L_0x0226
            goto L_0x022d
        L_0x0226:
            u7.i.a(r15)
            r15.f15407a = r7
            r15.f15408b = r7
        L_0x022d:
            r15.f15412f = r6
        L_0x022f:
            r25.A(r26)
            boolean r5 = r15.f15411e
            if (r5 == 0) goto L_0x023a
            r0.h1(r15, r7, r6)
            goto L_0x023d
        L_0x023a:
            r0.g1(r15, r7, r6)
        L_0x023d:
            int r5 = r0.f2156u
            int r8 = r0.f2154s
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r8)
            int r8 = r0.f2157v
            int r11 = r0.f2155t
            int r14 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r11)
            int r8 = r0.f2156u
            int r11 = r0.f2157v
            boolean r12 = r25.j()
            android.content.Context r13 = r0.Q
            if (r12 == 0) goto L_0x0273
            int r12 = r0.N
            if (r12 == r9) goto L_0x0261
            if (r12 == r8) goto L_0x0261
            r9 = 1
            goto L_0x0262
        L_0x0261:
            r9 = 0
        L_0x0262:
            u7.l r12 = r0.G
            boolean r6 = r12.f15425b
            if (r6 == 0) goto L_0x028d
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r6 = r6.heightPixels
            goto L_0x028f
        L_0x0273:
            int r6 = r0.O
            if (r6 == r9) goto L_0x027b
            if (r6 == r11) goto L_0x027b
            r9 = 1
            goto L_0x027c
        L_0x027b:
            r9 = 0
        L_0x027c:
            u7.l r12 = r0.G
            boolean r6 = r12.f15425b
            if (r6 == 0) goto L_0x028d
            android.content.res.Resources r6 = r13.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            int r6 = r6.widthPixels
            goto L_0x028f
        L_0x028d:
            int r6 = r12.f15424a
        L_0x028f:
            r20 = r6
            r0.N = r8
            r0.O = r11
            int r6 = r0.S
            r8 = 0
            u7.d r13 = r0.T
            if (r6 != r10) goto L_0x02fe
            int r11 = r0.L
            if (r11 != r10) goto L_0x02a2
            if (r9 == 0) goto L_0x02fe
        L_0x02a2:
            boolean r3 = r15.f15411e
            if (r3 == 0) goto L_0x02a9
        L_0x02a6:
            r8 = r15
            goto L_0x0398
        L_0x02a9:
            java.util.List r3 = r0.C
            r3.clear()
            r13.f15388a = r8
            r13.f15389b = r7
            boolean r3 = r25.j()
            u7.f r6 = r0.D
            u7.d r8 = r0.T
            if (r3 == 0) goto L_0x02d2
            int r3 = r15.f15407a
            java.util.List r9 = r0.C
            r21 = 0
            r16 = r6
            r17 = r8
            r18 = r5
            r19 = r14
            r22 = r3
            r23 = r9
            r16.b(r17, r18, r19, r20, r21, r22, r23)
            goto L_0x02e7
        L_0x02d2:
            int r3 = r15.f15407a
            java.util.List r9 = r0.C
            r21 = 0
            r16 = r6
            r17 = r8
            r18 = r14
            r19 = r5
            r22 = r3
            r23 = r9
            r16.b(r17, r18, r19, r20, r21, r22, r23)
        L_0x02e7:
            java.util.List r3 = r13.f15388a
            r0.C = r3
            r4.h(r5, r14, r7)
            r4.u(r7)
            int[] r3 = r4.f15394c
            int r4 = r15.f15407a
            r3 = r3[r4]
            r15.f15408b = r3
            u7.l r4 = r0.G
            r4.f15426c = r3
            goto L_0x02a6
        L_0x02fe:
            if (r6 == r10) goto L_0x0307
            int r9 = r15.f15407a
            int r6 = java.lang.Math.min(r6, r9)
            goto L_0x0309
        L_0x0307:
            int r6 = r15.f15407a
        L_0x0309:
            r13.f15388a = r8
            r13.f15389b = r7
            boolean r8 = r25.j()
            if (r8 == 0) goto L_0x0348
            java.util.List r8 = r0.C
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0329
            java.util.List r3 = r0.C
            r4.d(r3, r6)
            int r3 = r15.f15407a
            java.util.List r8 = r0.C
            r10 = r5
            r16 = r8
            r11 = r14
            goto L_0x035d
        L_0x0329:
            r4.i(r3)
            u7.f r3 = r0.D
            u7.d r8 = r0.T
            r21 = 0
            java.util.List r9 = r0.C
            r22 = -1
            r16 = r3
            r17 = r8
            r18 = r5
            r19 = r14
            r23 = r9
            r16.b(r17, r18, r19, r20, r21, r22, r23)
            r7 = r13
            r24 = r14
            r8 = r15
            goto L_0x038c
        L_0x0348:
            java.util.List r8 = r0.C
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x036e
            java.util.List r3 = r0.C
            r4.d(r3, r6)
            int r3 = r15.f15407a
            java.util.List r8 = r0.C
            r11 = r5
            r16 = r8
            r10 = r14
        L_0x035d:
            r8 = r4
            r9 = r13
            r12 = r20
            r7 = r13
            r13 = r6
            r24 = r14
            r14 = r3
            r3 = r15
            r15 = r16
            r8.b(r9, r10, r11, r12, r13, r14, r15)
            r8 = r3
            goto L_0x038c
        L_0x036e:
            r7 = r13
            r24 = r14
            r8 = r15
            r4.i(r3)
            u7.f r3 = r0.D
            u7.d r9 = r0.T
            r21 = 0
            java.util.List r10 = r0.C
            r22 = -1
            r16 = r3
            r17 = r9
            r18 = r24
            r19 = r5
            r23 = r10
            r16.b(r17, r18, r19, r20, r21, r22, r23)
        L_0x038c:
            java.util.List r3 = r7.f15388a
            r0.C = r3
            r3 = r24
            r4.h(r5, r3, r6)
            r4.u(r6)
        L_0x0398:
            u7.l r3 = r0.G
            r0.R0(r1, r2, r3)
            boolean r3 = r8.f15411e
            if (r3 == 0) goto L_0x03b4
            u7.l r3 = r0.G
            int r3 = r3.f15428e
            r4 = 1
            r5 = 0
            r0.g1(r8, r4, r5)
            u7.l r6 = r0.G
            r0.R0(r1, r2, r6)
            u7.l r6 = r0.G
            int r6 = r6.f15428e
            goto L_0x03c6
        L_0x03b4:
            r4 = 1
            r5 = 0
            u7.l r3 = r0.G
            int r6 = r3.f15428e
            r0.h1(r8, r4, r5)
            u7.l r3 = r0.G
            r0.R0(r1, r2, r3)
            u7.l r3 = r0.G
            int r3 = r3.f15428e
        L_0x03c6:
            int r5 = r25.H()
            if (r5 <= 0) goto L_0x03e3
            boolean r5 = r8.f15411e
            if (r5 == 0) goto L_0x03da
            int r4 = r0.Y0(r6, r1, r2, r4)
            int r4 = r4 + r3
            r5 = 0
            r0.Z0(r4, r1, r2, r5)
            goto L_0x03e3
        L_0x03da:
            r5 = 0
            int r3 = r0.Z0(r3, r1, r2, r4)
            int r3 = r3 + r6
            r0.Y0(r3, r1, r2, r5)
        L_0x03e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.n0(androidx.recyclerview.widget.y1, androidx.recyclerview.widget.g2):void");
    }

    public final boolean o() {
        int i10;
        if (this.f3576x == 0) {
            return j();
        }
        if (j()) {
            int i11 = this.f2156u;
            View view = this.R;
            if (view != null) {
                i10 = view.getWidth();
            } else {
                i10 = 0;
            }
            if (i11 > i10) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final void o0(g2 g2Var) {
        this.K = null;
        this.L = -1;
        this.M = RecyclerView.UNDEFINED_DURATION;
        this.S = -1;
        i.b(this.H);
        this.P.clear();
    }

    public final boolean p() {
        int i10;
        if (this.f3576x == 0) {
            return !j();
        }
        if (j()) {
            return true;
        }
        int i11 = this.f2157v;
        View view = this.R;
        if (view != null) {
            i10 = view.getHeight();
        } else {
            i10 = 0;
        }
        if (i11 > i10) {
            return true;
        }
        return false;
    }

    public final void p0(Parcelable parcelable) {
        if (parcelable instanceof n) {
            this.K = (n) parcelable;
            y0();
        }
    }

    public final boolean q(r1 r1Var) {
        return r1Var instanceof k;
    }

    public final Parcelable q0() {
        if (this.K != null) {
            return new n(this.K);
        }
        n nVar = new n();
        if (H() > 0) {
            View G2 = G(0);
            nVar.f15434h = q1.O(G2);
            nVar.f15435i = this.I.f(G2) - this.I.j();
        } else {
            nVar.f15434h = -1;
        }
        return nVar;
    }

    public final void setFlexLines(List list) {
        this.C = list;
    }

    public final int u(g2 g2Var) {
        return N0(g2Var);
    }

    public final int v(g2 g2Var) {
        return O0(g2Var);
    }

    public final int w(g2 g2Var) {
        return P0(g2Var);
    }

    public final int x(g2 g2Var) {
        return N0(g2Var);
    }

    public final int y(g2 g2Var) {
        return O0(g2Var);
    }

    public final int z(g2 g2Var) {
        return P0(g2Var);
    }

    public final int z0(int i10, y1 y1Var, g2 g2Var) {
        if (!j() || this.f3576x == 0) {
            int a12 = a1(i10, y1Var, g2Var);
            this.P.clear();
            return a12;
        }
        int b12 = b1(i10);
        this.H.f15410d += b12;
        this.J.o(-b12);
        return b12;
    }
}
