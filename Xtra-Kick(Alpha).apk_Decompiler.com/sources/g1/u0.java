package g1;

import android.net.Uri;
import android.os.Bundle;
import j1.l0;

public final class u0 {
    public Integer A;
    public Integer B;
    public CharSequence C;
    public CharSequence D;
    public CharSequence E;
    public Integer F;
    public Bundle G;

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f6596a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f6597b;

    /* renamed from: c  reason: collision with root package name */
    public CharSequence f6598c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f6599d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f6600e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f6601f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f6602g;

    /* renamed from: h  reason: collision with root package name */
    public l1 f6603h;

    /* renamed from: i  reason: collision with root package name */
    public l1 f6604i;

    /* renamed from: j  reason: collision with root package name */
    public byte[] f6605j;

    /* renamed from: k  reason: collision with root package name */
    public Integer f6606k;

    /* renamed from: l  reason: collision with root package name */
    public Uri f6607l;

    /* renamed from: m  reason: collision with root package name */
    public Integer f6608m;

    /* renamed from: n  reason: collision with root package name */
    public Integer f6609n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f6610o;

    /* renamed from: p  reason: collision with root package name */
    public Boolean f6611p;

    /* renamed from: q  reason: collision with root package name */
    public Boolean f6612q;

    /* renamed from: r  reason: collision with root package name */
    public Integer f6613r;

    /* renamed from: s  reason: collision with root package name */
    public Integer f6614s;

    /* renamed from: t  reason: collision with root package name */
    public Integer f6615t;

    /* renamed from: u  reason: collision with root package name */
    public Integer f6616u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f6617v;

    /* renamed from: w  reason: collision with root package name */
    public Integer f6618w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f6619x;

    /* renamed from: y  reason: collision with root package name */
    public CharSequence f6620y;

    /* renamed from: z  reason: collision with root package name */
    public CharSequence f6621z;

    public u0() {
    }

    public u0(v0 v0Var) {
        this.f6596a = v0Var.f6651h;
        this.f6597b = v0Var.f6652i;
        this.f6598c = v0Var.f6653j;
        this.f6599d = v0Var.f6654k;
        this.f6600e = v0Var.f6655l;
        this.f6601f = v0Var.f6656m;
        this.f6602g = v0Var.f6657n;
        this.f6603h = v0Var.f6658o;
        this.f6604i = v0Var.f6659p;
        this.f6605j = v0Var.f6660q;
        this.f6606k = v0Var.f6661r;
        this.f6607l = v0Var.f6662s;
        this.f6608m = v0Var.f6663t;
        this.f6609n = v0Var.f6664u;
        this.f6610o = v0Var.f6665v;
        this.f6611p = v0Var.f6666w;
        this.f6612q = v0Var.f6667x;
        this.f6613r = v0Var.f6669z;
        this.f6614s = v0Var.A;
        this.f6615t = v0Var.B;
        this.f6616u = v0Var.C;
        this.f6617v = v0Var.D;
        this.f6618w = v0Var.E;
        this.f6619x = v0Var.F;
        this.f6620y = v0Var.G;
        this.f6621z = v0Var.H;
        this.A = v0Var.I;
        this.B = v0Var.J;
        this.C = v0Var.K;
        this.D = v0Var.L;
        this.E = v0Var.M;
        this.F = v0Var.N;
        this.G = v0Var.O;
    }

    public final void a(int i10, byte[] bArr) {
        if (this.f6605j == null || l0.a(Integer.valueOf(i10), 3) || !l0.a(this.f6606k, 3)) {
            this.f6605j = (byte[]) bArr.clone();
            this.f6606k = Integer.valueOf(i10);
        }
    }

    public final void b(byte[] bArr, Integer num) {
        this.f6605j = bArr == null ? null : (byte[]) bArr.clone();
        this.f6606k = num;
    }
}
