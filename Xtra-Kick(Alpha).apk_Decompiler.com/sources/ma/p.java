package ma;

import fb.n;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import la.i;
import wa.l;
import xa.j;

public class p extends o {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean g(java.lang.Object[] r4, java.lang.Object r5) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r4)
            r0 = 0
            if (r5 != 0) goto L_0x0014
            int r5 = r4.length
            r1 = 0
        L_0x000a:
            if (r1 >= r5) goto L_0x0025
            r2 = r4[r1]
            if (r2 != 0) goto L_0x0011
            goto L_0x0026
        L_0x0011:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x0014:
            int r1 = r4.length
            r2 = 0
        L_0x0016:
            if (r2 >= r1) goto L_0x0025
            r3 = r4[r2]
            boolean r3 = xa.j.a(r5, r3)
            if (r3 == 0) goto L_0x0022
            r1 = r2
            goto L_0x0026
        L_0x0022:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0025:
            r1 = -1
        L_0x0026:
            if (r1 < 0) goto L_0x0029
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.p.g(java.lang.Object[], java.lang.Object):boolean");
    }

    public static String h(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        int i10 = 0;
        for (Object obj : objArr) {
            i10++;
            if (i10 > 1) {
                sb2.append(", ");
            }
            n.a(sb2, obj, (l) null);
        }
        sb2.append("");
        String sb3 = sb2.toString();
        j.e("joinTo(StringBuilder(), …ed, transform).toString()", sb3);
        return sb3;
    }

    public static final char i(char[] cArr) {
        j.f("<this>", cArr);
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final List j(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return b0.f10801h;
        }
        if (length != 1) {
            return new ArrayList(new j(objArr, false));
        }
        return q.b(objArr[0]);
    }

    public static final ArrayList k(Object[] objArr, Object[] objArr2) {
        int min = Math.min(objArr.length, objArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i10 = 0; i10 < min; i10++) {
            arrayList.add(new i(objArr[i10], objArr2[i10]));
        }
        return arrayList;
    }
}
