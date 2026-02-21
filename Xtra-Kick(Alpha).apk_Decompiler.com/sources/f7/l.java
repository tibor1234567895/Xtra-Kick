package f7;

import y5.r;
import y5.u;

public final class l {
    private l() {
    }

    public /* synthetic */ l(int i10) {
        this();
    }

    public static r a(l lVar, int i10, String str, boolean z10, int i11) {
        int i12;
        boolean z11;
        if ((i11 & 1) != 0) {
            i12 = 0;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        String str2 = str;
        if ((i11 & 16) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        lVar.getClass();
        u.f17067a.getClass();
        return new r(i12, str2, (String) null, (String) null, z11);
    }
}
