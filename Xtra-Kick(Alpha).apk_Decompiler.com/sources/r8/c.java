package r8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.TypedValue;
import c0.g;
import com.woxthebox.draglistview.R;

public final class c {
    private c() {
    }

    /* access modifiers changed from: private */
    public static Drawable b(Context context, int i10) {
        ColorStateList colorStateList;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(1);
        InsetDrawable insetDrawable = new InsetDrawable(gradientDrawable, i10, i10, i10, i10);
        ColorStateList valueOf = ColorStateList.valueOf(0);
        TypedValue a10 = q8.c.a(context, R.attr.colorControlHighlight);
        if (a10 != null) {
            int i11 = a10.resourceId;
            if (i11 != 0) {
                colorStateList = g.c(context, i11);
            } else {
                colorStateList = ColorStateList.valueOf(a10.data);
            }
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            valueOf = colorStateList;
        }
        return new RippleDrawable(valueOf, (Drawable) null, insetDrawable);
    }
}
