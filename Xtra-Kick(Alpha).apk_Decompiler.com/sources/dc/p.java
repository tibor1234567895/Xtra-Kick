package dc;

import androidx.fragment.app.k;
import java.util.ArrayList;
import java.util.Map;
import ma.j0;
import ma.z;
import xa.j;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f4811a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4812b;

    /* renamed from: c  reason: collision with root package name */
    public final f0 f4813c;

    /* renamed from: d  reason: collision with root package name */
    public final Long f4814d;

    /* renamed from: e  reason: collision with root package name */
    public final Long f4815e;

    /* renamed from: f  reason: collision with root package name */
    public final Long f4816f;

    /* renamed from: g  reason: collision with root package name */
    public final Long f4817g;

    /* renamed from: h  reason: collision with root package name */
    public final Map f4818h;

    public p() {
        this(false, false, (f0) null, (Long) null, (Long) null, (Long) null, (Long) null, 255);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f4811a) {
            arrayList.add("isRegularFile");
        }
        if (this.f4812b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f4814d;
        if (l10 != null) {
            arrayList.add("byteCount=" + l10);
        }
        Long l11 = this.f4815e;
        if (l11 != null) {
            arrayList.add("createdAt=" + l11);
        }
        Long l12 = this.f4816f;
        if (l12 != null) {
            arrayList.add("lastModifiedAt=" + l12);
        }
        Long l13 = this.f4817g;
        if (l13 != null) {
            arrayList.add("lastAccessedAt=" + l13);
        }
        Map map = this.f4818h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return z.y(arrayList, ", ", "FileMetadata(", ")", (k) null, 56);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ p(boolean r13, boolean r14, dc.f0 r15, java.lang.Long r16, java.lang.Long r17, java.lang.Long r18, java.lang.Long r19, int r20) {
        /*
            r12 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = 0
            goto L_0x000a
        L_0x0009:
            r4 = r13
        L_0x000a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0010
            r5 = 0
            goto L_0x0011
        L_0x0010:
            r5 = r14
        L_0x0011:
            r1 = r0 & 4
            r2 = 0
            if (r1 == 0) goto L_0x0018
            r6 = r2
            goto L_0x0019
        L_0x0018:
            r6 = r15
        L_0x0019:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x001f
            r7 = r2
            goto L_0x0021
        L_0x001f:
            r7 = r16
        L_0x0021:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0027
            r8 = r2
            goto L_0x0029
        L_0x0027:
            r8 = r17
        L_0x0029:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            r9 = r2
            goto L_0x0031
        L_0x002f:
            r9 = r18
        L_0x0031:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0037
            r10 = r2
            goto L_0x0039
        L_0x0037:
            r10 = r19
        L_0x0039:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0043
            ma.c0 r0 = ma.j0.d()
            r11 = r0
            goto L_0x0044
        L_0x0043:
            r11 = r2
        L_0x0044:
            r3 = r12
            r3.<init>((boolean) r4, (boolean) r5, (dc.f0) r6, (java.lang.Long) r7, (java.lang.Long) r8, (java.lang.Long) r9, (java.lang.Long) r10, (java.util.Map) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.p.<init>(boolean, boolean, dc.f0, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, int):void");
    }

    public p(boolean z10, boolean z11, f0 f0Var, Long l10, Long l11, Long l12, Long l13, Map map) {
        j.f("extras", map);
        this.f4811a = z10;
        this.f4812b = z11;
        this.f4813c = f0Var;
        this.f4814d = l10;
        this.f4815e = l11;
        this.f4816f = l12;
        this.f4817g = l13;
        this.f4818h = j0.g(map);
    }
}
