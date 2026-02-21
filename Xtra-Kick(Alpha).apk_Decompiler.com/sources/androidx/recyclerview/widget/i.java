package androidx.recyclerview.widget;

public final class i implements x0 {

    /* renamed from: a  reason: collision with root package name */
    public final x0 f2040a;

    /* renamed from: b  reason: collision with root package name */
    public int f2041b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2042c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2043d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Object f2044e = null;

    public i(x0 x0Var) {
        this.f2040a = x0Var;
    }

    public final void a(int i10, int i11) {
        int i12;
        if (this.f2041b != 2 || (i12 = this.f2042c) < i10 || i12 > i10 + i11) {
            e();
            this.f2042c = i10;
            this.f2043d = i11;
            this.f2041b = 2;
            return;
        }
        this.f2043d += i11;
        this.f2042c = i10;
    }

    public final void b(int i10, int i11) {
        e();
        this.f2040a.b(i10, i11);
    }

    public final void c(int i10, int i11) {
        int i12;
        if (this.f2041b == 1 && i10 >= (i12 = this.f2042c)) {
            int i13 = this.f2043d;
            if (i10 <= i12 + i13) {
                this.f2043d = i13 + i11;
                this.f2042c = Math.min(i10, i12);
                return;
            }
        }
        e();
        this.f2042c = i10;
        this.f2043d = i11;
        this.f2041b = 1;
    }

    public final void d(int i10, int i11, Object obj) {
        int i12;
        if (this.f2041b == 3) {
            int i13 = this.f2042c;
            int i14 = this.f2043d;
            if (i10 <= i13 + i14 && (i12 = i10 + i11) >= i13 && this.f2044e == obj) {
                this.f2042c = Math.min(i10, i13);
                this.f2043d = Math.max(i14 + i13, i12) - this.f2042c;
                return;
            }
        }
        e();
        this.f2042c = i10;
        this.f2043d = i11;
        this.f2044e = obj;
        this.f2041b = 3;
    }

    public final void e() {
        int i10 = this.f2041b;
        if (i10 != 0) {
            x0 x0Var = this.f2040a;
            if (i10 == 1) {
                x0Var.c(this.f2042c, this.f2043d);
            } else if (i10 == 2) {
                x0Var.a(this.f2042c, this.f2043d);
            } else if (i10 == 3) {
                x0Var.d(this.f2042c, this.f2043d, this.f2044e);
            }
            this.f2044e = null;
            this.f2041b = 0;
        }
    }
}
