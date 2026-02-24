package fb;

import java.util.List;
import wa.a;
import wb.v;
import xa.k;

public final class j extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6008h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6009i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f6010j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f6011k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(l lVar, String str, int i10) {
        super(0);
        this.f6010j = lVar;
        this.f6011k = str;
        this.f6009i = i10;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b() {
        /*
            r4 = this;
            int r0 = r4.f6008h
            switch(r0) {
                case 0: goto L_0x0006;
                default: goto L_0x0005;
            }
        L_0x0005:
            goto L_0x0032
        L_0x0006:
            java.lang.Object r0 = r4.f6010j
            fb.l r0 = (fb.l) r0
            java.lang.Object r1 = r4.f6011k
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r4.f6009i
            r0.getClass()
            java.lang.String r3 = "input"
            xa.j.f(r3, r1)
            java.util.regex.Pattern r0 = r0.f6013h
            java.util.regex.Matcher r0 = r0.matcher(r1)
            java.lang.String r3 = "nativePattern.matcher(input)"
            xa.j.e(r3, r0)
            boolean r2 = r0.find(r2)
            if (r2 != 0) goto L_0x002b
            r0 = 0
            goto L_0x0031
        L_0x002b:
            fb.h r2 = new fb.h
            r2.<init>(r0, r1)
            r0 = r2
        L_0x0031:
            return r0
        L_0x0032:
            java.lang.Object r0 = r4.f6010j
            wb.v r0 = (wb.v) r0
            wb.l0 r0 = r0.f16322s
            java.lang.Object r1 = r4.f6011k
            java.util.List r1 = (java.util.List) r1
            r0.getClass()
            java.lang.String r0 = "requestHeaders"
            xa.j.f(r0, r1)
            java.lang.Object r0 = r4.f6010j
            wb.v r0 = (wb.v) r0
            int r1 = r4.f6009i
            wb.i0 r2 = r0.F     // Catch:{ IOException -> 0x0060 }
            wb.c r3 = wb.c.CANCEL     // Catch:{ IOException -> 0x0060 }
            r2.N(r1, r3)     // Catch:{ IOException -> 0x0060 }
            monitor-enter(r0)     // Catch:{ IOException -> 0x0060 }
            java.util.LinkedHashSet r2 = r0.H     // Catch:{ all -> 0x005d }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x005d }
            r2.remove(r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ IOException -> 0x0060 }
            goto L_0x0060
        L_0x005d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ IOException -> 0x0060 }
            throw r1     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            la.v r0 = la.v.f9814a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.j.b():java.lang.Object");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(v vVar, int i10, List list) {
        super(0);
        this.f6010j = vVar;
        this.f6009i = i10;
        this.f6011k = list;
    }
}
