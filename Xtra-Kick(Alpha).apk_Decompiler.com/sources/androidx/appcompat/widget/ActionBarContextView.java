package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.woxthebox.draglistview.R;
import f.a;
import java.util.WeakHashMap;
import m.o;
import m0.c1;
import m0.i0;
import m0.n1;

public class ActionBarContextView extends ViewGroup {
    public final int A;

    /* renamed from: h  reason: collision with root package name */
    public final a f585h = new a(this);

    /* renamed from: i  reason: collision with root package name */
    public final Context f586i;

    /* renamed from: j  reason: collision with root package name */
    public ActionMenuView f587j;

    /* renamed from: k  reason: collision with root package name */
    public n f588k;

    /* renamed from: l  reason: collision with root package name */
    public int f589l;

    /* renamed from: m  reason: collision with root package name */
    public n1 f590m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f591n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f592o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f593p;

    /* renamed from: q  reason: collision with root package name */
    public CharSequence f594q;

    /* renamed from: r  reason: collision with root package name */
    public View f595r;

    /* renamed from: s  reason: collision with root package name */
    public View f596s;

    /* renamed from: t  reason: collision with root package name */
    public View f597t;

    /* renamed from: u  reason: collision with root package name */
    public LinearLayout f598u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f599v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f600w;

    /* renamed from: x  reason: collision with root package name */
    public final int f601x;

