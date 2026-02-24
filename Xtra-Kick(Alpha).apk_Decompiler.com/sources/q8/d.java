package q8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import androidx.appcompat.widget.u4;
import c0.g;

public final class d {
    private d() {
    }

    public static ColorStateList a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList c10;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (c10 = g.c(context, resourceId)) == null) {
            return typedArray.getColorStateList(i10);
        }
        return c10;
    }

    public static ColorStateList b(Context context, u4 u4Var, int i10) {
        int i11;
        ColorStateList c10;
        if (!u4Var.l(i10) || (i11 = u4Var.i(i10, 0)) == 0 || (c10 = g.c(context, i11)) == null) {
            return u4Var.b(i10);
        }
        return c10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r1 = h.a.a(r1, (r0 = r2.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable c(android.content.Context r1, android.content.res.TypedArray r2, int r3) {
        /*
            boolean r0 = r2.hasValue(r3)
            if (r0 == 0) goto L_0x0014
            r0 = 0
            int r0 = r2.getResourceId(r3, r0)
            if (r0 == 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = h.a.a(r1, r0)
            if (r1 == 0) goto L_0x0014
            return r1
        L_0x0014:
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.d.c(android.content.Context, android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static boolean d(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }
}
