package androidx.cardview.widget;

import android.graphics.drawable.Drawable;

public abstract class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public static final double f1162a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f1163b = 0;

    public static float a(float f10, float f11, boolean z10) {
        float f12 = f10 * 1.5f;
        if (!z10) {
            return f12;
        }
        return (float) (((1.0d - f1162a) * ((double) f11)) + ((double) f12));
    }
}
