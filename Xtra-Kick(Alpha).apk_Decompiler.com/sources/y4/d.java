package y4;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f16940a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f16941b;

    /* renamed from: c  reason: collision with root package name */
    public c f16942c;

    /* renamed from: d  reason: collision with root package name */
    public int f16943d = 0;

    public final boolean a() {
        return this.f16942c.f16930b != 0;
    }

    public final c b() {
        boolean z10;
        byte[] bArr;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this.f16941b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (a()) {
            return this.f16942c;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 6; i10++) {
                sb2.append((char) c());
            }
            if (!sb2.toString().startsWith("GIF")) {
                this.f16942c.f16930b = 1;
            } else {
                this.f16942c.f16934f = f();
                this.f16942c.f16935g = f();
                int c10 = c();
                c cVar = this.f16942c;
                if ((c10 & 128) != 0) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                cVar.f16936h = z13;
                cVar.f16937i = (int) Math.pow(2.0d, (double) ((c10 & 7) + 1));
                this.f16942c.f16938j = c();
                c cVar2 = this.f16942c;
                c();
                cVar2.getClass();
                if (this.f16942c.f16936h && !a()) {
                    c cVar3 = this.f16942c;
                    cVar3.f16929a = e(cVar3.f16937i);
                    c cVar4 = this.f16942c;
                    cVar4.f16939k = cVar4.f16929a[cVar4.f16938j];
                }
            }
            if (!a()) {
                boolean z14 = false;
                while (!z14 && !a() && this.f16942c.f16931c <= Integer.MAX_VALUE) {
                    int c11 = c();
                    if (c11 == 33) {
                        int c12 = c();
                        if (c12 != 1) {
                            if (c12 == 249) {
                                this.f16942c.f16932d = new b();
                                c();
                                int c13 = c();
                                b bVar = this.f16942c.f16932d;
                                int i11 = (c13 & 28) >> 2;
                                bVar.f16924g = i11;
                                if (i11 == 0) {
                                    bVar.f16924g = 1;
                                }
                                if ((c13 & 1) != 0) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                bVar.f16923f = z10;
                                int f10 = f();
                                if (f10 < 2) {
                                    f10 = 10;
                                }
                                b bVar2 = this.f16942c.f16932d;
                                bVar2.f16926i = f10 * 10;
                                bVar2.f16925h = c();
                                c();
                            } else if (c12 != 254 && c12 == 255) {
                                d();
                                StringBuilder sb3 = new StringBuilder();
                                int i12 = 0;
                                while (true) {
                                    bArr = this.f16940a;
                                    if (i12 >= 11) {
                                        break;
                                    }
                                    sb3.append((char) bArr[i12]);
                                    i12++;
                                }
                                if (sb3.toString().equals("NETSCAPE2.0")) {
                                    do {
                                        d();
                                        if (bArr[0] == 1) {
                                            byte b10 = bArr[1];
                                            byte b11 = bArr[2];
                                            this.f16942c.getClass();
                                        }
                                        if (this.f16943d <= 0) {
                                            break;
                                        }
                                    } while (a());
                                }
                            }
                        }
                        g();
                    } else if (c11 == 44) {
                        c cVar5 = this.f16942c;
                        if (cVar5.f16932d == null) {
                            cVar5.f16932d = new b();
                        }
                        this.f16942c.f16932d.f16918a = f();
                        this.f16942c.f16932d.f16919b = f();
                        this.f16942c.f16932d.f16920c = f();
                        this.f16942c.f16932d.f16921d = f();
                        int c14 = c();
                        if ((c14 & 128) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        int pow = (int) Math.pow(2.0d, (double) ((c14 & 7) + 1));
                        b bVar3 = this.f16942c.f16932d;
                        if ((c14 & 64) != 0) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        bVar3.f16922e = z12;
                        if (z11) {
                            bVar3.f16928k = e(pow);
                        } else {
                            bVar3.f16928k = null;
                        }
                        this.f16942c.f16932d.f16927j = this.f16941b.position();
                        c();
                        g();
                        if (!a()) {
                            c cVar6 = this.f16942c;
                            cVar6.f16931c++;
                            cVar6.f16933e.add(cVar6.f16932d);
                        }
                    } else if (c11 != 59) {
                        this.f16942c.f16930b = 1;
                    } else {
                        z14 = true;
                    }
                }
                c cVar7 = this.f16942c;
                if (cVar7.f16931c < 0) {
                    cVar7.f16930b = 1;
                }
            }
            return this.f16942c;
        }
    }

    public final int c() {
        try {
            return this.f16941b.get() & 255;
        } catch (Exception unused) {
            this.f16942c.f16930b = 1;
            return 0;
        }
    }

    public final void d() {
        int c10 = c();
        this.f16943d = c10;
        if (c10 > 0) {
            int i10 = 0;
            while (true) {
                try {
                    int i11 = this.f16943d;
                    if (i10 < i11) {
                        int i12 = i11 - i10;
                        this.f16941b.get(this.f16940a, i10, i12);
                        i10 += i12;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    Log.isLoggable("GifHeaderParser", 3);
                    this.f16942c.f16930b = 1;
                    return;
                }
            }
        }
    }

    public final int[] e(int i10) {
        byte[] bArr = new byte[(i10 * 3)];
        int[] iArr = null;
        try {
            this.f16941b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << 16) | -16777216 | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f16942c.f16930b = 1;
        }
        return iArr;
    }

    public final int f() {
        return this.f16941b.getShort();
    }

    public final void g() {
        int c10;
        do {
            c10 = c();
            this.f16941b.position(Math.min(this.f16941b.position() + c10, this.f16941b.limit()));
        } while (c10 > 0);
    }
}
