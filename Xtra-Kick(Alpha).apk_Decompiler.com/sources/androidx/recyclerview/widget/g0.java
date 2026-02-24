package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

public final class g0 extends o1 implements u1 {
    public static final int[] C = {16842919};
    public static final int[] D = new int[0];
    public int A;
    public final c0 B;

    /* renamed from: a  reason: collision with root package name */
    public final int f1992a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1993b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f1994c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f1995d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1996e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1997f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f1998g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f1999h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2000i;

    /* renamed from: j  reason: collision with root package name */
    public final int f2001j;

    /* renamed from: k  reason: collision with root package name */
    public int f2002k;

    /* renamed from: l  reason: collision with root package name */
    public int f2003l;

    /* renamed from: m  reason: collision with root package name */
    public float f2004m;

    /* renamed from: n  reason: collision with root package name */
    public int f2005n;

    /* renamed from: o  reason: collision with root package name */
    public int f2006o;

    /* renamed from: p  reason: collision with root package name */
    public float f2007p;

    /* renamed from: q  reason: collision with root package name */
    public int f2008q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f2009r = 0;

    /* renamed from: s  reason: collision with root package name */
    public RecyclerView f2010s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2011t = false;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2012u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f2013v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f2014w = 0;

    /* renamed from: x  reason: collision with root package name */
    public final int[] f2015x = new int[2];

    /* renamed from: y  reason: collision with root package name */
    public final int[] f2016y = new int[2];

    /* renamed from: z  reason: collision with root package name */
    public final ValueAnimator f2017z;

