package m;

import android.support.v4.media.h;
import android.widget.PopupWindow;
import androidx.appcompat.widget.j3;

public final class y implements PopupWindow.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10036h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f10037i;

    public /* synthetic */ y(int i10, Object obj) {
        this.f10036h = i10;
        this.f10037i = obj;
    }

    public final void onDismiss() {
        int i10 = this.f10036h;
        Object obj = this.f10037i;
        switch (i10) {
            case 0:
                ((a0) obj).c();
                return;
            default:
                h.y(((j3) obj).f899f);
                return;
        }
    }
}
