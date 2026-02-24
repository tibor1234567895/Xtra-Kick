package o3;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.preference.ListPreference;
import g.i;

public class l extends x {
    public int B0;
    public CharSequence[] C0;
    public CharSequence[] D0;

    public final void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            ListPreference listPreference = (ListPreference) r0();
            if (listPreference.f1879a0 == null || listPreference.f1880b0 == null) {
                throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
            }
            this.B0 = listPreference.y(listPreference.f1881c0);
            this.C0 = listPreference.f1879a0;
            this.D0 = listPreference.f1880b0;
            return;
        }
        this.B0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
        this.C0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
        this.D0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
    }

    public final void W(Bundle bundle) {
        super.W(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.B0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.C0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.D0);
    }

    public final void t0(boolean z10) {
        int i10;
        if (z10 && (i10 = this.B0) >= 0) {
            String charSequence = this.D0[i10].toString();
            ListPreference listPreference = (ListPreference) r0();
            listPreference.a(charSequence);
            listPreference.B(charSequence);
        }
    }

    public final void u0(g.l lVar) {
        CharSequence[] charSequenceArr = this.C0;
        int i10 = this.B0;
        k kVar = new k(this);
        i iVar = lVar.f6176a;
        iVar.f6095o = charSequenceArr;
        iVar.f6097q = kVar;
        iVar.f6102v = i10;
        iVar.f6101u = true;
        lVar.b((CharSequence) null, (DialogInterface.OnClickListener) null);
    }
}
