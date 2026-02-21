package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

public final class q implements DialogInterface.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ t f1549h;

    public q(t tVar) {
        this.f1549h = tVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        t tVar = this.f1549h;
        Dialog dialog = tVar.f1574o0;
        if (dialog != null) {
            tVar.onDismiss(dialog);
        }
    }
}
