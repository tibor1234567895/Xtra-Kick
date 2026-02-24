package u0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import java.util.Arrays;
import m0.c1;

public final class h {

    /* renamed from: v  reason: collision with root package name */
    public static final f f15174v = new f();

    /* renamed from: a  reason: collision with root package name */
    public int f15175a;

    /* renamed from: b  reason: collision with root package name */
    public int f15176b;

    /* renamed from: c  reason: collision with root package name */
    public int f15177c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float[] f15178d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f15179e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f15180f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f15181g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f15182h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f15183i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f15184j;

    /* renamed from: k  reason: collision with root package name */
    public int f15185k;

    /* renamed from: l  reason: collision with root package name */
    public VelocityTracker f15186l;

    /* renamed from: m  reason: collision with root package name */
    public final float f15187m;

    /* renamed from: n  reason: collision with root package name */
    public final float f15188n;

    /* renamed from: o  reason: collision with root package name */
    public final int f15189o;

    /* renamed from: p  reason: collision with root package name */
    public final OverScroller f15190p;

    /* renamed from: q  reason: collision with root package name */
    public final g f15191q;

    /* renamed from: r  reason: collision with root package name */
    public View f15192r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f15193s;

    /* renamed from: t  reason: collision with root package name */
    public final ViewGroup f15194t;

    /* renamed from: u  reason: collision with root package name */
    public final androidx.activity.h f15195u = new androidx.activity.h(5, this);

