package o8;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.f5;
import androidx.appcompat.widget.x3;
import c0.c;
import com.google.gson.internal.bind.l;
import com.woxthebox.draglistview.R;
import f0.b;
import h4.r;
import java.util.WeakHashMap;
import m.d0;
import m.q;
import m0.c0;
import m0.c1;
import m0.i0;
import n0.g;
import n0.h;
import y7.a;

public abstract class d extends FrameLayout implements d0 {
    public static final int[] L = {16842912};
    public static final b M = new b(0);
    public static final c N = new c(0);
    public Drawable A;
    public Drawable B;
    public ValueAnimator C;
    public b D = M;
    public float E = 0.0f;
    public boolean F = false;
    public int G = 0;
    public int H = 0;
    public boolean I = false;
    public int J = 0;
    public a K;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12310h = false;

    /* renamed from: i  reason: collision with root package name */
    public ColorStateList f12311i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f12312j;

    /* renamed from: k  reason: collision with root package name */
    public int f12313k;

    /* renamed from: l  reason: collision with root package name */
    public int f12314l;

    /* renamed from: m  reason: collision with root package name */
    public float f12315m;

    /* renamed from: n  reason: collision with root package name */
    public float f12316n;

    /* renamed from: o  reason: collision with root package name */
    public float f12317o;

    /* renamed from: p  reason: collision with root package name */
    public int f12318p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f12319q;

    /* renamed from: r  reason: collision with root package name */
    public final FrameLayout f12320r;

    /* renamed from: s  reason: collision with root package name */
    public final View f12321s;

    /* renamed from: t  reason: collision with root package name */
    public final ImageView f12322t;

    /* renamed from: u  reason: collision with root package name */
    public final ViewGroup f12323u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f12324v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f12325w;

    /* renamed from: x  reason: collision with root package name */
    public int f12326x = -1;

    /* renamed from: y  reason: collision with root package name */
    public q f12327y;

    /* renamed from: z  reason: collision with root package name */
    public ColorStateList f12328z;

