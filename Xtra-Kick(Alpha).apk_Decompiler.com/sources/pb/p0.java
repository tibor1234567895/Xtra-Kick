package pb;

import fb.w;
import hb.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import la.i;
import ma.o;
import q.m;
import qb.f;
import ub.d;
import xa.j;
import xa.x;
import ya.a;

public final class p0 implements Iterable, a {

    /* renamed from: i  reason: collision with root package name */
    public static final o0 f12930i = new o0(0);

    /* renamed from: h  reason: collision with root package name */
    public final String[] f12931h;

    public p0(String[] strArr) {
        this.f12931h = strArr;
    }

    public final String a(String str) {
        String[] strArr = this.f12931h;
        j.f("namesAndValues", strArr);
        int length = strArr.length - 2;
        int B0 = h0.B0(length, 0, -2);
        if (B0 <= length) {
            while (!w.g(str, strArr[length])) {
                if (length != B0) {
                    length -= 2;
                }
            }
            return strArr[length + 1];
        }
        return null;
    }

    public final Date b(String str) {
        String a10 = a(str);
        if (a10 != null) {
            return d.a(a10);
        }
        return null;
    }

    public final String c(int i10) {
        String str;
        int i11 = i10 * 2;
        String[] strArr = this.f12931h;
        j.f("<this>", strArr);
        if (i11 < 0 || i11 > strArr.length - 1) {
            str = null;
        } else {
            str = strArr[i11];
        }
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i10 + ']');
    }

    public final n0 d() {
        n0 n0Var = new n0();
        ArrayList arrayList = n0Var.f12909a;
        j.f("<this>", arrayList);
        String[] strArr = this.f12931h;
        j.f("elements", strArr);
        arrayList.addAll(o.b(strArr));
        return n0Var;
    }

    public final TreeMap e() {
        j.f("<this>", x.f16820a);
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        j.e("CASE_INSENSITIVE_ORDER", comparator);
        TreeMap treeMap = new TreeMap(comparator);
        int length = this.f12931h.length / 2;
        for (int i10 = 0; i10 < length; i10++) {
            String c10 = c(i10);
            Locale locale = Locale.US;
            j.e("US", locale);
            String lowerCase = c10.toLowerCase(locale);
            j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(f(i10));
        }
        return treeMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p0) {
            if (Arrays.equals(this.f12931h, ((p0) obj).f12931h)) {
                return true;
            }
        }
        return false;
    }

    public final String f(int i10) {
        String str;
        int i11 = (i10 * 2) + 1;
        String[] strArr = this.f12931h;
        j.f("<this>", strArr);
        if (i11 < 0 || i11 > strArr.length - 1) {
            str = null;
        } else {
            str = strArr[i11];
        }
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i10 + ']');
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12931h);
    }

    public final Iterator iterator() {
        int length = this.f12931h.length / 2;
        i[] iVarArr = new i[length];
        for (int i10 = 0; i10 < length; i10++) {
            iVarArr[i10] = new i(c(i10), f(i10));
        }
        return new m((Object[]) iVarArr);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int length = this.f12931h.length / 2;
        for (int i10 = 0; i10 < length; i10++) {
            String c10 = c(i10);
            String f10 = f(i10);
            sb2.append(c10);
            sb2.append(": ");
            if (f.k(c10)) {
                f10 = "██";
            }
            sb2.append(f10);
            sb2.append(Constants.WRITE_NEW_LINE);
        }
        String sb3 = sb2.toString();
        j.e("StringBuilder().apply(builderAction).toString()", sb3);
        return sb3;
    }
}
