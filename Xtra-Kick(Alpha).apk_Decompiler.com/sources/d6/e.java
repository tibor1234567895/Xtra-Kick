package d6;

import a2.r;
import android.util.Base64;
import g1.b1;
import g1.n;
import g1.t;
import g1.u;
import j1.l0;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r1.l;
import r1.o;
import u2.q;

public final class e implements r {
    public static final Pattern A = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern B = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern C = a("CAN-BLOCK-RELOAD");
    public static final Pattern D = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern E = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern F = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern G = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern I = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern J = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern K = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern L = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern M = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern N = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern O = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    public static final Pattern P = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    public static final Pattern Q = Pattern.compile("URI=\"(.+?)\"");
    public static final Pattern R = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern S = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern T = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern U = Pattern.compile("LANGUAGE=\"(.+?)\"");
    public static final Pattern V = Pattern.compile("NAME=\"(.+?)\"");
    public static final Pattern W = Pattern.compile("GROUP-ID=\"(.+?)\"");
    public static final Pattern X = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    public static final Pattern Y = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern Z = a(Constants.AUTO_SELECT);

    /* renamed from: a0  reason: collision with root package name */
    public static final Pattern f4536a0 = a(Constants.DEFAULT);

    /* renamed from: b0  reason: collision with root package name */
    public static final Pattern f4537b0 = a(Constants.FORCED);

    /* renamed from: c0  reason: collision with root package name */
    public static final Pattern f4538c0 = a("INDEPENDENT");

    /* renamed from: d0  reason: collision with root package name */
    public static final Pattern f4539d0 = a("GAP");

    /* renamed from: e0  reason: collision with root package name */
    public static final Pattern f4540e0 = a(Constants.PRECISE);

    /* renamed from: f0  reason: collision with root package name */
    public static final Pattern f4541f0 = Pattern.compile("VALUE=\"(.+?)\"");

    /* renamed from: g0  reason: collision with root package name */
    public static final Pattern f4542g0 = Pattern.compile("IMPORT=\"(.+?)\"");

    /* renamed from: h0  reason: collision with root package name */
    public static final Pattern f4543h0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* renamed from: j  reason: collision with root package name */
    public static final Pattern f4544j = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: k  reason: collision with root package name */
    public static final Pattern f4545k = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: l  reason: collision with root package name */
    public static final Pattern f4546l = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: m  reason: collision with root package name */
    public static final Pattern f4547m = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: n  reason: collision with root package name */
    public static final Pattern f4548n = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: o  reason: collision with root package name */
    public static final Pattern f4549o = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f4550p = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: q  reason: collision with root package name */
    public static final Pattern f4551q = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f4552r = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: s  reason: collision with root package name */
    public static final Pattern f4553s = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: t  reason: collision with root package name */
    public static final Pattern f4554t = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: u  reason: collision with root package name */
    public static final Pattern f4555u = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: v  reason: collision with root package name */
    public static final Pattern f4556v = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: w  reason: collision with root package name */
    public static final Pattern f4557w = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: x  reason: collision with root package name */
    public static final Pattern f4558x = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");

    /* renamed from: y  reason: collision with root package name */
    public static final Pattern f4559y = a("CAN-SKIP-DATERANGES");

    /* renamed from: z  reason: collision with root package name */
    public static final Pattern f4560z = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");

    /* renamed from: h  reason: collision with root package name */
    public final o f4561h;

    /* renamed from: i  reason: collision with root package name */
    public final l f4562i;

    static {
        Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    }

