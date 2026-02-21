package e3;

import j1.b0;
import java.util.regex.Pattern;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f4987c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f4988d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a  reason: collision with root package name */
    public final b0 f4989a = new b0();

    /* renamed from: b  reason: collision with root package name */
    public final StringBuilder f4990b = new StringBuilder();

    public static String a(b0 b0Var, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int i10 = b0Var.f8415b;
        int i11 = b0Var.f8416c;
        while (i10 < i11 && !z10) {
            char c10 = (char) b0Var.f8414a[i10];
            if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_'))) {
                z10 = true;
            } else {
                i10++;
                sb2.append(c10);
            }
        }
        b0Var.H(i10 - b0Var.f8415b);
        return sb2.toString();
    }

    public static String b(b0 b0Var, StringBuilder sb2) {
        c(b0Var);
        if (b0Var.f8416c - b0Var.f8415b == 0) {
            return null;
        }
        String a10 = a(b0Var, sb2);
        if (!"".equals(a10)) {
            return a10;
        }
        return "" + ((char) b0Var.v());
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A[LOOP:1: B:2:0x0002->B:35:0x0067, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0001 A[EDGE_INSN: B:40:0x0001->B:36:0x0001 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(j1.b0 r8) {
        /*
            r0 = 1
        L_0x0001:
            r1 = 1
        L_0x0002:
            int r2 = r8.f8416c
            int r3 = r8.f8415b
            int r2 = r2 - r3
            if (r2 <= 0) goto L_0x0069
            if (r1 == 0) goto L_0x0069
            byte[] r1 = r8.f8414a
            byte r1 = r1[r3]
            char r1 = (char) r1
            r2 = 9
            r3 = 0
            if (r1 == r2) goto L_0x0027
            r2 = 10
            if (r1 == r2) goto L_0x0027
            r2 = 12
            if (r1 == r2) goto L_0x0027
            r2 = 13
            if (r1 == r2) goto L_0x0027
            r2 = 32
            if (r1 == r2) goto L_0x0027
            r1 = 0
            goto L_0x002b
        L_0x0027:
            r8.H(r0)
            r1 = 1
        L_0x002b:
            if (r1 != 0) goto L_0x0001
            int r1 = r8.f8415b
            int r2 = r8.f8416c
            byte[] r4 = r8.f8414a
            int r5 = r1 + 2
            if (r5 > r2) goto L_0x0063
            int r5 = r1 + 1
            byte r1 = r4[r1]
            r6 = 47
            if (r1 != r6) goto L_0x0063
            int r1 = r5 + 1
            byte r5 = r4[r5]
            r7 = 42
            if (r5 != r7) goto L_0x0063
        L_0x0047:
            int r5 = r1 + 1
            if (r5 >= r2) goto L_0x005b
            byte r1 = r4[r1]
            char r1 = (char) r1
            if (r1 != r7) goto L_0x0059
            byte r1 = r4[r5]
            char r1 = (char) r1
            if (r1 != r6) goto L_0x0059
            int r2 = r5 + 1
            r1 = r2
            goto L_0x0047
        L_0x0059:
            r1 = r5
            goto L_0x0047
        L_0x005b:
            int r1 = r8.f8415b
            int r2 = r2 - r1
            r8.H(r2)
            r1 = 1
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            if (r1 == 0) goto L_0x0067
            goto L_0x0001
        L_0x0067:
            r1 = 0
            goto L_0x0002
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.b.c(j1.b0):void");
    }
}
