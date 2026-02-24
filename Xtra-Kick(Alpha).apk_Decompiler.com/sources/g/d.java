package g;

import android.view.View;

public final class d implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6054h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f6055i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ View f6056j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ k f6057k;

    public /* synthetic */ d(k kVar, View view, View view2, int i10) {
        this.f6054h = i10;
        this.f6057k = kVar;
        this.f6055i = view;
        this.f6056j = view2;
    }

    public final void run() {
        int i10 = this.f6054h;
        View view = this.f6056j;
        View view2 = this.f6055i;
        k kVar = this.f6057k;
        switch (i10) {
            case 0:
                k.b(kVar.f6143w, view2, view);
                return;
            default:
                k.b(kVar.f6127g, view2, view);
                return;
        }
    }
}
