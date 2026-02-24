package s2;

import d2.w;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static final long[] f14158d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f14159a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    public int f14160b;

    /* renamed from: c  reason: collision with root package name */
    public int f14161c;

    public static long a(byte[] bArr, int i10, boolean z10) {
        long j10 = ((long) bArr[0]) & 255;
        if (z10) {
            j10 &= ~f14158d[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (((long) bArr[i11]) & 255);
        }
        return j10;
    }

    public final long b(w wVar, boolean z10, boolean z11, int i10) {
        int i11 = this.f14160b;
        byte[] bArr = this.f14159a;
        if (i11 == 0) {
            if (!wVar.b(bArr, 0, 1, z10)) {
                return -1;
            }
            byte b10 = bArr[0] & 255;
            int i12 = 0;
            while (true) {
                if (i12 >= 8) {
                    i12 = -1;
                    break;
                }
                int i13 = ((f14158d[i12] & ((long) b10)) > 0 ? 1 : ((f14158d[i12] & ((long) b10)) == 0 ? 0 : -1));
                i12++;
                if (i13 != 0) {
                    break;
                }
            }
            this.f14161c = i12;
            if (i12 != -1) {
                this.f14160b = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i14 = this.f14161c;
        if (i14 > i10) {
            this.f14160b = 0;
            return -2;
        }
        if (i14 != 1) {
            wVar.readFully(bArr, 1, i14 - 1);
        }
        this.f14160b = 0;
        return a(bArr, this.f14161c, z11);
    }
}
