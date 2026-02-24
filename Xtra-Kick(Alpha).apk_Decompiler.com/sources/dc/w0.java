package dc;

import xa.j;

public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final g f4841a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final int f4842b = -1234567890;

    public static final boolean a(int i10, int i11, int i12, byte[] bArr, byte[] bArr2) {
        j.f("a", bArr);
        j.f("b", bArr2);
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c(int i10, n nVar) {
        j.f("<this>", nVar);
        if (i10 == f4842b) {
            return nVar.d();
        }
        return i10;
    }
}
