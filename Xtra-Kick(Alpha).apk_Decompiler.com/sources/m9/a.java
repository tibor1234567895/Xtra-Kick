package m9;

import java.util.TimeZone;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f10797a = TimeZone.getTimeZone("UTC");

    public static boolean a(char c10, int i10, String str) {
        return i10 < str.length() && str.charAt(i10) == c10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e1 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c6 A[Catch:{ IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01ce }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date b(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            r1 = r17
            r2 = r18
            int r0 = r18.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r3 = r0 + 4
            int r0 = c(r0, r3, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r4 = 45
            boolean r5 = a(r4, r3, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r5 == 0) goto L_0x0018
            int r3 = r3 + 1
        L_0x0018:
            int r5 = r3 + 2
            int r3 = c(r3, r5, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            boolean r6 = a(r4, r5, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r6 == 0) goto L_0x0026
            int r5 = r5 + 1
        L_0x0026:
            int r6 = r5 + 2
            int r5 = c(r5, r6, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r7 = 84
            boolean r7 = a(r7, r6, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r8 = 1
            if (r7 != 0) goto L_0x0049
            int r9 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r9 > r6) goto L_0x0049
            java.util.GregorianCalendar r4 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r3 = r3 - r8
            r4.<init>(r0, r3, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r2.setIndex(r6)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.util.Date r0 = r4.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            return r0
        L_0x0049:
            r10 = 2
            r11 = 43
            r12 = 90
            if (r7 == 0) goto L_0x00d5
            int r6 = r6 + 1
            int r7 = r6 + 2
            int r6 = c(r6, r7, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r13 = 58
            boolean r14 = a(r13, r7, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r14 == 0) goto L_0x0062
            int r7 = r7 + 1
        L_0x0062:
            int r14 = r7 + 2
            int r7 = c(r7, r14, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            boolean r13 = a(r13, r14, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r13 == 0) goto L_0x0070
            int r14 = r14 + 1
        L_0x0070:
            int r13 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r13 <= r14) goto L_0x00d2
            char r13 = r1.charAt(r14)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r13 == r12) goto L_0x00d2
            if (r13 == r11) goto L_0x00d2
            if (r13 == r4) goto L_0x00d2
            int r13 = r14 + 2
            int r14 = c(r14, r13, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r15 = 59
            if (r14 <= r15) goto L_0x0090
            r15 = 63
            if (r14 >= r15) goto L_0x0090
            r14 = 59
        L_0x0090:
            r15 = 46
            boolean r15 = a(r15, r13, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r15 == 0) goto L_0x00d0
            int r13 = r13 + 1
            int r15 = r13 + 1
        L_0x009c:
            int r9 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r15 >= r9) goto L_0x00b4
            char r9 = r1.charAt(r15)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r4 = 48
            if (r9 < r4) goto L_0x00b9
            r4 = 57
            if (r9 <= r4) goto L_0x00af
            goto L_0x00b9
        L_0x00af:
            int r15 = r15 + 1
            r4 = 45
            goto L_0x009c
        L_0x00b4:
            int r4 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r15 = r4
        L_0x00b9:
            int r4 = r13 + 3
            int r4 = java.lang.Math.min(r15, r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r9 = c(r13, r4, r1)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r4 = r4 - r13
            if (r4 == r8) goto L_0x00cc
            if (r4 == r10) goto L_0x00c9
            goto L_0x00ce
        L_0x00c9:
            int r9 = r9 * 10
            goto L_0x00ce
        L_0x00cc:
            int r9 = r9 * 100
        L_0x00ce:
            r13 = r15
            goto L_0x00db
        L_0x00d0:
            r9 = 0
            goto L_0x00db
        L_0x00d2:
            r4 = r6
            r6 = r14
            goto L_0x00d7
        L_0x00d5:
            r4 = 0
            r7 = 0
        L_0x00d7:
            r13 = r6
            r9 = 0
            r14 = 0
            r6 = r4
        L_0x00db:
            int r4 = r17.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r4 <= r13) goto L_0x01c6
            char r4 = r1.charAt(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r15 = 5
            java.util.TimeZone r16 = f10797a
            if (r4 != r12) goto L_0x00ef
            int r13 = r13 + r8
        L_0x00eb:
            r4 = r16
            goto L_0x0196
        L_0x00ef:
            if (r4 == r11) goto L_0x0112
            r11 = 45
            if (r4 != r11) goto L_0x00f6
            goto L_0x0112
        L_0x00f6:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r5 = "Invalid time zone indicator '"
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
        L_0x0112:
            java.lang.String r4 = r1.substring(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r11 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r11 < r15) goto L_0x011d
            goto L_0x012e
        L_0x011d:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = "00"
            r11.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
        L_0x012e:
            int r11 = r4.length()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r13 = r13 + r11
            java.lang.String r11 = "+0000"
            boolean r11 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r11 != 0) goto L_0x00eb
            java.lang.String r11 = "+00:00"
            boolean r11 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r11 == 0) goto L_0x0144
            goto L_0x00eb
        L_0x0144:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r12 = "GMT"
            r11.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = r11.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.util.TimeZone r16 = java.util.TimeZone.getTimeZone(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r11 = r16.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            boolean r12 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r12 != 0) goto L_0x00eb
            java.lang.String r12 = ":"
            java.lang.String r15 = ""
            java.lang.String r11 = r11.replace(r12, r15)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            boolean r11 = r11.equals(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            if (r11 == 0) goto L_0x0173
            goto L_0x00eb
        L_0x0173:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r5 = "Mismatching time zone indicator: "
            r3.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = " given, resolves to "
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r4 = r16.getID()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
        L_0x0196:
            java.util.GregorianCalendar r11 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.<init>(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r4 = 0
            r11.setLenient(r4)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r11.set(r8, r0)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            int r3 = r3 - r8
            r11.set(r10, r3)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0 = 5
            r11.set(r0, r5)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0 = 11
            r11.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0 = 12
            r11.set(r0, r7)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0 = 13
            r11.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r0 = 14
            r11.set(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            r2.setIndex(r13)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.util.Date r0 = r11.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            return r0
        L_0x01c6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x01d2, NumberFormatException -> 0x01d0, IllegalArgumentException -> 0x01ce }
        L_0x01ce:
            r0 = move-exception
            goto L_0x01d3
        L_0x01d0:
            r0 = move-exception
            goto L_0x01d3
        L_0x01d2:
            r0 = move-exception
        L_0x01d3:
            if (r1 != 0) goto L_0x01d7
            r1 = 0
            goto L_0x01ea
        L_0x01d7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\""
            r3.<init>(r4)
            r3.append(r1)
            r1 = 34
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x01ea:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01f6
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0211
        L_0x01f6:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0211:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Failed to parse date ["
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = "]: "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = r5.toString()
            int r2 = r18.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i10, int i11, String str) {
        int i12;
        int i13;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        if (i10 < i11) {
            i13 = i10 + 1;
            int digit = Character.digit(str.charAt(i10), 10);
            if (digit >= 0) {
                i12 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        } else {
            i12 = 0;
            i13 = i10;
        }
        while (i13 < i11) {
            int i14 = i13 + 1;
            int digit2 = Character.digit(str.charAt(i13), 10);
            if (digit2 >= 0) {
                i12 = (i12 * 10) - digit2;
                i13 = i14;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
        }
        return -i12;
    }
}
