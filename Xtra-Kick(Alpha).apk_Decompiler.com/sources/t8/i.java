package t8;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import b4.e0;
import f0.k;
import java.util.BitSet;
import l0.b;
import s8.a;

public class i extends Drawable implements k, y {
    public static final Paint D;
    public PorterDuffColorFilter A;
    public final RectF B;
    public final boolean C;

    /* renamed from: h  reason: collision with root package name */
    public h f14744h;

    /* renamed from: i  reason: collision with root package name */
    public final w[] f14745i;

    /* renamed from: j  reason: collision with root package name */
    public final w[] f14746j;

    /* renamed from: k  reason: collision with root package name */
    public final BitSet f14747k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14748l;

    /* renamed from: m  reason: collision with root package name */
    public final Matrix f14749m;

    /* renamed from: n  reason: collision with root package name */
    public final Path f14750n;

    /* renamed from: o  reason: collision with root package name */
    public final Path f14751o;

    /* renamed from: p  reason: collision with root package name */
    public final RectF f14752p;

    /* renamed from: q  reason: collision with root package name */
    public final RectF f14753q;

    /* renamed from: r  reason: collision with root package name */
    public final Region f14754r;

    /* renamed from: s  reason: collision with root package name */
    public final Region f14755s;

    /* renamed from: t  reason: collision with root package name */
    public n f14756t;

    /* renamed from: u  reason: collision with root package name */
    public final Paint f14757u;

    /* renamed from: v  reason: collision with root package name */
    public final Paint f14758v;

    /* renamed from: w  reason: collision with root package name */
    public final a f14759w;

    /* renamed from: x  reason: collision with root package name */
    public final e0 f14760x;

    /* renamed from: y  reason: collision with root package name */
    public final p f14761y;

    /* renamed from: z  reason: collision with root package name */
    public PorterDuffColorFilter f14762z;

