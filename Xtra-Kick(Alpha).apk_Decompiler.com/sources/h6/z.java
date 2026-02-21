package h6;

import android.content.Context;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class z extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f7701i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f7702j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f7703k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f7704l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerViewModel f7705m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f7706n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f7707o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(int i10, Context context, String str, ChannelPagerViewModel channelPagerViewModel, String str2, String str3, e eVar) {
        super(2, eVar);
        this.f7702j = i10;
        this.f7703k = context;
        this.f7704l = str;
        this.f7705m = channelPagerViewModel;
        this.f7706n = str2;
        this.f7707o = str3;
    }

    public final e create(Object obj, e eVar) {
        return new z(this.f7702j, this.f7703k, this.f7704l, this.f7705m, this.f7706n, this.f7707o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((z) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|(1:14)(1:15)|(1:17)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0089 A[Catch:{ Exception -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008d A[Catch:{ Exception -> 0x009b }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            android.content.Context r0 = r9.f7703k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r9.f7701i
            r3 = 0
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel r4 = r9.f7705m
            r5 = 1
            if (r2 == 0) goto L_0x001b
            if (r2 != r5) goto L_0x0013
            hb.h0.O1(r10)     // Catch:{ Exception -> 0x009b }
            goto L_0x008e
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001b:
            hb.h0.O1(r10)
            int r10 = r9.f7702j
            if (r10 == 0) goto L_0x00a3
            com.bumptech.glide.s r2 = com.bumptech.glide.c.e(r0)     // Catch:{ Exception -> 0x0039 }
            com.bumptech.glide.q r2 = r2.m()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r6 = r9.f7704l     // Catch:{ Exception -> 0x0039 }
            com.bumptech.glide.q r2 = r2.F(r6)     // Catch:{ Exception -> 0x0039 }
            h6.y r6 = new h6.y     // Catch:{ Exception -> 0x0039 }
            r7 = 0
            r6.<init>(r0, r10, r7)     // Catch:{ Exception -> 0x0039 }
            r2.D(r6)     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x009b }
            java.io.File r0 = r0.getFilesDir()     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x009b }
            java.lang.String r6 = java.io.File.separator     // Catch:{ Exception -> 0x009b }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009b }
            r7.<init>()     // Catch:{ Exception -> 0x009b }
            r7.append(r0)     // Catch:{ Exception -> 0x009b }
            r7.append(r6)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = "profile_pics"
            r7.append(r0)     // Catch:{ Exception -> 0x009b }
            r7.append(r6)     // Catch:{ Exception -> 0x009b }
            r7.append(r10)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = ".png"
            r7.append(r0)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x009b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x009b }
            java.lang.String r0 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x009b }
            e6.y0 r2 = r4.f3339e     // Catch:{ Exception -> 0x009b }
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r6 = new com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel     // Catch:{ Exception -> 0x009b }
            java.lang.String r7 = r9.f7706n     // Catch:{ Exception -> 0x009b }
            java.lang.String r8 = r9.f7707o     // Catch:{ Exception -> 0x009b }
            r6.<init>(r10, r7, r8, r0)     // Catch:{ Exception -> 0x009b }
            r9.f7701i = r5     // Catch:{ Exception -> 0x009b }
            r2.getClass()     // Catch:{ Exception -> 0x009b }
            nb.d r10 = hb.p0.f7834b     // Catch:{ Exception -> 0x009b }
            e6.w0 r0 = new e6.w0     // Catch:{ Exception -> 0x009b }
            r0.<init>(r2, r6, r3)     // Catch:{ Exception -> 0x009b }
            java.lang.Object r10 = hb.h0.c2(r10, r0, r9)     // Catch:{ Exception -> 0x009b }
            if (r10 != r1) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            la.v r10 = la.v.f9814a     // Catch:{ Exception -> 0x009b }
        L_0x008b:
            if (r10 != r1) goto L_0x008e
            return r1
        L_0x008e:
            androidx.lifecycle.o0 r10 = r4.f3343i     // Catch:{ Exception -> 0x009b }
            la.i r0 = new la.i     // Catch:{ Exception -> 0x009b }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x009b }
            r0.<init>(r1, r3)     // Catch:{ Exception -> 0x009b }
            r10.j(r0)     // Catch:{ Exception -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r10 = move-exception
            java.lang.String r0 = "NOP"
            java.lang.String r1 = "error: "
            android.util.Log.e(r0, r1, r10)
        L_0x00a3:
            la.v r10 = la.v.f9814a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.z.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
