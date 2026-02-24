package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;

public final class h0 {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f843b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static h0 f844c;

    /* renamed from: a  reason: collision with root package name */
    public q3 f845a;

    public static synchronized h0 a() {
        h0 h0Var;
        synchronized (h0.class) {
            if (f844c == null) {
                d();
            }
            h0Var = f844c;
        }
        return h0Var;
    }

    public static synchronized PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter h10;
        synchronized (h0.class) {
            h10 = q3.h(i10, mode);
        }
        return h10;
    }

    public static synchronized void d() {
        synchronized (h0.class) {
            if (f844c == null) {
                h0 h0Var = new h0();
                f844c = h0Var;
                h0Var.f845a = q3.d();
                f844c.f845a.l(new g0());
            }
        }
    }

    public static void e(Drawable drawable, s4 s4Var, int[] iArr) {
        boolean z10;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = q3.f1012h;
        int[] state = drawable.getState();
        int[] iArr2 = i2.f869a;
        if (drawable.mutate() == drawable) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z11 = s4Var.f1058d;
            if (z11 || s4Var.f1057c) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                if (z11) {
                    colorStateList = s4Var.f1055a;
                } else {
                    colorStateList = null;
                }
                if (s4Var.f1057c) {
                    mode = s4Var.f1056b;
                } else {
                    mode = q3.f1012h;
                }
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = q3.h(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final synchronized Drawable b(Context context, int i10) {
        return this.f845a.f(context, i10);
    }
}
