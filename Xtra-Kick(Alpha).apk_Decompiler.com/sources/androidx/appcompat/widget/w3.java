package androidx.appcompat.widget;

import android.view.View;

public final class w3 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f1119a;

    public w3(SearchView searchView) {
        this.f1119a = searchView;
    }

    public final void onFocusChange(View view, boolean z10) {
        SearchView searchView = this.f1119a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.S;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z10);
        }
    }
}
