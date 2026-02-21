package o1;

import h1.a;
import h1.b;
import java.nio.ByteBuffer;

public final class l0 extends q {

    /* renamed from: i  reason: collision with root package name */
    public final long f11937i = 150000;

    /* renamed from: j  reason: collision with root package name */
    public final long f11938j = 20000;

    /* renamed from: k  reason: collision with root package name */
    public final short f11939k = 1024;

    /* renamed from: l  reason: collision with root package name */
    public int f11940l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f11941m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f11942n;

    /* renamed from: o  reason: collision with root package name */
    public byte[] f11943o;

    /* renamed from: p  reason: collision with root package name */
    public int f11944p;

    /* renamed from: q  reason: collision with root package name */
    public int f11945q;

    /* renamed from: r  reason: collision with root package name */
    public int f11946r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11947s;

    /* renamed from: t  reason: collision with root package name */
    public long f11948t;

    public l0() {
        byte[] bArr = j1.l0.f8458f;
        this.f11942n = bArr;
        this.f11943o = bArr;
    }

    public final boolean c() {
        return this.f11941m;
    }

    public final void e(ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.f12035g.hasRemaining()) {
            int i10 = this.f11944p;
            if (i10 == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f11942n.length));
                int limit2 = byteBuffer.limit();
                while (true) {
                    limit2 -= 2;
                    if (limit2 >= byteBuffer.position()) {
                        if (Math.abs(byteBuffer.getShort(limit2)) > this.f11939k) {
                            int i11 = this.f11940l;
                            position = ((limit2 / i11) * i11) + i11;
                            break;
                        }
                    } else {
                        position = byteBuffer.position();
                        break;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.f11944p = 1;
                } else {
                    byteBuffer.limit(position);
                    int remaining = byteBuffer.remaining();
                    l(remaining).put(byteBuffer).flip();
                    if (remaining > 0) {
                        this.f11947s = true;
                    }
                }
                byteBuffer.limit(limit);
            } else if (i10 == 1) {
                int limit3 = byteBuffer.limit();
                int m10 = m(byteBuffer);
                int position2 = m10 - byteBuffer.position();
                byte[] bArr = this.f11942n;
                int length = bArr.length;
                int i12 = this.f11945q;
                int i13 = length - i12;
                if (m10 >= limit3 || position2 >= i13) {
                    int min = Math.min(position2, i13);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.f11942n, this.f11945q, min);
                    int i14 = this.f11945q + min;
                    this.f11945q = i14;
                    byte[] bArr2 = this.f11942n;
                    if (i14 == bArr2.length) {
                        if (this.f11947s) {
                            n(this.f11946r, bArr2);
                            this.f11948t += (long) ((this.f11945q - (this.f11946r * 2)) / this.f11940l);
                        } else {
                            this.f11948t += (long) ((i14 - this.f11946r) / this.f11940l);
                        }
                        o(byteBuffer, this.f11942n, this.f11945q);
                        this.f11945q = 0;
                        this.f11944p = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    n(i12, bArr);
                    this.f11945q = 0;
                    this.f11944p = 0;
                }
            } else if (i10 == 2) {
                int limit4 = byteBuffer.limit();
                int m11 = m(byteBuffer);
                byteBuffer.limit(m11);
                this.f11948t += (long) (byteBuffer.remaining() / this.f11940l);
                o(byteBuffer, this.f11943o, this.f11946r);
                if (m11 < limit4) {
                    n(this.f11946r, this.f11943o);
                    this.f11944p = 0;
                    byteBuffer.limit(limit4);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final a h(a aVar) {
        if (aVar.f6880c == 2) {
            return this.f11941m ? aVar : a.f6877e;
        }
        throw new b(aVar);
    }

    public final void i() {
        if (this.f11941m) {
            a aVar = this.f12030b;
            int i10 = aVar.f6881d;
            this.f11940l = i10;
            int i11 = aVar.f6878a;
            int i12 = ((int) ((this.f11937i * ((long) i11)) / 1000000)) * i10;
            if (this.f11942n.length != i12) {
                this.f11942n = new byte[i12];
            }
            int i13 = ((int) ((this.f11938j * ((long) i11)) / 1000000)) * i10;
            this.f11946r = i13;
            if (this.f11943o.length != i13) {
                this.f11943o = new byte[i13];
            }
        }
        this.f11944p = 0;
        this.f11948t = 0;
        this.f11945q = 0;
        this.f11947s = false;
    }

    public final void j() {
        int i10 = this.f11945q;
        if (i10 > 0) {
            n(i10, this.f11942n);
        }
        if (!this.f11947s) {
            this.f11948t += (long) (this.f11946r / this.f11940l);
        }
    }

    public final void k() {
        this.f11941m = false;
        this.f11946r = 0;
        byte[] bArr = j1.l0.f8458f;
        this.f11942n = bArr;
        this.f11943o = bArr;
    }

    public final int m(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > this.f11939k) {
                int i10 = this.f11940l;
                return (position / i10) * i10;
            }
        }
        return byteBuffer.limit();
    }

    public final void n(int i10, byte[] bArr) {
        l(i10).put(bArr, 0, i10).flip();
        if (i10 > 0) {
            this.f11947s = true;
        }
    }

    public final void o(ByteBuffer byteBuffer, byte[] bArr, int i10) {
        int min = Math.min(byteBuffer.remaining(), this.f11946r);
        int i11 = this.f11946r - min;
        System.arraycopy(bArr, i10 - i11, this.f11943o, 0, i11);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f11943o, i11, min);
    }
}
