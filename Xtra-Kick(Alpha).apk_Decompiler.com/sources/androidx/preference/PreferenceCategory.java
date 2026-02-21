package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import com.woxthebox.draglistview.R;
import d0.t;
import o3.l0;

public class PreferenceCategory extends PreferenceGroup {
    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, t.a(context, R.attr.preferenceCategoryStyle, 16842892));
    }

    public final boolean g() {
        return false;
    }

    public final void l(l0 l0Var) {
        super.l(l0Var);
        if (Build.VERSION.SDK_INT >= 28) {
            l0Var.itemView.setAccessibilityHeading(true);
        }
    }

    public final boolean w() {
        return !super.g();
    }
}
