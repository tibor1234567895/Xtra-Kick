package l8;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;

public final class i implements TypeEvaluator {

    /* renamed from: a  reason: collision with root package name */
    public final FloatEvaluator f9722a = new FloatEvaluator();

    public final Object evaluate(float f10, Object obj, Object obj2) {
        float floatValue = this.f9722a.evaluate(f10, (Float) obj, (Float) obj2).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
