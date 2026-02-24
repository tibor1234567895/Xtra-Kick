package h3;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.session.k;
import android.support.v4.media.session.m;
import android.support.v4.media.session.u;
import android.support.v4.media.session.z;
import android.text.TextUtils;
import e1.l0;
import g1.g1;
import g1.h;
import g1.n0;
import g1.s0;
import g1.t1;
import g1.u1;
import g1.v0;
import h9.e0;
import h9.w;
import j1.v;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import o1.b0;

public final class v2 implements d2 {

    /* renamed from: a  reason: collision with root package name */
    public v0 f7379a = v0.P;

    /* renamed from: b  reason: collision with root package name */
    public String f7380b = "";

    /* renamed from: c  reason: collision with root package name */
    public Uri f7381c;

    /* renamed from: d  reason: collision with root package name */
    public long f7382d = -9223372036854775807L;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ x2 f7383e;

    public v2(x2 x2Var) {
        this.f7383e = x2Var;
    }

    public final void A() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void B() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void C() {
        long j10;
        String str;
        Uri uri;
        Bitmap bitmap;
        n0 n0Var;
        x2 x2Var = this.f7383e;
        a4 a4Var = x2Var.f7437g.f7246s;
        s0 T0 = a4Var.T0();
        v0 V0 = a4Var.V0();
        if (a4Var.L0(16)) {
            j10 = a4Var.i0();
        } else {
            j10 = -9223372036854775807L;
        }
        long j11 = j10;
        if (T0 != null) {
            str = T0.f6556h;
        } else {
            str = "";
        }
        String str2 = str;
        if (T0 == null || (n0Var = T0.f6557i) == null) {
            uri = null;
        } else {
            uri = n0Var.f6478a;
        }
        if (!Objects.equals(this.f7379a, V0) || !Objects.equals(this.f7380b, str2) || !Objects.equals(this.f7381c, uri) || this.f7382d != j11) {
            this.f7380b = str2;
            this.f7381c = uri;
            this.f7379a = V0;
            this.f7382d = j11;
            n2 n2Var = x2Var.f7437g;
            e0 a10 = n2Var.f7240m.a(V0);
            if (a10 != null) {
                x2Var.f7448r = null;
                if (a10.isDone()) {
                    try {
                        bitmap = (Bitmap) w.b(a10);
                    } catch (ExecutionException e10) {
                        v.g("MediaSessionLegacyStub", "Failed to load bitmap: " + e10.getMessage());
                    }
                    ((z) x2Var.f7442l.f428i).r(t3.n(V0, str2, uri, j11, bitmap));
                }
                u2 u2Var = r1;
                u2 u2Var2 = new u2(this, V0, str2, uri, j11);
                x2Var.f7448r = u2Var;
                Handler handler = n2Var.f7239l;
                Objects.requireNonNull(handler);
                w.a(a10, u2Var, new b0(6, handler));
            }
            bitmap = null;
            ((z) x2Var.f7442l.f428i).r(t3.n(V0, str2, uri, j11, bitmap));
        }
    }

    public final void a(int i10) {
        u uVar = this.f7383e.f7437g.f7234g.f7442l;
        ((z) uVar.f428i).f(t3.p(i10));
    }

    public final void b() {
    }

    public final void c(h hVar) {
        x2 x2Var = this.f7383e;
        if (x2Var.f7437g.f7246s.V().f6519h == 0) {
            ((z) x2Var.f7442l.f428i).n(t3.v(hVar));
        }
    }

    public final /* synthetic */ void d(int i10) {
    }

    public final void e(v0 v0Var) {
        x2 x2Var = this.f7383e;
        CharSequence queueTitle = ((m) ((k) ((u) x2Var.f7442l.f429j).f428i)).f403a.getQueueTitle();
        CharSequence charSequence = v0Var.f6651h;
        if (!TextUtils.equals(queueTitle, charSequence)) {
            ((z) x2Var.f7442l.f428i).o(charSequence);
        }
    }

    public final void f(boolean z10) {
        u uVar = this.f7383e.f7437g.f7234g.f7442l;
        e1.h hVar = t3.f7332a;
        ((z) uVar.f428i).v(z10 ? 1 : 0);
    }

    public final void g(int i10, boolean z10) {
        y3 y3Var = this.f7383e.f7446p;
        if (y3Var != null) {
            if (z10) {
                i10 = 0;
            }
            y3Var.f7492c = i10;
            l0.a(y3Var.a(), i10);
            y3Var.getClass();
        }
    }

