package o3;

import android.content.DialogInterface;

public final class k implements DialogInterface.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f12140h;

    public k(l lVar) {
        this.f12140h = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i10) {
        l lVar = this.f12140h;
        lVar.B0 = i10;
        lVar.onClick(dialogInterface, -1);
        dialogInterface.dismiss();
    }
}
