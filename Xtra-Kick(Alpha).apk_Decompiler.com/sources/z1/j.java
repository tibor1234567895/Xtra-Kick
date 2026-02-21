package z1;

import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import g1.m;
import g1.x1;
import g1.y1;
import g9.b;
import j1.c;
import j1.l0;
import java.util.ArrayList;
import java.util.Map;
import v1.l1;

public final class j extends y1 {
    public static final String A0 = l0.C(1002);
    public static final String B0 = l0.C(1003);
    public static final String C0 = l0.C(1004);
    public static final String D0 = l0.C(1005);
    public static final String E0 = l0.C(1006);
    public static final String F0 = l0.C(1007);
    public static final String G0 = l0.C(1008);
    public static final String H0 = l0.C(1009);
    public static final String I0 = l0.C(1010);
    public static final String J0 = l0.C(1011);
    public static final String K0 = l0.C(1012);
    public static final String L0 = l0.C(1013);
    public static final String M0 = l0.C(1014);
    public static final String N0 = l0.C(1015);
    public static final String O0 = l0.C(1016);

    /* renamed from: x0  reason: collision with root package name */
    public static final j f17415x0 = new i().b();

    /* renamed from: y0  reason: collision with root package name */
    public static final String f17416y0 = l0.C(1000);

    /* renamed from: z0  reason: collision with root package name */
    public static final String f17417z0 = l0.C(1001);

    /* renamed from: i0  reason: collision with root package name */
    public final boolean f17418i0;

    /* renamed from: j0  reason: collision with root package name */
    public final boolean f17419j0;

    /* renamed from: k0  reason: collision with root package name */
    public final boolean f17420k0;

    /* renamed from: l0  reason: collision with root package name */
    public final boolean f17421l0;

    /* renamed from: m0  reason: collision with root package name */
    public final boolean f17422m0;

    /* renamed from: n0  reason: collision with root package name */
    public final boolean f17423n0;

    /* renamed from: o0  reason: collision with root package name */
    public final boolean f17424o0;

    /* renamed from: p0  reason: collision with root package name */
    public final boolean f17425p0;

    /* renamed from: q0  reason: collision with root package name */
    public final boolean f17426q0;

    /* renamed from: r0  reason: collision with root package name */
    public final boolean f17427r0;

    /* renamed from: s0  reason: collision with root package name */
    public final boolean f17428s0;

    /* renamed from: t0  reason: collision with root package name */
    public final boolean f17429t0;

    /* renamed from: u0  reason: collision with root package name */
    public final boolean f17430u0;

    /* renamed from: v0  reason: collision with root package name */
    public final SparseArray f17431v0;

    /* renamed from: w0  reason: collision with root package name */
    public final SparseBooleanArray f17432w0;

