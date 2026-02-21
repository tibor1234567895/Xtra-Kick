package e0;

import android.graphics.Insets;

public final class d {

    /* renamed from: e  reason: collision with root package name */
    public static final d f4855e = new d(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f4856a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4857b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4858c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4859d;

    public d(int i10, int i11, int i12, int i13) {
        this.f4856a = i10;
        this.f4857b = i11;
        this.f4858c = i12;
        this.f4859d = i13;
    }

    public static d a(d dVar, d dVar2) {
        return b(Math.max(dVar.f4856a, dVar2.f4856a), Math.max(dVar.f4857b, dVar2.f4857b), Math.max(dVar.f4858c, dVar2.f4858c), Math.max(dVar.f4859d, dVar2.f4859d));
    }

    public static d b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f4855e : new d(i10, i11, i12, i13);
    }

    public static d c(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public final Insets d() {
        return c.a(this.f4856a, this.f4857b, this.f4858c, this.f4859d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f4859d == dVar.f4859d && this.f4856a == dVar.f4856a && this.f4858c == dVar.f4858c && this.f4857b == dVar.f4857b;
    }

    public final int hashCode() {
        return (((((this.f4856a * 31) + this.f4857b) * 31) + this.f4858c) * 31) + this.f4859d;
    }

    public final String toString() {
        return "Insets{left=" + this.f4856a + ", top=" + this.f4857b + ", right=" + this.f4858c + ", bottom=" + this.f4859d + '}';
    }
}
