package m;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

public final class l extends BaseAdapter {

    /* renamed from: h  reason: collision with root package name */
    public final o f9965h;

    /* renamed from: i  reason: collision with root package name */
    public int f9966i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f9967j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f9968k;

    /* renamed from: l  reason: collision with root package name */
    public final LayoutInflater f9969l;

    /* renamed from: m  reason: collision with root package name */
    public final int f9970m;

    public l(o oVar, LayoutInflater layoutInflater, boolean z10, int i10) {
        this.f9968k = z10;
        this.f9969l = layoutInflater;
        this.f9965h = oVar;
        this.f9970m = i10;
        a();
    }

    public final void a() {
        o oVar = this.f9965h;
        q qVar = oVar.f9993v;
        if (qVar != null) {
            oVar.i();
            ArrayList arrayList = oVar.f9981j;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((q) arrayList.get(i10)) == qVar) {
                    this.f9966i = i10;
                    return;
                }
            }
        }
        this.f9966i = -1;
    }

    /* renamed from: b */
    public final q getItem(int i10) {
        ArrayList arrayList;
        boolean z10 = this.f9968k;
        o oVar = this.f9965h;
        if (z10) {
            oVar.i();
            arrayList = oVar.f9981j;
        } else {
            arrayList = oVar.l();
        }
        int i11 = this.f9966i;
        if (i11 >= 0 && i10 >= i11) {
            i10++;
        }
        return (q) arrayList.get(i10);
    }

    public final int getCount() {
        ArrayList arrayList;
        boolean z10 = this.f9968k;
        o oVar = this.f9965h;
        if (z10) {
            oVar.i();
            arrayList = oVar.f9981j;
        } else {
            arrayList = oVar.l();
        }
        int i10 = this.f9966i;
        int size = arrayList.size();
        if (i10 < 0) {
            return size;
        }
        return size - 1;
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        boolean z10 = false;
        if (view == null) {
            view = this.f9969l.inflate(this.f9970m, viewGroup, false);
        }
        int i12 = getItem(i10).f10000b;
        int i13 = i10 - 1;
        if (i13 >= 0) {
            i11 = getItem(i13).f10000b;
        } else {
            i11 = i12;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f9965h.m() && i12 != i11) {
            z10 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z10);
        d0 d0Var = (d0) view;
        if (this.f9967j) {
            listMenuItemView.setForceShowIcon(true);
        }
        d0Var.b(getItem(i10));
        return view;
    }

    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
