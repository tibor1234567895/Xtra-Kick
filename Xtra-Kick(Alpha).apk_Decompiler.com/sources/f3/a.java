package f3;

import android.net.Uri;
import c9.j;
import d2.a0;
import d2.v;
import g1.i1;
import g1.l;
import h3.a4;
import h3.b0;
import h3.d2;
import h3.e2;
import h3.f2;
import h3.m2;
import h3.n1;
import h3.n2;
import h3.o1;
import h3.p1;
import h3.p3;
import h3.q3;
import h3.r0;
import h3.r3;
import h3.s3;
import h3.t3;
import h3.y0;
import j1.d;
import j1.h;
import j1.q;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import n1.x;
import r1.u;

public final /* synthetic */ class a implements a0, l, q, n1, m2, h, p3, q3, r3, j, u {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5475h;

    public /* synthetic */ a(int i10) {
        this.f5475h = i10;
    }

    public void a(a4 a4Var, e2 e2Var, List list) {
        int i10 = s3.f7316j;
        a4Var.g0(list);
    }

    public Object apply(Object obj) {
        switch (this.f5475h) {
            case 0:
                return new x((d) obj);
            default:
                return (u2.u) obj;
        }
    }

    public void b(Object obj) {
        switch (this.f5475h) {
            case 20:
                ((a4) obj).B();
                return;
            case 23:
                ((a4) obj).z();
                return;
            case 25:
                ((a4) obj).u0();
                return;
            case 26:
                ((a4) obj).W();
                return;
            case 27:
                ((a4) obj).n0();
                return;
            case 28:
                ((a4) obj).O();
                return;
            default:
                int i10 = s3.f7316j;
                ((a4) obj).R();
                return;
        }
    }

    public v[] c() {
        return new v[]{new g3.d()};
    }

    public void d(a4 a4Var, f2 f2Var) {
        switch (this.f5475h) {
            case 22:
                t3.A(a4Var, f2Var);
                return;
            default:
                t3.A(a4Var, f2Var);
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [g1.m] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g1.m e(android.os.Bundle r14) {
        /*
            r13 = this;
            int r0 = r13.f5475h
            r1 = 0
            r2 = 0
            switch(r0) {
                case 6: goto L_0x00db;
                case 7: goto L_0x00a7;
                case 8: goto L_0x000e;
                case 13: goto L_0x0009;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x013c
        L_0x0009:
            h3.v r14 = h3.v.i(r14, r1)
            return r14
        L_0x000e:
            java.lang.String r0 = h3.i.f7079q
            int r4 = r14.getInt(r0, r2)
            java.lang.String r0 = h3.i.f7087y
            int r5 = r14.getInt(r0, r2)
            java.lang.String r0 = h3.i.f7080r
            android.os.IBinder r0 = b0.j.a(r14, r0)
            r0.getClass()
            java.lang.String r1 = h3.i.f7081s
            android.os.Parcelable r1 = r14.getParcelable(r1)
            r7 = r1
            android.app.PendingIntent r7 = (android.app.PendingIntent) r7
            java.lang.String r1 = h3.i.f7082t
            android.os.Bundle r1 = r14.getBundle(r1)
            if (r1 != 0) goto L_0x0037
            h3.h4 r1 = h3.h4.f7075i
            goto L_0x003f
        L_0x0037:
            h3.j3 r2 = h3.h4.f7077k
            g1.m r1 = r2.e(r1)
            h3.h4 r1 = (h3.h4) r1
        L_0x003f:
            r8 = r1
            java.lang.String r1 = h3.i.f7084v
            android.os.Bundle r1 = r14.getBundle(r1)
            if (r1 != 0) goto L_0x004b
            g1.g1 r1 = g1.g1.f6382i
            goto L_0x0053
        L_0x004b:
            g1.a r2 = g1.g1.f6384k
            g1.m r1 = r2.e(r1)
            g1.g1 r1 = (g1.g1) r1
        L_0x0053:
            r10 = r1
            java.lang.String r1 = h3.i.f7083u
            android.os.Bundle r1 = r14.getBundle(r1)
            if (r1 != 0) goto L_0x005f
            g1.g1 r1 = g1.g1.f6382i
            goto L_0x0067
        L_0x005f:
            g1.a r2 = g1.g1.f6384k
            g1.m r1 = r2.e(r1)
            g1.g1 r1 = (g1.g1) r1
        L_0x0067:
            r9 = r1
            java.lang.String r1 = h3.i.f7085w
            android.os.Bundle r1 = r14.getBundle(r1)
            java.lang.String r2 = h3.i.f7086x
            android.os.Bundle r14 = r14.getBundle(r2)
            if (r14 != 0) goto L_0x0079
            h3.w3 r14 = h3.w3.L
            goto L_0x0081
        L_0x0079:
            h3.j3 r2 = h3.w3.f7411q0
            g1.m r14 = r2.e(r14)
            h3.w3 r14 = (h3.w3) r14
        L_0x0081:
            r12 = r14
            h3.i r14 = new h3.i
            int r2 = h3.q.f7289c
            java.lang.String r2 = "androidx.media3.session.IMediaSession"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            if (r2 == 0) goto L_0x0095
            boolean r3 = r2 instanceof h3.r
            if (r3 == 0) goto L_0x0095
            h3.r r2 = (h3.r) r2
            goto L_0x009a
        L_0x0095:
            h3.p r2 = new h3.p
            r2.<init>(r0)
        L_0x009a:
            r6 = r2
            if (r1 != 0) goto L_0x00a1
            android.os.Bundle r0 = android.os.Bundle.EMPTY
            r11 = r0
            goto L_0x00a2
        L_0x00a1:
            r11 = r1
        L_0x00a2:
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        L_0x00a7:
            java.lang.String r0 = h3.h.f7053m
            int r4 = r14.getInt(r0, r2)
            java.lang.String r0 = h3.h.f7057q
            int r5 = r14.getInt(r0, r2)
            java.lang.String r0 = h3.h.f7054n
            java.lang.String r6 = r14.getString(r0)
            r6.getClass()
            java.lang.String r0 = h3.h.f7055o
            boolean r1 = r14.containsKey(r0)
            j1.a.b(r1)
            int r7 = r14.getInt(r0)
            java.lang.String r0 = h3.h.f7056p
            android.os.Bundle r14 = r14.getBundle(r0)
            h3.h r0 = new h3.h
            if (r14 != 0) goto L_0x00d5
            android.os.Bundle r14 = android.os.Bundle.EMPTY
        L_0x00d5:
            r8 = r14
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r0
        L_0x00db:
            java.lang.String r0 = h3.d.f6964n
            android.os.Bundle r0 = r14.getBundle(r0)
            if (r0 != 0) goto L_0x00e4
            goto L_0x00ed
        L_0x00e4:
            h3.j3 r1 = h3.f4.f7033o
            g1.m r0 = r1.e(r0)
            r1 = r0
            h3.f4 r1 = (h3.f4) r1
        L_0x00ed:
            java.lang.String r0 = h3.d.f6965o
            r3 = -1
            int r0 = r14.getInt(r0, r3)
            java.lang.String r4 = h3.d.f6966p
            int r4 = r14.getInt(r4, r2)
            java.lang.String r5 = h3.d.f6967q
            java.lang.String r6 = ""
            java.lang.CharSequence r5 = r14.getCharSequence(r5, r6)
            java.lang.String r6 = h3.d.f6968r
            android.os.Bundle r6 = r14.getBundle(r6)
            java.lang.String r7 = h3.d.f6969s
            boolean r14 = r14.getBoolean(r7, r2)
            h3.c r7 = new h3.c
            r7.<init>()
            if (r1 == 0) goto L_0x0121
            int r8 = r7.f6944b
            if (r8 != r3) goto L_0x011a
            r2 = 1
        L_0x011a:
            java.lang.String r8 = "playerCommands is already set. Only one of sessionCommand and playerCommand should be set."
            j1.a.a(r8, r2)
            r7.f6943a = r1
        L_0x0121:
            if (r0 == r3) goto L_0x0126
            r7.b(r0)
        L_0x0126:
            r7.f6945c = r4
            r7.f6946d = r5
            if (r6 != 0) goto L_0x012e
            android.os.Bundle r6 = android.os.Bundle.EMPTY
        L_0x012e:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>(r6)
            r7.f6947e = r0
            r7.f6948f = r14
            h3.d r14 = r7.a()
            return r14
        L_0x013c:
            java.lang.String r0 = h3.p1.f7275l
            android.os.Bundle r0 = r14.getBundle(r0)
            java.lang.String r1 = h3.p1.f7276m
            boolean r1 = r14.getBoolean(r1, r2)
            java.lang.String r3 = h3.p1.f7277n
            boolean r3 = r14.getBoolean(r3, r2)
            java.lang.String r4 = h3.p1.f7278o
            boolean r14 = r14.getBoolean(r4, r2)
            h3.p1 r2 = new h3.p1
            if (r0 != 0) goto L_0x015a
            android.os.Bundle r0 = android.os.Bundle.EMPTY
        L_0x015a:
            r2.<init>(r0, r1, r3, r14)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.a.e(android.os.Bundle):g1.m");
    }

    public v[] f(Uri uri, Map map) {
        return c();
    }

    public void g(y0 y0Var) {
        switch (this.f5475h) {
            case Constants.IV_SIZE:
                y0Var.f7461i.m(26, new a(15));
                return;
            default:
                int i10 = o1.f7265e;
                b0 b0Var = y0Var.f7453a;
                Objects.requireNonNull(b0Var);
                b0Var.S0(new r0(b0Var, 9));
                return;
        }
    }

    public Object h(n2 n2Var, e2 e2Var, int i10) {
        switch (this.f5475h) {
            case 0:
                android.support.v4.media.h.y(n2Var);
                throw null;
            default:
                android.support.v4.media.h.y(n2Var);
                throw null;
        }
    }

    public void i(d2 d2Var, int i10) {
        d2Var.d(i10);
    }

    public void invoke(Object obj) {
        switch (this.f5475h) {
            case 14:
                ((i1) obj).F(1);
                return;
            default:
                ((i1) obj).r();
                return;
        }
    }

    public /* synthetic */ a(String str, int i10, int i11, p1 p1Var, int i12) {
        this.f5475h = i12;
    }
}
