package d2;

import android.support.v4.media.n;
import g1.a0;
import g1.y0;
import g1.z;
import g1.z0;
import j1.l0;
import java.util.Arrays;
import java.util.Collections;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4173a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4174b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4175c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4176d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4177e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4178f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4179g;

    /* renamed from: h  reason: collision with root package name */
    public final int f4180h;

    /* renamed from: i  reason: collision with root package name */
    public final int f4181i;

    /* renamed from: j  reason: collision with root package name */
    public final long f4182j;

    /* renamed from: k  reason: collision with root package name */
    public final n f4183k;

    /* renamed from: l  reason: collision with root package name */
    public final z0 f4184l;

    public f0(int i10, int i11, int i12, int i13, int i14, int i15, int i16, long j10, n nVar, z0 z0Var) {
        this.f4173a = i10;
        this.f4174b = i11;
        this.f4175c = i12;
        this.f4176d = i13;
        this.f4177e = i14;
        this.f4178f = d(i14);
        this.f4179g = i15;
        this.f4180h = i16;
        this.f4181i = a(i16);
        this.f4182j = j10;
        this.f4183k = nVar;
        this.f4184l = z0Var;
    }

    public static int a(int i10) {
        if (i10 == 8) {
            return 1;
        }
        if (i10 == 12) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 != 20) {
            return i10 != 24 ? -1 : 6;
        }
        return 5;
    }

    public static int d(int i10) {
        switch (i10) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public final long b() {
        long j10 = this.f4182j;
        if (j10 == 0) {
            return -9223372036854775807L;
        }
        return (j10 * 1000000) / ((long) this.f4177e);
    }

    public final a0 c(byte[] bArr, z0 z0Var) {
        bArr[4] = Byte.MIN_VALUE;
        int i10 = this.f4176d;
        if (i10 <= 0) {
            i10 = -1;
        }
        z0 z0Var2 = this.f4184l;
        if (z0Var2 != null) {
            if (z0Var != null) {
                y0[] y0VarArr = z0Var.f6770h;
                if (y0VarArr.length != 0) {
                    int i11 = l0.f8453a;
                    y0[] y0VarArr2 = z0Var2.f6770h;
                    Object[] copyOf = Arrays.copyOf(y0VarArr2, y0VarArr2.length + y0VarArr.length);
                    System.arraycopy(y0VarArr, 0, copyOf, y0VarArr2.length, y0VarArr.length);
                    z0Var = new z0(z0Var2.f6771i, (y0[]) copyOf);
                }
            }
            z0Var = z0Var2;
        }
        z zVar = new z();
        zVar.f6754k = "audio/flac";
        zVar.f6755l = i10;
        zVar.f6767x = this.f4179g;
        zVar.f6768y = this.f4177e;
        zVar.f6756m = Collections.singletonList(bArr);
        zVar.f6752i = z0Var;
        return new a0(zVar);
    }

    public f0(int i10, byte[] bArr) {
        j1.a0 a0Var = new j1.a0(bArr.length, bArr);
        a0Var.k(i10 * 8);
        this.f4173a = a0Var.g(16);
        this.f4174b = a0Var.g(16);
        this.f4175c = a0Var.g(24);
        this.f4176d = a0Var.g(24);
        int g10 = a0Var.g(20);
        this.f4177e = g10;
        this.f4178f = d(g10);
        this.f4179g = a0Var.g(3) + 1;
        int g11 = a0Var.g(5) + 1;
        this.f4180h = g11;
        this.f4181i = a(g11);
        int g12 = a0Var.g(4);
        int g13 = a0Var.g(32);
        int i11 = l0.f8453a;
        this.f4182j = ((((long) g12) & 4294967295L) << 32) | (((long) g13) & 4294967295L);
        this.f4183k = null;
        this.f4184l = null;
    }
}
