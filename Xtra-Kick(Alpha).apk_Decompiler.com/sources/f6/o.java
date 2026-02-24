package f6;

import hb.f0;
import java.util.Iterator;
import java.util.List;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class o extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public List f5872i;

    /* renamed from: j  reason: collision with root package name */
    public Iterator f5873j;

    /* renamed from: k  reason: collision with root package name */
    public int f5874k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f5875l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List f5876m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ p f5877n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(List list, p pVar, e eVar) {
        super(2, eVar);
        this.f5876m = list;
        this.f5877n = pVar;
    }

    public final e create(Object obj, e eVar) {
        o oVar = new o(this.f5876m, this.f5877n, eVar);
        oVar.f5875l = obj;
        return oVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((o) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r12.f5874k
            r2 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.util.Iterator r1 = r12.f5873j
            java.util.List r3 = r12.f5872i
            java.lang.Object r4 = r12.f5875l
            hb.f0 r4 = (hb.f0) r4
            hb.h0.O1(r13)
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r12
            goto L_0x008b
        L_0x001b:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0023:
            hb.h0.O1(r13)
            java.lang.Object r13 = r12.f5875l
            hb.f0 r13 = (hb.f0) r13
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r3 = r12.f5876m
            r4 = 10
            java.util.ArrayList r3 = ma.z.m(r3, r4)
            java.util.Iterator r3 = r3.iterator()
            r4 = r13
            r13 = r12
            r11 = r3
            r3 = r1
            r1 = r11
        L_0x0040:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r1.next()
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = ma.s.i(r5)
            r6.<init>(r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x0059:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0075
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            f6.n r8 = new f6.n
            r9 = 0
            f6.p r10 = r13.f5877n
            r8.<init>(r10, r7, r9)
            hb.l0 r7 = hb.h0.i(r4, r8)
            r6.add(r7)
            goto L_0x0059
        L_0x0075:
            r13.f5875l = r4
            r13.f5872i = r3
            r13.f5873j = r1
            r13.f5874k = r2
            java.lang.Object r5 = hb.h0.j(r6, r13)
            if (r5 != r0) goto L_0x0084
            return r0
        L_0x0084:
            r11 = r0
            r0 = r13
            r13 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r11
        L_0x008b:
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.util.ArrayList r13 = ma.z.q(r13)
            r13.toString()
            r4.addAll(r13)
            r13 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L_0x0040
        L_0x009d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
