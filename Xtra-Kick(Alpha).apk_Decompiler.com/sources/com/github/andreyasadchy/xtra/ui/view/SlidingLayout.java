package com.github.andreyasadchy.xtra.ui.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.media3.ui.DefaultTimeBar;
import com.woxthebox.draglistview.R;
import hb.h0;
import java.util.ArrayList;
import la.i;
import q7.b;
import q7.c;
import q7.d;
import q7.e;
import u0.h;
import xa.j;

public final class SlidingLayout extends LinearLayout {
    public static final /* synthetic */ int B = 0;
    public final e A = new e(this);

    /* renamed from: h  reason: collision with root package name */
    public boolean f3532h;

    /* renamed from: i  reason: collision with root package name */
    public final h f3533i;

    /* renamed from: j  reason: collision with root package name */
    public View f3534j;

    /* renamed from: k  reason: collision with root package name */
    public View f3535k;

    /* renamed from: l  reason: collision with root package name */
    public DefaultTimeBar f3536l;

    /* renamed from: m  reason: collision with root package name */
    public int f3537m;

    /* renamed from: n  reason: collision with root package name */
    public int f3538n;

    /* renamed from: o  reason: collision with root package name */
    public int f3539o;

    /* renamed from: p  reason: collision with root package name */
    public float f3540p;

    /* renamed from: q  reason: collision with root package name */
    public int f3541q;

    /* renamed from: r  reason: collision with root package name */
    public int f3542r;

    /* renamed from: s  reason: collision with root package name */
    public float f3543s;

    /* renamed from: t  reason: collision with root package name */
    public float f3544t;

    /* renamed from: u  reason: collision with root package name */
    public final float[] f3545u = new float[2];

    /* renamed from: v  reason: collision with root package name */
    public boolean f3546v = true;

    /* renamed from: w  reason: collision with root package name */
    public boolean f3547w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f3548x;

    /* renamed from: y  reason: collision with root package name */
    public Integer f3549y;

