package m;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import l.d;

public final class t extends FrameLayout implements d {

    /* renamed from: h  reason: collision with root package name */
    public final CollapsibleActionView f10028h;

    public t(View view) {
        super(view.getContext());
        this.f10028h = (CollapsibleActionView) view;
        addView(view);
    }

    public final void a() {
        this.f10028h.onActionViewExpanded();
    }

    public final void e() {
        this.f10028h.onActionViewCollapsed();
    }
}
