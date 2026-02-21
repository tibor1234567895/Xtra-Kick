package b8;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.a3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import b4.e0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.woxthebox.draglistview.R;
import g.c;
import g.m0;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;
import m0.s1;
import o3.j0;

public final class h extends m0 {

    /* renamed from: l  reason: collision with root package name */
    public BottomSheetBehavior f2679l;

    /* renamed from: m  reason: collision with root package name */
    public FrameLayout f2680m;

    /* renamed from: n  reason: collision with root package name */
    public CoordinatorLayout f2681n;

    /* renamed from: o  reason: collision with root package name */
    public FrameLayout f2682o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2683p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2684q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2685r;

    /* renamed from: s  reason: collision with root package name */
    public g f2686s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f2687t;

    /* renamed from: u  reason: collision with root package name */
    public final f f2688u;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(android.content.Context r4, int r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 != 0) goto L_0x001b
            android.util.TypedValue r5 = new android.util.TypedValue
            r5.<init>()
            android.content.res.Resources$Theme r1 = r4.getTheme()
            r2 = 2130968712(0x7f040088, float:1.7546085E38)
            boolean r1 = r1.resolveAttribute(r2, r5, r0)
            if (r1 == 0) goto L_0x0018
            int r5 = r5.resourceId
            goto L_0x001b
        L_0x0018:
            r5 = 2132017827(0x7f1402a3, float:1.9673943E38)
        L_0x001b:
            r3.<init>(r4, r5)
            r3.f2683p = r0
            r3.f2684q = r0
            b8.f r4 = new b8.f
            r5 = 0
            r4.<init>(r5, r3)
            r3.f2688u = r4
            g.t r4 = r3.e()
            r4.v(r0)
            android.content.Context r4 = r3.getContext()
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int[] r0 = new int[r0]
            r1 = 2130969027(0x7f0401c3, float:1.7546724E38)
            r0[r5] = r1
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r0)
            boolean r4 = r4.getBoolean(r5, r5)
            r3.f2687t = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.h.<init>(android.content.Context, int):void");
    }

    public final void cancel() {
        j();
        super.cancel();
    }

    public final void i() {
        if (this.f2680m == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.f2680m = frameLayout;
            this.f2681n = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f2680m.findViewById(R.id.design_bottom_sheet);
            this.f2682o = frameLayout2;
            BottomSheetBehavior w10 = BottomSheetBehavior.w(frameLayout2);
            this.f2679l = w10;
            ArrayList arrayList = w10.W;
            f fVar = this.f2688u;
            if (!arrayList.contains(fVar)) {
                arrayList.add(fVar);
            }
            this.f2679l.C(this.f2683p);
        }
    }

    public final BottomSheetBehavior j() {
        if (this.f2679l == null) {
            i();
        }
        return this.f2679l;
    }

    public final FrameLayout k(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        i();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f2680m.findViewById(R.id.coordinator);
        if (i10 != 0 && view == null) {
            view = getLayoutInflater().inflate(i10, coordinatorLayout, false);
        }
        if (this.f2687t) {
            FrameLayout frameLayout = this.f2682o;
            e0 e0Var = new e0(21, this);
            WeakHashMap weakHashMap = c1.f10054a;
            o0.u(frameLayout, e0Var);
        }
        this.f2682o.removeAllViews();
        FrameLayout frameLayout2 = this.f2682o;
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new c(4, this));
        c1.p(this.f2682o, new j0(1, this));
        this.f2682o.setOnTouchListener(new a3(1, this));
        return this.f2680m;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z10 = this.f2687t && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f2680m;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z10);
            }
            CoordinatorLayout coordinatorLayout = this.f2681n;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z10);
            }
            s1.a(window, !z10);
            g gVar = this.f2686s;
            if (gVar != null) {
                gVar.e(window);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i10 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            if (i10 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    public final void onDetachedFromWindow() {
        g gVar = this.f2686s;
        if (gVar != null) {
            gVar.e((Window) null);
        }
    }

    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.f2679l;
        if (bottomSheetBehavior != null && bottomSheetBehavior.L == 5) {
            bottomSheetBehavior.E(4);
        }
    }

    public final void setCancelable(boolean z10) {
        super.setCancelable(z10);
        if (this.f2683p != z10) {
            this.f2683p = z10;
            BottomSheetBehavior bottomSheetBehavior = this.f2679l;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.C(z10);
            }
        }
    }

    public final void setCanceledOnTouchOutside(boolean z10) {
        super.setCanceledOnTouchOutside(z10);
        if (z10 && !this.f2683p) {
            this.f2683p = true;
        }
        this.f2684q = z10;
        this.f2685r = true;
    }

    public final void setContentView(int i10) {
        super.setContentView((View) k((View) null, i10, (ViewGroup.LayoutParams) null));
    }

    public final void setContentView(View view) {
        super.setContentView((View) k(view, 0, (ViewGroup.LayoutParams) null));
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView((View) k(view, 0, layoutParams));
    }
}
