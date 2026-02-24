package fb;

import eb.h;
import java.util.Iterator;
import wa.p;
import xa.j;

public final class e implements h {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f5997a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5998b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5999c;

    /* renamed from: d  reason: collision with root package name */
    public final p f6000d;

    public e(CharSequence charSequence, int i10, int i11, x xVar) {
        j.f("input", charSequence);
        this.f5997a = charSequence;
        this.f5998b = i10;
        this.f5999c = i11;
        this.f6000d = xVar;
    }

    public final Iterator iterator() {
        return new d(this);
    }
}
