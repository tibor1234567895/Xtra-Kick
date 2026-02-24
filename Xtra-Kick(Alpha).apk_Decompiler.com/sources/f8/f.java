package f8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.chip.Chip;
import com.woxthebox.draglistview.R;
import f0.b;
import f0.l;
import f0.m;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import m8.n;
import m8.o;
import m8.w;
import q8.g;
import r8.d;
import t8.h;
import t8.i;
import t8.p;

public final class f extends i implements Drawable.Callback, n {
    public static final int[] N0 = {16842910};
    public static final ShapeDrawable O0 = new ShapeDrawable(new OvalShape());
    public int A0 = 255;
    public ColorFilter B0;
    public PorterDuffColorFilter C0;
    public ColorStateList D0;
    public ColorStateList E;
    public PorterDuff.Mode E0 = PorterDuff.Mode.SRC_IN;
    public ColorStateList F;
    public int[] F0;
    public float G;
    public boolean G0;
    public float H = -1.0f;
    public ColorStateList H0;
    public ColorStateList I;
    public WeakReference I0 = new WeakReference((Object) null);
    public float J;
    public TextUtils.TruncateAt J0;
    public ColorStateList K;
    public boolean K0;
    public CharSequence L;
    public int L0;
    public boolean M;
    public boolean M0;
    public Drawable N;
    public ColorStateList O;
    public float P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public RippleDrawable T;
    public ColorStateList U;
    public float V;
    public SpannableStringBuilder W;
    public boolean X;
    public boolean Y;
    public Drawable Z;

    /* renamed from: a0  reason: collision with root package name */
    public ColorStateList f5957a0;

    /* renamed from: b0  reason: collision with root package name */
    public w7.f f5958b0;

    /* renamed from: c0  reason: collision with root package name */
    public w7.f f5959c0;

    /* renamed from: d0  reason: collision with root package name */
    public float f5960d0;

    /* renamed from: e0  reason: collision with root package name */
    public float f5961e0;

    /* renamed from: f0  reason: collision with root package name */
    public float f5962f0;

    /* renamed from: g0  reason: collision with root package name */
    public float f5963g0;

    /* renamed from: h0  reason: collision with root package name */
    public float f5964h0;

    /* renamed from: i0  reason: collision with root package name */
    public float f5965i0;

    /* renamed from: j0  reason: collision with root package name */
    public float f5966j0;

    /* renamed from: k0  reason: collision with root package name */
    public float f5967k0;

    /* renamed from: l0  reason: collision with root package name */
    public final Context f5968l0;

    /* renamed from: m0  reason: collision with root package name */
    public final Paint f5969m0 = new Paint(1);

    /* renamed from: n0  reason: collision with root package name */
    public final Paint.FontMetrics f5970n0 = new Paint.FontMetrics();

    /* renamed from: o0  reason: collision with root package name */
    public final RectF f5971o0 = new RectF();

    /* renamed from: p0  reason: collision with root package name */
    public final PointF f5972p0 = new PointF();

    /* renamed from: q0  reason: collision with root package name */
    public final Path f5973q0 = new Path();

    /* renamed from: r0  reason: collision with root package name */
    public final o f5974r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f5975s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f5976t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f5977u0;

    /* renamed from: v0  reason: collision with root package name */
    public int f5978v0;

    /* renamed from: w0  reason: collision with root package name */
    public int f5979w0;

    /* renamed from: x0  reason: collision with root package name */
    public int f5980x0;

    /* renamed from: y0  reason: collision with root package name */
    public boolean f5981y0;

