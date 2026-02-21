package o3;

import android.content.SharedPreferences;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.SeekBarPreference;
import h3.b0;
import hb.h0;
import t6.l;
import t6.s0;
import t6.t0;
import xa.j;

public final class n0 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f12163a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f12164b;

    public /* synthetic */ n0(int i10, Object obj) {
        this.f12163a = i10;
        this.f12164b = obj;
    }

    public final void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        int i11 = this.f12163a;
        Object obj = this.f12164b;
        switch (i11) {
            case 0:
                if (z10) {
                    SeekBarPreference seekBarPreference = (SeekBarPreference) obj;
                    if (seekBarPreference.f1910d0 || !seekBarPreference.Y) {
                        seekBarPreference.z(seekBar);
                        return;
                    }
                }
                SeekBarPreference seekBarPreference2 = (SeekBarPreference) obj;
                int i12 = i10 + seekBarPreference2.V;
                TextView textView = seekBarPreference2.f1907a0;
                if (textView != null) {
                    textView.setText(String.valueOf(i12));
                    return;
                }
                return;
            default:
                j.f("seekBar", seekBar);
                t0 t0Var = (t0) obj;
                s0 s0Var = t0Var.f14663w0;
                if (s0Var != null) {
                    float f10 = ((float) i10) / 100.0f;
                    b0 s02 = ((l) s0Var).s0();
                    if (s02 != null) {
                        s02.B0(f10);
                    }
                    t0Var.r0(i10);
                    return;
                }
                j.l("listener");
                throw null;
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        switch (this.f12163a) {
            case 0:
                ((SeekBarPreference) this.f12164b).Y = true;
                return;
            default:
                j.f("seekBar", seekBar);
                return;
        }
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        int i10 = this.f12163a;
        Object obj = this.f12164b;
        switch (i10) {
            case 0:
                SeekBarPreference seekBarPreference = (SeekBarPreference) obj;
                seekBarPreference.Y = false;
                if (seekBar.getProgress() + seekBarPreference.V != seekBarPreference.U) {
                    seekBarPreference.z(seekBar);
                    return;
                }
                return;
            default:
                j.f("seekBar", seekBar);
                SharedPreferences.Editor edit = h0.l1(((t0) obj).f0()).edit();
                j.e("editor", edit);
                edit.putInt("player_volume", seekBar.getProgress());
                edit.apply();
                return;
        }
    }
}
