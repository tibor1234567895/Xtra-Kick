package g;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

public final class h implements AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f6076h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k f6077i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ i f6078j;

    public h(i iVar, AlertController$RecycleListView alertController$RecycleListView, k kVar) {
        this.f6078j = iVar;
        this.f6076h = alertController$RecycleListView;
        this.f6077i = kVar;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        i iVar = this.f6078j;
        boolean[] zArr = iVar.f6099s;
        AlertController$RecycleListView alertController$RecycleListView = this.f6076h;
        if (zArr != null) {
            zArr[i10] = alertController$RecycleListView.isItemChecked(i10);
        }
        iVar.f6103w.onClick(this.f6077i.f6122b, i10, alertController$RecycleListView.isItemChecked(i10));
    }
}
