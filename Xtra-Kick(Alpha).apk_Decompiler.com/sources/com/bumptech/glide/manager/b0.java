package com.bumptech.glide.manager;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import d5.v;
import java.util.HashSet;
import m1.a;
import m1.k0;
import p1.i0;
import s1.b;
import s1.l;

public final class b0 implements l {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b0 f3255d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f3256a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f3257b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3258c;

    public b0(int i10) {
        b bVar = new b(i10, 0);
        b bVar2 = new b(i10, 1);
        this.f3257b = bVar;
        this.f3258c = bVar2;
        this.f3256a = false;
    }

    public static b0 c(Context context) {
        if (f3255d == null) {
            synchronized (b0.class) {
                if (f3255d == null) {
                    f3255d = new b0(context.getApplicationContext());
                }
            }
        }
        return f3255d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final s1.c a(s1.k r7) {
        /*
            r6 = this;
            java.lang.String r0 = "createCodec:"
            s1.q r1 = r7.f14027a
            java.lang.String r1 = r1.f14033a
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0047 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0047 }
            r3.append(r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0047 }
            j1.i0.a(r0)     // Catch:{ Exception -> 0x0047 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x0047 }
            s1.c r1 = new s1.c     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r3 = r6.f3257b     // Catch:{ Exception -> 0x0045 }
            c9.w r3 = (c9.w) r3     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x0045 }
            android.os.HandlerThread r3 = (android.os.HandlerThread) r3     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r4 = r6.f3258c     // Catch:{ Exception -> 0x0045 }
            c9.w r4 = (c9.w) r4     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0045 }
            android.os.HandlerThread r4 = (android.os.HandlerThread) r4     // Catch:{ Exception -> 0x0045 }
            boolean r5 = r6.f3256a     // Catch:{ Exception -> 0x0045 }
            r1.<init>(r0, r3, r4, r5)     // Catch:{ Exception -> 0x0045 }
            j1.i0.b()     // Catch:{ Exception -> 0x0042 }
            android.media.MediaFormat r2 = r7.f14028b     // Catch:{ Exception -> 0x0042 }
            android.view.Surface r3 = r7.f14030d     // Catch:{ Exception -> 0x0042 }
            android.media.MediaCrypto r7 = r7.f14031e     // Catch:{ Exception -> 0x0042 }
            s1.c.p(r1, r2, r3, r7)     // Catch:{ Exception -> 0x0042 }
            return r1
        L_0x0042:
            r7 = move-exception
            r2 = r1
            goto L_0x0049
        L_0x0045:
            r7 = move-exception
            goto L_0x0049
        L_0x0047:
            r7 = move-exception
            r0 = r2
        L_0x0049:
            if (r2 != 0) goto L_0x0051
            if (r0 == 0) goto L_0x0054
            r0.release()
            goto L_0x0054
        L_0x0051:
            r2.a()
        L_0x0054:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.manager.b0.a(s1.k):s1.c");
    }

    public final void d() {
        if (this.f3256a) {
            ((Context) this.f3257b).unregisterReceiver((a) this.f3258c);
            this.f3256a = false;
        }
    }

    public b0(Context context) {
        this.f3258c = new HashSet();
        v vVar = new v(new o(this, context));
        w wVar = new w(this);
        this.f3257b = Build.VERSION.SDK_INT >= 24 ? new i0(vVar, wVar) : new a0(context, vVar, wVar);
    }

    public b0(Context context, Handler handler, k0 k0Var) {
        this.f3257b = context.getApplicationContext();
        this.f3258c = new a(this, handler, k0Var);
    }
}
