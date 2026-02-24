package g;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.d1;
import androidx.appcompat.widget.h1;

public final class g implements AdapterView.OnItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f6070h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f6071i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f6072j;

    public /* synthetic */ g(Object obj, int i10, Object obj2) {
        this.f6070h = i10;
        this.f6072j = obj;
        this.f6071i = obj2;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        int i11 = this.f6070h;
        Object obj = this.f6072j;
        switch (i11) {
            case 0:
                i iVar = (i) obj;
                DialogInterface.OnClickListener onClickListener = iVar.f6097q;
                k kVar = (k) this.f6071i;
                onClickListener.onClick(kVar.f6122b, i10);
                if (!iVar.f6101u) {
                    kVar.f6122b.dismiss();
                    return;
                }
                return;
            default:
                d1 d1Var = (d1) obj;
                d1Var.O.setSelection(i10);
                h1 h1Var = d1Var.O;
                if (h1Var.getOnItemClickListener() != null) {
                    h1Var.performItemClick(view, i10, d1Var.L.getItemId(i10));
                }
                d1Var.dismiss();
                return;
        }
    }
}
