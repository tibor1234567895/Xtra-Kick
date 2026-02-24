package b2;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import j1.l0;
import p0.c;

public final class r implements p, DisplayManager.DisplayListener {

    /* renamed from: a  reason: collision with root package name */
    public final DisplayManager f2477a;

    /* renamed from: b  reason: collision with root package name */
    public c f2478b;

    public r(DisplayManager displayManager) {
        this.f2477a = displayManager;
    }

    public final void a() {
        this.f2477a.unregisterDisplayListener(this);
        this.f2478b = null;
    }

    public final void b(c cVar) {
        this.f2478b = cVar;
        Handler k10 = l0.k((Handler.Callback) null);
        DisplayManager displayManager = this.f2477a;
        displayManager.registerDisplayListener(this, k10);
        cVar.l(displayManager.getDisplay(0));
    }

    public final void onDisplayAdded(int i10) {
    }

    public final void onDisplayChanged(int i10) {
        c cVar = this.f2478b;
        if (cVar != null && i10 == 0) {
            cVar.l(this.f2477a.getDisplay(0));
        }
    }

    public final void onDisplayRemoved(int i10) {
    }
}
