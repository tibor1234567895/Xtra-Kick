package vb;

import dc.l;
import fb.y;
import hb.h0;
import pb.n0;
import pb.p0;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final l f15987a;

    /* renamed from: b  reason: collision with root package name */
    public long f15988b = 262144;

    static {
        new a(0);
    }

    public b(l lVar) {
        this.f15987a = lVar;
    }

    public final p0 a() {
        boolean z10;
        n0 n0Var = new n0();
        while (true) {
            String e02 = this.f15987a.e0(this.f15988b);
            this.f15988b -= (long) e02.length();
            if (e02.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                return n0Var.b();
            }
            int t10 = y.t(e02, ':', 1, false, 4);
            if (t10 != -1) {
                String substring = e02.substring(0, t10);
                j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
                String substring2 = e02.substring(t10 + 1);
                j.e("this as java.lang.String).substring(startIndex)", substring2);
                h0.C(n0Var, substring, substring2);
            } else {
                if (e02.charAt(0) == ':') {
                    e02 = e02.substring(1);
                    j.e("this as java.lang.String).substring(startIndex)", e02);
                }
                h0.C(n0Var, "", e02);
            }
        }
    }
}
