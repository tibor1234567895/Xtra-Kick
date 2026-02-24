package v0;

import java.nio.ByteBuffer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f15551a;

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f15552b;

    /* renamed from: c  reason: collision with root package name */
    public int f15553c;

    /* renamed from: d  reason: collision with root package name */
    public int f15554d;

    public c() {
        if (d.f15555a == null) {
            d.f15555a = new e();
        }
    }

    public final int a(int i10) {
        if (i10 < this.f15554d) {
            return this.f15552b.getShort(this.f15553c + i10);
        }
        return 0;
    }
}
