package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;

public final class p implements DialogInterface.OnCancelListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ t f1530h;

    public p(t tVar) {
        this.f1530h = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        t tVar = this.f1530h;
        Dialog dialog = tVar.f1574o0;
        if (dialog != null) {
            tVar.onCancel(dialog);
        }
    }
}
