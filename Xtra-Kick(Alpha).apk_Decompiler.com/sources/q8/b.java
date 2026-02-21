package q8;

import android.graphics.Typeface;
import m8.c;
import m8.d;

public final class b extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f13408a;

    /* renamed from: b  reason: collision with root package name */
    public final a f13409b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13410c;

    public b(c cVar, Typeface typeface) {
        this.f13408a = typeface;
        this.f13409b = cVar;
    }

    public final void a(int i10) {
        c(this.f13408a);
    }

    public final void b(Typeface typeface, boolean z10) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.f13410c) {
            c cVar = (c) this.f13409b;
            int i10 = cVar.f10717a;
            d dVar = cVar.f10718b;
            switch (i10) {
                case 0:
                    if (dVar.m(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
                default:
                    if (dVar.o(typeface)) {
                        dVar.i(false);
                        return;
                    }
                    return;
            }
        }
    }
}
