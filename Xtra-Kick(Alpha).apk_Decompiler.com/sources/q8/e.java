package q8;

import android.graphics.Typeface;
import d0.p;

public final class e extends p {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f13411a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f13412b;

    public e(g gVar, h hVar) {
        this.f13412b = gVar;
        this.f13411a = hVar;
    }

    public final void c(int i10) {
        this.f13412b.f13429m = true;
        this.f13411a.a(i10);
    }

    public final void d(Typeface typeface) {
        g gVar = this.f13412b;
        gVar.f13430n = Typeface.create(typeface, gVar.f13419c);
        gVar.f13429m = true;
        this.f13411a.b(gVar.f13430n, false);
    }
}