    /* renamed from: y  reason: collision with root package name */
    public final int f602y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f603z;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        Drawable drawable;
        int resourceId;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f586i = context;
        } else {
            this.f586i = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f5394d, R.attr.actionModeStyle, 0);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = obtainStyledAttributes.getDrawable(0);
        } else {
            drawable = h.a.a(context, resourceId);
        }
        WeakHashMap weakHashMap = c1.f10054a;
        i0.q(this, drawable);
        this.f601x = obtainStyledAttributes.getResourceId(5, 0);
        this.f602y = obtainStyledAttributes.getResourceId(4, 0);
        this.f589l = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.A = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i10, int i11) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, RecyclerView.UNDEFINED_DURATION), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - 0);
    }

    public static int j(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = ((i12 - measuredHeight) / 2) + i11;
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(l.c r7) {
        /*
            r6 = this;
            android.view.View r0 = r6.f595r
            r1 = 0
            if (r0 != 0) goto L_0x0016
            android.content.Context r0 = r6.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r2 = r6.A
            android.view.View r0 = r0.inflate(r2, r6, r1)
            r6.f595r = r0
            goto L_0x001e
        L_0x0016:
            android.view.ViewParent r0 = r0.getParent()
            if (r0 != 0) goto L_0x0021
            android.view.View r0 = r6.f595r
        L_0x001e:
            r6.addView(r0)
        L_0x0021:
            android.view.View r0 = r6.f595r
            r2 = 2131361866(0x7f0a004a, float:1.8343496E38)
            android.view.View r0 = r0.findViewById(r2)
            r6.f596s = r0
            androidx.appcompat.widget.c r2 = new androidx.appcompat.widget.c
            r2.<init>(r6, r7)
            r0.setOnClickListener(r2)
            m.o r7 = r7.c()
            androidx.appcompat.widget.n r0 = r6.f588k
            if (r0 == 0) goto L_0x004e
            r0.d()
            androidx.appcompat.widget.h r0 = r0.B
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.b()
            if (r2 == 0) goto L_0x004e
            m.x r0 = r0.f9899j
            r0.dismiss()
        L_0x004e:
            androidx.appcompat.widget.n r0 = new androidx.appcompat.widget.n
            android.content.Context r2 = r6.getContext()
            r0.<init>(r2)
            r6.f588k = r0
            r2 = 1
            r0.f956t = r2
            r0.f957u = r2
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r3 = -2
            r4 = -1
            r0.<init>(r3, r4)
            androidx.appcompat.widget.n r3 = r6.f588k
            android.content.Context r4 = r6.f586i
            r7.b(r3, r4)
            androidx.appcompat.widget.n r7 = r6.f588k
            m.e0 r3 = r7.f951o
            if (r3 != 0) goto L_0x0086
            android.view.LayoutInflater r4 = r7.f947k
            int r5 = r7.f949m
            android.view.View r1 = r4.inflate(r5, r6, r1)
            m.e0 r1 = (m.e0) r1
            r7.f951o = r1
            m.o r4 = r7.f946j
            r1.c(r4)
            r7.e(r2)
        L_0x0086:
            m.e0 r1 = r7.f951o
            if (r3 == r1) goto L_0x0090
            r2 = r1
            androidx.appcompat.widget.ActionMenuView r2 = (androidx.appcompat.widget.ActionMenuView) r2
            r2.setPresenter(r7)
        L_0x0090:
            androidx.appcompat.widget.ActionMenuView r1 = (androidx.appcompat.widget.ActionMenuView) r1
            r6.f587j = r1
            java.util.WeakHashMap r7 = m0.c1.f10054a
            r7 = 0
            m0.i0.q(r1, r7)
            androidx.appcompat.widget.ActionMenuView r7 = r6.f587j
            r6.addView(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.c(l.c):void");
    }

    public final void d() {
        if (this.f598u == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f598u = linearLayout;
            this.f599v = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f600w = (TextView) this.f598u.findViewById(R.id.action_bar_subtitle);
            int i10 = this.f601x;
            if (i10 != 0) {
                this.f599v.setTextAppearance(getContext(), i10);
            }
            int i11 = this.f602y;
            if (i11 != 0) {
                this.f600w.setTextAppearance(getContext(), i11);
            }
        }
        this.f599v.setText(this.f593p);
        this.f600w.setText(this.f594q);
        boolean z10 = !TextUtils.isEmpty(this.f593p);
        boolean z11 = !TextUtils.isEmpty(this.f594q);
        int i12 = 0;
        this.f600w.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f598u;
        if (!z10 && !z11) {
            i12 = 8;
        }
        linearLayout2.setVisibility(i12);
        if (this.f598u.getParent() == null) {
            addView(this.f598u);
        }
    }

    public final void e() {
        removeAllViews();
        this.f597t = null;
        this.f587j = null;
        this.f588k = null;
        View view = this.f596s;
        if (view != null) {
            view.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: g */
    public final void onConfigurationChanged(Configuration configuration) {
        int i10;
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes((AttributeSet) null, a.f5391a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        n nVar = this.f588k;
        if (nVar != null) {
            Configuration configuration2 = nVar.f945i.getResources().getConfiguration();
            int i11 = configuration2.screenWidthDp;
            int i12 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp > 600 || i11 > 600 || ((i11 > 960 && i12 > 720) || (i11 > 720 && i12 > 960))) {
                i10 = 5;
            } else if (i11 >= 500 || ((i11 > 640 && i12 > 480) || (i11 > 480 && i12 > 640))) {
                i10 = 4;
            } else if (i11 >= 360) {
                i10 = 3;
            } else {
                i10 = 2;
            }
            nVar.f960x = i10;
            o oVar = nVar.f946j;
            if (oVar != null) {
                oVar.p(true);
            }
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f590m != null ? this.f585h.f715b : getVisibility();
    }

    public int getContentHeight() {
        return this.f589l;
    }

    public CharSequence getSubtitle() {
        return this.f594q;
    }

    public CharSequence getTitle() {
        return this.f593p;
    }

    /* renamed from: h */
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f592o = false;
        }
        if (!this.f592o) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f592o = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f592o = false;
        }
        return true;
    }

    /* renamed from: i */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f591n = false;
        }
        if (!this.f591n) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f591n = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f591n = false;
        }
        return true;
    }

    /* renamed from: k */
    public final void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            n1 n1Var = this.f590m;
            if (n1Var != null) {
                n1Var.b();
            }
            super.setVisibility(i10);
        }
    }

    public final n1 l(int i10, long j10) {
        n1 n1Var = this.f590m;
        if (n1Var != null) {
            n1Var.b();
        }
        a aVar = this.f585h;
        if (i10 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            n1 a10 = c1.a(this);
            a10.a(1.0f);
            a10.c(j10);
            aVar.f716c.f590m = a10;
            aVar.f715b = i10;
            a10.d(aVar);
            return a10;
        }
        n1 a11 = c1.a(this);
        a11.a(0.0f);
        a11.c(j10);
        aVar.f716c.f590m = a11;
        aVar.f715b = i10;
        a11.d(aVar);
        return a11;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n nVar = this.f588k;
        if (nVar != null) {
            nVar.d();
            h hVar = this.f588k.B;
            if (hVar != null && hVar.b()) {
                hVar.f9899j.dismiss();
            }
        }
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean a10 = l5.a(this);
        int paddingRight = a10 ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f595r;
        if (!(view == null || view.getVisibility() == 8)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f595r.getLayoutParams();
            int i14 = a10 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = a10 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i16 = a10 ? paddingRight - i14 : paddingRight + i14;
            int j10 = j(this.f595r, i16, paddingTop, paddingTop2, a10) + i16;
            paddingRight = a10 ? j10 - i15 : j10 + i15;
        }
        LinearLayout linearLayout = this.f598u;
        if (!(linearLayout == null || this.f597t != null || linearLayout.getVisibility() == 8)) {
            paddingRight += j(this.f598u, paddingRight, paddingTop, paddingTop2, a10);
        }
        View view2 = this.f597t;
        if (view2 != null) {
            j(view2, paddingRight, paddingTop, paddingTop2, a10);
        }
        int paddingLeft = a10 ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f587j;
        if (actionMenuView != null) {
            j(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a10);
        }
    }

    public final void onMeasure(int i10, int i11) {
        int i12 = 1073741824;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        } else if (View.MeasureSpec.getMode(i11) != 0) {
            int size = View.MeasureSpec.getSize(i10);
            int i13 = this.f589l;
            if (i13 <= 0) {
                i13 = View.MeasureSpec.getSize(i11);
            }
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i14 = i13 - paddingBottom;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i14, RecyclerView.UNDEFINED_DURATION);
            View view = this.f595r;
            if (view != null) {
                int f10 = f(view, paddingLeft, makeMeasureSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f595r.getLayoutParams();
                paddingLeft = f10 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            ActionMenuView actionMenuView = this.f587j;
            if (actionMenuView != null && actionMenuView.getParent() == this) {
                paddingLeft = f(this.f587j, paddingLeft, makeMeasureSpec);
            }
            LinearLayout linearLayout = this.f598u;
            if (linearLayout != null && this.f597t == null) {
                if (this.f603z) {
                    this.f598u.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.f598u.getMeasuredWidth();
                    boolean z10 = measuredWidth <= paddingLeft;
                    if (z10) {
                        paddingLeft -= measuredWidth;
                    }
                    this.f598u.setVisibility(z10 ? 0 : 8);
                } else {
                    paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
                }
            }
            View view2 = this.f597t;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i15 = layoutParams.width;
                int i16 = i15 != -2 ? 1073741824 : RecyclerView.UNDEFINED_DURATION;
                if (i15 >= 0) {
                    paddingLeft = Math.min(i15, paddingLeft);
                }
                int i17 = layoutParams.height;
                if (i17 == -2) {
                    i12 = RecyclerView.UNDEFINED_DURATION;
                }
                if (i17 >= 0) {
                    i14 = Math.min(i17, i14);
                }
                this.f597t.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i16), View.MeasureSpec.makeMeasureSpec(i14, i12));
            }
            if (this.f589l <= 0) {
                int childCount = getChildCount();
                i13 = 0;
                for (int i18 = 0; i18 < childCount; i18++) {
                    int measuredHeight = getChildAt(i18).getMeasuredHeight() + paddingBottom;
                    if (measuredHeight > i13) {
                        i13 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(size, i13);
        } else {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
    }

    public void setContentHeight(int i10) {
        this.f589l = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f597t;
        if (view2 != null) {
            removeView(view2);
        }
        this.f597t = view;
        if (!(view == null || (linearLayout = this.f598u) == null)) {
            removeView(linearLayout);
            this.f598u = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f594q = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f593p = charSequence;
        d();
        c1.q(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f603z) {
            requestLayout();
        }
        this.f603z = z10;
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
