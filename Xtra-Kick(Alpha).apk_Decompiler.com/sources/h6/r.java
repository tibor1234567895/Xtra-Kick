package h6;

import y5.o;
import y5.u;

public final class r {
    private r() {
    }

    public /* synthetic */ r(int i10) {
        this();
    }

    public static o a(r rVar, int i10, String str, String str2, String str3, boolean z10, int i11, int i12) {
        String str4;
        String str5;
        boolean z11;
        int i13;
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        String str6 = null;
        if ((i12 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i12 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i12 & 8) == 0) {
            str6 = str3;
        }
        if ((i12 & 16) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i12 & 32) != 0) {
            i13 = 0;
        } else {
            i13 = i11;
        }
        rVar.getClass();
        u.f17067a.getClass();
        return new o(i10, i13, str4, str5, str6, z11);
    }
}
