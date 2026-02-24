package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import u7.a;
import u7.b;
import u7.c;
import u7.d;
import u7.e;
import u7.f;
import u7.h;
import u7.o;

public class FlexboxLayout extends ViewGroup implements a {

    /* renamed from: h  reason: collision with root package name */
    public int f3558h;

    /* renamed from: i  reason: collision with root package name */
    public int f3559i;

    /* renamed from: j  reason: collision with root package name */
    public int f3560j;

    /* renamed from: k  reason: collision with root package name */
    public int f3561k;

    /* renamed from: l  reason: collision with root package name */
    public int f3562l;

    /* renamed from: m  reason: collision with root package name */
    public int f3563m = -1;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f3564n;

    /* renamed from: o  reason: collision with root package name */
    public Drawable f3565o;

    /* renamed from: p  reason: collision with root package name */
    public int f3566p;

    /* renamed from: q  reason: collision with root package name */
    public int f3567q;

    /* renamed from: r  reason: collision with root package name */
    public int f3568r;

    /* renamed from: s  reason: collision with root package name */
    public int f3569s;

    /* renamed from: t  reason: collision with root package name */
    public int[] f3570t;

    /* renamed from: u  reason: collision with root package name */
    public SparseIntArray f3571u;

    /* renamed from: v  reason: collision with root package name */
    public final f f3572v = new f(this);

    /* renamed from: w  reason: collision with root package name */
    public List f3573w = new ArrayList();

