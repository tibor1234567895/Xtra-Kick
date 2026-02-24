package y8;

import android.widget.AutoCompleteTextView;

public final /* synthetic */ class j implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f17138a;

    public /* synthetic */ j(k kVar) {
        this.f17138a = kVar;
    }

    public final void onDismiss() {
        k kVar = this.f17138a;
        kVar.f17147m = true;
        kVar.f17149o = System.currentTimeMillis();
        kVar.t(false);
    }
}
