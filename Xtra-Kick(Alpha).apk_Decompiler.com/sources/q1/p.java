package q1;

import a2.e;
import a2.i;
import android.net.Uri;
import android.support.v4.media.h;
import android.text.TextUtils;
import d9.r0;
import d9.v0;
import e.a;
import g1.a0;
import g1.a1;
import g1.b1;
import g1.t;
import g1.v1;
import g1.z;
import g1.z0;
import g9.b;
import j1.l0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import k1.f0;
import m1.p1;
import p1.q;
import p1.u;
import r1.l;
import r1.m;
import r1.n;
import r1.o;
import r1.v;
import r1.x;
import v1.d1;
import v1.k;
import v1.l1;
import v1.y;

public final class p implements y, v {
    public l1 A;
    public v[] B;
    public v[] C;
    public int D;
    public a E;

    /* renamed from: h  reason: collision with root package name */
    public final l f13205h;

    /* renamed from: i  reason: collision with root package name */
    public final x f13206i;

    /* renamed from: j  reason: collision with root package name */
    public final c f13207j;

    /* renamed from: k  reason: collision with root package name */
    public final f0 f13208k;

    /* renamed from: l  reason: collision with root package name */
    public final u f13209l;

    /* renamed from: m  reason: collision with root package name */
    public final q f13210m;

    /* renamed from: n  reason: collision with root package name */
    public final i f13211n;

    /* renamed from: o  reason: collision with root package name */
    public final v1.f0 f13212o;

    /* renamed from: p  reason: collision with root package name */
    public final e f13213p;

    /* renamed from: q  reason: collision with root package name */
    public final IdentityHashMap f13214q;

    /* renamed from: r  reason: collision with root package name */
    public final a0 f13215r;

    /* renamed from: s  reason: collision with root package name */
    public final k f13216s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f13217t;

    /* renamed from: u  reason: collision with root package name */
    public final int f13218u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f13219v;

    /* renamed from: w  reason: collision with root package name */
    public final n1.f0 f13220w;

    /* renamed from: x  reason: collision with root package name */
    public final a f13221x = new a(this);

    /* renamed from: y  reason: collision with root package name */
    public v1.x f13222y;

    /* renamed from: z  reason: collision with root package name */
    public int f13223z;

    public p(l lVar, x xVar, c cVar, f0 f0Var, u uVar, q qVar, i iVar, v1.f0 f0Var2, e eVar, k kVar, boolean z10, int i10, boolean z11, n1.f0 f0Var3) {
        this.f13205h = lVar;
        this.f13206i = xVar;
        this.f13207j = cVar;
        this.f13208k = f0Var;
        this.f13209l = uVar;
        this.f13210m = qVar;
        this.f13211n = iVar;
        this.f13212o = f0Var2;
        this.f13213p = eVar;
        this.f13216s = kVar;
        this.f13217t = z10;
        this.f13218u = i10;
        this.f13219v = z11;
        this.f13220w = f0Var3;
        kVar.getClass();
        this.E = new a(23, (Object) new d1[0]);
        this.f13214q = new IdentityHashMap();
        this.f13215r = new a0();
        this.B = new v[0];
        this.C = new v[0];
    }

    public static a0 e(a0 a0Var, a0 a0Var2, boolean z10) {
        String str;
        String str2;
        int i10;
        int i11;
        int i12;
        z0 z0Var;
        String str3;
        int i13;
        int i14 = -1;
        if (a0Var2 != null) {
            str3 = a0Var2.f6273p;
            z0Var = a0Var2.f6274q;
            i12 = a0Var2.F;
            i11 = a0Var2.f6268k;
            i10 = a0Var2.f6269l;
            str2 = a0Var2.f6267j;
            str = a0Var2.f6266i;
        } else {
            str3 = l0.o(1, a0Var.f6273p);
            z0Var = a0Var.f6274q;
            if (z10) {
                i12 = a0Var.F;
                i11 = a0Var.f6268k;
                i10 = a0Var.f6269l;
                str2 = a0Var.f6267j;
                str = a0Var.f6266i;
            } else {
                i11 = 0;
                str2 = null;
                str = null;
                i12 = -1;
                i10 = 0;
            }
        }
        String d10 = a1.d(str3);
        if (z10) {
            i13 = a0Var.f6270m;
        } else {
            i13 = -1;
        }
        if (z10) {
            i14 = a0Var.f6271n;
        }
        z zVar = new z();
        zVar.f6744a = a0Var.f6265h;
        zVar.f6745b = str;
        zVar.f6753j = a0Var.f6275r;
        zVar.f6754k = d10;
        zVar.f6751h = str3;
        zVar.f6752i = z0Var;
        zVar.f6749f = i13;
        zVar.f6750g = i14;
        zVar.f6767x = i12;
        zVar.f6747d = i11;
        zVar.f6748e = i10;
        zVar.f6746c = str2;
        return zVar.a();
    }