    /* renamed from: x  reason: collision with root package name */
    public final d f3574x = new d();

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f15436a, 0, 0);
        this.f3558h = obtainStyledAttributes.getInt(5, 0);
        this.f3559i = obtainStyledAttributes.getInt(6, 0);
        this.f3560j = obtainStyledAttributes.getInt(7, 0);
        this.f3561k = obtainStyledAttributes.getInt(1, 0);
        this.f3562l = obtainStyledAttributes.getInt(0, 0);
        this.f3563m = obtainStyledAttributes.getInt(8, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(4);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i10 = obtainStyledAttributes.getInt(9, 0);
        if (i10 != 0) {
            this.f3567q = i10;
            this.f3566p = i10;
        }
        int i11 = obtainStyledAttributes.getInt(11, 0);
        if (i11 != 0) {
            this.f3567q = i11;
        }
        int i12 = obtainStyledAttributes.getInt(10, 0);
        if (i12 != 0) {
            this.f3566p = i12;
        }
        obtainStyledAttributes.recycle();
    }

    public final View a(int i10) {
        return getChildAt(i10);
    }

    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (this.f3571u == null) {
            this.f3571u = new SparseIntArray(getChildCount());
        }
        SparseIntArray sparseIntArray = this.f3571u;
        f fVar = this.f3572v;
        a aVar = fVar.f15392a;
        int flexItemCount = aVar.getFlexItemCount();
        ArrayList f10 = fVar.f(flexItemCount);
        e eVar = new e(0);
        if (view == null || !(layoutParams instanceof b)) {
            eVar.f15391i = 1;
        } else {
            eVar.f15391i = ((b) layoutParams).getOrder();
        }
        if (i10 == -1 || i10 == flexItemCount || i10 >= aVar.getFlexItemCount()) {
            eVar.f15390h = flexItemCount;
        } else {
            eVar.f15390h = i10;
            for (int i11 = i10; i11 < flexItemCount; i11++) {
                ((e) f10.get(i11)).f15390h++;
            }
        }
        f10.add(eVar);
        this.f3570t = f.r(flexItemCount + 1, f10, sparseIntArray);
        super.addView(view, i10, layoutParams);
    }

    public final int b(View view, int i10, int i11) {
        int i12;
        int i13 = 0;
        if (j()) {
            if (p(i10, i11)) {
                i13 = 0 + this.f3569s;
            }
            if ((this.f3567q & 4) <= 0) {
                return i13;
            }
            i12 = this.f3569s;
        } else {
            if (p(i10, i11)) {
                i13 = 0 + this.f3568r;
            }
            if ((this.f3566p & 4) <= 0) {
                return i13;
            }
            i12 = this.f3568r;
        }
        return i13 + i12;
    }

    public final int c(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof h;
    }

    public final void d(Canvas canvas, boolean z10, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f3573w.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) this.f3573w.get(i10);
            for (int i11 = 0; i11 < cVar.f15377h; i11++) {
                int i12 = cVar.f15384o + i11;
                View o10 = o(i12);
                if (!(o10 == null || o10.getVisibility() == 8)) {
                    h hVar = (h) o10.getLayoutParams();
                    if (p(i12, i11)) {
                        n(canvas, z10 ? o10.getRight() + hVar.rightMargin : (o10.getLeft() - hVar.leftMargin) - this.f3569s, cVar.f15371b, cVar.f15376g);
                    }
                    if (i11 == cVar.f15377h - 1 && (this.f3567q & 4) > 0) {
                        n(canvas, z10 ? (o10.getLeft() - hVar.leftMargin) - this.f3569s : o10.getRight() + hVar.rightMargin, cVar.f15371b, cVar.f15376g);
                    }
                }
            }
            if (q(i10)) {
                m(canvas, paddingLeft, z11 ? cVar.f15373d : cVar.f15371b - this.f3568r, max);
            }
            if (r(i10) && (this.f3566p & 4) > 0) {
                m(canvas, paddingLeft, z11 ? cVar.f15371b - this.f3568r : cVar.f15373d, max);
            }
        }
    }

    public final void e(View view, int i10, int i11, c cVar) {
        int i12;
        int i13;
        if (p(i10, i11)) {
            if (j()) {
                i13 = cVar.f15374e;
                i12 = this.f3569s;
            } else {
                i13 = cVar.f15374e;
                i12 = this.f3568r;
            }
            cVar.f15374e = i13 + i12;
            cVar.f15375f += i12;
        }
    }

    public final void f(c cVar) {
        int i10;
        int i11;
        if (j()) {
            if ((this.f3567q & 4) > 0) {
                i11 = cVar.f15374e;
                i10 = this.f3569s;
            } else {
                return;
            }
        } else if ((this.f3566p & 4) > 0) {
            i11 = cVar.f15374e;
            i10 = this.f3568r;
        } else {
            return;
        }
        cVar.f15374e = i11 + i10;
        cVar.f15375f += i10;
    }

    public final View g(int i10) {
        return o(i10);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new h(getContext(), attributeSet);
    }

    public int getAlignContent() {
        return this.f3562l;
    }

    public int getAlignItems() {
        return this.f3561k;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f3564n;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f3565o;
    }

    public int getFlexDirection() {
        return this.f3558h;
    }

    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<c> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f3573w.size());
        for (c cVar : this.f3573w) {
            if (cVar.f15377h - cVar.f15378i != 0) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public List<c> getFlexLinesInternal() {
        return this.f3573w;
    }

    public int getFlexWrap() {
        return this.f3559i;
    }

    public int getJustifyContent() {
        return this.f3560j;
    }

    public int getLargestMainSize() {
        int i10 = RecyclerView.UNDEFINED_DURATION;
        for (c cVar : this.f3573w) {
            i10 = Math.max(i10, cVar.f15374e);
        }
        return i10;
    }

    public int getMaxLine() {
        return this.f3563m;
    }

    public int getShowDividerHorizontal() {
        return this.f3566p;
    }

    public int getShowDividerVertical() {
        return this.f3567q;
    }

    public int getSumOfCrossSize() {
        int size = this.f3573w.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            c cVar = (c) this.f3573w.get(i11);
            if (q(i11)) {
                i10 += j() ? this.f3568r : this.f3569s;
            }
            if (r(i11)) {
                i10 += j() ? this.f3568r : this.f3569s;
            }
            i10 += cVar.f15376g;
        }
        return i10;
    }

    public final void h(View view, int i10) {
    }

    public final int i(int i10, int i11, int i12) {
        return ViewGroup.getChildMeasureSpec(i10, i11, i12);
    }

    public final boolean j() {
        int i10 = this.f3558h;
        return i10 == 0 || i10 == 1;
    }

    public final int k(View view) {
        return 0;
    }

    public final void l(Canvas canvas, boolean z10, boolean z11) {
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f3573w.size();
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = (c) this.f3573w.get(i10);
            for (int i11 = 0; i11 < cVar.f15377h; i11++) {
                int i12 = cVar.f15384o + i11;
                View o10 = o(i12);
                if (!(o10 == null || o10.getVisibility() == 8)) {
                    h hVar = (h) o10.getLayoutParams();
                    if (p(i12, i11)) {
                        m(canvas, cVar.f15370a, z11 ? o10.getBottom() + hVar.bottomMargin : (o10.getTop() - hVar.topMargin) - this.f3568r, cVar.f15376g);
                    }
                    if (i11 == cVar.f15377h - 1 && (this.f3566p & 4) > 0) {
                        m(canvas, cVar.f15370a, z11 ? (o10.getTop() - hVar.topMargin) - this.f3568r : o10.getBottom() + hVar.bottomMargin, cVar.f15376g);
                    }
                }
            }
            if (q(i10)) {
                n(canvas, z10 ? cVar.f15372c : cVar.f15370a - this.f3569s, paddingTop, max);
            }
            if (r(i10) && (this.f3567q & 4) > 0) {
                n(canvas, z10 ? cVar.f15370a - this.f3569s : cVar.f15372c, paddingTop, max);
            }
        }
    }

    public final void m(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f3564n;
        if (drawable != null) {
            drawable.setBounds(i10, i11, i12 + i10, this.f3568r + i11);
            this.f3564n.draw(canvas);
        }
    }

    public final void n(Canvas canvas, int i10, int i11, int i12) {
        Drawable drawable = this.f3565o;
        if (drawable != null) {
            drawable.setBounds(i10, i11, this.f3569s + i10, i12 + i11);
            this.f3565o.draw(canvas);
        }
    }

    public final View o(int i10) {
        if (i10 < 0) {
            return null;
        }
        int[] iArr = this.f3570t;
        if (i10 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i10]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0049, code lost:
        if (r6.f3559i == 2) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0053, code lost:
        if (r6.f3559i == 2) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.f3565o
            if (r0 != 0) goto L_0x0009
            android.graphics.drawable.Drawable r0 = r6.f3564n
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            int r0 = r6.f3566p
            if (r0 != 0) goto L_0x0012
            int r0 = r6.f3567q
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.util.WeakHashMap r0 = m0.c1.f10054a
            int r0 = m0.j0.d(r6)
            int r1 = r6.f3558h
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x004c
            if (r1 == r4) goto L_0x0042
            if (r1 == r2) goto L_0x0034
            r5 = 3
            if (r1 == r5) goto L_0x0027
            goto L_0x0059
        L_0x0027:
            if (r0 != r4) goto L_0x002a
            r3 = 1
        L_0x002a:
            int r0 = r6.f3559i
            if (r0 != r2) goto L_0x0030
            r3 = r3 ^ 1
        L_0x0030:
            r6.l(r7, r3, r4)
            goto L_0x0059
        L_0x0034:
            if (r0 != r4) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r4 = 0
        L_0x0038:
            int r0 = r6.f3559i
            if (r0 != r2) goto L_0x003e
            r4 = r4 ^ 1
        L_0x003e:
            r6.l(r7, r4, r3)
            goto L_0x0059
        L_0x0042:
            if (r0 == r4) goto L_0x0046
            r0 = 1
            goto L_0x0047
        L_0x0046:
            r0 = 0
        L_0x0047:
            int r1 = r6.f3559i
            if (r1 != r2) goto L_0x0056
            goto L_0x0055
        L_0x004c:
            if (r0 != r4) goto L_0x0050
            r0 = 1
            goto L_0x0051
        L_0x0050:
            r0 = 0
        L_0x0051:
            int r1 = r6.f3559i
            if (r1 != r2) goto L_0x0056
        L_0x0055:
            r3 = 1
        L_0x0056:
            r6.d(r7, r0, r3)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        if (r0 != 1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        if (r0 == 1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            java.util.WeakHashMap r0 = m0.c1.f10054a
            int r0 = m0.j0.d(r7)
            int r1 = r7.f3558h
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0051
            if (r1 == r3) goto L_0x004e
            r4 = 2
            if (r1 == r4) goto L_0x0038
            r5 = 3
            if (r1 != r5) goto L_0x0022
            if (r0 != r3) goto L_0x0017
            r2 = 1
        L_0x0017:
            int r0 = r7.f3559i
            if (r0 != r4) goto L_0x001f
            r0 = r2 ^ 1
            r5 = r0
            goto L_0x0020
        L_0x001f:
            r5 = r2
        L_0x0020:
            r6 = 1
            goto L_0x0045
        L_0x0022:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid flex direction is set: "
            r1.<init>(r2)
            int r2 = r7.f3558h
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0038:
            if (r0 != r3) goto L_0x003b
            r2 = 1
        L_0x003b:
            int r0 = r7.f3559i
            if (r0 != r4) goto L_0x0043
            r0 = r2 ^ 1
            r5 = r0
            goto L_0x0044
        L_0x0043:
            r5 = r2
        L_0x0044:
            r6 = 0
        L_0x0045:
            r0 = r7
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.t(r1, r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004e:
            if (r0 == r3) goto L_0x0055
            goto L_0x0053
        L_0x0051:
            if (r0 != r3) goto L_0x0055
        L_0x0053:
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            r0 = r7
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r0.s(r1, r2, r3, r4, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r9 = r17
            r10 = r18
            android.util.SparseIntArray r1 = r0.f3571u
            if (r1 != 0) goto L_0x0015
            android.util.SparseIntArray r1 = new android.util.SparseIntArray
            int r2 = r16.getChildCount()
            r1.<init>(r2)
            r0.f3571u = r1
        L_0x0015:
            android.util.SparseIntArray r1 = r0.f3571u
            u7.f r11 = r0.f3572v
            u7.a r2 = r11.f15392a
            int r3 = r2.getFlexItemCount()
            int r4 = r1.size()
            r5 = 1
            r12 = 0
            if (r4 == r3) goto L_0x0028
            goto L_0x0042
        L_0x0028:
            r4 = 0
        L_0x0029:
            if (r4 >= r3) goto L_0x0047
            android.view.View r6 = r2.a(r4)
            if (r6 != 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            u7.b r6 = (u7.b) r6
            int r6 = r6.getOrder()
            int r7 = r1.get(r4)
            if (r6 == r7) goto L_0x0044
        L_0x0042:
            r1 = 1
            goto L_0x0048
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0047:
            r1 = 0
        L_0x0048:
            if (r1 == 0) goto L_0x005c
            android.util.SparseIntArray r1 = r0.f3571u
            u7.a r2 = r11.f15392a
            int r2 = r2.getFlexItemCount()
            java.util.ArrayList r3 = r11.f(r2)
            int[] r1 = u7.f.r(r2, r3, r1)
            r0.f3570t = r1
        L_0x005c:
            int r1 = r0.f3558h
            r2 = 0
            u7.d r13 = r0.f3574x
            r14 = 3
            r15 = 2
            if (r1 == 0) goto L_0x00bb
            if (r1 == r5) goto L_0x00bb
            if (r1 == r15) goto L_0x0082
            if (r1 != r14) goto L_0x006c
            goto L_0x0082
        L_0x006c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid value for the flex direction is set: "
            r2.<init>(r3)
            int r3 = r0.f3558h
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0082:
            java.util.List r1 = r0.f3573w
            r1.clear()
            r13.f15388a = r2
            r13.f15389b = r12
            u7.f r1 = r0.f3572v
            u7.d r2 = r0.f3574x
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
            r7 = -1
            r8 = 0
            r3 = r18
            r4 = r17
            r1.b(r2, r3, r4, r5, r6, r7, r8)
            java.util.List r1 = r13.f15388a
            r0.f3573w = r1
            r11.h(r9, r10, r12)
            int r1 = r16.getPaddingLeft()
            int r2 = r16.getPaddingRight()
            int r2 = r2 + r1
            r11.g(r9, r10, r2)
            r11.u(r12)
            int r1 = r0.f3558h
            int r2 = r13.f15389b
            r0.u(r1, r9, r10, r2)
            goto L_0x0165
        L_0x00bb:
            java.util.List r1 = r0.f3573w
            r1.clear()
            r13.f15388a = r2
            r13.f15389b = r12
            u7.f r1 = r0.f3572v
            u7.d r2 = r0.f3574x
            r5 = 2147483647(0x7fffffff, float:NaN)
            r6 = 0
            r7 = -1
            r8 = 0
            r3 = r17
            r4 = r18
            r1.b(r2, r3, r4, r5, r6, r7, r8)
            java.util.List r1 = r13.f15388a
            r0.f3573w = r1
            r11.h(r9, r10, r12)
            int r1 = r0.f3561k
            if (r1 != r14) goto L_0x014f
            java.util.List r1 = r0.f3573w
            java.util.Iterator r1 = r1.iterator()
        L_0x00e6:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x014f
            java.lang.Object r2 = r1.next()
            u7.c r2 = (u7.c) r2
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
        L_0x00f5:
            int r5 = r2.f15377h
            if (r4 >= r5) goto L_0x014c
            int r5 = r2.f15384o
            int r5 = r5 + r4
            android.view.View r5 = r0.o(r5)
            if (r5 == 0) goto L_0x0149
            int r6 = r5.getVisibility()
            r7 = 8
            if (r6 != r7) goto L_0x010b
            goto L_0x0149
        L_0x010b:
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            u7.h r6 = (u7.h) r6
            int r7 = r0.f3559i
            if (r7 == r15) goto L_0x012b
            int r7 = r2.f15381l
            int r8 = r5.getBaseline()
            int r7 = r7 - r8
            int r8 = r6.topMargin
            int r7 = java.lang.Math.max(r7, r8)
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r7
            int r6 = r6.bottomMargin
            int r5 = r5 + r6
            goto L_0x0145
        L_0x012b:
            int r7 = r2.f15381l
            int r8 = r5.getMeasuredHeight()
            int r7 = r7 - r8
            int r8 = r5.getBaseline()
            int r8 = r8 + r7
            int r7 = r6.bottomMargin
            int r7 = java.lang.Math.max(r8, r7)
            int r5 = r5.getMeasuredHeight()
            int r6 = r6.topMargin
            int r5 = r5 + r6
            int r5 = r5 + r7
        L_0x0145:
            int r3 = java.lang.Math.max(r3, r5)
        L_0x0149:
            int r4 = r4 + 1
            goto L_0x00f5
        L_0x014c:
            r2.f15376g = r3
            goto L_0x00e6
        L_0x014f:
            int r1 = r16.getPaddingTop()
            int r2 = r16.getPaddingBottom()
            int r2 = r2 + r1
            r11.g(r9, r10, r2)
            r11.u(r12)
            int r1 = r0.f3558h
            int r2 = r13.f15389b
            r0.u(r1, r9, r10, r2)
        L_0x0165:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onMeasure(int, int):void");
    }

    public final boolean p(int i10, int i11) {
        boolean z10;
        int i12 = 1;
        while (true) {
            if (i12 > i11) {
                z10 = true;
                break;
            }
            View o10 = o(i10 - i12);
            if (o10 != null && o10.getVisibility() != 8) {
                z10 = false;
                break;
            }
            i12++;
        }
        if (z10) {
            if (j()) {
                if ((this.f3567q & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.f3566p & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (j()) {
            if ((this.f3567q & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.f3566p & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean q(int i10) {
        boolean z10;
        if (i10 < 0 || i10 >= this.f3573w.size()) {
            return false;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                z10 = true;
                break;
            }
            c cVar = (c) this.f3573w.get(i11);
            if (cVar.f15377h - cVar.f15378i > 0) {
                z10 = false;
                break;
            }
            i11++;
        }
        if (z10) {
            if (j()) {
                if ((this.f3566p & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.f3567q & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (j()) {
            if ((this.f3566p & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.f3567q & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean r(int i10) {
        if (i10 < 0 || i10 >= this.f3573w.size()) {
            return false;
        }
        for (int i11 = i10 + 1; i11 < this.f3573w.size(); i11++) {
            c cVar = (c) this.f3573w.get(i11);
            if (cVar.f15377h - cVar.f15378i > 0) {
                return false;
            }
        }
        if (j()) {
            if ((this.f3566p & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.f3567q & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(int r29, int r30, int r31, int r32, boolean r33) {
        /*
            r28 = this;
            r0 = r28
            int r1 = r28.getPaddingLeft()
            int r2 = r28.getPaddingRight()
            int r3 = r32 - r30
            int r4 = r31 - r29
            int r5 = r28.getPaddingBottom()
            int r3 = r3 - r5
            int r5 = r28.getPaddingTop()
            java.util.List r6 = r0.f3573w
            int r6 = r6.size()
            r8 = 0
        L_0x001e:
            if (r8 >= r6) goto L_0x01ff
            java.util.List r9 = r0.f3573w
            java.lang.Object r9 = r9.get(r8)
            u7.c r9 = (u7.c) r9
            boolean r10 = r0.q(r8)
            if (r10 == 0) goto L_0x0032
            int r10 = r0.f3568r
            int r3 = r3 - r10
            int r5 = r5 + r10
        L_0x0032:
            int r10 = r0.f3560j
            r15 = 4
            r14 = 2
            r11 = 0
            r13 = 1
            if (r10 == 0) goto L_0x00c6
            if (r10 == r13) goto L_0x00bc
            r12 = 1073741824(0x40000000, float:2.0)
            if (r10 == r14) goto L_0x00aa
            r7 = 3
            if (r10 == r7) goto L_0x0091
            if (r10 == r15) goto L_0x0077
            r7 = 5
            if (r10 != r7) goto L_0x0061
            int r7 = r9.f15377h
            int r10 = r9.f15378i
            int r7 = r7 - r10
            if (r7 == 0) goto L_0x0059
            int r10 = r9.f15374e
            int r10 = r4 - r10
            float r10 = (float) r10
            int r7 = r7 + 1
            float r7 = (float) r7
            float r10 = r10 / r7
            goto L_0x005a
        L_0x0059:
            r10 = 0
        L_0x005a:
            float r7 = (float) r1
            float r7 = r7 + r10
            int r12 = r4 - r2
            float r12 = (float) r12
            float r12 = r12 - r10
            goto L_0x00cb
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f3560j
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0077:
            int r7 = r9.f15377h
            int r10 = r9.f15378i
            int r7 = r7 - r10
            if (r7 == 0) goto L_0x0086
            int r10 = r9.f15374e
            int r10 = r4 - r10
            float r10 = (float) r10
            float r7 = (float) r7
            float r10 = r10 / r7
            goto L_0x0087
        L_0x0086:
            r10 = 0
        L_0x0087:
            float r7 = (float) r1
            float r12 = r10 / r12
            float r7 = r7 + r12
            int r14 = r4 - r2
            float r14 = (float) r14
            float r12 = r14 - r12
            goto L_0x00cb
        L_0x0091:
            float r7 = (float) r1
            int r10 = r9.f15377h
            int r12 = r9.f15378i
            int r10 = r10 - r12
            if (r10 == r13) goto L_0x009d
            int r10 = r10 + -1
            float r10 = (float) r10
            goto L_0x009f
        L_0x009d:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x009f:
            int r12 = r9.f15374e
            int r12 = r4 - r12
            float r12 = (float) r12
            float r10 = r12 / r10
            int r12 = r4 - r2
            float r12 = (float) r12
            goto L_0x00cb
        L_0x00aa:
            float r7 = (float) r1
            int r10 = r9.f15374e
            int r14 = r4 - r10
            float r14 = (float) r14
            float r14 = r14 / r12
            float r7 = r7 + r14
            int r14 = r4 - r2
            float r14 = (float) r14
            int r10 = r4 - r10
            float r10 = (float) r10
            float r10 = r10 / r12
            float r12 = r14 - r10
            goto L_0x00ca
        L_0x00bc:
            int r7 = r9.f15374e
            int r10 = r4 - r7
            int r10 = r10 + r2
            float r10 = (float) r10
            int r7 = r7 - r1
            float r12 = (float) r7
            r7 = r10
            goto L_0x00ca
        L_0x00c6:
            float r7 = (float) r1
            int r10 = r4 - r2
            float r12 = (float) r10
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            float r17 = java.lang.Math.max(r10, r11)
            r14 = 0
        L_0x00d0:
            int r10 = r9.f15377h
            if (r14 >= r10) goto L_0x01f3
            int r10 = r9.f15384o
            int r10 = r10 + r14
            android.view.View r18 = r0.o(r10)
            if (r18 == 0) goto L_0x01e1
            int r11 = r18.getVisibility()
            r15 = 8
            if (r11 != r15) goto L_0x00e7
            goto L_0x01e1
        L_0x00e7:
            android.view.ViewGroup$LayoutParams r11 = r18.getLayoutParams()
            r15 = r11
            u7.h r15 = (u7.h) r15
            int r11 = r15.leftMargin
            float r11 = (float) r11
            float r7 = r7 + r11
            int r11 = r15.rightMargin
            float r11 = (float) r11
            float r12 = r12 - r11
            boolean r10 = r0.p(r10, r14)
            if (r10 == 0) goto L_0x0106
            int r10 = r0.f3569s
            float r11 = (float) r10
            float r7 = r7 + r11
            float r12 = r12 - r11
            r20 = r10
            r19 = r12
            goto L_0x010a
        L_0x0106:
            r19 = r12
            r20 = 0
        L_0x010a:
            int r10 = r9.f15377h
            int r10 = r10 - r13
            if (r14 != r10) goto L_0x011c
            int r10 = r0.f3567q
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x011e
            int r10 = r0.f3569s
            r21 = r10
            goto L_0x0120
        L_0x011c:
            r16 = 4
        L_0x011e:
            r21 = 0
        L_0x0120:
            int r10 = r0.f3559i
            r12 = 2
            if (r10 != r12) goto L_0x0179
            if (r33 == 0) goto L_0x0152
            u7.f r10 = r0.f3572v
            int r11 = java.lang.Math.round(r19)
            int r22 = r18.getMeasuredWidth()
            int r22 = r11 - r22
            int r11 = r18.getMeasuredHeight()
            int r23 = r3 - r11
            int r24 = java.lang.Math.round(r19)
            r11 = r18
            r25 = 2
            r12 = r9
            r26 = 1
            r13 = r22
            r22 = r14
            r14 = r23
            r23 = r1
            r1 = r15
            r27 = 4
            r15 = r24
            goto L_0x0176
        L_0x0152:
            r23 = r1
            r22 = r14
            r1 = r15
            r25 = 2
            r26 = 1
            r27 = 4
            u7.f r10 = r0.f3572v
            int r13 = java.lang.Math.round(r7)
            int r11 = r18.getMeasuredHeight()
            int r14 = r3 - r11
            int r11 = java.lang.Math.round(r7)
            int r12 = r18.getMeasuredWidth()
            int r15 = r12 + r11
            r11 = r18
            r12 = r9
        L_0x0176:
            r16 = r3
            goto L_0x01af
        L_0x0179:
            r23 = r1
            r22 = r14
            r1 = r15
            r25 = 2
            r26 = 1
            r27 = 4
            u7.f r10 = r0.f3572v
            if (r33 == 0) goto L_0x0197
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredWidth()
            int r13 = r11 - r12
            int r15 = java.lang.Math.round(r19)
            goto L_0x01a5
        L_0x0197:
            int r13 = java.lang.Math.round(r7)
            int r11 = java.lang.Math.round(r7)
            int r12 = r18.getMeasuredWidth()
            int r15 = r12 + r11
        L_0x01a5:
            int r11 = r18.getMeasuredHeight()
            int r16 = r11 + r5
            r11 = r18
            r12 = r9
            r14 = r5
        L_0x01af:
            r10.o(r11, r12, r13, r14, r15, r16)
            int r10 = r18.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r17
            int r11 = r1.rightMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r7 = r7 + r10
            int r10 = r18.getMeasuredWidth()
            float r10 = (float) r10
            float r10 = r10 + r17
            int r1 = r1.leftMargin
            float r1 = (float) r1
            float r10 = r10 + r1
            float r19 = r19 - r10
            r13 = 0
            r15 = 0
            r10 = r9
            r11 = r18
            if (r33 == 0) goto L_0x01d7
            r12 = r21
            r14 = r20
            goto L_0x01db
        L_0x01d7:
            r12 = r20
            r14 = r21
        L_0x01db:
            r10.a(r11, r12, r13, r14, r15)
            r12 = r19
            goto L_0x01eb
        L_0x01e1:
            r23 = r1
            r22 = r14
            r25 = 2
            r26 = 1
            r27 = 4
        L_0x01eb:
            int r14 = r22 + 1
            r1 = r23
            r13 = 1
            r15 = 4
            goto L_0x00d0
        L_0x01f3:
            r23 = r1
            int r1 = r9.f15376g
            int r5 = r5 + r1
            int r3 = r3 - r1
            int r8 = r8 + 1
            r1 = r23
            goto L_0x001e
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.s(int, int, int, int, boolean):void");
    }

    public void setAlignContent(int i10) {
        if (this.f3562l != i10) {
            this.f3562l = i10;
            requestLayout();
        }
    }

    public void setAlignItems(int i10) {
        if (this.f3561k != i10) {
            this.f3561k = i10;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        int i10;
        if (drawable != this.f3564n) {
            this.f3564n = drawable;
            boolean z10 = false;
            if (drawable != null) {
                i10 = drawable.getIntrinsicHeight();
            } else {
                i10 = 0;
            }
            this.f3568r = i10;
            if (this.f3564n == null && this.f3565o == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        int i10;
        if (drawable != this.f3565o) {
            this.f3565o = drawable;
            boolean z10 = false;
            if (drawable != null) {
                i10 = drawable.getIntrinsicWidth();
            } else {
                i10 = 0;
            }
            this.f3569s = i10;
            if (this.f3564n == null && this.f3565o == null) {
                z10 = true;
            }
            setWillNotDraw(z10);
            requestLayout();
        }
    }

    public void setFlexDirection(int i10) {
        if (this.f3558h != i10) {
            this.f3558h = i10;
            requestLayout();
        }
    }

    public void setFlexLines(List<c> list) {
        this.f3573w = list;
    }

    public void setFlexWrap(int i10) {
        if (this.f3559i != i10) {
            this.f3559i = i10;
            requestLayout();
        }
    }

    public void setJustifyContent(int i10) {
        if (this.f3560j != i10) {
            this.f3560j = i10;
            requestLayout();
        }
    }

    public void setMaxLine(int i10) {
        if (this.f3563m != i10) {
            this.f3563m = i10;
            requestLayout();
        }
    }

    public void setShowDivider(int i10) {
        setShowDividerVertical(i10);
        setShowDividerHorizontal(i10);
    }

    public void setShowDividerHorizontal(int i10) {
        if (i10 != this.f3566p) {
            this.f3566p = i10;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i10) {
        if (i10 != this.f3567q) {
            this.f3567q = i10;
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(int r30, int r31, int r32, int r33, boolean r34, boolean r35) {
        /*
            r29 = this;
            r0 = r29
            int r1 = r29.getPaddingTop()
            int r2 = r29.getPaddingBottom()
            int r3 = r29.getPaddingRight()
            int r4 = r29.getPaddingLeft()
            int r5 = r32 - r30
            int r6 = r33 - r31
            int r5 = r5 - r3
            java.util.List r3 = r0.f3573w
            int r3 = r3.size()
            r8 = 0
        L_0x001e:
            if (r8 >= r3) goto L_0x01fa
            java.util.List r9 = r0.f3573w
            java.lang.Object r9 = r9.get(r8)
            u7.c r9 = (u7.c) r9
            boolean r10 = r0.q(r8)
            if (r10 == 0) goto L_0x0032
            int r10 = r0.f3569s
            int r4 = r4 + r10
            int r5 = r5 - r10
        L_0x0032:
            int r10 = r0.f3560j
            r15 = 4
            r11 = 0
            r14 = 1
            if (r10 == 0) goto L_0x00c4
            if (r10 == r14) goto L_0x00bc
            r12 = 2
            r13 = 1073741824(0x40000000, float:2.0)
            if (r10 == r12) goto L_0x00a9
            r12 = 3
            if (r10 == r12) goto L_0x0091
            if (r10 == r15) goto L_0x0077
            r12 = 5
            if (r10 != r12) goto L_0x0061
            int r10 = r9.f15377h
            int r12 = r9.f15378i
            int r10 = r10 - r12
            if (r10 == 0) goto L_0x0059
            int r12 = r9.f15374e
            int r12 = r6 - r12
            float r12 = (float) r12
            int r10 = r10 + 1
            float r10 = (float) r10
            float r12 = r12 / r10
            goto L_0x005a
        L_0x0059:
            r12 = 0
        L_0x005a:
            float r10 = (float) r1
            float r10 = r10 + r12
            int r13 = r6 - r2
            float r13 = (float) r13
            float r13 = r13 - r12
            goto L_0x00c9
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.<init>(r3)
            int r3 = r0.f3560j
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0077:
            int r10 = r9.f15377h
            int r12 = r9.f15378i
            int r10 = r10 - r12
            if (r10 == 0) goto L_0x0086
            int r12 = r9.f15374e
            int r12 = r6 - r12
            float r12 = (float) r12
            float r10 = (float) r10
            float r12 = r12 / r10
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            float r10 = (float) r1
            float r13 = r12 / r13
            float r10 = r10 + r13
            int r7 = r6 - r2
            float r7 = (float) r7
            float r13 = r7 - r13
            goto L_0x00c9
        L_0x0091:
            float r10 = (float) r1
            int r7 = r9.f15377h
            int r12 = r9.f15378i
            int r7 = r7 - r12
            if (r7 == r14) goto L_0x009d
            int r7 = r7 + -1
            float r7 = (float) r7
            goto L_0x009f
        L_0x009d:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x009f:
            int r12 = r9.f15374e
            int r12 = r6 - r12
            float r12 = (float) r12
            float r12 = r12 / r7
            int r7 = r6 - r2
            float r13 = (float) r7
            goto L_0x00c9
        L_0x00a9:
            float r7 = (float) r1
            int r10 = r9.f15374e
            int r12 = r6 - r10
            float r12 = (float) r12
            float r12 = r12 / r13
            float r7 = r7 + r12
            int r12 = r6 - r2
            float r12 = (float) r12
            int r10 = r6 - r10
            float r10 = (float) r10
            float r10 = r10 / r13
            float r13 = r12 - r10
            r10 = r7
            goto L_0x00c8
        L_0x00bc:
            int r7 = r9.f15374e
            int r10 = r6 - r7
            int r10 = r10 + r2
            float r10 = (float) r10
            int r7 = r7 - r1
            goto L_0x00c7
        L_0x00c4:
            float r10 = (float) r1
            int r7 = r6 - r2
        L_0x00c7:
            float r13 = (float) r7
        L_0x00c8:
            r12 = 0
        L_0x00c9:
            float r7 = java.lang.Math.max(r12, r11)
            r12 = 0
        L_0x00ce:
            int r11 = r9.f15377h
            if (r12 >= r11) goto L_0x01f2
            int r11 = r9.f15384o
            int r11 = r11 + r12
            android.view.View r18 = r0.o(r11)
            if (r18 == 0) goto L_0x01e6
            int r15 = r18.getVisibility()
            r14 = 8
            if (r15 != r14) goto L_0x00e5
            goto L_0x01e6
        L_0x00e5:
            android.view.ViewGroup$LayoutParams r14 = r18.getLayoutParams()
            r15 = r14
            u7.h r15 = (u7.h) r15
            int r14 = r15.topMargin
            float r14 = (float) r14
            float r10 = r10 + r14
            int r14 = r15.bottomMargin
            float r14 = (float) r14
            float r13 = r13 - r14
            boolean r11 = r0.p(r11, r12)
            if (r11 == 0) goto L_0x0106
            int r11 = r0.f3568r
            float r14 = (float) r11
            float r10 = r10 + r14
            float r13 = r13 - r14
            r19 = r10
            r21 = r11
            r20 = r13
            goto L_0x010c
        L_0x0106:
            r19 = r10
            r20 = r13
            r21 = 0
        L_0x010c:
            int r10 = r9.f15377h
            r14 = 1
            int r10 = r10 - r14
            if (r12 != r10) goto L_0x011f
            int r10 = r0.f3566p
            r16 = 4
            r10 = r10 & 4
            if (r10 <= 0) goto L_0x0121
            int r10 = r0.f3568r
            r22 = r10
            goto L_0x0123
        L_0x011f:
            r16 = 4
        L_0x0121:
            r22 = 0
        L_0x0123:
            if (r34 == 0) goto L_0x0177
            if (r35 == 0) goto L_0x0152
            u7.f r10 = r0.f3572v
            r13 = 1
            int r11 = r18.getMeasuredWidth()
            int r17 = r5 - r11
            int r11 = java.lang.Math.round(r20)
            int r23 = r18.getMeasuredHeight()
            int r23 = r11 - r23
            int r24 = java.lang.Math.round(r20)
            r11 = r18
            r25 = r12
            r12 = r9
            r26 = 1
            r14 = r17
            r27 = r15
            r28 = 4
            r15 = r23
            r16 = r5
            r17 = r24
            goto L_0x01b1
        L_0x0152:
            r25 = r12
            r27 = r15
            r26 = 1
            r28 = 4
            u7.f r10 = r0.f3572v
            r13 = 1
            int r11 = r18.getMeasuredWidth()
            int r14 = r5 - r11
            int r15 = java.lang.Math.round(r19)
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r12 + r11
            r11 = r18
            r12 = r9
            r16 = r5
            goto L_0x01b1
        L_0x0177:
            r25 = r12
            r27 = r15
            r26 = 1
            r28 = 4
            u7.f r10 = r0.f3572v
            r13 = 0
            if (r35 == 0) goto L_0x0199
            int r11 = java.lang.Math.round(r20)
            int r12 = r18.getMeasuredHeight()
            int r15 = r11 - r12
            int r11 = r18.getMeasuredWidth()
            int r16 = r11 + r4
            int r17 = java.lang.Math.round(r20)
            goto L_0x01ad
        L_0x0199:
            int r15 = java.lang.Math.round(r19)
            int r11 = r18.getMeasuredWidth()
            int r16 = r11 + r4
            int r11 = java.lang.Math.round(r19)
            int r12 = r18.getMeasuredHeight()
            int r17 = r12 + r11
        L_0x01ad:
            r11 = r18
            r12 = r9
            r14 = r4
        L_0x01b1:
            r10.p(r11, r12, r13, r14, r15, r16, r17)
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            r14 = r27
            int r11 = r14.bottomMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r16 = r10 + r19
            int r10 = r18.getMeasuredHeight()
            float r10 = (float) r10
            float r10 = r10 + r7
            int r11 = r14.topMargin
            float r11 = (float) r11
            float r10 = r10 + r11
            float r20 = r20 - r10
            r12 = 0
            r14 = 0
            r10 = r9
            r11 = r18
            if (r35 == 0) goto L_0x01da
            r13 = r22
            r15 = r21
            goto L_0x01de
        L_0x01da:
            r13 = r21
            r15 = r22
        L_0x01de:
            r10.a(r11, r12, r13, r14, r15)
            r10 = r16
            r13 = r20
            goto L_0x01ec
        L_0x01e6:
            r25 = r12
            r26 = 1
            r28 = 4
        L_0x01ec:
            int r12 = r25 + 1
            r14 = 1
            r15 = 4
            goto L_0x00ce
        L_0x01f2:
            int r7 = r9.f15376g
            int r4 = r4 + r7
            int r5 = r5 - r7
            int r8 = r8 + 1
            goto L_0x001e
        L_0x01fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.t(int, int, int, int, boolean, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        if (r1 < r4) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r3 < r9) goto L_0x0097;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r10)
            int r1 = android.view.View.MeasureSpec.getSize(r10)
            int r2 = android.view.View.MeasureSpec.getMode(r11)
            int r3 = android.view.View.MeasureSpec.getSize(r11)
            if (r9 == 0) goto L_0x003b
            r4 = 1
            if (r9 == r4) goto L_0x003b
            r4 = 2
            if (r9 == r4) goto L_0x0028
            r4 = 3
            if (r9 != r4) goto L_0x001c
            goto L_0x0028
        L_0x001c:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Invalid flex direction: "
            java.lang.String r9 = android.support.v4.media.h.i(r11, r9)
            r10.<init>(r9)
            throw r10
        L_0x0028:
            int r9 = r8.getLargestMainSize()
            int r4 = r8.getSumOfCrossSize()
            int r5 = r8.getPaddingLeft()
            int r5 = r5 + r4
            int r4 = r8.getPaddingRight()
            int r4 = r4 + r5
            goto L_0x004d
        L_0x003b:
            int r9 = r8.getSumOfCrossSize()
            int r4 = r8.getPaddingTop()
            int r4 = r4 + r9
            int r9 = r8.getPaddingBottom()
            int r9 = r9 + r4
            int r4 = r8.getLargestMainSize()
        L_0x004d:
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r7) goto L_0x006d
            if (r0 == 0) goto L_0x0068
            if (r0 != r6) goto L_0x005c
            if (r1 >= r4) goto L_0x0075
            goto L_0x006f
        L_0x005c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Unknown width mode is set: "
            java.lang.String r10 = android.support.v4.media.h.i(r10, r0)
            r9.<init>(r10)
            throw r9
        L_0x0068:
            int r10 = android.view.View.resolveSizeAndState(r4, r10, r12)
            goto L_0x0079
        L_0x006d:
            if (r1 >= r4) goto L_0x0074
        L_0x006f:
            int r12 = android.view.View.combineMeasuredStates(r12, r5)
            goto L_0x0075
        L_0x0074:
            r1 = r4
        L_0x0075:
            int r10 = android.view.View.resolveSizeAndState(r1, r10, r12)
        L_0x0079:
            r0 = 256(0x100, float:3.59E-43)
            if (r2 == r7) goto L_0x0095
            if (r2 == 0) goto L_0x0090
            if (r2 != r6) goto L_0x0084
            if (r3 >= r9) goto L_0x009d
            goto L_0x0097
        L_0x0084:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Unknown height mode is set: "
            java.lang.String r10 = android.support.v4.media.h.i(r10, r2)
            r9.<init>(r10)
            throw r9
        L_0x0090:
            int r9 = android.view.View.resolveSizeAndState(r9, r11, r12)
            goto L_0x00a1
        L_0x0095:
            if (r3 >= r9) goto L_0x009c
        L_0x0097:
            int r12 = android.view.View.combineMeasuredStates(r12, r0)
            goto L_0x009d
        L_0x009c:
            r3 = r9
        L_0x009d:
            int r9 = android.view.View.resolveSizeAndState(r3, r11, r12)
        L_0x00a1:
            r8.setMeasuredDimension(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.u(int, int, int, int):void");
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof h) {
            return new h((h) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new h((ViewGroup.MarginLayoutParams) layoutParams) : new h(layoutParams);
    }
}
