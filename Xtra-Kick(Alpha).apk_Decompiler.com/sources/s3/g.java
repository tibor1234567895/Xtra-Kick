package s3;

import fb.w;
import java.util.ArrayList;
import java.util.List;
import xa.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f14179a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f14180b;

    /* renamed from: c  reason: collision with root package name */
    public final List f14181c;

    /* renamed from: d  reason: collision with root package name */
    public final List f14182d;

    static {
        new f(0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public g(java.lang.String r5, java.util.List r6, boolean r7) {
        /*
            r4 = this;
            java.lang.String r0 = "columns"
            xa.j.f(r0, r6)
            int r0 = r6.size()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
        L_0x000f:
            if (r2 >= r0) goto L_0x0019
            java.lang.String r3 = "ASC"
            r1.add(r3)
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0019:
            r4.<init>(r5, r7, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.g.<init>(java.lang.String, java.util.List, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r5 = (s3.g) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            if (r4 != r5) goto L_0x0004
            r5 = 1
            return r5
        L_0x0004:
            boolean r0 = r5 instanceof s3.g
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            s3.g r5 = (s3.g) r5
            boolean r0 = r5.f14180b
            boolean r2 = r4.f14180b
            if (r2 == r0) goto L_0x0013
            return r1
        L_0x0013:
            java.util.List r0 = r4.f14181c
            java.util.List r2 = r5.f14181c
            boolean r0 = xa.j.a(r0, r2)
            if (r0 != 0) goto L_0x001e
            return r1
        L_0x001e:
            java.util.List r0 = r4.f14182d
            java.util.List r2 = r5.f14182d
            boolean r0 = xa.j.a(r0, r2)
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            java.lang.String r0 = r4.f14179a
            java.lang.String r2 = "index_"
            boolean r3 = fb.w.m(r0, r2, r1)
            java.lang.String r5 = r5.f14179a
            if (r3 == 0) goto L_0x003a
            boolean r5 = fb.w.m(r5, r2, r1)
            goto L_0x003e
        L_0x003a:
            boolean r5 = xa.j.a(r0, r5)
        L_0x003e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s3.g.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10;
        String str = this.f14179a;
        if (w.m(str, "index_", false)) {
            i10 = -1184239155;
        } else {
            i10 = str.hashCode();
        }
        int hashCode = this.f14181c.hashCode();
        return this.f14182d.hashCode() + ((hashCode + (((i10 * 31) + (this.f14180b ? 1 : 0)) * 31)) * 31);
    }

    public final String toString() {
        return "Index{name='" + this.f14179a + "', unique=" + this.f14180b + ", columns=" + this.f14181c + ", orders=" + this.f14182d + "'}";
    }

    public g(String str, boolean z10, List list, List list2) {
        j.f("columns", list);
        j.f("orders", list2);
        this.f14179a = str;
        this.f14180b = z10;
        this.f14181c = list;
        this.f14182d = list2;
        boolean isEmpty = list2.isEmpty();
        ArrayList arrayList = list2;
        if (isEmpty) {
            int size = list.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add("ASC");
            }
            arrayList = arrayList2;
        }
        this.f14182d = arrayList;
    }
}
