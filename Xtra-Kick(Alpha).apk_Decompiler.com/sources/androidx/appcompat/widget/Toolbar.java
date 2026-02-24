package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.session.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.h;
import androidx.fragment.app.r0;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import g.a;
import g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import l.l;
import m.o;
import m0.c1;
import m0.j0;
import m0.l0;
import m0.p;
import m0.q;

public class Toolbar extends ViewGroup implements q {
    public s3 A;
    public int B;
    public int C;
    public final int D;
    public CharSequence E;
    public CharSequence F;
    public ColorStateList G;
    public ColorStateList H;
    public boolean I;
    public boolean J;
    public final ArrayList K;
    public final ArrayList L;
    public final int[] M;
    public final u N;
    public ArrayList O;
    public final w4 P;
    public d5 Q;
    public n R;
    public y4 S;
    public boolean T;
    public OnBackInvokedCallback U;
    public OnBackInvokedDispatcher V;
    public boolean W;

    /* renamed from: a0  reason: collision with root package name */
    public final h f690a0;

    /* renamed from: h  reason: collision with root package name */
    public ActionMenuView f691h;

    /* renamed from: i  reason: collision with root package name */
    public t1 f692i;

    /* renamed from: j  reason: collision with root package name */
    public t1 f693j;

    /* renamed from: k  reason: collision with root package name */
    public m0 f694k;

    /* renamed from: l  reason: collision with root package name */
    public o0 f695l;

    /* renamed from: m  reason: collision with root package name */
    public final Drawable f696m;

    /* renamed from: n  reason: collision with root package name */
    public final CharSequence f697n;

    /* renamed from: o  reason: collision with root package name */
    public m0 f698o;

    /* renamed from: p  reason: collision with root package name */
    public View f699p;

    /* renamed from: q  reason: collision with root package name */
    public Context f700q;

    /* renamed from: r  reason: collision with root package name */
    public int f701r;

    /* renamed from: s  reason: collision with root package name */
    public int f702s;

    /* renamed from: t  reason: collision with root package name */
    public int f703t;

    /* renamed from: u  reason: collision with root package name */
    public final int f704u;

    /* renamed from: v  reason: collision with root package name */
    public final int f705v;

    /* renamed from: w  reason: collision with root package name */
    public int f706w;

    /* renamed from: x  reason: collision with root package name */
    public int f707x;

    /* renamed from: y  reason: collision with root package name */
    public int f708y;

