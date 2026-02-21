package d9;

import java.util.Arrays;

public abstract class k0 extends l0 {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f4626a = new Object[4];

    /* renamed from: b  reason: collision with root package name */
    public int f4627b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4628c;

    public k0() {
        u.a(4, "initialCapacity");
    }

    public final void b(int i10) {
        Object[] objArr = this.f4626a;
        if (objArr.length < i10) {
            this.f4626a = Arrays.copyOf(objArr, l0.a(objArr.length, i10));
        } else if (this.f4628c) {
            this.f4626a = (Object[]) objArr.clone();
        } else {
            return;
        }
        this.f4628c = false;
    }
}
