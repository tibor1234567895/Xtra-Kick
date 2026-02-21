package i;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import j.a;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    public final ObjectAnimator f7889a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7890b;

    public c(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
        super(0);
        int i10;
        int i11;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        if (z10) {
            i10 = numberOfFrames - 1;
        } else {
            i10 = 0;
        }
        if (z10) {
            i11 = 0;
        } else {
            i11 = numberOfFrames - 1;
        }
        d dVar = new d(animationDrawable, z10);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i10, i11});
        a.a(ofInt, true);
        ofInt.setDuration((long) dVar.f7893c);
        ofInt.setInterpolator(dVar);
        this.f7890b = z11;
        this.f7889a = ofInt;
    }

    public final boolean a() {
        return this.f7890b;
    }

    public final void b() {
        this.f7889a.reverse();
    }

    public final void c() {
        this.f7889a.start();
    }

    public final void d() {
        this.f7889a.cancel();
    }
}
