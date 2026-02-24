package f3;

import java.util.Arrays;

public final class n {

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f5656f = {0, 0, 1};

    /* renamed from: a  reason: collision with root package name */
    public boolean f5657a;

    /* renamed from: b  reason: collision with root package name */
    public int f5658b;

    /* renamed from: c  reason: collision with root package name */
    public int f5659c;

    /* renamed from: d  reason: collision with root package name */
    public int f5660d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f5661e = new byte[128];

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f5657a) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f5661e;
            int length = bArr2.length;
            int i13 = this.f5659c;
            if (length < i13 + i12) {
                this.f5661e = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.f5661e, this.f5659c, i12);
            this.f5659c += i12;
        }
    }
}
