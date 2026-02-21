package z6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import hb.f0;
import java.util.Iterator;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class k extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Iterator f17767i;

    /* renamed from: j  reason: collision with root package name */
    public Iterator f17768j;

    /* renamed from: k  reason: collision with root package name */
    public Video f17769k;

    /* renamed from: l  reason: collision with root package name */
    public int f17770l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BookmarksViewModel f17771m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Context f17772n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(BookmarksViewModel bookmarksViewModel, Context context, e eVar) {
        super(2, eVar);
        this.f17771m = bookmarksViewModel;
        this.f17772n = context;
    }

    public final e create(Object obj, e eVar) {
        return new k(this.f17771m, this.f17772n, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((k) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:66|67|68|69|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(1:86)|87|(1:89)|90) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x016a */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cd A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00df A[Catch:{ Exception -> 0x022a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e0 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f4 A[SYNTHETIC, Splitter:B:51:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b4 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c0 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01e4 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f0 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01fc A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0208 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0214 A[Catch:{ Exception -> 0x022a }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            r34 = this;
            r0 = r34
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f17770l
            r3 = 0
            r4 = 2
            r5 = 3
            r6 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r6) goto L_0x0032
            if (r2 == r4) goto L_0x0028
            if (r2 != r5) goto L_0x0020
            com.github.andreyasadchy.xtra.model.ui.Video r2 = r0.f17769k
            java.util.Iterator r6 = r0.f17768j
            java.util.Iterator r7 = r0.f17767i
            hb.h0.O1(r35)     // Catch:{ Exception -> 0x022a }
            r9 = r35
            r8 = r0
            goto L_0x00e6
        L_0x0020:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0028:
            java.util.Iterator r2 = r0.f17767i
            hb.h0.O1(r35)     // Catch:{ Exception -> 0x022a }
            r7 = r35
            r6 = r0
            goto L_0x00ae
        L_0x0032:
            hb.h0.O1(r35)     // Catch:{ Exception -> 0x022a }
            r2 = r35
            goto L_0x0052
        L_0x0038:
            hb.h0.O1(r35)
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r2 = r0.f17771m     // Catch:{ Exception -> 0x022a }
            e6.e0 r2 = r2.f3458e     // Catch:{ Exception -> 0x022a }
            r0.f17770l = r6     // Catch:{ Exception -> 0x022a }
            r2.getClass()     // Catch:{ Exception -> 0x022a }
            nb.d r7 = hb.p0.f7834b     // Catch:{ Exception -> 0x022a }
            e6.b0 r8 = new e6.b0     // Catch:{ Exception -> 0x022a }
            r8.<init>(r2, r3)     // Catch:{ Exception -> 0x022a }
            java.lang.Object r2 = hb.h0.c2(r7, r8, r0)     // Catch:{ Exception -> 0x022a }
            if (r2 != r1) goto L_0x0052
            return r1
        L_0x0052:
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x022a }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x022a }
            r7.<init>()     // Catch:{ Exception -> 0x022a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x022a }
        L_0x005d:
            boolean r8 = r2.hasNext()     // Catch:{ Exception -> 0x022a }
            if (r8 == 0) goto L_0x0073
            java.lang.Object r8 = r2.next()     // Catch:{ Exception -> 0x022a }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r8 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r8     // Catch:{ Exception -> 0x022a }
            java.lang.String r8 = r8.getVideoId()     // Catch:{ Exception -> 0x022a }
            if (r8 == 0) goto L_0x005d
            r7.add(r8)     // Catch:{ Exception -> 0x022a }
            goto L_0x005d
        L_0x0073:
            boolean r2 = r7.isEmpty()     // Catch:{ Exception -> 0x022a }
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x022a
            r2 = 100
            java.util.ArrayList r2 = ma.z.m(r7, r2)     // Catch:{ Exception -> 0x022a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x022a }
            r6 = r0
        L_0x0085:
            boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x022a }
            if (r7 == 0) goto L_0x022a
            java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x022a }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x022a }
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r8 = r6.f17771m     // Catch:{ Exception -> 0x022a }
            e6.x r8 = r8.f3457d     // Catch:{ Exception -> 0x022a }
            r6.f17767i = r2     // Catch:{ Exception -> 0x022a }
            r6.f17768j = r3     // Catch:{ Exception -> 0x022a }
            r6.f17769k = r3     // Catch:{ Exception -> 0x022a }
            r6.f17770l = r4     // Catch:{ Exception -> 0x022a }
            r8.getClass()     // Catch:{ Exception -> 0x022a }
            nb.d r9 = hb.p0.f7834b     // Catch:{ Exception -> 0x022a }
            e6.w r10 = new e6.w     // Catch:{ Exception -> 0x022a }
            r10.<init>(r7, r8, r3)     // Catch:{ Exception -> 0x022a }
            java.lang.Object r7 = hb.h0.c2(r9, r10, r6)     // Catch:{ Exception -> 0x022a }
            if (r7 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            java.util.List r7 = (java.util.List) r7     // Catch:{ Exception -> 0x022a }
            if (r7 == 0) goto L_0x0085
            java.util.Iterator r7 = r7.iterator()     // Catch:{ Exception -> 0x022a }
            r33 = r7
            r7 = r6
            r6 = r33
        L_0x00bb:
            boolean r8 = r6.hasNext()     // Catch:{ Exception -> 0x022a }
            if (r8 == 0) goto L_0x0227
            java.lang.Object r8 = r6.next()     // Catch:{ Exception -> 0x022a }
            com.github.andreyasadchy.xtra.model.ui.Video r8 = (com.github.andreyasadchy.xtra.model.ui.Video) r8     // Catch:{ Exception -> 0x022a }
            java.lang.String r9 = r8.getUuid()     // Catch:{ Exception -> 0x022a }
            if (r9 == 0) goto L_0x00ef
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r10 = r7.f17771m     // Catch:{ Exception -> 0x022a }
            e6.e0 r10 = r10.f3458e     // Catch:{ Exception -> 0x022a }
            r7.f17767i = r2     // Catch:{ Exception -> 0x022a }
            r7.f17768j = r6     // Catch:{ Exception -> 0x022a }
            r7.f17769k = r8     // Catch:{ Exception -> 0x022a }
            r7.f17770l = r5     // Catch:{ Exception -> 0x022a }
            java.lang.Object r9 = r10.b(r9, r7)     // Catch:{ Exception -> 0x022a }
            if (r9 != r1) goto L_0x00e0
            return r1
        L_0x00e0:
            r33 = r7
            r7 = r2
            r2 = r8
            r8 = r33
        L_0x00e6:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r9 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r9     // Catch:{ Exception -> 0x022a }
            r33 = r8
            r8 = r2
            r2 = r7
            r7 = r33
            goto L_0x00f0
        L_0x00ef:
            r9 = r3
        L_0x00f0:
            android.content.Context r10 = r7.f17772n
            if (r9 == 0) goto L_0x00bb
            int r11 = r9.getUserId()     // Catch:{ Exception -> 0x022a }
            int r12 = r8.getChannelId()     // Catch:{ Exception -> 0x022a }
            if (r11 != r12) goto L_0x0152
            java.lang.String r11 = r9.getUserLogin()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getChannelSlug()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 == 0) goto L_0x0152
            java.lang.String r11 = r9.getUserName()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getChannelName()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 == 0) goto L_0x0152
            java.lang.String r11 = r9.getTitle()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getTitle()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 == 0) goto L_0x0152
            java.lang.String r11 = r9.getCreatedAt()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getUploadDate()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 == 0) goto L_0x0152
            java.lang.String r11 = r9.getType()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getType()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 == 0) goto L_0x0152
            java.lang.String r11 = r9.getDuration()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getDuration()     // Catch:{ Exception -> 0x022a }
            boolean r11 = xa.j.a(r11, r12)     // Catch:{ Exception -> 0x022a }
            if (r11 != 0) goto L_0x00bb
        L_0x0152:
            com.bumptech.glide.s r11 = com.bumptech.glide.c.e(r10)     // Catch:{ Exception -> 0x016a }
            com.bumptech.glide.q r11 = r11.m()     // Catch:{ Exception -> 0x016a }
            java.lang.String r12 = r8.getThumbnail()     // Catch:{ Exception -> 0x016a }
            com.bumptech.glide.q r11 = r11.F(r12)     // Catch:{ Exception -> 0x016a }
            x6.m r12 = new x6.m     // Catch:{ Exception -> 0x016a }
            r12.<init>(r10, r8, r5)     // Catch:{ Exception -> 0x016a }
            r11.D(r12)     // Catch:{ Exception -> 0x016a }
        L_0x016a:
            java.lang.String r11 = r8.getUuid()     // Catch:{ Exception -> 0x022a }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x022a }
            java.io.File r10 = r10.getFilesDir()     // Catch:{ Exception -> 0x022a }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x022a }
            java.lang.String r13 = java.io.File.separator     // Catch:{ Exception -> 0x022a }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022a }
            r14.<init>()     // Catch:{ Exception -> 0x022a }
            r14.append(r10)     // Catch:{ Exception -> 0x022a }
            r14.append(r13)     // Catch:{ Exception -> 0x022a }
            java.lang.String r10 = "thumbnails"
            r14.append(r10)     // Catch:{ Exception -> 0x022a }
            r14.append(r13)     // Catch:{ Exception -> 0x022a }
            r14.append(r11)     // Catch:{ Exception -> 0x022a }
            java.lang.String r10 = ".png"
            r14.append(r10)     // Catch:{ Exception -> 0x022a }
            java.lang.String r10 = r14.toString()     // Catch:{ Exception -> 0x022a }
            r12.<init>(r10)     // Catch:{ Exception -> 0x022a }
            java.lang.String r27 = r12.getAbsolutePath()     // Catch:{ Exception -> 0x022a }
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r10 = r7.f17771m     // Catch:{ Exception -> 0x022a }
            e6.e0 r10 = r10.f3458e     // Catch:{ Exception -> 0x022a }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r11 = new com.github.andreyasadchy.xtra.model.offline.Bookmark     // Catch:{ Exception -> 0x022a }
            java.lang.String r14 = r9.getVideoId()     // Catch:{ Exception -> 0x022a }
            int r15 = r8.getChannelId()     // Catch:{ Exception -> 0x022a }
            java.lang.String r12 = r8.getChannelSlug()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x01b8
            java.lang.String r12 = r9.getUserLogin()     // Catch:{ Exception -> 0x022a }
        L_0x01b8:
            r16 = r12
            java.lang.String r12 = r8.getChannelName()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x01c4
            java.lang.String r12 = r9.getUserName()     // Catch:{ Exception -> 0x022a }
        L_0x01c4:
            r17 = r12
            java.lang.String r18 = r9.getUserType()     // Catch:{ Exception -> 0x022a }
            java.lang.String r19 = r9.getUserBroadcasterType()     // Catch:{ Exception -> 0x022a }
            java.lang.String r20 = r9.getUserLogo()     // Catch:{ Exception -> 0x022a }
            int r21 = r9.getGameId()     // Catch:{ Exception -> 0x022a }
            java.lang.String r22 = r9.getGameName()     // Catch:{ Exception -> 0x022a }
            r23 = 0
            r24 = 0
            java.lang.String r12 = r8.getTitle()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x01e8
            java.lang.String r12 = r9.getTitle()     // Catch:{ Exception -> 0x022a }
        L_0x01e8:
            r25 = r12
            java.lang.String r12 = r8.getUploadDate()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x01f4
            java.lang.String r12 = r9.getCreatedAt()     // Catch:{ Exception -> 0x022a }
        L_0x01f4:
            r26 = r12
            java.lang.String r12 = r8.getType()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x0200
            java.lang.String r12 = r9.getType()     // Catch:{ Exception -> 0x022a }
        L_0x0200:
            r28 = r12
            java.lang.String r12 = r8.getDuration()     // Catch:{ Exception -> 0x022a }
            if (r12 != 0) goto L_0x020c
            java.lang.String r12 = r9.getDuration()     // Catch:{ Exception -> 0x022a }
        L_0x020c:
            r29 = r12
            java.lang.String r8 = r8.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x022a }
            if (r8 != 0) goto L_0x0218
            java.lang.String r8 = r9.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x022a }
        L_0x0218:
            r30 = r8
            r31 = 1536(0x600, float:2.152E-42)
            r32 = 0
            r13 = r11
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ Exception -> 0x022a }
            r10.d(r11)     // Catch:{ Exception -> 0x022a }
            goto L_0x00bb
        L_0x0227:
            r6 = r7
            goto L_0x0085
        L_0x022a:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
