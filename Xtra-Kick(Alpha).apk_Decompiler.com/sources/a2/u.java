package a2;

import j0.a;
import java.util.ArrayList;
import java.util.Collections;

public final class u {

    /* renamed from: h  reason: collision with root package name */
    public static final a f86h = new a(13);

    /* renamed from: i  reason: collision with root package name */
    public static final a f87i = new a(14);

    /* renamed from: a  reason: collision with root package name */
    public final int f88a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f89b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final t[] f90c = new t[5];

    /* renamed from: d  reason: collision with root package name */
    public int f91d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f92e;

    /* renamed from: f  reason: collision with root package name */
    public int f93f;

    /* renamed from: g  reason: collision with root package name */
    public int f94g;

    public u(int i10) {
        this.f88a = i10;
    }

    public final void a(int i10, float f10) {
        t tVar;
        int i11;
        t tVar2;
        int i12;
        int i13 = this.f91d;
        ArrayList arrayList = this.f89b;
        if (i13 != 1) {
            Collections.sort(arrayList, f86h);
            this.f91d = 1;
        }
        int i14 = this.f94g;
        t[] tVarArr = this.f90c;
        if (i14 > 0) {
            int i15 = i14 - 1;
            this.f94g = i15;
            tVar = tVarArr[i15];
        } else {
            tVar = new t(0);
        }
        int i16 = this.f92e;
        this.f92e = i16 + 1;
        tVar.f83a = i16;
        tVar.f84b = i10;
        tVar.f85c = f10;
        arrayList.add(tVar);
        int i17 = this.f93f + i10;
        while (true) {
            this.f93f = i17;
            while (true) {
                int i18 = this.f93f;
                int i19 = this.f88a;
                if (i18 > i19) {
                    i11 = i18 - i19;
                    tVar2 = (t) arrayList.get(0);
                    i12 = tVar2.f84b;
                    if (i12 > i11) {
                        break;
                    }
                    this.f93f -= i12;
                    arrayList.remove(0);
                    int i20 = this.f94g;
                    if (i20 < 5) {
                        this.f94g = i20 + 1;
                        tVarArr[i20] = tVar2;
                    }
                } else {
                    return;
                }
            }
            tVar2.f84b = i12 - i11;
            i17 = this.f93f - i11;
        }
    }

    public final float b() {
        int i10 = this.f91d;
        ArrayList arrayList = this.f89b;
        if (i10 != 0) {
            Collections.sort(arrayList, f87i);
            this.f91d = 0;
        }
        float f10 = 0.5f * ((float) this.f93f);
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            t tVar = (t) arrayList.get(i12);
            i11 += tVar.f84b;
            if (((float) i11) >= f10) {
                return tVar.f85c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((t) arrayList.get(arrayList.size() - 1)).f85c;
    }
}
