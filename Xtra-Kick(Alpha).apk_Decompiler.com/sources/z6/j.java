package z6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Video f17762i;

    /* renamed from: j  reason: collision with root package name */
    public int f17763j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f17764k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f17765l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BookmarksViewModel f17766m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(String str, Context context, BookmarksViewModel bookmarksViewModel, e eVar) {
        super(2, eVar);
        this.f17764k = str;
        this.f17765l = context;
        this.f17766m = bookmarksViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f17764k, this.f17765l, this.f17766m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(24:30|(1:34)|35|(2:37|38)|39|40|(1:42)|43|(1:45)|46|(1:48)|49|(1:51)|52|(1:54)|55|(1:57)|58|(1:60)|61|(1:63)|64|(1:66)|67) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008a */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[SYNTHETIC, Splitter:B:37:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d6 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e1 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fc A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010b A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0117 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0123 A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x012f A[Catch:{ Exception -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013b A[Catch:{ Exception -> 0x014c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            r26 = this;
            r0 = r26
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f17763j
            java.lang.String r3 = r0.f17764k
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r4 = r0.f17766m
            r5 = 0
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0029
            if (r2 == r7) goto L_0x0023
            if (r2 != r6) goto L_0x001b
            com.github.andreyasadchy.xtra.model.ui.Video r1 = r0.f17762i
            hb.h0.O1(r27)     // Catch:{ Exception -> 0x014c }
            r3 = r27
            goto L_0x0057
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            hb.h0.O1(r27)     // Catch:{ Exception -> 0x014c }
            r2 = r27
            goto L_0x0043
        L_0x0029:
            hb.h0.O1(r27)
            if (r3 == 0) goto L_0x0046
            e6.x r2 = r4.f3457d     // Catch:{ Exception -> 0x014c }
            r0.f17763j = r7     // Catch:{ Exception -> 0x014c }
            r2.getClass()     // Catch:{ Exception -> 0x014c }
            nb.d r8 = hb.p0.f7834b     // Catch:{ Exception -> 0x014c }
            e6.u r9 = new e6.u     // Catch:{ Exception -> 0x014c }
            r9.<init>(r2, r3, r5)     // Catch:{ Exception -> 0x014c }
            java.lang.Object r2 = hb.h0.c2(r8, r9, r0)     // Catch:{ Exception -> 0x014c }
            if (r2 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.github.andreyasadchy.xtra.model.ui.Video r2 = (com.github.andreyasadchy.xtra.model.ui.Video) r2     // Catch:{ Exception -> 0x014c }
            goto L_0x0047
        L_0x0046:
            r2 = r5
        L_0x0047:
            if (r3 == 0) goto L_0x005b
            e6.e0 r8 = r4.f3458e     // Catch:{ Exception -> 0x014c }
            r0.f17762i = r2     // Catch:{ Exception -> 0x014c }
            r0.f17763j = r6     // Catch:{ Exception -> 0x014c }
            java.lang.Object r3 = r8.b(r3, r0)     // Catch:{ Exception -> 0x014c }
            if (r3 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r1 = r2
        L_0x0057:
            com.github.andreyasadchy.xtra.model.offline.Bookmark r3 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r3     // Catch:{ Exception -> 0x014c }
            r2 = r1
            goto L_0x005c
        L_0x005b:
            r3 = r5
        L_0x005c:
            if (r2 == 0) goto L_0x014c
            if (r3 == 0) goto L_0x014c
            java.lang.String r1 = r2.getUuid()     // Catch:{ Exception -> 0x014c }
            if (r1 == 0) goto L_0x006e
            boolean r1 = fb.w.h(r1)     // Catch:{ Exception -> 0x014c }
            if (r1 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r7 = 0
        L_0x006e:
            android.content.Context r1 = r0.f17765l
            if (r7 != 0) goto L_0x008a
            com.bumptech.glide.s r7 = com.bumptech.glide.c.e(r1)     // Catch:{ Exception -> 0x008a }
            com.bumptech.glide.q r7 = r7.m()     // Catch:{ Exception -> 0x008a }
            java.lang.String r8 = r2.getThumbnail()     // Catch:{ Exception -> 0x008a }
            com.bumptech.glide.q r7 = r7.F(r8)     // Catch:{ Exception -> 0x008a }
            x6.m r8 = new x6.m     // Catch:{ Exception -> 0x008a }
            r8.<init>(r1, r2, r6)     // Catch:{ Exception -> 0x008a }
            r7.D(r8)     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            java.lang.String r6 = r2.getUuid()     // Catch:{ Exception -> 0x014c }
            if (r6 == 0) goto L_0x00c2
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x014c }
            java.io.File r1 = r1.getFilesDir()     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x014c }
            java.lang.String r7 = java.io.File.separator     // Catch:{ Exception -> 0x014c }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014c }
            r8.<init>()     // Catch:{ Exception -> 0x014c }
            r8.append(r1)     // Catch:{ Exception -> 0x014c }
            r8.append(r7)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = "thumbnails"
            r8.append(r1)     // Catch:{ Exception -> 0x014c }
            r8.append(r7)     // Catch:{ Exception -> 0x014c }
            r8.append(r6)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = ".png"
            r8.append(r1)     // Catch:{ Exception -> 0x014c }
            java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x014c }
            r5.<init>(r1)     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ Exception -> 0x014c }
        L_0x00c2:
            r20 = r5
            e6.e0 r1 = r4.f3458e     // Catch:{ Exception -> 0x014c }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r4 = new com.github.andreyasadchy.xtra.model.offline.Bookmark     // Catch:{ Exception -> 0x014c }
            java.lang.String r7 = r3.getVideoId()     // Catch:{ Exception -> 0x014c }
            int r8 = r2.getChannelId()     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = r2.getChannelSlug()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x00da
            java.lang.String r5 = r3.getUserLogin()     // Catch:{ Exception -> 0x014c }
        L_0x00da:
            r9 = r5
            java.lang.String r5 = r2.getChannelName()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x00e5
            java.lang.String r5 = r3.getUserName()     // Catch:{ Exception -> 0x014c }
        L_0x00e5:
            r10 = r5
            java.lang.String r11 = r3.getUserType()     // Catch:{ Exception -> 0x014c }
            java.lang.String r12 = r3.getUserBroadcasterType()     // Catch:{ Exception -> 0x014c }
            java.lang.String r13 = r3.getUserLogo()     // Catch:{ Exception -> 0x014c }
            int r14 = r2.getGameId()     // Catch:{ Exception -> 0x014c }
            java.lang.String r5 = r2.getGameName()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x0100
            java.lang.String r5 = r3.getGameName()     // Catch:{ Exception -> 0x014c }
        L_0x0100:
            r15 = r5
            r16 = 0
            r17 = 0
            java.lang.String r5 = r2.getTitle()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x010f
            java.lang.String r5 = r3.getTitle()     // Catch:{ Exception -> 0x014c }
        L_0x010f:
            r18 = r5
            java.lang.String r5 = r2.getUploadDate()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x011b
            java.lang.String r5 = r3.getCreatedAt()     // Catch:{ Exception -> 0x014c }
        L_0x011b:
            r19 = r5
            java.lang.String r5 = r2.getType()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x0127
            java.lang.String r5 = r3.getType()     // Catch:{ Exception -> 0x014c }
        L_0x0127:
            r21 = r5
            java.lang.String r5 = r2.getDuration()     // Catch:{ Exception -> 0x014c }
            if (r5 != 0) goto L_0x0133
            java.lang.String r5 = r3.getDuration()     // Catch:{ Exception -> 0x014c }
        L_0x0133:
            r22 = r5
            java.lang.String r2 = r2.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x014c }
            if (r2 != 0) goto L_0x013f
            java.lang.String r2 = r3.getAnimatedPreviewURL()     // Catch:{ Exception -> 0x014c }
        L_0x013f:
            r23 = r2
            r24 = 1536(0x600, float:2.152E-42)
            r25 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ Exception -> 0x014c }
            r1.d(r4)     // Catch:{ Exception -> 0x014c }
        L_0x014c:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
