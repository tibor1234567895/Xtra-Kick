package t6;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.SeekBar;
import hb.h0;
import j3.w0;
import xa.j;

public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14655h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ w0 f14656i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ t0 f14657j;

    public /* synthetic */ q0(w0 w0Var, t0 t0Var, int i10) {
        this.f14655h = i10;
        this.f14656i = w0Var;
        this.f14657j = t0Var;
    }

    public final void onClick(View view) {
        int i10 = this.f14655h;
        t0 t0Var = this.f14657j;
        w0 w0Var = this.f14656i;
        switch (i10) {
            case 0:
                r0 r0Var = t0.f14661x0;
                j.f("$this_with", w0Var);
                j.f("this$0", t0Var);
                ((SeekBar) w0Var.f8715b).setProgress(100);
                SharedPreferences.Editor edit = h0.l1(t0Var.f0()).edit();
                j.e("editor", edit);
                edit.putInt("player_volume", 100);
                edit.apply();
                return;
            default:
                r0 r0Var2 = t0.f14661x0;
                j.f("$this_with", w0Var);
                j.f("this$0", t0Var);
                ((SeekBar) w0Var.f8715b).setProgress(0);
                SharedPreferences.Editor edit2 = h0.l1(t0Var.f0()).edit();
                j.e("editor", edit2);
                edit2.putInt("player_volume", 0);
                edit2.apply();
                return;
        }
    }
}
