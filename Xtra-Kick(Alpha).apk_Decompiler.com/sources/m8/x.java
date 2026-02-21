package m8;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.woxthebox.draglistview.R;

public abstract class x extends ImageButton {

    /* renamed from: h  reason: collision with root package name */
    public int f10796h = getVisibility();

    public x(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public final void a(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f10796h = i10;
        }
    }

    public final int getUserSetVisibility() {
        return this.f10796h;
    }

    public void setVisibility(int i10) {
        a(i10, true);
    }
}
