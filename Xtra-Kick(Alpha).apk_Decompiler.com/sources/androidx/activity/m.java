package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.d0;
import androidx.lifecycle.g0;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import hb.h0;
import xa.j;

public class m extends Dialog implements d0, s {

    /* renamed from: h  reason: collision with root package name */
    public g0 f487h;

    /* renamed from: i  reason: collision with root package name */
    public final r f488i = new r(new e(1, this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Context context, int i10) {
        super(context, i10);
        j.f("context", context);
    }

    public static void b(m mVar) {
        j.f("this$0", mVar);
        super.onBackPressed();
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j.f("view", view);
        c();
        super.addContentView(view, layoutParams);
    }

    public final void c() {
        Window window = getWindow();
        j.c(window);
        h0.B1(window.getDecorView(), this);
        Window window2 = getWindow();
        j.c(window2);
        View decorView = window2.getDecorView();
        j.e("window!!.decorView", decorView);
        h0.A1(decorView, this);
    }

    public final t o() {
        g0 g0Var = this.f487h;
        if (g0Var != null) {
            return g0Var;
        }
        g0 g0Var2 = new g0(this);
        this.f487h = g0Var2;
        return g0Var2;
    }

    public final void onBackPressed() {
        this.f488i.b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            r rVar = this.f488i;
            rVar.f500e = onBackInvokedDispatcher;
            rVar.c();
        }
        g0 g0Var = this.f487h;
        if (g0Var == null) {
            g0Var = new g0(this);
            this.f487h = g0Var;
        }
        g0Var.f(r.ON_CREATE);
    }

    public void onStart() {
        super.onStart();
        g0 g0Var = this.f487h;
        if (g0Var == null) {
            g0Var = new g0(this);
            this.f487h = g0Var;
        }
        g0Var.f(r.ON_RESUME);
    }

    public void onStop() {
        g0 g0Var = this.f487h;
        if (g0Var == null) {
            g0Var = new g0(this);
            this.f487h = g0Var;
        }
        g0Var.f(r.ON_DESTROY);
        this.f487h = null;
        super.onStop();
    }

    public void setContentView(int i10) {
        c();
        super.setContentView(i10);
    }

    public void setContentView(View view) {
        j.f("view", view);
        c();
        super.setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j.f("view", view);
        c();
        super.setContentView(view, layoutParams);
    }
}
