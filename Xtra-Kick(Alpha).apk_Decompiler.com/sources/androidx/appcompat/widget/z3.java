package androidx.appcompat.widget;

import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

public final class z3 implements View.OnKeyListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SearchView f1153h;

    public z3(SearchView searchView) {
        this.f1153h = searchView;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        boolean z10;
        int i11;
        SearchView searchView = this.f1153h;
        if (searchView.f652k0 == null) {
            return false;
        }
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f657w;
        if (!searchAutoComplete.isPopupShowing() || searchAutoComplete.getListSelection() == -1) {
            if (TextUtils.getTrimmedLength(searchAutoComplete.getText()) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i10 != 66) {
                return false;
            }
            view.cancelLongPress();
            searchView.getContext().startActivity(searchView.l("android.intent.action.SEARCH", (Uri) null, (String) null, searchAutoComplete.getText().toString()));
            return true;
        } else if (searchView.f652k0 == null || searchView.W == null || keyEvent.getAction() != 0 || !keyEvent.hasNoModifiers()) {
            return false;
        } else {
            if (i10 == 66 || i10 == 84 || i10 == 61) {
                searchView.p(searchAutoComplete.getListSelection());
            } else if (i10 == 21 || i10 == 22) {
                if (i10 == 21) {
                    i11 = 0;
                } else {
                    i11 = searchAutoComplete.length();
                }
                searchAutoComplete.setSelection(i11);
                searchAutoComplete.setListSelection(0);
                searchAutoComplete.clearListSelection();
                searchAutoComplete.a();
            } else if (i10 != 19) {
                return false;
            } else {
                searchAutoComplete.getListSelection();
                return false;
            }
            return true;
        }
    }
}
