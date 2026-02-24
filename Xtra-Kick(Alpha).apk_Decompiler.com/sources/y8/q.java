package y8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.t1;

public final class q extends AnimatorListenerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17178a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f17179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f17180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f17181d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f17182e;

    public q(r rVar, int i10, TextView textView, int i11, TextView textView2) {
        this.f17182e = rVar;
        this.f17178a = i10;
        this.f17179b = textView;
        this.f17180c = i11;
        this.f17181d = textView2;
    }

    public final void onAnimationEnd(Animator animator) {
        t1 t1Var;
        int i10 = this.f17178a;
        r rVar = this.f17182e;
        rVar.f17196n = i10;
        rVar.f17194l = null;
        TextView textView = this.f17179b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f17180c == 1 && (t1Var = rVar.f17200r) != null) {
                t1Var.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f17181d;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            textView2.setAlpha(1.0f);
        }
    }

    public final void onAnimationStart(Animator animator) {
        TextView textView = this.f17181d;
        if (textView != null) {
            textView.setVisibility(0);
            textView.setAlpha(0.0f);
        }
    }
}
