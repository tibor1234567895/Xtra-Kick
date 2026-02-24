package androidx.lifecycle;

import hb.f0;
import la.v;
import ob.a;
import pa.e;
import ra.i;
import wa.p;

public final class a1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public a f1646i;

    /* renamed from: j  reason: collision with root package name */
    public p f1647j;

    /* renamed from: k  reason: collision with root package name */
    public int f1648k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ a f1649l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ p f1650m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(a aVar, p pVar, e eVar) {
        super(2, eVar);
        this.f1649l = aVar;
        this.f1650m = pVar;
    }

    public final e create(Object obj, e eVar) {
        return new a1(this.f1649l, this.f1650m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((a1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: ob.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: ob.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r5.f1648k
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            ob.a r0 = r5.f1646i
            hb.h0.O1(r6)     // Catch:{ all -> 0x0013 }
            goto L_0x004f
        L_0x0013:
            r6 = move-exception
            goto L_0x0059
        L_0x0015:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001d:
            wa.p r1 = r5.f1647j
            ob.a r3 = r5.f1646i
            hb.h0.O1(r6)
            goto L_0x003c
        L_0x0025:
            hb.h0.O1(r6)
            ob.a r6 = r5.f1649l
            r5.f1646i = r6
            wa.p r1 = r5.f1650m
            r5.f1647j = r1
            r5.f1648k = r3
            r3 = r6
            ob.d r3 = (ob.d) r3
            java.lang.Object r6 = r3.e(r5)
            if (r6 != r0) goto L_0x003c
            return r0
        L_0x003c:
            androidx.lifecycle.z0 r6 = new androidx.lifecycle.z0     // Catch:{ all -> 0x005b }
            r6.<init>(r1, r4)     // Catch:{ all -> 0x005b }
            r5.f1646i = r3     // Catch:{ all -> 0x005b }
            r5.f1647j = r4     // Catch:{ all -> 0x005b }
            r5.f1648k = r2     // Catch:{ all -> 0x005b }
            java.lang.Object r6 = hb.h0.H(r6, r5)     // Catch:{ all -> 0x005b }
            if (r6 != r0) goto L_0x004e
            return r0
        L_0x004e:
            r0 = r3
        L_0x004f:
            la.v r6 = la.v.f9814a     // Catch:{ all -> 0x0013 }
            ob.d r0 = (ob.d) r0
            r0.f(r4)
            la.v r6 = la.v.f9814a
            return r6
        L_0x0059:
            r3 = r0
            goto L_0x005c
        L_0x005b:
            r6 = move-exception
        L_0x005c:
            ob.d r3 = (ob.d) r3
            r3.f(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.a1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
