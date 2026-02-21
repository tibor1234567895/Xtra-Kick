package v1;

import a2.a;
import a2.e;
import android.media.MediaCodec;
import j1.b0;
import j1.l0;
import java.nio.ByteBuffer;
import java.util.Arrays;
import l1.c;
import l1.d;
import l1.h;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final e f15825a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15826b;

    /* renamed from: c  reason: collision with root package name */
    public final b0 f15827c = new b0(32);

    /* renamed from: d  reason: collision with root package name */
    public v0 f15828d;

    /* renamed from: e  reason: collision with root package name */
    public v0 f15829e;

    /* renamed from: f  reason: collision with root package name */
    public v0 f15830f;

    /* renamed from: g  reason: collision with root package name */
    public long f15831g;

    public w0(e eVar) {
        this.f15825a = eVar;
        int i10 = eVar.f23b;
        this.f15826b = i10;
        v0 v0Var = new v0(i10, 0);
        this.f15828d = v0Var;
        this.f15829e = v0Var;
        this.f15830f = v0Var;
    }

    public static v0 d(v0 v0Var, long j10, ByteBuffer byteBuffer, int i10) {
        while (j10 >= v0Var.f15815b) {
            v0Var = v0Var.f15817d;
        }
        while (i10 > 0) {
            int min = Math.min(i10, (int) (v0Var.f15815b - j10));
            a aVar = v0Var.f15816c;
            byteBuffer.put(aVar.f16a, ((int) (j10 - v0Var.f15814a)) + aVar.f17b, min);
            i10 -= min;
            j10 += (long) min;
            if (j10 == v0Var.f15815b) {
                v0Var = v0Var.f15817d;
            }
        }
        return v0Var;
    }

    public static v0 e(v0 v0Var, long j10, byte[] bArr, int i10) {
        while (j10 >= v0Var.f15815b) {
            v0Var = v0Var.f15817d;
        }
        int i11 = i10;
        while (i11 > 0) {
            int min = Math.min(i11, (int) (v0Var.f15815b - j10));
            a aVar = v0Var.f15816c;
            System.arraycopy(aVar.f16a, ((int) (j10 - v0Var.f15814a)) + aVar.f17b, bArr, i10 - i11, min);
            i11 -= min;
            j10 += (long) min;
            if (j10 == v0Var.f15815b) {
                v0Var = v0Var.f15817d;
            }
        }
        return v0Var;
    }

    public static v0 f(v0 v0Var, h hVar, x0 x0Var, b0 b0Var) {
        ByteBuffer byteBuffer;
        long j10;
        boolean z10;
        if (hVar.f(1073741824)) {
            long j11 = x0Var.f15833b;
            int i10 = 1;
            b0Var.D(1);
            v0 e10 = e(v0Var, j11, b0Var.f8414a, 1);
            long j12 = j11 + 1;
            byte b10 = b0Var.f8414a[0];
            if ((b10 & 128) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            byte b11 = b10 & Byte.MAX_VALUE;
            d dVar = hVar.f9514i;
            byte[] bArr = dVar.f9504a;
            if (bArr == null) {
                dVar.f9504a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            v0Var = e(e10, j12, dVar.f9504a, b11);
            long j13 = j12 + ((long) b11);
            if (z10) {
                b0Var.D(2);
                v0Var = e(v0Var, j13, b0Var.f8414a, 2);
                j13 += 2;
                i10 = b0Var.A();
            }
            int[] iArr = dVar.f9507d;
            if (iArr == null || iArr.length < i10) {
                iArr = new int[i10];
            }
            int[] iArr2 = dVar.f9508e;
            if (iArr2 == null || iArr2.length < i10) {
                iArr2 = new int[i10];
            }
            if (z10) {
                int i11 = i10 * 6;
                b0Var.D(i11);
                v0Var = e(v0Var, j13, b0Var.f8414a, i11);
                j13 += (long) i11;
                b0Var.G(0);
                for (int i12 = 0; i12 < i10; i12++) {
                    iArr[i12] = b0Var.A();
                    iArr2[i12] = b0Var.y();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = x0Var.f15832a - ((int) (j13 - x0Var.f15833b));
            }
            d2.w0 w0Var = x0Var.f15834c;
            int i13 = l0.f8453a;
            byte[] bArr2 = w0Var.f4304b;
            byte[] bArr3 = dVar.f9504a;
            dVar.f9509f = i10;
            dVar.f9507d = iArr;
            dVar.f9508e = iArr2;
            dVar.f9505b = bArr2;
            dVar.f9504a = bArr3;
            int i14 = w0Var.f4303a;
            dVar.f9506c = i14;
            int i15 = w0Var.f4305c;
            dVar.f9510g = i15;
            int i16 = w0Var.f4306d;
            dVar.f9511h = i16;
            MediaCodec.CryptoInfo cryptoInfo = dVar.f9512i;
            cryptoInfo.numSubSamples = i10;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i14;
            if (l0.f8453a >= 24) {
                c cVar = dVar.f9513j;
                cVar.getClass();
                MediaCodec.CryptoInfo.Pattern pattern = cVar.f9503b;
                pattern.set(i15, i16);
                cVar.f9502a.setPattern(pattern);
            }
            long j14 = x0Var.f15833b;
            int i17 = (int) (j13 - j14);
            x0Var.f15833b = j14 + ((long) i17);
            x0Var.f15832a -= i17;
        }
        if (hVar.f(268435456)) {
            b0Var.D(4);
            v0 e11 = e(v0Var, x0Var.f15833b, b0Var.f8414a, 4);
            int y10 = b0Var.y();
            x0Var.f15833b += 4;
            x0Var.f15832a -= 4;
            hVar.j(y10);
            v0Var = d(e11, x0Var.f15833b, hVar.f9515j, y10);
            x0Var.f15833b += (long) y10;
            int i18 = x0Var.f15832a - y10;
            x0Var.f15832a = i18;
            ByteBuffer byteBuffer2 = hVar.f9518m;
            if (byteBuffer2 == null || byteBuffer2.capacity() < i18) {
                hVar.f9518m = ByteBuffer.allocate(i18);
            } else {
                hVar.f9518m.clear();
            }
            j10 = x0Var.f15833b;
            byteBuffer = hVar.f9518m;
        } else {
            hVar.j(x0Var.f15832a);
            j10 = x0Var.f15833b;
            byteBuffer = hVar.f9515j;
        }
        return d(v0Var, j10, byteBuffer, x0Var.f15832a);
    }

    public final void a(v0 v0Var) {
        if (v0Var.f15816c != null) {
            e eVar = this.f15825a;
            synchronized (eVar) {
                v0 v0Var2 = v0Var;
                while (v0Var2 != null) {
                    a[] aVarArr = eVar.f27f;
                    int i10 = eVar.f26e;
                    eVar.f26e = i10 + 1;
                    a aVar = v0Var2.f15816c;
                    aVar.getClass();
                    aVarArr[i10] = aVar;
                    eVar.f25d--;
                    v0Var2 = v0Var2.f15817d;
                    if (v0Var2 == null || v0Var2.f15816c == null) {
                        v0Var2 = null;
                    }
                }
                eVar.notifyAll();
            }
            v0Var.f15816c = null;
            v0Var.f15817d = null;
        }
    }

    public final void b(long j10) {
        if (j10 != -1) {
            while (true) {
                v0 v0Var = this.f15828d;
                if (j10 >= v0Var.f15815b) {
                    e eVar = this.f15825a;
                    a aVar = v0Var.f15816c;
                    synchronized (eVar) {
                        a[] aVarArr = eVar.f27f;
                        int i10 = eVar.f26e;
                        eVar.f26e = i10 + 1;
                        aVarArr[i10] = aVar;
                        eVar.f25d--;
                        eVar.notifyAll();
                    }
                    v0 v0Var2 = this.f15828d;
                    v0Var2.f15816c = null;
                    v0 v0Var3 = v0Var2.f15817d;
                    v0Var2.f15817d = null;
                    this.f15828d = v0Var3;
                } else if (this.f15829e.f15814a < v0Var.f15814a) {
                    this.f15829e = v0Var;
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public final int c(int i10) {
        a aVar;
        v0 v0Var = this.f15830f;
        if (v0Var.f15816c == null) {
            e eVar = this.f15825a;
            synchronized (eVar) {
                int i11 = eVar.f25d + 1;
                eVar.f25d = i11;
                int i12 = eVar.f26e;
                if (i12 > 0) {
                    a[] aVarArr = eVar.f27f;
                    int i13 = i12 - 1;
                    eVar.f26e = i13;
                    aVar = aVarArr[i13];
                    aVar.getClass();
                    eVar.f27f[eVar.f26e] = null;
                } else {
                    a aVar2 = new a(0, new byte[eVar.f23b]);
                    a[] aVarArr2 = eVar.f27f;
                    if (i11 > aVarArr2.length) {
                        eVar.f27f = (a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                    }
                    aVar = aVar2;
                }
            }
            v0 v0Var2 = new v0(this.f15826b, this.f15830f.f15815b);
            v0Var.f15816c = aVar;
            v0Var.f15817d = v0Var2;
        }
        return Math.min(i10, (int) (this.f15830f.f15815b - this.f15831g));
    }
}
