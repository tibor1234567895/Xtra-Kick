package j0;

import a2.t;
import d9.c0;
import d9.e0;
import d9.p1;
import e3.e;
import g1.a0;
import i3.i0;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import x2.d;
import z1.g;
import z1.m;
import z1.p;
import z1.q;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8380h;

    public /* synthetic */ a(int i10) {
        this.f8380h = i10;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.f8380h) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i10 = 0; i10 < bArr.length; i10++) {
                    byte b10 = bArr[i10];
                    byte b11 = bArr2[i10];
                    if (b10 != b11) {
                        return b10 - b11;
                    }
                }
                return 0;
            case 1:
                return ((a0) obj2).f6272o - ((a0) obj).f6272o;
            case 2:
                return ((g) Collections.max((List) obj)).compareTo((g) Collections.max((List) obj2));
            case 3:
                List list = (List) obj;
                List list2 = (List) obj2;
                c0 c0Var = e0.f4608a;
                a aVar = new a(9);
                c0Var.getClass();
                return c0.f(aVar.compare((p) Collections.max(list, new a(7)), (p) Collections.max(list2, new a(8)))).a(list.size(), list2.size()).b((p) Collections.max(list, new a(10)), (p) Collections.max(list2, new a(11)), new a(12)).e();
            case 4:
                return ((m) ((List) obj).get(0)).compareTo((m) ((List) obj2).get(0));
            case Constants.MAX_COMPATIBILITY_VERSION:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                p1 p1Var = q.f17467j;
                if (num.intValue() == -1) {
                    if (num2.intValue() == -1) {
                        return 0;
                    }
                    return -1;
                } else if (num2.intValue() == -1) {
                    return 1;
                } else {
                    return num.intValue() - num2.intValue();
                }
            case 6:
                Integer num3 = (Integer) obj;
                Integer num4 = (Integer) obj2;
                p1 p1Var2 = q.f17467j;
                return 0;
            case 7:
                return p.d((p) obj, (p) obj2);
            case 8:
                return p.d((p) obj, (p) obj2);
            case 9:
                return p.d((p) obj, (p) obj2);
            case 10:
                return p.c((p) obj, (p) obj2);
            case 11:
                return p.c((p) obj, (p) obj2);
            case 12:
                return p.c((p) obj, (p) obj2);
            case 13:
                return ((t) obj).f83a - ((t) obj2).f83a;
            case 14:
                return Float.compare(((t) obj).f85c, ((t) obj2).f85c);
            case Constants.IV_SIZE:
                return Integer.compare(((d) obj2).f16598b, ((d) obj).f16598b);
            case 17:
                return Integer.compare(((e) obj).f5012a.f5015b, ((e) obj2).f5012a.f5015b);
            case 18:
                return Long.compare(((e3.d) obj).f5009b, ((e3.d) obj2).f5009b);
            case 19:
                i0 i0Var = (i0) obj;
                i0 i0Var2 = (i0) obj2;
                int compare = Integer.compare(i0Var2.f8107b, i0Var.f8107b);
                if (compare != 0) {
                    return compare;
                }
                int compareTo = i0Var.f8108c.compareTo(i0Var2.f8108c);
                if (compareTo != 0) {
                    return compareTo;
                }
                return i0Var.f8109d.compareTo(i0Var2.f8109d);
            default:
                i0 i0Var3 = (i0) obj;
                i0 i0Var4 = (i0) obj2;
                int compare2 = Integer.compare(i0Var4.f8106a, i0Var3.f8106a);
                if (compare2 != 0) {
                    return compare2;
                }
                int compareTo2 = i0Var4.f8108c.compareTo(i0Var3.f8108c);
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                return i0Var4.f8109d.compareTo(i0Var3.f8109d);
        }
    }
}
