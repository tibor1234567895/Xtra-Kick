package b4;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public final class o implements TypeEvaluator {
    public final Object evaluate(float f10, Object obj, Object obj2) {
        Rect rect = (Rect) obj;
        Rect rect2 = (Rect) obj2;
        int i10 = rect.left;
        int i11 = i10 + ((int) (((float) (rect2.left - i10)) * f10));
        int i12 = rect.top;
        int i13 = i12 + ((int) (((float) (rect2.top - i12)) * f10));
        int i14 = rect.right;
        int i15 = rect.bottom;
        return new Rect(i11, i13, i14 + ((int) (((float) (rect2.right - i14)) * f10)), i15 + ((int) (((float) (rect2.bottom - i15)) * f10)));
    }
}
