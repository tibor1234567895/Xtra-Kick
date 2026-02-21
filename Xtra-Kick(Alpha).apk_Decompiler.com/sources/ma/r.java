package ma;

import android.support.v4.media.h;
import java.util.List;
import m6.y;
import xa.j;

public class r extends q {
    public static int c(List list, y yVar) {
        int size = list.size();
        j.f("<this>", list);
        int i10 = 0;
        g(list.size(), 0, size);
        int i11 = size - 1;
        while (i10 <= i11) {
            int i12 = (i10 + i11) >>> 1;
            int intValue = ((Number) yVar.invoke(list.get(i12))).intValue();
            if (intValue < 0) {
                i10 = i12 + 1;
            } else if (intValue <= 0) {
                return i12;
            } else {
                i11 = i12 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final int d(List list) {
        j.f("<this>", list);
        return list.size() - 1;
    }

    public static final List e(Object... objArr) {
        j.f("elements", objArr);
        if (objArr.length > 0) {
            return o.b(objArr);
        }
        return b0.f10801h;
    }

    public static final List f(List list) {
        int size = list.size();
        if (size == 0) {
            return b0.f10801h;
        }
        if (size != 1) {
            return list;
        }
        return q.b(list.get(0));
    }

    public static final void g(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException(h.j("fromIndex (", i11, ") is less than zero."));
        } else if (i12 > i10) {
            throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
        }
    }

    public static final void h() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
