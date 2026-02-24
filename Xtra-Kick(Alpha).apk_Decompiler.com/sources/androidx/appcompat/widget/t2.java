package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import f.a;
import m0.c1;

public abstract class t2 extends ViewGroup {

    /* renamed from: h  reason: collision with root package name */
    public boolean f1070h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f1071i = -1;

    /* renamed from: j  reason: collision with root package name */
    public int f1072j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f1073k;

    /* renamed from: l  reason: collision with root package name */
    public int f1074l = 8388659;

    /* renamed from: m  reason: collision with root package name */
    public int f1075m;

    /* renamed from: n  reason: collision with root package name */
    public float f1076n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1077o;

    /* renamed from: p  reason: collision with root package name */
    public int[] f1078p;

    /* renamed from: q  reason: collision with root package name */
    public int[] f1079q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f1080r;

    /* renamed from: s  reason: collision with root package name */
    public int f1081s;

    /* renamed from: t  reason: collision with root package name */
    public int f1082t;

    /* renamed from: u  reason: collision with root package name */
    public int f1083u;

    /* renamed from: v  reason: collision with root package name */
    public int f1084v;

    public t2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Drawable drawable;
        int resourceId;
        int[] iArr = a.f5405o;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        c1.o(this, context, iArr, attributeSet, obtainStyledAttributes, i10);
        int i11 = obtainStyledAttributes.getInt(1, -1);
        if (i11 >= 0) {
            setOrientation(i11);
        }
        int i12 = obtainStyledAttributes.getInt(0, -1);
        if (i12 >= 0) {
            setGravity(i12);
        }
        boolean z10 = obtainStyledAttributes.getBoolean(2, true);
        if (!z10) {
            setBaselineAligned(z10);
        }
        this.f1076n = obtainStyledAttributes.getFloat(4, -1.0f);
        this.f1071i = obtainStyledAttributes.getInt(3, -1);
        this.f1077o = obtainStyledAttributes.getBoolean(7, false);
        if (!obtainStyledAttributes.hasValue(5) || (resourceId = obtainStyledAttributes.getResourceId(5, 0)) == 0) {
            drawable = obtainStyledAttributes.getDrawable(5);
        } else {
            drawable = h.a.a(context, resourceId);
        }
        setDividerDrawable(drawable);
        this.f1083u = obtainStyledAttributes.getInt(8, 0);
        this.f1084v = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s2;
    }

    public final void f(int i10, Canvas canvas) {
        this.f1080r.setBounds(getPaddingLeft() + this.f1084v, i10, (getWidth() - getPaddingRight()) - this.f1084v, this.f1082t + i10);
        this.f1080r.draw(canvas);
    }

    public final void g(int i10, Canvas canvas) {
        this.f1080r.setBounds(i10, getPaddingTop() + this.f1084v, this.f1081s + i10, (getHeight() - getPaddingBottom()) - this.f1084v);
        this.f1080r.draw(canvas);
    }

    public int getBaseline() {
        int i10;
        if (this.f1071i < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f1071i;
        if (childCount > i11) {
            View childAt = getChildAt(i11);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i12 = this.f1072j;
                if (this.f1073k == 1 && (i10 = this.f1074l & 112) != 48) {
                    if (i10 == 16) {
                        i12 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1075m) / 2;
                    } else if (i10 == 80) {
                        i12 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1075m;
                    }
                }
                return i12 + ((s2) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f1071i == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1071i;
    }

    public Drawable getDividerDrawable() {
        return this.f1080r;
    }

    public int getDividerPadding() {
        return this.f1084v;
    }

    public int getDividerWidth() {
        return this.f1081s;
    }

    public int getGravity() {
        return this.f1074l;
    }

    public int getOrientation() {
        return this.f1073k;
    }

    public int getShowDividers() {
        return this.f1083u;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1076n;
    }

    /* renamed from: h */
    public s2 generateDefaultLayoutParams() {
        int i10 = this.f1073k;
        if (i10 == 0) {
            return new s2(-2);
        }
        if (i10 == 1) {
            return new s2(-1);
        }
        return null;
    }

    /* renamed from: i */
    public s2 generateLayoutParams(AttributeSet attributeSet) {
        return new s2(getContext(), attributeSet);
    }

    /* renamed from: j */
    public s2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s2 ? new s2((ViewGroup.MarginLayoutParams) (s2) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new s2((ViewGroup.MarginLayoutParams) layoutParams) : new s2(layoutParams);
    }

    public final boolean k(int i10) {
        if (i10 == 0) {
            return (this.f1083u & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f1083u & 4) != 0;
        }
        if ((this.f1083u & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public final void onDraw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.f1080r != null) {
            int i15 = 0;
            if (this.f1073k == 1) {
                int virtualChildCount = getVirtualChildCount();
                while (i15 < virtualChildCount) {
                    View childAt = getChildAt(i15);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !k(i15))) {
                        f((childAt.getTop() - ((s2) childAt.getLayoutParams()).topMargin) - this.f1082t, canvas);
                    }
                    i15++;
                }
                if (k(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        i14 = (getHeight() - getPaddingBottom()) - this.f1082t;
                    } else {
                        i14 = childAt2.getBottom() + ((s2) childAt2.getLayoutParams()).bottomMargin;
                    }
                    f(i14, canvas);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean a10 = l5.a(this);
            while (i15 < virtualChildCount2) {
                View childAt3 = getChildAt(i15);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !k(i15))) {
                    s2 s2Var = (s2) childAt3.getLayoutParams();
                    if (a10) {
                        i13 = childAt3.getRight() + s2Var.rightMargin;
                    } else {
                        i13 = (childAt3.getLeft() - s2Var.leftMargin) - this.f1081s;
                    }
                    g(i13, canvas);
                }
                i15++;
            }
            if (k(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    s2 s2Var2 = (s2) childAt4.getLayoutParams();
                    if (a10) {
                        i12 = childAt4.getLeft();
                        i11 = s2Var2.leftMargin;
                    } else {
                        i10 = childAt4.getRight() + s2Var2.rightMargin;
                        g(i10, canvas);
                    }
                } else if (a10) {
                    i10 = getPaddingLeft();
                    g(i10, canvas);
                } else {
                    i12 = getWidth();
                    i11 = getPaddingRight();
                }
                i10 = (i12 - i11) - this.f1081s;
                g(i10, canvas);
            }
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r26, int r27, int r28, int r29, int r30) {
        /*
            r25 = this;
            r0 = r25
            int r1 = r0.f1073k
            r2 = 80
            r3 = 16
            r4 = 8
            r5 = 5
            r6 = 8388615(0x800007, float:1.1754953E-38)
            r7 = 2
            r9 = 1
            if (r1 != r9) goto L_0x00b9
            int r1 = r25.getPaddingLeft()
            int r10 = r29 - r27
            int r11 = r25.getPaddingRight()
            int r11 = r10 - r11
            int r10 = r10 - r1
            int r12 = r25.getPaddingRight()
            int r10 = r10 - r12
            int r12 = r25.getVirtualChildCount()
            int r13 = r0.f1074l
            r14 = r13 & 112(0x70, float:1.57E-43)
            r6 = r6 & r13
            if (r14 == r3) goto L_0x0042
            if (r14 == r2) goto L_0x0036
            int r2 = r25.getPaddingTop()
            goto L_0x004d
        L_0x0036:
            int r2 = r25.getPaddingTop()
            int r2 = r2 + r30
            int r2 = r2 - r28
            int r3 = r0.f1075m
            int r2 = r2 - r3
            goto L_0x004d
        L_0x0042:
            int r2 = r25.getPaddingTop()
            int r3 = r30 - r28
            int r13 = r0.f1075m
            int r3 = r3 - r13
            int r3 = r3 / r7
            int r2 = r2 + r3
        L_0x004d:
            r3 = 0
        L_0x004e:
            if (r3 >= r12) goto L_0x01d1
            android.view.View r13 = r0.getChildAt(r3)
            if (r13 != 0) goto L_0x0059
            int r2 = r2 + 0
            goto L_0x00b3
        L_0x0059:
            int r14 = r13.getVisibility()
            if (r14 == r4) goto L_0x00b3
            int r14 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r16 = r13.getLayoutParams()
            r4 = r16
            androidx.appcompat.widget.s2 r4 = (androidx.appcompat.widget.s2) r4
            int r8 = r4.gravity
            if (r8 >= 0) goto L_0x0074
            r8 = r6
        L_0x0074:
            java.util.WeakHashMap r17 = m0.c1.f10054a
            int r7 = m0.j0.d(r25)
            int r7 = android.view.Gravity.getAbsoluteGravity(r8, r7)
            r7 = r7 & 7
            if (r7 == r9) goto L_0x008b
            if (r7 == r5) goto L_0x0088
            int r7 = r4.leftMargin
            int r7 = r7 + r1
            goto L_0x0096
        L_0x0088:
            int r7 = r11 - r14
            goto L_0x0093
        L_0x008b:
            int r7 = r10 - r14
            r8 = 2
            int r7 = r7 / r8
            int r7 = r7 + r1
            int r8 = r4.leftMargin
            int r7 = r7 + r8
        L_0x0093:
            int r8 = r4.rightMargin
            int r7 = r7 - r8
        L_0x0096:
            boolean r8 = r0.k(r3)
            if (r8 == 0) goto L_0x009f
            int r8 = r0.f1082t
            int r2 = r2 + r8
        L_0x009f:
            int r8 = r4.topMargin
            int r2 = r2 + r8
            int r8 = r2 + 0
            int r14 = r14 + r7
            int r5 = r15 + r8
            r13.layout(r7, r8, r14, r5)
            int r4 = r4.bottomMargin
            int r15 = r15 + r4
            r4 = 0
            int r15 = r15 + r4
            int r15 = r15 + r2
            int r3 = r3 + 0
            r2 = r15
        L_0x00b3:
            int r3 = r3 + r9
            r4 = 8
            r5 = 5
            r7 = 2
            goto L_0x004e
        L_0x00b9:
            boolean r1 = androidx.appcompat.widget.l5.a(r25)
            int r4 = r25.getPaddingTop()
            int r5 = r30 - r28
            int r7 = r25.getPaddingBottom()
            int r7 = r5 - r7
            int r5 = r5 - r4
            int r8 = r25.getPaddingBottom()
            int r5 = r5 - r8
            int r8 = r25.getVirtualChildCount()
            int r10 = r0.f1074l
            r6 = r6 & r10
            r10 = r10 & 112(0x70, float:1.57E-43)
            boolean r11 = r0.f1070h
            int[] r12 = r0.f1078p
            int[] r13 = r0.f1079q
            java.util.WeakHashMap r14 = m0.c1.f10054a
            int r14 = m0.j0.d(r25)
            int r6 = android.view.Gravity.getAbsoluteGravity(r6, r14)
            if (r6 == r9) goto L_0x00fe
            r14 = 5
            if (r6 == r14) goto L_0x00f2
            int r6 = r25.getPaddingLeft()
            goto L_0x010a
        L_0x00f2:
            int r6 = r25.getPaddingLeft()
            int r6 = r6 + r29
            int r6 = r6 - r27
            int r14 = r0.f1075m
            int r6 = r6 - r14
            goto L_0x010a
        L_0x00fe:
            int r6 = r25.getPaddingLeft()
            int r14 = r29 - r27
            int r15 = r0.f1075m
            int r14 = r14 - r15
            r15 = 2
            int r14 = r14 / r15
            int r6 = r6 + r14
        L_0x010a:
            if (r1 == 0) goto L_0x0110
            int r1 = r8 + -1
            r15 = -1
            goto L_0x0112
        L_0x0110:
            r1 = 0
            r15 = 1
        L_0x0112:
            r18 = r6
            r6 = 0
        L_0x0115:
            if (r6 >= r8) goto L_0x01d1
            int r19 = r15 * r6
            int r9 = r19 + r1
            android.view.View r2 = r0.getChildAt(r9)
            if (r2 != 0) goto L_0x012d
            int r18 = r18 + 0
        L_0x0123:
            r28 = r1
            r30 = r8
            r22 = r10
            r1 = 0
        L_0x012a:
            r2 = 1
            goto L_0x01c3
        L_0x012d:
            int r3 = r2.getVisibility()
            r14 = 8
            if (r3 == r14) goto L_0x0123
            int r3 = r2.getMeasuredWidth()
            int r21 = r2.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r22 = r2.getLayoutParams()
            r14 = r22
            androidx.appcompat.widget.s2 r14 = (androidx.appcompat.widget.s2) r14
            r28 = r1
            if (r11 == 0) goto L_0x0155
            int r1 = r14.height
            r30 = r8
            r8 = -1
            if (r1 == r8) goto L_0x0157
            int r8 = r2.getBaseline()
            goto L_0x0158
        L_0x0155:
            r30 = r8
        L_0x0157:
            r8 = -1
        L_0x0158:
            int r1 = r14.gravity
            if (r1 >= 0) goto L_0x015d
            r1 = r10
        L_0x015d:
            r1 = r1 & 112(0x70, float:1.57E-43)
            r22 = r10
            r10 = 16
            if (r1 == r10) goto L_0x0195
            r10 = 48
            if (r1 == r10) goto L_0x0186
            r10 = 80
            if (r1 == r10) goto L_0x0170
            r1 = r4
            r10 = -1
            goto L_0x01a1
        L_0x0170:
            int r1 = r7 - r21
            int r10 = r14.bottomMargin
            int r1 = r1 - r10
            r10 = -1
            if (r8 == r10) goto L_0x01a1
            int r23 = r2.getMeasuredHeight()
            int r23 = r23 - r8
            r8 = 2
            r24 = r13[r8]
            int r24 = r24 - r23
            int r1 = r1 - r24
            goto L_0x01a1
        L_0x0186:
            r10 = -1
            int r1 = r14.topMargin
            int r1 = r1 + r4
            if (r8 == r10) goto L_0x01a1
            r20 = 1
            r23 = r12[r20]
            int r23 = r23 - r8
            int r1 = r23 + r1
            goto L_0x01a1
        L_0x0195:
            r10 = -1
            int r1 = r5 - r21
            r8 = 2
            int r1 = r1 / r8
            int r1 = r1 + r4
            int r8 = r14.topMargin
            int r1 = r1 + r8
            int r8 = r14.bottomMargin
            int r1 = r1 - r8
        L_0x01a1:
            boolean r8 = r0.k(r9)
            if (r8 == 0) goto L_0x01ab
            int r8 = r0.f1081s
            int r18 = r18 + r8
        L_0x01ab:
            int r8 = r14.leftMargin
            int r18 = r18 + r8
            int r8 = r18 + 0
            int r9 = r3 + r8
            int r10 = r21 + r1
            r2.layout(r8, r1, r9, r10)
            int r1 = r14.rightMargin
            int r3 = r3 + r1
            r1 = 0
            int r3 = r3 + r1
            int r18 = r3 + r18
            int r6 = r6 + 0
            goto L_0x012a
        L_0x01c3:
            int r6 = r6 + r2
            r1 = r28
            r8 = r30
            r10 = r22
            r2 = 80
            r3 = 16
            r9 = 1
            goto L_0x0115
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t2.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02af, code lost:
        if (r13 < 0) goto L_0x02b1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04ea  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04f9  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04fd  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0544  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0555  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x055d  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0568  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x05fc  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06b8  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x06d6  */
    /* JADX WARNING: Removed duplicated region for block: B:344:0x07bc  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x07e0  */
    /* JADX WARNING: Removed duplicated region for block: B:358:0x0822  */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x082c  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x0883  */
    /* JADX WARNING: Removed duplicated region for block: B:420:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r39, int r40) {
        /*
            r38 = this;
            r6 = r38
            r7 = r39
            r8 = r40
            int r0 = r6.f1073k
            r10 = -2
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = 8
            r14 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            r4 = 1
            if (r0 != r4) goto L_0x0389
            r6.f1075m = r5
            int r3 = r38.getVirtualChildCount()
            int r2 = android.view.View.MeasureSpec.getMode(r39)
            int r1 = android.view.View.MeasureSpec.getMode(r40)
            int r0 = r6.f1071i
            boolean r9 = r6.f1077o
            r13 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 1
            r25 = 0
        L_0x0039:
            if (r13 >= r3) goto L_0x0177
            android.view.View r26 = r6.getChildAt(r13)
            if (r26 != 0) goto L_0x0047
            int r4 = r6.f1075m
            int r4 = r4 + r5
            r6.f1075m = r4
            goto L_0x004f
        L_0x0047:
            int r4 = r26.getVisibility()
            if (r4 != r12) goto L_0x005b
            int r13 = r13 + 0
        L_0x004f:
            r10 = r0
            r29 = r1
            r0 = r2
            r31 = r3
            r12 = r18
            r27 = 1
            goto L_0x0161
        L_0x005b:
            boolean r4 = r6.k(r13)
            if (r4 == 0) goto L_0x0068
            int r4 = r6.f1075m
            int r5 = r6.f1082t
            int r4 = r4 + r5
            r6.f1075m = r4
        L_0x0068:
            android.view.ViewGroup$LayoutParams r4 = r26.getLayoutParams()
            r5 = r4
            androidx.appcompat.widget.s2 r5 = (androidx.appcompat.widget.s2) r5
            float r4 = r5.weight
            float r22 = r22 + r4
            if (r1 != r15) goto L_0x0097
            int r12 = r5.height
            if (r12 != 0) goto L_0x0097
            int r12 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0097
            int r4 = r6.f1075m
            int r12 = r5.topMargin
            int r12 = r12 + r4
            int r15 = r5.bottomMargin
            int r12 = r12 + r15
            int r4 = java.lang.Math.max(r4, r12)
            r6.f1075m = r4
            r10 = r0
            r29 = r1
            r30 = r2
            r31 = r3
            r14 = r5
            r4 = 1
            r27 = 1
            goto L_0x00e9
        L_0x0097:
            int r12 = r5.height
            if (r12 != 0) goto L_0x00a3
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a3
            r5.height = r10
            r12 = 0
            goto L_0x00a5
        L_0x00a3:
            r12 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00a5:
            r4 = 0
            int r15 = (r22 > r14 ? 1 : (r22 == r14 ? 0 : -1))
            if (r15 != 0) goto L_0x00ad
            int r15 = r6.f1075m
            goto L_0x00ae
        L_0x00ad:
            r15 = 0
        L_0x00ae:
            r10 = r0
            r0 = r38
            r29 = r1
            r1 = r26
            r30 = r2
            r2 = r39
            r31 = r3
            r3 = r4
            r27 = 1
            r4 = r40
            r14 = r5
            r5 = r15
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            if (r12 == r11) goto L_0x00c9
            r14.height = r12
        L_0x00c9:
            int r0 = r26.getMeasuredHeight()
            int r1 = r6.f1075m
            int r2 = r1 + r0
            int r3 = r14.topMargin
            int r2 = r2 + r3
            int r3 = r14.bottomMargin
            int r2 = r2 + r3
            r3 = 0
            int r2 = r2 + r3
            int r1 = java.lang.Math.max(r1, r2)
            r6.f1075m = r1
            r5 = r19
            if (r9 == 0) goto L_0x00e7
            int r19 = java.lang.Math.max(r0, r5)
        L_0x00e7:
            r4 = r23
        L_0x00e9:
            if (r10 < 0) goto L_0x00f3
            int r0 = r13 + 1
            if (r10 != r0) goto L_0x00f3
            int r0 = r6.f1075m
            r6.f1072j = r0
        L_0x00f3:
            if (r13 >= r10) goto L_0x0105
            float r0 = r14.weight
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x00fd
            goto L_0x0105
        L_0x00fd:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x0105:
            r0 = r30
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x0114
            int r1 = r14.width
            r2 = -1
            if (r1 != r2) goto L_0x0114
            r5 = 1
            r25 = 1
            goto L_0x0115
        L_0x0114:
            r5 = 0
        L_0x0115:
            int r1 = r14.leftMargin
            int r2 = r14.rightMargin
            int r1 = r1 + r2
            int r2 = r26.getMeasuredWidth()
            int r2 = r2 + r1
            r3 = r21
            int r3 = java.lang.Math.max(r3, r2)
            int r12 = r26.getMeasuredState()
            r15 = r18
            int r12 = android.view.View.combineMeasuredStates(r15, r12)
            if (r24 == 0) goto L_0x0138
            int r15 = r14.width
            r11 = -1
            if (r15 != r11) goto L_0x0138
            r11 = 1
            goto L_0x0139
        L_0x0138:
            r11 = 0
        L_0x0139:
            float r14 = r14.weight
            r15 = 0
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x014b
            if (r5 == 0) goto L_0x0143
            goto L_0x0144
        L_0x0143:
            r1 = r2
        L_0x0144:
            r14 = r20
            int r20 = java.lang.Math.max(r14, r1)
            goto L_0x0159
        L_0x014b:
            r14 = r20
            if (r5 == 0) goto L_0x0150
            goto L_0x0151
        L_0x0150:
            r1 = r2
        L_0x0151:
            r2 = r17
            int r17 = java.lang.Math.max(r2, r1)
            r20 = r14
        L_0x0159:
            int r13 = r13 + 0
            r21 = r3
            r23 = r4
            r24 = r11
        L_0x0161:
            int r13 = r13 + 1
            r2 = r0
            r0 = r10
            r18 = r12
            r1 = r29
            r3 = r31
            r4 = 1
            r5 = 0
            r10 = -2
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = 8
            r14 = 0
            r15 = 1073741824(0x40000000, float:2.0)
            goto L_0x0039
        L_0x0177:
            r29 = r1
            r0 = r2
            r31 = r3
            r2 = r17
            r15 = r18
            r5 = r19
            r14 = r20
            r3 = r21
            r27 = 1
            int r1 = r6.f1075m
            r10 = r31
            if (r1 <= 0) goto L_0x019b
            boolean r1 = r6.k(r10)
            if (r1 == 0) goto L_0x019b
            int r1 = r6.f1075m
            int r4 = r6.f1082t
            int r1 = r1 + r4
            r6.f1075m = r1
        L_0x019b:
            r1 = r29
            if (r9 == 0) goto L_0x01e1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r4) goto L_0x01a5
            if (r1 != 0) goto L_0x01e1
        L_0x01a5:
            r4 = 0
            r6.f1075m = r4
            r11 = 0
        L_0x01a9:
            if (r11 >= r10) goto L_0x01e1
            android.view.View r12 = r6.getChildAt(r11)
            if (r12 != 0) goto L_0x01b7
            int r12 = r6.f1075m
            int r12 = r12 + r4
            r6.f1075m = r12
            goto L_0x01dd
        L_0x01b7:
            int r4 = r12.getVisibility()
            r13 = 8
            if (r4 != r13) goto L_0x01c2
            int r11 = r11 + 0
            goto L_0x01dd
        L_0x01c2:
            android.view.ViewGroup$LayoutParams r4 = r12.getLayoutParams()
            androidx.appcompat.widget.s2 r4 = (androidx.appcompat.widget.s2) r4
            int r12 = r6.f1075m
            int r19 = r12 + r5
            int r13 = r4.topMargin
            int r19 = r19 + r13
            int r4 = r4.bottomMargin
            int r19 = r19 + r4
            r4 = 0
            int r13 = r19 + 0
            int r4 = java.lang.Math.max(r12, r13)
            r6.f1075m = r4
        L_0x01dd:
            int r11 = r11 + 1
            r4 = 0
            goto L_0x01a9
        L_0x01e1:
            int r4 = r6.f1075m
            int r11 = r38.getPaddingTop()
            int r12 = r38.getPaddingBottom()
            int r12 = r12 + r11
            int r12 = r12 + r4
            r6.f1075m = r12
            int r4 = r38.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r12, r4)
            r11 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r8, r11)
            r11 = 16777215(0xffffff, float:2.3509886E-38)
            r11 = r11 & r4
            int r12 = r6.f1075m
            int r11 = r11 - r12
            if (r23 != 0) goto L_0x024e
            if (r11 == 0) goto L_0x020d
            r12 = 0
            int r13 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x020d
            goto L_0x024e
        L_0x020d:
            int r2 = java.lang.Math.max(r2, r14)
            if (r9 == 0) goto L_0x024a
            r9 = 1073741824(0x40000000, float:2.0)
            if (r1 == r9) goto L_0x024a
            r1 = 0
        L_0x0218:
            if (r1 >= r10) goto L_0x024a
            android.view.View r9 = r6.getChildAt(r1)
            if (r9 == 0) goto L_0x0247
            int r11 = r9.getVisibility()
            r12 = 8
            if (r11 != r12) goto L_0x0229
            goto L_0x0247
        L_0x0229:
            android.view.ViewGroup$LayoutParams r11 = r9.getLayoutParams()
            androidx.appcompat.widget.s2 r11 = (androidx.appcompat.widget.s2) r11
            float r11 = r11.weight
            r12 = 0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x0247
            int r11 = r9.getMeasuredWidth()
            r12 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r12)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r12)
            r9.measure(r11, r13)
        L_0x0247:
            int r1 = r1 + 1
            goto L_0x0218
        L_0x024a:
            r21 = r3
            goto L_0x0329
        L_0x024e:
            float r5 = r6.f1076n
            r9 = 0
            int r12 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r12 <= 0) goto L_0x0257
            r22 = r5
        L_0x0257:
            r5 = 0
            r6.f1075m = r5
            r5 = 0
        L_0x025b:
            if (r5 >= r10) goto L_0x0319
            android.view.View r9 = r6.getChildAt(r5)
            int r12 = r9.getVisibility()
            r13 = 8
            if (r12 != r13) goto L_0x026d
            r29 = r1
            goto L_0x0313
        L_0x026d:
            android.view.ViewGroup$LayoutParams r12 = r9.getLayoutParams()
            androidx.appcompat.widget.s2 r12 = (androidx.appcompat.widget.s2) r12
            float r13 = r12.weight
            r14 = 0
            int r16 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x02c7
            float r14 = (float) r11
            float r14 = r14 * r13
            float r14 = r14 / r22
            int r14 = (int) r14
            float r22 = r22 - r13
            int r11 = r11 - r14
            int r13 = r38.getPaddingLeft()
            int r16 = r38.getPaddingRight()
            int r16 = r16 + r13
            int r13 = r12.leftMargin
            int r16 = r16 + r13
            int r13 = r12.rightMargin
            int r13 = r16 + r13
            r16 = r11
            int r11 = r12.width
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r7, r13, r11)
            int r13 = r12.height
            if (r13 != 0) goto L_0x02aa
            r13 = 1073741824(0x40000000, float:2.0)
            if (r1 == r13) goto L_0x02a6
            goto L_0x02aa
        L_0x02a6:
            if (r14 <= 0) goto L_0x02b1
            r13 = r14
            goto L_0x02b2
        L_0x02aa:
            int r13 = r9.getMeasuredHeight()
            int r13 = r13 + r14
            if (r13 >= 0) goto L_0x02b2
        L_0x02b1:
            r13 = 0
        L_0x02b2:
            r14 = 1073741824(0x40000000, float:2.0)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r13, r14)
            r9.measure(r11, r13)
            int r11 = r9.getMeasuredState()
            r11 = r11 & -256(0xffffffffffffff00, float:NaN)
            int r15 = android.view.View.combineMeasuredStates(r15, r11)
            r11 = r16
        L_0x02c7:
            int r13 = r12.leftMargin
            int r14 = r12.rightMargin
            int r13 = r13 + r14
            int r14 = r9.getMeasuredWidth()
            int r14 = r14 + r13
            int r3 = java.lang.Math.max(r3, r14)
            r29 = r1
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x02e4
            int r1 = r12.width
            r16 = r3
            r3 = -1
            if (r1 != r3) goto L_0x02e7
            r1 = 1
            goto L_0x02e8
        L_0x02e4:
            r16 = r3
            r3 = -1
        L_0x02e7:
            r1 = 0
        L_0x02e8:
            if (r1 == 0) goto L_0x02eb
            goto L_0x02ec
        L_0x02eb:
            r13 = r14
        L_0x02ec:
            int r1 = java.lang.Math.max(r2, r13)
            if (r24 == 0) goto L_0x02f8
            int r2 = r12.width
            if (r2 != r3) goto L_0x02f8
            r2 = 1
            goto L_0x02f9
        L_0x02f8:
            r2 = 0
        L_0x02f9:
            int r3 = r6.f1075m
            int r9 = r9.getMeasuredHeight()
            int r9 = r9 + r3
            int r13 = r12.topMargin
            int r9 = r9 + r13
            int r12 = r12.bottomMargin
            int r9 = r9 + r12
            r12 = 0
            int r9 = r9 + r12
            int r3 = java.lang.Math.max(r3, r9)
            r6.f1075m = r3
            r24 = r2
            r3 = r16
            r2 = r1
        L_0x0313:
            int r5 = r5 + 1
            r1 = r29
            goto L_0x025b
        L_0x0319:
            int r1 = r6.f1075m
            int r5 = r38.getPaddingTop()
            int r9 = r38.getPaddingBottom()
            int r9 = r9 + r5
            int r9 = r9 + r1
            r6.f1075m = r9
            goto L_0x024a
        L_0x0329:
            if (r24 != 0) goto L_0x0330
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L_0x0330
            goto L_0x0332
        L_0x0330:
            r2 = r21
        L_0x0332:
            int r0 = r38.getPaddingLeft()
            int r1 = r38.getPaddingRight()
            int r1 = r1 + r0
            int r1 = r1 + r2
            int r0 = r38.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r1, r0)
            int r0 = android.view.View.resolveSizeAndState(r0, r7, r15)
            r6.setMeasuredDimension(r0, r4)
            if (r25 == 0) goto L_0x08c0
            int r0 = r38.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r9 = 0
        L_0x0358:
            if (r9 >= r10) goto L_0x08c0
            android.view.View r1 = r6.getChildAt(r9)
            int r0 = r1.getVisibility()
            r2 = 8
            if (r0 == r2) goto L_0x0386
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            r11 = r0
            androidx.appcompat.widget.s2 r11 = (androidx.appcompat.widget.s2) r11
            int r0 = r11.width
            r2 = -1
            if (r0 != r2) goto L_0x0386
            int r12 = r11.height
            int r0 = r1.getMeasuredHeight()
            r11.height = r0
            r3 = 0
            r5 = 0
            r0 = r38
            r2 = r7
            r4 = r40
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r11.height = r12
        L_0x0386:
            int r9 = r9 + 1
            goto L_0x0358
        L_0x0389:
            r0 = 0
            r27 = 1
            r6.f1075m = r0
            int r9 = r38.getVirtualChildCount()
            int r10 = android.view.View.MeasureSpec.getMode(r39)
            int r11 = android.view.View.MeasureSpec.getMode(r40)
            int[] r0 = r6.f1078p
            r12 = 4
            if (r0 == 0) goto L_0x03a3
            int[] r0 = r6.f1079q
            if (r0 != 0) goto L_0x03ab
        L_0x03a3:
            int[] r0 = new int[r12]
            r6.f1078p = r0
            int[] r0 = new int[r12]
            r6.f1079q = r0
        L_0x03ab:
            int[] r13 = r6.f1078p
            int[] r14 = r6.f1079q
            r15 = 3
            r0 = -1
            r13[r15] = r0
            r17 = 2
            r13[r17] = r0
            r13[r27] = r0
            r1 = 0
            r13[r1] = r0
            r14[r15] = r0
            r14[r17] = r0
            r14[r27] = r0
            r14[r1] = r0
            boolean r5 = r6.f1070h
            boolean r4 = r6.f1077o
            r0 = 1073741824(0x40000000, float:2.0)
            if (r10 != r0) goto L_0x03cf
            r19 = 1
            goto L_0x03d1
        L_0x03cf:
            r19 = 0
        L_0x03d1:
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r12 = 0
            r15 = 0
            r20 = 1
            r22 = 0
            r24 = 0
            r32 = 0
        L_0x03df:
            if (r3 >= r9) goto L_0x058a
            android.view.View r8 = r6.getChildAt(r3)
            if (r8 != 0) goto L_0x03f4
            int r8 = r6.f1075m
            r25 = 0
            int r8 = r8 + 0
            r6.f1075m = r8
            r25 = r0
            r26 = r2
            goto L_0x0402
        L_0x03f4:
            r25 = r0
            int r0 = r8.getVisibility()
            r26 = r2
            r2 = 8
            if (r0 != r2) goto L_0x040c
            int r3 = r3 + 0
        L_0x0402:
            r30 = r5
            r0 = r25
            r2 = r26
            r26 = r4
            goto L_0x0580
        L_0x040c:
            boolean r0 = r6.k(r3)
            if (r0 == 0) goto L_0x0419
            int r0 = r6.f1075m
            int r2 = r6.f1081s
            int r0 = r0 + r2
            r6.f1075m = r0
        L_0x0419:
            android.view.ViewGroup$LayoutParams r0 = r8.getLayoutParams()
            r2 = r0
            androidx.appcompat.widget.s2 r2 = (androidx.appcompat.widget.s2) r2
            float r0 = r2.weight
            float r29 = r1 + r0
            r1 = 1073741824(0x40000000, float:2.0)
            if (r10 != r1) goto L_0x0477
            int r1 = r2.width
            if (r1 != 0) goto L_0x0477
            r1 = 0
            int r30 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r30 <= 0) goto L_0x0477
            if (r19 == 0) goto L_0x0440
            int r0 = r6.f1075m
            int r1 = r2.leftMargin
            r30 = r3
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r1 = r1 + r0
            r6.f1075m = r1
            goto L_0x0450
        L_0x0440:
            r30 = r3
            int r0 = r6.f1075m
            int r1 = r2.leftMargin
            int r1 = r1 + r0
            int r3 = r2.rightMargin
            int r1 = r1 + r3
            int r0 = java.lang.Math.max(r0, r1)
            r6.f1075m = r0
        L_0x0450:
            if (r5 == 0) goto L_0x0467
            r0 = 0
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r8.measure(r1, r1)
            r1 = r2
            r34 = r25
            r35 = r26
            r25 = r30
            r26 = r4
            r30 = r5
            goto L_0x04ee
        L_0x0467:
            r1 = r2
            r34 = r25
            r35 = r26
            r25 = r30
            r0 = 1073741824(0x40000000, float:2.0)
            r26 = r4
            r30 = r5
            r4 = 1
            goto L_0x04f2
        L_0x0477:
            r30 = r3
            int r1 = r2.width
            if (r1 != 0) goto L_0x0487
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0488
            r0 = -2
            r2.width = r0
            r3 = 0
            goto L_0x048a
        L_0x0487:
            r1 = 0
        L_0x0488:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x048a:
            int r0 = (r29 > r1 ? 1 : (r29 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0493
            int r0 = r6.f1075m
            r31 = r0
            goto L_0x0495
        L_0x0493:
            r31 = 0
        L_0x0495:
            r33 = 0
            r1 = r25
            r0 = r38
            r34 = r1
            r1 = r8
            r36 = r2
            r35 = r26
            r2 = r39
            r37 = r3
            r25 = r30
            r3 = r31
            r26 = r4
            r4 = r40
            r30 = r5
            r5 = r33
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r0 = r37
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x04c0
            r1 = r36
            r1.width = r0
            goto L_0x04c2
        L_0x04c0:
            r1 = r36
        L_0x04c2:
            int r0 = r8.getMeasuredWidth()
            if (r19 == 0) goto L_0x04d6
            int r2 = r6.f1075m
            int r3 = r1.leftMargin
            int r3 = r3 + r0
            int r4 = r1.rightMargin
            int r3 = r3 + r4
            r4 = 0
            int r3 = r3 + r4
            int r3 = r3 + r2
            r6.f1075m = r3
            goto L_0x04e8
        L_0x04d6:
            r4 = 0
            int r2 = r6.f1075m
            int r3 = r2 + r0
            int r5 = r1.leftMargin
            int r3 = r3 + r5
            int r5 = r1.rightMargin
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r2 = java.lang.Math.max(r2, r3)
            r6.f1075m = r2
        L_0x04e8:
            if (r26 == 0) goto L_0x04ee
            int r12 = java.lang.Math.max(r0, r12)
        L_0x04ee:
            r4 = r22
            r0 = 1073741824(0x40000000, float:2.0)
        L_0x04f2:
            if (r11 == r0) goto L_0x04fd
            int r0 = r1.height
            r2 = -1
            if (r0 != r2) goto L_0x04fd
            r5 = 1
            r24 = 1
            goto L_0x04fe
        L_0x04fd:
            r5 = 0
        L_0x04fe:
            int r0 = r1.topMargin
            int r2 = r1.bottomMargin
            int r0 = r0 + r2
            int r2 = r8.getMeasuredHeight()
            int r2 = r2 + r0
            int r3 = r8.getMeasuredState()
            r22 = r0
            r0 = r34
            int r0 = android.view.View.combineMeasuredStates(r0, r3)
            if (r30 == 0) goto L_0x0544
            int r3 = r8.getBaseline()
            r8 = -1
            if (r3 == r8) goto L_0x0544
            int r8 = r1.gravity
            if (r8 >= 0) goto L_0x0523
            int r8 = r6.f1074l
        L_0x0523:
            r8 = r8 & 112(0x70, float:1.57E-43)
            r23 = 4
            int r8 = r8 >> 4
            r28 = -2
            r8 = r8 & -2
            int r8 = r8 >> 1
            r31 = r0
            r0 = r13[r8]
            int r0 = java.lang.Math.max(r0, r3)
            r13[r8] = r0
            r0 = r14[r8]
            int r3 = r2 - r3
            int r0 = java.lang.Math.max(r0, r3)
            r14[r8] = r0
            goto L_0x0546
        L_0x0544:
            r31 = r0
        L_0x0546:
            r3 = r32
            int r0 = java.lang.Math.max(r3, r2)
            if (r20 == 0) goto L_0x0555
            int r3 = r1.height
            r8 = -1
            if (r3 != r8) goto L_0x0555
            r3 = 1
            goto L_0x0556
        L_0x0555:
            r3 = 0
        L_0x0556:
            float r1 = r1.weight
            r8 = 0
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0568
            if (r5 == 0) goto L_0x0561
            r2 = r22
        L_0x0561:
            r8 = r35
            int r2 = java.lang.Math.max(r8, r2)
            goto L_0x0573
        L_0x0568:
            r8 = r35
            if (r5 == 0) goto L_0x056e
            r2 = r22
        L_0x056e:
            int r15 = java.lang.Math.max(r15, r2)
            r2 = r8
        L_0x0573:
            int r1 = r25 + 0
            r32 = r0
            r20 = r3
            r22 = r4
            r0 = r31
            r3 = r1
            r1 = r29
        L_0x0580:
            int r3 = r3 + 1
            r8 = r40
            r4 = r26
            r5 = r30
            goto L_0x03df
        L_0x058a:
            r8 = r2
            r26 = r4
            r30 = r5
            r3 = r32
            int r2 = r6.f1075m
            if (r2 <= 0) goto L_0x05a2
            boolean r2 = r6.k(r9)
            if (r2 == 0) goto L_0x05a2
            int r2 = r6.f1075m
            int r4 = r6.f1081s
            int r2 = r2 + r4
            r6.f1075m = r2
        L_0x05a2:
            r2 = r13[r27]
            r4 = -1
            r25 = r0
            if (r2 != r4) goto L_0x05bd
            r5 = 0
            r0 = r13[r5]
            if (r0 != r4) goto L_0x05bd
            r0 = r13[r17]
            if (r0 != r4) goto L_0x05bd
            r0 = 3
            r5 = r13[r0]
            if (r5 == r4) goto L_0x05b8
            goto L_0x05be
        L_0x05b8:
            r32 = r3
            r29 = r11
            goto L_0x05ee
        L_0x05bd:
            r0 = 3
        L_0x05be:
            r4 = r13[r0]
            r5 = 0
            r0 = r13[r5]
            r5 = r13[r17]
            int r2 = java.lang.Math.max(r2, r5)
            int r0 = java.lang.Math.max(r0, r2)
            int r0 = java.lang.Math.max(r4, r0)
            r2 = 3
            r4 = r14[r2]
            r2 = 0
            r5 = r14[r2]
            r2 = r14[r27]
            r29 = r11
            r11 = r14[r17]
            int r2 = java.lang.Math.max(r2, r11)
            int r2 = java.lang.Math.max(r5, r2)
            int r2 = java.lang.Math.max(r4, r2)
            int r2 = r2 + r0
            int r32 = java.lang.Math.max(r3, r2)
        L_0x05ee:
            if (r26 == 0) goto L_0x063f
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == r0) goto L_0x05f6
            if (r10 != 0) goto L_0x063f
        L_0x05f6:
            r0 = 0
            r6.f1075m = r0
            r5 = 0
        L_0x05fa:
            if (r5 >= r9) goto L_0x063f
            android.view.View r2 = r6.getChildAt(r5)
            if (r2 != 0) goto L_0x0608
            int r2 = r6.f1075m
            int r2 = r2 + r0
            r6.f1075m = r2
            goto L_0x063b
        L_0x0608:
            int r0 = r2.getVisibility()
            r3 = 8
            if (r0 != r3) goto L_0x0613
            int r5 = r5 + 0
            goto L_0x063b
        L_0x0613:
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            androidx.appcompat.widget.s2 r0 = (androidx.appcompat.widget.s2) r0
            if (r19 == 0) goto L_0x0629
            int r2 = r6.f1075m
            int r3 = r0.leftMargin
            int r3 = r3 + r12
            int r0 = r0.rightMargin
            int r3 = r3 + r0
            r4 = 0
            int r3 = r3 + r4
            int r3 = r3 + r2
            r6.f1075m = r3
            goto L_0x063b
        L_0x0629:
            r4 = 0
            int r2 = r6.f1075m
            int r3 = r2 + r12
            int r11 = r0.leftMargin
            int r3 = r3 + r11
            int r0 = r0.rightMargin
            int r3 = r3 + r0
            int r3 = r3 + r4
            int r0 = java.lang.Math.max(r2, r3)
            r6.f1075m = r0
        L_0x063b:
            int r5 = r5 + 1
            r0 = 0
            goto L_0x05fa
        L_0x063f:
            int r0 = r6.f1075m
            int r2 = r38.getPaddingLeft()
            int r3 = r38.getPaddingRight()
            int r3 = r3 + r2
            int r3 = r3 + r0
            r6.f1075m = r3
            int r0 = r38.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r3, r0)
            r2 = 0
            int r0 = android.view.View.resolveSizeAndState(r0, r7, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r0
            int r3 = r6.f1075m
            int r2 = r2 - r3
            if (r22 != 0) goto L_0x06b1
            if (r2 == 0) goto L_0x066b
            r4 = 0
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x066b
            goto L_0x06b1
        L_0x066b:
            int r1 = java.lang.Math.max(r15, r8)
            if (r26 == 0) goto L_0x06a8
            r2 = 1073741824(0x40000000, float:2.0)
            if (r10 == r2) goto L_0x06a8
            r5 = 0
        L_0x0676:
            if (r5 >= r9) goto L_0x06a8
            android.view.View r2 = r6.getChildAt(r5)
            if (r2 == 0) goto L_0x06a5
            int r4 = r2.getVisibility()
            r8 = 8
            if (r4 != r8) goto L_0x0687
            goto L_0x06a5
        L_0x0687:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.s2 r4 = (androidx.appcompat.widget.s2) r4
            float r4 = r4.weight
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x06a5
            r4 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r4)
            int r10 = r2.getMeasuredHeight()
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r4)
            r2.measure(r8, r10)
        L_0x06a5:
            int r5 = r5 + 1
            goto L_0x0676
        L_0x06a8:
            r4 = r40
            r15 = r1
            r1 = r25
            r12 = r29
            goto L_0x082a
        L_0x06b1:
            float r4 = r6.f1076n
            r5 = 0
            int r8 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x06b9
            r1 = r4
        L_0x06b9:
            r4 = -1
            r5 = 3
            r13[r5] = r4
            r13[r17] = r4
            r13[r27] = r4
            r8 = 0
            r13[r8] = r4
            r14[r5] = r4
            r14[r17] = r4
            r14[r27] = r4
            r14[r8] = r4
            r6.f1075m = r8
            r4 = r2
            r5 = -1
            r8 = 0
            r2 = r1
            r1 = r25
        L_0x06d4:
            if (r8 >= r9) goto L_0x0802
            android.view.View r11 = r6.getChildAt(r8)
            if (r11 == 0) goto L_0x07ee
            int r12 = r11.getVisibility()
            r3 = 8
            if (r12 != r3) goto L_0x06e6
            goto L_0x07ee
        L_0x06e6:
            android.view.ViewGroup$LayoutParams r3 = r11.getLayoutParams()
            androidx.appcompat.widget.s2 r3 = (androidx.appcompat.widget.s2) r3
            float r12 = r3.weight
            r18 = 0
            int r22 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r22 <= 0) goto L_0x0746
            float r7 = (float) r4
            float r7 = r7 * r12
            float r7 = r7 / r2
            int r7 = (int) r7
            float r2 = r2 - r12
            int r4 = r4 - r7
            int r12 = r38.getPaddingTop()
            int r22 = r38.getPaddingBottom()
            int r22 = r22 + r12
            int r12 = r3.topMargin
            int r22 = r22 + r12
            int r12 = r3.bottomMargin
            int r12 = r22 + r12
            r22 = r2
            int r2 = r3.height
            r25 = r4
            r4 = r40
            int r2 = android.view.ViewGroup.getChildMeasureSpec(r4, r12, r2)
            int r12 = r3.width
            if (r12 != 0) goto L_0x0725
            r12 = 1073741824(0x40000000, float:2.0)
            if (r10 == r12) goto L_0x0722
            goto L_0x0725
        L_0x0722:
            if (r7 <= 0) goto L_0x072c
            goto L_0x072d
        L_0x0725:
            int r12 = r11.getMeasuredWidth()
            int r7 = r7 + r12
            if (r7 >= 0) goto L_0x072d
        L_0x072c:
            r7 = 0
        L_0x072d:
            r12 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r12)
            r11.measure(r7, r2)
            int r2 = r11.getMeasuredState()
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2 = r2 & r7
            int r1 = android.view.View.combineMeasuredStates(r1, r2)
            r2 = r22
            r7 = r25
            goto L_0x0749
        L_0x0746:
            r7 = r4
            r4 = r40
        L_0x0749:
            if (r19 == 0) goto L_0x0765
            int r12 = r6.f1075m
            int r22 = r11.getMeasuredWidth()
            r25 = r1
            int r1 = r3.leftMargin
            int r22 = r22 + r1
            int r1 = r3.rightMargin
            int r22 = r22 + r1
            r1 = 0
            int r22 = r22 + 0
            int r12 = r22 + r12
            r6.f1075m = r12
            r26 = r2
            goto L_0x0783
        L_0x0765:
            r25 = r1
            r1 = 0
            int r12 = r6.f1075m
            int r22 = r11.getMeasuredWidth()
            int r22 = r22 + r12
            int r1 = r3.leftMargin
            int r22 = r22 + r1
            int r1 = r3.rightMargin
            int r22 = r22 + r1
            r26 = r2
            r1 = 0
            int r2 = r22 + 0
            int r1 = java.lang.Math.max(r12, r2)
            r6.f1075m = r1
        L_0x0783:
            r12 = r29
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x0790
            int r1 = r3.height
            r2 = -1
            if (r1 != r2) goto L_0x0790
            r1 = 1
            goto L_0x0791
        L_0x0790:
            r1 = 0
        L_0x0791:
            int r2 = r3.topMargin
            r22 = r7
            int r7 = r3.bottomMargin
            int r2 = r2 + r7
            int r7 = r11.getMeasuredHeight()
            int r7 = r7 + r2
            int r5 = java.lang.Math.max(r5, r7)
            if (r1 == 0) goto L_0x07a4
            goto L_0x07a5
        L_0x07a4:
            r2 = r7
        L_0x07a5:
            int r1 = java.lang.Math.max(r15, r2)
            if (r20 == 0) goto L_0x07b2
            int r2 = r3.height
            r15 = -1
            if (r2 != r15) goto L_0x07b3
            r2 = 1
            goto L_0x07b4
        L_0x07b2:
            r15 = -1
        L_0x07b3:
            r2 = 0
        L_0x07b4:
            if (r30 == 0) goto L_0x07e0
            int r11 = r11.getBaseline()
            if (r11 == r15) goto L_0x07e0
            int r3 = r3.gravity
            if (r3 >= 0) goto L_0x07c2
            int r3 = r6.f1074l
        L_0x07c2:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r23 = 4
            int r3 = r3 >> 4
            r28 = -2
            r3 = r3 & -2
            int r3 = r3 >> 1
            r15 = r13[r3]
            int r15 = java.lang.Math.max(r15, r11)
            r13[r3] = r15
            r15 = r14[r3]
            int r7 = r7 - r11
            int r7 = java.lang.Math.max(r15, r7)
            r14[r3] = r7
            goto L_0x07e4
        L_0x07e0:
            r23 = 4
            r28 = -2
        L_0x07e4:
            r15 = r1
            r20 = r2
            r7 = r22
            r1 = r25
            r2 = r26
            goto L_0x07f9
        L_0x07ee:
            r7 = r4
            r12 = r29
            r18 = 0
            r23 = 4
            r28 = -2
            r4 = r40
        L_0x07f9:
            int r8 = r8 + 1
            r4 = r7
            r29 = r12
            r7 = r39
            goto L_0x06d4
        L_0x0802:
            r4 = r40
            r12 = r29
            int r2 = r6.f1075m
            int r3 = r38.getPaddingLeft()
            int r7 = r38.getPaddingRight()
            int r7 = r7 + r3
            int r7 = r7 + r2
            r6.f1075m = r7
            r2 = r13[r27]
            r3 = -1
            if (r2 != r3) goto L_0x082c
            r7 = 0
            r8 = r13[r7]
            if (r8 != r3) goto L_0x082c
            r7 = r13[r17]
            if (r7 != r3) goto L_0x082c
            r7 = 3
            r8 = r13[r7]
            if (r8 == r3) goto L_0x0828
            goto L_0x082d
        L_0x0828:
            r32 = r5
        L_0x082a:
            r8 = 0
            goto L_0x0859
        L_0x082c:
            r7 = 3
        L_0x082d:
            r3 = r13[r7]
            r8 = 0
            r10 = r13[r8]
            r11 = r13[r17]
            int r2 = java.lang.Math.max(r2, r11)
            int r2 = java.lang.Math.max(r10, r2)
            int r2 = java.lang.Math.max(r3, r2)
            r3 = r14[r7]
            r7 = r14[r8]
            r10 = r14[r27]
            r11 = r14[r17]
            int r10 = java.lang.Math.max(r10, r11)
            int r7 = java.lang.Math.max(r7, r10)
            int r3 = java.lang.Math.max(r3, r7)
            int r3 = r3 + r2
            int r32 = java.lang.Math.max(r5, r3)
        L_0x0859:
            if (r20 != 0) goto L_0x0860
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0860
            goto L_0x0862
        L_0x0860:
            r15 = r32
        L_0x0862:
            int r2 = r38.getPaddingTop()
            int r3 = r38.getPaddingBottom()
            int r3 = r3 + r2
            int r3 = r3 + r15
            int r2 = r38.getSuggestedMinimumHeight()
            int r2 = java.lang.Math.max(r3, r2)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r3 & r1
            r0 = r0 | r3
            int r1 = r1 << 16
            int r1 = android.view.View.resolveSizeAndState(r2, r4, r1)
            r6.setMeasuredDimension(r0, r1)
            if (r24 == 0) goto L_0x08c0
            int r0 = r38.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
        L_0x088d:
            if (r8 >= r9) goto L_0x08c0
            android.view.View r1 = r6.getChildAt(r8)
            int r0 = r1.getVisibility()
            r10 = 8
            if (r0 == r10) goto L_0x08bc
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            r11 = r0
            androidx.appcompat.widget.s2 r11 = (androidx.appcompat.widget.s2) r11
            int r0 = r11.height
            r12 = -1
            if (r0 != r12) goto L_0x08bd
            int r13 = r11.width
            int r0 = r1.getMeasuredWidth()
            r11.width = r0
            r3 = 0
            r5 = 0
            r0 = r38
            r2 = r39
            r4 = r7
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            r11.width = r13
            goto L_0x08bd
        L_0x08bc:
            r12 = -1
        L_0x08bd:
            int r8 = r8 + 1
            goto L_0x088d
        L_0x08c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.t2.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z10) {
        this.f1070h = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 < 0 || i10 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1071i = i10;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f1080r) {
            this.f1080r = drawable;
            boolean z10 = false;
            if (drawable != null) {
                this.f1081s = drawable.getIntrinsicWidth();
                this.f1082t = drawable.getIntrinsicHeight();
            } else {
                this.f1081s = 0;
                this.f1082t = 0;
            }
            if (drawable == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setDividerPadding(int i10) {
        this.f1084v = i10;
    }

    public void setGravity(int i10) {
        if (this.f1074l != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f1074l = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & 8388615;
        int i12 = this.f1074l;
        if ((8388615 & i12) != i11) {
            this.f1074l = i11 | (-8388616 & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f1077o = z10;
    }

    public void setOrientation(int i10) {
        if (this.f1073k != i10) {
            this.f1073k = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f1083u) {
            requestLayout();
        }
        this.f1083u = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f1074l;
        if ((i12 & 112) != i11) {
            this.f1074l = i11 | (i12 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f1076n = Math.max(0.0f, f10);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
