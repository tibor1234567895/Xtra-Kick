package xa;

import db.a;
import java.io.Serializable;

public abstract class b implements a, Serializable {

    /* renamed from: n  reason: collision with root package name */
    public static final a f16799n = a.f16798h;

    /* renamed from: h  reason: collision with root package name */
    public transient a f16800h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f16801i;

    /* renamed from: j  reason: collision with root package name */
    public final Class f16802j;

    /* renamed from: k  reason: collision with root package name */
    public final String f16803k;

    /* renamed from: l  reason: collision with root package name */
    public final String f16804l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f16805m;

    public b() {
        this(f16799n, (Class) null, (String) null, (String) null, false);
    }

    public abstract a a();

    public final c c() {
        Class cls = this.f16802j;
        if (cls == null) {
            return null;
        }
        if (!this.f16805m) {
            return v.a(cls);
        }
        v.f16819a.getClass();
        return new l(cls);
    }

    public b(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f16801i = obj;
        this.f16802j = cls;
        this.f16803k = str;
        this.f16804l = str2;
        this.f16805m = z10;
    }
}