    public final void h(s0 s0Var) {
        C();
        x2 x2Var = this.f7383e;
        if (s0Var == null) {
            ((z) x2Var.f7442l.f428i).t(0);
        } else {
            u uVar = x2Var.f7442l;
            ((z) uVar.f428i).t(t3.w(s0Var.f6559k.f6658o));
        }
        n2 n2Var = x2Var.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void i() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void j() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final /* synthetic */ void k(int i10, v vVar) {
    }

    public final void l() {
        y3 y3Var;
        h hVar;
        int i10;
        int i11;
        x2 x2Var = this.f7383e;
        a4 a4Var = x2Var.f7437g.f7246s;
        if (a4Var.V().f6519h == 0) {
            y3Var = null;
        } else {
            g1 w10 = a4Var.w();
            if (!w10.i(26)) {
                i10 = 0;
            } else if (w10.i(25)) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            Handler handler = new Handler(a4Var.N0());
            if (a4Var.L0(23)) {
                i11 = a4Var.l();
            } else {
                i11 = 0;
            }
            y3Var = new y3(a4Var, i10, a4Var.V().f6521j, i11, handler);
        }
        x2Var.f7446p = y3Var;
        u uVar = x2Var.f7442l;
        if (y3Var == null) {
            if (a4Var.L0(21)) {
                hVar = a4Var.S();
            } else {
                hVar = h.f6386n;
            }
            ((z) uVar.f428i).n(t3.v(hVar));
            return;
        }
        ((z) uVar.f428i).w(y3Var);
    }

    public final void m(u1 u1Var) {
        boolean y10 = u1Var.y();
        x2 x2Var = this.f7383e;
        if (y10) {
            x2Var.f7442l.M((ArrayList) null);
            return;
        }
        e1.h hVar = t3.f7332a;
        ArrayList arrayList = new ArrayList();
        t1 t1Var = new t1();
        for (int i10 = 0; i10 < u1Var.x(); i10++) {
            arrayList.add(u1Var.v(i10, t1Var).f6577j);
        }
        ArrayList arrayList2 = new ArrayList();
        e eVar = new e(this, new AtomicInteger(0), arrayList, arrayList2, u1Var, 2);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            byte[] bArr = ((s0) arrayList.get(i11)).f6559k.f6660q;
            if (bArr == null) {
                arrayList2.add((Object) null);
                eVar.run();
            } else {
                e0 b10 = x2Var.f7437g.f7240m.b(bArr);
                arrayList2.add(b10);
                Handler handler = x2Var.f7437g.f7239l;
                Objects.requireNonNull(handler);
                b10.a(eVar, new b0(5, handler));
            }
        }
        C();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (j1.l0.a(r2, r0) == false) goto L_0x0037;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(int r2, h3.a4 r3, h3.a4 r4) {
        /*
            r1 = this;
            g1.u1 r2 = r4.U0()
            if (r3 == 0) goto L_0x0010
            g1.u1 r0 = r3.U0()
            boolean r0 = j1.l0.a(r0, r2)
            if (r0 != 0) goto L_0x0013
        L_0x0010:
            r1.m(r2)
        L_0x0013:
            r2 = 18
            boolean r0 = r4.L0(r2)
            if (r0 == 0) goto L_0x0020
            g1.v0 r0 = r4.H()
            goto L_0x0022
        L_0x0020:
            g1.v0 r0 = g1.v0.P
        L_0x0022:
            if (r3 == 0) goto L_0x0037
            boolean r2 = r3.L0(r2)
            if (r2 == 0) goto L_0x002f
            g1.v0 r2 = r3.H()
            goto L_0x0031
        L_0x002f:
            g1.v0 r2 = g1.v0.P
        L_0x0031:
            boolean r2 = j1.l0.a(r2, r0)
            if (r2 != 0) goto L_0x003a
        L_0x0037:
            r1.e(r0)
        L_0x003a:
            g1.v0 r2 = r4.V0()
            if (r3 == 0) goto L_0x004a
            g1.v0 r0 = r3.V0()
            boolean r2 = j1.l0.a(r0, r2)
            if (r2 != 0) goto L_0x004d
        L_0x004a:
            r1.C()
        L_0x004d:
            if (r3 == 0) goto L_0x0059
            boolean r2 = r3.o0()
            boolean r0 = r4.o0()
            if (r2 == r0) goto L_0x0060
        L_0x0059:
            boolean r2 = r4.o0()
            r1.f(r2)
        L_0x0060:
            if (r3 == 0) goto L_0x006c
            int r2 = r3.h()
            int r0 = r4.h()
            if (r2 == r0) goto L_0x0073
        L_0x006c:
            int r2 = r4.h()
            r1.a(r2)
        L_0x0073:
            r4.V()
            r1.l()
            h3.x2 r2 = r1.f7383e
            h3.x2.E(r2, r4)
            g1.s0 r0 = r4.T0()
            if (r3 == 0) goto L_0x0099
            g1.s0 r3 = r3.T0()
            boolean r3 = j1.l0.a(r3, r0)
            if (r3 != 0) goto L_0x008f
            goto L_0x0099
        L_0x008f:
            android.support.v4.media.session.PlaybackStateCompat r3 = r4.P0()
            android.support.v4.media.session.u r2 = r2.f7442l
            r2.L(r3)
            goto L_0x009c
        L_0x0099:
            r1.h(r0)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.v2.n(int, h3.a4, h3.a4):void");
    }

    public final /* synthetic */ void o(int i10, w3 w3Var, g1 g1Var, boolean z10, boolean z11, int i11) {
    }

    public final void p() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final /* synthetic */ void q() {
    }

    public final /* synthetic */ void r() {
    }

    public final /* synthetic */ void s() {
    }

    public final /* synthetic */ void t(int i10, j4 j4Var) {
    }

    public final void u(int i10, g1 g1Var) {
        x2 x2Var = this.f7383e;
        a4 a4Var = x2Var.f7437g.f7246s;
        x2.E(x2Var, a4Var);
        x2Var.f7437g.f7234g.f7442l.L(a4Var.P0());
    }

    public final /* synthetic */ void v() {
    }

    public final /* synthetic */ void w() {
    }

    public final void x(int i10, i4 i4Var, boolean z10, boolean z11) {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void y() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }

    public final void z() {
        n2 n2Var = this.f7383e.f7437g;
        n2Var.f7234g.f7442l.L(n2Var.f7246s.P0());
    }
}
