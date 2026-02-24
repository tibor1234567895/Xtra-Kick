package l8;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import q0.f;
import w7.a;

public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f9713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f9714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f9715c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f9716d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ float f9717e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ float f9718f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ float f9719g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Matrix f9720h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f9721i;

    public h(l lVar, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
        this.f9721i = lVar;
        this.f9713a = f10;
        this.f9714b = f11;
        this.f9715c = f12;
        this.f9716d = f13;
        this.f9717e = f14;
        this.f9718f = f15;
        this.f9719g = f16;
        this.f9720h = matrix;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        l lVar = this.f9721i;
        lVar.f9748s.setAlpha(a.a(this.f9713a, this.f9714b, 0.0f, 0.2f, floatValue));
        FloatingActionButton floatingActionButton = lVar.f9748s;
        float f10 = this.f9716d;
        float f11 = this.f9715c;
        floatingActionButton.setScaleX(((f10 - f11) * floatValue) + f11);
        FloatingActionButton floatingActionButton2 = lVar.f9748s;
        float f12 = this.f9717e;
        floatingActionButton2.setScaleY(((f10 - f12) * floatValue) + f12);
        float f13 = this.f9719g;
        float f14 = this.f9718f;
        lVar.f9745p = f.f(f13, f14, floatValue, f14);
        float f15 = f.f(f13, f14, floatValue, f14);
        Matrix matrix = this.f9720h;
        lVar.a(f15, matrix);
        lVar.f9748s.setImageMatrix(matrix);
    }
}
