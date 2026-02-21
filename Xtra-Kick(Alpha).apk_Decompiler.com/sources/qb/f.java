package qb;

import dc.c0;
import dc.d0;
import dc.l;
import dc.m;
import dc.n;
import fb.w;
import fb.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import ma.j;
import ma.r;
import oa.b;
import pb.n1;
import pb.o0;
import pb.o1;
import pb.p0;
import pb.t1;
import pb.u1;
import pb.x0;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f13487a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final d0 f13488b;

    /* renamed from: c  reason: collision with root package name */
    public static final p0 f13489c = o0.a(new String[0]);

    /* renamed from: d  reason: collision with root package name */
    public static final e f13490d;

    static {
        ArrayList arrayList;
        boolean z10;
        boolean z11;
        int i10;
        c0 c0Var = d0.f4749k;
        n.f4802k.getClass();
        n[] nVarArr = {m.a("efbbbf"), m.a("feff"), m.a("fffe"), m.a("0000ffff"), m.a("ffff0000")};
        c0Var.getClass();
        ArrayList arrayList2 = new ArrayList(new j(nVarArr, false));
        if (arrayList2.size() > 1) {
            Collections.sort(arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(5);
        for (int i11 = 0; i11 < 5; i11++) {
            n nVar = nVarArr[i11];
            arrayList3.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList3.toArray(new Integer[0]);
        Object[] copyOf = Arrays.copyOf(numArr, numArr.length);
        xa.j.f("elements", copyOf);
        if (copyOf.length == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(new j(copyOf, true));
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < 5) {
            n nVar2 = nVarArr[i12];
            int i14 = i13 + 1;
            int size = arrayList2.size();
            r.g(arrayList2.size(), 0, size);
            int i15 = size - 1;
            int i16 = 0;
            while (true) {
                if (i16 > i15) {
                    i10 = -(i16 + 1);
                    break;
                }
                i10 = (i16 + i15) >>> 1;
                int a10 = b.a((Comparable) arrayList2.get(i10), nVar2);
                if (a10 >= 0) {
                    if (a10 <= 0) {
                        break;
                    }
                    i15 = i10 - 1;
                } else {
                    i16 = i10 + 1;
                }
            }
            arrayList.set(i10, Integer.valueOf(i13));
            i12++;
            i13 = i14;
        }
        if (((n) arrayList2.get(0)).d() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i17 = 0;
            while (i17 < arrayList2.size()) {
                n nVar3 = (n) arrayList2.get(i17);
                int i18 = i17 + 1;
                int i19 = i18;
                while (i19 < arrayList2.size()) {
                    n nVar4 = (n) arrayList2.get(i19);
                    nVar4.getClass();
                    xa.j.f("prefix", nVar3);
                    if (!nVar4.m(0, nVar3, nVar3.d())) {
                        continue;
                        break;
                    }
                    if (nVar4.d() != nVar3.d()) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new IllegalArgumentException(("duplicate option: " + nVar4).toString());
                    } else if (((Number) arrayList.get(i19)).intValue() > ((Number) arrayList.get(i17)).intValue()) {
                        arrayList2.remove(i19);
                        arrayList.remove(i19);
                    } else {
                        i19++;
                    }
                }
                i17 = i18;
            }
            dc.j jVar = new dc.j();
            c0.a(0, jVar, 0, arrayList2, 0, arrayList2.size(), arrayList);
            int[] iArr = new int[((int) (jVar.f4787i / ((long) 4)))];
            int i20 = 0;
            while (!jVar.R()) {
                iArr[i20] = jVar.readInt();
                i20++;
            }
            Object[] copyOf2 = Arrays.copyOf(nVarArr, 5);
            xa.j.e("copyOf(this, size)", copyOf2);
            f13488b = new d0((n[]) copyOf2, iArr);
            p0.f12930i.getClass();
            n1 n1Var = o1.Companion;
            byte[] bArr = f13487a;
            n1.c(n1Var, bArr, (x0) null, 0, 7);
            u1.Companion.getClass();
            f13490d = t1.c(bArr, (x0) null);
            return;
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
    }

    public static final void a(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("length=" + j10 + ", offset=" + j11 + ", count=" + j11);
        }
    }

    public static final void b(Closeable closeable) {
        xa.j.f("<this>", closeable);
        try {
            closeable.close();
        } catch (RuntimeException e10) {
            throw e10;
        } catch (Exception unused) {
        }
    }

    public static final int c(int i10, int i11, String str, String str2) {
        xa.j.f("<this>", str);
        while (i10 < i11) {
            if (y.o(str2, str.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int d(String str, char c10, int i10, int i11) {
        xa.j.f("<this>", str);
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static /* synthetic */ int e(String str, char c10, int i10, int i11, int i12) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = str.length();
        }
        return d(str, c10, i10, i11);
    }

    public static final boolean f(String[] strArr, String[] strArr2, Comparator comparator) {
        boolean z10;
        boolean z11;
        xa.j.f("<this>", strArr);
        xa.j.f("comparator", comparator);
        if (strArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && strArr2 != null) {
            if (strArr2.length == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                for (String str : strArr) {
                    q.m mVar = new q.m((Object[]) strArr2);
                    while (mVar.hasNext()) {
                        if (comparator.compare(str, (String) mVar.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final int g(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (xa.j.h(charAt, 31) <= 0 || xa.j.h(charAt, 127) >= 0) {
                return i10;
            }
        }
        return -1;
    }

    public static final int h(int i10, int i11, String str) {
        xa.j.f("<this>", str);
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            boolean z10 = false;
            if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                z10 = true;
            }
            if (!z10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static final int i(int i10, int i11, String str) {
        xa.j.f("<this>", str);
        int i12 = i11 - 1;
        if (i10 <= i12) {
            while (true) {
                char charAt = str.charAt(i12);
                boolean z10 = false;
                if ((((charAt == 9 || charAt == 10) || charAt == 12) || charAt == 13) || charAt == ' ') {
                    z10 = true;
                }
                if (z10) {
                    if (i12 == i10) {
                        break;
                    }
                    i12--;
                } else {
                    return i12 + 1;
                }
            }
        }
        return i10;
    }

    public static final String[] j(String[] strArr, String[] strArr2, Comparator comparator) {
        xa.j.f("other", strArr2);
        xa.j.f("comparator", comparator);
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i10++;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        xa.j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>", array);
        return (String[]) array;
    }

    public static final boolean k(String str) {
        xa.j.f("name", str);
        return w.g(str, "Authorization") || w.g(str, "Cookie") || w.g(str, "Proxy-Authorization") || w.g(str, "Set-Cookie");
    }

    public static final int l(char c10) {
        boolean z10 = true;
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if ('A' > c10 || c10 >= 'G') {
                z10 = false;
            }
            if (!z10) {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static final int m(l lVar) {
        xa.j.f("<this>", lVar);
        return (lVar.readByte() & 255) | ((lVar.readByte() & 255) << 16) | ((lVar.readByte() & 255) << 8);
    }

    public static final int n(int i10, String str) {
        if (str == null) {
            return i10;
        }
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public static final String o(int i10, int i11, String str) {
        int h10 = h(i10, i11, str);
        String substring = str.substring(h10, i(h10, i11, str));
        xa.j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
        return substring;
    }
}
