package s1;

import android.media.MediaCodecInfo;
import android.util.Pair;
import c9.b;
import d9.r0;
import g1.a0;
import g1.a1;
import i1.c;
import j0.h;
import j1.l0;
import j1.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import oa.a;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f13983a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b  reason: collision with root package name */
    public static final HashMap f13984b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static int f13985c = -1;

    private c0() {
    }

    public static void a(String str, ArrayList arrayList) {
        if ("audio/raw".equals(str)) {
            if (l0.f8453a < 26 && l0.f8454b.equals("R9") && arrayList.size() == 1 && ((q) arrayList.get(0)).f14033a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayList.add(q.h("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false));
            }
            Collections.sort(arrayList, new a(2, new c(10)));
        }
        int i10 = l0.f8453a;
        if (i10 < 21 && arrayList.size() > 1) {
            String str2 = ((q) arrayList.get(0)).f14033a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                Collections.sort(arrayList, new a(2, new c(11)));
            }
        }
        if (i10 < 32 && arrayList.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((q) arrayList.get(0)).f14033a)) {
            arrayList.add((q) arrayList.remove(0));
        }
    }

    public static String b(a0 a0Var) {
        Pair d10;
        if ("audio/eac3-joc".equals(a0Var.f6276s)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(a0Var.f6276s) || (d10 = d(a0Var)) == null) {
            return null;
        }
        int intValue = ((Integer) d10.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static String c(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            if (!str2.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(str)) {
                return null;
            }
            return "audio/lg-ac3";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01ca, code lost:
        r0 = java.lang.Integer.valueOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x05a6, code lost:
        r4 = java.lang.Integer.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        if (r9.equals("01") == false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x073a, code lost:
        r0 = r0.f6492j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:499:0x078e, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:504:0x079c, code lost:
        if (r4 != r1) goto L_0x07a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:505:0x079e, code lost:
        r0 = new java.lang.StringBuilder("Unknown AV1 level: ");
        r0.append(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:525:?, code lost:
        return new android.util.Pair(java.lang.Integer.valueOf(r0), java.lang.Integer.valueOf(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00eb, code lost:
        r8 = java.lang.Integer.valueOf(r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x038d A[Catch:{ NumberFormatException -> 0x039d }] */
    /* JADX WARNING: Removed duplicated region for block: B:517:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair d(g1.a0 r17) {
        /*
            r0 = r17
            java.lang.String r1 = r0.f6273p
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r2 = "\\."
            java.lang.String[] r1 = r1.split(r2)
            java.lang.String r2 = "video/dolby-vision"
            java.lang.String r3 = r0.f6276s
            boolean r2 = r2.equals(r3)
            java.lang.String r3 = "MediaCodecUtil"
            r4 = 3
            r5 = 8
            r6 = 4
            r7 = 2
            r8 = 1
            java.lang.String r9 = r0.f6273p
            if (r2 == 0) goto L_0x01ec
            int r0 = r1.length
            java.lang.String r2 = "Ignoring malformed Dolby Vision codec string: "
            if (r0 >= r4) goto L_0x002e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            goto L_0x01d9
        L_0x002e:
            java.util.regex.Pattern r0 = f13983a
            r4 = r1[r8]
            java.util.regex.Matcher r0 = r0.matcher(r4)
            boolean r4 = r0.matches()
            if (r4 != 0) goto L_0x0043
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r2)
            goto L_0x01d9
        L_0x0043:
            java.lang.String r9 = r0.group(r8)
            java.lang.String r0 = "09"
            java.lang.String r2 = "08"
            java.lang.String r4 = "07"
            java.lang.String r10 = "06"
            java.lang.String r11 = "05"
            java.lang.String r12 = "04"
            java.lang.String r13 = "03"
            java.lang.String r14 = "02"
            java.lang.String r15 = "01"
            if (r9 != 0) goto L_0x005d
            goto L_0x00f0
        L_0x005d:
            int r16 = r9.hashCode()
            switch(r16) {
                case 1536: goto L_0x00b9;
                case 1537: goto L_0x00b2;
                case 1538: goto L_0x00a9;
                case 1539: goto L_0x00a0;
                case 1540: goto L_0x0097;
                case 1541: goto L_0x008e;
                case 1542: goto L_0x0085;
                case 1543: goto L_0x007c;
                case 1544: goto L_0x0072;
                case 1545: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x00c4
        L_0x0066:
            boolean r8 = r9.equals(r0)
            if (r8 != 0) goto L_0x006e
            goto L_0x00c4
        L_0x006e:
            r8 = 9
            goto L_0x00c5
        L_0x0072:
            boolean r8 = r9.equals(r2)
            if (r8 != 0) goto L_0x0079
            goto L_0x00c4
        L_0x0079:
            r8 = 8
            goto L_0x00c5
        L_0x007c:
            boolean r8 = r9.equals(r4)
            if (r8 != 0) goto L_0x0083
            goto L_0x00c4
        L_0x0083:
            r8 = 7
            goto L_0x00c5
        L_0x0085:
            boolean r8 = r9.equals(r10)
            if (r8 != 0) goto L_0x008c
            goto L_0x00c4
        L_0x008c:
            r8 = 6
            goto L_0x00c5
        L_0x008e:
            boolean r8 = r9.equals(r11)
            if (r8 != 0) goto L_0x0095
            goto L_0x00c4
        L_0x0095:
            r8 = 5
            goto L_0x00c5
        L_0x0097:
            boolean r8 = r9.equals(r12)
            if (r8 != 0) goto L_0x009e
            goto L_0x00c4
        L_0x009e:
            r8 = 4
            goto L_0x00c5
        L_0x00a0:
            boolean r8 = r9.equals(r13)
            if (r8 != 0) goto L_0x00a7
            goto L_0x00c4
        L_0x00a7:
            r8 = 3
            goto L_0x00c5
        L_0x00a9:
            boolean r8 = r9.equals(r14)
            if (r8 != 0) goto L_0x00b0
            goto L_0x00c4
        L_0x00b0:
            r8 = 2
            goto L_0x00c5
        L_0x00b2:
            boolean r16 = r9.equals(r15)
            if (r16 != 0) goto L_0x00c5
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r8 = "00"
            boolean r8 = r9.equals(r8)
            if (r8 != 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r8 = 0
            goto L_0x00c5
        L_0x00c4:
            r8 = -1
        L_0x00c5:
            switch(r8) {
                case 0: goto L_0x00ea;
                case 1: goto L_0x00e5;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00db;
                case 4: goto L_0x00d8;
                case 5: goto L_0x00d5;
                case 6: goto L_0x00d2;
                case 7: goto L_0x00cf;
                case 8: goto L_0x00cc;
                case 9: goto L_0x00c9;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            goto L_0x00f0
        L_0x00c9:
            r8 = 512(0x200, float:7.175E-43)
            goto L_0x00eb
        L_0x00cc:
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x00eb
        L_0x00cf:
            r8 = 128(0x80, float:1.794E-43)
            goto L_0x00eb
        L_0x00d2:
            r8 = 64
            goto L_0x00eb
        L_0x00d5:
            r8 = 32
            goto L_0x00eb
        L_0x00d8:
            r8 = 16
            goto L_0x00eb
        L_0x00db:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            goto L_0x00f1
        L_0x00e0:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            goto L_0x00f1
        L_0x00e5:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            goto L_0x00f1
        L_0x00ea:
            r8 = 1
        L_0x00eb:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00f1
        L_0x00f0:
            r8 = 0
        L_0x00f1:
            if (r8 != 0) goto L_0x00fc
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            r0.<init>(r1)
            goto L_0x01d9
        L_0x00fc:
            r9 = r1[r7]
            if (r9 != 0) goto L_0x0102
            goto L_0x01cf
        L_0x0102:
            int r1 = r9.hashCode()
            switch(r1) {
                case 1537: goto L_0x0161;
                case 1538: goto L_0x0158;
                case 1539: goto L_0x014f;
                case 1540: goto L_0x0146;
                case 1541: goto L_0x013b;
                case 1542: goto L_0x0130;
                case 1543: goto L_0x0125;
                case 1544: goto L_0x011a;
                case 1545: goto L_0x010e;
                default: goto L_0x0109;
            }
        L_0x0109:
            switch(r1) {
                case 1567: goto L_0x018e;
                case 1568: goto L_0x0182;
                case 1569: goto L_0x0176;
                case 1570: goto L_0x016a;
                default: goto L_0x010c;
            }
        L_0x010c:
            goto L_0x019a
        L_0x010e:
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0116
            goto L_0x019a
        L_0x0116:
            r0 = 8
            goto L_0x019b
        L_0x011a:
            boolean r0 = r9.equals(r2)
            if (r0 != 0) goto L_0x0122
            goto L_0x019a
        L_0x0122:
            r0 = 7
            goto L_0x019b
        L_0x0125:
            boolean r0 = r9.equals(r4)
            if (r0 != 0) goto L_0x012d
            goto L_0x019a
        L_0x012d:
            r0 = 6
            goto L_0x019b
        L_0x0130:
            boolean r0 = r9.equals(r10)
            if (r0 != 0) goto L_0x0138
            goto L_0x019a
        L_0x0138:
            r0 = 5
            goto L_0x019b
        L_0x013b:
            boolean r0 = r9.equals(r11)
            if (r0 != 0) goto L_0x0143
            goto L_0x019a
        L_0x0143:
            r0 = 4
            goto L_0x019b
        L_0x0146:
            boolean r0 = r9.equals(r12)
            if (r0 != 0) goto L_0x014d
            goto L_0x019a
        L_0x014d:
            r0 = 3
            goto L_0x019b
        L_0x014f:
            boolean r0 = r9.equals(r13)
            if (r0 != 0) goto L_0x0156
            goto L_0x019a
        L_0x0156:
            r0 = 2
            goto L_0x019b
        L_0x0158:
            boolean r0 = r9.equals(r14)
            if (r0 != 0) goto L_0x015f
            goto L_0x019a
        L_0x015f:
            r0 = 1
            goto L_0x019b
        L_0x0161:
            boolean r0 = r9.equals(r15)
            if (r0 != 0) goto L_0x0168
            goto L_0x019a
        L_0x0168:
            r0 = 0
            goto L_0x019b
        L_0x016a:
            java.lang.String r0 = "13"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0173
            goto L_0x019a
        L_0x0173:
            r0 = 12
            goto L_0x019b
        L_0x0176:
            java.lang.String r0 = "12"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x017f
            goto L_0x019a
        L_0x017f:
            r0 = 11
            goto L_0x019b
        L_0x0182:
            java.lang.String r0 = "11"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x018b
            goto L_0x019a
        L_0x018b:
            r0 = 10
            goto L_0x019b
        L_0x018e:
            java.lang.String r0 = "10"
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L_0x0197
            goto L_0x019a
        L_0x0197:
            r0 = 9
            goto L_0x019b
        L_0x019a:
            r0 = -1
        L_0x019b:
            switch(r0) {
                case 0: goto L_0x01c9;
                case 1: goto L_0x01c4;
                case 2: goto L_0x01bf;
                case 3: goto L_0x01ba;
                case 4: goto L_0x01b7;
                case 5: goto L_0x01b4;
                case 6: goto L_0x01b1;
                case 7: goto L_0x01ae;
                case 8: goto L_0x01ab;
                case 9: goto L_0x01a8;
                case 10: goto L_0x01a5;
                case 11: goto L_0x01a2;
                case 12: goto L_0x019f;
                default: goto L_0x019e;
            }
        L_0x019e:
            goto L_0x01cf
        L_0x019f:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x01ca
        L_0x01a2:
            r0 = 2048(0x800, float:2.87E-42)
            goto L_0x01ca
        L_0x01a5:
            r0 = 1024(0x400, float:1.435E-42)
            goto L_0x01ca
        L_0x01a8:
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x01ca
        L_0x01ab:
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x01ca
        L_0x01ae:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x01ca
        L_0x01b1:
            r0 = 64
            goto L_0x01ca
        L_0x01b4:
            r0 = 32
            goto L_0x01ca
        L_0x01b7:
            r0 = 16
            goto L_0x01ca
        L_0x01ba:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            goto L_0x01d0
        L_0x01bf:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            goto L_0x01d0
        L_0x01c4:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
            goto L_0x01d0
        L_0x01c9:
            r0 = 1
        L_0x01ca:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x01d0
        L_0x01cf:
            r0 = 0
        L_0x01d0:
            if (r0 != 0) goto L_0x01e5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            r0.<init>(r1)
        L_0x01d9:
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            j1.v.g(r3, r0)
            r0 = 0
            goto L_0x01eb
        L_0x01e5:
            android.util.Pair r1 = new android.util.Pair
            r1.<init>(r8, r0)
            r0 = r1
        L_0x01eb:
            return r0
        L_0x01ec:
            r2 = 0
            r2 = r1[r2]
            r2.getClass()
            int r4 = r2.hashCode()
            switch(r4) {
                case 3004662: goto L_0x023c;
                case 3006243: goto L_0x0231;
                case 3006244: goto L_0x0226;
                case 3199032: goto L_0x021b;
                case 3214780: goto L_0x0210;
                case 3356560: goto L_0x0205;
                case 3624515: goto L_0x01fa;
                default: goto L_0x01f9;
            }
        L_0x01f9:
            goto L_0x0247
        L_0x01fa:
            java.lang.String r4 = "vp09"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0203
            goto L_0x0247
        L_0x0203:
            r2 = 6
            goto L_0x0248
        L_0x0205:
            java.lang.String r4 = "mp4a"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x020e
            goto L_0x0247
        L_0x020e:
            r2 = 5
            goto L_0x0248
        L_0x0210:
            java.lang.String r4 = "hvc1"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0219
            goto L_0x0247
        L_0x0219:
            r2 = 4
            goto L_0x0248
        L_0x021b:
            java.lang.String r4 = "hev1"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0224
            goto L_0x0247
        L_0x0224:
            r2 = 3
            goto L_0x0248
        L_0x0226:
            java.lang.String r4 = "avc2"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x022f
            goto L_0x0247
        L_0x022f:
            r2 = 2
            goto L_0x0248
        L_0x0231:
            java.lang.String r4 = "avc1"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x023a
            goto L_0x0247
        L_0x023a:
            r2 = 1
            goto L_0x0248
        L_0x023c:
            java.lang.String r4 = "av01"
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x0245
            goto L_0x0247
        L_0x0245:
            r2 = 0
            goto L_0x0248
        L_0x0247:
            r2 = -1
        L_0x0248:
            switch(r2) {
                case 0: goto L_0x06e6;
                case 1: goto L_0x05df;
                case 2: goto L_0x05df;
                case 3: goto L_0x03ad;
                case 4: goto L_0x03ad;
                case 5: goto L_0x0314;
                case 6: goto L_0x024d;
                default: goto L_0x024b;
            }
        L_0x024b:
            r0 = 0
            return r0
        L_0x024d:
            r0 = 0
            int r2 = r1.length
            java.lang.String r4 = "Ignoring malformed VP9 codec string: "
            r5 = 3
            if (r2 >= r5) goto L_0x025b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            goto L_0x0309
        L_0x025b:
            r2 = 1
            r5 = r1[r2]     // Catch:{ NumberFormatException -> 0x0304 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x0304 }
            r1 = r1[r7]     // Catch:{ NumberFormatException -> 0x0304 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0304 }
            if (r5 == 0) goto L_0x027a
            if (r5 == r2) goto L_0x0278
            if (r5 == r7) goto L_0x0276
            r2 = 3
            if (r5 == r2) goto L_0x0273
            r2 = -1
            goto L_0x027b
        L_0x0273:
            r2 = 8
            goto L_0x027b
        L_0x0276:
            r2 = 4
            goto L_0x027b
        L_0x0278:
            r2 = 2
            goto L_0x027b
        L_0x027a:
            r2 = 1
        L_0x027b:
            r4 = -1
            if (r2 != r4) goto L_0x028a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown VP9 profile: "
            r1.<init>(r2)
            r1.append(r5)
            goto L_0x030c
        L_0x028a:
            r4 = 10
            if (r1 == r4) goto L_0x02e6
            r4 = 11
            if (r1 == r4) goto L_0x02e3
            r4 = 20
            if (r1 == r4) goto L_0x02e0
            r4 = 21
            if (r1 == r4) goto L_0x02dc
            r4 = 30
            if (r1 == r4) goto L_0x02d8
            r4 = 31
            if (r1 == r4) goto L_0x02d4
            r4 = 40
            if (r1 == r4) goto L_0x02d0
            r4 = 41
            if (r1 == r4) goto L_0x02cc
            r4 = 50
            if (r1 == r4) goto L_0x02c8
            r4 = 51
            if (r1 == r4) goto L_0x02c4
            switch(r1) {
                case 60: goto L_0x02c0;
                case 61: goto L_0x02bc;
                case 62: goto L_0x02b8;
                default: goto L_0x02b5;
            }
        L_0x02b5:
            r5 = -1
            r4 = -1
            goto L_0x02e8
        L_0x02b8:
            r4 = 8192(0x2000, float:1.14794E-41)
            r5 = -1
            goto L_0x02e8
        L_0x02bc:
            r5 = -1
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x02e8
        L_0x02c0:
            r5 = -1
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x02e8
        L_0x02c4:
            r5 = -1
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x02e8
        L_0x02c8:
            r5 = -1
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x02e8
        L_0x02cc:
            r5 = -1
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x02e8
        L_0x02d0:
            r5 = -1
            r4 = 64
            goto L_0x02e8
        L_0x02d4:
            r5 = -1
            r4 = 32
            goto L_0x02e8
        L_0x02d8:
            r5 = -1
            r4 = 16
            goto L_0x02e8
        L_0x02dc:
            r5 = -1
            r4 = 8
            goto L_0x02e8
        L_0x02e0:
            r5 = -1
            r4 = 4
            goto L_0x02e8
        L_0x02e3:
            r5 = -1
            r4 = 2
            goto L_0x02e8
        L_0x02e6:
            r5 = -1
            r4 = 1
        L_0x02e8:
            if (r4 != r5) goto L_0x02f6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown VP9 level: "
            r2.<init>(r4)
            r2.append(r1)
            r1 = r2
            goto L_0x030c
        L_0x02f6:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.<init>(r1, r2)
            goto L_0x0313
        L_0x0304:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
        L_0x0309:
            r1.append(r9)
        L_0x030c:
            java.lang.String r1 = r1.toString()
            j1.v.g(r3, r1)
        L_0x0313:
            return r0
        L_0x0314:
            r0 = 0
            int r2 = r1.length
            java.lang.String r4 = "Ignoring malformed MP4A codec string: "
            r5 = 3
            if (r2 == r5) goto L_0x0322
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            goto L_0x03a2
        L_0x0322:
            r2 = 1
            r2 = r1[r2]     // Catch:{ NumberFormatException -> 0x039d }
            r5 = 16
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x039d }
            java.lang.String r2 = g1.a1.e(r2)     // Catch:{ NumberFormatException -> 0x039d }
            java.lang.String r5 = "audio/mp4a-latm"
            boolean r2 = r5.equals(r2)     // Catch:{ NumberFormatException -> 0x039d }
            if (r2 == 0) goto L_0x03ac
            r1 = r1[r7]     // Catch:{ NumberFormatException -> 0x039d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x039d }
            r2 = 17
            if (r1 == r2) goto L_0x0386
            r2 = 20
            if (r1 == r2) goto L_0x0381
            r2 = 23
            if (r1 == r2) goto L_0x037c
            r2 = 29
            if (r1 == r2) goto L_0x0377
            r2 = 39
            if (r1 == r2) goto L_0x0372
            r2 = 42
            if (r1 == r2) goto L_0x036d
            switch(r1) {
                case 1: goto L_0x036a;
                case 2: goto L_0x0367;
                case 3: goto L_0x0364;
                case 4: goto L_0x0361;
                case 5: goto L_0x035e;
                case 6: goto L_0x035b;
                default: goto L_0x0358;
            }     // Catch:{ NumberFormatException -> 0x039d }
        L_0x0358:
            r1 = -1
            r2 = -1
            goto L_0x038b
        L_0x035b:
            r1 = -1
            r2 = 6
            goto L_0x038b
        L_0x035e:
            r1 = -1
            r2 = 5
            goto L_0x038b
        L_0x0361:
            r1 = -1
            r2 = 4
            goto L_0x038b
        L_0x0364:
            r1 = -1
            r2 = 3
            goto L_0x038b
        L_0x0367:
            r1 = -1
            r2 = 2
            goto L_0x038b
        L_0x036a:
            r1 = -1
            r2 = 1
            goto L_0x038b
        L_0x036d:
            r1 = 42
            r2 = 42
            goto L_0x038a
        L_0x0372:
            r1 = 39
            r2 = 39
            goto L_0x038a
        L_0x0377:
            r1 = 29
            r2 = 29
            goto L_0x038a
        L_0x037c:
            r1 = 23
            r2 = 23
            goto L_0x038a
        L_0x0381:
            r1 = 20
            r2 = 20
            goto L_0x038a
        L_0x0386:
            r1 = 17
            r2 = 17
        L_0x038a:
            r1 = -1
        L_0x038b:
            if (r2 == r1) goto L_0x03ac
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x039d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x039d }
            r5 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x039d }
            r1.<init>(r2, r5)     // Catch:{ NumberFormatException -> 0x039d }
            r0 = r1
            goto L_0x03ac
        L_0x039d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
        L_0x03a2:
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            j1.v.g(r3, r1)
        L_0x03ac:
            return r0
        L_0x03ad:
            r2 = 0
            int r4 = r1.length
            java.lang.String r8 = "Ignoring malformed HEVC codec string: "
            if (r4 >= r6) goto L_0x03ba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            goto L_0x05d4
        L_0x03ba:
            java.util.regex.Pattern r4 = f13983a
            r10 = 1
            r11 = r1[r10]
            java.util.regex.Matcher r4 = r4.matcher(r11)
            boolean r11 = r4.matches()
            if (r11 != 0) goto L_0x03d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            goto L_0x05d4
        L_0x03d0:
            java.lang.String r9 = r4.group(r10)
            java.lang.String r4 = "1"
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x03de
            r0 = 1
            goto L_0x03f3
        L_0x03de:
            java.lang.String r4 = "2"
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x05cd
            g1.o r0 = r0.E
            if (r0 == 0) goto L_0x03f2
            int r0 = r0.f6492j
            r4 = 6
            if (r0 != r4) goto L_0x03f2
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x03f3
        L_0x03f2:
            r0 = 2
        L_0x03f3:
            r4 = 3
            r1 = r1[r4]
            if (r1 != 0) goto L_0x03fa
            goto L_0x05b5
        L_0x03fa:
            int r4 = r1.hashCode()
            switch(r4) {
                case 70821: goto L_0x054c;
                case 70914: goto L_0x0541;
                case 70917: goto L_0x0536;
                case 71007: goto L_0x052b;
                case 71010: goto L_0x0520;
                case 74665: goto L_0x0515;
                case 74758: goto L_0x050a;
                case 74761: goto L_0x04ff;
                case 74851: goto L_0x04f1;
                case 74854: goto L_0x04e3;
                case 2193639: goto L_0x04d5;
                case 2193642: goto L_0x04c7;
                case 2193732: goto L_0x04b9;
                case 2193735: goto L_0x04ab;
                case 2193738: goto L_0x049d;
                case 2193825: goto L_0x048f;
                case 2193828: goto L_0x0481;
                case 2193831: goto L_0x0473;
                case 2312803: goto L_0x0465;
                case 2312806: goto L_0x0457;
                case 2312896: goto L_0x0449;
                case 2312899: goto L_0x043b;
                case 2312902: goto L_0x042d;
                case 2312989: goto L_0x041f;
                case 2312992: goto L_0x0411;
                case 2312995: goto L_0x0403;
                default: goto L_0x0401;
            }
        L_0x0401:
            goto L_0x0557
        L_0x0403:
            java.lang.String r4 = "L186"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x040d
            goto L_0x0557
        L_0x040d:
            r4 = 25
            goto L_0x0558
        L_0x0411:
            java.lang.String r4 = "L183"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x041b
            goto L_0x0557
        L_0x041b:
            r4 = 24
            goto L_0x0558
        L_0x041f:
            java.lang.String r4 = "L180"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0429
            goto L_0x0557
        L_0x0429:
            r4 = 23
            goto L_0x0558
        L_0x042d:
            java.lang.String r4 = "L156"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0437
            goto L_0x0557
        L_0x0437:
            r4 = 22
            goto L_0x0558
        L_0x043b:
            java.lang.String r4 = "L153"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0445
            goto L_0x0557
        L_0x0445:
            r4 = 21
            goto L_0x0558
        L_0x0449:
            java.lang.String r4 = "L150"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0453
            goto L_0x0557
        L_0x0453:
            r4 = 20
            goto L_0x0558
        L_0x0457:
            java.lang.String r4 = "L123"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0461
            goto L_0x0557
        L_0x0461:
            r4 = 19
            goto L_0x0558
        L_0x0465:
            java.lang.String r4 = "L120"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x046f
            goto L_0x0557
        L_0x046f:
            r4 = 18
            goto L_0x0558
        L_0x0473:
            java.lang.String r4 = "H186"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x047d
            goto L_0x0557
        L_0x047d:
            r4 = 17
            goto L_0x0558
        L_0x0481:
            java.lang.String r4 = "H183"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x048b
            goto L_0x0557
        L_0x048b:
            r4 = 16
            goto L_0x0558
        L_0x048f:
            java.lang.String r4 = "H180"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0499
            goto L_0x0557
        L_0x0499:
            r4 = 15
            goto L_0x0558
        L_0x049d:
            java.lang.String r4 = "H156"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04a7
            goto L_0x0557
        L_0x04a7:
            r4 = 14
            goto L_0x0558
        L_0x04ab:
            java.lang.String r4 = "H153"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04b5
            goto L_0x0557
        L_0x04b5:
            r4 = 13
            goto L_0x0558
        L_0x04b9:
            java.lang.String r4 = "H150"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04c3
            goto L_0x0557
        L_0x04c3:
            r4 = 12
            goto L_0x0558
        L_0x04c7:
            java.lang.String r4 = "H123"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04d1
            goto L_0x0557
        L_0x04d1:
            r4 = 11
            goto L_0x0558
        L_0x04d5:
            java.lang.String r4 = "H120"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04df
            goto L_0x0557
        L_0x04df:
            r4 = 10
            goto L_0x0558
        L_0x04e3:
            java.lang.String r4 = "L93"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04ed
            goto L_0x0557
        L_0x04ed:
            r4 = 9
            goto L_0x0558
        L_0x04f1:
            java.lang.String r4 = "L90"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x04fb
            goto L_0x0557
        L_0x04fb:
            r4 = 8
            goto L_0x0558
        L_0x04ff:
            java.lang.String r4 = "L63"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0508
            goto L_0x0557
        L_0x0508:
            r4 = 7
            goto L_0x0558
        L_0x050a:
            java.lang.String r4 = "L60"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0513
            goto L_0x0557
        L_0x0513:
            r4 = 6
            goto L_0x0558
        L_0x0515:
            java.lang.String r4 = "L30"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x051e
            goto L_0x0557
        L_0x051e:
            r4 = 5
            goto L_0x0558
        L_0x0520:
            java.lang.String r4 = "H93"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0529
            goto L_0x0557
        L_0x0529:
            r4 = 4
            goto L_0x0558
        L_0x052b:
            java.lang.String r4 = "H90"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0534
            goto L_0x0557
        L_0x0534:
            r4 = 3
            goto L_0x0558
        L_0x0536:
            java.lang.String r4 = "H63"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x053f
            goto L_0x0557
        L_0x053f:
            r4 = 2
            goto L_0x0558
        L_0x0541:
            java.lang.String r4 = "H60"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x054a
            goto L_0x0557
        L_0x054a:
            r4 = 1
            goto L_0x0558
        L_0x054c:
            java.lang.String r4 = "H30"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0555
            goto L_0x0557
        L_0x0555:
            r4 = 0
            goto L_0x0558
        L_0x0557:
            r4 = -1
        L_0x0558:
            switch(r4) {
                case 0: goto L_0x05b0;
                case 1: goto L_0x05ab;
                case 2: goto L_0x05a4;
                case 3: goto L_0x05a1;
                case 4: goto L_0x059e;
                case 5: goto L_0x059c;
                case 6: goto L_0x0597;
                case 7: goto L_0x0594;
                case 8: goto L_0x0591;
                case 9: goto L_0x058e;
                case 10: goto L_0x058b;
                case 11: goto L_0x0588;
                case 12: goto L_0x0584;
                case 13: goto L_0x0581;
                case 14: goto L_0x057e;
                case 15: goto L_0x057b;
                case 16: goto L_0x0578;
                case 17: goto L_0x0575;
                case 18: goto L_0x0572;
                case 19: goto L_0x056f;
                case 20: goto L_0x056c;
                case 21: goto L_0x0569;
                case 22: goto L_0x0566;
                case 23: goto L_0x0563;
                case 24: goto L_0x0560;
                case 25: goto L_0x055d;
                default: goto L_0x055b;
            }
        L_0x055b:
            goto L_0x05b5
        L_0x055d:
            r4 = 16777216(0x1000000, float:2.3509887E-38)
            goto L_0x05a6
        L_0x0560:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x05a6
        L_0x0563:
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x05a6
        L_0x0566:
            r4 = 262144(0x40000, float:3.67342E-40)
            goto L_0x05a6
        L_0x0569:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x05a6
        L_0x056c:
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x05a6
        L_0x056f:
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x05a6
        L_0x0572:
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x05a6
        L_0x0575:
            r4 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x05a6
        L_0x0578:
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x05a6
        L_0x057b:
            r4 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x05a6
        L_0x057e:
            r4 = 524288(0x80000, float:7.34684E-40)
            goto L_0x05a6
        L_0x0581:
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x05a6
        L_0x0584:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x05a6
        L_0x0588:
            r4 = 8192(0x2000, float:1.14794E-41)
            goto L_0x05a6
        L_0x058b:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x05a6
        L_0x058e:
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x05a6
        L_0x0591:
            r4 = 64
            goto L_0x05a6
        L_0x0594:
            r4 = 16
            goto L_0x05a6
        L_0x0597:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            goto L_0x05b6
        L_0x059c:
            r4 = 1
            goto L_0x05a6
        L_0x059e:
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x05a6
        L_0x05a1:
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x05a6
        L_0x05a4:
            r4 = 32
        L_0x05a6:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x05b6
        L_0x05ab:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            goto L_0x05b6
        L_0x05b0:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            goto L_0x05b6
        L_0x05b5:
            r4 = r2
        L_0x05b6:
            if (r4 != 0) goto L_0x05c3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown HEVC level string: "
            r0.<init>(r4)
            r0.append(r1)
            goto L_0x05d7
        L_0x05c3:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.<init>(r0, r4)
            goto L_0x05de
        L_0x05cd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown HEVC profile string: "
            r0.<init>(r1)
        L_0x05d4:
            r0.append(r9)
        L_0x05d7:
            java.lang.String r0 = r0.toString()
            j1.v.g(r3, r0)
        L_0x05de:
            return r2
        L_0x05df:
            r0 = 0
            int r2 = r1.length
            java.lang.String r4 = "Ignoring malformed AVC codec string: "
            if (r2 >= r7) goto L_0x05ec
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            goto L_0x06da
        L_0x05ec:
            r2 = 1
            r5 = r1[r2]     // Catch:{ NumberFormatException -> 0x06d5 }
            int r5 = r5.length()     // Catch:{ NumberFormatException -> 0x06d5 }
            r8 = 6
            if (r5 != r8) goto L_0x060e
            r5 = r1[r2]     // Catch:{ NumberFormatException -> 0x06d5 }
            r8 = 0
            java.lang.String r5 = r5.substring(r8, r7)     // Catch:{ NumberFormatException -> 0x06d5 }
            r8 = 16
            int r5 = java.lang.Integer.parseInt(r5, r8)     // Catch:{ NumberFormatException -> 0x06d5 }
            r1 = r1[r2]     // Catch:{ NumberFormatException -> 0x06d5 }
            java.lang.String r1 = r1.substring(r6)     // Catch:{ NumberFormatException -> 0x06d5 }
            int r1 = java.lang.Integer.parseInt(r1, r8)     // Catch:{ NumberFormatException -> 0x06d5 }
            goto L_0x0621
        L_0x060e:
            r8 = 16
            int r2 = r1.length     // Catch:{ NumberFormatException -> 0x06d5 }
            r5 = 3
            if (r2 < r5) goto L_0x06c5
            r2 = 1
            r2 = r1[r2]     // Catch:{ NumberFormatException -> 0x06d5 }
            int r5 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x06d5 }
            r1 = r1[r7]     // Catch:{ NumberFormatException -> 0x06d5 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x06d5 }
        L_0x0621:
            r2 = 66
            if (r5 == r2) goto L_0x0655
            r2 = 77
            if (r5 == r2) goto L_0x0653
            r2 = 88
            if (r5 == r2) goto L_0x0650
            r2 = 100
            if (r5 == r2) goto L_0x064c
            r2 = 110(0x6e, float:1.54E-43)
            if (r5 == r2) goto L_0x0648
            r2 = 122(0x7a, float:1.71E-43)
            if (r5 == r2) goto L_0x0644
            r2 = 244(0xf4, float:3.42E-43)
            if (r5 == r2) goto L_0x0640
            r2 = -1
            r7 = -1
            goto L_0x0657
        L_0x0640:
            r2 = -1
            r7 = 64
            goto L_0x0657
        L_0x0644:
            r2 = -1
            r7 = 32
            goto L_0x0657
        L_0x0648:
            r2 = -1
            r7 = 16
            goto L_0x0657
        L_0x064c:
            r2 = -1
            r7 = 8
            goto L_0x0657
        L_0x0650:
            r2 = -1
            r7 = 4
            goto L_0x0657
        L_0x0653:
            r2 = -1
            goto L_0x0657
        L_0x0655:
            r2 = -1
            r7 = 1
        L_0x0657:
            if (r7 != r2) goto L_0x0661
            java.lang.String r1 = "Unknown AVC profile: "
            java.lang.String r1 = android.support.v4.media.h.i(r1, r5)
            goto L_0x06e2
        L_0x0661:
            switch(r1) {
                case 10: goto L_0x067a;
                case 11: goto L_0x0677;
                case 12: goto L_0x0673;
                case 13: goto L_0x06a8;
                default: goto L_0x0664;
            }
        L_0x0664:
            switch(r1) {
                case 20: goto L_0x0685;
                case 21: goto L_0x0681;
                case 22: goto L_0x067d;
                default: goto L_0x0667;
            }
        L_0x0667:
            switch(r1) {
                case 30: goto L_0x0690;
                case 31: goto L_0x068c;
                case 32: goto L_0x0689;
                default: goto L_0x066a;
            }
        L_0x066a:
            switch(r1) {
                case 40: goto L_0x069b;
                case 41: goto L_0x0697;
                case 42: goto L_0x0694;
                default: goto L_0x066d;
            }
        L_0x066d:
            switch(r1) {
                case 50: goto L_0x06a6;
                case 51: goto L_0x06a2;
                case 52: goto L_0x069f;
                default: goto L_0x0670;
            }
        L_0x0670:
            r2 = -1
            r4 = -1
            goto L_0x06aa
        L_0x0673:
            r2 = -1
            r4 = 8
            goto L_0x06aa
        L_0x0677:
            r2 = -1
            r4 = 4
            goto L_0x06aa
        L_0x067a:
            r2 = -1
            r4 = 1
            goto L_0x06aa
        L_0x067d:
            r2 = -1
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x06aa
        L_0x0681:
            r2 = -1
            r4 = 64
            goto L_0x06aa
        L_0x0685:
            r2 = -1
            r4 = 32
            goto L_0x06aa
        L_0x0689:
            r8 = 1024(0x400, float:1.435E-42)
            goto L_0x06a8
        L_0x068c:
            r2 = -1
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x06aa
        L_0x0690:
            r2 = -1
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x06aa
        L_0x0694:
            r8 = 8192(0x2000, float:1.14794E-41)
            goto L_0x06a8
        L_0x0697:
            r2 = -1
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x06aa
        L_0x069b:
            r2 = -1
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x06aa
        L_0x069f:
            r8 = 65536(0x10000, float:9.18355E-41)
            goto L_0x06a8
        L_0x06a2:
            r8 = 32768(0x8000, float:4.5918E-41)
            goto L_0x06a8
        L_0x06a6:
            r8 = 16384(0x4000, float:2.2959E-41)
        L_0x06a8:
            r2 = -1
            r4 = r8
        L_0x06aa:
            if (r4 != r2) goto L_0x06b7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown AVC level: "
            r2.<init>(r4)
            r2.append(r1)
            goto L_0x06de
        L_0x06b7:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.<init>(r1, r2)
            goto L_0x06e5
        L_0x06c5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x06d5 }
            r1.<init>(r4)     // Catch:{ NumberFormatException -> 0x06d5 }
            r1.append(r9)     // Catch:{ NumberFormatException -> 0x06d5 }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x06d5 }
            j1.v.g(r3, r1)     // Catch:{ NumberFormatException -> 0x06d5 }
            goto L_0x06e5
        L_0x06d5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
        L_0x06da:
            r1.append(r9)
            r2 = r1
        L_0x06de:
            java.lang.String r1 = r2.toString()
        L_0x06e2:
            j1.v.g(r3, r1)
        L_0x06e5:
            return r0
        L_0x06e6:
            r2 = 0
            r4 = 16
            int r8 = r1.length
            java.lang.String r10 = "Ignoring malformed AV1 codec string: "
            if (r8 >= r6) goto L_0x06f5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            goto L_0x07bc
        L_0x06f5:
            r6 = 1
            r6 = r1[r6]     // Catch:{ NumberFormatException -> 0x07b7 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x07b7 }
            r8 = r1[r7]     // Catch:{ NumberFormatException -> 0x07b7 }
            r11 = 0
            java.lang.String r7 = r8.substring(r11, r7)     // Catch:{ NumberFormatException -> 0x07b7 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x07b7 }
            r8 = 3
            r1 = r1[r8]     // Catch:{ NumberFormatException -> 0x07b7 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x07b7 }
            if (r6 == 0) goto L_0x071c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.<init>(r1)
            r0.append(r6)
            goto L_0x07bf
        L_0x071c:
            if (r1 == r5) goto L_0x072e
            r6 = 10
            if (r1 == r6) goto L_0x072e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Unknown AV1 bit depth: "
            r0.<init>(r4)
            r0.append(r1)
            goto L_0x07bf
        L_0x072e:
            if (r1 != r5) goto L_0x0732
            r0 = 1
            goto L_0x0746
        L_0x0732:
            g1.o r0 = r0.E
            if (r0 == 0) goto L_0x0745
            byte[] r1 = r0.f6493k
            if (r1 != 0) goto L_0x0742
            int r0 = r0.f6492j
            r1 = 7
            if (r0 == r1) goto L_0x0742
            r1 = 6
            if (r0 != r1) goto L_0x0745
        L_0x0742:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0746
        L_0x0745:
            r0 = 2
        L_0x0746:
            switch(r7) {
                case 0: goto L_0x079a;
                case 1: goto L_0x0797;
                case 2: goto L_0x0794;
                case 3: goto L_0x0790;
                case 4: goto L_0x078e;
                case 5: goto L_0x078a;
                case 6: goto L_0x0786;
                case 7: goto L_0x0782;
                case 8: goto L_0x077e;
                case 9: goto L_0x077a;
                case 10: goto L_0x0777;
                case 11: goto L_0x0773;
                case 12: goto L_0x076f;
                case 13: goto L_0x076c;
                case 14: goto L_0x0769;
                case 15: goto L_0x0765;
                case 16: goto L_0x0762;
                case 17: goto L_0x075f;
                case 18: goto L_0x075c;
                case 19: goto L_0x0759;
                case 20: goto L_0x0756;
                case 21: goto L_0x0753;
                case 22: goto L_0x0750;
                case 23: goto L_0x074d;
                default: goto L_0x0749;
            }
        L_0x0749:
            r1 = -1
            r4 = -1
            goto L_0x079c
        L_0x074d:
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x078e
        L_0x0750:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x078e
        L_0x0753:
            r4 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x078e
        L_0x0756:
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x078e
        L_0x0759:
            r4 = 524288(0x80000, float:7.34684E-40)
            goto L_0x078e
        L_0x075c:
            r4 = 262144(0x40000, float:3.67342E-40)
            goto L_0x078e
        L_0x075f:
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x078e
        L_0x0762:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x078e
        L_0x0765:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x078e
        L_0x0769:
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x078e
        L_0x076c:
            r4 = 8192(0x2000, float:1.14794E-41)
            goto L_0x078e
        L_0x076f:
            r1 = -1
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x079c
        L_0x0773:
            r1 = -1
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x079c
        L_0x0777:
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x078e
        L_0x077a:
            r1 = -1
            r4 = 512(0x200, float:7.175E-43)
            goto L_0x079c
        L_0x077e:
            r1 = -1
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x079c
        L_0x0782:
            r1 = -1
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x079c
        L_0x0786:
            r1 = -1
            r4 = 64
            goto L_0x079c
        L_0x078a:
            r1 = -1
            r4 = 32
            goto L_0x079c
        L_0x078e:
            r1 = -1
            goto L_0x079c
        L_0x0790:
            r1 = -1
            r4 = 8
            goto L_0x079c
        L_0x0794:
            r1 = -1
            r4 = 4
            goto L_0x079c
        L_0x0797:
            r1 = -1
            r4 = 2
            goto L_0x079c
        L_0x079a:
            r1 = -1
            r4 = 1
        L_0x079c:
            if (r4 != r1) goto L_0x07a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown AV1 level: "
            r0.<init>(r1)
            r0.append(r7)
            goto L_0x07bf
        L_0x07a9:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r2.<init>(r0, r1)
            goto L_0x07c6
        L_0x07b7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
        L_0x07bc:
            r0.append(r9)
        L_0x07bf:
            java.lang.String r0 = r0.toString()
            j1.v.g(r3, r0)
        L_0x07c6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s1.c0.d(g1.a0):android.util.Pair");
    }

    public static synchronized List e(String str, boolean z10, boolean z11) {
        synchronized (c0.class) {
            x xVar = new x(str, z10, z11);
            HashMap hashMap = f13984b;
            List list = (List) hashMap.get(xVar);
            if (list != null) {
                return list;
            }
            int i10 = l0.f8453a;
            ArrayList f10 = f(xVar, i10 >= 21 ? new h(z10, z11) : new a0(0));
            if (z10 && f10.isEmpty() && 21 <= i10 && i10 <= 23) {
                f10 = f(xVar, new a0(0));
                if (!f10.isEmpty()) {
                    v.g("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((q) f10.get(0)).f14033a);
                }
            }
            a(str, f10);
            r0 j10 = r0.j(f10);
            hashMap.put(xVar, j10);
            return j10;
        }
    }

    public static ArrayList f(x xVar, z zVar) {
        boolean z10;
        boolean z11;
        int i10;
        String str;
        String str2;
        boolean z12;
        boolean z13;
        boolean z14;
        x xVar2 = xVar;
        z zVar2 = zVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str3 = xVar2.f14084a;
            int f10 = zVar.f();
            boolean h10 = zVar.h();
            int i11 = 0;
            while (i11 < f10) {
                MediaCodecInfo a10 = zVar2.a(i11);
                int i12 = l0.f8453a;
                if (i12 < 29 || !a10.isAlias()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    String name = a10.getName();
                    if (g(a10, name, h10, str3)) {
                        String c10 = c(a10, name, str3);
                        if (c10 != null) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = a10.getCapabilitiesForType(c10);
                                boolean g10 = zVar2.g("tunneled-playback", c10, capabilitiesForType);
                                boolean e10 = zVar2.e("tunneled-playback", capabilitiesForType);
                                boolean z15 = xVar2.f14086c;
                                if (z15 || !e10) {
                                    if (!z15 || g10) {
                                        boolean g11 = zVar2.g("secure-playback", c10, capabilitiesForType);
                                        boolean e11 = zVar2.e("secure-playback", capabilitiesForType);
                                        boolean z16 = xVar2.f14085b;
                                        if ((z16 || !e11) && (!z16 || g11)) {
                                            if (i12 >= 29) {
                                                z13 = a10.isHardwareAccelerated();
                                                z12 = true;
                                            } else {
                                                z12 = true;
                                                z13 = !h(a10, str3);
                                            }
                                            boolean h11 = h(a10, str3);
                                            if (i12 >= 29) {
                                                z14 = a10.isVendor();
                                            } else {
                                                String a11 = b.a(a10.getName());
                                                if (a11.startsWith("omx.google.") || a11.startsWith("c2.android.") || a11.startsWith("c2.google.")) {
                                                    z12 = false;
                                                }
                                                z14 = z12;
                                            }
                                            if ((!h10 || z16 != g11) && (h10 || z16)) {
                                                str = c10;
                                                str2 = name;
                                                i10 = i11;
                                                z11 = h10;
                                                if (!z11 && g11) {
                                                    try {
                                                        arrayList.add(q.h(str2 + ".secure", str3, str, capabilitiesForType, z13, h11, z14, true));
                                                        return arrayList;
                                                    } catch (Exception e12) {
                                                        e = e12;
                                                    }
                                                }
                                                i11 = i10 + 1;
                                                xVar2 = xVar;
                                                zVar2 = zVar;
                                                h10 = z11;
                                            } else {
                                                String str4 = c10;
                                                str = c10;
                                                boolean z17 = z13;
                                                String str5 = name;
                                                i10 = i11;
                                                z11 = h10;
                                                try {
                                                    arrayList.add(q.h(name, str3, str4, capabilitiesForType, z17, h11, z14, false));
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    str2 = str5;
                                                }
                                                i11 = i10 + 1;
                                                xVar2 = xVar;
                                                zVar2 = zVar;
                                                h10 = z11;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e14) {
                                e = e14;
                                str = c10;
                                str2 = name;
                                i10 = i11;
                                z11 = h10;
                                if (l0.f8453a <= 23) {
                                    if (!arrayList.isEmpty()) {
                                        v.c("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                        i11 = i10 + 1;
                                        xVar2 = xVar;
                                        zVar2 = zVar;
                                        h10 = z11;
                                    }
                                }
                                v.c("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                throw e;
                            }
                        }
                    }
                }
                i10 = i11;
                z11 = h10;
                i11 = i10 + 1;
                xVar2 = xVar;
                zVar2 = zVar;
                h10 = z11;
            }
            return arrayList;
        } catch (Exception e15) {
            throw new y(e15);
        }
    }

    public static boolean g(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i10 = l0.f8453a;
        if (i10 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i10 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = l0.f8454b;
            if ("a70".equals(str3) || ("Xiaomi".equals(l0.f8455c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = l0.f8454b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i10 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = l0.f8454b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i10 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(l0.f8455c))) {
            String str6 = l0.f8454b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i10 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(l0.f8455c)) {
            String str7 = l0.f8454b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i10 > 19 || !l0.f8454b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return i10 > 23 || !"audio/eac3-joc".equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str);
        }
        return false;
    }

    public static boolean h(MediaCodecInfo mediaCodecInfo, String str) {
        if (l0.f8453a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (a1.i(str)) {
            return true;
        }
        String a10 = b.a(mediaCodecInfo.getName());
        if (a10.startsWith("arc.")) {
            return false;
        }
        if (a10.startsWith("omx.google.") || a10.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((a10.startsWith("omx.sec.") && a10.contains(".sw.")) || a10.equals("omx.qcom.video.decoder.hevcswvdec") || a10.startsWith("c2.android.") || a10.startsWith("c2.google.")) {
            return true;
        }
        if (a10.startsWith("omx.") || a10.startsWith("c2.")) {
            return false;
        }
        return true;
    }

    public static int i() {
        q qVar;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        int i10;
        int i11;
        if (f13985c == -1) {
            int i12 = 0;
            List e10 = e("video/avc", false, false);
            if (e10.isEmpty()) {
                qVar = null;
            } else {
                qVar = (q) e10.get(0);
            }
            if (qVar != null) {
                MediaCodecInfo.CodecCapabilities codecCapabilities = qVar.f14036d;
                if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                    codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
                }
                int length = codecProfileLevelArr.length;
                int i13 = 0;
                while (i12 < length) {
                    int i14 = codecProfileLevelArr[i12].level;
                    if (i14 != 1 && i14 != 2) {
                        switch (i14) {
                            case 8:
                            case Constants.IV_SIZE:
                            case Constants.IV_SIZE_ALTERNATIVE:
                                i11 = 101376;
                                break;
                            case 64:
                                i11 = 202752;
                                break;
                            case 128:
                            case 256:
                                i11 = 414720;
                                break;
                            case 512:
                                i11 = 921600;
                                break;
                            case 1024:
                                i11 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i11 = 2097152;
                                break;
                            case 8192:
                                i11 = 2228224;
                                break;
                            case 16384:
                                i11 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i11 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i11 = 35651584;
                                break;
                            default:
                                i11 = -1;
                                break;
                        }
                    } else {
                        i11 = 25344;
                    }
                    i13 = Math.max(i11, i13);
                    i12++;
                }
                if (l0.f8453a >= 21) {
                    i10 = 345600;
                } else {
                    i10 = 172800;
                }
                i12 = Math.max(i13, i10);
            }
            f13985c = i12;
        }
        return f13985c;
    }
}
