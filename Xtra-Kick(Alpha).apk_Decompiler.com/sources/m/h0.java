package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.h3;
import androidx.appcompat.widget.o2;
import androidx.appcompat.widget.q0;
import com.woxthebox.draglistview.R;

public final class h0 extends x implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public int A = 0;
    public boolean B;

    /* renamed from: i  reason: collision with root package name */
    public final Context f9920i;

    /* renamed from: j  reason: collision with root package name */
    public final o f9921j;

    /* renamed from: k  reason: collision with root package name */
    public final l f9922k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f9923l;

    /* renamed from: m  reason: collision with root package name */
    public final int f9924m;

    /* renamed from: n  reason: collision with root package name */
    public final int f9925n;

    /* renamed from: o  reason: collision with root package name */
    public final int f9926o;

    /* renamed from: p  reason: collision with root package name */
    public final h3 f9927p;

    /* renamed from: q  reason: collision with root package name */
    public final e f9928q = new e(1, this);

    /* renamed from: r  reason: collision with root package name */
    public final f f9929r = new f(1, this);

    /* renamed from: s  reason: collision with root package name */
    public PopupWindow.OnDismissListener f9930s;

    /* renamed from: t  reason: collision with root package name */
    public View f9931t;

    /* renamed from: u  reason: collision with root package name */
    public View f9932u;

    /* renamed from: v  reason: collision with root package name */
    public b0 f9933v;

    /* renamed from: w  reason: collision with root package name */
    public ViewTreeObserver f9934w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f9935x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f9936y;

    /* renamed from: z  reason: collision with root package name */
    public int f9937z;

    public h0(int i10, int i11, Context context, View view, o oVar, boolean z10) {
        this.f9920i = context;
        this.f9921j = oVar;
        this.f9923l = z10;
        this.f9922k = new l(oVar, LayoutInflater.from(context), z10, R.layout.abc_popup_menu_item_layout);
        this.f9925n = i10;
        this.f9926o = i11;
        Resources resources = context.getResources();
        this.f9924m = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f9931t = view;
        this.f9927p = new h3(context, i10, i11);
        oVar.b(this, context);
    }

    public final void a(o oVar, boolean z10) {
        if (oVar == this.f9921j) {
            dismiss();
            b0 b0Var = this.f9933v;
            if (b0Var != null) {
                b0Var.a(oVar, z10);
            }
        }
    }

    public final boolean b() {
        return !this.f9935x && this.f9927p.b();
    }

    public final void c(Parcelable parcelable) {
    }

    public final void d() {
        View view;
        boolean z10;
        Rect rect;
        boolean z11 = true;
        if (!b()) {
            if (this.f9935x || (view = this.f9931t) == null) {
                z11 = false;
            } else {
                this.f9932u = view;
                h3 h3Var = this.f9927p;
                h3Var.G.setOnDismissListener(this);
                h3Var.f766w = this;
                h3Var.F = true;
                q0 q0Var = h3Var.G;
                q0Var.setFocusable(true);
                View view2 = this.f9932u;
                if (this.f9934w == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f9934w = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f9928q);
                }
                view2.addOnAttachStateChangeListener(this.f9929r);
                h3Var.f765v = view2;
                h3Var.f762s = this.A;
                boolean z12 = this.f9936y;
                Context context = this.f9920i;
                l lVar = this.f9922k;
                if (!z12) {
                    this.f9937z = x.o(lVar, context, this.f9924m);
                    this.f9936y = true;
                }
                h3Var.q(this.f9937z);
                q0Var.setInputMethodMode(2);
                Rect rect2 = this.f10035h;
                if (rect2 != null) {
                    rect = new Rect(rect2);
                } else {
                    rect = null;
                }
                h3Var.E = rect;
                h3Var.d();
                o2 o2Var = h3Var.f753j;
                o2Var.setOnKeyListener(this);
                if (this.B) {
                    o oVar = this.f9921j;
                    if (oVar.f9984m != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, o2Var, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(oVar.f9984m);
                        }
                        frameLayout.setEnabled(false);
                        o2Var.addHeaderView(frameLayout, (Object) null, false);
                    }
                }
                h3Var.p(lVar);
                h3Var.d();
            }
        }
        if (!z11) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public final void dismiss() {
        if (b()) {
            this.f9927p.dismiss();
        }
    }

    public final void e(boolean z10) {
        this.f9936y = false;
        l lVar = this.f9922k;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
    }

    public final o2 f() {
        return this.f9927p.f753j;
    }

    public final boolean i() {
        return false;
    }

    public final Parcelable j() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(m.i0 r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x007a
            m.a0 r0 = new m.a0
            android.content.Context r5 = r9.f9920i
            android.view.View r6 = r9.f9932u
            boolean r8 = r9.f9923l
            int r3 = r9.f9925n
            int r4 = r9.f9926o
            r2 = r0
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            m.b0 r2 = r9.f9933v
            r0.f9898i = r2
            m.x r3 = r0.f9899j
            if (r3 == 0) goto L_0x0023
            r3.l(r2)
        L_0x0023:
            boolean r2 = m.x.w(r10)
            r0.f9897h = r2
            m.x r3 = r0.f9899j
            if (r3 == 0) goto L_0x0030
            r3.q(r2)
        L_0x0030:
            android.widget.PopupWindow$OnDismissListener r2 = r9.f9930s
            r0.f9900k = r2
            r2 = 0
            r9.f9930s = r2
            m.o r2 = r9.f9921j
            r2.c(r1)
            androidx.appcompat.widget.h3 r2 = r9.f9927p
            int r3 = r2.f756m
            int r2 = r2.n()
            int r4 = r9.A
            android.view.View r5 = r9.f9931t
            java.util.WeakHashMap r6 = m0.c1.f10054a
            int r5 = m0.j0.d(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x005e
            android.view.View r4 = r9.f9931t
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L_0x005e:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L_0x0066
            goto L_0x006f
        L_0x0066:
            android.view.View r4 = r0.f9895f
            if (r4 != 0) goto L_0x006c
            r0 = 0
            goto L_0x0070
        L_0x006c:
            r0.d(r3, r2, r5, r5)
        L_0x006f:
            r0 = 1
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            m.b0 r0 = r9.f9933v
            if (r0 == 0) goto L_0x0079
            r0.n(r10)
        L_0x0079:
            return r5
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m.h0.k(m.i0):boolean");
    }

    public final void l(b0 b0Var) {
        this.f9933v = b0Var;
    }

    public final void n(o oVar) {
    }

    public final void onDismiss() {
        this.f9935x = true;
        this.f9921j.c(true);
        ViewTreeObserver viewTreeObserver = this.f9934w;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f9934w = this.f9932u.getViewTreeObserver();
            }
            this.f9934w.removeGlobalOnLayoutListener(this.f9928q);
            this.f9934w = null;
        }
        this.f9932u.removeOnAttachStateChangeListener(this.f9929r);
        PopupWindow.OnDismissListener onDismissListener = this.f9930s;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public final void p(View view) {
        this.f9931t = view;
    }

    public final void q(boolean z10) {
        this.f9922k.f9967j = z10;
    }

    public final void r(int i10) {
        this.A = i10;
    }

    public final void s(int i10) {
        this.f9927p.f756m = i10;
    }

    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f9930s = onDismissListener;
    }

    public final void u(boolean z10) {
        this.B = z10;
    }

    public final void v(int i10) {
        this.f9927p.j(i10);
    }
}
