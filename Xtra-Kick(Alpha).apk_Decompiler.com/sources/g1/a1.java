package g1;

import android.support.v4.media.h;
import android.text.TextUtils;
import c9.b;
import j1.l0;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import m0.x;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public static final ArrayList f6284a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f6285b = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    private a1() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
        r4 = (r4 = f(r5)).a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r4.hashCode()
            r2 = 1
            r3 = -1
            switch(r1) {
                case -2123537834: goto L_0x0086;
                case -432837260: goto L_0x007b;
                case -432837259: goto L_0x0070;
                case -53558318: goto L_0x0065;
                case 187078296: goto L_0x005a;
                case 187094639: goto L_0x004f;
                case 1504578661: goto L_0x0044;
                case 1504619009: goto L_0x0039;
                case 1504831518: goto L_0x002b;
                case 1903231877: goto L_0x001d;
                case 1903589369: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0090
        L_0x000f:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0019
            goto L_0x0090
        L_0x0019:
            r3 = 10
            goto L_0x0090
        L_0x001d:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0027
            goto L_0x0090
        L_0x0027:
            r3 = 9
            goto L_0x0090
        L_0x002b:
            java.lang.String r1 = "audio/mpeg"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            r3 = 8
            goto L_0x0090
        L_0x0039:
            java.lang.String r1 = "audio/flac"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0042
            goto L_0x0090
        L_0x0042:
            r3 = 7
            goto L_0x0090
        L_0x0044:
            java.lang.String r1 = "audio/eac3"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x004d
            goto L_0x0090
        L_0x004d:
            r3 = 6
            goto L_0x0090
        L_0x004f:
            java.lang.String r1 = "audio/raw"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0058
            goto L_0x0090
        L_0x0058:
            r3 = 5
            goto L_0x0090
        L_0x005a:
            java.lang.String r1 = "audio/ac3"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0063
            goto L_0x0090
        L_0x0063:
            r3 = 4
            goto L_0x0090
        L_0x0065:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x006e
            goto L_0x0090
        L_0x006e:
            r3 = 3
            goto L_0x0090
        L_0x0070:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            r3 = 2
            goto L_0x0090
        L_0x007b:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x0084
            goto L_0x0090
        L_0x0084:
            r3 = 1
            goto L_0x0090
        L_0x0086:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r3 = 0
        L_0x0090:
            switch(r3) {
                case 0: goto L_0x00aa;
                case 1: goto L_0x00aa;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0094;
                case 4: goto L_0x00aa;
                case 5: goto L_0x00aa;
                case 6: goto L_0x00aa;
                case 7: goto L_0x00aa;
                case 8: goto L_0x00aa;
                case 9: goto L_0x00aa;
                case 10: goto L_0x00aa;
                default: goto L_0x0093;
            }
        L_0x0093:
            return r0
        L_0x0094:
            if (r5 != 0) goto L_0x0097
            return r0
        L_0x0097:
            m0.x r4 = f(r5)
            if (r4 != 0) goto L_0x009e
            return r0
        L_0x009e:
            int r4 = r4.a()
            if (r4 == 0) goto L_0x00a9
            r5 = 16
            if (r4 == r5) goto L_0x00a9
            r0 = 1
        L_0x00a9:
            return r0
        L_0x00aa:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g1.a1.a(java.lang.String, java.lang.String):boolean");
    }

    public static String b(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] O = l0.O(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : O) {
            if (str2.equals(d(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public static int c(String str, String str2) {
        x f10;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals("audio/eac3-joc")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c10 = 1;
                    break;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    c10 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c10 = 3;
                    break;
                }
                break;
            case 187078297:
                if (str.equals("audio/ac4")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals("audio/mpeg")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    c10 = 7;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c10 = 8;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals("audio/true-hd")) {
                    c10 = 9;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return 18;
            case 1:
                return 7;
            case 2:
                if (str2 == null || (f10 = f(str2)) == null) {
                    return 0;
                }
                return f10.a();
            case 3:
                return 5;
            case 4:
                return 17;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return 6;
            case 6:
                return 9;
            case 7:
                return 20;
            case 8:
                return 8;
            case 9:
                return 14;
            default:
                return 0;
        }
    }

    public static String d(String str) {
        x f10;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String a10 = b.a(str.trim());
        if (a10.startsWith("avc1") || a10.startsWith("avc3")) {
            return "video/avc";
        }
        if (a10.startsWith("hev1") || a10.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (a10.startsWith("dvav") || a10.startsWith("dva1") || a10.startsWith("dvhe") || a10.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (a10.startsWith("av01")) {
            return "video/av01";
        }
        if (a10.startsWith("vp9") || a10.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (a10.startsWith("vp8") || a10.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (a10.startsWith("mp4a")) {
            if (a10.startsWith("mp4a.") && (f10 = f(a10)) != null) {
                str2 = e(f10.f10157a);
            }
            if (str2 == null) {
                return "audio/mp4a-latm";
            }
            return str2;
        } else if (a10.startsWith("mha1")) {
            return "audio/mha1";
        } else {
            if (a10.startsWith("mhm1")) {
                return "audio/mhm1";
            }
            if (a10.startsWith("ac-3") || a10.startsWith("dac3")) {
                return "audio/ac3";
            }
            if (a10.startsWith("ec-3") || a10.startsWith("dec3")) {
                return "audio/eac3";
            }
            if (a10.startsWith("ec+3")) {
                return "audio/eac3-joc";
            }
            if (a10.startsWith("ac-4") || a10.startsWith("dac4")) {
                return "audio/ac4";
            }
            if (a10.startsWith("dtsc")) {
                return "audio/vnd.dts";
            }
            if (a10.startsWith("dtse")) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (a10.startsWith("dtsh") || a10.startsWith("dtsl")) {
                return "audio/vnd.dts.hd";
            }
            if (a10.startsWith("dtsx")) {
                return "audio/vnd.dts.uhd;profile=p2";
            }
            if (a10.startsWith("opus")) {
                return "audio/opus";
            }
            if (a10.startsWith("vorbis")) {
                return "audio/vorbis";
            }
            if (a10.startsWith("flac")) {
                return "audio/flac";
            }
            if (a10.startsWith("stpp")) {
                return "application/ttml+xml";
            }
            if (a10.startsWith("wvtt")) {
                return "text/vtt";
            }
            if (a10.contains("cea708")) {
                return "application/cea-708";
            }
            if (a10.contains("eia608") || a10.contains("cea608")) {
                return "application/cea-608";
            }
            ArrayList arrayList = f6284a;
            if (arrayList.size() <= 0) {
                return null;
            }
            h.y(arrayList.get(0));
            throw null;
        }
    }

    public static String e(int i10) {
        if (i10 == 32) {
            return "video/mp4v-es";
        }
        if (i10 == 33) {
            return "video/avc";
        }
        if (i10 == 35) {
            return "video/hevc";
        }
        if (i10 == 64) {
            return "audio/mp4a-latm";
        }
        if (i10 == 163) {
            return "video/wvc1";
        }
        if (i10 == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i10 == 165) {
            return "audio/ac3";
        }
        if (i10 == 166) {
            return "audio/eac3";
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i10) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static x f(String str) {
        int i10;
        Matcher matcher = f6285b.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(group, 16);
            if (group2 != null) {
                i10 = Integer.parseInt(group2);
            } else {
                i10 = 0;
            }
            return new x(parseInt, i10);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String g(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    public static int h(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (i(str)) {
            return 1;
        }
        if (k(str)) {
            return 2;
        }
        if (j(str)) {
            return 3;
        }
        if ("image".equals(g(str))) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        ArrayList arrayList = f6284a;
        if (arrayList.size() <= 0) {
            return -1;
        }
        h.y(arrayList.get(0));
        throw null;
    }

    public static boolean i(String str) {
        return "audio".equals(g(str));
    }

    public static boolean j(String str) {
        return "text".equals(g(str)) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str);
    }

    public static boolean k(String str) {
        return "video".equals(g(str));
    }
}
