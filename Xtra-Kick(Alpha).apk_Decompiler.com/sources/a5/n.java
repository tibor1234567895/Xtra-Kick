package a5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

public final class n extends Drawable implements t, Animatable {

    /* renamed from: h  reason: collision with root package name */
    public final m f175h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f176i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f177j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f178k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f179l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f180m;

    /* renamed from: n  reason: collision with root package name */
    public int f181n = -1;

    /* renamed from: o  reason: collision with root package name */
    public boolean f182o;

    /* renamed from: p  reason: collision with root package name */
    public Paint f183p;

    /* renamed from: q  reason: collision with root package name */
    public Rect f184q;

    public n(m mVar) {
        int i10;
        int i11 = -1;
        w5.n.b(mVar);
        this.f175h = mVar;
        j jVar = mVar.f174a.f199a;
        if (jVar.f155b.getLoopCount() == 0) {
            i10 = 0;
        } else {
            i10 = jVar.f155b.getLoopCount();
        }
        this.f181n = i10 != 0 ? i10 : i11;
    }

    public final void a() {
        int i10;
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        w wVar = this.f175h.f174a;
        s sVar = wVar.f207i;
        if (sVar != null) {
            i10 = sVar.f191l;
        } else {
            i10 = -1;
        }
        if (i10 == wVar.f199a.d() - 1) {
            this.f180m++;
        }
        int i11 = this.f181n;
        if (i11 != -1 && this.f180m >= i11) {
            stop();
        }
    }

    public final void b() {
        w5.n.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f178k);
        m mVar = this.f175h;
        if (mVar.f174a.f199a.d() != 1) {
            if (!this.f176i) {
                this.f176i = true;
                w wVar = mVar.f174a;
                if (!wVar.f208j) {
                    ArrayList arrayList = wVar.f201c;
                    if (!arrayList.contains(this)) {
                        boolean isEmpty = arrayList.isEmpty();
                        arrayList.add(this);
                        if (isEmpty && !wVar.f204f) {
                            wVar.f204f = true;
                            wVar.f208j = false;
                            wVar.a();
                        }
                    } else {
                        throw new IllegalStateException("Cannot subscribe twice in a row");
                    }
                } else {
                    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
                }
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap;
        if (!this.f178k) {
            if (this.f182o) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.f184q == null) {
                    this.f184q = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f184q);
                this.f182o = false;
            }
            w wVar = this.f175h.f174a;
            s sVar = wVar.f207i;
            if (sVar != null) {
                bitmap = sVar.f193n;
            } else {
                bitmap = wVar.f210l;
            }
            if (this.f184q == null) {
                this.f184q = new Rect();
            }
            Rect rect = this.f184q;
            if (this.f183p == null) {
                this.f183p = new Paint(2);
            }
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.f183p);
        }
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f175h;
    }

    public final int getIntrinsicHeight() {
        return this.f175h.f174a.f214p;
    }

    public final int getIntrinsicWidth() {
        return this.f175h.f174a.f213o;
    }

    public final int getOpacity() {
        return -2;
    }

    public final boolean isRunning() {
        return this.f176i;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f182o = true;
    }

    public final void setAlpha(int i10) {
        if (this.f183p == null) {
            this.f183p = new Paint(2);
        }
        this.f183p.setAlpha(i10);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f183p == null) {
            this.f183p = new Paint(2);
        }
        this.f183p.setColorFilter(colorFilter);
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        w5.n.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f178k);
        this.f179l = z10;
        if (!z10) {
            this.f176i = false;
            w wVar = this.f175h.f174a;
            ArrayList arrayList = wVar.f201c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                wVar.f204f = false;
            }
        } else if (this.f177j) {
            b();
        }
        return super.setVisible(z10, z11);
    }

    public final void start() {
        this.f177j = true;
        this.f180m = 0;
        if (this.f179l) {
            b();
        }
    }

    public final void stop() {
        this.f177j = false;
        this.f176i = false;
        w wVar = this.f175h.f174a;
        ArrayList arrayList = wVar.f201c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            wVar.f204f = false;
        }
    }
}