    public final long B(long j10) {
        v[] vVarArr = this.C;
        if (vVarArr.length > 0) {
            boolean H = vVarArr[0].H(j10, false);
            int i10 = 1;
            while (true) {
                v[] vVarArr2 = this.C;
                if (i10 >= vVarArr2.length) {
                    break;
                }
                vVarArr2[i10].H(j10, H);
                i10++;
            }
            if (H) {
                this.f13215r.f13134a.clear();
            }
        }
        return j10;
    }

    public final boolean C(long j10) {
        if (this.A != null) {
            return this.E.C(j10);
        }
        for (v vVar : this.B) {
            if (!vVar.K) {
                vVar.C(vVar.W);
            }
        }
        return false;
    }

    public final void D(long j10) {
        this.E.D(j10);
    }

    public final void a() {
        for (v vVar : this.B) {
            ArrayList arrayList = vVar.f13270u;
            if (!arrayList.isEmpty()) {
                n nVar = (n) v0.a(arrayList);
                int b10 = vVar.f13260k.b(nVar);
                if (b10 == 1) {
                    nVar.K = true;
                } else if (b10 == 2 && !vVar.f13252a0) {
                    a2.q qVar = vVar.f13266q;
                    if (qVar.d()) {
                        qVar.a();
                    }
                }
            }
        }
        this.f13222y.r(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.net.Uri r17, j1.z r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            q1.v[] r2 = r0.B
            int r3 = r2.length
            r6 = 0
            r7 = 1
        L_0x0009:
            if (r6 >= r3) goto L_0x0091
            r8 = r2[r6]
            q1.k r9 = r8.f13260k
            android.net.Uri[] r10 = r9.f13171e
            boolean r10 = j1.l0.j(r10, r1)
            if (r10 != 0) goto L_0x001b
            r8 = r18
            goto L_0x0089
        L_0x001b:
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r19 != 0) goto L_0x003d
            z1.s r12 = r9.f13183q
            a2.j r12 = z1.w.a(r12)
            a2.i r8 = r8.f13265p
            r8.getClass()
            r8 = r18
            a2.k r12 = a2.i.a(r12, r8)
            if (r12 == 0) goto L_0x003f
            int r13 = r12.f59a
            r14 = 2
            if (r13 != r14) goto L_0x003f
            long r12 = r12.f60b
            goto L_0x0040
        L_0x003d:
            r8 = r18
        L_0x003f:
            r12 = r10
        L_0x0040:
            r14 = 0
        L_0x0041:
            android.net.Uri[] r15 = r9.f13171e
            int r4 = r15.length
            r5 = -1
            if (r14 >= r4) goto L_0x0053
            r4 = r15[r14]
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0050
            goto L_0x0054
        L_0x0050:
            int r14 = r14 + 1
            goto L_0x0041
        L_0x0053:
            r14 = -1
        L_0x0054:
            if (r14 != r5) goto L_0x0057
            goto L_0x0082
        L_0x0057:
            z1.s r4 = r9.f13183q
            int r4 = r4.t(r14)
            if (r4 != r5) goto L_0x0060
            goto L_0x0082
        L_0x0060:
            boolean r5 = r9.f13185s
            android.net.Uri r14 = r9.f13181o
            boolean r14 = r1.equals(r14)
            r5 = r5 | r14
            r9.f13185s = r5
            int r5 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0082
            z1.s r5 = r9.f13183q
            boolean r4 = r5.a(r4, r12)
            if (r4 == 0) goto L_0x0080
            r1.x r4 = r9.f13173g
            boolean r4 = r4.d(r1, r12)
            if (r4 == 0) goto L_0x0080
            goto L_0x0082
        L_0x0080:
            r4 = 0
            goto L_0x0083
        L_0x0082:
            r4 = 1
        L_0x0083:
            if (r4 == 0) goto L_0x008b
            int r4 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x008b
        L_0x0089:
            r4 = 1
            goto L_0x008c
        L_0x008b:
            r4 = 0
        L_0x008c:
            r7 = r7 & r4
            int r6 = r6 + 1
            goto L_0x0009
        L_0x0091:
            v1.x r1 = r0.f13222y
            r1.r(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.p.b(android.net.Uri, j1.z, boolean):boolean");
    }

    public final boolean c() {
        return this.E.c();
    }

    public final v d(String str, int i10, Uri[] uriArr, a0[] a0VarArr, a0 a0Var, List list, Map map, long j10) {
        k kVar = new k(this.f13205h, this.f13206i, uriArr, a0VarArr, this.f13207j, this.f13208k, this.f13215r, list, this.f13220w);
        return new v(str, i10, this.f13221x, kVar, map, this.f13213p, j10, a0Var, this.f13209l, this.f13210m, this.f13211n, this.f13212o, this.f13218u);
    }

    public final long f(long j10, p1 p1Var) {
        boolean z10;
        l lVar;
        long j11;
        v[] vVarArr = this.C;
        int length = vVarArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            v vVar = vVarArr[i10];
            if (vVar.H == 2) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                k kVar = vVar.f13260k;
                int o10 = kVar.f13183q.o();
                Uri[] uriArr = kVar.f13171e;
                int length2 = uriArr.length;
                x xVar = kVar.f13173g;
                if (o10 >= length2 || o10 == -1) {
                    lVar = null;
                } else {
                    lVar = xVar.m(true, uriArr[kVar.f13183q.k()]);
                }
                if (lVar != null) {
                    r0 r0Var = lVar.f13596r;
                    if (!r0Var.isEmpty() && lVar.f13623c) {
                        long o11 = lVar.f13586h - xVar.o();
                        long j12 = j10 - o11;
                        int d10 = l0.d(r0Var, Long.valueOf(j12), true);
                        long j13 = ((r1.i) r0Var.get(d10)).f13570l;
                        if (d10 != r0Var.size() - 1) {
                            j11 = ((r1.i) r0Var.get(d10 + 1)).f13570l;
                        } else {
                            j11 = j13;
                        }
                        return p1Var.a(j12, j13, j11) + o11;
                    }
                }
            } else {
                i10++;
            }
        }
        return j10;
    }

    public final long j() {
        return this.E.j();
    }

    public final long k() {
        return -9223372036854775807L;
    }

    public final void m(v1.x xVar, long j10) {
        HashMap hashMap;
        Map map;
        List list;
        HashSet hashSet;
        ArrayList arrayList;
        int i10;
        List list2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        int i12;
        boolean z14;
        this.f13222y = xVar;
        x xVar2 = this.f13206i;
        xVar2.j(this);
        o c10 = xVar2.c();
        c10.getClass();
        if (this.f13219v) {
            List list3 = c10.f13620m;
            ArrayList arrayList2 = new ArrayList(list3);
            HashMap hashMap2 = new HashMap();
            int i13 = 0;
            while (i13 < arrayList2.size()) {
                g1.u uVar = (g1.u) list3.get(i13);
                String str = uVar.f6594j;
                i13++;
                int i14 = i13;
                while (i14 < arrayList2.size()) {
                    g1.u uVar2 = (g1.u) arrayList2.get(i14);
                    if (TextUtils.equals(uVar2.f6594j, str)) {
                        String str2 = uVar.f6594j;
                        String str3 = uVar2.f6594j;
                        if (str2 == null || str3 == null || TextUtils.equals(str2, str3)) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        j1.a.e(z14);
                        if (str2 == null) {
                            str2 = str3;
                        }
                        int i15 = l0.f8453a;
                        t[] tVarArr = uVar.f6592h;
                        int length = tVarArr.length;
                        t[] tVarArr2 = uVar2.f6592h;
                        Object[] copyOf = Arrays.copyOf(tVarArr, length + tVarArr2.length);
                        System.arraycopy(tVarArr2, 0, copyOf, tVarArr.length, tVarArr2.length);
                        uVar = new g1.u(str2, true, (t[]) copyOf);
                        arrayList2.remove(i14);
                    } else {
                        i14++;
                    }
                }
                hashMap2.put(str, uVar);
            }
            hashMap = hashMap2;
        } else {
            hashMap = Collections.emptyMap();
        }
        Map map2 = hashMap;
        List list4 = c10.f13612e;
        boolean isEmpty = true ^ list4.isEmpty();
        this.f13223z = 0;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z15 = this.f13217t;
        List list5 = c10.f13614g;
        if (isEmpty) {
            int size = list4.size();
            int[] iArr = new int[size];
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < list4.size(); i18++) {
                a0 a0Var = ((n) list4.get(i18)).f13605b;
                if (a0Var.f6282y <= 0) {
                    String str4 = a0Var.f6273p;
                    if (l0.o(2, str4) == null) {
                        if (l0.o(1, str4) != null) {
                            iArr[i18] = 1;
                            i17++;
                        } else {
                            iArr[i18] = -1;
                        }
                    }
                }
                iArr[i18] = 2;
                i16++;
            }
            if (i16 > 0) {
                size = i16;
                z11 = true;
                z12 = false;
            } else if (i17 < size) {
                size -= i17;
                z11 = false;
                z12 = true;
            } else {
                z11 = false;
                z12 = false;
            }
            int i19 = size;
            Uri[] uriArr = new Uri[i19];
            a0[] a0VarArr = new a0[i19];
            int[] iArr2 = new int[i19];
            int i20 = 0;
            int i21 = 0;
            int i22 = i19;
            while (i20 < list4.size()) {
                if ((!z11 || iArr[i20] == 2) && (!z12 || iArr[i20] != 1)) {
                    n nVar = (n) list4.get(i20);
                    uriArr[i21] = nVar.f13604a;
                    a0VarArr[i21] = nVar.f13605b;
                    iArr2[i21] = i20;
                    i21++;
                }
                i20++;
            }
            String str5 = a0VarArr[0].f6273p;
            int n10 = l0.n(2, str5);
            int n11 = l0.n(1, str5);
            if ((n11 == 1 || (n11 == 0 && list5.isEmpty())) && n10 <= 1 && n11 + n10 > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z11 || n11 <= 0) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            a0 a0Var2 = c10.f13617j;
            String str6 = "main";
            a0 a0Var3 = a0Var2;
            int i23 = n10;
            int[] iArr3 = iArr2;
            a0[] a0VarArr2 = a0VarArr;
            Map map3 = map2;
            list = list5;
            int i24 = n11;
            Map map4 = map2;
            int i25 = i22;
            map = map4;
            v d10 = d("main", i11, uriArr, a0VarArr, a0Var3, c10.f13618k, map3, j10);
            arrayList3.add(d10);
            arrayList4.add(iArr3);
            if (z15 && z13) {
                ArrayList arrayList5 = new ArrayList();
                a0 a0Var4 = c10.f13617j;
                if (i23 > 0) {
                    a0[] a0VarArr3 = new a0[i25];
                    for (int i26 = 0; i26 < i25; i26++) {
                        a0 a0Var5 = a0VarArr2[i26];
                        String o10 = l0.o(2, a0Var5.f6273p);
                        String d11 = a1.d(o10);
                        z zVar = new z();
                        zVar.f6744a = a0Var5.f6265h;
                        zVar.f6745b = a0Var5.f6266i;
                        zVar.f6753j = a0Var5.f6275r;
                        zVar.f6754k = d11;
                        zVar.f6751h = o10;
                        zVar.f6752i = a0Var5.f6274q;
                        zVar.f6749f = a0Var5.f6270m;
                        zVar.f6750g = a0Var5.f6271n;
                        zVar.f6759p = a0Var5.f6281x;
                        zVar.f6760q = a0Var5.f6282y;
                        zVar.f6761r = a0Var5.f6283z;
                        zVar.f6747d = a0Var5.f6268k;
                        zVar.f6748e = a0Var5.f6269l;
                        a0VarArr3[i26] = new a0(zVar);
                    }
                    arrayList5.add(new v1(str6, a0VarArr3));
                    if (i24 > 0 && (a0Var4 != null || list.isEmpty())) {
                        arrayList5.add(new v1("main:audio", e(a0VarArr2[0], a0Var4, false)));
                    }
                    List list6 = c10.f13618k;
                    if (list6 != null) {
                        for (int i27 = 0; i27 < list6.size(); i27++) {
                            arrayList5.add(new v1(h.i("main:cc:", i27), (a0) list6.get(i27)));
                        }
                    }
                    i12 = 1;
                } else {
                    String str7 = str6;
                    a0[] a0VarArr4 = new a0[i25];
                    for (int i28 = 0; i28 < i25; i28++) {
                        a0VarArr4[i28] = e(a0VarArr2[i28], a0Var4, true);
                    }
                    i12 = 1;
                    arrayList5.add(new v1(str7, a0VarArr4));
                }
                a0[] a0VarArr5 = new a0[i12];
                z zVar2 = new z();
                zVar2.f6744a = "ID3";
                zVar2.f6754k = "application/id3";
                a0VarArr5[0] = new a0(zVar2);
                v1 v1Var = new v1("main:id3", a0VarArr5);
                arrayList5.add(v1Var);
                d10.F((v1[]) arrayList5.toArray(new v1[0]), arrayList5.indexOf(v1Var));
            }
        } else {
            list = list5;
            map = map2;
        }
        ArrayList arrayList6 = new ArrayList(list.size());
        ArrayList arrayList7 = new ArrayList(list.size());
        ArrayList arrayList8 = new ArrayList(list.size());
        HashSet hashSet2 = new HashSet();
        int i29 = 0;
        while (i29 < list.size()) {
            List list7 = list;
            String str8 = ((m) list7.get(i29)).f13603c;
            if (!hashSet2.add(str8)) {
                list2 = list7;
                i10 = i29;
                arrayList = arrayList8;
                hashSet = hashSet2;
            } else {
                arrayList6.clear();
                arrayList7.clear();
                arrayList8.clear();
                boolean z16 = true;
                for (int i30 = 0; i30 < list7.size(); i30++) {
                    if (l0.a(str8, ((m) list7.get(i30)).f13603c)) {
                        m mVar = (m) list7.get(i30);
                        arrayList8.add(Integer.valueOf(i30));
                        arrayList6.add(mVar.f13601a);
                        a0 a0Var6 = mVar.f13602b;
                        arrayList7.add(a0Var6);
                        if (l0.n(1, a0Var6.f6273p) == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z16 &= z10;
                    }
                }
                String m10 = h.m("audio:", str8);
                int i31 = l0.f8453a;
                String str9 = m10;
                list2 = list7;
                i10 = i29;
                arrayList = arrayList8;
                hashSet = hashSet2;
                v d12 = d(m10, 1, (Uri[]) arrayList6.toArray(new Uri[0]), (a0[]) arrayList7.toArray(new a0[0]), (a0) null, Collections.emptyList(), map, j10);
                arrayList4.add(b.d(arrayList));
                arrayList3.add(d12);
                if (z15 && z16) {
                    d12.F(new v1[]{new v1(str9, (a0[]) arrayList7.toArray(new a0[0]))}, new int[0]);
                }
            }
            i29 = i10 + 1;
            arrayList8 = arrayList;
            hashSet2 = hashSet;
            list = list2;
        }
        this.D = arrayList3.size();
        int i32 = 0;
        while (true) {
            List list8 = c10.f13615h;
            if (i32 >= list8.size()) {
                break;
            }
            m mVar2 = (m) list8.get(i32);
            StringBuilder r10 = h.r("subtitle:", i32, Constants.EXT_TAG_END);
            r10.append(mVar2.f13603c);
            String sb2 = r10.toString();
            Uri[] uriArr2 = {mVar2.f13601a};
            a0 a0Var7 = mVar2.f13602b;
            v d13 = d(sb2, 3, uriArr2, new a0[]{a0Var7}, (a0) null, Collections.emptyList(), map, j10);
            arrayList4.add(new int[]{i32});
            arrayList3.add(d13);
            d13.F(new v1[]{new v1(sb2, a0Var7)}, new int[0]);
            i32++;
        }
        this.B = (v[]) arrayList3.toArray(new v[0]);
        int[][] iArr4 = (int[][]) arrayList4.toArray(new int[0][]);
        this.f13223z = this.B.length;
        for (int i33 = 0; i33 < this.D; i33++) {
            this.B[i33].f13260k.f13178l = true;
        }
        for (v vVar : this.B) {
            if (!vVar.K) {
                vVar.C(vVar.W);
            }
        }
        this.C = this.B;
    }

    public final l1 o() {
        l1 l1Var = this.A;
        l1Var.getClass();
        return l1Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: q1.r} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long p(z1.s[] r37, boolean[] r38, v1.b1[] r39, boolean[] r40, long r41) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r39
            r12 = r41
            int r3 = r1.length
            int[] r14 = new int[r3]
            int r3 = r1.length
            int[] r15 = new int[r3]
            r3 = 0
        L_0x000f:
            int r4 = r1.length
            java.util.IdentityHashMap r10 = r0.f13214q
            r8 = -1
            if (r3 >= r4) goto L_0x004d
            r4 = r2[r3]
            if (r4 != 0) goto L_0x001b
            r4 = -1
            goto L_0x0025
        L_0x001b:
            java.lang.Object r4 = r10.get(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
        L_0x0025:
            r14[r3] = r4
            r15[r3] = r8
            r4 = r1[r3]
            if (r4 == 0) goto L_0x004a
            g1.v1 r4 = r4.l()
            r5 = 0
        L_0x0032:
            q1.v[] r6 = r0.B
            int r7 = r6.length
            if (r5 >= r7) goto L_0x004a
            r6 = r6[r5]
            r6.i()
            v1.l1 r6 = r6.P
            int r6 = r6.j(r4)
            if (r6 == r8) goto L_0x0047
            r15[r3] = r5
            goto L_0x004a
        L_0x0047:
            int r5 = r5 + 1
            goto L_0x0032
        L_0x004a:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x004d:
            r10.clear()
            int r9 = r1.length
            v1.b1[] r6 = new v1.b1[r9]
            int r7 = r1.length
            v1.b1[] r4 = new v1.b1[r7]
            int r5 = r1.length
            z1.s[] r3 = new z1.s[r5]
            q1.v[] r11 = r0.B
            int r11 = r11.length
            q1.v[] r11 = new q1.v[r11]
            r17 = r9
            r9 = 0
            r18 = 0
            r19 = 0
        L_0x0065:
            q1.v[] r8 = r0.B
            int r8 = r8.length
            if (r9 >= r8) goto L_0x031a
            r21 = r6
            r8 = 0
        L_0x006d:
            int r6 = r1.length
            r22 = r7
            if (r8 >= r6) goto L_0x008b
            r6 = r14[r8]
            if (r6 != r9) goto L_0x0079
            r6 = r2[r8]
            goto L_0x007a
        L_0x0079:
            r6 = 0
        L_0x007a:
            r4[r8] = r6
            r6 = r15[r8]
            if (r6 != r9) goto L_0x0083
            r7 = r1[r8]
            goto L_0x0084
        L_0x0083:
            r7 = 0
        L_0x0084:
            r3[r8] = r7
            int r8 = r8 + 1
            r7 = r22
            goto L_0x006d
        L_0x008b:
            q1.v[] r6 = r0.B
            r8 = r6[r9]
            r8.i()
            int r6 = r8.L
            r7 = 0
        L_0x0095:
            if (r7 >= r5) goto L_0x00ee
            r24 = r4[r7]
            r25 = r9
            r9 = r24
            q1.r r9 = (q1.r) r9
            if (r9 == 0) goto L_0x00dd
            r24 = r3[r7]
            if (r24 == 0) goto L_0x00a9
            boolean r24 = r38[r7]
            if (r24 != 0) goto L_0x00dd
        L_0x00a9:
            r24 = r10
            int r10 = r8.L
            r26 = r11
            r11 = -1
            int r10 = r10 + r11
            r8.L = r10
            int r10 = r9.f13240c
            if (r10 == r11) goto L_0x00d7
            q1.v r10 = r9.f13239b
            r10.i()
            int[] r11 = r10.R
            r11.getClass()
            int[] r11 = r10.R
            int r2 = r9.f13238a
            r2 = r11[r2]
            boolean[] r11 = r10.U
            boolean r11 = r11[r2]
            j1.a.e(r11)
            boolean[] r10 = r10.U
            r11 = 0
            r10[r2] = r11
            r2 = -1
            r9.f13240c = r2
            goto L_0x00d9
        L_0x00d7:
            r2 = -1
            r11 = 0
        L_0x00d9:
            r9 = 0
            r4[r7] = r9
            goto L_0x00e3
        L_0x00dd:
            r24 = r10
            r26 = r11
            r2 = -1
            r11 = 0
        L_0x00e3:
            int r7 = r7 + 1
            r2 = r39
            r10 = r24
            r9 = r25
            r11 = r26
            goto L_0x0095
        L_0x00ee:
            r25 = r9
            r24 = r10
            r26 = r11
            r2 = -1
            r11 = 0
            if (r19 != 0) goto L_0x0108
            boolean r7 = r8.Z
            if (r7 == 0) goto L_0x00ff
            if (r6 != 0) goto L_0x0106
            goto L_0x0108
        L_0x00ff:
            long r6 = r8.W
            int r9 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0106
            goto L_0x0108
        L_0x0106:
            r6 = 0
            goto L_0x0109
        L_0x0108:
            r6 = 1
        L_0x0109:
            q1.k r9 = r8.f13260k
            z1.s r7 = r9.f13183q
            r16 = r6
            r2 = r7
            r6 = 0
        L_0x0111:
            if (r6 >= r5) goto L_0x016a
            r11 = r3[r6]
            if (r11 != 0) goto L_0x011a
            r28 = r3
            goto L_0x0164
        L_0x011a:
            v1.l1 r10 = r8.P
            r28 = r3
            g1.v1 r3 = r11.l()
            int r3 = r10.j(r3)
            int r10 = r8.S
            if (r3 != r10) goto L_0x012d
            r9.f13183q = r11
            r2 = r11
        L_0x012d:
            r10 = r4[r6]
            if (r10 != 0) goto L_0x0164
            int r10 = r8.L
            r11 = 1
            int r10 = r10 + r11
            r8.L = r10
            q1.r r10 = new q1.r
            r10.<init>(r8, r3)
            r4[r6] = r10
            r40[r6] = r11
            int[] r11 = r8.R
            if (r11 == 0) goto L_0x0164
            r10.e()
            if (r16 != 0) goto L_0x0164
            q1.u[] r10 = r8.C
            int[] r11 = r8.R
            r3 = r11[r3]
            r3 = r10[r3]
            r10 = 1
            boolean r11 = r3.A(r12, r10)
            if (r11 != 0) goto L_0x0161
            int r10 = r3.f15579q
            int r3 = r3.f15581s
            int r10 = r10 + r3
            if (r10 == 0) goto L_0x0161
            r11 = 1
            goto L_0x0162
        L_0x0161:
            r11 = 0
        L_0x0162:
            r16 = r11
        L_0x0164:
            int r6 = r6 + 1
            r3 = r28
            r11 = 0
            goto L_0x0111
        L_0x016a:
            r28 = r3
            int r3 = r8.L
            java.util.ArrayList r6 = r8.f13270u
            if (r3 != 0) goto L_0x01b9
            r3 = 0
            r9.f13180n = r3
            r8.N = r3
            r10 = 1
            r8.Y = r10
            r6.clear()
            a2.q r2 = r8.f13266q
            boolean r3 = r2.d()
            if (r3 == 0) goto L_0x019b
            boolean r3 = r8.J
            if (r3 == 0) goto L_0x0197
            q1.u[] r3 = r8.C
            int r6 = r3.length
            r7 = 0
        L_0x018d:
            if (r7 >= r6) goto L_0x0197
            r11 = r3[r7]
            r11.i()
            int r7 = r7 + 1
            goto L_0x018d
        L_0x0197:
            r2.a()
            goto L_0x019e
        L_0x019b:
            r8.G()
        L_0x019e:
            r31 = r4
            r32 = r5
            r0 = r8
            r33 = r17
            r17 = r21
            r34 = r24
            r35 = r26
            r27 = r28
            r1 = 1
            r20 = -1
            r21 = r14
            r14 = r22
            r22 = r15
            r15 = r9
            goto L_0x026b
        L_0x01b9:
            r10 = 1
            boolean r3 = r6.isEmpty()
            if (r3 != 0) goto L_0x023b
            boolean r3 = j1.l0.a(r2, r7)
            if (r3 != 0) goto L_0x023b
            boolean r3 = r8.Z
            if (r3 != 0) goto L_0x021a
            r6 = 0
            int r3 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x01d1
            long r6 = -r12
        L_0x01d1:
            q1.n r11 = r8.w()
            x1.d[] r23 = r9.a(r11, r12)
            r29 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List r3 = r8.f13271v
            r27 = r28
            r28 = r3
            r3 = r2
            r31 = r4
            r32 = r5
            r4 = r41
            r0 = r21
            r21 = r14
            r14 = r22
            r22 = r15
            r33 = r17
            r20 = -1
            r17 = r0
            r0 = r8
            r15 = r9
            r8 = r29
            r34 = r24
            r10 = r28
            r1 = r11
            r35 = r26
            r11 = r23
            r3.c(r4, r6, r8, r10, r11)
            g1.v1 r3 = r15.f13174h
            g1.a0 r1 = r1.f16557d
            int r1 = r3.i(r1)
            int r2 = r2.k()
            if (r2 == r1) goto L_0x0218
            goto L_0x0232
        L_0x0218:
            r11 = 0
            goto L_0x0233
        L_0x021a:
            r31 = r4
            r32 = r5
            r0 = r8
            r33 = r17
            r17 = r21
            r34 = r24
            r35 = r26
            r27 = r28
            r20 = -1
            r21 = r14
            r14 = r22
            r22 = r15
            r15 = r9
        L_0x0232:
            r11 = 1
        L_0x0233:
            r1 = 1
            if (r11 == 0) goto L_0x0254
            r0.Y = r1
            r2 = 1
            r10 = 1
            goto L_0x0258
        L_0x023b:
            r31 = r4
            r32 = r5
            r0 = r8
            r33 = r17
            r17 = r21
            r34 = r24
            r35 = r26
            r27 = r28
            r1 = 1
            r20 = -1
            r21 = r14
            r14 = r22
            r22 = r15
            r15 = r9
        L_0x0254:
            r10 = r16
            r2 = r19
        L_0x0258:
            if (r10 == 0) goto L_0x0269
            r0.H(r12, r2)
            r11 = 0
        L_0x025e:
            if (r11 >= r14) goto L_0x0269
            r2 = r31[r11]
            if (r2 == 0) goto L_0x0266
            r40[r11] = r1
        L_0x0266:
            int r11 = r11 + 1
            goto L_0x025e
        L_0x0269:
            r16 = r10
        L_0x026b:
            java.util.ArrayList r2 = r0.f13275z
            r2.clear()
            r11 = 0
        L_0x0271:
            if (r11 >= r14) goto L_0x027f
            r3 = r31[r11]
            if (r3 == 0) goto L_0x027c
            q1.r r3 = (q1.r) r3
            r2.add(r3)
        L_0x027c:
            int r11 = r11 + 1
            goto L_0x0271
        L_0x027f:
            r0.Z = r1
            r3 = r37
            r2 = 0
            r11 = 0
        L_0x0285:
            int r4 = r3.length
            if (r11 >= r4) goto L_0x02b5
            r4 = r31[r11]
            r5 = r22[r11]
            r6 = r25
            if (r5 != r6) goto L_0x02a0
            r4.getClass()
            r17[r11] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            r5 = r34
            r5.put(r4, r2)
            r2 = 1
            goto L_0x02ae
        L_0x02a0:
            r5 = r34
            r7 = r21[r11]
            if (r7 != r6) goto L_0x02ae
            if (r4 != 0) goto L_0x02aa
            r4 = 1
            goto L_0x02ab
        L_0x02aa:
            r4 = 0
        L_0x02ab:
            j1.a.e(r4)
        L_0x02ae:
            int r11 = r11 + 1
            r34 = r5
            r25 = r6
            goto L_0x0285
        L_0x02b5:
            r6 = r25
            r5 = r34
            if (r2 == 0) goto L_0x02f8
            r4 = r18
            r2 = r35
            r2[r4] = r0
            int r18 = r4 + 1
            if (r4 != 0) goto L_0x02e9
            r15.f13178l = r1
            if (r16 != 0) goto L_0x02da
            r7 = r36
            r8 = r17
            q1.v[] r4 = r7.C
            int r9 = r4.length
            if (r9 == 0) goto L_0x02d8
            r9 = 0
            r4 = r4[r9]
            if (r0 == r4) goto L_0x0301
            goto L_0x02df
        L_0x02d8:
            r9 = 0
            goto L_0x02df
        L_0x02da:
            r9 = 0
            r7 = r36
            r8 = r17
        L_0x02df:
            q1.a0 r0 = r7.f13215r
            android.util.SparseArray r0 = r0.f13134a
            r0.clear()
            r19 = 1
            goto L_0x0301
        L_0x02e9:
            r9 = 0
            r7 = r36
            r8 = r17
            int r0 = r7.D
            if (r6 >= r0) goto L_0x02f4
            r11 = 1
            goto L_0x02f5
        L_0x02f4:
            r11 = 0
        L_0x02f5:
            r15.f13178l = r11
            goto L_0x0301
        L_0x02f8:
            r7 = r36
            r8 = r17
            r4 = r18
            r2 = r35
            r9 = 0
        L_0x0301:
            int r0 = r6 + 1
            r9 = r0
            r11 = r2
            r1 = r3
            r10 = r5
            r0 = r7
            r6 = r8
            r7 = r14
            r14 = r21
            r15 = r22
            r3 = r27
            r4 = r31
            r5 = r32
            r17 = r33
            r2 = r39
            goto L_0x0065
        L_0x031a:
            r7 = r0
            r0 = r2
            r8 = r6
            r2 = r11
            r1 = r17
            r4 = r18
            r9 = 0
            java.lang.System.arraycopy(r8, r9, r0, r9, r1)
            java.lang.Object[] r0 = j1.l0.J(r4, r2)
            q1.v[] r0 = (q1.v[]) r0
            r7.C = r0
            v1.k r1 = r7.f13216s
            r1.getClass()
            e.a r1 = new e.a
            r2 = 23
            r1.<init>((int) r2, (java.lang.Object) r0)
            r7.E = r1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.p.p(z1.s[], boolean[], v1.b1[], boolean[], long):long");
    }

    public final long u() {
        return this.E.u();
    }

    public final void v() {
        v[] vVarArr = this.B;
        int length = vVarArr.length;
        int i10 = 0;
        while (i10 < length) {
            v vVar = vVarArr[i10];
            vVar.E();
            if (!vVar.f13252a0 || vVar.K) {
                i10++;
            } else {
                throw b1.a("Loading finished before preparation is complete.", (Exception) null);
            }
        }
    }

    public final void y(long j10, boolean z10) {
        for (v vVar : this.C) {
            if (vVar.J && !vVar.z()) {
                int length = vVar.C.length;
                for (int i10 = 0; i10 < length; i10++) {
                    vVar.C[i10].h(j10, z10, vVar.U[i10]);
                }
            }
        }
    }
}
