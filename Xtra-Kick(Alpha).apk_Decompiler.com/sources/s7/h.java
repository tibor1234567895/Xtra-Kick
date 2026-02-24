package s7;

import android.content.Context;
import android.text.format.DateUtils;
import com.woxthebox.draglistview.R;
import fb.a0;
import fb.w;
import fb.y;
import hb.h0;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import ma.r;
import xa.j;
import xa.x;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f14375a = new h();

    private h() {
    }

    public static String a(Context context, int i10) {
        return (i10 <= 1000 || !h0.l1(context).getBoolean("ui_truncateviewcount", false)) ? String.valueOf(i10) : b(i10);
    }

    public static String b(int i10) {
        String str;
        int i11;
        if (String.valueOf(i10).length() < 7) {
            i11 = 1000;
            str = "K";
        } else {
            i11 = 1000000;
            str = "M";
        }
        int i12 = i10 / (i11 / 10);
        double d10 = ((double) i12) / 10.0d;
        int i13 = i12 / 10;
        if (true ^ (d10 == ((double) i13))) {
            return d10 + str;
        }
        return i13 + str;
    }

    public static String c(Context context, long j10) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j10);
        String formatDateTime = DateUtils.formatDateTime(context, j10, instance.get(1) == Calendar.getInstance().get(1) ? 8 : 16);
        j.e("formatDateTime(context, date, format)", formatDateTime);
        return formatDateTime;
    }

    public static String d(Context context, String str) {
        j.f("iso8601date", str);
        Long l10 = l(str);
        if (l10 == null) {
            return null;
        }
        long longValue = l10.longValue();
        f14375a.getClass();
        return c(context, longValue);
    }

    public static String e(Context context, int i10) {
        String str;
        String str2;
        if (i10 <= 1000 || !h0.l1(context).getBoolean("ui_truncateviewcount", false)) {
            str2 = context.getResources().getQuantityString(R.plurals.viewers, i10, new Object[]{Integer.valueOf(i10)});
            str = "{\n            context.re…, count, count)\n        }";
        } else {
            str2 = context.getString(R.string.viewers_count, new Object[]{b(i10)});
            str = "{\n            context.ge…housand(count))\n        }";
        }
        j.e(str, str2);
        return str2;
    }

    public static String f(Context context, int i10) {
        String str;
        String str2;
        if (i10 <= 1000 || !h0.l1(context).getBoolean("ui_truncateviewcount", false)) {
            str2 = context.getResources().getQuantityString(R.plurals.views, i10, new Object[]{Integer.valueOf(i10)});
            str = "{\n            context.re…, count, count)\n        }";
        } else {
            str2 = context.getString(R.string.views, new Object[]{b(i10)});
            str = "{\n            context.ge…housand(count))\n        }";
        }
        j.e(str, str2);
        return str2;
    }

    public static Long g(String str) {
        if (!(w.h(str))) {
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (Exception unused) {
                try {
                    String T = a0.T(y.M(str, "h", "0"));
                    StringBuilder sb2 = new StringBuilder();
                    int length = T.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        char charAt = T.charAt(i10);
                        if (Character.isDigit(charAt)) {
                            sb2.append(charAt);
                        }
                    }
                    String sb3 = sb2.toString();
                    j.e("filterTo(StringBuilder(), predicate).toString()", sb3);
                    int parseInt = Integer.parseInt(sb3);
                    String T2 = a0.T(y.M(str, "m", "0"));
                    StringBuilder sb4 = new StringBuilder();
                    int length2 = T2.length();
                    for (int i11 = 0; i11 < length2; i11++) {
                        char charAt2 = T2.charAt(i11);
                        if (Character.isDigit(charAt2)) {
                            sb4.append(charAt2);
                        }
                    }
                    String sb5 = sb4.toString();
                    j.e("filterTo(StringBuilder(), predicate).toString()", sb5);
                    int parseInt2 = Integer.parseInt(sb5);
                    String T3 = a0.T(y.M(str, "s", "0"));
                    StringBuilder sb6 = new StringBuilder();
                    int length3 = T3.length();
                    for (int i12 = 0; i12 < length3; i12++) {
                        char charAt3 = T3.charAt(i12);
                        if (Character.isDigit(charAt3)) {
                            sb6.append(charAt3);
                        }
                    }
                    String sb7 = sb6.toString();
                    j.e("filterTo(StringBuilder(), predicate).toString()", sb7);
                    return Long.valueOf((long) ((parseInt2 * 60) + (parseInt * 3600) + Integer.parseInt(sb7)));
                } catch (Exception unused2) {
                }
            }
        }
        return null;
    }

    public static String h(Context context, String str, boolean z10) {
        String str2;
        String str3;
        StringBuilder sb2;
        StringBuilder sb3;
        String str4;
        String str5;
        String str6;
        if (str == null) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            int i10 = parseInt / 86400;
            int i11 = parseInt % 86400;
            int i12 = i11 / 3600;
            int i13 = (i11 % 3600) / 60;
            int i14 = parseInt % 60;
            String str7 = "";
            if (z10) {
                x xVar = x.f16820a;
                if (i10 != 0) {
                    str4 = i10 + context.getString(R.string.days) + " ";
                } else {
                    str4 = str7;
                }
                if (i12 != 0) {
                    str5 = i12 + context.getString(R.string.hours) + " ";
                } else {
                    str5 = str7;
                }
                if (i13 != 0) {
                    str6 = i13 + context.getString(R.string.minutes) + " ";
                } else {
                    str6 = str7;
                }
                if (i14 != 0) {
                    str7 = i14 + context.getString(R.string.seconds) + " ";
                }
                String format = String.format(str4 + str5 + str6 + str7, Arrays.copyOf(new Object[0], 0));
                j.e("format(format, *args)", format);
                return y.R(format).toString();
            }
            x xVar2 = x.f16820a;
            if (i10 != 0) {
                str2 = i10 + Constants.EXT_TAG_END;
            } else {
                str2 = str7;
            }
            String str8 = "00:";
            if (i12 != 0) {
                if (i12 >= 10 || i10 == 0) {
                    sb3 = new StringBuilder();
                } else {
                    sb3 = new StringBuilder("0");
                }
                str3 = android.support.v4.media.h.o(sb3, i12, Constants.EXT_TAG_END);
            } else if (i10 != 0) {
                str3 = str8;
            } else {
                str3 = str7;
            }
            if (i13 != 0) {
                if (i13 >= 10 || (i12 == 0 && i10 == 0)) {
                    sb2 = new StringBuilder();
                } else {
                    sb2 = new StringBuilder("0");
                }
                str8 = android.support.v4.media.h.o(sb2, i13, Constants.EXT_TAG_END);
            } else if (i12 == 0 && i10 == 0) {
                str8 = str7;
            }
            if (i14 != 0) {
                if (i14 >= 10 || (i13 == 0 && i12 == 0 && i10 == 0)) {
                    str7 = String.valueOf(i14);
                } else {
                    str7 = android.support.v4.media.h.i("0", i14);
                }
            } else if (!(i13 == 0 && i12 == 0 && i10 == 0)) {
                str7 = "00";
            }
            String format2 = String.format(str2 + str3 + str8 + str7, Arrays.copyOf(new Object[0], 0));
            j.e("format(format, *args)", format2);
            return format2;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:779:?, code lost:
        return r0.getString(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String i(android.content.Context r23, java.lang.String r24, java.lang.String r25) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            i0.i r3 = g.t.f()
            java.lang.String r3 = r3.e()
            java.lang.String r4 = "getApplicationLocales().toLanguageTags()"
            xa.j.e(r4, r3)
            java.lang.String r4 = "-"
            java.lang.String r3 = fb.y.M(r3, r4, r3)
            int r4 = r3.hashCode()
            r5 = 3121(0xc31, float:4.373E-42)
            if (r4 == r5) goto L_0x0092
            r5 = 3201(0xc81, float:4.486E-42)
            if (r4 == r5) goto L_0x0088
            r5 = 3246(0xcae, float:4.549E-42)
            if (r4 == r5) goto L_0x007e
            r5 = 3276(0xccc, float:4.59E-42)
            if (r4 == r5) goto L_0x0074
            r5 = 3365(0xd25, float:4.715E-42)
            if (r4 == r5) goto L_0x006a
            r5 = 3383(0xd37, float:4.74E-42)
            if (r4 == r5) goto L_0x0060
            r5 = 3588(0xe04, float:5.028E-42)
            if (r4 == r5) goto L_0x0056
            r5 = 3651(0xe43, float:5.116E-42)
            if (r4 == r5) goto L_0x004c
            r5 = 3710(0xe7e, float:5.199E-42)
            if (r4 == r5) goto L_0x0043
            goto L_0x0f26
        L_0x0043:
            java.lang.String r4 = "tr"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0f26
            goto L_0x009c
        L_0x004c:
            java.lang.String r4 = "ru"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x0056:
            java.lang.String r4 = "pt"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x0060:
            java.lang.String r4 = "ja"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x006a:
            java.lang.String r4 = "in"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x0074:
            java.lang.String r4 = "fr"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x007e:
            java.lang.String r4 = "es"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x0088:
            java.lang.String r4 = "de"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x0092:
            java.lang.String r4 = "ar"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            goto L_0x0f26
        L_0x009c:
            if (r1 == 0) goto L_0x0f26
            int r3 = r24.hashCode()
            java.lang.String r6 = " viewers"
            java.lang.String r7 = "you for up to "
            java.lang.String r8 = ". Please try"
            java.lang.String r9 = " as a moderator"
            java.lang.String r10 = " unless you are"
            java.lang.String r11 = "timed out for "
            java.lang.String r12 = "This room is in "
            java.lang.String r13 = "You have added "
            java.lang.String r14 = " is now hosting"
            java.lang.String r15 = " is no longer"
            java.lang.String r5 = "You have removed "
            java.lang.String r4 = "is already in "
            r16 = r10
            java.lang.String r10 = " is not a"
            r17 = r10
            java.lang.String r10 = " seconds."
            r18 = r8
            java.lang.String r8 = " followers-only mode"
            r19 = r12
            java.lang.String r12 = ". Please email"
            r20 = r12
            java.lang.String r12 = "."
            r21 = 0
            r22 = r5
            java.lang.String r5 = ""
            switch(r3) {
                case -2140179943: goto L_0x0f08;
                case -2135329624: goto L_0x0ef7;
                case -2119425314: goto L_0x0eea;
                case -2113159971: goto L_0x0ec8;
                case -2064770332: goto L_0x0ebb;
                case -2061724317: goto L_0x0ead;
                case -2048424470: goto L_0x0e87;
                case -2031604540: goto L_0x0e78;
                case -1998496476: goto L_0x0e69;
                case -1977397403: goto L_0x0e43;
                case -1960309002: goto L_0x0e1d;
                case -1953100196: goto L_0x0df7;
                case -1935821923: goto L_0x0dd3;
                case -1888535562: goto L_0x0daf;
                case -1874224567: goto L_0x0d8b;
                case -1867622549: goto L_0x0d7c;
                case -1761122529: goto L_0x0d6d;
                case -1761112698: goto L_0x0d5e;
                case -1760964209: goto L_0x0d4f;
                case -1760828568: goto L_0x0d40;
                case -1760722007: goto L_0x0d31;
                case -1760701484: goto L_0x0d22;
                case -1642998140: goto L_0x0d13;
                case -1619591267: goto L_0x0d04;
                case -1526992799: goto L_0x0cf5;
                case -1452313715: goto L_0x0cd1;
                case -1452292041: goto L_0x0cab;
                case -1435203640: goto L_0x0c85;
                case -1411240462: goto L_0x0c76;
                case -1394580049: goto L_0x0c67;
                case -1394574418: goto L_0x0c58;
                case -1304171622: goto L_0x0c3a;
                case -1258787676: goto L_0x0c1c;
                case -1253919109: goto L_0x0bed;
                case -1211002468: goto L_0x0bc9;
                case -1204411438: goto L_0x0ba9;
                case -1199656897: goto L_0x0b83;
                case -1198896294: goto L_0x0b74;
                case -1136787288: goto L_0x0b4e;
                case -1083449807: goto L_0x0b3f;
                case -1067597163: goto L_0x0b1f;
                case -1059081724: goto L_0x0b10;
                case -1010845270: goto L_0x0b01;
                case -983913372: goto L_0x0adb;
                case -975320902: goto L_0x0acc;
                case -954119475: goto L_0x0abd;
                case -930285209: goto L_0x0aae;
                case -832713779: goto L_0x0a9f;
                case -826326559: goto L_0x0a7b;
                case -813799806: goto L_0x0a5b;
                case -732544383: goto L_0x0a3b;
                case -665454378: goto L_0x0a2c;
                case -646168115: goto L_0x0a1d;
                case -578208133: goto L_0x0a0e;
                case -570054191: goto L_0x09ee;
                case -565325879: goto L_0x09df;
                case -504269785: goto L_0x09d0;
                case -483676210: goto L_0x09c1;
                case -471156722: goto L_0x099b;
                case -420382344: goto L_0x098c;
                case -400408381: goto L_0x097d;
                case -390658826: goto L_0x096e;
                case -367331423: goto L_0x095f;
                case -360767478: goto L_0x0950;
                case -357768917: goto L_0x092a;
                case -336159223: goto L_0x091b;
                case -300237224: goto L_0x090c;
                case -287731764: goto L_0x08d5;
                case -270580516: goto L_0x08c6;
                case -225509224: goto L_0x08a0;
                case -195585267: goto L_0x0891;
                case -194404715: goto L_0x0871;
                case -189493637: goto L_0x0862;
                case -172692337: goto L_0x0842;
                case -170177036: goto L_0x0833;
                case -150184988: goto L_0x0824;
                case -82006888: goto L_0x0815;
                case -58281035: goto L_0x07f1;
                case -42646691: goto L_0x07cb;
                case -18895656: goto L_0x07a5;
                case 23978264: goto L_0x0796;
                case 54447373: goto L_0x0787;
                case 74426373: goto L_0x0778;
                case 121969126: goto L_0x0769;
                case 158738463: goto L_0x075a;
                case 159022593: goto L_0x074b;
                case 180254461: goto L_0x0725;
                case 194514261: goto L_0x0716;
                case 236594648: goto L_0x0707;
                case 272960248: goto L_0x06f8;
                case 300791454: goto L_0x06e9;
                case 487067201: goto L_0x06da;
                case 509654275: goto L_0x06a3;
                case 519457192: goto L_0x067d;
                case 527258899: goto L_0x065d;
                case 606665066: goto L_0x064e;
                case 743326038: goto L_0x063f;
                case 774467697: goto L_0x0630;
                case 774478692: goto L_0x0621;
                case 774487167: goto L_0x0612;
                case 785482397: goto L_0x0603;
                case 811027427: goto L_0x05f4;
                case 822583757: goto L_0x05e5;
                case 903072954: goto L_0x05c1;
                case 922992868: goto L_0x05b2;
                case 923520356: goto L_0x05a3;
                case 935568930: goto L_0x057f;
                case 970821621: goto L_0x0559;
                case 1007912160: goto L_0x054a;
                case 1033178988: goto L_0x052c;
                case 1094515933: goto L_0x050c;
                case 1096529261: goto L_0x04fd;
                case 1098693590: goto L_0x04d9;
                case 1104754917: goto L_0x04b9;
                case 1147409719: goto L_0x0493;
                case 1177692291: goto L_0x046d;
                case 1206641525: goto L_0x044d;
                case 1235360303: goto L_0x043e;
                case 1235456837: goto L_0x041a;
                case 1245544364: goto L_0x03f6;
                case 1252040376: goto L_0x03e7;
                case 1252051371: goto L_0x03d8;
                case 1252059846: goto L_0x03c9;
                case 1256628944: goto L_0x03a7;
                case 1305952278: goto L_0x0398;
                case 1338669579: goto L_0x0378;
                case 1344070022: goto L_0x0369;
                case 1385681208: goto L_0x035a;
                case 1410105212: goto L_0x034b;
                case 1410574168: goto L_0x0327;
                case 1465341711: goto L_0x0318;
                case 1496869830: goto L_0x02f6;
                case 1508660244: goto L_0x02d6;
                case 1509277656: goto L_0x02c7;
                case 1525777025: goto L_0x02b8;
                case 1547505703: goto L_0x02a9;
                case 1577603979: goto L_0x029a;
                case 1584939576: goto L_0x028b;
                case 1598790646: goto L_0x027c;
                case 1599318134: goto L_0x026d;
                case 1643124690: goto L_0x025e;
                case 1645011923: goto L_0x023e;
                case 1661082947: goto L_0x022f;
                case 1691070640: goto L_0x020b;
                case 1751574348: goto L_0x01de;
                case 1783037271: goto L_0x01be;
                case 1787695610: goto L_0x01af;
                case 1804858210: goto L_0x01a0;
                case 1834159594: goto L_0x0180;
                case 1875394097: goto L_0x0171;
                case 1933919013: goto L_0x0142;
                case 1938755076: goto L_0x0133;
                case 2028580421: goto L_0x0124;
                case 2101015434: goto L_0x0115;
                case 2109926143: goto L_0x0106;
                case 2110084463: goto L_0x00f7;
                case 2110347188: goto L_0x00e8;
                case 2120987466: goto L_0x00d9;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            goto L_0x0f26
        L_0x00d9:
            java.lang.String r3 = "bad_vip_achievement_incomplete"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00e3
            goto L_0x0f26
        L_0x00e3:
            r1 = 2131951929(0x7f130139, float:1.9540286E38)
            goto L_0x0f03
        L_0x00e8:
            java.lang.String r3 = "no_vips"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00f2
            goto L_0x0f26
        L_0x00f2:
            r1 = 2131951973(0x7f130165, float:1.9540376E38)
            goto L_0x0f03
        L_0x00f7:
            java.lang.String r3 = "no_mods"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0101
            goto L_0x0f26
        L_0x0101:
            r1 = 2131951971(0x7f130163, float:1.9540372E38)
            goto L_0x0f03
        L_0x0106:
            java.lang.String r3 = "no_help"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0110
            goto L_0x0f26
        L_0x0110:
            r1 = 2131951970(0x7f130162, float:1.954037E38)
            goto L_0x0f03
        L_0x0115:
            java.lang.String r3 = "usage_untimeout"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x011f
            goto L_0x0f26
        L_0x011f:
            r1 = 2131952031(0x7f13019f, float:1.9540493E38)
            goto L_0x0f03
        L_0x0124:
            java.lang.String r3 = "followers_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x012e
            goto L_0x0f26
        L_0x012e:
            r1 = 2131951941(0x7f130145, float:1.954031E38)
            goto L_0x0f03
        L_0x0133:
            java.lang.String r3 = "bad_unhost_error"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x013d
            goto L_0x0f26
        L_0x013d:
            r1 = 2131951926(0x7f130136, float:1.954028E38)
            goto L_0x0f03
        L_0x0142:
            java.lang.String r3 = "timeout_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x014c
            goto L_0x0f26
        L_0x014c:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0158
            java.lang.String r3 = " has been"
            java.lang.String r3 = fb.y.M(r2, r3, r5)
            goto L_0x0159
        L_0x0158:
            r3 = r5
        L_0x0159:
            r1[r21] = r3
            if (r2 == 0) goto L_0x0165
            java.lang.String r2 = fb.y.J(r2, r11, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x0165:
            r2 = 1
            r1[r2] = r5
            r2 = 2131951990(0x7f130176, float:1.954041E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0171:
            java.lang.String r3 = "whisper_invalid_self"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x017b
            goto L_0x0f26
        L_0x017b:
            r1 = 2131952042(0x7f1301aa, float:1.9540516E38)
            goto L_0x0f03
        L_0x0180:
            java.lang.String r3 = "unrecognized_cmd"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x018a
            goto L_0x0f26
        L_0x018a:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0195
            java.lang.String r3 = "Unrecognized command: "
            java.lang.String r5 = fb.y.J(r2, r3, r5)
        L_0x0195:
            r1[r21] = r5
            r2 = 2131951999(0x7f13017f, float:1.9540428E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x01a0:
            java.lang.String r3 = "msg_bad_characters"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01aa
            goto L_0x0f26
        L_0x01aa:
            r1 = 2131951952(0x7f130150, float:1.9540333E38)
            goto L_0x0f03
        L_0x01af:
            java.lang.String r3 = "usage_disconnect"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01b9
            goto L_0x0f26
        L_0x01b9:
            r1 = 2131952008(0x7f130188, float:1.9540447E38)
            goto L_0x0f03
        L_0x01be:
            java.lang.String r3 = "bad_vip_grantee_already_vip"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01c8
            goto L_0x0f26
        L_0x01c8:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x01d3
            java.lang.String r3 = " is already a"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x01d3:
            r1[r21] = r5
            r2 = 2131951930(0x7f13013a, float:1.9540288E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x01de:
            java.lang.String r3 = "host_receive"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01e8
            goto L_0x0f26
        L_0x01e8:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x01f2
            java.lang.String r3 = fb.y.M(r2, r14, r5)
            goto L_0x01f3
        L_0x01f2:
            r3 = r5
        L_0x01f3:
            r1[r21] = r3
            if (r2 == 0) goto L_0x01ff
            java.lang.String r2 = fb.y.J(r2, r7, r5)
            java.lang.String r5 = fb.y.M(r2, r6, r5)
        L_0x01ff:
            r3 = 1
            r1[r3] = r5
            r2 = 2131951946(0x7f13014a, float:1.954032E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x020b:
            r3 = 1
            java.lang.String r4 = "bad_delete_message_mod"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0216
            goto L_0x0f26
        L_0x0216:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            if (r2 == 0) goto L_0x0224
            java.lang.String r3 = "from another moderator "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x0224:
            r1[r21] = r5
            r2 = 2131951909(0x7f130125, float:1.9540246E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x022f:
            java.lang.String r3 = "emote_only_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0239
            goto L_0x0f26
        L_0x0239:
            r1 = 2131951939(0x7f130143, float:1.9540307E38)
            goto L_0x0f03
        L_0x023e:
            java.lang.String r3 = "ban_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0248
            goto L_0x0f26
        L_0x0248:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0253
            java.lang.String r3 = " is now banned"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0253:
            r1[r21] = r5
            r2 = 2131951933(0x7f13013d, float:1.9540294E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x025e:
            java.lang.String r3 = "whisper_restricted_recipient"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0268
            goto L_0x0f26
        L_0x0268:
            r1 = 2131952046(0x7f1301ae, float:1.9540524E38)
            goto L_0x0f03
        L_0x026d:
            java.lang.String r3 = "bad_ban_self"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0277
            goto L_0x0f26
        L_0x0277:
            r1 = 2131951905(0x7f130121, float:1.9540238E38)
            goto L_0x0f03
        L_0x027c:
            java.lang.String r3 = "bad_ban_anon"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0286
            goto L_0x0f26
        L_0x0286:
            r1 = 2131951902(0x7f13011e, float:1.9540232E38)
            goto L_0x0f03
        L_0x028b:
            java.lang.String r3 = "already_slow_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0295
            goto L_0x0f26
        L_0x0295:
            r1 = 2131951896(0x7f130118, float:1.954022E38)
            goto L_0x0f03
        L_0x029a:
            java.lang.String r3 = "emote_only_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02a4
            goto L_0x0f26
        L_0x02a4:
            r1 = 2131951940(0x7f130144, float:1.9540309E38)
            goto L_0x0f03
        L_0x02a9:
            java.lang.String r3 = "usage_followers_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02b3
            goto L_0x0f26
        L_0x02b3:
            r1 = 2131952011(0x7f13018b, float:1.9540453E38)
            goto L_0x0f03
        L_0x02b8:
            java.lang.String r3 = "already_r9k_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02c2
            goto L_0x0f26
        L_0x02c2:
            r1 = 2131951895(0x7f130117, float:1.9540217E38)
            goto L_0x0f03
        L_0x02c7:
            java.lang.String r3 = "unraid_error_no_active_raid"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02d1
            goto L_0x0f26
        L_0x02d1:
            r1 = 2131951996(0x7f13017c, float:1.9540422E38)
            goto L_0x0f03
        L_0x02d6:
            java.lang.String r3 = "bad_unban_no_ban"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x02e0
            goto L_0x0f26
        L_0x02e0:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x02eb
            java.lang.String r3 = " is not banned"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x02eb:
            r1[r21] = r5
            r2 = 2131951925(0x7f130135, float:1.9540278E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x02f6:
            java.lang.String r3 = "mod_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0300
            goto L_0x0f26
        L_0x0300:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x030d
            java.lang.String r2 = fb.y.J(r2, r13, r5)
            java.lang.String r5 = fb.y.M(r2, r9, r5)
        L_0x030d:
            r1[r21] = r5
            r2 = 2131951951(0x7f13014f, float:1.954033E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0318:
            java.lang.String r3 = "usage_slow_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0322
            goto L_0x0f26
        L_0x0322:
            r1 = 2131952022(0x7f130196, float:1.9540475E38)
            goto L_0x0f03
        L_0x0327:
            java.lang.String r3 = "bad_slow_duration"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0331
            goto L_0x0f26
        L_0x0331:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0340
            java.lang.String r3 = "to more than "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.M(r2, r10, r5)
        L_0x0340:
            r1[r21] = r5
            r2 = 2131951917(0x7f13012d, float:1.9540262E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x034b:
            java.lang.String r3 = "msg_rejected"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0355
            goto L_0x0f26
        L_0x0355:
            r1 = 2131951963(0x7f13015b, float:1.9540355E38)
            goto L_0x0f03
        L_0x035a:
            java.lang.String r3 = "whisper_restricted"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0364
            goto L_0x0f26
        L_0x0364:
            r1 = 2131952045(0x7f1301ad, float:1.9540522E38)
            goto L_0x0f03
        L_0x0369:
            java.lang.String r3 = "msg_r9k"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0373
            goto L_0x0f26
        L_0x0373:
            r1 = 2131951961(0x7f130159, float:1.9540351E38)
            goto L_0x0f03
        L_0x0378:
            java.lang.String r3 = "bad_mod_mod"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0382
            goto L_0x0f26
        L_0x0382:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x038d
            java.lang.String r3 = " is already"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x038d:
            r1[r21] = r5
            r2 = 2131951916(0x7f13012c, float:1.954026E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0398:
            java.lang.String r3 = "bad_timeout_broadcaster"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x03a2
            goto L_0x0f26
        L_0x03a2:
            r1 = 2131951920(0x7f130130, float:1.9540268E38)
            goto L_0x0f03
        L_0x03a7:
            java.lang.String r3 = "already_followers_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x03b1
            goto L_0x0f26
        L_0x03b1:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x03be
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r8, r5)
        L_0x03be:
            r1[r21] = r5
            r2 = 2131951893(0x7f130115, float:1.9540213E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x03c9:
            java.lang.String r3 = "usage_unvip"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x03d3
            goto L_0x0f26
        L_0x03d3:
            r1 = 2131952032(0x7f1301a0, float:1.9540495E38)
            goto L_0x0f03
        L_0x03d8:
            java.lang.String r3 = "usage_unmod"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x03e2
            goto L_0x0f26
        L_0x03e2:
            r1 = 2131952029(0x7f13019d, float:1.954049E38)
            goto L_0x0f03
        L_0x03e7:
            java.lang.String r3 = "usage_unban"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x03f1
            goto L_0x0f26
        L_0x03f1:
            r1 = 2131952027(0x7f13019b, float:1.9540485E38)
            goto L_0x0f03
        L_0x03f6:
            java.lang.String r3 = "bad_timeout_duration"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0400
            goto L_0x0f26
        L_0x0400:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x040f
            java.lang.String r3 = "for more than "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x040f:
            r1[r21] = r5
            r2 = 2131951921(0x7f130131, float:1.954027E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x041a:
            java.lang.String r3 = "usage_color"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0424
            goto L_0x0f26
        L_0x0424:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0433
            java.lang.String r3 = "following: "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x0433:
            r1[r21] = r5
            r2 = 2131952005(0x7f130185, float:1.954044E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x043e:
            java.lang.String r3 = "usage_clear"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0448
            goto L_0x0f26
        L_0x0448:
            r1 = 2131952004(0x7f130184, float:1.9540438E38)
            goto L_0x0f03
        L_0x044d:
            java.lang.String r3 = "bad_mod_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0457
            goto L_0x0f26
        L_0x0457:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0462
            java.lang.String r3 = " is banned"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0462:
            r1[r21] = r5
            r2 = 2131951915(0x7f13012b, float:1.9540258E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x046d:
            java.lang.String r3 = "cmds_available"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0477
            goto L_0x0f26
        L_0x0477:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0488
            java.lang.String r3 = "details): "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " More help:"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0488:
            r1[r21] = r5
            r2 = 2131951934(0x7f13013e, float:1.9540297E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0493:
            java.lang.String r3 = "delete_message_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x049d
            goto L_0x0f26
        L_0x049d:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x04ae
            java.lang.String r3 = "The message from "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " is now deleted."
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x04ae:
            r1[r21] = r5
            r2 = 2131951937(0x7f130141, float:1.9540303E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x04b9:
            java.lang.String r3 = "already_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x04c3
            goto L_0x0f26
        L_0x04c3:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x04ce
            java.lang.String r3 = " is already banned"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x04ce:
            r1[r21] = r5
            r2 = 2131951889(0x7f130111, float:1.9540205E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x04d9:
            java.lang.String r3 = "host_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x04e3
            goto L_0x0f26
        L_0x04e3:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x04f2
            java.lang.String r3 = "Now hosting "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x04f2:
            r1[r21] = r5
            r2 = 2131951945(0x7f130149, float:1.9540319E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x04fd:
            java.lang.String r3 = "usage_emote_only_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0507
            goto L_0x0f26
        L_0x0507:
            r1 = 2131952010(0x7f13018a, float:1.954045E38)
            goto L_0x0f03
        L_0x050c:
            java.lang.String r3 = "bad_vip_grantee_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0516
            goto L_0x0f26
        L_0x0516:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0521
            java.lang.String r3 = " is banned in"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0521:
            r1[r21] = r5
            r2 = 2131951931(0x7f13013b, float:1.954029E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x052c:
            java.lang.String r3 = "untimeout_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0536
            goto L_0x0f26
        L_0x0536:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x053f
            java.lang.String r5 = fb.y.M(r2, r15, r5)
        L_0x053f:
            r1[r21] = r5
            r2 = 2131952001(0x7f130181, float:1.9540432E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x054a:
            java.lang.String r3 = "bad_vip_max_vips_reached"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0554
            goto L_0x0f26
        L_0x0554:
            r1 = 2131951932(0x7f13013c, float:1.9540292E38)
            goto L_0x0f03
        L_0x0559:
            java.lang.String r3 = "bad_host_rate_exceeded"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0563
            goto L_0x0f26
        L_0x0563:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0574
            java.lang.String r3 = "changed more than "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " times every half"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0574:
            r1[r21] = r5
            r2 = 2131951912(0x7f130128, float:1.9540252E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x057f:
            java.lang.String r3 = "msg_slowmode"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0589
            goto L_0x0f26
        L_0x0589:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0598
            java.lang.String r3 = "talk again in "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.M(r2, r10, r5)
        L_0x0598:
            r1[r21] = r5
            r2 = 2131951965(0x7f13015d, float:1.954036E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x05a3:
            java.lang.String r3 = "bad_timeout_self"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05ad
            goto L_0x0f26
        L_0x05ad:
            r1 = 2131951923(0x7f130133, float:1.9540274E38)
            goto L_0x0f03
        L_0x05b2:
            java.lang.String r3 = "bad_timeout_anon"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05bc
            goto L_0x0f26
        L_0x05bc:
            r1 = 2131951919(0x7f13012f, float:1.9540266E38)
            goto L_0x0f03
        L_0x05c1:
            java.lang.String r3 = "vips_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05cb
            goto L_0x0f26
        L_0x05cb:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x05da
            java.lang.String r3 = "channel are: "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x05da:
            r1[r21] = r5
            r2 = 2131952038(0x7f1301a6, float:1.9540507E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x05e5:
            java.lang.String r3 = "bad_commercial_error"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05ef
            goto L_0x0f26
        L_0x05ef:
            r1 = 2131951907(0x7f130123, float:1.9540242E38)
            goto L_0x0f03
        L_0x05f4:
            java.lang.String r3 = "msg_verified_email"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x05fe
            goto L_0x0f26
        L_0x05fe:
            r1 = 2131951969(0x7f130161, float:1.9540368E38)
            goto L_0x0f03
        L_0x0603:
            java.lang.String r3 = "msg_suspended"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x060d
            goto L_0x0f26
        L_0x060d:
            r1 = 2131951967(0x7f13015f, float:1.9540363E38)
            goto L_0x0f03
        L_0x0612:
            java.lang.String r3 = "usage_vip"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x061c
            goto L_0x0f26
        L_0x061c:
            r1 = 2131952034(0x7f1301a2, float:1.95405E38)
            goto L_0x0f03
        L_0x0621:
            java.lang.String r3 = "usage_mod"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x062b
            goto L_0x0f26
        L_0x062b:
            r1 = 2131952017(0x7f130191, float:1.9540465E38)
            goto L_0x0f03
        L_0x0630:
            java.lang.String r3 = "usage_ban"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x063a
            goto L_0x0f26
        L_0x063a:
            r1 = 2131952003(0x7f130183, float:1.9540436E38)
            goto L_0x0f03
        L_0x063f:
            java.lang.String r3 = "usage_r9k_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0649
            goto L_0x0f26
        L_0x0649:
            r1 = 2131952019(0x7f130193, float:1.9540469E38)
            goto L_0x0f03
        L_0x064e:
            java.lang.String r3 = "already_subs_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0658
            goto L_0x0f26
        L_0x0658:
            r1 = 2131951898(0x7f13011a, float:1.9540224E38)
            goto L_0x0f03
        L_0x065d:
            java.lang.String r3 = "invalid_user"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0667
            goto L_0x0f26
        L_0x0667:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0672
            java.lang.String r3 = "Invalid username: "
            java.lang.String r5 = fb.y.J(r2, r3, r5)
        L_0x0672:
            r1[r21] = r5
            r2 = 2131951950(0x7f13014e, float:1.9540329E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x067d:
            java.lang.String r3 = "unvip_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0687
            goto L_0x0f26
        L_0x0687:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0698
            r3 = r22
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " as a VIP"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0698:
            r1[r21] = r5
            r2 = 2131952002(0x7f130182, float:1.9540434E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x06a3:
            java.lang.String r3 = "msg_followersonly"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06ad
            goto L_0x0f26
        L_0x06ad:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x06bd
            r3 = r19
            java.lang.String r3 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = fb.y.M(r3, r8, r5)
            goto L_0x06be
        L_0x06bd:
            r3 = r5
        L_0x06be:
            r1[r21] = r3
            if (r2 == 0) goto L_0x06ce
            java.lang.String r3 = "Follow "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " to join"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x06ce:
            r2 = 1
            r1[r2] = r5
            r2 = 2131951958(0x7f130156, float:1.9540345E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x06da:
            java.lang.String r3 = "usage_subs_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06e4
            goto L_0x0f26
        L_0x06e4:
            r1 = 2131952024(0x7f130198, float:1.954048E38)
            goto L_0x0f03
        L_0x06e9:
            java.lang.String r3 = "already_followers_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06f3
            goto L_0x0f26
        L_0x06f3:
            r1 = 2131951892(0x7f130114, float:1.9540211E38)
            goto L_0x0f03
        L_0x06f8:
            java.lang.String r3 = "raid_error_self"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0702
            goto L_0x0f26
        L_0x0702:
            r1 = 2131951979(0x7f13016b, float:1.9540388E38)
            goto L_0x0f03
        L_0x0707:
            java.lang.String r3 = "color_changed"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0711
            goto L_0x0f26
        L_0x0711:
            r1 = 2131951935(0x7f13013f, float:1.9540299E38)
            goto L_0x0f03
        L_0x0716:
            java.lang.String r3 = "whisper_banned_recipient"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0720
            goto L_0x0f26
        L_0x0720:
            r1 = 2131952040(0x7f1301a8, float:1.9540512E38)
            goto L_0x0f03
        L_0x0725:
            java.lang.String r3 = "raid_error_unexpected"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x072f
            goto L_0x0f26
        L_0x072f:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0740
            java.lang.String r3 = "a problem raiding "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            r3 = r18
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0740:
            r1[r21] = r5
            r2 = 2131951981(0x7f13016d, float:1.9540392E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x074b:
            java.lang.String r3 = "usage_unraid"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0755
            goto L_0x0f26
        L_0x0755:
            r1 = 2131952030(0x7f13019e, float:1.9540491E38)
            goto L_0x0f03
        L_0x075a:
            java.lang.String r3 = "usage_unhost"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0764
            goto L_0x0f26
        L_0x0764:
            r1 = 2131952028(0x7f13019c, float:1.9540487E38)
            goto L_0x0f03
        L_0x0769:
            java.lang.String r3 = "msg_emoteonly"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0773
            goto L_0x0f26
        L_0x0773:
            r1 = 2131951957(0x7f130155, float:1.9540343E38)
            goto L_0x0f03
        L_0x0778:
            java.lang.String r3 = "raid_error_already_raiding"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0782
            goto L_0x0f26
        L_0x0782:
            r1 = 2131951977(0x7f130169, float:1.9540384E38)
            goto L_0x0f03
        L_0x0787:
            java.lang.String r3 = "already_r9k_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0791
            goto L_0x0f26
        L_0x0791:
            r1 = 2131951894(0x7f130116, float:1.9540215E38)
            goto L_0x0f03
        L_0x0796:
            java.lang.String r3 = "usage_r9k_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x07a0
            goto L_0x0f26
        L_0x07a0:
            r1 = 2131952020(0x7f130194, float:1.954047E38)
            goto L_0x0f03
        L_0x07a5:
            java.lang.String r3 = "delete_staff_message_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x07af
            goto L_0x0f26
        L_0x07af:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x07c0
            java.lang.String r3 = "message from staff "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            r3 = r20
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x07c0:
            r1[r21] = r5
            r2 = 2131951938(0x7f130142, float:1.9540305E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x07cb:
            java.lang.String r3 = "msg_subsonly"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x07d5
            goto L_0x0f26
        L_0x07d5:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x07e6
            java.lang.String r3 = "/products/"
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = "/ticket?ref"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x07e6:
            r1[r21] = r5
            r2 = 2131951966(0x7f13015e, float:1.9540361E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x07f1:
            java.lang.String r3 = "msg_timedout"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x07fb
            goto L_0x0f26
        L_0x07fb:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x080a
            java.lang.String r2 = fb.y.J(r2, r11, r5)
            java.lang.String r3 = " more seconds."
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x080a:
            r1[r21] = r5
            r2 = 2131951968(0x7f130160, float:1.9540365E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0815:
            java.lang.String r3 = "usage_marker"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x081f
            goto L_0x0f26
        L_0x081f:
            r1 = 2131952015(0x7f13018f, float:1.954046E38)
            goto L_0x0f03
        L_0x0824:
            java.lang.String r3 = "already_emote_only_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x082e
            goto L_0x0f26
        L_0x082e:
            r1 = 2131951891(0x7f130113, float:1.954021E38)
            goto L_0x0f03
        L_0x0833:
            java.lang.String r3 = "r9k_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x083d
            goto L_0x0f26
        L_0x083d:
            r1 = 2131951975(0x7f130167, float:1.954038E38)
            goto L_0x0f03
        L_0x0842:
            java.lang.String r3 = "host_target_went_offline"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x084c
            goto L_0x0f26
        L_0x084c:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0857
            java.lang.String r3 = " has gone offline"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0857:
            r1[r21] = r5
            r2 = 2131951948(0x7f13014c, float:1.9540325E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0862:
            java.lang.String r3 = "bad_host_rejected"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x086c
            goto L_0x0f26
        L_0x086c:
            r1 = 2131951913(0x7f130129, float:1.9540254E38)
            goto L_0x0f03
        L_0x0871:
            java.lang.String r3 = "untimeout_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x087b
            goto L_0x0f26
        L_0x087b:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0886
            java.lang.String r3 = " is permanently banned"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0886:
            r1[r21] = r5
            r2 = 2131952000(0x7f130180, float:1.954043E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0891:
            java.lang.String r3 = "no_permission"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x089b
            goto L_0x0f26
        L_0x089b:
            r1 = 2131951972(0x7f130164, float:1.9540374E38)
            goto L_0x0f03
        L_0x08a0:
            java.lang.String r3 = "bad_ban_mod"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x08aa
            goto L_0x0f26
        L_0x08aa:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x08bb
            java.lang.String r3 = "cannot ban moderator"
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            r3 = r16
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x08bb:
            r1[r21] = r5
            r2 = 2131951904(0x7f130120, float:1.9540236E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x08c6:
            java.lang.String r3 = "bad_delete_message_broadcaster"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x08d0
            goto L_0x0f26
        L_0x08d0:
            r1 = 2131951908(0x7f130124, float:1.9540244E38)
            goto L_0x0f03
        L_0x08d5:
            r3 = r19
            java.lang.String r4 = "msg_followersonly_followed"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x08e1
            goto L_0x0f26
        L_0x08e1:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x08ef
            java.lang.String r3 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = fb.y.M(r3, r8, r5)
            goto L_0x08f0
        L_0x08ef:
            r3 = r5
        L_0x08f0:
            r1[r21] = r3
            if (r2 == 0) goto L_0x0900
            java.lang.String r3 = "following for "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = ". Continue"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0900:
            r2 = 1
            r1[r2] = r5
            r2 = 2131951959(0x7f130157, float:1.9540347E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x090c:
            java.lang.String r3 = "host_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0916
            goto L_0x0f26
        L_0x0916:
            r1 = 2131951944(0x7f130148, float:1.9540317E38)
            goto L_0x0f03
        L_0x091b:
            java.lang.String r3 = "usage_delete"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0925
            goto L_0x0f26
        L_0x0925:
            r1 = 2131952007(0x7f130187, float:1.9540445E38)
            goto L_0x0f03
        L_0x092a:
            r3 = r18
            java.lang.String r4 = "bad_host_error"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0936
            goto L_0x0f26
        L_0x0936:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0945
            java.lang.String r4 = "a problem hosting "
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0945:
            r1[r21] = r5
            r2 = 2131951910(0x7f130126, float:1.9540248E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0950:
            java.lang.String r3 = "already_emote_only_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x095a
            goto L_0x0f26
        L_0x095a:
            r1 = 2131951890(0x7f130112, float:1.9540207E38)
            goto L_0x0f03
        L_0x095f:
            java.lang.String r3 = "usage_emote_only_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0969
            goto L_0x0f26
        L_0x0969:
            r1 = 2131952009(0x7f130189, float:1.9540449E38)
            goto L_0x0f03
        L_0x096e:
            java.lang.String r3 = "usage_me"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0978
            goto L_0x0f26
        L_0x0978:
            r1 = 2131952016(0x7f130190, float:1.9540463E38)
            goto L_0x0f03
        L_0x097d:
            java.lang.String r3 = "usage_timeout"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0987
            goto L_0x0f26
        L_0x0987:
            r1 = 2131952026(0x7f13019a, float:1.9540483E38)
            goto L_0x0f03
        L_0x098c:
            java.lang.String r3 = "raid_error_too_many_viewers"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0996
            goto L_0x0f26
        L_0x0996:
            r1 = 2131951980(0x7f13016c, float:1.954039E38)
            goto L_0x0f03
        L_0x099b:
            java.lang.String r3 = "commercial_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x09a5
            goto L_0x0f26
        L_0x09a5:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x09b6
            java.lang.String r3 = "Initiating "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " second commercial break."
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x09b6:
            r1[r21] = r5
            r2 = 2131951936(0x7f130140, float:1.95403E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x09c1:
            java.lang.String r3 = "not_hosting"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x09cb
            goto L_0x0f26
        L_0x09cb:
            r1 = 2131951974(0x7f130166, float:1.9540378E38)
            goto L_0x0f03
        L_0x09d0:
            java.lang.String r3 = "usage_followers_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x09da
            goto L_0x0f26
        L_0x09da:
            r1 = 2131952012(0x7f13018c, float:1.9540455E38)
            goto L_0x0f03
        L_0x09df:
            java.lang.String r3 = "bad_host_self"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x09e9
            goto L_0x0f26
        L_0x09e9:
            r1 = 2131951914(0x7f13012a, float:1.9540256E38)
            goto L_0x0f03
        L_0x09ee:
            java.lang.String r3 = "turbo_only_color"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x09f8
            goto L_0x0f26
        L_0x09f8:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0a03
            java.lang.String r3 = "following instead: "
            java.lang.String r5 = fb.y.J(r2, r3, r5)
        L_0x0a03:
            r1[r21] = r5
            r2 = 2131951992(0x7f130178, float:1.9540414E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0a0e:
            java.lang.String r3 = "whisper_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a18
            goto L_0x0f26
        L_0x0a18:
            r1 = 2131952039(0x7f1301a7, float:1.954051E38)
            goto L_0x0f03
        L_0x0a1d:
            java.lang.String r3 = "msg_duplicate"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a27
            goto L_0x0f26
        L_0x0a27:
            r1 = 2131951956(0x7f130154, float:1.9540341E38)
            goto L_0x0f03
        L_0x0a2c:
            java.lang.String r3 = "msg_rejected_mandatory"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a36
            goto L_0x0f26
        L_0x0a36:
            r1 = 2131951964(0x7f13015c, float:1.9540357E38)
            goto L_0x0f03
        L_0x0a3b:
            java.lang.String r3 = "timeout_no_timeout"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a45
            goto L_0x0f26
        L_0x0a45:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0a50
            java.lang.String r3 = " is not timed"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0a50:
            r1[r21] = r5
            r2 = 2131951989(0x7f130175, float:1.9540408E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0a5b:
            java.lang.String r3 = "hosts_remaining"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a65
            goto L_0x0f26
        L_0x0a65:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0a70
            java.lang.String r3 = " host commands"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0a70:
            r1[r21] = r5
            r2 = 2131951949(0x7f13014d, float:1.9540327E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0a7b:
            java.lang.String r3 = "vip_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0a85
            goto L_0x0f26
        L_0x0a85:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0a94
            java.lang.String r2 = fb.y.J(r2, r13, r5)
            java.lang.String r3 = " as a vip"
            java.lang.String r5 = fb.y.P(r2, r3, r5)
        L_0x0a94:
            r1[r21] = r5
            r2 = 2131952037(0x7f1301a5, float:1.9540505E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0a9f:
            java.lang.String r3 = "raid_error_forbidden"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0aa9
            goto L_0x0f26
        L_0x0aa9:
            r1 = 2131951978(0x7f13016a, float:1.9540386E38)
            goto L_0x0f03
        L_0x0aae:
            java.lang.String r3 = "unraid_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ab8
            goto L_0x0f26
        L_0x0ab8:
            r1 = 2131951998(0x7f13017e, float:1.9540426E38)
            goto L_0x0f03
        L_0x0abd:
            java.lang.String r3 = "usage_subs_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ac7
            goto L_0x0f26
        L_0x0ac7:
            r1 = 2131952025(0x7f130199, float:1.9540481E38)
            goto L_0x0f03
        L_0x0acc:
            java.lang.String r3 = "r9k_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ad6
            goto L_0x0f26
        L_0x0ad6:
            r1 = 2131951976(0x7f130168, float:1.9540382E38)
            goto L_0x0f03
        L_0x0adb:
            java.lang.String r3 = "msg_followersonly_zero"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ae5
            goto L_0x0f26
        L_0x0ae5:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0af6
            java.lang.String r3 = ". Follow "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " to join the"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0af6:
            r1[r21] = r5
            r2 = 2131951960(0x7f130158, float:1.954035E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0b01:
            java.lang.String r3 = "raid_notice_restricted_chat"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b0b
            goto L_0x0f26
        L_0x0b0b:
            r1 = 2131951983(0x7f13016f, float:1.9540396E38)
            goto L_0x0f03
        L_0x0b10:
            java.lang.String r3 = "unraid_error_unexpected"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b1a
            goto L_0x0f26
        L_0x0b1a:
            r1 = 2131951997(0x7f13017d, float:1.9540424E38)
            goto L_0x0f03
        L_0x0b1f:
            java.lang.String r3 = "room_mods"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b29
            goto L_0x0f26
        L_0x0b29:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0b34
            java.lang.String r3 = "this channel are: "
            java.lang.String r5 = fb.y.J(r2, r3, r5)
        L_0x0b34:
            r1[r21] = r5
            r2 = 2131951984(0x7f130170, float:1.9540398E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0b3f:
            java.lang.String r3 = "slow_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b49
            goto L_0x0f26
        L_0x0b49:
            r1 = 2131951985(0x7f130171, float:1.95404E38)
            goto L_0x0f03
        L_0x0b4e:
            java.lang.String r3 = "tos_ban"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b58
            goto L_0x0f26
        L_0x0b58:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0b69
            java.lang.String r3 = "has closed channel "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = " due to Terms"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0b69:
            r1[r21] = r5
            r2 = 2131951991(0x7f130177, float:1.9540412E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0b74:
            java.lang.String r3 = "raid_notice_mature"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b7e
            goto L_0x0f26
        L_0x0b7e:
            r1 = 2131951982(0x7f13016e, float:1.9540394E38)
            goto L_0x0f03
        L_0x0b83:
            java.lang.String r3 = "usage_slow_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0b8d
            goto L_0x0f26
        L_0x0b8d:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0b9e
            java.lang.String r3 = "default="
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = ")"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0b9e:
            r1[r21] = r5
            r2 = 2131952023(0x7f130197, float:1.9540477E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0ba9:
            java.lang.String r3 = "bad_unmod_mod"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0bb3
            goto L_0x0f26
        L_0x0bb3:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0bbe
            r3 = r17
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0bbe:
            r1[r21] = r5
            r2 = 2131951927(0x7f130137, float:1.9540282E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0bc9:
            java.lang.String r3 = "msg_banned"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0bd3
            goto L_0x0f26
        L_0x0bd3:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0be2
            java.lang.String r3 = "from talking in "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x0be2:
            r1[r21] = r5
            r2 = 2131951953(0x7f130151, float:1.9540335E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0bed:
            java.lang.String r3 = "autohost_receive"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0bf7
            goto L_0x0f26
        L_0x0bf7:
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0c03
            java.lang.String r3 = " is now auto hosting"
            java.lang.String r3 = fb.y.M(r2, r3, r5)
            goto L_0x0c04
        L_0x0c03:
            r3 = r5
        L_0x0c04:
            r1[r21] = r3
            if (r2 == 0) goto L_0x0c10
            java.lang.String r2 = fb.y.J(r2, r7, r5)
            java.lang.String r5 = fb.y.M(r2, r6, r5)
        L_0x0c10:
            r3 = 1
            r1[r3] = r5
            r2 = 2131951900(0x7f13011c, float:1.9540228E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0c1c:
            r3 = 1
            java.lang.String r4 = "host_receive_no_count"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0c27
            goto L_0x0f26
        L_0x0c27:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            if (r2 == 0) goto L_0x0c2f
            java.lang.String r5 = fb.y.M(r2, r14, r5)
        L_0x0c2f:
            r1[r21] = r5
            r2 = 2131951947(0x7f13014b, float:1.9540323E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0c3a:
            java.lang.String r3 = "unban_success"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0c44
            goto L_0x0f26
        L_0x0c44:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0c4d
            java.lang.String r5 = fb.y.M(r2, r15, r5)
        L_0x0c4d:
            r1[r21] = r5
            r2 = 2131951994(0x7f13017a, float:1.9540418E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0c58:
            java.lang.String r3 = "whisper_limit_per_sec"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0c62
            goto L_0x0f26
        L_0x0c62:
            r1 = 2131952044(0x7f1301ac, float:1.954052E38)
            goto L_0x0f03
        L_0x0c67:
            java.lang.String r3 = "whisper_limit_per_min"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0c71
            goto L_0x0f26
        L_0x0c71:
            r1 = 2131952043(0x7f1301ab, float:1.9540518E38)
            goto L_0x0f03
        L_0x0c76:
            java.lang.String r3 = "msg_channel_blocked"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0c80
            goto L_0x0f26
        L_0x0c80:
            r1 = 2131951954(0x7f130152, float:1.9540337E38)
            goto L_0x0f03
        L_0x0c85:
            r3 = r20
            java.lang.String r4 = "bad_timeout_staff"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0c91
            goto L_0x0f26
        L_0x0c91:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0ca0
            java.lang.String r4 = "cannot timeout staff "
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0ca0:
            r1[r21] = r5
            r2 = 2131951924(0x7f130134, float:1.9540276E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0cab:
            r3 = r20
            java.lang.String r4 = "bad_timeout_admin"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0cb7
            goto L_0x0f26
        L_0x0cb7:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0cc6
            java.lang.String r4 = "cannot timeout admin "
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0cc6:
            r1[r21] = r5
            r2 = 2131951918(0x7f13012e, float:1.9540264E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0cd1:
            r3 = r22
            java.lang.String r4 = "unmod_success"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0cdd
            goto L_0x0f26
        L_0x0cdd:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0cea
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.M(r2, r9, r5)
        L_0x0cea:
            r1[r21] = r5
            r2 = 2131951995(0x7f13017b, float:1.954042E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0cf5:
            java.lang.String r3 = "msg_channel_suspended"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0cff
            goto L_0x0f26
        L_0x0cff:
            r1 = 2131951955(0x7f130153, float:1.954034E38)
            goto L_0x0f03
        L_0x0d04:
            java.lang.String r3 = "msg_ratelimit"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d0e
            goto L_0x0f26
        L_0x0d0e:
            r1 = 2131951962(0x7f13015a, float:1.9540353E38)
            goto L_0x0f03
        L_0x0d13:
            java.lang.String r3 = "already_subs_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d1d
            goto L_0x0f26
        L_0x0d1d:
            r1 = 2131951899(0x7f13011b, float:1.9540226E38)
            goto L_0x0f03
        L_0x0d22:
            java.lang.String r3 = "usage_vips"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d2c
            goto L_0x0f26
        L_0x0d2c:
            r1 = 2131952035(0x7f1301a3, float:1.9540501E38)
            goto L_0x0f03
        L_0x0d31:
            java.lang.String r3 = "usage_user"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d3b
            goto L_0x0f26
        L_0x0d3b:
            r1 = 2131952033(0x7f1301a1, float:1.9540497E38)
            goto L_0x0f03
        L_0x0d40:
            java.lang.String r3 = "usage_raid"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d4a
            goto L_0x0f26
        L_0x0d4a:
            r1 = 2131952021(0x7f130195, float:1.9540473E38)
            goto L_0x0f03
        L_0x0d4f:
            java.lang.String r3 = "usage_mods"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d59
            goto L_0x0f26
        L_0x0d59:
            r1 = 2131952018(0x7f130192, float:1.9540467E38)
            goto L_0x0f03
        L_0x0d5e:
            java.lang.String r3 = "usage_host"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d68
            goto L_0x0f26
        L_0x0d68:
            r1 = 2131952014(0x7f13018e, float:1.9540459E38)
            goto L_0x0f03
        L_0x0d6d:
            java.lang.String r3 = "usage_help"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d77
            goto L_0x0f26
        L_0x0d77:
            r1 = 2131952013(0x7f13018d, float:1.9540457E38)
            goto L_0x0f03
        L_0x0d7c:
            java.lang.String r3 = "subs_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d86
            goto L_0x0f26
        L_0x0d86:
            r1 = 2131951988(0x7f130174, float:1.9540406E38)
            goto L_0x0f03
        L_0x0d8b:
            java.lang.String r3 = "followers_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0d95
            goto L_0x0f26
        L_0x0d95:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0da4
            java.lang.String r3 = "is now in "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.M(r2, r8, r5)
        L_0x0da4:
            r1[r21] = r5
            r2 = 2131951942(0x7f130146, float:1.9540313E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0daf:
            java.lang.String r3 = "already_slow_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0db9
            goto L_0x0f26
        L_0x0db9:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0dc8
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r3 = "-second slow"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0dc8:
            r1[r21] = r5
            r2 = 2131951897(0x7f130119, float:1.9540221E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0dd3:
            java.lang.String r3 = "bad_host_hosting"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ddd
            goto L_0x0f26
        L_0x0ddd:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0dec
            java.lang.String r3 = "is already hosting "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.P(r2, r12, r5)
        L_0x0dec:
            r1[r21] = r5
            r2 = 2131951911(0x7f130127, float:1.954025E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0df7:
            java.lang.String r3 = "unavailable_command"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0e01
            goto L_0x0f26
        L_0x0e01:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0e12
            java.lang.String r3 = "Sorry, “"
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r3 = "” is not available"
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0e12:
            r1[r21] = r5
            r2 = 2131951993(0x7f130179, float:1.9540416E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0e1d:
            r3 = r20
            java.lang.String r4 = "bad_ban_staff"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0e29
            goto L_0x0f26
        L_0x0e29:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0e38
            java.lang.String r4 = "cannot ban staff"
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0e38:
            r1[r21] = r5
            r2 = 2131951906(0x7f130122, float:1.954024E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0e43:
            r3 = r20
            java.lang.String r4 = "bad_ban_admin"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0e4f
            goto L_0x0f26
        L_0x0e4f:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0e5e
            java.lang.String r4 = "cannot ban admin"
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0e5e:
            r1[r21] = r5
            r2 = 2131951901(0x7f13011d, float:1.954023E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0e69:
            java.lang.String r3 = "whisper_invalid_login"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0e73
            goto L_0x0f26
        L_0x0e73:
            r1 = 2131952041(0x7f1301a9, float:1.9540514E38)
            goto L_0x0f03
        L_0x0e78:
            java.lang.String r3 = "bad_ban_broadcaster"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0e82
            goto L_0x0f26
        L_0x0e82:
            r1 = 2131951903(0x7f13011f, float:1.9540234E38)
            goto L_0x0f03
        L_0x0e87:
            r3 = r16
            java.lang.String r4 = "bad_timeout_mod"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0e93
            goto L_0x0f26
        L_0x0e93:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0ea2
            java.lang.String r4 = "cannot timeout moderator "
            java.lang.String r2 = fb.y.J(r2, r4, r5)
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0ea2:
            r1[r21] = r5
            r2 = 2131951922(0x7f130132, float:1.9540272E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0ead:
            java.lang.String r3 = "subs_off"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0eb7
            goto L_0x0f26
        L_0x0eb7:
            r1 = 2131951987(0x7f130173, float:1.9540404E38)
            goto L_0x0f03
        L_0x0ebb:
            java.lang.String r3 = "usage_whisper"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ec4
            goto L_0x0f26
        L_0x0ec4:
            r1 = 2131952036(0x7f1301a4, float:1.9540503E38)
            goto L_0x0f03
        L_0x0ec8:
            java.lang.String r3 = "slow_on"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ed1
            goto L_0x0f26
        L_0x0ed1:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0ee0
            java.lang.String r3 = "send messages every "
            java.lang.String r2 = fb.y.J(r2, r3, r5)
            java.lang.String r5 = fb.y.M(r2, r10, r5)
        L_0x0ee0:
            r1[r21] = r5
            r2 = 2131951986(0x7f130172, float:1.9540402E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0eea:
            java.lang.String r3 = "followers_on_zero"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0ef3
            goto L_0x0f26
        L_0x0ef3:
            r1 = 2131951943(0x7f130147, float:1.9540315E38)
            goto L_0x0f03
        L_0x0ef7:
            java.lang.String r3 = "usage_commercial"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0f00
            goto L_0x0f26
        L_0x0f00:
            r1 = 2131952006(0x7f130186, float:1.9540443E38)
        L_0x0f03:
            java.lang.String r0 = r0.getString(r1)
            goto L_0x0f27
        L_0x0f08:
            r3 = r17
            java.lang.String r4 = "bad_unvip_grantee_not_vip"
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x0f13
            goto L_0x0f26
        L_0x0f13:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r2 == 0) goto L_0x0f1c
            java.lang.String r5 = fb.y.M(r2, r3, r5)
        L_0x0f1c:
            r1[r21] = r5
            r2 = 2131951928(0x7f130138, float:1.9540284E38)
            java.lang.String r0 = r0.getString(r2, r1)
            goto L_0x0f27
        L_0x0f26:
            r0 = r2
        L_0x0f27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.h.i(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r1 = "UTC"
            java.util.TimeZone r2 = java.util.TimeZone.getTimeZone(r1)
            java.util.Calendar r2 = java.util.Calendar.getInstance(r2)
            java.util.Date r2 = r2.getTime()
            long r2 = r2.getTime()
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
            java.util.Locale r6 = java.util.Locale.getDefault()
            r4.<init>(r5, r6)
            java.util.TimeZone r1 = java.util.TimeZone.getTimeZone(r1)
            r4.setTimeZone(r1)
            java.util.Date r8 = r4.parse(r8)     // Catch:{ ParseException -> 0x0036 }
            if (r8 == 0) goto L_0x0037
            long r4 = r8.getTime()     // Catch:{ ParseException -> 0x0036 }
            java.lang.Long r8 = java.lang.Long.valueOf(r4)     // Catch:{ ParseException -> 0x0036 }
            goto L_0x0038
        L_0x0036:
        L_0x0037:
            r8 = r0
        L_0x0038:
            if (r8 == 0) goto L_0x0048
            long r4 = r8.longValue()
            long r2 = r2 - r4
            r8 = 1000(0x3e8, float:1.401E-42)
            long r4 = (long) r8
            long r2 = r2 / r4
            java.lang.Long r8 = java.lang.Long.valueOf(r2)
            goto L_0x0049
        L_0x0048:
            r8 = r0
        L_0x0049:
            if (r8 == 0) goto L_0x005e
            long r1 = r8.longValue()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x005e
            java.lang.String r8 = r8.toString()
            r0 = 0
            java.lang.String r0 = h(r7, r8, r0)
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.h.j(android.content.Context, java.lang.String):java.lang.String");
    }

    public static LinkedHashMap k(String str, String str2) {
        String str3;
        String str4;
        List<String> e10 = r.e("chunked", "720p60", "720p30", "480p30", "360p30", "160p30", "144p30", "high", "medium", "low", "mobile", "audio_only");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str5 : e10) {
            String k10 = w.k(str, "storyboards", str5);
            if (str2 != null) {
                str3 = str2.toLowerCase(Locale.ROOT);
                j.e("this as java.lang.String).toLowerCase(Locale.ROOT)", str3);
            } else {
                str3 = null;
            }
            if (j.a(str3, "highlight")) {
                String L = y.L(str, Constants.LIST_SEPARATOR);
                str4 = android.support.v4.media.h.n("highlight-", y.M(L, "-", L), ".m3u8");
            } else {
                str4 = "index-dvr.m3u8";
            }
            j.f("replacement", str4);
            int x10 = y.x(k10, Constants.LIST_SEPARATOR, 6);
            if (x10 != -1) {
                int i10 = x10 + 1;
                int length = k10.length();
                if (length >= i10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(k10, 0, i10);
                    sb2.append(str4);
                    sb2.append(k10, length, k10.length());
                    k10 = sb2.toString();
                } else {
                    throw new IndexOutOfBoundsException("End index (" + length + ") is less than start index (" + i10 + ").");
                }
            }
            linkedHashMap.put(str5, k10);
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|(4:12|13|(1:15)|(1:20))) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r7 = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", java.util.Locale.getDefault()).parse(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r7 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r4 = java.lang.Long.valueOf(r7.getTime());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if (r4.longValue() > 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r0 != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Long l(java.lang.String r7) {
        /*
            java.lang.String r0 = "date"
            xa.j.f(r0, r7)
            r0 = 0
            r1 = 1
            r2 = 0
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x002e }
            java.lang.String r5 = "yyyy-MM-dd'T'HH:mm:ss'Z'"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ ParseException -> 0x002e }
            r4.<init>(r5, r6)     // Catch:{ ParseException -> 0x002e }
            java.util.Date r4 = r4.parse(r7)     // Catch:{ ParseException -> 0x002e }
            if (r4 == 0) goto L_0x0053
            long r4 = r4.getTime()     // Catch:{ ParseException -> 0x002e }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ ParseException -> 0x002e }
            long r5 = r4.longValue()     // Catch:{ ParseException -> 0x002e }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x002b
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x0053
            goto L_0x0054
        L_0x002e:
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat     // Catch:{ ParseException -> 0x0053 }
            java.lang.String r5 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ ParseException -> 0x0053 }
            r4.<init>(r5, r6)     // Catch:{ ParseException -> 0x0053 }
            java.util.Date r7 = r4.parse(r7)     // Catch:{ ParseException -> 0x0053 }
            if (r7 == 0) goto L_0x0053
            long r4 = r7.getTime()     // Catch:{ ParseException -> 0x0053 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ ParseException -> 0x0053 }
            long r5 = r4.longValue()     // Catch:{ ParseException -> 0x0053 }
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0050
            r0 = 1
        L_0x0050:
            if (r0 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.h.l(java.lang.String):java.lang.Long");
    }
}
