package t6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.c0;
import com.woxthebox.draglistview.R;
import e4.a;
import j3.w0;
import l6.n;
import o3.n0;
import xa.j;

public final class t0 extends n {

    /* renamed from: x0  reason: collision with root package name */
    public static final r0 f14661x0 = new r0(0);

    /* renamed from: v0  reason: collision with root package name */
    public w0 f14662v0;

    /* renamed from: w0  reason: collision with root package name */
    public s0 f14663w0;

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.player.PlayerVolumeDialog.PlayerVolumeListener", c0Var);
        this.f14663w0 = (s0) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        j.f("inflater", layoutInflater);
        View inflate = layoutInflater.inflate(R.layout.player_volume, viewGroup, false);
        int i10 = R.id.volumeBar;
        SeekBar seekBar = (SeekBar) a.a(inflate, R.id.volumeBar);
        if (seekBar != null) {
            i10 = R.id.volumeMute;
            ImageButton imageButton = (ImageButton) a.a(inflate, R.id.volumeMute);
            if (imageButton != null) {
                i10 = R.id.volumeText;
                TextView textView = (TextView) a.a(inflate, R.id.volumeText);
                if (textView != null) {
                    i10 = R.id.volumeText1;
                    LinearLayout linearLayout = (LinearLayout) a.a(inflate, R.id.volumeText1);
                    if (linearLayout != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) inflate;
                        this.f14662v0 = new w0(relativeLayout, seekBar, imageButton, textView, linearLayout, 5);
                        j.e("binding.root", relativeLayout);
                        return relativeLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f14662v0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        j.f("view", view);
        w0 w0Var = this.f14662v0;
        j.c(w0Var);
        int i10 = (int) (e0().getFloat("volume", 1.0f) * ((float) 100));
        r0(i10);
        Object obj = w0Var.f8715b;
        ((SeekBar) obj).setProgress(i10);
        ((SeekBar) obj).setOnSeekBarChangeListener(new n0(1, this));
    }

    public final void r0(int i10) {
        ImageButton imageButton;
        q0 q0Var;
        w0 w0Var = this.f14662v0;
        j.c(w0Var);
        ((TextView) w0Var.f8717d).setText(String.valueOf(i10));
        if (i10 == 0) {
            ((ImageButton) w0Var.f8716c).setImageResource(R.drawable.baseline_volume_off_black_24);
            imageButton = (ImageButton) w0Var.f8716c;
            q0Var = new q0(w0Var, this, 0);
        } else {
            ((ImageButton) w0Var.f8716c).setImageResource(R.drawable.baseline_volume_up_black_24);
            imageButton = (ImageButton) w0Var.f8716c;
            q0Var = new q0(w0Var, this, 1);
        }
        imageButton.setOnClickListener(q0Var);
    }
}
