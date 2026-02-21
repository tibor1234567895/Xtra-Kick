package i3;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.activity.u;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;

public final class c0 {
    public boolean A;
    public boolean B;
    public boolean C = true;

    /* renamed from: a  reason: collision with root package name */
    public final w f8038a;

    /* renamed from: b  reason: collision with root package name */
    public final View f8039b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f8040c;

    /* renamed from: d  reason: collision with root package name */
    public final ViewGroup f8041d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f8042e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f8043f;

    /* renamed from: g  reason: collision with root package name */
    public final ViewGroup f8044g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f8045h;

    /* renamed from: i  reason: collision with root package name */
    public final ViewGroup f8046i;

    /* renamed from: j  reason: collision with root package name */
    public final View f8047j;

    /* renamed from: k  reason: collision with root package name */
    public final View f8048k;

    /* renamed from: l  reason: collision with root package name */
    public final AnimatorSet f8049l;

    /* renamed from: m  reason: collision with root package name */
    public final AnimatorSet f8050m;

    /* renamed from: n  reason: collision with root package name */
    public final AnimatorSet f8051n;

    /* renamed from: o  reason: collision with root package name */
    public final AnimatorSet f8052o;

    /* renamed from: p  reason: collision with root package name */
    public final AnimatorSet f8053p;

    /* renamed from: q  reason: collision with root package name */
    public final ValueAnimator f8054q;

    /* renamed from: r  reason: collision with root package name */
    public final ValueAnimator f8055r;

    /* renamed from: s  reason: collision with root package name */
    public final x f8056s = new x(this, 0);

    /* renamed from: t  reason: collision with root package name */
    public final x f8057t = new x(this, 1);

    /* renamed from: u  reason: collision with root package name */
    public final x f8058u = new x(this, 2);

    /* renamed from: v  reason: collision with root package name */
    public final x f8059v = new x(this, 3);

    /* renamed from: w  reason: collision with root package name */
    public final x f8060w = new x(this, 4);

    /* renamed from: x  reason: collision with root package name */
    public final u f8061x = new u(2, this);

    /* renamed from: y  reason: collision with root package name */
    public final ArrayList f8062y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    public int f8063z = 0;

