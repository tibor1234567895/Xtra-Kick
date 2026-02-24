package o1;

import h1.a;
import h1.b;
import j1.l0;
import java.nio.ByteBuffer;

public final class o0 extends q {

    /* renamed from: i  reason: collision with root package name */
    public int f11997i;

    /* renamed from: j  reason: collision with root package name */
    public int f11998j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11999k;

    /* renamed from: l  reason: collision with root package name */
    public int f12000l;

    /* renamed from: m  reason: collision with root package name */
    public byte[] f12001m = l0.f8458f;

    /* renamed from: n  reason: collision with root package name */
    public int f12002n;

    /* renamed from: o  reason: collision with root package name */
    public long f12003o;

    public final ByteBuffer a() {
        int i10;
        if (super.d() && (i10 = this.f12002n) > 0) {
            l(i10).put(this.f12001m, 0, this.f12002n).flip();
            this.f12002n = 0;
        }
        return super.a();
    }

    public final boolean d() {
        return super.d() && this.f12002n == 0;
    }

    public final void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        if (i10 != 0) {
            int min = Math.min(i10, this.f12000l);
            this.f12003o += (long) (min / this.f12030b.f6881d);
            this.f12000l -= min;
            byteBuffer.position(position + min);
            if (this.f12000l <= 0) {
                int i11 = i10 - min;
                int length = (this.f12002n + i11) - this.f12001m.length;
                ByteBuffer l10 = l(length);
                int h10 = l0.h(length, 0, this.f12002n);
                l10.put(this.f12001m, 0, h10);
                int h11 = l0.h(length - h10, 0, i11);
                byteBuffer.limit(byteBuffer.position() + h11);
                l10.put(byteBuffer);
                byteBuffer.limit(limit);
                int i12 = i11 - h11;
                int i13 = this.f12002n - h10;
                this.f12002n = i13;
                byte[] bArr = this.f12001m;
                System.arraycopy(bArr, h10, bArr, 0, i13);
                byteBuffer.get(this.f12001m, this.f12002n, i12);
                this.f12002n += i12;
                l10.flip();
            }
        }
    }

    public final a h(a aVar) {
        if (aVar.f6880c == 2) {
            this.f11999k = true;
            return (this.f11997i == 0 && this.f11998j == 0) ? a.f6877e : aVar;
        }
        throw new b(aVar);
    }

    public final void i() {
        if (this.f11999k) {
            this.f11999k = false;
            int i10 = this.f11998j;
            int i11 = this.f12030b.f6881d;
            this.f12001m = new byte[(i10 * i11)];
            this.f12000l = this.f11997i * i11;
        }
        this.f12002n = 0;
    }

    public final void j() {
        if (this.f11999k) {
            int i10 = this.f12002n;
            if (i10 > 0) {
                this.f12003o += (long) (i10 / this.f12030b.f6881d);
            }
            this.f12002n = 0;
        }
    }

    public final void k() {
        this.f12001m = l0.f8458f;
    }
}
