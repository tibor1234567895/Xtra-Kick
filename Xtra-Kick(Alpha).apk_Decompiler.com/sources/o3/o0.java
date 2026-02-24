package o3;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import androidx.preference.SeekBarPreference;

public final class o0 implements View.OnKeyListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SeekBarPreference f12166h;

    public o0(SeekBarPreference seekBarPreference) {
        this.f12166h = seekBarPreference;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        SeekBarPreference seekBarPreference = this.f12166h;
        if ((!seekBarPreference.f1908b0 && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
            return false;
        }
        SeekBar seekBar = seekBarPreference.Z;
        if (seekBar != null) {
            return seekBar.onKeyDown(i10, keyEvent);
        }
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
        return false;
    }
}
