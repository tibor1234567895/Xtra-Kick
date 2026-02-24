package i;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.activity.h;
import f0.a;
import f0.b;
import f0.d;

public class i extends Drawable implements Drawable.Callback {

    /* renamed from: t  reason: collision with root package name */
    public static final /* synthetic */ int f7925t = 0;

    /* renamed from: h  reason: collision with root package name */
    public h f7926h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f7927i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f7928j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f7929k;

    /* renamed from: l  reason: collision with root package name */
    public int f7930l = 255;

    /* renamed from: m  reason: collision with root package name */
    public boolean f7931m;

    /* renamed from: n  reason: collision with root package name */
    public int f7932n = -1;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7933o;

    /* renamed from: p  reason: collision with root package name */
    public h f7934p;

    /* renamed from: q  reason: collision with root package name */
    public long f7935q;

    /* renamed from: r  reason: collision with root package name */
    public long f7936r;

    /* renamed from: s  reason: collision with root package name */
    public g f7937s;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f7931m = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f7928j
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0036
            long r9 = r13.f7935q
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x0038
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            int r9 = r13.f7930l
            r3.setAlpha(r9)
            goto L_0x0036
        L_0x0020:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            i.h r9 = r13.f7926h
            int r9 = r9.f7924z
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f7930l
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x0039
        L_0x0036:
            r13.f7935q = r6
        L_0x0038:
            r3 = 0
        L_0x0039:
            android.graphics.drawable.Drawable r9 = r13.f7929k
            if (r9 == 0) goto L_0x0061
            long r10 = r13.f7936r
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0063
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x004e
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f7929k = r0
            goto L_0x0061
        L_0x004e:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            i.h r4 = r13.f7926h
            int r4 = r4.A
            int r3 = r3 / r4
            int r4 = r13.f7930l
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0064
        L_0x0061:
            r13.f7936r = r6
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r14 == 0) goto L_0x0070
            if (r0 == 0) goto L_0x0070
            androidx.activity.h r14 = r13.f7934p
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i.i.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        h hVar = this.f7926h;
        if (theme != null) {
            hVar.c();
            int i10 = hVar.f7906h;
            Drawable[] drawableArr = hVar.f7905g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable != null && b.b(drawable)) {
                    b.a(drawableArr[i11], theme);
                    hVar.f7903e |= drawableArr[i11].getChangingConfigurations();
                }
            }
            Resources resources = theme.getResources();
            if (resources != null) {
                hVar.f7900b = resources;
                int i12 = resources.getDisplayMetrics().densityDpi;
                if (i12 == 0) {
                    i12 = 160;
                }
                int i13 = hVar.f7901c;
                hVar.f7901c = i12;
                if (i13 != i12) {
                    hVar.f7911m = false;
                    hVar.f7908j = false;
                    return;
                }
                return;
            }
            return;
        }
        hVar.getClass();
    }

    public h b() {
        return this.f7926h;
    }

    public final void c(Drawable drawable) {
        if (this.f7937s == null) {
            this.f7937s = new g();
        }
        g gVar = this.f7937s;
        gVar.f7898h = drawable.getCallback();
        drawable.setCallback(gVar);
        try {
            if (this.f7926h.f7924z <= 0 && this.f7931m) {
                drawable.setAlpha(this.f7930l);
            }
            h hVar = this.f7926h;
            if (hVar.D) {
                drawable.setColorFilter(hVar.C);
            } else {
                if (hVar.G) {
                    b.h(drawable, hVar.E);
                }
                h hVar2 = this.f7926h;
                if (hVar2.H) {
                    b.i(drawable, hVar2.F);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f7926h.f7922x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                d.c(drawable, d.b(this));
            }
            a.e(drawable, this.f7926h.B);
            Rect rect = this.f7927i;
            if (rect != null) {
                b.f(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            g gVar2 = this.f7937s;
            Drawable.Callback callback = gVar2.f7898h;
            gVar2.f7898h = null;
            drawable.setCallback(callback);
        }
    }

    public final boolean canApplyTheme() {
        return this.f7926h.canApplyTheme();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(int r10) {
        /*
            r9 = this;
            int r0 = r9.f7932n
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            i.h r0 = r9.f7926h
            int r0 = r0.A
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f7929k
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f7928j
            if (r0 == 0) goto L_0x0029
            r9.f7929k = r0
            i.h r0 = r9.f7926h
            int r0 = r0.A
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f7936r = r0
            goto L_0x0035
        L_0x0029:
            r9.f7929k = r4
            r9.f7936r = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f7928j
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            i.h r0 = r9.f7926h
            int r1 = r0.f7906h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.d(r10)
            r9.f7928j = r0
            r9.f7932n = r10
            if (r0 == 0) goto L_0x005a
            i.h r10 = r9.f7926h
            int r10 = r10.f7924z
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f7935q = r2
        L_0x0051:
            r9.c(r0)
            goto L_0x005a
        L_0x0055:
            r9.f7928j = r4
            r10 = -1
            r9.f7932n = r10
        L_0x005a:
            long r0 = r9.f7935q
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.f7936r
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            androidx.activity.h r0 = r9.f7934p
            if (r0 != 0) goto L_0x0073
            androidx.activity.h r0 = new androidx.activity.h
            r0.<init>(r10, r9)
            r9.f7934p = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.a(r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: i.i.d(int):boolean");
    }

    public final void draw(Canvas canvas) {
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f7929k;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void e(h hVar) {
        this.f7926h = hVar;
        int i10 = this.f7932n;
        if (i10 >= 0) {
            Drawable d10 = hVar.d(i10);
            this.f7928j = d10;
            if (d10 != null) {
                c(d10);
            }
        }
        this.f7929k = null;
    }

    public final int getAlpha() {
        return this.f7930l;
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        h hVar = this.f7926h;
        return changingConfigurations | hVar.f7903e | hVar.f7902d;
    }

    public final Drawable.ConstantState getConstantState() {
        boolean z10;
        h hVar = this.f7926h;
        if (!hVar.f7920v) {
            hVar.c();
            hVar.f7920v = true;
            int i10 = hVar.f7906h;
            Drawable[] drawableArr = hVar.f7905g;
            int i11 = 0;
            while (true) {
                if (i11 >= i10) {
                    hVar.f7921w = true;
                    z10 = true;
                    break;
                } else if (drawableArr[i11].getConstantState() == null) {
                    hVar.f7921w = false;
                    z10 = false;
                    break;
                } else {
                    i11++;
                }
            }
        } else {
            z10 = hVar.f7921w;
        }
        if (!z10) {
            return null;
        }
        this.f7926h.f7902d = getChangingConfigurations();
        return this.f7926h;
    }

    public final Drawable getCurrent() {
        return this.f7928j;
    }

    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f7927i;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public final int getIntrinsicHeight() {
        h hVar = this.f7926h;
        if (hVar.f7910l) {
            if (!hVar.f7911m) {
                hVar.b();
            }
            return hVar.f7913o;
        }
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public final int getIntrinsicWidth() {
        h hVar = this.f7926h;
        if (hVar.f7910l) {
            if (!hVar.f7911m) {
                hVar.b();
            }
            return hVar.f7912n;
        }
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public final int getMinimumHeight() {
        h hVar = this.f7926h;
        if (hVar.f7910l) {
            if (!hVar.f7911m) {
                hVar.b();
            }
            return hVar.f7915q;
        }
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public final int getMinimumWidth() {
        h hVar = this.f7926h;
        if (hVar.f7910l) {
            if (!hVar.f7911m) {
                hVar.b();
            }
            return hVar.f7914p;
        }
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public final int getOpacity() {
        Drawable drawable = this.f7928j;
        int i10 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        h hVar = this.f7926h;
        if (hVar.f7916r) {
            return hVar.f7917s;
        }
        hVar.c();
        int i11 = hVar.f7906h;
        Drawable[] drawableArr = hVar.f7905g;
        if (i11 > 0) {
            i10 = drawableArr[0].getOpacity();
        }
        for (int i12 = 1; i12 < i11; i12++) {
            i10 = Drawable.resolveOpacity(i10, drawableArr[i12].getOpacity());
        }
        hVar.f7917s = i10;
        hVar.f7916r = true;
        return i10;
    }

    public final void getOutline(Outline outline) {
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public final boolean getPadding(Rect rect) {
        boolean z10;
        h hVar = this.f7926h;
        boolean z11 = true;
        Rect rect2 = null;
        if (!hVar.f7907i) {
            Rect rect3 = hVar.f7909k;
            if (rect3 != null || hVar.f7908j) {
                rect2 = rect3;
            } else {
                hVar.c();
                Rect rect4 = new Rect();
                int i10 = hVar.f7906h;
                Drawable[] drawableArr = hVar.f7905g;
                for (int i11 = 0; i11 < i10; i11++) {
                    if (drawableArr[i11].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i12 = rect4.left;
                        if (i12 > rect2.left) {
                            rect2.left = i12;
                        }
                        int i13 = rect4.top;
                        if (i13 > rect2.top) {
                            rect2.top = i13;
                        }
                        int i14 = rect4.right;
                        if (i14 > rect2.right) {
                            rect2.right = i14;
                        }
                        int i15 = rect4.bottom;
                        if (i15 > rect2.bottom) {
                            rect2.bottom = i15;
                        }
                    }
                }
                hVar.f7908j = true;
                hVar.f7909k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            Drawable drawable = this.f7928j;
            if (drawable != null) {
                z10 = drawable.getPadding(rect);
            } else {
                z10 = super.getPadding(rect);
            }
        }
        if (!this.f7926h.B || d.b(this) != 1) {
            z11 = false;
        }
        if (z11) {
            int i16 = rect.left;
            rect.left = rect.right;
            rect.right = i16;
        }
        return z10;
    }

    public final void invalidateDrawable(Drawable drawable) {
        h hVar = this.f7926h;
        if (hVar != null) {
            hVar.f7916r = false;
            hVar.f7918t = false;
        }
        if (drawable == this.f7928j && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public final boolean isAutoMirrored() {
        return this.f7926h.B;
    }

    public boolean isStateful() {
        h hVar = this.f7926h;
        if (hVar.f7918t) {
            return hVar.f7919u;
        }
        hVar.c();
        int i10 = hVar.f7906h;
        Drawable[] drawableArr = hVar.f7905g;
        boolean z10 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            } else if (drawableArr[i11].isStateful()) {
                z10 = true;
                break;
            } else {
                i11++;
            }
        }
        hVar.f7919u = z10;
        hVar.f7918t = true;
        return z10;
    }

    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f7929k;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f7929k = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f7931m) {
                this.f7928j.setAlpha(this.f7930l);
            }
        }
        if (this.f7936r != 0) {
            this.f7936r = 0;
            z10 = true;
        }
        if (this.f7935q != 0) {
            this.f7935q = 0;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f7933o && super.mutate() == this) {
            h b10 = b();
            b10.e();
            e(b10);
            this.f7933o = true;
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f7929k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public final boolean onLayoutDirectionChanged(int i10) {
        boolean z10;
        h hVar = this.f7926h;
        int i11 = this.f7932n;
        int i12 = hVar.f7906h;
        Drawable[] drawableArr = hVar.f7905g;
        boolean z11 = false;
        for (int i13 = 0; i13 < i12; i13++) {
            Drawable drawable = drawableArr[i13];
            if (drawable != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    z10 = d.c(drawable, i10);
                } else {
                    z10 = false;
                }
                if (i13 == i11) {
                    z11 = z10;
                }
            }
        }
        hVar.f7923y = i10;
        return z11;
    }

    public final boolean onLevelChange(int i10) {
        Drawable drawable = this.f7929k;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f7929k;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable == this.f7928j && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j10);
        }
    }

    public final void setAlpha(int i10) {
        if (!this.f7931m || this.f7930l != i10) {
            this.f7931m = true;
            this.f7930l = i10;
            Drawable drawable = this.f7928j;
            if (drawable == null) {
                return;
            }
            if (this.f7935q == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    public final void setAutoMirrored(boolean z10) {
        h hVar = this.f7926h;
        if (hVar.B != z10) {
            hVar.B = z10;
            Drawable drawable = this.f7928j;
            if (drawable != null) {
                a.e(drawable, z10);
            }
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        h hVar = this.f7926h;
        hVar.D = true;
        if (hVar.C != colorFilter) {
            hVar.C = colorFilter;
            Drawable drawable = this.f7928j;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public final void setDither(boolean z10) {
        h hVar = this.f7926h;
        if (hVar.f7922x != z10) {
            hVar.f7922x = z10;
            Drawable drawable = this.f7928j;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    public final void setHotspot(float f10, float f11) {
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            b.e(drawable, f10, f11);
        }
    }

    public final void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f7927i;
        if (rect == null) {
            this.f7927i = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f7928j;
        if (drawable != null) {
            b.f(drawable, i10, i11, i12, i13);
        }
    }

    public final void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public final void setTintList(ColorStateList colorStateList) {
        h hVar = this.f7926h;
        hVar.G = true;
        if (hVar.E != colorStateList) {
            hVar.E = colorStateList;
            d.e(this.f7928j, colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f7926h;
        hVar.H = true;
        if (hVar.F != mode) {
            hVar.F = mode;
            d.f(this.f7928j, mode);
        }
    }

    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f7929k;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f7928j;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f7928j && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
