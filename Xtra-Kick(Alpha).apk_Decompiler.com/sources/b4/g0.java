package b4;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.appcompat.widget.n4;

public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static final i0 f2543a;

    /* renamed from: b  reason: collision with root package name */
    public static final n4 f2544b = new n4(Float.class, "translationAlpha", 6);

    static {
        int i10 = Build.VERSION.SDK_INT;
        f2543a = i10 >= 29 ? new l0() : i10 >= 23 ? new k0() : i10 >= 22 ? new j0() : new i0();
        new n4(Rect.class, "clipBounds", 7);
    }

    private g0() {
    }

    public static void a(View view, int i10, int i11, int i12, int i13) {
        f2543a.a(view, i10, i11, i12, i13);
    }
}
