package q1;

import android.net.Uri;
import android.util.Pair;
import d9.p0;
import d9.r0;
import d9.r1;
import e.a;
import g1.a0;
import g1.v1;
import j1.j0;
import j1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import k1.h;
import n1.f0;
import r1.g;
import r1.i;
import r1.l;
import r1.x;
import v1.b;
import x1.d;
import z1.s;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final l f13167a;

    /* renamed from: b  reason: collision with root package name */
    public final h f13168b;

    /* renamed from: c  reason: collision with root package name */
    public final h f13169c;

    /* renamed from: d  reason: collision with root package name */
    public final a0 f13170d;

    /* renamed from: e  reason: collision with root package name */
    public final Uri[] f13171e;

    /* renamed from: f  reason: collision with root package name */
    public final a0[] f13172f;

    /* renamed from: g  reason: collision with root package name */
    public final x f13173g;

    /* renamed from: h  reason: collision with root package name */
    public final v1 f13174h;

    /* renamed from: i  reason: collision with root package name */
    public final List f13175i;

    /* renamed from: j  reason: collision with root package name */
    public final a f13176j = new a(0);

    /* renamed from: k  reason: collision with root package name */
    public final f0 f13177k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f13178l;

    /* renamed from: m  reason: collision with root package name */
    public byte[] f13179m = l0.f8458f;

    /* renamed from: n  reason: collision with root package name */
    public b f13180n;

    /* renamed from: o  reason: collision with root package name */
    public Uri f13181o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f13182p;

    /* renamed from: q  reason: collision with root package name */
    public s f13183q;

    /* renamed from: r  reason: collision with root package name */
    public long f13184r = -9223372036854775807L;

    /* renamed from: s  reason: collision with root package name */
    public boolean f13185s;

    public k(l lVar, x xVar, Uri[] uriArr, a0[] a0VarArr, c cVar, k1.f0 f0Var, a0 a0Var, List list, f0 f0Var2) {
        this.f13167a = lVar;
        this.f13173g = xVar;
        this.f13171e = uriArr;
        this.f13172f = a0VarArr;
        this.f13170d = a0Var;
        this.f13175i = list;
        this.f13177k = f0Var2;
        h a10 = cVar.a();
        this.f13168b = a10;
        if (f0Var != null) {
            a10.i(f0Var);
        }
        this.f13169c = cVar.a();
        this.f13174h = new v1("", a0VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < uriArr.length; i10++) {
            if ((a0VarArr[i10].f6269l & 16384) == 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        this.f13183q = new i(this.f13174h, g9.b.d(arrayList));
    }

    public final d[] a(n nVar, long j10) {
        int i10;
        boolean z10;
        List list;
        n nVar2 = nVar;
        if (nVar2 == null) {
            i10 = -1;
        } else {
            i10 = this.f13174h.i(nVar2.f16557d);
        }
        int length = this.f13183q.length();
        d[] dVarArr = new d[length];
        boolean z11 = false;
        int i11 = 0;
        while (i11 < length) {
            int g10 = this.f13183q.g(i11);
            Uri uri = this.f13171e[g10];
            x xVar = this.f13173g;
            if (!xVar.e(uri)) {
                dVarArr[i11] = d.f16564a;
            } else {
                l m10 = xVar.m(z11, uri);
                m10.getClass();
                long o10 = m10.f13586h - xVar.o();
                if (g10 != i10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                long j11 = o10;
                l lVar = m10;
                Pair c10 = c(nVar, z10, m10, o10, j10);
                long longValue = ((Long) c10.first).longValue();
                int intValue = ((Integer) c10.second).intValue();
                int i12 = (int) (longValue - lVar.f13589k);
                if (i12 >= 0) {
                    r0 r0Var = lVar.f13596r;
                    if (r0Var.size() >= i12) {
                        ArrayList arrayList = new ArrayList();
                        if (i12 < r0Var.size()) {
                            if (intValue != -1) {
                                i iVar = (i) r0Var.get(i12);
                                if (intValue == 0) {
                                    arrayList.add(iVar);
                                } else if (intValue < iVar.f13565t.size()) {
                                    r0 r0Var2 = iVar.f13565t;
                                    arrayList.addAll(r0Var2.subList(intValue, r0Var2.size()));
                                }
                                i12++;
                            }
                            arrayList.addAll(r0Var.subList(i12, r0Var.size()));
                            intValue = 0;
                        }
                        if (lVar.f13592n != -9223372036854775807L) {
                            if (intValue == -1) {
                                intValue = 0;
                            }
                            r0 r0Var3 = lVar.f13597s;
                            if (intValue < r0Var3.size()) {
                                arrayList.addAll(r0Var3.subList(intValue, r0Var3.size()));
                            }
                        }
                        list = Collections.unmodifiableList(arrayList);
                        dVarArr[i11] = new h(j11, list);
                    }
                }
                p0 p0Var = r0.f4657i;
                list = r1.f4658l;
                dVarArr[i11] = new h(j11, list);
            }
            i11++;
            z11 = false;
        }
        return dVarArr;
    }

    public final int b(n nVar) {
        r0 r0Var;
        if (nVar.f13193o == -1) {
            return 1;
        }
        l m10 = this.f13173g.m(false, this.f13171e[this.f13174h.i(nVar.f16557d)]);
        m10.getClass();
        int i10 = (int) (nVar.f16563j - m10.f13589k);
        if (i10 < 0) {
            return 1;
        }
        r0 r0Var2 = m10.f13596r;
        if (i10 < r0Var2.size()) {
            r0Var = ((i) r0Var2.get(i10)).f13565t;
        } else {
            r0Var = m10.f13597s;
        }
        int size = r0Var.size();
        int i11 = nVar.f13193o;
        if (i11 >= size) {
            return 2;
        }
        g gVar = (g) r0Var.get(i11);
        if (gVar.f13560t) {
            return 0;
        }
        if (l0.a(Uri.parse(j0.c(m10.f13621a, gVar.f13566h)), nVar.f16555b.f9022a)) {
            return 1;
        }
        return 2;
    }

    public final Pair c(n nVar, boolean z10, l lVar, long j10, long j11) {
        long j12;
        r0 r0Var;
        Integer num;
        Long l10;
        n nVar2 = nVar;
        l lVar2 = lVar;
        boolean z11 = true;
        long j13 = 1;
        int i10 = -1;
        if (nVar2 == null || z10) {
            long j14 = j10 + lVar2.f13599u;
            if (nVar2 == null || this.f13182p) {
                j12 = j11;
            } else {
                j12 = nVar2.f16560g;
            }
            boolean z12 = lVar2.f13593o;
            long j15 = lVar2.f13589k;
            r0 r0Var2 = lVar2.f13596r;
            if (!z12 && j12 >= j14) {
                return new Pair(Long.valueOf(j15 + ((long) r0Var2.size())), -1);
            }
            long j16 = j12 - j10;
            Long valueOf = Long.valueOf(j16);
            int i11 = 0;
            if (this.f13173g.b() && nVar2 != null) {
                z11 = false;
            }
            int d10 = l0.d(r0Var2, valueOf, z11);
            long j17 = ((long) d10) + j15;
            if (d10 >= 0) {
                i iVar = (i) r0Var2.get(d10);
                r0 r0Var3 = lVar2.f13597s;
                if (j16 < iVar.f13570l + iVar.f13568j) {
                    r0Var = iVar.f13565t;
                } else {
                    r0Var = r0Var3;
                }
                while (true) {
                    if (i11 >= r0Var.size()) {
                        break;
                    }
                    g gVar = (g) r0Var.get(i11);
                    if (j16 >= gVar.f13570l + gVar.f13568j) {
                        i11++;
                    } else if (gVar.f13559s) {
                        if (r0Var != r0Var3) {
                            j13 = 0;
                        }
                        j17 += j13;
                        i10 = i11;
                    }
                }
            }
            return new Pair(Long.valueOf(j17), Integer.valueOf(i10));
        }
        boolean z13 = nVar2.H;
        int i12 = nVar2.f13193o;
        long j18 = nVar2.f16563j;
        if (z13) {
            if (i12 == -1) {
                if (j18 != -1) {
                    j18++;
                } else {
                    j18 = -1;
                }
            }
            l10 = Long.valueOf(j18);
            if (i12 != -1) {
                i10 = i12 + 1;
            }
            num = Integer.valueOf(i10);
        } else {
            l10 = Long.valueOf(j18);
            num = Integer.valueOf(i12);
        }
        return new Pair(l10, num);
    }

    public final f d(Uri uri, int i10) {
        if (uri == null) {
            return null;
        }
        a aVar = this.f13176j;
        byte[] bArr = (byte[]) ((LinkedHashMap) aVar.f4852i).remove(uri);
        if (bArr != null) {
            byte[] bArr2 = (byte[]) ((LinkedHashMap) aVar.f4852i).put(uri, bArr);
            return null;
        }
        k1.l lVar = new k1.l();
        lVar.f9013a = uri;
        lVar.f9020h = 1;
        return new f(this.f13169c, lVar.a(), this.f13172f[i10], this.f13183q.n(), this.f13183q.q(), this.f13179m);
    }
}
