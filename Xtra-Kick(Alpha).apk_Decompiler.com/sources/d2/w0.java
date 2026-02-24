package d2;

import java.util.Arrays;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f4303a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4304b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4305c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4306d;

    public w0(int i10, int i11, int i12, byte[] bArr) {
        this.f4303a = i10;
        this.f4304b = bArr;
        this.f4305c = i11;
        this.f4306d = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w0.class != obj.getClass()) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f4303a == w0Var.f4303a && this.f4305c == w0Var.f4305c && this.f4306d == w0Var.f4306d && Arrays.equals(this.f4304b, w0Var.f4304b);
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f4304b) + (this.f4303a * 31)) * 31) + this.f4305c) * 31) + this.f4306d;
    }
}
