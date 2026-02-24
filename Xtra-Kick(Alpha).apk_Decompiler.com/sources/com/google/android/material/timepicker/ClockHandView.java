package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.woxthebox.draglistview.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m8.w;
import v7.a;

class ClockHandView extends View {

    /* renamed from: h  reason: collision with root package name */
    public final ValueAnimator f3930h = new ValueAnimator();

    /* renamed from: i  reason: collision with root package name */
    public boolean f3931i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f3932j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final int f3933k;

    /* renamed from: l  reason: collision with root package name */
    public final float f3934l;

    /* renamed from: m  reason: collision with root package name */
    public final Paint f3935m;

    /* renamed from: n  reason: collision with root package name */
    public final RectF f3936n;

    /* renamed from: o  reason: collision with root package name */
    public final int f3937o;

    /* renamed from: p  reason: collision with root package name */
    public float f3938p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3939q;

    /* renamed from: r  reason: collision with root package name */
    public double f3940r;

    /* renamed from: s  reason: collision with root package name */
    public int f3941s;

    /* renamed from: t  reason: collision with root package name */
    public int f3942t;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        Paint paint = new Paint();
        this.f3935m = paint;
        this.f3936n = new RectF();
        this.f3942t = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f15939h, R.attr.materialClockStyle, 2132018380);
        n8.a.c(context, R.attr.motionDurationLong2, 200);
        n8.a.d(context, R.attr.motionEasingEmphasizedInterpolator, w7.a.f16154b);
        this.f3941s = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f3933k = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.f3937o = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f3934l = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(this, 2);
        obtainStyledAttributes.recycle();
    }

    public final int a(int i10) {
        return i10 == 2 ? Math.round(((float) this.f3941s) * 0.66f) : this.f3941s;
    }

    public final void b(float f10) {
        ValueAnimator valueAnimator = this.f3930h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        c(f10);
    }

    public final void c(float f10) {
        float f11 = f10 % 360.0f;
        this.f3938p = f11;
        this.f3940r = Math.toRadians((double) (f11 - 90.0f));
        float a10 = (float) a(this.f3942t);
        float cos = (((float) Math.cos(this.f3940r)) * a10) + ((float) (getWidth() / 2));
        float sin = (a10 * ((float) Math.sin(this.f3940r))) + ((float) (getHeight() / 2));
        float f12 = (float) this.f3933k;
        this.f3936n.set(cos - f12, sin - f12, cos + f12, sin + f12);
        Iterator it = this.f3932j.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((d) it.next());
            if (Math.abs(clockFaceView.N - f11) > 0.001f) {
                clockFaceView.N = f11;
                clockFaceView.m();
            }
        }
        invalidate();
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int a10 = a(this.f3942t);
        float f10 = (float) width;
        float f11 = (float) a10;
        float f12 = (float) height;
        Paint paint = this.f3935m;
        paint.setStrokeWidth(0.0f);
        int i10 = this.f3933k;
        canvas.drawCircle((((float) Math.cos(this.f3940r)) * f11) + f10, (f11 * ((float) Math.sin(this.f3940r))) + f12, (float) i10, paint);
        double sin = Math.sin(this.f3940r);
        double d10 = (double) ((float) (a10 - i10));
        paint.setStrokeWidth((float) this.f3937o);
        canvas.drawLine(f10, f12, (float) (width + ((int) (Math.cos(this.f3940r) * d10))), (float) (height + ((int) (d10 * sin))), paint);
        canvas.drawCircle(f10, f12, this.f3934l, paint);
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (!this.f3930h.isRunning()) {
            b(this.f3938p);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        boolean z13 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                z11 = this.f3939q;
                if (this.f3931i) {
                    if (((float) Math.hypot((double) (x10 - ((float) (getWidth() / 2))), (double) (y10 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + w.b(getContext(), 12)) {
                        i10 = 2;
                    } else {
                        i10 = 1;
                    }
                    this.f3942t = i10;
                }
            } else {
                z11 = false;
            }
            z10 = false;
        } else {
            this.f3939q = false;
            z11 = false;
            z10 = true;
        }
        boolean z14 = this.f3939q;
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (y10 - ((float) (getHeight() / 2))), (double) (x10 - ((float) (getWidth() / 2)))))) + 90;
        if (degrees < 0) {
            degrees += 360;
        }
        float f10 = (float) degrees;
        if (this.f3938p != f10) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z10 || !z12) {
            if (z12 || z11) {
                b(f10);
            }
            this.f3939q = z14 | z13;
            return true;
        }
        z13 = true;
        this.f3939q = z14 | z13;
        return true;
    }
}
