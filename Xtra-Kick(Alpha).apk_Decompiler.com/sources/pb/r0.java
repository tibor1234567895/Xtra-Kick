package pb;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import ma.s;
import xa.j;

public final class r0 {

    /* renamed from: i  reason: collision with root package name */
    public static final q0 f12952i = new q0(0);

    /* renamed from: a  reason: collision with root package name */
    public String f12953a;

    /* renamed from: b  reason: collision with root package name */
    public String f12954b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f12955c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f12956d;

    /* renamed from: e  reason: collision with root package name */
    public int f12957e = -1;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f12958f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f12959g;

    /* renamed from: h  reason: collision with root package name */
    public String f12960h;

    public r0() {
        ArrayList arrayList = new ArrayList();
        this.f12958f = arrayList;
        arrayList.add("");
    }

    public final t0 a() {
        int i10;
        ArrayList arrayList;
        String str;
        String str2;
        String str3 = this.f12953a;
        if (str3 != null) {
            s0 s0Var = t0.f12987k;
            s0 s0Var2 = s0Var;
            String d10 = s0.d(s0Var2, this.f12954b, 0, 0, false, 7);
            String d11 = s0.d(s0Var2, this.f12955c, 0, 0, false, 7);
            String str4 = this.f12956d;
            if (str4 != null) {
                int i11 = this.f12957e;
                if (i11 != -1) {
                    i10 = i11;
                } else {
                    String str5 = this.f12953a;
                    j.c(str5);
                    s0Var.getClass();
                    i10 = s0.b(str5);
                }
                ArrayList arrayList2 = this.f12958f;
                ArrayList arrayList3 = new ArrayList(s.i(arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add(s0.d(t0.f12987k, (String) it.next(), 0, 0, false, 7));
                }
                ArrayList<String> arrayList4 = this.f12959g;
                if (arrayList4 != null) {
                    arrayList = new ArrayList(s.i(arrayList4));
                    for (String str6 : arrayList4) {
                        if (str6 != null) {
                            str2 = s0.d(t0.f12987k, str6, 0, 0, true, 3);
                        } else {
                            str2 = null;
                        }
                        arrayList.add(str2);
                    }
                } else {
                    arrayList = null;
                }
                String str7 = this.f12960h;
                if (str7 != null) {
                    str = s0.d(t0.f12987k, str7, 0, 0, false, 7);
                } else {
                    str = null;
                }
                return new t0(str3, d10, d11, str4, i10, arrayList3, arrayList, str, toString());
            }
            throw new IllegalStateException("host == null");
        }
        throw new IllegalStateException("scheme == null");
    }

    public final void b(String str) {
        this.f12959g = str != null ? s0.e(s0.a(t0.f12987k, str, 0, 0, " \"'<>#", true, false, true, false, (Charset) null, 211)) : null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009c, code lost:
        if (r11 == ':') goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0312  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0425  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0449  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0455  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0256 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:254:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(pb.t0 r27, java.lang.String r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            r12 = r28
            java.lang.String r2 = "input"
            xa.j.f(r2, r12)
            byte[] r2 = qb.f.f13487a
            int r2 = r28.length()
            r3 = 0
            int r2 = qb.f.h(r3, r2, r12)
            int r4 = r28.length()
            int r13 = qb.f.i(r2, r4, r12)
            pb.q0 r4 = f12952i
            r4.getClass()
            int r4 = r13 - r2
            r5 = 91
            r6 = 2
            r7 = 58
            r8 = -1
            r9 = 1
            if (r4 >= r6) goto L_0x0030
            goto L_0x00a2
        L_0x0030:
            char r4 = r12.charAt(r2)
            r10 = 97
            int r11 = xa.j.h(r4, r10)
            r14 = 65
            if (r11 < 0) goto L_0x0046
            r11 = 122(0x7a, float:1.71E-43)
            int r11 = xa.j.h(r4, r11)
            if (r11 <= 0) goto L_0x0055
        L_0x0046:
            int r11 = xa.j.h(r4, r14)
            if (r11 < 0) goto L_0x00a2
            r11 = 90
            int r4 = xa.j.h(r4, r11)
            if (r4 <= 0) goto L_0x0055
            goto L_0x00a2
        L_0x0055:
            int r4 = r2 + 1
        L_0x0057:
            if (r4 >= r13) goto L_0x00a2
            char r11 = r12.charAt(r4)
            if (r10 > r11) goto L_0x0065
            r15 = 123(0x7b, float:1.72E-43)
            if (r11 >= r15) goto L_0x0065
            r15 = 1
            goto L_0x0066
        L_0x0065:
            r15 = 0
        L_0x0066:
            if (r15 == 0) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            if (r14 > r11) goto L_0x006f
            if (r11 >= r5) goto L_0x006f
        L_0x006d:
            r15 = 1
            goto L_0x0070
        L_0x006f:
            r15 = 0
        L_0x0070:
            if (r15 == 0) goto L_0x0073
            goto L_0x0079
        L_0x0073:
            r15 = 48
            if (r15 > r11) goto L_0x007b
            if (r11 >= r7) goto L_0x007b
        L_0x0079:
            r15 = 1
            goto L_0x007c
        L_0x007b:
            r15 = 0
        L_0x007c:
            if (r15 == 0) goto L_0x007f
            goto L_0x0083
        L_0x007f:
            r15 = 43
            if (r11 != r15) goto L_0x0085
        L_0x0083:
            r15 = 1
            goto L_0x0086
        L_0x0085:
            r15 = 0
        L_0x0086:
            if (r15 == 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            r15 = 45
            if (r11 != r15) goto L_0x008f
        L_0x008d:
            r15 = 1
            goto L_0x0090
        L_0x008f:
            r15 = 0
        L_0x0090:
            if (r15 == 0) goto L_0x0093
            goto L_0x0097
        L_0x0093:
            r15 = 46
            if (r11 != r15) goto L_0x0099
        L_0x0097:
            r15 = 1
            goto L_0x009a
        L_0x0099:
            r15 = 0
        L_0x009a:
            if (r15 != 0) goto L_0x009f
            if (r11 != r7) goto L_0x00a2
            goto L_0x00a3
        L_0x009f:
            int r4 = r4 + 1
            goto L_0x0057
        L_0x00a2:
            r4 = -1
        L_0x00a3:
            java.lang.String r14 = "this as java.lang.String…ing(startIndex, endIndex)"
            if (r4 == r8) goto L_0x00e5
            java.lang.String r5 = "https:"
            boolean r5 = fb.w.l(r12, r5, r2, r9)
            if (r5 == 0) goto L_0x00b6
            java.lang.String r3 = "https"
            r0.f12953a = r3
            int r2 = r2 + 6
            goto L_0x00eb
        L_0x00b6:
            java.lang.String r5 = "http:"
            boolean r5 = fb.w.l(r12, r5, r2, r9)
            if (r5 == 0) goto L_0x00c5
            java.lang.String r3 = "http"
            r0.f12953a = r3
            int r2 = r2 + 5
            goto L_0x00eb
        L_0x00c5:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Expected URL scheme 'http' or 'https' but was '"
            r2.<init>(r5)
            java.lang.String r3 = r12.substring(r3, r4)
            xa.j.e(r14, r3)
            r2.append(r3)
            r3 = 39
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00e5:
            if (r1 == 0) goto L_0x049c
            java.lang.String r3 = r1.f12989a
            r0.f12953a = r3
        L_0x00eb:
            r3 = 0
            r4 = r2
        L_0x00ed:
            r5 = 92
            r8 = 47
            if (r4 >= r13) goto L_0x0100
            char r9 = r12.charAt(r4)
            if (r9 == r5) goto L_0x00fb
            if (r9 != r8) goto L_0x0100
        L_0x00fb:
            int r3 = r3 + 1
            int r4 = r4 + 1
            goto L_0x00ed
        L_0x0100:
            java.util.ArrayList r15 = r0.f12958f
            r4 = 35
            if (r3 >= r6) goto L_0x0146
            if (r1 == 0) goto L_0x0146
            java.lang.String r5 = r0.f12953a
            java.lang.String r6 = r1.f12989a
            boolean r5 = xa.j.a(r6, r5)
            if (r5 != 0) goto L_0x0113
            goto L_0x0146
        L_0x0113:
            java.lang.String r3 = r27.e()
            r0.f12954b = r3
            java.lang.String r3 = r27.a()
            r0.f12955c = r3
            java.lang.String r3 = r1.f12992d
            r0.f12956d = r3
            int r3 = r1.f12993e
            r0.f12957e = r3
            r15.clear()
            java.util.ArrayList r3 = r27.c()
            r15.addAll(r3)
            if (r2 == r13) goto L_0x0139
            char r3 = r12.charAt(r2)
            if (r3 != r4) goto L_0x0140
        L_0x0139:
            java.lang.String r1 = r27.d()
            r0.b(r1)
        L_0x0140:
            r1 = 1
            r19 = r15
            r14 = 1
            goto L_0x0319
        L_0x0146:
            int r2 = r2 + r3
            r1 = 0
            r3 = 0
            r11 = r2
            r16 = 0
            r17 = 0
        L_0x014e:
            java.lang.String r1 = "@/\\?#"
            int r10 = qb.f.c(r11, r13, r12, r1)
            if (r10 == r13) goto L_0x015b
            char r1 = r12.charAt(r10)
            goto L_0x015c
        L_0x015b:
            r1 = -1
        L_0x015c:
            r2 = 64
            if (r1 != r2) goto L_0x0208
            java.lang.String r9 = "%40"
            if (r16 != 0) goto L_0x01cf
            int r8 = qb.f.d(r12, r7, r11, r10)
            pb.s0 r18 = pb.t0.f12987k
            java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
            r6 = 1
            r7 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 240(0xf0, float:3.36E-43)
            r1 = r18
            r2 = r28
            r3 = r11
            r4 = r8
            r11 = r8
            r8 = r19
            r23 = r9
            r9 = r20
            r24 = r10
            r10 = r21
            r19 = r15
            r15 = r11
            r11 = r22
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r17 == 0) goto L_0x01a8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r0.f12954b
            r2.append(r3)
            r3 = r23
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
        L_0x01a8:
            r0.f12954b = r1
            r11 = r24
            if (r15 == r11) goto L_0x01ca
            int r3 = r15 + 1
            java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r15 = 240(0xf0, float:3.36E-43)
            r1 = r18
            r2 = r28
            r4 = r11
            r24 = r11
            r11 = r15
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0.f12955c = r1
            r16 = 1
            goto L_0x01cc
        L_0x01ca:
            r24 = r11
        L_0x01cc:
            r17 = 1
            goto L_0x0200
        L_0x01cf:
            r3 = r9
            r24 = r10
            r19 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r1 = r0.f12955c
            r15.append(r1)
            r15.append(r3)
            pb.s0 r1 = pb.t0.f12987k
            java.lang.String r5 = " \"':;<=>@[]^`{}|/\\?#"
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r18 = 240(0xf0, float:3.36E-43)
            r2 = r28
            r3 = r11
            r4 = r24
            r11 = r18
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.append(r1)
            java.lang.String r1 = r15.toString()
            r0.f12955c = r1
        L_0x0200:
            r15 = r24
            int r11 = r15 + 1
        L_0x0204:
            r2 = r19
            goto L_0x0495
        L_0x0208:
            r19 = r15
            r15 = r10
            r2 = -1
            r3 = 58
            if (r1 != r2) goto L_0x0212
        L_0x0210:
            r2 = 1
            goto L_0x0218
        L_0x0212:
            r2 = 47
            if (r1 != r2) goto L_0x0217
            goto L_0x0210
        L_0x0217:
            r2 = 0
        L_0x0218:
            if (r2 == 0) goto L_0x021c
        L_0x021a:
            r2 = 1
            goto L_0x0222
        L_0x021c:
            r2 = 92
            if (r1 != r2) goto L_0x0221
            goto L_0x021a
        L_0x0221:
            r2 = 0
        L_0x0222:
            if (r2 == 0) goto L_0x0225
            goto L_0x0229
        L_0x0225:
            r2 = 63
            if (r1 != r2) goto L_0x022b
        L_0x0229:
            r2 = 1
            goto L_0x022c
        L_0x022b:
            r2 = 0
        L_0x022c:
            if (r2 == 0) goto L_0x022f
            goto L_0x0233
        L_0x022f:
            r2 = 35
            if (r1 != r2) goto L_0x0235
        L_0x0233:
            r1 = 1
            goto L_0x0236
        L_0x0235:
            r1 = 0
        L_0x0236:
            if (r1 == 0) goto L_0x0492
            r10 = r11
        L_0x0239:
            if (r10 >= r15) goto L_0x0256
            char r1 = r12.charAt(r10)
            r2 = 91
            if (r1 != r2) goto L_0x0250
        L_0x0243:
            int r10 = r10 + 1
            if (r10 >= r15) goto L_0x0253
            char r1 = r12.charAt(r10)
            r2 = 93
            if (r1 != r2) goto L_0x0243
            goto L_0x0253
        L_0x0250:
            if (r1 != r3) goto L_0x0253
            goto L_0x0257
        L_0x0253:
            int r10 = r10 + 1
            goto L_0x0239
        L_0x0256:
            r10 = r15
        L_0x0257:
            int r9 = r10 + 1
            if (r9 >= r15) goto L_0x02e5
            pb.s0 r7 = pb.t0.f12987k
            r5 = 0
            r6 = 4
            r1 = r7
            r2 = r28
            r3 = r11
            r4 = r10
            java.lang.String r1 = pb.s0.d(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = hb.h0.R1(r1)
            r0.f12956d = r1
            java.lang.String r5 = ""
            r6 = 0
            r8 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 248(0xf8, float:3.48E-43)
            r4 = 1
            r1 = r7
            r2 = r28
            r3 = r9
            r7 = 1
            r4 = r15
            r7 = r8
            r8 = r16
            r25 = r9
            r9 = r17
            r27 = r10
            r10 = r18
            r18 = r11
            r11 = r20
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ NumberFormatException -> 0x02a8 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x02a8 }
            r2 = 1
            if (r2 > r1) goto L_0x02a1
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r1 >= r3) goto L_0x02a1
            r3 = 1
            goto L_0x02a2
        L_0x02a1:
            r3 = 0
        L_0x02a2:
            if (r3 == 0) goto L_0x02a6
            r4 = 1
            goto L_0x02b2
        L_0x02a6:
            r4 = 1
            goto L_0x02b1
        L_0x02a8:
            r2 = 1
            goto L_0x02a6
        L_0x02aa:
            r25 = r9
            r27 = r10
            r18 = r11
            goto L_0x02a6
        L_0x02b1:
            r1 = -1
        L_0x02b2:
            r0.f12957e = r1
            r2 = -1
            if (r1 == r2) goto L_0x02b9
            r1 = 1
            goto L_0x02ba
        L_0x02b9:
            r1 = 0
        L_0x02ba:
            if (r1 == 0) goto L_0x02bf
            r1 = 34
            goto L_0x030e
        L_0x02bf:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid URL port: \""
            r1.<init>(r2)
            r10 = r25
            java.lang.String r2 = r12.substring(r10, r15)
            xa.j.e(r14, r2)
            r1.append(r2)
            r2 = 34
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x02e5:
            r27 = r10
            r18 = r11
            r7 = 34
            r8 = 1
            pb.s0 r1 = pb.t0.f12987k
            r5 = 0
            r6 = 4
            r2 = r28
            r3 = r18
            r4 = r27
            java.lang.String r1 = pb.s0.d(r1, r2, r3, r4, r5, r6)
            java.lang.String r1 = hb.h0.R1(r1)
            r0.f12956d = r1
            java.lang.String r1 = r0.f12953a
            xa.j.c(r1)
            int r1 = pb.s0.b(r1)
            r0.f12957e = r1
            r1 = 34
            r4 = 1
        L_0x030e:
            java.lang.String r2 = r0.f12956d
            if (r2 == 0) goto L_0x0314
            r2 = 1
            goto L_0x0315
        L_0x0314:
            r2 = 0
        L_0x0315:
            if (r2 == 0) goto L_0x046c
            r14 = r4
            r2 = r15
        L_0x0319:
            java.lang.String r1 = "?#"
            int r15 = qb.f.c(r2, r13, r12, r1)
            if (r2 != r15) goto L_0x0323
            goto L_0x041b
        L_0x0323:
            char r1 = r12.charAt(r2)
            java.lang.String r11 = ""
            r3 = 47
            if (r1 == r3) goto L_0x033d
            r3 = 92
            if (r1 != r3) goto L_0x0332
            goto L_0x033d
        L_0x0332:
            int r1 = r19.size()
            int r1 = r1 - r14
            r10 = r19
            r10.set(r1, r11)
            goto L_0x0347
        L_0x033d:
            r10 = r19
            r10.clear()
            r10.add(r11)
            int r2 = r2 + 1
        L_0x0347:
            r3 = r2
        L_0x0348:
            if (r3 >= r15) goto L_0x041b
            java.lang.String r1 = "/\\"
            int r9 = qb.f.c(r3, r15, r12, r1)
            if (r9 >= r15) goto L_0x0356
            r1 = 1
            r16 = 1
            goto L_0x0359
        L_0x0356:
            r1 = 0
            r16 = 0
        L_0x0359:
            r6 = 1
            pb.s0 r1 = pb.t0.f12987k
            java.lang.String r5 = " \"<>^`{}|/\\?#"
            r7 = 0
            r8 = 0
            r17 = 0
            r18 = 0
            r19 = 240(0xf0, float:3.36E-43)
            r2 = r28
            r4 = r9
            r20 = r9
            r9 = r17
            r27 = r10
            r10 = r18
            r0 = r11
            r11 = r19
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.String r2 = "."
            boolean r2 = xa.j.a(r1, r2)
            if (r2 != 0) goto L_0x038b
            java.lang.String r2 = "%2e"
            boolean r2 = fb.w.g(r1, r2)
            if (r2 == 0) goto L_0x0389
            goto L_0x038b
        L_0x0389:
            r2 = 0
            goto L_0x038c
        L_0x038b:
            r2 = 1
        L_0x038c:
            if (r2 == 0) goto L_0x0392
            r2 = r27
            goto L_0x040d
        L_0x0392:
            java.lang.String r2 = ".."
            boolean r2 = xa.j.a(r1, r2)
            if (r2 != 0) goto L_0x03b5
            java.lang.String r2 = "%2e."
            boolean r2 = fb.w.g(r1, r2)
            if (r2 != 0) goto L_0x03b5
            java.lang.String r2 = ".%2e"
            boolean r2 = fb.w.g(r1, r2)
            if (r2 != 0) goto L_0x03b5
            java.lang.String r2 = "%2e%2e"
            boolean r2 = fb.w.g(r1, r2)
            if (r2 == 0) goto L_0x03b3
            goto L_0x03b5
        L_0x03b3:
            r2 = 0
            goto L_0x03b6
        L_0x03b5:
            r2 = 1
        L_0x03b6:
            if (r2 == 0) goto L_0x03e4
            int r1 = r27.size()
            int r1 = r1 - r14
            r2 = r27
            java.lang.Object r1 = r2.remove(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x03cd
            r1 = 1
            goto L_0x03ce
        L_0x03cd:
            r1 = 0
        L_0x03ce:
            if (r1 == 0) goto L_0x03e0
            boolean r1 = r2.isEmpty()
            r1 = r1 ^ r14
            if (r1 == 0) goto L_0x03e0
            int r1 = r2.size()
            int r1 = r1 - r14
            r2.set(r1, r0)
            goto L_0x040d
        L_0x03e0:
            r2.add(r0)
            goto L_0x040d
        L_0x03e4:
            r2 = r27
            int r3 = r2.size()
            int r3 = r3 - r14
            java.lang.Object r3 = r2.get(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x03f9
            r3 = 1
            goto L_0x03fa
        L_0x03f9:
            r3 = 0
        L_0x03fa:
            if (r3 == 0) goto L_0x0405
            int r3 = r2.size()
            int r3 = r3 - r14
            r2.set(r3, r1)
            goto L_0x0408
        L_0x0405:
            r2.add(r1)
        L_0x0408:
            if (r16 == 0) goto L_0x040d
            r2.add(r0)
        L_0x040d:
            if (r16 == 0) goto L_0x0413
            int r9 = r20 + 1
            r3 = r9
            goto L_0x0415
        L_0x0413:
            r3 = r20
        L_0x0415:
            r11 = r0
            r10 = r2
            r0 = r26
            goto L_0x0348
        L_0x041b:
            if (r15 >= r13) goto L_0x0449
            char r0 = r12.charAt(r15)
            r1 = 63
            if (r0 != r1) goto L_0x0449
            r0 = 35
            int r0 = qb.f.d(r12, r0, r15, r13)
            pb.s0 r1 = pb.t0.f12987k
            int r3 = r15 + 1
            java.lang.String r5 = " \"'<>#"
            r6 = 1
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 0
            r11 = 208(0xd0, float:2.91E-43)
            r2 = r28
            r4 = r0
            java.lang.String r1 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            java.util.ArrayList r1 = pb.s0.e(r1)
            r14 = r26
            r14.f12959g = r1
            r15 = r0
            goto L_0x044b
        L_0x0449:
            r14 = r26
        L_0x044b:
            if (r15 >= r13) goto L_0x046b
            char r0 = r12.charAt(r15)
            r1 = 35
            if (r0 != r1) goto L_0x046b
            pb.s0 r1 = pb.t0.f12987k
            int r3 = r15 + 1
            java.lang.String r5 = ""
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 176(0xb0, float:2.47E-43)
            r2 = r28
            r4 = r13
            java.lang.String r0 = pb.s0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.f12960h = r0
        L_0x046b:
            return
        L_0x046c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid URL host: \""
            r0.<init>(r2)
            r15 = r27
            r3 = r18
            java.lang.String r2 = r12.substring(r3, r15)
            xa.j.e(r14, r2)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0492:
            r3 = r11
            goto L_0x0204
        L_0x0495:
            r7 = 58
            r0 = r26
            r15 = r2
            goto L_0x014e
        L_0x049c:
            int r0 = r28.length()
            r1 = 6
            if (r0 <= r1) goto L_0x04ae
            java.lang.String r0 = fb.a0.S(r1, r12)
            java.lang.String r1 = "..."
            java.lang.String r0 = r0.concat(r1)
            goto L_0x04af
        L_0x04ae:
            r0 = r12
        L_0x04af:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Expected URL scheme 'http' or 'https' but no scheme was found for "
            java.lang.String r0 = android.support.v4.media.h.m(r2, r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.r0.c(pb.t0, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r1 != false) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if (r1 != pb.s0.b(r3)) goto L_0x0098;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r6.f12953a
            if (r1 == 0) goto L_0x000f
            r0.append(r1)
            java.lang.String r1 = "://"
            goto L_0x0011
        L_0x000f:
            java.lang.String r1 = "//"
        L_0x0011:
            r0.append(r1)
            java.lang.String r1 = r6.f12954b
            int r1 = r1.length()
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            r4 = 58
            if (r1 != 0) goto L_0x0032
            java.lang.String r1 = r6.f12955c
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x002f
            r1 = 1
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            if (r1 == 0) goto L_0x0050
        L_0x0032:
            java.lang.String r1 = r6.f12954b
            r0.append(r1)
            java.lang.String r1 = r6.f12955c
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r3 = 0
        L_0x0041:
            if (r3 == 0) goto L_0x004b
            r0.append(r4)
            java.lang.String r1 = r6.f12955c
            r0.append(r1)
        L_0x004b:
            r1 = 64
            r0.append(r1)
        L_0x0050:
            java.lang.String r1 = r6.f12956d
            if (r1 == 0) goto L_0x006f
            boolean r1 = fb.y.o(r1, r4)
            if (r1 == 0) goto L_0x006a
            r1 = 91
            r0.append(r1)
            java.lang.String r1 = r6.f12956d
            r0.append(r1)
            r1 = 93
            r0.append(r1)
            goto L_0x006f
        L_0x006a:
            java.lang.String r1 = r6.f12956d
            r0.append(r1)
        L_0x006f:
            int r1 = r6.f12957e
            r3 = -1
            if (r1 != r3) goto L_0x0078
            java.lang.String r5 = r6.f12953a
            if (r5 == 0) goto L_0x009e
        L_0x0078:
            if (r1 == r3) goto L_0x007b
            goto L_0x0089
        L_0x007b:
            pb.s0 r1 = pb.t0.f12987k
            java.lang.String r3 = r6.f12953a
            xa.j.c(r3)
            r1.getClass()
            int r1 = pb.s0.b(r3)
        L_0x0089:
            java.lang.String r3 = r6.f12953a
            if (r3 == 0) goto L_0x0098
            pb.s0 r5 = pb.t0.f12987k
            r5.getClass()
            int r3 = pb.s0.b(r3)
            if (r1 == r3) goto L_0x009e
        L_0x0098:
            r0.append(r4)
            r0.append(r1)
        L_0x009e:
            pb.s0 r1 = pb.t0.f12987k
            java.util.ArrayList r3 = r6.f12958f
            r1.getClass()
            java.lang.String r1 = "<this>"
            xa.j.f(r1, r3)
            int r1 = r3.size()
        L_0x00ae:
            if (r2 >= r1) goto L_0x00c1
            r4 = 47
            r0.append(r4)
            java.lang.Object r4 = r3.get(r2)
            java.lang.String r4 = (java.lang.String) r4
            r0.append(r4)
            int r2 = r2 + 1
            goto L_0x00ae
        L_0x00c1:
            java.util.ArrayList r1 = r6.f12959g
            if (r1 == 0) goto L_0x00d7
            r1 = 63
            r0.append(r1)
            pb.s0 r1 = pb.t0.f12987k
            java.util.ArrayList r2 = r6.f12959g
            xa.j.c(r2)
            r1.getClass()
            pb.s0.f(r2, r0)
        L_0x00d7:
            java.lang.String r1 = r6.f12960h
            if (r1 == 0) goto L_0x00e5
            r1 = 35
            r0.append(r1)
            java.lang.String r1 = r6.f12960h
            r0.append(r1)
        L_0x00e5:
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            xa.j.e(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pb.r0.toString():java.lang.String");
    }
}
