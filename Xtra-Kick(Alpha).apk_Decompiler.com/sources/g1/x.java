package g1;

import android.util.SparseBooleanArray;
import j1.a;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final SparseBooleanArray f6688a = new SparseBooleanArray();

    /* renamed from: b  reason: collision with root package name */
    public boolean f6689b;

    public final void a(int i10) {
        a.e(!this.f6689b);
        this.f6688a.append(i10, true);
    }

    public final void b(int... iArr) {
        for (int a10 : iArr) {
            a(a10);
        }
    }

    public final y c() {
        a.e(!this.f6689b);
        this.f6689b = true;
        return new y(this.f6688a);
    }
}