    public g0(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i10, int i11, int i12) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f2017z = ofFloat;
        this.A = 0;
        c0 c0Var = new c0(0, this);
        this.B = c0Var;
        d0 d0Var = new d0(this);
        this.f1994c = stateListDrawable;
        this.f1995d = drawable;
        this.f1998g = stateListDrawable2;
        this.f1999h = drawable2;
        this.f1996e = Math.max(i10, stateListDrawable.getIntrinsicWidth());
        this.f1997f = Math.max(i10, drawable.getIntrinsicWidth());
        this.f2000i = Math.max(i10, stateListDrawable2.getIntrinsicWidth());
        this.f2001j = Math.max(i10, drawable2.getIntrinsicWidth());
        this.f1992a = i11;
        this.f1993b = i12;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new e0(this));
        ofFloat.addUpdateListener(new f0(this));
        RecyclerView recyclerView2 = this.f2010s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.f2010s.removeOnItemTouchListener(this);
                this.f2010s.removeOnScrollListener(d0Var);
                this.f2010s.removeCallbacks(c0Var);
            }
            this.f2010s = recyclerView;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(this);
                this.f2010s.addOnItemTouchListener(this);
                this.f2010s.addOnScrollListener(d0Var);
            }
        }
    }

    public final boolean a(float f10, float f11) {
        if (f11 >= ((float) (this.f2009r - this.f2000i))) {
            int i10 = this.f2006o;
            int i11 = this.f2005n;
            return f10 >= ((float) (i10 - (i11 / 2))) && f10 <= ((float) ((i11 / 2) + i10));
        }
    }

    public final boolean b(float f10, float f11) {
        boolean z10;
        RecyclerView recyclerView = this.f2010s;
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(recyclerView) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i10 = this.f1996e;
        if (z10) {
            if (f10 > ((float) i10)) {
                return false;
            }
        } else if (f10 < ((float) (this.f2008q - i10))) {
            return false;
        }
        int i11 = this.f2003l;
        int i12 = this.f2002k / 2;
        if (f11 < ((float) (i11 - i12)) || f11 > ((float) (i12 + i11))) {
            return false;
        }
        return true;
    }

    public final void c(int i10) {
        RecyclerView recyclerView = this.f2010s;
        c0 c0Var = this.B;
        recyclerView.removeCallbacks(c0Var);
        this.f2010s.postDelayed(c0Var, (long) i10);
    }

    public final void d(int i10) {
        int i11;
        StateListDrawable stateListDrawable = this.f1994c;
        if (i10 == 2 && this.f2013v != 2) {
            stateListDrawable.setState(C);
            this.f2010s.removeCallbacks(this.B);
        }
        if (i10 == 0) {
            this.f2010s.invalidate();
        } else {
            e();
        }
        if (this.f2013v != 2 || i10 == 2) {
            if (i10 == 1) {
                i11 = 1500;
            }
            this.f2013v = i10;
        }
        stateListDrawable.setState(D);
        i11 = 1200;
        c(i11);
        this.f2013v = i10;
    }

    public final void e() {
        int i10 = this.A;
        ValueAnimator valueAnimator = this.f2017z;
        if (i10 != 0) {
            if (i10 == 3) {
                valueAnimator.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        valueAnimator.setDuration(500);
        valueAnimator.setStartDelay(0);
        valueAnimator.start();
    }

    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, g2 g2Var) {
        int i10;
        if (this.f2008q != this.f2010s.getWidth() || this.f2009r != this.f2010s.getHeight()) {
            this.f2008q = this.f2010s.getWidth();
            this.f2009r = this.f2010s.getHeight();
            d(0);
        } else if (this.A != 0) {
            if (this.f2011t) {
                int i11 = this.f2008q;
                int i12 = this.f1996e;
                int i13 = i11 - i12;
                int i14 = this.f2003l;
                int i15 = this.f2002k;
                int i16 = i14 - (i15 / 2);
                StateListDrawable stateListDrawable = this.f1994c;
                stateListDrawable.setBounds(0, 0, i12, i15);
                int i17 = this.f2009r;
                int i18 = this.f1997f;
                Drawable drawable = this.f1995d;
                drawable.setBounds(0, 0, i18, i17);
                RecyclerView recyclerView2 = this.f2010s;
                WeakHashMap weakHashMap = c1.f10054a;
                boolean z10 = true;
                if (j0.d(recyclerView2) != 1) {
                    z10 = false;
                }
                if (z10) {
                    drawable.draw(canvas);
                    canvas.translate((float) i12, (float) i16);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    i10 = -i12;
                } else {
                    canvas.translate((float) i13, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, (float) i16);
                    stateListDrawable.draw(canvas);
                    i10 = -i13;
                }
                canvas.translate((float) i10, (float) (-i16));
            }
            if (this.f2012u) {
                int i19 = this.f2009r;
                int i20 = this.f2000i;
                int i21 = i19 - i20;
                int i22 = this.f2006o;
                int i23 = this.f2005n;
                int i24 = i22 - (i23 / 2);
                StateListDrawable stateListDrawable2 = this.f1998g;
                stateListDrawable2.setBounds(0, 0, i23, i20);
                int i25 = this.f2008q;
                int i26 = this.f2001j;
                Drawable drawable2 = this.f1999h;
                drawable2.setBounds(0, 0, i25, i26);
                canvas.translate(0.0f, (float) i21);
                drawable2.draw(canvas);
                canvas.translate((float) i24, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate((float) (-i24), (float) (-i21));
            }
        }
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i10 = this.f2013v;
        if (i10 == 1) {
            boolean b10 = b(motionEvent.getX(), motionEvent.getY());
            boolean a10 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (b10 || a10)) {
                if (a10) {
                    this.f2014w = 1;
                    this.f2007p = (float) ((int) motionEvent.getX());
                } else if (b10) {
                    this.f2014w = 2;
                    this.f2004m = (float) ((int) motionEvent.getY());
                }
                d(2);
                return true;
            }
        } else if (i10 == 2) {
            return true;
        }
        return false;
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean z10) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bc, code lost:
        if (r8 >= 0) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0114, code lost:
        if (r4 >= 0) goto L_0x0116;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTouchEvent(androidx.recyclerview.widget.RecyclerView r12, android.view.MotionEvent r13) {
        /*
            r11 = this;
            int r12 = r11.f2013v
            if (r12 != 0) goto L_0x0005
            return
        L_0x0005:
            int r12 = r13.getAction()
            r0 = 1
            r1 = 2
            if (r12 != 0) goto L_0x0047
            float r12 = r13.getX()
            float r2 = r13.getY()
            boolean r12 = r11.b(r12, r2)
            float r2 = r13.getX()
            float r3 = r13.getY()
            boolean r2 = r11.a(r2, r3)
            if (r12 != 0) goto L_0x0029
            if (r2 == 0) goto L_0x011f
        L_0x0029:
            if (r2 == 0) goto L_0x0036
            r11.f2014w = r0
            float r12 = r13.getX()
            int r12 = (int) r12
            float r12 = (float) r12
            r11.f2007p = r12
            goto L_0x0042
        L_0x0036:
            if (r12 == 0) goto L_0x0042
            r11.f2014w = r1
            float r12 = r13.getY()
            int r12 = (int) r12
            float r12 = (float) r12
            r11.f2004m = r12
        L_0x0042:
            r11.d(r1)
            goto L_0x011f
        L_0x0047:
            int r12 = r13.getAction()
            r2 = 0
            if (r12 != r0) goto L_0x005e
            int r12 = r11.f2013v
            if (r12 != r1) goto L_0x005e
            r12 = 0
            r11.f2004m = r12
            r11.f2007p = r12
            r11.d(r0)
            r11.f2014w = r2
            goto L_0x011f
        L_0x005e:
            int r12 = r13.getAction()
            if (r12 != r1) goto L_0x011f
            int r12 = r11.f2013v
            if (r12 != r1) goto L_0x011f
            r11.e()
            int r12 = r11.f2014w
            r3 = 1073741824(0x40000000, float:2.0)
            int r4 = r11.f1993b
            if (r12 != r0) goto L_0x00c7
            float r12 = r13.getX()
            int[] r5 = r11.f2016y
            r5[r2] = r4
            int r6 = r11.f2008q
            int r6 = r6 - r4
            r5[r0] = r6
            float r7 = (float) r4
            float r6 = (float) r6
            float r12 = java.lang.Math.min(r6, r12)
            float r12 = java.lang.Math.max(r7, r12)
            int r6 = r11.f2006o
            float r6 = (float) r6
            float r6 = r6 - r12
            float r6 = java.lang.Math.abs(r6)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 >= 0) goto L_0x0097
            goto L_0x00c7
        L_0x0097:
            float r6 = r11.f2007p
            androidx.recyclerview.widget.RecyclerView r7 = r11.f2010s
            int r7 = r7.computeHorizontalScrollRange()
            androidx.recyclerview.widget.RecyclerView r8 = r11.f2010s
            int r8 = r8.computeHorizontalScrollOffset()
            int r9 = r11.f2008q
            r10 = r5[r0]
            r5 = r5[r2]
            int r10 = r10 - r5
            if (r10 != 0) goto L_0x00b0
        L_0x00ae:
            r5 = 0
            goto L_0x00be
        L_0x00b0:
            float r5 = r12 - r6
            float r6 = (float) r10
            float r5 = r5 / r6
            int r7 = r7 - r9
            float r6 = (float) r7
            float r5 = r5 * r6
            int r5 = (int) r5
            int r8 = r8 + r5
            if (r8 >= r7) goto L_0x00ae
            if (r8 < 0) goto L_0x00ae
        L_0x00be:
            if (r5 == 0) goto L_0x00c5
            androidx.recyclerview.widget.RecyclerView r6 = r11.f2010s
            r6.scrollBy(r5, r2)
        L_0x00c5:
            r11.f2007p = r12
        L_0x00c7:
            int r12 = r11.f2014w
            if (r12 != r1) goto L_0x011f
            float r12 = r13.getY()
            int[] r13 = r11.f2015x
            r13[r2] = r4
            int r1 = r11.f2009r
            int r1 = r1 - r4
            r13[r0] = r1
            float r4 = (float) r4
            float r1 = (float) r1
            float r12 = java.lang.Math.min(r1, r12)
            float r12 = java.lang.Math.max(r4, r12)
            int r1 = r11.f2003l
            float r1 = (float) r1
            float r1 = r1 - r12
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ef
            goto L_0x011f
        L_0x00ef:
            float r1 = r11.f2004m
            androidx.recyclerview.widget.RecyclerView r3 = r11.f2010s
            int r3 = r3.computeVerticalScrollRange()
            androidx.recyclerview.widget.RecyclerView r4 = r11.f2010s
            int r4 = r4.computeVerticalScrollOffset()
            int r5 = r11.f2009r
            r0 = r13[r0]
            r13 = r13[r2]
            int r0 = r0 - r13
            if (r0 != 0) goto L_0x0108
        L_0x0106:
            r13 = 0
            goto L_0x0116
        L_0x0108:
            float r13 = r12 - r1
            float r0 = (float) r0
            float r13 = r13 / r0
            int r3 = r3 - r5
            float r0 = (float) r3
            float r13 = r13 * r0
            int r13 = (int) r13
            int r4 = r4 + r13
            if (r4 >= r3) goto L_0x0106
            if (r4 < 0) goto L_0x0106
        L_0x0116:
            if (r13 == 0) goto L_0x011d
            androidx.recyclerview.widget.RecyclerView r0 = r11.f2010s
            r0.scrollBy(r2, r13)
        L_0x011d:
            r11.f2004m = r12
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.g0.onTouchEvent(androidx.recyclerview.widget.RecyclerView, android.view.MotionEvent):void");
    }
}
