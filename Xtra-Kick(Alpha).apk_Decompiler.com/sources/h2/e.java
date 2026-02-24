package h2;

import android.support.v4.media.h;
import d2.p0;
import d2.w0;
import d2.x0;
import g1.a0;
import g1.z;
import j1.b0;
import k0.k;

public final class e extends k {

    /* renamed from: b  reason: collision with root package name */
    public final b0 f6906b = new b0(p0.f4278a);

    /* renamed from: c  reason: collision with root package name */
    public final b0 f6907c = new b0(4);

    /* renamed from: d  reason: collision with root package name */
    public int f6908d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6909e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6910f;

    /* renamed from: g  reason: collision with root package name */
    public int f6911g;

    public e(x0 x0Var) {
        super(x0Var);
    }

    public final boolean c(b0 b0Var) {
        int v10 = b0Var.v();
        int i10 = (v10 >> 4) & 15;
        int i11 = v10 & 15;
        if (i11 == 7) {
            this.f6911g = i10;
            if (i10 != 5) {
                return true;
            }
            return false;
        }
        throw new d(h.i("Video format not supported: ", i11));
    }

    public final boolean d(long j10, b0 b0Var) {
        int i10;
        int v10 = b0Var.v();
        byte[] bArr = b0Var.f8414a;
        int i11 = b0Var.f8415b;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        byte b10 = (((bArr[i11] & 255) << 24) >> 8) | ((bArr[i12] & 255) << 8);
        b0Var.f8415b = i13 + 1;
        long j11 = (((long) ((bArr[i13] & 255) | b10)) * 1000) + j10;
        Object obj = this.f8956a;
        if (v10 == 0 && !this.f6909e) {
            b0 b0Var2 = new b0(new byte[(b0Var.f8416c - b0Var.f8415b)]);
            b0Var.d(b0Var2.f8414a, 0, b0Var.f8416c - b0Var.f8415b);
            d2.e a10 = d2.e.a(b0Var2);
            this.f6908d = a10.f4158b;
            z zVar = new z();
            zVar.f6754k = "video/avc";
            zVar.f6751h = a10.f4162f;
            zVar.f6759p = a10.f4159c;
            zVar.f6760q = a10.f4160d;
            zVar.f6763t = a10.f4161e;
            zVar.f6756m = a10.f4157a;
            ((x0) obj).a(new a0(zVar));
            this.f6909e = true;
            return false;
        } else if (v10 != 1 || !this.f6909e) {
            return false;
        } else {
            if (this.f6911g == 1) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            if (!this.f6910f && i10 == 0) {
                return false;
            }
            b0 b0Var3 = this.f6907c;
            byte[] bArr2 = b0Var3.f8414a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i14 = 4 - this.f6908d;
            int i15 = 0;
            while (b0Var.f8416c - b0Var.f8415b > 0) {
                b0Var.d(b0Var3.f8414a, i14, this.f6908d);
                b0Var3.G(0);
                int y10 = b0Var3.y();
                b0 b0Var4 = this.f6906b;
                b0Var4.G(0);
                x0 x0Var = (x0) obj;
                x0Var.d(4, b0Var4);
                x0Var.d(y10, b0Var);
                i15 = i15 + 4 + y10;
            }
            ((x0) obj).e(j11, i10, i15, 0, (w0) null);
            this.f6910f = true;
            return true;
        }
    }
}
