package androidx.recyclerview.widget;

import android.animation.ValueAnimator;

public final class c0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1950h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1951i;

    public /* synthetic */ c0(int i10, Object obj) {
        this.f1950h = i10;
        this.f1951i = obj;
    }

    public final void run() {
        int i10 = this.f1950h;
        Object obj = this.f1951i;
        switch (i10) {
            case 0:
                g0 g0Var = (g0) obj;
                int i11 = g0Var.A;
                ValueAnimator valueAnimator = g0Var.f2017z;
                if (i11 == 1) {
                    valueAnimator.cancel();
                } else if (i11 != 2) {
                    return;
                }
                g0Var.A = 3;
                valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
                valueAnimator.setDuration((long) 500);
                valueAnimator.start();
                return;
            default:
                ((StaggeredGridLayoutManager) obj).O0();
                return;
        }
    }
}
