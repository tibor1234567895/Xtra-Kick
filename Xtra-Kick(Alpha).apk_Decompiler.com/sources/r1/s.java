package r1;

import a2.r;
import android.util.Base64;
import g1.b1;
import g1.n;
import g1.t;
import g1.u;
import j1.l0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u2.q;

public final class s implements r {
    public static final Pattern A = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern B = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern C = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern D = a("CAN-BLOCK-RELOAD");
    public static final Pattern E = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern F = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern G = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern H = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern I = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern J = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern K = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern L = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern M = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern N = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern O = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern P = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern S = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern T = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern U = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern V = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern W = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern X = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern Y = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern Z = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");

    /* renamed from: a0  reason: collision with root package name */
    public static final Pattern f13628a0 = a(Constants.AUTO_SELECT);

    /* renamed from: b0  reason: collision with root package name */
    public static final Pattern f13629b0 = a(Constants.DEFAULT);

    /* renamed from: c0  reason: collision with root package name */
    public static final Pattern f13630c0 = a(Constants.FORCED);

    /* renamed from: d0  reason: collision with root package name */
    public static final Pattern f13631d0 = a("INDEPENDENT");

    /* renamed from: e0  reason: collision with root package name */
    public static final Pattern f13632e0 = a("GAP");

    /* renamed from: f0  reason: collision with root package name */
    public static final Pattern f13633f0 = a(Constants.PRECISE);

    /* renamed from: g0  reason: collision with root package name */
    public static final Pattern f13634g0 = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: h0  reason: collision with root package name */
    public static final Pattern f13635h0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: i0  reason: collision with root package name */
    public static final Pattern f13636i0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f13637j = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f13638k = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f13639l = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f13640m = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f13641n = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f13642o = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f13643p = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: q  reason: collision with root package name */
    public static final Pattern f13644q = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f13645r = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f13646s = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f13647t = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: u  reason: collision with root package name */
    public static final Pattern f13648u = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f13649v = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: w  reason: collision with root package name */
    public static final Pattern f13650w = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: x  reason: collision with root package name */
    public static final Pattern f13651x = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: y  reason: collision with root package name */
    public static final Pattern f13652y = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f13653z = a("CAN-SKIP-DATERANGES");

    /* renamed from: h  reason: collision with root package name */
    public final o f13654h;

    /* renamed from: i  reason: collision with root package name */
    public final l f13655i;

    public s() {
        this(o.f13610n, (l) null);
    }

    public static Pattern a(String str) {
        return Pattern.compile(str.concat("=(NO|YES)"));
    }

    public static u b(String str, t[] tVarArr) {
        t[] tVarArr2 = new t[tVarArr.length];
        for (int i10 = 0; i10 < tVarArr.length; i10++) {
            t tVar = tVarArr[i10];
            tVarArr2[i10] = new t(tVar.f6567i, tVar.f6568j, tVar.f6569k, (byte[]) null);
        }
        return new u(str, true, tVarArr2);
    }

