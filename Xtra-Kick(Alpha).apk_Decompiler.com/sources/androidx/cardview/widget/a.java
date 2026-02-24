package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.support.v4.media.n;

public final class a {
    public final void a(n nVar, float f10) {
        float f11;
        ((RoundRectDrawable) ((Drawable) nVar.f337i)).setPadding(f10, ((CardView) nVar.f338j).getUseCompatPadding(), ((CardView) nVar.f338j).getPreventCornerOverlap());
        if (!((CardView) nVar.f338j).getUseCompatPadding()) {
            nVar.A(0, 0, 0, 0);
            return;
        }
        float padding = ((RoundRectDrawable) ((Drawable) nVar.f337i)).getPadding();
        float radius = ((RoundRectDrawable) ((Drawable) nVar.f337i)).getRadius();
        if (((CardView) nVar.f338j).getPreventCornerOverlap()) {
            f11 = (float) (((1.0d - b.f1162a) * ((double) radius)) + ((double) padding));
        } else {
            int i10 = b.f1163b;
            f11 = padding;
        }
        int ceil = (int) Math.ceil((double) f11);
        int ceil2 = (int) Math.ceil((double) b.a(padding, radius, ((CardView) nVar.f338j).getPreventCornerOverlap()));
        nVar.A(ceil, ceil2, ceil, ceil2);
    }
}
