package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.activity.e;
import g1.k1;
import g1.u1;
import i3.h0;
import i3.k;
import i3.o0;
import i3.w;
import j1.a;
import j1.l0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View implements o0 {
    public static final /* synthetic */ int W = 0;
    public final int A;
    public final StringBuilder B;
    public final Formatter C;
    public final e D;
    public final CopyOnWriteArraySet E;
    public final Point F;
    public final float G;
    public int H;
    public long I;
    public int J;
    public Rect K;
    public final ValueAnimator L;
    public float M;
    public boolean N;
    public boolean O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public int T;
    public long[] U;
    public boolean[] V;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f1828h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f1829i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f1830j;

    /* renamed from: k  reason: collision with root package name */
    public final Rect f1831k;

    /* renamed from: l  reason: collision with root package name */
    public final Paint f1832l;

    /* renamed from: m  reason: collision with root package name */
    public final Paint f1833m;

    /* renamed from: n  reason: collision with root package name */
    public final Paint f1834n;

    /* renamed from: o  reason: collision with root package name */
    public final Paint f1835o;

    /* renamed from: p  reason: collision with root package name */
    public final Paint f1836p;

    /* renamed from: q  reason: collision with root package name */
    public final Paint f1837q;

    /* renamed from: r  reason: collision with root package name */
    public final Drawable f1838r;

    /* renamed from: s  reason: collision with root package name */
    public final int f1839s;

    /* renamed from: t  reason: collision with root package name */
    public final int f1840t;

    /* renamed from: u  reason: collision with root package name */
    public final int f1841u;

    /* renamed from: v  reason: collision with root package name */
    public final int f1842v;

    /* renamed from: w  reason: collision with root package name */
    public final int f1843w;

    /* renamed from: x  reason: collision with root package name */
    public final int f1844x;

    /* renamed from: y  reason: collision with root package name */
    public final int f1845y;

    /* renamed from: z  reason: collision with root package name */
    public final int f1846z;

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, attributeSet, 0);
    }

    public static int a(int i10, float f10) {
        return (int) ((((float) i10) * f10) + 0.5f);
    }

    private long getPositionIncrement() {
        long j10 = this.I;
        if (j10 != -9223372036854775807L) {
            return j10;
        }
        long j11 = this.Q;
        if (j11 == -9223372036854775807L) {
            return 0;
        }
        return j11 / ((long) this.H);
    }

    private String getProgressText() {
        return l0.x(this.B, this.C, this.R);
    }

    private long getScrubberPosition() {
        Rect rect = this.f1829i;
        if (rect.width() <= 0 || this.Q == -9223372036854775807L) {
            return 0;
        }
        return (((long) this.f1831k.width()) * this.Q) / ((long) rect.width());
    }

    public final void b(float f10) {
        Rect rect = this.f1829i;
        this.f1831k.right = l0.h((int) f10, rect.left, rect.right);
    }

    public final boolean c(long j10) {
        long j11 = this.Q;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.O ? this.P : this.R;
        long i10 = l0.i(j12 + j10, 0, j11);
        if (i10 == j12) {
            return false;
        }
        if (!this.O) {
            d(i10);
        } else {
            g(i10);
        }
        f();
        return true;
    }

    public final void d(long j10) {
        this.P = j10;
        this.O = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            w wVar = ((k) it.next()).f8114h;
            wVar.f8213u0 = true;
            TextView textView = wVar.K;
            if (textView != null) {
                textView.setText(l0.x(wVar.M, wVar.N, j10));
            }
            wVar.f8186h.g();
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1838r;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e(boolean z10) {
        k1 k1Var;
        removeCallbacks(this.D);
        this.O = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.E.iterator();
        while (it.hasNext()) {
            long j10 = this.P;
            w wVar = ((k) it.next()).f8114h;
            wVar.f8213u0 = false;
            if (!z10 && (k1Var = wVar.f8201o0) != null) {
                if (wVar.f8211t0) {
                    if (k1Var.L0(17) && k1Var.L0(10)) {
                        u1 j02 = k1Var.j0();
                        int x10 = j02.x();
                        int i10 = 0;
                        while (true) {
                            long j11 = j02.v(i10, wVar.P).j();
                            if (j10 < j11) {
                                break;
                            } else if (i10 == x10 - 1) {
                                j10 = j11;
                                break;
                            } else {
                                j10 -= j11;
                                i10++;
                            }
                        }
                        k1Var.v(i10, j10);
                    }
                } else if (k1Var.L0(5)) {
                    k1Var.q0(j10);
                }
                wVar.p();
            }
            wVar.f8186h.h();
        }
    }

    public final void f() {
        Rect rect = this.f1830j;
        Rect rect2 = this.f1829i;
        rect.set(rect2);
        Rect rect3 = this.f1831k;
        rect3.set(rect2);
        long j10 = this.O ? this.P : this.R;
        if (this.Q > 0) {
            rect.right = Math.min(rect2.left + ((int) ((((long) rect2.width()) * this.S) / this.Q)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((((long) rect2.width()) * j10) / this.Q)), rect2.right);
        } else {
            int i10 = rect2.left;
            rect.right = i10;
            rect3.right = i10;
        }
        invalidate(this.f1828h);
    }

    public final void g(long j10) {
        if (this.P != j10) {
            this.P = j10;
            Iterator it = this.E.iterator();
            while (it.hasNext()) {
                w wVar = ((k) it.next()).f8114h;
                TextView textView = wVar.K;
                if (textView != null) {
                    textView.setText(l0.x(wVar.M, wVar.N, j10));
                }
            }
        }
    }

    public long getPreferredUpdateDelay() {
        int width = (int) (((float) this.f1829i.width()) / this.G);
        if (width != 0) {
            long j10 = this.Q;
            if (!(j10 == 0 || j10 == -9223372036854775807L)) {
                return j10 / ((long) width);
            }
        }
        return Long.MAX_VALUE;
    }

    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1838r;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final void onDraw(Canvas canvas) {
        int i10;
        Paint paint;
        Canvas canvas2 = canvas;
        canvas.save();
        Rect rect = this.f1829i;
        int height = rect.height();
        int centerY = rect.centerY() - (height / 2);
        int i11 = height + centerY;
        long j10 = this.Q;
        Paint paint2 = this.f1834n;
        Rect rect2 = this.f1831k;
        if (j10 <= 0) {
            canvas.drawRect((float) rect.left, (float) centerY, (float) rect.right, (float) i11, paint2);
        } else {
            Rect rect3 = this.f1830j;
            int i12 = rect3.left;
            int i13 = rect3.right;
            int max = Math.max(Math.max(rect.left, i13), rect2.right);
            int i14 = rect.right;
            if (max < i14) {
                canvas.drawRect((float) max, (float) centerY, (float) i14, (float) i11, paint2);
            }
            int max2 = Math.max(i12, rect2.right);
            if (i13 > max2) {
                canvas.drawRect((float) max2, (float) centerY, (float) i13, (float) i11, this.f1833m);
            }
            if (rect2.width() > 0) {
                canvas.drawRect((float) rect2.left, (float) centerY, (float) rect2.right, (float) i11, this.f1832l);
            }
            if (this.T != 0) {
                long[] jArr = this.U;
                jArr.getClass();
                boolean[] zArr = this.V;
                zArr.getClass();
                int i15 = this.f1842v;
                int i16 = i15 / 2;
                int i17 = 0;
                int i18 = 0;
                while (i18 < this.T) {
                    long i19 = l0.i(jArr[i18], 0, this.Q);
                    int min = Math.min(rect.width() - i15, Math.max(i17, ((int) ((((long) rect.width()) * i19) / this.Q)) - i16)) + rect.left;
                    if (zArr[i18]) {
                        paint = this.f1836p;
                    } else {
                        paint = this.f1835o;
                    }
                    float f10 = (float) (min + i15);
                    Canvas canvas3 = canvas;
                    float f11 = (float) i11;
                    canvas3.drawRect((float) min, (float) centerY, f10, f11, paint);
                    i18++;
                    i15 = i15;
                    i17 = 0;
                }
            }
        }
        if (this.Q > 0) {
            int h10 = l0.h(rect2.right, rect2.left, rect.right);
            int centerY2 = rect2.centerY();
            Drawable drawable = this.f1838r;
            if (drawable == null) {
                if (this.O || isFocused()) {
                    i10 = this.f1845y;
                } else if (isEnabled()) {
                    i10 = this.f1843w;
                } else {
                    i10 = this.f1844x;
                }
                canvas2.drawCircle((float) h10, (float) centerY2, (float) ((int) ((((float) i10) * this.M) / 2.0f)), this.f1837q);
            } else {
                int intrinsicWidth = ((int) (((float) drawable.getIntrinsicWidth()) * this.M)) / 2;
                int intrinsicHeight = ((int) (((float) drawable.getIntrinsicHeight()) * this.M)) / 2;
                drawable.setBounds(h10 - intrinsicWidth, centerY2 - intrinsicHeight, h10 + intrinsicWidth, centerY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas.restore();
    }

    public final void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.O && !z10) {
            e(false);
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.Q > 0) {
            if (l0.f8453a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
                return;
            }
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        if (c(r0) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = r4.D;
        removeCallbacks(r5);
        postDelayed(r5, 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L_0x002e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L_0x0025
            switch(r5) {
                case 21: goto L_0x0013;
                case 22: goto L_0x0014;
                case 23: goto L_0x0025;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x002e
        L_0x0013:
            long r0 = -r0
        L_0x0014:
            boolean r0 = r4.c(r0)
            if (r0 == 0) goto L_0x002e
            androidx.activity.e r5 = r4.D
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L_0x0025:
            boolean r0 = r4.O
            if (r0 == 0) goto L_0x002e
            r5 = 0
            r4.e(r5)
            return r3
        L_0x002e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        Rect rect;
        int i17 = i12 - i10;
        int i18 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i17 - getPaddingRight();
        if (this.N) {
            i14 = 0;
        } else {
            i14 = this.f1846z;
        }
        int i19 = this.f1841u;
        int i20 = this.f1839s;
        int i21 = this.f1840t;
        if (i19 == 1) {
            i16 = (i18 - getPaddingBottom()) - i21;
            i15 = ((i18 - getPaddingBottom()) - i20) - Math.max(i14 - (i20 / 2), 0);
        } else {
            i16 = (i18 - i21) / 2;
            i15 = (i18 - i20) / 2;
        }
        Rect rect2 = this.f1828h;
        rect2.set(paddingLeft, i16, paddingRight, i21 + i16);
        this.f1829i.set(rect2.left + i14, i15, rect2.right - i14, i20 + i15);
        if (l0.f8453a >= 29 && !((rect = this.K) != null && rect.width() == i17 && this.K.height() == i18)) {
            Rect rect3 = new Rect(0, 0, i17, i18);
            this.K = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        f();
    }

    public final void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int i12 = this.f1840t;
        if (mode == 0) {
            size = i12;
        } else if (mode != 1073741824) {
            size = Math.min(i12, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        Drawable drawable = this.f1838r;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void onRtlPropertiesChanged(int i10) {
        boolean z10;
        Drawable drawable = this.f1838r;
        if (drawable != null) {
            if (l0.f8453a < 23 || !drawable.setLayoutDirection(i10)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                invalidate();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r3 != 3) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x007b
            long r2 = r7.Q
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0010
            goto L_0x007b
        L_0x0010:
            android.graphics.Point r0 = r7.F
            float r2 = r8.getX()
            int r2 = (int) r2
            float r3 = r8.getY()
            int r3 = (int) r3
            r0.set(r2, r3)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L_0x0064
            r5 = 3
            if (r3 == r4) goto L_0x0055
            r6 = 2
            if (r3 == r6) goto L_0x0033
            if (r3 == r5) goto L_0x0055
            goto L_0x007b
        L_0x0033:
            boolean r8 = r7.O
            if (r8 == 0) goto L_0x007b
            int r8 = r7.A
            if (r0 >= r8) goto L_0x0041
            int r8 = r7.J
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r2 = r2 + r8
            goto L_0x0043
        L_0x0041:
            r7.J = r2
        L_0x0043:
            float r8 = (float) r2
            r7.b(r8)
            long r0 = r7.getScrubberPosition()
            r7.g(r0)
        L_0x004e:
            r7.f()
            r7.invalidate()
            return r4
        L_0x0055:
            boolean r0 = r7.O
            if (r0 == 0) goto L_0x007b
            int r8 = r8.getAction()
            if (r8 != r5) goto L_0x0060
            r1 = 1
        L_0x0060:
            r7.e(r1)
            return r4
        L_0x0064:
            float r8 = (float) r2
            float r0 = (float) r0
            int r2 = (int) r8
            int r0 = (int) r0
            android.graphics.Rect r3 = r7.f1828h
            boolean r0 = r3.contains(r2, r0)
            if (r0 == 0) goto L_0x007b
            r7.b(r8)
            long r0 = r7.getScrubberPosition()
            r7.d(r0)
            goto L_0x004e
        L_0x007b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (c(getPositionIncrement()) != false) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (c(-getPositionIncrement()) != false) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(int r7, android.os.Bundle r8) {
        /*
            r6 = this;
            boolean r8 = super.performAccessibilityAction(r7, r8)
            r0 = 1
            if (r8 == 0) goto L_0x0008
            return r0
        L_0x0008:
            long r1 = r6.Q
            r3 = 0
            r8 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0012
            return r8
        L_0x0012:
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r7 != r1) goto L_0x0025
            long r1 = r6.getPositionIncrement()
            long r1 = -r1
            boolean r7 = r6.c(r1)
            if (r7 == 0) goto L_0x0034
        L_0x0021:
            r6.e(r8)
            goto L_0x0034
        L_0x0025:
            r1 = 4096(0x1000, float:5.74E-42)
            if (r7 != r1) goto L_0x0039
            long r1 = r6.getPositionIncrement()
            boolean r7 = r6.c(r1)
            if (r7 == 0) goto L_0x0034
            goto L_0x0021
        L_0x0034:
            r7 = 4
            r6.sendAccessibilityEvent(r7)
            return r0
        L_0x0039:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.performAccessibilityAction(int, android.os.Bundle):boolean");
    }

    public void setAdMarkerColor(int i10) {
        this.f1835o.setColor(i10);
        invalidate(this.f1828h);
    }

    public void setBufferedColor(int i10) {
        this.f1833m.setColor(i10);
        invalidate(this.f1828h);
    }

    public void setBufferedPosition(long j10) {
        if (this.S != j10) {
            this.S = j10;
            f();
        }
    }

    public void setDuration(long j10) {
        if (this.Q != j10) {
            this.Q = j10;
            if (this.O && j10 == -9223372036854775807L) {
                e(true);
            }
            f();
        }
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (this.O && !z10) {
            e(true);
        }
    }

    public void setKeyCountIncrement(int i10) {
        a.b(i10 > 0);
        this.H = i10;
        this.I = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j10) {
        a.b(j10 > 0);
        this.H = -1;
        this.I = j10;
    }

    public void setPlayedAdMarkerColor(int i10) {
        this.f1836p.setColor(i10);
        invalidate(this.f1828h);
    }

    public void setPlayedColor(int i10) {
        this.f1832l.setColor(i10);
        invalidate(this.f1828h);
    }

    public void setPosition(long j10) {
        if (this.R != j10) {
            this.R = j10;
            setContentDescription(getProgressText());
            f();
        }
    }

    public void setScrubberColor(int i10) {
        this.f1837q.setColor(i10);
        invalidate(this.f1828h);
    }

    public void setUnplayedColor(int i10) {
        this.f1834n.setColor(i10);
        invalidate(this.f1828h);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, AttributeSet attributeSet2, int i10) {
        super(context, attributeSet, 0);
        int i11;
        int i12;
        AttributeSet attributeSet3 = attributeSet2;
        this.f1828h = new Rect();
        this.f1829i = new Rect();
        this.f1830j = new Rect();
        this.f1831k = new Rect();
        Paint paint = new Paint();
        this.f1832l = paint;
        Paint paint2 = new Paint();
        this.f1833m = paint2;
        Paint paint3 = new Paint();
        this.f1834n = paint3;
        Paint paint4 = new Paint();
        this.f1835o = paint4;
        Paint paint5 = new Paint();
        this.f1836p = paint5;
        Paint paint6 = new Paint();
        this.f1837q = paint6;
        paint6.setAntiAlias(true);
        this.E = new CopyOnWriteArraySet();
        this.F = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.G = f10;
        this.A = a(-50, f10);
        int a10 = a(4, f10);
        int a11 = a(26, f10);
        int a12 = a(4, f10);
        int a13 = a(12, f10);
        int a14 = a(0, f10);
        int a15 = a(16, f10);
        if (attributeSet3 != null) {
            Paint paint7 = paint4;
            Paint paint8 = paint5;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, h0.f8099b, 0, i10);
            try {
                Drawable drawable = obtainStyledAttributes.getDrawable(10);
                this.f1838r = drawable;
                if (drawable != null) {
                    int i13 = l0.f8453a;
                    if (i13 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i13 >= 23) {
                            boolean A2 = drawable.setLayoutDirection(layoutDirection);
                        }
                    }
                    a11 = Math.max(drawable.getMinimumHeight(), a11);
                }
                this.f1839s = obtainStyledAttributes.getDimensionPixelSize(3, a10);
                this.f1840t = obtainStyledAttributes.getDimensionPixelSize(12, a11);
                this.f1841u = obtainStyledAttributes.getInt(2, 0);
                this.f1842v = obtainStyledAttributes.getDimensionPixelSize(1, a12);
                this.f1843w = obtainStyledAttributes.getDimensionPixelSize(11, a13);
                this.f1844x = obtainStyledAttributes.getDimensionPixelSize(8, a14);
                this.f1845y = obtainStyledAttributes.getDimensionPixelSize(9, a15);
                int i14 = obtainStyledAttributes.getInt(6, -1);
                int i15 = obtainStyledAttributes.getInt(7, -1);
                int i16 = obtainStyledAttributes.getInt(4, -855638017);
                int i17 = obtainStyledAttributes.getInt(13, 872415231);
                int i18 = obtainStyledAttributes.getInt(0, -1291845888);
                int i19 = obtainStyledAttributes.getInt(5, 872414976);
                paint.setColor(i14);
                paint6.setColor(i15);
                paint2.setColor(i16);
                paint3.setColor(i17);
                paint7.setColor(i18);
                paint8.setColor(i19);
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            this.f1839s = a10;
            this.f1840t = a11;
            this.f1841u = 0;
            this.f1842v = a12;
            this.f1843w = a13;
            this.f1844x = a14;
            this.f1845y = a15;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f1838r = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.B = sb2;
        this.C = new Formatter(sb2, Locale.getDefault());
        this.D = new e(17, this);
        Drawable drawable2 = this.f1838r;
        if (drawable2 != null) {
            i12 = drawable2.getMinimumWidth();
            i11 = 1;
        } else {
            i11 = 1;
            i12 = Math.max(this.f1844x, Math.max(this.f1843w, this.f1845y));
        }
        this.f1846z = (i12 + i11) / 2;
        this.M = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.L = valueAnimator;
        valueAnimator.addUpdateListener(new i3.e(0, this));
        this.Q = -9223372036854775807L;
        this.I = -9223372036854775807L;
        this.H = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
