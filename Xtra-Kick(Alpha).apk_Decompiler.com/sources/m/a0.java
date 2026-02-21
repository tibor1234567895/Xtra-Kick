package m;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import com.woxthebox.draglistview.R;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;

public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f9890a;

    /* renamed from: b  reason: collision with root package name */
    public final o f9891b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f9892c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9893d;

    /* renamed from: e  reason: collision with root package name */
    public final int f9894e;

    /* renamed from: f  reason: collision with root package name */
    public View f9895f;

    /* renamed from: g  reason: collision with root package name */
    public int f9896g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9897h;

    /* renamed from: i  reason: collision with root package name */
    public b0 f9898i;

    /* renamed from: j  reason: collision with root package name */
    public x f9899j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f9900k;

    /* renamed from: l  reason: collision with root package name */
    public final y f9901l;

    public a0(int i10, int i11, Context context, View view, o oVar, boolean z10) {
        this.f9896g = 8388611;
        this.f9901l = new y(0, this);
        this.f9890a = context;
        this.f9891b = oVar;
        this.f9895f = view;
        this.f9892c = z10;
        this.f9893d = i10;
        this.f9894e = i11;
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [m.x, m.c0] */
    /* JADX WARNING: type inference failed for: r7v1, types: [m.h0] */
    /* JADX WARNING: type inference failed for: r1v10, types: [m.i] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final m.x a() {
        /*
            r14 = this;
            m.x r0 = r14.f9899j
            if (r0 != 0) goto L_0x0077
            java.lang.String r0 = "window"
            android.content.Context r1 = r14.f9890a
            java.lang.Object r0 = r1.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            m.z.a(r0, r2)
            int r0 = r2.x
            int r2 = r2.y
            int r0 = java.lang.Math.min(r0, r2)
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131165206(0x7f070016, float:1.7944623E38)
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0045
            m.i r0 = new m.i
            android.content.Context r2 = r14.f9890a
            android.view.View r3 = r14.f9895f
            int r4 = r14.f9893d
            int r5 = r14.f9894e
            boolean r6 = r14.f9892c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0057
        L_0x0045:
            m.h0 r0 = new m.h0
            android.content.Context r10 = r14.f9890a
            m.o r12 = r14.f9891b
            android.view.View r11 = r14.f9895f
            int r8 = r14.f9893d
            int r9 = r14.f9894e
            boolean r13 = r14.f9892c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0057:
            m.o r1 = r14.f9891b
            r0.n(r1)
            m.y r1 = r14.f9901l
            r0.t(r1)
            android.view.View r1 = r14.f9895f
            r0.p(r1)
            m.b0 r1 = r14.f9898i
            r0.l(r1)
            boolean r1 = r14.f9897h
            r0.q(r1)
            int r1 = r14.f9896g
            r0.r(r1)
            r14.f9899j = r0
        L_0x0077:
            m.x r0 = r14.f9899j
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.a0.a():m.x");
    }

    public final boolean b() {
        x xVar = this.f9899j;
        return xVar != null && xVar.b();
    }

    public void c() {
        this.f9899j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f9900k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i10, int i11, boolean z10, boolean z11) {
        x a10 = a();
        a10.u(z11);
        if (z10) {
            int i12 = this.f9896g;
            View view = this.f9895f;
            WeakHashMap weakHashMap = c1.f10054a;
            if ((Gravity.getAbsoluteGravity(i12, j0.d(view)) & 7) == 5) {
                i10 -= this.f9895f.getWidth();
            }
            a10.s(i10);
            a10.v(i11);
            int i13 = (int) ((this.f9890a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a10.f10035h = new Rect(i10 - i13, i11 - i13, i10 + i13, i11 + i13);
        }
        a10.d();
    }

    public a0(Context context, o oVar, View view, boolean z10) {
        this(R.attr.actionOverflowMenuStyle, 0, context, view, oVar, z10);
    }
}
