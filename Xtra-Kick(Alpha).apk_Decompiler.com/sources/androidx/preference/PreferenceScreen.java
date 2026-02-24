package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.fragment.app.c0;
import com.woxthebox.draglistview.R;
import d0.t;
import o3.g0;
import o3.z;

public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: a0  reason: collision with root package name */
    public final boolean f1906a0 = true;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, t.a(context, R.attr.preferenceScreenStyle, 16842891));
    }

    public final void m() {
        g0 g0Var;
        if (this.f1899t == null && this.f1900u == null && A() != 0 && (g0Var = this.f1888i.f12136k) != null) {
            z zVar = (z) g0Var;
            for (c0 c0Var = zVar; c0Var != null; c0Var = c0Var.C) {
            }
            zVar.v();
            zVar.t();
        }
    }
}
