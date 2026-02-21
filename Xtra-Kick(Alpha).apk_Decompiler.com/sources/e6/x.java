package e6;

import c6.b;
import javax.inject.Inject;
import xa.j;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final s0 f5265a;

    /* renamed from: b  reason: collision with root package name */
    public final b f5266b;

    @Inject
    public x(s0 s0Var, b bVar) {
        j.f("kickApi", s0Var);
        j.f("kickMapper", bVar);
        this.f5265a = s0Var;
        this.f5266b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable a(int r6, java.lang.String r7, pa.e r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof e6.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            e6.c r0 = (e6.c) r0
            int r1 = r0.f5089k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5089k = r1
            goto L_0x0018
        L_0x0013:
            e6.c r0 = new e6.c
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f5087i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5089k
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            e6.x r6 = r0.f5086h
            hb.h0.O1(r8)
            goto L_0x004d
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            hb.h0.O1(r8)
            r0.f5086h = r5
            r0.f5089k = r3
            e6.s0 r8 = r5.f5265a
            r8.getClass()
            nb.d r2 = hb.p0.f7834b
            e6.n0 r3 = new e6.n0
            r4 = 0
            r3.<init>(r8, r7, r6, r4)
            java.lang.Object r8 = hb.h0.c2(r2, r3, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r6 = r5
        L_0x004d:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipResponse r8 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipResponse) r8
            c6.b r6 = r6.f5266b
            java.util.List r7 = r8.getClips()
            r6.getClass()
            java.util.ArrayList r6 = c6.b.c(r7)
            e6.b r7 = new e6.b
            r7.<init>()
            java.util.List r6 = ma.z.F(r6, r7)
            int r7 = r8.getNextCursor()
            java.lang.Integer r8 = new java.lang.Integer
            r8.<init>(r7)
            la.i r7 = new la.i
            r7.<init>(r6, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.a(int, java.lang.String, pa.e):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable b(int r11, java.lang.String r12, java.lang.String r13, pa.e r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof e6.e
            if (r0 == 0) goto L_0x0013
            r0 = r14
            e6.e r0 = (e6.e) r0
            int r1 = r0.f5104k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5104k = r1
            goto L_0x0018
        L_0x0013:
            e6.e r0 = new e6.e
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f5102i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5104k
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            e6.x r11 = r0.f5101h
            hb.h0.O1(r14)
            goto L_0x0055
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            hb.h0.O1(r14)
            if (r13 != 0) goto L_0x0038
            java.lang.String r13 = "all"
        L_0x0038:
            r8 = r13
            r0.f5101h = r10
            r0.f5104k = r3
            e6.s0 r6 = r10.f5265a
            r6.getClass()
            nb.d r13 = hb.p0.f7834b
            e6.o0 r14 = new e6.o0
            r9 = 0
            r4 = r14
            r5 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.Object r14 = hb.h0.c2(r13, r14, r0)
            if (r14 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r11 = r10
        L_0x0055:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipResponse r14 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.ClipResponse) r14
            c6.b r11 = r11.f5266b
            java.util.List r12 = r14.getClips()
            r11.getClass()
            java.util.ArrayList r11 = c6.b.c(r12)
            e6.d r12 = new e6.d
            r12.<init>()
            java.util.List r11 = ma.z.F(r11, r12)
            int r12 = r14.getNextCursor()
            java.lang.Integer r13 = new java.lang.Integer
            r13.<init>(r12)
            la.i r12 = new la.i
            r12.<init>(r11, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.b(int, java.lang.String, java.lang.String, pa.e):java.io.Serializable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: ma.b0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: ma.b0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: ma.b0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable c(int r28, java.lang.String r29, com.github.andreyasadchy.xtra.model.ui.StreamSortEnum r30, pa.e r31) {
        /*
            r27 = this;
            r0 = r27
            r1 = r31
            boolean r2 = r1 instanceof e6.f
            if (r2 == 0) goto L_0x0017
            r2 = r1
            e6.f r2 = (e6.f) r2
            int r3 = r2.f5114k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5114k = r3
            goto L_0x001c
        L_0x0017:
            e6.f r2 = new e6.f
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f5112i
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5114k
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            e6.x r2 = r2.f5111h
            hb.h0.O1(r1)
            goto L_0x006a
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            hb.h0.O1(r1)
            int[] r1 = e6.a.f5075a
            int r4 = r30.ordinal()
            r1 = r1[r4]
            if (r1 == r5) goto L_0x0049
            r4 = 2
            if (r1 == r4) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            java.lang.String r1 = "asc"
            goto L_0x004b
        L_0x0049:
            java.lang.String r1 = "desc"
        L_0x004b:
            r10 = r1
            r2.f5111h = r0
            r2.f5114k = r5
            e6.s0 r8 = r0.f5265a
            r8.getClass()
            nb.d r1 = hb.p0.f7834b
            e6.r0 r4 = new e6.r0
            r11 = 0
            r6 = r4
            r7 = r28
            r9 = r29
            r6.<init>(r7, r8, r9, r10, r11)
            java.lang.Object r1 = hb.h0.c2(r1, r4, r2)
            if (r1 != r3) goto L_0x0069
            return r3
        L_0x0069:
            r2 = r0
        L_0x006a:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Response r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Response) r1
            c6.b r2 = r2.f5266b
            r2.getClass()
            java.lang.String r2 = "response"
            xa.j.f(r2, r1)
            java.lang.Object r2 = r1.getData()
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x011b
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = ma.s.i(r2)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x008b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x011d
            java.lang.Object r4 = r2.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Stream r4 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Stream) r4
            java.util.List r5 = r4.getCategories()
            java.lang.Object r5 = ma.z.u(r5)
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.CategoriesItem r5 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.CategoriesItem) r5
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel r6 = r4.getChannel()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.User r7 = r6.getUser()
            int r9 = r4.getId()
            int r10 = r4.getChannelId()
            java.lang.String r11 = r6.getSlug()
            if (r5 == 0) goto L_0x00bd
            int r6 = r5.getId()
            r13 = r6
            goto L_0x00bf
        L_0x00bd:
            r6 = 0
            r13 = 0
        L_0x00bf:
            if (r5 == 0) goto L_0x00c7
            java.lang.String r6 = r5.getName()
            if (r6 != 0) goto L_0x00c9
        L_0x00c7:
            java.lang.String r6 = "Unknown"
        L_0x00c9:
            r14 = r6
            r6 = 0
            if (r5 == 0) goto L_0x00d3
            java.lang.String r5 = r5.getSlug()
            r15 = r5
            goto L_0x00d4
        L_0x00d3:
            r15 = r6
        L_0x00d4:
            java.lang.String r17 = r4.getTitle()
            java.lang.String r5 = r7.getProfilepic()
            c6.a r8 = c6.b.f2971b
            if (r5 == 0) goto L_0x00e7
            java.lang.String r5 = c6.a.a(r8, r5)
            r21 = r5
            goto L_0x00e9
        L_0x00e7:
            r21 = r6
        L_0x00e9:
            java.lang.String r12 = r7.getUsername()
            int r5 = r4.getViewerCount()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Thumbnail r4 = r4.getThumbnail()
            java.lang.String r4 = r4.getSrc()
            java.lang.String r20 = c6.a.a(r8, r4)
            com.github.andreyasadchy.xtra.model.ui.Stream r4 = new com.github.andreyasadchy.xtra.model.ui.Stream
            r8 = r4
            r16 = 0
            java.lang.Integer r18 = java.lang.Integer.valueOf(r5)
            r19 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 58496(0xe480, float:8.197E-41)
            r26 = 0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r3.add(r4)
            goto L_0x008b
        L_0x011b:
            ma.b0 r3 = ma.b0.f10801h
        L_0x011d:
            la.p r2 = new la.p
            java.lang.String r4 = r1.getPrevPageUrl()
            java.lang.String r1 = r1.getNextPageUrl()
            r2.<init>(r3, r4, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.c(int, java.lang.String, com.github.andreyasadchy.xtra.model.ui.StreamSortEnum, pa.e):java.io.Serializable");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: ma.b0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: ma.b0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: ma.b0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable d(int r20, pa.e r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof e6.g
            if (r2 == 0) goto L_0x0017
            r2 = r1
            e6.g r2 = (e6.g) r2
            int r3 = r2.f5125k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5125k = r3
            goto L_0x001c
        L_0x0017:
            e6.g r2 = new e6.g
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f5123i
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5125k
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            e6.x r2 = r2.f5122h
            hb.h0.O1(r1)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            hb.h0.O1(r1)
            r2.f5122h = r0
            r2.f5125k = r5
            e6.s0 r1 = r0.f5265a
            r1.getClass()
            nb.d r4 = hb.p0.f7834b
            e6.q0 r5 = new e6.q0
            r6 = 0
            r7 = r20
            r5.<init>(r1, r7, r6)
            java.lang.Object r1 = hb.h0.c2(r4, r5, r2)
            if (r1 != r3) goto L_0x0052
            return r3
        L_0x0052:
            r2 = r0
        L_0x0053:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Response r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Response) r1
            c6.b r2 = r2.f5266b
            r2.getClass()
            java.lang.String r2 = "response"
            xa.j.f(r2, r1)
            java.lang.Object r2 = r1.getData()
            java.util.List r2 = (java.util.List) r2
            if (r2 == 0) goto L_0x00e5
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = ma.s.i(r2)
            r3.<init>(r4)
            java.util.Iterator r2 = r2.iterator()
        L_0x0074:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00e7
            java.lang.Object r4 = r2.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Subcategories r4 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Subcategories) r4
            int r6 = r4.getId()
            java.lang.String r7 = r4.getName()
            java.lang.String r8 = r4.getSlug()
            int r5 = r4.getViewers()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.CategoryBanner r9 = r4.getBanner()
            java.lang.String r9 = r9.getUrl()
            c6.a r10 = c6.b.f2971b
            java.lang.String r9 = c6.a.a(r10, r9)
            java.util.List r4 = r4.getTags()
            java.util.ArrayList r12 = new java.util.ArrayList
            int r10 = ma.s.i(r4)
            r12.<init>(r10)
            java.util.Iterator r4 = r4.iterator()
        L_0x00af:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x00cd
            java.lang.Object r10 = r4.next()
            r15 = r10
            java.lang.String r15 = (java.lang.String) r15
            com.github.andreyasadchy.xtra.model.ui.Tag r10 = new com.github.andreyasadchy.xtra.model.ui.Tag
            r14 = 0
            r16 = 0
            r17 = 5
            r18 = 0
            r13 = r10
            r13.<init>(r14, r15, r16, r17, r18)
            r12.add(r10)
            goto L_0x00af
        L_0x00cd:
            com.github.andreyasadchy.xtra.model.ui.Game r4 = new com.github.andreyasadchy.xtra.model.ui.Game
            java.lang.Integer r10 = java.lang.Integer.valueOf(r5)
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 1952(0x7a0, float:2.735E-42)
            r18 = 0
            r5 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r3.add(r4)
            goto L_0x0074
        L_0x00e5:
            ma.b0 r3 = ma.b0.f10801h
        L_0x00e7:
            la.p r2 = new la.p
            java.lang.String r4 = r1.getPrevPageUrl()
            java.lang.String r1 = r1.getNextPageUrl()
            r2.<init>(r3, r4, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.d(int, pa.e):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable e(java.lang.String r20, pa.e r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            boolean r2 = r1 instanceof e6.i
            if (r2 == 0) goto L_0x0017
            r2 = r1
            e6.i r2 = (e6.i) r2
            int r3 = r2.f5148k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5148k = r3
            goto L_0x001c
        L_0x0017:
            e6.i r2 = new e6.i
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f5146i
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5148k
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            e6.x r2 = r2.f5145h
            hb.h0.O1(r1)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            hb.h0.O1(r1)
            r2.f5145h = r0
            r2.f5148k = r5
            e6.s0 r1 = r0.f5265a
            r1.getClass()
            nb.d r4 = hb.p0.f7834b
            e6.l0 r5 = new e6.l0
            r6 = 0
            r7 = r20
            r5.<init>(r1, r7, r6)
            java.lang.Object r1 = hb.h0.c2(r4, r5, r2)
            if (r1 != r3) goto L_0x0052
            return r3
        L_0x0052:
            r2 = r0
        L_0x0053:
            com.github.andreyasadchy.xtra.model.retrofit.kick.MultiSearch r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.MultiSearch) r1
            java.util.List r1 = r1.getResults()
            java.lang.Object r1 = ma.z.u(r1)
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchResult r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.SearchResult) r1
            if (r1 != 0) goto L_0x0064
            ma.b0 r1 = ma.b0.f10801h
            return r1
        L_0x0064:
            c6.b r2 = r2.f5266b
            r2.getClass()
            java.util.List r1 = r1.getHits()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = ma.s.i(r1)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x007a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00ce
            java.lang.Object r3 = r1.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchHit r3 = (com.github.andreyasadchy.xtra.model.retrofit.kick.SearchHit) r3
            com.github.andreyasadchy.xtra.model.ui.Game r15 = new com.github.andreyasadchy.xtra.model.ui.Game
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r4 = r4.getId()
            java.lang.Integer r4 = fb.v.d(r4)
            if (r4 == 0) goto L_0x009c
            int r4 = r4.intValue()
            r5 = r4
            goto L_0x009e
        L_0x009c:
            r4 = 0
            r5 = 0
        L_0x009e:
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r6 = r4.getName()
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r7 = r4.getSlug()
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r3 = r3.getDocument()
            java.lang.String r8 = r3.getSrc()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r3 = 0
            r16 = 2032(0x7f0, float:2.847E-42)
            r17 = 0
            r4 = r15
            r18 = r15
            r15 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r3 = r18
            r2.add(r3)
            goto L_0x007a
        L_0x00ce:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.e(java.lang.String, pa.e):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.Serializable f(java.lang.String r25, pa.e r26) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            boolean r2 = r1 instanceof e6.j
            if (r2 == 0) goto L_0x0017
            r2 = r1
            e6.j r2 = (e6.j) r2
            int r3 = r2.f5160k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5160k = r3
            goto L_0x001c
        L_0x0017:
            e6.j r2 = new e6.j
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f5158i
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5160k
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            e6.x r2 = r2.f5157h
            hb.h0.O1(r1)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            hb.h0.O1(r1)
            r2.f5157h = r0
            r2.f5160k = r5
            e6.s0 r1 = r0.f5265a
            r1.getClass()
            nb.d r4 = hb.p0.f7834b
            e6.k0 r5 = new e6.k0
            r6 = 0
            r7 = r25
            r5.<init>(r1, r7, r6)
            java.lang.Object r1 = hb.h0.c2(r4, r5, r2)
            if (r1 != r3) goto L_0x0052
            return r3
        L_0x0052:
            r2 = r0
        L_0x0053:
            com.github.andreyasadchy.xtra.model.retrofit.kick.MultiSearch r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.MultiSearch) r1
            java.util.List r1 = r1.getResults()
            java.lang.Object r1 = ma.z.u(r1)
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchResult r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.SearchResult) r1
            if (r1 != 0) goto L_0x0064
            ma.b0 r1 = ma.b0.f10801h
            return r1
        L_0x0064:
            c6.b r2 = r2.f5266b
            r2.getClass()
            java.util.List r1 = r1.getHits()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = ma.s.i(r1)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x007a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x00dc
            java.lang.Object r3 = r1.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchHit r3 = (com.github.andreyasadchy.xtra.model.retrofit.kick.SearchHit) r3
            com.github.andreyasadchy.xtra.model.ui.User r5 = new com.github.andreyasadchy.xtra.model.ui.User
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r4 = r4.getId()
            java.lang.Integer r4 = fb.v.d(r4)
            if (r4 == 0) goto L_0x009d
            int r4 = r4.intValue()
            r23 = r4
            goto L_0x00a0
        L_0x009d:
            r4 = 0
            r23 = 0
        L_0x00a0:
            r6 = 0
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r7 = r4.getSlug()
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r4 = r3.getDocument()
            java.lang.String r8 = r4.getUsername()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.github.andreyasadchy.xtra.model.retrofit.kick.SearchDocument r3 = r3.getDocument()
            boolean r3 = r3.is_live()
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r3)
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 61426(0xeff2, float:8.6076E-41)
            r22 = 0
            r4 = r5
            r3 = r5
            r5 = r23
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r2.add(r3)
            goto L_0x007a
        L_0x00dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.f(java.lang.String, pa.e):java.io.Serializable");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(int r23, pa.e r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            boolean r2 = r1 instanceof e6.m
            if (r2 == 0) goto L_0x0017
            r2 = r1
            e6.m r2 = (e6.m) r2
            int r3 = r2.f5182k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f5182k = r3
            goto L_0x001c
        L_0x0017:
            e6.m r2 = new e6.m
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f5180i
            qa.a r3 = qa.a.COROUTINE_SUSPENDED
            int r4 = r2.f5182k
            r5 = 1
            if (r4 == 0) goto L_0x0035
            if (r4 != r5) goto L_0x002d
            c6.b r2 = r2.f5179h
            hb.h0.O1(r1)
            goto L_0x0059
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            hb.h0.O1(r1)
            c6.b r1 = r0.f5266b
            r2.f5179h = r1
            r2.f5182k = r5
            e6.s0 r4 = r0.f5265a
            r4.getClass()
            nb.d r6 = hb.p0.f7834b
            e6.p0 r7 = new e6.p0
            r8 = 0
            r9 = r23
            r7.<init>(r4, r9, r8)
            java.lang.Object r2 = hb.h0.c2(r6, r7, r2)
            if (r2 != r3) goto L_0x0054
            return r3
        L_0x0054:
            r21 = r2
            r2 = r1
            r1 = r21
        L_0x0059:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Data r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Data) r1
            r2.getClass()
            java.lang.String r3 = "loadRecentMessages"
            xa.j.f(r3, r1)
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.DataStatus r3 = r1.getStatus()
            boolean r3 = r3.getError()
            if (r3 == 0) goto L_0x0077
            com.github.andreyasadchy.xtra.model.KickRecentMessages r1 = new com.github.andreyasadchy.xtra.model.KickRecentMessages
            ma.b0 r2 = ma.b0.f10801h
            r3 = 0
            r1.<init>(r3, r2)
            goto L_0x0106
        L_0x0077:
            java.lang.Object r1 = r1.getData()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessagesResponse r1 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessagesResponse) r1
            if (r1 == 0) goto L_0x00fe
            java.util.List r1 = r1.getMessages()
            if (r1 == 0) goto L_0x00fe
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = ma.s.i(r1)
            r3.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x0092:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00f8
            java.lang.Object r4 = r1.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Message r4 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Message) r4
            java.lang.String r7 = r4.getId()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessageSender r6 = r4.getSender()
            int r8 = r6.getId()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessageSender r6 = r4.getSender()
            java.lang.String r9 = r6.getSlug()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessageSender r6 = r4.getSender()
            java.lang.String r10 = r6.getUsername()
            java.lang.String r11 = r4.getContent()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessageSender r6 = r4.getSender()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.MessageIdentity r6 = r6.getIdentity()
            java.lang.String r12 = r6.getColor()
            java.lang.String r6 = r4.getContent()
            java.util.ArrayList r14 = c6.b.a(r6)
            ma.b0 r15 = ma.b0.f10801h
            java.lang.String r16 = r4.getContent()
            int r17 = r4.getChatId()
            java.lang.String r4 = r4.getCreatedAt()
            s7.h r6 = r2.f2973a
            r6.getClass()
            java.lang.Long r20 = s7.h.l(r4)
            com.github.andreyasadchy.xtra.model.chat.LiveChatMessage r4 = new com.github.andreyasadchy.xtra.model.chat.LiveChatMessage
            r13 = 0
            r18 = 0
            r19 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r3.add(r4)
            goto L_0x0092
        L_0x00f8:
            ma.k0 r1 = new ma.k0
            r1.<init>((java.util.List) r3)
            goto L_0x0100
        L_0x00fe:
            ma.b0 r1 = ma.b0.f10801h
        L_0x0100:
            com.github.andreyasadchy.xtra.model.KickRecentMessages r2 = new com.github.andreyasadchy.xtra.model.KickRecentMessages
            r2.<init>(r5, r1)
            r1 = r2
        L_0x0106:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.x.g(int, pa.e):java.lang.Object");
    }
}
