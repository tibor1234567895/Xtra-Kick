package n3;

import android.content.Context;
import com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel;
import com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel;
import com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel;
import hb.f0;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;
import wa.q;

public final class t extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11478i;

    /* renamed from: j  reason: collision with root package name */
    public int f11479j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11480k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11481l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f11482m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(Object obj, e eVar, int i10) {
        super(3, eVar);
        this.f11478i = i10;
        this.f11482m = obj;
    }

    public final Object e(Object obj, Object obj2, Object obj3) {
        switch (this.f11478i) {
            case 0:
                return l((j) obj, obj2, (e) obj3);
            case 1:
                t tVar = new t((Object) (d1) this.f11482m, (e) obj3, 1);
                tVar.f11480k = (r0) obj;
                tVar.f11481l = (r0) obj2;
                return tVar.invokeSuspend(v.f9814a);
            case 2:
                return l((j) obj, obj2, (e) obj3);
            case 3:
                return l((j) obj, obj2, (e) obj3);
            case 4:
                return l((j) obj, obj2, (e) obj3);
            case Constants.MAX_COMPATIBILITY_VERSION:
                return l((j) obj, obj2, (e) obj3);
            case 6:
                return l((j) obj, obj2, (e) obj3);
            default:
                return l((j) obj, obj2, (e) obj3);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: kb.j} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            r1 = 3
            r2 = 10
            r3 = 30
            int r4 = r11.f11478i
            r5 = 2
            r6 = 0
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            java.lang.Object r8 = r11.f11482m
            r9 = 1
            switch(r4) {
                case 0: goto L_0x01a0;
                case 1: goto L_0x0163;
                case 2: goto L_0x0125;
                case 3: goto L_0x00e6;
                case 4: goto L_0x00a9;
                case 5: goto L_0x0052;
                case 6: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x01ce
        L_0x0015:
            int r1 = r11.f11479j
            if (r1 == 0) goto L_0x0025
            if (r1 != r9) goto L_0x001f
            hb.h0.O1(r12)
            goto L_0x004f
        L_0x001f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x0025:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r1 = r11.f11481l
            java.lang.String r1 = (java.lang.String) r1
            e.a r4 = new e.a
            n3.r3 r5 = new n3.r3
            r5.<init>(r3, r2, r3)
            l3.j r2 = new l3.j
            com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel r8 = (com.github.andreyasadchy.xtra.ui.search.tags.TagSearchViewModel) r8
            r3 = 7
            r2.<init>(r8, r3, r1)
            r4.<init>((n3.r3) r5, (wa.a) r2)
            java.lang.Object r1 = r4.f4852i
            kb.i r1 = (kb.i) r1
            r11.f11479j = r9
            java.lang.Object r12 = hb.h0.Q(r12, r1, r11)
            if (r12 != r0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            la.v r0 = la.v.f9814a
        L_0x0051:
            return r0
        L_0x0052:
            int r4 = r11.f11479j
            if (r4 == 0) goto L_0x0062
            if (r4 != r9) goto L_0x005c
            hb.h0.O1(r12)
            goto L_0x00a6
        L_0x005c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x0062:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r4 = r11.f11481l
            java.lang.String r4 = (java.lang.String) r4
            e.a r5 = new e.a
            android.content.Context r8 = (android.content.Context) r8
            android.content.SharedPreferences r7 = hb.h0.l1(r8)
            java.lang.String r8 = "compactStreamsV2"
            java.lang.String r10 = "disabled"
            java.lang.String r7 = r7.getString(r8, r10)
            java.lang.String r8 = "all"
            boolean r7 = xa.j.a(r7, r8)
            if (r7 == 0) goto L_0x008b
            n3.r3 r1 = new n3.r3
            r1.<init>(r3, r2, r3)
            goto L_0x0091
        L_0x008b:
            n3.r3 r2 = new n3.r3
            r2.<init>(r3, r1, r3)
            r1 = r2
        L_0x0091:
            e7.i r2 = new e7.i
            r2.<init>(r4, r6)
            r5.<init>((n3.r3) r1, (wa.a) r2)
            java.lang.Object r1 = r5.f4852i
            kb.i r1 = (kb.i) r1
            r11.f11479j = r9
            java.lang.Object r12 = hb.h0.Q(r12, r1, r11)
            if (r12 != r0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            la.v r0 = la.v.f9814a
        L_0x00a8:
            return r0
        L_0x00a9:
            int r1 = r11.f11479j
            if (r1 == 0) goto L_0x00b9
            if (r1 != r9) goto L_0x00b3
            hb.h0.O1(r12)
            goto L_0x00e3
        L_0x00b3:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x00b9:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r1 = r11.f11481l
            java.lang.String r1 = (java.lang.String) r1
            e.a r4 = new e.a
            n3.r3 r5 = new n3.r3
            r5.<init>(r3, r2, r3)
            l3.j r2 = new l3.j
            com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel r8 = (com.github.andreyasadchy.xtra.ui.search.games.GameSearchViewModel) r8
            r3 = 6
            r2.<init>(r1, r3, r8)
            r4.<init>((n3.r3) r5, (wa.a) r2)
            java.lang.Object r1 = r4.f4852i
            kb.i r1 = (kb.i) r1
            r11.f11479j = r9
            java.lang.Object r12 = hb.h0.Q(r12, r1, r11)
            if (r12 != r0) goto L_0x00e3
            goto L_0x00e5
        L_0x00e3:
            la.v r0 = la.v.f9814a
        L_0x00e5:
            return r0
        L_0x00e6:
            int r1 = r11.f11479j
            if (r1 == 0) goto L_0x00f6
            if (r1 != r9) goto L_0x00f0
            hb.h0.O1(r12)
            goto L_0x0122
        L_0x00f0:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x00f6:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r1 = r11.f11481l
            java.lang.String r1 = (java.lang.String) r1
            e.a r2 = new e.a
            n3.r3 r3 = new n3.r3
            r4 = 15
            r5 = 5
            r3.<init>(r4, r5, r4)
            l3.j r4 = new l3.j
            com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel r8 = (com.github.andreyasadchy.xtra.ui.search.channels.ChannelSearchViewModel) r8
            r4.<init>(r1, r5, r8)
            r2.<init>((n3.r3) r3, (wa.a) r4)
            java.lang.Object r1 = r2.f4852i
            kb.i r1 = (kb.i) r1
            r11.f11479j = r9
            java.lang.Object r12 = hb.h0.Q(r12, r1, r11)
            if (r12 != r0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            la.v r0 = la.v.f9814a
        L_0x0124:
            return r0
        L_0x0125:
            int r2 = r11.f11479j
            if (r2 == 0) goto L_0x0135
            if (r2 != r9) goto L_0x012f
            hb.h0.O1(r12)
            goto L_0x0160
        L_0x012f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x0135:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r2 = r11.f11481l
            k6.g r2 = (k6.g) r2
            e.a r3 = new e.a
            n3.r3 r4 = new n3.r3
            r6 = 20
            r4.<init>(r6, r1, r6)
            l3.j r1 = new l3.j
            com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel r8 = (com.github.andreyasadchy.xtra.ui.clips.common.ClipsViewModel) r8
            r1.<init>(r2, r5, r8)
            r3.<init>((n3.r3) r4, (wa.a) r1)
            java.lang.Object r1 = r3.f4852i
            kb.i r1 = (kb.i) r1
            r11.f11479j = r9
            java.lang.Object r12 = hb.h0.Q(r12, r1, r11)
            if (r12 != r0) goto L_0x0160
            goto L_0x0162
        L_0x0160:
            la.v r0 = la.v.f9814a
        L_0x0162:
            return r0
        L_0x0163:
            int r0 = r11.f11479j
            if (r0 != 0) goto L_0x019a
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            n3.r0 r12 = (n3.r0) r12
            java.lang.Object r0 = r11.f11481l
            n3.r0 r0 = (n3.r0) r0
            n3.d1 r8 = (n3.d1) r8
            java.lang.String r1 = "<this>"
            xa.j.f(r1, r0)
            java.lang.String r1 = "previous"
            xa.j.f(r1, r12)
            java.lang.String r1 = "loadType"
            xa.j.f(r1, r8)
            int r1 = r0.f11451a
            int r2 = r12.f11451a
            if (r1 <= r2) goto L_0x018b
            r6 = 1
            goto L_0x0196
        L_0x018b:
            if (r1 >= r2) goto L_0x018e
            goto L_0x0196
        L_0x018e:
            n3.a6 r1 = r0.f11452b
            n3.a6 r2 = r12.f11452b
            boolean r6 = hb.h0.E1(r1, r2, r8)
        L_0x0196:
            if (r6 == 0) goto L_0x0199
            r12 = r0
        L_0x0199:
            return r12
        L_0x019a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x01a0:
            int r1 = r11.f11479j
            if (r1 == 0) goto L_0x01b0
            if (r1 != r9) goto L_0x01aa
            hb.h0.O1(r12)
            goto L_0x01cb
        L_0x01aa:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x01b0:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            kb.j r12 = (kb.j) r12
            java.lang.Object r1 = r11.f11481l
            n3.u3 r1 = (n3.u3) r1
            n3.f1 r2 = new n3.f1
            hb.f0 r8 = (hb.f0) r8
            r2.<init>(r8, r1)
            r11.f11479j = r9
            java.lang.Object r12 = r12.a(r2, r11)
            if (r12 != r0) goto L_0x01cb
            goto L_0x01cd
        L_0x01cb:
            la.v r0 = la.v.f9814a
        L_0x01cd:
            return r0
        L_0x01ce:
            int r1 = r11.f11479j
            if (r1 == 0) goto L_0x01e8
            if (r1 == r9) goto L_0x01e0
            if (r1 != r5) goto L_0x01da
            hb.h0.O1(r12)
            goto L_0x020b
        L_0x01da:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>(r7)
            throw r12
        L_0x01e0:
            java.lang.Object r1 = r11.f11480k
            kb.j r1 = (kb.j) r1
            hb.h0.O1(r12)
            goto L_0x01ff
        L_0x01e8:
            hb.h0.O1(r12)
            java.lang.Object r12 = r11.f11480k
            r1 = r12
            kb.j r1 = (kb.j) r1
            java.lang.Object r12 = r11.f11481l
            wa.p r8 = (wa.p) r8
            r11.f11480k = r1
            r11.f11479j = r9
            java.lang.Object r12 = r8.g(r12, r11)
            if (r12 != r0) goto L_0x01ff
            goto L_0x020d
        L_0x01ff:
            r2 = 0
            r11.f11480k = r2
            r11.f11479j = r5
            java.lang.Object r12 = r1.a(r12, r11)
            if (r12 != r0) goto L_0x020b
            goto L_0x020d
        L_0x020b:
            la.v r0 = la.v.f9814a
        L_0x020d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object l(j jVar, Object obj, e eVar) {
        int i10 = this.f11478i;
        Object obj2 = this.f11482m;
        switch (i10) {
            case 0:
                t tVar = new t(eVar, (Object) (f0) obj2, 0);
                tVar.f11480k = jVar;
                tVar.f11481l = obj;
                return tVar.invokeSuspend(v.f9814a);
            case 2:
                t tVar2 = new t(eVar, (Object) (ClipsViewModel) obj2, 2);
                tVar2.f11480k = jVar;
                tVar2.f11481l = obj;
                return tVar2.invokeSuspend(v.f9814a);
            case 3:
                t tVar3 = new t(eVar, (Object) (ChannelSearchViewModel) obj2, 3);
                tVar3.f11480k = jVar;
                tVar3.f11481l = obj;
                return tVar3.invokeSuspend(v.f9814a);
            case 4:
                t tVar4 = new t(eVar, (Object) (GameSearchViewModel) obj2, 4);
                tVar4.f11480k = jVar;
                tVar4.f11481l = obj;
                return tVar4.invokeSuspend(v.f9814a);
            case Constants.MAX_COMPATIBILITY_VERSION:
                t tVar5 = new t(eVar, (Object) (Context) obj2, 5);
                tVar5.f11480k = jVar;
                tVar5.f11481l = obj;
                return tVar5.invokeSuspend(v.f9814a);
            case 6:
                t tVar6 = new t(eVar, (Object) (TagSearchViewModel) obj2, 6);
                tVar6.f11480k = jVar;
                tVar6.f11481l = obj;
                return tVar6.invokeSuspend(v.f9814a);
            default:
                t tVar7 = new t((Object) (p) obj2, eVar, 7);
                tVar7.f11480k = jVar;
                tVar7.f11481l = obj;
                return tVar7.invokeSuspend(v.f9814a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(e eVar, Object obj, int i10) {
        super(3, eVar);
        this.f11478i = i10;
        this.f11482m = obj;
    }
}
