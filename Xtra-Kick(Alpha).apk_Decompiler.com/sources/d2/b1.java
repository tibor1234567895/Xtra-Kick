package d2;

import android.util.Base64;
import d0.d;
import g1.z0;
import j1.b0;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.List;
import m2.b;

public final class b1 {
    private b1() {
    }

    public static z0 a(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            String str = (String) list.get(i10);
            int i11 = l0.f8453a;
            String[] split = str.split(Constants.ATTRIBUTE_SEPARATOR, 2);
            if (split.length != 2) {
                v.g("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(b.u(new b0(Base64.decode(split[1], 0))));
                } catch (RuntimeException e10) {
                    v.h("VorbisUtil", "Failed to parse vorbis picture", e10);
                }
            } else {
                arrayList.add(new r2.b(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new z0((List) arrayList);
    }

    public static d b(b0 b0Var, boolean z10, boolean z11) {
        if (z10) {
            c(3, b0Var, false);
        }
        String s10 = b0Var.s((int) b0Var.l());
        long l10 = b0Var.l();
        String[] strArr = new String[((int) l10)];
        int length = s10.length() + 11 + 4;
        for (int i10 = 0; ((long) i10) < l10; i10++) {
            String s11 = b0Var.s((int) b0Var.l());
            strArr[i10] = s11;
            length = length + 4 + s11.length();
        }
        if (!z11 || (b0Var.v() & 1) != 0) {
            return new d((Object) s10, length + 1, (Object) strArr);
        }
        throw g1.b1.a("framing bit expected to be set", (Exception) null);
    }

    public static boolean c(int i10, b0 b0Var, boolean z10) {
        if (b0Var.f8416c - b0Var.f8415b < 7) {
            if (z10) {
                return false;
            }
            throw g1.b1.a("too short header: " + (b0Var.f8416c - b0Var.f8415b), (Exception) null);
        } else if (b0Var.v() != i10) {
            if (z10) {
                return false;
            }
            throw g1.b1.a("expected header type " + Integer.toHexString(i10), (Exception) null);
        } else if (b0Var.v() == 118 && b0Var.v() == 111 && b0Var.v() == 114 && b0Var.v() == 98 && b0Var.v() == 105 && b0Var.v() == 115) {
            return true;
        } else {
            if (z10) {
                return false;
            }
            throw g1.b1.a("expected characters 'vorbis'", (Exception) null);
        }
    }
}
