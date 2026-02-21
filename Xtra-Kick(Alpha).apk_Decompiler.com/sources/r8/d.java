package r8;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import e0.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f13884a = {16842919};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f13885b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f13886c = {16842913, 16842919};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f13887d = {16842913};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f13888e = {16842910, 16842919};

    /* renamed from: f  reason: collision with root package name */
    public static final String f13889f = d.class.getSimpleName();

    private d() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f13885b;
        return new ColorStateList(new int[][]{f13887d, iArr, StateSet.NOTHING}, new int[]{b(colorStateList, f13886c), b(colorStateList, iArr), b(colorStateList, f13884a)});
    }

    public static int b(ColorStateList colorStateList, int[] iArr) {
        int i10;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i10 = 0;
        }
        return a.d(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    public static ColorStateList c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 22 && i10 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f13888e, 0)) != 0) {
            Log.w(f13889f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean d(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
