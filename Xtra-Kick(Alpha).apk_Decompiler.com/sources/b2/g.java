package b2;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.emoji2.text.r;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.a0;
import g1.a1;
import g1.b2;
import g1.o;
import g1.z;
import j1.i0;
import j1.l0;
import j1.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import m1.h;
import m1.k0;
import m1.o1;
import m1.w0;
import o1.f;
import oa.a;
import p0.c;
import p1.e0;
import s1.c0;
import s1.i;
import s1.k;
import s1.m;
import s1.n;
import s1.q;
import s1.u;
import s1.v;
import s1.w;
import s1.y;

public final class g extends u {

    /* renamed from: t1  reason: collision with root package name */
    public static final int[] f2433t1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: u1  reason: collision with root package name */
    public static boolean f2434u1;

    /* renamed from: v1  reason: collision with root package name */
    public static boolean f2435v1;
    public final Context J0;
    public final t K0;
    public final x L0;
    public final long M0;
    public final int N0 = 50;
    public final boolean O0;
    public e P0;
    public boolean Q0;
    public boolean R0;
    public Surface S0;
    public i T0;
    public boolean U0;
    public int V0;
    public boolean W0;
    public boolean X0;
    public boolean Y0;
    public long Z0;

    /* renamed from: a1  reason: collision with root package name */
    public long f2436a1;

    /* renamed from: b1  reason: collision with root package name */
    public long f2437b1;

    /* renamed from: c1  reason: collision with root package name */
    public int f2438c1;

    /* renamed from: d1  reason: collision with root package name */
    public int f2439d1;

    /* renamed from: e1  reason: collision with root package name */
    public int f2440e1;

    /* renamed from: f1  reason: collision with root package name */
    public long f2441f1;

    /* renamed from: g1  reason: collision with root package name */
    public long f2442g1;

    /* renamed from: h1  reason: collision with root package name */
    public long f2443h1;

    /* renamed from: i1  reason: collision with root package name */
    public int f2444i1;

    /* renamed from: j1  reason: collision with root package name */
    public long f2445j1;

    /* renamed from: k1  reason: collision with root package name */
    public int f2446k1;

    /* renamed from: l1  reason: collision with root package name */
    public int f2447l1;

    /* renamed from: m1  reason: collision with root package name */
    public int f2448m1;

    /* renamed from: n1  reason: collision with root package name */
    public float f2449n1;

    /* renamed from: o1  reason: collision with root package name */
    public b2 f2450o1;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f2451p1;

    /* renamed from: q1  reason: collision with root package name */
    public int f2452q1;

    /* renamed from: r1  reason: collision with root package name */
    public f f2453r1;

    /* renamed from: s1  reason: collision with root package name */
    public m f2454s1;

    public g(Context context, i iVar, e0 e0Var, long j10, Handler handler, k0 k0Var) {
        super(2, iVar, e0Var, 30.0f);
        this.M0 = j10;
        Context applicationContext = context.getApplicationContext();
        this.J0 = applicationContext;
        this.K0 = new t(applicationContext);
        this.L0 = new x(handler, k0Var);
        this.O0 = "NVIDIA".equals(l0.f8455c);
        this.f2436a1 = -9223372036854775807L;
        this.f2446k1 = -1;
        this.f2447l1 = -1;
        this.f2449n1 = -1.0f;
        this.V0 = 1;
        this.f2452q1 = 0;
        this.f2450o1 = null;
    }

