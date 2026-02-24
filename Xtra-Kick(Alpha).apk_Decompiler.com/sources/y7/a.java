package y7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import m8.n;
import m8.o;
import m8.r;
import q8.g;
import t8.i;

public final class a extends Drawable implements n {

    /* renamed from: h  reason: collision with root package name */
    public final WeakReference f17074h;

    /* renamed from: i  reason: collision with root package name */
    public final i f17075i;

    /* renamed from: j  reason: collision with root package name */
    public final o f17076j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f17077k = new Rect();

    /* renamed from: l  reason: collision with root package name */
    public final d f17078l;

    /* renamed from: m  reason: collision with root package name */
    public float f17079m;

    /* renamed from: n  reason: collision with root package name */
    public float f17080n;

    /* renamed from: o  reason: collision with root package name */
    public int f17081o;

    /* renamed from: p  reason: collision with root package name */
    public float f17082p;

    /* renamed from: q  reason: collision with root package name */
    public float f17083q;

    /* renamed from: r  reason: collision with root package name */
    public float f17084r;

    /* renamed from: s  reason: collision with root package name */
    public WeakReference f17085s;

    /* renamed from: t  reason: collision with root package name */
    public WeakReference f17086t;

    public a(Context context, c cVar) {
        int i10;
        int i11;
        FrameLayout frameLayout;
        g gVar;
        WeakReference weakReference = new WeakReference(context);
        this.f17074h = weakReference;
        r.c(context, r.f10794b, "Theme.MaterialComponents");
        o oVar = new o(this);
        this.f17076j = oVar;
        TextPaint textPaint = oVar.f10787a;
        textPaint.setTextAlign(Paint.Align.CENTER);
        d dVar = new d(context, cVar);
        this.f17078l = dVar;
        boolean a10 = dVar.a();
        c cVar2 = dVar.f17107b;
        if (a10) {
            i10 = cVar2.f17093n.intValue();
        } else {
            i10 = cVar2.f17091l.intValue();
        }
        if (dVar.a()) {
            i11 = cVar2.f17094o.intValue();
        } else {
            i11 = cVar2.f17092m.intValue();
        }
        i iVar = new i(new t8.n(t8.n.a(context, i10, i11, new t8.a((float) 0))));
        this.f17075i = iVar;
        g();
        Context context2 = (Context) weakReference.get();
        if (!(context2 == null || oVar.f10792f == (gVar = new g(context2, cVar2.f17090k.intValue())))) {
            oVar.b(gVar, context2);
            textPaint.setColor(cVar2.f17089j.intValue());
            invalidateSelf();
            i();
            invalidateSelf();
        }
        this.f17081o = ((int) Math.pow(10.0d, ((double) cVar2.f17097r) - 1.0d)) - 1;
        oVar.f10790d = true;
        i();
        invalidateSelf();
        oVar.f10790d = true;
        g();
        i();
        invalidateSelf();
        textPaint.setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(cVar2.f17088i.intValue());
        if (iVar.f14744h.f14725c != valueOf) {
            iVar.k(valueOf);
            invalidateSelf();
        }
        textPaint.setColor(cVar2.f17089j.intValue());
        invalidateSelf();
        WeakReference weakReference2 = this.f17085s;
        if (!(weakReference2 == null || weakReference2.get() == null)) {
            View view = (View) this.f17085s.get();
            WeakReference weakReference3 = this.f17086t;
            if (weakReference3 != null) {
                frameLayout = (FrameLayout) weakReference3.get();
            } else {
                frameLayout = null;
            }
            h(view, frameLayout);
        }
        i();
        setVisible(cVar2.f17103x.booleanValue(), false);
    }

    public final void a() {
        invalidateSelf();
    }

    public final String b() {
        int e10 = e();
        int i10 = this.f17081o;
        d dVar = this.f17078l;
        if (e10 <= i10) {
            return NumberFormat.getInstance(dVar.f17107b.f17098s).format((long) e());
        }
        Context context = (Context) this.f17074h.get();
        if (context == null) {
            return "";
        }
        return String.format(dVar.f17107b.f17098s, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[]{Integer.valueOf(this.f17081o), "+"});
    }

