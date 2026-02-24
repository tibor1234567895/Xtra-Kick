package l6;

import android.graphics.drawable.Drawable;
import c4.f;

public final class j implements Drawable.Callback {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9616h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f9617i;

    public /* synthetic */ j(int i10, Object obj) {
        this.f9616h = i10;
        this.f9617i = obj;
    }

    public final void invalidateDrawable(Drawable drawable) {
        int i10 = this.f9616h;
        Object obj = this.f9617i;
        switch (i10) {
            case 0:
                xa.j.f("who", drawable);
                ((h) obj).f9606h.invalidate();
                return;
            case 1:
                xa.j.f("who", drawable);
                ((h) obj).f9606h.invalidate();
                return;
            default:
                ((f) obj).invalidateSelf();
                return;
        }
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        int i10 = this.f9616h;
        Object obj = this.f9617i;
        switch (i10) {
            case 0:
                xa.j.f("who", drawable);
                xa.j.f("what", runnable);
                ((h) obj).f9606h.postDelayed(runnable, j10);
                return;
            case 1:
                xa.j.f("who", drawable);
                xa.j.f("what", runnable);
                ((h) obj).f9606h.postDelayed(runnable, j10);
                return;
            default:
                ((f) obj).scheduleSelf(runnable, j10);
                return;
        }
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        int i10 = this.f9616h;
        Object obj = this.f9617i;
        switch (i10) {
            case 0:
                xa.j.f("who", drawable);
                xa.j.f("what", runnable);
                ((h) obj).f9606h.removeCallbacks(runnable);
                return;
            case 1:
                xa.j.f("who", drawable);
                xa.j.f("what", runnable);
                ((h) obj).f9606h.removeCallbacks(runnable);
                return;
            default:
                ((f) obj).unscheduleSelf(runnable);
                return;
        }
    }
}
