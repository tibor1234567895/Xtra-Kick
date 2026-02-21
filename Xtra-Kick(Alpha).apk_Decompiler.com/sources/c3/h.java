package c3;

import android.text.Layout;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public String f2841a;

    /* renamed from: b  reason: collision with root package name */
    public int f2842b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2843c;

    /* renamed from: d  reason: collision with root package name */
    public int f2844d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2845e;

    /* renamed from: f  reason: collision with root package name */
    public int f2846f = -1;

    /* renamed from: g  reason: collision with root package name */
    public int f2847g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f2848h = -1;

    /* renamed from: i  reason: collision with root package name */
    public int f2849i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f2850j = -1;

    /* renamed from: k  reason: collision with root package name */
    public float f2851k;

    /* renamed from: l  reason: collision with root package name */
    public String f2852l;

    /* renamed from: m  reason: collision with root package name */
    public int f2853m = -1;

    /* renamed from: n  reason: collision with root package name */
    public int f2854n = -1;

    /* renamed from: o  reason: collision with root package name */
    public Layout.Alignment f2855o;

    /* renamed from: p  reason: collision with root package name */
    public Layout.Alignment f2856p;

    /* renamed from: q  reason: collision with root package name */
    public int f2857q = -1;

    /* renamed from: r  reason: collision with root package name */
    public b f2858r;

    /* renamed from: s  reason: collision with root package name */
    public float f2859s = Float.MAX_VALUE;

    public final void a(h hVar) {
        int i10;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (hVar != null) {
            if (!this.f2843c && hVar.f2843c) {
                this.f2842b = hVar.f2842b;
                this.f2843c = true;
            }
            if (this.f2848h == -1) {
                this.f2848h = hVar.f2848h;
            }
            if (this.f2849i == -1) {
                this.f2849i = hVar.f2849i;
            }
            if (this.f2841a == null && (str = hVar.f2841a) != null) {
                this.f2841a = str;
            }
            if (this.f2846f == -1) {
                this.f2846f = hVar.f2846f;
            }
            if (this.f2847g == -1) {
                this.f2847g = hVar.f2847g;
            }
            if (this.f2854n == -1) {
                this.f2854n = hVar.f2854n;
            }
            if (this.f2855o == null && (alignment2 = hVar.f2855o) != null) {
                this.f2855o = alignment2;
            }
            if (this.f2856p == null && (alignment = hVar.f2856p) != null) {
                this.f2856p = alignment;
            }
            if (this.f2857q == -1) {
                this.f2857q = hVar.f2857q;
            }
            if (this.f2850j == -1) {
                this.f2850j = hVar.f2850j;
                this.f2851k = hVar.f2851k;
            }
            if (this.f2858r == null) {
                this.f2858r = hVar.f2858r;
            }
            if (this.f2859s == Float.MAX_VALUE) {
                this.f2859s = hVar.f2859s;
            }
            if (!this.f2845e && hVar.f2845e) {
                this.f2844d = hVar.f2844d;
                this.f2845e = true;
            }
            if (this.f2853m == -1 && (i10 = hVar.f2853m) != -1) {
                this.f2853m = i10;
            }
        }
    }
}
