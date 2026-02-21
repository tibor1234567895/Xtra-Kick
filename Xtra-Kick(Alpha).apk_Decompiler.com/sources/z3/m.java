package z3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import c0.g;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;
import m0.t;
import m0.u;
import m0.v;
import m0.w;
import m0.x;
import q0.j;

public abstract class m extends ViewGroup implements w, v, t {
    public static final int[] R = {16842766};
    public a A;
    public int B = -1;
    public int C;
    public final int D;
    public final int E;
    public int F;
    public e G;
    public g H;
    public g I;
    public h J;
    public h K;
    public boolean L;
    public int M;
    public boolean N;
    public final f O = new f(this, 0);
    public final g P = new g(this, 2);
    public final g Q = new g(this, 3);

    /* renamed from: h  reason: collision with root package name */
    public View f17550h;

    /* renamed from: i  reason: collision with root package name */
    public j f17551i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f17552j = false;

    /* renamed from: k  reason: collision with root package name */
    public final int f17553k;

    /* renamed from: l  reason: collision with root package name */
    public float f17554l = -1.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f17555m;

    /* renamed from: n  reason: collision with root package name */
    public final x f17556n;

    /* renamed from: o  reason: collision with root package name */
    public final u f17557o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f17558p = new int[2];

    /* renamed from: q  reason: collision with root package name */
    public final int[] f17559q = new int[2];

    /* renamed from: r  reason: collision with root package name */
    public final int[] f17560r = new int[2];

    /* renamed from: s  reason: collision with root package name */
    public boolean f17561s;

    /* renamed from: t  reason: collision with root package name */
    public final int f17562t;

    /* renamed from: u  reason: collision with root package name */
    public int f17563u;

    /* renamed from: v  reason: collision with root package name */
    public float f17564v;

    /* renamed from: w  reason: collision with root package name */
    public float f17565w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f17566x;

    /* renamed from: y  reason: collision with root package name */
    public int f17567y = -1;

    /* renamed from: z  reason: collision with root package name */
    public final DecelerateInterpolator f17568z;

    public m(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17553k = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f17562t = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f17568z = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.M = (int) (displayMetrics.density * 40.0f);
        this.A = new a(getContext());
        e eVar = new e(getContext());
        this.G = eVar;
        eVar.b(7.5f, 2.5f, 10.0f, 5.0f);
        eVar.invalidateSelf();
        this.A.setImageDrawable(this.G);
        this.A.setVisibility(8);
        addView(this.A);
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.E = i10;
        this.f17554l = (float) i10;
        this.f17556n = new x();
        this.f17557o = new u(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.M;
        this.f17563u = i11;
        this.D = i11;
        k(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i10) {
        this.A.getBackground().setAlpha(i10);
        this.G.setAlpha(i10);
    }

    public final void a(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    public final void b(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        int i15;
        if (i14 == 0) {
            int i16 = iArr[1];
            int[] iArr2 = this.f17559q;
            if (i14 == 0) {
                this.f17557o.d(i10, i11, i12, i13, iArr2, i14, iArr);
            }
            int i17 = i13 - (iArr[1] - i16);
            if (i17 == 0) {
                i15 = i13 + this.f17559q[1];
            } else {
                i15 = i17;
            }
            if (i15 < 0 && !g()) {
                float abs = this.f17555m + ((float) Math.abs(i15));
                this.f17555m = abs;
                j(abs);
                iArr[1] = iArr[1] + i17;
            }
        }
    }

    public final boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f17557o.a(f10, f11, z10);
    }

    public final boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f17557o.b(f10, f11);
    }

    public final boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f17557o.c(i10, i11, iArr, iArr2, 0);
    }

