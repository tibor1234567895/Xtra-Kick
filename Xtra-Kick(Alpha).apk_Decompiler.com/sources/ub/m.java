package ub;

import fb.v;
import fb.w;
import java.net.ProtocolException;
import pb.h1;
import xa.j;

public final class m {
    private m() {
    }

    public /* synthetic */ m(int i10) {
        this();
    }

    public static n a(String str) {
        int i10;
        h1 h1Var;
        String str2;
        j.f("statusLine", str);
        if (w.m(str, "HTTP/1.", false)) {
            i10 = 9;
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                h1Var = h1.HTTP_1_0;
            } else if (charAt == 1) {
                h1Var = h1.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: ".concat(str));
            }
        } else if (w.m(str, "ICY ", false)) {
            h1Var = h1.HTTP_1_0;
            i10 = 4;
        } else if (w.m(str, "SOURCETABLE ", false)) {
            h1Var = h1.HTTP_1_1;
            i10 = 12;
        } else {
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        int i11 = i10 + 3;
        if (str.length() >= i11) {
            String substring = str.substring(i10, i11);
            j.e("this as java.lang.String…ing(startIndex, endIndex)", substring);
            Integer d10 = v.d(substring);
            if (d10 != null) {
                int intValue = d10.intValue();
                if (str.length() <= i11) {
                    str2 = "";
                } else if (str.charAt(i11) == ' ') {
                    str2 = str.substring(i10 + 4);
                    j.e("this as java.lang.String).substring(startIndex)", str2);
                } else {
                    throw new ProtocolException("Unexpected status line: ".concat(str));
                }
                return new n(h1Var, intValue, str2);
            }
            throw new ProtocolException("Unexpected status line: ".concat(str));
        }
        throw new ProtocolException("Unexpected status line: ".concat(str));
    }
}
