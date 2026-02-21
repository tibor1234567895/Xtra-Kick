package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.support.v4.media.session.u;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.r0;
import androidx.lifecycle.a2;
import androidx.lifecycle.b0;
import androidx.lifecycle.b2;
import androidx.lifecycle.d0;
import androidx.lifecycle.d1;
import androidx.lifecycle.g0;
import androidx.lifecycle.g1;
import androidx.lifecycle.g2;
import androidx.lifecycle.h2;
import androidx.lifecycle.m;
import androidx.lifecycle.o1;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.s1;
import androidx.lifecycle.t;
import b0.k;
import b0.l;
import b0.m0;
import b0.n0;
import b0.o0;
import b1.f;
import c0.i;
import com.woxthebox.draglistview.R;
import d.a;
import d.b;
import hb.h0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import m0.q;
import t3.e;
import t3.g;
import t3.h;
import xa.j;

public class ComponentActivity extends k implements h2, m, h, s, androidx.activity.result.h, c0.h, i, m0, n0, q {

    /* renamed from: i  reason: collision with root package name */
    public final a f448i = new a();

    /* renamed from: j  reason: collision with root package name */
    public final u f449j = new u((Runnable) new e(0, this));

    /* renamed from: k  reason: collision with root package name */
    public final g0 f450k;

    /* renamed from: l  reason: collision with root package name */
    public final g f451l;

    /* renamed from: m  reason: collision with root package name */
    public g2 f452m;

    /* renamed from: n  reason: collision with root package name */
    public s1 f453n;

    /* renamed from: o  reason: collision with root package name */
    public final r f454o;

    /* renamed from: p  reason: collision with root package name */
    public final i f455p;

    /* renamed from: q  reason: collision with root package name */
    public final CopyOnWriteArrayList f456q;

    /* renamed from: r  reason: collision with root package name */
    public final CopyOnWriteArrayList f457r;

    /* renamed from: s  reason: collision with root package name */
    public final CopyOnWriteArrayList f458s;

    /* renamed from: t  reason: collision with root package name */
    public final CopyOnWriteArrayList f459t;

    /* renamed from: u  reason: collision with root package name */
    public final CopyOnWriteArrayList f460u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f461v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f462w;

    public ComponentActivity() {
        g0 g0Var = new g0(this);
        this.f450k = g0Var;
        g.f14538d.getClass();
        g gVar = new g(this);
        this.f451l = gVar;
        this.f454o = new r(new h(0, this));
        new AtomicInteger();
        this.f455p = new i(this);
        this.f456q = new CopyOnWriteArrayList();
        this.f457r = new CopyOnWriteArrayList();
        this.f458s = new CopyOnWriteArrayList();
        this.f459t = new CopyOnWriteArrayList();
        this.f460u = new CopyOnWriteArrayList();
        this.f461v = false;
        this.f462w = false;
        int i10 = Build.VERSION.SDK_INT;
        g0Var.a(new b0() {
            public final void d(d0 d0Var, r rVar) {
                View view;
                if (rVar == r.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    if (window != null) {
                        view = window.peekDecorView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        view.cancelPendingInputEvents();
                    }
                }
            }
        });
        g0Var.a(new b0() {
            public final void d(d0 d0Var, r rVar) {
                if (rVar == r.ON_DESTROY) {
                    ComponentActivity.this.f448i.f4078b = null;
                    if (!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.m().a();
                    }
                }
            }
        });
        g0Var.a(new b0() {
            public final void d(d0 d0Var, r rVar) {
                ComponentActivity componentActivity = ComponentActivity.this;
                if (componentActivity.f452m == null) {
                    l lVar = (l) componentActivity.getLastNonConfigurationInstance();
                    if (lVar != null) {
                        componentActivity.f452m = lVar.f486a;
                    }
                    if (componentActivity.f452m == null) {
                        componentActivity.f452m = new g2();
                    }
                }
                componentActivity.f450k.c(this);
            }
        });
        gVar.a();
        o1.b(this);
        if (i10 <= 23) {
            g0Var.a(new ImmLeaksCleaner(this));
        }
        gVar.f14540b.c("android:support:activity-result", new f(0, this));
        p(new g(this, 0));
    }

