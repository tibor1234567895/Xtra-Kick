package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import hb.h0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m0.o0;
import m0.t;
import m0.u;
import m0.w;
import m0.x;
import q0.g;
import q0.k;
import q0.l;
import q0.m;
import q0.o;

public class NestedScrollView extends FrameLayout implements w, t {
    public static final float I = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    public static final k J = new k();
    public static final int[] K = {16843130};
    public final int[] A = new int[2];
    public int B;
    public int C;
    public o D;
    public final x E;
    public final u F;
    public float G;
    public m H;

    /* renamed from: h  reason: collision with root package name */
    public final float f1221h;

    /* renamed from: i  reason: collision with root package name */
    public long f1222i;

    /* renamed from: j  reason: collision with root package name */
    public final Rect f1223j = new Rect();

    /* renamed from: k  reason: collision with root package name */
    public OverScroller f1224k;

    /* renamed from: l  reason: collision with root package name */
    public final EdgeEffect f1225l;

    /* renamed from: m  reason: collision with root package name */
    public final EdgeEffect f1226m;

    /* renamed from: n  reason: collision with root package name */
    public int f1227n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1228o = true;

    /* renamed from: p  reason: collision with root package name */
    public boolean f1229p = false;

    /* renamed from: q  reason: collision with root package name */
    public View f1230q = null;

    /* renamed from: r  reason: collision with root package name */
    public boolean f1231r = false;

    /* renamed from: s  reason: collision with root package name */
    public VelocityTracker f1232s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1233t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f1234u = true;

    /* renamed from: v  reason: collision with root package name */
    public int f1235v;

    /* renamed from: w  reason: collision with root package name */
    public int f1236w;

    /* renamed from: x  reason: collision with root package name */
    public int f1237x;

    /* renamed from: y  reason: collision with root package name */
    public int f1238y = -1;

