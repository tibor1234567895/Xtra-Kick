package androidx.appcompat.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build;
import android.support.v4.media.v;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;

public final class b1 implements ListAdapter, SpinnerAdapter {

    /* renamed from: h  reason: collision with root package name */
    public final SpinnerAdapter f736h;

    /* renamed from: i  reason: collision with root package name */
    public final ListAdapter f737i;

    public b1(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        this.f736h = spinnerAdapter;
        if (spinnerAdapter instanceof ListAdapter) {
            this.f737i = (ListAdapter) spinnerAdapter;
        }
        if (theme != null && Build.VERSION.SDK_INT >= 23 && v.n(spinnerAdapter)) {
            z0.a(v.i(spinnerAdapter), theme);
        }
    }

    public final boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.f737i;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public final int getCount() {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter == null) {
            return 0;
        }
        return spinnerAdapter.getCount();
    }

    public final View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getDropDownView(i10, view, viewGroup);
    }

    public final Object getItem(int i10) {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter == null) {
            return null;
        }
        return spinnerAdapter.getItem(i10);
    }

    public final long getItemId(int i10) {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter == null) {
            return -1;
        }
        return spinnerAdapter.getItemId(i10);
    }

    public final int getItemViewType(int i10) {
        return 0;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        return getDropDownView(i10, view, viewGroup);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final boolean hasStableIds() {
        SpinnerAdapter spinnerAdapter = this.f736h;
        return spinnerAdapter != null && spinnerAdapter.hasStableIds();
    }

    public final boolean isEmpty() {
        return getCount() == 0;
    }

    public final boolean isEnabled(int i10) {
        ListAdapter listAdapter = this.f737i;
        if (listAdapter != null) {
            return listAdapter.isEnabled(i10);
        }
        return true;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.f736h;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}
