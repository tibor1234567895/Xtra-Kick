package m;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;

public final class j extends BaseAdapter {

    /* renamed from: h  reason: collision with root package name */
    public int f9957h = -1;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ k f9958i;

    public j(k kVar) {
        this.f9958i = kVar;
        a();
    }

    public final void a() {
        o oVar = this.f9958i.f9961j;
        q qVar = oVar.f9993v;
        if (qVar != null) {
            oVar.i();
            ArrayList arrayList = oVar.f9981j;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((q) arrayList.get(i10)) == qVar) {
                    this.f9957h = i10;
                    return;
                }
            }
        }
        this.f9957h = -1;
    }

    /* renamed from: b */
    public final q getItem(int i10) {
        k kVar = this.f9958i;
        o oVar = kVar.f9961j;
        oVar.i();
        ArrayList arrayList = oVar.f9981j;
        kVar.getClass();
        int i11 = i10 + 0;
        int i12 = this.f9957h;
        if (i12 >= 0 && i11 >= i12) {
            i11++;
        }
        return (q) arrayList.get(i11);
    }

    public final int getCount() {
        k kVar = this.f9958i;
        o oVar = kVar.f9961j;
        oVar.i();
        int size = oVar.f9981j.size();
        kVar.getClass();
        int i10 = size + 0;
        if (this.f9957h < 0) {
            return i10;
        }
        return i10 - 1;
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f9958i.f9960i.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((d0) view).b(getItem(i10));
        return view;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