    /* renamed from: z  reason: collision with root package name */
    public final ArrayList f3550z = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.f("context", context);
        j.f("attrs", attributeSet);
        h hVar = new h(getContext(), this, new d(0, this));
        hVar.f15176b = (int) (((float) hVar.f15176b) * 1.0f);
        this.f3533i = hVar;
        setId(R.id.slidingLayout);
    }

    public static final void c(SlidingLayout slidingLayout) {
        int i10;
        slidingLayout.f3539o = slidingLayout.getHeight() / 5;
        slidingLayout.setPivotX(((float) slidingLayout.getWidth()) * 0.95f);
        if (slidingLayout.d()) {
            slidingLayout.f3538n = slidingLayout.getHeight() / 2;
            int height = slidingLayout.getHeight() * 2;
            View view = slidingLayout.f3534j;
            if (view != null) {
                i10 = height - view.getHeight();
            } else {
                j.l("dragView");
                throw null;
            }
        } else {
            slidingLayout.f3538n = (int) (((float) slidingLayout.getHeight()) / 1.5f);
            i10 = slidingLayout.getHeight();
        }
        slidingLayout.setPivotY(((float) i10) - slidingLayout.f3540p);
    }

    public final void a(float f10, float f11) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{f10}), PropertyValuesHolder.ofFloat("scaleY", new float[]{f11})});
        ofPropertyValuesHolder.setDuration(250);
        ofPropertyValuesHolder.addListener(this.A);
        ofPropertyValuesHolder.start();
    }

    public final void b() {
        Context context = getContext();
        j.e("context", context);
        this.f3532h = h0.l1(context).getBoolean("debug_secondview", false);
        View view = this.f3534j;
        if (view != null) {
            view.post(new b(this, 0));
            View view2 = this.f3535k;
            if (view2 != null) {
                view2.post(new b(this, 1));
                return;
            }
            return;
        }
        j.l("dragView");
        throw null;
    }

    public final void computeScroll() {
        if (this.f3533i.g()) {
            postInvalidateOnAnimation();
        }
    }

    public final boolean d() {
        return getOrientation() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r8 = r1[1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e(android.view.View r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 2
            int[] r1 = new int[r0]
            r6.getLocationOnScreen(r1)
            int[] r0 = new int[r0]
            r5.getLocationOnScreen(r0)
            r2 = 0
            r3 = r0[r2]
            int r3 = r3 + r7
            r7 = 1
            r0 = r0[r7]
            int r0 = r0 + r8
            r8 = r1[r2]
            if (r3 < r8) goto L_0x002a
            int r4 = r6.getWidth()
            int r4 = r4 + r8
            if (r3 >= r4) goto L_0x002a
            r8 = r1[r7]
            if (r0 < r8) goto L_0x002a
            int r6 = r6.getHeight()
            int r6 = r6 + r8
            if (r0 >= r6) goto L_0x002a
            r2 = 1
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.view.SlidingLayout.e(android.view.View, int, int):boolean");
    }

    public final void f() {
        int i10;
        this.f3546v = true;
        View view = this.f3535k;
        if (view != null) {
            view.requestLayout();
            if (d()) {
                i10 = 0;
            } else {
                this.f3548x = true;
                Integer num = this.f3549y;
                j.c(num);
                i10 = num.intValue();
            }
            view.setVisibility(i10);
        }
        a(1.0f, 1.0f);
        for (c e10 : this.f3550z) {
            e10.e();
        }
    }

    public final void g() {
        this.f3546v = false;
        View view = this.f3535k;
        if (view != null) {
            view.layout(0, 0, 0, 0);
            if (!d()) {
                this.f3548x = true;
                this.f3549y = Integer.valueOf(view.getVisibility());
            }
            h0.J0(view);
        }
        a(this.f3543s, this.f3544t);
        if (this.f3541q != 0) {
            PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("top", new int[]{0});
            int[] iArr = new int[1];
            View view2 = this.f3534j;
            if (view2 != null) {
                iArr[0] = view2.getHeight();
                PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("bottom", iArr);
                View view3 = this.f3534j;
                if (view3 != null) {
                    ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view3, new PropertyValuesHolder[]{ofInt, ofInt2});
                    ofPropertyValuesHolder.setDuration(250);
                    ofPropertyValuesHolder.start();
                } else {
                    j.l("dragView");
                    throw null;
                }
            } else {
                j.l("dragView");
                throw null;
            }
        }
        for (c l10 : this.f3550z) {
            l10.l();
        }
    }

    public final Integer getMaximizedSecondViewVisibility() {
        return this.f3549y;
    }

    public final View getSecondView() {
        return this.f3535k;
    }

    public final void h(int i10, int i11) {
        View view = this.f3534j;
        if (view == null) {
            j.l("dragView");
            throw null;
        } else if (this.f3533i.t(view, i10, i11)) {
            postInvalidateOnAnimation();
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        j.f("newConfig", configuration);
        super.onConfigurationChanged(configuration);
        int i10 = 1;
        if (configuration.orientation != 1) {
            i10 = 0;
        }
        setOrientation(i10);
        b();
    }

    public final void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        j.e("getChildAt(0)", childAt);
        this.f3534j = childAt;
        this.f3535k = getChildAt(1);
        b();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        j.f("ev", motionEvent);
        int actionMasked = motionEvent.getActionMasked() & 255;
        h hVar = this.f3533i;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                hVar.a();
                return false;
            }
        } else if (motionEvent.getPointerId(motionEvent.getActionIndex()) == -1) {
            return false;
        }
        View view = this.f3534j;
        if (view != null) {
            hVar.getClass();
            return hVar.s(motionEvent) || h.k(view, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        j.l("dragView");
        throw null;
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        View view = this.f3534j;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            if (!this.f3547w || this.f3548x) {
                View view2 = this.f3534j;
                if (view2 != null) {
                    int i15 = this.f3542r;
                    int i16 = this.f3541q;
                    if (!this.f3546v) {
                        i14 = getWidth();
                    } else if (view2 != null) {
                        i14 = view2.getMeasuredWidth() + this.f3542r;
                    } else {
                        j.l("dragView");
                        throw null;
                    }
                    view2.layout(i15, i16, i14, this.f3541q + measuredHeight);
                } else {
                    j.l("dragView");
                    throw null;
                }
            }
            View view3 = this.f3535k;
            if (view3 != null && this.f3546v) {
                if (!(view3.getVisibility() == 0)) {
                    return;
                }
                if (d()) {
                    int i17 = this.f3541q;
                    view3.layout(i10, measuredHeight + i17, i12, i13 + i17);
                    return;
                }
                View view4 = this.f3534j;
                if (view4 != null) {
                    view3.layout(view4.getMeasuredWidth(), this.f3541q, getWidth(), measuredHeight + this.f3541q);
                } else {
                    j.l("dragView");
                    throw null;
                }
            }
        } else {
            j.l("dragView");
            throw null;
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f3546v = bundle.getBoolean("isMaximized");
            this.f3549y = Integer.valueOf(bundle.getInt("secondViewVisibility"));
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    public final Parcelable onSaveInstanceState() {
        View view = this.f3535k;
        if (view != null && !d() && this.f3546v) {
            this.f3549y = Integer.valueOf(view.getVisibility());
        }
        return h0.r(new i("superState", super.onSaveInstanceState()), new i("isMaximized", Boolean.valueOf(this.f3546v)), new i("secondViewVisibility", this.f3549y));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        j.f("event", motionEvent);
        try {
            if (this.f3547w) {
                return true;
            }
            DefaultTimeBar defaultTimeBar = this.f3536l;
            if (defaultTimeBar == null || !defaultTimeBar.isPressed()) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                View view = this.f3534j;
                if (view != null) {
                    view.dispatchTouchEvent(motionEvent);
                    return true;
                }
                j.l("dragView");
                throw null;
            }
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            View view2 = this.f3534j;
            if (view2 != null) {
                boolean e10 = e(view2, x10, y10);
                boolean S0 = h0.S0(motionEvent, this.f3545u);
                if (y10 > 100 || !this.f3546v) {
                    this.f3533i.l(motionEvent);
                }
                if (e10) {
                    if (this.f3546v) {
                        View view3 = this.f3534j;
                        if (view3 != null) {
                            view3.dispatchTouchEvent(motionEvent);
                        } else {
                            j.l("dragView");
                            throw null;
                        }
                    } else if (S0) {
                        f();
                        return true;
                    }
                }
                if (S0) {
                    super.performClick();
                }
                if (!e10) {
                    View view4 = this.f3535k;
                    if (view4 == null || !e(view4, x10, y10)) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            j.l("dragView");
            throw null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean performClick() {
        super.performClick();
        return true;
    }

    public final void setMaximizedSecondViewVisibility(Integer num) {
        this.f3549y = num;
    }

    public final void setSecondView(View view) {
        this.f3535k = view;
    }
}
