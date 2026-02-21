package e6;

import hb.f0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class w extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public x f5254i;

    /* renamed from: j  reason: collision with root package name */
    public Collection f5255j;

    /* renamed from: k  reason: collision with root package name */
    public Iterator f5256k;

    /* renamed from: l  reason: collision with root package name */
    public int f5257l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List f5258m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ x f5259n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(List list, x xVar, e eVar) {
        super(2, eVar);
        this.f5258m = list;
        this.f5259n = xVar;
    }

    public final e create(Object obj, e eVar) {
        return new w(this.f5258m, this.f5259n, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((w) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r10.f5257l
            r2 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            java.util.Iterator r1 = r10.f5256k
            java.util.Collection r3 = r10.f5255j
            e6.x r4 = r10.f5254i
            hb.h0.O1(r11)
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            goto L_0x0060
        L_0x0018:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0020:
            hb.h0.O1(r11)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r1 = r10.f5258m
            java.util.Iterator r1 = r1.iterator()
            e6.x r3 = r10.f5259n
            r4 = r3
            r3 = r11
            r11 = r10
        L_0x0033:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x006d
            java.lang.Object r5 = r1.next()
            java.lang.String r5 = (java.lang.String) r5
            r11.f5254i = r4
            r11.f5255j = r3
            r11.f5256k = r1
            r11.f5257l = r2
            r4.getClass()
            nb.d r6 = hb.p0.f7834b
            e6.u r7 = new e6.u
            r8 = 0
            r7.<init>(r4, r5, r8)
            java.lang.Object r5 = hb.h0.c2(r6, r7, r11)
            if (r5 != r0) goto L_0x0059
            return r0
        L_0x0059:
            r9 = r0
            r0 = r11
            r11 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r9
        L_0x0060:
            com.github.andreyasadchy.xtra.model.ui.Video r11 = (com.github.andreyasadchy.xtra.model.ui.Video) r11
            if (r11 == 0) goto L_0x0067
            r4.add(r11)
        L_0x0067:
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L_0x0033
        L_0x006d:
            java.util.List r3 = (java.util.List) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
