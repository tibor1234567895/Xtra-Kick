package a9;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.woxthebox.draglistview.R;
import l.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f289a = {16842752, R.attr.theme};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f290b = {R.attr.materialThemeOverlay};

    private a() {
    }

    public static Context a(Context context, AttributeSet attributeSet, int i10, int i11) {
        boolean z10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f290b, i10, i11);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (!(context instanceof f) || ((f) context).f9435a != resourceId) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (resourceId == 0 || z10) {
            return context;
        }
        f fVar = new f(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f289a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            fVar.getTheme().applyStyle(resourceId2, true);
        }
        return fVar;
    }
}