    public d(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.f12320r = (FrameLayout) findViewById(R.id.navigation_bar_item_icon_container);
        this.f12321s = findViewById(R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        this.f12322t = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f12323u = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f12324v = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f12325w = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f12313k = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f12314l = viewGroup.getPaddingBottom();
        WeakHashMap weakHashMap = c1.f10054a;
        i0.s(textView, 2);
        i0.s(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new x3(2, this));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void e(android.widget.TextView r4, int r5) {
        /*
            q0.a0.d(r4, r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto L_0x000c
        L_0x000a:
            r5 = 0
            goto L_0x0059
        L_0x000c:
            int[] r2 = v7.a.H
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            boolean r3 = r5.getValue(r1, r2)
            r5.recycle()
            if (r3 != 0) goto L_0x0021
            goto L_0x000a
        L_0x0021:
            int r5 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r5 < r3) goto L_0x002c
            int r5 = r2.getComplexUnit()
            goto L_0x0031
        L_0x002c:
            int r5 = r2.data
            int r5 = r5 >> r1
            r5 = r5 & 15
        L_0x0031:
            r3 = 2
            if (r5 != r3) goto L_0x004b
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L_0x0059
        L_0x004b:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L_0x0059:
            if (r5 == 0) goto L_0x005f
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.d.e(android.widget.TextView, int):void");
    }

    public static void f(float f10, float f11, int i10, TextView textView) {
        textView.setScaleX(f10);
        textView.setScaleY(f11);
        textView.setVisibility(i10);
    }

    public static void g(View view, int i10, int i11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i10;
        layoutParams.bottomMargin = i10;
        layoutParams.gravity = i11;
        view.setLayoutParams(layoutParams);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f12320r;
        return frameLayout != null ? frameLayout : this.f12322t;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i10 = 0;
        for (int i11 = 0; i11 < indexOfChild; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if ((childAt instanceof d) && childAt.getVisibility() == 0) {
                i10++;
            }
        }
        return i10;
    }

    private int getSuggestedIconHeight() {
        a aVar = this.K;
        int minimumHeight = aVar != null ? aVar.getMinimumHeight() / 2 : 0;
        return this.f12322t.getMeasuredWidth() + Math.max(minimumHeight, ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin) + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        int i10;
        a aVar = this.K;
        if (aVar == null) {
            i10 = 0;
        } else {
            i10 = aVar.getMinimumWidth() - this.K.f17078l.f17107b.f17104y.intValue();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        int max = Math.max(i10, layoutParams.leftMargin);
        return Math.max(i10, layoutParams.rightMargin) + this.f12322t.getMeasuredWidth() + max;
    }

    public static void i(ViewGroup viewGroup, int i10) {
        viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), i10);
    }

    public final void a(float f10, float f11) {
        this.f12315m = f10 - f11;
        this.f12316n = (f11 * 1.0f) / f10;
        this.f12317o = (f10 * 1.0f) / f11;
    }

    public final void b(q qVar) {
        CharSequence charSequence;
        int i10;
        this.f12327y = qVar;
        setCheckable(qVar.isCheckable());
        setChecked(qVar.isChecked());
        setEnabled(qVar.isEnabled());
        setIcon(qVar.getIcon());
        setTitle(qVar.f10003e);
        setId(qVar.f9999a);
        if (!TextUtils.isEmpty(qVar.f10015q)) {
            setContentDescription(qVar.f10015q);
        }
        if (!TextUtils.isEmpty(qVar.f10016r)) {
            charSequence = qVar.f10016r;
        } else {
            charSequence = qVar.f10003e;
        }
        if (Build.VERSION.SDK_INT > 23) {
            f5.a(this, charSequence);
        }
        if (qVar.isVisible()) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        setVisibility(i10);
        this.f12310h = true;
    }

    public final void c() {
        Drawable drawable = this.f12312j;
        ColorStateList colorStateList = this.f12311i;
        FrameLayout frameLayout = this.f12320r;
        RippleDrawable rippleDrawable = null;
        boolean z10 = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.F && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(r8.d.c(this.f12311i), (Drawable) null, activeIndicatorDrawable);
                z10 = false;
            } else if (drawable == null) {
                drawable = new RippleDrawable(r8.d.a(this.f12311i), (Drawable) null, (Drawable) null);
            }
        }
        if (frameLayout != null) {
            WeakHashMap weakHashMap = c1.f10054a;
            i0.q(frameLayout, rippleDrawable);
        }
        WeakHashMap weakHashMap2 = c1.f10054a;
        i0.q(this, drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z10);
        }
    }

    public final void d(float f10, float f11) {
        float f12;
        float f13;
        View view = this.f12321s;
        if (view != null) {
            b bVar = this.D;
            bVar.getClass();
            LinearInterpolator linearInterpolator = w7.a.f16153a;
            view.setScaleX((0.6f * f10) + 0.4f);
            view.setScaleY(bVar.a(f10, f11));
            int i10 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            if (i10 == 0) {
                f12 = 0.8f;
            } else {
                f12 = 0.0f;
            }
            if (i10 == 0) {
                f13 = 1.0f;
            } else {
                f13 = 0.2f;
            }
            view.setAlpha(w7.a.a(0.0f, 1.0f, f12, f13, f10));
        }
        this.E = f10;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f12320r;
        if (frameLayout != null && this.F) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        View view = this.f12321s;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    public a getBadge() {
        return this.K;
    }

    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    public q getItemData() {
        return this.f12327y;
    }

    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f12326x;
    }

    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f12323u;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f12323u;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void h(int i10) {
        boolean z10;
        int i11;
        View view = this.f12321s;
        if (view != null) {
            int min = Math.min(this.G, i10 - (this.J * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (!this.I || this.f12318p != 2) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                i11 = min;
            } else {
                i11 = this.H;
            }
            layoutParams.height = i11;
            layoutParams.width = min;
            view.setLayoutParams(layoutParams);
        }
    }

    public final int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        q qVar = this.f12327y;
        if (qVar != null && qVar.isCheckable() && this.f12327y.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, L);
        }
        return onCreateDrawableState;
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        a aVar = this.K;
        if (aVar != null && aVar.isVisible()) {
            q qVar = this.f12327y;
            CharSequence charSequence = qVar.f10003e;
            if (!TextUtils.isEmpty(qVar.f10015q)) {
                charSequence = this.f12327y.f10015q;
            }
            accessibilityNodeInfo.setContentDescription(charSequence + ", " + this.K.c());
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) l.c(0, 1, getItemVisiblePosition(), 1, isSelected()).f4038a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) g.f10903e.f10911a);
        }
        h.a(accessibilityNodeInfo).putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
    }

    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        post(new r(this, i10, 2));
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        View view = this.f12321s;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
            c();
        }
    }

    public void setActiveIndicatorEnabled(boolean z10) {
        this.F = z10;
        c();
        View view = this.f12321s;
        if (view != null) {
            view.setVisibility(z10 ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i10) {
        this.H = i10;
        h(getWidth());
    }

    public void setActiveIndicatorMarginHorizontal(int i10) {
        this.J = i10;
        h(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z10) {
        this.I = z10;
    }

    public void setActiveIndicatorWidth(int i10) {
        this.G = i10;
        h(getWidth());
    }

    public void setBadge(a aVar) {
        boolean z10;
        boolean z11;
        a aVar2 = this.K;
        if (aVar2 != aVar) {
            boolean z12 = true;
            if (aVar2 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            ImageView imageView = this.f12322t;
            if (z10 && imageView != null) {
                Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
                if (this.K != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    setClipChildren(true);
                    setClipToPadding(true);
                    a aVar3 = this.K;
                    if (aVar3 != null) {
                        if (aVar3.d() != null) {
                            aVar3.d().setForeground((Drawable) null);
                        } else {
                            imageView.getOverlay().remove(aVar3);
                        }
                    }
                    this.K = null;
                }
            }
            this.K = aVar;
            if (imageView != null) {
                if (aVar == null) {
                    z12 = false;
                }
                if (z12) {
                    setClipChildren(false);
                    setClipToPadding(false);
                    a aVar4 = this.K;
                    Rect rect = new Rect();
                    imageView.getDrawingRect(rect);
                    aVar4.setBounds(rect);
                    aVar4.h(imageView, (FrameLayout) null);
                    if (aVar4.d() != null) {
                        aVar4.d().setForeground(aVar4);
                    } else {
                        imageView.getOverlay().add(aVar4);
                    }
                }
            }
        }
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c4, code lost:
        if (r13 != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00cd, code lost:
        if (r13 != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00da, code lost:
        if (r13 != false) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e8, code lost:
        g(r2, r3, 17);
        i(r10, 0);
        r0.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fa, code lost:
        if (r13 != false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        g(getIconOrContainer(), (int) (((float) r12.f12313k) + r12.f12315m), 49);
        f(1.0f, 1.0f, 0, r0);
        r0 = r12.f12316n;
        f(r0, r0, 4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0113, code lost:
        g(getIconOrContainer(), r12.f12313k, 49);
        r2 = r12.f12317o;
        f(r2, r2, 4, r0);
        f(1.0f, 1.0f, 0, r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setChecked(boolean r13) {
        /*
            r12 = this;
            android.widget.TextView r0 = r12.f12325w
            int r1 = r0.getWidth()
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            android.widget.TextView r1 = r12.f12324v
            int r3 = r1.getWidth()
            int r3 = r3 / r2
            float r3 = (float) r3
            r1.setPivotX(r3)
            int r3 = r1.getBaseline()
            float r3 = (float) r3
            r1.setPivotY(r3)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r13 == 0) goto L_0x002e
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            boolean r5 = r12.F
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0096
            boolean r5 = r12.f12310h
            if (r5 == 0) goto L_0x0096
            java.util.WeakHashMap r5 = m0.c1.f10054a
            boolean r5 = m0.l0.b(r12)
            if (r5 != 0) goto L_0x0042
            goto L_0x0096
        L_0x0042:
            android.animation.ValueAnimator r5 = r12.C
            if (r5 == 0) goto L_0x004c
            r5.cancel()
            r5 = 0
            r12.C = r5
        L_0x004c:
            float[] r5 = new float[r2]
            float r8 = r12.E
            r5[r7] = r8
            r5[r6] = r4
            android.animation.ValueAnimator r5 = android.animation.ValueAnimator.ofFloat(r5)
            r12.C = r5
            o8.a r8 = new o8.a
            r8.<init>(r12, r4)
            r5.addUpdateListener(r8)
            android.animation.ValueAnimator r4 = r12.C
            android.content.Context r5 = r12.getContext()
            a1.b r8 = w7.a.f16154b
            r9 = 2130969455(0x7f04036f, float:1.7547592E38)
            android.animation.TimeInterpolator r5 = n8.a.d(r5, r9, r8)
            r4.setInterpolator(r5)
            android.animation.ValueAnimator r4 = r12.C
            android.content.Context r5 = r12.getContext()
            android.content.res.Resources r8 = r12.getResources()
            r9 = 2131427368(0x7f0b0028, float:1.847635E38)
            int r8 = r8.getInteger(r9)
            r9 = 2130969439(0x7f04035f, float:1.754756E38)
            int r5 = n8.a.c(r5, r9, r8)
            long r8 = (long) r5
            r4.setDuration(r8)
            android.animation.ValueAnimator r4 = r12.C
            r4.start()
            goto L_0x0099
        L_0x0096:
            r12.d(r4, r4)
        L_0x0099:
            int r4 = r12.f12318p
            r5 = -1
            r8 = 17
            r9 = 49
            android.view.ViewGroup r10 = r12.f12323u
            r11 = 4
            if (r4 == r5) goto L_0x00d0
            if (r4 == 0) goto L_0x00c7
            if (r4 == r6) goto L_0x00bf
            if (r4 == r2) goto L_0x00ad
            goto L_0x0124
        L_0x00ad:
            android.view.View r2 = r12.getIconOrContainer()
            int r3 = r12.f12313k
            g(r2, r3, r8)
            r2 = 8
            r0.setVisibility(r2)
            r1.setVisibility(r2)
            goto L_0x0124
        L_0x00bf:
            int r2 = r12.f12314l
            i(r10, r2)
            if (r13 == 0) goto L_0x0113
            goto L_0x00fc
        L_0x00c7:
            android.view.View r2 = r12.getIconOrContainer()
            int r3 = r12.f12313k
            if (r13 == 0) goto L_0x00e8
            goto L_0x00dc
        L_0x00d0:
            boolean r2 = r12.f12319q
            if (r2 == 0) goto L_0x00f5
            android.view.View r2 = r12.getIconOrContainer()
            int r3 = r12.f12313k
            if (r13 == 0) goto L_0x00e8
        L_0x00dc:
            g(r2, r3, r9)
            int r2 = r12.f12314l
            i(r10, r2)
            r0.setVisibility(r7)
            goto L_0x00f1
        L_0x00e8:
            g(r2, r3, r8)
            i(r10, r7)
            r0.setVisibility(r11)
        L_0x00f1:
            r1.setVisibility(r11)
            goto L_0x0124
        L_0x00f5:
            int r2 = r12.f12314l
            i(r10, r2)
            if (r13 == 0) goto L_0x0113
        L_0x00fc:
            android.view.View r2 = r12.getIconOrContainer()
            int r4 = r12.f12313k
            float r4 = (float) r4
            float r5 = r12.f12315m
            float r4 = r4 + r5
            int r4 = (int) r4
            g(r2, r4, r9)
            f(r3, r3, r7, r0)
            float r0 = r12.f12316n
            f(r0, r0, r11, r1)
            goto L_0x0124
        L_0x0113:
            android.view.View r2 = r12.getIconOrContainer()
            int r4 = r12.f12313k
            g(r2, r4, r9)
            float r2 = r12.f12317o
            f(r2, r2, r11, r0)
            f(r3, r3, r7, r1)
        L_0x0124:
            r12.refreshDrawableState()
            r12.setSelected(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.d.setChecked(boolean):void");
    }

    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f12324v.setEnabled(z10);
        this.f12325w.setEnabled(z10);
        this.f12322t.setEnabled(z10);
        e.a aVar = null;
        if (z10) {
            Context context = getContext();
            if (Build.VERSION.SDK_INT >= 24) {
                aVar = new e.a(13, (Object) c0.b(context, 1002));
            } else {
                aVar = new e.a(13, (Object) null);
            }
        }
        c1.s(this, aVar);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.A) {
            this.A = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = f0.d.g(drawable).mutate();
                this.B = drawable;
                ColorStateList colorStateList = this.f12328z;
                if (colorStateList != null) {
                    b.h(drawable, colorStateList);
                }
            }
            this.f12322t.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i10) {
        ImageView imageView = this.f12322t;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f12328z = colorStateList;
        if (this.f12327y != null && (drawable = this.B) != null) {
            b.h(drawable, colorStateList);
            this.B.invalidateSelf();
        }
    }

    public void setItemBackground(int i10) {
        Drawable drawable;
        if (i10 == 0) {
            drawable = null;
        } else {
            Context context = getContext();
            Object obj = c0.g.f2717a;
            drawable = c.b(context, i10);
        }
        setItemBackground(drawable);
    }

    public void setItemPaddingBottom(int i10) {
        if (this.f12314l != i10) {
            this.f12314l = i10;
            q qVar = this.f12327y;
            if (qVar != null) {
                setChecked(qVar.isChecked());
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        if (this.f12313k != i10) {
            this.f12313k = i10;
            q qVar = this.f12327y;
            if (qVar != null) {
                setChecked(qVar.isChecked());
            }
        }
    }

    public void setItemPosition(int i10) {
        this.f12326x = i10;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f12311i = colorStateList;
        c();
    }

    public void setLabelVisibilityMode(int i10) {
        boolean z10;
        b bVar;
        if (this.f12318p != i10) {
            this.f12318p = i10;
            if (!this.I || i10 != 2) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                bVar = N;
            } else {
                bVar = M;
            }
            this.D = bVar;
            h(getWidth());
            q qVar = this.f12327y;
            if (qVar != null) {
                setChecked(qVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z10) {
        if (this.f12319q != z10) {
            this.f12319q = z10;
            q qVar = this.f12327y;
            if (qVar != null) {
                setChecked(qVar.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i10) {
        TextView textView = this.f12325w;
        e(textView, i10);
        a(this.f12324v.getTextSize(), textView.getTextSize());
        textView.setTypeface(textView.getTypeface(), 1);
    }

    public void setTextAppearanceInactive(int i10) {
        TextView textView = this.f12324v;
        e(textView, i10);
        a(textView.getTextSize(), this.f12325w.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f12324v.setTextColor(colorStateList);
            this.f12325w.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f12324v.setText(charSequence);
        this.f12325w.setText(charSequence);
        q qVar = this.f12327y;
        if (qVar == null || TextUtils.isEmpty(qVar.f10015q)) {
            setContentDescription(charSequence);
        }
        q qVar2 = this.f12327y;
        if (qVar2 != null && !TextUtils.isEmpty(qVar2.f10016r)) {
            charSequence = this.f12327y.f10016r;
        }
        if (Build.VERSION.SDK_INT > 23) {
            f5.a(this, charSequence);
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f12312j = drawable;
        c();
    }
}
