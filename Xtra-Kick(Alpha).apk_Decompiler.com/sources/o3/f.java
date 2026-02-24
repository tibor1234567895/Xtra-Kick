package o3;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.activity.h;
import androidx.preference.EditTextPreference;

public class f extends x {
    public EditText B0;
    public CharSequence C0;
    public final h D0 = new h(8, this);
    public long E0 = -1;

    public final void N(Bundle bundle) {
        CharSequence charSequence;
        super.N(bundle);
        if (bundle == null) {
            charSequence = ((EditTextPreference) r0()).f1878a0;
        } else {
            charSequence = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
        this.C0 = charSequence;
    }

    public final void W(Bundle bundle) {
        super.W(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.C0);
    }

    public final void s0(View view) {
        super.s0(view);
        EditText editText = (EditText) view.findViewById(16908291);
        this.B0 = editText;
        if (editText != null) {
            editText.requestFocus();
            this.B0.setText(this.C0);
            EditText editText2 = this.B0;
            editText2.setSelection(editText2.getText().length());
            ((EditTextPreference) r0()).getClass();
            return;
        }
        throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
    }

    public final void t0(boolean z10) {
        if (z10) {
            String obj = this.B0.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) r0();
            editTextPreference.a(obj);
            editTextPreference.y(obj);
        }
    }

    public final void v0() {
        this.E0 = SystemClock.currentThreadTimeMillis();
        w0();
    }

    public final void w0() {
        boolean z10;
        long j10 = this.E0;
        if (j10 == -1 || j10 + 1000 <= SystemClock.currentThreadTimeMillis()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            EditText editText = this.B0;
            if (editText == null || !editText.isFocused() || ((InputMethodManager) this.B0.getContext().getSystemService("input_method")).showSoftInput(this.B0, 0)) {
                this.E0 = -1;
                return;
            }
            EditText editText2 = this.B0;
            h hVar = this.D0;
            editText2.removeCallbacks(hVar);
            this.B0.postDelayed(hVar, 50);
        }
    }
}
