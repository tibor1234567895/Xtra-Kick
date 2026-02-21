package v;

import android.support.v4.media.h;
import java.util.ArrayList;
import java.util.Iterator;
import s.e;
import u.b;
import u.f;
import u.g;

public final class p {

    /* renamed from: f  reason: collision with root package name */
    public static int f15535f;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f15536a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final int f15537b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f15538c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f15539d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f15540e = -1;

    public p(int i10) {
        int i11 = f15535f;
        f15535f = i11 + 1;
        this.f15537b = i11;
        this.f15538c = i10;
    }

    public final void a(ArrayList arrayList) {
        int size = this.f15536a.size();
        if (this.f15540e != -1 && size > 0) {
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                p pVar = (p) arrayList.get(i10);
                if (this.f15540e == pVar.f15537b) {
                    c(this.f15538c, pVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(e eVar, int i10) {
        int i11;
        u.e eVar2;
        ArrayList arrayList = this.f15536a;
        if (arrayList.size() == 0) {
            return 0;
        }
        g gVar = (g) ((f) arrayList.get(0)).U;
        eVar.t();
        gVar.c(eVar, false);
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            ((f) arrayList.get(i12)).c(eVar, false);
        }
        if (i10 == 0 && gVar.A0 > 0) {
            b.a(gVar, eVar, arrayList, 0);
        }
        if (i10 == 1 && gVar.B0 > 0) {
            b.a(gVar, eVar, arrayList, 1);
        }
        try {
            eVar.q();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f15539d = new ArrayList();
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            this.f15539d.add(new o(this, (f) arrayList.get(i13), eVar, i10));
        }
        if (i10 == 0) {
            i11 = e.o(gVar.J);
            eVar2 = gVar.L;
        } else {
            i11 = e.o(gVar.K);
            eVar2 = gVar.M;
        }
        int o10 = e.o(eVar2);
        eVar.t();
        return o10 - i11;
    }

    public final void c(int i10, p pVar) {
        Iterator it = this.f15536a.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            int i11 = pVar.f15537b;
            if (hasNext) {
                f fVar = (f) it.next();
                ArrayList arrayList = pVar.f15536a;
                if (!arrayList.contains(fVar)) {
                    arrayList.add(fVar);
                }
                if (i10 == 0) {
                    fVar.f15109o0 = i11;
                } else {
                    fVar.f15111p0 = i11;
                }
            } else {
                this.f15540e = i11;
                return;
            }
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f15538c;
        if (i10 == 0) {
            str = "Horizontal";
        } else if (i10 == 1) {
            str = "Vertical";
        } else if (i10 == 2) {
            str = "Both";
        } else {
            str = "Unknown";
        }
        sb2.append(str);
        sb2.append(" [");
        String o10 = h.o(sb2, this.f15537b, "] <");
        Iterator it = this.f15536a.iterator();
        while (it.hasNext()) {
            o10 = o10 + " " + ((f) it.next()).f15097i0;
        }
        return q0.f.g(o10, " >");
    }
}
