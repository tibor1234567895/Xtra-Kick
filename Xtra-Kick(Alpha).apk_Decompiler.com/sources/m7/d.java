package m7;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.Video;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class d extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f10684i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Video f10685j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ e f10686k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f10687l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Video video, e eVar, Context context, e eVar2) {
        super(2, eVar2);
        this.f10685j = video;
        this.f10686k = eVar;
        this.f10687l = context;
    }

    public final e create(Object obj, e eVar) {
        return new d(this.f10685j, this.f10686k, this.f10687l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((d) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:21|(1:25)|(2:27|28)|30|(2:32|33)|34|35|(1:37)|38|41|(0)(0)|45|(0)(0)|(0)(0)|52|(0)|(0)|57|58) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x009d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd A[Catch:{ Exception -> 0x00c7 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            r30 = this;
            r0 = r30
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f10684i
            r3 = 3
            r4 = 2
            r5 = 1
            m7.e r6 = r0.f10686k
            r7 = 0
            android.content.Context r8 = r0.f10687l
            com.github.andreyasadchy.xtra.model.ui.Video r9 = r0.f10685j
            if (r2 == 0) goto L_0x0032
            if (r2 == r5) goto L_0x002c
            if (r2 == r4) goto L_0x0025
            if (r2 != r3) goto L_0x001d
            hb.h0.O1(r31)
            goto L_0x01a2
        L_0x001d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0025:
            hb.h0.O1(r31)     // Catch:{ Exception -> 0x00c7 }
            r2 = r31
            goto L_0x00be
        L_0x002c:
            hb.h0.O1(r31)
            r2 = r31
            goto L_0x0046
        L_0x0032:
            hb.h0.O1(r31)
            java.lang.String r2 = r9.getUuid()
            if (r2 == 0) goto L_0x0049
            e6.e0 r10 = r6.f10688d
            r0.f10684i = r5
            java.lang.Object r2 = r10.b(r2, r0)
            if (r2 != r1) goto L_0x0046
            return r1
        L_0x0046:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r2 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r2
            goto L_0x004a
        L_0x0049:
            r2 = r7
        L_0x004a:
            if (r2 == 0) goto L_0x0053
            e6.e0 r1 = r6.f10688d
            r1.a(r8, r2)
            goto L_0x01a2
        L_0x0053:
            java.lang.String r2 = r9.getUuid()
            if (r2 == 0) goto L_0x0061
            boolean r2 = fb.w.h(r2)
            if (r2 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r5 = 0
        L_0x0061:
            if (r5 != 0) goto L_0x007e
            com.bumptech.glide.s r2 = com.bumptech.glide.c.e(r8)     // Catch:{ Exception -> 0x007d }
            com.bumptech.glide.q r2 = r2.m()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r9.getThumbnail()     // Catch:{ Exception -> 0x007d }
            com.bumptech.glide.q r2 = r2.F(r5)     // Catch:{ Exception -> 0x007d }
            x6.m r5 = new x6.m     // Catch:{ Exception -> 0x007d }
            r10 = 4
            r5.<init>(r8, r9, r10)     // Catch:{ Exception -> 0x007d }
            r2.D(r5)     // Catch:{ Exception -> 0x007d }
            goto L_0x007e
        L_0x007d:
        L_0x007e:
            int r2 = r9.getChannelId()
            if (r2 == 0) goto L_0x009d
            com.bumptech.glide.s r2 = com.bumptech.glide.c.e(r8)     // Catch:{ Exception -> 0x009d }
            com.bumptech.glide.q r2 = r2.m()     // Catch:{ Exception -> 0x009d }
            java.lang.String r5 = r9.getChannelLogo()     // Catch:{ Exception -> 0x009d }
            com.bumptech.glide.q r2 = r2.F(r5)     // Catch:{ Exception -> 0x009d }
            x6.m r5 = new x6.m     // Catch:{ Exception -> 0x009d }
            r10 = 5
            r5.<init>(r8, r9, r10)     // Catch:{ Exception -> 0x009d }
            r2.D(r5)     // Catch:{ Exception -> 0x009d }
        L_0x009d:
            int r2 = r9.getChannelId()     // Catch:{ Exception -> 0x00c7 }
            e6.x r5 = r6.f10689e     // Catch:{ Exception -> 0x00c7 }
            java.lang.Integer r10 = new java.lang.Integer     // Catch:{ Exception -> 0x00c7 }
            r10.<init>(r2)     // Catch:{ Exception -> 0x00c7 }
            ma.q.b(r10)     // Catch:{ Exception -> 0x00c7 }
            r0.f10684i = r4     // Catch:{ Exception -> 0x00c7 }
            r5.getClass()     // Catch:{ Exception -> 0x00c7 }
            nb.d r2 = hb.p0.f7834b     // Catch:{ Exception -> 0x00c7 }
            e6.t r4 = new e6.t     // Catch:{ Exception -> 0x00c7 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x00c7 }
            java.lang.Object r2 = hb.h0.c2(r2, r4, r0)     // Catch:{ Exception -> 0x00c7 }
            if (r2 != r1) goto L_0x00be
            return r1
        L_0x00be:
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x00c7 }
            java.lang.Object r2 = ma.z.u(r2)     // Catch:{ Exception -> 0x00c7 }
            com.github.andreyasadchy.xtra.model.ui.User r2 = (com.github.andreyasadchy.xtra.model.ui.User) r2     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00c9
        L_0x00c7:
            r2 = r7
        L_0x00c9:
            java.lang.String r4 = r9.getUuid()
            java.lang.String r5 = ".png"
            if (r4 == 0) goto L_0x0104
            java.io.File r10 = new java.io.File
            java.io.File r11 = r8.getFilesDir()
            java.lang.String r11 = r11.toString()
            java.lang.String r12 = java.io.File.separator
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r11)
            r13.append(r12)
            java.lang.String r11 = "thumbnails"
            r13.append(r11)
            r13.append(r12)
            r13.append(r4)
            r13.append(r5)
            java.lang.String r4 = r13.toString()
            r10.<init>(r4)
            java.lang.String r4 = r10.getAbsolutePath()
            r24 = r4
            goto L_0x0106
        L_0x0104:
            r24 = r7
        L_0x0106:
            int r4 = r9.getChannelId()
            java.io.File r10 = new java.io.File
            java.io.File r8 = r8.getFilesDir()
            java.lang.String r8 = r8.toString()
            java.lang.String r11 = java.io.File.separator
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r8)
            r12.append(r11)
            java.lang.String r8 = "profile_pics"
            r12.append(r8)
            r12.append(r11)
            r12.append(r4)
            r12.append(r5)
            java.lang.String r4 = r12.toString()
            r10.<init>(r4)
            java.lang.String r17 = r10.getAbsolutePath()
            e6.e0 r4 = r6.f10688d
            com.github.andreyasadchy.xtra.model.offline.Bookmark r5 = new com.github.andreyasadchy.xtra.model.offline.Bookmark
            java.lang.String r11 = r9.getUuid()
            int r12 = r9.getChannelId()
            java.lang.String r13 = r9.getChannelSlug()
            java.lang.String r14 = r9.getChannelName()
            if (r2 == 0) goto L_0x0156
            java.lang.String r6 = r2.getType()
            r15 = r6
            goto L_0x0157
        L_0x0156:
            r15 = r7
        L_0x0157:
            if (r2 == 0) goto L_0x0160
            java.lang.String r2 = r2.getBroadcasterType()
            r16 = r2
            goto L_0x0162
        L_0x0160:
            r16 = r7
        L_0x0162:
            int r18 = r9.getGameId()
            java.lang.String r19 = r9.getGameName()
            r20 = 0
            r21 = 0
            java.lang.String r22 = r9.getTitle()
            java.lang.String r23 = r9.getUploadDate()
            java.lang.String r25 = r9.getType()
            java.lang.String r26 = r9.getDuration()
            java.lang.String r27 = r9.getAnimatedPreviewURL()
            r28 = 1536(0x600, float:2.152E-42)
            r29 = 0
            r10 = r5
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r0.f10684i = r3
            r4.getClass()
            nb.d r2 = hb.p0.f7834b
            e6.c0 r3 = new e6.c0
            r3.<init>(r4, r5, r7)
            java.lang.Object r2 = hb.h0.c2(r2, r3, r0)
            if (r2 != r1) goto L_0x019d
            goto L_0x019f
        L_0x019d:
            la.v r2 = la.v.f9814a
        L_0x019f:
            if (r2 != r1) goto L_0x01a2
            return r1
        L_0x01a2:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m7.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