    public static t c(String str, String str2, HashMap hashMap) {
        String k10 = k(str, Q, "1", hashMap);
        boolean equals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = R;
        if (equals) {
            String l10 = l(str, pattern, hashMap);
            return new t(n.f6476d, (String) null, "video/mp4", Base64.decode(l10.substring(l10.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new t(n.f6476d, (String) null, "hls", l0.z(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(k10)) {
                return null;
            }
            String l11 = l(str, pattern, hashMap);
            byte[] decode = Base64.decode(l11.substring(l11.indexOf(44)), 0);
            UUID uuid = n.f6477e;
            return new t(uuid, (String) null, "video/mp4", q.a(uuid, decode));
        }
    }

    public static int d(Pattern pattern, String str) {
        return Integer.parseInt(l(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0244, code lost:
        if (r1 != null) goto L_0x0253;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static r1.l e(r1.o r92, r1.l r93, r1.r r94, java.lang.String r95) {
        /*
            r0 = r92
            boolean r1 = r0.f13623c
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r1.k r6 = new r1.k
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r19 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r24 = 0
            r16 = r6
            r16.<init>(r17, r19, r20, r22, r24)
            java.util.TreeMap r8 = new java.util.TreeMap
            r8.<init>()
            java.lang.String r9 = ""
            r16 = 0
            r18 = -1
            r13 = r93
            r12 = r0
            r34 = r1
            r55 = r6
            r40 = r9
            r23 = r16
            r27 = r23
            r37 = r27
            r49 = r37
            r51 = r49
            r80 = r51
            r84 = r80
            r86 = r84
            r57 = r18
            r1 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r22 = 0
            r25 = 0
            r26 = 0
            r29 = 1
            r30 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r32 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r35 = 0
            r36 = 0
            r39 = 0
            r53 = 0
            r56 = 0
            r77 = 0
            r78 = 0
            r79 = 0
            r82 = 0
            r83 = 0
            r6 = r4
            r4 = 0
        L_0x0090:
            boolean r41 = r94.a()
            if (r41 == 0) goto L_0x06fc
            java.lang.String r10 = r94.b()
            java.lang.String r14 = "#EXT"
            boolean r14 = r10.startsWith(r14)
            if (r14 == 0) goto L_0x00a5
            r7.add(r10)
        L_0x00a5:
            java.lang.String r14 = "#EXT-X-PLAYLIST-TYPE"
            boolean r14 = r10.startsWith(r14)
            if (r14 == 0) goto L_0x00c7
            java.util.regex.Pattern r14 = f13651x
            java.lang.String r10 = l(r10, r14, r2)
            java.lang.String r14 = "VOD"
            boolean r14 = r14.equals(r10)
            if (r14 == 0) goto L_0x00bd
            r1 = 1
            goto L_0x0090
        L_0x00bd:
            java.lang.String r14 = "EVENT"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x0090
            r1 = 2
            goto L_0x0090
        L_0x00c7:
            java.lang.String r14 = "#EXT-X-I-FRAMES-ONLY"
            boolean r14 = r10.equals(r14)
            if (r14 == 0) goto L_0x00d2
            r82 = 1
            goto L_0x0090
        L_0x00d2:
            java.lang.String r14 = "#EXT-X-START"
            boolean r14 = r10.startsWith(r14)
            r42 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            if (r14 == 0) goto L_0x00fd
            java.util.Map r14 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r11 = J
            java.lang.String r11 = l(r10, r11, r14)
            double r20 = java.lang.Double.parseDouble(r11)
            r11 = r1
            double r0 = r20 * r42
            long r0 = (long) r0
            java.util.regex.Pattern r14 = f13633f0
            boolean r22 = g(r10, r14)
            r20 = r0
            r1 = r11
        L_0x00fa:
            r0 = r92
            goto L_0x0090
        L_0x00fd:
            r11 = r1
            java.lang.String r0 = "#EXT-X-SERVER-CONTROL"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x015b
            java.util.regex.Pattern r0 = f13652y
            double r0 = h(r10, r0)
            r44 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r14 = (r0 > r44 ? 1 : (r0 == r44 ? 0 : -1))
            if (r14 != 0) goto L_0x0118
            r60 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x011d
        L_0x0118:
            double r0 = r0 * r42
            long r0 = (long) r0
            r60 = r0
        L_0x011d:
            java.util.regex.Pattern r0 = f13653z
            boolean r62 = g(r10, r0)
            java.util.regex.Pattern r0 = B
            double r0 = h(r10, r0)
            int r14 = (r0 > r44 ? 1 : (r0 == r44 ? 0 : -1))
            if (r14 != 0) goto L_0x0133
            r63 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0138
        L_0x0133:
            double r0 = r0 * r42
            long r0 = (long) r0
            r63 = r0
        L_0x0138:
            java.util.regex.Pattern r0 = C
            double r0 = h(r10, r0)
            int r14 = (r0 > r44 ? 1 : (r0 == r44 ? 0 : -1))
            if (r14 != 0) goto L_0x0148
            r65 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x014d
        L_0x0148:
            double r0 = r0 * r42
            long r0 = (long) r0
            r65 = r0
        L_0x014d:
            java.util.regex.Pattern r0 = D
            boolean r67 = g(r10, r0)
            r1.k r55 = new r1.k
            r59 = r55
            r59.<init>(r60, r62, r63, r65, r67)
            goto L_0x0176
        L_0x015b:
            java.lang.String r0 = "#EXT-X-PART-INF"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0182
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r1 = f13649v
            java.lang.String r0 = l(r10, r1, r0)
            double r0 = java.lang.Double.parseDouble(r0)
            double r0 = r0 * r42
            long r0 = (long) r0
            r32 = r0
        L_0x0176:
            r90 = r3
            r89 = r7
            r0 = r12
            r3 = r78
        L_0x017d:
            r12 = r9
            r9 = r95
            goto L_0x0548
        L_0x0182:
            java.lang.String r0 = "#EXT-X-MAP"
            boolean r0 = r10.startsWith(r0)
            java.util.regex.Pattern r1 = L
            java.lang.String r14 = "@"
            r89 = r7
            java.util.regex.Pattern r7 = R
            if (r0 == 0) goto L_0x01e3
            java.lang.String r42 = l(r10, r7, r2)
            r0 = 0
            java.lang.String r1 = k(r10, r1, r0, r2)
            if (r1 == 0) goto L_0x01b5
            int r0 = j1.l0.f8453a
            r0 = -1
            java.lang.String[] r0 = r1.split(r14, r0)
            r1 = 0
            r7 = r0[r1]
            long r57 = java.lang.Long.parseLong(r7)
            int r1 = r0.length
            r7 = 1
            if (r1 <= r7) goto L_0x01b5
            r0 = r0[r7]
            long r37 = java.lang.Long.parseLong(r0)
        L_0x01b5:
            int r0 = (r57 > r18 ? 1 : (r57 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x01bb
            r37 = r16
        L_0x01bb:
            if (r77 == 0) goto L_0x01c7
            if (r56 == 0) goto L_0x01c0
            goto L_0x01c7
        L_0x01c0:
            java.lang.String r0 = "The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128."
            g1.b1 r0 = g1.b1.b(r0)
            throw r0
        L_0x01c7:
            r1.i r83 = new r1.i
            r41 = r83
            r43 = r37
            r45 = r57
            r47 = r77
            r48 = r56
            r41.<init>(r42, r43, r45, r47, r48)
            if (r0 == 0) goto L_0x01da
            long r37 = r37 + r57
        L_0x01da:
            r0 = r92
            r1 = r11
            r57 = r18
            r7 = r89
            goto L_0x0090
        L_0x01e3:
            java.lang.String r0 = "#EXT-X-TARGETDURATION"
            boolean r0 = r10.startsWith(r0)
            r90 = r3
            r91 = r4
            r3 = 1000000(0xf4240, double:4.940656E-318)
            if (r0 == 0) goto L_0x0202
            java.util.regex.Pattern r0 = f13647t
            int r0 = d(r0, r10)
            long r0 = (long) r0
            long r30 = r0 * r3
        L_0x01fb:
            r0 = r12
        L_0x01fc:
            r3 = r78
            r4 = r91
            goto L_0x017d
        L_0x0202:
            java.lang.String r0 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x021c
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r1 = E
            java.lang.String r0 = l(r10, r1, r0)
            long r27 = java.lang.Long.parseLong(r0)
            r0 = r12
            r49 = r27
            goto L_0x01fc
        L_0x021c:
            java.lang.String r0 = "#EXT-X-VERSION"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x022b
            java.util.regex.Pattern r0 = f13650w
            int r29 = d(r0, r10)
            goto L_0x01fb
        L_0x022b:
            java.lang.String r0 = "#EXT-X-DEFINE"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0262
            java.util.regex.Pattern r0 = f13635h0
            r1 = 0
            java.lang.String r0 = k(r10, r0, r1, r2)
            if (r0 == 0) goto L_0x0247
            java.util.Map r1 = r12.f13619l
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0256
            goto L_0x0253
        L_0x0247:
            java.util.regex.Pattern r0 = W
            java.lang.String r0 = l(r10, r0, r2)
            java.util.regex.Pattern r1 = f13634g0
            java.lang.String r1 = l(r10, r1, r2)
        L_0x0253:
            r2.put(r0, r1)
        L_0x0256:
            r63 = r2
            r62 = r9
            r3 = r78
            r10 = r90
            r9 = r95
            goto L_0x06e9
        L_0x0262:
            java.lang.String r0 = "#EXTINF"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x028e
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r1 = F
            java.lang.String r0 = l(r10, r1, r0)
            java.math.BigDecimal r1 = new java.math.BigDecimal
            r1.<init>(r0)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r3)
            java.math.BigDecimal r0 = r1.multiply(r0)
            long r84 = r0.longValue()
            java.util.regex.Pattern r0 = G
            java.lang.String r40 = k(r10, r0, r9, r2)
            goto L_0x01fb
        L_0x028e:
            java.lang.String r0 = "#EXT-X-SKIP"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x032a
            java.util.regex.Pattern r0 = A
            int r0 = d(r0, r10)
            if (r13 == 0) goto L_0x02a6
            boolean r1 = r15.isEmpty()
            if (r1 == 0) goto L_0x02a6
            r1 = 1
            goto L_0x02a7
        L_0x02a6:
            r1 = 0
        L_0x02a7:
            j1.a.e(r1)
            int r1 = j1.l0.f8453a
            long r3 = r13.f13589k
            long r3 = r27 - r3
            int r1 = (int) r3
            int r0 = r0 + r1
            if (r1 < 0) goto L_0x0324
            d9.r0 r3 = r13.f13596r
            int r3 = r3.size()
            if (r0 > r3) goto L_0x0324
            r3 = r80
        L_0x02be:
            if (r1 >= r0) goto L_0x0317
            d9.r0 r7 = r13.f13596r
            java.lang.Object r7 = r7.get(r1)
            r1.i r7 = (r1.i) r7
            r12 = r9
            long r9 = r13.f13589k
            int r14 = (r27 > r9 ? 1 : (r27 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x02da
            int r9 = r13.f13588j
            int r9 = r9 - r26
            int r10 = r7.f13569k
            int r9 = r9 + r10
            r1.i r7 = r7.a(r9, r3)
        L_0x02da:
            r15.add(r7)
            long r9 = r7.f13568j
            long r3 = r3 + r9
            long r9 = r7.f13575q
            int r13 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r13 == 0) goto L_0x02eb
            long r13 = r7.f13574p
            long r13 = r13 + r9
            r37 = r13
        L_0x02eb:
            java.lang.String r9 = r7.f13573o
            if (r9 == 0) goto L_0x02f9
            java.lang.String r10 = java.lang.Long.toHexString(r49)
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x02fb
        L_0x02f9:
            r56 = r9
        L_0x02fb:
            r9 = 1
            long r49 = r49 + r9
            int r1 = r1 + 1
            int r9 = r7.f13569k
            r1.i r10 = r7.f13567i
            g1.u r13 = r7.f13571m
            java.lang.String r7 = r7.f13572n
            r51 = r3
            r77 = r7
            r79 = r9
            r83 = r10
            r9 = r12
            r39 = r13
            r13 = r93
            goto L_0x02be
        L_0x0317:
            r12 = r9
            r0 = r92
            r13 = r93
            r9 = r95
            r80 = r3
            r3 = r78
            goto L_0x042c
        L_0x0324:
            r1.q r0 = new r1.q
            r0.<init>()
            throw r0
        L_0x032a:
            r12 = r9
            java.lang.String r0 = "#EXT-X-KEY"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x03ae
            java.util.regex.Pattern r0 = O
            java.lang.String r0 = l(r10, r0, r2)
            java.util.regex.Pattern r1 = P
            java.lang.String r3 = "identity"
            java.lang.String r1 = k(r10, r1, r3, r2)
            java.lang.String r4 = "NONE"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x034e
            r8.clear()
            r0 = 0
            goto L_0x0395
        L_0x034e:
            java.util.regex.Pattern r4 = S
            r9 = 0
            java.lang.String r4 = k(r10, r4, r9, r2)
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x036c
            java.lang.String r1 = "AES-128"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x039c
            java.lang.String r0 = l(r10, r7, r2)
            r77 = r0
            r56 = r4
            goto L_0x039f
        L_0x036c:
            r3 = r78
            if (r3 != 0) goto L_0x0389
            java.lang.String r3 = "SAMPLE-AES-CENC"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0384
            java.lang.String r3 = "SAMPLE-AES-CTR"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0381
            goto L_0x0384
        L_0x0381:
            java.lang.String r0 = "cbcs"
            goto L_0x0386
        L_0x0384:
            java.lang.String r0 = "cenc"
        L_0x0386:
            r78 = r0
            goto L_0x038b
        L_0x0389:
            r78 = r3
        L_0x038b:
            g1.t r0 = c(r10, r1, r2)
            if (r0 == 0) goto L_0x039c
            r8.put(r1, r0)
            r0 = r4
        L_0x0395:
            r56 = r0
            r39 = 0
        L_0x0399:
            r77 = 0
            goto L_0x039f
        L_0x039c:
            r56 = r4
            goto L_0x0399
        L_0x039f:
            r0 = r92
            r13 = r93
            r1 = r11
            r9 = r12
            r7 = r89
            r3 = r90
            r4 = r91
            r12 = r0
            goto L_0x0090
        L_0x03ae:
            r3 = r78
            java.lang.String r0 = "#EXT-X-BYTERANGE"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x03d7
            java.util.regex.Pattern r0 = K
            java.lang.String r0 = l(r10, r0, r2)
            int r1 = j1.l0.f8453a
            r1 = -1
            java.lang.String[] r0 = r0.split(r14, r1)
            r1 = 0
            r4 = r0[r1]
            long r57 = java.lang.Long.parseLong(r4)
            int r1 = r0.length
            r4 = 1
            if (r1 <= r4) goto L_0x0426
            r0 = r0[r4]
            long r37 = java.lang.Long.parseLong(r0)
            goto L_0x0426
        L_0x03d7:
            r4 = 1
            java.lang.String r0 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r0 = r10.startsWith(r0)
            r9 = 58
            if (r0 == 0) goto L_0x03fb
            int r0 = r10.indexOf(r9)
            int r0 = r0 + r4
            java.lang.String r0 = r10.substring(r0)
            int r26 = java.lang.Integer.parseInt(r0)
            r0 = r92
            r13 = r93
            r9 = r95
            r4 = r91
            r25 = 1
            goto L_0x0548
        L_0x03fb:
            java.lang.String r0 = "#EXT-X-DISCONTINUITY"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0406
            int r79 = r79 + 1
            goto L_0x0426
        L_0x0406:
            java.lang.String r0 = "#EXT-X-PROGRAM-DATE-TIME"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0434
            int r0 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0430
            int r0 = r10.indexOf(r9)
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r0 = r10.substring(r0)
            long r0 = j1.l0.K(r0)
            long r0 = j1.l0.H(r0)
            long r23 = r0 - r80
        L_0x0426:
            r0 = r92
            r13 = r93
            r9 = r95
        L_0x042c:
            r4 = r91
            goto L_0x0548
        L_0x0430:
            r9 = r95
            goto L_0x04ca
        L_0x0434:
            java.lang.String r0 = "#EXT-X-GAP"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0448
            r0 = r92
            r13 = r93
            r9 = r95
            r4 = r91
            r53 = 1
            goto L_0x0548
        L_0x0448:
            java.lang.String r0 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x045c
            r0 = r92
            r13 = r93
            r9 = r95
            r4 = r91
            r34 = 1
            goto L_0x0548
        L_0x045c:
            java.lang.String r0 = "#EXT-X-ENDLIST"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0470
            r0 = r92
            r13 = r93
            r9 = r95
            r4 = r91
            r35 = 1
            goto L_0x0548
        L_0x0470:
            java.lang.String r0 = "#EXT-X-RENDITION-REPORT"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x04af
            java.util.regex.Pattern r0 = H
            long r0 = i(r10, r0)
            java.util.regex.Pattern r4 = I
            java.util.regex.Matcher r4 = r4.matcher(r10)
            boolean r9 = r4.find()
            if (r9 == 0) goto L_0x0497
            r9 = 1
            java.lang.String r4 = r4.group(r9)
            r4.getClass()
            int r14 = java.lang.Integer.parseInt(r4)
            goto L_0x0498
        L_0x0497:
            r14 = -1
        L_0x0498:
            java.lang.String r4 = l(r10, r7, r2)
            r9 = r95
            java.lang.String r4 = j1.j0.c(r9, r4)
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r1.h r7 = new r1.h
            r7.<init>(r4, r0, r14)
            r5.add(r7)
            goto L_0x04ca
        L_0x04af:
            r9 = r95
            java.lang.String r0 = "#EXT-X-PRELOAD-HINT"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x0553
            if (r91 == 0) goto L_0x04bc
            goto L_0x04ca
        L_0x04bc:
            java.util.regex.Pattern r0 = U
            java.lang.String r0 = l(r10, r0, r2)
            java.lang.String r1 = "PART"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x04d2
        L_0x04ca:
            r63 = r2
            r62 = r12
        L_0x04ce:
            r10 = r90
            goto L_0x06e9
        L_0x04d2:
            java.lang.String r60 = l(r10, r7, r2)
            java.util.regex.Pattern r0 = M
            long r0 = i(r10, r0)
            java.util.regex.Pattern r4 = N
            long r72 = i(r10, r4)
            if (r77 != 0) goto L_0x04e7
            r69 = 0
            goto L_0x04f2
        L_0x04e7:
            if (r56 == 0) goto L_0x04ec
            r69 = r56
            goto L_0x04f2
        L_0x04ec:
            java.lang.String r4 = java.lang.Long.toHexString(r49)
            r69 = r4
        L_0x04f2:
            if (r39 != 0) goto L_0x0517
            boolean r4 = r8.isEmpty()
            if (r4 != 0) goto L_0x0517
            java.util.Collection r4 = r8.values()
            r7 = 0
            g1.t[] r10 = new g1.t[r7]
            java.lang.Object[] r4 = r4.toArray(r10)
            g1.t[] r4 = (g1.t[]) r4
            g1.u r7 = new g1.u
            r10 = 1
            r7.<init>(r3, r10, r4)
            if (r36 != 0) goto L_0x0515
            g1.u r4 = b(r3, r4)
            r36 = r4
        L_0x0515:
            r39 = r7
        L_0x0517:
            int r4 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x0523
            int r7 = (r72 > r18 ? 1 : (r72 == r18 ? 0 : -1))
            if (r7 == 0) goto L_0x0520
            goto L_0x0523
        L_0x0520:
            r4 = r91
            goto L_0x0544
        L_0x0523:
            r1.g r7 = new r1.g
            r62 = 0
            if (r4 == 0) goto L_0x052c
            r70 = r0
            goto L_0x052e
        L_0x052c:
            r70 = r16
        L_0x052e:
            r74 = 0
            r75 = 0
            r76 = 1
            r59 = r7
            r61 = r83
            r64 = r79
            r65 = r51
            r67 = r39
            r68 = r77
            r59.<init>(r60, r61, r62, r64, r65, r67, r68, r69, r70, r72, r74, r75, r76)
            r4 = r7
        L_0x0544:
            r0 = r92
            r13 = r93
        L_0x0548:
            r78 = r3
            r1 = r11
            r9 = r12
            r7 = r89
            r3 = r90
            r12 = r0
            goto L_0x00fa
        L_0x0553:
            java.lang.String r0 = "#EXT-X-PART"
            boolean r0 = r10.startsWith(r0)
            if (r0 == 0) goto L_0x061a
            if (r77 != 0) goto L_0x0560
            r69 = 0
            goto L_0x056b
        L_0x0560:
            if (r56 == 0) goto L_0x0565
            r69 = r56
            goto L_0x056b
        L_0x0565:
            java.lang.String r0 = java.lang.Long.toHexString(r49)
            r69 = r0
        L_0x056b:
            java.lang.String r60 = l(r10, r7, r2)
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r4 = f13648u
            java.lang.String r0 = l(r10, r4, r0)
            double r44 = java.lang.Double.parseDouble(r0)
            r0 = r12
            double r12 = r44 * r42
            long r12 = (long) r12
            java.util.regex.Pattern r4 = f13631d0
            boolean r4 = g(r10, r4)
            if (r34 == 0) goto L_0x0591
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0591
            r7 = 1
            goto L_0x0592
        L_0x0591:
            r7 = 0
        L_0x0592:
            r75 = r4 | r7
            java.util.regex.Pattern r4 = f13632e0
            boolean r74 = g(r10, r4)
            r4 = 0
            java.lang.String r1 = k(r10, r1, r4, r2)
            if (r1 == 0) goto L_0x05ba
            int r7 = j1.l0.f8453a
            r7 = -1
            java.lang.String[] r1 = r1.split(r14, r7)
            r7 = 0
            r10 = r1[r7]
            long r41 = java.lang.Long.parseLong(r10)
            int r7 = r1.length
            r10 = 1
            if (r7 <= r10) goto L_0x05bc
            r1 = r1[r10]
            long r86 = java.lang.Long.parseLong(r1)
            goto L_0x05bc
        L_0x05ba:
            r41 = r18
        L_0x05bc:
            int r1 = (r41 > r18 ? 1 : (r41 == r18 ? 0 : -1))
            if (r1 != 0) goto L_0x05c2
            r86 = r16
        L_0x05c2:
            if (r39 != 0) goto L_0x05e7
            boolean r7 = r8.isEmpty()
            if (r7 != 0) goto L_0x05e7
            java.util.Collection r7 = r8.values()
            r10 = 0
            g1.t[] r14 = new g1.t[r10]
            java.lang.Object[] r7 = r7.toArray(r14)
            g1.t[] r7 = (g1.t[]) r7
            g1.u r10 = new g1.u
            r14 = 1
            r10.<init>(r3, r14, r7)
            if (r36 != 0) goto L_0x05e5
            g1.u r7 = b(r3, r7)
            r36 = r7
        L_0x05e5:
            r39 = r10
        L_0x05e7:
            r1.g r7 = new r1.g
            r59 = r7
            r76 = 0
            r61 = r83
            r62 = r12
            r64 = r79
            r65 = r51
            r67 = r39
            r68 = r77
            r70 = r86
            r72 = r41
            r59.<init>(r60, r61, r62, r64, r65, r67, r68, r69, r70, r72, r74, r75, r76)
            r6.add(r7)
            long r51 = r51 + r12
            if (r1 == 0) goto L_0x0609
            long r86 = r86 + r41
        L_0x0609:
            r12 = r92
            r13 = r93
            r9 = r0
            r78 = r3
            r1 = r11
            r7 = r89
            r3 = r90
            r4 = r91
            r0 = r12
            goto L_0x0090
        L_0x061a:
            r0 = r12
            r4 = 0
            java.lang.String r1 = "#"
            boolean r1 = r10.startsWith(r1)
            if (r1 != 0) goto L_0x06e3
            if (r77 != 0) goto L_0x0628
            r1 = r4
            goto L_0x0631
        L_0x0628:
            if (r56 == 0) goto L_0x062d
            r1 = r56
            goto L_0x0631
        L_0x062d:
            java.lang.String r1 = java.lang.Long.toHexString(r49)
        L_0x0631:
            r12 = 1
            long r12 = r49 + r12
            java.lang.String r7 = m(r10, r2)
            r10 = r90
            java.lang.Object r14 = r10.get(r7)
            r1.i r14 = (r1.i) r14
            int r59 = (r57 > r18 ? 1 : (r57 == r18 ? 0 : -1))
            if (r59 != 0) goto L_0x0648
            r60 = r16
            goto L_0x0664
        L_0x0648:
            if (r82 == 0) goto L_0x0662
            if (r83 != 0) goto L_0x0662
            if (r14 != 0) goto L_0x0662
            r1.i r14 = new r1.i
            r43 = 0
            r47 = 0
            r48 = 0
            r41 = r14
            r42 = r7
            r45 = r37
            r41.<init>(r42, r43, r45, r47, r48)
            r10.put(r7, r14)
        L_0x0662:
            r60 = r37
        L_0x0664:
            if (r39 != 0) goto L_0x068a
            boolean r37 = r8.isEmpty()
            if (r37 != 0) goto L_0x068a
            java.util.Collection r4 = r8.values()
            r62 = r0
            r63 = r2
            r0 = 0
            g1.t[] r2 = new g1.t[r0]
            java.lang.Object[] r2 = r4.toArray(r2)
            g1.t[] r2 = (g1.t[]) r2
            g1.u r4 = new g1.u
            r0 = 1
            r4.<init>(r3, r0, r2)
            if (r36 != 0) goto L_0x0690
            g1.u r36 = b(r3, r2)
            goto L_0x0690
        L_0x068a:
            r62 = r0
            r63 = r2
            r4 = r39
        L_0x0690:
            r1.i r0 = new r1.i
            if (r83 == 0) goto L_0x0697
            r39 = r83
            goto L_0x0699
        L_0x0697:
            r39 = r14
        L_0x0699:
            r37 = r0
            r38 = r7
            r41 = r84
            r43 = r79
            r44 = r80
            r46 = r4
            r47 = r77
            r48 = r1
            r49 = r60
            r51 = r57
            r54 = r6
            r37.<init>(r38, r39, r40, r41, r43, r44, r46, r47, r48, r49, r51, r53, r54)
            r15.add(r0)
            long r51 = r80 + r84
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            if (r59 == 0) goto L_0x06c0
            long r60 = r60 + r57
        L_0x06c0:
            r37 = r60
            r0 = r92
            r78 = r3
            r39 = r4
            r3 = r10
            r1 = r11
            r49 = r12
            r84 = r16
            r57 = r18
            r80 = r51
            r9 = r62
            r40 = r9
            r2 = r63
            r7 = r89
            r4 = r91
            r53 = 0
            r12 = r0
            r13 = r93
            goto L_0x0090
        L_0x06e3:
            r62 = r0
            r63 = r2
            goto L_0x04ce
        L_0x06e9:
            r0 = r92
            r12 = r0
            r13 = r93
            r78 = r3
            r3 = r10
            r1 = r11
            r9 = r62
            r2 = r63
            r7 = r89
            r4 = r91
            goto L_0x0090
        L_0x06fc:
            r9 = r95
            r11 = r1
            r91 = r4
            r89 = r7
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = 0
        L_0x0709:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x0762
            java.lang.Object r2 = r5.get(r1)
            r1.h r2 = (r1.h) r2
            long r3 = r2.f13562b
            int r7 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r7 != 0) goto L_0x0728
            int r3 = r15.size()
            long r3 = (long) r3
            long r3 = r27 + r3
            boolean r7 = r6.isEmpty()
            long r7 = (long) r7
            long r3 = r3 - r7
        L_0x0728:
            int r7 = r2.f13563c
            r8 = -1
            if (r7 != r8) goto L_0x074f
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r32 > r12 ? 1 : (r32 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x074d
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0745
            java.lang.Object r7 = d9.v0.a(r15)
            r1.i r7 = (r1.i) r7
            d9.r0 r7 = r7.f13565t
            goto L_0x0746
        L_0x0745:
            r7 = r6
        L_0x0746:
            int r7 = r7.size()
            r10 = 1
            int r7 = r7 - r10
            goto L_0x0755
        L_0x074d:
            r10 = 1
            goto L_0x0755
        L_0x074f:
            r10 = 1
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0755:
            r1.h r14 = new r1.h
            android.net.Uri r2 = r2.f13561a
            r14.<init>(r2, r3, r7)
            r0.put(r2, r14)
            int r1 = r1 + 1
            goto L_0x0709
        L_0x0762:
            r10 = 1
            if (r91 == 0) goto L_0x076a
            r4 = r91
            r6.add(r4)
        L_0x076a:
            r1.l r1 = new r1.l
            int r2 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r2 == 0) goto L_0x0773
            r88 = 1
            goto L_0x0775
        L_0x0773:
            r88 = 0
        L_0x0775:
            r4 = r1
            r5 = r11
            r2 = r6
            r6 = r95
            r7 = r89
            r8 = r20
            r10 = r22
            r11 = r23
            r13 = r25
            r14 = r26
            r3 = r15
            r15 = r27
            r17 = r29
            r18 = r30
            r20 = r32
            r22 = r34
            r23 = r35
            r24 = r88
            r25 = r36
            r26 = r3
            r27 = r2
            r28 = r55
            r29 = r0
            r4.<init>(r5, r6, r7, r8, r10, r11, r13, r14, r15, r17, r18, r20, r22, r23, r24, r25, r26, r27, r28, r29)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.s.e(r1.o, r1.l, r1.r, java.lang.String):r1.l");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static r1.o f(r1.r r36, java.lang.String r37) {
        /*
            r1 = r37
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
            r13 = 0
        L_0x0036:
            boolean r14 = r36.a()
            java.util.regex.Pattern r9 = R
            java.lang.String r15 = "application/x-mpegURL"
            r19 = r10
            java.util.regex.Pattern r10 = W
            if (r14 == 0) goto L_0x0219
            java.lang.String r14 = r36.b()
            r20 = r7
            java.lang.String r7 = "#EXT"
            boolean r7 = r14.startsWith(r7)
            if (r7 == 0) goto L_0x0055
            r8.add(r14)
        L_0x0055:
            java.lang.String r7 = "#EXT-X-I-FRAME-STREAM-INF"
            boolean r7 = r14.startsWith(r7)
            r21 = r8
            java.lang.String r8 = "#EXT-X-DEFINE"
            boolean r8 = r14.startsWith(r8)
            if (r8 == 0) goto L_0x0073
            java.lang.String r7 = l(r14, r10, r11)
            java.util.regex.Pattern r8 = f13634g0
            java.lang.String r8 = l(r14, r8, r11)
            r11.put(r7, r8)
            goto L_0x00d5
        L_0x0073:
            java.lang.String r8 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r8 = r14.equals(r8)
            if (r8 == 0) goto L_0x007d
            r10 = 1
            goto L_0x00d7
        L_0x007d:
            java.lang.String r8 = "#EXT-X-MEDIA"
            boolean r8 = r14.startsWith(r8)
            if (r8 == 0) goto L_0x0089
            r3.add(r14)
            goto L_0x00d5
        L_0x0089:
            java.lang.String r8 = "#EXT-X-SESSION-KEY"
            boolean r8 = r14.startsWith(r8)
            if (r8 == 0) goto L_0x00ca
            java.util.regex.Pattern r7 = P
            java.lang.String r8 = "identity"
            java.lang.String r7 = k(r14, r7, r8, r11)
            g1.t r7 = c(r14, r7, r11)
            if (r7 == 0) goto L_0x00d5
            java.util.regex.Pattern r8 = O
            java.lang.String r8 = l(r14, r8, r11)
            java.lang.String r9 = "SAMPLE-AES-CENC"
            boolean r9 = r9.equals(r8)
            if (r9 != 0) goto L_0x00b9
            java.lang.String r9 = "SAMPLE-AES-CTR"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00b6
            goto L_0x00b9
        L_0x00b6:
            java.lang.String r8 = "cbcs"
            goto L_0x00bb
        L_0x00b9:
            java.lang.String r8 = "cenc"
        L_0x00bb:
            g1.u r9 = new g1.u
            r10 = 1
            g1.t[] r14 = new g1.t[r10]
            r15 = 0
            r14[r15] = r7
            r9.<init>(r8, r10, r14)
            r12.add(r9)
            goto L_0x00d5
        L_0x00ca:
            java.lang.String r8 = "#EXT-X-STREAM-INF"
            boolean r8 = r14.startsWith(r8)
            if (r8 != 0) goto L_0x00e4
            if (r7 == 0) goto L_0x00d5
            goto L_0x00e4
        L_0x00d5:
            r10 = r19
        L_0x00d7:
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r30 = r12
            r4 = r0
            goto L_0x0201
        L_0x00e4:
            java.lang.String r8 = "CLOSED-CAPTIONS=NONE"
            boolean r8 = r14.contains(r8)
            r13 = r13 | r8
            if (r7 == 0) goto L_0x00f0
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00f1
        L_0x00f0:
            r8 = 0
        L_0x00f1:
            java.util.regex.Pattern r10 = f13642o
            int r10 = d(r10, r14)
            r29 = r13
            java.util.regex.Pattern r13 = f13637j
            java.util.regex.Matcher r13 = r13.matcher(r14)
            boolean r22 = r13.find()
            r30 = r12
            if (r22 == 0) goto L_0x0114
            r12 = 1
            java.lang.String r13 = r13.group(r12)
            r13.getClass()
            int r12 = java.lang.Integer.parseInt(r13)
            goto L_0x0115
        L_0x0114:
            r12 = -1
        L_0x0115:
            java.util.regex.Pattern r13 = f13644q
            r31 = r6
            r6 = 0
            java.lang.String r13 = k(r14, r13, r6, r11)
            r32 = r5
            java.util.regex.Pattern r5 = f13645r
            java.lang.String r5 = k(r14, r5, r6, r11)
            if (r5 == 0) goto L_0x014f
            int r6 = j1.l0.f8453a
            java.lang.String r6 = "x"
            r33 = r4
            r4 = -1
            java.lang.String[] r5 = r5.split(r6, r4)
            r4 = 0
            r6 = r5[r4]
            int r4 = java.lang.Integer.parseInt(r6)
            r6 = 1
            r5 = r5[r6]
            int r5 = java.lang.Integer.parseInt(r5)
            if (r4 <= 0) goto L_0x0149
            if (r5 > 0) goto L_0x0146
            goto L_0x0149
        L_0x0146:
            r16 = r4
            goto L_0x014c
        L_0x0149:
            r5 = -1
            r16 = -1
        L_0x014c:
            r4 = r16
            goto L_0x0153
        L_0x014f:
            r33 = r4
            r4 = -1
            r5 = -1
        L_0x0153:
            java.util.regex.Pattern r6 = f13646s
            r34 = r3
            r3 = 0
            java.lang.String r6 = k(r14, r6, r3, r11)
            if (r6 == 0) goto L_0x0163
            float r6 = java.lang.Float.parseFloat(r6)
            goto L_0x0165
        L_0x0163:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0165:
            r35 = r0
            java.util.regex.Pattern r0 = f13638k
            java.lang.String r0 = k(r14, r0, r3, r11)
            r16 = r0
            java.util.regex.Pattern r0 = f13639l
            java.lang.String r0 = k(r14, r0, r3, r11)
            r17 = r0
            java.util.regex.Pattern r0 = f13640m
            java.lang.String r0 = k(r14, r0, r3, r11)
            r18 = r0
            java.util.regex.Pattern r0 = f13641n
            java.lang.String r0 = k(r14, r0, r3, r11)
            if (r7 == 0) goto L_0x018c
            java.lang.String r3 = l(r14, r9, r11)
            goto L_0x019a
        L_0x018c:
            boolean r3 = r36.a()
            if (r3 == 0) goto L_0x0212
            java.lang.String r3 = r36.b()
            java.lang.String r3 = m(r3, r11)
        L_0x019a:
            android.net.Uri r3 = j1.j0.d(r1, r3)
            g1.z r7 = new g1.z
            r7.<init>()
            int r9 = r2.size()
            r7.b(r9)
            r7.f6753j = r15
            r7.f6751h = r13
            r7.f6749f = r12
            r7.f6750g = r10
            r7.f6759p = r4
            r7.f6760q = r5
            r7.f6761r = r6
            r7.f6748e = r8
            g1.a0 r4 = new g1.a0
            r4.<init>(r7)
            r1.n r5 = new r1.n
            r22 = r5
            r23 = r3
            r24 = r4
            r25 = r16
            r26 = r17
            r27 = r18
            r28 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28)
            r2.add(r5)
            r4 = r35
            java.lang.Object r5 = r4.get(r3)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x01e7
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r4.put(r3, r5)
        L_0x01e7:
            q1.y r3 = new q1.y
            r22 = r3
            r23 = r12
            r24 = r10
            r25 = r16
            r26 = r17
            r27 = r18
            r28 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28)
            r5.add(r3)
            r10 = r19
            r13 = r29
        L_0x0201:
            r0 = r4
            r7 = r20
            r8 = r21
            r12 = r30
            r6 = r31
            r5 = r32
            r4 = r33
            r3 = r34
            goto L_0x0036
        L_0x0212:
            java.lang.String r0 = "#EXT-X-STREAM-INF must be followed by another line"
            g1.b1 r0 = g1.b1.b(r0)
            throw r0
        L_0x0219:
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r20 = r7
            r21 = r8
            r30 = r12
            r4 = r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r5 = 0
        L_0x0233:
            int r6 = r2.size()
            if (r5 >= r6) goto L_0x02ab
            java.lang.Object r6 = r2.get(r5)
            r1.n r6 = (r1.n) r6
            android.net.Uri r7 = r6.f13604a
            boolean r7 = r0.add(r7)
            if (r7 == 0) goto L_0x02a0
            g1.a0 r7 = r6.f13605b
            g1.z0 r8 = r7.f6274q
            if (r8 != 0) goto L_0x024f
            r8 = 1
            goto L_0x0250
        L_0x024f:
            r8 = 0
        L_0x0250:
            j1.a.e(r8)
            q1.z r8 = new q1.z
            android.net.Uri r12 = r6.f13604a
            java.lang.Object r12 = r4.get(r12)
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            r12.getClass()
            r14 = 0
            r8.<init>(r14, r14, r12)
            g1.z0 r12 = new g1.z0
            r36 = r0
            r14 = 1
            g1.y0[] r0 = new g1.y0[r14]
            r14 = 0
            r0[r14] = r8
            r12.<init>((g1.y0[]) r0)
            g1.z r0 = new g1.z
            r0.<init>(r7)
            r0.f6752i = r12
            g1.a0 r7 = new g1.a0
            r7.<init>(r0)
            r1.n r0 = new r1.n
            android.net.Uri r8 = r6.f13604a
            java.lang.String r12 = r6.f13606c
            java.lang.String r14 = r6.f13607d
            r35 = r4
            java.lang.String r4 = r6.f13608e
            java.lang.String r6 = r6.f13609f
            r22 = r0
            r23 = r8
            r24 = r7
            r25 = r12
            r26 = r14
            r27 = r4
            r28 = r6
            r22.<init>(r23, r24, r25, r26, r27, r28)
            r3.add(r0)
            goto L_0x02a4
        L_0x02a0:
            r36 = r0
            r35 = r4
        L_0x02a4:
            int r5 = r5 + 1
            r0 = r36
            r4 = r35
            goto L_0x0233
        L_0x02ab:
            r0 = 0
            r6 = 0
            r8 = 0
        L_0x02ae:
            int r4 = r34.size()
            if (r0 >= r4) goto L_0x0551
            r4 = r34
            java.lang.Object r5 = r4.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r7 = X
            java.lang.String r7 = l(r5, r7, r11)
            java.lang.String r12 = l(r5, r10, r11)
            g1.z r14 = new g1.z
            r14.<init>()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r7)
            r22 = r10
            java.lang.String r10 = ":"
            r4.append(r10)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            r14.f6744a = r4
            r14.f6745b = r12
            r14.f6753j = r15
            java.util.regex.Pattern r4 = f13629b0
            boolean r4 = g(r5, r4)
            java.util.regex.Pattern r10 = f13630c0
            boolean r10 = g(r5, r10)
            if (r10 == 0) goto L_0x02f7
            r4 = r4 | 2
        L_0x02f7:
            java.util.regex.Pattern r10 = f13628a0
            boolean r10 = g(r5, r10)
            if (r10 == 0) goto L_0x0301
            r4 = r4 | 4
        L_0x0301:
            r14.f6747d = r4
            java.util.regex.Pattern r4 = Y
            r10 = 0
            java.lang.String r4 = k(r5, r4, r10, r11)
            boolean r10 = android.text.TextUtils.isEmpty(r4)
            if (r10 == 0) goto L_0x0314
            r23 = r15
            r4 = 0
            goto L_0x034b
        L_0x0314:
            int r10 = j1.l0.f8453a
            java.lang.String r10 = ","
            r23 = r15
            r15 = -1
            java.lang.String[] r4 = r4.split(r10, r15)
            java.lang.String r10 = "public.accessibility.describes-video"
            boolean r10 = j1.l0.j(r4, r10)
            if (r10 == 0) goto L_0x032a
            r10 = 512(0x200, float:7.175E-43)
            goto L_0x032b
        L_0x032a:
            r10 = 0
        L_0x032b:
            java.lang.String r15 = "public.accessibility.transcribes-spoken-dialog"
            boolean r15 = j1.l0.j(r4, r15)
            if (r15 == 0) goto L_0x0335
            r10 = r10 | 4096(0x1000, float:5.74E-42)
        L_0x0335:
            java.lang.String r15 = "public.accessibility.describes-music-and-sound"
            boolean r15 = j1.l0.j(r4, r15)
            if (r15 == 0) goto L_0x033f
            r10 = r10 | 1024(0x400, float:1.435E-42)
        L_0x033f:
            java.lang.String r15 = "public.easy-to-read"
            boolean r4 = j1.l0.j(r4, r15)
            if (r4 == 0) goto L_0x034a
            r4 = r10 | 8192(0x2000, float:1.14794E-41)
            goto L_0x034b
        L_0x034a:
            r4 = r10
        L_0x034b:
            r14.f6748e = r4
            java.util.regex.Pattern r4 = V
            r10 = 0
            java.lang.String r4 = k(r5, r4, r10, r11)
            r14.f6746c = r4
            java.lang.String r4 = k(r5, r9, r10, r11)
            if (r4 != 0) goto L_0x035e
            r4 = 0
            goto L_0x0362
        L_0x035e:
            android.net.Uri r4 = j1.j0.d(r1, r4)
        L_0x0362:
            g1.z0 r10 = new g1.z0
            r15 = 1
            g1.y0[] r1 = new g1.y0[r15]
            q1.z r15 = new q1.z
            r24 = r9
            java.util.List r9 = java.util.Collections.emptyList()
            r15.<init>(r7, r12, r9)
            r9 = 0
            r1[r9] = r15
            r10.<init>((g1.y0[]) r1)
            java.util.regex.Pattern r1 = T
            java.lang.String r1 = l(r5, r1, r11)
            int r9 = r1.hashCode()
            r15 = 2
            switch(r9) {
                case -959297733: goto L_0x03a8;
                case -333210994: goto L_0x039d;
                case 62628790: goto L_0x0392;
                case 81665115: goto L_0x0387;
                default: goto L_0x0386;
            }
        L_0x0386:
            goto L_0x03b3
        L_0x0387:
            java.lang.String r9 = "VIDEO"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0390
            goto L_0x03b3
        L_0x0390:
            r1 = 3
            goto L_0x03b4
        L_0x0392:
            java.lang.String r9 = "AUDIO"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x039b
            goto L_0x03b3
        L_0x039b:
            r1 = 2
            goto L_0x03b4
        L_0x039d:
            java.lang.String r9 = "CLOSED-CAPTIONS"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x03a6
            goto L_0x03b3
        L_0x03a6:
            r1 = 1
            goto L_0x03b4
        L_0x03a8:
            java.lang.String r9 = "SUBTITLES"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x03b1
            goto L_0x03b3
        L_0x03b1:
            r1 = 0
            goto L_0x03b4
        L_0x03b3:
            r1 = -1
        L_0x03b4:
            if (r1 == 0) goto L_0x04e5
            r9 = 1
            if (r1 == r9) goto L_0x04a0
            if (r1 == r15) goto L_0x0415
            r9 = 3
            if (r1 == r9) goto L_0x03c1
        L_0x03be:
            r9 = r33
            goto L_0x040d
        L_0x03c1:
            r1 = 0
        L_0x03c2:
            int r5 = r2.size()
            if (r1 >= r5) goto L_0x03da
            java.lang.Object r5 = r2.get(r1)
            r1.n r5 = (r1.n) r5
            java.lang.String r9 = r5.f13606c
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x03d7
            goto L_0x03db
        L_0x03d7:
            int r1 = r1 + 1
            goto L_0x03c2
        L_0x03da:
            r5 = 0
        L_0x03db:
            if (r5 == 0) goto L_0x03f9
            g1.a0 r1 = r5.f13605b
            java.lang.String r5 = r1.f6273p
            java.lang.String r5 = j1.l0.o(r15, r5)
            r14.f6751h = r5
            java.lang.String r5 = g1.a1.d(r5)
            r14.f6754k = r5
            int r5 = r1.f6281x
            r14.f6759p = r5
            int r5 = r1.f6282y
            r14.f6760q = r5
            float r1 = r1.f6283z
            r14.f6761r = r1
        L_0x03f9:
            if (r4 != 0) goto L_0x03fc
            goto L_0x03be
        L_0x03fc:
            r14.f6752i = r10
            r1.m r1 = new r1.m
            g1.a0 r5 = new g1.a0
            r5.<init>(r14)
            r1.<init>(r4, r5, r12)
            r9 = r33
            r9.add(r1)
        L_0x040d:
            r25 = r8
            r7 = r31
            r5 = r32
            goto L_0x053d
        L_0x0415:
            r9 = r33
            r1 = 0
        L_0x0418:
            int r15 = r2.size()
            if (r1 >= r15) goto L_0x0434
            java.lang.Object r15 = r2.get(r1)
            r1.n r15 = (r1.n) r15
            r25 = r8
            java.lang.String r8 = r15.f13607d
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x042f
            goto L_0x0437
        L_0x042f:
            int r1 = r1 + 1
            r8 = r25
            goto L_0x0418
        L_0x0434:
            r25 = r8
            r15 = 0
        L_0x0437:
            if (r15 == 0) goto L_0x0449
            g1.a0 r1 = r15.f13605b
            java.lang.String r1 = r1.f6273p
            r8 = 1
            java.lang.String r1 = j1.l0.o(r8, r1)
            r14.f6751h = r1
            java.lang.String r1 = g1.a1.d(r1)
            goto L_0x044b
        L_0x0449:
            r8 = 1
            r1 = 0
        L_0x044b:
            java.util.regex.Pattern r7 = f13643p
            r8 = 0
            java.lang.String r5 = k(r5, r7, r8, r11)
            if (r5 == 0) goto L_0x047d
            int r7 = j1.l0.f8453a
            java.lang.String r7 = "/"
            r8 = 2
            java.lang.String[] r7 = r5.split(r7, r8)
            r8 = 0
            r7 = r7[r8]
            int r7 = java.lang.Integer.parseInt(r7)
            r14.f6767x = r7
            java.lang.String r7 = "audio/eac3"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x047e
            java.lang.String r7 = "/JOC"
            boolean r5 = r5.endsWith(r7)
            if (r5 == 0) goto L_0x047e
            java.lang.String r1 = "ec+3"
            r14.f6751h = r1
            java.lang.String r1 = "audio/eac3-joc"
            goto L_0x047e
        L_0x047d:
            r8 = 0
        L_0x047e:
            r14.f6754k = r1
            if (r4 == 0) goto L_0x0494
            r14.f6752i = r10
            r1.m r1 = new r1.m
            g1.a0 r5 = new g1.a0
            r5.<init>(r14)
            r1.<init>(r4, r5, r12)
            r4 = r32
            r4.add(r1)
            goto L_0x04df
        L_0x0494:
            r4 = r32
            if (r15 == 0) goto L_0x04df
            g1.a0 r1 = new g1.a0
            r1.<init>(r14)
            r25 = r1
            goto L_0x04df
        L_0x04a0:
            r25 = r8
            r4 = r32
            r9 = r33
            r8 = 0
            java.util.regex.Pattern r1 = Z
            java.lang.String r1 = l(r5, r1, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r1.startsWith(r5)
            if (r5 == 0) goto L_0x04c1
            r5 = 2
            java.lang.String r1 = r1.substring(r5)
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r5 = "application/cea-608"
            goto L_0x04cc
        L_0x04c1:
            r5 = 7
            java.lang.String r1 = r1.substring(r5)
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r5 = "application/cea-708"
        L_0x04cc:
            if (r6 != 0) goto L_0x04d3
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x04d3:
            r14.f6754k = r5
            r14.C = r1
            g1.a0 r1 = new g1.a0
            r1.<init>(r14)
            r6.add(r1)
        L_0x04df:
            r5 = r4
            r8 = r25
            r7 = r31
            goto L_0x053f
        L_0x04e5:
            r25 = r8
            r5 = r32
            r9 = r33
            r8 = 0
            r15 = 0
        L_0x04ed:
            int r1 = r2.size()
            if (r15 >= r1) goto L_0x0506
            java.lang.Object r1 = r2.get(r15)
            r1.n r1 = (r1.n) r1
            java.lang.String r8 = r1.f13608e
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0502
            goto L_0x0507
        L_0x0502:
            int r15 = r15 + 1
            r8 = 0
            goto L_0x04ed
        L_0x0506:
            r1 = 0
        L_0x0507:
            if (r1 == 0) goto L_0x0519
            g1.a0 r1 = r1.f13605b
            java.lang.String r1 = r1.f6273p
            r7 = 3
            java.lang.String r1 = j1.l0.o(r7, r1)
            r14.f6751h = r1
            java.lang.String r1 = g1.a1.d(r1)
            goto L_0x051a
        L_0x0519:
            r1 = 0
        L_0x051a:
            if (r1 != 0) goto L_0x051e
            java.lang.String r1 = "text/vtt"
        L_0x051e:
            r14.f6754k = r1
            r14.f6752i = r10
            if (r4 == 0) goto L_0x0534
            r1.m r1 = new r1.m
            g1.a0 r7 = new g1.a0
            r7.<init>(r14)
            r1.<init>(r4, r7, r12)
            r7 = r31
            r7.add(r1)
            goto L_0x053d
        L_0x0534:
            r7 = r31
            java.lang.String r1 = "HlsPlaylistParser"
            java.lang.String r4 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            j1.v.g(r1, r4)
        L_0x053d:
            r8 = r25
        L_0x053f:
            int r0 = r0 + 1
            r1 = r37
            r32 = r5
            r31 = r7
            r33 = r9
            r10 = r22
            r15 = r23
            r9 = r24
            goto L_0x02ae
        L_0x0551:
            r25 = r8
            r7 = r31
            r5 = r32
            r9 = r33
            if (r13 == 0) goto L_0x0561
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
            goto L_0x0562
        L_0x0561:
            r10 = r6
        L_0x0562:
            r1.o r13 = new r1.o
            r0 = r13
            r1 = r37
            r2 = r21
            r4 = r9
            r6 = r7
            r7 = r20
            r8 = r25
            r9 = r10
            r10 = r19
            r12 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.s.f(r1.r, java.lang.String):r1.o");
    }

    public static boolean g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Constants.YES.equals(matcher.group(1));
        }
        return false;
    }

    public static double h(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -9.223372036854776E18d;
        }
        String group = matcher.group(1);
        group.getClass();
        return Double.parseDouble(group);
    }

    public static long i(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }

    public static String k(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            str2.getClass();
        }
        if (map.isEmpty() || str2 == null) {
            return str2;
        }
        return m(str2, map);
    }

    public static String l(String str, Pattern pattern, Map map) {
        String k10 = k(str, pattern, (String) null, map);
        if (k10 != null) {
            return k10;
        }
        throw b1.b("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String m(String str, Map map) {
        Matcher matcher = f13636i0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c A[Catch:{ all -> 0x003b }, LOOP:3: B:32:0x006c->B:87:0x006c, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(android.net.Uri r7, k1.j r8) {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r8)
            r0.<init>(r1)
            java.util.ArrayDeque r8 = new java.util.ArrayDeque
            r8.<init>()
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            r2 = 239(0xef, float:3.35E-43)
            r3 = 0
            if (r1 != r2) goto L_0x002d
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            r2 = 187(0xbb, float:2.62E-43)
            if (r1 != r2) goto L_0x004a
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            r2 = 191(0xbf, float:2.68E-43)
            if (r1 == r2) goto L_0x0029
            goto L_0x004a
        L_0x0029:
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
        L_0x002d:
            r2 = -1
            if (r1 == r2) goto L_0x003e
            boolean r4 = java.lang.Character.isWhitespace(r1)     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x003e
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            goto L_0x002d
        L_0x003b:
            r7 = move-exception
            goto L_0x0108
        L_0x003e:
            r4 = 0
        L_0x003f:
            r5 = 7
            if (r4 >= r5) goto L_0x0053
            java.lang.String r5 = "#EXTM3U"
            char r5 = r5.charAt(r4)     // Catch:{ all -> 0x003b }
            if (r1 == r5) goto L_0x004c
        L_0x004a:
            r1 = 0
            goto L_0x006a
        L_0x004c:
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0053:
            if (r1 == r2) goto L_0x0066
            boolean r4 = java.lang.Character.isWhitespace(r1)     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x0066
            boolean r4 = j1.l0.E(r1)     // Catch:{ all -> 0x003b }
            if (r4 != 0) goto L_0x0066
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            goto L_0x0053
        L_0x0066:
            boolean r1 = j1.l0.E(r1)     // Catch:{ all -> 0x003b }
        L_0x006a:
            if (r1 == 0) goto L_0x0101
        L_0x006c:
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x00f5
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x003b }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x007d
            goto L_0x006c
        L_0x007d:
            java.lang.String r2 = "#EXT-X-STREAM-INF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0096
            r8.add(r1)     // Catch:{ all -> 0x003b }
            r1.r r1 = new r1.r     // Catch:{ all -> 0x003b }
            r1.<init>(r8, r0, r3)     // Catch:{ all -> 0x003b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x003b }
            r1.o r7 = f(r1, r7)     // Catch:{ all -> 0x003b }
            goto L_0x00ef
        L_0x0096:
            java.lang.String r2 = "#EXT-X-TARGETDURATION"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXTINF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-KEY"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-BYTERANGE"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-DISCONTINUITY"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x003b }
            if (r2 != 0) goto L_0x00db
            java.lang.String r2 = "#EXT-X-ENDLIST"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x00d7
            goto L_0x00db
        L_0x00d7:
            r8.add(r1)     // Catch:{ all -> 0x003b }
            goto L_0x006c
        L_0x00db:
            r8.add(r1)     // Catch:{ all -> 0x003b }
            r1.o r1 = r6.f13654h     // Catch:{ all -> 0x003b }
            r1.l r2 = r6.f13655i     // Catch:{ all -> 0x003b }
            r1.r r4 = new r1.r     // Catch:{ all -> 0x003b }
            r4.<init>(r8, r0, r3)     // Catch:{ all -> 0x003b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x003b }
            r1.l r7 = e(r1, r2, r4, r7)     // Catch:{ all -> 0x003b }
        L_0x00ef:
            int r8 = j1.l0.f8453a
            r0.close()     // Catch:{ IOException -> 0x00f4 }
        L_0x00f4:
            return r7
        L_0x00f5:
            int r7 = j1.l0.f8453a
            r0.close()     // Catch:{ IOException -> 0x00fa }
        L_0x00fa:
            java.lang.String r7 = "Failed to parse the playlist, could not identify any tags."
            g1.b1 r7 = g1.b1.b(r7)
            throw r7
        L_0x0101:
            java.lang.String r7 = "Input does not start with the #EXTM3U header."
            g1.b1 r7 = g1.b1.b(r7)     // Catch:{ all -> 0x003b }
            throw r7     // Catch:{ all -> 0x003b }
        L_0x0108:
            int r8 = j1.l0.f8453a
            r0.close()     // Catch:{ IOException -> 0x010d }
        L_0x010d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.s.j(android.net.Uri, k1.j):java.lang.Object");
    }

    public s(o oVar, l lVar) {
        this.f13654h = oVar;
        this.f13655i = lVar;
    }
}
