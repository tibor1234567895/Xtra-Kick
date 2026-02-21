package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public final class q2 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1010h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ r2 f1011i;

    public /* synthetic */ q2(r2 r2Var, int i10) {
        this.f1010h = i10;
        this.f1011i = r2Var;
    }

    public final void run() {
        int i10 = this.f1010h;
        r2 r2Var = this.f1011i;
        switch (i10) {
            case 0:
                ViewParent parent = r2Var.f1035k.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                r2Var.a();
                View view = r2Var.f1035k;
                if (view.isEnabled() && !view.isLongClickable() && r2Var.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    r2Var.f1038n = true;
                    return;
                }
                return;
        }
    }
}