    public j(i iVar) {
        super(iVar);
        this.f17418i0 = iVar.A;
        this.f17419j0 = iVar.B;
        this.f17420k0 = iVar.C;
        this.f17421l0 = iVar.D;
        this.f17422m0 = iVar.E;
        this.f17423n0 = iVar.F;
        this.f17424o0 = iVar.G;
        this.f17425p0 = iVar.H;
        this.f17426q0 = iVar.I;
        this.f17427r0 = iVar.J;
        this.f17428s0 = iVar.K;
        this.f17429t0 = iVar.L;
        this.f17430u0 = iVar.M;
        this.f17431v0 = iVar.N;
        this.f17432w0 = iVar.O;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r11) {
        /*
            r10 = this;
            r0 = 1
            if (r10 != r11) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r11 == 0) goto L_0x00fc
            java.lang.Class<z1.j> r2 = z1.j.class
            java.lang.Class r3 = r11.getClass()
            if (r2 == r3) goto L_0x0011
            goto L_0x00fc
        L_0x0011:
            z1.j r11 = (z1.j) r11
            boolean r2 = super.equals(r11)
            if (r2 == 0) goto L_0x00fa
            boolean r2 = r10.f17418i0
            boolean r3 = r11.f17418i0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17419j0
            boolean r3 = r11.f17419j0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17420k0
            boolean r3 = r11.f17420k0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17421l0
            boolean r3 = r11.f17421l0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17422m0
            boolean r3 = r11.f17422m0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17423n0
            boolean r3 = r11.f17423n0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17424o0
            boolean r3 = r11.f17424o0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17425p0
            boolean r3 = r11.f17425p0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17426q0
            boolean r3 = r11.f17426q0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17427r0
            boolean r3 = r11.f17427r0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17428s0
            boolean r3 = r11.f17428s0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17429t0
            boolean r3 = r11.f17429t0
            if (r2 != r3) goto L_0x00fa
            boolean r2 = r10.f17430u0
            boolean r3 = r11.f17430u0
            if (r2 != r3) goto L_0x00fa
            android.util.SparseBooleanArray r2 = r10.f17432w0
            int r3 = r2.size()
            android.util.SparseBooleanArray r4 = r11.f17432w0
            int r5 = r4.size()
            if (r5 == r3) goto L_0x0077
        L_0x0075:
            r2 = 0
            goto L_0x0089
        L_0x0077:
            r5 = 0
        L_0x0078:
            if (r5 >= r3) goto L_0x0088
            int r6 = r2.keyAt(r5)
            int r6 = r4.indexOfKey(r6)
            if (r6 >= 0) goto L_0x0085
            goto L_0x0075
        L_0x0085:
            int r5 = r5 + 1
            goto L_0x0078
        L_0x0088:
            r2 = 1
        L_0x0089:
            if (r2 == 0) goto L_0x00fa
            android.util.SparseArray r2 = r10.f17431v0
            int r3 = r2.size()
            android.util.SparseArray r11 = r11.f17431v0
            int r4 = r11.size()
            if (r4 == r3) goto L_0x009b
        L_0x0099:
            r11 = 0
            goto L_0x00f7
        L_0x009b:
            r4 = 0
        L_0x009c:
            if (r4 >= r3) goto L_0x00f6
            int r5 = r2.keyAt(r4)
            int r5 = r11.indexOfKey(r5)
            if (r5 < 0) goto L_0x0099
            java.lang.Object r6 = r2.valueAt(r4)
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r5 = r11.valueAt(r5)
            java.util.Map r5 = (java.util.Map) r5
            int r7 = r6.size()
            int r8 = r5.size()
            if (r8 == r7) goto L_0x00bf
            goto L_0x00ed
        L_0x00bf:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x00c7:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00ef
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            v1.l1 r8 = (v1.l1) r8
            boolean r9 = r5.containsKey(r8)
            if (r9 == 0) goto L_0x00ed
            java.lang.Object r7 = r7.getValue()
            java.lang.Object r8 = r5.get(r8)
            boolean r7 = j1.l0.a(r7, r8)
            if (r7 != 0) goto L_0x00c7
        L_0x00ed:
            r5 = 0
            goto L_0x00f0
        L_0x00ef:
            r5 = 1
        L_0x00f0:
            if (r5 != 0) goto L_0x00f3
            goto L_0x0099
        L_0x00f3:
            int r4 = r4 + 1
            goto L_0x009c
        L_0x00f6:
            r11 = 1
        L_0x00f7:
            if (r11 == 0) goto L_0x00fa
            goto L_0x00fb
        L_0x00fa:
            r0 = 0
        L_0x00fb:
            return r0
        L_0x00fc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.j.equals(java.lang.Object):boolean");
    }

    public final Bundle h() {
        Bundle h10 = super.h();
        h10.putBoolean(f17416y0, this.f17418i0);
        h10.putBoolean(f17417z0, this.f17419j0);
        h10.putBoolean(A0, this.f17420k0);
        h10.putBoolean(M0, this.f17421l0);
        h10.putBoolean(B0, this.f17422m0);
        h10.putBoolean(C0, this.f17423n0);
        h10.putBoolean(D0, this.f17424o0);
        h10.putBoolean(E0, this.f17425p0);
        h10.putBoolean(N0, this.f17426q0);
        h10.putBoolean(O0, this.f17427r0);
        h10.putBoolean(F0, this.f17428s0);
        h10.putBoolean(G0, this.f17429t0);
        h10.putBoolean(H0, this.f17430u0);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray2 = this.f17431v0;
            if (i10 >= sparseArray2.size()) {
                break;
            }
            int keyAt = sparseArray2.keyAt(i10);
            for (Map.Entry entry : ((Map) sparseArray2.valueAt(i10)).entrySet()) {
                k kVar = (k) entry.getValue();
                if (kVar != null) {
                    sparseArray.put(arrayList2.size(), kVar);
                }
                arrayList2.add((l1) entry.getKey());
                arrayList.add(Integer.valueOf(keyAt));
            }
            h10.putIntArray(I0, b.d(arrayList));
            h10.putParcelableArrayList(J0, c.b(arrayList2));
            SparseArray sparseArray3 = new SparseArray(sparseArray.size());
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                sparseArray3.put(sparseArray.keyAt(i11), ((m) sparseArray.valueAt(i11)).h());
            }
            h10.putSparseParcelableArray(K0, sparseArray3);
            i10++;
        }
        SparseBooleanArray sparseBooleanArray = this.f17432w0;
        int[] iArr = new int[sparseBooleanArray.size()];
        for (int i12 = 0; i12 < sparseBooleanArray.size(); i12++) {
            iArr[i12] = sparseBooleanArray.keyAt(i12);
        }
        h10.putIntArray(L0, iArr);
        return h10;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f17418i0 ? 1 : 0)) * 31) + (this.f17419j0 ? 1 : 0)) * 31) + (this.f17420k0 ? 1 : 0)) * 31) + (this.f17421l0 ? 1 : 0)) * 31) + (this.f17422m0 ? 1 : 0)) * 31) + (this.f17423n0 ? 1 : 0)) * 31) + (this.f17424o0 ? 1 : 0)) * 31) + (this.f17425p0 ? 1 : 0)) * 31) + (this.f17426q0 ? 1 : 0)) * 31) + (this.f17427r0 ? 1 : 0)) * 31) + (this.f17428s0 ? 1 : 0)) * 31) + (this.f17429t0 ? 1 : 0)) * 31) + (this.f17430u0 ? 1 : 0);
    }

    public final x1 i() {
        return new i(this);
    }
}
