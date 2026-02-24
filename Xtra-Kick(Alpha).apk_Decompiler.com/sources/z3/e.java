package z3;

import a1.b;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import q0.f;

public final class e extends Drawable implements Animatable {

    /* renamed from: n  reason: collision with root package name */
    public static final LinearInterpolator f17533n = new LinearInterpolator();

    /* renamed from: o  reason: collision with root package name */
    public static final b f17534o = new b();

    /* renamed from: p  reason: collision with root package name */
    public static final int[] f17535p = {-16777216};

    /* renamed from: h  reason: collision with root package name */
    public final d f17536h;

    /* renamed from: i  reason: collision with root package name */
    public float f17537i;

    /* renamed from: j  reason: collision with root package name */
    public final Resources f17538j;

    /* renamed from: k  reason: collision with root package name */
    public ValueAnimator f17539k;

    /* renamed from: l  reason: collision with root package name */
    public float f17540l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f17541m;

    public e(Context context) {
        context.getClass();
        this.f17538j = context.getResources();
        d dVar = new d();
        this.f17536h = dVar;
        dVar.f17520i = f17535p;
        dVar.a(0);
        dVar.f17519h = 2.5f;
        dVar.f17513b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new b(this, 0, dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f17533n);
        ofFloat.addListener(new c(this, dVar));
        this.f17539k = ofFloat;
    }

    public static void c(float f10, d dVar) {
        int i10;
        if (f10 > 0.75f) {
            float f11 = (f10 - 0.75f) / 0.25f;
            int[] iArr = dVar.f17520i;
            int i11 = dVar.f17521j;
            int i12 = iArr[i11];
            int i13 = iArr[(i11 + 1) % iArr.length];
            int i14 = (i12 >> 24) & 255;
            int i15 = (i12 >> 16) & 255;
            int i16 = (i12 >> 8) & 255;
            int i17 = i12 & 255;
            i10 = (i17 + ((int) (f11 * ((float) ((i13 & 255) - i17))))) | ((i14 + ((int) (((float) (((i13 >> 24) & 255) - i14)) * f11))) << 24) | ((i15 + ((int) (((float) (((i13 >> 16) & 255) - i15)) * f11))) << 16) | ((i16 + ((int) (((float) (((i13 >> 8) & 255) - i16)) * f11))) << 8);
        } else {
            i10 = dVar.f17520i[dVar.f17521j];
        }
        dVar.f17532u = i10;
    }

