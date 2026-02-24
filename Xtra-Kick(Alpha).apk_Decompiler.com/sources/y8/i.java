package y8;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class i implements View.OnTouchListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ k f17137h;

    public /* synthetic */ i(k kVar) {
        this.f17137h = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        k kVar = this.f17137h;
        kVar.getClass();
        if (motionEvent.getAction() == 1) {
            long currentTimeMillis = System.currentTimeMillis() - kVar.f17149o;
            if (currentTimeMillis < 0 || currentTimeMillis > 300) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                kVar.f17147m = false;
            }
            kVar.u();
            kVar.f17147m = true;
            kVar.f17149o = System.currentTimeMillis();
        }
        return false;
    }
}
