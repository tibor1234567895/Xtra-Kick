package n3;

import j3.w0;
import java.util.Iterator;
import kb.j;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class q extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public Iterator f11415i;

    /* renamed from: j  reason: collision with root package name */
    public int f11416j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11417k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w0 f11418l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(w0 w0Var, e eVar) {
        super(2, eVar);
        this.f11418l = w0Var;
    }

    public final e create(Object obj, e eVar) {
        q qVar = new q(this.f11418l, eVar);
        qVar.f11417k = obj;
        return qVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((q) create((j) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r6.f11416j
            j3.w0 r2 = r6.f11418l
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r4) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            java.util.Iterator r1 = r6.f11415i
            java.lang.Object r2 = r6.f11417k
            kb.j r2 = (kb.j) r2
            hb.h0.O1(r7)
            goto L_0x0052
        L_0x0018:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0020:
            java.lang.Object r1 = r6.f11417k
            kb.j r1 = (kb.j) r1
            hb.h0.O1(r7)
            goto L_0x0041
        L_0x0028:
            hb.h0.O1(r7)
            java.lang.Object r7 = r6.f11417k
            kb.j r7 = (kb.j) r7
            java.lang.Object r1 = r2.f8714a
            n3.g0 r1 = (n3.g0) r1
            r6.f11417k = r7
            r6.f11416j = r4
            java.io.Serializable r1 = r1.a(r6)
            if (r1 != r0) goto L_0x003e
            return r0
        L_0x003e:
            r5 = r1
            r1 = r7
            r7 = r5
        L_0x0041:
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r2 = r2.f8717d
            hb.l1 r2 = (hb.l1) r2
            hb.u1 r2 = (hb.u1) r2
            r2.X()
            java.util.Iterator r7 = r7.iterator()
            r2 = r1
            r1 = r7
        L_0x0052:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x006b
            java.lang.Object r7 = r1.next()
            ma.e0 r7 = (ma.e0) r7
            r6.f11417k = r2
            r6.f11415i = r1
            r6.f11416j = r3
            java.lang.Object r7 = r2.a(r7, r6)
            if (r7 != r0) goto L_0x0052
            return r0
        L_0x006b:
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n3.q.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