    public c0(w wVar) {
        w wVar2 = wVar;
        this.f8038a = wVar2;
        this.f8039b = wVar2.findViewById(R.id.exo_controls_background);
        this.f8040c = (ViewGroup) wVar2.findViewById(R.id.exo_center_controls);
        this.f8042e = (ViewGroup) wVar2.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) wVar2.findViewById(R.id.exo_bottom_bar);
        this.f8041d = viewGroup;
        this.f8046i = (ViewGroup) wVar2.findViewById(R.id.exo_time);
        View findViewById = wVar2.findViewById(R.id.exo_progress);
        this.f8047j = findViewById;
        this.f8043f = (ViewGroup) wVar2.findViewById(R.id.exo_basic_controls);
        this.f8044g = (ViewGroup) wVar2.findViewById(R.id.exo_extra_controls);
        this.f8045h = (ViewGroup) wVar2.findViewById(R.id.exo_extra_controls_scroll_view);
        View findViewById2 = wVar2.findViewById(R.id.exo_overflow_show);
        this.f8048k = findViewById2;
        View findViewById3 = wVar2.findViewById(R.id.exo_overflow_hide);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new z(this, 0));
            findViewById3.setOnClickListener(new z(this, 1));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new y(this, 2));
        ofFloat.addListener(new a0(this, 0));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new y(this, 3));
        ofFloat2.addListener(new a0(this, 1));
        Resources resources = wVar.getResources();
        float dimension = resources.getDimension(R.dimen.exo_styled_bottom_bar_height) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R.dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f8049l = animatorSet;
        animatorSet.setDuration(250);
        animatorSet.addListener(new b0(this, wVar2, 0));
        animatorSet.play(ofFloat).with(e(findViewById, 0.0f, dimension)).with(e(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f8050m = animatorSet2;
        animatorSet2.setDuration(250);
        animatorSet2.addListener(new b0(this, wVar2, 1));
        animatorSet2.play(e(findViewById, dimension, dimension2)).with(e(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f8051n = animatorSet3;
        animatorSet3.setDuration(250);
        animatorSet3.addListener(new b0(this, wVar2, 2));
        animatorSet3.play(ofFloat).with(e(findViewById, 0.0f, dimension2)).with(e(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f8052o = animatorSet4;
        animatorSet4.setDuration(250);
        animatorSet4.addListener(new a0(this, 2));
        animatorSet4.play(ofFloat2).with(e(findViewById, dimension, 0.0f)).with(e(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f8053p = animatorSet5;
        animatorSet5.setDuration(250);
        animatorSet5.addListener(new a0(this, 3));
        animatorSet5.play(ofFloat2).with(e(findViewById, dimension2, 0.0f)).with(e(viewGroup, dimension2, 0.0f));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f8054q = ofFloat3;
        ofFloat3.setDuration(250);
        ofFloat3.addUpdateListener(new y(this, 0));
        ofFloat3.addListener(new a0(this, 4));
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.f8055r = ofFloat4;
        ofFloat4.setDuration(250);
        ofFloat4.addUpdateListener(new y(this, 1));
        ofFloat4.addListener(new a0(this, 5));
    }

    public static void a(c0 c0Var, View view) {
        ValueAnimator valueAnimator;
        c0Var.h();
        if (view.getId() == R.id.exo_overflow_show) {
            valueAnimator = c0Var.f8054q;
        } else if (view.getId() == R.id.exo_overflow_hide) {
            valueAnimator = c0Var.f8055r;
        } else {
            return;
        }
        valueAnimator.start();
    }

    public static int d(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    public static ObjectAnimator e(View view, float f10, float f11) {
        return ObjectAnimator.ofFloat(view, "translationY", new float[]{f10, f11});
    }

    public static boolean k(View view) {
        int id = view.getId();
        return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
    }

    public final void b(float f10) {
        ViewGroup viewGroup = this.f8045h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((float) ((int) ((1.0f - f10) * ((float) viewGroup.getWidth()))));
        }
        ViewGroup viewGroup2 = this.f8046i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f10);
        }
        ViewGroup viewGroup3 = this.f8043f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f10);
        }
    }

    public final boolean c(View view) {
        return view != null && this.f8062y.contains(view);
    }

    public final void f(x xVar, long j10) {
        if (j10 >= 0) {
            this.f8038a.postDelayed(xVar, j10);
        }
    }

    public final void g() {
        w wVar = this.f8038a;
        wVar.removeCallbacks(this.f8060w);
        wVar.removeCallbacks(this.f8057t);
        wVar.removeCallbacks(this.f8059v);
        wVar.removeCallbacks(this.f8058u);
    }

    public final void h() {
        x xVar;
        if (this.f8063z != 3) {
            g();
            int showTimeoutMs = this.f8038a.getShowTimeoutMs();
            if (showTimeoutMs > 0) {
                if (!this.C) {
                    xVar = this.f8060w;
                } else if (this.f8063z == 1) {
                    f(this.f8058u, 2000);
                    return;
                } else {
                    xVar = this.f8059v;
                }
                f(xVar, (long) showTimeoutMs);
            }
        }
    }

    public final void i(View view, boolean z10) {
        if (view != null) {
            ArrayList arrayList = this.f8062y;
            if (!z10) {
                view.setVisibility(8);
                arrayList.remove(view);
                return;
            }
            view.setVisibility((!this.A || !k(view)) ? 0 : 4);
            arrayList.add(view);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(int r4) {
        /*
            r3 = this;
            int r0 = r3.f8063z
            r3.f8063z = r4
            i3.w r1 = r3.f8038a
            r2 = 2
            if (r4 != r2) goto L_0x000f
            r2 = 8
        L_0x000b:
            r1.setVisibility(r2)
            goto L_0x0013
        L_0x000f:
            if (r0 != r2) goto L_0x0013
            r2 = 0
            goto L_0x000b
        L_0x0013:
            if (r0 == r4) goto L_0x0032
            java.util.concurrent.CopyOnWriteArrayList r4 = r1.f8192k
            java.util.Iterator r4 = r4.iterator()
        L_0x001b:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0032
            java.lang.Object r0 = r4.next()
            i3.v r0 = (i3.v) r0
            r1.getVisibility()
            i3.d0 r0 = (i3.d0) r0
            i3.g0 r0 = r0.f8073j
            r0.j()
            goto L_0x001b
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c0.j(int):void");
    }

    public final void l() {
        AnimatorSet animatorSet;
        if (!this.C) {
            j(0);
            h();
            return;
        }
        int i10 = this.f8063z;
        if (i10 == 1) {
            animatorSet = this.f8052o;
        } else if (i10 != 2) {
            if (i10 == 3) {
                this.B = true;
            } else if (i10 == 4) {
                return;
            }
            h();
        } else {
            animatorSet = this.f8053p;
        }
        animatorSet.start();
        h();
    }
}
