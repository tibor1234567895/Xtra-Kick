package w7;

import a1.b;
import a1.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import q0.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final LinearInterpolator f16153a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final b f16154b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final a1.a f16155c = new a1.a();

    /* renamed from: d  reason: collision with root package name */
    public static final c f16156d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final DecelerateInterpolator f16157e = new DecelerateInterpolator();

    public static float a(float f10, float f11, float f12, float f13, float f14) {
        return f14 <= f12 ? f10 : f14 >= f13 ? f11 : f.f(f11, f10, (f14 - f12) / (f13 - f12), f10);
    }

    public static int b(int i10, float f10, int i11) {
        return Math.round(f10 * ((float) (i11 - i10))) + i10;
    }
}
