package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

public final class j4 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SearchView.SearchAutoComplete f900h;

    public j4(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f900h = searchAutoComplete;
    }

    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f900h;
        if (searchAutoComplete.f663n) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f663n = false;
        }
    }
}
