package s7;

import android.content.Context;
import android.util.DisplayMetrics;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f14365a = new b();

    private b() {
    }

    public static int a(Context context, int i10) {
        j.f("context", context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i11 = displayMetrics.heightPixels;
        int i12 = displayMetrics.widthPixels;
        if (i11 <= i12) {
            i11 = i12;
        }
        return (int) ((((float) i10) / 100.0f) * ((float) i11));
    }
}
