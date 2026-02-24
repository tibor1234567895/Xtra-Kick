package o5;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;
import w5.n;

public final class e extends Drawable implements i, Animatable {

    /* renamed from: h  reason: collision with root package name */
    public final d f12201h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12202i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f12203j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f12204k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f12205l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f12206m;

    /* renamed from: n  reason: collision with root package name */
    public final int f12207n = -1;

    /* renamed from: o  reason: collision with root package name */
    public boolean f12208o;

    /* renamed from: p  reason: collision with root package name */
    public Paint f12209p;

    /* renamed from: q  reason: collision with root package name */
    public Rect f12210q;

    public e(d dVar) {
        n.b(dVar);
        this.f12201h = dVar;
    }

    public final void a() {
        n.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f12204k);
        d dVar = this.f12201h;
        if (dVar.f12200a.f12216a.d() != 1) {
            if (!this.f12202i) {
                this.f12202i = true;
                j jVar = dVar.f12200a;
                if (!jVar.f12225j) {
                    ArrayList arrayList = jVar.f12218c;
                    if (!arrayList.contains(this)) {
                        boolean isEmpty = arrayList.isEmpty();
                        arrayList.add(this);
                        if (isEmpty && !jVar.f12221f) {
                            jVar.f12221f = true;
                            jVar.f12225j = false;
                            jVar.a();
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
        if (!this.f12204k) {
            if (this.f12208o) {
                int intrinsicWidth = getIntrinsicWidth();
                int intrinsicHeight = getIntrinsicHeight();
                Rect bounds = getBounds();
                if (this.f12210q == null) {
                    this.f12210q = new Rect();
                }
                Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f12210q);
                this.f12208o = false;
            }
            j jVar = this.f12201h.f12200a;
            h hVar = jVar.f12224i;
            if (hVar != null) {
                bitmap = hVar.f12215n;
            } else {
                bitmap = jVar.f12227l;
            }
            if (this.f12210q == null) {
                this.f12210q = new Rect();
            }
            Rect rect = this.f12210q;
            if (this.f12209p == null) {
                this.f12209p = new Paint(2);
            }
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.f12209p);
        }
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f12201h;
    }

    public final int getIntrinsicHeight() {
        return this.f12201h.f12200a.f12231p;
    }

    public final int getIntrinsicWidth() {
        return this.f12201h.f12200a.f12230o;
    }

    public final int getOpacity() {
        return -2;
    }

    public final boolean isRunning() {
        return this.f12202i;
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f12208o = true;
    }

    public final void setAlpha(int i10) {
        if (this.f12209p == null) {
            this.f12209p = new Paint(2);
        }
        this.f12209p.setAlpha(i10);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f12209p == null) {
            this.f12209p = new Paint(2);
        }
        this.f12209p.setColorFilter(colorFilter);
    }

    public final boolean setVisible(boolean z10, boolean z11) {
        n.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f12204k);
        this.f12205l = z10;
        if (!z10) {
            this.f12202i = false;
            j jVar = this.f12201h.f12200a;
            ArrayList arrayList = jVar.f12218c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                jVar.f12221f = false;
            }
        } else if (this.f12203j) {
            a();
        }
        return super.setVisible(z10, z11);
    }

    public final void start() {
        this.f12203j = true;
        this.f12206m = 0;
        if (this.f12205l) {
            a();
        }
    }

    public final void stop() {
        this.f12203j = false;
        this.f12202i = false;
        j jVar = this.f12201h.f12200a;
        ArrayList arrayList = jVar.f12218c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            jVar.f12221f = false;
        }
    }
}
