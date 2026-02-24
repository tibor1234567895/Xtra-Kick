package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;

public final class a4 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchView f727a;

    public a4(SearchView searchView) {
        this.f727a = searchView;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        this.f727a.s();
        return true;
    }
}
