package h3;

import android.os.Handler;
import android.os.Looper;

public final class j2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public boolean f7135a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f7136b = true;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n2 f7137c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j2(n2 n2Var, Looper looper) {
        super(looper);
        this.f7137c = n2Var;
    }

    public final void a(boolean z10, boolean z11) {
        boolean z12 = false;
        this.f7135a = this.f7135a && z10;
        if (this.f7136b && z11) {
            z12 = true;
        }
        this.f7136b = z12;
        if (!hasMessages(1)) {
            sendEmptyMessage(1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006b A[Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r19) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            int r2 = r0.what
            r3 = 1
            if (r2 != r3) goto L_0x00c9
            h3.n2 r2 = r1.f7137c
            h3.w3 r0 = r2.f7245r
            h3.a4 r4 = r2.f7246s
            g1.u1 r4 = r4.U0()
            h3.a4 r5 = r2.f7246s
            h3.i4 r5 = r5.S0()
            h3.u3 r0 = android.support.v4.media.h.g(r0, r0)
            r0.f7349j = r4
            r0.f7342c = r5
            h3.w3 r0 = r0.a()
            r2.f7245r = r0
            boolean r11 = r1.f7135a
            boolean r12 = r1.f7136b
            h3.s3 r13 = r2.f7233f
            h3.w3 r14 = r13.D0(r0)
            h3.g r15 = r13.f7319f
            d9.r0 r10 = r15.d()
            r0 = 0
            r9 = 0
        L_0x0039:
            int r0 = r10.size()
            if (r9 >= r0) goto L_0x00c4
            java.lang.Object r0 = r10.get(r9)
            r8 = r0
            h3.e2 r8 = (h3.e2) r8
            h3.e4 r0 = r15.f(r8)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            if (r0 == 0) goto L_0x0052
            int r0 = r0.a()     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            r5 = r0
            goto L_0x006d
        L_0x0052:
            h3.g r0 = r13.f7319f     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            boolean r0 = r0.g(r8)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            if (r0 != 0) goto L_0x0067
            h3.x2 r0 = r2.f7234g     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            h3.g r0 = r0.f7436f     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            boolean r0 = r0.g(r8)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            if (r0 == 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r0 = 0
            goto L_0x0068
        L_0x0067:
            r0 = 1
        L_0x0068:
            if (r0 != 0) goto L_0x006b
            goto L_0x00c4
        L_0x006b:
            r0 = 0
            r5 = 0
        L_0x006d:
            g1.g1 r0 = r15.c(r8)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            h3.a4 r4 = r2.f7246s     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            g1.g1 r4 = r4.w()     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            g1.g1 r7 = h3.t3.y(r0, r4)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            h3.d2 r4 = r8.f6998c     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            j1.a.f(r4)     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            int r0 = r8.f6997b     // Catch:{ DeadObjectException -> 0x00b1, RemoteException -> 0x0092 }
            r6 = r14
            r19 = r8
            r8 = r11
            r16 = r9
            r9 = r12
            r17 = r10
            r10 = r0
            r4.o(r5, r6, r7, r8, r9, r10)     // Catch:{ DeadObjectException -> 0x00b7, RemoteException -> 0x0090 }
            goto L_0x00be
        L_0x0090:
            r0 = move-exception
            goto L_0x0099
        L_0x0092:
            r0 = move-exception
            r19 = r8
            r16 = r9
            r17 = r10
        L_0x0099:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Exception in "
            r4.<init>(r5)
            java.lang.String r5 = r19.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "MSImplBase"
            j1.v.h(r5, r4, r0)
            goto L_0x00be
        L_0x00b1:
            r19 = r8
            r16 = r9
            r17 = r10
        L_0x00b7:
            h3.g r0 = r13.f7319f
            r4 = r19
            r0.k(r4)
        L_0x00be:
            int r9 = r16 + 1
            r10 = r17
            goto L_0x0039
        L_0x00c4:
            r1.f7135a = r3
            r1.f7136b = r3
            return
        L_0x00c9:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid message what="
            r3.<init>(r4)
            int r0 = r0.what
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.j2.handleMessage(android.os.Message):void");
    }
}
