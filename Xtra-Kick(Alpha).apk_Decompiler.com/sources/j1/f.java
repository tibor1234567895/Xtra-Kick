package j1;

import android.graphics.Color;
import android.support.v4.media.h;
import android.text.TextUtils;
import c9.b;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f8424a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f8425b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f8426c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d  reason: collision with root package name */
    public static final HashMap f8427d;

    static {
        HashMap hashMap = new HashMap();
        f8427d = hashMap;
        hashMap.put("aliceblue", -984833);
        hashMap.put("antiquewhite", -332841);
        hashMap.put("aqua", -16711681);
        HashMap hashMap2 = hashMap;
        h.v(-8388652, hashMap2, "aquamarine", -983041, "azure", -657956, "beige", -6972, "bisque");
        h.v(-16777216, hashMap2, "black", -5171, "blanchedalmond", -16776961, "blue", -7722014, "blueviolet");
        h.v(-5952982, hashMap2, "brown", -2180985, "burlywood", -10510688, "cadetblue", -8388864, "chartreuse");
        h.v(-2987746, hashMap2, "chocolate", -32944, "coral", -10185235, "cornflowerblue", -1828, "cornsilk");
        hashMap.put("crimson", -2354116);
        hashMap.put("cyan", -16711681);
        hashMap.put("darkblue", -16777077);
        hashMap.put("darkcyan", -16741493);
        hashMap.put("darkgoldenrod", -4684277);
        hashMap.put("darkgray", -5658199);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkgrey", -5658199);
        hashMap.put("darkkhaki", -4343957);
        HashMap hashMap3 = hashMap;
        h.v(-7667573, hashMap3, "darkmagenta", -11179217, "darkolivegreen", -29696, "darkorange", -6737204, "darkorchid");
        h.v(-7667712, hashMap3, "darkred", -1468806, "darksalmon", -7357297, "darkseagreen", -12042869, "darkslateblue");
        hashMap.put("darkslategray", -13676721);
        hashMap.put("darkslategrey", -13676721);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        hashMap.put("deeppink", -60269);
        hashMap.put("deepskyblue", -16728065);
        hashMap.put("dimgray", -9868951);
        hashMap.put("dimgrey", -9868951);
        h.v(-14774017, hashMap, "dodgerblue", -5103070, "firebrick", -1296, "floralwhite", -14513374, "forestgreen");
        hashMap.put("fuchsia", -65281);
        hashMap.put("gainsboro", -2302756);
        hashMap.put("ghostwhite", -460545);
        hashMap.put("gold", -10496);
        hashMap.put("goldenrod", -2448096);
        hashMap.put("gray", -8355712);
        hashMap.put("green", -16744448);
        hashMap.put("greenyellow", -5374161);
        hashMap.put("grey", -8355712);
        HashMap hashMap4 = hashMap;
        h.v(-983056, hashMap4, "honeydew", -38476, "hotpink", -3318692, "indianred", -11861886, "indigo");
        h.v(-16, hashMap4, "ivory", -989556, "khaki", -1644806, "lavender", -3851, "lavenderblush");
        h.v(-8586240, hashMap4, "lawngreen", -1331, "lemonchiffon", -5383962, "lightblue", -1015680, "lightcoral");
        hashMap.put("lightcyan", -2031617);
        hashMap.put("lightgoldenrodyellow", -329006);
        hashMap.put("lightgray", -2894893);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightgrey", -2894893);
        hashMap.put("lightpink", -18751);
        hashMap.put("lightsalmon", -24454);
        hashMap.put("lightseagreen", -14634326);
        hashMap.put("lightskyblue", -7876870);
        hashMap.put("lightslategray", -8943463);
        hashMap.put("lightslategrey", -8943463);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        hashMap.put("lime", -16711936);
        hashMap.put("limegreen", -13447886);
        hashMap.put("linen", -331546);
        hashMap.put("magenta", -65281);
        hashMap.put("maroon", -8388608);
        hashMap.put("mediumaquamarine", -10039894);
        HashMap hashMap5 = hashMap;
        h.v(-16777011, hashMap5, "mediumblue", -4565549, "mediumorchid", -7114533, "mediumpurple", -12799119, "mediumseagreen");
        h.v(-8689426, hashMap5, "mediumslateblue", -16713062, "mediumspringgreen", -12004916, "mediumturquoise", -3730043, "mediumvioletred");
        h.v(-15132304, hashMap5, "midnightblue", -655366, "mintcream", -6943, "mistyrose", -6987, "moccasin");
        h.v(-8531, hashMap5, "navajowhite", -16777088, "navy", -133658, "oldlace", -8355840, "olive");
        h.v(-9728477, hashMap5, "olivedrab", -23296, "orange", -47872, "orangered", -2461482, "orchid");
        h.v(-1120086, hashMap5, "palegoldenrod", -6751336, "palegreen", -5247250, "paleturquoise", -2396013, "palevioletred");
        h.v(-4139, hashMap5, "papayawhip", -9543, "peachpuff", -3308225, "peru", -16181, "pink");
        h.v(-2252579, hashMap5, "plum", -5185306, "powderblue", -8388480, "purple", -10079335, "rebeccapurple");
        h.v(-65536, hashMap5, "red", -4419697, "rosybrown", -12490271, "royalblue", -7650029, "saddlebrown");
        h.v(-360334, hashMap5, "salmon", -744352, "sandybrown", -13726889, "seagreen", -2578, "seashell");
        h.v(-6270419, hashMap5, "sienna", -4144960, "silver", -7876885, "skyblue", -9807155, "slateblue");
        hashMap.put("slategray", -9404272);
        hashMap.put("slategrey", -9404272);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        HashMap hashMap6 = hashMap;
        h.v(-12156236, hashMap6, "steelblue", -2968436, "tan", -16744320, "teal", -2572328, "thistle");
        h.v(-40121, hashMap6, "tomato", 0, "transparent", -12525360, "turquoise", -1146130, "violet");
        h.v(-663885, hashMap6, "wheat", -1, "white", -657931, "whitesmoke", -256, "yellow");
        hashMap.put("yellowgreen", -6632142);
    }

    private f() {
    }

    public static int a(String str, boolean z10) {
        Pattern pattern;
        int i10;
        a.b(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return -16777216 | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            if (z10) {
                pattern = f8426c;
            } else {
                pattern = f8425b;
            }
            Matcher matcher = pattern.matcher(replace);
            if (matcher.matches()) {
                if (z10) {
                    String group = matcher.group(4);
                    group.getClass();
                    i10 = (int) (Float.parseFloat(group) * 255.0f);
                } else {
                    String group2 = matcher.group(4);
                    group2.getClass();
                    i10 = Integer.parseInt(group2, 10);
                }
                String group3 = matcher.group(1);
                group3.getClass();
                int parseInt = Integer.parseInt(group3, 10);
                String group4 = matcher.group(2);
                group4.getClass();
                int parseInt2 = Integer.parseInt(group4, 10);
                String group5 = matcher.group(3);
                group5.getClass();
                return Color.argb(i10, parseInt, parseInt2, Integer.parseInt(group5, 10));
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = f8424a.matcher(replace);
            if (matcher2.matches()) {
                String group6 = matcher2.group(1);
                group6.getClass();
                int parseInt3 = Integer.parseInt(group6, 10);
                String group7 = matcher2.group(2);
                group7.getClass();
                int parseInt4 = Integer.parseInt(group7, 10);
                String group8 = matcher2.group(3);
                group8.getClass();
                return Color.rgb(parseInt3, parseInt4, Integer.parseInt(group8, 10));
            }
        } else {
            Integer num = (Integer) f8427d.get(b.a(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
