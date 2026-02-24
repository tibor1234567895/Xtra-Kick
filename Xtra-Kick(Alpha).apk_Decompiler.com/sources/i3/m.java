package i3;

import android.view.View;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n f8142h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f8143i;

    public /* synthetic */ m(n nVar, int i10) {
        this.f8142h = nVar;
        this.f8143i = i10;
    }

    public final void onClick(View view) {
        n nVar = this.f8142h;
        int i10 = nVar.f8146c;
        int i11 = this.f8143i;
        w wVar = nVar.f8147d;
        if (i11 != i10) {
            wVar.setPlaybackSpeed(nVar.f8145b[i11]);
        }
        wVar.f8206r.dismiss();
    }
}
