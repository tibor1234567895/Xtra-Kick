package u5;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import t5.d;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public final int f15361a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f15362b;

    public c(int i10, boolean z10) {
        this.f15361a = i10;
        this.f15362b = z10;
    }

    public final boolean a(Object obj, f fVar) {
        Drawable drawable = (Drawable) obj;
        d dVar = (d) fVar;
        Drawable drawable2 = ((ImageView) dVar.f14559i).getDrawable();
        if (drawable2 == null) {
            drawable2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawable2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f15362b);
        transitionDrawable.startTransition(this.f15361a);
        ((ImageView) dVar.f14559i).setImageDrawable(transitionDrawable);
        return true;
    }
}
