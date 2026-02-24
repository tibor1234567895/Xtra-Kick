package wb;

import dc.m;
import dc.n;
import fb.w;
import qb.h;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f16255a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final n f16256b = m.b("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f16257c = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f16258d = new String[64];

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f16259e;

    static {
        n.f4802k.getClass();
        String[] strArr = new String[256];
        for (int i10 = 0; i10 < 256; i10++) {
            String binaryString = Integer.toBinaryString(i10);
            j.e("toBinaryString(it)", binaryString);
            strArr[i10] = w.j(h.e("%8s", binaryString), ' ', '0');
        }
        f16259e = strArr;
        String[] strArr2 = f16258d;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[9] = android.support.v4.media.h.p(new StringBuilder(), strArr2[1], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f16258d;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strArr3[i13]);
            sb2.append('|');
            strArr3[i14 | 8] = android.support.v4.media.h.p(sb2, strArr3[i12], "|PADDED");
        }
        int length = f16258d.length;
        for (int i15 = 0; i15 < length; i15++) {
            String[] strArr4 = f16258d;
            if (strArr4[i15] == null) {
                strArr4[i15] = f16259e[i15];
            }
        }
    }

    private i() {
    }

    public static String a(int i10) {
        String[] strArr = f16257c;
        if (i10 < strArr.length) {
            return strArr[i10];
        }
        return h.e("0x%02x", Integer.valueOf(i10));
    }

    public static String b(int i10, int i11, int i12, int i13, boolean z10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String a10 = a(i12);
        if (i13 == 0) {
            str = "";
        } else {
            String[] strArr = f16259e;
            if (!(i12 == 2 || i12 == 3)) {
                if (i12 == 4 || i12 == 6) {
                    if (i13 == 1) {
                        str = "ACK";
                    } else {
                        str = strArr[i13];
                    }
                } else if (!(i12 == 7 || i12 == 8)) {
                    String[] strArr2 = f16258d;
                    if (i13 < strArr2.length) {
                        str3 = strArr2[i13];
                        j.c(str3);
                    } else {
                        str3 = strArr[i13];
                    }
                    if (i12 == 5 && (i13 & 4) != 0) {
                        str5 = "HEADERS";
                        str4 = "PUSH_PROMISE";
                    } else if (i12 != 0 || (i13 & 32) == 0) {
                        str = str3;
                    } else {
                        str5 = "PRIORITY";
                        str4 = "COMPRESSED";
                    }
                    str = w.k(str3, str5, str4);
                }
            }
            str = strArr[i13];
        }
        if (z10) {
            str2 = "<<";
        } else {
            str2 = ">>";
        }
        return h.e("%s 0x%08x %5d %-13s %s", str2, Integer.valueOf(i10), Integer.valueOf(i11), a10, str);
    }

    public static String c(long j10, int i10, int i11, boolean z10) {
        return h.e("%s 0x%08x %5d %-13s %d", z10 ? "<<" : ">>", Integer.valueOf(i10), Integer.valueOf(i11), a(8), Long.valueOf(j10));
    }
}
