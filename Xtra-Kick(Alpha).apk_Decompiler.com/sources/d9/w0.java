package d9;

import c9.r;
import java.util.Iterator;

public final class w0 extends a {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f4688j = 1;

    /* renamed from: k  reason: collision with root package name */
    public final Iterator f4689k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f4690l;

    public w0(a2 a2Var) {
        this.f4690l = a2Var;
        this.f4689k = a2Var.f4590h.iterator();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r1 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (((d9.a2) r2).f4591i.contains(r1) == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        r6.f4588h = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r4.hasNext() == false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r1 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (((c9.r) r2).apply(r1) == false) goto L_0x000c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r6.f4588h = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r4.hasNext() == false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a() {
        /*
            r6 = this;
            r0 = 3
            int r1 = r6.f4688j
            java.lang.Object r2 = r6.f4690l
            r3 = 0
            java.util.Iterator r4 = r6.f4689k
            switch(r1) {
                case 0: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0024
        L_0x000c:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r4.next()
            r5 = r2
            c9.r r5 = (c9.r) r5
            boolean r5 = r5.apply(r1)
            if (r5 == 0) goto L_0x000c
            r3 = r1
            goto L_0x0023
        L_0x0021:
            r6.f4588h = r0
        L_0x0023:
            return r3
        L_0x0024:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r4.next()
            r5 = r2
            d9.a2 r5 = (d9.a2) r5
            java.util.Set r5 = r5.f4591i
            boolean r5 = r5.contains(r1)
            if (r5 == 0) goto L_0x0024
            r3 = r1
            goto L_0x003d
        L_0x003b:
            r6.f4588h = r0
        L_0x003d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: d9.w0.a():java.lang.Object");
    }

    public w0(Iterator it, r rVar) {
        this.f4689k = it;
        this.f4690l = rVar;
    }
}
