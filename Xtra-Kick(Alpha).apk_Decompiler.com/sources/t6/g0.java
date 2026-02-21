package t6;

import android.content.Context;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class g0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f14592i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f14593j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f14594k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f14595l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ i0 f14596m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f14597n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f14598o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(int i10, Context context, String str, i0 i0Var, String str2, String str3, e eVar) {
        super(2, eVar);
        this.f14593j = i10;
        this.f14594k = context;
        this.f14595l = str;
        this.f14596m = i0Var;
        this.f14597n = str2;
        this.f14598o = str3;
    }

    public final e create(Object obj, e eVar) {
        return new g0(this.f14593j, this.f14594k, this.f14595l, this.f14596m, this.f14597n, this.f14598o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((g0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|(1:14)(1:15)|(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0087 A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088 A[Catch:{ Exception -> 0x0099 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008c A[Catch:{ Exception -> 0x0099 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f14594k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r9.f14592i
            r3 = 0
            t6.i0 r4 = r9.f14596m
            r5 = 1
            if (r2 == 0) goto L_0x001b
            if (r2 != r5) goto L_0x0013
            hb.h0.O1(r10)     // Catch:{ Exception -> 0x0099 }
            goto L_0x008d
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001b:
            hb.h0.O1(r10)
            int r10 = r9.f14593j
            if (r10 == 0) goto L_0x0099
            com.bumptech.glide.s r2 = com.bumptech.glide.c.e(r0)     // Catch:{ Exception -> 0x0038 }
            com.bumptech.glide.q r2 = r2.m()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r6 = r9.f14595l     // Catch:{ Exception -> 0x0038 }
            com.bumptech.glide.q r2 = r2.F(r6)     // Catch:{ Exception -> 0x0038 }
            h6.y r6 = new h6.y     // Catch:{ Exception -> 0x0038 }
            r6.<init>(r0, r10, r5)     // Catch:{ Exception -> 0x0038 }
            r2.D(r6)     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0099 }
            java.io.File r0 = r0.getFilesDir()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0099 }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x0099 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
            r7.<init>()     // Catch:{ Exception -> 0x0099 }
            r7.append(r0)     // Catch:{ Exception -> 0x0099 }
            r7.append(r6)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r0 = "profile_pics"
            r7.append(r0)     // Catch:{ Exception -> 0x0099 }
            r7.append(r6)     // Catch:{ Exception -> 0x0099 }
            r7.append(r10)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r0 = ".png"
            r7.append(r0)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x0099 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0099 }
            java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x0099 }
            e6.y0 r2 = r4.f14604e     // Catch:{ Exception -> 0x0099 }
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r6 = new com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel     // Catch:{ Exception -> 0x0099 }
            java.lang.String r7 = r9.f14597n     // Catch:{ Exception -> 0x0099 }
            java.lang.String r8 = r9.f14598o     // Catch:{ Exception -> 0x0099 }
            r6.<init>(r10, r7, r8, r0)     // Catch:{ Exception -> 0x0099 }
            r9.f14592i = r5     // Catch:{ Exception -> 0x0099 }
            r2.getClass()     // Catch:{ Exception -> 0x0099 }
            nb.d r10 = hb.p0.f7834b     // Catch:{ Exception -> 0x0099 }
            e6.w0 r0 = new e6.w0     // Catch:{ Exception -> 0x0099 }
            r0.<init>(r2, r6, r3)     // Catch:{ Exception -> 0x0099 }
            java.lang.Object r10 = hb.h0.c2(r10, r0, r9)     // Catch:{ Exception -> 0x0099 }
            if (r10 != r1) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            la.v r10 = la.v.f9814a     // Catch:{ Exception -> 0x0099 }
        L_0x008a:
            if (r10 != r1) goto L_0x008d
            return r1
        L_0x008d:
            androidx.lifecycle.o0 r10 = r4.f14609j     // Catch:{ Exception -> 0x0099 }
            la.i r0 = new la.i     // Catch:{ Exception -> 0x0099 }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0099 }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x0099 }
            r10.j(r0)     // Catch:{ Exception -> 0x0099 }
        L_0x0099:
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
