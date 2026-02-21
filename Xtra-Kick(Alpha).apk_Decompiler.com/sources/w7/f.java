package w7;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import q.k;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final k f16163a = new k();

    /* renamed from: b  reason: collision with root package name */
    public final k f16164b = new k();

    public static f a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static f b(Context context, int i10) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i10);
            if (loadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return c(arrayList);
        } catch (Exception e10) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i10), e10);
            return null;
        }
    }

    public static f c(ArrayList arrayList) {
        f fVar = new f();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Animator animator = (Animator) arrayList.get(i10);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                fVar.f16164b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                    interpolator = a.f16154b;
                } else if (interpolator instanceof AccelerateInterpolator) {
                    interpolator = a.f16155c;
                } else if (interpolator instanceof DecelerateInterpolator) {
                    interpolator = a.f16156d;
                }
                g gVar = new g(startDelay, duration, interpolator);
                gVar.f16168d = objectAnimator.getRepeatCount();
                gVar.f16169e = objectAnimator.getRepeatMode();
                fVar.f16163a.put(propertyName, gVar);
                i10++;
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return fVar;
    }

    public final g d(String str) {
        boolean z10;
        k kVar = this.f16163a;
        if (kVar.getOrDefault(str, (Object) null) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return (g) kVar.getOrDefault(str, (Object) null);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        return this.f16163a.equals(((f) obj).f16163a);
    }

    public final int hashCode() {
        return this.f16163a.hashCode();
    }

    public final String toString() {
        return Constants.WRITE_NEW_LINE + f.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f16163a + "}\n";
    }
}