    public e() {
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
        String i10 = i(str, P, "1", hashMap);
        boolean equals = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2);
        Pattern pattern = Q;
        if (equals) {
            String k10 = k(str, pattern, hashMap);
            return new t(n.f6476d, (String) null, "video/mp4", Base64.decode(k10.substring(k10.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new t(n.f6476d, (String) null, "hls", l0.z(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(i10)) {
                return null;
            }
            String k11 = k(str, pattern, hashMap);
            byte[] decode = Base64.decode(k11.substring(k11.indexOf(44)), 0);
            UUID uuid = n.f6477e;
            return new t(uuid, (String) null, "video/mp4", q.a(uuid, decode));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0251, code lost:
        if (r10 != null) goto L_0x0260;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static r1.l d(r1.o r93, r1.l r94, r1.r r95, java.lang.String r96) {
        /*
            android.app.Application r0 = com.github.andreyasadchy.xtra.XtraApp.f3320l
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = o3.i0.a(r0)
            r2 = 0
            r0.getSharedPreferences(r1, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0 = r93
            boolean r1 = r0.f13623c
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r1.k r7 = new r1.k
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r19 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r24 = 0
            r16 = r7
            r16.<init>(r17, r19, r20, r22, r24)
            java.util.TreeMap r9 = new java.util.TreeMap
            r9.<init>()
            r16 = 0
            java.lang.String r11 = ""
            r79 = r94
            r78 = r0
            r34 = r1
            r55 = r7
            r40 = r11
            r23 = r16
            r27 = r23
            r37 = r27
            r49 = r37
            r51 = r49
            r82 = r51
            r86 = r82
            r88 = r86
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
            r57 = -1
            r77 = 0
            r80 = 0
            r81 = 0
            r84 = 0
            r85 = 0
            r7 = r5
            r5 = 0
        L_0x00a2:
            boolean r41 = r95.a()
            r12 = -1
            if (r41 == 0) goto L_0x0729
            java.lang.String r13 = r95.b()
            java.lang.String r10 = "#EXT"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x00b8
            r8.add(r13)
        L_0x00b8:
            java.lang.String r10 = "#EXT-X-PLAYLIST-TYPE"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x00da
            java.util.regex.Pattern r10 = f4557w
            java.lang.String r10 = k(r13, r10, r3)
            java.lang.String r12 = "VOD"
            boolean r12 = r12.equals(r10)
            if (r12 == 0) goto L_0x00d0
            r1 = 1
            goto L_0x00a2
        L_0x00d0:
            java.lang.String r12 = "EVENT"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x00a2
            r1 = 2
            goto L_0x00a2
        L_0x00da:
            java.lang.String r10 = "#EXT-X-I-FRAMES-ONLY"
            boolean r10 = r13.equals(r10)
            if (r10 == 0) goto L_0x00e5
            r84 = 1
            goto L_0x00a2
        L_0x00e5:
            java.lang.String r10 = "#EXT-X-START"
            boolean r10 = r13.startsWith(r10)
            r41 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            if (r10 == 0) goto L_0x0110
            java.util.Map r10 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r12 = I
            java.lang.String r10 = k(r13, r12, r10)
            double r20 = java.lang.Double.parseDouble(r10)
            r90 = r15
            double r14 = r20 * r41
            long r14 = (long) r14
            java.util.regex.Pattern r12 = f4540e0
            boolean r22 = f(r13, r12)
            r20 = r14
            r15 = r90
            goto L_0x00a2
        L_0x0110:
            r90 = r15
            java.lang.String r14 = "#EXT-X-SERVER-CONTROL"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x016f
            java.util.regex.Pattern r12 = f4558x
            double r14 = g(r13, r12)
            r43 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r12 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            if (r12 != 0) goto L_0x012c
            r60 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0131
        L_0x012c:
            double r14 = r14 * r41
            long r14 = (long) r14
            r60 = r14
        L_0x0131:
            java.util.regex.Pattern r12 = f4559y
            boolean r62 = f(r13, r12)
            java.util.regex.Pattern r12 = A
            double r14 = g(r13, r12)
            int r12 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            if (r12 != 0) goto L_0x0147
            r63 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x014c
        L_0x0147:
            double r14 = r14 * r41
            long r14 = (long) r14
            r63 = r14
        L_0x014c:
            java.util.regex.Pattern r12 = B
            double r14 = g(r13, r12)
            int r12 = (r14 > r43 ? 1 : (r14 == r43 ? 0 : -1))
            if (r12 != 0) goto L_0x015c
            r65 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0161
        L_0x015c:
            double r14 = r14 * r41
            long r14 = (long) r14
            r65 = r14
        L_0x0161:
            java.util.regex.Pattern r12 = C
            boolean r67 = f(r13, r12)
            r1.k r55 = new r1.k
            r59 = r55
            r59.<init>(r60, r62, r63, r65, r67)
            goto L_0x018a
        L_0x016f:
            java.lang.String r14 = "#EXT-X-PART-INF"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x0198
            java.util.Map r12 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r14 = f4555u
            java.lang.String r12 = k(r13, r14, r12)
            double r12 = java.lang.Double.parseDouble(r12)
            double r12 = r12 * r41
            long r12 = (long) r12
            r32 = r12
        L_0x018a:
            r2 = r79
            r0 = r90
            r79 = r11
            r92 = r78
            r78 = r1
            r1 = r92
            goto L_0x0559
        L_0x0198:
            java.lang.String r14 = "#EXT-X-MAP"
            boolean r14 = r13.startsWith(r14)
            java.util.regex.Pattern r15 = K
            java.lang.String r10 = "@"
            java.util.regex.Pattern r2 = Q
            if (r14 == 0) goto L_0x01f6
            java.lang.String r42 = k(r13, r2, r3)
            r2 = 0
            java.lang.String r13 = i(r13, r15, r2, r3)
            if (r13 == 0) goto L_0x01c8
            int r2 = j1.l0.f8453a
            java.lang.String[] r2 = r13.split(r10, r12)
            r10 = 0
            r12 = r2[r10]
            long r57 = java.lang.Long.parseLong(r12)
            int r10 = r2.length
            r12 = 1
            if (r10 <= r12) goto L_0x01c8
            r2 = r2[r12]
            long r37 = java.lang.Long.parseLong(r2)
        L_0x01c8:
            r12 = -1
            int r2 = (r57 > r12 ? 1 : (r57 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x01d0
            r37 = r16
        L_0x01d0:
            if (r77 == 0) goto L_0x01dc
            if (r56 == 0) goto L_0x01d5
            goto L_0x01dc
        L_0x01d5:
            java.lang.String r0 = "The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128."
            g1.b1 r0 = g1.b1.b(r0)
            throw r0
        L_0x01dc:
            r1.i r85 = new r1.i
            r41 = r85
            r43 = r37
            r45 = r57
            r47 = r77
            r48 = r56
            r41.<init>(r42, r43, r45, r47, r48)
            if (r2 == 0) goto L_0x01ef
            long r37 = r37 + r57
        L_0x01ef:
            r15 = r90
            r2 = 0
            r57 = -1
            goto L_0x00a2
        L_0x01f6:
            java.lang.String r14 = "#EXT-X-TARGETDURATION"
            boolean r14 = r13.startsWith(r14)
            r44 = 2000000(0x1e8480, double:9.881313E-318)
            if (r14 == 0) goto L_0x0204
            r30 = r44
            goto L_0x018a
        L_0x0204:
            java.lang.String r14 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x021e
            java.util.Map r2 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r10 = D
            java.lang.String r2 = k(r13, r10, r2)
            long r27 = java.lang.Long.parseLong(r2)
            r49 = r27
            goto L_0x018a
        L_0x021e:
            java.lang.String r14 = "#EXT-X-VERSION"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x0236
            java.util.Map r2 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r10 = f4556v
            java.lang.String r2 = k(r13, r10, r2)
            int r29 = java.lang.Integer.parseInt(r2)
            goto L_0x018a
        L_0x0236:
            java.lang.String r14 = "#EXT-X-DEFINE"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x026d
            java.util.regex.Pattern r2 = f4542g0
            r10 = 0
            java.lang.String r2 = i(r13, r2, r10, r3)
            if (r2 == 0) goto L_0x0254
            r10 = r78
            java.util.Map r10 = r10.f13619l
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0263
            goto L_0x0260
        L_0x0254:
            java.util.regex.Pattern r2 = V
            java.lang.String r2 = k(r13, r2, r3)
            java.util.regex.Pattern r10 = f4541f0
            java.lang.String r10 = k(r13, r10, r3)
        L_0x0260:
            r3.put(r2, r10)
        L_0x0263:
            r78 = r1
            r79 = r11
            r11 = r80
            r0 = r90
            goto L_0x04e0
        L_0x026d:
            java.lang.String r14 = "#EXTINF"
            boolean r14 = r13.startsWith(r14)
            if (r14 == 0) goto L_0x029c
            java.util.Map r2 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r10 = E
            java.lang.String r2 = k(r13, r10, r2)
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r2)
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r14 = 1000000(0xf4240, double:4.940656E-318)
            r2.<init>(r14)
            java.math.BigDecimal r2 = r10.multiply(r2)
            long r86 = r2.longValue()
            java.util.regex.Pattern r2 = F
            java.lang.String r40 = i(r13, r2, r11, r3)
            goto L_0x018a
        L_0x029c:
            java.lang.String r14 = "#EXT-X-SKIP"
            boolean r14 = r13.startsWith(r14)
            r46 = 1
            if (r14 == 0) goto L_0x0356
            java.util.Map r2 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r10 = f4560z
            java.lang.String r2 = k(r13, r10, r2)
            int r2 = java.lang.Integer.parseInt(r2)
            r10 = r79
            if (r10 == 0) goto L_0x02c0
            boolean r12 = r90.isEmpty()
            if (r12 == 0) goto L_0x02c0
            r12 = 1
            goto L_0x02c1
        L_0x02c0:
            r12 = 0
        L_0x02c1:
            j1.a.e(r12)
            int r12 = j1.l0.f8453a
            long r12 = r10.f13589k
            long r12 = r27 - r12
            int r13 = (int) r12
            int r2 = r2 + r13
            if (r13 < 0) goto L_0x0350
            d9.r0 r12 = r10.f13596r
            int r12 = r12.size()
            if (r2 > r12) goto L_0x0350
            r14 = r82
        L_0x02d8:
            if (r13 >= r2) goto L_0x0342
            d9.r0 r12 = r10.f13596r
            java.lang.Object r12 = r12.get(r13)
            r1.i r12 = (r1.i) r12
            r78 = r1
            long r0 = r10.f13589k
            int r39 = (r27 > r0 ? 1 : (r27 == r0 ? 0 : -1))
            if (r39 == 0) goto L_0x02f5
            int r0 = r10.f13588j
            int r0 = r0 - r26
            int r1 = r12.f13569k
            int r0 = r0 + r1
            r1.i r12 = r12.a(r0, r14)
        L_0x02f5:
            r0 = r90
            r0.add(r12)
            r10 = r2
            long r1 = r12.f13568j
            long r14 = r14 + r1
            long r1 = r12.f13575q
            r41 = -1
            int r39 = (r1 > r41 ? 1 : (r1 == r41 ? 0 : -1))
            r41 = r10
            r79 = r11
            if (r39 == 0) goto L_0x030f
            long r10 = r12.f13574p
            long r10 = r10 + r1
            r37 = r10
        L_0x030f:
            java.lang.String r1 = r12.f13573o
            if (r1 == 0) goto L_0x031d
            java.lang.String r2 = java.lang.Long.toHexString(r49)
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x031f
        L_0x031d:
            r56 = r1
        L_0x031f:
            long r49 = r49 + r46
            int r13 = r13 + 1
            int r1 = r12.f13569k
            r1.i r2 = r12.f13567i
            g1.u r10 = r12.f13571m
            java.lang.String r11 = r12.f13572n
            r90 = r0
            r81 = r1
            r85 = r2
            r39 = r10
            r77 = r11
            r51 = r14
            r2 = r41
            r1 = r78
            r11 = r79
            r0 = r93
            r10 = r94
            goto L_0x02d8
        L_0x0342:
            r78 = r1
            r79 = r11
            r0 = r90
            r1 = r93
            r2 = r94
            r82 = r14
            goto L_0x0559
        L_0x0350:
            d6.d r0 = new d6.d
            r0.<init>()
            throw r0
        L_0x0356:
            r78 = r1
            r79 = r11
            r0 = r90
            java.lang.String r1 = "#EXT-X-KEY"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x03cc
            java.util.regex.Pattern r1 = N
            java.lang.String r1 = k(r13, r1, r3)
            java.util.regex.Pattern r10 = O
            java.lang.String r11 = "identity"
            java.lang.String r10 = i(r13, r10, r11, r3)
            java.lang.String r12 = "NONE"
            boolean r12 = r12.equals(r1)
            if (r12 == 0) goto L_0x0380
            r9.clear()
            r43 = 0
            goto L_0x03c4
        L_0x0380:
            java.util.regex.Pattern r12 = R
            r14 = 0
            java.lang.String r43 = i(r13, r12, r14, r3)
            boolean r11 = r11.equals(r10)
            if (r11 == 0) goto L_0x039c
            java.lang.String r10 = "AES-128"
            boolean r1 = r10.equals(r1)
            if (r1 == 0) goto L_0x03c6
            java.lang.String r1 = k(r13, r2, r3)
            r77 = r1
            goto L_0x03c8
        L_0x039c:
            r11 = r80
            if (r11 != 0) goto L_0x03b9
            java.lang.String r2 = "SAMPLE-AES-CENC"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x03b4
            java.lang.String r2 = "SAMPLE-AES-CTR"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x03b1
            goto L_0x03b4
        L_0x03b1:
            java.lang.String r1 = "cbcs"
            goto L_0x03b6
        L_0x03b4:
            java.lang.String r1 = "cenc"
        L_0x03b6:
            r80 = r1
            goto L_0x03bb
        L_0x03b9:
            r80 = r11
        L_0x03bb:
            g1.t r1 = c(r13, r10, r3)
            if (r1 == 0) goto L_0x03c6
            r9.put(r10, r1)
        L_0x03c4:
            r39 = 0
        L_0x03c6:
            r77 = 0
        L_0x03c8:
            r56 = r43
            goto L_0x0555
        L_0x03cc:
            r11 = r80
            java.lang.String r1 = "#EXT-X-BYTERANGE"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x03f4
            java.util.regex.Pattern r1 = J
            java.lang.String r1 = k(r13, r1, r3)
            int r2 = j1.l0.f8453a
            java.lang.String[] r1 = r1.split(r10, r12)
            r2 = 0
            r10 = r1[r2]
            long r57 = java.lang.Long.parseLong(r10)
            int r2 = r1.length
            r10 = 1
            if (r2 <= r10) goto L_0x0441
            r1 = r1[r10]
            long r37 = java.lang.Long.parseLong(r1)
            goto L_0x0441
        L_0x03f4:
            r1 = 1
            java.lang.String r14 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r14 = r13.startsWith(r14)
            r12 = 58
            if (r14 == 0) goto L_0x0416
            int r2 = r13.indexOf(r12)
            int r2 = r2 + r1
            java.lang.String r1 = r13.substring(r2)
            int r26 = java.lang.Integer.parseInt(r1)
            r1 = r93
            r2 = r94
            r80 = r11
            r25 = 1
            goto L_0x0559
        L_0x0416:
            java.lang.String r1 = "#EXT-X-DISCONTINUITY"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0421
            int r81 = r81 + 1
            goto L_0x0441
        L_0x0421:
            java.lang.String r1 = "#EXT-X-PROGRAM-DATE-TIME"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0445
            int r1 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x04e0
            int r1 = r13.indexOf(r12)
            r2 = 1
            int r1 = r1 + r2
            java.lang.String r1 = r13.substring(r1)
            long r1 = j1.l0.K(r1)
            long r1 = j1.l0.H(r1)
            long r23 = r1 - r82
        L_0x0441:
            r80 = r11
            goto L_0x0555
        L_0x0445:
            java.lang.String r1 = "#EXT-X-DATERANGE"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0452
            j1.v.b()
            goto L_0x04e0
        L_0x0452:
            java.lang.String r1 = "#EXT-X-GAP"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0464
            r1 = r93
            r2 = r94
            r80 = r11
            r53 = 1
            goto L_0x0559
        L_0x0464:
            java.lang.String r1 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0476
            r1 = r93
            r2 = r94
            r80 = r11
            r34 = 1
            goto L_0x0559
        L_0x0476:
            java.lang.String r1 = "#EXT-X-ENDLIST"
            boolean r1 = r13.equals(r1)
            if (r1 == 0) goto L_0x0488
            r1 = r93
            r2 = r94
            r80 = r11
            r35 = 1
            goto L_0x0559
        L_0x0488:
            java.lang.String r1 = "#EXT-X-RENDITION-REPORT"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x04c7
            java.util.regex.Pattern r1 = G
            long r14 = h(r13, r1)
            java.util.regex.Pattern r1 = H
            java.util.regex.Matcher r1 = r1.matcher(r13)
            boolean r10 = r1.find()
            if (r10 == 0) goto L_0x04af
            r10 = 1
            java.lang.String r1 = r1.group(r10)
            r1.getClass()
            int r12 = java.lang.Integer.parseInt(r1)
            goto L_0x04b0
        L_0x04af:
            r12 = -1
        L_0x04b0:
            java.lang.String r1 = k(r13, r2, r3)
            r2 = r96
            java.lang.String r1 = j1.j0.c(r2, r1)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r1.h r10 = new r1.h
            r10.<init>(r1, r14, r12)
            r6.add(r10)
            goto L_0x04e0
        L_0x04c7:
            java.lang.String r1 = "#EXT-X-PRELOAD-HINT"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0569
            if (r5 == 0) goto L_0x04d2
            goto L_0x04e0
        L_0x04d2:
            java.util.regex.Pattern r1 = T
            java.lang.String r1 = k(r13, r1, r3)
            java.lang.String r10 = "PART"
            boolean r1 = r10.equals(r1)
            if (r1 != 0) goto L_0x04e4
        L_0x04e0:
            r90 = r8
            goto L_0x0639
        L_0x04e4:
            java.lang.String r60 = k(r13, r2, r3)
            java.util.regex.Pattern r1 = L
            long r1 = h(r13, r1)
            java.util.regex.Pattern r10 = M
            long r72 = h(r13, r10)
            if (r77 != 0) goto L_0x04f9
            r69 = 0
            goto L_0x0504
        L_0x04f9:
            if (r56 == 0) goto L_0x04fe
            r69 = r56
            goto L_0x0504
        L_0x04fe:
            java.lang.String r10 = java.lang.Long.toHexString(r49)
            r69 = r10
        L_0x0504:
            if (r39 != 0) goto L_0x0529
            boolean r10 = r9.isEmpty()
            if (r10 != 0) goto L_0x0529
            java.util.Collection r10 = r9.values()
            r12 = 0
            g1.t[] r13 = new g1.t[r12]
            java.lang.Object[] r10 = r10.toArray(r13)
            g1.t[] r10 = (g1.t[]) r10
            g1.u r12 = new g1.u
            r13 = 1
            r12.<init>(r11, r13, r10)
            if (r36 != 0) goto L_0x0527
            g1.u r10 = b(r11, r10)
            r36 = r10
        L_0x0527:
            r39 = r12
        L_0x0529:
            r12 = -1
            int r10 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r10 == 0) goto L_0x0533
            int r14 = (r72 > r12 ? 1 : (r72 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x0441
        L_0x0533:
            r1.g r5 = new r1.g
            r62 = 0
            if (r10 == 0) goto L_0x053c
            r70 = r1
            goto L_0x053e
        L_0x053c:
            r70 = r16
        L_0x053e:
            r74 = 0
            r75 = 0
            r76 = 1
            r59 = r5
            r61 = r85
            r64 = r81
            r65 = r51
            r67 = r39
            r68 = r77
            r59.<init>(r60, r61, r62, r64, r65, r67, r68, r69, r70, r72, r74, r75, r76)
            goto L_0x0441
        L_0x0555:
            r1 = r93
            r2 = r94
        L_0x0559:
            r15 = r0
            r11 = r79
            r0 = r93
            r79 = r2
            r2 = 0
            r92 = r78
            r78 = r1
            r1 = r92
            goto L_0x00a2
        L_0x0569:
            java.lang.String r1 = "#EXT-X-PART"
            boolean r1 = r13.startsWith(r1)
            if (r1 == 0) goto L_0x0626
            if (r77 != 0) goto L_0x0576
            r69 = 0
            goto L_0x0581
        L_0x0576:
            if (r56 == 0) goto L_0x057b
            r69 = r56
            goto L_0x0581
        L_0x057b:
            java.lang.String r1 = java.lang.Long.toHexString(r49)
            r69 = r1
        L_0x0581:
            java.lang.String r60 = k(r13, r2, r3)
            java.util.Map r1 = java.util.Collections.emptyMap()
            java.util.regex.Pattern r2 = f4554t
            java.lang.String r1 = k(r13, r2, r1)
            double r1 = java.lang.Double.parseDouble(r1)
            double r1 = r1 * r41
            long r1 = (long) r1
            java.util.regex.Pattern r12 = f4538c0
            boolean r12 = f(r13, r12)
            if (r34 == 0) goto L_0x05a6
            boolean r14 = r7.isEmpty()
            if (r14 == 0) goto L_0x05a6
            r14 = 1
            goto L_0x05a7
        L_0x05a6:
            r14 = 0
        L_0x05a7:
            r75 = r12 | r14
            java.util.regex.Pattern r12 = f4539d0
            boolean r74 = f(r13, r12)
            r14 = 0
            java.lang.String r12 = i(r13, r15, r14, r3)
            if (r12 == 0) goto L_0x05cf
            int r13 = j1.l0.f8453a
            r13 = -1
            java.lang.String[] r10 = r12.split(r10, r13)
            r12 = 0
            r13 = r10[r12]
            long r12 = java.lang.Long.parseLong(r13)
            int r15 = r10.length
            r14 = 1
            if (r15 <= r14) goto L_0x05d1
            r10 = r10[r14]
            long r88 = java.lang.Long.parseLong(r10)
            goto L_0x05d1
        L_0x05cf:
            r12 = -1
        L_0x05d1:
            r14 = -1
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 != 0) goto L_0x05d9
            r88 = r16
        L_0x05d9:
            if (r39 != 0) goto L_0x0601
            boolean r14 = r9.isEmpty()
            if (r14 != 0) goto L_0x0601
            java.util.Collection r14 = r9.values()
            r90 = r8
            r15 = 0
            g1.t[] r8 = new g1.t[r15]
            java.lang.Object[] r8 = r14.toArray(r8)
            g1.t[] r8 = (g1.t[]) r8
            g1.u r14 = new g1.u
            r15 = 1
            r14.<init>(r11, r15, r8)
            if (r36 != 0) goto L_0x05fe
            g1.u r8 = b(r11, r8)
            r36 = r8
        L_0x05fe:
            r39 = r14
            goto L_0x0603
        L_0x0601:
            r90 = r8
        L_0x0603:
            r1.g r8 = new r1.g
            r59 = r8
            r76 = 0
            r61 = r85
            r62 = r1
            r64 = r81
            r65 = r51
            r67 = r39
            r68 = r77
            r70 = r88
            r72 = r12
            r59.<init>(r60, r61, r62, r64, r65, r67, r68, r69, r70, r72, r74, r75, r76)
            r7.add(r8)
            long r51 = r51 + r1
            if (r10 == 0) goto L_0x0639
            long r88 = r88 + r12
            goto L_0x0639
        L_0x0626:
            r90 = r8
            java.lang.String r1 = "#"
            boolean r1 = r13.startsWith(r1)
            java.lang.String r2 = "#EXT-X-TWITCH-PREFETCH"
            if (r1 == 0) goto L_0x064b
            boolean r1 = r13.startsWith(r2)
            if (r1 == 0) goto L_0x0639
            goto L_0x064b
        L_0x0639:
            r15 = r0
            r80 = r11
            r1 = r78
            r11 = r79
            r8 = r90
            r2 = 0
            r0 = r93
            r78 = r0
            r79 = r94
            goto L_0x00a2
        L_0x064b:
            if (r77 != 0) goto L_0x064f
            r1 = 0
            goto L_0x0658
        L_0x064f:
            if (r56 == 0) goto L_0x0654
            r1 = r56
            goto L_0x0658
        L_0x0654:
            java.lang.String r1 = java.lang.Long.toHexString(r49)
        L_0x0658:
            long r14 = r49 + r46
            boolean r2 = r13.startsWith(r2)
            if (r2 == 0) goto L_0x066c
            int r2 = r13.indexOf(r12)
            r8 = 1
            int r2 = r2 + r8
            java.lang.String r13 = r13.substring(r2)
            r86 = r44
        L_0x066c:
            java.lang.String r2 = l(r13, r3)
            java.lang.String r8 = "-unmuted"
            java.lang.String r10 = "-muted"
            java.lang.String r2 = r2.replace(r8, r10)
            java.lang.Object r8 = r4.get(r2)
            r1.i r8 = (r1.i) r8
            r12 = -1
            int r10 = (r57 > r12 ? 1 : (r57 == r12 ? 0 : -1))
            if (r10 != 0) goto L_0x0687
            r12 = r16
            goto L_0x06a3
        L_0x0687:
            if (r84 == 0) goto L_0x06a1
            if (r85 != 0) goto L_0x06a1
            if (r8 != 0) goto L_0x06a1
            r1.i r8 = new r1.i
            r43 = 0
            r47 = 0
            r48 = 0
            r41 = r8
            r42 = r2
            r45 = r37
            r41.<init>(r42, r43, r45, r47, r48)
            r4.put(r2, r8)
        L_0x06a1:
            r12 = r37
        L_0x06a3:
            if (r39 != 0) goto L_0x06cb
            boolean r37 = r9.isEmpty()
            if (r37 != 0) goto L_0x06cb
            r59 = r3
            java.util.Collection r3 = r9.values()
            r60 = r4
            r37 = r8
            r4 = 0
            g1.t[] r8 = new g1.t[r4]
            java.lang.Object[] r3 = r3.toArray(r8)
            g1.t[] r3 = (g1.t[]) r3
            g1.u r8 = new g1.u
            r4 = 1
            r8.<init>(r11, r4, r3)
            if (r36 != 0) goto L_0x06d3
            g1.u r36 = b(r11, r3)
            goto L_0x06d3
        L_0x06cb:
            r59 = r3
            r60 = r4
            r37 = r8
            r8 = r39
        L_0x06d3:
            r1.i r3 = new r1.i
            if (r85 == 0) goto L_0x06da
            r39 = r85
            goto L_0x06dc
        L_0x06da:
            r39 = r37
        L_0x06dc:
            r37 = r3
            r38 = r2
            r41 = r86
            r43 = r81
            r44 = r82
            r46 = r8
            r47 = r77
            r48 = r1
            r49 = r12
            r51 = r57
            r54 = r7
            r37.<init>(r38, r39, r40, r41, r43, r44, r46, r47, r48, r49, r51, r53, r54)
            r0.add(r3)
            long r51 = r82 + r86
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r10 == 0) goto L_0x0703
            long r12 = r12 + r57
        L_0x0703:
            r37 = r12
            r39 = r8
            r80 = r11
            r49 = r14
            r86 = r16
            r82 = r51
            r3 = r59
            r4 = r60
            r1 = r78
            r11 = r79
            r40 = r11
            r8 = r90
            r2 = 0
            r53 = 0
            r57 = -1
            r78 = r93
            r79 = r94
            r15 = r0
            r0 = r78
            goto L_0x00a2
        L_0x0729:
            r78 = r1
            r90 = r8
            r0 = r15
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r10 = 0
        L_0x0734:
            int r2 = r6.size()
            if (r10 >= r2) goto L_0x0788
            java.lang.Object r2 = r6.get(r10)
            r1.h r2 = (r1.h) r2
            long r3 = r2.f13562b
            r8 = -1
            int r11 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x0755
            int r3 = r0.size()
            long r3 = (long) r3
            long r3 = r27 + r3
            boolean r11 = r7.isEmpty()
            long r11 = (long) r11
            long r3 = r3 - r11
        L_0x0755:
            int r11 = r2.f13563c
            r12 = -1
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r11 != r12) goto L_0x077a
            int r15 = (r32 > r13 ? 1 : (r32 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x077a
            boolean r11 = r7.isEmpty()
            if (r11 == 0) goto L_0x0772
            java.lang.Object r11 = d9.v0.a(r0)
            r1.i r11 = (r1.i) r11
            d9.r0 r11 = r11.f13565t
            goto L_0x0773
        L_0x0772:
            r11 = r7
        L_0x0773:
            int r11 = r11.size()
            r15 = 1
            int r11 = r11 - r15
            goto L_0x077b
        L_0x077a:
            r15 = 1
        L_0x077b:
            r1.h r8 = new r1.h
            android.net.Uri r2 = r2.f13561a
            r8.<init>(r2, r3, r11)
            r1.put(r2, r8)
            int r10 = r10 + 1
            goto L_0x0734
        L_0x0788:
            r15 = 1
            if (r5 == 0) goto L_0x078e
            r7.add(r5)
        L_0x078e:
            r1.l r2 = new r1.l
            int r3 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x0797
            r91 = 1
            goto L_0x0799
        L_0x0797:
            r91 = 0
        L_0x0799:
            r5 = r2
            r6 = r78
            r3 = r7
            r7 = r96
            r8 = r90
            r9 = r20
            r11 = r22
            r12 = r23
            r14 = r25
            r15 = r26
            r16 = r27
            r18 = r29
            r19 = r30
            r21 = r32
            r23 = r34
            r24 = r35
            r25 = r91
            r26 = r36
            r27 = r0
            r28 = r3
            r29 = r55
            r30 = r1
            r5.<init>(r6, r7, r8, r9, r11, r12, r14, r15, r16, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: d6.e.d(r1.o, r1.l, r1.r, java.lang.String):r1.l");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static r1.o e(r1.r r36, java.lang.String r37) {
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
            java.util.regex.Pattern r9 = Q
            java.lang.String r15 = "application/x-mpegURL"
            r19 = r10
            java.util.regex.Pattern r10 = V
            if (r14 == 0) goto L_0x0221
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
            java.lang.String r7 = k(r14, r10, r11)
            java.util.regex.Pattern r8 = f4541f0
            java.lang.String r8 = k(r14, r8, r11)
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
            java.util.regex.Pattern r7 = O
            java.lang.String r8 = "identity"
            java.lang.String r7 = i(r14, r7, r8, r11)
            g1.t r7 = c(r14, r7, r11)
            if (r7 == 0) goto L_0x00d5
            java.util.regex.Pattern r8 = N
            java.lang.String r8 = k(r14, r8, r11)
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
            goto L_0x0209
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
            java.util.Map r10 = java.util.Collections.emptyMap()
            r22 = r13
            java.util.regex.Pattern r13 = f4549o
            java.lang.String r10 = k(r14, r13, r10)
            int r10 = java.lang.Integer.parseInt(r10)
            java.util.regex.Pattern r13 = f4544j
            java.util.regex.Matcher r13 = r13.matcher(r14)
            boolean r23 = r13.find()
            r30 = r12
            if (r23 == 0) goto L_0x011c
            r12 = 1
            java.lang.String r13 = r13.group(r12)
            r13.getClass()
            int r12 = java.lang.Integer.parseInt(r13)
            goto L_0x011d
        L_0x011c:
            r12 = -1
        L_0x011d:
            java.util.regex.Pattern r13 = f4551q
            r31 = r6
            r6 = 0
            java.lang.String r13 = i(r14, r13, r6, r11)
            r32 = r5
            java.util.regex.Pattern r5 = f4552r
            java.lang.String r5 = i(r14, r5, r6, r11)
            if (r5 == 0) goto L_0x0157
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
            if (r4 <= 0) goto L_0x0151
            if (r5 > 0) goto L_0x014e
            goto L_0x0151
        L_0x014e:
            r16 = r4
            goto L_0x0154
        L_0x0151:
            r5 = -1
            r16 = -1
        L_0x0154:
            r4 = r16
            goto L_0x015b
        L_0x0157:
            r33 = r4
            r4 = -1
            r5 = -1
        L_0x015b:
            java.util.regex.Pattern r6 = f4553s
            r34 = r3
            r3 = 0
            java.lang.String r6 = i(r14, r6, r3, r11)
            if (r6 == 0) goto L_0x016b
            float r6 = java.lang.Float.parseFloat(r6)
            goto L_0x016d
        L_0x016b:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x016d:
            r35 = r0
            java.util.regex.Pattern r0 = f4545k
            java.lang.String r0 = i(r14, r0, r3, r11)
            r16 = r0
            java.util.regex.Pattern r0 = f4546l
            java.lang.String r0 = i(r14, r0, r3, r11)
            r17 = r0
            java.util.regex.Pattern r0 = f4547m
            java.lang.String r0 = i(r14, r0, r3, r11)
            r18 = r0
            java.util.regex.Pattern r0 = f4548n
            java.lang.String r0 = i(r14, r0, r3, r11)
            if (r7 == 0) goto L_0x0194
            java.lang.String r3 = k(r14, r9, r11)
            goto L_0x01a2
        L_0x0194:
            boolean r3 = r36.a()
            if (r3 == 0) goto L_0x021a
            java.lang.String r3 = r36.b()
            java.lang.String r3 = l(r3, r11)
        L_0x01a2:
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
            r23 = r5
            r24 = r3
            r25 = r4
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r0
            r23.<init>(r24, r25, r26, r27, r28, r29)
            r2.add(r5)
            r4 = r35
            java.lang.Object r5 = r4.get(r3)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x01ef
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r4.put(r3, r5)
        L_0x01ef:
            q1.y r3 = new q1.y
            r23 = r3
            r24 = r12
            r25 = r10
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r0
            r23.<init>(r24, r25, r26, r27, r28, r29)
            r5.add(r3)
            r10 = r19
            r13 = r22
        L_0x0209:
            r0 = r4
            r7 = r20
            r8 = r21
            r12 = r30
            r6 = r31
            r5 = r32
            r4 = r33
            r3 = r34
            goto L_0x0036
        L_0x021a:
            java.lang.String r0 = "#EXT-X-STREAM-INF must be followed by another line"
            g1.b1 r0 = g1.b1.b(r0)
            throw r0
        L_0x0221:
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
        L_0x023b:
            int r6 = r2.size()
            if (r5 >= r6) goto L_0x02b3
            java.lang.Object r6 = r2.get(r5)
            r1.n r6 = (r1.n) r6
            android.net.Uri r7 = r6.f13604a
            boolean r7 = r0.add(r7)
            if (r7 == 0) goto L_0x02a8
            g1.a0 r7 = r6.f13605b
            g1.z0 r8 = r7.f6274q
            if (r8 != 0) goto L_0x0257
            r8 = 1
            goto L_0x0258
        L_0x0257:
            r8 = 0
        L_0x0258:
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
            goto L_0x02ac
        L_0x02a8:
            r36 = r0
            r35 = r4
        L_0x02ac:
            int r5 = r5 + 1
            r0 = r36
            r4 = r35
            goto L_0x023b
        L_0x02b3:
            r0 = 0
            r6 = 0
            r8 = 0
        L_0x02b6:
            int r4 = r34.size()
            if (r0 >= r4) goto L_0x0559
            r4 = r34
            java.lang.Object r5 = r4.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r7 = W
            java.lang.String r7 = k(r5, r7, r11)
            java.lang.String r12 = k(r5, r10, r11)
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
            java.util.regex.Pattern r4 = f4536a0
            boolean r4 = f(r5, r4)
            java.util.regex.Pattern r10 = f4537b0
            boolean r10 = f(r5, r10)
            if (r10 == 0) goto L_0x02ff
            r4 = r4 | 2
        L_0x02ff:
            java.util.regex.Pattern r10 = Z
            boolean r10 = f(r5, r10)
            if (r10 == 0) goto L_0x0309
            r4 = r4 | 4
        L_0x0309:
            r14.f6747d = r4
            java.util.regex.Pattern r4 = X
            r10 = 0
            java.lang.String r4 = i(r5, r4, r10, r11)
            boolean r10 = android.text.TextUtils.isEmpty(r4)
            if (r10 == 0) goto L_0x031c
            r23 = r15
            r4 = 0
            goto L_0x0353
        L_0x031c:
            int r10 = j1.l0.f8453a
            java.lang.String r10 = ","
            r23 = r15
            r15 = -1
            java.lang.String[] r4 = r4.split(r10, r15)
            java.lang.String r10 = "public.accessibility.describes-video"
            boolean r10 = j1.l0.j(r4, r10)
            if (r10 == 0) goto L_0x0332
            r10 = 512(0x200, float:7.175E-43)
            goto L_0x0333
        L_0x0332:
            r10 = 0
        L_0x0333:
            java.lang.String r15 = "public.accessibility.transcribes-spoken-dialog"
            boolean r15 = j1.l0.j(r4, r15)
            if (r15 == 0) goto L_0x033d
            r10 = r10 | 4096(0x1000, float:5.74E-42)
        L_0x033d:
            java.lang.String r15 = "public.accessibility.describes-music-and-sound"
            boolean r15 = j1.l0.j(r4, r15)
            if (r15 == 0) goto L_0x0347
            r10 = r10 | 1024(0x400, float:1.435E-42)
        L_0x0347:
            java.lang.String r15 = "public.easy-to-read"
            boolean r4 = j1.l0.j(r4, r15)
            if (r4 == 0) goto L_0x0352
            r4 = r10 | 8192(0x2000, float:1.14794E-41)
            goto L_0x0353
        L_0x0352:
            r4 = r10
        L_0x0353:
            r14.f6748e = r4
            java.util.regex.Pattern r4 = U
            r10 = 0
            java.lang.String r4 = i(r5, r4, r10, r11)
            r14.f6746c = r4
            java.lang.String r4 = i(r5, r9, r10, r11)
            if (r4 != 0) goto L_0x0366
            r4 = 0
            goto L_0x036a
        L_0x0366:
            android.net.Uri r4 = j1.j0.d(r1, r4)
        L_0x036a:
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
            java.util.regex.Pattern r1 = S
            java.lang.String r1 = k(r5, r1, r11)
            int r9 = r1.hashCode()
            r15 = 2
            switch(r9) {
                case -959297733: goto L_0x03b0;
                case -333210994: goto L_0x03a5;
                case 62628790: goto L_0x039a;
                case 81665115: goto L_0x038f;
                default: goto L_0x038e;
            }
        L_0x038e:
            goto L_0x03bb
        L_0x038f:
            java.lang.String r9 = "VIDEO"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0398
            goto L_0x03bb
        L_0x0398:
            r1 = 3
            goto L_0x03bc
        L_0x039a:
            java.lang.String r9 = "AUDIO"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x03a3
            goto L_0x03bb
        L_0x03a3:
            r1 = 2
            goto L_0x03bc
        L_0x03a5:
            java.lang.String r9 = "CLOSED-CAPTIONS"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x03ae
            goto L_0x03bb
        L_0x03ae:
            r1 = 1
            goto L_0x03bc
        L_0x03b0:
            java.lang.String r9 = "SUBTITLES"
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x03b9
            goto L_0x03bb
        L_0x03b9:
            r1 = 0
            goto L_0x03bc
        L_0x03bb:
            r1 = -1
        L_0x03bc:
            if (r1 == 0) goto L_0x04ed
            r9 = 1
            if (r1 == r9) goto L_0x04a8
            if (r1 == r15) goto L_0x041d
            r9 = 3
            if (r1 == r9) goto L_0x03c9
        L_0x03c6:
            r9 = r33
            goto L_0x0415
        L_0x03c9:
            r1 = 0
        L_0x03ca:
            int r5 = r2.size()
            if (r1 >= r5) goto L_0x03e2
            java.lang.Object r5 = r2.get(r1)
            r1.n r5 = (r1.n) r5
            java.lang.String r9 = r5.f13606c
            boolean r9 = r7.equals(r9)
            if (r9 == 0) goto L_0x03df
            goto L_0x03e3
        L_0x03df:
            int r1 = r1 + 1
            goto L_0x03ca
        L_0x03e2:
            r5 = 0
        L_0x03e3:
            if (r5 == 0) goto L_0x0401
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
        L_0x0401:
            if (r4 != 0) goto L_0x0404
            goto L_0x03c6
        L_0x0404:
            r14.f6752i = r10
            r1.m r1 = new r1.m
            g1.a0 r5 = new g1.a0
            r5.<init>(r14)
            r1.<init>(r4, r5, r12)
            r9 = r33
            r9.add(r1)
        L_0x0415:
            r25 = r8
            r7 = r31
            r5 = r32
            goto L_0x0545
        L_0x041d:
            r9 = r33
            r1 = 0
        L_0x0420:
            int r15 = r2.size()
            if (r1 >= r15) goto L_0x043c
            java.lang.Object r15 = r2.get(r1)
            r1.n r15 = (r1.n) r15
            r25 = r8
            java.lang.String r8 = r15.f13607d
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x0437
            goto L_0x043f
        L_0x0437:
            int r1 = r1 + 1
            r8 = r25
            goto L_0x0420
        L_0x043c:
            r25 = r8
            r15 = 0
        L_0x043f:
            if (r15 == 0) goto L_0x0451
            g1.a0 r1 = r15.f13605b
            java.lang.String r1 = r1.f6273p
            r8 = 1
            java.lang.String r1 = j1.l0.o(r8, r1)
            r14.f6751h = r1
            java.lang.String r1 = g1.a1.d(r1)
            goto L_0x0453
        L_0x0451:
            r8 = 1
            r1 = 0
        L_0x0453:
            java.util.regex.Pattern r7 = f4550p
            r8 = 0
            java.lang.String r5 = i(r5, r7, r8, r11)
            if (r5 == 0) goto L_0x0485
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
            if (r7 == 0) goto L_0x0486
            java.lang.String r7 = "/JOC"
            boolean r5 = r5.endsWith(r7)
            if (r5 == 0) goto L_0x0486
            java.lang.String r1 = "ec+3"
            r14.f6751h = r1
            java.lang.String r1 = "audio/eac3-joc"
            goto L_0x0486
        L_0x0485:
            r8 = 0
        L_0x0486:
            r14.f6754k = r1
            if (r4 == 0) goto L_0x049c
            r14.f6752i = r10
            r1.m r1 = new r1.m
            g1.a0 r5 = new g1.a0
            r5.<init>(r14)
            r1.<init>(r4, r5, r12)
            r4 = r32
            r4.add(r1)
            goto L_0x04e7
        L_0x049c:
            r4 = r32
            if (r15 == 0) goto L_0x04e7
            g1.a0 r1 = new g1.a0
            r1.<init>(r14)
            r25 = r1
            goto L_0x04e7
        L_0x04a8:
            r25 = r8
            r4 = r32
            r9 = r33
            r8 = 0
            java.util.regex.Pattern r1 = Y
            java.lang.String r1 = k(r5, r1, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r1.startsWith(r5)
            if (r5 == 0) goto L_0x04c9
            r5 = 2
            java.lang.String r1 = r1.substring(r5)
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r5 = "application/cea-608"
            goto L_0x04d4
        L_0x04c9:
            r5 = 7
            java.lang.String r1 = r1.substring(r5)
            int r1 = java.lang.Integer.parseInt(r1)
            java.lang.String r5 = "application/cea-708"
        L_0x04d4:
            if (r6 != 0) goto L_0x04db
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x04db:
            r14.f6754k = r5
            r14.C = r1
            g1.a0 r1 = new g1.a0
            r1.<init>(r14)
            r6.add(r1)
        L_0x04e7:
            r5 = r4
            r8 = r25
            r7 = r31
            goto L_0x0547
        L_0x04ed:
            r25 = r8
            r5 = r32
            r9 = r33
            r8 = 0
            r15 = 0
        L_0x04f5:
            int r1 = r2.size()
            if (r15 >= r1) goto L_0x050e
            java.lang.Object r1 = r2.get(r15)
            r1.n r1 = (r1.n) r1
            java.lang.String r8 = r1.f13608e
            boolean r8 = r7.equals(r8)
            if (r8 == 0) goto L_0x050a
            goto L_0x050f
        L_0x050a:
            int r15 = r15 + 1
            r8 = 0
            goto L_0x04f5
        L_0x050e:
            r1 = 0
        L_0x050f:
            if (r1 == 0) goto L_0x0521
            g1.a0 r1 = r1.f13605b
            java.lang.String r1 = r1.f6273p
            r7 = 3
            java.lang.String r1 = j1.l0.o(r7, r1)
            r14.f6751h = r1
            java.lang.String r1 = g1.a1.d(r1)
            goto L_0x0522
        L_0x0521:
            r1 = 0
        L_0x0522:
            if (r1 != 0) goto L_0x0526
            java.lang.String r1 = "text/vtt"
        L_0x0526:
            r14.f6754k = r1
            r14.f6752i = r10
            if (r4 == 0) goto L_0x053c
            r1.m r1 = new r1.m
            g1.a0 r7 = new g1.a0
            r7.<init>(r14)
            r1.<init>(r4, r7, r12)
            r7 = r31
            r7.add(r1)
            goto L_0x0545
        L_0x053c:
            r7 = r31
            java.lang.String r1 = "HlsPlaylistParser"
            java.lang.String r4 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            j1.v.g(r1, r4)
        L_0x0545:
            r8 = r25
        L_0x0547:
            int r0 = r0 + 1
            r1 = r37
            r32 = r5
            r31 = r7
            r33 = r9
            r10 = r22
            r15 = r23
            r9 = r24
            goto L_0x02b6
        L_0x0559:
            r25 = r8
            r7 = r31
            r5 = r32
            r9 = r33
            if (r13 == 0) goto L_0x0569
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
            goto L_0x056a
        L_0x0569:
            r10 = r6
        L_0x056a:
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
        throw new UnsupportedOperationException("Method not decompiled: d6.e.e(r1.r, java.lang.String):r1.o");
    }

    public static boolean f(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return Constants.YES.equals(matcher.group(1));
        }
        return false;
    }

    public static double g(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -9.223372036854776E18d;
        }
        String group = matcher.group(1);
        group.getClass();
        return Double.parseDouble(group);
    }

    public static long h(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        String group = matcher.group(1);
        group.getClass();
        return Long.parseLong(group);
    }

    public static String i(String str, Pattern pattern, String str2, Map map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
            str2.getClass();
        }
        if (map.isEmpty() || str2 == null) {
            return str2;
        }
        return l(str2, map);
    }

    public static String k(String str, Pattern pattern, Map map) {
        String i10 = i(str, pattern, (String) null, map);
        if (i10 != null) {
            return i10;
        }
        throw b1.b("Couldn't match " + pattern.pattern() + " in " + str);
    }

    public static String l(String str, Map map) {
        Matcher matcher = f4543h0.matcher(str);
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

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006b A[Catch:{ all -> 0x003b }, LOOP:3: B:32:0x006b->B:87:0x006b, LOOP_START] */
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
            if (r1 != r2) goto L_0x0069
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            r2 = 191(0xbf, float:2.68E-43)
            if (r1 == r2) goto L_0x0029
            goto L_0x0069
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
            if (r4 >= r5) goto L_0x0052
            java.lang.String r5 = "#EXTM3U"
            char r5 = r5.charAt(r4)     // Catch:{ all -> 0x003b }
            if (r1 == r5) goto L_0x004b
            goto L_0x0069
        L_0x004b:
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0052:
            if (r1 == r2) goto L_0x0065
            boolean r3 = java.lang.Character.isWhitespace(r1)     // Catch:{ all -> 0x003b }
            if (r3 == 0) goto L_0x0065
            boolean r3 = j1.l0.E(r1)     // Catch:{ all -> 0x003b }
            if (r3 != 0) goto L_0x0065
            int r1 = r0.read()     // Catch:{ all -> 0x003b }
            goto L_0x0052
        L_0x0065:
            boolean r3 = j1.l0.E(r1)     // Catch:{ all -> 0x003b }
        L_0x0069:
            if (r3 == 0) goto L_0x0101
        L_0x006b:
            java.lang.String r1 = r0.readLine()     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x00f5
            java.lang.String r1 = r1.trim()     // Catch:{ all -> 0x003b }
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x007c
            goto L_0x006b
        L_0x007c:
            java.lang.String r2 = "#EXT-X-STREAM-INF"
            boolean r2 = r1.startsWith(r2)     // Catch:{ all -> 0x003b }
            r3 = 1
            if (r2 == 0) goto L_0x0096
            r8.add(r1)     // Catch:{ all -> 0x003b }
            r1.r r1 = new r1.r     // Catch:{ all -> 0x003b }
            r1.<init>(r8, r0, r3)     // Catch:{ all -> 0x003b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x003b }
            r1.o r7 = e(r1, r7)     // Catch:{ all -> 0x003b }
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
            goto L_0x006b
        L_0x00db:
            r8.add(r1)     // Catch:{ all -> 0x003b }
            r1.o r1 = r6.f4561h     // Catch:{ all -> 0x003b }
            r1.l r2 = r6.f4562i     // Catch:{ all -> 0x003b }
            r1.r r4 = new r1.r     // Catch:{ all -> 0x003b }
            r4.<init>(r8, r0, r3)     // Catch:{ all -> 0x003b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x003b }
            r1.l r7 = d(r1, r2, r4, r7)     // Catch:{ all -> 0x003b }
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
        throw new UnsupportedOperationException("Method not decompiled: d6.e.j(android.net.Uri, k1.j):java.lang.Object");
    }

    public e(o oVar, l lVar) {
        this.f4561h = oVar;
        this.f4562i = lVar;
    }
}