    public final CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        boolean f10 = f();
        d dVar = this.f17078l;
        if (!f10) {
            return dVar.f17107b.f17099t;
        }
        if (dVar.f17107b.f17100u == 0 || (context = (Context) this.f17074h.get()) == null) {
            return null;
        }
        int e10 = e();
        int i10 = this.f17081o;
        c cVar = dVar.f17107b;
        if (e10 <= i10) {
            return context.getResources().getQuantityString(cVar.f17100u, e(), new Object[]{Integer.valueOf(e())});
        }
        return context.getString(cVar.f17101v, new Object[]{Integer.valueOf(i10)});
    }

    public final FrameLayout d() {
        WeakReference weakReference = this.f17086t;
        if (weakReference != null) {
            return (FrameLayout) weakReference.get();
        }
        return null;
    }

    public final void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f17075i.draw(canvas);
            if (f()) {
                Rect rect = new Rect();
                String b10 = b();
                o oVar = this.f17076j;
                oVar.f10787a.getTextBounds(b10, 0, b10.length(), rect);
                canvas.drawText(b10, this.f17079m, this.f17080n + ((float) (rect.height() / 2)), oVar.f10787a);
            }
        }
    }

    public final int e() {
        if (f()) {
            return this.f17078l.f17107b.f17096q;
        }
        return 0;
    }

    public final boolean f() {
        return this.f17078l.a();
    }

    public final void g() {
        int i10;
        int i11;
        Context context = (Context) this.f17074h.get();
        if (context != null) {
            d dVar = this.f17078l;
            boolean a10 = dVar.a();
            c cVar = dVar.f17107b;
            if (a10) {
                i10 = cVar.f17093n.intValue();
            } else {
                i10 = cVar.f17091l.intValue();
            }
            if (dVar.a()) {
                i11 = cVar.f17094o.intValue();
            } else {
                i11 = cVar.f17092m.intValue();
            }
            this.f17075i.setShapeAppearanceModel(new t8.n(t8.n.a(context, i10, i11, new t8.a((float) 0))));
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        return this.f17078l.f17107b.f17095p;
    }

    public final int getIntrinsicHeight() {
        return this.f17077k.height();
    }

    public final int getIntrinsicWidth() {
        return this.f17077k.width();
    }

    public final int getOpacity() {
        return -3;
    }

    public final void h(View view, FrameLayout frameLayout) {
        this.f17085s = new WeakReference(view);
        this.f17086t = new WeakReference(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        i();
        invalidateSelf();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x011e, code lost:
        if (m0.j0.d(r1) == 0) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0127, code lost:
        if (m0.j0.d(r1) == 0) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0132, code lost:
        r1 = (((float) r4.right) + r11.f17083q) - ((float) r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r11 = this;
            java.lang.ref.WeakReference r0 = r11.f17074h
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.ref.WeakReference r1 = r11.f17085s
            r2 = 0
            if (r1 == 0) goto L_0x0014
            java.lang.Object r1 = r1.get()
            android.view.View r1 = (android.view.View) r1
            goto L_0x0015
        L_0x0014:
            r1 = r2
        L_0x0015:
            if (r0 == 0) goto L_0x016b
            if (r1 != 0) goto L_0x001b
            goto L_0x016b
        L_0x001b:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.graphics.Rect r3 = r11.f17077k
            r0.set(r3)
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r1.getDrawingRect(r4)
            java.lang.ref.WeakReference r5 = r11.f17086t
            if (r5 == 0) goto L_0x0037
            java.lang.Object r2 = r5.get()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x0037:
            if (r2 != 0) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            r2.offsetDescendantRectToMyCoords(r1, r4)
        L_0x003d:
            boolean r2 = r11.f()
            y7.d r5 = r11.f17078l
            if (r2 != 0) goto L_0x0048
            float r2 = r5.f17108c
            goto L_0x004a
        L_0x0048:
            float r2 = r5.f17109d
        L_0x004a:
            r11.f17082p = r2
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = 1073741824(0x40000000, float:2.0)
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0057
            r11.f17084r = r2
            goto L_0x007b
        L_0x0057:
            boolean r2 = r11.f()
            if (r2 != 0) goto L_0x0060
            float r2 = r5.f17111f
            goto L_0x0062
        L_0x0060:
            float r2 = r5.f17113h
        L_0x0062:
            float r2 = r2 / r7
            int r2 = java.lang.Math.round(r2)
            float r2 = (float) r2
            r11.f17084r = r2
            boolean r2 = r11.f()
            if (r2 != 0) goto L_0x0073
            float r2 = r5.f17110e
            goto L_0x0075
        L_0x0073:
            float r2 = r5.f17112g
        L_0x0075:
            float r2 = r2 / r7
            int r2 = java.lang.Math.round(r2)
            float r2 = (float) r2
        L_0x007b:
            r11.f17083q = r2
            int r2 = r11.e()
            r8 = 9
            if (r2 <= r8) goto L_0x009b
            java.lang.String r2 = r11.b()
            float r8 = r11.f17083q
            m8.o r9 = r11.f17076j
            float r2 = r9.a(r2)
            float r2 = r2 / r7
            float r7 = r5.f17114i
            float r2 = r2 + r7
            float r2 = java.lang.Math.max(r8, r2)
            r11.f17083q = r2
        L_0x009b:
            boolean r2 = r11.f()
            if (r2 == 0) goto L_0x00aa
            y7.c r2 = r5.f17107b
            java.lang.Integer r2 = r2.B
            int r2 = r2.intValue()
            goto L_0x00b2
        L_0x00aa:
            y7.c r2 = r5.f17107b
            java.lang.Integer r2 = r2.f17105z
            int r2 = r2.intValue()
        L_0x00b2:
            int r7 = r5.f17117l
            if (r7 != 0) goto L_0x00bd
            float r7 = r11.f17084r
            int r7 = java.lang.Math.round(r7)
            int r2 = r2 - r7
        L_0x00bd:
            y7.c r7 = r5.f17107b
            java.lang.Integer r8 = r7.D
            int r8 = r8.intValue()
            int r8 = r8 + r2
            java.lang.Integer r2 = r7.f17102w
            int r2 = r2.intValue()
            r9 = 8388691(0x800053, float:1.175506E-38)
            if (r2 == r9) goto L_0x00da
            r10 = 8388693(0x800055, float:1.1755063E-38)
            if (r2 == r10) goto L_0x00da
            int r2 = r4.top
            int r2 = r2 + r8
            goto L_0x00dd
        L_0x00da:
            int r2 = r4.bottom
            int r2 = r2 - r8
        L_0x00dd:
            float r2 = (float) r2
            r11.f17080n = r2
            boolean r2 = r11.f()
            if (r2 == 0) goto L_0x00ed
            java.lang.Integer r2 = r7.A
            int r2 = r2.intValue()
            goto L_0x00f3
        L_0x00ed:
            java.lang.Integer r2 = r7.f17104y
            int r2 = r2.intValue()
        L_0x00f3:
            int r8 = r5.f17117l
            r10 = 1
            if (r8 != r10) goto L_0x0104
            boolean r8 = r11.f()
            if (r8 == 0) goto L_0x0101
            int r5 = r5.f17116k
            goto L_0x0103
        L_0x0101:
            int r5 = r5.f17115j
        L_0x0103:
            int r2 = r2 + r5
        L_0x0104:
            java.lang.Integer r5 = r7.C
            int r5 = r5.intValue()
            int r5 = r5 + r2
            java.lang.Integer r2 = r7.f17102w
            int r2 = r2.intValue()
            r7 = 8388659(0x800033, float:1.1755015E-38)
            if (r2 == r7) goto L_0x0121
            if (r2 == r9) goto L_0x0121
            java.util.WeakHashMap r2 = m0.c1.f10054a
            int r1 = m0.j0.d(r1)
            if (r1 != 0) goto L_0x0129
            goto L_0x0132
        L_0x0121:
            java.util.WeakHashMap r2 = m0.c1.f10054a
            int r1 = m0.j0.d(r1)
            if (r1 != 0) goto L_0x0132
        L_0x0129:
            int r1 = r4.left
            float r1 = (float) r1
            float r2 = r11.f17083q
            float r1 = r1 - r2
            float r2 = (float) r5
            float r1 = r1 + r2
            goto L_0x013a
        L_0x0132:
            int r1 = r4.right
            float r1 = (float) r1
            float r2 = r11.f17083q
            float r1 = r1 + r2
            float r2 = (float) r5
            float r1 = r1 - r2
        L_0x013a:
            r11.f17079m = r1
            float r2 = r11.f17080n
            float r4 = r11.f17083q
            float r5 = r11.f17084r
            float r7 = r1 - r4
            int r7 = (int) r7
            float r8 = r2 - r5
            int r8 = (int) r8
            float r1 = r1 + r4
            int r1 = (int) r1
            float r2 = r2 + r5
            int r2 = (int) r2
            r3.set(r7, r8, r1, r2)
            float r1 = r11.f17082p
            t8.i r2 = r11.f17075i
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0162
            t8.h r4 = r2.f14744h
            t8.n r4 = r4.f14723a
            t8.n r1 = r4.e(r1)
            r2.setShapeAppearanceModel(r1)
        L_0x0162:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x016b
            r2.setBounds(r3)
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.a.i():void");
    }

    public final boolean isStateful() {
        return false;
    }

    public final boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final void setAlpha(int i10) {
        d dVar = this.f17078l;
        dVar.f17106a.f17095p = i10;
        dVar.f17107b.f17095p = i10;
        this.f17076j.f10787a.setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
