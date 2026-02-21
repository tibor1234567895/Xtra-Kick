package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public final class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final ActionBarContainer f728a;

    public b(ActionBarContainer actionBarContainer) {
        this.f728a = actionBarContainer;
    }

    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f728a;
        if (actionBarContainer.f582n) {
            Drawable drawable = actionBarContainer.f581m;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f579k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f580l;
        if (drawable3 != null && actionBarContainer.f583o) {
            drawable3.draw(canvas);
        }
    }

    public final int getOpacity() {
        return 0;
    }

    public final void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f728a;
        if (!actionBarContainer.f582n) {
            drawable = actionBarContainer.f579k;
            if (drawable == null) {
                return;
            }
        } else if (actionBarContainer.f581m != null) {
            drawable = actionBarContainer.f579k;
        } else {
            return;
        }
        drawable.getOutline(outline);
    }

    public final void setAlpha(int i10) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
