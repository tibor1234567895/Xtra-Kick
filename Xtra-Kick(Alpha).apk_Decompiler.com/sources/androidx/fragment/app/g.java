package androidx.fragment.app;

import android.animation.Animator;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.PlaybackMetrics;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.SparseArray;
import d0.d;
import d9.p0;
import g1.a2;
import g1.b1;
import g1.b2;
import g1.d1;
import g1.e1;
import g1.k;
import g1.k1;
import g1.l1;
import g1.s0;
import g1.t1;
import g1.u;
import g1.u1;
import g1.v0;
import g1.y;
import g1.y1;
import g1.z1;
import h3.a4;
import h3.b0;
import h3.d2;
import h3.e2;
import h3.i1;
import h3.j1;
import h3.m2;
import h3.n1;
import h3.n2;
import h3.r3;
import h3.s3;
import h3.u0;
import h3.w2;
import h3.w3;
import h3.x2;
import h3.y0;
import h3.z;
import i0.e;
import j1.a;
import j1.h;
import j1.l0;
import j1.q;
import j1.r;
import j1.v;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import k1.g0;
import m0.x;
import m1.p;
import n0.f;
import n1.a0;
import n1.b;
import n1.c;
import n1.c0;
import o1.j;
import o1.l;
import p1.i;
import p1.m;
import s1.s;
import z1.n;

