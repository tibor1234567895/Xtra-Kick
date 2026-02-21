package c4;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import f0.a;
import f0.b;
import f0.d;
import org.xmlpull.v1.XmlPullParser;

public final class s extends j {

    /* renamed from: q  reason: collision with root package name */
    public static final PorterDuff.Mode f2949q = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public q f2950i;

    /* renamed from: j  reason: collision with root package name */
    public PorterDuffColorFilter f2951j;

    /* renamed from: k  reason: collision with root package name */
    public ColorFilter f2952k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2953l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f2954m;

    /* renamed from: n  reason: collision with root package name */
    public final float[] f2955n;

    /* renamed from: o  reason: collision with root package name */
    public final Matrix f2956o;

    /* renamed from: p  reason: collision with root package name */
    public final Rect f2957p;

    public s() {
        this.f2954m = true;
        this.f2955n = new float[9];
        this.f2956o = new Matrix();
        this.f2957p = new Rect();
        this.f2950i = new q();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final boolean canApplyTheme() {
        Drawable drawable = this.f2892h;
        if (drawable == null) {
            return false;
        }
        b.b(drawable);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        if (r10 == false) goto L_0x00c1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            android.graphics.drawable.Drawable r2 = r0.f2892h
            if (r2 == 0) goto L_0x000c
            r2.draw(r1)
            return
        L_0x000c:
            android.graphics.Rect r2 = r0.f2957p
            r0.copyBounds(r2)
            int r3 = r2.width()
            if (r3 <= 0) goto L_0x0181
            int r3 = r2.height()
            if (r3 > 0) goto L_0x001f
            goto L_0x0181
        L_0x001f:
            android.graphics.ColorFilter r3 = r0.f2952k
            if (r3 != 0) goto L_0x0025
            android.graphics.PorterDuffColorFilter r3 = r0.f2951j
        L_0x0025:
            android.graphics.Matrix r4 = r0.f2956o
            r1.getMatrix(r4)
            float[] r5 = r0.f2955n
            r4.getValues(r5)
            r4 = 0
            r6 = r5[r4]
            float r6 = java.lang.Math.abs(r6)
            r7 = 4
            r7 = r5[r7]
            float r7 = java.lang.Math.abs(r7)
            r8 = 1
            r9 = r5[r8]
            float r9 = java.lang.Math.abs(r9)
            r10 = 3
            r5 = r5[r10]
            float r5 = java.lang.Math.abs(r5)
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0056
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x005a
        L_0x0056:
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x005a:
            int r5 = r2.width()
            float r5 = (float) r5
            float r5 = r5 * r6
            int r5 = (int) r5
            int r6 = r2.height()
            float r6 = (float) r6
            float r6 = r6 * r7
            int r6 = (int) r6
            r7 = 2048(0x800, float:2.87E-42)
            int r5 = java.lang.Math.min(r7, r5)
            int r6 = java.lang.Math.min(r7, r6)
            if (r5 <= 0) goto L_0x0181
            if (r6 > 0) goto L_0x007a
            goto L_0x0181
        L_0x007a:
            int r7 = r19.save()
            int r9 = r2.left
            float r9 = (float) r9
            int r12 = r2.top
            float r12 = (float) r12
            r1.translate(r9, r12)
            boolean r9 = r18.isAutoMirrored()
            if (r9 == 0) goto L_0x0095
            int r9 = f0.d.b(r18)
            if (r9 != r8) goto L_0x0095
            r9 = 1
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            if (r9 == 0) goto L_0x00a5
            int r9 = r2.width()
            float r9 = (float) r9
            r1.translate(r9, r11)
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.scale(r9, r10)
        L_0x00a5:
            r2.offsetTo(r4, r4)
            c4.q r9 = r0.f2950i
            android.graphics.Bitmap r10 = r9.f2941f
            if (r10 == 0) goto L_0x00c1
            int r10 = r10.getWidth()
            if (r5 != r10) goto L_0x00be
            android.graphics.Bitmap r10 = r9.f2941f
            int r10 = r10.getHeight()
            if (r6 != r10) goto L_0x00be
            r10 = 1
            goto L_0x00bf
        L_0x00be:
            r10 = 0
        L_0x00bf:
            if (r10 != 0) goto L_0x00cb
        L_0x00c1:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r5, r6, r10)
            r9.f2941f = r10
            r9.f2946k = r8
        L_0x00cb:
            boolean r9 = r0.f2954m
            if (r9 != 0) goto L_0x00eb
            c4.q r9 = r0.f2950i
            android.graphics.Bitmap r10 = r9.f2941f
            r10.eraseColor(r4)
            android.graphics.Canvas r15 = new android.graphics.Canvas
            android.graphics.Bitmap r10 = r9.f2941f
            r15.<init>(r10)
            c4.p r12 = r9.f2937b
            c4.m r13 = r12.f2927g
            android.graphics.Matrix r14 = c4.p.f2920p
            r16 = r5
            r17 = r6
            r12.a(r13, r14, r15, r16, r17)
            goto L_0x0145
        L_0x00eb:
            c4.q r9 = r0.f2950i
            boolean r10 = r9.f2946k
            if (r10 != 0) goto L_0x010f
            android.content.res.ColorStateList r10 = r9.f2942g
            android.content.res.ColorStateList r11 = r9.f2938c
            if (r10 != r11) goto L_0x010f
            android.graphics.PorterDuff$Mode r10 = r9.f2943h
            android.graphics.PorterDuff$Mode r11 = r9.f2939d
            if (r10 != r11) goto L_0x010f
            boolean r10 = r9.f2945j
            boolean r11 = r9.f2940e
            if (r10 != r11) goto L_0x010f
            int r10 = r9.f2944i
            c4.p r9 = r9.f2937b
            int r9 = r9.getRootAlpha()
            if (r10 != r9) goto L_0x010f
            r9 = 1
            goto L_0x0110
        L_0x010f:
            r9 = 0
        L_0x0110:
            if (r9 != 0) goto L_0x0145
            c4.q r9 = r0.f2950i
            android.graphics.Bitmap r10 = r9.f2941f
            r10.eraseColor(r4)
            android.graphics.Canvas r15 = new android.graphics.Canvas
            android.graphics.Bitmap r10 = r9.f2941f
            r15.<init>(r10)
            c4.p r12 = r9.f2937b
            c4.m r13 = r12.f2927g
            android.graphics.Matrix r14 = c4.p.f2920p
            r16 = r5
            r17 = r6
            r12.a(r13, r14, r15, r16, r17)
            c4.q r5 = r0.f2950i
            android.content.res.ColorStateList r6 = r5.f2938c
            r5.f2942g = r6
            android.graphics.PorterDuff$Mode r6 = r5.f2939d
            r5.f2943h = r6
            c4.p r6 = r5.f2937b
            int r6 = r6.getRootAlpha()
            r5.f2944i = r6
            boolean r6 = r5.f2940e
            r5.f2945j = r6
            r5.f2946k = r4
        L_0x0145:
            c4.q r5 = r0.f2950i
            c4.p r6 = r5.f2937b
            int r6 = r6.getRootAlpha()
            r9 = 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L_0x0152
            r4 = 1
        L_0x0152:
            r6 = 0
            if (r4 != 0) goto L_0x0159
            if (r3 != 0) goto L_0x0159
            r3 = r6
            goto L_0x0179
        L_0x0159:
            android.graphics.Paint r4 = r5.f2947l
            if (r4 != 0) goto L_0x0167
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r5.f2947l = r4
            r4.setFilterBitmap(r8)
        L_0x0167:
            android.graphics.Paint r4 = r5.f2947l
            c4.p r8 = r5.f2937b
            int r8 = r8.getRootAlpha()
            r4.setAlpha(r8)
            android.graphics.Paint r4 = r5.f2947l
            r4.setColorFilter(r3)
            android.graphics.Paint r3 = r5.f2947l
        L_0x0179:
            android.graphics.Bitmap r4 = r5.f2941f
            r1.drawBitmap(r4, r6, r2, r3)
            r1.restoreToCount(r7)
        L_0x0181:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return a.a(drawable);
        }
        return this.f2950i.f2937b.getRootAlpha();
    }

    public final int getChangingConfigurations() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f2950i.getChangingConfigurations();
    }

    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return b.c(drawable);
        }
        return this.f2952k;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.f2892h != null && Build.VERSION.SDK_INT >= 24) {
            return new r(this.f2892h.getConstantState());
        }
        this.f2950i.f2936a = getChangingConfigurations();
        return this.f2950i;
    }

    public final int getIntrinsicHeight() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f2950i.f2937b.f2929i;
    }

    public final int getIntrinsicWidth() {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f2950i.f2937b.f2928h;
    }

    public final int getOpacity() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public final void invalidateSelf() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final boolean isAutoMirrored() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return a.d(drawable);
        }
        return this.f2950i.f2940e;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            q qVar = this.f2950i;
            if (qVar != null) {
                p pVar = qVar.f2937b;
                if (pVar.f2934n == null) {
                    pVar.f2934n = Boolean.valueOf(pVar.f2927g.a());
                }
                if (pVar.f2934n.booleanValue() || ((colorStateList = this.f2950i.f2938c) != null && colorStateList.isStateful())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final Drawable mutate() {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f2953l && super.mutate() == this) {
            this.f2950i = new q(this.f2950i);
            this.f2953l = true;
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        q qVar = this.f2950i;
        ColorStateList colorStateList = qVar.f2938c;
        if (colorStateList == null || (mode = qVar.f2939d) == null) {
            z10 = false;
        } else {
            this.f2951j = a(colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        p pVar = qVar.f2937b;
        if (pVar.f2934n == null) {
            pVar.f2934n = Boolean.valueOf(pVar.f2927g.a());
        }
        if (pVar.f2934n.booleanValue()) {
            boolean b10 = qVar.f2937b.f2927g.b(iArr);
            qVar.f2946k |= b10;
            if (b10) {
                invalidateSelf();
                return true;
            }
        }
        return z10;
    }

    public final void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    public final void setAlpha(int i10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f2950i.f2937b.getRootAlpha() != i10) {
            this.f2950i.f2937b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            a.e(drawable, z10);
        } else {
            this.f2950i.f2940e = z10;
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f2952k = colorFilter;
        invalidateSelf();
    }

    public final void setTint(int i10) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            d.d(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.h(drawable, colorStateList);
            return;
        }
        q qVar = this.f2950i;
        if (qVar.f2938c != colorStateList) {
            qVar.f2938c = colorStateList;
            this.f2951j = a(colorStateList, qVar.f2939d);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            b.i(drawable, mode);
            return;
        }
        q qVar = this.f2950i;
        if (qVar.f2939d != mode) {
            qVar.f2939d = mode;
            this.f2951j = a(qVar.f2938c, mode);
            invalidateSelf();
        }
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f2892h;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f2892h;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public s(q qVar) {
        this.f2954m = true;
        this.f2955n = new float[9];
        this.f2956o = new Matrix();
        this.f2957p = new Rect();
        this.f2950i = qVar;
        this.f2951j = a(qVar.f2938c, qVar.f2939d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void inflate(android.content.res.Resources r22, org.xmlpull.v1.XmlPullParser r23, android.util.AttributeSet r24, android.content.res.Resources.Theme r25) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            android.graphics.drawable.Drawable r0 = r1.f2892h
            if (r0 == 0) goto L_0x0012
            f0.b.d(r0, r2, r3, r4, r5)
            return
        L_0x0012:
            c4.q r6 = r1.f2950i
            c4.p r0 = new c4.p
            r0.<init>()
            r6.f2937b = r0
            int[] r0 = c4.a.f2865a
            android.content.res.TypedArray r7 = d0.t.h(r2, r5, r4, r0)
            c4.q r8 = r1.f2950i
            c4.p r9 = r8.f2937b
            java.lang.String r0 = "tintMode"
            r10 = 6
            r11 = -1
            int r0 = d0.t.d(r7, r3, r0, r10, r11)
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_IN
            r13 = 9
            r14 = 5
            r15 = 3
            if (r0 == r15) goto L_0x0049
            if (r0 == r14) goto L_0x004b
            if (r0 == r13) goto L_0x0046
            switch(r0) {
                case 14: goto L_0x0043;
                case 15: goto L_0x0040;
                case 16: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x004b
        L_0x003d:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.ADD
            goto L_0x004b
        L_0x0040:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SCREEN
            goto L_0x004b
        L_0x0043:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x004b
        L_0x0046:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_ATOP
            goto L_0x004b
        L_0x0049:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_OVER
        L_0x004b:
            r8.f2939d = r12
            java.lang.String r0 = "tint"
            boolean r0 = d0.t.g(r3, r0)
            r12 = 0
            r10 = 2
            r13 = 1
            if (r0 == 0) goto L_0x00a3
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r7.getValue(r13, r0)
            int r11 = r0.type
            if (r11 == r10) goto L_0x008f
            r10 = 28
            if (r11 < r10) goto L_0x0073
            r10 = 31
            if (r11 > r10) goto L_0x0073
            int r0 = r0.data
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            goto L_0x00a4
        L_0x0073:
            android.content.res.Resources r0 = r7.getResources()
            int r10 = r7.getResourceId(r13, r12)
            java.lang.ThreadLocal r11 = d0.c.f4089a
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)     // Catch:{ Exception -> 0x0086 }
            android.content.res.ColorStateList r0 = d0.c.a(r0, r10, r5)     // Catch:{ Exception -> 0x0086 }
            goto L_0x00a4
        L_0x0086:
            r0 = move-exception
            java.lang.String r10 = "CSLCompat"
            java.lang.String r11 = "Failed to inflate ColorStateList."
            android.util.Log.e(r10, r11, r0)
            goto L_0x00a3
        L_0x008f:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Failed to resolve attribute at index 1: "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00a3:
            r0 = 0
        L_0x00a4:
            if (r0 == 0) goto L_0x00a8
            r8.f2938c = r0
        L_0x00a8:
            boolean r0 = r8.f2940e
            java.lang.String r10 = "autoMirrored"
            boolean r10 = d0.t.g(r3, r10)
            if (r10 != 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            boolean r0 = r7.getBoolean(r14, r0)
        L_0x00b7:
            r8.f2940e = r0
            float r0 = r9.f2930j
            java.lang.String r8 = "viewportWidth"
            r10 = 7
            float r0 = d0.t.c(r7, r3, r8, r10, r0)
            r9.f2930j = r0
            float r0 = r9.f2931k
            java.lang.String r8 = "viewportHeight"
            r11 = 8
            float r0 = d0.t.c(r7, r3, r8, r11, r0)
            r9.f2931k = r0
            float r8 = r9.f2930j
            r17 = 0
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x03c9
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x03ae
            float r0 = r9.f2928h
            float r0 = r7.getDimension(r15, r0)
            r9.f2928h = r0
            float r0 = r9.f2929i
            r8 = 2
            float r0 = r7.getDimension(r8, r0)
            r9.f2929i = r0
            float r8 = r9.f2928h
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x0393
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0378
            float r0 = r9.getAlpha()
            java.lang.String r8 = "alpha"
            r14 = 4
            float r0 = d0.t.c(r7, r3, r8, r14, r0)
            r9.setAlpha(r0)
            java.lang.String r0 = r7.getString(r12)
            if (r0 == 0) goto L_0x0112
            r9.f2933m = r0
            q.e r8 = r9.f2935o
            r8.put(r0, r9)
        L_0x0112:
            r7.recycle()
            int r0 = r21.getChangingConfigurations()
            r6.f2936a = r0
            r6.f2946k = r13
            c4.q r0 = r1.f2950i
            c4.p r7 = r0.f2937b
            java.util.ArrayDeque r8 = new java.util.ArrayDeque
            r8.<init>()
            c4.m r9 = r7.f2927g
            r8.push(r9)
            int r9 = r23.getEventType()
            int r18 = r23.getDepth()
            int r10 = r18 + 1
            r18 = 1
        L_0x0137:
            if (r9 == r13) goto L_0x0363
            int r14 = r23.getDepth()
            if (r14 >= r10) goto L_0x0141
            if (r9 == r15) goto L_0x0363
        L_0x0141:
            java.lang.String r14 = "group"
            r15 = 2
            if (r9 != r15) goto L_0x033c
            java.lang.String r9 = r23.getName()
            java.lang.Object r15 = r8.peek()
            c4.m r15 = (c4.m) r15
            java.lang.String r11 = "path"
            boolean r11 = r11.equals(r9)
            q.e r13 = r7.f2935o
            java.lang.String r12 = "fillType"
            r19 = r7
            java.lang.String r7 = "pathData"
            if (r11 == 0) goto L_0x0258
            c4.l r9 = new c4.l
            r9.<init>()
            int[] r11 = c4.a.f2867c
            android.content.res.TypedArray r11 = d0.t.h(r2, r5, r4, r11)
            boolean r7 = d0.t.g(r3, r7)
            if (r7 != 0) goto L_0x0175
            r20 = r10
            goto L_0x0235
        L_0x0175:
            r7 = 0
            java.lang.String r14 = r11.getString(r7)
            if (r14 == 0) goto L_0x017e
            r9.f2917b = r14
        L_0x017e:
            r7 = 2
            java.lang.String r14 = r11.getString(r7)
            if (r14 == 0) goto L_0x018b
            e0.h[] r7 = e0.i.c(r14)
            r9.f2916a = r7
        L_0x018b:
            java.lang.String r7 = "fillColor"
            r14 = 1
            d0.d r7 = d0.t.b(r11, r3, r5, r7, r14)
            r9.f2895g = r7
            float r7 = r9.f2897i
            java.lang.String r14 = "fillAlpha"
            r20 = r10
            r10 = 12
            float r7 = d0.t.c(r11, r3, r14, r10, r7)
            r9.f2897i = r7
            java.lang.String r7 = "strokeLineCap"
            r10 = 8
            r14 = -1
            int r7 = d0.t.d(r11, r3, r7, r10, r14)
            android.graphics.Paint$Cap r14 = r9.f2901m
            if (r7 == 0) goto L_0x01bc
            r10 = 1
            if (r7 == r10) goto L_0x01b9
            r10 = 2
            if (r7 == r10) goto L_0x01b6
            goto L_0x01be
        L_0x01b6:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.SQUARE
            goto L_0x01be
        L_0x01b9:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.ROUND
            goto L_0x01be
        L_0x01bc:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.BUTT
        L_0x01be:
            r9.f2901m = r14
            java.lang.String r7 = "strokeLineJoin"
            r10 = 9
            r14 = -1
            int r7 = d0.t.d(r11, r3, r7, r10, r14)
            android.graphics.Paint$Join r10 = r9.f2902n
            if (r7 == 0) goto L_0x01da
            r14 = 1
            if (r7 == r14) goto L_0x01d7
            r14 = 2
            if (r7 == r14) goto L_0x01d4
            goto L_0x01dc
        L_0x01d4:
            android.graphics.Paint$Join r10 = android.graphics.Paint.Join.BEVEL
            goto L_0x01dc
        L_0x01d7:
            android.graphics.Paint$Join r10 = android.graphics.Paint.Join.ROUND
            goto L_0x01dc
        L_0x01da:
            android.graphics.Paint$Join r10 = android.graphics.Paint.Join.MITER
        L_0x01dc:
            r9.f2902n = r10
            float r7 = r9.f2903o
            java.lang.String r10 = "strokeMiterLimit"
            r14 = 10
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2903o = r7
            java.lang.String r7 = "strokeColor"
            r10 = 3
            d0.d r7 = d0.t.b(r11, r3, r5, r7, r10)
            r9.f2893e = r7
            float r7 = r9.f2896h
            java.lang.String r10 = "strokeAlpha"
            r14 = 11
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2896h = r7
            float r7 = r9.f2894f
            java.lang.String r10 = "strokeWidth"
            r14 = 4
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2894f = r7
            float r7 = r9.f2899k
            java.lang.String r10 = "trimPathEnd"
            r14 = 6
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2899k = r7
            float r7 = r9.f2900l
            java.lang.String r10 = "trimPathOffset"
            r14 = 7
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2900l = r7
            float r7 = r9.f2898j
            java.lang.String r10 = "trimPathStart"
            r14 = 5
            float r7 = d0.t.c(r11, r3, r10, r14, r7)
            r9.f2898j = r7
            int r7 = r9.f2918c
            r10 = 13
            int r7 = d0.t.d(r11, r3, r12, r10, r7)
            r9.f2918c = r7
        L_0x0235:
            r11.recycle()
            java.util.ArrayList r7 = r15.f2905b
            r7.add(r9)
            java.lang.String r7 = r9.getPathName()
            if (r7 == 0) goto L_0x024a
            java.lang.String r7 = r9.getPathName()
            r13.put(r7, r9)
        L_0x024a:
            int r7 = r0.f2936a
            int r9 = r9.f2919d
            r7 = r7 | r9
            r0.f2936a = r7
            r10 = 0
            r12 = 7
            r14 = 5
            r18 = 0
            goto L_0x0339
        L_0x0258:
            r20 = r10
            r10 = -1
            java.lang.String r11 = "clip-path"
            boolean r11 = r11.equals(r9)
            if (r11 == 0) goto L_0x02b0
            c4.k r9 = new c4.k
            r9.<init>()
            boolean r7 = d0.t.g(r3, r7)
            if (r7 != 0) goto L_0x026f
            goto L_0x0295
        L_0x026f:
            int[] r7 = c4.a.f2868d
            android.content.res.TypedArray r7 = d0.t.h(r2, r5, r4, r7)
            r11 = 0
            java.lang.String r14 = r7.getString(r11)
            if (r14 == 0) goto L_0x027e
            r9.f2917b = r14
        L_0x027e:
            r14 = 1
            java.lang.String r16 = r7.getString(r14)
            if (r16 == 0) goto L_0x028b
            e0.h[] r14 = e0.i.c(r16)
            r9.f2916a = r14
        L_0x028b:
            r14 = 2
            int r12 = d0.t.d(r7, r3, r12, r14, r11)
            r9.f2918c = r12
            r7.recycle()
        L_0x0295:
            java.util.ArrayList r7 = r15.f2905b
            r7.add(r9)
            java.lang.String r7 = r9.getPathName()
            if (r7 == 0) goto L_0x02a7
            java.lang.String r7 = r9.getPathName()
            r13.put(r7, r9)
        L_0x02a7:
            int r7 = r0.f2936a
            int r9 = r9.f2919d
            r7 = r7 | r9
            r0.f2936a = r7
            goto L_0x0336
        L_0x02b0:
            boolean r7 = r14.equals(r9)
            if (r7 == 0) goto L_0x0336
            c4.m r7 = new c4.m
            r7.<init>()
            int[] r9 = c4.a.f2866b
            android.content.res.TypedArray r9 = d0.t.h(r2, r5, r4, r9)
            float r11 = r7.f2906c
            java.lang.String r12 = "rotation"
            r14 = 5
            float r11 = d0.t.c(r9, r3, r12, r14, r11)
            r7.f2906c = r11
            float r11 = r7.f2907d
            r12 = 1
            float r11 = r9.getFloat(r12, r11)
            r7.f2907d = r11
            float r11 = r7.f2908e
            r10 = 2
            float r11 = r9.getFloat(r10, r11)
            r7.f2908e = r11
            float r11 = r7.f2909f
            java.lang.String r10 = "scaleX"
            r12 = 3
            float r10 = d0.t.c(r9, r3, r10, r12, r11)
            r7.f2909f = r10
            float r10 = r7.f2910g
            java.lang.String r11 = "scaleY"
            r12 = 4
            float r10 = d0.t.c(r9, r3, r11, r12, r10)
            r7.f2910g = r10
            float r10 = r7.f2911h
            java.lang.String r11 = "translateX"
            r12 = 6
            float r10 = d0.t.c(r9, r3, r11, r12, r10)
            r7.f2911h = r10
            float r10 = r7.f2912i
            java.lang.String r11 = "translateY"
            r12 = 7
            float r10 = d0.t.c(r9, r3, r11, r12, r10)
            r7.f2912i = r10
            r10 = 0
            java.lang.String r11 = r9.getString(r10)
            if (r11 == 0) goto L_0x0313
            r7.f2915l = r11
        L_0x0313:
            r7.c()
            r9.recycle()
            java.util.ArrayList r9 = r15.f2905b
            r9.add(r7)
            r8.push(r7)
            java.lang.String r9 = r7.getGroupName()
            if (r9 == 0) goto L_0x032e
            java.lang.String r9 = r7.getGroupName()
            r13.put(r9, r7)
        L_0x032e:
            int r9 = r0.f2936a
            int r7 = r7.f2914k
            r7 = r7 | r9
            r0.f2936a = r7
            goto L_0x0339
        L_0x0336:
            r10 = 0
            r12 = 7
            r14 = 5
        L_0x0339:
            r7 = 5
            r11 = 3
            goto L_0x0353
        L_0x033c:
            r19 = r7
            r20 = r10
            r7 = 5
            r10 = 0
            r11 = 3
            r12 = 7
            if (r9 != r11) goto L_0x0353
            java.lang.String r9 = r23.getName()
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x0353
            r8.pop()
        L_0x0353:
            int r9 = r23.next()
            r7 = r19
            r10 = r20
            r11 = 8
            r12 = 0
            r13 = 1
            r14 = 4
            r15 = 3
            goto L_0x0137
        L_0x0363:
            if (r18 != 0) goto L_0x0370
            android.content.res.ColorStateList r0 = r6.f2938c
            android.graphics.PorterDuff$Mode r2 = r6.f2939d
            android.graphics.PorterDuffColorFilter r0 = r1.a(r0, r2)
            r1.f2951j = r0
            return
        L_0x0370:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r2 = "no path defined"
            r0.<init>(r2)
            throw r0
        L_0x0378:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires height > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0393:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires width > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03ae:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportHeight > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x03c9:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportWidth > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
