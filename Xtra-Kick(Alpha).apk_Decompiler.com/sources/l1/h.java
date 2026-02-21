package l1;

import g1.t0;
import java.nio.ByteBuffer;

public class h extends a {

    /* renamed from: i  reason: collision with root package name */
    public final d f9514i = new d();

    /* renamed from: j  reason: collision with root package name */
    public ByteBuffer f9515j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9516k;

    /* renamed from: l  reason: collision with root package name */
    public long f9517l;

    /* renamed from: m  reason: collision with root package name */
    public ByteBuffer f9518m;

    /* renamed from: n  reason: collision with root package name */
    public final int f9519n;

    /* renamed from: o  reason: collision with root package name */
    public final int f9520o;

    static {
        t0.a("media3.decoder");
    }

    public h(int i10) {
        this.f9519n = i10;
        this.f9520o = 0;
    }

    public void h() {
        this.f9501h = 0;
        ByteBuffer byteBuffer = this.f9515j;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f9518m;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f9516k = false;
    }

    public final ByteBuffer i(int i10) {
        int i11 = this.f9519n;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f9515j;
        throw new g(byteBuffer == null ? 0 : byteBuffer.capacity(), i10);
    }

    public final void j(int i10) {
        int i11 = i10 + this.f9520o;
        ByteBuffer byteBuffer = this.f9515j;
        if (byteBuffer == null) {
            this.f9515j = i(i11);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i12 = i11 + position;
        if (capacity >= i12) {
            this.f9515j = byteBuffer;
            return;
        }
        ByteBuffer i13 = i(i12);
        i13.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            i13.put(byteBuffer);
        }
        this.f9515j = i13;
    }

    public final void k() {
        ByteBuffer byteBuffer = this.f9515j;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f9518m;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }
}
