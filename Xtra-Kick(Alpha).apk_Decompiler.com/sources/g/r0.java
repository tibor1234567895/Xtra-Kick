package g;

import h3.e2;
import h3.f;
import h3.g;
import h3.s3;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6200h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f6201i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f6202j;

    public /* synthetic */ r0(Object obj, int i10, Object obj2) {
        this.f6200h = i10;
        this.f6201i = obj;
        this.f6202j = obj2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f6201i
            h3.l1 r0 = (h3.l1) r0
            java.lang.Object r1 = r6.f6202j
            android.support.v4.media.session.MediaSessionCompat$Token r1 = (android.support.v4.media.session.MediaSessionCompat$Token) r1
            android.support.v4.media.session.u r2 = new android.support.v4.media.session.u
            android.content.Context r3 = r0.f7171a
            r2.<init>((android.content.Context) r3, (android.support.v4.media.session.MediaSessionCompat$Token) r1)
            r0.f7177g = r2
            h3.i1 r1 = r0.f7175e
            h3.b0 r0 = r0.f7172b
            android.os.Handler r0 = r0.f6926e
            if (r1 == 0) goto L_0x0080
            java.lang.Object r3 = r2.f430k
            java.util.concurrent.ConcurrentHashMap r3 = (java.util.concurrent.ConcurrentHashMap) r3
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            java.lang.Object r3 = r3.putIfAbsent(r1, r4)
            if (r3 == 0) goto L_0x002d
            java.lang.String r0 = "MediaControllerCompat"
            java.lang.String r1 = "the callback has already been registered"
            android.util.Log.w(r0, r1)
            goto L_0x007c
        L_0x002d:
            if (r0 != 0) goto L_0x0034
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
        L_0x0034:
            r1.n(r0)
            java.lang.Object r2 = r2.f428i
            android.support.v4.media.session.k r2 = (android.support.v4.media.session.k) r2
            android.support.v4.media.session.m r2 = (android.support.v4.media.session.m) r2
            android.media.session.MediaController r3 = r2.f403a
            android.support.v4.media.session.g r4 = r1.f400a
            r3.registerCallback(r4, r0)
            java.lang.Object r0 = r2.f404b
            monitor-enter(r0)
            android.support.v4.media.session.MediaSessionCompat$Token r3 = r2.f407e     // Catch:{ all -> 0x007d }
            android.support.v4.media.session.f r3 = r3.u()     // Catch:{ all -> 0x007d }
            r4 = 0
            if (r3 == 0) goto L_0x0074
            android.support.v4.media.session.l r3 = new android.support.v4.media.session.l     // Catch:{ all -> 0x007d }
            r3.<init>(r1)     // Catch:{ all -> 0x007d }
            java.util.HashMap r5 = r2.f406d     // Catch:{ all -> 0x007d }
            r5.put(r1, r3)     // Catch:{ all -> 0x007d }
            r1.f402c = r3     // Catch:{ all -> 0x007d }
            android.support.v4.media.session.MediaSessionCompat$Token r2 = r2.f407e     // Catch:{ RemoteException -> 0x006b }
            android.support.v4.media.session.f r2 = r2.u()     // Catch:{ RemoteException -> 0x006b }
            r2.m(r3)     // Catch:{ RemoteException -> 0x006b }
            r2 = 13
            r1.m(r2, r4, r4)     // Catch:{ RemoteException -> 0x006b }
            goto L_0x007b
        L_0x006b:
            r1 = move-exception
            java.lang.String r2 = "MediaControllerCompat"
            java.lang.String r3 = "Dead object in registerCallback."
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x007d }
            goto L_0x007b
        L_0x0074:
            r1.f402c = r4     // Catch:{ all -> 0x007d }
            java.util.ArrayList r2 = r2.f405c     // Catch:{ all -> 0x007d }
            r2.add(r1)     // Catch:{ all -> 0x007d }
        L_0x007b:
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
        L_0x007c:
            return
        L_0x007d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            throw r1
        L_0x0080:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "callback must not be null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g.r0.a():void");
    }

    private final void b() {
        e2 e2Var = (e2) this.f6202j;
        g gVar = ((s3) this.f6201i).f7319f;
        synchronized (gVar.f7037a) {
            f fVar = (f) gVar.f7039c.getOrDefault(e2Var, (Object) null);
            if (fVar != null && !fVar.f7017f) {
                if (!fVar.f7014c.isEmpty()) {
                    fVar.f7017f = true;
                    gVar.b(fVar);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r19 = this;
            r1 = r19
            int r0 = r1.f6200h
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 0
            r5 = -1
            r6 = 1
            r7 = 0
            switch(r0) {
                case 0: goto L_0x0455;
                case 1: goto L_0x0449;
                case 2: goto L_0x0427;
                case 3: goto L_0x0010;
                case 4: goto L_0x0404;
                case 5: goto L_0x03da;
                case 6: goto L_0x03ca;
                case 7: goto L_0x03b6;
                case 8: goto L_0x02dd;
                case 9: goto L_0x02bf;
                case 10: goto L_0x029c;
                case 11: goto L_0x0259;
                case 12: goto L_0x0233;
                case 13: goto L_0x0225;
                case 14: goto L_0x01e1;
                case 15: goto L_0x01d5;
                case 16: goto L_0x01af;
                case 17: goto L_0x018d;
                case 18: goto L_0x0167;
                case 19: goto L_0x012f;
                case 20: goto L_0x011e;
                case 21: goto L_0x011a;
                case 22: goto L_0x0107;
                case 23: goto L_0x00a0;
                case 24: goto L_0x008a;
                case 25: goto L_0x0061;
                case 26: goto L_0x0033;
                case 27: goto L_0x0016;
                case 28: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x046e
        L_0x0012:
            r19.b()
            return
        L_0x0016:
            java.lang.Object r0 = r1.f6201i
            h3.s3 r0 = (h3.s3) r0
            java.lang.Object r2 = r1.f6202j
            h3.o r2 = (h3.o) r2
            int r3 = h3.s3.f7316j
            r0.getClass()
            android.os.IBinder r2 = r2.asBinder()
            h3.g r0 = r0.f7319f
            h3.e2 r2 = r0.e(r2)
            if (r2 == 0) goto L_0x0032
            r0.k(r2)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Object r0 = r1.f6201i
            h3.y1 r0 = (h3.y1) r0
            java.lang.Object r2 = r1.f6202j
            h3.g2 r2 = (h3.g2) r2
            int r3 = h3.b3.f6933o
            java.util.HashMap r3 = r0.f7486h
            r3.remove(r2)
            java.util.HashMap r0 = r0.f7485g
            java.lang.Object r0 = r0.remove(r2)
            h9.e0 r0 = (h9.e0) r0
            if (r0 == 0) goto L_0x005c
            boolean r3 = r0.cancel(r6)
            if (r3 == 0) goto L_0x0053
            goto L_0x005c
        L_0x0053:
            java.lang.Object r0 = h9.w.b(r0)     // Catch:{ CancellationException | ExecutionException -> 0x005c }
            h3.b0 r0 = (h3.b0) r0     // Catch:{ CancellationException | ExecutionException -> 0x005c }
            r0.a()
        L_0x005c:
            h3.n2 r0 = r2.f7047a
            r0.f7244q = r4
            return
        L_0x0061:
            java.lang.Object r0 = r1.f6201i
            h9.e0 r0 = (h9.e0) r0
            java.lang.Object r2 = r1.f6202j
            android.os.ResultReceiver r2 = (android.os.ResultReceiver) r2
            int r3 = h3.x2.f7435t
            java.lang.Object r0 = r0.get()     // Catch:{ CancellationException -> 0x007d, InterruptedException | ExecutionException -> 0x0077 }
            h3.j4 r0 = (h3.j4) r0     // Catch:{ CancellationException -> 0x007d, InterruptedException | ExecutionException -> 0x0077 }
            java.lang.String r3 = "SessionResult must not be null"
            j1.a.d(r0, r3)     // Catch:{ CancellationException -> 0x007d, InterruptedException | ExecutionException -> 0x0077 }
            goto L_0x0082
        L_0x0077:
            h3.j4 r0 = new h3.j4
            r0.<init>(r5)
            goto L_0x0082
        L_0x007d:
            h3.j4 r0 = new h3.j4
            r0.<init>(r6)
        L_0x0082:
            android.os.Bundle r3 = r0.f7144i
            int r0 = r0.f7143h
            r2.send(r0, r3)
            return
        L_0x008a:
            java.lang.Object r0 = r1.f6201i
            h3.n2 r0 = (h3.n2) r0
            java.lang.Object r2 = r1.f6202j
            h9.k0 r2 = (h9.k0) r2
            java.lang.Object r3 = h3.n2.f7225w
            boolean r0 = r0.h()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r2.l(r0)
            return
        L_0x00a0:
            java.lang.Object r0 = r1.f6201i
            r2 = r0
            h3.n2 r2 = (h3.n2) r2
            java.lang.Object r0 = r1.f6202j
            r3 = r0
            h3.a4 r3 = (h3.a4) r3
            h3.x2 r5 = r2.f7234g
            r2.f7246s = r3
            h3.l2 r0 = new h3.l2
            r0.<init>((h3.n2) r2, (h3.a4) r3)
            r3.x0(r0)
            r2.f7243p = r0
            h3.v2 r0 = r5.f7439i     // Catch:{ RemoteException -> 0x00be }
            r0.n(r7, r4, r3)     // Catch:{ RemoteException -> 0x00be }
            goto L_0x00c6
        L_0x00be:
            r0 = move-exception
            java.lang.String r6 = "MSImplBase"
            java.lang.String r8 = "Exception in using media1 API"
            j1.v.d(r6, r8, r0)
        L_0x00c6:
            android.support.v4.media.session.u r0 = r5.f7442l
            java.lang.Object r5 = r0.f428i
            android.support.v4.media.session.z r5 = (android.support.v4.media.session.z) r5
            r5.p()
            java.lang.Object r0 = r0.f430k
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
            boolean r5 = r0.hasNext()
            if (r5 != 0) goto L_0x00ff
            h3.w3 r0 = r3.Q0()
            r2.f7245r = r0
            g1.g1 r0 = r3.w()
            h3.j2 r3 = r2.f7230c
            r3.a(r7, r7)
            h3.m1 r3 = new h3.m1
            r3.<init>(r0)
            r2.d(r3)
            p0.c r0 = new p0.c
            r3 = 14
            r0.<init>(r3, r2)
            r2.b(r0)
            return
        L_0x00ff:
            java.lang.Object r0 = r0.next()
            android.support.v4.media.h.y(r0)
            throw r4
        L_0x0107:
            java.lang.Object r0 = r1.f6201i
            h3.y0 r0 = (h3.y0) r0
            java.lang.Object r2 = r1.f6202j
            h3.n1 r2 = (h3.n1) r2
            int r3 = h3.o1.f7265e
            boolean r3 = r0.f7465m
            if (r3 == 0) goto L_0x0116
            goto L_0x0119
        L_0x0116:
            r2.g(r0)
        L_0x0119:
            return
        L_0x011a:
            r19.a()
            return
        L_0x011e:
            java.lang.Object r0 = r1.f6201i
            h3.n2 r0 = (h3.n2) r0
            boolean r2 = r0.f()
            if (r2 == 0) goto L_0x0129
            goto L_0x012e
        L_0x0129:
            h3.b2 r0 = r0.f7231d
            r0.b()
        L_0x012e:
            return
        L_0x012f:
            java.lang.Object r0 = r1.f6201i
            c2.m r0 = (c2.m) r0
            java.lang.Object r2 = r1.f6202j
            android.graphics.SurfaceTexture r2 = (android.graphics.SurfaceTexture) r2
            android.graphics.SurfaceTexture r3 = r0.f2786n
            android.view.Surface r4 = r0.f2787o
            android.view.Surface r5 = new android.view.Surface
            r5.<init>(r2)
            r0.f2786n = r2
            r0.f2787o = r5
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f2780h
            java.util.Iterator r0 = r0.iterator()
        L_0x014a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x015c
            java.lang.Object r2 = r0.next()
            m1.k0 r2 = (m1.k0) r2
            m1.n0 r2 = r2.f10314h
            r2.q1(r5)
            goto L_0x014a
        L_0x015c:
            if (r3 == 0) goto L_0x0161
            r3.release()
        L_0x0161:
            if (r4 == 0) goto L_0x0166
            r4.release()
        L_0x0166:
            return
        L_0x0167:
            java.lang.Object r0 = r1.f6201i
            b2.x r0 = (b2.x) r0
            java.lang.Object r2 = r1.f6202j
            java.lang.String r2 = (java.lang.String) r2
            r0.getClass()
            int r3 = j1.l0.f8453a
            b2.y r0 = r0.f2512b
            m1.k0 r0 = (m1.k0) r0
            m1.n0 r0 = r0.f10314h
            n1.a r0 = r0.f10394r
            n1.x r0 = (n1.x) r0
            n1.b r3 = r0.c0()
            n1.r r4 = new n1.r
            r4.<init>(r3, r2, r6)
            r2 = 1019(0x3fb, float:1.428E-42)
            r0.d0(r3, r2, r4)
            return
        L_0x018d:
            java.lang.Object r0 = r1.f6201i
            b2.x r0 = (b2.x) r0
            java.lang.Object r2 = r1.f6202j
            g1.b2 r2 = (g1.b2) r2
            r0.getClass()
            int r3 = j1.l0.f8453a
            b2.y r0 = r0.f2512b
            m1.k0 r0 = (m1.k0) r0
            m1.n0 r0 = r0.f10314h
            r0.f10379g0 = r2
            m1.j0 r3 = new m1.j0
            r3.<init>(r2)
            r2 = 25
            v.e r0 = r0.f10388l
            r0.m(r2, r3)
            return
        L_0x01af:
            java.lang.Object r0 = r1.f6201i
            b2.x r0 = (b2.x) r0
            java.lang.Object r2 = r1.f6202j
            java.lang.Exception r2 = (java.lang.Exception) r2
            r0.getClass()
            int r3 = j1.l0.f8453a
            b2.y r0 = r0.f2512b
            m1.k0 r0 = (m1.k0) r0
            m1.n0 r0 = r0.f10314h
            n1.a r0 = r0.f10394r
            n1.x r0 = (n1.x) r0
            n1.b r3 = r0.c0()
            h3.j3 r4 = new h3.j3
            r4.<init>(r3, r2, r7)
            r2 = 1030(0x406, float:1.443E-42)
            r0.d0(r3, r2, r4)
            return
        L_0x01d5:
            java.lang.Object r0 = r1.f6201i
            android.support.v4.media.n r0 = (android.support.v4.media.n) r0
            java.lang.Object r0 = r0.f338j
            android.support.v4.media.h.y(r0)
            int r0 = w1.a.f16040k
            throw r4
        L_0x01e1:
            java.lang.Object r0 = r1.f6201i
            v1.r0 r0 = (v1.r0) r0
            java.lang.Object r4 = r1.f6202j
            d2.u0 r4 = (d2.u0) r4
            n2.c r5 = r0.f15776y
            if (r5 != 0) goto L_0x01ef
            r5 = r4
            goto L_0x01f4
        L_0x01ef:
            d2.e0 r5 = new d2.e0
            r5.<init>(r2)
        L_0x01f4:
            r0.F = r5
            long r8 = r4.j()
            r0.G = r8
            boolean r5 = r0.M
            if (r5 != 0) goto L_0x0209
            long r8 = r4.j()
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0209
            r7 = 1
        L_0x0209:
            r0.H = r7
            if (r7 == 0) goto L_0x020e
            r6 = 7
        L_0x020e:
            r0.I = r6
            long r2 = r0.G
            boolean r4 = r4.f()
            boolean r5 = r0.H
            v1.u0 r6 = r0.f15765n
            r6.t(r2, r4, r5)
            boolean r2 = r0.C
            if (r2 != 0) goto L_0x0224
            r0.t()
        L_0x0224:
            return
        L_0x0225:
            java.lang.Object r0 = r1.f6201i
            r1.c r0 = (r1.c) r0
            java.lang.Object r2 = r1.f6202j
            android.net.Uri r2 = (android.net.Uri) r2
            r0.f13539p = r7
            r0.b(r2)
            return
        L_0x0233:
            java.lang.Object r0 = r1.f6201i
            p1.j r0 = (p1.j) r0
            java.lang.Object r2 = r1.f6202j
            g1.a0 r2 = (g1.a0) r2
            p1.k r3 = r0.f12471k
            int r4 = r3.f12486p
            if (r4 == 0) goto L_0x0258
            boolean r4 = r0.f12470j
            if (r4 == 0) goto L_0x0246
            goto L_0x0258
        L_0x0246:
            android.os.Looper r4 = r3.f12490t
            r4.getClass()
            p1.q r5 = r0.f12468h
            p1.n r2 = r3.g(r4, r5, r2, r7)
            r0.f12469i = r2
            java.util.Set r2 = r3.f12484n
            r2.add(r0)
        L_0x0258:
            return
        L_0x0259:
            java.lang.Object r0 = r1.f6201i
            android.media.AudioTrack r0 = (android.media.AudioTrack) r0
            java.lang.Object r2 = r1.f6202j
            j1.g r2 = (j1.g) r2
            java.lang.Object r3 = o1.e0.f11874d0
            r0.flush()     // Catch:{ all -> 0x0282 }
            r0.release()     // Catch:{ all -> 0x0282 }
            r2.b()
            java.lang.Object r3 = o1.e0.f11874d0
            monitor-enter(r3)
            int r0 = o1.e0.f11876f0     // Catch:{ all -> 0x027f }
            int r0 = r0 + r5
            o1.e0.f11876f0 = r0     // Catch:{ all -> 0x027f }
            if (r0 != 0) goto L_0x027d
            java.util.concurrent.ExecutorService r0 = o1.e0.f11875e0     // Catch:{ all -> 0x027f }
            r0.shutdown()     // Catch:{ all -> 0x027f }
            o1.e0.f11875e0 = r4     // Catch:{ all -> 0x027f }
        L_0x027d:
            monitor-exit(r3)     // Catch:{ all -> 0x027f }
            return
        L_0x027f:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x027f }
            throw r0
        L_0x0282:
            r0 = move-exception
            r2.b()
            java.lang.Object r2 = o1.e0.f11874d0
            monitor-enter(r2)
            int r3 = o1.e0.f11876f0     // Catch:{ all -> 0x0299 }
            int r3 = r3 + r5
            o1.e0.f11876f0 = r3     // Catch:{ all -> 0x0299 }
            if (r3 != 0) goto L_0x0297
            java.util.concurrent.ExecutorService r3 = o1.e0.f11875e0     // Catch:{ all -> 0x0299 }
            r3.shutdown()     // Catch:{ all -> 0x0299 }
            o1.e0.f11875e0 = r4     // Catch:{ all -> 0x0299 }
        L_0x0297:
            monitor-exit(r2)     // Catch:{ all -> 0x0299 }
            throw r0
        L_0x0299:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0299 }
            throw r0
        L_0x029c:
            java.lang.Object r0 = r1.f6201i
            android.support.v4.media.n r0 = (android.support.v4.media.n) r0
            java.lang.Object r2 = r1.f6202j
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.f338j
            m1.k0 r0 = (m1.k0) r0
            int r3 = j1.l0.f8453a
            m1.n0 r0 = r0.f10314h
            n1.a r0 = r0.f10394r
            n1.x r0 = (n1.x) r0
            n1.b r3 = r0.c0()
            n1.r r4 = new n1.r
            r4.<init>(r3, r2, r7)
            r2 = 1012(0x3f4, float:1.418E-42)
            r0.d0(r3, r2, r4)
            return
        L_0x02bf:
            java.lang.Object r0 = r1.f6201i
            m1.u0 r0 = (m1.u0) r0
            java.lang.Object r2 = r1.f6202j
            m1.m1 r2 = (m1.m1) r2
            r0.getClass()
            m1.u0.b(r2)     // Catch:{ p -> 0x02ce }
            return
        L_0x02ce:
            r0 = move-exception
            r2 = r0
            java.lang.String r0 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Unexpected error delivering message on external thread."
            j1.v.d(r0, r3, r2)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>(r2)
            throw r0
        L_0x02dd:
            java.lang.Object r0 = r1.f6201i
            r8 = r0
            m1.n0 r8 = (m1.n0) r8
            java.lang.Object r0 = r1.f6202j
            m1.r0 r0 = (m1.r0) r0
            int r4 = r8.H
            int r9 = r0.f10453c
            int r4 = r4 - r9
            r8.H = r4
            boolean r9 = r0.f10454d
            if (r9 == 0) goto L_0x02f7
            int r9 = r0.f10455e
            r8.I = r9
            r8.J = r6
        L_0x02f7:
            boolean r9 = r0.f10456f
            if (r9 == 0) goto L_0x02ff
            int r9 = r0.f10457g
            r8.K = r9
        L_0x02ff:
            if (r4 != 0) goto L_0x03b5
            m1.k1 r4 = r0.f10452b
            g1.u1 r4 = r4.f10316a
            m1.k1 r9 = r8.f10383i0
            g1.u1 r9 = r9.f10316a
            boolean r9 = r9.y()
            if (r9 != 0) goto L_0x031b
            boolean r9 = r4.y()
            if (r9 == 0) goto L_0x031b
            r8.f10385j0 = r5
            r9 = 0
            r8.f10387k0 = r9
        L_0x031b:
            boolean r5 = r4.y()
            if (r5 != 0) goto L_0x0356
            r5 = r4
            m1.n1 r5 = (m1.n1) r5
            g1.u1[] r5 = r5.f10410s
            java.util.List r5 = java.util.Arrays.asList(r5)
            int r9 = r5.size()
            java.util.ArrayList r10 = r8.f10391o
            int r10 = r10.size()
            if (r9 != r10) goto L_0x0338
            r9 = 1
            goto L_0x0339
        L_0x0338:
            r9 = 0
        L_0x0339:
            j1.a.e(r9)
            r9 = 0
        L_0x033d:
            int r10 = r5.size()
            if (r9 >= r10) goto L_0x0356
            java.util.ArrayList r10 = r8.f10391o
            java.lang.Object r10 = r10.get(r9)
            m1.m0 r10 = (m1.m0) r10
            java.lang.Object r11 = r5.get(r9)
            g1.u1 r11 = (g1.u1) r11
            r10.f10350b = r11
            int r9 = r9 + 1
            goto L_0x033d
        L_0x0356:
            boolean r5 = r8.J
            if (r5 == 0) goto L_0x03a2
            m1.k1 r5 = r0.f10452b
            v1.a0 r5 = r5.f10317b
            m1.k1 r9 = r8.f10383i0
            v1.a0 r9 = r9.f10317b
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x0376
            m1.k1 r5 = r0.f10452b
            long r9 = r5.f10319d
            m1.k1 r5 = r8.f10383i0
            long r11 = r5.f10333r
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0375
            goto L_0x0376
        L_0x0375:
            r6 = 0
        L_0x0376:
            if (r6 == 0) goto L_0x039f
            boolean r2 = r4.y()
            if (r2 != 0) goto L_0x039b
            m1.k1 r2 = r0.f10452b
            v1.a0 r2 = r2.f10317b
            boolean r2 = r2.a()
            if (r2 == 0) goto L_0x0389
            goto L_0x039b
        L_0x0389:
            m1.k1 r2 = r0.f10452b
            v1.a0 r3 = r2.f10317b
            long r9 = r2.f10319d
            java.lang.Object r2 = r3.f6678a
            g1.r1 r3 = r8.f10390n
            r4.p(r2, r3)
            long r2 = r3.f6546l
            long r9 = r9 + r2
            r2 = r9
            goto L_0x039f
        L_0x039b:
            m1.k1 r2 = r0.f10452b
            long r2 = r2.f10319d
        L_0x039f:
            r15 = r2
            r13 = r6
            goto L_0x03a4
        L_0x03a2:
            r15 = r2
            r13 = 0
        L_0x03a4:
            r8.J = r7
            m1.k1 r9 = r0.f10452b
            r10 = 1
            int r11 = r8.K
            r12 = 0
            int r14 = r8.I
            r17 = -1
            r18 = 0
            r8.u1(r9, r10, r11, r12, r13, r14, r15, r17, r18)
        L_0x03b5:
            return
        L_0x03b6:
            java.lang.Object r0 = r1.f6201i
            h9.k0 r0 = (h9.k0) r0
            java.lang.Object r2 = r1.f6202j
            h9.e0 r2 = (h9.e0) r2
            int r3 = j1.l0.f8453a
            java.lang.Object r0 = r0.f7762h
            boolean r0 = r0 instanceof h9.b
            if (r0 == 0) goto L_0x03c9
            r2.cancel(r7)
        L_0x03c9:
            return
        L_0x03ca:
            java.lang.Object r0 = r1.f6201i
            j1.z r0 = (j1.z) r0
            java.lang.Object r2 = r1.f6202j
            a2.f r2 = (a2.f) r2
            int r0 = r0.c()
            r2.a(r0)
            return
        L_0x03da:
            java.lang.Object r0 = r1.f6201i
            androidx.lifecycle.j r0 = (androidx.lifecycle.j) r0
            java.lang.Object r2 = r1.f6202j
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            java.lang.String r3 = "this$0"
            xa.j.f(r3, r0)
            java.lang.String r3 = "$runnable"
            xa.j.f(r3, r2)
            java.util.ArrayDeque r3 = r0.f1706d
            boolean r2 = r3.offer(r2)
            if (r2 == 0) goto L_0x03f8
            r0.a()
            return
        L_0x03f8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "cannot enqueue any more runnables"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0404:
            java.lang.Object r0 = r1.f6201i
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r1.f6202j
            z0.i r2 = (z0.i) r2
            z0.d r3 = z0.d.f17359a
            java.lang.String r3 = "$violation"
            xa.j.f(r3, r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Policy violation with PENALTY_DEATH in "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r3 = "FragmentStrictMode"
            android.util.Log.e(r3, r0, r2)
            throw r2
        L_0x0427:
            java.lang.Object r0 = r1.f6201i
            androidx.fragment.app.j r0 = (androidx.fragment.app.j) r0
            java.lang.Object r2 = r1.f6202j
            androidx.fragment.app.h2 r2 = (androidx.fragment.app.h2) r2
            androidx.fragment.app.c2 r3 = androidx.fragment.app.n.f1505f
            java.lang.String r3 = "$transitionInfo"
            xa.j.f(r3, r0)
            java.lang.String r3 = "$operation"
            xa.j.f(r3, r2)
            r0.b()
            r0 = 2
            boolean r0 = androidx.fragment.app.c1.I(r0)
            if (r0 == 0) goto L_0x0448
            r2.toString()
        L_0x0448:
            return
        L_0x0449:
            java.lang.Object r0 = r1.f6201i
            d0.p r0 = (d0.p) r0
            java.lang.Object r2 = r1.f6202j
            android.graphics.Typeface r2 = (android.graphics.Typeface) r2
            r0.d(r2)
            return
        L_0x0455:
            java.lang.Object r0 = r1.f6201i
            r2 = r0
            g.s0 r2 = (g.s0) r2
            java.lang.Object r0 = r1.f6202j
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            r2.getClass()
            r0.run()     // Catch:{ all -> 0x0468 }
            r2.b()
            return
        L_0x0468:
            r0 = move-exception
            r3 = r0
            r2.b()
            throw r3
        L_0x046e:
            java.lang.Object r0 = r1.f6201i
            androidx.profileinstaller.ProfileInstallerInitializer r0 = (androidx.profileinstaller.ProfileInstallerInitializer) r0
            java.lang.Object r2 = r1.f6202j
            android.content.Context r2 = (android.content.Context) r2
            r0.getClass()
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r0 < r3) goto L_0x0488
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            android.os.Handler r0 = p3.l.a(r0)
            goto L_0x0491
        L_0x0488:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            r0.<init>(r3)
        L_0x0491:
            java.util.Random r3 = new java.util.Random
            r3.<init>()
            r4 = 1000(0x3e8, float:1.401E-42)
            int r4 = java.lang.Math.max(r4, r6)
            int r3 = r3.nextInt(r4)
            p3.i r4 = new p3.i
            r4.<init>(r2, r7)
            int r3 = r3 + 5000
            long r2 = (long) r3
            r0.postDelayed(r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.r0.run():void");
    }
}