    public final void a(float f10, d dVar, boolean z10) {
        float f11;
        float f12;
        if (this.f17541m) {
            c(f10, dVar);
            float floor = (float) (Math.floor((double) (dVar.f17524m / 0.8f)) + 1.0d);
            float f13 = dVar.f17522k;
            float f14 = dVar.f17523l;
            dVar.f17516e = (((f14 - 0.01f) - f13) * f10) + f13;
            dVar.f17517f = f14;
            float f15 = dVar.f17524m;
            dVar.f17518g = f.f(floor, f15, f10, f15);
        } else if (f10 != 1.0f || z10) {
            float f16 = dVar.f17524m;
            b bVar = f17534o;
            if (f10 < 0.5f) {
                f11 = dVar.f17522k;
                f12 = (bVar.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + f11;
            } else {
                float f17 = dVar.f17522k + 0.79f;
                float f18 = f17;
                f11 = f17 - (((1.0f - bVar.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f12 = f18;
            }
            dVar.f17516e = f11;
            dVar.f17517f = f12;
            dVar.f17518g = (0.20999998f * f10) + f16;
            this.f17537i = (f10 + this.f17540l) * 216.0f;
        }
    }

    public final void b(float f10, float f11, float f12, float f13) {
        float f14 = this.f17538j.getDisplayMetrics().density;
        float f15 = f11 * f14;
        d dVar = this.f17536h;
        dVar.f17519h = f15;
        dVar.f17513b.setStrokeWidth(f15);
        dVar.f17528q = f10 * f14;
        dVar.a(0);
        dVar.f17529r = (int) (f12 * f14);
        dVar.f17530s = (int) (f13 * f14);
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f17537i, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f17536h;
        RectF rectF = dVar.f17512a;
        float f10 = dVar.f17528q;
        float f11 = (dVar.f17519h / 2.0f) + f10;
        if (f10 <= 0.0f) {
            f11 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) dVar.f17529r) * dVar.f17527p) / 2.0f, dVar.f17519h / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f11, ((float) bounds.centerY()) - f11, ((float) bounds.centerX()) + f11, ((float) bounds.centerY()) + f11);
        float f12 = dVar.f17516e;
        float f13 = dVar.f17518g;
        float f14 = (f12 + f13) * 360.0f;
        float f15 = ((dVar.f17517f + f13) * 360.0f) - f14;
        Paint paint = dVar.f17513b;
        paint.setColor(dVar.f17532u);
        paint.setAlpha(dVar.f17531t);
        float f16 = dVar.f17519h / 2.0f;
        rectF.inset(f16, f16);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f17515d);
        float f17 = -f16;
        rectF.inset(f17, f17);
        canvas.drawArc(rectF, f14, f15, false, paint);
        if (dVar.f17525n) {
            Path path = dVar.f17526o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f17526o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            dVar.f17526o.moveTo(0.0f, 0.0f);
            dVar.f17526o.lineTo(((float) dVar.f17529r) * dVar.f17527p, 0.0f);
            Path path3 = dVar.f17526o;
            float f18 = dVar.f17527p;
            path3.lineTo((((float) dVar.f17529r) * f18) / 2.0f, ((float) dVar.f17530s) * f18);
            dVar.f17526o.offset((rectF.centerX() + (Math.min(rectF.width(), rectF.height()) / 2.0f)) - ((((float) dVar.f17529r) * dVar.f17527p) / 2.0f), (dVar.f17519h / 2.0f) + rectF.centerY());
            dVar.f17526o.close();
            Paint paint2 = dVar.f17514c;
            paint2.setColor(dVar.f17532u);
            paint2.setAlpha(dVar.f17531t);
            canvas.save();
            canvas.rotate(f14 + f15, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f17526o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    public final int getAlpha() {
        return this.f17536h.f17531t;
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        return this.f17539k.isRunning();
    }

    public final void setAlpha(int i10) {
        this.f17536h.f17531t = i10;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f17536h.f17513b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void start() {
        long j10;
        ValueAnimator valueAnimator;
        this.f17539k.cancel();
        d dVar = this.f17536h;
        float f10 = dVar.f17516e;
        dVar.f17522k = f10;
        float f11 = dVar.f17517f;
        dVar.f17523l = f11;
        dVar.f17524m = dVar.f17518g;
        if (f11 != f10) {
            this.f17541m = true;
            valueAnimator = this.f17539k;
            j10 = 666;
        } else {
            dVar.a(0);
            dVar.f17522k = 0.0f;
            dVar.f17523l = 0.0f;
            dVar.f17524m = 0.0f;
            dVar.f17516e = 0.0f;
            dVar.f17517f = 0.0f;
            dVar.f17518g = 0.0f;
            valueAnimator = this.f17539k;
            j10 = 1332;
        }
        valueAnimator.setDuration(j10);
        this.f17539k.start();
    }

    public final void stop() {
        this.f17539k.cancel();
        this.f17537i = 0.0f;
        d dVar = this.f17536h;
        if (dVar.f17525n) {
            dVar.f17525n = false;
        }
        dVar.a(0);
        dVar.f17522k = 0.0f;
        dVar.f17523l = 0.0f;
        dVar.f17524m = 0.0f;
        dVar.f17516e = 0.0f;
        dVar.f17517f = 0.0f;
        dVar.f17518g = 0.0f;
        invalidateSelf();
    }
}
