package d5;

import android.support.v4.media.n;
import android.util.Log;
import b5.a;
import b5.j;
import com.bumptech.glide.load.data.e;
import h5.h0;
import java.io.IOException;
import java.util.ArrayList;

public final class t0 implements h, g {

    /* renamed from: h  reason: collision with root package name */
    public final i f4484h;

    /* renamed from: i  reason: collision with root package name */
    public final g f4485i;

    /* renamed from: j  reason: collision with root package name */
    public volatile int f4486j;

    /* renamed from: k  reason: collision with root package name */
    public volatile e f4487k;

    /* renamed from: l  reason: collision with root package name */
    public volatile Object f4488l;

    /* renamed from: m  reason: collision with root package name */
    public volatile h0 f4489m;

    /* renamed from: n  reason: collision with root package name */
    public volatile f f4490n;

    public t0(i iVar, g gVar) {
        this.f4484h = iVar;
        this.f4485i = gVar;
    }

    public final void a(j jVar, Object obj, e eVar, a aVar, j jVar2) {
        this.f4485i.a(jVar, obj, eVar, this.f4489m.f7577c.d(), jVar);
    }

    public final void b() {
        throw new UnsupportedOperationException();
    }

    public final boolean c() {
        boolean z10;
        boolean z11;
        if (this.f4488l != null) {
            Object obj = this.f4488l;
            this.f4488l = null;
            try {
                if (!e(obj)) {
                    return true;
                }
            } catch (IOException unused) {
                Log.isLoggable("SourceGenerator", 3);
            }
        }
        if (this.f4487k != null && this.f4487k.c()) {
            return true;
        }
        this.f4487k = null;
        this.f4489m = null;
        boolean z12 = false;
        while (!z12) {
            if (this.f4486j < this.f4484h.b().size()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                break;
            }
            ArrayList b10 = this.f4484h.b();
            int i10 = this.f4486j;
            this.f4486j = i10 + 1;
            this.f4489m = (h0) b10.get(i10);
            if (this.f4489m != null) {
                if (!this.f4484h.f4407p.c(this.f4489m.f7577c.d())) {
                    if (this.f4484h.c(this.f4489m.f7577c.a()) != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                    }
                }
                this.f4489m.f7577c.f(this.f4484h.f4406o, new n((Object) this, (Object) this.f4489m, 27));
                z12 = true;
            }
        }
        return z12;
    }

    public final void cancel() {
        h0 h0Var = this.f4489m;
        if (h0Var != null) {
            h0Var.f7577c.cancel();
        }
    }

