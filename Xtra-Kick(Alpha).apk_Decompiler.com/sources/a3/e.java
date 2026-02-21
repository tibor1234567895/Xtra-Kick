package a3;

import android.graphics.Color;
import g9.b;
import j1.a;
import j1.v;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f121a;

    /* renamed from: b  reason: collision with root package name */
    public final int f122b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f123c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f124d;

    /* renamed from: e  reason: collision with root package name */
    public final float f125e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f126f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f127g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f128h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f129i;

    /* renamed from: j  reason: collision with root package name */
    public final int f130j;

    public e(String str, int i10, Integer num, Integer num2, float f10, boolean z10, boolean z11, boolean z12, boolean z13, int i11) {
        this.f121a = str;
        this.f122b = i10;
        this.f123c = num;
        this.f124d = num2;
        this.f125e = f10;
        this.f126f = z10;
        this.f127g = z11;
        this.f128h = z12;
        this.f129i = z13;
        this.f130j = i11;
    }

    public static int a(String str) {
        boolean z10;
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                case 6:
                case 7:
                case 8:
                case 9:
                    z10 = true;
                    break;
                default:
                    z10 = false;
                    break;
            }
            if (z10) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        v.g("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e10) {
            v.h("SsaStyle", "Failed to parse boolean value: '" + str + "'", e10);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            a.b(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(b.a(((parseLong >> 24) & 255) ^ 255), b.a(parseLong & 255), b.a((parseLong >> 8) & 255), b.a((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e10) {
            v.h("SsaStyle", "Failed to parse color expression: '" + str + "'", e10);
            return null;
        }
    }
}
