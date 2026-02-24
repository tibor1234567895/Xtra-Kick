package cc;

import android.support.v4.media.h;
import dc.g;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f3123a = new j();

    private j() {
    }

    public static String a(int i10) {
        StringBuilder sb2;
        boolean z10;
        if (i10 < 1000 || i10 >= 5000) {
            StringBuilder sb3 = new StringBuilder("Code must be in range [1000,5000): ");
            sb3.append(i10);
            sb2 = sb3;
        } else {
            boolean z11 = false;
            if (1004 > i10 || i10 >= 1007) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (!z10) {
                if (1015 <= i10 && i10 < 3000) {
                    z11 = true;
                }
                if (!z11) {
                    return null;
                }
            }
            sb2 = h.r("Code ", i10, " is reserved and may not be used.");
        }
        return sb2.toString();
    }

    public static void b(g gVar, byte[] bArr) {
        long j10;
        xa.j.f("cursor", gVar);
        xa.j.f("key", bArr);
        int length = bArr.length;
        int i10 = 0;
        do {
            byte[] bArr2 = gVar.f4768l;
            int i11 = gVar.f4769m;
            int i12 = gVar.f4770n;
            boolean z10 = true;
            if (bArr2 != null) {
                while (i11 < i12) {
                    int i13 = i10 % length;
                    bArr2[i11] = (byte) (bArr2[i11] ^ bArr[i13]);
                    i11++;
                    i10 = i13 + 1;
                }
            }
            long j11 = gVar.f4767k;
            dc.j jVar = gVar.f4764h;
            xa.j.c(jVar);
            if (j11 == jVar.f4787i) {
                z10 = false;
            }
            if (z10) {
                long j12 = gVar.f4767k;
                if (j12 == -1) {
                    j10 = 0;
                } else {
                    j10 = j12 + ((long) (gVar.f4770n - gVar.f4769m));
                }
            } else {
                throw new IllegalStateException("no more bytes".toString());
            }
        } while (gVar.e(j10) != -1);
    }
}
