package j1;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final int f8450a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8451b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8452c;

    public /* synthetic */ k(int i10, int i11, String str) {
        this.f8450a = i10;
        this.f8451b = i11;
        this.f8452c = str;
    }

    public static k a(b0 b0Var) {
        String str;
        b0Var.H(2);
        int v10 = b0Var.v();
        int i10 = v10 >> 1;
        int v11 = ((b0Var.v() >> 3) & 31) | ((v10 & 1) << 5);
        if (i10 == 4 || i10 == 5 || i10 == 7) {
            str = "dvhe";
        } else if (i10 == 8) {
            str = "hev1";
        } else if (i10 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        String str2 = ".0";
        sb2.append(str2);
        sb2.append(i10);
        if (v11 >= 10) {
            str2 = ".";
        }
        sb2.append(str2);
        sb2.append(v11);
        return new k(i10, v11, sb2.toString());
    }

    public k(String str, int i10, int i11) {
        this.f8452c = str;
        this.f8450a = i10;
        this.f8451b = i11;
    }
}