    /* renamed from: z  reason: collision with root package name */
    public final int[] f1239z = new int[2];

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.nestedScrollViewStyle);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            edgeEffect = g.a(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.f1225l = edgeEffect;
        if (i10 >= 31) {
            edgeEffect2 = g.a(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.f1226m = edgeEffect2;
        this.f1221h = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1224k = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1235v = viewConfiguration.getScaledTouchSlop();
        this.f1236w = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1237x = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, R.attr.nestedScrollViewStyle, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.E = new x();
        this.F = new u(this);
        setNestedScrollingEnabled(true);
        c1.p(this, J);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.G == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.G = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.G;
    }

    public static boolean n(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && n((View) parent, view2);
    }

    public final void a(View view, View view2, int i10, int i11) {
        x xVar = this.E;
        if (i11 == 1) {
            xVar.f10158b = i10;
        } else {
            xVar.f10157a = i10;
        }
        w(2, i11);
    }

    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void b(View view, int i10) {
        x xVar = this.E;
        if (i10 == 1) {
            xVar.f10158b = 0;
        } else {
            xVar.f10157a = 0;
        }
        y(i10);
    }

    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
        i(i10, i11, iArr, (int[]) null, i12);
    }

    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void computeScroll() {
        /*
            r15 = this;
            android.widget.OverScroller r0 = r15.f1224k
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            android.widget.OverScroller r0 = r15.f1224k
            r0.computeScrollOffset()
            android.widget.OverScroller r0 = r15.f1224k
            int r0 = r0.getCurrY()
            int r1 = r15.C
            int r1 = r0 - r1
            int r2 = r15.getHeight()
            android.widget.EdgeEffect r3 = r15.f1226m
            android.widget.EdgeEffect r4 = r15.f1225l
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = 0
            r7 = 1082130432(0x40800000, float:4.0)
            if (r1 <= 0) goto L_0x0048
            float r8 = hb.h0.e0(r4)
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0048
            int r6 = -r1
            float r6 = (float) r6
            float r6 = r6 * r7
            float r8 = (float) r2
            float r6 = r6 / r8
            int r2 = -r2
            float r2 = (float) r2
            float r2 = r2 / r7
            float r5 = hb.h0.i1(r4, r6, r5)
            float r5 = r5 * r2
            int r2 = java.lang.Math.round(r5)
            if (r2 == r1) goto L_0x0067
            r4.finish()
            goto L_0x0067
        L_0x0048:
            if (r1 >= 0) goto L_0x0068
            float r8 = hb.h0.e0(r3)
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0068
            float r6 = (float) r1
            float r6 = r6 * r7
            float r2 = (float) r2
            float r6 = r6 / r2
            float r2 = r2 / r7
            float r5 = hb.h0.i1(r3, r6, r5)
            float r5 = r5 * r2
            int r2 = java.lang.Math.round(r5)
            if (r2 == r1) goto L_0x0067
            r3.finish()
        L_0x0067:
            int r1 = r1 - r2
        L_0x0068:
            r15.C = r0
            int[] r0 = r15.A
            r2 = 1
            r13 = 0
            r0[r2] = r13
            r6 = 0
            r9 = 0
            r10 = 1
            r5 = r15
            r7 = r1
            r8 = r0
            r5.i(r6, r7, r8, r9, r10)
            r5 = r0[r2]
            int r1 = r1 - r5
            int r14 = r15.getScrollRange()
            if (r1 == 0) goto L_0x00a5
            int r5 = r15.getScrollY()
            int r6 = r15.getScrollX()
            r15.r(r1, r6, r5, r14)
            int r6 = r15.getScrollY()
            int r7 = r6 - r5
            int r1 = r1 - r7
            r0[r2] = r13
            int[] r10 = r15.f1239z
            r11 = 1
            r6 = 0
            r8 = 0
            m0.u r5 = r15.F
            r9 = r1
            r12 = r0
            r5.e(r6, r7, r8, r9, r10, r11, r12)
            r0 = r0[r2]
            int r1 = r1 - r0
        L_0x00a5:
            if (r1 == 0) goto L_0x00df
            int r0 = r15.getOverScrollMode()
            if (r0 == 0) goto L_0x00b1
            if (r0 != r2) goto L_0x00b2
            if (r14 <= 0) goto L_0x00b2
        L_0x00b1:
            r13 = 1
        L_0x00b2:
            if (r13 == 0) goto L_0x00d7
            if (r1 >= 0) goto L_0x00c7
            boolean r0 = r4.isFinished()
            if (r0 == 0) goto L_0x00d7
            android.widget.OverScroller r0 = r15.f1224k
            float r0 = r0.getCurrVelocity()
            int r0 = (int) r0
            r4.onAbsorb(r0)
            goto L_0x00d7
        L_0x00c7:
            boolean r0 = r3.isFinished()
            if (r0 == 0) goto L_0x00d7
            android.widget.OverScroller r0 = r15.f1224k
            float r0 = r0.getCurrVelocity()
            int r0 = (int) r0
            r3.onAbsorb(r0)
        L_0x00d7:
            android.widget.OverScroller r0 = r15.f1224k
            r0.abortAnimation()
            r15.y(r2)
        L_0x00df:
            android.widget.OverScroller r0 = r15.f1224k
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00ed
            java.util.WeakHashMap r0 = m0.c1.f10054a
            m0.i0.k(r15)
            goto L_0x00f0
        L_0x00ed:
            r15.y(r2)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        p(i13, i14, iArr);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || k(keyEvent);
    }

    public final boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.F.a(f10, f11, z10);
    }

    public final boolean dispatchNestedPreFling(float f10, float f11) {
        return this.F.b(f10, f11);
    }

    public final boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return i(i10, i11, iArr, iArr2, 0);
    }

    public final boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.F.e(i10, i11, i12, i13, iArr, 0, (int[]) null);
    }

    public final void draw(Canvas canvas) {
        int i10;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f1225l;
        int i11 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (l.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i10 = getPaddingLeft() + 0;
            } else {
                i10 = 0;
            }
            if (l.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate((float) i10, (float) min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = c1.f10054a;
                i0.k(this);
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f1226m;
        if (!edgeEffect2.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (l.a(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i11 = 0 + getPaddingLeft();
            }
            if (l.a(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i11 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            edgeEffect2.setSize(width2, height2);
            if (edgeEffect2.draw(canvas)) {
                WeakHashMap weakHashMap2 = c1.f10054a;
                i0.k(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        p(i13, i14, (int[]) null);
    }

    public final boolean f(View view, View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    public final boolean g(int i10) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !o(findNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            t(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f1223j;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            t(h(rect), 0, 1, true);
            findNextFocus.requestFocus(i10);
        }
        if (findFocus != null && findFocus.isFocused() && (!o(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        x xVar = this.E;
        return xVar.f10158b | xVar.f10157a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public final int h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i11) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        } else if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        } else {
            return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
        }
    }

    public final boolean hasNestedScrollingParent() {
        return this.F.g(0);
    }

    public final boolean i(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return this.F.c(i10, i11, iArr, iArr2, i12);
    }

    public final boolean isNestedScrollingEnabled() {
        return this.F.f10142d;
    }

    public final void j() {
        this.f1238y = -1;
        this.f1231r = false;
        VelocityTracker velocityTracker = this.f1232s;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1232s = null;
        }
        y(0);
        this.f1225l.onRelease();
        this.f1226m.onRelease();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(android.view.KeyEvent r8) {
        /*
            r7 = this;
            android.graphics.Rect r0 = r7.f1223j
            r0.setEmpty()
            int r1 = r7.getChildCount()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x0033
            android.view.View r1 = r7.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r4 = (android.widget.FrameLayout.LayoutParams) r4
            int r1 = r1.getHeight()
            int r5 = r4.topMargin
            int r1 = r1 + r5
            int r4 = r4.bottomMargin
            int r1 = r1 + r4
            int r4 = r7.getHeight()
            int r5 = r7.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r7.getPaddingBottom()
            int r4 = r4 - r5
            if (r1 <= r4) goto L_0x0033
            r1 = 1
            goto L_0x0034
        L_0x0033:
            r1 = 0
        L_0x0034:
            r4 = 130(0x82, float:1.82E-43)
            if (r1 != 0) goto L_0x0062
            boolean r0 = r7.isFocused()
            if (r0 == 0) goto L_0x0061
            int r8 = r8.getKeyCode()
            r0 = 4
            if (r8 == r0) goto L_0x0061
            android.view.View r8 = r7.findFocus()
            if (r8 != r7) goto L_0x004c
            r8 = 0
        L_0x004c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r8 = r0.findNextFocus(r7, r8, r4)
            if (r8 == 0) goto L_0x005f
            if (r8 == r7) goto L_0x005f
            boolean r8 = r8.requestFocus(r4)
            if (r8 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r2 = 0
        L_0x0060:
            return r2
        L_0x0061:
            return r3
        L_0x0062:
            int r1 = r8.getAction()
            if (r1 != 0) goto L_0x00f0
            int r1 = r8.getKeyCode()
            r5 = 19
            r6 = 33
            if (r1 == r5) goto L_0x00e1
            r5 = 20
            if (r1 == r5) goto L_0x00d1
            r5 = 62
            if (r1 == r5) goto L_0x007c
            goto L_0x00f0
        L_0x007c:
            boolean r8 = r8.isShiftPressed()
            if (r8 == 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r6 = 130(0x82, float:1.82E-43)
        L_0x0085:
            if (r6 != r4) goto L_0x0089
            r8 = 1
            goto L_0x008a
        L_0x0089:
            r8 = 0
        L_0x008a:
            int r1 = r7.getHeight()
            if (r8 == 0) goto L_0x00bd
            int r8 = r7.getScrollY()
            int r8 = r8 + r1
            r0.top = r8
            int r8 = r7.getChildCount()
            if (r8 <= 0) goto L_0x00c8
            int r8 = r8 - r2
            android.view.View r8 = r7.getChildAt(r8)
            android.view.ViewGroup$LayoutParams r2 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r8 = r8.getBottom()
            int r2 = r2.bottomMargin
            int r8 = r8 + r2
            int r2 = r7.getPaddingBottom()
            int r2 = r2 + r8
            int r8 = r0.top
            int r8 = r8 + r1
            if (r8 <= r2) goto L_0x00c8
            int r2 = r2 - r1
            r0.top = r2
            goto L_0x00c8
        L_0x00bd:
            int r8 = r7.getScrollY()
            int r8 = r8 - r1
            r0.top = r8
            if (r8 >= 0) goto L_0x00c8
            r0.top = r3
        L_0x00c8:
            int r8 = r0.top
            int r1 = r1 + r8
            r0.bottom = r1
            r7.s(r6, r8, r1)
            goto L_0x00f0
        L_0x00d1:
            boolean r8 = r8.isAltPressed()
            if (r8 != 0) goto L_0x00dc
            boolean r3 = r7.g(r4)
            goto L_0x00f0
        L_0x00dc:
            boolean r3 = r7.m(r4)
            goto L_0x00f0
        L_0x00e1:
            boolean r8 = r8.isAltPressed()
            if (r8 != 0) goto L_0x00ec
            boolean r3 = r7.g(r6)
            goto L_0x00f0
        L_0x00ec:
            boolean r3 = r7.m(r6)
        L_0x00f0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.k(android.view.KeyEvent):boolean");
    }

    public final void l(int i10) {
        if (getChildCount() > 0) {
            this.f1224k.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, 0, 0);
            w(2, 1);
            this.C = getScrollY();
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
        }
    }

    public final boolean m(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f1223j;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            rect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.top = rect.bottom - height;
        }
        return s(i10, rect.top, rect.bottom);
    }

    public final void measureChild(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public final void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean o(View view, int i10, int i11) {
        Rect rect = this.f1223j;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i10 >= getScrollY() && rect.top - i10 <= getScrollY() + i11;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1229p = false;
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z10;
        int i10;
        float f10;
        boolean z11;
        boolean z12 = false;
        if (motionEvent.getAction() != 8 || this.f1231r) {
            return false;
        }
        if ((motionEvent.getSource() & 2) == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f10 = motionEvent.getAxisValue(9);
            i10 = (int) motionEvent.getX();
        } else {
            if ((motionEvent.getSource() & 4194304) == 4194304) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                f10 = motionEvent.getAxisValue(26);
                i10 = getWidth() / 2;
            } else {
                f10 = 0.0f;
                i10 = 0;
            }
        }
        if (f10 == 0.0f) {
            return false;
        }
        int verticalScrollFactorCompat = (int) (f10 * getVerticalScrollFactorCompat());
        if ((motionEvent.getSource() & 8194) == 8194) {
            z12 = true;
        }
        t(-verticalScrollFactorCompat, i10, 1, z12);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getAction()
            r1 = 1
            r2 = 2
            if (r0 != r2) goto L_0x000d
            boolean r3 = r12.f1231r
            if (r3 == 0) goto L_0x000d
            return r1
        L_0x000d:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L_0x00b1
            r5 = -1
            if (r0 == r1) goto L_0x0083
            if (r0 == r2) goto L_0x0025
            r1 = 3
            if (r0 == r1) goto L_0x0083
            r1 = 6
            if (r0 == r1) goto L_0x0020
            goto L_0x0139
        L_0x0020:
            r12.q(r13)
            goto L_0x0139
        L_0x0025:
            int r0 = r12.f1238y
            if (r0 != r5) goto L_0x002b
            goto L_0x0139
        L_0x002b:
            int r3 = r13.findPointerIndex(r0)
            if (r3 != r5) goto L_0x004b
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid pointerId="
            r13.<init>(r1)
            r13.append(r0)
            java.lang.String r0 = " in onInterceptTouchEvent"
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.e(r0, r13)
            goto L_0x0139
        L_0x004b:
            float r0 = r13.getY(r3)
            int r0 = (int) r0
            int r3 = r12.f1227n
            int r3 = r0 - r3
            int r3 = java.lang.Math.abs(r3)
            int r5 = r12.f1235v
            if (r3 <= r5) goto L_0x0139
            int r3 = r12.getNestedScrollAxes()
            r2 = r2 & r3
            if (r2 != 0) goto L_0x0139
            r12.f1231r = r1
            r12.f1227n = r0
            android.view.VelocityTracker r0 = r12.f1232s
            if (r0 != 0) goto L_0x0071
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r12.f1232s = r0
        L_0x0071:
            android.view.VelocityTracker r0 = r12.f1232s
            r0.addMovement(r13)
            r12.B = r4
            android.view.ViewParent r13 = r12.getParent()
            if (r13 == 0) goto L_0x0139
            r13.requestDisallowInterceptTouchEvent(r1)
            goto L_0x0139
        L_0x0083:
            r12.f1231r = r4
            r12.f1238y = r5
            android.view.VelocityTracker r13 = r12.f1232s
            if (r13 == 0) goto L_0x0090
            r13.recycle()
            r12.f1232s = r3
        L_0x0090:
            android.widget.OverScroller r5 = r12.f1224k
            int r6 = r12.getScrollX()
            int r7 = r12.getScrollY()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            boolean r13 = r5.springBack(r6, r7, r8, r9, r10, r11)
            if (r13 == 0) goto L_0x00ac
            java.util.WeakHashMap r13 = m0.c1.f10054a
            m0.i0.k(r12)
        L_0x00ac:
            r12.y(r4)
            goto L_0x0139
        L_0x00b1:
            float r0 = r13.getY()
            int r0 = (int) r0
            float r5 = r13.getX()
            int r5 = (int) r5
            int r6 = r12.getChildCount()
            if (r6 <= 0) goto L_0x00e5
            int r6 = r12.getScrollY()
            android.view.View r7 = r12.getChildAt(r4)
            int r8 = r7.getTop()
            int r8 = r8 - r6
            if (r0 < r8) goto L_0x00e5
            int r8 = r7.getBottom()
            int r8 = r8 - r6
            if (r0 >= r8) goto L_0x00e5
            int r6 = r7.getLeft()
            if (r5 < r6) goto L_0x00e5
            int r6 = r7.getRight()
            if (r5 >= r6) goto L_0x00e5
            r5 = 1
            goto L_0x00e6
        L_0x00e5:
            r5 = 0
        L_0x00e6:
            if (r5 != 0) goto L_0x0104
            boolean r13 = r12.x(r13)
            if (r13 != 0) goto L_0x00f8
            android.widget.OverScroller r13 = r12.f1224k
            boolean r13 = r13.isFinished()
            if (r13 != 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r1 = 0
        L_0x00f8:
            r12.f1231r = r1
            android.view.VelocityTracker r13 = r12.f1232s
            if (r13 == 0) goto L_0x0139
            r13.recycle()
            r12.f1232s = r3
            goto L_0x0139
        L_0x0104:
            r12.f1227n = r0
            int r0 = r13.getPointerId(r4)
            r12.f1238y = r0
            android.view.VelocityTracker r0 = r12.f1232s
            if (r0 != 0) goto L_0x0117
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r12.f1232s = r0
            goto L_0x011a
        L_0x0117:
            r0.clear()
        L_0x011a:
            android.view.VelocityTracker r0 = r12.f1232s
            r0.addMovement(r13)
            android.widget.OverScroller r0 = r12.f1224k
            r0.computeScrollOffset()
            boolean r13 = r12.x(r13)
            if (r13 != 0) goto L_0x0134
            android.widget.OverScroller r13 = r12.f1224k
            boolean r13 = r13.isFinished()
            if (r13 != 0) goto L_0x0133
            goto L_0x0134
        L_0x0133:
            r1 = 0
        L_0x0134:
            r12.f1231r = r1
            r12.w(r2, r4)
        L_0x0139:
            boolean r13 = r12.f1231r
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        super.onLayout(z10, i10, i11, i12, i13);
        int i15 = 0;
        this.f1228o = false;
        View view = this.f1230q;
        if (view != null && n(view, this)) {
            View view2 = this.f1230q;
            Rect rect = this.f1223j;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h10 = h(rect);
            if (h10 != 0) {
                scrollBy(0, h10);
            }
        }
        this.f1230q = null;
        if (!this.f1229p) {
            if (this.D != null) {
                scrollTo(getScrollX(), this.D.f13119h);
                this.D = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i14 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i14 = 0;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i14 && scrollY >= 0) {
                i15 = paddingTop + scrollY > i14 ? i14 - paddingTop : scrollY;
            }
            if (i15 != scrollY) {
                scrollTo(getScrollX(), i15);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1229p = true;
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1233t && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        l((int) f11);
        return true;
    }

    public final boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        c(view, i10, i11, iArr, 0);
    }

    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        p(i13, 0, (int[]) null);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        a(view, view2, i10, 0);
    }

    public final void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        View view;
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        FocusFinder instance = FocusFinder.getInstance();
        if (rect == null) {
            view = instance.findNextFocus(this, (View) null, i10);
        } else {
            view = instance.findNextFocusFromRect(this, rect, i10);
        }
        if (view != null && !(true ^ o(view, 0, getHeight()))) {
            return view.requestFocus(i10, rect);
        }
        return false;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.getSuperState());
        this.D = oVar;
        requestLayout();
    }

    public final Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f13119h = getScrollY();
        return oVar;
    }

    public final void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        m mVar = this.H;
        if (mVar != null) {
            android.support.v4.media.session.u uVar = (android.support.v4.media.session.u) mVar;
            g.k.b(this, (View) uVar.f428i, (View) uVar.f429j);
        }
    }

    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && o(findFocus, 0, i13)) {
            Rect rect = this.f1223j;
            findFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findFocus, rect);
            int h10 = h(rect);
            if (h10 == 0) {
                return;
            }
            if (this.f1234u) {
                v(0, h10, false);
            } else {
                scrollBy(0, h10);
            }
        }
    }

    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return f(view, view2, i10, 0);
    }

    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ee, code lost:
        if (hb.h0.e0(r6) == 0.0f) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0173, code lost:
        if (u(r6, r0) != false) goto L_0x0175;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            android.view.VelocityTracker r0 = r13.f1232s
            if (r0 != 0) goto L_0x000a
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r13.f1232s = r0
        L_0x000a:
            int r0 = r14.getActionMasked()
            r1 = 0
            if (r0 != 0) goto L_0x0013
            r13.B = r1
        L_0x0013:
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r14)
            int r3 = r13.B
            float r3 = (float) r3
            r4 = 0
            r2.offsetLocation(r4, r3)
            r3 = 1
            r5 = 2
            if (r0 == 0) goto L_0x01ae
            android.widget.EdgeEffect r6 = r13.f1226m
            android.widget.EdgeEffect r7 = r13.f1225l
            if (r0 == r3) goto L_0x013a
            if (r0 == r5) goto L_0x007f
            r1 = 3
            if (r0 == r1) goto L_0x005a
            r1 = 5
            if (r0 == r1) goto L_0x0047
            r1 = 6
            if (r0 == r1) goto L_0x0035
            goto L_0x01e2
        L_0x0035:
            r13.q(r14)
            int r0 = r13.f1238y
            int r0 = r14.findPointerIndex(r0)
            float r14 = r14.getY(r0)
            int r14 = (int) r14
            r13.f1227n = r14
            goto L_0x01e2
        L_0x0047:
            int r0 = r14.getActionIndex()
            float r1 = r14.getY(r0)
            int r1 = (int) r1
            r13.f1227n = r1
            int r14 = r14.getPointerId(r0)
            r13.f1238y = r14
            goto L_0x01e2
        L_0x005a:
            boolean r14 = r13.f1231r
            if (r14 == 0) goto L_0x01aa
            int r14 = r13.getChildCount()
            if (r14 <= 0) goto L_0x01aa
            android.widget.OverScroller r4 = r13.f1224k
            int r5 = r13.getScrollX()
            int r6 = r13.getScrollY()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r13.getScrollRange()
            boolean r14 = r4.springBack(r5, r6, r7, r8, r9, r10)
            if (r14 == 0) goto L_0x01aa
            java.util.WeakHashMap r14 = m0.c1.f10054a
            goto L_0x01a7
        L_0x007f:
            int r0 = r13.f1238y
            int r0 = r14.findPointerIndex(r0)
            r5 = -1
            if (r0 != r5) goto L_0x00a4
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid pointerId="
            r14.<init>(r0)
            int r0 = r13.f1238y
            r14.append(r0)
            java.lang.String r0 = " in onTouchEvent"
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "NestedScrollView"
            android.util.Log.e(r0, r14)
            goto L_0x01e2
        L_0x00a4:
            float r5 = r14.getY(r0)
            int r5 = (int) r5
            int r8 = r13.f1227n
            int r8 = r8 - r5
            float r9 = r14.getX(r0)
            int r10 = r13.getWidth()
            float r10 = (float) r10
            float r9 = r9 / r10
            float r10 = (float) r8
            int r11 = r13.getHeight()
            float r11 = (float) r11
            float r10 = r10 / r11
            float r11 = hb.h0.e0(r7)
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00d9
            float r6 = -r10
            float r6 = hb.h0.i1(r7, r6, r9)
            float r6 = -r6
            float r9 = hb.h0.e0(r7)
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x00d7
            r12 = r7
            r7 = r6
            r6 = r12
            goto L_0x00f0
        L_0x00d7:
            r4 = r6
            goto L_0x00f4
        L_0x00d9:
            float r7 = hb.h0.e0(r6)
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00f4
            r7 = 1065353216(0x3f800000, float:1.0)
            float r7 = r7 - r9
            float r7 = hb.h0.i1(r6, r10, r7)
            float r9 = hb.h0.e0(r6)
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x00f3
        L_0x00f0:
            r6.onRelease()
        L_0x00f3:
            r4 = r7
        L_0x00f4:
            int r6 = r13.getHeight()
            float r6 = (float) r6
            float r4 = r4 * r6
            int r4 = java.lang.Math.round(r4)
            if (r4 == 0) goto L_0x0104
            r13.invalidate()
        L_0x0104:
            int r8 = r8 - r4
            boolean r4 = r13.f1231r
            if (r4 != 0) goto L_0x0123
            int r4 = java.lang.Math.abs(r8)
            int r6 = r13.f1235v
            if (r4 <= r6) goto L_0x0123
            android.view.ViewParent r4 = r13.getParent()
            if (r4 == 0) goto L_0x011a
            r4.requestDisallowInterceptTouchEvent(r3)
        L_0x011a:
            r13.f1231r = r3
            int r4 = r13.f1235v
            if (r8 <= 0) goto L_0x0122
            int r8 = r8 - r4
            goto L_0x0123
        L_0x0122:
            int r8 = r8 + r4
        L_0x0123:
            boolean r4 = r13.f1231r
            if (r4 == 0) goto L_0x01e2
            float r14 = r14.getX(r0)
            int r14 = (int) r14
            int r14 = r13.t(r8, r14, r1, r1)
            int r5 = r5 - r14
            r13.f1227n = r5
            int r0 = r13.B
            int r0 = r0 + r14
            r13.B = r0
            goto L_0x01e2
        L_0x013a:
            android.view.VelocityTracker r14 = r13.f1232s
            int r0 = r13.f1237x
            float r0 = (float) r0
            r5 = 1000(0x3e8, float:1.401E-42)
            r14.computeCurrentVelocity(r5, r0)
            int r0 = r13.f1238y
            float r14 = r14.getYVelocity(r0)
            int r14 = (int) r14
            int r0 = java.lang.Math.abs(r14)
            int r5 = r13.f1236w
            if (r0 < r5) goto L_0x018e
            float r0 = hb.h0.e0(r7)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0166
            boolean r0 = r13.u(r7, r14)
            if (r0 == 0) goto L_0x0164
            r0 = r14
            r6 = r7
            goto L_0x0175
        L_0x0164:
            int r0 = -r14
            goto L_0x0179
        L_0x0166:
            float r0 = hb.h0.e0(r6)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x017d
            int r0 = -r14
            boolean r1 = r13.u(r6, r0)
            if (r1 == 0) goto L_0x0179
        L_0x0175:
            r6.onAbsorb(r0)
            goto L_0x017c
        L_0x0179:
            r13.l(r0)
        L_0x017c:
            r1 = 1
        L_0x017d:
            if (r1 != 0) goto L_0x01aa
            int r14 = -r14
            float r0 = (float) r14
            boolean r1 = r13.dispatchNestedPreFling(r4, r0)
            if (r1 != 0) goto L_0x01aa
            r13.dispatchNestedFling(r4, r0, r3)
            r13.l(r14)
            goto L_0x01aa
        L_0x018e:
            android.widget.OverScroller r5 = r13.f1224k
            int r6 = r13.getScrollX()
            int r7 = r13.getScrollY()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r13.getScrollRange()
            boolean r14 = r5.springBack(r6, r7, r8, r9, r10, r11)
            if (r14 == 0) goto L_0x01aa
            java.util.WeakHashMap r14 = m0.c1.f10054a
        L_0x01a7:
            m0.i0.k(r13)
        L_0x01aa:
            r13.j()
            goto L_0x01e2
        L_0x01ae:
            int r0 = r13.getChildCount()
            if (r0 != 0) goto L_0x01b5
            return r1
        L_0x01b5:
            boolean r0 = r13.f1231r
            if (r0 == 0) goto L_0x01c2
            android.view.ViewParent r0 = r13.getParent()
            if (r0 == 0) goto L_0x01c2
            r0.requestDisallowInterceptTouchEvent(r3)
        L_0x01c2:
            android.widget.OverScroller r0 = r13.f1224k
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x01d2
            android.widget.OverScroller r0 = r13.f1224k
            r0.abortAnimation()
            r13.y(r3)
        L_0x01d2:
            float r0 = r14.getY()
            int r0 = (int) r0
            int r14 = r14.getPointerId(r1)
            r13.f1227n = r0
            r13.f1238y = r14
            r13.w(r5, r1)
        L_0x01e2:
            android.view.VelocityTracker r14 = r13.f1232s
            if (r14 == 0) goto L_0x01e9
            r14.addMovement(r2)
        L_0x01e9:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i10, int i11, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.F.e(0, scrollY2, 0, i10 - scrollY2, (int[]) null, i11, iArr);
    }

    public final void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1238y) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f1227n = (int) motionEvent.getY(i10);
            this.f1238y = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f1232s;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean r(int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        int overScrollMode = getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i14 = i11 + 0;
        int i15 = i12 + i10;
        int i16 = i13 + 0;
        if (i14 <= 0 && i14 >= 0) {
            z10 = false;
        } else {
            z10 = true;
            i14 = 0;
        }
        if (i15 > i16) {
            i15 = i16;
        } else if (i15 < 0) {
            i15 = 0;
        } else {
            z11 = false;
            if (z11 && !this.F.g(1)) {
                this.f1224k.springBack(i14, i15, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i14, i15, z10, z11);
            if (z10 && !z11) {
                return false;
            }
        }
        z11 = true;
        this.f1224k.springBack(i14, i15, 0, 0, 0, getScrollRange());
        onOverScrolled(i14, i15, z10, z11);
        return z10 ? true : true;
    }

    public final void requestChildFocus(View view, View view2) {
        if (!this.f1228o) {
            Rect rect = this.f1223j;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int h10 = h(rect);
            if (h10 != 0) {
                scrollBy(0, h10);
            }
        } else {
            this.f1230q = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        boolean z11;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int h10 = h(rect);
        if (h10 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (z10) {
                scrollBy(0, h10);
            } else {
                v(0, h10, false);
            }
        }
        return z11;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        VelocityTracker velocityTracker;
        if (z10 && (velocityTracker = this.f1232s) != null) {
            velocityTracker.recycle();
            this.f1232s = null;
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public final void requestLayout() {
        this.f1228o = true;
        super.requestLayout();
    }

    public final boolean s(int i10, int i11, int i12) {
        boolean z10;
        boolean z11;
        int i13;
        boolean z12;
        boolean z13;
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int height = getHeight();
        int scrollY = getScrollY();
        int i17 = height + scrollY;
        if (i14 == 33) {
            z10 = true;
        } else {
            z10 = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z14 = false;
        for (int i18 = 0; i18 < size; i18++) {
            View view2 = focusables.get(i18);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i15 < bottom && top < i16) {
                if (i15 >= top || bottom >= i16) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (view == null) {
                    view = view2;
                    z14 = z12;
                } else {
                    if ((!z10 || top >= view.getTop()) && (z10 || bottom <= view.getBottom())) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    if (z14) {
                        if (z12) {
                            if (!z13) {
                            }
                        }
                    } else if (z12) {
                        view = view2;
                        z14 = true;
                    } else if (!z13) {
                    }
                    view = view2;
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i15 < scrollY || i16 > i17) {
            if (z10) {
                i13 = i15 - scrollY;
            } else {
                i13 = i16 - i17;
            }
            t(i13, 0, 1, true);
            z11 = true;
        } else {
            z11 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i14);
        }
        return z11;
    }

    public final void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i10 < 0) {
                i10 = 0;
            } else if (width + i10 > width2) {
                i10 = width2 - width;
            }
            if (height >= height2 || i11 < 0) {
                i11 = 0;
            } else if (height + i11 > height2) {
                i11 = height2 - height;
            }
            if (i10 != getScrollX() || i11 != getScrollY()) {
                super.scrollTo(i10, i11);
            }
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f1233t) {
            this.f1233t = z10;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z10) {
        u uVar = this.F;
        if (uVar.f10142d) {
            WeakHashMap weakHashMap = c1.f10054a;
            o0.z(uVar.f10141c);
        }
        uVar.f10142d = z10;
    }

    public void setOnScrollChangeListener(m mVar) {
        this.H = mVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f1234u = z10;
    }

    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final boolean startNestedScroll(int i10) {
        return w(i10, 0);
    }

    public final void stopNestedScroll() {
        y(0);
    }

    public final int t(int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i15 = i11;
        int i16 = i12;
        if (i16 == 1) {
            w(2, i16);
        }
        boolean i17 = i(0, i10, this.A, this.f1239z, i12);
        int[] iArr = this.A;
        int[] iArr2 = this.f1239z;
        if (i17) {
            i14 = i10 - iArr[1];
            i13 = iArr2[1] + 0;
        } else {
            i14 = i10;
            i13 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || z10) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!r(i14, 0, scrollY, scrollRange) || this.F.g(i16)) {
            z13 = false;
        } else {
            z13 = true;
        }
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        int[] iArr3 = this.f1239z;
        int i18 = scrollRange;
        this.F.e(0, scrollY2, 0, i14 - scrollY2, iArr3, i12, iArr);
        int i19 = i13 + iArr2[1];
        int i20 = i14 - iArr[1];
        int i21 = scrollY + i20;
        EdgeEffect edgeEffect = this.f1226m;
        EdgeEffect edgeEffect2 = this.f1225l;
        if (i21 < 0) {
            if (z12) {
                h0.i1(edgeEffect2, ((float) (-i20)) / ((float) getHeight()), ((float) i15) / ((float) getWidth()));
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i21 > i18 && z12) {
            h0.i1(edgeEffect, ((float) i20) / ((float) getHeight()), 1.0f - (((float) i15) / ((float) getWidth())));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (!edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.k(this);
            z14 = false;
        } else {
            z14 = z13;
        }
        int i22 = i12;
        if (z14 && i22 == 0) {
            this.f1232s.clear();
        }
        if (i22 == 1) {
            y(i22);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i19;
    }

    public final boolean u(EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        float e02 = h0.e0(edgeEffect) * ((float) getHeight());
        float f10 = this.f1221h * 0.015f;
        double log = Math.log((double) ((((float) Math.abs(-i10)) * 0.35f) / f10));
        double d10 = (double) I;
        if (((float) (Math.exp((d10 / (d10 - 1.0d)) * log) * ((double) f10))) < e02) {
            return true;
        }
        return false;
    }

    public final void v(int i10, int i11, boolean z10) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1222i > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f1224k;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
                if (z10) {
                    w(2, 1);
                } else {
                    y(1);
                }
                this.C = getScrollY();
                WeakHashMap weakHashMap = c1.f10054a;
                i0.k(this);
            } else {
                if (!this.f1224k.isFinished()) {
                    this.f1224k.abortAnimation();
                    y(1);
                }
                scrollBy(i10, i11);
            }
            this.f1222i = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final boolean w(int i10, int i11) {
        return this.F.h(i10, i11);
    }

    public final boolean x(MotionEvent motionEvent) {
        boolean z10;
        EdgeEffect edgeEffect = this.f1225l;
        if (h0.e0(edgeEffect) != 0.0f) {
            h0.i1(edgeEffect, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z10 = true;
        } else {
            z10 = false;
        }
        EdgeEffect edgeEffect2 = this.f1226m;
        if (h0.e0(edgeEffect2) == 0.0f) {
            return z10;
        }
        h0.i1(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    public final void y(int i10) {
        this.F.i(i10);
    }

    public final void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
