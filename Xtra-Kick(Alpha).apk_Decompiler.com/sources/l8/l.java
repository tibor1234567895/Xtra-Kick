package l8;

import a1.a;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import b4.e0;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import m8.k;
import t8.i;
import t8.n;
import t8.y;
import w7.b;
import w7.d;
import w7.f;

public abstract class l {
    public static final int A = R.attr.motionDurationLong2;
    public static final int B = R.attr.motionEasingEmphasizedInterpolator;
    public static final int C = R.attr.motionDurationMedium1;
    public static final int D = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] E = {16842919, 16842910};
    public static final int[] F = {16843623, 16842908, 16842910};
    public static final int[] G = {16842908, 16842910};
    public static final int[] H = {16843623, 16842910};
    public static final int[] I = {16842910};
    public static final int[] J = new int[0];

    /* renamed from: z  reason: collision with root package name */
    public static final a f9729z = w7.a.f16155c;

    /* renamed from: a  reason: collision with root package name */
    public n f9730a;

    /* renamed from: b  reason: collision with root package name */
    public i f9731b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f9732c;

    /* renamed from: d  reason: collision with root package name */
    public a f9733d;

    /* renamed from: e  reason: collision with root package name */
    public LayerDrawable f9734e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9735f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9736g = true;

    /* renamed from: h  reason: collision with root package name */
    public float f9737h;

    /* renamed from: i  reason: collision with root package name */
    public float f9738i;

    /* renamed from: j  reason: collision with root package name */
    public float f9739j;

    /* renamed from: k  reason: collision with root package name */
    public int f9740k;

    /* renamed from: l  reason: collision with root package name */
    public Animator f9741l;

    /* renamed from: m  reason: collision with root package name */
    public f f9742m;

    /* renamed from: n  reason: collision with root package name */
    public f f9743n;

    /* renamed from: o  reason: collision with root package name */
    public float f9744o;

    /* renamed from: p  reason: collision with root package name */
    public float f9745p = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    public int f9746q;

    /* renamed from: r  reason: collision with root package name */
    public int f9747r = 0;

    /* renamed from: s  reason: collision with root package name */
    public final FloatingActionButton f9748s;

    /* renamed from: t  reason: collision with root package name */
    public final e0 f9749t;

    /* renamed from: u  reason: collision with root package name */
    public final Rect f9750u = new Rect();

    /* renamed from: v  reason: collision with root package name */
    public final RectF f9751v = new RectF();

    /* renamed from: w  reason: collision with root package name */
    public final RectF f9752w = new RectF();

    /* renamed from: x  reason: collision with root package name */
    public final Matrix f9753x = new Matrix();

    /* renamed from: y  reason: collision with root package name */
    public z.f f9754y;

    public l(FloatingActionButton floatingActionButton, e0 e0Var) {
        this.f9748s = floatingActionButton;
        this.f9749t = e0Var;
        k kVar = new k();
        n nVar = (n) this;
        kVar.a(E, d(new j(nVar, 2)));
        kVar.a(F, d(new j(nVar, 1)));
        kVar.a(G, d(new j(nVar, 1)));
        kVar.a(H, d(new j(nVar, 1)));
        kVar.a(I, d(new j(nVar, 3)));
        kVar.a(J, d(new j(nVar, 0)));
        this.f9744o = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(j jVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f9729z);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(jVar);
        valueAnimator.addUpdateListener(jVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    public final void a(float f10, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f9748s.getDrawable();
        if (drawable != null && this.f9746q != 0) {
            RectF rectF = this.f9751v;
            RectF rectF2 = this.f9752w;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i10 = this.f9746q;
            rectF2.set(0.0f, 0.0f, (float) i10, (float) i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f9746q;
            matrix.postScale(f10, f10, ((float) i11) / 2.0f, ((float) i11) / 2.0f);
        }
    }

    public final AnimatorSet b(f fVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f10};
        FloatingActionButton floatingActionButton = this.f9748s;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionButton, property, fArr);
        fVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_X, new float[]{f11});
        fVar.d("scale").a(ofFloat2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 26) {
            ofFloat2.setEvaluator(new i());
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_Y, new float[]{f11});
        fVar.d("scale").a(ofFloat3);
        if (i10 == 26) {
            ofFloat3.setEvaluator(new i());
        }
        arrayList.add(ofFloat3);
        Matrix matrix = this.f9753x;
        a(f12, matrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(floatingActionButton, new d(), new g(this), new Matrix[]{new Matrix(matrix)});
        fVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f10, float f11, float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        FloatingActionButton floatingActionButton = this.f9748s;
        ofFloat.addUpdateListener(new h(this, floatingActionButton.getAlpha(), f10, floatingActionButton.getScaleX(), f11, floatingActionButton.getScaleY(), this.f9745p, f12, new Matrix(this.f9753x)));
        arrayList.add(ofFloat);
        b.a(animatorSet, arrayList);
        animatorSet.setDuration((long) n8.a.c(floatingActionButton.getContext(), i10, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(n8.a.d(floatingActionButton.getContext(), i11, w7.a.f16154b));
        return animatorSet;
    }

    public abstract float e();

    public void f(Rect rect) {
        int sizeDimension = this.f9735f ? (this.f9740k - this.f9748s.getSizeDimension()) / 2 : 0;
        float e10 = this.f9736g ? e() + this.f9739j : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil((double) e10));
        int max2 = Math.max(sizeDimension, (int) Math.ceil((double) (e10 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public abstract void g(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10);

    public abstract void h();

    public abstract void i();

    public abstract void j(int[] iArr);

    public abstract void k(float f10, float f11, float f12);

    public final void l() {
    }

    public void m(ColorStateList colorStateList) {
        Drawable drawable = this.f9732c;
        if (drawable != null) {
            f0.b.h(drawable, r8.d.c(colorStateList));
        }
    }

    public final void n(n nVar) {
        this.f9730a = nVar;
        i iVar = this.f9731b;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        Drawable drawable = this.f9732c;
        if (drawable instanceof y) {
            ((y) drawable).setShapeAppearanceModel(nVar);
        }
        a aVar = this.f9733d;
        if (aVar != null) {
            aVar.f9700o = nVar;
            aVar.invalidateSelf();
        }
    }

    public abstract boolean o();

    public abstract void p();

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.graphics.drawable.LayerDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.graphics.drawable.InsetDrawable} */
    /* JADX WARNING: type inference failed for: r1v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q() {
        /*
            r8 = this;
            android.graphics.Rect r0 = r8.f9750u
            r8.f(r0)
            android.graphics.drawable.LayerDrawable r1 = r8.f9734e
            java.lang.String r2 = "Didn't initialize content background"
            l0.f.c(r1, r2)
            boolean r1 = r8.o()
            if (r1 == 0) goto L_0x0023
            android.graphics.drawable.InsetDrawable r1 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.LayerDrawable r3 = r8.f9734e
            int r4 = r0.left
            int r5 = r0.top
            int r6 = r0.right
            int r7 = r0.bottom
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0025
        L_0x0023:
            android.graphics.drawable.LayerDrawable r1 = r8.f9734e
        L_0x0025:
            b4.e0 r2 = r8.f9749t
            r2.j(r1)
            int r1 = r0.left
            int r3 = r0.top
            int r4 = r0.right
            int r0 = r0.bottom
            java.lang.Object r2 = r2.f2538i
            com.google.android.material.floatingactionbutton.FloatingActionButton r2 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r2
            android.graphics.Rect r5 = r2.f3821s
            r5.set(r1, r3, r4, r0)
            int r5 = r2.f3818p
            int r1 = r1 + r5
            int r3 = r3 + r5
            int r4 = r4 + r5
            int r0 = r0 + r5
            r2.setPadding(r1, r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.l.q():void");
    }
}
