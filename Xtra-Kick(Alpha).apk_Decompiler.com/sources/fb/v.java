package fb;

public class v extends u {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r3 == '+') goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Integer d(java.lang.String r10) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r10)
            r0 = 10
            fb.a.a(r0)
            int r1 = r10.length()
            if (r1 != 0) goto L_0x0011
            goto L_0x0056
        L_0x0011:
            r2 = 0
            char r3 = r10.charAt(r2)
            r4 = 48
            int r4 = xa.j.h(r3, r4)
            if (r4 >= 0) goto L_0x002f
            r4 = 1
            if (r1 != r4) goto L_0x0022
            goto L_0x0056
        L_0x0022:
            r5 = 45
            if (r3 != r5) goto L_0x002a
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 1
            goto L_0x0034
        L_0x002a:
            r5 = 43
            if (r3 != r5) goto L_0x0056
            goto L_0x0030
        L_0x002f:
            r4 = 0
        L_0x0030:
            r3 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            r5 = 0
        L_0x0034:
            r6 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
            r7 = -59652323(0xfffffffffc71c71d, float:-5.0215282E36)
        L_0x003a:
            if (r4 >= r1) goto L_0x005c
            char r8 = r10.charAt(r4)
            int r8 = java.lang.Character.digit(r8, r0)
            if (r8 >= 0) goto L_0x0047
            goto L_0x0056
        L_0x0047:
            if (r2 >= r7) goto L_0x0050
            if (r7 != r6) goto L_0x0056
            int r7 = r3 / 10
            if (r2 >= r7) goto L_0x0050
            goto L_0x0056
        L_0x0050:
            int r2 = r2 * 10
            int r9 = r3 + r8
            if (r2 >= r9) goto L_0x0058
        L_0x0056:
            r10 = 0
            goto L_0x0068
        L_0x0058:
            int r2 = r2 - r8
            int r4 = r4 + 1
            goto L_0x003a
        L_0x005c:
            if (r5 == 0) goto L_0x0063
            java.lang.Integer r10 = java.lang.Integer.valueOf(r2)
            goto L_0x0068
        L_0x0063:
            int r10 = -r2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
        L_0x0068:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.v.d(java.lang.String):java.lang.Integer");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r4 == '+') goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long e(java.lang.String r18) {
        /*
            r0 = r18
            r1 = 10
            fb.a.a(r1)
            int r2 = r18.length()
            if (r2 != 0) goto L_0x000e
            goto L_0x0062
        L_0x000e:
            r3 = 0
            char r4 = r0.charAt(r3)
            r5 = 48
            int r5 = xa.j.h(r4, r5)
            if (r5 >= 0) goto L_0x002d
            r5 = 1
            if (r2 != r5) goto L_0x001f
            goto L_0x0062
        L_0x001f:
            r6 = 45
            if (r4 != r6) goto L_0x0028
            r3 = -9223372036854775808
            r6 = r3
            r3 = 1
            goto L_0x0033
        L_0x0028:
            r6 = 43
            if (r4 != r6) goto L_0x0062
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0033:
            r8 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r10 = 0
            r12 = r8
        L_0x003b:
            if (r5 >= r2) goto L_0x0068
            char r4 = r0.charAt(r5)
            int r4 = java.lang.Character.digit(r4, r1)
            if (r4 >= 0) goto L_0x0048
            goto L_0x0062
        L_0x0048:
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0058
            int r14 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r14 != 0) goto L_0x0062
            long r12 = (long) r1
            long r12 = r6 / r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0058
            goto L_0x0062
        L_0x0058:
            long r14 = (long) r1
            long r10 = r10 * r14
            long r14 = (long) r4
            long r16 = r6 + r14
            int r4 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r4 >= 0) goto L_0x0064
        L_0x0062:
            r0 = 0
            goto L_0x0074
        L_0x0064:
            long r10 = r10 - r14
            int r5 = r5 + 1
            goto L_0x003b
        L_0x0068:
            if (r3 == 0) goto L_0x006f
            java.lang.Long r0 = java.lang.Long.valueOf(r10)
            goto L_0x0074
        L_0x006f:
            long r0 = -r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.v.e(java.lang.String):java.lang.Long");
    }
}