    /* renamed from: z0  reason: collision with root package name */
    public int f5982z0;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.chipStyle, 2132018302);
        i(context);
        this.f5968l0 = context;
        o oVar = new o(this);
        this.f5974r0 = oVar;
        this.L = "";
        oVar.f10787a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = N0;
        setState(iArr);
        if (!Arrays.equals(this.F0, iArr)) {
            this.F0 = iArr;
            if (T()) {
                w(getState(), iArr);
            }
        }
        this.K0 = true;
        int[] iArr2 = d.f13884a;
        O0.setTint(-1);
    }

    public static void U(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public static boolean t(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean u(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z10) {
        if (this.Y != z10) {
            boolean R2 = R();
            this.Y = z10;
            boolean R3 = R();
            if (R2 != R3) {
                if (R3) {
                    o(this.Z);
                } else {
                    U(this.Z);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void B(float f10) {
        if (this.H != f10) {
            this.H = f10;
            setShapeAppearanceModel(this.f14744h.f14723a.e(f10));
        }
    }

    public final void C(Drawable drawable) {
        Drawable drawable2 = this.N;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof l) {
            drawable2 = ((m) ((l) drawable2)).f5427m;
        }
        if (drawable2 != drawable) {
            float q10 = q();
            if (drawable != null) {
                drawable3 = f0.d.g(drawable).mutate();
            }
            this.N = drawable3;
            float q11 = q();
            U(drawable2);
            if (S()) {
                o(this.N);
            }
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void D(float f10) {
        if (this.P != f10) {
            float q10 = q();
            this.P = f10;
            float q11 = q();
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        this.Q = true;
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (S()) {
                b.h(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z10) {
        if (this.M != z10) {
            boolean S2 = S();
            this.M = z10;
            boolean S3 = S();
            if (S2 != S3) {
                if (S3) {
                    o(this.N);
                } else {
                    U(this.N);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void G(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (this.M0) {
                h hVar = this.f14744h;
                if (hVar.f14726d != colorStateList) {
                    hVar.f14726d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void H(float f10) {
        if (this.J != f10) {
            this.J = f10;
            this.f5969m0.setStrokeWidth(f10);
            if (this.M0) {
                this.f14744h.f14733k = f10;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void I(Drawable drawable) {
        Drawable drawable2 = this.S;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof l) {
            drawable2 = ((m) ((l) drawable2)).f5427m;
        }
        if (drawable2 != drawable) {
            float r10 = r();
            if (drawable != null) {
                drawable3 = f0.d.g(drawable).mutate();
            }
            this.S = drawable3;
            int[] iArr = d.f13884a;
            this.T = new RippleDrawable(d.c(this.K), this.S, O0);
            float r11 = r();
            U(drawable2);
            if (T()) {
                o(this.S);
            }
            invalidateSelf();
            if (r10 != r11) {
                v();
            }
        }
    }

    public final void J(float f10) {
        if (this.f5966j0 != f10) {
            this.f5966j0 = f10;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void K(float f10) {
        if (this.V != f10) {
            this.V = f10;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void L(float f10) {
        if (this.f5965i0 != f10) {
            this.f5965i0 = f10;
            invalidateSelf();
            if (T()) {
                v();
            }
        }
    }

    public final void M(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (T()) {
                b.h(this.S, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void N(boolean z10) {
        if (this.R != z10) {
            boolean T2 = T();
            this.R = z10;
            boolean T3 = T();
            if (T2 != T3) {
                if (T3) {
                    o(this.S);
                } else {
                    U(this.S);
                }
                invalidateSelf();
                v();
            }
        }
    }

    public final void O(float f10) {
        if (this.f5962f0 != f10) {
            float q10 = q();
            this.f5962f0 = f10;
            float q11 = q();
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void P(float f10) {
        if (this.f5961e0 != f10) {
            float q10 = q();
            this.f5961e0 = f10;
            float q11 = q();
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        if (this.K != colorStateList) {
            this.K = colorStateList;
            if (this.G0) {
                colorStateList2 = d.c(colorStateList);
            } else {
                colorStateList2 = null;
            }
            this.H0 = colorStateList2;
            onStateChange(getState());
        }
    }

    public final boolean R() {
        return this.Y && this.Z != null && this.f5981y0;
    }

    public final boolean S() {
        return this.M && this.N != null;
    }

    public final boolean T() {
        return this.R && this.S != null;
    }

    public final void a() {
        v();
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        RectF rectF;
        int i13;
        int i14;
        boolean z10;
        int i15;
        float f10;
        int i16;
        Canvas canvas2 = canvas;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i10 = this.A0) != 0) {
            if (i10 < 255) {
                float f11 = (float) bounds.left;
                float f12 = (float) bounds.top;
                float f13 = (float) bounds.right;
                float f14 = (float) bounds.bottom;
                if (Build.VERSION.SDK_INT > 21) {
                    i16 = canvas.saveLayerAlpha(f11, f12, f13, f14, i10);
                } else {
                    i16 = canvas.saveLayerAlpha(f11, f12, f13, f14, i10, 31);
                }
                i11 = i16;
            } else {
                i11 = 0;
            }
            boolean z11 = this.M0;
            Paint paint = this.f5969m0;
            RectF rectF2 = this.f5971o0;
            if (!z11) {
                paint.setColor(this.f5975s0);
                paint.setStyle(Paint.Style.FILL);
                rectF2.set(bounds);
                canvas2.drawRoundRect(rectF2, s(), s(), paint);
            }
            if (!this.M0) {
                paint.setColor(this.f5976t0);
                paint.setStyle(Paint.Style.FILL);
                ColorFilter colorFilter = this.B0;
                if (colorFilter == null) {
                    colorFilter = this.C0;
                }
                paint.setColorFilter(colorFilter);
                rectF2.set(bounds);
                canvas2.drawRoundRect(rectF2, s(), s(), paint);
            }
            if (this.M0) {
                super.draw(canvas);
            }
            if (this.J > 0.0f && !this.M0) {
                paint.setColor(this.f5978v0);
                paint.setStyle(Paint.Style.STROKE);
                if (!this.M0) {
                    ColorFilter colorFilter2 = this.B0;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.C0;
                    }
                    paint.setColorFilter(colorFilter2);
                }
                float f15 = this.J / 2.0f;
                rectF2.set(((float) bounds.left) + f15, ((float) bounds.top) + f15, ((float) bounds.right) - f15, ((float) bounds.bottom) - f15);
                float f16 = this.H - (this.J / 2.0f);
                canvas2.drawRoundRect(rectF2, f16, f16, paint);
            }
            paint.setColor(this.f5979w0);
            paint.setStyle(Paint.Style.FILL);
            rectF2.set(bounds);
            if (!this.M0) {
                canvas2.drawRoundRect(rectF2, s(), s(), paint);
                i12 = 0;
            } else {
                RectF rectF3 = new RectF(bounds);
                Path path = this.f5973q0;
                p pVar = this.f14761y;
                h hVar = this.f14744h;
                pVar.a(hVar.f14723a, hVar.f14732j, rectF3, this.f14760x, path);
                RectF h10 = h();
                i12 = 0;
                f(canvas, paint, path, this.f14744h.f14723a, h10);
            }
            if (S()) {
                p(bounds, rectF2);
                float f17 = rectF2.left;
                float f18 = rectF2.top;
                canvas2.translate(f17, f18);
                this.N.setBounds(i12, i12, (int) rectF2.width(), (int) rectF2.height());
                this.N.draw(canvas2);
                canvas2.translate(-f17, -f18);
            }
            if (R()) {
                p(bounds, rectF2);
                float f19 = rectF2.left;
                float f20 = rectF2.top;
                canvas2.translate(f19, f20);
                this.Z.setBounds(i12, i12, (int) rectF2.width(), (int) rectF2.height());
                this.Z.draw(canvas2);
                canvas2.translate(-f19, -f20);
            }
            if (!this.K0 || this.L == null) {
                rectF = rectF2;
                i14 = i11;
                i13 = 255;
            } else {
                PointF pointF = this.f5972p0;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                CharSequence charSequence = this.L;
                o oVar = this.f5974r0;
                if (charSequence != null) {
                    float q10 = q() + this.f5960d0 + this.f5963g0;
                    if (f0.d.b(this) == 0) {
                        pointF.x = ((float) bounds.left) + q10;
                        align = Paint.Align.LEFT;
                    } else {
                        pointF.x = ((float) bounds.right) - q10;
                        align = Paint.Align.RIGHT;
                    }
                    TextPaint textPaint = oVar.f10787a;
                    Paint.FontMetrics fontMetrics = this.f5970n0;
                    textPaint.getFontMetrics(fontMetrics);
                    pointF.y = ((float) bounds.centerY()) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
                }
                rectF2.setEmpty();
                if (this.L != null) {
                    float q11 = q() + this.f5960d0 + this.f5963g0;
                    float r10 = r() + this.f5967k0 + this.f5964h0;
                    if (f0.d.b(this) == 0) {
                        rectF2.left = ((float) bounds.left) + q11;
                        f10 = ((float) bounds.right) - r10;
                    } else {
                        rectF2.left = ((float) bounds.left) + r10;
                        f10 = ((float) bounds.right) - q11;
                    }
                    rectF2.right = f10;
                    rectF2.top = (float) bounds.top;
                    rectF2.bottom = (float) bounds.bottom;
                }
                g gVar = oVar.f10792f;
                TextPaint textPaint2 = oVar.f10787a;
                if (gVar != null) {
                    textPaint2.drawableState = getState();
                    oVar.f10792f.e(this.f5968l0, textPaint2, oVar.f10788b);
                }
                textPaint2.setTextAlign(align);
                if (Math.round(oVar.a(this.L.toString())) > Math.round(rectF2.width())) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    i15 = canvas.save();
                    canvas2.clipRect(rectF2);
                } else {
                    i15 = 0;
                }
                CharSequence charSequence2 = this.L;
                if (z10 && this.J0 != null) {
                    charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF2.width(), this.J0);
                }
                CharSequence charSequence3 = charSequence2;
                int length = charSequence3.length();
                int i17 = length;
                i13 = 255;
                float f21 = pointF.x;
                rectF = rectF2;
                float f22 = pointF.y;
                i14 = i11;
                canvas.drawText(charSequence3, 0, i17, f21, f22, textPaint2);
                if (z10) {
                    canvas2.restoreToCount(i15);
                }
            }
            if (T()) {
                rectF.setEmpty();
                if (T()) {
                    float f23 = this.f5967k0 + this.f5966j0;
                    if (f0.d.b(this) == 0) {
                        float f24 = ((float) bounds.right) - f23;
                        rectF.right = f24;
                        rectF.left = f24 - this.V;
                    } else {
                        float f25 = ((float) bounds.left) + f23;
                        rectF.left = f25;
                        rectF.right = f25 + this.V;
                    }
                    float exactCenterY = bounds.exactCenterY();
                    float f26 = this.V;
                    float f27 = exactCenterY - (f26 / 2.0f);
                    rectF.top = f27;
                    rectF.bottom = f27 + f26;
                }
                float f28 = rectF.left;
                float f29 = rectF.top;
                canvas2.translate(f28, f29);
                this.S.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
                int[] iArr = d.f13884a;
                this.T.setBounds(this.S.getBounds());
                this.T.jumpToCurrentState();
                this.T.draw(canvas2);
                canvas2.translate(-f28, -f29);
            }
            if (this.A0 < i13) {
                canvas2.restoreToCount(i14);
            }
        }
    }

    public final int getAlpha() {
        return this.A0;
    }

    public final ColorFilter getColorFilter() {
        return this.B0;
    }

    public final int getIntrinsicHeight() {
        return (int) this.G;
    }

    public final int getIntrinsicWidth() {
        return Math.min(Math.round(r() + this.f5974r0.a(this.L.toString()) + q() + this.f5960d0 + this.f5963g0 + this.f5964h0 + this.f5967k0), this.L0);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void getOutline(Outline outline) {
        if (this.M0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.H);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.G, this.H);
        }
        outline.setAlpha(((float) this.A0) / 255.0f);
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final boolean isStateful() {
        boolean z10;
        boolean z11;
        ColorStateList colorStateList;
        if (t(this.E) || t(this.F) || t(this.I)) {
            return true;
        }
        if (this.G0 && t(this.H0)) {
            return true;
        }
        g gVar = this.f5974r0.f10792f;
        if (gVar == null || (colorStateList = gVar.f13426j) == null || !colorStateList.isStateful()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return true;
        }
        if (!this.Y || this.Z == null || !this.X) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 || u(this.N) || u(this.Z) || t(this.D0)) {
            return true;
        }
        return false;
    }

    public final void o(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            f0.d.c(drawable, f0.d.b(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.S) {
                if (drawable.isStateful()) {
                    drawable.setState(this.F0);
                }
                b.h(drawable, this.U);
                return;
            }
            Drawable drawable2 = this.N;
            if (drawable == drawable2 && this.Q) {
                b.h(drawable2, this.O);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    public final boolean onLayoutDirectionChanged(int i10) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (S()) {
            onLayoutDirectionChanged |= f0.d.c(this.N, i10);
        }
        if (R()) {
            onLayoutDirectionChanged |= f0.d.c(this.Z, i10);
        }
        if (T()) {
            onLayoutDirectionChanged |= f0.d.c(this.S, i10);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    public final boolean onLevelChange(int i10) {
        boolean onLevelChange = super.onLevelChange(i10);
        if (S()) {
            onLevelChange |= this.N.setLevel(i10);
        }
        if (R()) {
            onLevelChange |= this.Z.setLevel(i10);
        }
        if (T()) {
            onLevelChange |= this.S.setLevel(i10);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final boolean onStateChange(int[] iArr) {
        if (this.M0) {
            super.onStateChange(iArr);
        }
        return w(iArr, this.F0);
    }

    public final void p(Rect rect, RectF rectF) {
        Drawable drawable;
        Drawable drawable2;
        float f10;
        rectF.setEmpty();
        if (S() || R()) {
            float f11 = this.f5960d0 + this.f5961e0;
            if (this.f5981y0) {
                drawable = this.Z;
            } else {
                drawable = this.N;
            }
            float f12 = this.P;
            if (f12 <= 0.0f && drawable != null) {
                f12 = (float) drawable.getIntrinsicWidth();
            }
            if (f0.d.b(this) == 0) {
                float f13 = ((float) rect.left) + f11;
                rectF.left = f13;
                rectF.right = f13 + f12;
            } else {
                float f14 = ((float) rect.right) - f11;
                rectF.right = f14;
                rectF.left = f14 - f12;
            }
            if (this.f5981y0) {
                drawable2 = this.Z;
            } else {
                drawable2 = this.N;
            }
            float f15 = this.P;
            if (f15 <= 0.0f && drawable2 != null) {
                f15 = (float) Math.ceil((double) w.b(this.f5968l0, 24));
                if (((float) drawable2.getIntrinsicHeight()) <= f15) {
                    f10 = (float) drawable2.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f10 / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f10;
                }
            }
            f10 = f15;
            float exactCenterY2 = rect.exactCenterY() - (f10 / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f10;
        }
    }

    public final float q() {
        Drawable drawable;
        if (!S() && !R()) {
            return 0.0f;
        }
        float f10 = this.f5961e0;
        if (this.f5981y0) {
            drawable = this.Z;
        } else {
            drawable = this.N;
        }
        float f11 = this.P;
        if (f11 <= 0.0f && drawable != null) {
            f11 = (float) drawable.getIntrinsicWidth();
        }
        return f11 + f10 + this.f5962f0;
    }

    public final float r() {
        if (T()) {
            return this.f5965i0 + this.V + this.f5966j0;
        }
        return 0.0f;
    }

    public final float s() {
        if (this.M0) {
            return this.f14744h.f14723a.f14782e.a(h());
        }
        return this.H;
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    public final void setAlpha(int i10) {
        if (this.A0 != i10) {
            this.A0 = i10;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.B0 != colorFilter) {
            this.B0 = colorFilter;
            invalidateSelf();
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (this.E0 != mode) {
            this.E0 = mode;
            ColorStateList colorStateList = this.D0;
            if (colorStateList == null || mode == null) {
                porterDuffColorFilter = null;
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
            this.C0 = porterDuffColorFilter;
            invalidateSelf();
        }
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (S()) {
            visible |= this.N.setVisible(z10, z11);
        }
        if (R()) {
            visible |= this.Z.setVisible(z10, z11);
        }
        if (T()) {
            visible |= this.S.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v() {
        e eVar = (e) this.I0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.b(chip.f3730w);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean w(int[] r9, int[] r10) {
        /*
            r8 = this;
            boolean r0 = super.onStateChange(r9)
            android.content.res.ColorStateList r1 = r8.E
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r8.f5975s0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r1 = r8.d(r1)
            int r3 = r8.f5975s0
            r4 = 1
            if (r3 == r1) goto L_0x001d
            r8.f5975s0 = r1
            r0 = 1
        L_0x001d:
            android.content.res.ColorStateList r3 = r8.F
            if (r3 == 0) goto L_0x0028
            int r5 = r8.f5976t0
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x0029
        L_0x0028:
            r3 = 0
        L_0x0029:
            int r3 = r8.d(r3)
            int r5 = r8.f5976t0
            if (r5 == r3) goto L_0x0034
            r8.f5976t0 = r3
            r0 = 1
        L_0x0034:
            int r1 = e0.a.b(r3, r1)
            int r3 = r8.f5977u0
            if (r3 == r1) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            t8.h r5 = r8.f14744h
            android.content.res.ColorStateList r5 = r5.f14725c
            if (r5 != 0) goto L_0x0047
            r5 = 1
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x0055
            r8.f5977u0 = r1
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r1)
            r8.k(r0)
            r0 = 1
        L_0x0055:
            android.content.res.ColorStateList r1 = r8.I
            if (r1 == 0) goto L_0x0060
            int r3 = r8.f5978v0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            int r3 = r8.f5978v0
            if (r3 == r1) goto L_0x0068
            r8.f5978v0 = r1
            r0 = 1
        L_0x0068:
            android.content.res.ColorStateList r1 = r8.H0
            if (r1 == 0) goto L_0x007b
            boolean r1 = r8.d.d(r9)
            if (r1 == 0) goto L_0x007b
            android.content.res.ColorStateList r1 = r8.H0
            int r3 = r8.f5979w0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x007c
        L_0x007b:
            r1 = 0
        L_0x007c:
            int r3 = r8.f5979w0
            if (r3 == r1) goto L_0x0087
            r8.f5979w0 = r1
            boolean r1 = r8.G0
            if (r1 == 0) goto L_0x0087
            r0 = 1
        L_0x0087:
            m8.o r1 = r8.f5974r0
            q8.g r1 = r1.f10792f
            if (r1 == 0) goto L_0x0098
            android.content.res.ColorStateList r1 = r1.f13426j
            if (r1 == 0) goto L_0x0098
            int r3 = r8.f5980x0
            int r1 = r1.getColorForState(r9, r3)
            goto L_0x0099
        L_0x0098:
            r1 = 0
        L_0x0099:
            int r3 = r8.f5980x0
            if (r3 == r1) goto L_0x00a0
            r8.f5980x0 = r1
            r0 = 1
        L_0x00a0:
            int[] r1 = r8.getState()
            if (r1 != 0) goto L_0x00a7
            goto L_0x00b7
        L_0x00a7:
            int r3 = r1.length
            r5 = 0
        L_0x00a9:
            if (r5 >= r3) goto L_0x00b7
            r6 = r1[r5]
            r7 = 16842912(0x10100a0, float:2.3694006E-38)
            if (r6 != r7) goto L_0x00b4
            r1 = 1
            goto L_0x00b8
        L_0x00b4:
            int r5 = r5 + 1
            goto L_0x00a9
        L_0x00b7:
            r1 = 0
        L_0x00b8:
            if (r1 == 0) goto L_0x00c0
            boolean r1 = r8.X
            if (r1 == 0) goto L_0x00c0
            r1 = 1
            goto L_0x00c1
        L_0x00c0:
            r1 = 0
        L_0x00c1:
            boolean r3 = r8.f5981y0
            if (r3 == r1) goto L_0x00db
            android.graphics.drawable.Drawable r3 = r8.Z
            if (r3 == 0) goto L_0x00db
            float r0 = r8.q()
            r8.f5981y0 = r1
            float r1 = r8.q()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00da
            r0 = 1
            r1 = 1
            goto L_0x00dc
        L_0x00da:
            r0 = 1
        L_0x00db:
            r1 = 0
        L_0x00dc:
            android.content.res.ColorStateList r3 = r8.D0
            if (r3 == 0) goto L_0x00e7
            int r5 = r8.f5982z0
            int r3 = r3.getColorForState(r9, r5)
            goto L_0x00e8
        L_0x00e7:
            r3 = 0
        L_0x00e8:
            int r5 = r8.f5982z0
            if (r5 == r3) goto L_0x0109
            r8.f5982z0 = r3
            android.content.res.ColorStateList r0 = r8.D0
            android.graphics.PorterDuff$Mode r3 = r8.E0
            if (r0 == 0) goto L_0x0105
            if (r3 != 0) goto L_0x00f7
            goto L_0x0105
        L_0x00f7:
            int[] r5 = r8.getState()
            int r0 = r0.getColorForState(r5, r2)
            android.graphics.PorterDuffColorFilter r5 = new android.graphics.PorterDuffColorFilter
            r5.<init>(r0, r3)
            goto L_0x0106
        L_0x0105:
            r5 = 0
        L_0x0106:
            r8.C0 = r5
            goto L_0x010a
        L_0x0109:
            r4 = r0
        L_0x010a:
            android.graphics.drawable.Drawable r0 = r8.N
            boolean r0 = u(r0)
            if (r0 == 0) goto L_0x0119
            android.graphics.drawable.Drawable r0 = r8.N
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0119:
            android.graphics.drawable.Drawable r0 = r8.Z
            boolean r0 = u(r0)
            if (r0 == 0) goto L_0x0128
            android.graphics.drawable.Drawable r0 = r8.Z
            boolean r0 = r0.setState(r9)
            r4 = r4 | r0
        L_0x0128:
            android.graphics.drawable.Drawable r0 = r8.S
            boolean r0 = u(r0)
            if (r0 == 0) goto L_0x0145
            int r0 = r9.length
            int r3 = r10.length
            int r0 = r0 + r3
            int[] r0 = new int[r0]
            int r3 = r9.length
            java.lang.System.arraycopy(r9, r2, r0, r2, r3)
            int r9 = r9.length
            int r3 = r10.length
            java.lang.System.arraycopy(r10, r2, r0, r9, r3)
            android.graphics.drawable.Drawable r9 = r8.S
            boolean r9 = r9.setState(r0)
            r4 = r4 | r9
        L_0x0145:
            int[] r9 = r8.d.f13884a
            android.graphics.drawable.RippleDrawable r9 = r8.T
            boolean r9 = u(r9)
            if (r9 == 0) goto L_0x0156
            android.graphics.drawable.RippleDrawable r9 = r8.T
            boolean r9 = r9.setState(r10)
            r4 = r4 | r9
        L_0x0156:
            if (r4 == 0) goto L_0x015b
            r8.invalidateSelf()
        L_0x015b:
            if (r1 == 0) goto L_0x0160
            r8.v()
        L_0x0160:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: f8.f.w(int[], int[]):boolean");
    }

    public final void x(boolean z10) {
        if (this.X != z10) {
            this.X = z10;
            float q10 = q();
            if (!z10 && this.f5981y0) {
                this.f5981y0 = false;
            }
            float q11 = q();
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void y(Drawable drawable) {
        if (this.Z != drawable) {
            float q10 = q();
            this.Z = drawable;
            float q11 = q();
            U(this.Z);
            o(this.Z);
            invalidateSelf();
            if (q10 != q11) {
                v();
            }
        }
    }

    public final void z(ColorStateList colorStateList) {
        boolean z10;
        if (this.f5957a0 != colorStateList) {
            this.f5957a0 = colorStateList;
            if (!this.Y || this.Z == null || !this.X) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                b.h(this.Z, colorStateList);
            }
            onStateChange(getState());
        }
    }
}
