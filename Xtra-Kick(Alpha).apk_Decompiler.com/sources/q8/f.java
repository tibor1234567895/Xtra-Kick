package q8;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

public final class f extends h {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f13413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextPaint f13414b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f13415c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f13416d;

    public f(g gVar, Context context, TextPaint textPaint, h hVar) {
        this.f13416d = gVar;
        this.f13413a = context;
        this.f13414b = textPaint;
        this.f13415c = hVar;
    }

    public final void a(int i10) {
        this.f13415c.a(i10);
    }

    public final void b(Typeface typeface, boolean z10) {
        this.f13416d.g(this.f13413a, this.f13414b, typeface);
        this.f13415c.b(typeface, z10);
    }
}
