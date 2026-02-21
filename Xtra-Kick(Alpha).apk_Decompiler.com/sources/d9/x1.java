package d9;

public final class x1 extends u0 {

    /* renamed from: p  reason: collision with root package name */
    public static final Object[] f4701p;

    /* renamed from: q  reason: collision with root package name */
    public static final x1 f4702q;

    /* renamed from: k  reason: collision with root package name */
    public final transient Object[] f4703k;

    /* renamed from: l  reason: collision with root package name */
    public final transient int f4704l;

    /* renamed from: m  reason: collision with root package name */
    public final transient Object[] f4705m;

    /* renamed from: n  reason: collision with root package name */
    public final transient int f4706n;

    /* renamed from: o  reason: collision with root package name */
    public final transient int f4707o;

    static {
        Object[] objArr = new Object[0];
        f4701p = objArr;
        f4702q = new x1(0, 0, 0, objArr, objArr);
    }

    public x1(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        this.f4703k = objArr;
        this.f4704l = i10;
        this.f4705m = objArr2;
        this.f4706n = i11;
        this.f4707o = i12;
    }

    public final int b(int i10, Object[] objArr) {
        Object[] objArr2 = this.f4703k;
        int i11 = this.f4707o;
        System.arraycopy(objArr2, 0, objArr, i10, i11);
        return i10 + i11;
    }

    public final Object[] c() {
        return this.f4703k;
    }

    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f4705m;
            if (objArr.length != 0) {
                int b10 = h0.b(obj);
                while (true) {
                    int i10 = b10 & this.f4706n;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    b10 = i10 + 1;
                }
            }
        }
        return false;
    }

    public final int d() {
        return this.f4707o;
    }

    public final int e() {
        return 0;
    }

    public final boolean f() {
        return false;
    }

    /* renamed from: g */
    public final i2 iterator() {
        return a().listIterator(0);
    }

    public final int hashCode() {
        return this.f4704l;
    }

    public final r0 k() {
        return r0.h(this.f4707o, this.f4703k);
    }

    public final int size() {
        return this.f4707o;
    }
}
