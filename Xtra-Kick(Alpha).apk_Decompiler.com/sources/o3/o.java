package o3;

import android.content.DialogInterface;

public final class o implements DialogInterface.OnMultiChoiceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p f12165a;

    public o(p pVar) {
        this.f12165a = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i10, boolean z10) {
        boolean z11;
        boolean z12;
        p pVar = this.f12165a;
        if (z10) {
            z11 = pVar.C0;
            z12 = pVar.B0.add(pVar.E0[i10].toString());
        } else {
            z11 = pVar.C0;
            z12 = pVar.B0.remove(pVar.E0[i10].toString());
        }
        pVar.C0 = z12 | z11;
    }
}
