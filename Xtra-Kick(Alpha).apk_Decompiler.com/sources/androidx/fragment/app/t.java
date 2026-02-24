package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.m;
import com.woxthebox.draglistview.R;
import hb.h0;

public class t extends c0 implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: d0  reason: collision with root package name */
    public Handler f1563d0;

    /* renamed from: e0  reason: collision with root package name */
    public final o f1564e0 = new o(0, this);

    /* renamed from: f0  reason: collision with root package name */
    public final p f1565f0 = new p(this);

    /* renamed from: g0  reason: collision with root package name */
    public final q f1566g0 = new q(this);

    /* renamed from: h0  reason: collision with root package name */
    public int f1567h0 = 0;

    /* renamed from: i0  reason: collision with root package name */
    public int f1568i0 = 0;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f1569j0 = true;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f1570k0 = true;

    /* renamed from: l0  reason: collision with root package name */
    public int f1571l0 = -1;

    /* renamed from: m0  reason: collision with root package name */
    public boolean f1572m0;

    /* renamed from: n0  reason: collision with root package name */
    public final r f1573n0 = new r(this);

    /* renamed from: o0  reason: collision with root package name */
    public Dialog f1574o0;

    /* renamed from: p0  reason: collision with root package name */
    public boolean f1575p0;

    /* renamed from: q0  reason: collision with root package name */
    public boolean f1576q0;

    /* renamed from: r0  reason: collision with root package name */
    public boolean f1577r0;

    /* renamed from: s0  reason: collision with root package name */
    public boolean f1578s0 = false;

    public void J() {
        this.K = true;
    }

    public void M(Context context) {
        super.M(context);
        this.X.g(this.f1573n0);
        if (!this.f1577r0) {
            this.f1576q0 = false;
        }
    }

    public void N(Bundle bundle) {
        super.N(bundle);
        this.f1563d0 = new Handler();
        this.f1570k0 = this.E == 0;
        if (bundle != null) {
            this.f1567h0 = bundle.getInt("android:style", 0);
            this.f1568i0 = bundle.getInt("android:theme", 0);
            this.f1569j0 = bundle.getBoolean("android:cancelable", true);
            this.f1570k0 = bundle.getBoolean("android:showsDialog", this.f1570k0);
            this.f1571l0 = bundle.getInt("android:backStackId", -1);
        }
    }

    public void Q() {
        this.K = true;
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            this.f1575p0 = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.f1574o0.dismiss();
            if (!this.f1576q0) {
                onDismiss(this.f1574o0);
            }
            this.f1574o0 = null;
            this.f1578s0 = false;
        }
    }

    public final void R() {
        this.K = true;
        if (!this.f1577r0 && !this.f1576q0) {
            this.f1576q0 = true;
        }
        this.X.k(this.f1573n0);
    }

    /* JADX INFO: finally extract failed */
    public LayoutInflater S(Bundle bundle) {
        LayoutInflater S = super.S(bundle);
        boolean z10 = this.f1570k0;
        if (!z10 || this.f1572m0) {
            if (c1.I(2)) {
                toString();
            }
            return S;
        }
        if (z10 && !this.f1578s0) {
            try {
                this.f1572m0 = true;
                Dialog n02 = n0(bundle);
                this.f1574o0 = n02;
                if (this.f1570k0) {
                    p0(n02, this.f1567h0);
                    Context v10 = v();
                    if (v10 instanceof Activity) {
                        this.f1574o0.setOwnerActivity((Activity) v10);
                    }
                    this.f1574o0.setCancelable(this.f1569j0);
                    this.f1574o0.setOnCancelListener(this.f1565f0);
                    this.f1574o0.setOnDismissListener(this.f1566g0);
                    this.f1578s0 = true;
                } else {
                    this.f1574o0 = null;
                }
                this.f1572m0 = false;
            } catch (Throwable th) {
                this.f1572m0 = false;
                throw th;
            }
        }
        if (c1.I(2)) {
            toString();
        }
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            return S.cloneInContext(dialog.getContext());
        }
        return S;
    }

    public void W(Bundle bundle) {
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i10 = this.f1567h0;
        if (i10 != 0) {
            bundle.putInt("android:style", i10);
        }
        int i11 = this.f1568i0;
        if (i11 != 0) {
            bundle.putInt("android:theme", i11);
        }
        boolean z10 = this.f1569j0;
        if (!z10) {
            bundle.putBoolean("android:cancelable", z10);
        }
        boolean z11 = this.f1570k0;
        if (!z11) {
            bundle.putBoolean("android:showsDialog", z11);
        }
        int i12 = this.f1571l0;
        if (i12 != -1) {
            bundle.putInt("android:backStackId", i12);
        }
    }

    public void X() {
        this.K = true;
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            this.f1575p0 = false;
            dialog.show();
            View decorView = this.f1574o0.getWindow().getDecorView();
            h0.B1(decorView, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    public void Y() {
        this.K = true;
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public final void a0(Bundle bundle) {
        Bundle bundle2;
        this.K = true;
        if (this.f1574o0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f1574o0.onRestoreInstanceState(bundle2);
        }
    }

    public final void b0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.b0(layoutInflater, viewGroup, bundle);
        if (this.M == null && this.f1574o0 != null && bundle != null && (bundle2 = bundle.getBundle("android:savedDialogState")) != null) {
            this.f1574o0.onRestoreInstanceState(bundle2);
        }
    }

    public void l0() {
        m0(false, false);
    }

    public final void m0(boolean z10, boolean z11) {
        if (!this.f1576q0) {
            this.f1576q0 = true;
            this.f1577r0 = false;
            Dialog dialog = this.f1574o0;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.f1574o0.dismiss();
                if (!z11) {
                    if (Looper.myLooper() == this.f1563d0.getLooper()) {
                        onDismiss(this.f1574o0);
                    } else {
                        this.f1563d0.post(this.f1564e0);
                    }
                }
            }
            this.f1575p0 = true;
            if (this.f1571l0 >= 0) {
                c1 x10 = x();
                int i10 = this.f1571l0;
                if (i10 >= 0) {
                    x10.w(new a1(x10, (String) null, i10), z10);
                    this.f1571l0 = -1;
                    return;
                }
                throw new IllegalArgumentException(h.i("Bad id: ", i10));
            }
            a aVar = new a(x());
            aVar.f1548p = true;
            aVar.k(this);
            if (z10) {
                aVar.h(true);
            } else {
                aVar.g();
            }
        }
    }

    public Dialog n0(Bundle bundle) {
        if (c1.I(3)) {
            toString();
        }
        return new m(f0(), this.f1568i0);
    }

    public final Dialog o0() {
        Dialog dialog = this.f1574o0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.f1575p0) {
            if (c1.I(3)) {
                toString();
            }
            m0(true, true);
        }
    }

    public void p0(Dialog dialog, int i10) {
        if (!(i10 == 1 || i10 == 2)) {
            if (i10 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public final void q0(c1 c1Var, String str) {
        this.f1576q0 = false;
        this.f1577r0 = true;
        c1Var.getClass();
        a aVar = new a(c1Var);
        aVar.f1548p = true;
        aVar.d(0, this, str, 1);
        aVar.g();
    }

    public final h0 r() {
        return new s(this, new w(this));
    }
}
