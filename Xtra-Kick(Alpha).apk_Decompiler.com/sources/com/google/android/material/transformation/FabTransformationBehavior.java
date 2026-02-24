package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.media.session.g0;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import b9.b;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;
import w7.a;
import w7.c;
import w7.f;
import w7.g;
import z.e;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f3962c = new Rect();

    /* renamed from: d  reason: collision with root package name */
    public final RectF f3963d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f3964e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    public final int[] f3965f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    public float f3966g;

    /* renamed from: h  reason: collision with root package name */
    public float f3967h;

    public FabTransformationBehavior() {
    }

    public static Pair u(float f10, float f11, boolean z10, b bVar) {
        String str;
        f fVar;
        g gVar;
        int i10;
        if (f10 == 0.0f || f11 == 0.0f) {
            gVar = bVar.f2699a.d("translationXLinear");
            fVar = bVar.f2699a;
            str = "translationYLinear";
        } else if ((!z10 || f11 >= 0.0f) && (z10 || i10 <= 0)) {
            gVar = bVar.f2699a.d("translationXCurveDownwards");
            fVar = bVar.f2699a;
            str = "translationYCurveDownwards";
        } else {
            gVar = bVar.f2699a.d("translationXCurveUpwards");
            fVar = bVar.f2699a;
            str = "translationYCurveUpwards";
        }
        return new Pair(gVar, fVar.d(str));
    }

    public static float x(b bVar, g gVar, float f10) {
        long j10 = gVar.f16165a;
        g d10 = bVar.f2699a.d("expansion");
        float interpolation = gVar.b().getInterpolation(((float) (((d10.f16165a + d10.f16166b) + 17) - j10)) / ((float) gVar.f16166b));
        LinearInterpolator linearInterpolator = a.f16153a;
        return q0.f.f(0.0f, f10, interpolation, f10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r4 = ((com.google.android.material.floatingactionbutton.FloatingActionButton) r4).getExpandedComponentIdHint();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(android.view.View r3, android.view.View r4) {
        /*
            r2 = this;
            int r0 = r3.getVisibility()
            r1 = 8
            if (r0 == r1) goto L_0x001e
            boolean r0 = r4 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r0 == 0) goto L_0x001c
            com.google.android.material.floatingactionbutton.FloatingActionButton r4 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r4
            int r4 = r4.getExpandedComponentIdHint()
            if (r4 == 0) goto L_0x001a
            int r3 = r3.getId()
            if (r4 != r3) goto L_0x001c
        L_0x001a:
            r3 = 1
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            return r3
        L_0x001e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.b(android.view.View, android.view.View):boolean");
    }

    public final void c(e eVar) {
        if (eVar.f17329h == 0) {
            eVar.f17329h = 80;
        }
    }

    public final AnimatorSet t(View view, View view2, boolean z10, boolean z11) {
        ObjectAnimator objectAnimator;
        ArrayList arrayList;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3;
        ObjectAnimator objectAnimator4;
        View view3 = view;
        View view4 = view2;
        boolean z12 = z10;
        b z13 = z(view2.getContext(), z12);
        if (z12) {
            this.f3966g = view.getTranslationX();
            this.f3967h = view.getTranslationY();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        WeakHashMap weakHashMap = c1.f10054a;
        float i10 = o0.i(view2) - o0.i(view);
        if (z12) {
            if (!z11) {
                view4.setTranslationZ(-i10);
            }
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Z, new float[]{-i10});
        }
        z13.f2699a.d("elevation").a(objectAnimator);
        arrayList2.add(objectAnimator);
        RectF rectF = this.f3963d;
        float v10 = v(view3, view4, z13.f2700b);
        float w10 = w(view3, view4, z13.f2700b);
        Pair u10 = u(v10, w10, z12, z13);
        g gVar = (g) u10.first;
        g gVar2 = (g) u10.second;
        if (z12) {
            if (!z11) {
                view4.setTranslationX(-v10);
                view4.setTranslationY(-w10);
            }
            arrayList = arrayList3;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            ObjectAnimator objectAnimator5 = ofFloat;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            float x10 = x(z13, gVar, -v10);
            float x11 = x(z13, gVar2, -w10);
            Rect rect = this.f3962c;
            view4.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.f3964e;
            y(view4, rectF2);
            rectF2.offset(x10, x11);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
            objectAnimator2 = ofFloat2;
            objectAnimator3 = objectAnimator5;
        } else {
            arrayList = arrayList3;
            objectAnimator3 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-v10});
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-w10});
        }
        gVar.a(objectAnimator3);
        gVar2.a(objectAnimator2);
        arrayList2.add(objectAnimator3);
        arrayList2.add(objectAnimator2);
        rectF.width();
        rectF.height();
        float v11 = v(view3, view4, z13.f2700b);
        float w11 = w(view3, view4, z13.f2700b);
        Pair u11 = u(v11, w11, z12, z13);
        g gVar3 = (g) u11.first;
        g gVar4 = (g) u11.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z12) {
            v11 = this.f3966g;
        }
        fArr[0] = v11;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z12) {
            w11 = this.f3967h;
        }
        fArr2[0] = w11;
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view3, property2, fArr2);
        gVar3.a(ofFloat3);
        gVar4.a(ofFloat4);
        arrayList2.add(ofFloat3);
        arrayList2.add(ofFloat4);
        boolean z14 = view4 instanceof ViewGroup;
        if (z14) {
            View findViewById = view4.findViewById(R.id.mtrl_child_content_container);
            ViewGroup viewGroup = null;
            if (findViewById != null) {
                if (findViewById instanceof ViewGroup) {
                    viewGroup = (ViewGroup) findViewById;
                }
            } else if (z14) {
                viewGroup = (ViewGroup) view4;
            }
            if (viewGroup != null) {
                if (z12) {
                    if (!z11) {
                        c.f16158a.set(viewGroup, Float.valueOf(0.0f));
                    }
                    objectAnimator4 = ObjectAnimator.ofFloat(viewGroup, c.f16158a, new float[]{1.0f});
                } else {
                    objectAnimator4 = ObjectAnimator.ofFloat(viewGroup, c.f16158a, new float[]{0.0f});
                }
                z13.f2699a.d("contentFade").a(objectAnimator4);
                arrayList2.add(objectAnimator4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        w7.b.a(animatorSet, arrayList2);
        animatorSet.addListener(new l8.b(z12, view4, view3));
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList.get(i11));
        }
        return animatorSet;
    }

    public final float v(View view, View view2, g0 g0Var) {
        RectF rectF = this.f3963d;
        RectF rectF2 = this.f3964e;
        y(view, rectF);
        rectF.offset(this.f3966g, this.f3967h);
        y(view2, rectF2);
        g0Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float w(View view, View view2, g0 g0Var) {
        RectF rectF = this.f3963d;
        RectF rectF2 = this.f3964e;
        y(view, rectF);
        rectF.offset(this.f3966g, this.f3967h);
        y(view2, rectF2);
        g0Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void y(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.f3965f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    public abstract b z(Context context, boolean z10);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
