package n3;

import android.support.v4.media.h;
import androidx.fragment.app.k;
import cb.c;
import cb.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.r;
import ma.z;
import xa.j;

public final class n3 implements j1 {

    /* renamed from: e  reason: collision with root package name */
    public static final m3 f11353e = new m3(0);

    /* renamed from: f  reason: collision with root package name */
    public static final n3 f11354f = new n3(q1.f11421h);

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f11355a;

    /* renamed from: b  reason: collision with root package name */
    public int f11356b;

    /* renamed from: c  reason: collision with root package name */
    public int f11357c;

    /* renamed from: d  reason: collision with root package name */
    public int f11358d;

    static {
        q1.f11420g.getClass();
    }

    public n3(q1 q1Var) {
        j.f("insertEvent", q1Var);
        List<u5> list = q1Var.f11423b;
        this.f11355a = z.K(list);
        int i10 = 0;
        for (u5 u5Var : list) {
            i10 += u5Var.f11514b.size();
        }
        this.f11356b = i10;
        this.f11357c = q1Var.f11424c;
        this.f11358d = q1Var.f11425d;
    }

    public final y5 a(int i10) {
        ArrayList arrayList;
        int i11 = 0;
        int i12 = i10 - this.f11357c;
        while (true) {
            arrayList = this.f11355a;
            if (i12 < ((u5) arrayList.get(i11)).f11514b.size() || i11 >= r.d(arrayList)) {
                int d10 = d();
                int e10 = e();
            } else {
                i12 -= ((u5) arrayList.get(i11)).f11514b.size();
                i11++;
            }
        }
        int d102 = d();
        int e102 = e();
        return new y5(((u5) arrayList.get(i11)).f11515c, i12, i10 - this.f11357c, ((f() - i10) - this.f11358d) - 1, d102, e102);
    }

    public final int b(e eVar) {
        boolean z10;
        Iterator it = this.f11355a.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            u5 u5Var = (u5) it.next();
            int[] iArr = u5Var.f11513a;
            int length = iArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    z10 = false;
                    break;
                } else if (eVar.b(iArr[i11])) {
                    z10 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z10) {
                i10 += u5Var.f11514b.size();
                it.remove();
            }
        }
        return i10;
    }

    public final Object c(int i10) {
        ArrayList arrayList = this.f11355a;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            int size2 = ((u5) arrayList.get(i11)).f11514b.size();
            if (size2 > i10) {
                break;
            }
            i10 -= size2;
            i11++;
        }
        return ((u5) arrayList.get(i11)).f11514b.get(i10);
    }

    public final int d() {
        boolean z10;
        Integer num;
        int[] iArr = ((u5) z.s(this.f11355a)).f11513a;
        j.f("<this>", iArr);
        if (iArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            num = null;
        } else {
            int i10 = iArr[0];
            c a10 = new e(1, iArr.length - 1).iterator();
            while (a10.f3068j) {
                int i11 = iArr[a10.a()];
                if (i10 > i11) {
                    i10 = i11;
                }
            }
            num = Integer.valueOf(i10);
        }
        j.c(num);
        return num.intValue();
    }

    public final int e() {
        boolean z10;
        Integer num;
        int[] iArr = ((u5) z.z(this.f11355a)).f11513a;
        j.f("<this>", iArr);
        if (iArr.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            num = null;
        } else {
            int i10 = iArr[0];
            c a10 = new e(1, iArr.length - 1).iterator();
            while (a10.f3068j) {
                int i11 = iArr[a10.a()];
                if (i10 < i11) {
                    i10 = i11;
                }
            }
            num = Integer.valueOf(i10);
        }
        j.c(num);
        return num.intValue();
    }

    public final int f() {
        return this.f11357c + this.f11356b + this.f11358d;
    }

    public final String toString() {
        int i10 = this.f11356b;
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(c(i11));
        }
        String y10 = z.y(arrayList, (String) null, (String) null, (String) null, (k) null, 63);
        StringBuilder sb2 = new StringBuilder("[(");
        sb2.append(this.f11357c);
        sb2.append(" placeholders), ");
        sb2.append(y10);
        sb2.append(", (");
        return h.o(sb2, this.f11358d, " placeholders)]");
    }
}
