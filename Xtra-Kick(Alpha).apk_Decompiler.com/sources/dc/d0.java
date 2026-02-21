package dc;

import java.util.RandomAccess;
import ma.f;

public final class d0 extends f implements RandomAccess {

    /* renamed from: k  reason: collision with root package name */
    public static final c0 f4749k = new c0(0);

    /* renamed from: i  reason: collision with root package name */
    public final n[] f4750i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f4751j;

    public d0(n[] nVarArr, int[] iArr) {
        this.f4750i = nVarArr;
        this.f4751j = iArr;
    }

    public final int a() {
        return this.f4750i.length;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        return super.contains((n) obj);
    }

    public final Object get(int i10) {
        return this.f4750i[i10];
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof n)) {
            return -1;
        }
        return super.indexOf((n) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof n)) {
            return -1;
        }
        return super.lastIndexOf((n) obj);
    }
}
