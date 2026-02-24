package x8;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;
import m0.c1;
import m0.i0;
import m8.w;

public final class g extends LinearLayout {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f16751k = 0;

    /* renamed from: h  reason: collision with root package name */
    public ValueAnimator f16752h;

    /* renamed from: i  reason: collision with root package name */
    public int f16753i = -1;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TabLayout f16754j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(TabLayout tabLayout, Context context) {
        super(context);
        this.f16754j = tabLayout;
        setWillNotDraw(false);
    }

    public final void a(int i10) {
        TabLayout tabLayout = this.f16754j;
        if (tabLayout.W == 0 || (tabLayout.getTabSelectedIndicator().getBounds().left == -1 && tabLayout.getTabSelectedIndicator().getBounds().right == -1)) {
            View childAt = getChildAt(i10);
            c cVar = tabLayout.P;
            Drawable drawable = tabLayout.f3876v;
            cVar.getClass();
            RectF a10 = c.a(tabLayout, childAt);
            drawable.setBounds((int) a10.left, drawable.getBounds().top, (int) a10.right, drawable.getBounds().bottom);
            tabLayout.f3862h = i10;
        }
    }

    public final void b(int i10) {
        TabLayout tabLayout = this.f16754j;
        Rect bounds = tabLayout.f3876v.getBounds();
        tabLayout.f3876v.setBounds(bounds.left, 0, bounds.right, i10);
        requestLayout();
    }

    public final void c(View view, View view2, float f10) {
        boolean z10;
        if (view == null || view.getWidth() <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            TabLayout tabLayout = this.f16754j;
            tabLayout.P.b(tabLayout, view, view2, f10, tabLayout.f3876v);
        } else {
            TabLayout tabLayout2 = this.f16754j;
            Drawable drawable = tabLayout2.f3876v;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout2.f3876v.getBounds().bottom);
        }
        WeakHashMap weakHashMap = c1.f10054a;
        i0.k(this);
    }

    public final void d(int i10, int i11, boolean z10) {
        TabLayout tabLayout = this.f16754j;
        if (tabLayout.f3862h != i10) {
            View childAt = getChildAt(tabLayout.getSelectedTabPosition());
            View childAt2 = getChildAt(i10);
            if (childAt2 == null) {
                a(tabLayout.getSelectedTabPosition());
                return;
            }
            tabLayout.f3862h = i10;
            f fVar = new f(this, childAt, childAt2);
            if (z10) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f16752h = valueAnimator;
                valueAnimator.setInterpolator(tabLayout.Q);
                valueAnimator.setDuration((long) i11);
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(fVar);
                valueAnimator.start();
                return;
            }
            this.f16752h.removeAllUpdateListeners();
            this.f16752h.addUpdateListener(fVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            com.google.android.material.tabs.TabLayout r0 = r6.f16754j
            android.graphics.drawable.Drawable r1 = r0.f3876v
            android.graphics.Rect r1 = r1.getBounds()
            int r1 = r1.height()
            if (r1 >= 0) goto L_0x0014
            android.graphics.drawable.Drawable r1 = r0.f3876v
            int r1 = r1.getIntrinsicHeight()
        L_0x0014:
            int r2 = r0.I
            if (r2 == 0) goto L_0x0033
            r3 = 1
            r4 = 2
            if (r2 == r3) goto L_0x0024
            r3 = 0
            if (r2 == r4) goto L_0x003d
            r1 = 3
            if (r2 == r1) goto L_0x0039
            r1 = 0
            goto L_0x003d
        L_0x0024:
            int r2 = r6.getHeight()
            int r2 = r2 - r1
            int r3 = r2 / 2
            int r2 = r6.getHeight()
            int r2 = r2 + r1
            int r1 = r2 / 2
            goto L_0x003d
        L_0x0033:
            int r2 = r6.getHeight()
            int r3 = r2 - r1
        L_0x0039:
            int r1 = r6.getHeight()
        L_0x003d:
            android.graphics.drawable.Drawable r2 = r0.f3876v
            android.graphics.Rect r2 = r2.getBounds()
            int r2 = r2.width()
            if (r2 <= 0) goto L_0x005d
            android.graphics.drawable.Drawable r2 = r0.f3876v
            android.graphics.Rect r2 = r2.getBounds()
            android.graphics.drawable.Drawable r4 = r0.f3876v
            int r5 = r2.left
            int r2 = r2.right
            r4.setBounds(r5, r3, r2, r1)
            android.graphics.drawable.Drawable r0 = r0.f3876v
            r0.draw(r7)
        L_0x005d:
            super.draw(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x8.g.draw(android.graphics.Canvas):void");
    }

    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        ValueAnimator valueAnimator = this.f16752h;
        TabLayout tabLayout = this.f16754j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            if (tabLayout.f3862h == -1) {
                tabLayout.f3862h = tabLayout.getSelectedTabPosition();
            }
            a(tabLayout.f3862h);
            return;
        }
        d(tabLayout.getSelectedTabPosition(), -1, false);
    }

    public final void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            TabLayout tabLayout = this.f16754j;
            boolean z10 = true;
            if (tabLayout.G == 1 || tabLayout.J == 2) {
                int childCount = getChildCount();
                int i12 = 0;
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    if (childAt.getVisibility() == 0) {
                        i12 = Math.max(i12, childAt.getMeasuredWidth());
                    }
                }
                if (i12 > 0) {
                    if (i12 * childCount <= getMeasuredWidth() - (((int) w.b(getContext(), 16)) * 2)) {
                        boolean z11 = false;
                        for (int i14 = 0; i14 < childCount; i14++) {
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i14).getLayoutParams();
                            if (layoutParams.width != i12 || layoutParams.weight != 0.0f) {
                                layoutParams.width = i12;
                                layoutParams.weight = 0.0f;
                                z11 = true;
                            }
                        }
                        z10 = z11;
                    } else {
                        tabLayout.G = 0;
                        tabLayout.l(false);
                    }
                    if (z10) {
                        super.onMeasure(i10, i11);
                    }
                }
            }
        }
    }

    public final void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (Build.VERSION.SDK_INT < 23 && this.f16753i != i10) {
            requestLayout();
            this.f16753i = i10;
        }
    }
}
