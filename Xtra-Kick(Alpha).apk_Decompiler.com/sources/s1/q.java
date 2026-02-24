package s1;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import g1.a0;
import g1.a1;
import j1.l0;
import j1.v;
import m1.h;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final String f14033a;

    /* renamed from: b  reason: collision with root package name */
    public final String f14034b;

    /* renamed from: c  reason: collision with root package name */
    public final String f14035c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f14036d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f14037e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f14038f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f14039g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f14040h;

    public q(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z10, boolean z11, boolean z12) {
        str.getClass();
        this.f14033a = str;
        this.f14034b = str2;
        this.f14035c = str3;
        this.f14036d = codecCapabilities;
        this.f14039g = z10;
        this.f14037e = z11;
        this.f14038f = z12;
        this.f14040h = a1.k(str2);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i10, int i11, double d10) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i12 = l0.f8453a;
        Point point = new Point((((i10 + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i11 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
        int i13 = point.x;
        int i14 = point.y;
        if (d10 == -1.0d || d10 < 1.0d) {
            return videoCapabilities.isSizeSupported(i13, i14);
        }
        return videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d10));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006d, code lost:
        if (r15 != false) goto L_0x0072;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static s1.q h(java.lang.String r8, java.lang.String r9, java.lang.String r10, android.media.MediaCodecInfo.CodecCapabilities r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        /*
            s1.q r13 = new s1.q
            r14 = 1
            r0 = 0
            if (r11 == 0) goto L_0x0046
            int r1 = j1.l0.f8453a
            r2 = 19
            if (r1 < r2) goto L_0x0016
            java.lang.String r2 = "adaptive-playback"
            boolean r2 = r11.isFeatureSupported(r2)
            if (r2 == 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            if (r2 == 0) goto L_0x0046
            r2 = 22
            if (r1 > r2) goto L_0x0041
            java.lang.String r1 = j1.l0.f8456d
            java.lang.String r2 = "ODROID-XU3"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x002f
            java.lang.String r2 = "Nexus 10"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0041
        L_0x002f:
            java.lang.String r1 = "OMX.Exynos.AVC.Decoder"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x003f
            java.lang.String r1 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x0041
        L_0x003f:
            r1 = 1
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            if (r1 != 0) goto L_0x0046
            r6 = 1
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            r1 = 21
            if (r11 == 0) goto L_0x005a
            int r2 = j1.l0.f8453a
            if (r2 < r1) goto L_0x0059
            java.lang.String r2 = "tunneled-playback"
            boolean r2 = r11.isFeatureSupported(r2)
            if (r2 == 0) goto L_0x0059
            r2 = 1
            goto L_0x005a
        L_0x0059:
            r2 = 0
        L_0x005a:
            if (r15 != 0) goto L_0x0072
            if (r11 == 0) goto L_0x0070
            int r15 = j1.l0.f8453a
            if (r15 < r1) goto L_0x006c
            java.lang.String r15 = "secure-playback"
            boolean r15 = r11.isFeatureSupported(r15)
            if (r15 == 0) goto L_0x006c
            r15 = 1
            goto L_0x006d
        L_0x006c:
            r15 = 0
        L_0x006d:
            if (r15 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r7 = 0
            goto L_0x0073
        L_0x0072:
            r7 = 1
        L_0x0073:
            r0 = r13
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.q.h(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean):s1.q");
    }

    public final h b(a0 a0Var, a0 a0Var2) {
        int i10;
        int i11;
        boolean z10 = false;
        if (!l0.a(a0Var.f6276s, a0Var2.f6276s)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        if (this.f14040h) {
            if (a0Var.A != a0Var2.A) {
                i10 |= 1024;
            }
            if (!this.f14037e && !(a0Var.f6281x == a0Var2.f6281x && a0Var.f6282y == a0Var2.f6282y)) {
                i10 |= 512;
            }
            if (!l0.a(a0Var.E, a0Var2.E)) {
                i10 |= 2048;
            }
            if (l0.f8456d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.f14033a)) {
                z10 = true;
            }
            if (z10 && !a0Var.j(a0Var2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                String str = this.f14033a;
                if (a0Var.j(a0Var2)) {
                    i11 = 3;
                } else {
                    i11 = 2;
                }
                return new h(str, a0Var, a0Var2, i11, 0);
            }
        } else {
            if (a0Var.F != a0Var2.F) {
                i10 |= 4096;
            }
            if (a0Var.G != a0Var2.G) {
                i10 |= 8192;
            }
            if (a0Var.H != a0Var2.H) {
                i10 |= 16384;
            }
            String str2 = this.f14034b;
            if (i10 == 0 && "audio/mp4a-latm".equals(str2)) {
                Pair d10 = c0.d(a0Var);
                Pair d11 = c0.d(a0Var2);
                if (!(d10 == null || d11 == null)) {
                    int intValue = ((Integer) d10.first).intValue();
                    int intValue2 = ((Integer) d11.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new h(this.f14033a, a0Var, a0Var2, 3, 0);
                    }
                }
            }
            if (!a0Var.j(a0Var2)) {
                i10 |= 32;
            }
            if ("audio/opus".equals(str2)) {
                i10 |= 2;
            }
            if (i10 == 0) {
                return new h(this.f14033a, a0Var, a0Var2, 1, 0);
            }
        }
        return new h(this.f14033a, a0Var, a0Var2, 0, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0103 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0104 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(g1.a0 r13, boolean r14) {
        /*
            r12 = this;
            android.util.Pair r0 = s1.c0.d(r13)
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r13.f6276s
            boolean r3 = r3.equals(r4)
            r4 = 8
            r5 = 2
            r6 = 0
            java.lang.String r7 = "video/hevc"
            java.lang.String r8 = r12.f14034b
            if (r3 == 0) goto L_0x003e
            java.lang.String r3 = "video/avc"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x0036
            r0 = 0
            r2 = 8
            goto L_0x003e
        L_0x0036:
            boolean r3 = r7.equals(r8)
            if (r3 == 0) goto L_0x003e
            r0 = 0
            r2 = 2
        L_0x003e:
            boolean r3 = r12.f14040h
            if (r3 != 0) goto L_0x0047
            r3 = 42
            if (r2 == r3) goto L_0x0047
            return r1
        L_0x0047:
            android.media.MediaCodecInfo$CodecCapabilities r3 = r12.f14036d
            if (r3 == 0) goto L_0x004f
            android.media.MediaCodecInfo$CodecProfileLevel[] r9 = r3.profileLevels
            if (r9 != 0) goto L_0x0051
        L_0x004f:
            android.media.MediaCodecInfo$CodecProfileLevel[] r9 = new android.media.MediaCodecInfo.CodecProfileLevel[r6]
        L_0x0051:
            int r10 = j1.l0.f8453a
            r11 = 23
            if (r10 > r11) goto L_0x00d4
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r10.equals(r8)
            if (r10 == 0) goto L_0x00d4
            int r10 = r9.length
            if (r10 != 0) goto L_0x00d4
            if (r3 == 0) goto L_0x0079
            android.media.MediaCodecInfo$VideoCapabilities r3 = r3.getVideoCapabilities()
            if (r3 == 0) goto L_0x0079
            android.util.Range r3 = r3.getBitrateRange()
            java.lang.Comparable r3 = r3.getUpper()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x007a
        L_0x0079:
            r3 = 0
        L_0x007a:
            r9 = 180000000(0xaba9500, float:1.7967196E-32)
            if (r3 < r9) goto L_0x0082
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x00c7
        L_0x0082:
            r9 = 120000000(0x7270e00, float:1.2567798E-34)
            if (r3 < r9) goto L_0x008a
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x00c7
        L_0x008a:
            r9 = 60000000(0x3938700, float:8.670878E-37)
            if (r3 < r9) goto L_0x0092
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x00c7
        L_0x0092:
            r9 = 30000000(0x1c9c380, float:7.411627E-38)
            if (r3 < r9) goto L_0x009a
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x00c7
        L_0x009a:
            r9 = 18000000(0x112a880, float:2.6936858E-38)
            if (r3 < r9) goto L_0x00a2
            r4 = 64
            goto L_0x00c7
        L_0x00a2:
            r9 = 12000000(0xb71b00, float:1.6815582E-38)
            if (r3 < r9) goto L_0x00aa
            r4 = 32
            goto L_0x00c7
        L_0x00aa:
            r9 = 7200000(0x6ddd00, float:1.0089349E-38)
            if (r3 < r9) goto L_0x00b2
            r4 = 16
            goto L_0x00c7
        L_0x00b2:
            r9 = 3600000(0x36ee80, float:5.044674E-39)
            if (r3 < r9) goto L_0x00b8
            goto L_0x00c7
        L_0x00b8:
            r4 = 1800000(0x1b7740, float:2.522337E-39)
            if (r3 < r4) goto L_0x00bf
            r4 = 4
            goto L_0x00c7
        L_0x00bf:
            r4 = 800000(0xc3500, float:1.121039E-39)
            if (r3 < r4) goto L_0x00c6
            r4 = 2
            goto L_0x00c7
        L_0x00c6:
            r4 = 1
        L_0x00c7:
            android.media.MediaCodecInfo$CodecProfileLevel r3 = new android.media.MediaCodecInfo$CodecProfileLevel
            r3.<init>()
            r3.profile = r1
            r3.level = r4
            android.media.MediaCodecInfo$CodecProfileLevel[] r9 = new android.media.MediaCodecInfo.CodecProfileLevel[r1]
            r9[r6] = r3
        L_0x00d4:
            int r3 = r9.length
            r4 = 0
        L_0x00d6:
            if (r4 >= r3) goto L_0x0107
            r10 = r9[r4]
            int r11 = r10.profile
            if (r11 != r2) goto L_0x0104
            int r10 = r10.level
            if (r10 >= r0) goto L_0x00e4
            if (r14 != 0) goto L_0x0104
        L_0x00e4:
            boolean r10 = r7.equals(r8)
            if (r10 == 0) goto L_0x0100
            if (r5 != r2) goto L_0x0100
            java.lang.String r10 = j1.l0.f8454b
            java.lang.String r11 = "sailfish"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x00fe
            java.lang.String r11 = "marlin"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x0100
        L_0x00fe:
            r10 = 1
            goto L_0x0101
        L_0x0100:
            r10 = 0
        L_0x0101:
            if (r10 != 0) goto L_0x0104
            return r1
        L_0x0104:
            int r4 = r4 + 1
            goto L_0x00d6
        L_0x0107:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "codec.profileLevel, "
            r14.<init>(r0)
            java.lang.String r13 = r13.f6273p
            r14.append(r13)
            java.lang.String r13 = ", "
            r14.append(r13)
            java.lang.String r13 = r12.f14035c
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            r12.g(r13)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.q.c(g1.a0, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(g1.a0 r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.f6276s
            java.lang.String r1 = r8.f14034b
            boolean r0 = r1.equals(r0)
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = s1.c0.b(r9)
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r0 != 0) goto L_0x001d
            return r2
        L_0x001d:
            boolean r0 = r8.c(r9, r3)
            if (r0 != 0) goto L_0x0024
            return r2
        L_0x0024:
            boolean r0 = r8.f14040h
            r4 = 21
            if (r0 == 0) goto L_0x0065
            int r0 = r9.f6281x
            if (r0 <= 0) goto L_0x0064
            int r1 = r9.f6282y
            if (r1 > 0) goto L_0x0033
            goto L_0x0064
        L_0x0033:
            int r3 = j1.l0.f8453a
            if (r3 < r4) goto L_0x003f
            float r9 = r9.f6283z
            double r2 = (double) r9
            boolean r9 = r8.f(r0, r1, r2)
            return r9
        L_0x003f:
            int r9 = r0 * r1
            int r3 = s1.c0.i()
            if (r9 > r3) goto L_0x0048
            r2 = 1
        L_0x0048:
            if (r2 != 0) goto L_0x0063
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r3 = "legacyFrameSize, "
            r9.<init>(r3)
            r9.append(r0)
            java.lang.String r0 = "x"
            r9.append(r0)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.g(r9)
        L_0x0063:
            return r2
        L_0x0064:
            return r3
        L_0x0065:
            int r0 = j1.l0.f8453a
            if (r0 < r4) goto L_0x015f
            android.media.MediaCodecInfo$CodecCapabilities r4 = r8.f14036d
            r5 = -1
            int r6 = r9.G
            if (r6 == r5) goto L_0x0092
            if (r4 != 0) goto L_0x0075
            java.lang.String r6 = "sampleRate.caps"
            goto L_0x008a
        L_0x0075:
            android.media.MediaCodecInfo$AudioCapabilities r7 = r4.getAudioCapabilities()
            if (r7 != 0) goto L_0x007e
            java.lang.String r6 = "sampleRate.aCaps"
            goto L_0x008a
        L_0x007e:
            boolean r7 = r7.isSampleRateSupported(r6)
            if (r7 != 0) goto L_0x008f
            java.lang.String r7 = "sampleRate.support, "
            java.lang.String r6 = android.support.v4.media.h.i(r7, r6)
        L_0x008a:
            r8.g(r6)
            r6 = 0
            goto L_0x0090
        L_0x008f:
            r6 = 1
        L_0x0090:
            if (r6 == 0) goto L_0x0160
        L_0x0092:
            int r9 = r9.F
            if (r9 == r5) goto L_0x015f
            if (r4 != 0) goto L_0x009c
            java.lang.String r9 = "channelCount.caps"
            goto L_0x0157
        L_0x009c:
            android.media.MediaCodecInfo$AudioCapabilities r4 = r4.getAudioCapabilities()
            if (r4 != 0) goto L_0x00a6
            java.lang.String r9 = "channelCount.aCaps"
            goto L_0x0157
        L_0x00a6:
            int r4 = r4.getMaxInputChannelCount()
            if (r4 > r3) goto L_0x014f
            r3 = 26
            if (r0 < r3) goto L_0x00b4
            if (r4 <= 0) goto L_0x00b4
            goto L_0x014f
        L_0x00b4:
            java.lang.String r0 = "audio/mpeg"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/3gpp"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/amr-wb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/vorbis"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/opus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/raw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/flac"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/g711-alaw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/g711-mlaw"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x014f
            java.lang.String r0 = "audio/gsm"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x010d
            goto L_0x014f
        L_0x010d:
            java.lang.String r0 = "audio/ac3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0117
            r0 = 6
            goto L_0x0124
        L_0x0117:
            java.lang.String r0 = "audio/eac3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0122
            r0 = 16
            goto L_0x0124
        L_0x0122:
            r0 = 30
        L_0x0124:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "AssumedMaxChannelAdjustment: "
            r1.<init>(r3)
            java.lang.String r3 = r8.f14033a
            r1.append(r3)
            java.lang.String r3 = ", ["
            r1.append(r3)
            r1.append(r4)
            java.lang.String r3 = " to "
            r1.append(r3)
            r1.append(r0)
            java.lang.String r3 = "]"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "MediaCodecInfo"
            j1.v.g(r3, r1)
            r4 = r0
        L_0x014f:
            if (r4 >= r9) goto L_0x015c
            java.lang.String r0 = "channelCount.support, "
            java.lang.String r9 = android.support.v4.media.h.i(r0, r9)
        L_0x0157:
            r8.g(r9)
            r9 = 0
            goto L_0x015d
        L_0x015c:
            r9 = 1
        L_0x015d:
            if (r9 == 0) goto L_0x0160
        L_0x015f:
            r2 = 1
        L_0x0160:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.q.d(g1.a0):boolean");
    }

    public final boolean e(a0 a0Var) {
        if (this.f14040h) {
            return this.f14037e;
        }
        Pair d10 = c0.d(a0Var);
        return d10 != null && ((Integer) d10.first).intValue() == 42;
    }

    public final boolean f(int i10, int i11, double d10) {
        String str;
        StringBuilder sb2;
        boolean z10;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f14036d;
        if (codecCapabilities == null) {
            str = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                str = "sizeAndRate.vCaps";
            } else {
                if (l0.f8453a >= 29) {
                    int a10 = p.a(videoCapabilities, i10, i11, d10);
                    if (a10 == 2) {
                        return true;
                    }
                    if (a10 == 1) {
                        sb2 = new StringBuilder("sizeAndRate.cover, ");
                        sb2.append(i10);
                        sb2.append("x");
                        sb2.append(i11);
                        sb2.append("@");
                        sb2.append(d10);
                        str = sb2.toString();
                    }
                }
                if (!a(videoCapabilities, i10, i11, d10)) {
                    if (i10 < i11) {
                        if (!"OMX.MTK.VIDEO.DECODER.HEVC".equals(this.f14033a) || !"mcv5a".equals(l0.f8454b)) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10 && a(videoCapabilities, i11, i10, d10)) {
                            StringBuilder sb3 = new StringBuilder("sizeAndRate.rotated, ");
                            sb3.append(i10);
                            sb3.append("x");
                            sb3.append(i11);
                            sb3.append("@");
                            sb3.append(d10);
                            int i12 = l0.f8453a;
                            v.b();
                        }
                    }
                    sb2 = new StringBuilder("sizeAndRate.support, ");
                    sb2.append(i10);
                    sb2.append("x");
                    sb2.append(i11);
                    sb2.append("@");
                    sb2.append(d10);
                    str = sb2.toString();
                }
                return true;
            }
        }
        g(str);
        return false;
    }

    public final void g(String str) {
        int i10 = l0.f8453a;
        v.b();
    }

    public final String toString() {
        return this.f14033a;
    }
}
