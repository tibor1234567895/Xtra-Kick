package y8;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.activity.e;
import com.woxthebox.draglistview.R;
import i3.i;
import n8.a;

public final class d extends o {

    /* renamed from: e  reason: collision with root package name */
    public final int f17126e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17127f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeInterpolator f17128g;

    /* renamed from: h  reason: collision with root package name */
    public final TimeInterpolator f17129h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f17130i;

    /* renamed from: j  reason: collision with root package name */
    public final i f17131j = new i(23, this);

    /* renamed from: k  reason: collision with root package name */
    public final b f17132k = new b(this, 0);

    /* renamed from: l  reason: collision with root package name */
    public AnimatorSet f17133l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f17134m;

    public d(n nVar) {
        super(nVar);
        this.f17126e = a.c(nVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f17127f = a.c(nVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f17128g = a.d(nVar.getContext(), R.attr.motionEasingLinearInterpolator, w7.a.f16153a);
        this.f17129h = a.d(nVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, w7.a.f16156d);
    }

    public final void a() {
        if (this.f17175b.f17170w == null) {
            t(u());
        }
    }

    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    public final View.OnFocusChangeListener e() {
        return this.f17132k;
    }

    public final View.OnClickListener f() {
        return this.f17131j;
    }

    public final View.OnFocusChangeListener g() {
        return this.f17132k;
    }

    public final void m(EditText editText) {
        this.f17130i = editText;
        this.f17174a.setEndIconVisible(u());
    }

    public final void p(boolean z10) {
        if (this.f17175b.f17170w != null) {
            t(z10);
        }
    }

    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(this.f17129h);
        ofFloat.setDuration((long) this.f17127f);
        ofFloat.addUpdateListener(new a(this, 0));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        TimeInterpolator timeInterpolator = this.f17128g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i10 = this.f17126e;
        ofFloat2.setDuration((long) i10);
        ofFloat2.addUpdateListener(new a(this, 1));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f17133l = animatorSet;
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        this.f17133l.addListener(new c(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration((long) i10);
        ofFloat3.addUpdateListener(new a(this, 1));
        this.f17134m = ofFloat3;
        ofFloat3.addListener(new c(this, 1));
    }

    public final void s() {
        EditText editText = this.f17130i;
        if (editText != null) {
            editText.post(new e(23, this));
        }
    }

    public final void t(boolean z10) {
        boolean z11 = this.f17175b.c() == z10;
        if (z10 && !this.f17133l.isRunning()) {
            this.f17134m.cancel();
            this.f17133l.start();
            if (z11) {
                this.f17133l.end();
            }
        } else if (!z10) {
            this.f17133l.cancel();
            this.f17134m.start();
            if (z11) {
                this.f17134m.end();
            }
        }
    }

    public final boolean u() {
        EditText editText = this.f17130i;
        return editText != null && (editText.hasFocus() || this.f17177d.hasFocus()) && this.f17130i.getText().length() > 0;
    }
}
