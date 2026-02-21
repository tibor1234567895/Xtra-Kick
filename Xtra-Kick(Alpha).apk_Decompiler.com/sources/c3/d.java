package c3;

import android.support.v4.media.h;
import android.text.Layout;
import androidx.recyclerview.widget.RecyclerView;
import c9.b;
import j1.l0;
import j1.m0;
import j1.v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m0.x;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import w2.c;
import w2.f;

public final class d extends c {

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f2808n = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f2809o = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f2810p = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: q  reason: collision with root package name */
    public static final Pattern f2811q = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f2812r = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f2813s = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f2814t = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: u  reason: collision with root package name */
    public static final c f2815u = new c(1, 30.0f, 1);

    /* renamed from: v  reason: collision with root package name */
    public static final x f2816v = new x(32, 15);

    /* renamed from: m  reason: collision with root package name */
    public final XmlPullParserFactory f2817m;

    public d() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f2817m = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    public static h i(h hVar) {
        return hVar == null ? new h() : hVar;
    }

    public static boolean j(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static Layout.Alignment k(String str) {
        String a10 = b.a(str);
        a10.getClass();
        char c10 = 65535;
        switch (a10.hashCode()) {
            case -1364013995:
                if (a10.equals("center")) {
                    c10 = 0;
                    break;
                }
                break;
            case 100571:
                if (a10.equals("end")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3317767:
                if (a10.equals("left")) {
                    c10 = 2;
                    break;
                }
                break;
            case 108511772:
                if (a10.equals("right")) {
                    c10 = 3;
                    break;
                }
                break;
            case 109757538:
                if (a10.equals("start")) {
                    c10 = 4;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    public static x l(XmlPullParser xmlPullParser, x xVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return xVar;
        }
        Matcher matcher = f2814t.matcher(attributeValue);
        if (matcher.matches()) {
            try {
                String group = matcher.group(1);
                group.getClass();
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                group2.getClass();
                int parseInt2 = Integer.parseInt(group2);
                if (parseInt != 0 && parseInt2 != 0) {
                    return new x(parseInt, parseInt2);
                }
                throw new f("Invalid cell resolution " + parseInt + " " + parseInt2);
            } catch (NumberFormatException unused) {
            }
        }
        v.g("TtmlDecoder", "Ignoring malformed cell resolution: ".concat(attributeValue));
        return xVar;
    }

    public static void m(String str, h hVar) {
        Matcher matcher;
        int i10 = l0.f8453a;
        String[] split = str.split("\\s+", -1);
        int length = split.length;
        Pattern pattern = f2810p;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else if (split.length == 2) {
            matcher = pattern.matcher(split[1]);
            v.g("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new f(h.o(new StringBuilder("Invalid number of entries for fontSize: "), split.length, "."));
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.getClass();
            group.hashCode();
            char c10 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c10 = 2;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    hVar.f2850j = 3;
                    break;
                case 1:
                    hVar.f2850j = 2;
                    break;
                case 2:
                    hVar.f2850j = 1;
                    break;
                default:
                    throw new f(h.n("Invalid unit for fontSize: '", group, "'."));
            }
            String group2 = matcher.group(1);
            group2.getClass();
            hVar.f2851k = Float.parseFloat(group2);
            return;
        }
        throw new f(h.n("Invalid expression for fontSize: '", str, "'."));
    }

    public static c n(XmlPullParser xmlPullParser) {
        int i10;
        float f10;
        int i11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        if (attributeValue != null) {
            i10 = Integer.parseInt(attributeValue);
        } else {
            i10 = 30;
        }
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i12 = l0.f8453a;
            String[] split = attributeValue2.split(" ", -1);
            if (split.length == 2) {
                f10 = ((float) Integer.parseInt(split[0])) / ((float) Integer.parseInt(split[1]));
            } else {
                throw new f("frameRateMultiplier doesn't have 2 parts");
            }
        } else {
            f10 = 1.0f;
        }
        c cVar = f2815u;
        int i13 = cVar.f2806b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i13 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i11 = Integer.parseInt(attributeValue4);
        } else {
            i11 = cVar.f2807c;
        }
        return new c(i13, ((float) i10) * f10, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void o(org.xmlpull.v1.XmlPullParser r20, java.util.HashMap r21, m0.x r22, m0.x r23, java.util.HashMap r24, java.util.HashMap r25) {
        /*
            r0 = r20
            r1 = r21
            r2 = r23
        L_0x0006:
            r20.next()
            java.lang.String r3 = "style"
            boolean r4 = j1.m0.c(r0, r3)
            r5 = -1
            r6 = 0
            if (r4 == 0) goto L_0x0053
            java.lang.String r3 = j1.m0.a(r0, r3)
            c3.h r4 = new c3.h
            r4.<init>()
            c3.h r4 = q(r0, r4)
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = r3.trim()
            boolean r7 = r3.isEmpty()
            if (r7 == 0) goto L_0x002f
            java.lang.String[] r3 = new java.lang.String[r6]
            goto L_0x0037
        L_0x002f:
            int r7 = j1.l0.f8453a
            java.lang.String r7 = "\\s+"
            java.lang.String[] r3 = r3.split(r7, r5)
        L_0x0037:
            int r5 = r3.length
        L_0x0038:
            if (r6 >= r5) goto L_0x0048
            r7 = r3[r6]
            java.lang.Object r7 = r1.get(r7)
            c3.h r7 = (c3.h) r7
            r4.a(r7)
            int r6 = r6 + 1
            goto L_0x0038
        L_0x0048:
            java.lang.String r3 = r4.f2852l
            if (r3 == 0) goto L_0x004f
            r1.put(r3, r4)
        L_0x004f:
            r6 = r24
            goto L_0x021a
        L_0x0053:
            java.lang.String r3 = "region"
            boolean r3 = j1.m0.c(r0, r3)
            java.lang.String r4 = "id"
            if (r3 == 0) goto L_0x01ec
            java.lang.String r8 = j1.m0.a(r0, r4)
            if (r8 != 0) goto L_0x0065
            goto L_0x01e1
        L_0x0065:
            java.lang.String r3 = "origin"
            java.lang.String r3 = j1.m0.a(r0, r3)
            if (r3 == 0) goto L_0x01da
            java.util.regex.Pattern r4 = f2812r
            java.util.regex.Matcher r7 = r4.matcher(r3)
            java.util.regex.Pattern r9 = f2813s
            java.util.regex.Matcher r10 = r9.matcher(r3)
            boolean r11 = r7.matches()
            r12 = 2
            r13 = 1
            r14 = 1120403456(0x42c80000, float:100.0)
            if (r11 == 0) goto L_0x009c
            java.lang.String r10 = r7.group(r13)     // Catch:{ NumberFormatException -> 0x01d0 }
            r10.getClass()     // Catch:{ NumberFormatException -> 0x01d0 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x01d0 }
            float r10 = r10 / r14
            java.lang.String r7 = r7.group(r12)     // Catch:{ NumberFormatException -> 0x01d0 }
            r7.getClass()     // Catch:{ NumberFormatException -> 0x01d0 }
            float r7 = java.lang.Float.parseFloat(r7)     // Catch:{ NumberFormatException -> 0x01d0 }
            float r7 = r7 / r14
            goto L_0x00ca
        L_0x009c:
            boolean r7 = r10.matches()
            if (r7 == 0) goto L_0x01d3
            if (r2 != 0) goto L_0x00a5
            goto L_0x0103
        L_0x00a5:
            java.lang.String r7 = r10.group(r13)     // Catch:{ NumberFormatException -> 0x01d0 }
            r7.getClass()     // Catch:{ NumberFormatException -> 0x01d0 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x01d0 }
            java.lang.String r10 = r10.group(r12)     // Catch:{ NumberFormatException -> 0x01d0 }
            r10.getClass()     // Catch:{ NumberFormatException -> 0x01d0 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01d0 }
            float r7 = (float) r7     // Catch:{ NumberFormatException -> 0x01d0 }
            int r11 = r2.f10157a     // Catch:{ NumberFormatException -> 0x01d0 }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x01d0 }
            float r7 = r7 / r11
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01d0 }
            int r11 = r2.f10158b     // Catch:{ NumberFormatException -> 0x01d0 }
            float r11 = (float) r11
            float r10 = r10 / r11
            r19 = r10
            r10 = r7
            r7 = r19
        L_0x00ca:
            java.lang.String r11 = "extent"
            java.lang.String r11 = j1.m0.a(r0, r11)
            if (r11 == 0) goto L_0x01cd
            java.util.regex.Matcher r4 = r4.matcher(r11)
            java.util.regex.Matcher r9 = r9.matcher(r11)
            boolean r11 = r4.matches()
            if (r11 == 0) goto L_0x00fb
            java.lang.String r9 = r4.group(r13)     // Catch:{ NumberFormatException -> 0x01c7 }
            r9.getClass()     // Catch:{ NumberFormatException -> 0x01c7 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x01c7 }
            float r9 = r9 / r14
            java.lang.String r4 = r4.group(r12)     // Catch:{ NumberFormatException -> 0x01c7 }
            r4.getClass()     // Catch:{ NumberFormatException -> 0x01c7 }
            float r3 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x01c7 }
            float r3 = r3 / r14
            r14 = r3
            r4 = r9
            goto L_0x0128
        L_0x00fb:
            boolean r4 = r9.matches()
            if (r4 == 0) goto L_0x01ca
            if (r2 != 0) goto L_0x0107
        L_0x0103:
            java.lang.String r4 = "Ignoring region with missing tts:extent: "
            goto L_0x01d5
        L_0x0107:
            java.lang.String r4 = r9.group(r13)     // Catch:{ NumberFormatException -> 0x01c7 }
            r4.getClass()     // Catch:{ NumberFormatException -> 0x01c7 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x01c7 }
            java.lang.String r9 = r9.group(r12)     // Catch:{ NumberFormatException -> 0x01c7 }
            r9.getClass()     // Catch:{ NumberFormatException -> 0x01c7 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x01c7 }
            float r4 = (float) r4     // Catch:{ NumberFormatException -> 0x01c7 }
            int r11 = r2.f10157a     // Catch:{ NumberFormatException -> 0x01c7 }
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x01c7 }
            float r4 = r4 / r11
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x01c7 }
            int r3 = r2.f10158b     // Catch:{ NumberFormatException -> 0x01c7 }
            float r3 = (float) r3
            float r9 = r9 / r3
            r14 = r9
        L_0x0128:
            java.lang.String r3 = "displayAlign"
            java.lang.String r3 = j1.m0.a(r0, r3)
            if (r3 == 0) goto L_0x0157
            java.lang.String r3 = c9.b.a(r3)
            r3.getClass()
            java.lang.String r9 = "center"
            boolean r9 = r3.equals(r9)
            if (r9 != 0) goto L_0x014e
            java.lang.String r9 = "after"
            boolean r3 = r3.equals(r9)
            if (r3 != 0) goto L_0x0148
            goto L_0x0157
        L_0x0148:
            float r7 = r7 + r14
            r11 = r22
            r3 = r7
            r15 = 2
            goto L_0x015b
        L_0x014e:
            r3 = 1073741824(0x40000000, float:2.0)
            float r3 = r14 / r3
            float r3 = r3 + r7
            r11 = r22
            r15 = 1
            goto L_0x015b
        L_0x0157:
            r11 = r22
            r3 = r7
            r15 = 0
        L_0x015b:
            int r7 = r11.f10158b
            float r7 = (float) r7
            r9 = 1065353216(0x3f800000, float:1.0)
            float r16 = r9 / r7
            java.lang.String r7 = "writingMode"
            java.lang.String r7 = j1.m0.a(r0, r7)
            if (r7 == 0) goto L_0x01b2
            java.lang.String r7 = c9.b.a(r7)
            r7.getClass()
            int r9 = r7.hashCode()
            r5 = 3694(0xe6e, float:5.176E-42)
            if (r9 == r5) goto L_0x019a
            r5 = 3553396(0x363874, float:4.979368E-39)
            if (r9 == r5) goto L_0x018f
            r5 = 3553576(0x363928, float:4.97962E-39)
            if (r9 == r5) goto L_0x0184
            goto L_0x01a2
        L_0x0184:
            java.lang.String r5 = "tbrl"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x018d
            goto L_0x01a2
        L_0x018d:
            r5 = 2
            goto L_0x01a5
        L_0x018f:
            java.lang.String r5 = "tblr"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x0198
            goto L_0x01a2
        L_0x0198:
            r5 = 1
            goto L_0x01a5
        L_0x019a:
            java.lang.String r5 = "tb"
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L_0x01a4
        L_0x01a2:
            r5 = -1
            goto L_0x01a5
        L_0x01a4:
            r5 = 0
        L_0x01a5:
            if (r5 == 0) goto L_0x01af
            if (r5 == r13) goto L_0x01af
            if (r5 == r12) goto L_0x01ac
            goto L_0x01b2
        L_0x01ac:
            r17 = 1
            goto L_0x01b6
        L_0x01af:
            r17 = 2
            goto L_0x01b6
        L_0x01b2:
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r17 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01b6:
            c3.f r5 = new c3.f
            r6 = 0
            r18 = 1
            r7 = r5
            r9 = r10
            r10 = r3
            r11 = r6
            r12 = r15
            r13 = r4
            r15 = r18
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x01e2
        L_0x01c7:
            java.lang.String r4 = "Ignoring region with malformed extent: "
            goto L_0x01d5
        L_0x01ca:
            java.lang.String r4 = "Ignoring region with unsupported extent: "
            goto L_0x01d5
        L_0x01cd:
            java.lang.String r3 = "Ignoring region without an extent"
            goto L_0x01dc
        L_0x01d0:
            java.lang.String r4 = "Ignoring region with malformed origin: "
            goto L_0x01d5
        L_0x01d3:
            java.lang.String r4 = "Ignoring region with unsupported origin: "
        L_0x01d5:
            java.lang.String r3 = r4.concat(r3)
            goto L_0x01dc
        L_0x01da:
            java.lang.String r3 = "Ignoring region without an origin"
        L_0x01dc:
            java.lang.String r4 = "TtmlDecoder"
            j1.v.g(r4, r3)
        L_0x01e1:
            r5 = 0
        L_0x01e2:
            if (r5 == 0) goto L_0x004f
            java.lang.String r3 = r5.f2831a
            r6 = r24
            r6.put(r3, r5)
            goto L_0x021a
        L_0x01ec:
            r6 = r24
            java.lang.String r3 = "metadata"
            boolean r5 = j1.m0.c(r0, r3)
            if (r5 == 0) goto L_0x021a
        L_0x01f6:
            r20.next()
            java.lang.String r5 = "image"
            boolean r5 = j1.m0.c(r0, r5)
            if (r5 == 0) goto L_0x0211
            java.lang.String r5 = j1.m0.a(r0, r4)
            if (r5 == 0) goto L_0x0211
            java.lang.String r7 = r20.nextText()
            r8 = r25
            r8.put(r5, r7)
            goto L_0x0213
        L_0x0211:
            r8 = r25
        L_0x0213:
            boolean r5 = j1.m0.b(r0, r3)
            if (r5 == 0) goto L_0x01f6
            goto L_0x021c
        L_0x021a:
            r8 = r25
        L_0x021c:
            java.lang.String r3 = "head"
            boolean r3 = j1.m0.b(r0, r3)
            if (r3 == 0) goto L_0x0006
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.o(org.xmlpull.v1.XmlPullParser, java.util.HashMap, m0.x, m0.x, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static c3.e p(org.xmlpull.v1.XmlPullParser r21, c3.e r22, java.util.HashMap r23, c3.c r24) {
        /*
            r0 = r21
            r11 = r22
            r1 = r24
            int r2 = r21.getAttributeCount()
            r3 = 0
            c3.h r7 = q(r0, r3)
            java.lang.String r4 = ""
            r10 = r3
            r13 = r10
            r12 = r4
            r3 = 0
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0024:
            if (r3 >= r2) goto L_0x00e0
            java.lang.String r4 = r0.getAttributeName(r3)
            java.lang.String r6 = r0.getAttributeValue(r3)
            r4.getClass()
            int r20 = r4.hashCode()
            r8 = 2
            r9 = 1
            switch(r20) {
                case -934795532: goto L_0x0072;
                case 99841: goto L_0x0067;
                case 100571: goto L_0x005c;
                case 93616297: goto L_0x0051;
                case 109780401: goto L_0x0046;
                case 1292595405: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x007d
        L_0x003b:
            java.lang.String r5 = "backgroundImage"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0044
            goto L_0x007d
        L_0x0044:
            r4 = 5
            goto L_0x007e
        L_0x0046:
            java.lang.String r5 = "style"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x004f
            goto L_0x007d
        L_0x004f:
            r4 = 4
            goto L_0x007e
        L_0x0051:
            java.lang.String r5 = "begin"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x005a
            goto L_0x007d
        L_0x005a:
            r4 = 3
            goto L_0x007e
        L_0x005c:
            java.lang.String r5 = "end"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0065
            goto L_0x007d
        L_0x0065:
            r4 = 2
            goto L_0x007e
        L_0x0067:
            java.lang.String r5 = "dur"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0070
            goto L_0x007d
        L_0x0070:
            r4 = 1
            goto L_0x007e
        L_0x0072:
            java.lang.String r5 = "region"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r4 = 0
            goto L_0x007e
        L_0x007d:
            r4 = -1
        L_0x007e:
            if (r4 == 0) goto L_0x00d2
            if (r4 == r9) goto L_0x00c8
            if (r4 == r8) goto L_0x00c0
            r5 = 3
            if (r4 == r5) goto L_0x00b9
            r5 = 4
            if (r4 == r5) goto L_0x009c
            r5 = 5
            if (r4 == r5) goto L_0x008e
            goto L_0x009a
        L_0x008e:
            java.lang.String r4 = "#"
            boolean r4 = r6.startsWith(r4)
            if (r4 == 0) goto L_0x009a
            java.lang.String r13 = r6.substring(r9)
        L_0x009a:
            r5 = 0
            goto L_0x00cf
        L_0x009c:
            java.lang.String r4 = r6.trim()
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x00aa
            r5 = 0
            java.lang.String[] r4 = new java.lang.String[r5]
            goto L_0x00b4
        L_0x00aa:
            r5 = 0
            int r6 = j1.l0.f8453a
            java.lang.String r6 = "\\s+"
            r8 = -1
            java.lang.String[] r4 = r4.split(r6, r8)
        L_0x00b4:
            int r6 = r4.length
            if (r6 <= 0) goto L_0x00cf
            r10 = r4
            goto L_0x00cf
        L_0x00b9:
            r5 = 0
            long r8 = r(r6, r1)
            r14 = r8
            goto L_0x00cf
        L_0x00c0:
            r5 = 0
            long r8 = r(r6, r1)
            r16 = r8
            goto L_0x00cf
        L_0x00c8:
            r5 = 0
            long r8 = r(r6, r1)
            r18 = r8
        L_0x00cf:
            r4 = r23
            goto L_0x00dc
        L_0x00d2:
            r4 = r23
            r5 = 0
            boolean r8 = r4.containsKey(r6)
            if (r8 == 0) goto L_0x00dc
            r12 = r6
        L_0x00dc:
            int r3 = r3 + 1
            goto L_0x0024
        L_0x00e0:
            if (r11 == 0) goto L_0x00f9
            long r1 = r11.f2821d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00fe
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00f2
            long r14 = r14 + r1
        L_0x00f2:
            int r5 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00fe
            long r16 = r16 + r1
            goto L_0x00fe
        L_0x00f9:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00fe:
            int r1 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0115
            int r1 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x010b
            long r18 = r14 + r18
            r5 = r18
            goto L_0x0117
        L_0x010b:
            if (r11 == 0) goto L_0x0115
            long r1 = r11.f2822e
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0115
            r5 = r1
            goto L_0x0117
        L_0x0115:
            r5 = r16
        L_0x0117:
            java.lang.String r1 = r21.getName()
            c3.e r16 = new c3.e
            r2 = 0
            r0 = r16
            r3 = r14
            r8 = r10
            r9 = r12
            r10 = r13
            r11 = r22
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.p(org.xmlpull.v1.XmlPullParser, c3.e, java.util.HashMap, c3.c):c3.e");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f5, code lost:
        if (r5.equals("auto") != false) goto L_0x01f9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ab  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static c3.h q(org.xmlpull.v1.XmlPullParser r16, c3.h r17) {
        /*
            r1 = r16
            int r2 = r16.getAttributeCount()
            r3 = 0
            r0 = r17
            r4 = 0
        L_0x000a:
            if (r4 >= r2) goto L_0x0487
            java.lang.String r5 = r1.getAttributeValue(r4)
            java.lang.String r6 = r1.getAttributeName(r4)
            r6.getClass()
            int r7 = r6.hashCode()
            r9 = 4
            r11 = -1
            r12 = 2
            r13 = 1
            switch(r7) {
                case -1550943582: goto L_0x00d3;
                case -1224696685: goto L_0x00c8;
                case -1065511464: goto L_0x00bd;
                case -879295043: goto L_0x00b2;
                case -734428249: goto L_0x00a7;
                case 3355: goto L_0x009c;
                case 3511770: goto L_0x0091;
                case 94842723: goto L_0x0086;
                case 109403361: goto L_0x0078;
                case 110138194: goto L_0x006a;
                case 365601008: goto L_0x005c;
                case 921125321: goto L_0x004e;
                case 1115953443: goto L_0x0040;
                case 1287124693: goto L_0x0032;
                case 1754920356: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x00de
        L_0x0024:
            java.lang.String r7 = "multiRowAlign"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x002e
            goto L_0x00de
        L_0x002e:
            r6 = 14
            goto L_0x00df
        L_0x0032:
            java.lang.String r7 = "backgroundColor"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x003c
            goto L_0x00de
        L_0x003c:
            r6 = 13
            goto L_0x00df
        L_0x0040:
            java.lang.String r7 = "rubyPosition"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x004a
            goto L_0x00de
        L_0x004a:
            r6 = 12
            goto L_0x00df
        L_0x004e:
            java.lang.String r7 = "textEmphasis"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0058
            goto L_0x00de
        L_0x0058:
            r6 = 11
            goto L_0x00df
        L_0x005c:
            java.lang.String r7 = "fontSize"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0066
            goto L_0x00de
        L_0x0066:
            r6 = 10
            goto L_0x00df
        L_0x006a:
            java.lang.String r7 = "textCombine"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0074
            goto L_0x00de
        L_0x0074:
            r6 = 9
            goto L_0x00df
        L_0x0078:
            java.lang.String r7 = "shear"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0082
            goto L_0x00de
        L_0x0082:
            r6 = 8
            goto L_0x00df
        L_0x0086:
            java.lang.String r7 = "color"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x008f
            goto L_0x00de
        L_0x008f:
            r6 = 7
            goto L_0x00df
        L_0x0091:
            java.lang.String r7 = "ruby"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x009a
            goto L_0x00de
        L_0x009a:
            r6 = 6
            goto L_0x00df
        L_0x009c:
            java.lang.String r7 = "id"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00a5
            goto L_0x00de
        L_0x00a5:
            r6 = 5
            goto L_0x00df
        L_0x00a7:
            java.lang.String r7 = "fontWeight"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00b0
            goto L_0x00de
        L_0x00b0:
            r6 = 4
            goto L_0x00df
        L_0x00b2:
            java.lang.String r7 = "textDecoration"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00bb
            goto L_0x00de
        L_0x00bb:
            r6 = 3
            goto L_0x00df
        L_0x00bd:
            java.lang.String r7 = "textAlign"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00c6
            goto L_0x00de
        L_0x00c6:
            r6 = 2
            goto L_0x00df
        L_0x00c8:
            java.lang.String r7 = "fontFamily"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00d1
            goto L_0x00de
        L_0x00d1:
            r6 = 1
            goto L_0x00df
        L_0x00d3:
            java.lang.String r7 = "fontStyle"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x00dc
            goto L_0x00de
        L_0x00dc:
            r6 = 0
            goto L_0x00df
        L_0x00de:
            r6 = -1
        L_0x00df:
            java.lang.String r7 = "after"
            java.lang.String r14 = "before"
            java.lang.String r15 = "none"
            java.lang.String r8 = "TtmlDecoder"
            switch(r6) {
                case 0: goto L_0x0477;
                case 1: goto L_0x0470;
                case 2: goto L_0x0465;
                case 3: goto L_0x0405;
                case 4: goto L_0x03f7;
                case 5: goto L_0x03e3;
                case 6: goto L_0x0363;
                case 7: goto L_0x0342;
                case 8: goto L_0x02ee;
                case 9: goto L_0x02c7;
                case 10: goto L_0x02b5;
                case 11: goto L_0x0134;
                case 12: goto L_0x010f;
                case 13: goto L_0x00f8;
                case 14: goto L_0x00ec;
                default: goto L_0x00ea;
            }
        L_0x00ea:
            goto L_0x0483
        L_0x00ec:
            c3.h r0 = i(r0)
            android.text.Layout$Alignment r5 = k(r5)
            r0.f2856p = r5
            goto L_0x0483
        L_0x00f8:
            c3.h r0 = i(r0)
            int r6 = j1.f.a(r5, r3)     // Catch:{ IllegalArgumentException -> 0x0106 }
            r0.f2844d = r6     // Catch:{ IllegalArgumentException -> 0x0106 }
            r0.f2845e = r13     // Catch:{ IllegalArgumentException -> 0x0106 }
            goto L_0x0483
        L_0x0106:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed parsing background value: "
            r6.<init>(r7)
            goto L_0x0357
        L_0x010f:
            java.lang.String r5 = c9.b.a(r5)
            r5.getClass()
            boolean r6 = r5.equals(r14)
            if (r6 != 0) goto L_0x012c
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0124
            goto L_0x0483
        L_0x0124:
            c3.h r0 = i(r0)
            r0.f2854n = r12
            goto L_0x0483
        L_0x012c:
            c3.h r0 = i(r0)
            r0.f2854n = r13
            goto L_0x0483
        L_0x0134:
            c3.h r0 = i(r0)
            java.util.regex.Pattern r6 = c3.b.f2797d
            if (r5 != 0) goto L_0x013d
            goto L_0x014b
        L_0x013d:
            java.lang.String r5 = r5.trim()
            java.lang.String r5 = c9.b.a(r5)
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x014e
        L_0x014b:
            r5 = 0
            goto L_0x02b1
        L_0x014e:
            java.util.regex.Pattern r6 = c3.b.f2797d
            java.lang.String[] r5 = android.text.TextUtils.split(r5, r6)
            int r6 = r5.length
            if (r6 == 0) goto L_0x016e
            if (r6 == r13) goto L_0x0165
            int r6 = r5.length
            java.lang.Object r5 = r5.clone()
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            d9.u0 r5 = d9.u0.i(r6, r5)
            goto L_0x0170
        L_0x0165:
            r5 = r5[r3]
            d9.g2 r6 = new d9.g2
            r6.<init>(r5)
            r5 = r6
            goto L_0x0170
        L_0x016e:
            d9.x1 r5 = d9.x1.f4702q
        L_0x0170:
            d9.u0 r6 = c3.b.f2801h
            d9.a2 r6 = d9.f2.d(r6, r5)
            d9.w0 r8 = new d9.w0
            r8.<init>(r6)
            boolean r6 = r8.hasNext()
            java.lang.String r9 = "outside"
            if (r6 == 0) goto L_0x0188
            java.lang.Object r6 = r8.next()
            goto L_0x0189
        L_0x0188:
            r6 = r9
        L_0x0189:
            java.lang.String r6 = (java.lang.String) r6
            int r8 = r6.hashCode()
            r10 = -1392885889(0xffffffffacfa3f7f, float:-7.112477E-12)
            if (r8 == r10) goto L_0x01af
            r10 = -1106037339(0xffffffffbe1335a5, float:-0.14375933)
            if (r8 == r10) goto L_0x01a7
            r9 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r8 == r9) goto L_0x019f
            goto L_0x01b7
        L_0x019f:
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01b7
            r6 = 0
            goto L_0x01b8
        L_0x01a7:
            boolean r6 = r6.equals(r9)
            if (r6 == 0) goto L_0x01b7
            r6 = 1
            goto L_0x01b8
        L_0x01af:
            boolean r6 = r6.equals(r14)
            if (r6 == 0) goto L_0x01b7
            r6 = 2
            goto L_0x01b8
        L_0x01b7:
            r6 = -1
        L_0x01b8:
            if (r6 == 0) goto L_0x01c0
            if (r6 == r13) goto L_0x01be
            r6 = 1
            goto L_0x01c1
        L_0x01be:
            r6 = -2
            goto L_0x01c1
        L_0x01c0:
            r6 = 2
        L_0x01c1:
            d9.u0 r7 = c3.b.f2798e
            d9.a2 r7 = d9.f2.d(r7, r5)
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L_0x0204
            d9.w0 r5 = new d9.w0
            r5.<init>(r7)
            java.lang.Object r5 = r5.next()
            java.lang.String r5 = (java.lang.String) r5
            int r7 = r5.hashCode()
            r8 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r7 == r8) goto L_0x01ef
            r8 = 3387192(0x33af38, float:4.746467E-39)
            if (r7 == r8) goto L_0x01e7
            goto L_0x01f8
        L_0x01e7:
            boolean r5 = r5.equals(r15)
            if (r5 == 0) goto L_0x01f8
            r13 = 0
            goto L_0x01f9
        L_0x01ef:
            java.lang.String r7 = "auto"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x01f8
            goto L_0x01f9
        L_0x01f8:
            r13 = -1
        L_0x01f9:
            if (r13 == 0) goto L_0x01fc
            goto L_0x01fd
        L_0x01fc:
            r11 = 0
        L_0x01fd:
            c3.b r5 = new c3.b
            r5.<init>(r11, r3, r6)
            goto L_0x02b1
        L_0x0204:
            d9.u0 r7 = c3.b.f2800g
            d9.a2 r7 = d9.f2.d(r7, r5)
            d9.u0 r8 = c3.b.f2799f
            d9.a2 r5 = d9.f2.d(r8, r5)
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x0223
            boolean r8 = r5.isEmpty()
            if (r8 == 0) goto L_0x0223
            c3.b r5 = new c3.b
            r5.<init>(r11, r3, r6)
            goto L_0x02b1
        L_0x0223:
            d9.w0 r8 = new d9.w0
            r8.<init>(r7)
            boolean r7 = r8.hasNext()
            java.lang.String r9 = "filled"
            if (r7 == 0) goto L_0x0235
            java.lang.Object r7 = r8.next()
            goto L_0x0236
        L_0x0235:
            r7 = r9
        L_0x0236:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r7.hashCode()
            r10 = -1274499742(0xffffffffb408ad62, float:-1.2729063E-7)
            if (r8 == r10) goto L_0x0251
            r9 = 3417674(0x34264a, float:4.789181E-39)
            if (r8 == r9) goto L_0x0247
            goto L_0x0259
        L_0x0247:
            java.lang.String r8 = "open"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0259
            r7 = 0
            goto L_0x025a
        L_0x0251:
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0259
            r7 = 1
            goto L_0x025a
        L_0x0259:
            r7 = -1
        L_0x025a:
            if (r7 == 0) goto L_0x025e
            r7 = 1
            goto L_0x025f
        L_0x025e:
            r7 = 2
        L_0x025f:
            d9.w0 r8 = new d9.w0
            r8.<init>(r5)
            boolean r5 = r8.hasNext()
            java.lang.String r9 = "circle"
            if (r5 == 0) goto L_0x0271
            java.lang.Object r5 = r8.next()
            goto L_0x0272
        L_0x0271:
            r5 = r9
        L_0x0272:
            java.lang.String r5 = (java.lang.String) r5
            int r8 = r5.hashCode()
            r10 = -1360216880(0xffffffffaeecbcd0, float:-1.0765577E-10)
            if (r8 == r10) goto L_0x029c
            r9 = -905816648(0xffffffffca0255b8, float:-2135406.0)
            if (r8 == r9) goto L_0x0292
            r9 = 99657(0x18549, float:1.39649E-40)
            if (r8 == r9) goto L_0x0288
            goto L_0x02a3
        L_0x0288:
            java.lang.String r8 = "dot"
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x02a3
            r11 = 0
            goto L_0x02a3
        L_0x0292:
            java.lang.String r8 = "sesame"
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x02a3
            r11 = 1
            goto L_0x02a3
        L_0x029c:
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x02a3
            r11 = 2
        L_0x02a3:
            if (r11 == 0) goto L_0x02ab
            if (r11 == r13) goto L_0x02a9
            r10 = 1
            goto L_0x02ac
        L_0x02a9:
            r10 = 3
            goto L_0x02ac
        L_0x02ab:
            r10 = 2
        L_0x02ac:
            c3.b r5 = new c3.b
            r5.<init>(r10, r7, r6)
        L_0x02b1:
            r0.f2858r = r5
            goto L_0x0483
        L_0x02b5:
            c3.h r0 = i(r0)     // Catch:{ f -> 0x02be }
            m(r5, r0)     // Catch:{ f -> 0x02be }
            goto L_0x0483
        L_0x02be:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed parsing fontSize value: "
            r6.<init>(r7)
            goto L_0x0357
        L_0x02c7:
            java.lang.String r5 = c9.b.a(r5)
            r5.getClass()
            java.lang.String r6 = "all"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x02e6
            boolean r5 = r5.equals(r15)
            if (r5 != 0) goto L_0x02de
            goto L_0x0483
        L_0x02de:
            c3.h r0 = i(r0)
            r0.f2857q = r3
            goto L_0x0483
        L_0x02e6:
            c3.h r0 = i(r0)
            r0.f2857q = r13
            goto L_0x0483
        L_0x02ee:
            c3.h r6 = i(r0)
            java.util.regex.Pattern r0 = f2811q
            java.util.regex.Matcher r0 = r0.matcher(r5)
            boolean r7 = r0.matches()
            if (r7 != 0) goto L_0x0310
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r7 = "Invalid value for shear: "
            r0.<init>(r7)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            j1.v.g(r8, r0)
            goto L_0x033a
        L_0x0310:
            java.lang.String r0 = r0.group(r13)     // Catch:{ NumberFormatException -> 0x0328 }
            r0.getClass()     // Catch:{ NumberFormatException -> 0x0328 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0328 }
            r7 = -1027080192(0xffffffffc2c80000, float:-100.0)
            float r0 = java.lang.Math.max(r7, r0)     // Catch:{ NumberFormatException -> 0x0328 }
            r7 = 1120403456(0x42c80000, float:100.0)
            float r0 = java.lang.Math.min(r7, r0)     // Catch:{ NumberFormatException -> 0x0328 }
            goto L_0x033d
        L_0x0328:
            r0 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Failed to parse shear: "
            r7.<init>(r9)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            j1.v.h(r8, r5, r0)
        L_0x033a:
            r0 = 2139095039(0x7f7fffff, float:3.4028235E38)
        L_0x033d:
            r6.f2859s = r0
            r0 = r6
            goto L_0x0483
        L_0x0342:
            c3.h r0 = i(r0)
            int r6 = j1.f.a(r5, r3)     // Catch:{ IllegalArgumentException -> 0x0350 }
            r0.f2842b = r6     // Catch:{ IllegalArgumentException -> 0x0350 }
            r0.f2843c = r13     // Catch:{ IllegalArgumentException -> 0x0350 }
            goto L_0x0483
        L_0x0350:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed parsing color value: "
            r6.<init>(r7)
        L_0x0357:
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            j1.v.g(r8, r5)
            goto L_0x0483
        L_0x0363:
            java.lang.String r5 = c9.b.a(r5)
            r5.getClass()
            int r6 = r5.hashCode()
            switch(r6) {
                case -618561360: goto L_0x03a9;
                case -410956671: goto L_0x039e;
                case -250518009: goto L_0x0393;
                case -136074796: goto L_0x0388;
                case 3016401: goto L_0x037d;
                case 3556653: goto L_0x0372;
                default: goto L_0x0371;
            }
        L_0x0371:
            goto L_0x03b3
        L_0x0372:
            java.lang.String r6 = "text"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x037b
            goto L_0x03b3
        L_0x037b:
            r11 = 5
            goto L_0x03b3
        L_0x037d:
            java.lang.String r6 = "base"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0386
            goto L_0x03b3
        L_0x0386:
            r11 = 4
            goto L_0x03b3
        L_0x0388:
            java.lang.String r6 = "textContainer"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0391
            goto L_0x03b3
        L_0x0391:
            r11 = 3
            goto L_0x03b3
        L_0x0393:
            java.lang.String r6 = "delimiter"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x039c
            goto L_0x03b3
        L_0x039c:
            r11 = 2
            goto L_0x03b3
        L_0x039e:
            java.lang.String r6 = "container"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x03a7
            goto L_0x03b3
        L_0x03a7:
            r11 = 1
            goto L_0x03b3
        L_0x03a9:
            java.lang.String r6 = "baseContainer"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x03b2
            goto L_0x03b3
        L_0x03b2:
            r11 = 0
        L_0x03b3:
            if (r11 == 0) goto L_0x03db
            if (r11 == r13) goto L_0x03d3
            if (r11 == r12) goto L_0x03cb
            r5 = 3
            if (r11 == r5) goto L_0x03c3
            if (r11 == r9) goto L_0x03db
            r6 = 5
            if (r11 == r6) goto L_0x03c3
            goto L_0x0483
        L_0x03c3:
            c3.h r0 = i(r0)
            r0.f2853m = r5
            goto L_0x0483
        L_0x03cb:
            c3.h r0 = i(r0)
            r0.f2853m = r9
            goto L_0x0483
        L_0x03d3:
            c3.h r0 = i(r0)
            r0.f2853m = r13
            goto L_0x0483
        L_0x03db:
            c3.h r0 = i(r0)
            r0.f2853m = r12
            goto L_0x0483
        L_0x03e3:
            java.lang.String r6 = "style"
            java.lang.String r7 = r16.getName()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0483
            c3.h r0 = i(r0)
            r0.f2852l = r5
            goto L_0x0483
        L_0x03f7:
            c3.h r0 = i(r0)
            java.lang.String r6 = "bold"
            boolean r5 = r6.equalsIgnoreCase(r5)
            r0.f2848h = r5
            goto L_0x0483
        L_0x0405:
            java.lang.String r5 = c9.b.a(r5)
            r5.getClass()
            int r6 = r5.hashCode()
            switch(r6) {
                case -1461280213: goto L_0x0435;
                case -1026963764: goto L_0x042a;
                case 913457136: goto L_0x041f;
                case 1679736913: goto L_0x0414;
                default: goto L_0x0413;
            }
        L_0x0413:
            goto L_0x043f
        L_0x0414:
            java.lang.String r6 = "linethrough"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x041d
            goto L_0x043f
        L_0x041d:
            r11 = 3
            goto L_0x043f
        L_0x041f:
            java.lang.String r6 = "nolinethrough"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0428
            goto L_0x043f
        L_0x0428:
            r11 = 2
            goto L_0x043f
        L_0x042a:
            java.lang.String r6 = "underline"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0433
            goto L_0x043f
        L_0x0433:
            r11 = 1
            goto L_0x043f
        L_0x0435:
            java.lang.String r6 = "nounderline"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x043e
            goto L_0x043f
        L_0x043e:
            r11 = 0
        L_0x043f:
            if (r11 == 0) goto L_0x045e
            if (r11 == r13) goto L_0x0457
            if (r11 == r12) goto L_0x0450
            r5 = 3
            if (r11 == r5) goto L_0x0449
            goto L_0x0483
        L_0x0449:
            c3.h r0 = i(r0)
            r0.f2846f = r13
            goto L_0x0483
        L_0x0450:
            c3.h r0 = i(r0)
            r0.f2846f = r3
            goto L_0x0483
        L_0x0457:
            c3.h r0 = i(r0)
            r0.f2847g = r13
            goto L_0x0483
        L_0x045e:
            c3.h r0 = i(r0)
            r0.f2847g = r3
            goto L_0x0483
        L_0x0465:
            c3.h r0 = i(r0)
            android.text.Layout$Alignment r5 = k(r5)
            r0.f2855o = r5
            goto L_0x0483
        L_0x0470:
            c3.h r0 = i(r0)
            r0.f2841a = r5
            goto L_0x0483
        L_0x0477:
            c3.h r0 = i(r0)
            java.lang.String r6 = "italic"
            boolean r5 = r6.equalsIgnoreCase(r5)
            r0.f2849i = r5
        L_0x0483:
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0487:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.q(org.xmlpull.v1.XmlPullParser, c3.h):c3.h");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
        if (r13.equals("ms") == false) goto L_0x00da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f1, code lost:
        r7 = r7 * r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        r7 = r7 / r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long r(java.lang.String r13, c3.c r14) {
        /*
            java.util.regex.Pattern r0 = f2808n
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x007f
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            r13.getClass()
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            r13.getClass()
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0050
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0051
        L_0x0050:
            r9 = r4
        L_0x0051:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0063
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.f2805a
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x0064
        L_0x0063:
            r9 = r4
        L_0x0064:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x007a
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.f2806b
            double r4 = (double) r13
            double r0 = r0 / r4
            float r13 = r14.f2805a
            double r13 = (double) r13
            double r4 = r0 / r13
        L_0x007a:
            double r7 = r7 + r4
        L_0x007b:
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x007f:
            java.util.regex.Pattern r0 = f2809o
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x00f9
            java.lang.String r13 = r0.group(r7)
            r13.getClass()
            double r7 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            r13.getClass()
            int r0 = r13.hashCode()
            switch(r0) {
                case 102: goto L_0x00cf;
                case 104: goto L_0x00c4;
                case 109: goto L_0x00b9;
                case 116: goto L_0x00ae;
                case 3494: goto L_0x00a5;
                default: goto L_0x00a4;
            }
        L_0x00a4:
            goto L_0x00da
        L_0x00a5:
            java.lang.String r0 = "ms"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00db
            goto L_0x00da
        L_0x00ae:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00b7
            goto L_0x00da
        L_0x00b7:
            r4 = 3
            goto L_0x00db
        L_0x00b9:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00c2
            goto L_0x00da
        L_0x00c2:
            r4 = 2
            goto L_0x00db
        L_0x00c4:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00cd
            goto L_0x00da
        L_0x00cd:
            r4 = 1
            goto L_0x00db
        L_0x00cf:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00d8
            goto L_0x00da
        L_0x00d8:
            r4 = 0
            goto L_0x00db
        L_0x00da:
            r4 = -1
        L_0x00db:
            switch(r4) {
                case 0: goto L_0x00f4;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00e9;
                case 3: goto L_0x00e5;
                case 4: goto L_0x00df;
                default: goto L_0x00de;
            }
        L_0x00de:
            goto L_0x007b
        L_0x00df:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
            goto L_0x00f7
        L_0x00e5:
            int r13 = r14.f2807c
            double r13 = (double) r13
            goto L_0x00f7
        L_0x00e9:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x00f1
        L_0x00ec:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x00f1:
            double r7 = r7 * r13
            goto L_0x007b
        L_0x00f4:
            float r13 = r14.f2805a
            double r13 = (double) r13
        L_0x00f7:
            double r7 = r7 / r13
            goto L_0x007b
        L_0x00f9:
            w2.f r14 = new w2.f
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r13 = android.support.v4.media.h.m(r0, r13)
            r14.<init>((java.lang.String) r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.d.r(java.lang.String, c3.c):long");
    }

    public static x s(XmlPullParser xmlPullParser) {
        String str;
        String a10 = m0.a(xmlPullParser, "extent");
        if (a10 == null) {
            return null;
        }
        Matcher matcher = f2813s.matcher(a10);
        if (!matcher.matches()) {
            str = "Ignoring non-pixel tts extent: ";
        } else {
            try {
                String group = matcher.group(1);
                group.getClass();
                int parseInt = Integer.parseInt(group);
                String group2 = matcher.group(2);
                group2.getClass();
                return new x(parseInt, Integer.parseInt(group2));
            } catch (NumberFormatException unused) {
                str = "Ignoring malformed tts extent: ";
            }
        }
        v.g("TtmlDecoder", str.concat(a10));
        return null;
    }

    public final w2.d f(byte[] bArr, int i10, boolean z10) {
        x xVar;
        c cVar;
        try {
            XmlPullParser newPullParser = this.f2817m.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new f("", -3.4028235E38f, -3.4028235E38f, RecyclerView.UNDEFINED_DURATION, RecyclerView.UNDEFINED_DURATION, -3.4028235E38f, -3.4028235E38f, RecyclerView.UNDEFINED_DURATION, -3.4028235E38f, RecyclerView.UNDEFINED_DURATION));
            x xVar2 = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i10), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            int eventType = newPullParser.getEventType();
            c cVar2 = f2815u;
            x xVar3 = f2816v;
            i iVar = null;
            x xVar4 = xVar3;
            int i11 = 0;
            while (eventType != 1) {
                e eVar = (e) arrayDeque.peek();
                if (i11 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            cVar2 = n(newPullParser);
                            xVar4 = l(newPullParser, xVar3);
                            xVar2 = s(newPullParser);
                        }
                        x xVar5 = xVar4;
                        x xVar6 = xVar2;
                        c cVar3 = cVar2;
                        if (!j(name)) {
                            v.f("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i11++;
                            xVar = xVar5;
                            cVar = cVar3;
                        } else if ("head".equals(name)) {
                            xVar = xVar5;
                            cVar = cVar3;
                            o(newPullParser, hashMap, xVar5, xVar6, hashMap2, hashMap3);
                        } else {
                            xVar = xVar5;
                            cVar = cVar3;
                            try {
                                e p10 = p(newPullParser, eVar, hashMap2, cVar);
                                arrayDeque.push(p10);
                                if (eVar != null) {
                                    if (eVar.f2830m == null) {
                                        eVar.f2830m = new ArrayList();
                                    }
                                    eVar.f2830m.add(p10);
                                }
                            } catch (f e10) {
                                v.h("TtmlDecoder", "Suppressing parser error", e10);
                                i11++;
                            }
                        }
                        xVar4 = xVar;
                        cVar2 = cVar;
                        xVar2 = xVar6;
                    } else if (eventType == 4) {
                        eVar.getClass();
                        e a10 = e.a(newPullParser.getText());
                        if (eVar.f2830m == null) {
                            eVar.f2830m = new ArrayList();
                        }
                        eVar.f2830m.add(a10);
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            e eVar2 = (e) arrayDeque.peek();
                            eVar2.getClass();
                            iVar = new i(eVar2, hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                newPullParser.next();
                eventType = newPullParser.getEventType();
            }
            if (iVar != null) {
                return iVar;
            }
            throw new f("No TTML subtitles found");
        } catch (XmlPullParserException e11) {
            throw new f("Unable to decode source", e11);
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        }
    }
}
