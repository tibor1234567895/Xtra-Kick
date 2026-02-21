package pb;

import fb.y;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import qb.h;
import xa.j;

public final class v {
    private v() {
    }

    public /* synthetic */ v(int i10) {
        this();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003d, code lost:
        if (r0 != ':') goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r4, int r5, java.lang.String r6, boolean r7) {
        /*
        L_0x0000:
            if (r4 >= r5) goto L_0x0048
            char r0 = r6.charAt(r4)
            r1 = 32
            r2 = 1
            if (r0 >= r1) goto L_0x000f
            r1 = 9
            if (r0 != r1) goto L_0x003f
        L_0x000f:
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 >= r1) goto L_0x003f
            r1 = 57
            r3 = 0
            if (r0 > r1) goto L_0x001e
            r1 = 48
            if (r1 > r0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 != 0) goto L_0x003f
            r1 = 122(0x7a, float:1.71E-43)
            if (r0 > r1) goto L_0x002b
            r1 = 97
            if (r1 > r0) goto L_0x002b
            r1 = 1
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            if (r1 != 0) goto L_0x003f
            r1 = 90
            if (r0 > r1) goto L_0x0038
            r1 = 65
            if (r1 > r0) goto L_0x0038
            r1 = 1
            goto L_0x0039
        L_0x0038:
            r1 = 0
        L_0x0039:
            if (r1 != 0) goto L_0x003f
            r1 = 58
            if (r0 != r1) goto L_0x0040
        L_0x003f:
            r3 = 1
        L_0x0040:
            r0 = r7 ^ 1
            if (r3 != r0) goto L_0x0045
            return r4
        L_0x0045:
            int r4 = r4 + 1
            goto L_0x0000
        L_0x0048:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.v.a(int, int, java.lang.String, boolean):int");
    }

    public static long b(int i10, String str) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        int a10 = a(0, i10, str, false);
        Matcher matcher = w.f13013n.matcher(str);
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        while (a10 < i10) {
            int a11 = a(a10 + 1, i10, str, true);
            matcher.region(a10, a11);
            if (i12 == -1 && matcher.usePattern(w.f13013n).matches()) {
                String group = matcher.group(1);
                j.e("matcher.group(1)", group);
                i12 = Integer.parseInt(group);
                String group2 = matcher.group(2);
                j.e("matcher.group(2)", group2);
                i15 = Integer.parseInt(group2);
                String group3 = matcher.group(3);
                j.e("matcher.group(3)", group3);
                i16 = Integer.parseInt(group3);
            } else if (i13 != -1 || !matcher.usePattern(w.f13012m).matches()) {
                if (i14 == -1) {
                    Pattern pattern = w.f13011l;
                    if (matcher.usePattern(pattern).matches()) {
                        String group4 = matcher.group(1);
                        j.e("matcher.group(1)", group4);
                        Locale locale = Locale.US;
                        j.e("US", locale);
                        String lowerCase = group4.toLowerCase(locale);
                        j.e("this as java.lang.String).toLowerCase(locale)", lowerCase);
                        String pattern2 = pattern.pattern();
                        j.e("MONTH_PATTERN.pattern()", pattern2);
                        i14 = y.u(pattern2, lowerCase, 0, false, 6) / 4;
                    }
                }
                if (i11 == -1 && matcher.usePattern(w.f13010k).matches()) {
                    String group5 = matcher.group(1);
                    j.e("matcher.group(1)", group5);
                    i11 = Integer.parseInt(group5);
                }
            } else {
                String group6 = matcher.group(1);
                j.e("matcher.group(1)", group6);
                i13 = Integer.parseInt(group6);
            }
            a10 = a(a11 + 1, i10, str, false);
        }
        if (70 > i11 || i11 >= 100) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            i11 += 1900;
        }
        if (i11 < 0 || i11 >= 70) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            i11 += 2000;
        }
        if (i11 >= 1601) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            if (i14 != -1) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                if (1 > i13 || i13 >= 32) {
                    z14 = false;
                } else {
                    z14 = true;
                }
                if (z14) {
                    if (i12 < 0 || i12 >= 24) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (z15) {
                        if (i15 < 0 || i15 >= 60) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            if (i16 < 0 || i16 >= 60) {
                                z17 = false;
                            } else {
                                z17 = true;
                            }
                            if (z17) {
                                GregorianCalendar gregorianCalendar = new GregorianCalendar(h.f13494b);
                                gregorianCalendar.setLenient(false);
                                gregorianCalendar.set(1, i11);
                                gregorianCalendar.set(2, i14 - 1);
                                gregorianCalendar.set(5, i13);
                                gregorianCalendar.set(11, i12);
                                gregorianCalendar.set(12, i15);
                                gregorianCalendar.set(13, i16);
                                gregorianCalendar.set(14, 0);
                                return gregorianCalendar.getTimeInMillis();
                            }
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
