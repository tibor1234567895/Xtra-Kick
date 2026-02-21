package e8;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import c4.c;
import f0.b;

public final class a extends c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f5313b;

    public a(d dVar) {
        this.f5313b = dVar;
    }

    public final void a(Drawable drawable) {
        ColorStateList colorStateList = this.f5313b.f5325v;
        if (colorStateList != null) {
            b.h(drawable, colorStateList);
        }
    }

    public final void b(Drawable drawable) {
        d dVar = this.f5313b;
        ColorStateList colorStateList = dVar.f5325v;
        if (colorStateList != null) {
            b.g(drawable, colorStateList.getColorForState(dVar.f5329z, colorStateList.getDefaultColor()));
        }
    }
}
