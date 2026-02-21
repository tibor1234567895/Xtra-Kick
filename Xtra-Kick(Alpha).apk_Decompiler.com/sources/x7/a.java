package x7;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import g.b1;
import java.util.Iterator;
import t8.i;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f16711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f16712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f16713c;

    public /* synthetic */ a(Object obj, int i10, Object obj2) {
        this.f16711a = i10;
        this.f16712b = obj;
        this.f16713c = obj2;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i10 = this.f16711a;
        Object obj = this.f16713c;
        Object obj2 = this.f16712b;
        switch (i10) {
            case 0:
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                i iVar = (i) obj;
                int i11 = AppBarLayout.F;
                appBarLayout.getClass();
                int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                iVar.setAlpha(floatValue);
                Iterator it = appBarLayout.f3596y.iterator();
                while (it.hasNext()) {
                    h.y(it.next());
                    ColorStateList colorStateList = iVar.f14744h.f14725c;
                    if (colorStateList != null) {
                        colorStateList.withAlpha(floatValue).getDefaultColor();
                        throw null;
                    }
                }
                return;
            case 1:
                AppBarLayout appBarLayout2 = (AppBarLayout) obj2;
                int i12 = AppBarLayout.F;
                appBarLayout2.getClass();
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((i) obj).j(floatValue2);
                Drawable drawable = appBarLayout2.C;
                if (drawable instanceof i) {
                    ((i) drawable).j(floatValue2);
                }
                Iterator it2 = appBarLayout2.f3596y.iterator();
                if (it2.hasNext()) {
                    h.y(it2.next());
                    throw null;
                }
                return;
            default:
                ((View) ((b1) ((e.a) obj2).f4852i).f6030d.getParent()).invalidate();
                return;
        }
    }
}