    public final boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f17557o.e(i10, i11, i12, i13, iArr, 0, (int[]) null);
    }

    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        d(view, i10, i11, i12, i13, i14, this.f17560r);
    }

    public final boolean f(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            return onStartNestedScroll(view, view2, i10);
        }
        return false;
    }

    public final boolean g() {
        View view = this.f17550h;
        if (view instanceof ListView) {
            return j.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.B;
        return i12 < 0 ? i11 : i11 == i10 + -1 ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    public int getNestedScrollAxes() {
        x xVar = this.f17556n;
        return xVar.f10158b | xVar.f10157a;
    }

    public int getProgressCircleDiameter() {
        return this.M;
    }

    public int getProgressViewEndOffset() {
        return this.E;
    }

    public int getProgressViewStartOffset() {
        return this.D;
    }

    public final void h() {
        if (this.f17550h == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.A)) {
                    this.f17550h = childAt;
                    return;
                }
            }
        }
    }

    public final boolean hasNestedScrollingParent() {
        return this.f17557o.g(0);
    }

    public final void i(float f10) {
        if (f10 > this.f17554l) {
            m(true, true);
            return;
        }
        this.f17552j = false;
        e eVar = this.G;
        d dVar = eVar.f17536h;
        dVar.f17516e = 0.0f;
        dVar.f17517f = 0.0f;
        eVar.invalidateSelf();
        f fVar = new f(this, 1);
        this.C = this.f17563u;
        g gVar = this.Q;
        gVar.reset();
        gVar.setDuration(200);
        gVar.setInterpolator(this.f17568z);
        a aVar = this.A;
        aVar.f17505h = fVar;
        aVar.clearAnimation();
        this.A.startAnimation(gVar);
        e eVar2 = this.G;
        d dVar2 = eVar2.f17536h;
        if (dVar2.f17525n) {
            dVar2.f17525n = false;
        }
        eVar2.invalidateSelf();
    }

    public final boolean isNestedScrollingEnabled() {
        return this.f17557o.f10142d;
    }

    public final void j(float f10) {
        e eVar = this.G;
        d dVar = eVar.f17536h;
        boolean z10 = true;
        if (!dVar.f17525n) {
            dVar.f17525n = true;
        }
        eVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f10 / this.f17554l));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f10) - this.f17554l;
        int i10 = this.F;
        if (i10 <= 0) {
            i10 = this.E;
        }
        float f11 = (float) i10;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f11 * 2.0f) / f11) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i11 = this.D + ((int) ((f11 * min) + (f11 * pow * 2.0f)));
        if (this.A.getVisibility() != 0) {
            this.A.setVisibility(0);
        }
        this.A.setScaleX(1.0f);
        this.A.setScaleY(1.0f);
        if (f10 < this.f17554l) {
            if (this.G.f17536h.f17531t > 76) {
                h hVar = this.J;
                if (hVar == null || !hVar.hasStarted() || hVar.hasEnded()) {
                    z10 = false;
                }
                if (!z10) {
                    h hVar2 = new h(this, this.G.f17536h.f17531t, 76);
                    hVar2.setDuration(300);
                    a aVar = this.A;
                    aVar.f17505h = null;
                    aVar.clearAnimation();
                    this.A.startAnimation(hVar2);
                    this.J = hVar2;
                }
            }
        } else if (this.G.f17536h.f17531t < 255) {
            h hVar3 = this.K;
            if (hVar3 == null || !hVar3.hasStarted() || hVar3.hasEnded()) {
                z10 = false;
            }
            if (!z10) {
                h hVar4 = new h(this, this.G.f17536h.f17531t, 255);
                hVar4.setDuration(300);
                a aVar2 = this.A;
                aVar2.f17505h = null;
                aVar2.clearAnimation();
                this.A.startAnimation(hVar4);
                this.K = hVar4;
            }
        }
        e eVar2 = this.G;
        float min2 = Math.min(0.8f, max * 0.8f);
        d dVar2 = eVar2.f17536h;
        dVar2.f17516e = 0.0f;
        dVar2.f17517f = min2;
        eVar2.invalidateSelf();
        e eVar3 = this.G;
        float min3 = Math.min(1.0f, max);
        d dVar3 = eVar3.f17536h;
        if (min3 != dVar3.f17527p) {
            dVar3.f17527p = min3;
        }
        eVar3.invalidateSelf();
        e eVar4 = this.G;
        eVar4.f17536h.f17518g = ((pow * 2.0f) + ((max * 0.4f) - 16.0f)) * 0.5f;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i11 - this.f17563u);
    }

    public final void k(float f10) {
        int i10 = this.C;
        setTargetOffsetTopAndBottom((i10 + ((int) (((float) (this.D - i10)) * f10))) - this.A.getTop());
    }

    public final void l() {
        this.A.clearAnimation();
        this.G.stop();
        this.A.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.D - this.f17563u);
        this.f17563u = this.A.getTop();
    }

    public final void m(boolean z10, boolean z11) {
        if (this.f17552j != z10) {
            this.L = z11;
            h();
            this.f17552j = z10;
            f fVar = this.O;
            if (z10) {
                this.C = this.f17563u;
                g gVar = this.P;
                gVar.reset();
                gVar.setDuration(200);
                gVar.setInterpolator(this.f17568z);
                if (fVar != null) {
                    this.A.f17505h = fVar;
                }
                this.A.clearAnimation();
                this.A.startAnimation(gVar);
                return;
            }
            g gVar2 = new g(this, 1);
            this.I = gVar2;
            gVar2.setDuration(150);
            a aVar = this.A;
            aVar.f17505h = fVar;
            aVar.clearAnimation();
            this.A.startAnimation(this.I);
        }
    }

    public final void n(float f10) {
        float f11 = this.f17565w;
        int i10 = this.f17553k;
        if (f10 - f11 > ((float) i10) && !this.f17566x) {
            this.f17564v = f11 + ((float) i10);
            this.f17566x = true;
            this.G.setAlpha(76);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        h();
        int actionMasked = motionEvent.getActionMasked();
        int i10 = 0;
        if (!isEnabled() || g() || this.f17552j || this.f17561s) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i11 = this.f17567y;
                    if (i11 == -1) {
                        Log.e("m", "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i11);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    n(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.f17567y) {
                            if (actionIndex == 0) {
                                i10 = 1;
                            }
                            this.f17567y = motionEvent.getPointerId(i10);
                        }
                    }
                }
            }
            this.f17566x = false;
            this.f17567y = -1;
        } else {
            setTargetOffsetTopAndBottom(this.D - this.A.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f17567y = pointerId;
            this.f17566x = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f17565w = motionEvent.getY(findPointerIndex2);
        }
        return this.f17566x;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f17550h == null) {
                h();
            }
            View view = this.f17550h;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.A.getMeasuredWidth();
                int measuredHeight2 = this.A.getMeasuredHeight();
                int i14 = measuredWidth / 2;
                int i15 = measuredWidth2 / 2;
                int i16 = this.f17563u;
                this.A.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f17550h == null) {
            h();
        }
        View view = this.f17550h;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.A.measure(View.MeasureSpec.makeMeasureSpec(this.M, 1073741824), View.MeasureSpec.makeMeasureSpec(this.M, 1073741824));
            this.B = -1;
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                if (getChildAt(i12) == this.A) {
                    this.B = i12;
                    return;
                }
            }
        }
    }

    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    public final boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f17555m;
            if (f10 > 0.0f) {
                float f11 = (float) i11;
                if (f11 > f10) {
                    iArr[1] = (int) f10;
                    this.f17555m = 0.0f;
                } else {
                    this.f17555m = f10 - f11;
                    iArr[1] = i11;
                }
                j(this.f17555m);
            }
        }
        int[] iArr2 = this.f17558p;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        d(view, i10, i11, i12, i13, 0, this.f17560r);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f17556n.f10157a = i10;
        startNestedScroll(i10 & 2);
        this.f17555m = 0.0f;
        this.f17561s = true;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        l lVar = (l) parcelable;
        super.onRestoreInstanceState(lVar.getSuperState());
        setRefreshing(lVar.f17549h);
    }

    public final Parcelable onSaveInstanceState() {
        return new l(super.onSaveInstanceState(), this.f17552j);
    }

    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return isEnabled() && !this.f17552j && (i10 & 2) != 0;
    }

    public final void onStopNestedScroll(View view) {
        this.f17556n.f10157a = 0;
        this.f17561s = false;
        float f10 = this.f17555m;
        if (f10 > 0.0f) {
            i(f10);
            this.f17555m = 0.0f;
        }
        stopNestedScroll();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int i10 = 0;
        if (!isEnabled() || g() || this.f17552j || this.f17561s) {
            return false;
        }
        if (actionMasked == 0) {
            this.f17567y = motionEvent.getPointerId(0);
            this.f17566x = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f17567y);
            if (findPointerIndex < 0) {
                Log.e("m", "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.f17566x) {
                this.f17566x = false;
                i((motionEvent.getY(findPointerIndex) - this.f17564v) * 0.5f);
            }
            this.f17567y = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f17567y);
            if (findPointerIndex2 < 0) {
                Log.e("m", "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y10 = motionEvent.getY(findPointerIndex2);
            n(y10);
            if (this.f17566x) {
                float f10 = (y10 - this.f17564v) * 0.5f;
                if (f10 <= 0.0f) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                j(f10);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e("m", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f17567y = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                int actionIndex2 = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex2) == this.f17567y) {
                    if (actionIndex2 == 0) {
                        i10 = 1;
                    }
                    this.f17567y = motionEvent.getPointerId(i10);
                }
            }
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent;
        View view = this.f17550h;
        if (view != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (!o0.p(view)) {
                if (!this.N && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(z10);
                    return;
                }
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void setAnimationProgress(float f10) {
        this.A.setScaleX(f10);
        this.A.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        h();
        e eVar = this.G;
        d dVar = eVar.f17536h;
        dVar.f17520i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = g.b(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f17554l = (float) i10;
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!z10) {
            l();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.N = z10;
    }

    public void setNestedScrollingEnabled(boolean z10) {
        u uVar = this.f17557o;
        if (uVar.f10142d) {
            WeakHashMap weakHashMap = c1.f10054a;
            o0.z(uVar.f10141c);
        }
        uVar.f10142d = z10;
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }

    public void setOnRefreshListener(j jVar) {
        this.f17551i = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(int i10) {
        this.A.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(int i10) {
        setProgressBackgroundColorSchemeColor(g.b(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f17552j == z10) {
            m(z10, false);
            return;
        }
        this.f17552j = z10;
        setTargetOffsetTopAndBottom((this.E + this.D) - this.f17563u);
        this.L = false;
        this.A.setVisibility(0);
        this.G.setAlpha(255);
        g gVar = new g(this, 0);
        this.H = gVar;
        gVar.setDuration((long) this.f17562t);
        f fVar = this.O;
        if (fVar != null) {
            this.A.f17505h = fVar;
        }
        this.A.clearAnimation();
        this.A.startAnimation(this.H);
    }

    public void setSize(int i10) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        if (i10 == 0 || i10 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i10 == 0) {
                f10 = 56.0f;
            } else {
                f10 = 40.0f;
            }
            this.M = (int) (displayMetrics.density * f10);
            this.A.setImageDrawable((Drawable) null);
            e eVar = this.G;
            eVar.getClass();
            if (i10 == 0) {
                f11 = 12.0f;
                f14 = 6.0f;
                f13 = 11.0f;
                f12 = 3.0f;
            } else {
                f11 = 10.0f;
                f14 = 5.0f;
                f13 = 7.5f;
                f12 = 2.5f;
            }
            eVar.b(f13, f12, f11, f14);
            eVar.invalidateSelf();
            this.A.setImageDrawable(this.G);
        }
    }

    public void setSlingshotDistance(int i10) {
        this.F = i10;
    }

    public void setTargetOffsetTopAndBottom(int i10) {
        this.A.bringToFront();
        c1.k(this.A, i10);
        this.f17563u = this.A.getTop();
    }

    public final boolean startNestedScroll(int i10) {
        return this.f17557o.h(i10, 0);
    }

    public final void stopNestedScroll() {
        this.f17557o.i(0);
    }
}