    public static boolean r0(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (g.class) {
            if (!f2434u1) {
                f2435v1 = s0();
                f2434u1 = true;
            }
        }
        return f2435v1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x0848, code lost:
        if (r0.equals("PGN528") == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08ae, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean s0() {
        /*
            int r0 = j1.l0.f8453a
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = -1
            r8 = 0
            r9 = 1
            r10 = 28
            if (r0 > r10) goto L_0x007a
            java.lang.String r11 = j1.l0.f8454b
            r11.getClass()
            int r12 = r11.hashCode()
            switch(r12) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r11 = -1
            goto L_0x0075
        L_0x001e:
            java.lang.String r12 = "machuca"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r11 = 7
            goto L_0x0075
        L_0x0029:
            java.lang.String r12 = "once"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r11 = 6
            goto L_0x0075
        L_0x0034:
            java.lang.String r12 = "magnolia"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r11 = 5
            goto L_0x0075
        L_0x003f:
            java.lang.String r12 = "aquaman"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r11 = 4
            goto L_0x0075
        L_0x004a:
            java.lang.String r12 = "oneday"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r11 = 3
            goto L_0x0075
        L_0x0055:
            java.lang.String r12 = "dangalUHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r11 = 2
            goto L_0x0075
        L_0x0060:
            java.lang.String r12 = "dangalFHD"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r11 = 1
            goto L_0x0075
        L_0x006b:
            java.lang.String r12 = "dangal"
            boolean r11 = r11.equals(r12)
            if (r11 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r11 = 0
        L_0x0075:
            switch(r11) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r9
        L_0x007a:
            r11 = 27
            if (r0 > r11) goto L_0x0089
            java.lang.String r12 = "HWEML"
            java.lang.String r13 = j1.l0.f8454b
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0089
            return r9
        L_0x0089:
            java.lang.String r12 = j1.l0.f8456d
            r12.getClass()
            int r13 = r12.hashCode()
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f4;
                case -321033677: goto L_0x00e9;
                case 2006354: goto L_0x00de;
                case 2006367: goto L_0x00d3;
                case 2006371: goto L_0x00c8;
                case 1785421873: goto L_0x00bd;
                case 1785421876: goto L_0x00b2;
                case 1798172390: goto L_0x00a7;
                case 2119412532: goto L_0x009a;
                default: goto L_0x0097;
            }
        L_0x0097:
            r13 = -1
            goto L_0x00fe
        L_0x009a:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00a3
            goto L_0x0097
        L_0x00a3:
            r13 = 8
            goto L_0x00fe
        L_0x00a7:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00b0
            goto L_0x0097
        L_0x00b0:
            r13 = 7
            goto L_0x00fe
        L_0x00b2:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00bb
            goto L_0x0097
        L_0x00bb:
            r13 = 6
            goto L_0x00fe
        L_0x00bd:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00c6
            goto L_0x0097
        L_0x00c6:
            r13 = 5
            goto L_0x00fe
        L_0x00c8:
            java.lang.String r13 = "AFTR"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00d1
            goto L_0x0097
        L_0x00d1:
            r13 = 4
            goto L_0x00fe
        L_0x00d3:
            java.lang.String r13 = "AFTN"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00dc
            goto L_0x0097
        L_0x00dc:
            r13 = 3
            goto L_0x00fe
        L_0x00de:
            java.lang.String r13 = "AFTA"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00e7
            goto L_0x0097
        L_0x00e7:
            r13 = 2
            goto L_0x00fe
        L_0x00e9:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00f2
            goto L_0x0097
        L_0x00f2:
            r13 = 1
            goto L_0x00fe
        L_0x00f4:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00fd
            goto L_0x0097
        L_0x00fd:
            r13 = 0
        L_0x00fe:
            switch(r13) {
                case 0: goto L_0x08b0;
                case 1: goto L_0x08b0;
                case 2: goto L_0x08b0;
                case 3: goto L_0x08b0;
                case 4: goto L_0x08b0;
                case 5: goto L_0x08b0;
                case 6: goto L_0x08b0;
                case 7: goto L_0x08b0;
                case 8: goto L_0x08b0;
                default: goto L_0x0101;
            }
        L_0x0101:
            r13 = 26
            if (r0 > r13) goto L_0x08af
            java.lang.String r0 = j1.l0.f8454b
            r0.getClass()
            int r15 = r0.hashCode()
            switch(r15) {
                case -2144781245: goto L_0x0894;
                case -2144781185: goto L_0x0888;
                case -2144781160: goto L_0x087c;
                case -2097309513: goto L_0x0870;
                case -2022874474: goto L_0x0864;
                case -1978993182: goto L_0x0858;
                case -1978990237: goto L_0x084c;
                case -1936688988: goto L_0x0842;
                case -1936688066: goto L_0x0835;
                case -1936688065: goto L_0x0827;
                case -1931988508: goto L_0x0819;
                case -1885099851: goto L_0x080b;
                case -1696512866: goto L_0x07fd;
                case -1680025915: goto L_0x07ef;
                case -1615810839: goto L_0x07e1;
                case -1600724499: goto L_0x07d3;
                case -1554255044: goto L_0x07c5;
                case -1481772737: goto L_0x07b7;
                case -1481772730: goto L_0x07a9;
                case -1481772729: goto L_0x079b;
                case -1320080169: goto L_0x078d;
                case -1217592143: goto L_0x077f;
                case -1180384755: goto L_0x0771;
                case -1139198265: goto L_0x0763;
                case -1052835013: goto L_0x0755;
                case -993250464: goto L_0x0747;
                case -993250458: goto L_0x0739;
                case -965403638: goto L_0x072b;
                case -958336948: goto L_0x071d;
                case -879245230: goto L_0x070f;
                case -842500323: goto L_0x0701;
                case -821392978: goto L_0x06f3;
                case -797483286: goto L_0x06e5;
                case -794946968: goto L_0x06d7;
                case -788334647: goto L_0x06c9;
                case -782144577: goto L_0x06bb;
                case -575125681: goto L_0x06ad;
                case -521118391: goto L_0x069f;
                case -430914369: goto L_0x0691;
                case -290434366: goto L_0x0683;
                case -282781963: goto L_0x0675;
                case -277133239: goto L_0x0667;
                case -173639913: goto L_0x0659;
                case -56598463: goto L_0x064b;
                case 2126: goto L_0x063d;
                case 2564: goto L_0x062f;
                case 2715: goto L_0x0621;
                case 2719: goto L_0x0613;
                case 3091: goto L_0x0605;
                case 3483: goto L_0x05f7;
                case 73405: goto L_0x05e9;
                case 75537: goto L_0x05db;
                case 75739: goto L_0x05cd;
                case 76779: goto L_0x05bf;
                case 78669: goto L_0x05b1;
                case 79305: goto L_0x05a3;
                case 80618: goto L_0x0595;
                case 88274: goto L_0x0587;
                case 98846: goto L_0x0579;
                case 98848: goto L_0x056b;
                case 99329: goto L_0x055d;
                case 101481: goto L_0x054f;
                case 1513190: goto L_0x0541;
                case 1514184: goto L_0x0533;
                case 1514185: goto L_0x0525;
                case 2133089: goto L_0x0517;
                case 2133091: goto L_0x0509;
                case 2133120: goto L_0x04fb;
                case 2133151: goto L_0x04ed;
                case 2133182: goto L_0x04df;
                case 2133184: goto L_0x04d1;
                case 2436959: goto L_0x04c3;
                case 2463773: goto L_0x04b5;
                case 2464648: goto L_0x04a7;
                case 2689555: goto L_0x0499;
                case 3154429: goto L_0x048b;
                case 3284551: goto L_0x047d;
                case 3351335: goto L_0x046f;
                case 3386211: goto L_0x0461;
                case 41325051: goto L_0x0453;
                case 51349633: goto L_0x0445;
                case 51350594: goto L_0x0437;
                case 55178625: goto L_0x0429;
                case 61542055: goto L_0x041b;
                case 65355429: goto L_0x040d;
                case 66214468: goto L_0x03ff;
                case 66214470: goto L_0x03f1;
                case 66214473: goto L_0x03e3;
                case 66215429: goto L_0x03d5;
                case 66215431: goto L_0x03c7;
                case 66215433: goto L_0x03b9;
                case 66216390: goto L_0x03ab;
                case 76402249: goto L_0x039d;
                case 76404105: goto L_0x038f;
                case 76404911: goto L_0x0381;
                case 80963634: goto L_0x0373;
                case 82882791: goto L_0x0365;
                case 98715550: goto L_0x0357;
                case 101370885: goto L_0x0349;
                case 102844228: goto L_0x033b;
                case 165221241: goto L_0x032d;
                case 182191441: goto L_0x031f;
                case 245388979: goto L_0x0311;
                case 287431619: goto L_0x0303;
                case 307593612: goto L_0x02f5;
                case 308517133: goto L_0x02e7;
                case 316215098: goto L_0x02d9;
                case 316215116: goto L_0x02cb;
                case 316246811: goto L_0x02bd;
                case 316246818: goto L_0x02af;
                case 407160593: goto L_0x02a1;
                case 507412548: goto L_0x0293;
                case 793982701: goto L_0x0285;
                case 794038622: goto L_0x0277;
                case 794040393: goto L_0x0269;
                case 835649806: goto L_0x025b;
                case 917340916: goto L_0x024d;
                case 958008161: goto L_0x023f;
                case 1060579533: goto L_0x0231;
                case 1150207623: goto L_0x0223;
                case 1176899427: goto L_0x0215;
                case 1280332038: goto L_0x0207;
                case 1306947716: goto L_0x01f9;
                case 1349174697: goto L_0x01eb;
                case 1522194893: goto L_0x01dd;
                case 1691543273: goto L_0x01cf;
                case 1691544261: goto L_0x01c1;
                case 1709443163: goto L_0x01b3;
                case 1865889110: goto L_0x01a5;
                case 1906253259: goto L_0x0197;
                case 1977196784: goto L_0x0189;
                case 2006372676: goto L_0x017c;
                case 2019281702: goto L_0x016f;
                case 2029784656: goto L_0x0162;
                case 2030379515: goto L_0x0155;
                case 2033393791: goto L_0x0148;
                case 2047190025: goto L_0x013b;
                case 2047252157: goto L_0x012e;
                case 2048319463: goto L_0x0121;
                case 2048855701: goto L_0x0114;
                default: goto L_0x0111;
            }
        L_0x0111:
            r1 = -1
            goto L_0x089f
        L_0x0114:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011d
            goto L_0x0111
        L_0x011d:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x089f
        L_0x0121:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012a
            goto L_0x0111
        L_0x012a:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x089f
        L_0x012e:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0137
            goto L_0x0111
        L_0x0137:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x089f
        L_0x013b:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0144
            goto L_0x0111
        L_0x0144:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x089f
        L_0x0148:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0151
            goto L_0x0111
        L_0x0151:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x089f
        L_0x0155:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x015e
            goto L_0x0111
        L_0x015e:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x089f
        L_0x0162:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016b
            goto L_0x0111
        L_0x016b:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x089f
        L_0x016f:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0178
            goto L_0x0111
        L_0x0178:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x089f
        L_0x017c:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0185
            goto L_0x0111
        L_0x0185:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x089f
        L_0x0189:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0193
            goto L_0x0111
        L_0x0193:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x089f
        L_0x0197:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a1
            goto L_0x0111
        L_0x01a1:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x089f
        L_0x01a5:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01af
            goto L_0x0111
        L_0x01af:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x089f
        L_0x01b3:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01bd
            goto L_0x0111
        L_0x01bd:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x089f
        L_0x01c1:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01cb
            goto L_0x0111
        L_0x01cb:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x089f
        L_0x01cf:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d9
            goto L_0x0111
        L_0x01d9:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x089f
        L_0x01dd:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e7
            goto L_0x0111
        L_0x01e7:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x089f
        L_0x01eb:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f5
            goto L_0x0111
        L_0x01f5:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x089f
        L_0x01f9:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0203
            goto L_0x0111
        L_0x0203:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x089f
        L_0x0207:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0211
            goto L_0x0111
        L_0x0211:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x089f
        L_0x0215:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x021f
            goto L_0x0111
        L_0x021f:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x089f
        L_0x0223:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x022d
            goto L_0x0111
        L_0x022d:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x089f
        L_0x0231:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x023b
            goto L_0x0111
        L_0x023b:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x089f
        L_0x023f:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0249
            goto L_0x0111
        L_0x0249:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x089f
        L_0x024d:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0257
            goto L_0x0111
        L_0x0257:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x089f
        L_0x025b:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0265
            goto L_0x0111
        L_0x0265:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x089f
        L_0x0269:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0273
            goto L_0x0111
        L_0x0273:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x089f
        L_0x0277:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0281
            goto L_0x0111
        L_0x0281:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x089f
        L_0x0285:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028f
            goto L_0x0111
        L_0x028f:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x089f
        L_0x0293:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x029d
            goto L_0x0111
        L_0x029d:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x089f
        L_0x02a1:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ab
            goto L_0x0111
        L_0x02ab:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x089f
        L_0x02af:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b9
            goto L_0x0111
        L_0x02b9:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x089f
        L_0x02bd:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c7
            goto L_0x0111
        L_0x02c7:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x089f
        L_0x02cb:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d5
            goto L_0x0111
        L_0x02d5:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x089f
        L_0x02d9:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e3
            goto L_0x0111
        L_0x02e3:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x089f
        L_0x02e7:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f1
            goto L_0x0111
        L_0x02f1:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x089f
        L_0x02f5:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02ff
            goto L_0x0111
        L_0x02ff:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x089f
        L_0x0303:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x030d
            goto L_0x0111
        L_0x030d:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x089f
        L_0x0311:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x031b
            goto L_0x0111
        L_0x031b:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x089f
        L_0x031f:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0329
            goto L_0x0111
        L_0x0329:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x089f
        L_0x032d:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0337
            goto L_0x0111
        L_0x0337:
            r1 = 100
            goto L_0x089f
        L_0x033b:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0345
            goto L_0x0111
        L_0x0345:
            r1 = 99
            goto L_0x089f
        L_0x0349:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0353
            goto L_0x0111
        L_0x0353:
            r1 = 98
            goto L_0x089f
        L_0x0357:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0361
            goto L_0x0111
        L_0x0361:
            r1 = 97
            goto L_0x089f
        L_0x0365:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x036f
            goto L_0x0111
        L_0x036f:
            r1 = 96
            goto L_0x089f
        L_0x0373:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x037d
            goto L_0x0111
        L_0x037d:
            r1 = 95
            goto L_0x089f
        L_0x0381:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x038b
            goto L_0x0111
        L_0x038b:
            r1 = 94
            goto L_0x089f
        L_0x038f:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0399
            goto L_0x0111
        L_0x0399:
            r1 = 93
            goto L_0x089f
        L_0x039d:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a7
            goto L_0x0111
        L_0x03a7:
            r1 = 92
            goto L_0x089f
        L_0x03ab:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b5
            goto L_0x0111
        L_0x03b5:
            r1 = 91
            goto L_0x089f
        L_0x03b9:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c3
            goto L_0x0111
        L_0x03c3:
            r1 = 90
            goto L_0x089f
        L_0x03c7:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d1
            goto L_0x0111
        L_0x03d1:
            r1 = 89
            goto L_0x089f
        L_0x03d5:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03df
            goto L_0x0111
        L_0x03df:
            r1 = 88
            goto L_0x089f
        L_0x03e3:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ed
            goto L_0x0111
        L_0x03ed:
            r1 = 87
            goto L_0x089f
        L_0x03f1:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03fb
            goto L_0x0111
        L_0x03fb:
            r1 = 86
            goto L_0x089f
        L_0x03ff:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0409
            goto L_0x0111
        L_0x0409:
            r1 = 85
            goto L_0x089f
        L_0x040d:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0417
            goto L_0x0111
        L_0x0417:
            r1 = 84
            goto L_0x089f
        L_0x041b:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0425
            goto L_0x0111
        L_0x0425:
            r1 = 83
            goto L_0x089f
        L_0x0429:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0433
            goto L_0x0111
        L_0x0433:
            r1 = 82
            goto L_0x089f
        L_0x0437:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0441
            goto L_0x0111
        L_0x0441:
            r1 = 81
            goto L_0x089f
        L_0x0445:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x044f
            goto L_0x0111
        L_0x044f:
            r1 = 80
            goto L_0x089f
        L_0x0453:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x045d
            goto L_0x0111
        L_0x045d:
            r1 = 79
            goto L_0x089f
        L_0x0461:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x046b
            goto L_0x0111
        L_0x046b:
            r1 = 78
            goto L_0x089f
        L_0x046f:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0479
            goto L_0x0111
        L_0x0479:
            r1 = 77
            goto L_0x089f
        L_0x047d:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0487
            goto L_0x0111
        L_0x0487:
            r1 = 76
            goto L_0x089f
        L_0x048b:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0495
            goto L_0x0111
        L_0x0495:
            r1 = 75
            goto L_0x089f
        L_0x0499:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a3
            goto L_0x0111
        L_0x04a3:
            r1 = 74
            goto L_0x089f
        L_0x04a7:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b1
            goto L_0x0111
        L_0x04b1:
            r1 = 73
            goto L_0x089f
        L_0x04b5:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04bf
            goto L_0x0111
        L_0x04bf:
            r1 = 72
            goto L_0x089f
        L_0x04c3:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04cd
            goto L_0x0111
        L_0x04cd:
            r1 = 71
            goto L_0x089f
        L_0x04d1:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04db
            goto L_0x0111
        L_0x04db:
            r1 = 70
            goto L_0x089f
        L_0x04df:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e9
            goto L_0x0111
        L_0x04e9:
            r1 = 69
            goto L_0x089f
        L_0x04ed:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f7
            goto L_0x0111
        L_0x04f7:
            r1 = 68
            goto L_0x089f
        L_0x04fb:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0505
            goto L_0x0111
        L_0x0505:
            r1 = 67
            goto L_0x089f
        L_0x0509:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0513
            goto L_0x0111
        L_0x0513:
            r1 = 66
            goto L_0x089f
        L_0x0517:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0521
            goto L_0x0111
        L_0x0521:
            r1 = 65
            goto L_0x089f
        L_0x0525:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x052f
            goto L_0x0111
        L_0x052f:
            r1 = 64
            goto L_0x089f
        L_0x0533:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x053d
            goto L_0x0111
        L_0x053d:
            r1 = 63
            goto L_0x089f
        L_0x0541:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x054b
            goto L_0x0111
        L_0x054b:
            r1 = 62
            goto L_0x089f
        L_0x054f:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0559
            goto L_0x0111
        L_0x0559:
            r1 = 61
            goto L_0x089f
        L_0x055d:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0567
            goto L_0x0111
        L_0x0567:
            r1 = 60
            goto L_0x089f
        L_0x056b:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0575
            goto L_0x0111
        L_0x0575:
            r1 = 59
            goto L_0x089f
        L_0x0579:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0583
            goto L_0x0111
        L_0x0583:
            r1 = 58
            goto L_0x089f
        L_0x0587:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0591
            goto L_0x0111
        L_0x0591:
            r1 = 57
            goto L_0x089f
        L_0x0595:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x059f
            goto L_0x0111
        L_0x059f:
            r1 = 56
            goto L_0x089f
        L_0x05a3:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ad
            goto L_0x0111
        L_0x05ad:
            r1 = 55
            goto L_0x089f
        L_0x05b1:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05bb
            goto L_0x0111
        L_0x05bb:
            r1 = 54
            goto L_0x089f
        L_0x05bf:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c9
            goto L_0x0111
        L_0x05c9:
            r1 = 53
            goto L_0x089f
        L_0x05cd:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d7
            goto L_0x0111
        L_0x05d7:
            r1 = 52
            goto L_0x089f
        L_0x05db:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e5
            goto L_0x0111
        L_0x05e5:
            r1 = 51
            goto L_0x089f
        L_0x05e9:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f3
            goto L_0x0111
        L_0x05f3:
            r1 = 50
            goto L_0x089f
        L_0x05f7:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0601
            goto L_0x0111
        L_0x0601:
            r1 = 49
            goto L_0x089f
        L_0x0605:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060f
            goto L_0x0111
        L_0x060f:
            r1 = 48
            goto L_0x089f
        L_0x0613:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x061d
            goto L_0x0111
        L_0x061d:
            r1 = 47
            goto L_0x089f
        L_0x0621:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x062b
            goto L_0x0111
        L_0x062b:
            r1 = 46
            goto L_0x089f
        L_0x062f:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0639
            goto L_0x0111
        L_0x0639:
            r1 = 45
            goto L_0x089f
        L_0x063d:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0647
            goto L_0x0111
        L_0x0647:
            r1 = 44
            goto L_0x089f
        L_0x064b:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0655
            goto L_0x0111
        L_0x0655:
            r1 = 43
            goto L_0x089f
        L_0x0659:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0663
            goto L_0x0111
        L_0x0663:
            r1 = 42
            goto L_0x089f
        L_0x0667:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0671
            goto L_0x0111
        L_0x0671:
            r1 = 41
            goto L_0x089f
        L_0x0675:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067f
            goto L_0x0111
        L_0x067f:
            r1 = 40
            goto L_0x089f
        L_0x0683:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068d
            goto L_0x0111
        L_0x068d:
            r1 = 39
            goto L_0x089f
        L_0x0691:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069b
            goto L_0x0111
        L_0x069b:
            r1 = 38
            goto L_0x089f
        L_0x069f:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a9
            goto L_0x0111
        L_0x06a9:
            r1 = 37
            goto L_0x089f
        L_0x06ad:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b7
            goto L_0x0111
        L_0x06b7:
            r1 = 36
            goto L_0x089f
        L_0x06bb:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c5
            goto L_0x0111
        L_0x06c5:
            r1 = 35
            goto L_0x089f
        L_0x06c9:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d3
            goto L_0x0111
        L_0x06d3:
            r1 = 34
            goto L_0x089f
        L_0x06d7:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06e1
            goto L_0x0111
        L_0x06e1:
            r1 = 33
            goto L_0x089f
        L_0x06e5:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ef
            goto L_0x0111
        L_0x06ef:
            r1 = 32
            goto L_0x089f
        L_0x06f3:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06fd
            goto L_0x0111
        L_0x06fd:
            r1 = 31
            goto L_0x089f
        L_0x0701:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x070b
            goto L_0x0111
        L_0x070b:
            r1 = 30
            goto L_0x089f
        L_0x070f:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0719
            goto L_0x0111
        L_0x0719:
            r1 = 29
            goto L_0x089f
        L_0x071d:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0727
            goto L_0x0111
        L_0x0727:
            r1 = 28
            goto L_0x089f
        L_0x072b:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0735
            goto L_0x0111
        L_0x0735:
            r1 = 27
            goto L_0x089f
        L_0x0739:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0743
            goto L_0x0111
        L_0x0743:
            r1 = 26
            goto L_0x089f
        L_0x0747:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0751
            goto L_0x0111
        L_0x0751:
            r1 = 25
            goto L_0x089f
        L_0x0755:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075f
            goto L_0x0111
        L_0x075f:
            r1 = 24
            goto L_0x089f
        L_0x0763:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076d
            goto L_0x0111
        L_0x076d:
            r1 = 23
            goto L_0x089f
        L_0x0771:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x077b
            goto L_0x0111
        L_0x077b:
            r1 = 22
            goto L_0x089f
        L_0x077f:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0789
            goto L_0x0111
        L_0x0789:
            r1 = 21
            goto L_0x089f
        L_0x078d:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0797
            goto L_0x0111
        L_0x0797:
            r1 = 20
            goto L_0x089f
        L_0x079b:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a5
            goto L_0x0111
        L_0x07a5:
            r1 = 19
            goto L_0x089f
        L_0x07a9:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b3
            goto L_0x0111
        L_0x07b3:
            r1 = 18
            goto L_0x089f
        L_0x07b7:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07c1
            goto L_0x0111
        L_0x07c1:
            r1 = 17
            goto L_0x089f
        L_0x07c5:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cf
            goto L_0x0111
        L_0x07cf:
            r1 = 16
            goto L_0x089f
        L_0x07d3:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07dd
            goto L_0x0111
        L_0x07dd:
            r1 = 15
            goto L_0x089f
        L_0x07e1:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07eb
            goto L_0x0111
        L_0x07eb:
            r1 = 14
            goto L_0x089f
        L_0x07ef:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07f9
            goto L_0x0111
        L_0x07f9:
            r1 = 13
            goto L_0x089f
        L_0x07fd:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0807
            goto L_0x0111
        L_0x0807:
            r1 = 12
            goto L_0x089f
        L_0x080b:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0815
            goto L_0x0111
        L_0x0815:
            r1 = 11
            goto L_0x089f
        L_0x0819:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0823
            goto L_0x0111
        L_0x0823:
            r1 = 10
            goto L_0x089f
        L_0x0827:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0831
            goto L_0x0111
        L_0x0831:
            r1 = 9
            goto L_0x089f
        L_0x0835:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x083f
            goto L_0x0111
        L_0x083f:
            r1 = 8
            goto L_0x089f
        L_0x0842:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x089f
            goto L_0x0111
        L_0x084c:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0856
            goto L_0x0111
        L_0x0856:
            r1 = 6
            goto L_0x089f
        L_0x0858:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0862
            goto L_0x0111
        L_0x0862:
            r1 = 5
            goto L_0x089f
        L_0x0864:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x086e
            goto L_0x0111
        L_0x086e:
            r1 = 4
            goto L_0x089f
        L_0x0870:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x087a
            goto L_0x0111
        L_0x087a:
            r1 = 3
            goto L_0x089f
        L_0x087c:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0886
            goto L_0x0111
        L_0x0886:
            r1 = 2
            goto L_0x089f
        L_0x0888:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0892
            goto L_0x0111
        L_0x0892:
            r1 = 1
            goto L_0x089f
        L_0x0894:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x089e
            goto L_0x0111
        L_0x089e:
            r1 = 0
        L_0x089f:
            switch(r1) {
                case 0: goto L_0x08ae;
                case 1: goto L_0x08ae;
                case 2: goto L_0x08ae;
                case 3: goto L_0x08ae;
                case 4: goto L_0x08ae;
                case 5: goto L_0x08ae;
                case 6: goto L_0x08ae;
                case 7: goto L_0x08ae;
                case 8: goto L_0x08ae;
                case 9: goto L_0x08ae;
                case 10: goto L_0x08ae;
                case 11: goto L_0x08ae;
                case 12: goto L_0x08ae;
                case 13: goto L_0x08ae;
                case 14: goto L_0x08ae;
                case 15: goto L_0x08ae;
                case 16: goto L_0x08ae;
                case 17: goto L_0x08ae;
                case 18: goto L_0x08ae;
                case 19: goto L_0x08ae;
                case 20: goto L_0x08ae;
                case 21: goto L_0x08ae;
                case 22: goto L_0x08ae;
                case 23: goto L_0x08ae;
                case 24: goto L_0x08ae;
                case 25: goto L_0x08ae;
                case 26: goto L_0x08ae;
                case 27: goto L_0x08ae;
                case 28: goto L_0x08ae;
                case 29: goto L_0x08ae;
                case 30: goto L_0x08ae;
                case 31: goto L_0x08ae;
                case 32: goto L_0x08ae;
                case 33: goto L_0x08ae;
                case 34: goto L_0x08ae;
                case 35: goto L_0x08ae;
                case 36: goto L_0x08ae;
                case 37: goto L_0x08ae;
                case 38: goto L_0x08ae;
                case 39: goto L_0x08ae;
                case 40: goto L_0x08ae;
                case 41: goto L_0x08ae;
                case 42: goto L_0x08ae;
                case 43: goto L_0x08ae;
                case 44: goto L_0x08ae;
                case 45: goto L_0x08ae;
                case 46: goto L_0x08ae;
                case 47: goto L_0x08ae;
                case 48: goto L_0x08ae;
                case 49: goto L_0x08ae;
                case 50: goto L_0x08ae;
                case 51: goto L_0x08ae;
                case 52: goto L_0x08ae;
                case 53: goto L_0x08ae;
                case 54: goto L_0x08ae;
                case 55: goto L_0x08ae;
                case 56: goto L_0x08ae;
                case 57: goto L_0x08ae;
                case 58: goto L_0x08ae;
                case 59: goto L_0x08ae;
                case 60: goto L_0x08ae;
                case 61: goto L_0x08ae;
                case 62: goto L_0x08ae;
                case 63: goto L_0x08ae;
                case 64: goto L_0x08ae;
                case 65: goto L_0x08ae;
                case 66: goto L_0x08ae;
                case 67: goto L_0x08ae;
                case 68: goto L_0x08ae;
                case 69: goto L_0x08ae;
                case 70: goto L_0x08ae;
                case 71: goto L_0x08ae;
                case 72: goto L_0x08ae;
                case 73: goto L_0x08ae;
                case 74: goto L_0x08ae;
                case 75: goto L_0x08ae;
                case 76: goto L_0x08ae;
                case 77: goto L_0x08ae;
                case 78: goto L_0x08ae;
                case 79: goto L_0x08ae;
                case 80: goto L_0x08ae;
                case 81: goto L_0x08ae;
                case 82: goto L_0x08ae;
                case 83: goto L_0x08ae;
                case 84: goto L_0x08ae;
                case 85: goto L_0x08ae;
                case 86: goto L_0x08ae;
                case 87: goto L_0x08ae;
                case 88: goto L_0x08ae;
                case 89: goto L_0x08ae;
                case 90: goto L_0x08ae;
                case 91: goto L_0x08ae;
                case 92: goto L_0x08ae;
                case 93: goto L_0x08ae;
                case 94: goto L_0x08ae;
                case 95: goto L_0x08ae;
                case 96: goto L_0x08ae;
                case 97: goto L_0x08ae;
                case 98: goto L_0x08ae;
                case 99: goto L_0x08ae;
                case 100: goto L_0x08ae;
                case 101: goto L_0x08ae;
                case 102: goto L_0x08ae;
                case 103: goto L_0x08ae;
                case 104: goto L_0x08ae;
                case 105: goto L_0x08ae;
                case 106: goto L_0x08ae;
                case 107: goto L_0x08ae;
                case 108: goto L_0x08ae;
                case 109: goto L_0x08ae;
                case 110: goto L_0x08ae;
                case 111: goto L_0x08ae;
                case 112: goto L_0x08ae;
                case 113: goto L_0x08ae;
                case 114: goto L_0x08ae;
                case 115: goto L_0x08ae;
                case 116: goto L_0x08ae;
                case 117: goto L_0x08ae;
                case 118: goto L_0x08ae;
                case 119: goto L_0x08ae;
                case 120: goto L_0x08ae;
                case 121: goto L_0x08ae;
                case 122: goto L_0x08ae;
                case 123: goto L_0x08ae;
                case 124: goto L_0x08ae;
                case 125: goto L_0x08ae;
                case 126: goto L_0x08ae;
                case 127: goto L_0x08ae;
                case 128: goto L_0x08ae;
                case 129: goto L_0x08ae;
                case 130: goto L_0x08ae;
                case 131: goto L_0x08ae;
                case 132: goto L_0x08ae;
                case 133: goto L_0x08ae;
                case 134: goto L_0x08ae;
                case 135: goto L_0x08ae;
                case 136: goto L_0x08ae;
                case 137: goto L_0x08ae;
                case 138: goto L_0x08ae;
                case 139: goto L_0x08ae;
                default: goto L_0x08a2;
            }
        L_0x08a2:
            r12.getClass()
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r12.equals(r0)
            if (r0 != 0) goto L_0x08ae
            goto L_0x08af
        L_0x08ae:
            return r9
        L_0x08af:
            return r8
        L_0x08b0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.g.s0():boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        if (r4.equals("video/hevc") == false) goto L_0x0040;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int t0(g1.a0 r10, s1.q r11) {
        /*
            int r0 = r10.f6281x
            r1 = -1
            if (r0 == r1) goto L_0x00e3
            int r2 = r10.f6282y
            if (r2 != r1) goto L_0x000b
            goto L_0x00e3
        L_0x000b:
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r10.f6276s
            boolean r3 = r3.equals(r4)
            java.lang.String r5 = "video/avc"
            r6 = 2
            java.lang.String r7 = "video/hevc"
            r8 = 1
            if (r3 == 0) goto L_0x0034
            android.util.Pair r10 = s1.c0.d(r10)
            if (r10 == 0) goto L_0x0033
            java.lang.Object r10 = r10.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r10 == r3) goto L_0x0031
            if (r10 == r8) goto L_0x0031
            if (r10 != r6) goto L_0x0033
        L_0x0031:
            r4 = r5
            goto L_0x0034
        L_0x0033:
            r4 = r7
        L_0x0034:
            r4.getClass()
            int r10 = r4.hashCode()
            r3 = 4
            r9 = 3
            switch(r10) {
                case -1664118616: goto L_0x007e;
                case -1662735862: goto L_0x0073;
                case -1662541442: goto L_0x006c;
                case 1187890754: goto L_0x0061;
                case 1331836730: goto L_0x0058;
                case 1599127256: goto L_0x004d;
                case 1599127257: goto L_0x0042;
                default: goto L_0x0040;
            }
        L_0x0040:
            r6 = -1
            goto L_0x0088
        L_0x0042:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x004b
            goto L_0x0040
        L_0x004b:
            r6 = 6
            goto L_0x0088
        L_0x004d:
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x0056
            goto L_0x0040
        L_0x0056:
            r6 = 5
            goto L_0x0088
        L_0x0058:
            boolean r10 = r4.equals(r5)
            if (r10 != 0) goto L_0x005f
            goto L_0x0040
        L_0x005f:
            r6 = 4
            goto L_0x0088
        L_0x0061:
            java.lang.String r10 = "video/mp4v-es"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x006a
            goto L_0x0040
        L_0x006a:
            r6 = 3
            goto L_0x0088
        L_0x006c:
            boolean r10 = r4.equals(r7)
            if (r10 != 0) goto L_0x0088
            goto L_0x0040
        L_0x0073:
            java.lang.String r10 = "video/av01"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x007c
            goto L_0x0040
        L_0x007c:
            r6 = 1
            goto L_0x0088
        L_0x007e:
            java.lang.String r10 = "video/3gpp"
            boolean r10 = r4.equals(r10)
            if (r10 != 0) goto L_0x0087
            goto L_0x0040
        L_0x0087:
            r6 = 0
        L_0x0088:
            switch(r6) {
                case 0: goto L_0x00dd;
                case 1: goto L_0x00dd;
                case 2: goto L_0x00d1;
                case 3: goto L_0x00dd;
                case 4: goto L_0x0093;
                case 5: goto L_0x00dd;
                case 6: goto L_0x008c;
                default: goto L_0x008b;
            }
        L_0x008b:
            return r1
        L_0x008c:
            int r0 = r0 * r2
            int r0 = r0 * 3
            int r0 = r0 / 8
            return r0
        L_0x0093:
            java.lang.String r10 = j1.l0.f8456d
            java.lang.String r4 = "BRAVIA 4K 2015"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x00d0
            java.lang.String r4 = "Amazon"
            java.lang.String r5 = j1.l0.f8455c
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00bc
            java.lang.String r4 = "KFSOWI"
            boolean r4 = r4.equals(r10)
            if (r4 != 0) goto L_0x00d0
            java.lang.String r4 = "AFTS"
            boolean r10 = r4.equals(r10)
            if (r10 == 0) goto L_0x00bc
            boolean r10 = r11.f14038f
            if (r10 == 0) goto L_0x00bc
            goto L_0x00d0
        L_0x00bc:
            int r0 = r0 + 16
            int r0 = r0 + r1
            int r0 = r0 / 16
            int r2 = r2 + 16
            int r2 = r2 + r1
            int r2 = r2 / 16
            int r2 = r2 * r0
            int r2 = r2 * 16
            int r2 = r2 * 16
            int r2 = r2 * 3
            int r2 = r2 / r3
            return r2
        L_0x00d0:
            return r1
        L_0x00d1:
            int r0 = r0 * r2
            int r0 = r0 * 3
            int r0 = r0 / r3
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r10, r0)
            return r10
        L_0x00dd:
            int r0 = r0 * r2
            int r0 = r0 * 3
            int r0 = r0 / r3
            return r0
        L_0x00e3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.g.t0(g1.a0, s1.q):int");
    }

    public static r0 u0(Context context, v vVar, a0 a0Var, boolean z10, boolean z11) {
        String str = a0Var.f6276s;
        if (str == null) {
            p0 p0Var = r0.f4657i;
            return r1.f4658l;
        }
        ((e0) vVar).getClass();
        List e10 = c0.e(str, z10, z11);
        String b10 = c0.b(a0Var);
        if (b10 == null) {
            return r0.j(e10);
        }
        List e11 = c0.e(b10, z10, z11);
        if (l0.f8453a >= 26 && "video/dolby-vision".equals(a0Var.f6276s) && !e11.isEmpty() && !d.a(context)) {
            return r0.j(e11);
        }
        p0 p0Var2 = r0.f4657i;
        o0 o0Var = new o0();
        o0Var.d(e10);
        o0Var.d(e11);
        return o0Var.e();
    }

    public static int v0(a0 a0Var, q qVar) {
        if (a0Var.f6277t == -1) {
            return t0(a0Var, qVar);
        }
        List list = a0Var.f6278u;
        int size = list.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += ((byte[]) list.get(i11)).length;
        }
        return a0Var.f6277t + i10;
    }

    public final h A(q qVar, a0 a0Var, a0 a0Var2) {
        h b10 = qVar.b(a0Var, a0Var2);
        e eVar = this.P0;
        int i10 = eVar.f2428a;
        int i11 = a0Var2.f6281x;
        int i12 = b10.f10256e;
        if (i11 > i10 || a0Var2.f6282y > eVar.f2429b) {
            i12 |= 256;
        }
        if (v0(a0Var2, qVar) > this.P0.f2430c) {
            i12 |= 64;
        }
        int i13 = i12;
        return new h(qVar.f14033a, a0Var, a0Var2, i13 != 0 ? 0 : b10.f10255d, i13);
    }

    public final void A0(m mVar, int i10, long j10) {
        y0();
        i0.a("releaseOutputBuffer");
        mVar.m(i10, j10);
        i0.b();
        this.f2442g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f10235e++;
        this.f2439d1 = 0;
        x0();
    }

    public final n B(IllegalStateException illegalStateException, q qVar) {
        return new c(illegalStateException, qVar, this.S0);
    }

    public final boolean B0(q qVar) {
        return l0.f8453a >= 23 && !this.f2451p1 && !r0(qVar.f14033a) && (!qVar.f14038f || i.v(this.J0));
    }

    public final void C0(m mVar, int i10) {
        i0.a("skipVideoBuffer");
        mVar.d(i10, false);
        i0.b();
        this.E0.f10236f++;
    }

    public final void D0(int i10, int i11) {
        m1.g gVar = this.E0;
        gVar.f10238h += i10;
        int i12 = i10 + i11;
        gVar.f10237g += i12;
        this.f2438c1 += i12;
        int i13 = this.f2439d1 + i12;
        this.f2439d1 = i13;
        gVar.f10239i = Math.max(i13, gVar.f10239i);
        int i14 = this.N0;
        if (i14 > 0 && this.f2438c1 >= i14) {
            w0();
        }
    }

    public final void E0(long j10) {
        m1.g gVar = this.E0;
        gVar.f10241k += j10;
        gVar.f10242l++;
        this.f2443h1 += j10;
        this.f2444i1++;
    }

    public final boolean J() {
        return this.f2451p1 && l0.f8453a < 23;
    }

    public final float K(float f10, a0[] a0VarArr) {
        float f11 = -1.0f;
        for (a0 a0Var : a0VarArr) {
            float f12 = a0Var.f6283z;
            if (f12 != -1.0f) {
                f11 = Math.max(f11, f12);
            }
        }
        if (f11 == -1.0f) {
            return -1.0f;
        }
        return f11 * f10;
    }

    public final ArrayList L(v vVar, a0 a0Var, boolean z10) {
        r0 u02 = u0(this.J0, vVar, a0Var, z10, this.f2451p1);
        Pattern pattern = c0.f13983a;
        ArrayList arrayList = new ArrayList(u02);
        Collections.sort(arrayList, new a(2, new w(a0Var)));
        return arrayList;
    }

    public final k N(q qVar, a0 a0Var, MediaCrypto mediaCrypto, float f10) {
        String str;
        int i10;
        int i11;
        o oVar;
        e eVar;
        boolean z10;
        Pair d10;
        Point point;
        float f11;
        Point point2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i12;
        int t02;
        q qVar2 = qVar;
        a0 a0Var2 = a0Var;
        float f12 = f10;
        i iVar = this.T0;
        if (!(iVar == null || iVar.f2462h == qVar2.f14038f)) {
            if (this.S0 == iVar) {
                this.S0 = null;
            }
            iVar.release();
            this.T0 = null;
        }
        String str2 = qVar2.f14035c;
        a0[] a0VarArr = this.f10223o;
        a0VarArr.getClass();
        int i13 = a0Var2.f6281x;
        int v02 = v0(a0Var2, qVar2);
        int length = a0VarArr.length;
        float f13 = a0Var2.f6283z;
        int i14 = a0Var2.f6281x;
        o oVar2 = a0Var2.E;
        int i15 = a0Var2.f6282y;
        if (length == 1) {
            if (!(v02 == -1 || (t02 = t0(a0Var2, qVar2)) == -1)) {
                v02 = Math.min((int) (((float) v02) * 1.5f), t02);
            }
            eVar = new e(i13, i15, v02);
            str = str2;
            i11 = i15;
            i10 = i14;
            oVar = oVar2;
        } else {
            int length2 = a0VarArr.length;
            int i16 = i15;
            int i17 = 0;
            boolean z11 = false;
            while (i17 < length2) {
                a0 a0Var3 = a0VarArr[i17];
                a0[] a0VarArr2 = a0VarArr;
                if (oVar2 != null && a0Var3.E == null) {
                    z zVar = new z(a0Var3);
                    zVar.f6766w = oVar2;
                    a0Var3 = new a0(zVar);
                }
                if (qVar2.b(a0Var2, a0Var3).f10255d != 0) {
                    int i18 = a0Var3.f6282y;
                    i12 = length2;
                    int i19 = a0Var3.f6281x;
                    z11 |= i19 == -1 || i18 == -1;
                    int max = Math.max(i13, i19);
                    i16 = Math.max(i16, i18);
                    i13 = max;
                    v02 = Math.max(v02, v0(a0Var3, qVar2));
                } else {
                    i12 = length2;
                }
                i17++;
                float f14 = f10;
                a0VarArr = a0VarArr2;
                length2 = i12;
            }
            if (z11) {
                j1.v.g("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i13 + "x" + i16);
                boolean z12 = i15 > i14;
                int i20 = z12 ? i15 : i14;
                int i21 = z12 ? i14 : i15;
                oVar = oVar2;
                i11 = i15;
                float f15 = ((float) i21) / ((float) i20);
                int[] iArr = f2433t1;
                str = str2;
                i10 = i14;
                int i22 = 0;
                while (true) {
                    if (i22 >= 9) {
                        break;
                    }
                    int i23 = iArr[i22];
                    int[] iArr2 = iArr;
                    int i24 = (int) (((float) i23) * f15);
                    if (i23 <= i20 || i24 <= i21) {
                        break;
                    }
                    int i25 = i20;
                    int i26 = i21;
                    if (l0.f8453a >= 21) {
                        int i27 = z12 ? i24 : i23;
                        if (!z12) {
                            i23 = i24;
                        }
                        MediaCodecInfo.CodecCapabilities codecCapabilities = qVar2.f14036d;
                        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                            f11 = f15;
                            point2 = null;
                        } else {
                            int widthAlignment = videoCapabilities.getWidthAlignment();
                            int heightAlignment = videoCapabilities.getHeightAlignment();
                            f11 = f15;
                            point2 = new Point((((i27 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i23 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
                        }
                        if (qVar2.f(point2.x, point2.y, (double) f13)) {
                            point = point2;
                            break;
                        }
                    } else {
                        f11 = f15;
                        try {
                            int i28 = (((i23 + 16) - 1) / 16) * 16;
                            int i29 = (((i24 + 16) - 1) / 16) * 16;
                            if (i28 * i29 <= c0.i()) {
                                int i30 = z12 ? i29 : i28;
                                if (!z12) {
                                    i28 = i29;
                                }
                                point = new Point(i30, i28);
                            }
                        } catch (y unused) {
                        }
                    }
                    i22++;
                    iArr = iArr2;
                    i20 = i25;
                    i21 = i26;
                    f15 = f11;
                }
                point = null;
                if (point != null) {
                    i13 = Math.max(i13, point.x);
                    i16 = Math.max(i16, point.y);
                    z zVar2 = new z(a0Var2);
                    zVar2.f6759p = i13;
                    zVar2.f6760q = i16;
                    v02 = Math.max(v02, t0(new a0(zVar2), qVar2));
                    j1.v.g("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i13 + "x" + i16);
                }
            } else {
                str = str2;
                i11 = i15;
                i10 = i14;
                oVar = oVar2;
            }
            eVar = new e(i13, i16, v02);
        }
        this.P0 = eVar;
        int i31 = this.f2451p1 ? this.f2452q1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i10);
        mediaFormat.setInteger("height", i11);
        x.b(mediaFormat, a0Var2.f6278u);
        if (f13 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f13);
        }
        x.a(mediaFormat, "rotation-degrees", a0Var2.A);
        if (oVar != null) {
            o oVar3 = oVar;
            x.a(mediaFormat, "color-transfer", oVar3.f6492j);
            x.a(mediaFormat, "color-standard", oVar3.f6490h);
            x.a(mediaFormat, "color-range", oVar3.f6491i);
            byte[] bArr = oVar3.f6493k;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(a0Var2.f6276s) && (d10 = c0.d(a0Var)) != null) {
            x.a(mediaFormat, "profile", ((Integer) d10.first).intValue());
        }
        mediaFormat.setInteger("max-width", eVar.f2428a);
        mediaFormat.setInteger("max-height", eVar.f2429b);
        x.a(mediaFormat, "max-input-size", eVar.f2430c);
        if (l0.f8453a >= 23) {
            mediaFormat.setInteger("priority", 0);
            float f16 = f10;
            if (f16 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f16);
            }
        }
        if (this.O0) {
            z10 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z10 = true;
        }
        if (i31 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z10);
            mediaFormat.setInteger("audio-session-id", i31);
        }
        if (this.S0 == null) {
            if (B0(qVar)) {
                if (this.T0 == null) {
                    this.T0 = i.w(this.J0, qVar2.f14038f);
                }
                this.S0 = this.T0;
            } else {
                throw new IllegalStateException();
            }
        }
        return new k(qVar, mediaFormat, a0Var, this.S0, mediaCrypto);
    }

    public final void O(l1.h hVar) {
        if (this.R0) {
            ByteBuffer byteBuffer = hVar.f9518m;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b10 = byteBuffer.get();
                short s10 = byteBuffer.getShort();
                short s11 = byteBuffer.getShort();
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                byteBuffer.position(0);
                if (b10 != -75 || s10 != 60 || s11 != 1 || b11 != 4) {
                    return;
                }
                if (b12 == 0 || b12 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    m mVar = this.N;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    mVar.k(bundle);
                }
            }
        }
    }

    public final void S(Exception exc) {
        j1.v.d("MediaCodecVideoRenderer", "Video codec error", exc);
        x xVar = this.L0;
        Handler handler = xVar.f2511a;
        if (handler != null) {
            handler.post(new g.r0(xVar, 16, exc));
        }
    }

    public final void T(String str, long j10, long j11) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        x xVar = this.L0;
        Handler handler = xVar.f2511a;
        if (handler != null) {
            handler.post(new f(xVar, str, j10, j11, 1));
        }
        this.Q0 = r0(str);
        q qVar = this.U;
        qVar.getClass();
        boolean z10 = false;
        if (l0.f8453a >= 29 && "video/x-vnd.on2.vp9".equals(qVar.f14034b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = qVar.f14036d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                } else if (codecProfileLevelArr[i10].profile == 16384) {
                    z10 = true;
                    break;
                } else {
                    i10++;
                }
            }
        }
        this.R0 = z10;
        if (l0.f8453a >= 23 && this.f2451p1) {
            m mVar = this.N;
            mVar.getClass();
            this.f2453r1 = new f(this, mVar);
        }
    }

    public final void U(String str) {
        x xVar = this.L0;
        Handler handler = xVar.f2511a;
        if (handler != null) {
            handler.post(new g.r0(xVar, 18, str));
        }
    }

    public final h V(w0 w0Var) {
        h V = super.V(w0Var);
        a0 a0Var = w0Var.f10523b;
        x xVar = this.L0;
        Handler handler = xVar.f2511a;
        if (handler != null) {
            handler.post(new r(xVar, a0Var, V, 12));
        }
        return V;
    }

    public final void W(a0 a0Var, MediaFormat mediaFormat) {
        boolean z10;
        int i10;
        int i11;
        m mVar = this.N;
        if (mVar != null) {
            mVar.f(this.V0);
        }
        if (this.f2451p1) {
            this.f2446k1 = a0Var.f6281x;
            this.f2447l1 = a0Var.f6282y;
        } else {
            mediaFormat.getClass();
            if (!mediaFormat.containsKey("crop-right") || !mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i10 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i10 = mediaFormat.getInteger("width");
            }
            this.f2446k1 = i10;
            if (z10) {
                i11 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i11 = mediaFormat.getInteger("height");
            }
            this.f2447l1 = i11;
        }
        float f10 = a0Var.B;
        this.f2449n1 = f10;
        int i12 = l0.f8453a;
        int i13 = a0Var.A;
        if (i12 < 21) {
            this.f2448m1 = i13;
        } else if (i13 == 90 || i13 == 270) {
            int i14 = this.f2446k1;
            this.f2446k1 = this.f2447l1;
            this.f2447l1 = i14;
            this.f2449n1 = 1.0f / f10;
        }
        t tVar = this.K0;
        tVar.f2489f = a0Var.f6283z;
        b bVar = tVar.f2484a;
        bVar.f2423a.c();
        bVar.f2424b.c();
        bVar.f2425c = false;
        bVar.f2426d = -9223372036854775807L;
        bVar.f2427e = 0;
        tVar.b();
    }

    public final void Y(long j10) {
        super.Y(j10);
        if (!this.f2451p1) {
            this.f2440e1--;
        }
    }

    public final void Z() {
        q0();
    }

    public final void a0(l1.h hVar) {
        boolean z10 = this.f2451p1;
        if (!z10) {
            this.f2440e1++;
        }
        if (l0.f8453a < 23 && z10) {
            long j10 = hVar.f9517l;
            p0(j10);
            y0();
            this.E0.f10235e++;
            x0();
            Y(j10);
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            b2.t r0 = r6.K0
            r1 = 1
            if (r7 == r1) goto L_0x0053
            r2 = 7
            if (r7 == r2) goto L_0x004d
            r2 = 10
            if (r7 == r2) goto L_0x0038
            r2 = 4
            if (r7 == r2) goto L_0x0027
            r2 = 5
            if (r7 == r2) goto L_0x0014
            goto L_0x011c
        L_0x0014:
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r7 = r8.intValue()
            int r8 = r0.f2493j
            if (r8 != r7) goto L_0x0020
            goto L_0x011c
        L_0x0020:
            r0.f2493j = r7
            r0.c(r1)
            goto L_0x011c
        L_0x0027:
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r7 = r8.intValue()
            r6.V0 = r7
            s1.m r8 = r6.N
            if (r8 == 0) goto L_0x011c
            r8.f(r7)
            goto L_0x011c
        L_0x0038:
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r7 = r8.intValue()
            int r8 = r6.f2452q1
            if (r8 == r7) goto L_0x011c
            r6.f2452q1 = r7
            boolean r7 = r6.f2451p1
            if (r7 == 0) goto L_0x011c
            r6.e0()
            goto L_0x011c
        L_0x004d:
            b2.m r8 = (b2.m) r8
            r6.f2454s1 = r8
            goto L_0x011c
        L_0x0053:
            boolean r7 = r8 instanceof android.view.Surface
            r2 = 0
            if (r7 == 0) goto L_0x005b
            android.view.Surface r8 = (android.view.Surface) r8
            goto L_0x005c
        L_0x005b:
            r8 = r2
        L_0x005c:
            if (r8 != 0) goto L_0x0078
            b2.i r7 = r6.T0
            if (r7 == 0) goto L_0x0064
            r8 = r7
            goto L_0x0078
        L_0x0064:
            s1.q r7 = r6.U
            if (r7 == 0) goto L_0x0078
            boolean r3 = r6.B0(r7)
            if (r3 == 0) goto L_0x0078
            android.content.Context r8 = r6.J0
            boolean r7 = r7.f14038f
            b2.i r8 = b2.i.w(r8, r7)
            r6.T0 = r8
        L_0x0078:
            android.view.Surface r7 = r6.S0
            r3 = 17
            b2.x r4 = r6.L0
            if (r7 == r8) goto L_0x00f0
            r6.S0 = r8
            r0.getClass()
            boolean r7 = r8 instanceof b2.i
            if (r7 == 0) goto L_0x008b
            r7 = r2
            goto L_0x008c
        L_0x008b:
            r7 = r8
        L_0x008c:
            android.view.Surface r5 = r0.f2488e
            if (r5 != r7) goto L_0x0091
            goto L_0x0099
        L_0x0091:
            r0.a()
            r0.f2488e = r7
            r0.c(r1)
        L_0x0099:
            r7 = 0
            r6.U0 = r7
            int r7 = r6.f10221m
            s1.m r0 = r6.N
            if (r0 == 0) goto L_0x00b8
            int r1 = j1.l0.f8453a
            r5 = 23
            if (r1 < r5) goto L_0x00b2
            if (r8 == 0) goto L_0x00b2
            boolean r1 = r6.Q0
            if (r1 != 0) goto L_0x00b2
            r0.j(r8)
            goto L_0x00b8
        L_0x00b2:
            r6.e0()
            r6.Q()
        L_0x00b8:
            if (r8 == 0) goto L_0x00ea
            b2.i r0 = r6.T0
            if (r8 == r0) goto L_0x00ea
            g1.b2 r8 = r6.f2450o1
            if (r8 == 0) goto L_0x00ce
            android.os.Handler r0 = r4.f2511a
            if (r0 == 0) goto L_0x00ce
            g.r0 r1 = new g.r0
            r1.<init>(r4, r3, r8)
            r0.post(r1)
        L_0x00ce:
            r6.q0()
            r8 = 2
            if (r7 != r8) goto L_0x011c
            r7 = 0
            long r0 = r6.M0
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x00e2
            long r7 = android.os.SystemClock.elapsedRealtime()
            long r7 = r7 + r0
            goto L_0x00e7
        L_0x00e2:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00e7:
            r6.f2436a1 = r7
            goto L_0x011c
        L_0x00ea:
            r6.f2450o1 = r2
            r6.q0()
            goto L_0x011c
        L_0x00f0:
            if (r8 == 0) goto L_0x011c
            b2.i r7 = r6.T0
            if (r8 == r7) goto L_0x011c
            g1.b2 r7 = r6.f2450o1
            if (r7 == 0) goto L_0x0106
            android.os.Handler r8 = r4.f2511a
            if (r8 == 0) goto L_0x0106
            g.r0 r0 = new g.r0
            r0.<init>(r4, r3, r7)
            r8.post(r0)
        L_0x0106:
            boolean r7 = r6.U0
            if (r7 == 0) goto L_0x011c
            android.view.Surface r7 = r6.S0
            android.os.Handler r8 = r4.f2511a
            if (r8 == 0) goto L_0x011c
            long r0 = android.os.SystemClock.elapsedRealtime()
            b2.v r2 = new b2.v
            r2.<init>(r4, r7, r0)
            r8.post(r2)
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.g.b(int, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        if (r11 != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0138, code lost:
        if ((((r5 > -30000 ? 1 : (r5 == -30000 ? 0 : -1)) < 0) && r12 > 100000) != false) goto L_0x013a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x022c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0280  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x028c  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c0(long r29, long r31, s1.m r33, java.nio.ByteBuffer r34, int r35, int r36, int r37, long r38, boolean r40, boolean r41, g1.a0 r42) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r3 = r33
            r4 = r35
            r5 = r38
            r33.getClass()
            long r7 = r0.Z0
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x001a
            r0.Z0 = r1
        L_0x001a:
            long r7 = r0.f2441f1
            r13 = -1
            r15 = 1000(0x3e8, double:4.94E-321)
            r11 = 0
            int r17 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r17 == 0) goto L_0x00b9
            b2.t r7 = r0.K0
            long r9 = r7.f2497n
            int r8 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0033
            r7.f2499p = r9
            long r8 = r7.f2498o
            r7.f2500q = r8
        L_0x0033:
            long r8 = r7.f2496m
            r19 = 1
            long r8 = r8 + r19
            r7.f2496m = r8
            long r8 = r5 * r15
            b2.b r10 = r7.f2484a
            b2.a r13 = r10.f2423a
            r13.b(r8)
            b2.a r13 = r10.f2423a
            boolean r13 = r13.a()
            if (r13 == 0) goto L_0x004f
            r10.f2425c = r11
            goto L_0x008b
        L_0x004f:
            long r13 = r10.f2426d
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r21 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r21 == 0) goto L_0x008b
            boolean r13 = r10.f2425c
            if (r13 == 0) goto L_0x0077
            b2.a r13 = r10.f2424b
            long r11 = r13.f2418d
            r21 = 0
            int r23 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r23 != 0) goto L_0x006a
            r11 = 0
            goto L_0x0075
        L_0x006a:
            long r11 = r11 - r19
            r19 = 15
            long r11 = r11 % r19
            int r12 = (int) r11
            boolean[] r11 = r13.f2421g
            boolean r11 = r11[r12]
        L_0x0075:
            if (r11 == 0) goto L_0x0083
        L_0x0077:
            b2.a r11 = r10.f2424b
            r11.c()
            b2.a r11 = r10.f2424b
            long r12 = r10.f2426d
            r11.b(r12)
        L_0x0083:
            r11 = 1
            r10.f2425c = r11
            b2.a r11 = r10.f2424b
            r11.b(r8)
        L_0x008b:
            boolean r11 = r10.f2425c
            if (r11 == 0) goto L_0x00a2
            b2.a r11 = r10.f2424b
            boolean r11 = r11.a()
            if (r11 == 0) goto L_0x00a2
            b2.a r11 = r10.f2423a
            b2.a r12 = r10.f2424b
            r10.f2423a = r12
            r10.f2424b = r11
            r11 = 0
            r10.f2425c = r11
        L_0x00a2:
            r10.f2426d = r8
            b2.a r8 = r10.f2423a
            boolean r8 = r8.a()
            if (r8 == 0) goto L_0x00ae
            r8 = 0
            goto L_0x00b2
        L_0x00ae:
            int r8 = r10.f2427e
            r9 = 1
            int r8 = r8 + r9
        L_0x00b2:
            r10.f2427e = r8
            r7.b()
            r0.f2441f1 = r5
        L_0x00b9:
            s1.t r7 = r0.F0
            long r7 = r7.f14047b
            long r22 = r5 - r7
            if (r40 == 0) goto L_0x00c8
            if (r41 != 0) goto L_0x00c8
            r0.C0(r3, r4)
            r1 = 1
            return r1
        L_0x00c8:
            float r9 = r0.L
            double r9 = (double) r9
            int r11 = r0.f10221m
            r12 = 2
            if (r11 != r12) goto L_0x00d2
            r11 = 1
            goto L_0x00d3
        L_0x00d2:
            r11 = 0
        L_0x00d3:
            long r12 = android.os.SystemClock.elapsedRealtime()
            long r12 = r12 * r15
            long r5 = r5 - r1
            double r5 = (double) r5
            double r5 = r5 / r9
            long r5 = (long) r5
            if (r11 == 0) goto L_0x00e2
            long r9 = r12 - r31
            long r5 = r5 - r9
        L_0x00e2:
            android.view.Surface r9 = r0.S0
            b2.i r10 = r0.T0
            r19 = -30000(0xffffffffffff8ad0, double:NaN)
            if (r9 != r10) goto L_0x00fd
            int r1 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f0
            r1 = 1
            goto L_0x00f1
        L_0x00f0:
            r1 = 0
        L_0x00f1:
            if (r1 == 0) goto L_0x00fb
            r0.C0(r3, r4)
            r0.E0(r5)
            r1 = 1
            return r1
        L_0x00fb:
            r1 = 0
            return r1
        L_0x00fd:
            long r9 = r0.f2442g1
            long r12 = r12 - r9
            boolean r9 = r0.Y0
            if (r9 != 0) goto L_0x010b
            if (r11 != 0) goto L_0x010f
            boolean r9 = r0.X0
            if (r9 == 0) goto L_0x0111
            goto L_0x010f
        L_0x010b:
            boolean r9 = r0.W0
            if (r9 != 0) goto L_0x0111
        L_0x010f:
            r9 = 1
            goto L_0x0112
        L_0x0111:
            r9 = 0
        L_0x0112:
            long r14 = r0.f2436a1
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r10 != 0) goto L_0x013c
            int r10 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r10 < 0) goto L_0x013c
            if (r9 != 0) goto L_0x013a
            if (r11 == 0) goto L_0x013c
            int r7 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r7 >= 0) goto L_0x012b
            r7 = 1
            goto L_0x012c
        L_0x012b:
            r7 = 0
        L_0x012c:
            if (r7 == 0) goto L_0x0137
            r7 = 100000(0x186a0, double:4.94066E-319)
            int r9 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0137
            r7 = 1
            goto L_0x0138
        L_0x0137:
            r7 = 0
        L_0x0138:
            if (r7 == 0) goto L_0x013c
        L_0x013a:
            r7 = 1
            goto L_0x013d
        L_0x013c:
            r7 = 0
        L_0x013d:
            r8 = 21
            if (r7 == 0) goto L_0x0166
            long r1 = java.lang.System.nanoTime()
            b2.m r7 = r0.f2454s1
            if (r7 == 0) goto L_0x0156
            android.media.MediaFormat r9 = r0.P
            r21 = r7
            r24 = r1
            r26 = r42
            r27 = r9
            r21.d(r22, r24, r26, r27)
        L_0x0156:
            int r7 = j1.l0.f8453a
            if (r7 < r8) goto L_0x015e
            r0.A0(r3, r4, r1)
            goto L_0x0161
        L_0x015e:
            r0.z0(r3, r4)
        L_0x0161:
            r0.E0(r5)
            r1 = 1
            return r1
        L_0x0166:
            if (r11 == 0) goto L_0x0320
            long r9 = r0.Z0
            int r7 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0170
            goto L_0x0320
        L_0x0170:
            long r9 = java.lang.System.nanoTime()
            r11 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r11
            long r5 = r5 + r9
            b2.t r7 = r0.K0
            long r11 = r7.f2499p
            r15 = -1
            int r13 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x01d9
            b2.b r11 = r7.f2484a
            boolean r11 = r11.a()
            if (r11 == 0) goto L_0x01d9
            b2.b r11 = r7.f2484a
            boolean r12 = r11.a()
            if (r12 == 0) goto L_0x01a4
            b2.a r11 = r11.f2423a
            long r12 = r11.f2419e
            r15 = 0
            int r21 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r21 != 0) goto L_0x01a0
            r14 = 0
            goto L_0x01a9
        L_0x01a0:
            long r14 = r11.f2420f
            long r14 = r14 / r12
            goto L_0x01a9
        L_0x01a4:
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x01a9:
            long r11 = r7.f2500q
            r38 = r9
            long r8 = r7.f2496m
            long r3 = r7.f2499p
            long r8 = r8 - r3
            long r8 = r8 * r14
            float r3 = (float) r8
            float r4 = r7.f2492i
            float r3 = r3 / r4
            long r3 = (long) r3
            long r11 = r11 + r3
            long r3 = r5 - r11
            long r3 = java.lang.Math.abs(r3)
            r8 = 20000000(0x1312d00, double:9.881313E-317)
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x01c9
            r3 = 1
            goto L_0x01ca
        L_0x01c9:
            r3 = 0
        L_0x01ca:
            if (r3 == 0) goto L_0x01ce
            r5 = r11
            goto L_0x01db
        L_0x01ce:
            r3 = 0
            r7.f2496m = r3
            r3 = -1
            r7.f2499p = r3
            r7.f2497n = r3
            goto L_0x01db
        L_0x01d9:
            r38 = r9
        L_0x01db:
            long r3 = r7.f2496m
            r7.f2497n = r3
            r7.f2498o = r5
            b2.s r3 = r7.f2486c
            if (r3 == 0) goto L_0x021a
            long r8 = r7.f2494k
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x01f1
            goto L_0x021a
        L_0x01f1:
            long r3 = r3.f2480h
            int r8 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x01f8
            goto L_0x021a
        L_0x01f8:
            long r8 = r7.f2494k
            long r10 = r5 - r3
            long r10 = r10 / r8
            long r10 = r10 * r8
            long r10 = r10 + r3
            int r3 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r3 > 0) goto L_0x0207
            long r3 = r10 - r8
            goto L_0x020a
        L_0x0207:
            long r8 = r8 + r10
            r3 = r10
            r10 = r8
        L_0x020a:
            long r8 = r10 - r5
            long r5 = r5 - r3
            int r12 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x0212
            goto L_0x0213
        L_0x0212:
            r10 = r3
        L_0x0213:
            long r3 = r7.f2495l
            long r10 = r10 - r3
            r3 = r38
            r5 = r10
            goto L_0x021c
        L_0x021a:
            r3 = r38
        L_0x021c:
            long r3 = r5 - r3
            r7 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r7
            long r7 = r0.f2436a1
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x022e
            r7 = 1
            goto L_0x022f
        L_0x022e:
            r7 = 0
        L_0x022f:
            r8 = -500000(0xfffffffffff85ee0, double:NaN)
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0238
            r8 = 1
            goto L_0x0239
        L_0x0238:
            r8 = 0
        L_0x0239:
            if (r8 == 0) goto L_0x023f
            if (r41 != 0) goto L_0x023f
            r8 = 1
            goto L_0x0240
        L_0x023f:
            r8 = 0
        L_0x0240:
            if (r8 == 0) goto L_0x027c
            v1.b1 r8 = r0.f10222n
            r8.getClass()
            long r9 = r0.f10224p
            long r1 = r1 - r9
            int r1 = r8.d(r1)
            if (r1 != 0) goto L_0x0252
            r1 = 0
            goto L_0x0278
        L_0x0252:
            m1.g r2 = r0.E0
            if (r7 == 0) goto L_0x0263
            int r8 = r2.f10234d
            int r8 = r8 + r1
            r2.f10234d = r8
            int r1 = r2.f10236f
            int r8 = r0.f2440e1
            int r1 = r1 + r8
            r2.f10236f = r1
            goto L_0x026e
        L_0x0263:
            int r8 = r2.f10240j
            r9 = 1
            int r8 = r8 + r9
            r2.f10240j = r8
            int r2 = r0.f2440e1
            r0.D0(r1, r2)
        L_0x026e:
            boolean r1 = r28.H()
            if (r1 == 0) goto L_0x0277
            r28.Q()
        L_0x0277:
            r1 = 1
        L_0x0278:
            if (r1 == 0) goto L_0x027c
            r1 = 0
            return r1
        L_0x027c:
            int r1 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x0282
            r1 = 1
            goto L_0x0283
        L_0x0282:
            r1 = 0
        L_0x0283:
            if (r1 == 0) goto L_0x0289
            if (r41 != 0) goto L_0x0289
            r1 = 1
            goto L_0x028a
        L_0x0289:
            r1 = 0
        L_0x028a:
            if (r1 == 0) goto L_0x02af
            if (r7 == 0) goto L_0x0297
            r1 = r33
            r2 = r35
            r0.C0(r1, r2)
            r1 = 1
            goto L_0x02ab
        L_0x0297:
            r1 = r33
            r2 = r35
            java.lang.String r5 = "dropVideoBuffer"
            j1.i0.a(r5)
            r5 = 0
            r1.d(r2, r5)
            j1.i0.b()
            r1 = 1
            r0.D0(r5, r1)
        L_0x02ab:
            r0.E0(r3)
            return r1
        L_0x02af:
            r1 = r33
            r2 = r35
            int r7 = j1.l0.f8453a
            r8 = 21
            if (r7 < r8) goto L_0x02e5
            r7 = 50000(0xc350, double:2.47033E-319)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x031e
            long r7 = r0.f2445j1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x02ca
            r0.C0(r1, r2)
            goto L_0x02de
        L_0x02ca:
            b2.m r7 = r0.f2454s1
            if (r7 == 0) goto L_0x02db
            android.media.MediaFormat r8 = r0.P
            r21 = r7
            r24 = r5
            r26 = r42
            r27 = r8
            r21.d(r22, r24, r26, r27)
        L_0x02db:
            r0.A0(r1, r2, r5)
        L_0x02de:
            r0.E0(r3)
            r0.f2445j1 = r5
            r1 = 1
            return r1
        L_0x02e5:
            r7 = 30000(0x7530, double:1.4822E-319)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x031e
            r7 = 11000(0x2af8, double:5.4347E-320)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0305
            r7 = 10000(0x2710, double:4.9407E-320)
            long r7 = r3 - r7
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            java.lang.Thread.sleep(r7)     // Catch:{ InterruptedException -> 0x02fc }
            goto L_0x0305
        L_0x02fc:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            r1 = 0
            return r1
        L_0x0305:
            b2.m r7 = r0.f2454s1
            if (r7 == 0) goto L_0x0316
            android.media.MediaFormat r8 = r0.P
            r21 = r7
            r24 = r5
            r26 = r42
            r27 = r8
            r21.d(r22, r24, r26, r27)
        L_0x0316:
            r0.z0(r1, r2)
            r0.E0(r3)
            r1 = 1
            return r1
        L_0x031e:
            r1 = 0
            return r1
        L_0x0320:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b2.g.c0(long, long, s1.m, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, g1.a0):boolean");
    }

    public final String g() {
        return "MediaCodecVideoRenderer";
    }

    public final void g0() {
        super.g0();
        this.f2440e1 = 0;
    }

    public final boolean k() {
        i iVar;
        if (super.k() && (this.W0 || (((iVar = this.T0) != null && this.S0 == iVar) || this.N == null || this.f2451p1))) {
            this.f2436a1 = -9223372036854775807L;
            return true;
        } else if (this.f2436a1 == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f2436a1) {
                return true;
            }
            this.f2436a1 = -9223372036854775807L;
            return false;
        }
    }

    public final boolean k0(q qVar) {
        return this.S0 != null || B0(qVar);
    }

    public final void l() {
        x xVar = this.L0;
        this.f2450o1 = null;
        q0();
        this.U0 = false;
        this.f2453r1 = null;
        try {
            super.l();
            m1.g gVar = this.E0;
            xVar.getClass();
            synchronized (gVar) {
            }
            Handler handler = xVar.f2511a;
            if (handler != null) {
                handler.post(new w(xVar, gVar, 1));
            }
        } catch (Throwable th) {
            xVar.a(this.E0);
            throw th;
        }
    }

    public final void m(boolean z10, boolean z11) {
        boolean z12;
        this.E0 = new m1.g();
        o1 o1Var = this.f10218j;
        o1Var.getClass();
        boolean z13 = o1Var.f10419a;
        if (!z13 || this.f2452q1 != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        j1.a.e(z12);
        if (this.f2451p1 != z13) {
            this.f2451p1 = z13;
            e0();
        }
        m1.g gVar = this.E0;
        x xVar = this.L0;
        Handler handler = xVar.f2511a;
        if (handler != null) {
            handler.post(new w(xVar, gVar, 0));
        }
        this.X0 = z11;
        this.Y0 = false;
    }

    public final int m0(v vVar, a0 a0Var) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        if (!a1.k(a0Var.f6276s)) {
            return android.support.v4.media.h.c(0, 0, 0);
        }
        if (a0Var.f6279v != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Context context = this.J0;
        r0 u02 = u0(context, vVar, a0Var, z10, false);
        if (z10 && u02.isEmpty()) {
            u02 = u0(context, vVar, a0Var, false, false);
        }
        if (u02.isEmpty()) {
            return android.support.v4.media.h.c(1, 0, 0);
        }
        int i15 = a0Var.N;
        if (i15 == 0 || i15 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return android.support.v4.media.h.c(2, 0, 0);
        }
        q qVar = (q) u02.get(0);
        boolean d10 = qVar.d(a0Var);
        if (!d10) {
            int i16 = 1;
            while (true) {
                if (i16 >= u02.size()) {
                    break;
                }
                q qVar2 = (q) u02.get(i16);
                if (qVar2.d(a0Var)) {
                    qVar = qVar2;
                    z12 = false;
                    d10 = true;
                    break;
                }
                i16++;
            }
        }
        z12 = true;
        if (d10) {
            i10 = 4;
        } else {
            i10 = 3;
        }
        if (qVar.e(a0Var)) {
            i11 = 16;
        } else {
            i11 = 8;
        }
        if (qVar.f14039g) {
            i12 = 64;
        } else {
            i12 = 0;
        }
        if (z12) {
            i13 = 128;
        } else {
            i13 = 0;
        }
        if (l0.f8453a >= 26 && "video/dolby-vision".equals(a0Var.f6276s) && !d.a(context)) {
            i13 = 256;
        }
        if (d10) {
            r0 u03 = u0(context, vVar, a0Var, z10, true);
            if (!u03.isEmpty()) {
                Pattern pattern = c0.f13983a;
                ArrayList arrayList = new ArrayList(u03);
                Collections.sort(arrayList, new a(2, new w(a0Var)));
                q qVar3 = (q) arrayList.get(0);
                if (qVar3.d(a0Var) && qVar3.e(a0Var)) {
                    i14 = 32;
                }
            }
        }
        return i10 | i11 | i14 | i12 | i13;
    }

    public final void n(long j10, boolean z10) {
        super.n(j10, z10);
        q0();
        t tVar = this.K0;
        tVar.f2496m = 0;
        tVar.f2499p = -1;
        tVar.f2497n = -1;
        long j11 = -9223372036854775807L;
        this.f2441f1 = -9223372036854775807L;
        this.Z0 = -9223372036854775807L;
        this.f2439d1 = 0;
        if (z10) {
            long j12 = this.M0;
            if (j12 > 0) {
                j11 = SystemClock.elapsedRealtime() + j12;
            }
            this.f2436a1 = j11;
            return;
        }
        this.f2436a1 = -9223372036854775807L;
    }

    public final void o() {
        try {
            C();
            e0();
            p1.n nVar = this.H;
            if (nVar != null) {
                nVar.d((p1.q) null);
            }
            this.H = null;
            i iVar = this.T0;
            if (iVar != null) {
                if (this.S0 == iVar) {
                    this.S0 = null;
                }
                iVar.release();
                this.T0 = null;
            }
        } catch (Throwable th) {
            i iVar2 = this.T0;
            if (iVar2 != null) {
                if (this.S0 == iVar2) {
                    this.S0 = null;
                }
                iVar2.release();
                this.T0 = null;
            }
            throw th;
        }
    }

    public final void p() {
        this.f2438c1 = 0;
        this.f2437b1 = SystemClock.elapsedRealtime();
        this.f2442g1 = SystemClock.elapsedRealtime() * 1000;
        this.f2443h1 = 0;
        this.f2444i1 = 0;
        t tVar = this.K0;
        tVar.f2487d = true;
        tVar.f2496m = 0;
        tVar.f2499p = -1;
        tVar.f2497n = -1;
        p pVar = tVar.f2485b;
        if (pVar != null) {
            s sVar = tVar.f2486c;
            sVar.getClass();
            sVar.f2481i.sendEmptyMessage(1);
            pVar.b(new c(7, tVar));
        }
        tVar.c(false);
    }

    public final void q() {
        this.f2436a1 = -9223372036854775807L;
        w0();
        int i10 = this.f2444i1;
        if (i10 != 0) {
            long j10 = this.f2443h1;
            x xVar = this.L0;
            Handler handler = xVar.f2511a;
            if (handler != null) {
                handler.post(new u(xVar, j10, i10));
            }
            this.f2443h1 = 0;
            this.f2444i1 = 0;
        }
        t tVar = this.K0;
        tVar.f2487d = false;
        p pVar = tVar.f2485b;
        if (pVar != null) {
            pVar.a();
            s sVar = tVar.f2486c;
            sVar.getClass();
            sVar.f2481i.sendEmptyMessage(2);
        }
        tVar.a();
    }

    public final void q0() {
        m mVar;
        this.W0 = false;
        if (l0.f8453a >= 23 && this.f2451p1 && (mVar = this.N) != null) {
            this.f2453r1 = new f(this, mVar);
        }
    }

    public final void w(float f10, float f11) {
        super.w(f10, f11);
        t tVar = this.K0;
        tVar.f2492i = f10;
        tVar.f2496m = 0;
        tVar.f2499p = -1;
        tVar.f2497n = -1;
        tVar.c(false);
    }

    public final void w0() {
        if (this.f2438c1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = elapsedRealtime - this.f2437b1;
            int i10 = this.f2438c1;
            x xVar = this.L0;
            Handler handler = xVar.f2511a;
            if (handler != null) {
                handler.post(new u(xVar, i10, j10));
            }
            this.f2438c1 = 0;
            this.f2437b1 = elapsedRealtime;
        }
    }

    public final void x0() {
        this.Y0 = true;
        if (!this.W0) {
            this.W0 = true;
            Surface surface = this.S0;
            x xVar = this.L0;
            Handler handler = xVar.f2511a;
            if (handler != null) {
                handler.post(new v(xVar, surface, SystemClock.elapsedRealtime()));
            }
            this.U0 = true;
        }
    }

    public final void y0() {
        int i10 = this.f2446k1;
        if (i10 != -1 || this.f2447l1 != -1) {
            b2 b2Var = this.f2450o1;
            if (b2Var == null || b2Var.f6317h != i10 || b2Var.f6318i != this.f2447l1 || b2Var.f6319j != this.f2448m1 || b2Var.f6320k != this.f2449n1) {
                b2 b2Var2 = new b2(this.f2449n1, this.f2446k1, this.f2447l1, this.f2448m1);
                this.f2450o1 = b2Var2;
                x xVar = this.L0;
                Handler handler = xVar.f2511a;
                if (handler != null) {
                    handler.post(new g.r0(xVar, 17, b2Var2));
                }
            }
        }
    }

    public final void z0(m mVar, int i10) {
        y0();
        i0.a("releaseOutputBuffer");
        mVar.d(i10, true);
        i0.b();
        this.f2442g1 = SystemClock.elapsedRealtime() * 1000;
        this.E0.f10235e++;
        this.f2439d1 = 0;
        x0();
    }
}
