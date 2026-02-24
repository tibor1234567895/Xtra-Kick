package i1;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import g1.a;
import g1.m;
import j1.l0;
import java.util.Arrays;

public final class b implements m {
    public static final String A = l0.C(1);
    public static final String B = l0.C(2);
    public static final String C = l0.C(3);
    public static final String D = l0.C(4);
    public static final String E = l0.C(5);
    public static final String F = l0.C(6);
    public static final String G = l0.C(7);
    public static final String H = l0.C(8);
    public static final String I = l0.C(9);
    public static final String J = l0.C(10);
    public static final String K = l0.C(11);
    public static final String L = l0.C(12);
    public static final String M = l0.C(13);
    public static final String N = l0.C(14);
    public static final String O = l0.C(15);
    public static final String P = l0.C(16);
    public static final a Q = new a(29);

    /* renamed from: y  reason: collision with root package name */
    public static final b f7970y;

    /* renamed from: z  reason: collision with root package name */
    public static final String f7971z = l0.C(0);

    /* renamed from: h  reason: collision with root package name */
    public final CharSequence f7972h;

    /* renamed from: i  reason: collision with root package name */
    public final Layout.Alignment f7973i;

    /* renamed from: j  reason: collision with root package name */
    public final Layout.Alignment f7974j;

    /* renamed from: k  reason: collision with root package name */
    public final Bitmap f7975k;

    /* renamed from: l  reason: collision with root package name */
    public final float f7976l;

    /* renamed from: m  reason: collision with root package name */
    public final int f7977m;

    /* renamed from: n  reason: collision with root package name */
    public final int f7978n;

    /* renamed from: o  reason: collision with root package name */
    public final float f7979o;

    /* renamed from: p  reason: collision with root package name */
    public final int f7980p;

    /* renamed from: q  reason: collision with root package name */
    public final float f7981q;

    /* renamed from: r  reason: collision with root package name */
    public final float f7982r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f7983s;

    /* renamed from: t  reason: collision with root package name */
    public final int f7984t;

    /* renamed from: u  reason: collision with root package name */
    public final int f7985u;

    /* renamed from: v  reason: collision with root package name */
    public final float f7986v;

    /* renamed from: w  reason: collision with root package name */
    public final int f7987w;

    /* renamed from: x  reason: collision with root package name */
    public final float f7988x;

    static {
        a aVar = new a();
        aVar.f7953a = "";
        f7970y = aVar.a();
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15) {
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 == null) {
            bitmap.getClass();
        } else {
            j1.a.b(bitmap2 == null);
        }
        this.f7972h = charSequence2 instanceof Spanned ? SpannedString.valueOf(charSequence) : charSequence2 != null ? charSequence.toString() : null;
        this.f7973i = alignment;
        this.f7974j = alignment2;
        this.f7975k = bitmap2;
        this.f7976l = f10;
        this.f7977m = i10;
        this.f7978n = i11;
        this.f7979o = f11;
        this.f7980p = i12;
        this.f7981q = f13;
        this.f7982r = f14;
        this.f7983s = z10;
        this.f7984t = i14;
        this.f7985u = i13;
        this.f7986v = f12;
        this.f7987w = i15;
        this.f7988x = f15;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (TextUtils.equals(this.f7972h, bVar.f7972h) && this.f7973i == bVar.f7973i && this.f7974j == bVar.f7974j) {
            Bitmap bitmap = bVar.f7975k;
            Bitmap bitmap2 = this.f7975k;
            if (bitmap2 != null ? !(bitmap == null || !bitmap2.sameAs(bitmap)) : bitmap == null) {
                return this.f7976l == bVar.f7976l && this.f7977m == bVar.f7977m && this.f7978n == bVar.f7978n && this.f7979o == bVar.f7979o && this.f7980p == bVar.f7980p && this.f7981q == bVar.f7981q && this.f7982r == bVar.f7982r && this.f7983s == bVar.f7983s && this.f7984t == bVar.f7984t && this.f7985u == bVar.f7985u && this.f7986v == bVar.f7986v && this.f7987w == bVar.f7987w && this.f7988x == bVar.f7988x;
            }
        }
    }

    public final Bundle h() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence(f7971z, this.f7972h);
        bundle.putSerializable(A, this.f7973i);
        bundle.putSerializable(B, this.f7974j);
        bundle.putParcelable(C, this.f7975k);
        bundle.putFloat(D, this.f7976l);
        bundle.putInt(E, this.f7977m);
        bundle.putInt(F, this.f7978n);
        bundle.putFloat(G, this.f7979o);
        bundle.putInt(H, this.f7980p);
        bundle.putInt(I, this.f7985u);
        bundle.putFloat(J, this.f7986v);
        bundle.putFloat(K, this.f7981q);
        bundle.putFloat(L, this.f7982r);
        bundle.putBoolean(N, this.f7983s);
        bundle.putInt(M, this.f7984t);
        bundle.putInt(O, this.f7987w);
        bundle.putFloat(P, this.f7988x);
        return bundle;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7972h, this.f7973i, this.f7974j, this.f7975k, Float.valueOf(this.f7976l), Integer.valueOf(this.f7977m), Integer.valueOf(this.f7978n), Float.valueOf(this.f7979o), Integer.valueOf(this.f7980p), Float.valueOf(this.f7981q), Float.valueOf(this.f7982r), Boolean.valueOf(this.f7983s), Integer.valueOf(this.f7984t), Integer.valueOf(this.f7985u), Float.valueOf(this.f7986v), Integer.valueOf(this.f7987w), Float.valueOf(this.f7988x)});
    }
}
