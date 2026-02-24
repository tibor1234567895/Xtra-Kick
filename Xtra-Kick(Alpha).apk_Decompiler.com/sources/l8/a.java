package l8;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import b4.e0;
import c4.e;
import t8.c;
import t8.n;
import t8.o;
import t8.p;

public final class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final p f9686a = o.f14790a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f9687b;

    /* renamed from: c  reason: collision with root package name */
    public final Path f9688c = new Path();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f9689d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final RectF f9690e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    public final RectF f9691f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    public final e f9692g = new e(this, 0);

    /* renamed from: h  reason: collision with root package name */
    public float f9693h;

    /* renamed from: i  reason: collision with root package name */
    public int f9694i;

    /* renamed from: j  reason: collision with root package name */
    public int f9695j;

    /* renamed from: k  reason: collision with root package name */
    public int f9696k;

    /* renamed from: l  reason: collision with root package name */
    public int f9697l;

    /* renamed from: m  reason: collision with root package name */
    public int f9698m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f9699n = true;

    /* renamed from: o  reason: collision with root package name */
    public n f9700o;

    /* renamed from: p  reason: collision with root package name */
    public ColorStateList f9701p;

    public a(n nVar) {
        this.f9700o = nVar;
        Paint paint = new Paint(1);
        this.f9687b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public final void draw(Canvas canvas) {
        boolean z10 = this.f9699n;
        Paint paint = this.f9687b;
        Rect rect = this.f9689d;
        if (z10) {
            copyBounds(rect);
            float height = this.f9693h / ((float) rect.height());
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{e0.a.b(this.f9694i, this.f9698m), e0.a.b(this.f9695j, this.f9698m), e0.a.b(e0.a.d(this.f9695j, 0), this.f9698m), e0.a.b(e0.a.d(this.f9697l, 0), this.f9698m), e0.a.b(this.f9697l, this.f9698m), e0.a.b(this.f9696k, this.f9698m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP));
            this.f9699n = false;
        }
        float strokeWidth = paint.getStrokeWidth() / 2.0f;
        copyBounds(rect);
        RectF rectF = this.f9690e;
        rectF.set(rect);
        c cVar = this.f9700o.f14782e;
        RectF rectF2 = this.f9691f;
        rectF2.set(getBounds());
        float min = Math.min(cVar.a(rectF2), rectF.width() / 2.0f);
        n nVar = this.f9700o;
        rectF2.set(getBounds());
        if (nVar.d(rectF2)) {
            rectF.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(rectF, min, min, paint);
        }
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f9692g;
    }

    public final int getOpacity() {
        return this.f9693h > 0.0f ? -3 : -2;
    }

    public final void getOutline(Outline outline) {
        n nVar = this.f9700o;
        RectF rectF = this.f9691f;
        rectF.set(getBounds());
        if (nVar.d(rectF)) {
            c cVar = this.f9700o.f14782e;
            rectF.set(getBounds());
            outline.setRoundRect(getBounds(), cVar.a(rectF));
            return;
        }
        Rect rect = this.f9689d;
        copyBounds(rect);
        RectF rectF2 = this.f9690e;
        rectF2.set(rect);
        n nVar2 = this.f9700o;
        Path path = this.f9688c;
        this.f9686a.a(nVar2, 1.0f, rectF2, (e0) null, path);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            outline.setPath(path);
        } else if (i10 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    public final boolean getPadding(Rect rect) {
        n nVar = this.f9700o;
        RectF rectF = this.f9691f;
        rectF.set(getBounds());
        if (!nVar.d(rectF)) {
            return true;
        }
        int round = Math.round(this.f9693h);
        rect.set(round, round, round, round);
        return true;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.f9701p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public final void onBoundsChange(Rect rect) {
        this.f9699n = true;
    }

    public final boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f9701p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f9698m)) == this.f9698m)) {
            this.f9699n = true;
            this.f9698m = colorForState;
        }
        if (this.f9699n) {
            invalidateSelf();
        }
        return this.f9699n;
    }

    public final void setAlpha(int i10) {
        this.f9687b.setAlpha(i10);
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f9687b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
