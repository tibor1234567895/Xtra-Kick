package androidx.emoji2.text;

import b5.f;
import com.bumptech.glide.integration.webp.c;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import k5.k;
import k5.l;
import w5.a;

public final class b0 implements c, l, g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1245a;

    /* renamed from: b  reason: collision with root package name */
    public final ByteBuffer f1246b;

    public b0(int i10, ByteBuffer byteBuffer) {
        this.f1245a = i10;
        if (i10 == 1) {
            this.f1246b = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        } else if (i10 != 3) {
            this.f1246b = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        } else {
            this.f1246b = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
    }

    public final long a(long j10) {
        int min;
        int i10 = this.f1245a;
        ByteBuffer byteBuffer = this.f1246b;
        switch (i10) {
            case 1:
                min = (int) Math.min((long) byteBuffer.remaining(), j10);
                byteBuffer.position(byteBuffer.position() + min);
                break;
            default:
                min = (int) Math.min((long) byteBuffer.remaining(), j10);
                byteBuffer.position(byteBuffer.position() + min);
                break;
        }
        return (long) min;
    }

    public final int b() {
        int d10;
        short d11;
        switch (this.f1245a) {
            case 1:
                d10 = (g() << 8) & 65280;
                d11 = g() & 255;
                break;
            default:
                d10 = d() << 8;
                d11 = d();
                break;
        }
        return d10 | d11;
    }

    public final void c() {
    }

    public final short d() {
        ByteBuffer byteBuffer = this.f1246b;
        if (byteBuffer.remaining() >= 1) {
            return (short) (byteBuffer.get() & 255);
        }
        throw new k();
    }

    public final Object e() {
        ByteBuffer byteBuffer = this.f1246b;
        byteBuffer.position(0);
        return byteBuffer;
    }

    public final int f(int i10, byte[] bArr) {
        ByteBuffer byteBuffer = this.f1246b;
        int min = Math.min(i10, byteBuffer.remaining());
        if (min == 0) {
            return -1;
        }
        byteBuffer.get(bArr, 0, min);
        return min;
    }

    public final int g() {
        ByteBuffer byteBuffer = this.f1246b;
        if (byteBuffer.remaining() < 1) {
            return -1;
        }
        return byteBuffer.get();
    }

    public final short h(int i10) {
        boolean z10;
        ByteBuffer byteBuffer = this.f1246b;
        if (byteBuffer.remaining() - i10 >= 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return byteBuffer.getShort(i10);
        }
        return -1;
    }

    public final ImageHeaderParser$ImageType i(f fVar) {
        ByteBuffer byteBuffer = this.f1246b;
        try {
            return fVar.a(byteBuffer);
        } finally {
            a.c(byteBuffer);
        }
    }

    public final long j() {
        return ((long) this.f1246b.getInt()) & 4294967295L;
    }

    public final void k(int i10) {
        ByteBuffer byteBuffer = this.f1246b;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    public b0(int i10, byte[] bArr) {
        this.f1245a = 4;
        this.f1246b = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
    }

    public /* synthetic */ b0(ByteBuffer byteBuffer, int i10) {
        this.f1245a = i10;
        this.f1246b = byteBuffer;
    }
}
