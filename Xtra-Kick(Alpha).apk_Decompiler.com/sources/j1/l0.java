package j1;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.h;
import android.text.TextUtils;
import androidx.emoji2.text.r;
import c9.b;
import g.r0;
import g1.a1;
import g1.b1;
import h9.e0;
import h9.k0;
import h9.p;
import h9.q;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f8453a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f8454b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f8455c;

    /* renamed from: d  reason: collision with root package name */
    public static final String f8456d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f8457e;

    /* renamed from: f  reason: collision with root package name */
    public static final byte[] f8458f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f8459g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f8460h = Pattern.compile("(?:.*\\.)?isml?(?:/(manifest(.*))?)?", 2);

    /* renamed from: i  reason: collision with root package name */
    public static HashMap f8461i;

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f8462j = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "arb", "ar-arb", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f8463k = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f8464l = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    /* renamed from: m  reason: collision with root package name */
    public static final int[] f8465m = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, 219, 220, 213, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, 247, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, 217, 208, 215, 194, 197, 204, 203, 230, 225, 232, 239, 250, 253, 244, 243};

    static {
        int i10 = Build.VERSION.SDK_INT;
        f8453a = i10;
        String str = Build.DEVICE;
        f8454b = str;
        String str2 = Build.MANUFACTURER;
        f8455c = str2;
        String str3 = Build.MODEL;
        f8456d = str3;
        f8457e = str + ", " + str3 + ", " + str2 + ", " + i10;
        Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
    }

    private l0() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int A(android.net.Uri r11, java.lang.String r12) {
        /*
            r0 = -1
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 0
            r5 = 1
            if (r12 != 0) goto L_0x00d4
            java.lang.String r12 = r11.getScheme()
            if (r12 == 0) goto L_0x0043
            java.lang.String r6 = "rtsp"
            if (r6 != r12) goto L_0x0013
            goto L_0x003d
        L_0x0013:
            int r7 = r12.length()
            if (r1 == r7) goto L_0x001a
            goto L_0x003b
        L_0x001a:
            r7 = 0
        L_0x001b:
            if (r7 >= r1) goto L_0x003d
            char r8 = r6.charAt(r7)
            char r9 = r12.charAt(r7)
            if (r8 != r9) goto L_0x0028
            goto L_0x0038
        L_0x0028:
            r8 = r8 | 32
            int r8 = r8 + -97
            char r8 = (char) r8
            r10 = 26
            if (r8 >= r10) goto L_0x003b
            r9 = r9 | 32
            int r9 = r9 + -97
            char r9 = (char) r9
            if (r8 != r9) goto L_0x003b
        L_0x0038:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x003b:
            r12 = 0
            goto L_0x003e
        L_0x003d:
            r12 = 1
        L_0x003e:
            if (r12 == 0) goto L_0x0043
            r1 = 3
            goto L_0x00d3
        L_0x0043:
            java.lang.String r12 = r11.getLastPathSegment()
            if (r12 != 0) goto L_0x004b
            goto L_0x00d3
        L_0x004b:
            r6 = 46
            int r6 = r12.lastIndexOf(r6)
            if (r6 < 0) goto L_0x00a5
            int r6 = r6 + r5
            java.lang.String r12 = r12.substring(r6)
            java.lang.String r12 = c9.b.a(r12)
            r12.getClass()
            int r6 = r12.hashCode()
            switch(r6) {
                case 104579: goto L_0x0088;
                case 108321: goto L_0x007d;
                case 3242057: goto L_0x0072;
                case 3299913: goto L_0x0067;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x0092
        L_0x0067:
            java.lang.String r6 = "m3u8"
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x0070
            goto L_0x0092
        L_0x0070:
            r0 = 3
            goto L_0x0092
        L_0x0072:
            java.lang.String r6 = "isml"
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x007b
            goto L_0x0092
        L_0x007b:
            r0 = 2
            goto L_0x0092
        L_0x007d:
            java.lang.String r6 = "mpd"
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x0086
            goto L_0x0092
        L_0x0086:
            r0 = 1
            goto L_0x0092
        L_0x0088:
            java.lang.String r6 = "ism"
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r0 = 0
        L_0x0092:
            if (r0 == 0) goto L_0x00a0
            if (r0 == r5) goto L_0x009e
            if (r0 == r3) goto L_0x00a0
            if (r0 == r2) goto L_0x009c
            r12 = 4
            goto L_0x00a1
        L_0x009c:
            r12 = 2
            goto L_0x00a1
        L_0x009e:
            r12 = 0
            goto L_0x00a1
        L_0x00a0:
            r12 = 1
        L_0x00a1:
            if (r12 == r1) goto L_0x00a5
            r1 = r12
            goto L_0x00d3
        L_0x00a5:
            java.lang.String r11 = r11.getPath()
            r11.getClass()
            java.util.regex.Pattern r12 = f8460h
            java.util.regex.Matcher r11 = r12.matcher(r11)
            boolean r12 = r11.matches()
            if (r12 == 0) goto L_0x00d3
            java.lang.String r11 = r11.group(r3)
            if (r11 == 0) goto L_0x00d2
            java.lang.String r12 = "format=mpd-time-csf"
            boolean r12 = r11.contains(r12)
            if (r12 == 0) goto L_0x00c8
            r1 = 0
            goto L_0x00d3
        L_0x00c8:
            java.lang.String r12 = "format=m3u8-aapl"
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x00d2
            r1 = 2
            goto L_0x00d3
        L_0x00d2:
            r1 = 1
        L_0x00d3:
            return r1
        L_0x00d4:
            int r11 = r12.hashCode()
            switch(r11) {
                case -979127466: goto L_0x00fd;
                case -156749520: goto L_0x00f2;
                case 64194685: goto L_0x00e7;
                case 1154777587: goto L_0x00dc;
                default: goto L_0x00db;
            }
        L_0x00db:
            goto L_0x0107
        L_0x00dc:
            java.lang.String r11 = "application/x-rtsp"
            boolean r11 = r12.equals(r11)
            if (r11 != 0) goto L_0x00e5
            goto L_0x0107
        L_0x00e5:
            r0 = 3
            goto L_0x0107
        L_0x00e7:
            java.lang.String r11 = "application/dash+xml"
            boolean r11 = r12.equals(r11)
            if (r11 != 0) goto L_0x00f0
            goto L_0x0107
        L_0x00f0:
            r0 = 2
            goto L_0x0107
        L_0x00f2:
            java.lang.String r11 = "application/vnd.ms-sstr+xml"
            boolean r11 = r12.equals(r11)
            if (r11 != 0) goto L_0x00fb
            goto L_0x0107
        L_0x00fb:
            r0 = 1
            goto L_0x0107
        L_0x00fd:
            java.lang.String r11 = "application/x-mpegURL"
            boolean r11 = r12.equals(r11)
            if (r11 != 0) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r0 = 0
        L_0x0107:
            switch(r0) {
                case 0: goto L_0x010e;
                case 1: goto L_0x010d;
                case 2: goto L_0x010c;
                case 3: goto L_0x010b;
                default: goto L_0x010a;
            }
        L_0x010a:
            return r1
        L_0x010b:
            return r2
        L_0x010c:
            return r4
        L_0x010d:
            return r5
        L_0x010e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.l0.A(android.net.Uri, java.lang.String):int");
    }

    public static boolean B(b0 b0Var, b0 b0Var2, Inflater inflater) {
        int i10 = b0Var.f8416c - b0Var.f8415b;
        if (i10 <= 0) {
            return false;
        }
        if (b0Var2.f8414a.length < i10) {
            b0Var2.a(i10 * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        byte[] bArr = b0Var.f8414a;
        int i11 = b0Var.f8415b;
        inflater.setInput(bArr, i11, b0Var.f8416c - i11);
        int i12 = 0;
        while (true) {
            try {
                byte[] bArr2 = b0Var2.f8414a;
                i12 += inflater.inflate(bArr2, i12, bArr2.length - i12);
                if (inflater.finished()) {
                    b0Var2.F(i12);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else {
                    byte[] bArr3 = b0Var2.f8414a;
                    if (i12 == bArr3.length) {
                        b0Var2.a(bArr3.length * 2);
                    }
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static String C(int i10) {
        return Integer.toString(i10, 36);
    }

    public static boolean D(int i10) {
        return i10 == 3 || i10 == 2 || i10 == 268435456 || i10 == 536870912 || i10 == 805306368 || i10 == 4;
    }

    public static boolean E(int i10) {
        return i10 == 10 || i10 == 13;
    }

    public static boolean F(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    public static void G(ArrayList arrayList, int i10, int i11, int i12) {
        ArrayDeque arrayDeque = new ArrayDeque();
        int i13 = i11 - i10;
        while (true) {
            i13--;
            if (i13 >= 0) {
                arrayDeque.addFirst(arrayList.remove(i10 + i13));
            } else {
                arrayList.addAll(Math.min(i12, arrayList.size()), arrayDeque);
                return;
            }
        }
    }

    public static long H(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 * 1000;
    }

    public static String I(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals("und")) {
            str = replace;
        }
        String a10 = b.a(str);
        int i10 = 0;
        String str2 = a10.split("-", 2)[0];
        if (f8461i == null) {
            String[] iSOLanguages = Locale.getISOLanguages();
            int length = iSOLanguages.length;
            String[] strArr = f8462j;
            HashMap hashMap = new HashMap(length + strArr.length);
            for (String str3 : iSOLanguages) {
                try {
                    String iSO3Language = new Locale(str3).getISO3Language();
                    if (!TextUtils.isEmpty(iSO3Language)) {
                        hashMap.put(iSO3Language, str3);
                    }
                } catch (MissingResourceException unused) {
                }
            }
            for (int i11 = 0; i11 < strArr.length; i11 += 2) {
                hashMap.put(strArr[i11], strArr[i11 + 1]);
            }
            f8461i = hashMap;
        }
        String str4 = (String) f8461i.get(str2);
        if (str4 != null) {
            StringBuilder q10 = h.q(str4);
            q10.append(a10.substring(str2.length()));
            a10 = q10.toString();
            str2 = str4;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return a10;
        }
        while (true) {
            String[] strArr2 = f8463k;
            if (i10 >= strArr2.length) {
                return a10;
            }
            if (a10.startsWith(strArr2[i10])) {
                return strArr2[i10 + 1] + a10.substring(strArr2[i10].length());
            }
            i10 += 2;
        }
    }

    public static Object[] J(int i10, Object[] objArr) {
        a.b(i10 <= objArr.length);
        return Arrays.copyOf(objArr, i10);
    }

    public static long K(String str) {
        int i10;
        Matcher matcher = f8459g.matcher(str);
        if (matcher.matches()) {
            if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
                i10 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                if ("-".equals(matcher.group(11))) {
                    i10 *= -1;
                }
            } else {
                i10 = 0;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            return i10 != 0 ? timeInMillis - (((long) i10) * 60000) : timeInMillis;
        }
        throw b1.a("Invalid date/time format: " + str, (Exception) null);
    }

    public static void L(Handler handler, Runnable runnable) {
        if (handler.getLooper().getThread().isAlive()) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public static long M(long j10, long j11, long j12) {
        int i10 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
        if (i10 >= 0 && j12 % j11 == 0) {
            return j10 / (j12 / j11);
        }
        if (i10 < 0 && j11 % j12 == 0) {
            return (j11 / j12) * j10;
        }
        return (long) (((double) j10) * (((double) j11) / ((double) j12)));
    }

    public static void N(long[] jArr, long j10) {
        int i10 = 0;
        int i11 = (j10 > 1000000 ? 1 : (j10 == 1000000 ? 0 : -1));
        if (i11 >= 0 && j10 % 1000000 == 0) {
            long j11 = j10 / 1000000;
            while (i10 < jArr.length) {
                jArr[i10] = jArr[i10] / j11;
                i10++;
            }
        } else if (i11 >= 0 || 1000000 % j10 != 0) {
            double d10 = ((double) 1000000) / ((double) j10);
            while (i10 < jArr.length) {
                jArr[i10] = (long) (((double) jArr[i10]) * d10);
                i10++;
            }
        } else {
            long j12 = 1000000 / j10;
            while (i10 < jArr.length) {
                jArr[i10] = jArr[i10] * j12;
                i10++;
            }
        }
    }

    public static String[] O(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return str.trim().split("(\\s*,\\s*)", -1);
    }

    public static k0 P(e0 e0Var, p pVar) {
        k0 n10 = k0.n();
        r0 r0Var = new r0(n10, 7, e0Var);
        q qVar = q.f7765h;
        n10.a(r0Var, qVar);
        e0Var.a(new r(e0Var, n10, pVar, 4), qVar);
        return n10;
    }

    public static long Q(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 / 1000;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(long[] r4, long r5, boolean r7) {
        /*
            int r0 = java.util.Arrays.binarySearch(r4, r5)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x001a
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r4.length
            if (r0 >= r1) goto L_0x0014
            r1 = r4[r0]
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0014
            goto L_0x0008
        L_0x0014:
            if (r7 == 0) goto L_0x0019
            int r4 = r0 + -1
            goto L_0x001a
        L_0x0019:
            r4 = r0
        L_0x001a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.l0.b(long[], long, boolean):int");
    }

    public static int c(w wVar, long j10) {
        int i10 = wVar.f8479a - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            if (wVar.b(i12) < j10) {
                i11 = i12 + 1;
            } else {
                i10 = i12 - 1;
            }
        }
        int i13 = i10 + 1;
        if (i13 < wVar.f8479a && wVar.b(i13) == j10) {
            return i13;
        }
        if (i10 == -1) {
            return 0;
        }
        return i10;
    }

    public static int d(List list, Long l10, boolean z10) {
        int i10;
        int binarySearch = Collections.binarySearch(list, l10);
        if (binarySearch < 0) {
            i10 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || ((Comparable) list.get(binarySearch)).compareTo(l10) != 0) {
                    i10 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (((Comparable) list.get(binarySearch)).compareTo(l10) != 0);
            i10 = binarySearch + 1;
        }
        return z10 ? Math.max(0, i10) : i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int e(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0019
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0013
            r1 = r2[r0]
            if (r1 != r3) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            if (r4 == 0) goto L_0x0018
            int r2 = r0 + 1
            goto L_0x0019
        L_0x0018:
            r2 = r0
        L_0x0019:
            if (r5 == 0) goto L_0x0020
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.l0.e(int[], int, boolean, boolean):int");
    }

    public static int f(long[] jArr, long j10, boolean z10) {
        int i10;
        int binarySearch = Arrays.binarySearch(jArr, j10);
        if (binarySearch < 0) {
            i10 = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0 || jArr[binarySearch] != j10) {
                    i10 = binarySearch + 1;
                }
                binarySearch--;
                break;
            } while (jArr[binarySearch] != j10);
            i10 = binarySearch + 1;
        }
        return z10 ? Math.max(0, i10) : i10;
    }

    public static float g(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f10, f12));
    }

    public static int h(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i10, i12));
    }

    public static long i(long j10, long j11, long j12) {
        return Math.max(j11, Math.min(j10, j12));
    }

    public static boolean j(Object[] objArr, Object obj) {
        for (Object a10 : objArr) {
            if (a(a10, obj)) {
                return true;
            }
        }
        return false;
    }

    public static Handler k(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        a.f(myLooper);
        return new Handler(myLooper, callback);
    }

    public static String l(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int m(int i10) {
        if (i10 == 12) {
            return 743676;
        }
        switch (i10) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case Constants.MAX_COMPATIBILITY_VERSION:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 0;
        }
    }

    public static int n(int i10, String str) {
        int i11 = 0;
        for (String d10 : O(str)) {
            if (i10 == a1.h(a1.d(d10))) {
                i11++;
            }
        }
        return i11;
    }

    public static String o(int i10, String str) {
        String[] O = O(str);
        if (O.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : O) {
            if (i10 == a1.h(a1.d(str2))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public static Drawable p(Context context, Resources resources, int i10) {
        return f8453a >= 21 ? k0.a(context, resources, i10) : resources.getDrawable(i10);
    }

    public static int q(int i10) {
        if (i10 == 2 || i10 == 4) {
            return 6005;
        }
        if (i10 == 10) {
            return 6004;
        }
        if (i10 == 7) {
            return 6005;
        }
        if (i10 == 8) {
            return 6003;
        }
        switch (i10) {
            case 15:
                return 6003;
            case Constants.IV_SIZE:
            case 18:
                return 6005;
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                return 6004;
            default:
                switch (i10) {
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                        return 6002;
                    default:
                        return 6006;
                }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r5 = r5.split("_", -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int r(java.lang.String r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = -1
            java.lang.String r2 = "_"
            java.lang.String[] r5 = r5.split(r2, r1)
            int r1 = r5.length
            r2 = 2
            if (r1 >= r2) goto L_0x0010
            return r0
        L_0x0010:
            int r3 = r1 + -1
            r3 = r5[r3]
            r4 = 3
            if (r1 < r4) goto L_0x0024
            int r1 = r1 - r2
            r5 = r5[r1]
            java.lang.String r1 = "neg"
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0024
            r5 = 1
            goto L_0x0025
        L_0x0024:
            r5 = 0
        L_0x0025:
            r3.getClass()     // Catch:{ NumberFormatException -> 0x002f }
            int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x002f }
            if (r5 == 0) goto L_0x002f
            int r0 = -r0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.l0.r(java.lang.String):int");
    }

    public static long s(long j10, float f10) {
        return f10 == 1.0f ? j10 : Math.round(((double) j10) * ((double) f10));
    }

    public static int t(int i10) {
        if (i10 == 8) {
            return 3;
        }
        if (i10 == 16) {
            return 2;
        }
        if (i10 != 24) {
            return i10 != 32 ? 0 : 805306368;
        }
        return 536870912;
    }

    public static int u(int i10, int i11) {
        if (i10 != 2) {
            if (i10 == 3) {
                return i11;
            }
            if (i10 != 4) {
                if (i10 != 268435456) {
                    if (i10 == 536870912) {
                        return i11 * 3;
                    }
                    if (i10 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i11 * 4;
        }
        return i11 * 2;
    }

    public static long v(long j10, float f10) {
        return f10 == 1.0f ? j10 : Math.round(((double) j10) / ((double) f10));
    }

    public static int w(int i10) {
        if (i10 == 13) {
            return 1;
        }
        switch (i10) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case Constants.MAX_COMPATIBILITY_VERSION:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static String x(StringBuilder sb2, Formatter formatter, long j10) {
        if (j10 == -9223372036854775807L) {
            j10 = 0;
        }
        String str = j10 < 0 ? "-" : "";
        long abs = (Math.abs(j10) + 500) / 1000;
        long j11 = abs % 60;
        long j12 = (abs / 60) % 60;
        long j13 = abs / 3600;
        sb2.setLength(0);
        return (j13 > 0 ? formatter.format("%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j13), Long.valueOf(j12), Long.valueOf(j11)}) : formatter.format("%s%02d:%02d", new Object[]{str, Long.valueOf(j12), Long.valueOf(j11)})).toString();
    }

    public static String y(int i10) {
        switch (i10) {
            case -2:
                return "none";
            case -1:
                return "unknown";
            case 0:
                return "default";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case Constants.MAX_COMPATIBILITY_VERSION:
                return "metadata";
            case 6:
                return "camera motion";
            default:
                if (i10 >= 10000) {
                    return h.j("custom (", i10, ")");
                }
                return "?";
        }
    }

    public static byte[] z(String str) {
        return str.getBytes(c9.h.f3035c);
    }
}