    public final void d(j jVar, Exception exc, e eVar, a aVar) {
        this.f4485i.d(jVar, exc, eVar, this.f4489m.f7577c.d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.String r0 = "SourceGenerator"
            int r1 = w5.i.f16115a
            android.os.SystemClock.elapsedRealtimeNanos()
            r1 = 0
            d5.i r2 = r12.f4484h     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.h r2 = r2.f4394c     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.n r2 = r2.b()     // Catch:{ all -> 0x0056 }
            com.bumptech.glide.load.data.g r2 = r2.h(r13)     // Catch:{ all -> 0x0056 }
            java.lang.Object r5 = r2.e()     // Catch:{ all -> 0x0056 }
            d5.i r3 = r12.f4484h     // Catch:{ all -> 0x0056 }
            b5.d r9 = r3.e(r5)     // Catch:{ all -> 0x0056 }
            android.support.v4.media.session.u r10 = new android.support.v4.media.session.u     // Catch:{ all -> 0x0056 }
            d5.i r3 = r12.f4484h     // Catch:{ all -> 0x0056 }
            b5.n r6 = r3.f4400i     // Catch:{ all -> 0x0056 }
            r7 = 18
            r8 = 0
            r3 = r10
            r4 = r9
            r3.<init>((java.lang.Object) r4, (java.lang.Object) r5, (java.lang.Object) r6, (int) r7, (int) r8)     // Catch:{ all -> 0x0056 }
            d5.f r3 = new d5.f     // Catch:{ all -> 0x0056 }
            h5.h0 r4 = r12.f4489m     // Catch:{ all -> 0x0056 }
            b5.j r4 = r4.f7575a     // Catch:{ all -> 0x0056 }
            d5.i r5 = r12.f4484h     // Catch:{ all -> 0x0056 }
            b5.j r6 = r5.f4405n     // Catch:{ all -> 0x0056 }
            r3.<init>(r4, r6)     // Catch:{ all -> 0x0056 }
            d5.v r4 = r5.f4399h     // Catch:{ all -> 0x0056 }
            f5.a r4 = r4.a()     // Catch:{ all -> 0x0056 }
            r4.a(r3, r10)     // Catch:{ all -> 0x0056 }
            r5 = 2
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0056 }
            if (r5 == 0) goto L_0x0058
            r3.toString()     // Catch:{ all -> 0x0056 }
            r13.toString()     // Catch:{ all -> 0x0056 }
            r9.toString()     // Catch:{ all -> 0x0056 }
            android.os.SystemClock.elapsedRealtimeNanos()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            r13 = move-exception
            goto L_0x00a9
        L_0x0058:
            java.io.File r4 = r4.b(r3)     // Catch:{ all -> 0x0056 }
            r5 = 1
            if (r4 == 0) goto L_0x007a
            r12.f4490n = r3     // Catch:{ all -> 0x0056 }
            d5.e r13 = new d5.e     // Catch:{ all -> 0x0056 }
            h5.h0 r0 = r12.f4489m     // Catch:{ all -> 0x0056 }
            b5.j r0 = r0.f7575a     // Catch:{ all -> 0x0056 }
            java.util.List r0 = java.util.Collections.singletonList(r0)     // Catch:{ all -> 0x0056 }
            d5.i r2 = r12.f4484h     // Catch:{ all -> 0x0056 }
            r13.<init>(r0, r2, r12)     // Catch:{ all -> 0x0056 }
            r12.f4487k = r13     // Catch:{ all -> 0x0056 }
            h5.h0 r13 = r12.f4489m
            com.bumptech.glide.load.data.e r13 = r13.f7577c
            r13.c()
            return r5
        L_0x007a:
            r3 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0089
            d5.f r0 = r12.f4490n     // Catch:{ all -> 0x0056 }
            java.util.Objects.toString(r0)     // Catch:{ all -> 0x0056 }
            r13.toString()     // Catch:{ all -> 0x0056 }
        L_0x0089:
            d5.g r6 = r12.f4485i     // Catch:{ all -> 0x00a7 }
            h5.h0 r13 = r12.f4489m     // Catch:{ all -> 0x00a7 }
            b5.j r7 = r13.f7575a     // Catch:{ all -> 0x00a7 }
            java.lang.Object r8 = r2.e()     // Catch:{ all -> 0x00a7 }
            h5.h0 r13 = r12.f4489m     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.data.e r9 = r13.f7577c     // Catch:{ all -> 0x00a7 }
            h5.h0 r13 = r12.f4489m     // Catch:{ all -> 0x00a7 }
            com.bumptech.glide.load.data.e r13 = r13.f7577c     // Catch:{ all -> 0x00a7 }
            b5.a r10 = r13.d()     // Catch:{ all -> 0x00a7 }
            h5.h0 r13 = r12.f4489m     // Catch:{ all -> 0x00a7 }
            b5.j r11 = r13.f7575a     // Catch:{ all -> 0x00a7 }
            r6.a(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a7 }
            return r1
        L_0x00a7:
            r13 = move-exception
            r1 = 1
        L_0x00a9:
            if (r1 != 0) goto L_0x00b2
            h5.h0 r0 = r12.f4489m
            com.bumptech.glide.load.data.e r0 = r0.f7577c
            r0.c()
        L_0x00b2:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.t0.e(java.lang.Object):boolean");
    }
}
