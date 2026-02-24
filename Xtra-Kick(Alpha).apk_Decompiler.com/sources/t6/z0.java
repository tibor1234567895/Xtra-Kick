package t6;

import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import androidx.fragment.app.t;
import com.github.andreyasadchy.xtra.util.AdminReceiver;
import com.woxthebox.draglistview.R;
import e4.a;
import g.i;
import g.l;
import g.m;
import h6.b;
import hb.h0;
import l.h;
import n3.t0;
import xa.j;

public final class z0 extends t {

    /* renamed from: v0  reason: collision with root package name */
    public static final x0 f14677v0 = new x0(0);

    /* renamed from: t0  reason: collision with root package name */
    public h f14678t0;

    /* renamed from: u0  reason: collision with root package name */
    public y0 f14679u0;

    public final void J() {
        this.K = true;
        h hVar = this.f14678t0;
        j.c(hVar);
        NumberPicker numberPicker = (NumberPicker) hVar.f9448j;
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(23);
        NumberPicker numberPicker2 = (NumberPicker) hVar.f9450l;
        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(59);
        long j10 = e0().getLong("timeLeft");
        if (j10 < 0) {
            ((NumberPicker) hVar.f9450l).setValue(15);
        } else {
            long j11 = j10 / 3600000;
            h hVar2 = this.f14678t0;
            j.c(hVar2);
            ((NumberPicker) hVar2.f9448j).setValue((int) j11);
            ((NumberPicker) hVar.f9450l).setValue((int) ((j10 - (j11 * 3600000)) / 60000));
        }
        ComponentName componentName = new ComponentName(f0(), AdminReceiver.class);
        Object systemService = f0().getSystemService("device_policy");
        j.d("null cannot be cast to non-null type android.app.admin.DevicePolicyManager", systemService);
        if (((DevicePolicyManager) systemService).isAdminActive(componentName)) {
            CheckBox checkBox = (CheckBox) hVar.f9449k;
            checkBox.setChecked(h0.l1(f0()).getBoolean("sleep_timer_lock", true));
            checkBox.setText(checkBox.getContext().getString(R.string.sleep_timer_lock));
            return;
        }
        CheckBox checkBox2 = (CheckBox) hVar.f9449k;
        checkBox2.setChecked(false);
        checkBox2.setText(checkBox2.getContext().getString(R.string.sleep_timer_lock_permissions));
        checkBox2.setOnClickListener(new b(componentName, 9, this));
    }

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.player.SleepTimerDialog.OnSleepTimerStartedListener", c0Var);
        this.f14679u0 = (y0) c0Var;
    }

    public final void Q() {
        super.Q();
        this.f14678t0 = null;
    }

    public final Dialog n0(Bundle bundle) {
        NestedScrollView nestedScrollView;
        LayoutInflater layoutInflater = this.R;
        if (layoutInflater == null) {
            layoutInflater = c0((Bundle) null);
        }
        View inflate = layoutInflater.inflate(R.layout.dialog_sleep_timer, (ViewGroup) null, false);
        int i10 = R.id.hours;
        NumberPicker numberPicker = (NumberPicker) a.a(inflate, R.id.hours);
        if (numberPicker != null) {
            i10 = R.id.lockCheckbox;
            CheckBox checkBox = (CheckBox) a.a(inflate, R.id.lockCheckbox);
            if (checkBox != null) {
                i10 = R.id.minutes;
                NumberPicker numberPicker2 = (NumberPicker) a.a(inflate, R.id.minutes);
                if (numberPicker2 != null) {
                    this.f14678t0 = new h((NestedScrollView) inflate, numberPicker, checkBox, numberPicker2, 5);
                    l title = new l(f0()).setTitle(z(R.string.sleep_timer));
                    h hVar = this.f14678t0;
                    j.c(hVar);
                    int i11 = hVar.f9446h;
                    Object obj = hVar.f9447i;
                    switch (i11) {
                        case Constants.MAX_COMPATIBILITY_VERSION:
                            nestedScrollView = (NestedScrollView) obj;
                            break;
                        default:
                            nestedScrollView = (NestedScrollView) obj;
                            break;
                    }
                    l view = title.setView(nestedScrollView);
                    h hVar2 = this.f14678t0;
                    j.c(hVar2);
                    t0 t0Var = new t0(this, 1, hVar2);
                    if (e0().getLong("timeLeft") < 0) {
                        view.b(z(R.string.start), new u0(t0Var, 0));
                        view.setNegativeButton(17039360, new v0(this, 0));
                    } else {
                        view.b(z(R.string.set), new u0(t0Var, 1));
                        view.a(z(R.string.stop), new w0(this, hVar2, 0));
                        v0 v0Var = new v0(this, 1);
                        i iVar = view.f6176a;
                        iVar.f6091k = iVar.f6081a.getText(17039360);
                        iVar.f6092l = v0Var;
                    }
                    m create = view.create();
                    j.e("builder.create()", create);
                    return create;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }
}
