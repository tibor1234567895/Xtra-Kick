package h2;

import d2.w0;
import d2.x0;
import g1.z;
import j1.a0;
import j1.b0;
import java.util.Collections;
import k0.k;

public final class a extends k {

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f6883e = {5512, 11025, 22050, 44100};

    /* renamed from: b  reason: collision with root package name */
    public boolean f6884b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6885c;

    /* renamed from: d  reason: collision with root package name */
    public int f6886d;

    public a(x0 x0Var) {
        super(x0Var);
    }

    public final boolean c(b0 b0Var) {
        String str;
        z zVar;
        int i10;
        if (!this.f6884b) {
            int v10 = b0Var.v();
            int i11 = (v10 >> 4) & 15;
            this.f6886d = i11;
            Object obj = this.f8956a;
            if (i11 == 2) {
                i10 = f6883e[(v10 >> 2) & 3];
                zVar = new z();
                zVar.f6754k = "audio/mpeg";
                zVar.f6767x = 1;
            } else if (i11 == 7 || i11 == 8) {
                if (i11 == 7) {
                    str = "audio/g711-alaw";
                } else {
                    str = "audio/g711-mlaw";
                }
                zVar = new z();
                zVar.f6754k = str;
                zVar.f6767x = 1;
                i10 = 8000;
            } else {
                if (i11 != 10) {
                    throw new d("Audio format not supported: " + this.f6886d);
                }
                this.f6884b = true;
            }
            zVar.f6768y = i10;
            ((x0) obj).a(zVar.a());
            this.f6885c = true;
            this.f6884b = true;
        } else {
            b0Var.H(1);
        }
        return true;
    }

    public final boolean d(long j10, b0 b0Var) {
        int i10;
        int i11 = this.f6886d;
        Object obj = this.f8956a;
        if (i11 == 2) {
            i10 = b0Var.f8416c;
        } else {
            int v10 = b0Var.v();
            if (v10 == 0 && !this.f6885c) {
                int i12 = b0Var.f8416c - b0Var.f8415b;
                byte[] bArr = new byte[i12];
                b0Var.d(bArr, 0, i12);
                j1.k b10 = d2.a.b(new a0(i12, bArr), false);
                z zVar = new z();
                zVar.f6754k = "audio/mp4a-latm";
                zVar.f6751h = b10.f8452c;
                zVar.f6767x = b10.f8451b;
                zVar.f6768y = b10.f8450a;
                zVar.f6756m = Collections.singletonList(bArr);
                ((x0) obj).a(new g1.a0(zVar));
                this.f6885c = true;
                return false;
            } else if (this.f6886d == 10 && v10 != 1) {
                return false;
            } else {
                i10 = b0Var.f8416c;
            }
        }
        int i13 = i10 - b0Var.f8415b;
        x0 x0Var = (x0) obj;
        x0Var.d(i13, b0Var);
        x0Var.e(j10, 1, i13, 0, (w0) null);
        return true;
    }
}
