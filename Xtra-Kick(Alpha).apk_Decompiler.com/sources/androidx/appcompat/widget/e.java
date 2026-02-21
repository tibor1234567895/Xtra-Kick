package androidx.appcompat.widget;

public final class e implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f806h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f807i;

    public /* synthetic */ e(ActionBarOverlayLayout actionBarOverlayLayout, int i10) {
        this.f806h = i10;
        this.f807i = actionBarOverlayLayout;
    }

    public final void run() {
        int i10 = this.f806h;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f807i;
        switch (i10) {
            case 0:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.D = actionBarOverlayLayout.f607k.animate().translationY(0.0f).setListener(actionBarOverlayLayout.E);
                return;
            default:
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.D = actionBarOverlayLayout.f607k.animate().translationY((float) (-actionBarOverlayLayout.f607k.getHeight())).setListener(actionBarOverlayLayout.E);
                return;
        }
    }
}
