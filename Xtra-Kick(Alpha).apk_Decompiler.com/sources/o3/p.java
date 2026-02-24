package o3;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import g.i;
import g.l;
import java.util.ArrayList;
import java.util.HashSet;

public class p extends x {
    public final HashSet B0 = new HashSet();
    public boolean C0;
    public CharSequence[] D0;
    public CharSequence[] E0;

    public final void N(Bundle bundle) {
        CharSequence[] charSequenceArr;
        super.N(bundle);
        HashSet hashSet = this.B0;
        if (bundle == null) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) r0();
            if (multiSelectListPreference.f1884a0 == null || (charSequenceArr = multiSelectListPreference.f1885b0) == null) {
                throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
            }
            hashSet.clear();
            hashSet.addAll(multiSelectListPreference.f1886c0);
            this.C0 = false;
            this.D0 = multiSelectListPreference.f1884a0;
            this.E0 = charSequenceArr;
            return;
        }
        hashSet.clear();
        hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
        this.C0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
        this.D0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
        this.E0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
    }

    public final void W(Bundle bundle) {
        super.W(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.B0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.C0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.D0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.E0);
    }

    public final void t0(boolean z10) {
        if (z10 && this.C0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) r0();
            HashSet hashSet = this.B0;
            multiSelectListPreference.a(hashSet);
            multiSelectListPreference.y(hashSet);
        }
        this.C0 = false;
    }

    public final void u0(l lVar) {
        int length = this.E0.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = this.B0.contains(this.E0[i10].toString());
        }
        CharSequence[] charSequenceArr = this.D0;
        o oVar = new o(this);
        i iVar = lVar.f6176a;
        iVar.f6095o = charSequenceArr;
        iVar.f6103w = oVar;
        iVar.f6099s = zArr;
        iVar.f6100t = true;
    }
}