    private void u() {
        h0.B1(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        j.f("<this>", decorView);
        decorView.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView2 = getWindow().getDecorView();
        j.f("<this>", decorView2);
        decorView2.setTag(R.id.view_tree_saved_state_registry_owner, this);
        h0.A1(getWindow().getDecorView(), this);
    }

    public final e a() {
        return this.f451l.f14540b;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        super.addContentView(view, layoutParams);
    }

    public b2 h() {
        if (this.f453n == null) {
            this.f453n = new s1(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.f453n;
    }

    public final f i() {
        f fVar = new f();
        if (getApplication() != null) {
            fVar.b(a2.f1653g, getApplication());
        }
        fVar.b(o1.f1735a, this);
        fVar.b(o1.f1736b, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            fVar.b(o1.f1737c, getIntent().getExtras());
        }
        return fVar;
    }

    public final void k(r0 r0Var) {
        u uVar = this.f449j;
        ((CopyOnWriteArrayList) uVar.f429j).add(r0Var);
        ((Runnable) uVar.f428i).run();
    }

    public final g2 m() {
        if (getApplication() != null) {
            if (this.f452m == null) {
                l lVar = (l) getLastNonConfigurationInstance();
                if (lVar != null) {
                    this.f452m = lVar.f486a;
                }
                if (this.f452m == null) {
                    this.f452m = new g2();
                }
            }
            return this.f452m;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public final void n(l0.a aVar) {
        this.f456q.add(aVar);
    }

    public final t o() {
        return this.f450k;
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        if (!this.f455p.a(i10, i11, intent)) {
            super.onActivityResult(i10, i11, intent);
        }
    }

    public final void onBackPressed() {
        this.f454o.b();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f456q.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).b(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        this.f451l.b(bundle);
        a aVar = this.f448i;
        aVar.f4078b = this;
        Iterator it = aVar.f4077a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a();
        }
        super.onCreate(bundle);
        g1.f1694i.getClass();
        d1.b(this);
        if (i0.b.a()) {
            r rVar = this.f454o;
            rVar.f500e = k.a(this);
            rVar.c();
        }
    }

    public final boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f449j.f429j).iterator();
        while (it.hasNext()) {
            ((r0) it.next()).f1555a.j();
        }
        return true;
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        if (i10 == 0) {
            return this.f449j.G();
        }
        return false;
    }

    public final void onMultiWindowModeChanged(boolean z10) {
        if (!this.f461v) {
            Iterator it = this.f459t.iterator();
            while (it.hasNext()) {
                ((l0.a) it.next()).b(new l(z10));
            }
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f458s.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).b(intent);
        }
    }

    public void onPanelClosed(int i10, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f449j.f429j).iterator();
        while (it.hasNext()) {
            ((r0) it.next()).f1555a.p();
        }
        super.onPanelClosed(i10, menu);
    }

    public final void onPictureInPictureModeChanged(boolean z10) {
        if (!this.f462w) {
            Iterator it = this.f460u.iterator();
            while (it.hasNext()) {
                ((l0.a) it.next()).b(new o0(z10));
            }
        }
    }

    public final boolean onPreparePanel(int i10, View view, Menu menu) {
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f449j.f429j).iterator();
        while (it.hasNext()) {
            ((r0) it.next()).f1555a.s();
        }
        return true;
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (!this.f455p.a(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i10, strArr, iArr);
        }
    }

    public final Object onRetainNonConfigurationInstance() {
        l lVar;
        g2 g2Var = this.f452m;
        if (g2Var == null && (lVar = (l) getLastNonConfigurationInstance()) != null) {
            g2Var = lVar.f486a;
        }
        if (g2Var == null) {
            return null;
        }
        l lVar2 = new l();
        lVar2.f486a = g2Var;
        return lVar2;
    }

    public void onSaveInstanceState(Bundle bundle) {
        g0 g0Var = this.f450k;
        if (g0Var instanceof g0) {
            g0Var.h(s.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f451l.c(bundle);
    }

    public final void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator it = this.f457r.iterator();
        while (it.hasNext()) {
            ((l0.a) it.next()).b(Integer.valueOf(i10));
        }
    }

    public final void p(b bVar) {
        a aVar = this.f448i;
        if (aVar.f4078b != null) {
            bVar.a();
        }
        aVar.f4077a.add(bVar);
    }

    public final void r(androidx.fragment.app.o0 o0Var) {
        this.f459t.add(o0Var);
    }

    public final void reportFullyDrawn() {
        try {
            if (a4.b.a()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void s(androidx.fragment.app.o0 o0Var) {
        this.f460u.add(o0Var);
    }

    public void setContentView(int i10) {
        u();
        super.setContentView(i10);
    }

    public final void startActivityForResult(Intent intent, int i10) {
        super.startActivityForResult(intent, i10);
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13);
    }

    public final void t(androidx.fragment.app.o0 o0Var) {
        this.f457r.add(o0Var);
    }

    public final void v(r0 r0Var) {
        u uVar = this.f449j;
        ((CopyOnWriteArrayList) uVar.f429j).remove(r0Var);
        android.support.v4.media.h.y(((Map) uVar.f430k).remove(r0Var));
        ((Runnable) uVar.f428i).run();
    }

    public final void w(androidx.fragment.app.o0 o0Var) {
        this.f456q.remove(o0Var);
    }

    public final void x(androidx.fragment.app.o0 o0Var) {
        this.f459t.remove(o0Var);
    }

    public final void y(androidx.fragment.app.o0 o0Var) {
        this.f460u.remove(o0Var);
    }

    public final void z(androidx.fragment.app.o0 o0Var) {
        this.f457r.remove(o0Var);
    }

    /* JADX INFO: finally extract failed */
    public final void onMultiWindowModeChanged(boolean z10, Configuration configuration) {
        this.f461v = true;
        try {
            super.onMultiWindowModeChanged(z10, configuration);
            this.f461v = false;
            Iterator it = this.f459t.iterator();
            while (it.hasNext()) {
                ((l0.a) it.next()).b(new l(z10, 0));
            }
        } catch (Throwable th) {
            this.f461v = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void onPictureInPictureModeChanged(boolean z10, Configuration configuration) {
        this.f462w = true;
        try {
            super.onPictureInPictureModeChanged(z10, configuration);
            this.f462w = false;
            Iterator it = this.f460u.iterator();
            while (it.hasNext()) {
                ((l0.a) it.next()).b(new o0(z10, 0));
            }
        } catch (Throwable th) {
            this.f462w = false;
            throw th;
        }
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        u();
        super.setContentView(view);
    }

    public final void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        super.startActivityForResult(intent, i10, bundle);
    }

    public final void startIntentSenderForResult(IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u();
        super.setContentView(view, layoutParams);
    }
}
