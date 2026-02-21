package androidx.appcompat.widget;

import android.database.DataSetObserver;
import com.google.android.material.tabs.TabLayout;
import r0.b;

public final class y2 extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1130a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1131b;

    public /* synthetic */ y2(int i10, Object obj) {
        this.f1130a = i10;
        this.f1131b = obj;
    }

    public final void onChanged() {
        int i10 = this.f1130a;
        Object obj = this.f1131b;
        switch (i10) {
            case 0:
                b3 b3Var = (b3) obj;
                if (b3Var.b()) {
                    b3Var.d();
                    return;
                }
                return;
            case 1:
                b bVar = (b) obj;
                bVar.f13521h = true;
                bVar.notifyDataSetChanged();
                return;
            default:
                ((TabLayout) obj).g();
                return;
        }
    }

    public final void onInvalidated() {
        int i10 = this.f1130a;
        Object obj = this.f1131b;
        switch (i10) {
            case 0:
                ((b3) obj).dismiss();
                return;
            case 1:
                b bVar = (b) obj;
                bVar.f13521h = false;
                bVar.notifyDataSetInvalidated();
                return;
            default:
                ((TabLayout) obj).g();
                return;
        }
    }
}
