package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.recyclerview.widget.RecyclerView;
import e.a;
import m.b0;
import m.c0;
import m.e0;
import m.m;
import m.n;
import m.o;
import m.q;

public class ActionMenuView extends t2 implements n, e0 {
    public n A;
    public b0 B;
    public m C;
    public boolean D;
    public int E;
    public final int F;
    public final int G;
    public r H;

    /* renamed from: w  reason: collision with root package name */
    public o f623w;

    /* renamed from: x  reason: collision with root package name */
    public Context f624x;

    /* renamed from: y  reason: collision with root package name */
    public int f625y = 0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f626z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.F = (int) (56.0f * f10);
        this.G = (int) (f10 * 4.0f);
        this.f624x = context;
    }

    public static q l(ViewGroup.LayoutParams layoutParams) {
        q qVar;
        if (layoutParams != null) {
            if (layoutParams instanceof q) {
                qVar = new q((q) layoutParams);
            } else {
                qVar = new q(layoutParams);
            }
            if (qVar.gravity <= 0) {
                qVar.gravity = 16;
            }
            return qVar;
        }
        q qVar2 = new q();
        qVar2.gravity = 16;
        return qVar2;
    }

    public final void c(o oVar) {
        this.f623w = oVar;
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof q;
    }

    public final boolean d(q qVar) {
        return this.f623w.q(qVar, (c0) null, 0);
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        q qVar = new q();
        qVar.gravity = 16;
        return qVar;
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new q(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.f623w == null) {
            Context context = getContext();
            o oVar = new o(context);
            this.f623w = oVar;
            oVar.f9976e = new a(5, (Object) this);
            n nVar = new n(context);
            this.A = nVar;
            nVar.f956t = true;
            nVar.f957u = true;
            b0 b0Var = this.B;
            if (b0Var == null) {
                b0Var = new p();
            }
            nVar.f948l = b0Var;
            this.f623w.b(this.A, this.f624x);
            n nVar2 = this.A;
            nVar2.f951o = this;
            this.f623w = nVar2.f946j;
        }
        return this.f623w;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        n nVar = this.A;
        k kVar = nVar.f953q;
        if (kVar != null) {
            return kVar.getDrawable();
        }
        if (nVar.f955s) {
            return nVar.f954r;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f625y;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final s2 h() {
        q qVar = new q();
        qVar.gravity = 16;
        return qVar;
    }

    public final s2 i(AttributeSet attributeSet) {
        return new q(getContext(), attributeSet);
    }

    public final /* bridge */ /* synthetic */ s2 j(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public final boolean m(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof o)) {
            z10 = false | ((o) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof o)) ? z10 : z10 | ((o) childAt2).c();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n nVar = this.A;
        if (nVar != null) {
            nVar.e(false);
            if (this.A.f()) {
                this.A.d();
                this.A.n();
            }
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.A;
        if (nVar != null) {
            nVar.d();
            h hVar = nVar.B;
            if (hVar != null && hVar.b()) {
                hVar.f9899j.dismiss();
            }
        }
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (!this.D) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i16 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i17 = i12 - i10;
        int paddingRight = (i17 - getPaddingRight()) - getPaddingLeft();
        boolean a10 = l5.a(this);
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                q qVar = (q) childAt.getLayoutParams();
                if (qVar.f991a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m(i20)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a10) {
                        i14 = getPaddingLeft() + qVar.leftMargin;
                        i15 = i14 + measuredWidth;
                    } else {
                        i15 = (getWidth() - getPaddingRight()) - qVar.rightMargin;
                        i14 = i15 - measuredWidth;
                    }
                    int i21 = i16 - (measuredHeight / 2);
                    childAt.layout(i14, i21, i15, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i18 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + qVar.leftMargin) + qVar.rightMargin;
                    m(i20);
                    i19++;
                }
            }
        }
        if (childCount == 1 && i18 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i17 / 2) - (measuredWidth2 / 2);
            int i23 = i16 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i19 - (i18 ^ 1);
        int max = Math.max(0, i24 > 0 ? paddingRight / i24 : 0);
        if (a10) {
            int width = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                q qVar2 = (q) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !qVar2.f991a) {
                    int i26 = width - qVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i16 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width = i26 - ((measuredWidth3 + qVar2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            q qVar3 = (q) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !qVar3.f991a) {
                int i29 = paddingLeft + qVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i30 = i16 - (measuredHeight4 / 2);
                childAt4.layout(i29, i30, i29 + measuredWidth4, measuredHeight4 + i30);
                paddingLeft = measuredWidth4 + qVar3.rightMargin + max + i29;
            }
        }
    }

    public final void onMeasure(int i10, int i11) {
        boolean z10;
        int i12;
        boolean z11;
        boolean z12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z15;
        int i18;
        int i19;
        boolean z16;
        int i20;
        ActionMenuItemView actionMenuItemView;
        boolean z17;
        int i21;
        boolean z18;
        o oVar;
        boolean z19 = this.D;
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.D = z10;
        if (z19 != z10) {
            this.E = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.D || (oVar = this.f623w) == null || size == this.E)) {
            this.E = size;
            oVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.D || childCount <= 0) {
            int i22 = i11;
            for (int i23 = 0; i23 < childCount; i23++) {
                q qVar = (q) getChildAt(i23).getLayoutParams();
                qVar.rightMargin = 0;
                qVar.leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i10);
        int size3 = View.MeasureSpec.getSize(i11);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingBottom, -2);
        int i24 = size2 - paddingRight;
        int i25 = this.F;
        int i26 = i24 / i25;
        int i27 = i24 % i25;
        if (i26 == 0) {
            setMeasuredDimension(i24, 0);
            return;
        }
        int i28 = (i27 / i26) + i25;
        int childCount2 = getChildCount();
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        boolean z20 = false;
        long j10 = 0;
        int i33 = 0;
        while (true) {
            i12 = this.G;
            if (i32 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i32);
            int i34 = size3;
            int i35 = i24;
            if (childAt.getVisibility() == 8) {
                i18 = mode;
                i19 = paddingBottom;
            } else {
                boolean z21 = childAt instanceof ActionMenuItemView;
                int i36 = i30 + 1;
                if (z21) {
                    childAt.setPadding(i12, 0, i12, 0);
                }
                q qVar2 = (q) childAt.getLayoutParams();
                qVar2.f996f = false;
                qVar2.f993c = 0;
                qVar2.f992b = 0;
                qVar2.f994d = false;
                qVar2.leftMargin = 0;
                qVar2.rightMargin = 0;
                if (!z21 || !((ActionMenuItemView) childAt).l()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                qVar2.f995e = z16;
                if (qVar2.f991a) {
                    i20 = 1;
                } else {
                    i20 = i26;
                }
                int i37 = i36;
                q qVar3 = (q) childAt.getLayoutParams();
                i18 = mode;
                i19 = paddingBottom;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                if (z21) {
                    actionMenuItemView = (ActionMenuItemView) childAt;
                } else {
                    actionMenuItemView = null;
                }
                if (actionMenuItemView == null || !actionMenuItemView.l()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (i20 <= 0 || (z17 && i20 < 2)) {
                    i21 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i20 * i28, RecyclerView.UNDEFINED_DURATION), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i21 = measuredWidth / i28;
                    if (measuredWidth % i28 != 0) {
                        i21++;
                    }
                    if (z17 && i21 < 2) {
                        i21 = 2;
                    }
                }
                if (qVar3.f991a || !z17) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                qVar3.f994d = z18;
                qVar3.f992b = i21;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i28 * i21, 1073741824), makeMeasureSpec);
                i31 = Math.max(i31, i21);
                if (qVar2.f994d) {
                    i33++;
                }
                if (qVar2.f991a) {
                    z20 = true;
                }
                i26 -= i21;
                i29 = Math.max(i29, childAt.getMeasuredHeight());
                if (i21 == 1) {
                    j10 |= (long) (1 << i32);
                }
                i30 = i37;
            }
            i32++;
            size3 = i34;
            i24 = i35;
            paddingBottom = i19;
            mode = i18;
        }
        int i38 = mode;
        int i39 = i24;
        int i40 = size3;
        if (!z20 || i30 != 2) {
            z11 = false;
        } else {
            z11 = true;
        }
        boolean z22 = false;
        while (true) {
            if (i33 <= 0 || i26 <= 0) {
                z12 = z22;
            } else {
                int i41 = Integer.MAX_VALUE;
                int i42 = 0;
                int i43 = 0;
                long j11 = 0;
                while (i43 < childCount2) {
                    q qVar4 = (q) getChildAt(i43).getLayoutParams();
                    boolean z23 = z22;
                    if (qVar4.f994d) {
                        int i44 = qVar4.f992b;
                        if (i44 < i41) {
                            j11 = 1 << i43;
                            i41 = i44;
                            i42 = 1;
                        } else if (i44 == i41) {
                            j11 |= 1 << i43;
                            i42++;
                        }
                    }
                    i43++;
                    z22 = z23;
                }
                z12 = z22;
                j10 |= j11;
                if (i42 > i26) {
                    break;
                }
                int i45 = i41 + 1;
                int i46 = 0;
                while (i46 < childCount2) {
                    View childAt2 = getChildAt(i46);
                    q qVar5 = (q) childAt2.getLayoutParams();
                    int i47 = i29;
                    int i48 = childMeasureSpec;
                    int i49 = childCount2;
                    long j12 = (long) (1 << i46);
                    if ((j11 & j12) != 0) {
                        if (!z11 || !qVar5.f995e) {
                            z15 = true;
                        } else {
                            z15 = true;
                            if (i26 == 1) {
                                childAt2.setPadding(i12 + i28, 0, i12, 0);
                            }
                        }
                        qVar5.f992b += z15 ? 1 : 0;
                        qVar5.f996f = z15;
                        i26--;
                    } else if (qVar5.f992b == i45) {
                        j10 |= j12;
                    }
                    i46++;
                    childMeasureSpec = i48;
                    i29 = i47;
                    childCount2 = i49;
                }
                z22 = true;
            }
        }
        z12 = z22;
        int i50 = i29;
        int i51 = childMeasureSpec;
        int i52 = childCount2;
        if (z20 || i30 != 1) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (i26 <= 0 || j10 == 0 || (i26 >= i30 - 1 && !z13 && i31 <= 1)) {
            i13 = i52;
            z14 = z12;
        } else {
            float bitCount = (float) Long.bitCount(j10);
            if (!z13) {
                if ((j10 & 1) != 0 && !((q) getChildAt(0).getLayoutParams()).f995e) {
                    bitCount -= 0.5f;
                }
                int i53 = i52 - 1;
                if ((j10 & ((long) (1 << i53))) != 0 && !((q) getChildAt(i53).getLayoutParams()).f995e) {
                    bitCount -= 0.5f;
                }
            }
            if (bitCount > 0.0f) {
                i17 = (int) (((float) (i26 * i28)) / bitCount);
            } else {
                i17 = 0;
            }
            boolean z24 = z12;
            i13 = i52;
            for (int i54 = 0; i54 < i13; i54++) {
                if ((j10 & ((long) (1 << i54))) != 0) {
                    View childAt3 = getChildAt(i54);
                    q qVar6 = (q) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        qVar6.f993c = i17;
                        qVar6.f996f = true;
                        if (i54 == 0 && !qVar6.f995e) {
                            qVar6.leftMargin = (-i17) / 2;
                        }
                    } else if (qVar6.f991a) {
                        qVar6.f993c = i17;
                        qVar6.f996f = true;
                        qVar6.rightMargin = (-i17) / 2;
                    } else {
                        if (i54 != 0) {
                            qVar6.leftMargin = i17 / 2;
                        }
                        if (i54 != i13 - 1) {
                            qVar6.rightMargin = i17 / 2;
                        }
                    }
                    z24 = true;
                }
            }
            z14 = z24;
        }
        if (z14) {
            int i55 = 0;
            while (i55 < i13) {
                View childAt4 = getChildAt(i55);
                q qVar7 = (q) childAt4.getLayoutParams();
                if (!qVar7.f996f) {
                    i16 = i51;
                } else {
                    i16 = i51;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((qVar7.f992b * i28) + qVar7.f993c, 1073741824), i16);
                }
                i55++;
                i51 = i16;
            }
        }
        if (i38 != 1073741824) {
            i15 = i39;
            i14 = i50;
        } else {
            i14 = i40;
            i15 = i39;
        }
        setMeasuredDimension(i15, i14);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.A.f961y = z10;
    }

    public void setOnMenuItemClickListener(r rVar) {
        this.H = rVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        n nVar = this.A;
        k kVar = nVar.f953q;
        if (kVar != null) {
            kVar.setImageDrawable(drawable);
            return;
        }
        nVar.f955s = true;
        nVar.f954r = drawable;
    }

    public void setOverflowReserved(boolean z10) {
        this.f626z = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f625y != i10) {
            this.f625y = i10;
            if (i10 == 0) {
                this.f624x = getContext();
            } else {
                this.f624x = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(n nVar) {
        this.A = nVar;
        nVar.f951o = this;
        this.f623w = nVar.f946j;
    }

    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }
}
