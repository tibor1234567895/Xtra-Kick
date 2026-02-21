package f3;

import java.util.Arrays;

public final class l {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f5632e = {0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    public boolean f5633a;

    /* renamed from: b  reason: collision with root package name */
    public int f5634b;

    /* renamed from: c  reason: collision with root package name */
    public int f5635c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5636d = new byte[128];

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f5633a) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f5636d;
            int length = bArr2.length;
            int i13 = this.f5634b;
            if (length < i13 + i12) {
                this.f5636d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f5636d, this.f5634b, i12);
            this.f5634b += i12;
        }
    }
}
