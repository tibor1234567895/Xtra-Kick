package androidx.appcompat.widget;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.woxthebox.draglistview.R;
import h.a;
import m.i0;
import m0.d;

public class ShareActionProvider extends d {

    /* renamed from: c  reason: collision with root package name */
    public final int f665c = 4;

    /* renamed from: d  reason: collision with root package name */
    public final Context f666d;

    /* renamed from: e  reason: collision with root package name */
    public final String f667e = "share_history.xml";

    public ShareActionProvider(Context context) {
        this.f666d = context;
    }

    public final boolean a() {
        return true;
    }

    public final View c() {
        Context context = this.f666d;
        z zVar = new z(context);
        if (!zVar.isInEditMode()) {
            zVar.setActivityChooserModel(u.c(context, this.f667e));
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        zVar.setExpandActivityOverflowButtonDrawable(a.a(context, typedValue.resourceId));
        zVar.setProvider(this);
        zVar.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        zVar.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return zVar;
    }

    public final void f(i0 i0Var) {
        i0Var.clear();
        Context context = this.f666d;
        u c10 = u.c(context, this.f667e);
        context.getPackageManager();
        int e10 = c10.e();
        int min = Math.min(e10, this.f665c);
        if (min > 0) {
            c10.d(0);
            throw null;
        } else if (min < e10) {
            i0Var.addSubMenu(0, min, min, (CharSequence) context.getString(R.string.abc_activity_chooser_view_see_all));
            if (e10 > 0) {
                c10.d(0);
                throw null;
            }
        }
    }
}
