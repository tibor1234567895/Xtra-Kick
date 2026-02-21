package a3;

import c9.h;
import j1.b0;
import j1.l0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w2.c;

public final class a extends c {

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f95r = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: m  reason: collision with root package name */
    public final boolean f96m;

    /* renamed from: n  reason: collision with root package name */
    public final b f97n;

    /* renamed from: o  reason: collision with root package name */
    public LinkedHashMap f98o;

    /* renamed from: p  reason: collision with root package name */
    public float f99p;

    /* renamed from: q  reason: collision with root package name */
    public float f100q;

    public a() {
        this((List) null);
    }

    public static int i(long j10, ArrayList arrayList, ArrayList arrayList2) {
        int i10;
        ArrayList arrayList3;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (((Long) arrayList.get(size)).longValue() != j10) {
                    if (((Long) arrayList.get(size)).longValue() < j10) {
                        i10 = size + 1;
                        break;
                    }
                } else {
                    return size;
                }
            } else {
                i10 = 0;
                break;
            }
        }
        arrayList.add(i10, Long.valueOf(j10));
        if (i10 != 0) {
            arrayList3 = new ArrayList((Collection) arrayList2.get(i10 - 1));
        }
        arrayList2.add(i10, arrayList3);
        return i10;
    }

    public static long k(String str) {
        Matcher matcher = f95r.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i10 = l0.f8453a;
        long parseLong = (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(group) * 60 * 60 * 1000000);
        return (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(3)) * 1000000) + parseLong;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01f8, code lost:
        switch(r12) {
            case -1: goto L_0x0205;
            case 0: goto L_0x01fb;
            case 1: goto L_0x0203;
            case 2: goto L_0x0201;
            case 3: goto L_0x01ff;
            case 4: goto L_0x0203;
            case com.iheartradio.m3u8.Constants.MAX_COMPATIBILITY_VERSION :int: goto L_0x0201;
            case 6: goto L_0x01ff;
            case 7: goto L_0x0203;
            case 8: goto L_0x0201;
            case 9: goto L_0x01ff;
            default: goto L_0x01fb;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01fb, code lost:
        android.support.v4.media.h.z("Unknown alignment: ", r12, "SsaDecoder");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ff, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0201, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0203, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0205, code lost:
        r6 = androidx.recyclerview.widget.RecyclerView.UNDEFINED_DURATION;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0207, code lost:
        r3.f7961i = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0209, code lost:
        switch(r12) {
            case -1: goto L_0x0215;
            case 0: goto L_0x020c;
            case 1: goto L_0x0214;
            case 2: goto L_0x0214;
            case 3: goto L_0x0214;
            case 4: goto L_0x0212;
            case com.iheartradio.m3u8.Constants.MAX_COMPATIBILITY_VERSION :int: goto L_0x0212;
            case 6: goto L_0x0212;
            case 7: goto L_0x0210;
            case 8: goto L_0x0210;
            case 9: goto L_0x0210;
            default: goto L_0x020c;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x020c, code lost:
        android.support.v4.media.h.z("Unknown alignment: ", r12, "SsaDecoder");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0210, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0212, code lost:
        r5 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0214, code lost:
        r5 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0215, code lost:
        r3.f7959g = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0217, code lost:
        if (r15 == null) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x021b, code lost:
        if (r7 == -3.4028235E38f) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x021f, code lost:
        if (r4 == -3.4028235E38f) goto L_0x022a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0221, code lost:
        r3.f7960h = r15.x / r4;
        r0 = r15.y / r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022a, code lost:
        r0 = r3.f7961i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022e, code lost:
        if (r0 == 0) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0230, code lost:
        if (r0 == 1) goto L_0x023c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0232, code lost:
        if (r0 == 2) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0234, code lost:
        r0 = -3.4028235E38f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0238, code lost:
        r0 = 0.95f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x023c, code lost:
        r0 = 0.5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x023f, code lost:
        r0 = 0.05f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0242, code lost:
        r3.f7960h = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0244, code lost:
        if (r5 == 0) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0246, code lost:
        if (r5 == 1) goto L_0x024f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0248, code lost:
        if (r5 == 2) goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x024b, code lost:
        r17 = 0.95f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x024f, code lost:
        r17 = 0.5f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0252, code lost:
        r17 = 0.05f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0255, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0257, code lost:
        r3.f7957e = r0;
        r3.f7958f = 0;
        r0 = r3.a();
        r3 = i(r9, r2, r1);
        r4 = i(r18, r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x026a, code lost:
        if (r3 >= r4) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x026c, code lost:
        ((java.util.List) r1.get(r3)).add(r0);
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f3, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01f4, code lost:
        r3.f7955c = r5;
        r5 = androidx.recyclerview.widget.RecyclerView.UNDEFINED_DURATION;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final w2.d f(byte[] r21, int r22, boolean r23) {
        /*
            r20 = this;
            r0 = r20
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            j1.b0 r3 = new j1.b0
            r4 = r21
            r5 = r22
            r3.<init>(r5, r4)
            java.nio.charset.Charset r4 = r3.C()
            if (r4 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            java.nio.charset.Charset r4 = c9.h.f3035c
        L_0x001e:
            boolean r5 = r0.f96m
            if (r5 != 0) goto L_0x0025
            r0.j(r3, r4)
        L_0x0025:
            if (r5 == 0) goto L_0x002a
            a3.b r5 = r0.f97n
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            java.lang.String r6 = r3.h(r4)
            if (r6 == 0) goto L_0x0288
            java.lang.String r7 = "Format:"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x003e
            a3.b r5 = a3.b.a(r6)
            goto L_0x002b
        L_0x003e:
            java.lang.String r7 = "Dialogue:"
            boolean r8 = r6.startsWith(r7)
            if (r8 == 0) goto L_0x0278
            java.lang.String r8 = "SsaDecoder"
            if (r5 != 0) goto L_0x0055
            java.lang.String r7 = "Skipping dialogue line before complete format: "
            java.lang.String r6 = r7.concat(r6)
            j1.v.g(r8, r6)
            goto L_0x0278
        L_0x0055:
            boolean r7 = r6.startsWith(r7)
            j1.a.b(r7)
            r7 = 9
            java.lang.String r7 = r6.substring(r7)
            java.lang.String r9 = ","
            int r10 = r5.f105e
            java.lang.String[] r7 = r7.split(r9, r10)
            int r9 = r7.length
            if (r9 == r10) goto L_0x0070
            java.lang.String r7 = "Skipping dialogue line with fewer columns than format: "
            goto L_0x0090
        L_0x0070:
            int r9 = r5.f101a
            r9 = r7[r9]
            long r9 = k(r9)
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0082
            goto L_0x008e
        L_0x0082:
            int r13 = r5.f102b
            r13 = r7[r13]
            long r13 = k(r13)
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x0099
        L_0x008e:
            java.lang.String r7 = "Skipping invalid timing: "
        L_0x0090:
            java.lang.String r6 = r7.concat(r6)
            j1.v.g(r8, r6)
            goto L_0x0278
        L_0x0099:
            java.util.LinkedHashMap r6 = r0.f98o
            r11 = -1
            if (r6 == 0) goto L_0x00af
            int r12 = r5.f103c
            if (r12 == r11) goto L_0x00af
            r11 = r7[r12]
            java.lang.String r11 = r11.trim()
            java.lang.Object r6 = r6.get(r11)
            a3.e r6 = (a3.e) r6
            goto L_0x00b0
        L_0x00af:
            r6 = 0
        L_0x00b0:
            int r11 = r5.f104d
            r7 = r7[r11]
            java.util.regex.Pattern r11 = a3.d.f117a
            java.util.regex.Matcher r11 = r11.matcher(r7)
            r12 = -1
            r15 = 0
        L_0x00bc:
            boolean r16 = r11.find()
            r23 = r3
            r3 = 1
            if (r16 == 0) goto L_0x00ff
            java.lang.String r3 = r11.group(r3)
            r3.getClass()
            android.graphics.PointF r16 = a3.d.a(r3)     // Catch:{ RuntimeException -> 0x00d4 }
            if (r16 == 0) goto L_0x00d4
            r15 = r16
        L_0x00d4:
            r16 = r4
            java.util.regex.Pattern r4 = a3.d.f120d     // Catch:{ RuntimeException -> 0x00f9 }
            java.util.regex.Matcher r3 = r4.matcher(r3)     // Catch:{ RuntimeException -> 0x00f9 }
            boolean r4 = r3.find()     // Catch:{ RuntimeException -> 0x00f9 }
            if (r4 == 0) goto L_0x00ef
            r4 = 1
            java.lang.String r3 = r3.group(r4)     // Catch:{ RuntimeException -> 0x00f9 }
            r3.getClass()     // Catch:{ RuntimeException -> 0x00f9 }
            int r3 = a3.e.a(r3)     // Catch:{ RuntimeException -> 0x00f9 }
            goto L_0x00f0
        L_0x00ef:
            r3 = -1
        L_0x00f0:
            r4 = -1
            if (r3 == r4) goto L_0x00fa
            r12 = r3
            r4 = r16
            r3 = r23
            goto L_0x00bc
        L_0x00f9:
        L_0x00fa:
            r3 = r23
            r4 = r16
            goto L_0x00bc
        L_0x00ff:
            r16 = r4
            a3.d r3 = new a3.d
            java.util.regex.Pattern r3 = a3.d.f117a
            java.util.regex.Matcher r3 = r3.matcher(r7)
            java.lang.String r4 = ""
            java.lang.String r3 = r3.replaceAll(r4)
            java.lang.String r4 = "\\N"
            java.lang.String r7 = "\n"
            java.lang.String r3 = r3.replace(r4, r7)
            java.lang.String r4 = "\\n"
            java.lang.String r3 = r3.replace(r4, r7)
            java.lang.String r4 = "\\h"
            java.lang.String r7 = " "
            java.lang.String r3 = r3.replace(r4, r7)
            float r4 = r0.f99p
            float r7 = r0.f100q
            android.text.SpannableString r11 = new android.text.SpannableString
            r11.<init>(r3)
            i1.a r3 = new i1.a
            r3.<init>()
            r3.f7953a = r11
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            if (r6 == 0) goto L_0x01d3
            java.lang.Integer r0 = r6.f123c
            r21 = r5
            if (r0 == 0) goto L_0x0156
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            int r0 = r0.intValue()
            r5.<init>(r0)
            int r0 = r11.length()
            r18 = r13
            r13 = 33
            r14 = 0
            r11.setSpan(r5, r14, r0, r13)
            goto L_0x0158
        L_0x0156:
            r18 = r13
        L_0x0158:
            int r0 = r6.f130j
            r5 = 3
            if (r0 != r5) goto L_0x0174
            java.lang.Integer r0 = r6.f124d
            if (r0 == 0) goto L_0x0174
            android.text.style.BackgroundColorSpan r13 = new android.text.style.BackgroundColorSpan
            int r0 = r0.intValue()
            r13.<init>(r0)
            int r0 = r11.length()
            r14 = 33
            r5 = 0
            r11.setSpan(r13, r5, r0, r14)
        L_0x0174:
            float r0 = r6.f125e
            int r5 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x0184
            int r5 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x0184
            float r0 = r0 / r7
            r3.f7963k = r0
            r0 = 1
            r3.f7962j = r0
        L_0x0184:
            boolean r0 = r6.f127g
            boolean r5 = r6.f126f
            if (r5 == 0) goto L_0x0193
            if (r0 == 0) goto L_0x0193
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r5 = 3
            r0.<init>(r5)
            goto L_0x01a4
        L_0x0193:
            if (r5 == 0) goto L_0x019c
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r5 = 1
            r0.<init>(r5)
            goto L_0x01a4
        L_0x019c:
            if (r0 == 0) goto L_0x01af
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan
            r5 = 2
            r0.<init>(r5)
        L_0x01a4:
            int r5 = r11.length()
            r13 = 33
            r14 = 0
            r11.setSpan(r0, r14, r5, r13)
            goto L_0x01b2
        L_0x01af:
            r13 = 33
            r14 = 0
        L_0x01b2:
            boolean r0 = r6.f128h
            if (r0 == 0) goto L_0x01c2
            android.text.style.UnderlineSpan r0 = new android.text.style.UnderlineSpan
            r0.<init>()
            int r5 = r11.length()
            r11.setSpan(r0, r14, r5, r13)
        L_0x01c2:
            boolean r0 = r6.f129i
            if (r0 == 0) goto L_0x01d7
            android.text.style.StrikethroughSpan r0 = new android.text.style.StrikethroughSpan
            r0.<init>()
            int r5 = r11.length()
            r11.setSpan(r0, r14, r5, r13)
            goto L_0x01d7
        L_0x01d3:
            r21 = r5
            r18 = r13
        L_0x01d7:
            r0 = -1
            if (r12 == r0) goto L_0x01db
            goto L_0x01e1
        L_0x01db:
            if (r6 == 0) goto L_0x01e0
            int r12 = r6.f122b
            goto L_0x01e1
        L_0x01e0:
            r12 = -1
        L_0x01e1:
            java.lang.String r0 = "Unknown alignment: "
            switch(r12) {
                case -1: goto L_0x01f3;
                case 0: goto L_0x01e6;
                case 1: goto L_0x01f0;
                case 2: goto L_0x01ed;
                case 3: goto L_0x01ea;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01ed;
                case 6: goto L_0x01ea;
                case 7: goto L_0x01f0;
                case 8: goto L_0x01ed;
                case 9: goto L_0x01ea;
                default: goto L_0x01e6;
            }
        L_0x01e6:
            android.support.v4.media.h.z(r0, r12, r8)
            goto L_0x01f3
        L_0x01ea:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x01f4
        L_0x01ed:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x01f4
        L_0x01f0:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            goto L_0x01f4
        L_0x01f3:
            r5 = 0
        L_0x01f4:
            r3.f7955c = r5
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            switch(r12) {
                case -1: goto L_0x0205;
                case 0: goto L_0x01fb;
                case 1: goto L_0x0203;
                case 2: goto L_0x0201;
                case 3: goto L_0x01ff;
                case 4: goto L_0x0203;
                case 5: goto L_0x0201;
                case 6: goto L_0x01ff;
                case 7: goto L_0x0203;
                case 8: goto L_0x0201;
                case 9: goto L_0x01ff;
                default: goto L_0x01fb;
            }
        L_0x01fb:
            android.support.v4.media.h.z(r0, r12, r8)
            goto L_0x0205
        L_0x01ff:
            r6 = 2
            goto L_0x0207
        L_0x0201:
            r6 = 1
            goto L_0x0207
        L_0x0203:
            r6 = 0
            goto L_0x0207
        L_0x0205:
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0207:
            r3.f7961i = r6
            switch(r12) {
                case -1: goto L_0x0215;
                case 0: goto L_0x020c;
                case 1: goto L_0x0214;
                case 2: goto L_0x0214;
                case 3: goto L_0x0214;
                case 4: goto L_0x0212;
                case 5: goto L_0x0212;
                case 6: goto L_0x0212;
                case 7: goto L_0x0210;
                case 8: goto L_0x0210;
                case 9: goto L_0x0210;
                default: goto L_0x020c;
            }
        L_0x020c:
            android.support.v4.media.h.z(r0, r12, r8)
            goto L_0x0215
        L_0x0210:
            r5 = 0
            goto L_0x0215
        L_0x0212:
            r5 = 1
            goto L_0x0215
        L_0x0214:
            r5 = 2
        L_0x0215:
            r3.f7959g = r5
            if (r15 == 0) goto L_0x022a
            int r0 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x022a
            int r0 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x022a
            float r0 = r15.x
            float r0 = r0 / r4
            r3.f7960h = r0
            float r0 = r15.y
            float r0 = r0 / r7
            goto L_0x0257
        L_0x022a:
            int r0 = r3.f7961i
            r4 = 1
            r6 = 2
            if (r0 == 0) goto L_0x023f
            if (r0 == r4) goto L_0x023c
            if (r0 == r6) goto L_0x0238
            r0 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            goto L_0x0242
        L_0x0238:
            r0 = 1064514355(0x3f733333, float:0.95)
            goto L_0x0242
        L_0x023c:
            r0 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0242
        L_0x023f:
            r0 = 1028443341(0x3d4ccccd, float:0.05)
        L_0x0242:
            r3.f7960h = r0
            if (r5 == 0) goto L_0x0252
            if (r5 == r4) goto L_0x024f
            if (r5 == r6) goto L_0x024b
            goto L_0x0255
        L_0x024b:
            r17 = 1064514355(0x3f733333, float:0.95)
            goto L_0x0255
        L_0x024f:
            r17 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0255
        L_0x0252:
            r17 = 1028443341(0x3d4ccccd, float:0.05)
        L_0x0255:
            r0 = r17
        L_0x0257:
            r3.f7957e = r0
            r0 = 0
            r3.f7958f = r0
            i1.b r0 = r3.a()
            int r3 = i(r9, r2, r1)
            r4 = r18
            int r4 = i(r4, r2, r1)
        L_0x026a:
            if (r3 >= r4) goto L_0x027e
            java.lang.Object r5 = r1.get(r3)
            java.util.List r5 = (java.util.List) r5
            r5.add(r0)
            int r3 = r3 + 1
            goto L_0x026a
        L_0x0278:
            r23 = r3
            r16 = r4
            r21 = r5
        L_0x027e:
            r0 = r20
            r5 = r21
            r3 = r23
            r4 = r16
            goto L_0x002b
        L_0x0288:
            a3.f r0 = new a3.f
            r3 = 0
            r0.<init>(r1, r3, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a.f(byte[], int, boolean):w2.d");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:141|142|143|(1:148)(1:147)|(2:150|153)|151|152|153) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:151:0x02b1 */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x024f A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0252 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0264 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0267 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0279 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x027c A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x028e A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0291 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0297 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02c5 A[Catch:{ RuntimeException -> 0x02cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(j1.b0 r39, java.nio.charset.Charset r40) {
        /*
            r38 = this;
            r1 = r38
            r2 = r39
        L_0x0004:
            java.lang.String r0 = r39.h(r40)
            if (r0 == 0) goto L_0x030b
            java.lang.String r3 = "[Script Info]"
            boolean r3 = r3.equalsIgnoreCase(r0)
            r4 = 91
            r5 = 2
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x006e
        L_0x0017:
            java.lang.String r0 = r39.h(r40)
            if (r0 == 0) goto L_0x0004
            int r3 = r2.f8416c
            int r8 = r2.f8415b
            int r3 = r3 - r8
            if (r3 == 0) goto L_0x002a
            char r3 = r39.b(r40)
            if (r3 == r4) goto L_0x0004
        L_0x002a:
            java.lang.String r3 = ":"
            java.lang.String[] r0 = r0.split(r3)
            int r3 = r0.length
            if (r3 == r5) goto L_0x0034
            goto L_0x0017
        L_0x0034:
            r3 = r0[r7]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = c9.b.a(r3)
            r3.getClass()
            java.lang.String r8 = "playresx"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x005f
            java.lang.String r8 = "playresy"
            boolean r3 = r3.equals(r8)
            if (r3 != 0) goto L_0x0052
            goto L_0x0017
        L_0x0052:
            r0 = r0[r6]     // Catch:{ NumberFormatException -> 0x006c }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x006c }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x006c }
            r1.f100q = r0     // Catch:{ NumberFormatException -> 0x006c }
            goto L_0x0017
        L_0x005f:
            r0 = r0[r6]     // Catch:{ NumberFormatException -> 0x006c }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x006c }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x006c }
            r1.f99p = r0     // Catch:{ NumberFormatException -> 0x006c }
            goto L_0x0017
        L_0x006c:
            goto L_0x0017
        L_0x006e:
            java.lang.String r3 = "[V4+ Styles]"
            boolean r3 = r3.equalsIgnoreCase(r0)
            java.lang.String r8 = "SsaDecoder"
            if (r3 == 0) goto L_0x02f4
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
        L_0x007d:
            r10 = 0
        L_0x007e:
            java.lang.String r11 = r39.h(r40)
            if (r11 == 0) goto L_0x02f0
            int r0 = r2.f8416c
            int r12 = r2.f8415b
            int r0 = r0 - r12
            if (r0 == 0) goto L_0x0091
            char r0 = r39.b(r40)
            if (r0 == r4) goto L_0x02f0
        L_0x0091:
            java.lang.String r0 = "Format:"
            boolean r0 = r11.startsWith(r0)
            r12 = 6
            r13 = 3
            r14 = -1
            java.lang.String r15 = ","
            if (r0 == 0) goto L_0x0186
            r0 = 7
            java.lang.String r10 = r11.substring(r0)
            java.lang.String[] r10 = android.text.TextUtils.split(r10, r15)
            r11 = 0
            r15 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            r20 = -1
            r21 = -1
            r22 = -1
            r23 = -1
            r24 = -1
            r25 = -1
        L_0x00bb:
            int r0 = r10.length
            if (r11 >= r0) goto L_0x016f
            r0 = r10[r11]
            java.lang.String r0 = r0.trim()
            java.lang.String r0 = c9.b.a(r0)
            r0.getClass()
            int r26 = r0.hashCode()
            switch(r26) {
                case -1178781136: goto L_0x013d;
                case -1026963764: goto L_0x0132;
                case -192095652: goto L_0x0127;
                case -70925746: goto L_0x011c;
                case 3029637: goto L_0x0111;
                case 3373707: goto L_0x0106;
                case 366554320: goto L_0x00fb;
                case 767321349: goto L_0x00f0;
                case 1767875043: goto L_0x00e2;
                case 1988365454: goto L_0x00d4;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            goto L_0x0148
        L_0x00d4:
            java.lang.String r4 = "outlinecolour"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00de
            goto L_0x0148
        L_0x00de:
            r0 = 9
            goto L_0x0149
        L_0x00e2:
            java.lang.String r4 = "alignment"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0148
        L_0x00ec:
            r0 = 8
            goto L_0x0149
        L_0x00f0:
            java.lang.String r4 = "borderstyle"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00f9
            goto L_0x0148
        L_0x00f9:
            r0 = 7
            goto L_0x0149
        L_0x00fb:
            java.lang.String r4 = "fontsize"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0104
            goto L_0x0148
        L_0x0104:
            r0 = 6
            goto L_0x0149
        L_0x0106:
            java.lang.String r4 = "name"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x010f
            goto L_0x0148
        L_0x010f:
            r0 = 5
            goto L_0x0149
        L_0x0111:
            java.lang.String r4 = "bold"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x011a
            goto L_0x0148
        L_0x011a:
            r0 = 4
            goto L_0x0149
        L_0x011c:
            java.lang.String r4 = "primarycolour"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0125
            goto L_0x0148
        L_0x0125:
            r0 = 3
            goto L_0x0149
        L_0x0127:
            java.lang.String r4 = "strikeout"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0130
            goto L_0x0148
        L_0x0130:
            r0 = 2
            goto L_0x0149
        L_0x0132:
            java.lang.String r4 = "underline"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x013b
            goto L_0x0148
        L_0x013b:
            r0 = 1
            goto L_0x0149
        L_0x013d:
            java.lang.String r4 = "italic"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r0 = 0
            goto L_0x0149
        L_0x0148:
            r0 = -1
        L_0x0149:
            switch(r0) {
                case 0: goto L_0x0167;
                case 1: goto L_0x0164;
                case 2: goto L_0x0161;
                case 3: goto L_0x015e;
                case 4: goto L_0x015b;
                case 5: goto L_0x0159;
                case 6: goto L_0x0156;
                case 7: goto L_0x0153;
                case 8: goto L_0x0150;
                case 9: goto L_0x014d;
                default: goto L_0x014c;
            }
        L_0x014c:
            goto L_0x0169
        L_0x014d:
            r19 = r11
            goto L_0x0169
        L_0x0150:
            r17 = r11
            goto L_0x0169
        L_0x0153:
            r25 = r11
            goto L_0x0169
        L_0x0156:
            r20 = r11
            goto L_0x0169
        L_0x0159:
            r15 = r11
            goto L_0x0169
        L_0x015b:
            r21 = r11
            goto L_0x0169
        L_0x015e:
            r18 = r11
            goto L_0x0169
        L_0x0161:
            r24 = r11
            goto L_0x0169
        L_0x0164:
            r23 = r11
            goto L_0x0169
        L_0x0167:
            r22 = r11
        L_0x0169:
            int r11 = r11 + 1
            r4 = 91
            goto L_0x00bb
        L_0x016f:
            if (r15 == r14) goto L_0x0182
            a3.c r0 = new a3.c
            int r4 = r10.length
            r14 = r15
            r15 = r0
            r16 = r14
            r26 = r4
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r10 = r0
            r4 = 91
            goto L_0x007e
        L_0x0182:
            r4 = 91
            goto L_0x007d
        L_0x0186:
            java.lang.String r0 = "Style:"
            boolean r4 = r11.startsWith(r0)
            if (r4 == 0) goto L_0x02ea
            if (r10 != 0) goto L_0x019b
            java.lang.String r0 = "Skipping 'Style:' line before 'Format:' line: "
            java.lang.String r0 = r0.concat(r11)
            j1.v.g(r8, r0)
            goto L_0x02ea
        L_0x019b:
            java.lang.String r4 = "'"
            boolean r0 = r11.startsWith(r0)
            j1.a.b(r0)
            java.lang.String r0 = r11.substring(r12)
            java.lang.String[] r12 = android.text.TextUtils.split(r0, r15)
            int r0 = r12.length
            int r15 = r10.f116k
            java.lang.String r9 = "SsaStyle"
            if (r0 == r15) goto L_0x01cf
            java.lang.Object[] r0 = new java.lang.Object[r13]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0[r7] = r4
            int r4 = r12.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0[r6] = r4
            r0[r5] = r11
            java.lang.String r4 = "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'"
            java.lang.String r0 = j1.l0.l(r4, r0)
            j1.v.g(r9, r0)
            goto L_0x02e2
        L_0x01cf:
            a3.e r15 = new a3.e     // Catch:{ RuntimeException -> 0x02cd }
            int r0 = r10.f106a     // Catch:{ RuntimeException -> 0x02cd }
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r28 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            int r0 = r10.f107b     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x01ea
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            int r0 = a3.e.a(r0)     // Catch:{ RuntimeException -> 0x02cd }
            r29 = r0
            goto L_0x01ec
        L_0x01ea:
            r29 = -1
        L_0x01ec:
            int r0 = r10.f108c     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x01fd
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.Integer r0 = a3.e.c(r0)     // Catch:{ RuntimeException -> 0x02cd }
            r30 = r0
            goto L_0x01ff
        L_0x01fd:
            r30 = 0
        L_0x01ff:
            int r0 = r10.f109d     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x0210
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.Integer r0 = a3.e.c(r0)     // Catch:{ RuntimeException -> 0x02cd }
            r31 = r0
            goto L_0x0212
        L_0x0210:
            r31 = 0
        L_0x0212:
            int r0 = r10.f110e     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x0239
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r5 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            float r0 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x0223 }
            r32 = r0
            goto L_0x023f
        L_0x0223:
            r0 = move-exception
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r13 = "Failed to parse font size: '"
            r0.<init>(r13)     // Catch:{ RuntimeException -> 0x02cd }
            r0.append(r5)     // Catch:{ RuntimeException -> 0x02cd }
            r0.append(r4)     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.toString()     // Catch:{ RuntimeException -> 0x02cd }
            j1.v.h(r9, r0, r7)     // Catch:{ RuntimeException -> 0x02cd }
        L_0x0239:
            r0 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r32 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x023f:
            int r0 = r10.f111f     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x0252
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            boolean r0 = a3.e.b(r0)     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == 0) goto L_0x0252
            r33 = 1
            goto L_0x0254
        L_0x0252:
            r33 = 0
        L_0x0254:
            int r0 = r10.f112g     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x0267
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            boolean r0 = a3.e.b(r0)     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == 0) goto L_0x0267
            r34 = 1
            goto L_0x0269
        L_0x0267:
            r34 = 0
        L_0x0269:
            int r0 = r10.f113h     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x027c
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            boolean r0 = a3.e.b(r0)     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == 0) goto L_0x027c
            r35 = 1
            goto L_0x027e
        L_0x027c:
            r35 = 0
        L_0x027e:
            int r0 = r10.f114i     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x0291
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            boolean r0 = a3.e.b(r0)     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == 0) goto L_0x0291
            r36 = 1
            goto L_0x0293
        L_0x0291:
            r36 = 0
        L_0x0293:
            int r0 = r10.f115j     // Catch:{ RuntimeException -> 0x02cd }
            if (r0 == r14) goto L_0x02c5
            r0 = r12[r0]     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r0.trim()     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r5 = r0.trim()     // Catch:{ NumberFormatException -> 0x02b1 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x02b1 }
            if (r5 == r6) goto L_0x02ac
            r7 = 3
            if (r5 == r7) goto L_0x02ac
            r7 = 0
            goto L_0x02ad
        L_0x02ac:
            r7 = 1
        L_0x02ad:
            if (r7 == 0) goto L_0x02b1
            r14 = r5
            goto L_0x02c2
        L_0x02b1:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r7 = "Ignoring unknown BorderStyle: "
            r5.<init>(r7)     // Catch:{ RuntimeException -> 0x02cd }
            r5.append(r0)     // Catch:{ RuntimeException -> 0x02cd }
            java.lang.String r0 = r5.toString()     // Catch:{ RuntimeException -> 0x02cd }
            j1.v.g(r9, r0)     // Catch:{ RuntimeException -> 0x02cd }
        L_0x02c2:
            r37 = r14
            goto L_0x02c7
        L_0x02c5:
            r37 = -1
        L_0x02c7:
            r27 = r15
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ RuntimeException -> 0x02cd }
            goto L_0x02e3
        L_0x02cd:
            r0 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Skipping malformed 'Style:' line: '"
            r5.<init>(r7)
            r5.append(r11)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            j1.v.h(r9, r4, r0)
        L_0x02e2:
            r15 = 0
        L_0x02e3:
            if (r15 == 0) goto L_0x02ea
            java.lang.String r0 = r15.f121a
            r3.put(r0, r15)
        L_0x02ea:
            r4 = 91
            r5 = 2
            r7 = 0
            goto L_0x007e
        L_0x02f0:
            r1.f98o = r3
            goto L_0x0004
        L_0x02f4:
            java.lang.String r3 = "[V4 Styles]"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L_0x0303
            java.lang.String r0 = "[V4 Styles] are not supported"
            j1.v.f(r8, r0)
            goto L_0x0004
        L_0x0303:
            java.lang.String r3 = "[Events]"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0004
        L_0x030b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.a.j(j1.b0, java.nio.charset.Charset):void");
    }

    public a(List list) {
        this.f99p = -3.4028235E38f;
        this.f100q = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f96m = false;
            this.f97n = null;
            return;
        }
        this.f96m = true;
        int i10 = l0.f8453a;
        Charset charset = h.f3035c;
        String str = new String((byte[]) list.get(0), charset);
        j1.a.b(str.startsWith("Format:"));
        b a10 = b.a(str);
        a10.getClass();
        this.f97n = a10;
        j(new b0((byte[]) list.get(1)), charset);
    }
}
