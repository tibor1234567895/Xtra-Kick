package w6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import hb.f0;
import la.v;
import pa.e;
import wa.p;

public final class i extends ra.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16140i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f16141j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ StreamPlayerViewModel f16142k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f16143l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Stream f16144m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(StreamPlayerViewModel streamPlayerViewModel, Context context, Stream stream, e eVar) {
        super(2, eVar);
        this.f16142k = streamPlayerViewModel;
        this.f16143l = context;
        this.f16144m = stream;
    }

    public final e create(Object obj, e eVar) {
        i iVar = new i(this.f16142k, this.f16143l, this.f16144m, eVar);
        iVar.f16141j = obj;
        return iVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((i) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: hb.f0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC, Splitter:B:24:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r7.f16140i
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r4) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r1 = r7.f16141j
            hb.f0 r1 = (hb.f0) r1
            hb.h0.O1(r8)
            goto L_0x003b
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001f:
            java.lang.Object r1 = r7.f16141j
            hb.f0 r1 = (hb.f0) r1
            hb.h0.O1(r8)     // Catch:{ Exception -> 0x0030 }
            goto L_0x003b
        L_0x0027:
            java.lang.Object r1 = r7.f16141j
            hb.f0 r1 = (hb.f0) r1
            hb.h0.O1(r8)     // Catch:{ Exception -> 0x0030 }
            r8 = r7
            goto L_0x0061
        L_0x0030:
            r8 = r7
            goto L_0x0070
        L_0x0033:
            hb.h0.O1(r8)
            java.lang.Object r8 = r7.f16141j
            r1 = r8
            hb.f0 r1 = (hb.f0) r1
        L_0x003b:
            r8 = r7
        L_0x003c:
            pa.k r5 = r1.v()
            hb.k1 r6 = hb.l1.f7823b
            pa.h r5 = r5.N(r6)
            hb.l1 r5 = (hb.l1) r5
            if (r5 == 0) goto L_0x004f
            boolean r5 = r5.c()
            goto L_0x0050
        L_0x004f:
            r5 = 1
        L_0x0050:
            if (r5 == 0) goto L_0x007e
            com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel r5 = r8.f16142k     // Catch:{ Exception -> 0x006f }
            com.github.andreyasadchy.xtra.model.ui.Stream r6 = r8.f16144m     // Catch:{ Exception -> 0x006f }
            r8.f16141j = r1     // Catch:{ Exception -> 0x006f }
            r8.f16140i = r4     // Catch:{ Exception -> 0x006f }
            java.lang.Object r5 = com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel.g(r5, r6, r8)     // Catch:{ Exception -> 0x006f }
            if (r5 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r8.f16141j = r1     // Catch:{ Exception -> 0x006f }
            r8.f16140i = r3     // Catch:{ Exception -> 0x006f }
            r5 = 300000(0x493e0, double:1.482197E-318)
            java.lang.Object r5 = hb.h0.L(r5, r8)     // Catch:{ Exception -> 0x006f }
            if (r5 != r0) goto L_0x003c
            return r0
        L_0x006f:
        L_0x0070:
            r8.f16141j = r1
            r8.f16140i = r2
            r5 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r5 = hb.h0.L(r5, r8)
            if (r5 != r0) goto L_0x003c
            return r0
        L_0x007e:
            la.v r8 = la.v.f9814a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: w6.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
