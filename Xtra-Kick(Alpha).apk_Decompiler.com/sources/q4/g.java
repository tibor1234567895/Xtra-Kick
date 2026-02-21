package q4;

import android.support.v4.media.h;
import android.support.v4.media.session.u;
import i4.m;
import i4.t;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ma.j0;
import o4.b;
import s4.i;
import xa.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final m f13329a;

    /* renamed from: b  reason: collision with root package name */
    public final u f13330b;

    static {
        new f(0);
    }

    public g(m mVar, u uVar) {
        this.f13329a = mVar;
        this.f13330b = uVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static s4.r c(n4.m r9, s4.i r10, q4.d r11, q4.e r12) {
        /*
            s4.r r8 = new s4.r
            android.content.Context r0 = r10.f14249a
            android.content.res.Resources r0 = r0.getResources()
            android.graphics.drawable.BitmapDrawable r1 = new android.graphics.drawable.BitmapDrawable
            android.graphics.Bitmap r2 = r12.f13327a
            r1.<init>(r0, r2)
            r3 = 1
            java.lang.String r0 = "coil#disk_cache_key"
            java.util.Map r12 = r12.f13328b
            java.lang.Object r0 = r12.get(r0)
            boolean r2 = r0 instanceof java.lang.String
            r4 = 0
            if (r2 == 0) goto L_0x0021
            java.lang.String r0 = (java.lang.String) r0
            r5 = r0
            goto L_0x0022
        L_0x0021:
            r5 = r4
        L_0x0022:
            java.lang.String r0 = "coil#is_sampled"
            java.lang.Object r12 = r12.get(r0)
            boolean r0 = r12 instanceof java.lang.Boolean
            if (r0 == 0) goto L_0x002f
            r4 = r12
            java.lang.Boolean r4 = (java.lang.Boolean) r4
        L_0x002f:
            r12 = 0
            if (r4 == 0) goto L_0x0038
            boolean r0 = r4.booleanValue()
            r6 = r0
            goto L_0x0039
        L_0x0038:
            r6 = 0
        L_0x0039:
            android.graphics.Bitmap$Config[] r0 = w4.e.f16080a
            boolean r0 = r9 instanceof n4.m
            if (r0 == 0) goto L_0x0046
            boolean r9 = r9.f11703g
            if (r9 == 0) goto L_0x0046
            r9 = 1
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            r0 = r8
            r2 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.g.c(n4.m, s4.i, q4.d, q4.e):s4.r");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e1, code lost:
        if (java.lang.Math.abs(((double) r3) - (r11 * ((double) r4))) > 1.0d) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0108, code lost:
        if (java.lang.Math.abs(r3 - r4) > 1) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0114, code lost:
        if (r1 == false) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        if (r7 != false) goto L_0x011d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0122  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final q4.e a(s4.i r19, q4.d r20, t4.g r21, int r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            int r4 = r1.J
            boolean r4 = q0.f.d(r4)
            r5 = 0
            if (r4 != 0) goto L_0x0012
            return r5
        L_0x0012:
            i4.m r4 = r0.f13329a
            i4.t r4 = (i4.t) r4
            la.e r4 = r4.f8273b
            java.lang.Object r4 = r4.getValue()
            q4.h r4 = (q4.h) r4
            if (r4 == 0) goto L_0x002f
            q4.o r6 = r4.f13331a
            q4.e r6 = r6.b(r2)
            if (r6 != 0) goto L_0x0030
            q4.p r4 = r4.f13332b
            q4.e r6 = r4.b(r2)
            goto L_0x0030
        L_0x002f:
            r6 = r5
        L_0x0030:
            if (r6 == 0) goto L_0x0125
            android.graphics.Bitmap r4 = r6.f13327a
            android.graphics.Bitmap$Config r7 = r4.getConfig()
            if (r7 != 0) goto L_0x003c
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x003c:
            android.support.v4.media.session.u r8 = r0.f13330b
            r8.getClass()
            boolean r7 = android.support.v4.media.session.u.E(r1, r7)
            if (r7 != 0) goto L_0x004b
        L_0x0047:
            r17 = r6
            goto L_0x011d
        L_0x004b:
            java.util.Map r7 = r6.f13328b
            java.lang.String r9 = "coil#is_sampled"
            java.lang.Object r7 = r7.get(r9)
            boolean r9 = r7 instanceof java.lang.Boolean
            if (r9 == 0) goto L_0x005a
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x005b
        L_0x005a:
            r7 = r5
        L_0x005b:
            if (r7 == 0) goto L_0x0062
            boolean r7 = r7.booleanValue()
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            boolean r9 = hb.h0.Z0(r21)
            r10 = 1
            if (r9 == 0) goto L_0x0071
            if (r7 == 0) goto L_0x006d
            goto L_0x0047
        L_0x006d:
            r17 = r6
            goto L_0x011f
        L_0x0071:
            java.util.Map r2 = r2.f13326i
            java.lang.String r9 = "coil#transformation_size"
            java.lang.Object r2 = r2.get(r9)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0089
            java.lang.String r1 = r21.toString()
            boolean r8 = xa.j.a(r2, r1)
            r17 = r6
            goto L_0x0120
        L_0x0089:
            int r2 = r4.getWidth()
            int r4 = r4.getHeight()
            t4.c r9 = r3.f14548a
            boolean r11 = r9 instanceof t4.a
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r11 == 0) goto L_0x009f
            t4.a r9 = (t4.a) r9
            int r9 = r9.f14542a
            goto L_0x00a2
        L_0x009f:
            r9 = 2147483647(0x7fffffff, float:NaN)
        L_0x00a2:
            t4.c r3 = r3.f14549b
            boolean r11 = r3 instanceof t4.a
            if (r11 == 0) goto L_0x00af
            t4.a r3 = (t4.a) r3
            int r3 = r3.f14542a
            r11 = r22
            goto L_0x00b4
        L_0x00af:
            r11 = r22
            r3 = 2147483647(0x7fffffff, float:NaN)
        L_0x00b4:
            double r13 = j4.i.a(r2, r4, r9, r3, r11)
            boolean r1 = w4.c.a(r19)
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r1 == 0) goto L_0x00e4
            int r11 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            r17 = r6
            if (r11 <= 0) goto L_0x00c8
            r11 = r15
            goto L_0x00c9
        L_0x00c8:
            r11 = r13
        L_0x00c9:
            double r5 = (double) r9
            double r8 = (double) r2
            double r8 = r8 * r11
            double r5 = r5 - r8
            double r5 = java.lang.Math.abs(r5)
            int r2 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x011f
            double r2 = (double) r3
            double r4 = (double) r4
            double r11 = r11 * r4
            double r2 = r2 - r11
            double r2 = java.lang.Math.abs(r2)
            int r4 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r4 > 0) goto L_0x010b
            goto L_0x011f
        L_0x00e4:
            r17 = r6
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r5) goto L_0x00ef
            if (r9 != r12) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            r6 = 0
            goto L_0x00f0
        L_0x00ef:
            r6 = 1
        L_0x00f0:
            if (r6 != 0) goto L_0x00f9
            int r9 = r9 - r2
            int r2 = java.lang.Math.abs(r9)
            if (r2 > r10) goto L_0x010b
        L_0x00f9:
            if (r3 == r5) goto L_0x0100
            if (r3 != r12) goto L_0x00fe
            goto L_0x0100
        L_0x00fe:
            r2 = 0
            goto L_0x0101
        L_0x0100:
            r2 = 1
        L_0x0101:
            if (r2 != 0) goto L_0x011f
            int r3 = r3 - r4
            int r2 = java.lang.Math.abs(r3)
            if (r2 > r10) goto L_0x010b
            goto L_0x011f
        L_0x010b:
            int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x0111
            r2 = 1
            goto L_0x0112
        L_0x0111:
            r2 = 0
        L_0x0112:
            if (r2 != 0) goto L_0x0117
            if (r1 != 0) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            int r1 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r1 <= 0) goto L_0x011f
            if (r7 == 0) goto L_0x011f
        L_0x011d:
            r8 = 0
            goto L_0x0120
        L_0x011f:
            r8 = 1
        L_0x0120:
            if (r8 == 0) goto L_0x0125
            r5 = r17
            goto L_0x0126
        L_0x0125:
            r5 = 0
        L_0x0126:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.g.a(s4.i, q4.d, t4.g, int):q4.e");
    }

    public final d b(i iVar, Object obj, s4.m mVar, i4.i iVar2) {
        String str;
        Map map;
        d dVar = iVar.f14253e;
        if (dVar != null) {
            return dVar;
        }
        List list = ((t) this.f13329a).f8277f.f8239c;
        int size = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                str = null;
                break;
            }
            la.i iVar3 = (la.i) list.get(i10);
            b bVar = (b) iVar3.f9799h;
            if (((Class) iVar3.f9800i).isAssignableFrom(obj.getClass())) {
                j.d("null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>", bVar);
                str = bVar.a(obj, mVar);
                if (str != null) {
                    break;
                }
            }
            i10++;
        }
        if (str == null) {
            return null;
        }
        Map map2 = iVar.f14273y.f14293h;
        if (map2.isEmpty()) {
            map = j0.d();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = map2.entrySet().iterator();
            if (!it.hasNext()) {
                map = linkedHashMap;
            } else {
                h.y(((Map.Entry) it.next()).getValue());
                throw null;
            }
        }
        List list2 = iVar.f14259k;
        if (list2.isEmpty() && map.isEmpty()) {
            return new d(str, j0.d());
        }
        LinkedHashMap i11 = j0.i(map);
        if (!list2.isEmpty()) {
            if (list2.size() <= 0) {
                i11.put("coil#transformation_size", mVar.f14279d.toString());
            } else {
                h.y(list2.get(0));
                throw null;
            }
        }
        return new d(str, i11);
    }
}
