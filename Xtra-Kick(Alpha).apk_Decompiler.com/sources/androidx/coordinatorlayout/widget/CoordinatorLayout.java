package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import c0.g;
import com.woxthebox.draglistview.R;
import e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import l0.e;
import m0.c1;
import m0.i0;
import m0.j0;
import m0.m;
import m0.m0;
import m0.o0;
import m0.q2;
import m0.v;
import m0.w;
import m0.x;
import m0.y;
import q.k;
import z.b;
import z.c;
import z.d;
import z.f;
import z.h;
import z.i;
import z.j;

public class CoordinatorLayout extends ViewGroup implements v, w {
    public static final String A;
    public static final Class[] B = {Context.class, AttributeSet.class};
    public static final ThreadLocal C = new ThreadLocal();
    public static final i D = new i();
    public static final e E = new e(12);

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList f1185h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final j f1186i = new j();

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f1187j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f1188k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final int[] f1189l = new int[2];

    /* renamed from: m  reason: collision with root package name */
    public final int[] f1190m = new int[2];

    /* renamed from: n  reason: collision with root package name */
    public boolean f1191n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1192o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f1193p;

    /* renamed from: q  reason: collision with root package name */
    public View f1194q;

    /* renamed from: r  reason: collision with root package name */
    public View f1195r;

    /* renamed from: s  reason: collision with root package name */
    public f f1196s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f1197t;

    /* renamed from: u  reason: collision with root package name */
    public q2 f1198u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f1199v;

    /* renamed from: w  reason: collision with root package name */
    public Drawable f1200w;

    /* renamed from: x  reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1201x;

    /* renamed from: y  reason: collision with root package name */
    public a f1202y;

