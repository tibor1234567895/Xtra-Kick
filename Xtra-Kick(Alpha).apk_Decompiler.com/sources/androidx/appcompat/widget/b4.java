package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import y8.t;

public final class b4 implements AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f770h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f771i;

    public /* synthetic */ b4(View view, int i10) {
        this.f770h = i10;
        this.f771i = view;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        Object obj;
        int i11 = this.f770h;
        View view2 = this.f771i;
        switch (i11) {
            case 0:
                ((SearchView) view2).p(i10);
                return;
            default:
                t tVar = (t) view2;
                View view3 = null;
                if (i10 < 0) {
                    b3 b3Var = tVar.f17212l;
                    if (!b3Var.b()) {
                        obj = null;
                    } else {
                        obj = b3Var.f753j.getSelectedItem();
                    }
                } else {
                    obj = tVar.getAdapter().getItem(i10);
                }
                t.a(tVar, obj);
                AdapterView.OnItemClickListener onItemClickListener = tVar.getOnItemClickListener();
                b3 b3Var2 = tVar.f17212l;
                if (onItemClickListener != null) {
                    if (view == null || i10 < 0) {
                        if (b3Var2.b()) {
                            view3 = b3Var2.f753j.getSelectedView();
                        }
                        view = view3;
                        if (!b3Var2.b()) {
                            i10 = -1;
                        } else {
                            i10 = b3Var2.f753j.getSelectedItemPosition();
                        }
                        if (!b3Var2.b()) {
                            j10 = Long.MIN_VALUE;
                        } else {
                            j10 = b3Var2.f753j.getSelectedItemId();
                        }
                    }
                    onItemClickListener.onItemClick(b3Var2.f753j, view, i10, j10);
                }
                b3Var2.dismiss();
                return;
        }
    }
}
