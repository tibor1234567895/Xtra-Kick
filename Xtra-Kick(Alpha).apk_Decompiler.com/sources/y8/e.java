package y8;

import android.view.View;
import com.google.android.material.internal.CheckableImageButton;

public final class e extends o {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f17135e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(n nVar, int i10) {
        super(nVar);
        this.f17135e = i10;
    }

    public final void r() {
        switch (this.f17135e) {
            case 0:
                n nVar = this.f17175b;
                nVar.f17169v = null;
                CheckableImageButton checkableImageButton = nVar.f17161n;
                checkableImageButton.setOnLongClickListener((View.OnLongClickListener) null);
                p.e(checkableImageButton, (View.OnLongClickListener) null);
                return;
            default:
                return;
        }
    }
}