    /* renamed from: z  reason: collision with root package name */
    public final x f1203z = new x();

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        A = packageR != null ? packageR.getName() : null;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        int[] iArr = y.a.f16854a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f1193p = intArray;
            float f10 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i10 = 0; i10 < length; i10++) {
                int[] iArr2 = this.f1193p;
                iArr2[i10] = (int) (((float) iArr2[i10]) * f10);
            }
        }
        this.f1200w = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        y();
        super.setOnHierarchyChangeListener(new d(this));
        WeakHashMap weakHashMap = c1.f10054a;
        if (i0.c(this) == 0) {
            i0.s(this, 1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) E.j();
        return rect == null ? new Rect() : rect;
    }

    public static void m(int i10, Rect rect, Rect rect2, z.e eVar, int i11, int i12) {
        int i13;
        int i14;
        int i15 = eVar.f17324c;
        if (i15 == 0) {
            i15 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i15, i10);
        int i16 = eVar.f17325d;
        if ((i16 & 7) == 0) {
            i16 |= 8388611;
        }
        if ((i16 & 112) == 0) {
            i16 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i16, i10);
        int i17 = absoluteGravity & 7;
        int i18 = absoluteGravity & 112;
        int i19 = absoluteGravity2 & 7;
        int i20 = absoluteGravity2 & 112;
        if (i19 == 1) {
            i13 = rect.left + (rect.width() / 2);
        } else if (i19 != 5) {
            i13 = rect.left;
        } else {
            i13 = rect.right;
        }
        if (i20 == 16) {
            i14 = rect.top + (rect.height() / 2);
        } else if (i20 != 80) {
            i14 = rect.top;
        } else {
            i14 = rect.bottom;
        }
        if (i17 == 1) {
            i13 -= i11 / 2;
        } else if (i17 != 5) {
            i13 -= i11;
        }
        if (i18 == 16) {
            i14 -= i12 / 2;
        } else if (i18 != 80) {
            i14 -= i12;
        }
        rect2.set(i13, i14, i11 + i13, i12 + i14);
    }

    public static z.e o(View view) {
        z.e eVar = (z.e) view.getLayoutParams();
        if (!eVar.f17323b) {
            if (view instanceof z.a) {
                b behavior = ((z.a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                b bVar = eVar.f17322a;
                if (bVar != behavior) {
                    if (bVar != null) {
                        bVar.f();
                    }
                    eVar.f17322a = behavior;
                    eVar.f17323b = true;
                    if (behavior != null) {
                        behavior.c(eVar);
                    }
                }
            } else {
                c cVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    cVar = (c) cls.getAnnotation(c.class);
                    if (cVar != null) {
                        break;
                    }
                }
                if (cVar != null) {
                    try {
                        b bVar2 = (b) cVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        b bVar3 = eVar.f17322a;
                        if (bVar3 != bVar2) {
                            if (bVar3 != null) {
                                bVar3.f();
                            }
                            eVar.f17322a = bVar2;
                            eVar.f17323b = true;
                            if (bVar2 != null) {
                                bVar2.c(eVar);
                            }
                        }
                    } catch (Exception e10) {
                        Log.e("CoordinatorLayout", "Default behavior class " + cVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                    }
                }
            }
            eVar.f17323b = true;
        }
        return eVar;
    }

    public static void w(View view, int i10) {
        z.e eVar = (z.e) view.getLayoutParams();
        int i11 = eVar.f17330i;
        if (i11 != i10) {
            c1.j(view, i10 - i11);
            eVar.f17330i = i10;
        }
    }

    public static void x(View view, int i10) {
        z.e eVar = (z.e) view.getLayoutParams();
        int i11 = eVar.f17331j;
        if (i11 != i10) {
            c1.k(view, i10 - i11);
            eVar.f17331j = i10;
        }
    }

    public final void a(View view, View view2, int i10, int i11) {
        x xVar = this.f1203z;
        if (i11 == 1) {
            xVar.f10158b = i10;
        } else {
            xVar.f10157a = i10;
        }
        this.f1195r = view2;
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            ((z.e) getChildAt(i12).getLayoutParams()).getClass();
        }
    }

    public final void b(View view, int i10) {
        x xVar = this.f1203z;
        if (i10 == 1) {
            xVar.f10158b = 0;
        } else {
            xVar.f10157a = 0;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            z.e eVar = (z.e) childAt.getLayoutParams();
            if (eVar.a(i10)) {
                b bVar = eVar.f17322a;
                if (bVar != null) {
                    bVar.q(this, childAt, view, i10);
                }
                if (i10 == 0) {
                    eVar.f17335n = false;
                } else if (i10 == 1) {
                    eVar.f17336o = false;
                }
                eVar.f17337p = false;
            }
        }
        this.f1195r = null;
    }

    public final void c(View view, int i10, int i11, int[] iArr, int i12) {
        b bVar;
        int i13;
        int i14;
        int childCount = getChildCount();
        boolean z10 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() == 8) {
                int i18 = i12;
            } else {
                z.e eVar = (z.e) childAt.getLayoutParams();
                if (eVar.a(i12) && (bVar = eVar.f17322a) != null) {
                    int[] iArr2 = this.f1189l;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.k(this, childAt, view, i10, i11, iArr2, i12);
                    int[] iArr3 = this.f1189l;
                    if (i10 > 0) {
                        i13 = Math.max(i15, iArr3[0]);
                    } else {
                        i13 = Math.min(i15, iArr3[0]);
                    }
                    i15 = i13;
                    if (i11 > 0) {
                        i14 = Math.max(i16, iArr3[1]);
                    } else {
                        i14 = Math.min(i16, iArr3[1]);
                    }
                    i16 = i14;
                    z10 = true;
                }
            }
        }
        iArr[0] = i15;
        iArr[1] = i16;
        if (z10) {
            q(1);
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof z.e) && super.checkLayoutParams(layoutParams);
    }

    public final void d(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        b bVar;
        int i15;
        int i16;
        int childCount = getChildCount();
        boolean z10 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                int i20 = i14;
            } else {
                z.e eVar = (z.e) childAt.getLayoutParams();
                if (eVar.a(i14) && (bVar = eVar.f17322a) != null) {
                    int[] iArr2 = this.f1189l;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.l(this, childAt, i11, i12, i13, iArr2);
                    if (i12 > 0) {
                        i15 = Math.max(i17, iArr2[0]);
                    } else {
                        i15 = Math.min(i17, iArr2[0]);
                    }
                    i17 = i15;
                    if (i13 > 0) {
                        i16 = Math.max(i18, iArr2[1]);
                    } else {
                        i16 = Math.min(i18, iArr2[1]);
                    }
                    i18 = i16;
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i17;
        iArr[1] = iArr[1] + i18;
        if (z10) {
            q(1);
        }
    }

    public final boolean drawChild(Canvas canvas, View view, long j10) {
        b bVar = ((z.e) view.getLayoutParams()).f17322a;
        if (bVar != null) {
            bVar.getClass();
        }
        return super.drawChild(canvas, view, j10);
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1200w;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    public final void e(View view, int i10, int i11, int i12, int i13, int i14) {
        d(view, i10, i11, i12, i13, 0, this.f1190m);
    }

    public final boolean f(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                z.e eVar = (z.e) childAt.getLayoutParams();
                b bVar = eVar.f17322a;
                if (bVar != null) {
                    boolean p10 = bVar.p(this, childAt, view, i10, i11);
                    z10 |= p10;
                    if (i11 == 0) {
                        eVar.f17335n = p10;
                    } else if (i11 == 1) {
                        eVar.f17336o = p10;
                    }
                } else if (i11 == 0) {
                    eVar.f17335n = false;
                } else if (i11 == 1) {
                    eVar.f17336o = false;
                }
            }
        }
        return z10;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new z.e();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new z.e(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        u();
        return Collections.unmodifiableList(this.f1185h);
    }

    public final q2 getLastWindowInsets() {
        return this.f1198u;
    }

    public int getNestedScrollAxes() {
        x xVar = this.f1203z;
        return xVar.f10158b | xVar.f10157a;
    }

    public Drawable getStatusBarBackground() {
        return this.f1200w;
    }

    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(z.e eVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + eVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - eVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + eVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - eVar.bottomMargin));
        rect.set(max, max2, i10 + max, i11 + max2);
    }

    public final void i(View view) {
        List list = (List) this.f1186i.f17343b.getOrDefault(view, (Object) null);
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                View view2 = (View) list.get(i10);
                b bVar = ((z.e) view2.getLayoutParams()).f17322a;
                if (bVar != null) {
                    bVar.d(this, view2, view);
                }
            }
        }
    }

    public final void j(View view, Rect rect, boolean z10) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            l(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList k(View view) {
        k kVar = this.f1186i.f17343b;
        int i10 = kVar.f13081j;
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < i10; i11++) {
            ArrayList arrayList2 = (ArrayList) kVar.l(i11);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.h(i11));
            }
        }
        ArrayList arrayList3 = this.f1188k;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void l(View view, Rect rect) {
        ThreadLocal threadLocal = z.k.f17346a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = z.k.f17346a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        z.k.a(this, view, matrix);
        ThreadLocal threadLocal3 = z.k.f17347b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int n(int i10) {
        StringBuilder sb2;
        int[] iArr = this.f1193p;
        if (iArr == null) {
            sb2 = new StringBuilder("No keylines defined for ");
            sb2.append(this);
            sb2.append(" - attempted index lookup ");
            sb2.append(i10);
        } else if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        } else {
            sb2 = new StringBuilder("Keyline index ");
            sb2.append(i10);
            sb2.append(" out of range for ");
            sb2.append(this);
        }
        Log.e("CoordinatorLayout", sb2.toString());
        return 0;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        v(false);
        if (this.f1197t) {
            if (this.f1196s == null) {
                this.f1196s = new f(0, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1196s);
        }
        if (this.f1198u == null) {
            WeakHashMap weakHashMap = c1.f10054a;
            if (i0.b(this)) {
                m0.c(this);
            }
        }
        this.f1192o = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v(false);
        if (this.f1197t && this.f1196s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1196s);
        }
        View view = this.f1195r;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f1192o = false;
    }

    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1199v && this.f1200w != null) {
            q2 q2Var = this.f1198u;
            int e10 = q2Var != null ? q2Var.e() : 0;
            if (e10 > 0) {
                this.f1200w.setBounds(0, 0, getWidth(), e10);
                this.f1200w.draw(canvas);
            }
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            v(true);
        }
        boolean t10 = t(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            v(true);
        }
        return t10;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        b bVar;
        WeakHashMap weakHashMap = c1.f10054a;
        int d10 = j0.d(this);
        ArrayList arrayList = this.f1185h;
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) arrayList.get(i14);
            if (view.getVisibility() != 8 && ((bVar = ((z.e) view.getLayoutParams()).f17322a) == null || !bVar.h(this, view, d10))) {
                r(view, d10);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0191, code lost:
        if (r0.i(r32, r19, r25, r20, r26) == false) goto L_0x01ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0194  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r33, int r34) {
        /*
            r32 = this;
            r6 = r32
            r32.u()
            int r0 = r32.getChildCount()
            r7 = 0
            r1 = 0
        L_0x000b:
            r2 = 1
            if (r1 >= r0) goto L_0x0036
            android.view.View r3 = r6.getChildAt(r1)
            z.j r4 = r6.f1186i
            q.k r4 = r4.f17343b
            int r5 = r4.f13081j
            r8 = 0
        L_0x0019:
            if (r8 >= r5) goto L_0x002e
            java.lang.Object r9 = r4.l(r8)
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            if (r9 == 0) goto L_0x002b
            boolean r9 = r9.contains(r3)
            if (r9 == 0) goto L_0x002b
            r3 = 1
            goto L_0x002f
        L_0x002b:
            int r8 = r8 + 1
            goto L_0x0019
        L_0x002e:
            r3 = 0
        L_0x002f:
            if (r3 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0037
        L_0x0033:
            int r1 = r1 + 1
            goto L_0x000b
        L_0x0036:
            r0 = 0
        L_0x0037:
            boolean r1 = r6.f1197t
            if (r0 == r1) goto L_0x006b
            if (r0 == 0) goto L_0x0058
            boolean r0 = r6.f1192o
            if (r0 == 0) goto L_0x0055
            z.f r0 = r6.f1196s
            if (r0 != 0) goto L_0x004c
            z.f r0 = new z.f
            r0.<init>(r7, r6)
            r6.f1196s = r0
        L_0x004c:
            android.view.ViewTreeObserver r0 = r32.getViewTreeObserver()
            z.f r1 = r6.f1196s
            r0.addOnPreDrawListener(r1)
        L_0x0055:
            r6.f1197t = r2
            goto L_0x006b
        L_0x0058:
            boolean r0 = r6.f1192o
            if (r0 == 0) goto L_0x0069
            z.f r0 = r6.f1196s
            if (r0 == 0) goto L_0x0069
            android.view.ViewTreeObserver r0 = r32.getViewTreeObserver()
            z.f r1 = r6.f1196s
            r0.removeOnPreDrawListener(r1)
        L_0x0069:
            r6.f1197t = r7
        L_0x006b:
            int r8 = r32.getPaddingLeft()
            int r0 = r32.getPaddingTop()
            int r9 = r32.getPaddingRight()
            int r1 = r32.getPaddingBottom()
            java.util.WeakHashMap r3 = m0.c1.f10054a
            int r10 = m0.j0.d(r32)
            if (r10 != r2) goto L_0x0085
            r11 = 1
            goto L_0x0086
        L_0x0085:
            r11 = 0
        L_0x0086:
            int r12 = android.view.View.MeasureSpec.getMode(r33)
            int r13 = android.view.View.MeasureSpec.getSize(r33)
            int r14 = android.view.View.MeasureSpec.getMode(r34)
            int r15 = android.view.View.MeasureSpec.getSize(r34)
            int r16 = r8 + r9
            int r17 = r0 + r1
            int r0 = r32.getSuggestedMinimumWidth()
            int r1 = r32.getSuggestedMinimumHeight()
            m0.q2 r3 = r6.f1198u
            if (r3 == 0) goto L_0x00af
            boolean r3 = m0.i0.b(r32)
            if (r3 == 0) goto L_0x00af
            r18 = 1
            goto L_0x00b1
        L_0x00af:
            r18 = 0
        L_0x00b1:
            java.util.ArrayList r5 = r6.f1185h
            int r4 = r5.size()
            r3 = r0
            r2 = r1
            r0 = 0
            r1 = 0
        L_0x00bb:
            if (r1 >= r4) goto L_0x01f3
            java.lang.Object r19 = r5.get(r1)
            android.view.View r19 = (android.view.View) r19
            int r7 = r19.getVisibility()
            r21 = r0
            r0 = 8
            if (r7 != r0) goto L_0x00df
            r28 = r4
            r29 = r5
            r22 = r8
            r23 = r9
            r27 = r10
            r0 = r21
            r24 = 0
            r21 = r1
            goto L_0x01e4
        L_0x00df:
            android.view.ViewGroup$LayoutParams r0 = r19.getLayoutParams()
            r7 = r0
            z.e r7 = (z.e) r7
            int r0 = r7.f17326e
            if (r0 < 0) goto L_0x012b
            if (r12 == 0) goto L_0x012b
            int r0 = r6.n(r0)
            r22 = r1
            int r1 = r7.f17324c
            if (r1 != 0) goto L_0x00f9
            r1 = 8388661(0x800035, float:1.1755018E-38)
        L_0x00f9:
            int r1 = android.view.Gravity.getAbsoluteGravity(r1, r10)
            r1 = r1 & 7
            r23 = r2
            r2 = 3
            if (r1 != r2) goto L_0x0106
            if (r11 == 0) goto L_0x010b
        L_0x0106:
            r2 = 5
            if (r1 != r2) goto L_0x0117
            if (r11 == 0) goto L_0x0117
        L_0x010b:
            int r1 = r13 - r9
            int r1 = r1 - r0
            r0 = 0
            int r1 = java.lang.Math.max(r0, r1)
            r20 = r1
            r2 = 0
            goto L_0x0132
        L_0x0117:
            if (r1 != r2) goto L_0x011b
            if (r11 == 0) goto L_0x0120
        L_0x011b:
            r2 = 3
            if (r1 != r2) goto L_0x0129
            if (r11 == 0) goto L_0x0129
        L_0x0120:
            int r0 = r0 - r8
            r2 = 0
            int r0 = java.lang.Math.max(r2, r0)
            r20 = r0
            goto L_0x0132
        L_0x0129:
            r2 = 0
            goto L_0x0130
        L_0x012b:
            r22 = r1
            r23 = r2
            goto L_0x0129
        L_0x0130:
            r20 = 0
        L_0x0132:
            if (r18 == 0) goto L_0x0165
            boolean r0 = m0.i0.b(r19)
            if (r0 != 0) goto L_0x0165
            m0.q2 r0 = r6.f1198u
            int r0 = r0.c()
            m0.q2 r1 = r6.f1198u
            int r1 = r1.d()
            int r1 = r1 + r0
            m0.q2 r0 = r6.f1198u
            int r0 = r0.e()
            m0.q2 r2 = r6.f1198u
            int r2 = r2.b()
            int r2 = r2 + r0
            int r0 = r13 - r1
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r12)
            int r1 = r15 - r2
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r14)
            r25 = r0
            r26 = r1
            goto L_0x0169
        L_0x0165:
            r25 = r33
            r26 = r34
        L_0x0169:
            z.b r0 = r7.f17322a
            if (r0 == 0) goto L_0x0194
            r2 = r21
            r21 = r22
            r1 = r32
            r22 = r8
            r24 = 0
            r8 = r2
            r30 = r23
            r23 = r9
            r9 = r30
            r2 = r19
            r27 = r10
            r10 = r3
            r3 = r25
            r28 = r4
            r4 = r20
            r29 = r5
            r5 = r26
            boolean r0 = r0.i(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x01b9
            goto L_0x01ab
        L_0x0194:
            r28 = r4
            r29 = r5
            r27 = r10
            r24 = 0
            r10 = r3
            r30 = r22
            r22 = r8
            r8 = r21
            r21 = r30
            r31 = r23
            r23 = r9
            r9 = r31
        L_0x01ab:
            r5 = 0
            r0 = r32
            r1 = r19
            r2 = r25
            r3 = r20
            r4 = r26
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
        L_0x01b9:
            int r0 = r19.getMeasuredWidth()
            int r0 = r0 + r16
            int r1 = r7.leftMargin
            int r0 = r0 + r1
            int r1 = r7.rightMargin
            int r0 = r0 + r1
            int r0 = java.lang.Math.max(r10, r0)
            int r1 = r19.getMeasuredHeight()
            int r1 = r1 + r17
            int r2 = r7.topMargin
            int r1 = r1 + r2
            int r2 = r7.bottomMargin
            int r1 = r1 + r2
            int r1 = java.lang.Math.max(r9, r1)
            int r2 = r19.getMeasuredState()
            int r2 = android.view.View.combineMeasuredStates(r8, r2)
            r3 = r0
            r0 = r2
            r2 = r1
        L_0x01e4:
            int r1 = r21 + 1
            r8 = r22
            r9 = r23
            r10 = r27
            r4 = r28
            r5 = r29
            r7 = 0
            goto L_0x00bb
        L_0x01f3:
            r8 = r0
            r9 = r2
            r10 = r3
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r8
            r1 = r33
            int r0 = android.view.View.resolveSizeAndState(r10, r1, r0)
            int r1 = r8 << 16
            r2 = r34
            int r1 = android.view.View.resolveSizeAndState(r9, r2, r1)
            r6.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public final boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                z.e eVar = (z.e) childAt.getLayoutParams();
                if (eVar.a(0)) {
                    b bVar = eVar.f17322a;
                }
            }
        }
        return false;
    }

    public final boolean onNestedPreFling(View view, float f10, float f11) {
        b bVar;
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                z.e eVar = (z.e) childAt.getLayoutParams();
                if (eVar.a(0) && (bVar = eVar.f17322a) != null) {
                    z10 |= bVar.j(view);
                }
            }
        }
        return z10;
    }

    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        c(view, i10, i11, iArr, 0);
    }

    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        e(view, i10, i11, i12, i13, 0);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        a(view, view2, i10, 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f14484h);
        SparseArray sparseArray = hVar.f17341j;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            b bVar = o(childAt).f17322a;
            if (!(id == -1 || bVar == null || (parcelable2 = (Parcelable) sparseArray.get(id)) == null)) {
                bVar.n(childAt, parcelable2);
            }
        }
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable o10;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            b bVar = ((z.e) childAt.getLayoutParams()).f17322a;
            if (!(id == -1 || bVar == null || (o10 = bVar.o(childAt)) == null)) {
                sparseArray.append(id, o10);
            }
        }
        hVar.f17341j = sparseArray;
        return hVar;
    }

    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return f(view, view2, i10, 0);
    }

    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f1194q
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.t(r1, r4)
            if (r3 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.f1194q
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            z.e r6 = (z.e) r6
            z.b r6 = r6.f17322a
            if (r6 == 0) goto L_0x0029
            android.view.View r7 = r0.f1194q
            boolean r6 = r6.r(r0, r7, r1)
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            android.view.View r7 = r0.f1194q
            r8 = 0
            if (r7 != 0) goto L_0x0035
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x0048
        L_0x0035:
            if (r3 == 0) goto L_0x0048
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x0048:
            if (r8 == 0) goto L_0x004d
            r8.recycle()
        L_0x004d:
            if (r2 == r4) goto L_0x0052
            r1 = 3
            if (r2 != r1) goto L_0x0055
        L_0x0052:
            r0.v(r5)
        L_0x0055:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean p(View view, int i10, int i11) {
        e eVar = E;
        Rect g10 = g();
        l(view, g10);
        try {
            return g10.contains(i10, i11);
        } finally {
            g10.setEmpty();
            eVar.e(g10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0294 A[EDGE_INSN: B:134:0x0294->B:100:0x0294 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(int r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            java.util.WeakHashMap r2 = m0.c1.f10054a
            int r2 = m0.j0.d(r25)
            java.util.ArrayList r9 = r0.f1185h
            int r10 = r9.size()
            android.graphics.Rect r11 = g()
            android.graphics.Rect r12 = g()
            android.graphics.Rect r13 = g()
            r3 = r1
            r15 = 0
        L_0x001e:
            l0.e r8 = E
            if (r15 >= r10) goto L_0x02ee
            java.lang.Object r4 = r9.get(r15)
            r7 = r4
            android.view.View r7 = (android.view.View) r7
            android.view.ViewGroup$LayoutParams r4 = r7.getLayoutParams()
            r6 = r4
            z.e r6 = (z.e) r6
            if (r3 != 0) goto L_0x0042
            int r4 = r7.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0042
            r7 = r9
            r6 = r10
            r5 = r13
            r21 = r15
            r14 = 0
            goto L_0x02e7
        L_0x0042:
            r5 = 0
        L_0x0043:
            if (r5 >= r15) goto L_0x0105
            java.lang.Object r3 = r9.get(r5)
            android.view.View r3 = (android.view.View) r3
            android.view.View r4 = r6.f17333l
            if (r4 != r3) goto L_0x00e7
            android.view.ViewGroup$LayoutParams r3 = r7.getLayoutParams()
            r4 = r3
            z.e r4 = (z.e) r4
            android.view.View r3 = r4.f17332k
            if (r3 == 0) goto L_0x00e7
            android.graphics.Rect r3 = g()
            android.graphics.Rect r14 = g()
            r17 = r9
            android.graphics.Rect r9 = g()
            r18 = r5
            android.view.View r5 = r4.f17332k
            r0.l(r5, r3)
            r5 = 0
            r0.j(r7, r14, r5)
            int r5 = r7.getMeasuredWidth()
            r19 = r10
            int r10 = r7.getMeasuredHeight()
            r20 = r3
            r3 = r2
            r16 = r4
            r21 = r15
            r15 = 1
            r4 = r20
            r22 = r5
            r5 = r9
            r23 = r6
            r6 = r16
            r15 = r7
            r7 = r22
            r24 = r13
            r13 = r8
            r8 = r10
            m(r3, r4, r5, r6, r7, r8)
            int r3 = r9.left
            int r4 = r14.left
            if (r3 != r4) goto L_0x00ab
            int r3 = r9.top
            int r4 = r14.top
            if (r3 == r4) goto L_0x00a5
            goto L_0x00ab
        L_0x00a5:
            r3 = r16
            r5 = r22
            r4 = 0
            goto L_0x00b0
        L_0x00ab:
            r3 = r16
            r5 = r22
            r4 = 1
        L_0x00b0:
            r0.h(r3, r9, r5, r10)
            int r5 = r9.left
            int r6 = r14.left
            int r5 = r5 - r6
            int r6 = r9.top
            int r7 = r14.top
            int r6 = r6 - r7
            if (r5 == 0) goto L_0x00c2
            m0.c1.j(r15, r5)
        L_0x00c2:
            if (r6 == 0) goto L_0x00c7
            m0.c1.k(r15, r6)
        L_0x00c7:
            if (r4 == 0) goto L_0x00d2
            z.b r4 = r3.f17322a
            if (r4 == 0) goto L_0x00d2
            android.view.View r3 = r3.f17332k
            r4.d(r0, r15, r3)
        L_0x00d2:
            r20.setEmpty()
            r3 = r20
            r13.e(r3)
            r14.setEmpty()
            r13.e(r14)
            r9.setEmpty()
            r13.e(r9)
            goto L_0x00f5
        L_0x00e7:
            r18 = r5
            r23 = r6
            r17 = r9
            r19 = r10
            r24 = r13
            r21 = r15
            r15 = r7
            r13 = r8
        L_0x00f5:
            int r5 = r18 + 1
            r8 = r13
            r7 = r15
            r9 = r17
            r10 = r19
            r15 = r21
            r6 = r23
            r13 = r24
            goto L_0x0043
        L_0x0105:
            r23 = r6
            r17 = r9
            r19 = r10
            r24 = r13
            r21 = r15
            r3 = 1
            r15 = r7
            r13 = r8
            r0.j(r15, r12, r3)
            r4 = r23
            int r3 = r4.f17328g
            r5 = 48
            r6 = 80
            r7 = 3
            r8 = 5
            if (r3 == 0) goto L_0x016f
            boolean r3 = r12.isEmpty()
            if (r3 != 0) goto L_0x016f
            int r3 = r4.f17328g
            int r3 = android.view.Gravity.getAbsoluteGravity(r3, r2)
            r9 = r3 & 112(0x70, float:1.57E-43)
            if (r9 == r5) goto L_0x0144
            if (r9 == r6) goto L_0x0134
            goto L_0x014e
        L_0x0134:
            int r9 = r11.bottom
            int r10 = r25.getHeight()
            int r14 = r12.top
            int r10 = r10 - r14
            int r9 = java.lang.Math.max(r9, r10)
            r11.bottom = r9
            goto L_0x014e
        L_0x0144:
            int r9 = r11.top
            int r10 = r12.bottom
            int r9 = java.lang.Math.max(r9, r10)
            r11.top = r9
        L_0x014e:
            r3 = r3 & 7
            if (r3 == r7) goto L_0x0165
            if (r3 == r8) goto L_0x0155
            goto L_0x016f
        L_0x0155:
            int r3 = r11.right
            int r9 = r25.getWidth()
            int r10 = r12.left
            int r9 = r9 - r10
            int r3 = java.lang.Math.max(r3, r9)
            r11.right = r3
            goto L_0x016f
        L_0x0165:
            int r3 = r11.left
            int r9 = r12.right
            int r3 = java.lang.Math.max(r3, r9)
            r11.left = r3
        L_0x016f:
            int r3 = r4.f17329h
            if (r3 == 0) goto L_0x027a
            int r3 = r15.getVisibility()
            if (r3 != 0) goto L_0x027a
            java.util.WeakHashMap r3 = m0.c1.f10054a
            boolean r3 = m0.l0.c(r15)
            if (r3 != 0) goto L_0x0183
            goto L_0x027a
        L_0x0183:
            int r3 = r15.getWidth()
            if (r3 <= 0) goto L_0x027a
            int r3 = r15.getHeight()
            if (r3 > 0) goto L_0x0191
            goto L_0x027a
        L_0x0191:
            android.view.ViewGroup$LayoutParams r3 = r15.getLayoutParams()
            z.e r3 = (z.e) r3
            z.b r4 = r3.f17322a
            android.graphics.Rect r9 = g()
            android.graphics.Rect r10 = g()
            int r14 = r15.getLeft()
            int r8 = r15.getTop()
            int r7 = r15.getRight()
            int r6 = r15.getBottom()
            r10.set(r14, r8, r7, r6)
            if (r4 == 0) goto L_0x01e7
            boolean r4 = r4.a(r15, r9)
            if (r4 == 0) goto L_0x01e7
            boolean r4 = r10.contains(r9)
            if (r4 == 0) goto L_0x01c3
            goto L_0x01ea
        L_0x01c3:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Rect should be within the child's bounds. Rect:"
            r2.<init>(r3)
            java.lang.String r3 = r9.toShortString()
            r2.append(r3)
            java.lang.String r3 = " | Bounds:"
            r2.append(r3)
            java.lang.String r3 = r10.toShortString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01e7:
            r9.set(r10)
        L_0x01ea:
            r10.setEmpty()
            r13.e(r10)
            boolean r4 = r9.isEmpty()
            if (r4 == 0) goto L_0x01fe
        L_0x01f6:
            r9.setEmpty()
            r13.e(r9)
            goto L_0x027a
        L_0x01fe:
            int r4 = r3.f17329h
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r2)
            r6 = r4 & 48
            if (r6 != r5) goto L_0x021a
            int r5 = r9.top
            int r6 = r3.topMargin
            int r5 = r5 - r6
            int r6 = r3.f17331j
            int r5 = r5 - r6
            int r6 = r11.top
            if (r5 >= r6) goto L_0x021a
            int r6 = r6 - r5
            x(r15, r6)
            r5 = 1
            goto L_0x021b
        L_0x021a:
            r5 = 0
        L_0x021b:
            r6 = r4 & 80
            r7 = 80
            if (r6 != r7) goto L_0x0237
            int r6 = r25.getHeight()
            int r7 = r9.bottom
            int r6 = r6 - r7
            int r7 = r3.bottomMargin
            int r6 = r6 - r7
            int r7 = r3.f17331j
            int r6 = r6 + r7
            int r7 = r11.bottom
            if (r6 >= r7) goto L_0x0237
            int r6 = r6 - r7
            x(r15, r6)
            r5 = 1
        L_0x0237:
            if (r5 != 0) goto L_0x023d
            r5 = 0
            x(r15, r5)
        L_0x023d:
            r5 = r4 & 3
            r6 = 3
            if (r5 != r6) goto L_0x0254
            int r5 = r9.left
            int r6 = r3.leftMargin
            int r5 = r5 - r6
            int r6 = r3.f17330i
            int r5 = r5 - r6
            int r6 = r11.left
            if (r5 >= r6) goto L_0x0254
            int r6 = r6 - r5
            w(r15, r6)
            r5 = 1
            goto L_0x0255
        L_0x0254:
            r5 = 0
        L_0x0255:
            r4 = r4 & 5
            r6 = 5
            if (r4 != r6) goto L_0x0271
            int r4 = r25.getWidth()
            int r6 = r9.right
            int r4 = r4 - r6
            int r6 = r3.rightMargin
            int r4 = r4 - r6
            int r3 = r3.f17330i
            int r4 = r4 + r3
            int r3 = r11.right
            if (r4 >= r3) goto L_0x0271
            int r4 = r4 - r3
            w(r15, r4)
            r4 = 1
            goto L_0x0272
        L_0x0271:
            r4 = r5
        L_0x0272:
            if (r4 != 0) goto L_0x01f6
            r3 = 0
            w(r15, r3)
            goto L_0x01f6
        L_0x027a:
            r3 = 2
            if (r1 == r3) goto L_0x02a2
            android.view.ViewGroup$LayoutParams r4 = r15.getLayoutParams()
            z.e r4 = (z.e) r4
            android.graphics.Rect r4 = r4.f17338q
            r5 = r24
            r5.set(r4)
            boolean r4 = r5.equals(r12)
            if (r4 == 0) goto L_0x0296
            r7 = r17
            r6 = r19
        L_0x0294:
            r14 = 0
            goto L_0x02e6
        L_0x0296:
            android.view.ViewGroup$LayoutParams r4 = r15.getLayoutParams()
            z.e r4 = (z.e) r4
            android.graphics.Rect r4 = r4.f17338q
            r4.set(r12)
            goto L_0x02a4
        L_0x02a2:
            r5 = r24
        L_0x02a4:
            int r4 = r21 + 1
            r6 = r19
        L_0x02a8:
            r7 = r17
            if (r4 >= r6) goto L_0x0294
            java.lang.Object r8 = r7.get(r4)
            android.view.View r8 = (android.view.View) r8
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            z.e r9 = (z.e) r9
            z.b r10 = r9.f17322a
            if (r10 == 0) goto L_0x02df
            boolean r13 = r10.b(r8, r15)
            if (r13 == 0) goto L_0x02df
            if (r1 != 0) goto L_0x02cd
            boolean r13 = r9.f17337p
            if (r13 == 0) goto L_0x02cd
            r14 = 0
            r9.f17337p = r14
            r10 = 1
            goto L_0x02e1
        L_0x02cd:
            r14 = 0
            if (r1 == r3) goto L_0x02d5
            boolean r8 = r10.d(r0, r8, r15)
            goto L_0x02d9
        L_0x02d5:
            r10.e(r0, r15)
            r8 = 1
        L_0x02d9:
            r10 = 1
            if (r1 != r10) goto L_0x02e1
            r9.f17337p = r8
            goto L_0x02e1
        L_0x02df:
            r10 = 1
            r14 = 0
        L_0x02e1:
            int r4 = r4 + 1
            r17 = r7
            goto L_0x02a8
        L_0x02e6:
            r3 = r1
        L_0x02e7:
            int r15 = r21 + 1
            r13 = r5
            r10 = r6
            r9 = r7
            goto L_0x001e
        L_0x02ee:
            r5 = r13
            r13 = r8
            r11.setEmpty()
            r13.e(r11)
            r12.setEmpty()
            r13.e(r12)
            r5.setEmpty()
            r13.e(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.q(int):void");
    }

    public final void r(View view, int i10) {
        boolean z10;
        z.e eVar = (z.e) view.getLayoutParams();
        View view2 = eVar.f17332k;
        int i11 = 0;
        if (view2 != null || eVar.f17327f == -1) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!z10) {
            e eVar2 = E;
            if (view2 != null) {
                Rect g10 = g();
                Rect g11 = g();
                try {
                    l(view2, g10);
                    z.e eVar3 = (z.e) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    m(i10, g10, g11, eVar3, measuredWidth, measuredHeight);
                    h(eVar3, g11, measuredWidth, measuredHeight);
                    view.layout(g11.left, g11.top, g11.right, g11.bottom);
                } finally {
                    g10.setEmpty();
                    eVar2.e(g10);
                    g11.setEmpty();
                    eVar2.e(g11);
                }
            } else {
                int i12 = eVar.f17326e;
                if (i12 >= 0) {
                    z.e eVar4 = (z.e) view.getLayoutParams();
                    int i13 = eVar4.f17324c;
                    if (i13 == 0) {
                        i13 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i13, i10);
                    int i14 = absoluteGravity & 7;
                    int i15 = absoluteGravity & 112;
                    int width = getWidth();
                    int height = getHeight();
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (i10 == 1) {
                        i12 = width - i12;
                    }
                    int n10 = n(i12) - measuredWidth2;
                    if (i14 == 1) {
                        n10 += measuredWidth2 / 2;
                    } else if (i14 == 5) {
                        n10 += measuredWidth2;
                    }
                    if (i15 == 16) {
                        i11 = 0 + (measuredHeight2 / 2);
                    } else if (i15 == 80) {
                        i11 = measuredHeight2 + 0;
                    }
                    int max = Math.max(getPaddingLeft() + eVar4.leftMargin, Math.min(n10, ((width - getPaddingRight()) - measuredWidth2) - eVar4.rightMargin));
                    int max2 = Math.max(getPaddingTop() + eVar4.topMargin, Math.min(i11, ((height - getPaddingBottom()) - measuredHeight2) - eVar4.bottomMargin));
                    view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                    return;
                }
                z.e eVar5 = (z.e) view.getLayoutParams();
                Rect g12 = g();
                g12.set(getPaddingLeft() + eVar5.leftMargin, getPaddingTop() + eVar5.topMargin, (getWidth() - getPaddingRight()) - eVar5.rightMargin, (getHeight() - getPaddingBottom()) - eVar5.bottomMargin);
                if (this.f1198u != null) {
                    WeakHashMap weakHashMap = c1.f10054a;
                    if (i0.b(this) && !i0.b(view)) {
                        g12.left = this.f1198u.c() + g12.left;
                        g12.top = this.f1198u.e() + g12.top;
                        g12.right -= this.f1198u.d();
                        g12.bottom -= this.f1198u.b();
                    }
                }
                Rect g13 = g();
                int i16 = eVar5.f17324c;
                if ((i16 & 7) == 0) {
                    i16 |= 8388611;
                }
                if ((i16 & 112) == 0) {
                    i16 |= 48;
                }
                m.b(i16, view.getMeasuredWidth(), view.getMeasuredHeight(), g12, g13, i10);
                view.layout(g13.left, g13.top, g13.right, g13.bottom);
                g12.setEmpty();
                eVar2.e(g12);
                g13.setEmpty();
                eVar2.e(g13);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        b bVar = ((z.e) view.getLayoutParams()).f17322a;
        if (bVar == null || !bVar.m(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10 && !this.f1191n) {
            v(false);
            this.f1191n = true;
        }
    }

    public final void s(View view, int i10, int i11, int i12) {
        measureChildWithMargins(view, i10, i11, i12, 0);
    }

    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        y();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1201x = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z10;
        Drawable drawable2 = this.f1200w;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f1200w = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f1200w.setState(getDrawableState());
                }
                Drawable drawable4 = this.f1200w;
                WeakHashMap weakHashMap = c1.f10054a;
                f0.d.c(drawable4, j0.d(this));
                Drawable drawable5 = this.f1200w;
                if (getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                drawable5.setVisible(z10, false);
                this.f1200w.setCallback(this);
            }
            WeakHashMap weakHashMap2 = c1.f10054a;
            i0.k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        Drawable drawable;
        if (i10 != 0) {
            Context context = getContext();
            Object obj = g.f2717a;
            drawable = c0.c.b(context, i10);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f1200w;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f1200w.setVisible(z10, false);
        }
    }

    public final boolean t(MotionEvent motionEvent, int i10) {
        boolean z10;
        int i11;
        MotionEvent motionEvent2 = motionEvent;
        int i12 = i10;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1187j;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i13 = childCount - 1; i13 >= 0; i13--) {
            if (isChildrenDrawingOrderEnabled) {
                i11 = getChildDrawingOrder(childCount, i13);
            } else {
                i11 = i13;
            }
            arrayList.add(getChildAt(i11));
        }
        i iVar = D;
        if (iVar != null) {
            Collections.sort(arrayList, iVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent3 = null;
        boolean z11 = false;
        boolean z12 = false;
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) arrayList.get(i14);
            z.e eVar = (z.e) view.getLayoutParams();
            b bVar = eVar.f17322a;
            if ((!z11 && !z12) || actionMasked == 0) {
                if (!z11 && bVar != null) {
                    if (i12 == 0) {
                        z11 = bVar.g(this, view, motionEvent2);
                    } else if (i12 == 1) {
                        z11 = bVar.r(this, view, motionEvent2);
                    }
                    if (z11) {
                        this.f1194q = view;
                    }
                }
                if (eVar.f17322a == null) {
                    eVar.f17334m = false;
                }
                boolean z13 = eVar.f17334m;
                if (z13) {
                    z10 = true;
                } else {
                    z10 = z13 | false;
                    eVar.f17334m = z10;
                }
                if (!z10 || z13) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z10 && !z12) {
                    break;
                }
            } else if (bVar != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i12 == 0) {
                    bVar.g(this, view, motionEvent3);
                } else if (i12 == 1) {
                    bVar.r(this, view, motionEvent3);
                }
            }
        }
        arrayList.clear();
        return z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
        if (r12 != false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0147 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u() {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList r1 = r0.f1185h
            r1.clear()
            z.j r2 = r0.f1186i
            q.k r3 = r2.f17343b
            int r4 = r3.f13081j
            r6 = 0
        L_0x000e:
            s.f r7 = r2.f17342a
            if (r6 >= r4) goto L_0x0023
            java.lang.Object r8 = r3.l(r6)
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            if (r8 == 0) goto L_0x0020
            r8.clear()
            r7.e(r8)
        L_0x0020:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0023:
            r3.clear()
            int r3 = r16.getChildCount()
            r4 = 0
        L_0x002b:
            q.k r6 = r2.f17343b
            if (r4 >= r3) goto L_0x0173
            android.view.View r8 = r0.getChildAt(r4)
            z.e r9 = o(r8)
            r10 = 0
            r11 = 1
            r12 = -1
            int r13 = r9.f17327f
            if (r13 != r12) goto L_0x0044
            r9.f17333l = r10
            r9.f17332k = r10
            goto L_0x00be
        L_0x0044:
            android.view.View r12 = r9.f17332k
            if (r12 == 0) goto L_0x0073
            int r12 = r12.getId()
            if (r12 == r13) goto L_0x004f
            goto L_0x006c
        L_0x004f:
            android.view.View r12 = r9.f17332k
            android.view.ViewParent r14 = r12.getParent()
        L_0x0055:
            if (r14 == r0) goto L_0x006e
            if (r14 == 0) goto L_0x0068
            if (r14 != r8) goto L_0x005c
            goto L_0x0068
        L_0x005c:
            boolean r15 = r14 instanceof android.view.View
            if (r15 == 0) goto L_0x0063
            r12 = r14
            android.view.View r12 = (android.view.View) r12
        L_0x0063:
            android.view.ViewParent r14 = r14.getParent()
            goto L_0x0055
        L_0x0068:
            r9.f17333l = r10
            r9.f17332k = r10
        L_0x006c:
            r12 = 0
            goto L_0x0071
        L_0x006e:
            r9.f17333l = r12
            r12 = 1
        L_0x0071:
            if (r12 != 0) goto L_0x00be
        L_0x0073:
            android.view.View r12 = r0.findViewById(r13)
            r9.f17332k = r12
            if (r12 == 0) goto L_0x00b4
            if (r12 != r0) goto L_0x008c
            boolean r12 = r16.isInEditMode()
            if (r12 == 0) goto L_0x0084
            goto L_0x00ba
        L_0x0084:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "View can not be anchored to the the parent CoordinatorLayout"
            r1.<init>(r2)
            throw r1
        L_0x008c:
            android.view.ViewParent r13 = r12.getParent()
        L_0x0090:
            if (r13 == r0) goto L_0x00b1
            if (r13 == 0) goto L_0x00b1
            if (r13 != r8) goto L_0x00a5
            boolean r12 = r16.isInEditMode()
            if (r12 == 0) goto L_0x009d
            goto L_0x00ba
        L_0x009d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Anchor must not be a descendant of the anchored view"
            r1.<init>(r2)
            throw r1
        L_0x00a5:
            boolean r14 = r13 instanceof android.view.View
            if (r14 == 0) goto L_0x00ac
            r12 = r13
            android.view.View r12 = (android.view.View) r12
        L_0x00ac:
            android.view.ViewParent r13 = r13.getParent()
            goto L_0x0090
        L_0x00b1:
            r9.f17333l = r12
            goto L_0x00be
        L_0x00b4:
            boolean r12 = r16.isInEditMode()
            if (r12 == 0) goto L_0x014f
        L_0x00ba:
            r9.f17333l = r10
            r9.f17332k = r10
        L_0x00be:
            boolean r12 = r6.containsKey(r8)
            if (r12 != 0) goto L_0x00c7
            r6.put(r8, r10)
        L_0x00c7:
            r12 = 0
        L_0x00c8:
            if (r12 >= r3) goto L_0x014b
            if (r12 != r4) goto L_0x00ce
            goto L_0x0147
        L_0x00ce:
            android.view.View r13 = r0.getChildAt(r12)
            android.view.View r14 = r9.f17333l
            if (r13 == r14) goto L_0x0105
            java.util.WeakHashMap r14 = m0.c1.f10054a
            int r14 = m0.j0.d(r16)
            android.view.ViewGroup$LayoutParams r15 = r13.getLayoutParams()
            z.e r15 = (z.e) r15
            int r15 = r15.f17328g
            int r15 = android.view.Gravity.getAbsoluteGravity(r15, r14)
            if (r15 == 0) goto L_0x00f5
            int r5 = r9.f17329h
            int r5 = android.view.Gravity.getAbsoluteGravity(r5, r14)
            r5 = r5 & r15
            if (r5 != r15) goto L_0x00f5
            r5 = 1
            goto L_0x00f6
        L_0x00f5:
            r5 = 0
        L_0x00f6:
            if (r5 != 0) goto L_0x0105
            z.b r5 = r9.f17322a
            if (r5 == 0) goto L_0x0103
            boolean r5 = r5.b(r8, r13)
            if (r5 == 0) goto L_0x0103
            goto L_0x0105
        L_0x0103:
            r5 = 0
            goto L_0x0106
        L_0x0105:
            r5 = 1
        L_0x0106:
            if (r5 == 0) goto L_0x0147
            boolean r5 = r6.containsKey(r13)
            if (r5 != 0) goto L_0x0117
            boolean r5 = r6.containsKey(r13)
            if (r5 != 0) goto L_0x0117
            r6.put(r13, r10)
        L_0x0117:
            boolean r5 = r6.containsKey(r13)
            if (r5 == 0) goto L_0x013f
            boolean r5 = r6.containsKey(r8)
            if (r5 == 0) goto L_0x013f
            java.lang.Object r5 = r6.getOrDefault(r13, r10)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x013b
            java.lang.Object r5 = r7.j()
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x0138
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x0138:
            r6.put(r13, r5)
        L_0x013b:
            r5.add(r8)
            goto L_0x0147
        L_0x013f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "All nodes must be present in the graph before being added as an edge"
            r1.<init>(r2)
            throw r1
        L_0x0147:
            int r12 = r12 + 1
            goto L_0x00c8
        L_0x014b:
            int r4 = r4 + 1
            goto L_0x002b
        L_0x014f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Could not find CoordinatorLayout descendant view with id "
            r2.<init>(r3)
            android.content.res.Resources r3 = r16.getResources()
            java.lang.String r3 = r3.getResourceName(r13)
            r2.append(r3)
            java.lang.String r3 = " to anchor view "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0173:
            java.util.ArrayList r3 = r2.f17344c
            r3.clear()
            java.util.HashSet r4 = r2.f17345d
            r4.clear()
            int r5 = r6.f13081j
            r7 = 0
        L_0x0180:
            if (r7 >= r5) goto L_0x018c
            java.lang.Object r8 = r6.h(r7)
            r2.a(r8, r3, r4)
            int r7 = r7 + 1
            goto L_0x0180
        L_0x018c:
            r1.addAll(r3)
            java.util.Collections.reverse(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.u():void");
    }

    public final void v(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            b bVar = ((z.e) childAt.getLayoutParams()).f17322a;
            if (bVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z10) {
                    bVar.g(this, childAt, obtain);
                } else {
                    bVar.r(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((z.e) getChildAt(i11).getLayoutParams()).f17334m = false;
        }
        this.f1194q = null;
        this.f1191n = false;
    }

    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1200w;
    }

    public final void y() {
        WeakHashMap weakHashMap = c1.f10054a;
        if (i0.b(this)) {
            if (this.f1202y == null) {
                this.f1202y = new a(10, (Object) this);
            }
            o0.u(this, this.f1202y);
            setSystemUiVisibility(1280);
            return;
        }
        o0.u(this, (y) null);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof z.e) {
            return new z.e((z.e) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new z.e((ViewGroup.MarginLayoutParams) layoutParams) : new z.e(layoutParams);
    }
}
