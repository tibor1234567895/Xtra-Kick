package u2;

import h3.s2;
import v3.d;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f15200a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15201b;

    public /* synthetic */ c(int i10, int i11) {
        this.f15200a = i11;
        this.f15201b = i10;
    }

    public static String c(int i10) {
        return "" + ((char) ((i10 >> 24) & 255)) + ((char) ((i10 >> 16) & 255)) + ((char) ((i10 >> 8) & 255)) + ((char) (i10 & 255));
    }

    public abstract void a(d dVar);

    public abstract void b(d dVar);

    public abstract void d(d dVar);

    public abstract void e(d dVar);

    public abstract void f();

    public abstract void g(d dVar);

    public abstract s2 h(d dVar);

    public String toString() {
        switch (this.f15200a) {
            case 0:
                return c(this.f15201b);
            default:
                return super.toString();
        }
    }
}
