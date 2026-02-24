package androidx.recyclerview.widget;

import android.util.SparseIntArray;

public abstract class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f2094a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    public final SparseIntArray f2095b = new SparseIntArray();

    public final int a(int i10, int i11) {
        b();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            b();
            i12++;
            if (i12 == i11) {
                i13++;
                i12 = 0;
            } else if (i12 > i11) {
                i13++;
                i12 = 1;
            }
        }
        return i12 + 1 > i11 ? i13 + 1 : i13;
    }

    public abstract void b();

    public final void c() {
        this.f2094a.clear();
    }
}
