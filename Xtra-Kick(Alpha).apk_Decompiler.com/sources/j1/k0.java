package j1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public final class k0 {
    private k0() {
    }

    public static Drawable a(Context context, Resources resources, int i10) {
        return resources.getDrawable(i10, context.getTheme());
    }
}
