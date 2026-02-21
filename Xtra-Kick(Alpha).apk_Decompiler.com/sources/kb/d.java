package kb;

import jb.a;
import lb.f;
import pa.k;
import wa.p;

public final class d extends f {

    /* renamed from: k  reason: collision with root package name */
    public final p f9278k;

    /* renamed from: l  reason: collision with root package name */
    public final p f9279l;

    public d(p pVar, k kVar, int i10, a aVar) {
        super(kVar, i10, aVar);
        this.f9278k = pVar;
        this.f9279l = pVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(jb.r r5, pa.e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kb.c
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kb.c r0 = (kb.c) r0
            int r1 = r0.f9272k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9272k = r1
            goto L_0x0018
        L_0x0013:
            kb.c r0 = new kb.c
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f9270i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9272k
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            jb.r r5 = r0.f9269h
            hb.h0.O1(r6)
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            hb.h0.O1(r6)
            r0.f9269h = r5
            r0.f9272k = r3
            wa.p r6 = r4.f9278k
            java.lang.Object r6 = r6.g(r5, r0)
            if (r6 != r1) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            la.v r6 = la.v.f9814a
        L_0x0043:
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            jb.q r5 = (jb.q) r5
            boolean r5 = r5.l()
            if (r5 == 0) goto L_0x0051
            la.v r5 = la.v.f9814a
            return r5
        L_0x0051:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kb.d.f(jb.r, pa.e):java.lang.Object");
    }

    public final f g(k kVar, int i10, a aVar) {
        return new d(this.f9279l, kVar, i10, aVar);
    }

    /* renamed from: k */
    public final String toString() {
        return "block[" + this.f9278k + "] -> " + super.toString();
    }
}
