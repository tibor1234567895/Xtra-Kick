package com.github.andreyasadchy.xtra.ui.player.stream;

import androidx.lifecycle.o0;
import e6.x;
import e6.y0;
import e6.z1;
import javax.inject.Inject;
import t6.i0;
import xa.j;

public final class StreamPlayerViewModel extends i0 {

    /* renamed from: n  reason: collision with root package name */
    public final z1 f3444n;

    /* renamed from: o  reason: collision with root package name */
    public final o0 f3445o = new o0();

    /* renamed from: p  reason: collision with root package name */
    public final o0 f3446p = new o0();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public StreamPlayerViewModel(z1 z1Var, x xVar, y0 y0Var) {
        super(xVar, y0Var);
        j.f("playerRepository", z1Var);
        j.f("repository", xVar);
        j.f("localFollowsChannel", y0Var);
        this.f3444n = z1Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.github.andreyasadchy.xtra.model.ui.Stream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object g(com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r5, com.github.andreyasadchy.xtra.model.ui.Stream r6, pa.e r7) {
        /*
            r5.getClass()
            boolean r0 = r7 instanceof w6.k
            if (r0 == 0) goto L_0x0016
            r0 = r7
            w6.k r0 = (w6.k) r0
            int r1 = r0.f16152k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.f16152k = r1
            goto L_0x001b
        L_0x0016:
            w6.k r0 = new w6.k
            r0.<init>(r5, r7)
        L_0x001b:
            java.lang.Object r7 = r0.f16150i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f16152k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r5 = r0.f16149h
            hb.h0.O1(r7)
            goto L_0x0055
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            hb.h0.O1(r7)
            java.lang.String r6 = r6.getChannelSlug()
            if (r6 == 0) goto L_0x009c
            r0.f16149h = r5
            r0.f16152k = r3
            e6.x r7 = r5.f14603d
            r7.getClass()
            nb.d r2 = hb.p0.f7834b
            e6.n r3 = new e6.n
            r3.<init>(r7, r6, r4)
            java.lang.Object r7 = hb.h0.c2(r2, r3, r0)
            if (r7 != r1) goto L_0x0055
            goto L_0x009e
        L_0x0055:
            com.github.andreyasadchy.xtra.model.ui.Stream r7 = (com.github.andreyasadchy.xtra.model.ui.Stream) r7
            androidx.lifecycle.o0 r6 = r5.f3445o
            java.lang.Object r6 = r6.d()
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = (com.github.andreyasadchy.xtra.model.ui.Stream) r6
            if (r6 == 0) goto L_0x0097
            if (r7 == 0) goto L_0x006c
            int r0 = r7.getId()
            if (r0 == 0) goto L_0x006c
            r6.setId(r0)
        L_0x006c:
            if (r7 == 0) goto L_0x0077
            int r0 = r7.getGameId()
            if (r0 == 0) goto L_0x0077
            r6.setGameId(r0)
        L_0x0077:
            if (r7 == 0) goto L_0x007e
            java.lang.String r0 = r7.getGameName()
            goto L_0x007f
        L_0x007e:
            r0 = r4
        L_0x007f:
            r6.setGameName(r0)
            if (r7 == 0) goto L_0x0089
            java.lang.String r0 = r7.getTitle()
            goto L_0x008a
        L_0x0089:
            r0 = r4
        L_0x008a:
            r6.setTitle(r0)
            if (r7 == 0) goto L_0x0093
            java.lang.Integer r4 = r7.getViewerCount()
        L_0x0093:
            r6.setViewerCount(r4)
            r4 = r6
        L_0x0097:
            androidx.lifecycle.o0 r5 = r5.f3445o
            r5.j(r4)
        L_0x009c:
            la.v r1 = la.v.f9814a
        L_0x009e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel.g(com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel, com.github.andreyasadchy.xtra.model.ui.Stream, pa.e):java.lang.Object");
    }
}
