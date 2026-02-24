package h6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class a0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public String f7632i;

    /* renamed from: j  reason: collision with root package name */
    public int f7633j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ User f7634k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f7635l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ ChannelPagerViewModel f7636m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a0(User user, Context context, ChannelPagerViewModel channelPagerViewModel, e eVar) {
        super(2, eVar);
        this.f7634k = user;
        this.f7635l = context;
        this.f7636m = channelPagerViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new a0(this.f7634k, this.f7635l, this.f7636m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:16|17|18|19|20|21|22|(1:24)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A[Catch:{ Exception -> 0x0144 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3 A[Catch:{ Exception -> 0x0144 }, LOOP:0: B:32:0x00dd->B:34:0x00e3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x011a A[Catch:{ Exception -> 0x0144 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127 A[Catch:{ Exception -> 0x0144 }, LOOP:1: B:39:0x0121->B:41:0x0127, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            android.content.Context r0 = r11.f7635l
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r11.f7633j
            r3 = 0
            r4 = 3
            r5 = 1
            r6 = 2
            com.github.andreyasadchy.xtra.ui.channel.ChannelPagerViewModel r7 = r11.f7636m
            com.github.andreyasadchy.xtra.model.ui.User r8 = r11.f7634k
            if (r2 == 0) goto L_0x0032
            if (r2 == r5) goto L_0x002c
            if (r2 == r6) goto L_0x0025
            if (r2 != r4) goto L_0x001d
            java.lang.String r0 = r11.f7632i
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x0144 }
            goto L_0x011b
        L_0x001d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0025:
            java.lang.String r0 = r11.f7632i
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x0144 }
            goto L_0x00d7
        L_0x002c:
            java.lang.String r0 = r11.f7632i
            hb.h0.O1(r12)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0097
        L_0x0032:
            hb.h0.O1(r12)
            r8.getChannelId()     // Catch:{ Exception -> 0x0144 }
            com.bumptech.glide.s r12 = com.bumptech.glide.c.e(r0)     // Catch:{ Exception -> 0x0050 }
            com.bumptech.glide.q r12 = r12.m()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = r8.getChannelLogo()     // Catch:{ Exception -> 0x0050 }
            com.bumptech.glide.q r12 = r12.F(r2)     // Catch:{ Exception -> 0x0050 }
            s7.c r2 = new s7.c     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r6, r0, r8)     // Catch:{ Exception -> 0x0050 }
            r12.D(r2)     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x0144 }
            java.io.File r0 = r0.getFilesDir()     // Catch:{ Exception -> 0x0144 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0144 }
            java.lang.String r2 = java.io.File.separator     // Catch:{ Exception -> 0x0144 }
            int r9 = r8.getChannelId()     // Catch:{ Exception -> 0x0144 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0144 }
            r10.<init>()     // Catch:{ Exception -> 0x0144 }
            r10.append(r0)     // Catch:{ Exception -> 0x0144 }
            r10.append(r2)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r0 = "profile_pics"
            r10.append(r0)     // Catch:{ Exception -> 0x0144 }
            r10.append(r2)     // Catch:{ Exception -> 0x0144 }
            r10.append(r9)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r0 = ".png"
            r10.append(r0)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r0 = r10.toString()     // Catch:{ Exception -> 0x0144 }
            r12.<init>(r0)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x0144 }
            e6.y0 r12 = r7.f3339e     // Catch:{ Exception -> 0x0144 }
            int r2 = r8.getChannelId()     // Catch:{ Exception -> 0x0144 }
            r11.f7632i = r0     // Catch:{ Exception -> 0x0144 }
            r11.f7633j = r5     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r12 = r12.a(r2, r11)     // Catch:{ Exception -> 0x0144 }
            if (r12 != r1) goto L_0x0097
            return r1
        L_0x0097:
            com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel r12 = (com.github.andreyasadchy.xtra.model.offline.LocalFollowChannel) r12     // Catch:{ Exception -> 0x0144 }
            if (r12 == 0) goto L_0x00bc
            e6.y0 r2 = r7.f3339e     // Catch:{ Exception -> 0x0144 }
            java.lang.String r5 = r8.getChannelSlug()     // Catch:{ Exception -> 0x0144 }
            r12.setUserLogin(r5)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r5 = r8.getChannelName()     // Catch:{ Exception -> 0x0144 }
            r12.setUserName(r5)     // Catch:{ Exception -> 0x0144 }
            r12.setChannelLogo(r0)     // Catch:{ Exception -> 0x0144 }
            r2.getClass()     // Catch:{ Exception -> 0x0144 }
            hb.d1 r5 = hb.d1.f7786h     // Catch:{ Exception -> 0x0144 }
            e6.x0 r9 = new e6.x0     // Catch:{ Exception -> 0x0144 }
            r9.<init>(r2, r12, r3)     // Catch:{ Exception -> 0x0144 }
            r12 = 0
            hb.h0.b1(r5, r3, r12, r9, r4)     // Catch:{ Exception -> 0x0144 }
        L_0x00bc:
            e6.o1 r12 = r7.f3340f     // Catch:{ Exception -> 0x0144 }
            int r2 = r8.getChannelId()     // Catch:{ Exception -> 0x0144 }
            r11.f7632i = r0     // Catch:{ Exception -> 0x0144 }
            r11.f7633j = r6     // Catch:{ Exception -> 0x0144 }
            r12.getClass()     // Catch:{ Exception -> 0x0144 }
            nb.d r5 = hb.p0.f7834b     // Catch:{ Exception -> 0x0144 }
            e6.i1 r6 = new e6.i1     // Catch:{ Exception -> 0x0144 }
            r6.<init>(r12, r2, r3)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r12 = hb.h0.c2(r5, r6, r11)     // Catch:{ Exception -> 0x0144 }
            if (r12 != r1) goto L_0x00d7
            return r1
        L_0x00d7:
            java.util.List r12 = (java.util.List) r12     // Catch:{ Exception -> 0x0144 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0144 }
        L_0x00dd:
            boolean r2 = r12.hasNext()     // Catch:{ Exception -> 0x0144 }
            if (r2 == 0) goto L_0x0100
            java.lang.Object r2 = r12.next()     // Catch:{ Exception -> 0x0144 }
            com.github.andreyasadchy.xtra.model.offline.OfflineVideo r2 = (com.github.andreyasadchy.xtra.model.offline.OfflineVideo) r2     // Catch:{ Exception -> 0x0144 }
            e6.o1 r5 = r7.f3340f     // Catch:{ Exception -> 0x0144 }
            java.lang.String r6 = r8.getChannelSlug()     // Catch:{ Exception -> 0x0144 }
            r2.setChannelLogin(r6)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r6 = r8.getChannelName()     // Catch:{ Exception -> 0x0144 }
            r2.setChannelName(r6)     // Catch:{ Exception -> 0x0144 }
            r2.setChannelLogo(r0)     // Catch:{ Exception -> 0x0144 }
            r5.b(r2)     // Catch:{ Exception -> 0x0144 }
            goto L_0x00dd
        L_0x0100:
            e6.e0 r12 = r7.f3341g     // Catch:{ Exception -> 0x0144 }
            int r2 = r8.getChannelId()     // Catch:{ Exception -> 0x0144 }
            r11.f7632i = r0     // Catch:{ Exception -> 0x0144 }
            r11.f7633j = r4     // Catch:{ Exception -> 0x0144 }
            r12.getClass()     // Catch:{ Exception -> 0x0144 }
            nb.d r4 = hb.p0.f7834b     // Catch:{ Exception -> 0x0144 }
            e6.a0 r5 = new e6.a0     // Catch:{ Exception -> 0x0144 }
            r5.<init>(r12, r2, r3)     // Catch:{ Exception -> 0x0144 }
            java.lang.Object r12 = hb.h0.c2(r4, r5, r11)     // Catch:{ Exception -> 0x0144 }
            if (r12 != r1) goto L_0x011b
            return r1
        L_0x011b:
            java.util.List r12 = (java.util.List) r12     // Catch:{ Exception -> 0x0144 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x0144 }
        L_0x0121:
            boolean r1 = r12.hasNext()     // Catch:{ Exception -> 0x0144 }
            if (r1 == 0) goto L_0x0144
            java.lang.Object r1 = r12.next()     // Catch:{ Exception -> 0x0144 }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r1 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r1     // Catch:{ Exception -> 0x0144 }
            e6.e0 r2 = r7.f3341g     // Catch:{ Exception -> 0x0144 }
            java.lang.String r3 = r8.getChannelSlug()     // Catch:{ Exception -> 0x0144 }
            r1.setUserLogin(r3)     // Catch:{ Exception -> 0x0144 }
            java.lang.String r3 = r8.getChannelName()     // Catch:{ Exception -> 0x0144 }
            r1.setUserName(r3)     // Catch:{ Exception -> 0x0144 }
            r1.setUserLogo(r0)     // Catch:{ Exception -> 0x0144 }
            r2.d(r1)     // Catch:{ Exception -> 0x0144 }
            goto L_0x0121
        L_0x0144:
            la.v r12 = la.v.f9814a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: h6.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
