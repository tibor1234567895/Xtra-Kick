package b3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w2.c;

public final class a extends c {

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f2513o = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f2514p = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: m  reason: collision with root package name */
    public final StringBuilder f2515m = new StringBuilder();

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f2516n = new ArrayList();

    public static long i(Matcher matcher, int i10) {
        long j10;
        String group = matcher.group(i10 + 1);
        if (group != null) {
            j10 = Long.parseLong(group) * 60 * 60 * 1000;
        } else {
            j10 = 0;
        }
        String group2 = matcher.group(i10 + 2);
        group2.getClass();
        String group3 = matcher.group(i10 + 3);
        group3.getClass();
        long parseLong = (Long.parseLong(group3) * 1000) + (Long.parseLong(group2) * 60 * 1000) + j10;
        String group4 = matcher.group(i10 + 4);
        if (group4 != null) {
            parseLong += Long.parseLong(group4);
        }
        return parseLong * 1000;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.d f(byte[] r19, int r20, boolean r21) {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = "SubripDecoder"
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            j1.w r3 = new j1.w
            r3.<init>()
            j1.b0 r4 = new j1.b0
            r5 = r19
            r6 = r20
            r4.<init>(r6, r5)
            java.nio.charset.Charset r5 = r4.C()
            if (r5 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            java.nio.charset.Charset r5 = c9.h.f3035c
        L_0x0020:
            java.lang.String r6 = r4.h(r5)
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x0244
            int r9 = r6.length()
            if (r9 != 0) goto L_0x0034
            r16 = r4
            r17 = r5
            goto L_0x023c
        L_0x0034:
            java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0235 }
            java.lang.String r6 = r4.h(r5)
            if (r6 != 0) goto L_0x0044
            java.lang.String r4 = "Unexpected end"
            j1.v.g(r1, r4)
            goto L_0x0244
        L_0x0044:
            java.util.regex.Pattern r9 = f2513o
            java.util.regex.Matcher r9 = r9.matcher(r6)
            boolean r10 = r9.matches()
            if (r10 == 0) goto L_0x0227
            long r10 = i(r9, r8)
            r3.a(r10)
            r6 = 6
            long r9 = i(r9, r6)
            r3.a(r9)
            java.lang.StringBuilder r9 = r0.f2515m
            r9.setLength(r7)
            java.util.ArrayList r10 = r0.f2516n
            r10.clear()
            java.lang.String r11 = r4.h(r5)
        L_0x006d:
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x00bd
            int r12 = r9.length()
            if (r12 <= 0) goto L_0x007e
            java.lang.String r12 = "<br>"
            r9.append(r12)
        L_0x007e:
            java.lang.String r11 = r11.trim()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>(r11)
            java.util.regex.Pattern r13 = f2514p
            java.util.regex.Matcher r11 = r13.matcher(r11)
            r13 = 0
        L_0x008e:
            boolean r14 = r11.find()
            if (r14 == 0) goto L_0x00af
            java.lang.String r14 = r11.group()
            r10.add(r14)
            int r15 = r11.start()
            int r15 = r15 - r13
            int r14 = r14.length()
            int r6 = r15 + r14
            java.lang.String r7 = ""
            r12.replace(r15, r6, r7)
            int r13 = r13 + r14
            r6 = 6
            r7 = 0
            goto L_0x008e
        L_0x00af:
            java.lang.String r6 = r12.toString()
            r9.append(r6)
            java.lang.String r11 = r4.h(r5)
            r6 = 6
            r7 = 0
            goto L_0x006d
        L_0x00bd:
            java.lang.String r6 = r9.toString()
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            r7 = 0
        L_0x00c6:
            int r9 = r10.size()
            if (r7 >= r9) goto L_0x00de
            java.lang.Object r9 = r10.get(r7)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r11 = "\\{\\\\an[1-9]\\}"
            boolean r11 = r9.matches(r11)
            if (r11 == 0) goto L_0x00db
            goto L_0x00df
        L_0x00db:
            int r7 = r7 + 1
            goto L_0x00c6
        L_0x00de:
            r9 = 0
        L_0x00df:
            i1.a r7 = new i1.a
            r7.<init>()
            r7.f7953a = r6
            if (r9 != 0) goto L_0x00f2
            i1.b r6 = r7.a()
            r16 = r4
            r17 = r5
            goto L_0x021e
        L_0x00f2:
            int r6 = r9.hashCode()
            java.lang.String r11 = "{\\an9}"
            java.lang.String r12 = "{\\an8}"
            java.lang.String r13 = "{\\an7}"
            java.lang.String r14 = "{\\an6}"
            java.lang.String r15 = "{\\an5}"
            java.lang.String r10 = "{\\an4}"
            java.lang.String r8 = "{\\an3}"
            java.lang.String r0 = "{\\an2}"
            r16 = r4
            java.lang.String r4 = "{\\an1}"
            switch(r6) {
                case -685620710: goto L_0x014f;
                case -685620679: goto L_0x0147;
                case -685620648: goto L_0x013f;
                case -685620617: goto L_0x0137;
                case -685620586: goto L_0x012f;
                case -685620555: goto L_0x0127;
                case -685620524: goto L_0x011f;
                case -685620493: goto L_0x0116;
                case -685620462: goto L_0x010e;
                default: goto L_0x010d;
            }
        L_0x010d:
            goto L_0x0157
        L_0x010e:
            boolean r6 = r9.equals(r11)
            if (r6 == 0) goto L_0x0157
            r6 = 5
            goto L_0x0158
        L_0x0116:
            boolean r6 = r9.equals(r12)
            if (r6 == 0) goto L_0x0157
            r6 = 8
            goto L_0x0158
        L_0x011f:
            boolean r6 = r9.equals(r13)
            if (r6 == 0) goto L_0x0157
            r6 = 2
            goto L_0x0158
        L_0x0127:
            boolean r6 = r9.equals(r14)
            if (r6 == 0) goto L_0x0157
            r6 = 4
            goto L_0x0158
        L_0x012f:
            boolean r6 = r9.equals(r15)
            if (r6 == 0) goto L_0x0157
            r6 = 7
            goto L_0x0158
        L_0x0137:
            boolean r6 = r9.equals(r10)
            if (r6 == 0) goto L_0x0157
            r6 = 1
            goto L_0x0158
        L_0x013f:
            boolean r6 = r9.equals(r8)
            if (r6 == 0) goto L_0x0157
            r6 = 3
            goto L_0x0158
        L_0x0147:
            boolean r6 = r9.equals(r0)
            if (r6 == 0) goto L_0x0157
            r6 = 6
            goto L_0x0158
        L_0x014f:
            boolean r6 = r9.equals(r4)
            if (r6 == 0) goto L_0x0157
            r6 = 0
            goto L_0x0158
        L_0x0157:
            r6 = -1
        L_0x0158:
            r17 = r5
            if (r6 == 0) goto L_0x016f
            r5 = 1
            if (r6 == r5) goto L_0x016f
            r5 = 2
            if (r6 == r5) goto L_0x016f
            r5 = 3
            if (r6 == r5) goto L_0x016d
            r5 = 4
            if (r6 == r5) goto L_0x016d
            r5 = 5
            if (r6 == r5) goto L_0x016d
            r5 = 1
            goto L_0x0170
        L_0x016d:
            r5 = 2
            goto L_0x0170
        L_0x016f:
            r5 = 0
        L_0x0170:
            r7.f7961i = r5
            int r5 = r9.hashCode()
            switch(r5) {
                case -685620710: goto L_0x01bb;
                case -685620679: goto L_0x01b3;
                case -685620648: goto L_0x01ab;
                case -685620617: goto L_0x01a3;
                case -685620586: goto L_0x019b;
                case -685620555: goto L_0x0192;
                case -685620524: goto L_0x018a;
                case -685620493: goto L_0x0182;
                case -685620462: goto L_0x017a;
                default: goto L_0x0179;
            }
        L_0x0179:
            goto L_0x01c3
        L_0x017a:
            boolean r0 = r9.equals(r11)
            if (r0 == 0) goto L_0x01c3
            r6 = 5
            goto L_0x01c4
        L_0x0182:
            boolean r0 = r9.equals(r12)
            if (r0 == 0) goto L_0x01c3
            r6 = 4
            goto L_0x01c4
        L_0x018a:
            boolean r0 = r9.equals(r13)
            if (r0 == 0) goto L_0x01c3
            r6 = 3
            goto L_0x01c4
        L_0x0192:
            boolean r0 = r9.equals(r14)
            if (r0 == 0) goto L_0x01c3
            r6 = 8
            goto L_0x01c4
        L_0x019b:
            boolean r0 = r9.equals(r15)
            if (r0 == 0) goto L_0x01c3
            r6 = 7
            goto L_0x01c4
        L_0x01a3:
            boolean r0 = r9.equals(r10)
            if (r0 == 0) goto L_0x01c3
            r6 = 6
            goto L_0x01c4
        L_0x01ab:
            boolean r0 = r9.equals(r8)
            if (r0 == 0) goto L_0x01c3
            r6 = 2
            goto L_0x01c4
        L_0x01b3:
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x01c3
            r6 = 1
            goto L_0x01c4
        L_0x01bb:
            boolean r0 = r9.equals(r4)
            if (r0 == 0) goto L_0x01c3
            r6 = 0
            goto L_0x01c4
        L_0x01c3:
            r6 = -1
        L_0x01c4:
            if (r6 == 0) goto L_0x01d9
            r0 = 1
            if (r6 == r0) goto L_0x01d9
            r0 = 2
            if (r6 == r0) goto L_0x01d9
            r0 = 3
            if (r6 == r0) goto L_0x01d7
            r0 = 4
            if (r6 == r0) goto L_0x01d7
            r0 = 5
            if (r6 == r0) goto L_0x01d7
            r0 = 1
            goto L_0x01da
        L_0x01d7:
            r0 = 0
            goto L_0x01da
        L_0x01d9:
            r0 = 2
        L_0x01da:
            r7.f7959g = r0
            int r4 = r7.f7961i
            r5 = 1064011039(0x3f6b851f, float:0.92)
            r6 = 1056964608(0x3f000000, float:0.5)
            r8 = 1034147594(0x3da3d70a, float:0.08)
            if (r4 == 0) goto L_0x01fb
            r9 = 1
            if (r4 == r9) goto L_0x01f8
            r9 = 2
            if (r4 != r9) goto L_0x01f2
            r4 = 1064011039(0x3f6b851f, float:0.92)
            goto L_0x01fe
        L_0x01f2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x01f8:
            r4 = 1056964608(0x3f000000, float:0.5)
            goto L_0x01fe
        L_0x01fb:
            r4 = 1034147594(0x3da3d70a, float:0.08)
        L_0x01fe:
            r7.f7960h = r4
            if (r0 == 0) goto L_0x0212
            r4 = 1
            if (r0 == r4) goto L_0x020f
            r4 = 2
            if (r0 != r4) goto L_0x0209
            goto L_0x0215
        L_0x0209:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x020f:
            r5 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0215
        L_0x0212:
            r5 = 1034147594(0x3da3d70a, float:0.08)
        L_0x0215:
            r7.f7957e = r5
            r0 = 0
            r7.f7958f = r0
            i1.b r6 = r7.a()
        L_0x021e:
            r2.add(r6)
            i1.b r0 = i1.b.f7970y
            r2.add(r0)
            goto L_0x023c
        L_0x0227:
            r16 = r4
            r17 = r5
            java.lang.String r0 = "Skipping invalid timing: "
        L_0x022d:
            java.lang.String r0 = r0.concat(r6)
            j1.v.g(r1, r0)
            goto L_0x023c
        L_0x0235:
            r16 = r4
            r17 = r5
            java.lang.String r0 = "Skipping invalid index: "
            goto L_0x022d
        L_0x023c:
            r0 = r18
            r4 = r16
            r5 = r17
            goto L_0x0020
        L_0x0244:
            r0 = 0
            i1.b[] r0 = new i1.b[r0]
            java.lang.Object[] r0 = r2.toArray(r0)
            i1.b[] r0 = (i1.b[]) r0
            long[] r1 = r3.f8480b
            int r2 = r3.f8479a
            long[] r1 = java.util.Arrays.copyOf(r1, r2)
            a3.f r2 = new a3.f
            r3 = 1
            r2.<init>(r0, r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.a.f(byte[], int, boolean):w2.d");
    }
}
