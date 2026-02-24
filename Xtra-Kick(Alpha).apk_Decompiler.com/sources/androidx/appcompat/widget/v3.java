package androidx.appcompat.widget;

import android.database.Cursor;
import r0.b;

public final class v3 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1107h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SearchView f1108i;

    public /* synthetic */ v3(SearchView searchView, int i10) {
        this.f1107h = i10;
        this.f1108i = searchView;
    }

    public final void run() {
        int i10 = this.f1107h;
        SearchView searchView = this.f1108i;
        switch (i10) {
            case 0:
                searchView.u();
                return;
            default:
                b bVar = searchView.W;
                if (bVar instanceof m4) {
                    bVar.b((Cursor) null);
                    return;
                }
                return;
        }
    }
}
