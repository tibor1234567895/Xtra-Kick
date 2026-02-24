package t8;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import j8.a;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;

public final class j {
    private j() {
    }

    public static d a(int i10) {
        if (i10 == 0) {
            return new l();
        }
        if (i10 != 1) {
            return new l();
        }
        return new e();
    }

    public static void b(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).j(f10);
        }
    }

    public static void c(View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            d(view, (i) background);
        }
    }

    public static void d(View view, i iVar) {
        boolean z10;
        a aVar = iVar.f14744h.f14724b;
        if (aVar == null || !aVar.f8843a) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            float f10 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                WeakHashMap weakHashMap = c1.f10054a;
                f10 += o0.i((View) parent);
            }
            h hVar = iVar.f14744h;
            if (hVar.f14735m != f10) {
                hVar.f14735m = f10;
                iVar.n();
            }
        }
    }
}
