package g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

public final class f extends ArrayAdapter {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f6065h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f6066i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(i iVar, Context context, int i10, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(context, i10, 16908308, charSequenceArr);
        this.f6066i = iVar;
        this.f6065h = alertController$RecycleListView;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i10, view, viewGroup);
        boolean[] zArr = this.f6066i.f6099s;
        if (zArr != null && zArr[i10]) {
            this.f6065h.setItemChecked(i10, true);
        }
        return view2;
    }
}
