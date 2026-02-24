package androidx.appcompat.widget;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;

public final class f5 {
    private f5() {
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            e5.a(view, charSequence);
            return;
        }
        h5 h5Var = h5.f855r;
        if (h5Var != null && h5Var.f857h == view) {
            h5.b((h5) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            h5 h5Var2 = h5.f856s;
            if (h5Var2 != null && h5Var2.f857h == view) {
                h5Var2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new h5(view, charSequence);
    }
}