    /* renamed from: z  reason: collision with root package name */
    public int f709z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static z4 g(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof z4 ? new z4((z4) layoutParams) : layoutParams instanceof a ? new z4((a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new z4((ViewGroup.MarginLayoutParams) layoutParams) : new z4(layoutParams);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new l(getContext());
    }

    public static int i(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return p.b(marginLayoutParams) + p.c(marginLayoutParams);
    }

    public static int j(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i10) {
        boolean z10;
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(this) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i10, j0.d(this));
        arrayList.clear();
        if (z10) {
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt = getChildAt(i11);
                z4 z4Var = (z4) childAt.getLayoutParams();
                if (z4Var.f1154b == 0 && r(childAt)) {
                    int i12 = z4Var.f6019a;
                    WeakHashMap weakHashMap2 = c1.f10054a;
                    int d10 = j0.d(this);
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i12, d10) & 7;
                    if (!(absoluteGravity2 == 1 || absoluteGravity2 == 3 || absoluteGravity2 == 5)) {
                        absoluteGravity2 = d10 == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            z4 z4Var2 = (z4) childAt2.getLayoutParams();
            if (z4Var2.f1154b == 0 && r(childAt2)) {
                int i14 = z4Var2.f6019a;
                WeakHashMap weakHashMap3 = c1.f10054a;
                int d11 = j0.d(this);
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i14, d11) & 7;
                if (!(absoluteGravity3 == 1 || absoluteGravity3 == 3 || absoluteGravity3 == 5)) {
                    absoluteGravity3 = d11 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z10) {
        z4 z4Var;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            z4Var = new z4();
        } else if (!checkLayoutParams(layoutParams)) {
            z4Var = g(layoutParams);
        } else {
            z4Var = (z4) layoutParams;
        }
        z4Var.f1154b = 1;
        if (!z10 || this.f699p == null) {
            addView(view, z4Var);
            return;
        }
        view.setLayoutParams(z4Var);
        this.L.add(view);
    }

    public final void c() {
        if (this.f698o == null) {
            m0 m0Var = new m0(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            this.f698o = m0Var;
            m0Var.setImageDrawable(this.f696m);
            this.f698o.setContentDescription(this.f697n);
            z4 z4Var = new z4();
            z4Var.f6019a = (this.f704u & 112) | 8388611;
            z4Var.f1154b = 2;
            this.f698o.setLayoutParams(z4Var);
            this.f698o.setOnClickListener(new c(1, this));
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof z4);
    }

    public final void d() {
        e();
        ActionMenuView actionMenuView = this.f691h;
        if (actionMenuView.f623w == null) {
            o oVar = (o) actionMenuView.getMenu();
            if (this.S == null) {
                this.S = new y4(this);
            }
            this.f691h.setExpandedActionViewsExclusive(true);
            oVar.b(this.S, this.f700q);
            s();
        }
    }

    public final void e() {
        if (this.f691h == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), (AttributeSet) null);
            this.f691h = actionMenuView;
            actionMenuView.setPopupTheme(this.f701r);
            this.f691h.setOnMenuItemClickListener(this.P);
            ActionMenuView actionMenuView2 = this.f691h;
            w4 w4Var = new w4(this);
            actionMenuView2.B = null;
            actionMenuView2.C = w4Var;
            z4 z4Var = new z4();
            z4Var.f6019a = (this.f704u & 112) | 8388613;
            this.f691h.setLayoutParams(z4Var);
            b(this.f691h, false);
        }
    }

    public final void f() {
        if (this.f694k == null) {
            this.f694k = new m0(getContext(), (AttributeSet) null, R.attr.toolbarNavigationButtonStyle);
            z4 z4Var = new z4();
            z4Var.f6019a = (this.f704u & 112) | 8388611;
            this.f694k.setLayoutParams(z4Var);
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new z4();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new z4(getContext(), attributeSet);
    }

    public CharSequence getCollapseContentDescription() {
        m0 m0Var = this.f698o;
        if (m0Var != null) {
            return m0Var.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        m0 m0Var = this.f698o;
        if (m0Var != null) {
            return m0Var.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        s3 s3Var = this.A;
        if (s3Var == null) {
            return 0;
        }
        if (s3Var.f1053g) {
            return s3Var.f1047a;
        }
        return s3Var.f1048b;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.C;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        s3 s3Var = this.A;
        if (s3Var != null) {
            return s3Var.f1047a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        s3 s3Var = this.A;
        if (s3Var != null) {
            return s3Var.f1048b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        s3 s3Var = this.A;
        if (s3Var == null) {
            return 0;
        }
        if (s3Var.f1053g) {
            return s3Var.f1048b;
        }
        return s3Var.f1047a;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.B;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean z10;
        o oVar;
        ActionMenuView actionMenuView = this.f691h;
        if (actionMenuView == null || (oVar = actionMenuView.f623w) == null || !oVar.hasVisibleItems()) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            return Math.max(getContentInsetEnd(), Math.max(this.C, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = c1.f10054a;
        if (j0.d(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.B, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        o0 o0Var = this.f695l;
        if (o0Var != null) {
            return o0Var.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        o0 o0Var = this.f695l;
        if (o0Var != null) {
            return o0Var.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        d();
        return this.f691h.getMenu();
    }

    public View getNavButtonView() {
        return this.f694k;
    }

    public CharSequence getNavigationContentDescription() {
        m0 m0Var = this.f694k;
        if (m0Var != null) {
            return m0Var.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        m0 m0Var = this.f694k;
        if (m0Var != null) {
            return m0Var.getDrawable();
        }
        return null;
    }

    public n getOuterActionMenuPresenter() {
        return this.R;
    }

    public Drawable getOverflowIcon() {
        d();
        return this.f691h.getOverflowIcon();
    }

    /* access modifiers changed from: package-private */
    public Context getPopupContext() {
        return this.f700q;
    }

    public int getPopupTheme() {
        return this.f701r;
    }

    public CharSequence getSubtitle() {
        return this.F;
    }

    public final TextView getSubtitleTextView() {
        return this.f693j;
    }

    public CharSequence getTitle() {
        return this.E;
    }

    public int getTitleMarginBottom() {
        return this.f709z;
    }

    public int getTitleMarginEnd() {
        return this.f707x;
    }

    public int getTitleMarginStart() {
        return this.f706w;
    }

    public int getTitleMarginTop() {
        return this.f708y;
    }

    public final TextView getTitleTextView() {
        return this.f692i;
    }

    public f2 getWrapper() {
        if (this.Q == null) {
            this.Q = new d5(this);
        }
        return this.Q;
    }

    public final int h(View view, int i10) {
        int i11;
        z4 z4Var = (z4) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i10 > 0) {
            i11 = (measuredHeight - i10) / 2;
        } else {
            i11 = 0;
        }
        int i12 = z4Var.f6019a & 112;
        if (!(i12 == 16 || i12 == 48 || i12 == 80)) {
            i12 = this.D & 112;
        }
        if (i12 == 48) {
            return getPaddingTop() - i11;
        }
        if (i12 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - z4Var.bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i13 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i14 = z4Var.topMargin;
        if (i13 < i14) {
            i13 = i14;
        } else {
            int i15 = (((height - paddingBottom) - measuredHeight) - i13) - paddingTop;
            int i16 = z4Var.bottomMargin;
            if (i15 < i16) {
                i13 = Math.max(0, i13 - (i16 - i15));
            }
        }
        return paddingTop + i13;
    }

    public void k(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public final void l() {
        Iterator it = this.O.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.N.f429j).iterator();
        while (it2.hasNext()) {
            ((r0) it2.next()).f1555a.j();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.O = currentMenuItems2;
    }

    public final boolean m(View view) {
        return view.getParent() == this || this.L.contains(view);
    }

    public final int n(View view, int i10, int i11, int[] iArr) {
        z4 z4Var = (z4) view.getLayoutParams();
        int i12 = z4Var.leftMargin - iArr[0];
        int max = Math.max(0, i12) + i10;
        iArr[0] = Math.max(0, -i12);
        int h10 = h(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, h10, max + measuredWidth, view.getMeasuredHeight() + h10);
        return measuredWidth + z4Var.rightMargin + max;
    }

    public final int o(View view, int i10, int i11, int[] iArr) {
        z4 z4Var = (z4) view.getLayoutParams();
        int i12 = z4Var.rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int h10 = h(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, h10, max, view.getMeasuredHeight() + h10);
        return max - (measuredWidth + z4Var.leftMargin);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f690a0);
        s();
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.J = false;
        }
        if (!this.J) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.J = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.J = false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x0288 A[LOOP:0: B:104:0x0286->B:105:0x0288, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02a4 A[LOOP:1: B:107:0x02a2->B:108:0x02a4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02c3 A[LOOP:2: B:110:0x02c1->B:111:0x02c3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0311 A[LOOP:3: B:118:0x030f->B:119:0x0311, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            r19 = this;
            r0 = r19
            java.util.WeakHashMap r1 = m0.c1.f10054a
            int r1 = m0.j0.d(r19)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000e
            r1 = 1
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            int r4 = r19.getWidth()
            int r5 = r19.getHeight()
            int r6 = r19.getPaddingLeft()
            int r7 = r19.getPaddingRight()
            int r8 = r19.getPaddingTop()
            int r9 = r19.getPaddingBottom()
            int r10 = r4 - r7
            int[] r11 = r0.M
            r11[r2] = r3
            r11[r3] = r3
            int r12 = m0.i0.d(r19)
            if (r12 < 0) goto L_0x003c
            int r13 = r24 - r22
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x003d
        L_0x003c:
            r12 = 0
        L_0x003d:
            androidx.appcompat.widget.m0 r13 = r0.f694k
            boolean r13 = r0.r(r13)
            if (r13 == 0) goto L_0x0055
            androidx.appcompat.widget.m0 r13 = r0.f694k
            if (r1 == 0) goto L_0x0050
            int r13 = r0.o(r13, r10, r12, r11)
            r14 = r13
            r13 = r6
            goto L_0x0057
        L_0x0050:
            int r13 = r0.n(r13, r6, r12, r11)
            goto L_0x0056
        L_0x0055:
            r13 = r6
        L_0x0056:
            r14 = r10
        L_0x0057:
            androidx.appcompat.widget.m0 r15 = r0.f698o
            boolean r15 = r0.r(r15)
            if (r15 == 0) goto L_0x006c
            androidx.appcompat.widget.m0 r15 = r0.f698o
            if (r1 == 0) goto L_0x0068
            int r14 = r0.o(r15, r14, r12, r11)
            goto L_0x006c
        L_0x0068:
            int r13 = r0.n(r15, r13, r12, r11)
        L_0x006c:
            androidx.appcompat.widget.ActionMenuView r15 = r0.f691h
            boolean r15 = r0.r(r15)
            if (r15 == 0) goto L_0x0081
            androidx.appcompat.widget.ActionMenuView r15 = r0.f691h
            if (r1 == 0) goto L_0x007d
            int r13 = r0.n(r15, r13, r12, r11)
            goto L_0x0081
        L_0x007d:
            int r14 = r0.o(r15, r14, r12, r11)
        L_0x0081:
            int r15 = r19.getCurrentContentInsetLeft()
            int r16 = r19.getCurrentContentInsetRight()
            int r2 = r15 - r13
            int r2 = java.lang.Math.max(r3, r2)
            r11[r3] = r2
            int r2 = r10 - r14
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r11[r17] = r2
            int r2 = java.lang.Math.max(r13, r15)
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r14, r10)
            android.view.View r13 = r0.f699p
            boolean r13 = r0.r(r13)
            if (r13 == 0) goto L_0x00bc
            android.view.View r13 = r0.f699p
            if (r1 == 0) goto L_0x00b8
            int r10 = r0.o(r13, r10, r12, r11)
            goto L_0x00bc
        L_0x00b8:
            int r2 = r0.n(r13, r2, r12, r11)
        L_0x00bc:
            androidx.appcompat.widget.o0 r13 = r0.f695l
            boolean r13 = r0.r(r13)
            if (r13 == 0) goto L_0x00d1
            androidx.appcompat.widget.o0 r13 = r0.f695l
            if (r1 == 0) goto L_0x00cd
            int r10 = r0.o(r13, r10, r12, r11)
            goto L_0x00d1
        L_0x00cd:
            int r2 = r0.n(r13, r2, r12, r11)
        L_0x00d1:
            androidx.appcompat.widget.t1 r13 = r0.f692i
            boolean r13 = r0.r(r13)
            androidx.appcompat.widget.t1 r14 = r0.f693j
            boolean r14 = r0.r(r14)
            if (r13 == 0) goto L_0x00f8
            androidx.appcompat.widget.t1 r15 = r0.f692i
            android.view.ViewGroup$LayoutParams r15 = r15.getLayoutParams()
            androidx.appcompat.widget.z4 r15 = (androidx.appcompat.widget.z4) r15
            int r3 = r15.topMargin
            r23 = r7
            androidx.appcompat.widget.t1 r7 = r0.f692i
            int r7 = r7.getMeasuredHeight()
            int r7 = r7 + r3
            int r3 = r15.bottomMargin
            int r7 = r7 + r3
            r3 = 0
            int r7 = r7 + r3
            goto L_0x00fb
        L_0x00f8:
            r23 = r7
            r7 = 0
        L_0x00fb:
            if (r14 == 0) goto L_0x0115
            androidx.appcompat.widget.t1 r3 = r0.f693j
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.z4 r3 = (androidx.appcompat.widget.z4) r3
            int r15 = r3.topMargin
            r16 = r4
            androidx.appcompat.widget.t1 r4 = r0.f693j
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r15
            int r3 = r3.bottomMargin
            int r4 = r4 + r3
            int r7 = r7 + r4
            goto L_0x0117
        L_0x0115:
            r16 = r4
        L_0x0117:
            if (r13 != 0) goto L_0x0122
            if (r14 == 0) goto L_0x011c
            goto L_0x0122
        L_0x011c:
            r18 = r6
            r22 = r12
            goto L_0x027a
        L_0x0122:
            if (r13 == 0) goto L_0x0127
            androidx.appcompat.widget.t1 r3 = r0.f692i
            goto L_0x0129
        L_0x0127:
            androidx.appcompat.widget.t1 r3 = r0.f693j
        L_0x0129:
            if (r14 == 0) goto L_0x012e
            androidx.appcompat.widget.t1 r4 = r0.f693j
            goto L_0x0130
        L_0x012e:
            androidx.appcompat.widget.t1 r4 = r0.f692i
        L_0x0130:
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.z4 r3 = (androidx.appcompat.widget.z4) r3
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.appcompat.widget.z4 r4 = (androidx.appcompat.widget.z4) r4
            if (r13 == 0) goto L_0x0146
            androidx.appcompat.widget.t1 r15 = r0.f692i
            int r15 = r15.getMeasuredWidth()
            if (r15 > 0) goto L_0x0150
        L_0x0146:
            if (r14 == 0) goto L_0x0153
            androidx.appcompat.widget.t1 r15 = r0.f693j
            int r15 = r15.getMeasuredWidth()
            if (r15 <= 0) goto L_0x0153
        L_0x0150:
            r17 = 1
            goto L_0x0155
        L_0x0153:
            r17 = 0
        L_0x0155:
            int r15 = r0.D
            r15 = r15 & 112(0x70, float:1.57E-43)
            r18 = r6
            r6 = 48
            if (r15 == r6) goto L_0x0197
            r6 = 80
            if (r15 == r6) goto L_0x018b
            int r6 = r5 - r8
            int r6 = r6 - r9
            int r6 = r6 - r7
            int r6 = r6 / 2
            int r15 = r3.topMargin
            r22 = r12
            int r12 = r0.f708y
            int r15 = r15 + r12
            if (r6 >= r15) goto L_0x0174
            r6 = r15
            goto L_0x0189
        L_0x0174:
            int r5 = r5 - r9
            int r5 = r5 - r7
            int r5 = r5 - r6
            int r5 = r5 - r8
            int r3 = r3.bottomMargin
            int r7 = r0.f709z
            int r3 = r3 + r7
            if (r5 >= r3) goto L_0x0189
            int r3 = r4.bottomMargin
            int r3 = r3 + r7
            int r3 = r3 - r5
            int r6 = r6 - r3
            r3 = 0
            int r6 = java.lang.Math.max(r3, r6)
        L_0x0189:
            int r8 = r8 + r6
            goto L_0x01a4
        L_0x018b:
            r22 = r12
            int r5 = r5 - r9
            int r3 = r4.bottomMargin
            int r5 = r5 - r3
            int r3 = r0.f709z
            int r5 = r5 - r3
            int r8 = r5 - r7
            goto L_0x01a4
        L_0x0197:
            r22 = r12
            int r4 = r19.getPaddingTop()
            int r3 = r3.topMargin
            int r4 = r4 + r3
            int r3 = r0.f708y
            int r8 = r4 + r3
        L_0x01a4:
            if (r1 == 0) goto L_0x0213
            if (r17 == 0) goto L_0x01ab
            int r1 = r0.f706w
            goto L_0x01ac
        L_0x01ab:
            r1 = 0
        L_0x01ac:
            r3 = 1
            r4 = r11[r3]
            int r1 = r1 - r4
            r4 = 0
            int r5 = java.lang.Math.max(r4, r1)
            int r10 = r10 - r5
            int r1 = -r1
            int r1 = java.lang.Math.max(r4, r1)
            r11[r3] = r1
            if (r13 == 0) goto L_0x01e3
            androidx.appcompat.widget.t1 r1 = r0.f692i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.z4 r1 = (androidx.appcompat.widget.z4) r1
            androidx.appcompat.widget.t1 r3 = r0.f692i
            int r3 = r3.getMeasuredWidth()
            int r3 = r10 - r3
            androidx.appcompat.widget.t1 r4 = r0.f692i
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            androidx.appcompat.widget.t1 r5 = r0.f692i
            r5.layout(r3, r8, r10, r4)
            int r5 = r0.f707x
            int r3 = r3 - r5
            int r1 = r1.bottomMargin
            int r8 = r4 + r1
            goto L_0x01e4
        L_0x01e3:
            r3 = r10
        L_0x01e4:
            if (r14 == 0) goto L_0x020a
            androidx.appcompat.widget.t1 r1 = r0.f693j
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.z4 r1 = (androidx.appcompat.widget.z4) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            androidx.appcompat.widget.t1 r1 = r0.f693j
            int r1 = r1.getMeasuredWidth()
            int r1 = r10 - r1
            androidx.appcompat.widget.t1 r4 = r0.f693j
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            androidx.appcompat.widget.t1 r5 = r0.f693j
            r5.layout(r1, r8, r10, r4)
            int r1 = r0.f707x
            int r1 = r10 - r1
            goto L_0x020b
        L_0x020a:
            r1 = r10
        L_0x020b:
            if (r17 == 0) goto L_0x027a
            int r1 = java.lang.Math.min(r3, r1)
            r10 = r1
            goto L_0x027a
        L_0x0213:
            if (r17 == 0) goto L_0x0218
            int r1 = r0.f706w
            goto L_0x0219
        L_0x0218:
            r1 = 0
        L_0x0219:
            r3 = 0
            r4 = r11[r3]
            int r1 = r1 - r4
            int r4 = java.lang.Math.max(r3, r1)
            int r2 = r2 + r4
            int r1 = -r1
            int r1 = java.lang.Math.max(r3, r1)
            r11[r3] = r1
            if (r13 == 0) goto L_0x024e
            androidx.appcompat.widget.t1 r1 = r0.f692i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.z4 r1 = (androidx.appcompat.widget.z4) r1
            androidx.appcompat.widget.t1 r3 = r0.f692i
            int r3 = r3.getMeasuredWidth()
            int r3 = r3 + r2
            androidx.appcompat.widget.t1 r4 = r0.f692i
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            androidx.appcompat.widget.t1 r5 = r0.f692i
            r5.layout(r2, r8, r3, r4)
            int r5 = r0.f707x
            int r3 = r3 + r5
            int r1 = r1.bottomMargin
            int r8 = r4 + r1
            goto L_0x024f
        L_0x024e:
            r3 = r2
        L_0x024f:
            if (r14 == 0) goto L_0x0273
            androidx.appcompat.widget.t1 r1 = r0.f693j
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.appcompat.widget.z4 r1 = (androidx.appcompat.widget.z4) r1
            int r1 = r1.topMargin
            int r8 = r8 + r1
            androidx.appcompat.widget.t1 r1 = r0.f693j
            int r1 = r1.getMeasuredWidth()
            int r1 = r1 + r2
            androidx.appcompat.widget.t1 r4 = r0.f693j
            int r4 = r4.getMeasuredHeight()
            int r4 = r4 + r8
            androidx.appcompat.widget.t1 r5 = r0.f693j
            r5.layout(r2, r8, r1, r4)
            int r4 = r0.f707x
            int r1 = r1 + r4
            goto L_0x0274
        L_0x0273:
            r1 = r2
        L_0x0274:
            if (r17 == 0) goto L_0x027a
            int r2 = java.lang.Math.max(r3, r1)
        L_0x027a:
            java.util.ArrayList r1 = r0.K
            r3 = 3
            r0.a(r1, r3)
            int r3 = r1.size()
            r4 = r2
            r2 = 0
        L_0x0286:
            if (r2 >= r3) goto L_0x0297
            java.lang.Object r5 = r1.get(r2)
            android.view.View r5 = (android.view.View) r5
            r12 = r22
            int r4 = r0.n(r5, r4, r12, r11)
            int r2 = r2 + 1
            goto L_0x0286
        L_0x0297:
            r12 = r22
            r2 = 5
            r0.a(r1, r2)
            int r2 = r1.size()
            r3 = 0
        L_0x02a2:
            if (r3 >= r2) goto L_0x02b1
            java.lang.Object r5 = r1.get(r3)
            android.view.View r5 = (android.view.View) r5
            int r10 = r0.o(r5, r10, r12, r11)
            int r3 = r3 + 1
            goto L_0x02a2
        L_0x02b1:
            r3 = 1
            r0.a(r1, r3)
            r2 = 0
            r5 = r11[r2]
            r2 = r11[r3]
            int r3 = r1.size()
            r7 = r5
            r5 = 0
            r6 = 0
        L_0x02c1:
            if (r5 >= r3) goto L_0x02f4
            java.lang.Object r8 = r1.get(r5)
            android.view.View r8 = (android.view.View) r8
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.appcompat.widget.z4 r9 = (androidx.appcompat.widget.z4) r9
            int r13 = r9.leftMargin
            int r13 = r13 - r7
            int r7 = r9.rightMargin
            int r7 = r7 - r2
            r2 = 0
            int r9 = java.lang.Math.max(r2, r13)
            int r14 = java.lang.Math.max(r2, r7)
            int r13 = -r13
            int r13 = java.lang.Math.max(r2, r13)
            int r7 = -r7
            int r7 = java.lang.Math.max(r2, r7)
            int r8 = r8.getMeasuredWidth()
            int r8 = r8 + r9
            int r8 = r8 + r14
            int r6 = r6 + r8
            int r5 = r5 + 1
            r2 = r7
            r7 = r13
            goto L_0x02c1
        L_0x02f4:
            r2 = 0
            int r3 = r16 - r18
            int r3 = r3 - r23
            int r3 = r3 / 2
            int r3 = r3 + r18
            int r5 = r6 / 2
            int r3 = r3 - r5
            int r6 = r6 + r3
            if (r3 >= r4) goto L_0x0304
            goto L_0x030b
        L_0x0304:
            if (r6 <= r10) goto L_0x030a
            int r6 = r6 - r10
            int r4 = r3 - r6
            goto L_0x030b
        L_0x030a:
            r4 = r3
        L_0x030b:
            int r3 = r1.size()
        L_0x030f:
            if (r2 >= r3) goto L_0x031e
            java.lang.Object r5 = r1.get(r2)
            android.view.View r5 = (android.view.View) r5
            int r4 = r0.n(r5, r4, r12, r11)
            int r2 = r2 + 1
            goto L_0x030f
        L_0x031e:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    public final void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z10;
        char a10 = l5.a(this);
        char c10 = a10 ^ 1;
        int i19 = 0;
        if (r(this.f694k)) {
            q(this.f694k, i10, 0, i11, this.f705v);
            i14 = i(this.f694k) + this.f694k.getMeasuredWidth();
            i13 = Math.max(0, j(this.f694k) + this.f694k.getMeasuredHeight());
            i12 = View.combineMeasuredStates(0, this.f694k.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
            i12 = 0;
        }
        if (r(this.f698o)) {
            q(this.f698o, i10, 0, i11, this.f705v);
            i14 = i(this.f698o) + this.f698o.getMeasuredWidth();
            i13 = Math.max(i13, j(this.f698o) + this.f698o.getMeasuredHeight());
            i12 = View.combineMeasuredStates(i12, this.f698o.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i14) + 0;
        int max2 = Math.max(0, currentContentInsetStart - i14);
        int[] iArr = this.M;
        iArr[a10] = max2;
        if (r(this.f691h)) {
            q(this.f691h, i10, max, i11, this.f705v);
            i15 = i(this.f691h) + this.f691h.getMeasuredWidth();
            i13 = Math.max(i13, j(this.f691h) + this.f691h.getMeasuredHeight());
            i12 = View.combineMeasuredStates(i12, this.f691h.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i15);
        iArr[c10] = Math.max(0, currentContentInsetEnd - i15);
        if (r(this.f699p)) {
            max3 += p(this.f699p, i10, max3, i11, 0, iArr);
            i13 = Math.max(i13, j(this.f699p) + this.f699p.getMeasuredHeight());
            i12 = View.combineMeasuredStates(i12, this.f699p.getMeasuredState());
        }
        if (r(this.f695l)) {
            max3 += p(this.f695l, i10, max3, i11, 0, iArr);
            i13 = Math.max(i13, j(this.f695l) + this.f695l.getMeasuredHeight());
            i12 = View.combineMeasuredStates(i12, this.f695l.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((z4) childAt.getLayoutParams()).f1154b == 0 && r(childAt)) {
                max3 += p(childAt, i10, max3, i11, 0, iArr);
                i13 = Math.max(i13, j(childAt) + childAt.getMeasuredHeight());
                i12 = View.combineMeasuredStates(i12, childAt.getMeasuredState());
            }
        }
        int i21 = this.f708y + this.f709z;
        int i22 = this.f706w + this.f707x;
        if (r(this.f692i)) {
            p(this.f692i, i10, max3 + i22, i11, i21, iArr);
            int i23 = i(this.f692i) + this.f692i.getMeasuredWidth();
            i16 = j(this.f692i) + this.f692i.getMeasuredHeight();
            i18 = View.combineMeasuredStates(i12, this.f692i.getMeasuredState());
            i17 = i23;
        } else {
            i18 = i12;
            i17 = 0;
            i16 = 0;
        }
        if (r(this.f693j)) {
            int i24 = i16 + i21;
            i17 = Math.max(i17, p(this.f693j, i10, max3 + i22, i11, i24, iArr));
            i16 += j(this.f693j) + this.f693j.getMeasuredHeight();
            i18 = View.combineMeasuredStates(i18, this.f693j.getMeasuredState());
        } else {
            int i25 = i18;
        }
        int max4 = Math.max(i13, i16);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max4;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + max3 + i17, getSuggestedMinimumWidth()), i10, -16777216 & i18);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i11, i18 << 16);
        if (this.T) {
            int childCount2 = getChildCount();
            int i26 = 0;
            while (true) {
                if (i26 >= childCount2) {
                    z10 = true;
                    break;
                }
                View childAt2 = getChildAt(i26);
                if (r(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    break;
                }
                i26++;
            }
        }
        z10 = false;
        if (!z10) {
            i19 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        o oVar;
        MenuItem findItem;
        if (!(parcelable instanceof c5)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c5 c5Var = (c5) parcelable;
        super.onRestoreInstanceState(c5Var.f14484h);
        ActionMenuView actionMenuView = this.f691h;
        if (actionMenuView != null) {
            oVar = actionMenuView.f623w;
        } else {
            oVar = null;
        }
        int i10 = c5Var.f783j;
        if (!(i10 == 0 || this.S == null || oVar == null || (findItem = oVar.findItem(i10)) == null)) {
            findItem.expandActionView();
        }
        if (c5Var.f784k) {
            h hVar = this.f690a0;
            removeCallbacks(hVar);
            post(hVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onRtlPropertiesChanged(int r3) {
        /*
            r2 = this;
            super.onRtlPropertiesChanged(r3)
            androidx.appcompat.widget.s3 r0 = r2.A
            if (r0 != 0) goto L_0x000e
            androidx.appcompat.widget.s3 r0 = new androidx.appcompat.widget.s3
            r0.<init>()
            r2.A = r0
        L_0x000e:
            androidx.appcompat.widget.s3 r0 = r2.A
            r1 = 1
            if (r3 != r1) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            boolean r3 = r0.f1053g
            if (r1 != r3) goto L_0x001a
            goto L_0x0048
        L_0x001a:
            r0.f1053g = r1
            boolean r3 = r0.f1054h
            if (r3 == 0) goto L_0x0040
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto L_0x0032
            int r1 = r0.f1050d
            if (r1 == r3) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            int r1 = r0.f1051e
        L_0x002b:
            r0.f1047a = r1
            int r1 = r0.f1049c
            if (r1 == r3) goto L_0x0044
            goto L_0x0046
        L_0x0032:
            int r1 = r0.f1049c
            if (r1 == r3) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            int r1 = r0.f1051e
        L_0x0039:
            r0.f1047a = r1
            int r1 = r0.f1050d
            if (r1 == r3) goto L_0x0044
            goto L_0x0046
        L_0x0040:
            int r3 = r0.f1051e
            r0.f1047a = r3
        L_0x0044:
            int r1 = r0.f1052f
        L_0x0046:
            r0.f1048b = r1
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onRtlPropertiesChanged(int):void");
    }

    public final Parcelable onSaveInstanceState() {
        boolean z10;
        m.q qVar;
        c5 c5Var = new c5(super.onSaveInstanceState());
        y4 y4Var = this.S;
        if (!(y4Var == null || (qVar = y4Var.f1134i) == null)) {
            c5Var.f783j = qVar.f9999a;
        }
        ActionMenuView actionMenuView = this.f691h;
        boolean z11 = false;
        if (actionMenuView != null) {
            n nVar = actionMenuView.A;
            if (nVar == null || !nVar.f()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                z11 = true;
            }
        }
        c5Var.f784k = z11;
        return c5Var;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.I = false;
        }
        if (!this.I) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.I = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.I = false;
        }
        return true;
    }

    public final int p(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i15) + Math.max(0, i14);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void q(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i13 >= 0) {
            if (mode != 0) {
                i13 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i13);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i13, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean r(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        boolean z10;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a10 = x4.a(this);
            y4 y4Var = this.S;
            boolean z11 = false;
            if (y4Var == null || y4Var.f1134i == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && a10 != null) {
                WeakHashMap weakHashMap = c1.f10054a;
                if (l0.b(this) && this.W) {
                    z11 = true;
                }
            }
            if (z11 && this.V == null) {
                if (this.U == null) {
                    this.U = x4.b(new v4(this, 1));
                }
                x4.c(a10, this.U);
            } else if (!z11 && (onBackInvokedDispatcher = this.V) != null) {
                x4.d(onBackInvokedDispatcher, this.U);
                a10 = null;
            } else {
                return;
            }
            this.V = a10;
        }
    }

    public void setBackInvokedCallbackEnabled(boolean z10) {
        if (this.W != z10) {
            this.W = z10;
            s();
        }
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(h.a.a(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.T = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = RecyclerView.UNDEFINED_DURATION;
        }
        if (i10 != this.C) {
            this.C = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = RecyclerView.UNDEFINED_DURATION;
        }
        if (i10 != this.B) {
            this.B = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(h.a.a(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(h.a.a(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        f();
        this.f694k.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(a5 a5Var) {
    }

    public void setOverflowIcon(Drawable drawable) {
        d();
        this.f691h.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f701r != i10) {
            this.f701r = i10;
            if (i10 == 0) {
                this.f700q = getContext();
            } else {
                this.f700q = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f709z = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f707x = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f706w = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f708y = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.D = 8388627;
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.M = new int[2];
        this.N = new u((Runnable) new v4(this, 0));
        this.O = new ArrayList();
        this.P = new w4(this);
        this.f690a0 = new h(3, this);
        Context context2 = getContext();
        int[] iArr = f.a.f5416z;
        u4 m10 = u4.m(context2, attributeSet, iArr, R.attr.toolbarStyle);
        c1.o(this, context, iArr, attributeSet, m10.f1100b, R.attr.toolbarStyle);
        this.f702s = m10.i(28, 0);
        this.f703t = m10.i(19, 0);
        TypedArray typedArray = m10.f1100b;
        this.D = typedArray.getInteger(0, 8388627);
        this.f704u = typedArray.getInteger(2, 48);
        int c10 = m10.c(22, 0);
        c10 = m10.l(27) ? m10.c(27, c10) : c10;
        this.f709z = c10;
        this.f708y = c10;
        this.f707x = c10;
        this.f706w = c10;
        int c11 = m10.c(25, -1);
        if (c11 >= 0) {
            this.f706w = c11;
        }
        int c12 = m10.c(24, -1);
        if (c12 >= 0) {
            this.f707x = c12;
        }
        int c13 = m10.c(26, -1);
        if (c13 >= 0) {
            this.f708y = c13;
        }
        int c14 = m10.c(23, -1);
        if (c14 >= 0) {
            this.f709z = c14;
        }
        this.f705v = m10.d(13, -1);
        int c15 = m10.c(9, RecyclerView.UNDEFINED_DURATION);
        int c16 = m10.c(5, RecyclerView.UNDEFINED_DURATION);
        int d10 = m10.d(7, 0);
        int d11 = m10.d(8, 0);
        if (this.A == null) {
            this.A = new s3();
        }
        s3 s3Var = this.A;
        s3Var.f1054h = false;
        if (d10 != Integer.MIN_VALUE) {
            s3Var.f1051e = d10;
            s3Var.f1047a = d10;
        }
        if (d11 != Integer.MIN_VALUE) {
            s3Var.f1052f = d11;
            s3Var.f1048b = d11;
        }
        if (!(c15 == Integer.MIN_VALUE && c16 == Integer.MIN_VALUE)) {
            s3Var.a(c15, c16);
        }
        this.B = m10.c(10, RecyclerView.UNDEFINED_DURATION);
        this.C = m10.c(6, RecyclerView.UNDEFINED_DURATION);
        this.f696m = m10.e(4);
        this.f697n = m10.k(3);
        CharSequence k10 = m10.k(21);
        if (!TextUtils.isEmpty(k10)) {
            setTitle(k10);
        }
        CharSequence k11 = m10.k(18);
        if (!TextUtils.isEmpty(k11)) {
            setSubtitle(k11);
        }
        this.f700q = getContext();
        setPopupTheme(m10.i(17, 0));
        Drawable e10 = m10.e(16);
        if (e10 != null) {
            setNavigationIcon(e10);
        }
        CharSequence k12 = m10.k(15);
        if (!TextUtils.isEmpty(k12)) {
            setNavigationContentDescription(k12);
        }
        Drawable e11 = m10.e(11);
        if (e11 != null) {
            setLogo(e11);
        }
        CharSequence k13 = m10.k(12);
        if (!TextUtils.isEmpty(k13)) {
            setLogoDescription(k13);
        }
        if (m10.l(29)) {
            setTitleTextColor(m10.b(29));
        }
        if (m10.l(20)) {
            setSubtitleTextColor(m10.b(20));
        }
        if (m10.l(14)) {
            k(m10.i(14, 0));
        }
        m10.n();
    }

    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return g(layoutParams);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        m0 m0Var = this.f698o;
        if (m0Var != null) {
            m0Var.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f698o.setImageDrawable(drawable);
            return;
        }
        m0 m0Var = this.f698o;
        if (m0Var != null) {
            m0Var.setImageDrawable(this.f696m);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f695l == null) {
                this.f695l = new o0(getContext(), (AttributeSet) null, 0);
            }
            if (!m(this.f695l)) {
                b(this.f695l, true);
            }
        } else {
            o0 o0Var = this.f695l;
            if (o0Var != null && m(o0Var)) {
                removeView(this.f695l);
                this.L.remove(this.f695l);
            }
        }
        o0 o0Var2 = this.f695l;
        if (o0Var2 != null) {
            o0Var2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f695l == null) {
            this.f695l = new o0(getContext(), (AttributeSet) null, 0);
        }
        o0 o0Var = this.f695l;
        if (o0Var != null) {
            o0Var.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            f();
        }
        m0 m0Var = this.f694k;
        if (m0Var != null) {
            m0Var.setContentDescription(charSequence);
            f5.a(this.f694k, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            f();
            if (!m(this.f694k)) {
                b(this.f694k, true);
            }
        } else {
            m0 m0Var = this.f694k;
            if (m0Var != null && m(m0Var)) {
                removeView(this.f694k);
                this.L.remove(this.f694k);
            }
        }
        m0 m0Var2 = this.f694k;
        if (m0Var2 != null) {
            m0Var2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f693j == null) {
                Context context = getContext();
                t1 t1Var = new t1(context, (AttributeSet) null);
                this.f693j = t1Var;
                t1Var.setSingleLine();
                this.f693j.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f703t;
                if (i10 != 0) {
                    this.f693j.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.H;
                if (colorStateList != null) {
                    this.f693j.setTextColor(colorStateList);
                }
            }
            if (!m(this.f693j)) {
                b(this.f693j, true);
            }
        } else {
            t1 t1Var2 = this.f693j;
            if (t1Var2 != null && m(t1Var2)) {
                removeView(this.f693j);
                this.L.remove(this.f693j);
            }
        }
        t1 t1Var3 = this.f693j;
        if (t1Var3 != null) {
            t1Var3.setText(charSequence);
        }
        this.F = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.H = colorStateList;
        t1 t1Var = this.f693j;
        if (t1Var != null) {
            t1Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f692i == null) {
                Context context = getContext();
                t1 t1Var = new t1(context, (AttributeSet) null);
                this.f692i = t1Var;
                t1Var.setSingleLine();
                this.f692i.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f702s;
                if (i10 != 0) {
                    this.f692i.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.G;
                if (colorStateList != null) {
                    this.f692i.setTextColor(colorStateList);
                }
            }
            if (!m(this.f692i)) {
                b(this.f692i, true);
            }
        } else {
            t1 t1Var2 = this.f692i;
            if (t1Var2 != null && m(t1Var2)) {
                removeView(this.f692i);
                this.L.remove(this.f692i);
            }
        }
        t1 t1Var3 = this.f692i;
        if (t1Var3 != null) {
            t1Var3.setText(charSequence);
        }
        this.E = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.G = colorStateList;
        t1 t1Var = this.f692i;
        if (t1Var != null) {
            t1Var.setTextColor(colorStateList);
        }
    }
}
