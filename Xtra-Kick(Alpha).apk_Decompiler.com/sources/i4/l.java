package i4;

import android.content.Context;
import h3.j3;
import la.f;
import la.o;
import s4.a;
import w4.c;
import w4.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8250a;

    /* renamed from: b  reason: collision with root package name */
    public a f8251b = c.f16078a;

    /* renamed from: c  reason: collision with root package name */
    public c f8252c = null;

    /* renamed from: d  reason: collision with root package name */
    public final j f8253d = new j(0);

    public l(Context context) {
        this.f8250a = context.getApplicationContext();
    }

    public final t a() {
        Context context = this.f8250a;
        a aVar = this.f8251b;
        o b10 = f.b(new j(this, 0));
        o b11 = f.b(new j(this, 1));
        o b12 = f.b(k.f8249h);
        j3 j3Var = h.f8245c;
        c cVar = this.f8252c;
        if (cVar == null) {
            cVar = new c();
        }
        return new t(context, aVar, b10, b11, b12, j3Var, cVar, this.f8253d);
    }
}
