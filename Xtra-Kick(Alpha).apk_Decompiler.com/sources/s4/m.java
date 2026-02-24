package s4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.os.Build;
import pb.p0;
import s.i;
import t4.g;
import xa.j;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final Context f14276a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap.Config f14277b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorSpace f14278c;

    /* renamed from: d  reason: collision with root package name */
    public final g f14279d;

    /* renamed from: e  reason: collision with root package name */
    public final int f14280e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f14281f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f14282g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f14283h;

    /* renamed from: i  reason: collision with root package name */
    public final String f14284i;

    /* renamed from: j  reason: collision with root package name */
    public final p0 f14285j;

    /* renamed from: k  reason: collision with root package name */
    public final t f14286k;

    /* renamed from: l  reason: collision with root package name */
    public final p f14287l;

    /* renamed from: m  reason: collision with root package name */
    public final int f14288m;

    /* renamed from: n  reason: collision with root package name */
    public final int f14289n;

    /* renamed from: o  reason: collision with root package name */
    public final int f14290o;

    public m(Context context, Bitmap.Config config, ColorSpace colorSpace, g gVar, int i10, boolean z10, boolean z11, boolean z12, String str, p0 p0Var, t tVar, p pVar, int i11, int i12, int i13) {
        this.f14276a = context;
        this.f14277b = config;
        this.f14278c = colorSpace;
        this.f14279d = gVar;
        this.f14280e = i10;
        this.f14281f = z10;
        this.f14282g = z11;
        this.f14283h = z12;
        this.f14284i = str;
        this.f14285j = p0Var;
        this.f14286k = tVar;
        this.f14287l = pVar;
        this.f14288m = i11;
        this.f14289n = i12;
        this.f14290o = i13;
    }

    public static m a(m mVar, Bitmap.Config config) {
        m mVar2 = mVar;
        Context context = mVar2.f14276a;
        ColorSpace colorSpace = mVar2.f14278c;
        g gVar = mVar2.f14279d;
        int i10 = mVar2.f14280e;
        boolean z10 = mVar2.f14281f;
        boolean z11 = mVar2.f14282g;
        boolean z12 = mVar2.f14283h;
        String str = mVar2.f14284i;
        p0 p0Var = mVar2.f14285j;
        t tVar = mVar2.f14286k;
        p pVar = mVar2.f14287l;
        int i11 = mVar2.f14288m;
        int i12 = mVar2.f14289n;
        int i13 = mVar2.f14290o;
        mVar.getClass();
        return new m(context, config, colorSpace, gVar, i10, z10, z11, z12, str, p0Var, tVar, pVar, i11, i12, i13);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            return j.a(this.f14276a, mVar.f14276a) && this.f14277b == mVar.f14277b && (Build.VERSION.SDK_INT < 26 || j.a(this.f14278c, mVar.f14278c)) && j.a(this.f14279d, mVar.f14279d) && this.f14280e == mVar.f14280e && this.f14281f == mVar.f14281f && this.f14282g == mVar.f14282g && this.f14283h == mVar.f14283h && j.a(this.f14284i, mVar.f14284i) && j.a(this.f14285j, mVar.f14285j) && j.a(this.f14286k, mVar.f14286k) && j.a(this.f14287l, mVar.f14287l) && this.f14288m == mVar.f14288m && this.f14289n == mVar.f14289n && this.f14290o == mVar.f14290o;
        }
    }

    public final int hashCode() {
        int hashCode = (this.f14277b.hashCode() + (this.f14276a.hashCode() * 31)) * 31;
        int i10 = 0;
        ColorSpace colorSpace = this.f14278c;
        int i11 = 1237;
        int a10 = (((((i.a(this.f14280e) + ((this.f14279d.hashCode() + ((hashCode + (colorSpace != null ? colorSpace.hashCode() : 0)) * 31)) * 31)) * 31) + (this.f14281f ? 1231 : 1237)) * 31) + (this.f14282g ? 1231 : 1237)) * 31;
        if (this.f14283h) {
            i11 = 1231;
        }
        int i12 = (a10 + i11) * 31;
        String str = this.f14284i;
        if (str != null) {
            i10 = str.hashCode();
        }
        int hashCode2 = this.f14285j.hashCode();
        int hashCode3 = this.f14286k.hashCode();
        return i.a(this.f14290o) + ((i.a(this.f14289n) + ((i.a(this.f14288m) + ((this.f14287l.hashCode() + ((hashCode3 + ((hashCode2 + ((i12 + i10) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }
}
