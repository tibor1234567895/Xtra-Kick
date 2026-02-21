package oa;

import java.util.Comparator;
import java.util.regex.Pattern;
import s1.b0;
import s1.c0;
import xa.j;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12364h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f12365i;

    public /* synthetic */ a(int i10, Object obj) {
        this.f12364h = i10;
        this.f12365i = obj;
    }

    public final int compare(Object obj, Object obj2) {
        int i10 = this.f12364h;
        Object obj3 = this.f12365i;
        switch (i10) {
            case 0:
                Comparator comparator = (Comparator) obj3;
                j.f("$comparator", comparator);
                if (obj == obj2) {
                    return 0;
                }
                if (obj == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                return comparator.compare(obj, obj2);
            case 1:
                Comparator comparator2 = (Comparator) obj3;
                j.f("$comparator", comparator2);
                if (obj == obj2) {
                    return 0;
                }
                if (obj == null) {
                    return 1;
                }
                if (obj2 == null) {
                    return -1;
                }
                return comparator2.compare(obj, obj2);
            default:
                b0 b0Var = (b0) obj3;
                Pattern pattern = c0.f13983a;
                return b0Var.d(obj2) - b0Var.d(obj);
        }
    }
}
