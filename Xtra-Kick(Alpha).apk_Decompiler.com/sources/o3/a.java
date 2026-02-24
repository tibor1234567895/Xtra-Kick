package o3;

import android.widget.CompoundButton;
import androidx.preference.CheckBoxPreference;
import androidx.preference.SwitchPreference;
import androidx.preference.SwitchPreferenceCompat;
import androidx.preference.TwoStatePreference;

public final class a implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f12105a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TwoStatePreference f12106b;

    public /* synthetic */ a(TwoStatePreference twoStatePreference, int i10) {
        this.f12105a = i10;
        this.f12106b = twoStatePreference;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        int i10 = this.f12105a;
        TwoStatePreference twoStatePreference = this.f12106b;
        switch (i10) {
            case 0:
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) twoStatePreference;
                checkBoxPreference.a(Boolean.valueOf(z10));
                checkBoxPreference.y(z10);
                return;
            case 1:
                SwitchPreference switchPreference = (SwitchPreference) twoStatePreference;
                switchPreference.a(Boolean.valueOf(z10));
                switchPreference.y(z10);
                return;
            default:
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) twoStatePreference;
                switchPreferenceCompat.a(Boolean.valueOf(z10));
                switchPreferenceCompat.y(z10);
                return;
        }
    }
}
