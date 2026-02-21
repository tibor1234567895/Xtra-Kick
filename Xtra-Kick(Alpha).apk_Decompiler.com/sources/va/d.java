package va;

import java.io.File;
import xa.j;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15977b;

    /* renamed from: c  reason: collision with root package name */
    public File[] f15978c;

    /* renamed from: d  reason: collision with root package name */
    public int f15979d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f15980e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, File file) {
        super(file);
        j.f("rootDir", file);
        this.f15980e = eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        if (r0.length == 0) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File a() {
        /*
            r5 = this;
            boolean r0 = r5.f15977b
            java.io.File r1 = r5.f15983a
            va.e r2 = r5.f15980e
            if (r0 != 0) goto L_0x0011
            va.g r0 = r2.f15982k
            r0.getClass()
            r0 = 1
            r5.f15977b = r0
            return r1
        L_0x0011:
            java.io.File[] r0 = r5.f15978c
            r3 = 0
            if (r0 == 0) goto L_0x0025
            int r4 = r5.f15979d
            xa.j.c(r0)
            int r0 = r0.length
            if (r4 >= r0) goto L_0x001f
            goto L_0x0025
        L_0x001f:
            va.g r0 = r2.f15982k
            r0.getClass()
            return r3
        L_0x0025:
            java.io.File[] r0 = r5.f15978c
            if (r0 != 0) goto L_0x0046
            java.io.File[] r0 = r1.listFiles()
            r5.f15978c = r0
            if (r0 != 0) goto L_0x0036
            va.g r0 = r2.f15982k
            r0.getClass()
        L_0x0036:
            java.io.File[] r0 = r5.f15978c
            if (r0 == 0) goto L_0x0040
            xa.j.c(r0)
            int r0 = r0.length
            if (r0 != 0) goto L_0x0046
        L_0x0040:
            va.g r0 = r2.f15982k
            r0.getClass()
            return r3
        L_0x0046:
            java.io.File[] r0 = r5.f15978c
            xa.j.c(r0)
            int r1 = r5.f15979d
            int r2 = r1 + 1
            r5.f15979d = r2
            r0 = r0[r1]
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: va.d.a():java.io.File");
    }
}
