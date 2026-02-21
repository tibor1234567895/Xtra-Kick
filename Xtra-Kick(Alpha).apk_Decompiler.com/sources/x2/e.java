package x2;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;

public final class e {
    public static final int[] A = {3, 3, 3, 3, 3, 3, 1};
    public static final boolean[] B = {false, false, false, true, true, true, false};
    public static final int[] C;
    public static final int[] D = {0, 1, 2, 3, 4, 3, 4};
    public static final int[] E = {0, 0, 0, 0, 0, 3, 3};
    public static final int[] F;

    /* renamed from: w  reason: collision with root package name */
    public static final int f16599w = c(2, 2, 2, 0);

    /* renamed from: x  reason: collision with root package name */
    public static final int f16600x;

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f16601y = {0, 0, 0, 0, 0, 2, 0};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f16602z = {0, 0, 0, 0, 0, 0, 2};

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f16603a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final SpannableStringBuilder f16604b = new SpannableStringBuilder();

    /* renamed from: c  reason: collision with root package name */
    public boolean f16605c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f16606d;

    /* renamed from: e  reason: collision with root package name */
    public int f16607e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16608f;

    /* renamed from: g  reason: collision with root package name */
    public int f16609g;

    /* renamed from: h  reason: collision with root package name */
    public int f16610h;

    /* renamed from: i  reason: collision with root package name */
    public int f16611i;

    /* renamed from: j  reason: collision with root package name */
    public int f16612j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16613k;

    /* renamed from: l  reason: collision with root package name */
    public int f16614l;

    /* renamed from: m  reason: collision with root package name */
    public int f16615m;

    /* renamed from: n  reason: collision with root package name */
    public int f16616n;

    /* renamed from: o  reason: collision with root package name */
    public int f16617o;

    /* renamed from: p  reason: collision with root package name */
    public int f16618p;

    /* renamed from: q  reason: collision with root package name */
    public int f16619q;

    /* renamed from: r  reason: collision with root package name */
    public int f16620r;

    /* renamed from: s  reason: collision with root package name */
    public int f16621s;

    /* renamed from: t  reason: collision with root package name */
    public int f16622t;

    /* renamed from: u  reason: collision with root package name */
    public int f16623u;

    /* renamed from: v  reason: collision with root package name */
    public int f16624v;

    static {
        int c10 = c(0, 0, 0, 0);
        f16600x = c10;
        int c11 = c(0, 0, 0, 3);
        C = new int[]{c10, c11, c10, c10, c11, c10, c10};
        F = new int[]{c10, c10, c10, c10, c10, c11, c11};
    }

    public e() {
        d();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int c(int r4, int r5, int r6, int r7) {
        /*
            r0 = 4
            j1.a.c(r4, r0)
            j1.a.c(r5, r0)
            j1.a.c(r6, r0)
            j1.a.c(r7, r0)
            r0 = 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0021
            if (r7 == r2) goto L_0x0021
            r3 = 2
            if (r7 == r3) goto L_0x001e
            r3 = 3
            if (r7 == r3) goto L_0x001c
            goto L_0x0021
        L_0x001c:
            r7 = 0
            goto L_0x0023
        L_0x001e:
            r7 = 127(0x7f, float:1.78E-43)
            goto L_0x0023
        L_0x0021:
            r7 = 255(0xff, float:3.57E-43)
        L_0x0023:
            if (r4 <= r2) goto L_0x0028
            r4 = 255(0xff, float:3.57E-43)
            goto L_0x0029
        L_0x0028:
            r4 = 0
        L_0x0029:
            if (r5 <= r2) goto L_0x002e
            r5 = 255(0xff, float:3.57E-43)
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r6 <= r2) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.e.c(int, int, int, int):int");
    }

    public final void a(char c10) {
        SpannableStringBuilder spannableStringBuilder = this.f16604b;
        if (c10 == 10) {
            ArrayList arrayList = this.f16603a;
            arrayList.add(b());
            spannableStringBuilder.clear();
            if (this.f16618p != -1) {
                this.f16618p = 0;
            }
            if (this.f16619q != -1) {
                this.f16619q = 0;
            }
            if (this.f16620r != -1) {
                this.f16620r = 0;
            }
            if (this.f16622t != -1) {
                this.f16622t = 0;
            }
            while (true) {
                if ((this.f16613k && arrayList.size() >= this.f16612j) || arrayList.size() >= 15) {
                    arrayList.remove(0);
                } else {
                    return;
                }
            }
        } else {
            spannableStringBuilder.append(c10);
        }
    }

    public final SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f16604b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f16618p != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f16618p, length, 33);
            }
            if (this.f16619q != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f16619q, length, 33);
            }
            if (this.f16620r != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f16621s), this.f16620r, length, 33);
            }
            if (this.f16622t != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f16623u), this.f16622t, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public final void d() {
        this.f16603a.clear();
        this.f16604b.clear();
        this.f16618p = -1;
        this.f16619q = -1;
        this.f16620r = -1;
        this.f16622t = -1;
        this.f16624v = 0;
        this.f16605c = false;
        this.f16606d = false;
        this.f16607e = 4;
        this.f16608f = false;
        this.f16609g = 0;
        this.f16610h = 0;
        this.f16611i = 0;
        this.f16612j = 15;
        this.f16613k = true;
        this.f16614l = 0;
        this.f16615m = 0;
        this.f16616n = 0;
        int i10 = f16600x;
        this.f16617o = i10;
        this.f16621s = f16599w;
        this.f16623u = i10;
    }

    public final void e(boolean z10, boolean z11) {
        int i10 = this.f16618p;
        SpannableStringBuilder spannableStringBuilder = this.f16604b;
        if (i10 != -1) {
            if (!z10) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f16618p, spannableStringBuilder.length(), 33);
                this.f16618p = -1;
            }
        } else if (z10) {
            this.f16618p = spannableStringBuilder.length();
        }
        if (this.f16619q != -1) {
            if (!z11) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f16619q, spannableStringBuilder.length(), 33);
                this.f16619q = -1;
            }
        } else if (z11) {
            this.f16619q = spannableStringBuilder.length();
        }
    }

    public final void f(int i10, int i11) {
        int i12 = this.f16620r;
        SpannableStringBuilder spannableStringBuilder = this.f16604b;
        if (!(i12 == -1 || this.f16621s == i10)) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f16621s), this.f16620r, spannableStringBuilder.length(), 33);
        }
        if (i10 != f16599w) {
            this.f16620r = spannableStringBuilder.length();
            this.f16621s = i10;
        }
        if (!(this.f16622t == -1 || this.f16623u == i11)) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f16623u), this.f16622t, spannableStringBuilder.length(), 33);
        }
        if (i11 != f16600x) {
            this.f16622t = spannableStringBuilder.length();
            this.f16623u = i11;
        }
    }
}
