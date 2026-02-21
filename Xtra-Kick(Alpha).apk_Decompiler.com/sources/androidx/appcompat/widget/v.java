package androidx.appcompat.widget;

import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;

public final class v extends DataSetObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1102a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f1103b;

    public /* synthetic */ v(z zVar, int i10) {
        this.f1102a = i10;
        this.f1103b = zVar;
    }

    public final void onChanged() {
        int size;
        switch (this.f1102a) {
            case 0:
                super.onChanged();
                this.f1103b.f1136h.notifyDataSetChanged();
                return;
            default:
                super.onChanged();
                z zVar = this.f1103b;
                if (zVar.f1136h.getCount() > 0) {
                    zVar.f1140l.setEnabled(true);
                } else {
                    zVar.f1140l.setEnabled(false);
                }
                int e10 = zVar.f1136h.f1121h.e();
                u uVar = zVar.f1136h.f1121h;
                synchronized (uVar.f1087a) {
                    uVar.b();
                    size = uVar.f1089c.size();
                }
                if (e10 == 1 || (e10 > 1 && size > 0)) {
                    zVar.f1142n.setVisibility(0);
                    zVar.f1136h.f1121h.f();
                    zVar.getContext().getPackageManager();
                    throw null;
                }
                zVar.f1142n.setVisibility(8);
                if (zVar.f1142n.getVisibility() == 0) {
                    zVar.f1138j.setBackgroundDrawable(zVar.f1139k);
                    return;
                } else {
                    zVar.f1138j.setBackgroundDrawable((Drawable) null);
                    return;
                }
        }
    }

    public final void onInvalidated() {
        switch (this.f1102a) {
            case 0:
                super.onInvalidated();
                this.f1103b.f1136h.notifyDataSetInvalidated();
                return;
            default:
                super.onInvalidated();
                return;
        }
    }
}
