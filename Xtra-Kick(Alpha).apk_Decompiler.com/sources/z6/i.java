package z6;

import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import hb.f0;
import java.util.Iterator;
import la.v;
import pa.e;
import wa.p;

public final class i extends ra.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Iterator f17757i;

    /* renamed from: j  reason: collision with root package name */
    public Iterator f17758j;

    /* renamed from: k  reason: collision with root package name */
    public User f17759k;

    /* renamed from: l  reason: collision with root package name */
    public int f17760l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ BookmarksViewModel f17761m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(BookmarksViewModel bookmarksViewModel, e eVar) {
        super(2, eVar);
        this.f17761m = bookmarksViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new i(this.f17761m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((i) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if (r7 != false) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b5 A[Catch:{ Exception -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee A[Catch:{ Exception -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127 A[Catch:{ Exception -> 0x0164 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r13.f17760l
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r2 = r13.f17761m
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r6) goto L_0x0034
            if (r1 == r4) goto L_0x002a
            if (r1 != r3) goto L_0x0022
            com.github.andreyasadchy.xtra.model.ui.User r1 = r13.f17759k
            java.util.Iterator r2 = r13.f17758j
            java.util.Iterator r6 = r13.f17757i
            hb.h0.O1(r14)     // Catch:{ Exception -> 0x0164 }
            r7 = r2
            r2 = r6
            r6 = r1
            r1 = r0
            r0 = r13
            goto L_0x011b
        L_0x0022:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x002a:
            java.util.Iterator r1 = r13.f17757i
            hb.h0.O1(r14)     // Catch:{ Exception -> 0x0164 }
            r2 = r1
            r1 = r0
            r0 = r13
            goto L_0x00dd
        L_0x0034:
            hb.h0.O1(r14)     // Catch:{ Exception -> 0x0164 }
            goto L_0x0050
        L_0x0038:
            hb.h0.O1(r14)
            e6.e0 r14 = r2.f3458e     // Catch:{ Exception -> 0x0164 }
            r13.f17760l = r6     // Catch:{ Exception -> 0x0164 }
            r14.getClass()     // Catch:{ Exception -> 0x0164 }
            nb.d r1 = hb.p0.f7834b     // Catch:{ Exception -> 0x0164 }
            e6.b0 r7 = new e6.b0     // Catch:{ Exception -> 0x0164 }
            r7.<init>(r14, r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r14 = hb.h0.c2(r1, r7, r13)     // Catch:{ Exception -> 0x0164 }
            if (r14 != r0) goto L_0x0050
            return r0
        L_0x0050:
            java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch:{ Exception -> 0x0164 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0164 }
            r1.<init>()     // Catch:{ Exception -> 0x0164 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0164 }
        L_0x005b:
            boolean r7 = r14.hasNext()     // Catch:{ Exception -> 0x0164 }
            if (r7 == 0) goto L_0x009c
            java.lang.Object r7 = r14.next()     // Catch:{ Exception -> 0x0164 }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r7 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r7     // Catch:{ Exception -> 0x0164 }
            int r7 = r7.getUserId()     // Catch:{ Exception -> 0x0164 }
            java.lang.Integer r8 = new java.lang.Integer     // Catch:{ Exception -> 0x0164 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0164 }
            int r7 = r8.intValue()     // Catch:{ Exception -> 0x0164 }
            if (r7 == 0) goto L_0x0091
            r3.u0 r9 = r2.f3462i     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r9 = r9.d()     // Catch:{ Exception -> 0x0164 }
            java.util.List r9 = (java.util.List) r9     // Catch:{ Exception -> 0x0164 }
            r10 = 0
            if (r9 == 0) goto L_0x008e
            com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser r11 = new com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser     // Catch:{ Exception -> 0x0164 }
            r11.<init>(r7)     // Catch:{ Exception -> 0x0164 }
            boolean r7 = r9.contains(r11)     // Catch:{ Exception -> 0x0164 }
            if (r7 != r6) goto L_0x008e
            r7 = 1
            goto L_0x008f
        L_0x008e:
            r7 = 0
        L_0x008f:
            if (r7 == 0) goto L_0x0092
        L_0x0091:
            r10 = 1
        L_0x0092:
            if (r10 != 0) goto L_0x0095
            goto L_0x0096
        L_0x0095:
            r8 = r5
        L_0x0096:
            if (r8 == 0) goto L_0x005b
            r1.add(r8)     // Catch:{ Exception -> 0x0164 }
            goto L_0x005b
        L_0x009c:
            boolean r14 = r1.isEmpty()     // Catch:{ Exception -> 0x0164 }
            r14 = r14 ^ r6
            if (r14 == 0) goto L_0x0164
            r14 = 100
            java.util.ArrayList r14 = ma.z.m(r1, r14)     // Catch:{ Exception -> 0x0164 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0164 }
            r1 = r14
            r14 = r13
        L_0x00af:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0164 }
            if (r2 == 0) goto L_0x0164
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0164 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ Exception -> 0x0164 }
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r2 = r14.f17761m     // Catch:{ Exception -> 0x0164 }
            e6.x r2 = r2.f3457d     // Catch:{ Exception -> 0x0164 }
            r14.f17757i = r1     // Catch:{ Exception -> 0x0164 }
            r14.f17758j = r5     // Catch:{ Exception -> 0x0164 }
            r14.f17759k = r5     // Catch:{ Exception -> 0x0164 }
            r14.f17760l = r4     // Catch:{ Exception -> 0x0164 }
            r2.getClass()     // Catch:{ Exception -> 0x0164 }
            nb.d r2 = hb.p0.f7834b     // Catch:{ Exception -> 0x0164 }
            e6.t r6 = new e6.t     // Catch:{ Exception -> 0x0164 }
            r6.<init>(r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r2 = hb.h0.c2(r2, r6, r14)     // Catch:{ Exception -> 0x0164 }
            if (r2 != r0) goto L_0x00d8
            return r0
        L_0x00d8:
            r12 = r0
            r0 = r14
            r14 = r2
            r2 = r1
            r1 = r12
        L_0x00dd:
            java.util.List r14 = (java.util.List) r14     // Catch:{ Exception -> 0x0164 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0164 }
            r12 = r2
            r2 = r14
            r14 = r0
            r0 = r1
            r1 = r12
        L_0x00e8:
            boolean r6 = r2.hasNext()     // Catch:{ Exception -> 0x0164 }
            if (r6 == 0) goto L_0x00af
            java.lang.Object r6 = r2.next()     // Catch:{ Exception -> 0x0164 }
            com.github.andreyasadchy.xtra.model.ui.User r6 = (com.github.andreyasadchy.xtra.model.ui.User) r6     // Catch:{ Exception -> 0x0164 }
            int r7 = r6.getChannelId()     // Catch:{ Exception -> 0x0164 }
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r8 = r14.f17761m     // Catch:{ Exception -> 0x0164 }
            e6.e0 r8 = r8.f3458e     // Catch:{ Exception -> 0x0164 }
            r14.f17757i = r1     // Catch:{ Exception -> 0x0164 }
            r14.f17758j = r2     // Catch:{ Exception -> 0x0164 }
            r14.f17759k = r6     // Catch:{ Exception -> 0x0164 }
            r14.f17760l = r3     // Catch:{ Exception -> 0x0164 }
            r8.getClass()     // Catch:{ Exception -> 0x0164 }
            nb.d r9 = hb.p0.f7834b     // Catch:{ Exception -> 0x0164 }
            e6.a0 r10 = new e6.a0     // Catch:{ Exception -> 0x0164 }
            r10.<init>(r8, r7, r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r7 = hb.h0.c2(r9, r10, r14)     // Catch:{ Exception -> 0x0164 }
            if (r7 != r0) goto L_0x0115
            return r0
        L_0x0115:
            r12 = r0
            r0 = r14
            r14 = r7
            r7 = r2
            r2 = r1
            r1 = r12
        L_0x011b:
            java.util.List r14 = (java.util.List) r14     // Catch:{ Exception -> 0x0164 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0164 }
        L_0x0121:
            boolean r8 = r14.hasNext()     // Catch:{ Exception -> 0x0164 }
            if (r8 == 0) goto L_0x015f
            java.lang.Object r8 = r14.next()     // Catch:{ Exception -> 0x0164 }
            com.github.andreyasadchy.xtra.model.offline.Bookmark r8 = (com.github.andreyasadchy.xtra.model.offline.Bookmark) r8     // Catch:{ Exception -> 0x0164 }
            java.lang.String r9 = r6.getType()     // Catch:{ Exception -> 0x0164 }
            java.lang.String r10 = r8.getUserType()     // Catch:{ Exception -> 0x0164 }
            boolean r9 = xa.j.a(r9, r10)     // Catch:{ Exception -> 0x0164 }
            if (r9 == 0) goto L_0x0149
            java.lang.String r9 = r6.getBroadcasterType()     // Catch:{ Exception -> 0x0164 }
            java.lang.String r10 = r8.getUserBroadcasterType()     // Catch:{ Exception -> 0x0164 }
            boolean r9 = xa.j.a(r9, r10)     // Catch:{ Exception -> 0x0164 }
            if (r9 != 0) goto L_0x0121
        L_0x0149:
            com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel r9 = r0.f17761m     // Catch:{ Exception -> 0x0164 }
            e6.e0 r9 = r9.f3458e     // Catch:{ Exception -> 0x0164 }
            java.lang.String r10 = r6.getType()     // Catch:{ Exception -> 0x0164 }
            r8.setUserType(r10)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r10 = r6.getBroadcasterType()     // Catch:{ Exception -> 0x0164 }
            r8.setUserBroadcasterType(r10)     // Catch:{ Exception -> 0x0164 }
            r9.d(r8)     // Catch:{ Exception -> 0x0164 }
            goto L_0x0121
        L_0x015f:
            r14 = r0
            r0 = r1
            r1 = r2
            r2 = r7
            goto L_0x00e8
        L_0x0164:
            la.v r14 = la.v.f9814a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
