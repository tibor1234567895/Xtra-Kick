package e6;

import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class i0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f5149i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f5150j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ s0 f5151k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f5152l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(s0 s0Var, String str, e eVar) {
        super(2, eVar);
        this.f5151k = s0Var;
        this.f5152l = str;
    }

    public final e create(Object obj, e eVar) {
        i0 i0Var = new i0(this.f5151k, this.f5152l, eVar);
        i0Var.f5150j = obj;
        return i0Var;
    }

    public final Object g(Object obj, Object obj2) {
        return ((i0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: hb.f0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r8.f5149i
            e6.s0 r2 = r8.f5151k
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r4) goto L_0x001a
            if (r1 != r3) goto L_0x0012
            hb.h0.O1(r9)
            goto L_0x007b
        L_0x0012:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001a:
            java.lang.Object r1 = r8.f5150j
            hb.f0 r1 = (hb.f0) r1
            hb.h0.O1(r9)
            goto L_0x0039
        L_0x0022:
            hb.h0.O1(r9)
            java.lang.Object r9 = r8.f5150j
            r1 = r9
            hb.f0 r1 = (hb.f0) r1
            com.github.andreyasadchy.xtra.api.KickApi r9 = r2.f5233a
            r8.f5150j = r1
            r8.f5149i = r4
            java.lang.String r4 = r8.f5152l
            java.lang.Object r9 = r9.getChannelLegacy(r4, r8)
            if (r9 != r0) goto L_0x0039
            return r0
        L_0x0039:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel r9 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Channel) r9
            java.util.List r9 = r9.getPreviousLivestreams()
            if (r9 == 0) goto L_0x007f
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x004a:
            boolean r5 = r9.hasNext()
            r6 = 0
            if (r5 == 0) goto L_0x0070
            java.lang.Object r5 = r9.next()
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.PreviousLivestream r5 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v1.PreviousLivestream) r5
            com.github.andreyasadchy.xtra.model.retrofit.kick.v1.Video r5 = r5.getVideo()
            java.lang.String r5 = r5.getUuid()
            if (r5 == 0) goto L_0x006a
            e6.h0 r7 = new e6.h0
            r7.<init>(r2, r5, r6)
            hb.l0 r6 = hb.h0.i(r1, r7)
        L_0x006a:
            if (r6 == 0) goto L_0x004a
            r4.add(r6)
            goto L_0x004a
        L_0x0070:
            r8.f5150j = r6
            r8.f5149i = r3
            java.lang.Object r9 = hb.h0.j(r4, r8)
            if (r9 != r0) goto L_0x007b
            return r0
        L_0x007b:
            java.util.List r9 = (java.util.List) r9
            if (r9 != 0) goto L_0x0081
        L_0x007f:
            ma.b0 r9 = ma.b0.f10801h
        L_0x0081:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.i0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
