package q6;

import y5.q;
import y5.u;

public final class g {
    private g() {
    }

    public /* synthetic */ g(int i10) {
        this();
    }

    public static q a(g gVar, int i10, String str, String str2, String str3, String[] strArr, boolean z10, int i11) {
        int i12;
        String str4;
        String str5;
        String str6;
        String[] strArr2;
        boolean z11;
        if ((i11 & 1) != 0) {
            i12 = 0;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i11 & 4) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i11 & 8) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i11 & 16) != 0) {
            strArr2 = null;
        } else {
            strArr2 = strArr;
        }
        if ((i11 & 32) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        gVar.getClass();
        u.f17067a.getClass();
        return new q(i12, str4, str5, str6, strArr2, z11, 0, (String) null);
    }
}
