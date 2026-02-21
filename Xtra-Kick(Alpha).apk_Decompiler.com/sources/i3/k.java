package i3;

import android.view.View;
import android.widget.PopupWindow;
import g1.a2;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.g1;
import g1.h;
import g1.h1;
import g1.i1;
import g1.j1;
import g1.k1;
import g1.q;
import g1.s0;
import g1.u1;
import g1.v0;
import g1.y;
import g1.y1;
import g1.z0;
import i1.d;
import java.util.List;

public final class k implements i1, View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ w f8114h;

    public k(w wVar) {
        this.f8114h = wVar;
    }

    public final /* synthetic */ void A(float f10) {
    }

    public final /* synthetic */ void B(d1 d1Var) {
    }

    public final /* synthetic */ void D(y1 y1Var) {
    }

    public final /* synthetic */ void F(int i10) {
    }

    public final /* synthetic */ void G(long j10) {
    }

    public final /* synthetic */ void K(int i10, int i11) {
    }

    public final /* synthetic */ void L(int i10, s0 s0Var) {
    }

    public final /* synthetic */ void N(e1 e1Var) {
    }

    public final /* synthetic */ void O(g1 g1Var) {
    }

    public final /* synthetic */ void P(a2 a2Var) {
    }

    public final /* synthetic */ void Q(u1 u1Var, int i10) {
    }

    public final /* synthetic */ void R(d dVar) {
    }

    public final /* synthetic */ void S(z0 z0Var) {
    }

    public final /* synthetic */ void V(b2 b2Var) {
    }

    public final /* synthetic */ void X(q qVar) {
    }

    public final /* synthetic */ void Y(boolean z10) {
    }

    public final /* synthetic */ void a(int i10) {
    }

    public final /* synthetic */ void c(h hVar) {
    }

    public final /* synthetic */ void e(v0 v0Var) {
    }

    public final /* synthetic */ void f(boolean z10) {
    }

    public final /* synthetic */ void g(int i10, boolean z10) {
    }

    public final /* synthetic */ void h(int i10) {
    }

    public final /* synthetic */ void i(long j10) {
    }

    public final /* synthetic */ void j(boolean z10) {
    }

    public final /* synthetic */ void k(int i10) {
    }

    public final void l(k1 k1Var, h1 h1Var) {
        y yVar = h1Var.f6411a;
        boolean a10 = yVar.a(4, 5, 13);
        w wVar = this.f8114h;
        if (a10) {
            wVar.n();
        }
        if (yVar.a(4, 5, 7, 13)) {
            wVar.p();
        }
        if (yVar.a(8, 13)) {
            wVar.q();
        }
        if (yVar.a(9, 13)) {
            wVar.s();
        }
        if (yVar.a(8, 9, 11, 0, 16, 17, 13)) {
            wVar.m();
        }
        if (yVar.a(11, 0, 13)) {
            wVar.t();
        }
        if (yVar.a(12, 13)) {
            wVar.o();
        }
        if (yVar.a(2, 13)) {
            wVar.u();
        }
    }

    public final /* synthetic */ void m(long j10) {
    }

    public final /* synthetic */ void n(int i10, j1 j1Var, j1 j1Var2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac A[LOOP:0: B:41:0x008d->B:55:0x00ac, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00aa A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r7) {
        /*
            r6 = this;
            i3.w r0 = r6.f8114h
            g1.k1 r1 = r0.f8201o0
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            i3.c0 r2 = r0.f8186h
            r2.h()
            android.view.View r3 = r0.f8212u
            if (r3 != r7) goto L_0x001d
            r7 = 9
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            r1.u0()
            goto L_0x00f2
        L_0x001d:
            android.view.View r3 = r0.f8210t
            if (r3 != r7) goto L_0x002d
            r7 = 7
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            r1.D0()
            goto L_0x00f2
        L_0x002d:
            android.view.View r3 = r0.f8216w
            r4 = 4
            if (r3 != r7) goto L_0x0045
            int r7 = r1.b()
            if (r7 == r4) goto L_0x00f2
            r7 = 12
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            r1.v0()
            goto L_0x00f2
        L_0x0045:
            android.view.View r3 = r0.f8218x
            if (r3 != r7) goto L_0x0056
            r7 = 11
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            r1.A0()
            goto L_0x00f2
        L_0x0056:
            android.view.View r3 = r0.f8214v
            r5 = 1
            if (r3 != r7) goto L_0x007a
            int r7 = r1.b()
            if (r7 == r5) goto L_0x0075
            if (r7 == r4) goto L_0x0075
            boolean r7 = r1.y()
            if (r7 != 0) goto L_0x006a
            goto L_0x0075
        L_0x006a:
            boolean r7 = r1.L0(r5)
            if (r7 == 0) goto L_0x00f2
            r1.g()
            goto L_0x00f2
        L_0x0075:
            i3.w.e(r1)
            goto L_0x00f2
        L_0x007a:
            android.widget.ImageView r3 = r0.A
            if (r3 != r7) goto L_0x00b3
            r7 = 15
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            int r7 = r1.h()
            int r0 = r0.f8219x0
            r2 = 1
        L_0x008d:
            r3 = 2
            if (r2 > r3) goto L_0x00af
            int r4 = r7 + r2
            int r4 = r4 % 3
            if (r4 == 0) goto L_0x00a7
            if (r4 == r5) goto L_0x00a0
            if (r4 == r3) goto L_0x009b
            goto L_0x00a5
        L_0x009b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a0:
            r3 = r0 & 1
            if (r3 == 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r3 = 0
            goto L_0x00a8
        L_0x00a7:
            r3 = 1
        L_0x00a8:
            if (r3 == 0) goto L_0x00ac
            r7 = r4
            goto L_0x00af
        L_0x00ac:
            int r2 = r2 + 1
            goto L_0x008d
        L_0x00af:
            r1.f(r7)
            goto L_0x00f2
        L_0x00b3:
            android.widget.ImageView r3 = r0.B
            if (r3 != r7) goto L_0x00c8
            r7 = 14
            boolean r7 = r1.L0(r7)
            if (r7 == 0) goto L_0x00f2
            boolean r7 = r1.o0()
            r7 = r7 ^ r5
            r1.A(r7)
            goto L_0x00f2
        L_0x00c8:
            android.view.View r1 = r0.G
            if (r1 != r7) goto L_0x00d2
            r2.g()
            i3.q r7 = r0.f8196m
            goto L_0x00ef
        L_0x00d2:
            android.view.View r1 = r0.H
            if (r1 != r7) goto L_0x00dc
            r2.g()
            i3.n r7 = r0.f8198n
            goto L_0x00ef
        L_0x00dc:
            android.view.View r1 = r0.I
            if (r1 != r7) goto L_0x00e6
            r2.g()
            i3.j r7 = r0.f8202p
            goto L_0x00ef
        L_0x00e6:
            android.widget.ImageView r1 = r0.D
            if (r1 != r7) goto L_0x00f2
            r2.g()
            i3.j r7 = r0.f8200o
        L_0x00ef:
            r0.f(r7, r1)
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.k.onClick(android.view.View):void");
    }

    public final void onDismiss() {
        w wVar = this.f8114h;
        if (wVar.D0) {
            wVar.f8186h.h();
        }
    }

    public final /* synthetic */ void q(boolean z10) {
    }

    public final /* synthetic */ void r() {
    }

    public final /* synthetic */ void s() {
    }

    public final /* synthetic */ void t(v0 v0Var) {
    }

    public final /* synthetic */ void u(d1 d1Var) {
    }

    public final /* synthetic */ void v(boolean z10) {
    }

    public final /* synthetic */ void x(List list) {
    }

    public final /* synthetic */ void y(int i10, boolean z10) {
    }

    public final /* synthetic */ void z(int i10, boolean z10) {
    }
}