    public h(Context context, ViewGroup viewGroup, g gVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (gVar != null) {
            this.f15194t = viewGroup;
            this.f15191q = gVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f15189o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f15176b = viewConfiguration.getScaledTouchSlop();
            this.f15187m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f15188n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f15190p = new OverScroller(context, f15174v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    public static boolean k(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public final void a() {
        this.f15177c = -1;
        float[] fArr = this.f15178d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f15179e, 0.0f);
            Arrays.fill(this.f15180f, 0.0f);
            Arrays.fill(this.f15181g, 0.0f);
            Arrays.fill(this.f15182h, 0);
            Arrays.fill(this.f15183i, 0);
            Arrays.fill(this.f15184j, 0);
            this.f15185k = 0;
        }
        VelocityTracker velocityTracker = this.f15186l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f15186l = null;
        }
    }

    public final void b(View view, int i10) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f15194t;
        if (parent == viewGroup) {
            this.f15192r = view;
            this.f15177c = i10;
            this.f15191q.e(view, i10);
            q(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float abs = Math.abs(f10);
        float abs2 = Math.abs(f11);
        if ((this.f15182h[i10] & i11) != i11 || (0 & i11) == 0 || (this.f15184j[i10] & i11) == i11 || (this.f15183i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f15176b;
        if (abs <= ((float) i12) && abs2 <= ((float) i12)) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.f15191q.getClass();
        }
        return (this.f15183i[i10] & i11) == 0 && abs > ((float) this.f15176b);
    }

    public final boolean d(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        g gVar = this.f15191q;
        boolean z10 = gVar.c(view) > 0;
        boolean z11 = gVar.d() > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f15176b) : z11 && Math.abs(f11) > ((float) this.f15176b);
        }
        float f12 = f11 * f11;
        int i10 = this.f15176b;
        return f12 + (f10 * f10) > ((float) (i10 * i10));
    }

    public final void e(int i10) {
        float[] fArr = this.f15178d;
        if (fArr != null) {
            int i11 = this.f15185k;
            boolean z10 = true;
            int i12 = 1 << i10;
            if ((i12 & i11) == 0) {
                z10 = false;
            }
            if (z10) {
                fArr[i10] = 0.0f;
                this.f15179e[i10] = 0.0f;
                this.f15180f[i10] = 0.0f;
                this.f15181g[i10] = 0.0f;
                this.f15182h[i10] = 0;
                this.f15183i[i10] = 0;
                this.f15184j[i10] = 0;
                this.f15185k = (~i12) & i11;
            }
        }
    }

    public final int f(int i10, int i11, int i12) {
        int i13;
        if (i10 == 0) {
            return 0;
        }
        int width = this.f15194t.getWidth();
        float f10 = (float) (width / 2);
        float sin = (((float) Math.sin((double) ((Math.min(1.0f, ((float) Math.abs(i10)) / ((float) width)) - 0.5f) * 0.47123894f))) * f10) + f10;
        int abs = Math.abs(i11);
        if (abs > 0) {
            i13 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
        } else {
            i13 = (int) (((((float) Math.abs(i10)) / ((float) i12)) + 1.0f) * 256.0f);
        }
        return Math.min(i13, 600);
    }

    public final boolean g() {
        if (this.f15175a == 2) {
            OverScroller overScroller = this.f15190p;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f15192r.getLeft();
            int top = currY - this.f15192r.getTop();
            if (left != 0) {
                c1.j(this.f15192r, left);
            }
            if (top != 0) {
                c1.k(this.f15192r, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f15191q.g(this.f15192r, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f15194t.post(this.f15195u);
            }
        }
        return this.f15175a == 2;
    }

    public final View h(int i10, int i11) {
        ViewGroup viewGroup = this.f15194t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f15191q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean i(int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int left = this.f15192r.getLeft();
        int top = this.f15192r.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        OverScroller overScroller = this.f15190p;
        if (i14 == 0 && i15 == 0) {
            overScroller.abortAnimation();
            q(0);
            return false;
        }
        View view = this.f15192r;
        int i16 = (int) this.f15188n;
        int i17 = (int) this.f15187m;
        int abs = Math.abs(i12);
        if (abs < i16) {
            i12 = 0;
        } else if (abs > i17) {
            if (i12 > 0) {
                i12 = i17;
            } else {
                i12 = -i17;
            }
        }
        int abs2 = Math.abs(i13);
        if (abs2 < i16) {
            i13 = 0;
        } else if (abs2 > i17) {
            if (i13 > 0) {
                i13 = i17;
            } else {
                i13 = -i17;
            }
        }
        int abs3 = Math.abs(i14);
        int abs4 = Math.abs(i15);
        int abs5 = Math.abs(i12);
        int abs6 = Math.abs(i13);
        int i18 = abs5 + abs6;
        int i19 = abs3 + abs4;
        if (i12 != 0) {
            f10 = (float) abs5;
            f11 = (float) i18;
        } else {
            f10 = (float) abs3;
            f11 = (float) i19;
        }
        float f14 = f10 / f11;
        if (i13 != 0) {
            f13 = (float) abs6;
            f12 = (float) i18;
        } else {
            f13 = (float) abs4;
            f12 = (float) i19;
        }
        float f15 = f13 / f12;
        g gVar = this.f15191q;
        overScroller.startScroll(left, top, i14, i15, (int) ((((float) f(i15, i13, gVar.d())) * f15) + (((float) f(i14, i12, gVar.c(view))) * f14)));
        q(2);
        return true;
    }

    public final boolean j(int i10) {
        boolean z10;
        if ((this.f15185k & (1 << i10)) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void l(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f15186l == null) {
            this.f15186l = VelocityTracker.obtain();
        }
        this.f15186l.addMovement(motionEvent);
        int i11 = 0;
        g gVar = this.f15191q;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f15175a != 1) {
                        int pointerCount = motionEvent.getPointerCount();
                        while (i11 < pointerCount) {
                            int pointerId = motionEvent.getPointerId(i11);
                            if (j(pointerId)) {
                                float x10 = motionEvent.getX(i11);
                                float y10 = motionEvent.getY(i11);
                                float f10 = x10 - this.f15178d[pointerId];
                                float f11 = y10 - this.f15179e[pointerId];
                                n(pointerId, f10, f11);
                                if (this.f15175a != 1) {
                                    View h10 = h((int) x10, (int) y10);
                                    if (d(h10, f10, f11) && u(h10, pointerId)) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            i11++;
                        }
                    } else if (j(this.f15177c)) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f15177c);
                        float x11 = motionEvent.getX(findPointerIndex);
                        float y11 = motionEvent.getY(findPointerIndex);
                        float[] fArr = this.f15180f;
                        int i12 = this.f15177c;
                        int i13 = (int) (x11 - fArr[i12]);
                        int i14 = (int) (y11 - this.f15181g[i12]);
                        int left = this.f15192r.getLeft() + i13;
                        int top = this.f15192r.getTop() + i14;
                        int left2 = this.f15192r.getLeft();
                        int top2 = this.f15192r.getTop();
                        if (i13 != 0) {
                            left = gVar.a(this.f15192r, left);
                            c1.j(this.f15192r, left - left2);
                        }
                        if (i14 != 0) {
                            top = gVar.b(this.f15192r, top);
                            c1.k(this.f15192r, top - top2);
                        }
                        if (!(i13 == 0 && i14 == 0)) {
                            gVar.g(this.f15192r, left, top);
                        }
                    } else {
                        return;
                    }
                    p(motionEvent);
                    return;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x12 = motionEvent.getX(actionIndex);
                        float y12 = motionEvent.getY(actionIndex);
                        o(pointerId2, x12, y12);
                        if (this.f15175a == 0) {
                            u(h((int) x12, (int) y12), pointerId2);
                            if ((this.f15182h[pointerId2] & 0) == 0) {
                                return;
                            }
                        } else {
                            if (k(this.f15192r, (int) x12, (int) y12)) {
                                u(this.f15192r, pointerId2);
                                return;
                            }
                            return;
                        }
                    } else if (actionMasked == 6) {
                        int pointerId3 = motionEvent.getPointerId(actionIndex);
                        if (this.f15175a == 1 && pointerId3 == this.f15177c) {
                            int pointerCount2 = motionEvent.getPointerCount();
                            while (true) {
                                if (i11 >= pointerCount2) {
                                    i10 = -1;
                                    break;
                                }
                                int pointerId4 = motionEvent.getPointerId(i11);
                                if (pointerId4 != this.f15177c) {
                                    View h11 = h((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                                    View view = this.f15192r;
                                    if (h11 == view && u(view, pointerId4)) {
                                        i10 = this.f15177c;
                                        break;
                                    }
                                }
                                i11++;
                            }
                            if (i10 == -1) {
                                m();
                            }
                        }
                        e(pointerId3);
                        return;
                    } else {
                        return;
                    }
                } else if (this.f15175a == 1) {
                    this.f15193s = true;
                    gVar.h(this.f15192r, 0.0f, 0.0f);
                    this.f15193s = false;
                    if (this.f15175a == 1) {
                        q(0);
                    }
                }
            } else if (this.f15175a == 1) {
                m();
            }
            a();
            return;
        }
        float x13 = motionEvent.getX();
        float y13 = motionEvent.getY();
        int pointerId5 = motionEvent.getPointerId(0);
        View h12 = h((int) x13, (int) y13);
        o(pointerId5, x13, y13);
        u(h12, pointerId5);
        if ((this.f15182h[pointerId5] & 0) == 0) {
            return;
        }
        gVar.getClass();
    }

    public final void m() {
        VelocityTracker velocityTracker = this.f15186l;
        float f10 = this.f15187m;
        velocityTracker.computeCurrentVelocity(1000, f10);
        float xVelocity = this.f15186l.getXVelocity(this.f15177c);
        float abs = Math.abs(xVelocity);
        float f11 = 0.0f;
        float f12 = this.f15188n;
        if (abs < f12) {
            xVelocity = 0.0f;
        } else if (abs > f10) {
            if (xVelocity > 0.0f) {
                xVelocity = f10;
            } else {
                xVelocity = -f10;
            }
        }
        float yVelocity = this.f15186l.getYVelocity(this.f15177c);
        float abs2 = Math.abs(yVelocity);
        if (abs2 >= f12) {
            if (abs2 > f10) {
                if (yVelocity <= 0.0f) {
                    f10 = -f10;
                }
                f11 = f10;
            } else {
                f11 = yVelocity;
            }
        }
        this.f15193s = true;
        this.f15191q.h(this.f15192r, xVelocity, f11);
        this.f15193s = false;
        if (this.f15175a == 1) {
            q(0);
        }
    }

    public final void n(int i10, float f10, float f11) {
        boolean c10 = c(f10, f11, i10, 1);
        if (c(f11, f10, i10, 4)) {
            c10 |= true;
        }
        if (c(f10, f11, i10, 2)) {
            c10 |= true;
        }
        if (c(f11, f10, i10, 8)) {
            c10 |= true;
        }
        if (c10) {
            int[] iArr = this.f15183i;
            iArr[i10] = iArr[i10] | c10;
            this.f15191q.getClass();
        }
    }

    public final void o(int i10, float f10, float f11) {
        float[] fArr = this.f15178d;
        int i11 = 0;
        if (fArr == null || fArr.length <= i10) {
            int i12 = i10 + 1;
            float[] fArr2 = new float[i12];
            float[] fArr3 = new float[i12];
            float[] fArr4 = new float[i12];
            float[] fArr5 = new float[i12];
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int[] iArr3 = new int[i12];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f15179e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f15180f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f15181g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f15182h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f15183i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f15184j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f15178d = fArr2;
            this.f15179e = fArr3;
            this.f15180f = fArr4;
            this.f15181g = fArr5;
            this.f15182h = iArr;
            this.f15183i = iArr2;
            this.f15184j = iArr3;
        }
        float[] fArr9 = this.f15178d;
        this.f15180f[i10] = f10;
        fArr9[i10] = f10;
        float[] fArr10 = this.f15179e;
        this.f15181g[i10] = f11;
        fArr10[i10] = f11;
        int[] iArr7 = this.f15182h;
        int i13 = (int) f10;
        int i14 = (int) f11;
        ViewGroup viewGroup = this.f15194t;
        int left = viewGroup.getLeft();
        int i15 = this.f15189o;
        if (i13 < left + i15) {
            i11 = 1;
        }
        if (i14 < viewGroup.getTop() + i15) {
            i11 |= 4;
        }
        if (i13 > viewGroup.getRight() - i15) {
            i11 |= 2;
        }
        if (i14 > viewGroup.getBottom() - i15) {
            i11 |= 8;
        }
        iArr7[i10] = i11;
        this.f15185k = (1 << i10) | this.f15185k;
    }

    public final void p(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (j(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f15180f[pointerId] = x10;
                this.f15181g[pointerId] = y10;
            }
        }
    }

    public final void q(int i10) {
        this.f15194t.removeCallbacks(this.f15195u);
        if (this.f15175a != i10) {
            this.f15175a = i10;
            this.f15191q.f(i10);
            if (this.f15175a == 0) {
                this.f15192r = null;
            }
        }
    }

    public final boolean r(int i10, int i11) {
        if (this.f15193s) {
            return i(i10, i11, (int) this.f15186l.getXVelocity(this.f15177c), (int) this.f15186l.getYVelocity(this.f15177c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        if ((r0.f15182h[r2] & 0) != 0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cf, code lost:
        if (r13 != r12) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0119, code lost:
        if ((r0.f15182h[r1] & 0) != 0) goto L_0x011b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0123 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s(android.view.MotionEvent r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r19.getActionMasked()
            int r3 = r19.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r18.a()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f15186l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f15186l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f15186l
            r4.addMovement(r1)
            r4 = 1
            r5 = 0
            r6 = 2
            u0.g r7 = r0.f15191q
            if (r2 == 0) goto L_0x00f4
            if (r2 == r4) goto L_0x00f0
            if (r2 == r6) goto L_0x006c
            r8 = 3
            if (r2 == r8) goto L_0x00f0
            r8 = 5
            if (r2 == r8) goto L_0x003f
            r6 = 6
            if (r2 == r6) goto L_0x0036
            goto L_0x011e
        L_0x0036:
            int r1 = r1.getPointerId(r3)
            r0.e(r1)
            goto L_0x011e
        L_0x003f:
            int r2 = r1.getPointerId(r3)
            float r8 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.o(r2, r8, r1)
            int r3 = r0.f15175a
            if (r3 != 0) goto L_0x005b
            int[] r1 = r0.f15182h
            r1 = r1[r2]
            r1 = r1 & r5
            if (r1 == 0) goto L_0x011e
            goto L_0x011b
        L_0x005b:
            if (r3 != r6) goto L_0x011e
            int r3 = (int) r8
            int r1 = (int) r1
            android.view.View r1 = r0.h(r3, r1)
            android.view.View r3 = r0.f15192r
            if (r1 != r3) goto L_0x011e
            r0.u(r1, r2)
            goto L_0x011e
        L_0x006c:
            float[] r2 = r0.f15178d
            if (r2 == 0) goto L_0x011e
            float[] r2 = r0.f15179e
            if (r2 != 0) goto L_0x0076
            goto L_0x011e
        L_0x0076:
            int r2 = r19.getPointerCount()
            r3 = 0
        L_0x007b:
            if (r3 >= r2) goto L_0x00ec
            int r6 = r1.getPointerId(r3)
            boolean r8 = r0.j(r6)
            if (r8 != 0) goto L_0x0088
            goto L_0x00e9
        L_0x0088:
            float r8 = r1.getX(r3)
            float r9 = r1.getY(r3)
            float[] r10 = r0.f15178d
            r10 = r10[r6]
            float r10 = r8 - r10
            float[] r11 = r0.f15179e
            r11 = r11[r6]
            float r11 = r9 - r11
            int r8 = (int) r8
            int r9 = (int) r9
            android.view.View r8 = r0.h(r8, r9)
            if (r8 == 0) goto L_0x00ac
            boolean r9 = r0.d(r8, r10, r11)
            if (r9 == 0) goto L_0x00ac
            r9 = 1
            goto L_0x00ad
        L_0x00ac:
            r9 = 0
        L_0x00ad:
            if (r9 == 0) goto L_0x00d8
            int r12 = r8.getLeft()
            int r13 = (int) r10
            int r13 = r13 + r12
            int r13 = r7.a(r8, r13)
            int r14 = r8.getTop()
            int r15 = (int) r11
            int r15 = r15 + r14
            int r15 = r7.b(r8, r15)
            int r16 = r7.c(r8)
            int r17 = r7.d()
            if (r16 == 0) goto L_0x00d1
            if (r16 <= 0) goto L_0x00d8
            if (r13 != r12) goto L_0x00d8
        L_0x00d1:
            if (r17 == 0) goto L_0x00ec
            if (r17 <= 0) goto L_0x00d8
            if (r15 != r14) goto L_0x00d8
            goto L_0x00ec
        L_0x00d8:
            r0.n(r6, r10, r11)
            int r10 = r0.f15175a
            if (r10 != r4) goto L_0x00e0
            goto L_0x00ec
        L_0x00e0:
            if (r9 == 0) goto L_0x00e9
            boolean r6 = r0.u(r8, r6)
            if (r6 == 0) goto L_0x00e9
            goto L_0x00ec
        L_0x00e9:
            int r3 = r3 + 1
            goto L_0x007b
        L_0x00ec:
            r18.p(r19)
            goto L_0x011e
        L_0x00f0:
            r18.a()
            goto L_0x011e
        L_0x00f4:
            float r2 = r19.getX()
            float r3 = r19.getY()
            int r1 = r1.getPointerId(r5)
            r0.o(r1, r2, r3)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.h(r2, r3)
            android.view.View r3 = r0.f15192r
            if (r2 != r3) goto L_0x0114
            int r3 = r0.f15175a
            if (r3 != r6) goto L_0x0114
            r0.u(r2, r1)
        L_0x0114:
            int[] r2 = r0.f15182h
            r1 = r2[r1]
            r1 = r1 & r5
            if (r1 == 0) goto L_0x011e
        L_0x011b:
            r7.getClass()
        L_0x011e:
            int r1 = r0.f15175a
            if (r1 != r4) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r4 = 0
        L_0x0124:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.h.s(android.view.MotionEvent):boolean");
    }

    public final boolean t(View view, int i10, int i11) {
        this.f15192r = view;
        this.f15177c = -1;
        boolean i12 = i(i10, i11, 0, 0);
        if (!i12 && this.f15175a == 0 && this.f15192r != null) {
            this.f15192r = null;
        }
        return i12;
    }

    public final boolean u(View view, int i10) {
        if (view == this.f15192r && this.f15177c == i10) {
            return true;
        }
        if (view == null || !this.f15191q.i(view, i10)) {
            return false;
        }
        this.f15177c = i10;
        b(view, i10);
        return true;
    }
}