    static {
        Paint paint = new Paint(1);
        D = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public i() {
        this(new n());
    }

    public final void b(RectF rectF, Path path) {
        p pVar = this.f14761y;
        h hVar = this.f14744h;
        n nVar = hVar.f14723a;
        float f10 = hVar.f14732j;
        pVar.a(nVar, f10, rectF, this.f14760x, path);
        if (this.f14744h.f14731i != 1.0f) {
            Matrix matrix = this.f14749m;
            matrix.reset();
            float f11 = this.f14744h.f14731i;
            matrix.setScale(f11, f11, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.B, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r2 = r4.getColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.PorterDuffColorFilter c(android.content.res.ColorStateList r2, android.graphics.PorterDuff.Mode r3, android.graphics.Paint r4, boolean r5) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x001a
            if (r3 != 0) goto L_0x0005
            goto L_0x001a
        L_0x0005:
            int[] r4 = r1.getState()
            r0 = 0
            int r2 = r2.getColorForState(r4, r0)
            if (r5 == 0) goto L_0x0014
            int r2 = r1.d(r2)
        L_0x0014:
            android.graphics.PorterDuffColorFilter r4 = new android.graphics.PorterDuffColorFilter
            r4.<init>(r2, r3)
            goto L_0x0030
        L_0x001a:
            if (r5 == 0) goto L_0x002e
            int r2 = r4.getColor()
            int r3 = r1.d(r2)
            if (r3 == r2) goto L_0x002e
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r4)
            goto L_0x002f
        L_0x002e:
            r2 = 0
        L_0x002f:
            r4 = r2
        L_0x0030:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.i.c(android.content.res.ColorStateList, android.graphics.PorterDuff$Mode, android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    public final int d(int i10) {
        h hVar = this.f14744h;
        float f10 = hVar.f14736n + hVar.f14737o + hVar.f14735m;
        j8.a aVar = hVar.f14724b;
        if (aVar != null) {
            return aVar.a(i10, f10);
        }
        return i10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0113, code lost:
        if (r0 != false) goto L_0x0115;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r22) {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
            android.graphics.Paint r8 = r6.f14757u
            android.graphics.PorterDuffColorFilter r0 = r6.f14762z
            r8.setColorFilter(r0)
            int r9 = r8.getAlpha()
            t8.h r0 = r6.f14744h
            int r0 = r0.f14734l
            int r1 = r0 >>> 7
            int r0 = r0 + r1
            int r0 = r0 * r9
            int r0 = r0 >>> 8
            r8.setAlpha(r0)
            android.graphics.Paint r10 = r6.f14758v
            android.graphics.PorterDuffColorFilter r0 = r6.A
            r10.setColorFilter(r0)
            t8.h r0 = r6.f14744h
            float r0 = r0.f14733k
            r10.setStrokeWidth(r0)
            int r11 = r10.getAlpha()
            t8.h r0 = r6.f14744h
            int r0 = r0.f14734l
            int r1 = r0 >>> 7
            int r0 = r0 + r1
            int r0 = r0 * r11
            int r0 = r0 >>> 8
            r10.setAlpha(r0)
            boolean r0 = r6.f14748l
            android.graphics.Path r3 = r6.f14750n
            r12 = 0
            r13 = 0
            r14 = 1
            if (r0 == 0) goto L_0x00eb
            t8.h r0 = r6.f14744h
            android.graphics.Paint$Style r0 = r0.f14743u
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r0 == r1) goto L_0x0052
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
            if (r0 != r1) goto L_0x005c
        L_0x0052:
            float r0 = r10.getStrokeWidth()
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x005c
            r0 = 1
            goto L_0x005d
        L_0x005c:
            r0 = 0
        L_0x005d:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == 0) goto L_0x0067
            float r0 = r10.getStrokeWidth()
            float r0 = r0 / r1
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            float r0 = -r0
            t8.h r2 = r6.f14744h
            t8.n r2 = r2.f14723a
            t8.g r4 = new t8.g
            r4.<init>(r0)
            r2.getClass()
            t8.m r0 = new t8.m
            r0.<init>(r2)
            t8.c r5 = r2.f14782e
            t8.c r5 = r4.a(r5)
            r0.f14769e = r5
            t8.c r5 = r2.f14783f
            t8.c r5 = r4.a(r5)
            r0.f14770f = r5
            t8.c r5 = r2.f14785h
            t8.c r5 = r4.a(r5)
            r0.f14772h = r5
            t8.c r2 = r2.f14784g
            t8.c r2 = r4.a(r2)
            r0.f14771g = r2
            t8.n r2 = new t8.n
            r2.<init>(r0)
            r6.f14756t = r2
            t8.h r0 = r6.f14744h
            float r0 = r0.f14732j
            android.graphics.RectF r4 = r6.f14753q
            android.graphics.RectF r5 = r21.h()
            r4.set(r5)
            t8.h r5 = r6.f14744h
            android.graphics.Paint$Style r5 = r5.f14743u
            android.graphics.Paint$Style r15 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r5 == r15) goto L_0x00ba
            android.graphics.Paint$Style r15 = android.graphics.Paint.Style.STROKE
            if (r5 != r15) goto L_0x00c4
        L_0x00ba:
            float r5 = r10.getStrokeWidth()
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x00c4
            r5 = 1
            goto L_0x00c5
        L_0x00c4:
            r5 = 0
        L_0x00c5:
            if (r5 == 0) goto L_0x00cd
            float r5 = r10.getStrokeWidth()
            float r5 = r5 / r1
            goto L_0x00ce
        L_0x00cd:
            r5 = 0
        L_0x00ce:
            r4.inset(r5, r5)
            android.graphics.Path r1 = r6.f14751o
            t8.p r15 = r6.f14761y
            r19 = 0
            r16 = r2
            r17 = r0
            r18 = r4
            r20 = r1
            r15.a(r16, r17, r18, r19, r20)
            android.graphics.RectF r0 = r21.h()
            r6.b(r0, r3)
            r6.f14748l = r13
        L_0x00eb:
            t8.h r0 = r6.f14744h
            int r1 = r0.f14738p
            r2 = 2
            if (r1 == r14) goto L_0x0117
            int r4 = r0.f14739q
            if (r4 <= 0) goto L_0x0117
            if (r1 == r2) goto L_0x0115
            int r1 = android.os.Build.VERSION.SDK_INT
            t8.n r0 = r0.f14723a
            android.graphics.RectF r4 = r21.h()
            boolean r0 = r0.d(r4)
            if (r0 != 0) goto L_0x0112
            boolean r0 = r3.isConvex()
            if (r0 != 0) goto L_0x0112
            r0 = 29
            if (r1 >= r0) goto L_0x0112
            r0 = 1
            goto L_0x0113
        L_0x0112:
            r0 = 0
        L_0x0113:
            if (r0 == 0) goto L_0x0117
        L_0x0115:
            r0 = 1
            goto L_0x0118
        L_0x0117:
            r0 = 0
        L_0x0118:
            if (r0 != 0) goto L_0x011c
            goto L_0x01c7
        L_0x011c:
            r22.save()
            t8.h r0 = r6.f14744h
            int r1 = r0.f14740r
            double r4 = (double) r1
            int r0 = r0.f14741s
            double r0 = (double) r0
            double r0 = java.lang.Math.toRadians(r0)
            double r0 = java.lang.Math.sin(r0)
            double r0 = r0 * r4
            int r0 = (int) r0
            t8.h r1 = r6.f14744h
            int r4 = r1.f14740r
            double r4 = (double) r4
            int r1 = r1.f14741s
            double r13 = (double) r1
            double r13 = java.lang.Math.toRadians(r13)
            double r13 = java.lang.Math.cos(r13)
            double r13 = r13 * r4
            int r1 = (int) r13
            float r0 = (float) r0
            float r1 = (float) r1
            r7.translate(r0, r1)
            boolean r0 = r6.C
            if (r0 != 0) goto L_0x0152
            r21.e(r22)
            goto L_0x01c4
        L_0x0152:
            android.graphics.RectF r0 = r6.B
            float r1 = r0.width()
            android.graphics.Rect r4 = r21.getBounds()
            int r4 = r4.width()
            float r4 = (float) r4
            float r1 = r1 - r4
            int r1 = (int) r1
            float r4 = r0.height()
            android.graphics.Rect r5 = r21.getBounds()
            int r5 = r5.height()
            float r5 = (float) r5
            float r4 = r4 - r5
            int r4 = (int) r4
            if (r1 < 0) goto L_0x020a
            if (r4 < 0) goto L_0x020a
            float r5 = r0.width()
            int r5 = (int) r5
            t8.h r13 = r6.f14744h
            int r13 = r13.f14739q
            int r13 = r13 * 2
            int r13 = r13 + r5
            int r13 = r13 + r1
            float r0 = r0.height()
            int r0 = (int) r0
            t8.h r5 = r6.f14744h
            int r5 = r5.f14739q
            int r5 = r5 * 2
            int r5 = r5 + r0
            int r5 = r5 + r4
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r13, r5, r0)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            android.graphics.Rect r5 = r21.getBounds()
            int r5 = r5.left
            t8.h r13 = r6.f14744h
            int r13 = r13.f14739q
            int r5 = r5 - r13
            int r5 = r5 - r1
            float r1 = (float) r5
            android.graphics.Rect r5 = r21.getBounds()
            int r5 = r5.top
            t8.h r13 = r6.f14744h
            int r13 = r13.f14739q
            int r5 = r5 - r13
            int r5 = r5 - r4
            float r4 = (float) r5
            float r5 = -r1
            float r13 = -r4
            r2.translate(r5, r13)
            r6.e(r2)
            r2 = 0
            r7.drawBitmap(r0, r1, r4, r2)
            r0.recycle()
        L_0x01c4:
            r22.restore()
        L_0x01c7:
            t8.h r0 = r6.f14744h
            android.graphics.Paint$Style r1 = r0.f14743u
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r1 == r2) goto L_0x01d6
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL
            if (r1 != r2) goto L_0x01d4
            goto L_0x01d6
        L_0x01d4:
            r1 = 0
            goto L_0x01d7
        L_0x01d6:
            r1 = 1
        L_0x01d7:
            if (r1 == 0) goto L_0x01e7
            t8.n r4 = r0.f14723a
            android.graphics.RectF r5 = r21.h()
            r0 = r21
            r1 = r22
            r2 = r8
            r0.f(r1, r2, r3, r4, r5)
        L_0x01e7:
            t8.h r0 = r6.f14744h
            android.graphics.Paint$Style r0 = r0.f14743u
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL_AND_STROKE
            if (r0 == r1) goto L_0x01f3
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.STROKE
            if (r0 != r1) goto L_0x01fd
        L_0x01f3:
            float r0 = r10.getStrokeWidth()
            int r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x01fd
            r13 = 1
            goto L_0x01fe
        L_0x01fd:
            r13 = 0
        L_0x01fe:
            if (r13 == 0) goto L_0x0203
            r21.g(r22)
        L_0x0203:
            r8.setAlpha(r9)
            r10.setAlpha(r11)
            return
        L_0x020a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Invalid shadow bounds. Check that the treatments result in a valid path."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.i.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas) {
        if (this.f14747k.cardinality() > 0) {
            Log.w("i", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i10 = this.f14744h.f14740r;
        Path path = this.f14750n;
        a aVar = this.f14759w;
        if (i10 != 0) {
            canvas.drawPath(path, aVar.f14383a);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            w wVar = this.f14745i[i11];
            int i12 = this.f14744h.f14739q;
            Matrix matrix = w.f14819b;
            wVar.a(matrix, aVar, i12, canvas);
            this.f14746j[i11].a(matrix, aVar, this.f14744h.f14739q, canvas);
        }
        if (this.C) {
            h hVar = this.f14744h;
            int sin = (int) (Math.sin(Math.toRadians((double) hVar.f14741s)) * ((double) hVar.f14740r));
            h hVar2 = this.f14744h;
            int cos = (int) (Math.cos(Math.toRadians((double) hVar2.f14741s)) * ((double) hVar2.f14740r));
            canvas.translate((float) (-sin), (float) (-cos));
            canvas.drawPath(path, D);
            canvas.translate((float) sin, (float) cos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, n nVar, RectF rectF) {
        if (nVar.d(rectF)) {
            float a10 = nVar.f14783f.a(rectF) * this.f14744h.f14732j;
            canvas.drawRoundRect(rectF, a10, a10, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public void g(Canvas canvas) {
        boolean z10;
        Paint paint = this.f14758v;
        Path path = this.f14751o;
        n nVar = this.f14756t;
        RectF rectF = this.f14753q;
        rectF.set(h());
        Paint.Style style = this.f14744h.f14743u;
        float f10 = 0.0f;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && paint.getStrokeWidth() > 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f10 = paint.getStrokeWidth() / 2.0f;
        }
        rectF.inset(f10, f10);
        f(canvas, paint, path, nVar, rectF);
    }

    public int getAlpha() {
        return this.f14744h.f14734l;
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f14744h;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        h hVar = this.f14744h;
        if (hVar.f14738p != 2) {
            if (hVar.f14723a.d(h())) {
                outline.setRoundRect(getBounds(), this.f14744h.f14723a.f14782e.a(h()) * this.f14744h.f14732j);
                return;
            }
            RectF h10 = h();
            Path path = this.f14750n;
            b(h10, path);
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
    }

    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f14744h.f14730h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f14754r;
        region.set(bounds);
        RectF h10 = h();
        Path path = this.f14750n;
        b(h10, path);
        Region region2 = this.f14755s;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        RectF rectF = this.f14752p;
        rectF.set(getBounds());
        return rectF;
    }

    public final void i(Context context) {
        this.f14744h.f14724b = new j8.a(context);
        n();
    }

    public final void invalidateSelf() {
        this.f14748l = true;
        super.invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = r1.f14744h.f14726d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = r1.f14744h.f14725c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f14744h.f14728f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r1.f14744h.f14727e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0039
            t8.h r0 = r1.f14744h
            android.content.res.ColorStateList r0 = r0.f14728f
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x0012:
            t8.h r0 = r1.f14744h
            android.content.res.ColorStateList r0 = r0.f14727e
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x001e:
            t8.h r0 = r1.f14744h
            android.content.res.ColorStateList r0 = r0.f14726d
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0039
        L_0x002a:
            t8.h r0 = r1.f14744h
            android.content.res.ColorStateList r0 = r0.f14725c
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r0 = 0
            goto L_0x003a
        L_0x0039:
            r0 = 1
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.i.isStateful():boolean");
    }

    public final void j(float f10) {
        h hVar = this.f14744h;
        if (hVar.f14736n != f10) {
            hVar.f14736n = f10;
            n();
        }
    }

    public final void k(ColorStateList colorStateList) {
        h hVar = this.f14744h;
        if (hVar.f14725c != colorStateList) {
            hVar.f14725c = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r5.f14757u;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r2 = r5.f14758v;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(int[] r6) {
        /*
            r5 = this;
            t8.h r0 = r5.f14744h
            android.content.res.ColorStateList r0 = r0.f14725c
            r1 = 1
            if (r0 == 0) goto L_0x001c
            android.graphics.Paint r0 = r5.f14757u
            int r2 = r0.getColor()
            t8.h r3 = r5.f14744h
            android.content.res.ColorStateList r3 = r3.f14725c
            int r3 = r3.getColorForState(r6, r2)
            if (r2 == r3) goto L_0x001c
            r0.setColor(r3)
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            t8.h r2 = r5.f14744h
            android.content.res.ColorStateList r2 = r2.f14726d
            if (r2 == 0) goto L_0x0037
            android.graphics.Paint r2 = r5.f14758v
            int r3 = r2.getColor()
            t8.h r4 = r5.f14744h
            android.content.res.ColorStateList r4 = r4.f14726d
            int r6 = r4.getColorForState(r6, r3)
            if (r3 == r6) goto L_0x0037
            r2.setColor(r6)
            goto L_0x0038
        L_0x0037:
            r1 = r0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t8.i.l(int[]):boolean");
    }

    public final boolean m() {
        PorterDuffColorFilter porterDuffColorFilter = this.f14762z;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        h hVar = this.f14744h;
        this.f14762z = c(hVar.f14728f, hVar.f14729g, this.f14757u, true);
        h hVar2 = this.f14744h;
        this.A = c(hVar2.f14727e, hVar2.f14729g, this.f14758v, false);
        h hVar3 = this.f14744h;
        if (hVar3.f14742t) {
            this.f14759w.a(hVar3.f14728f.getColorForState(getState(), 0));
        }
        if (!b.a(porterDuffColorFilter, this.f14762z) || !b.a(porterDuffColorFilter2, this.A)) {
            return true;
        }
        return false;
    }

    public Drawable mutate() {
        this.f14744h = new h(this.f14744h);
        return this;
    }

    public final void n() {
        h hVar = this.f14744h;
        float f10 = hVar.f14736n + hVar.f14737o;
        hVar.f14739q = (int) Math.ceil((double) (0.75f * f10));
        this.f14744h.f14740r = (int) Math.ceil((double) (f10 * 0.25f));
        m();
        super.invalidateSelf();
    }

    public final void onBoundsChange(Rect rect) {
        this.f14748l = true;
        super.onBoundsChange(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z10 = l(iArr) || m();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public void setAlpha(int i10) {
        h hVar = this.f14744h;
        if (hVar.f14734l != i10) {
            hVar.f14734l = i10;
            super.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f14744h.getClass();
        super.invalidateSelf();
    }

    public final void setShapeAppearanceModel(n nVar) {
        this.f14744h.f14723a = nVar;
        invalidateSelf();
    }

    public final void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f14744h.f14728f = colorStateList;
        m();
        super.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f14744h;
        if (hVar.f14729g != mode) {
            hVar.f14729g = mode;
            m();
            super.invalidateSelf();
        }
    }

    public i(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(n.b(context, attributeSet, i10, i11).a());
    }

    public i(h hVar) {
        p pVar;
        this.f14745i = new w[4];
        this.f14746j = new w[4];
        this.f14747k = new BitSet(8);
        this.f14749m = new Matrix();
        this.f14750n = new Path();
        this.f14751o = new Path();
        this.f14752p = new RectF();
        this.f14753q = new RectF();
        this.f14754r = new Region();
        this.f14755s = new Region();
        Paint paint = new Paint(1);
        this.f14757u = paint;
        Paint paint2 = new Paint(1);
        this.f14758v = paint2;
        this.f14759w = new a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = o.f14790a;
        } else {
            pVar = new p();
        }
        this.f14761y = pVar;
        this.B = new RectF();
        this.C = true;
        this.f14744h = hVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m();
        l(getState());
        this.f14760x = new e0(26, this);
    }

    public i(n nVar) {
        this(new h(nVar));
    }
}