public final /* synthetic */ class g implements e, q, r, n, u0, h, n1, m2, w2, r3 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1427h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1428i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f1429j;

    public /* synthetic */ g(Object obj, int i10, Object obj2) {
        this.f1427h = i10;
        this.f1428i = obj;
        this.f1429j = obj2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d9.r1 a(int r19, g1.v1 r20, int[] r21) {
        /*
            r18 = this;
            r0 = r18
            r9 = r20
            int r1 = r0.f1427h
            java.lang.Object r2 = r0.f1429j
            java.lang.Object r3 = r0.f1428i
            switch(r1) {
                case 12: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x00dd
        L_0x000f:
            r11 = r3
            z1.j r11 = (z1.j) r11
            int[] r2 = (int[]) r2
            d9.p1 r1 = z1.q.f17467j
            r12 = r2[r19]
            int r1 = r11.f6733p
            r13 = -1
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r14) goto L_0x008d
            int r2 = r11.f6734q
            if (r2 != r14) goto L_0x0026
            goto L_0x008d
        L_0x0026:
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L_0x002a:
            int r5 = r9.f6673h
            if (r3 >= r5) goto L_0x008b
            g1.a0[] r5 = r9.f6676k
            r5 = r5[r3]
            int r6 = r5.f6281x
            if (r6 <= 0) goto L_0x0085
            int r7 = r5.f6282y
            if (r7 <= 0) goto L_0x0085
            boolean r8 = r11.f6735r
            if (r8 == 0) goto L_0x004d
            if (r6 <= r7) goto L_0x0042
            r8 = 1
            goto L_0x0043
        L_0x0042:
            r8 = 0
        L_0x0043:
            if (r1 <= r2) goto L_0x0047
            r10 = 1
            goto L_0x0048
        L_0x0047:
            r10 = 0
        L_0x0048:
            if (r8 == r10) goto L_0x004d
            r8 = r1
            r10 = r2
            goto L_0x004f
        L_0x004d:
            r10 = r1
            r8 = r2
        L_0x004f:
            int r15 = r6 * r8
            int r14 = r7 * r10
            if (r15 < r14) goto L_0x0060
            android.graphics.Point r8 = new android.graphics.Point
            int r15 = j1.l0.f8453a
            int r14 = r14 + r6
            int r14 = r14 + r13
            int r14 = r14 / r6
            r8.<init>(r10, r14)
            goto L_0x006b
        L_0x0060:
            android.graphics.Point r6 = new android.graphics.Point
            int r10 = j1.l0.f8453a
            int r15 = r15 + r7
            int r15 = r15 + r13
            int r15 = r15 / r7
            r6.<init>(r15, r8)
            r8 = r6
        L_0x006b:
            int r5 = r5.f6281x
            int r6 = r5 * r7
            int r10 = r8.x
            float r10 = (float) r10
            r14 = 1065017672(0x3f7ae148, float:0.98)
            float r10 = r10 * r14
            int r10 = (int) r10
            if (r5 < r10) goto L_0x0085
            int r5 = r8.y
            float r5 = (float) r5
            float r5 = r5 * r14
            int r5 = (int) r5
            if (r7 < r5) goto L_0x0085
            if (r6 >= r4) goto L_0x0085
            r4 = r6
        L_0x0085:
            int r3 = r3 + 1
            r14 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x002a
        L_0x008b:
            r10 = r4
            goto L_0x0090
        L_0x008d:
            r10 = 2147483647(0x7fffffff, float:NaN)
        L_0x0090:
            d9.p0 r1 = d9.r0.f4657i
            d9.o0 r14 = new d9.o0
            r14.<init>()
            r15 = 0
        L_0x0098:
            int r1 = r9.f6673h
            if (r15 >= r1) goto L_0x00d8
            g1.a0[] r1 = r9.f6676k
            r1 = r1[r15]
            int r2 = r1.f6281x
            if (r2 == r13) goto L_0x00ac
            int r1 = r1.f6282y
            if (r1 != r13) goto L_0x00a9
            goto L_0x00ac
        L_0x00a9:
            int r2 = r2 * r1
            goto L_0x00ad
        L_0x00ac:
            r2 = -1
        L_0x00ad:
            r8 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == r8) goto L_0x00ba
            if (r2 == r13) goto L_0x00b7
            if (r2 > r10) goto L_0x00b7
            goto L_0x00ba
        L_0x00b7:
            r16 = 0
            goto L_0x00bc
        L_0x00ba:
            r16 = 1
        L_0x00bc:
            z1.p r7 = new z1.p
            r6 = r21[r15]
            r1 = r7
            r2 = r19
            r3 = r20
            r4 = r15
            r5 = r11
            r13 = r7
            r7 = r12
            r17 = 2147483647(0x7fffffff, float:NaN)
            r8 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r14.c(r13)
            int r15 = r15 + 1
            r13 = -1
            goto L_0x0098
        L_0x00d8:
            d9.r1 r1 = r14.e()
            return r1
        L_0x00dd:
            r8 = r3
            z1.j r8 = (z1.j) r8
            r10 = r2
            java.lang.String r10 = (java.lang.String) r10
            d9.p1 r1 = z1.q.f17467j
            d9.p0 r1 = d9.r0.f4657i
            d9.o0 r11 = new d9.o0
            r11.<init>()
            r12 = 0
        L_0x00ed:
            int r1 = r9.f6673h
            if (r12 >= r1) goto L_0x0106
            z1.m r13 = new z1.m
            r6 = r21[r12]
            r1 = r13
            r2 = r19
            r3 = r20
            r4 = r12
            r5 = r8
            r7 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r11.c(r13)
            int r12 = r12 + 1
            goto L_0x00ed
        L_0x0106:
            d9.r1 r1 = r11.e()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.g.a(int, g1.v1, int[]):d9.r1");
    }

    public final void b(Object obj) {
        int i10 = this.f1427h;
        Object obj2 = this.f1428i;
        switch (i10) {
            case 20:
                b0 b0Var = ((y0) obj2).f7453a;
                ((z) obj).p();
                return;
            case 21:
                b0 b0Var2 = ((y0) obj2).f7453a;
                ((z) obj).o();
                return;
            default:
                b0 b0Var3 = ((i1) obj2).f7101e.f7172b;
                ((z) obj).p();
                return;
        }
    }

    public final void c(Object obj, y yVar) {
        int i10;
        int i11;
        d dVar;
        int i12;
        int i13;
        boolean z10;
        x xVar;
        x xVar2;
        int i14;
        boolean z11;
        x xVar3;
        x xVar4;
        int i15;
        int i16;
        u uVar;
        int i17;
        k1 k1Var = (k1) this.f1429j;
        android.support.v4.media.n nVar = new android.support.v4.media.n(yVar, ((n1.x) this.f1428i).f11001l);
        c0 c0Var = (c0) ((c) obj);
        c0Var.getClass();
        if (((y) nVar.f337i).c() != 0) {
            for (int i18 = 0; i18 < ((y) nVar.f337i).c(); i18++) {
                int b10 = ((y) nVar.f337i).b(i18);
                b bVar = (b) ((SparseArray) nVar.f338j).get(b10);
                bVar.getClass();
                if (b10 == 0) {
                    n1.z zVar = c0Var.f10932b;
                    synchronized (zVar) {
                        zVar.f11019e.getClass();
                        u1 u1Var = zVar.f11020f;
                        zVar.f11020f = bVar.f10922b;
                        Iterator it = zVar.f11017c.values().iterator();
                        while (it.hasNext()) {
                            n1.y yVar2 = (n1.y) it.next();
                            if (!yVar2.b(u1Var, zVar.f11020f) || yVar2.a(bVar)) {
                                it.remove();
                                if (yVar2.f11010e) {
                                    if (yVar2.f11006a.equals(zVar.f11021g)) {
                                        zVar.f11021g = null;
                                    }
                                    ((c0) zVar.f11019e).i(bVar, yVar2.f11006a);
                                }
                            }
                        }
                        zVar.c(bVar);
                    }
                } else if (b10 == 11) {
                    c0Var.f10932b.e(bVar, c0Var.f10941k);
                } else {
                    c0Var.f10932b.d(bVar);
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (nVar.l(0)) {
                b bVar2 = (b) ((SparseArray) nVar.f338j).get(0);
                bVar2.getClass();
                if (c0Var.f10940j != null) {
                    c0Var.f(bVar2.f10922b, bVar2.f10924d);
                }
            }
            if (nVar.l(2) && c0Var.f10940j != null) {
                p0 l10 = k1Var.D().f6289h.listIterator(0);
                loop2:
                while (true) {
                    if (!l10.hasNext()) {
                        uVar = null;
                        break;
                    }
                    z1 z1Var = (z1) l10.next();
                    for (int i19 = 0; i19 < z1Var.f6777h; i19++) {
                        if (z1Var.f6781l[i19] && (uVar = z1Var.f6778i.f6676k[i19].f6279v) != null) {
                            break loop2;
                        }
                    }
                }
                if (uVar != null) {
                    PlaybackMetrics.Builder b11 = a0.b(c0Var.f10940j);
                    int i20 = 0;
                    while (true) {
                        if (i20 >= uVar.f6595k) {
                            i17 = 1;
                            break;
                        }
                        UUID uuid = uVar.f6592h[i20].f6567i;
                        if (uuid.equals(g1.n.f6476d)) {
                            i17 = 3;
                            break;
                        } else if (uuid.equals(g1.n.f6477e)) {
                            i17 = 2;
                            break;
                        } else if (uuid.equals(g1.n.f6475c)) {
                            i17 = 6;
                            break;
                        } else {
                            i20++;
                        }
                    }
                    b11.setDrmType(i17);
                }
            }
            if (nVar.l(1011)) {
                c0Var.f10956z++;
            }
            d1 d1Var = c0Var.f10944n;
            if (d1Var == null) {
                i11 = 1;
                i10 = 2;
            } else {
                if (c0Var.f10952v == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                int i21 = d1Var.f6349h;
                if (i21 == 1001) {
                    xVar2 = new x(20, 0);
                } else {
                    if (d1Var instanceof p) {
                        p pVar = (p) d1Var;
                        if (pVar.f10424p == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        i14 = pVar.f10428t;
                    } else {
                        z11 = false;
                        i14 = 0;
                    }
                    Throwable cause = d1Var.getCause();
                    cause.getClass();
                    if (!(cause instanceof IOException)) {
                        if (z11 && (i14 == 0 || i14 == 1)) {
                            xVar = new x(35, 0);
                        } else if (z11 && i14 == 3) {
                            xVar = new x(15, 0);
                        } else if (z11 && i14 == 2) {
                            xVar = new x(23, 0);
                        } else if (cause instanceof s) {
                            xVar3 = new x(13, l0.r(((s) cause).f14044k));
                        } else {
                            if (cause instanceof s1.n) {
                                xVar4 = new x(14, l0.r(((s1.n) cause).f14032h));
                            } else {
                                if (cause instanceof OutOfMemoryError) {
                                    xVar = new x(14, 0);
                                } else if (cause instanceof j) {
                                    xVar = new x(17, ((j) cause).f11932h);
                                } else if (cause instanceof l) {
                                    xVar = new x(18, ((l) cause).f11934h);
                                } else if (l0.f8453a < 16 || !(cause instanceof MediaCodec.CryptoException)) {
                                    xVar = new x(22, 0);
                                } else {
                                    int errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                    xVar4 = new x(c0.c(errorCode), errorCode);
                                }
                                a0.h();
                                c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                                i11 = 1;
                                c0Var.A = true;
                                c0Var.f10944n = null;
                                i10 = 2;
                            }
                            xVar3 = xVar4;
                        }
                        a0.h();
                        c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                        i11 = 1;
                        c0Var.A = true;
                        c0Var.f10944n = null;
                        i10 = 2;
                    } else if (cause instanceof k1.z) {
                        xVar2 = new x(5, ((k1.z) cause).f9070k);
                    } else if ((cause instanceof k1.y) || (cause instanceof b1)) {
                        if (z10) {
                            i15 = 10;
                        } else {
                            i15 = 11;
                        }
                        xVar2 = new x(i15, 0);
                        xVar = xVar2;
                        a0.h();
                        c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                        i11 = 1;
                        c0Var.A = true;
                        c0Var.f10944n = null;
                        i10 = 2;
                    } else {
                        boolean z12 = cause instanceof k1.x;
                        if (z12 || (cause instanceof g0)) {
                            if (j1.z.b(c0Var.f10931a).c() == 1) {
                                xVar2 = new x(3, 0);
                                xVar = xVar2;
                                a0.h();
                                c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                                i11 = 1;
                                c0Var.A = true;
                                c0Var.f10944n = null;
                                i10 = 2;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    xVar2 = new x(6, 0);
                                    xVar = xVar2;
                                    a0.h();
                                    c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                                    i11 = 1;
                                    c0Var.A = true;
                                    c0Var.f10944n = null;
                                    i10 = 2;
                                } else {
                                    if (cause2 instanceof SocketTimeoutException) {
                                        xVar2 = new x(7, 0);
                                    } else if (!z12 || ((k1.x) cause).f9069j != 1) {
                                        xVar2 = new x(8, 0);
                                        xVar = xVar2;
                                        a0.h();
                                        c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                                        i11 = 1;
                                        c0Var.A = true;
                                        c0Var.f10944n = null;
                                        i10 = 2;
                                    } else {
                                        xVar2 = new x(4, 0);
                                    }
                                    xVar = xVar2;
                                    a0.h();
                                    c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                                    i11 = 1;
                                    c0Var.A = true;
                                    c0Var.f10944n = null;
                                    i10 = 2;
                                }
                            }
                        } else if (i21 == 1002) {
                            xVar2 = new x(21, 0);
                        } else if (cause instanceof m) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            int i22 = l0.f8453a;
                            if (i22 >= 21 && (cause3 instanceof MediaDrm.MediaDrmStateException)) {
                                int r10 = l0.r(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                xVar3 = new x(c0.c(r10), r10);
                            } else if (i22 >= 23 && f.u(cause3)) {
                                xVar2 = new x(27, 0);
                            } else if (i22 >= 18 && (cause3 instanceof NotProvisionedException)) {
                                xVar2 = new x(24, 0);
                            } else if (i22 >= 18 && (cause3 instanceof DeniedByServerException)) {
                                xVar2 = new x(29, 0);
                            } else if (cause3 instanceof p1.l0) {
                                xVar2 = new x(23, 0);
                            } else {
                                if (cause3 instanceof i) {
                                    i16 = 28;
                                } else {
                                    i16 = 30;
                                }
                                xVar2 = new x(i16, 0);
                            }
                        } else if (!(cause instanceof k1.u) || !(cause.getCause() instanceof FileNotFoundException)) {
                            xVar2 = new x(9, 0);
                            xVar = xVar2;
                            a0.h();
                            c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                            i11 = 1;
                            c0Var.A = true;
                            c0Var.f10944n = null;
                            i10 = 2;
                        } else {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            if (l0.f8453a < 21 || !(cause5 instanceof ErrnoException) || ((ErrnoException) cause5).errno != OsConstants.EACCES) {
                                xVar2 = new x(31, 0);
                            } else {
                                xVar2 = new x(32, 0);
                            }
                        }
                    }
                    xVar = xVar3;
                    a0.h();
                    c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                    i11 = 1;
                    c0Var.A = true;
                    c0Var.f10944n = null;
                    i10 = 2;
                }
                xVar = xVar2;
                a0.h();
                c0Var.f10933c.reportPlaybackErrorEvent(b0.b0.g().setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).setErrorCode(xVar.f10157a).setSubErrorCode(xVar.f10158b).setException(d1Var).build());
                i11 = 1;
                c0Var.A = true;
                c0Var.f10944n = null;
                i10 = 2;
            }
            if (nVar.l(i10)) {
                a2 D = k1Var.D();
                boolean i23 = D.i(i10);
                boolean i24 = D.i(i11);
                boolean i25 = D.i(3);
                if (i23 || i24 || i25) {
                    if (!i23) {
                        c0Var.g(0, elapsedRealtime, (g1.a0) null);
                    }
                    if (!i24) {
                        c0Var.d(0, elapsedRealtime, (g1.a0) null);
                    }
                    if (!i25) {
                        c0Var.e(0, elapsedRealtime, (g1.a0) null);
                    }
                }
            }
            if (c0Var.a(c0Var.f10945o)) {
                d dVar2 = c0Var.f10945o;
                g1.a0 a0Var = (g1.a0) dVar2.f4091i;
                if (a0Var.f6282y != -1) {
                    c0Var.g(dVar2.f4090h, elapsedRealtime, a0Var);
                    c0Var.f10945o = null;
                }
            }
            if (c0Var.a(c0Var.f10946p)) {
                d dVar3 = c0Var.f10946p;
                c0Var.d(dVar3.f4090h, elapsedRealtime, (g1.a0) dVar3.f4091i);
                dVar = null;
                c0Var.f10946p = null;
            } else {
                dVar = null;
            }
            if (c0Var.a(c0Var.f10947q)) {
                d dVar4 = c0Var.f10947q;
                c0Var.e(dVar4.f4090h, elapsedRealtime, (g1.a0) dVar4.f4091i);
                c0Var.f10947q = dVar;
            }
            switch (j1.z.b(c0Var.f10931a).c()) {
                case 0:
                    i12 = 0;
                    break;
                case 1:
                    i12 = 9;
                    break;
                case 2:
                    i12 = 2;
                    break;
                case 3:
                    i12 = 4;
                    break;
                case 4:
                    i12 = 5;
                    break;
                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                    i12 = 6;
                    break;
                case 7:
                    i12 = 3;
                    break;
                case 9:
                    i12 = 8;
                    break;
                case 10:
                    i12 = 7;
                    break;
                default:
                    i12 = 1;
                    break;
            }
            if (i12 != c0Var.f10943m) {
                c0Var.f10943m = i12;
                n1.b0.D();
                c0Var.f10933c.reportNetworkEvent(n1.b0.h().setNetworkType(i12).setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).build());
            }
            if (k1Var.b() != 2) {
                c0Var.f10951u = false;
            }
            if (k1Var.k() == null) {
                c0Var.f10953w = false;
            } else if (nVar.l(10)) {
                c0Var.f10953w = true;
            }
            int b12 = k1Var.b();
            if (c0Var.f10951u) {
                i13 = 5;
            } else if (c0Var.f10953w) {
                i13 = 13;
            } else if (b12 == 4) {
                i13 = 11;
            } else if (b12 == 2) {
                int i26 = c0Var.f10942l;
                if (i26 == 0 || i26 == 2) {
                    i13 = 2;
                } else if (!k1Var.y()) {
                    i13 = 7;
                } else if (k1Var.f0() != 0) {
                    i13 = 10;
                } else {
                    i13 = 6;
                }
            } else if (b12 == 3) {
                if (!k1Var.y()) {
                    i13 = 4;
                } else if (k1Var.f0() != 0) {
                    i13 = 9;
                } else {
                    i13 = 3;
                }
            } else if (b12 != 1 || c0Var.f10942l == 0) {
                i13 = c0Var.f10942l;
            } else {
                i13 = 12;
            }
            if (c0Var.f10942l != i13) {
                c0Var.f10942l = i13;
                c0Var.A = true;
                n1.b0.B();
                c0Var.f10933c.reportPlaybackStateEvent(n1.b0.p().setState(c0Var.f10942l).setTimeSinceCreatedMillis(elapsedRealtime - c0Var.f10934d).build());
            }
            if (nVar.l(1028)) {
                n1.z zVar2 = c0Var.f10932b;
                b bVar3 = (b) ((SparseArray) nVar.f338j).get(1028);
                bVar3.getClass();
                zVar2.a(bVar3);
            }
        }
    }

    public final void d(h3.r rVar, int i10) {
        int i11 = this.f1427h;
        Object obj = this.f1429j;
        Object obj2 = this.f1428i;
        switch (i11) {
            case 14:
                rVar.t0(((y0) obj2).f7455c, i10, ((y1) obj).h());
                return;
            case 15:
                y0 y0Var = (y0) obj2;
                y0Var.getClass();
                rVar.K(y0Var.f7455c, i10, ((e1) obj).h());
                return;
            case Constants.IV_SIZE /*16*/:
                y0 y0Var2 = (y0) obj2;
                y0Var2.getClass();
                rVar.w(y0Var2.f7455c, i10, ((s0) obj).h());
                return;
            case 17:
                y0 y0Var3 = (y0) obj2;
                y0Var3.getClass();
                rVar.s0(y0Var3.f7455c, i10, ((v0) obj).h());
                return;
            default:
                y0 y0Var4 = (y0) obj2;
                y0Var4.getClass();
                rVar.i0(y0Var4.f7455c, i10, new k(j1.c.c((List) obj)));
                return;
        }
    }

    public final void e(e2 e2Var) {
        String str;
        int i10 = this.f1427h;
        Object obj = this.f1429j;
        Object obj2 = this.f1428i;
        switch (i10) {
            case 27:
                x2 x2Var = (x2) obj2;
                int i11 = x2.f7435t;
                x2Var.getClass();
                String str2 = ((MediaDescriptionCompat) obj).f299h;
                if (TextUtils.isEmpty(str2)) {
                    str = "onRemoveQueueItem(): Media ID shouldn't be null";
                } else {
                    a4 a4Var = x2Var.f7437g.f7246s;
                    if (!a4Var.L0(17)) {
                        str = "Can't remove item by id without availabe COMMAND_GET_TIMELINE";
                    } else {
                        u1 j02 = a4Var.j0();
                        t1 t1Var = new t1();
                        for (int i12 = 0; i12 < j02.x(); i12++) {
                            if (TextUtils.equals(j02.v(i12, t1Var).f6577j.f6556h, str2)) {
                                a4Var.m0(i12);
                                return;
                            }
                        }
                        return;
                    }
                }
                v.g("MediaSessionLegacyStub", str);
                return;
            default:
                l1 l1Var = (l1) obj;
                n2 n2Var = ((x2) obj2).f7437g;
                s0 T0 = n2Var.f7246s.T0();
                if (T0 != null) {
                    a.d(n2Var.f7231d.h(n2Var.f7237j, e2Var, T0.f6556h, l1Var), "onSetRating must return non-null future");
                    return;
                }
                return;
        }
    }

    public final void f() {
        h2 h2Var = (h2) this.f1429j;
        xa.j.f("$operation", h2Var);
        ((Animator) this.f1428i).end();
        if (c1.I(2)) {
            h2Var.toString();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: h3.w3} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: h3.v3} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(h3.y0 r15) {
        /*
            r14 = this;
            v.e r0 = r15.f7461i
            int r1 = r14.f1427h
            r2 = 13
            java.lang.Object r3 = r14.f1429j
            java.lang.Object r4 = r14.f1428i
            r5 = 20
            r6 = 0
            r7 = 1
            switch(r1) {
                case 24: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x01ef
        L_0x0013:
            h3.w3 r4 = (h3.w3) r4
            h3.v3 r3 = (h3.v3) r3
            int r1 = h3.o1.f7265e
            boolean r1 = r15.H0()
            if (r1 != 0) goto L_0x0021
            goto L_0x01ee
        L_0x0021:
            h3.w3 r1 = r15.f7478z
            if (r1 == 0) goto L_0x0039
            h3.v3 r8 = r15.A
            if (r8 == 0) goto L_0x0039
            g1.g1 r9 = r15.f7470r
            android.util.Pair r1 = h3.t3.z(r1, r8, r4, r3, r9)
            java.lang.Object r3 = r1.first
            r4 = r3
            h3.w3 r4 = (h3.w3) r4
            java.lang.Object r1 = r1.second
            r3 = r1
            h3.v3 r3 = (h3.v3) r3
        L_0x0039:
            r1 = 0
            r15.f7478z = r1
            r15.A = r1
            q.f r1 = r15.f7463k
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004c
            r15.f7478z = r4
            r15.A = r3
            goto L_0x01ee
        L_0x004c:
            h3.w3 r1 = r15.f7466n
            h3.v3 r8 = h3.v3.f7384j
            g1.g1 r9 = r15.f7470r
            android.util.Pair r3 = h3.t3.z(r1, r8, r4, r3, r9)
            java.lang.Object r3 = r3.first
            h3.w3 r3 = (h3.w3) r3
            r15.f7466n = r3
            g1.d1 r15 = r1.f7412h
            g1.d1 r4 = r3.f7412h
            if (r15 == r4) goto L_0x006d
            if (r15 == 0) goto L_0x006b
            boolean r15 = r15.i(r4)
            if (r15 == 0) goto L_0x006b
            goto L_0x006d
        L_0x006b:
            r15 = 0
            goto L_0x006e
        L_0x006d:
            r15 = 1
        L_0x006e:
            r4 = 14
            r8 = 3
            r9 = 10
            if (r15 != 0) goto L_0x007f
            android.support.v4.media.h.x(r3, r8, r0, r9)
            g1.d1 r15 = r3.f7412h
            if (r15 == 0) goto L_0x007f
            android.support.v4.media.h.x(r3, r4, r0, r9)
        L_0x007f:
            g1.s0 r15 = r1.o()
            g1.s0 r4 = r3.o()
            boolean r15 = j1.l0.a(r15, r4)
            r10 = 19
            if (r15 != 0) goto L_0x0097
            androidx.fragment.app.g r15 = new androidx.fragment.app.g
            r15.<init>(r4, r10, r3)
            r0.j(r7, r15)
        L_0x0097:
            g1.a2 r15 = r1.J
            g1.a2 r4 = r3.J
            boolean r15 = j1.l0.a(r15, r4)
            r4 = 22
            if (r15 != 0) goto L_0x00a7
            r15 = 2
            android.support.v4.media.h.x(r3, r4, r0, r15)
        L_0x00a7:
            g1.e1 r15 = r1.f7418n
            g1.e1 r7 = r3.f7418n
            boolean r15 = j1.l0.a(r15, r7)
            r7 = 12
            if (r15 != 0) goto L_0x00b8
            r15 = 23
            android.support.v4.media.h.x(r3, r15, r0, r7)
        L_0x00b8:
            int r15 = r1.f7419o
            int r10 = r3.f7419o
            r11 = 8
            if (r15 == r10) goto L_0x00c5
            r15 = 24
            android.support.v4.media.h.x(r3, r15, r0, r11)
        L_0x00c5:
            r15 = 25
            boolean r10 = r1.f7420p
            boolean r12 = r3.f7420p
            r13 = 9
            if (r10 == r12) goto L_0x00d2
            android.support.v4.media.h.x(r3, r15, r0, r13)
        L_0x00d2:
            g1.u1 r15 = r1.f7421q
            g1.u1 r10 = r3.f7421q
            boolean r15 = j1.l0.a(r15, r10)
            if (r15 != 0) goto L_0x00e1
            r15 = 26
            android.support.v4.media.h.x(r3, r15, r0, r6)
        L_0x00e1:
            g1.v0 r15 = r1.f7423s
            g1.v0 r6 = r3.f7423s
            boolean r15 = j1.l0.a(r15, r6)
            r6 = 15
            r10 = 27
            if (r15 != 0) goto L_0x00f2
            android.support.v4.media.h.x(r3, r10, r0, r6)
        L_0x00f2:
            float r15 = r1.f7424t
            float r6 = r3.f7424t
            int r15 = (r15 > r6 ? 1 : (r15 == r6 ? 0 : -1))
            if (r15 == 0) goto L_0x00ff
            r15 = 28
            android.support.v4.media.h.x(r3, r15, r0, r4)
        L_0x00ff:
            g1.h r15 = r1.f7425u
            g1.h r4 = r3.f7425u
            boolean r15 = j1.l0.a(r15, r4)
            r4 = 4
            if (r15 != 0) goto L_0x010d
            android.support.v4.media.h.x(r3, r4, r0, r5)
        L_0x010d:
            i1.d r15 = r1.f7426v
            d9.r0 r15 = r15.f7994h
            i1.d r5 = r3.f7426v
            d9.r0 r5 = r5.f7994h
            boolean r15 = r15.equals(r5)
            r5 = 6
            r6 = 5
            if (r15 != 0) goto L_0x0128
            h3.i0 r15 = new h3.i0
            r15.<init>(r3, r6)
            r0.j(r10, r15)
            android.support.v4.media.h.x(r3, r5, r0, r10)
        L_0x0128:
            g1.q r15 = r1.f7427w
            g1.q r10 = r3.f7427w
            boolean r15 = j1.l0.a(r15, r10)
            r10 = 7
            if (r15 != 0) goto L_0x0138
            r15 = 29
            android.support.v4.media.h.x(r3, r10, r0, r15)
        L_0x0138:
            int r15 = r1.f7428x
            int r12 = r3.f7428x
            if (r15 != r12) goto L_0x0144
            boolean r15 = r1.f7429y
            boolean r12 = r3.f7429y
            if (r15 == r12) goto L_0x0149
        L_0x0144:
            r15 = 30
            android.support.v4.media.h.x(r3, r11, r0, r15)
        L_0x0149:
            boolean r15 = r1.f7430z
            boolean r11 = r3.f7430z
            if (r15 == r11) goto L_0x0152
            android.support.v4.media.h.x(r3, r13, r0, r6)
        L_0x0152:
            int r15 = r1.D
            int r6 = r3.D
            if (r15 == r6) goto L_0x015b
            android.support.v4.media.h.x(r3, r9, r0, r5)
        L_0x015b:
            int r15 = r1.E
            int r5 = r3.E
            r6 = 11
            if (r15 == r5) goto L_0x0166
            android.support.v4.media.h.x(r3, r6, r0, r4)
        L_0x0166:
            boolean r15 = r1.B
            boolean r4 = r3.B
            if (r15 == r4) goto L_0x016f
            android.support.v4.media.h.x(r3, r7, r0, r10)
        L_0x016f:
            boolean r15 = r1.C
            boolean r4 = r3.C
            if (r15 == r4) goto L_0x0178
            android.support.v4.media.h.x(r3, r2, r0, r8)
        L_0x0178:
            g1.b2 r15 = r1.f7422r
            g1.b2 r2 = r3.f7422r
            boolean r15 = j1.l0.a(r15, r2)
            if (r15 != 0) goto L_0x0189
            r15 = 15
            r2 = 25
            android.support.v4.media.h.x(r3, r15, r0, r2)
        L_0x0189:
            g1.j1 r15 = r1.f7415k
            g1.j1 r2 = r3.f7415k
            boolean r15 = j1.l0.a(r15, r2)
            r2 = 16
            if (r15 == 0) goto L_0x019f
            g1.j1 r15 = r1.f7416l
            g1.j1 r4 = r3.f7416l
            boolean r15 = j1.l0.a(r15, r4)
            if (r15 != 0) goto L_0x01a2
        L_0x019f:
            android.support.v4.media.h.x(r3, r2, r0, r6)
        L_0x01a2:
            g1.v0 r15 = r1.F
            g1.v0 r4 = r3.F
            boolean r15 = j1.l0.a(r15, r4)
            r4 = 17
            if (r15 != 0) goto L_0x01b3
            r15 = 14
            android.support.v4.media.h.x(r3, r4, r0, r15)
        L_0x01b3:
            long r5 = r1.G
            long r7 = r3.G
            r15 = 18
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x01c0
            android.support.v4.media.h.x(r3, r15, r0, r2)
        L_0x01c0:
            long r5 = r1.H
            long r7 = r3.H
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x01cd
            r2 = 19
            android.support.v4.media.h.x(r3, r2, r0, r4)
        L_0x01cd:
            long r4 = r1.I
            long r6 = r3.I
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x01da
            r2 = 20
            android.support.v4.media.h.x(r3, r2, r0, r15)
        L_0x01da:
            g1.y1 r15 = r1.K
            g1.y1 r1 = r3.K
            boolean r15 = j1.l0.a(r15, r1)
            if (r15 != 0) goto L_0x01eb
            r15 = 21
            r1 = 19
            android.support.v4.media.h.x(r3, r15, r0, r1)
        L_0x01eb:
            r0.g()
        L_0x01ee:
            return
        L_0x01ef:
            h3.h4 r4 = (h3.h4) r4
            g1.g1 r3 = (g1.g1) r3
            int r1 = h3.o1.f7265e
            boolean r1 = r15.H0()
            if (r1 != 0) goto L_0x01fc
            goto L_0x0241
        L_0x01fc:
            g1.g1 r1 = r15.f7468p
            boolean r1 = j1.l0.a(r1, r3)
            r1 = r1 ^ r7
            h3.h4 r5 = r15.f7467o
            boolean r5 = j1.l0.a(r5, r4)
            r5 = r5 ^ r7
            if (r1 != 0) goto L_0x020f
            if (r5 != 0) goto L_0x020f
            goto L_0x0241
        L_0x020f:
            if (r1 == 0) goto L_0x0223
            r15.f7468p = r3
            g1.g1 r1 = r15.f7470r
            g1.g1 r6 = r15.f7469q
            g1.g1 r3 = h3.t3.y(r3, r6)
            r15.f7470r = r3
            boolean r1 = j1.l0.a(r3, r1)
            r6 = r1 ^ 1
        L_0x0223:
            if (r5 == 0) goto L_0x0227
            r15.f7467o = r4
        L_0x0227:
            if (r6 == 0) goto L_0x0233
            h3.l0 r1 = new h3.l0
            r3 = 20
            r1.<init>(r15, r3)
            r0.m(r2, r1)
        L_0x0233:
            if (r5 == 0) goto L_0x0241
            androidx.fragment.app.g r0 = new androidx.fragment.app.g
            r1 = 21
            r0.<init>(r15, r1, r4)
            h3.b0 r15 = r15.f7453a
            r15.R0(r0)
        L_0x0241:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.g.g(h3.y0):void");
    }

    public final Object h(n2 n2Var, e2 e2Var, int i10) {
        int i11 = s3.f7316j;
        h9.a0 h10 = n2Var.f7231d.h(n2Var.f7237j, e2Var, (String) this.f1428i, (l1) this.f1429j);
        a.d(h10, "onSetRating must return non-null future");
        return h10;
    }

    public final void i(d2 d2Var, int i10) {
        Object obj = n2.f7225w;
        d2Var.n(i10, (a4) this.f1428i, (a4) this.f1429j);
    }

    public final void invoke(Object obj) {
        int i10 = this.f1427h;
        Object obj2 = this.f1428i;
        Object obj3 = this.f1429j;
        switch (i10) {
            case 1:
                ((c) obj).getClass();
                return;
            case 2:
                ((c) obj).getClass();
                return;
            case 3:
                ((c) obj).getClass();
                return;
            case 4:
                ((c) obj).getClass();
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                ((c) obj).getClass();
                return;
            case 7:
                ((c) obj).getClass();
                return;
            case 8:
                ((c) obj).getClass();
                return;
            case 9:
                ((c) obj).getClass();
                return;
            case 10:
                ((c) obj).getClass();
                return;
            case 11:
                b2 b2Var = (b2) obj3;
                c0 c0Var = (c0) ((c) obj);
                d dVar = c0Var.f10945o;
                if (dVar != null) {
                    g1.a0 a0Var = (g1.a0) dVar.f4091i;
                    if (a0Var.f6282y == -1) {
                        g1.z zVar = new g1.z(a0Var);
                        zVar.f6759p = b2Var.f6317h;
                        zVar.f6760q = b2Var.f6318i;
                        c0Var.f10945o = new d((Object) new g1.a0(zVar), dVar.f4090h, (Serializable) (String) dVar.f4092j);
                    }
                }
                int i11 = b2Var.f6317h;
                return;
            case 19:
                ((g1.i1) obj).L(((w3) obj3).f7413i, (s0) obj2);
                return;
            default:
                ((g1.i1) obj).L(((Integer) obj3).intValue(), ((j1) obj2).f7131a.o());
                return;
        }
    }
}
