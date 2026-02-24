package y8;

import android.view.View;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17122a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f17123b;

    public /* synthetic */ b(o oVar, int i10) {
        this.f17122a = i10;
        this.f17123b = oVar;
    }

    public final void onFocusChange(View view, boolean z10) {
        int i10 = this.f17122a;
        o oVar = this.f17123b;
        switch (i10) {
            case 0:
                d dVar = (d) oVar;
                dVar.t(dVar.u());
                return;
            default:
                k kVar = (k) oVar;
                kVar.f17146l = z10;
                kVar.q();
                if (!z10) {
                    kVar.t(false);
                    kVar.f17147m = false;
                    return;
                }
                return;
        }
    }
}
