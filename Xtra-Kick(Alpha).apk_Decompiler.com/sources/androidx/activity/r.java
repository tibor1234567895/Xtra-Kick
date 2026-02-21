package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.c1;
import androidx.fragment.app.d0;
import androidx.fragment.app.q0;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import i0.b;
import j3.k0;
import java.util.ArrayDeque;
import java.util.Iterator;
import t6.l;
import xa.j;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f496a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque f497b;

    /* renamed from: c  reason: collision with root package name */
    public final d0 f498c;

    /* renamed from: d  reason: collision with root package name */
    public final OnBackInvokedCallback f499d;

    /* renamed from: e  reason: collision with root package name */
    public OnBackInvokedDispatcher f500e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f501f;

    public r() {
        this((Runnable) null);
    }

    public final void a(androidx.lifecycle.d0 d0Var, q0 q0Var) {
        t o10 = d0Var.o();
        if (o10.b() != s.DESTROYED) {
            q0Var.f490b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, o10, q0Var));
            if (b.a()) {
                c();
                q0Var.f491c = this.f498c;
            }
        }
    }

    public final void b() {
        Iterator descendingIterator = this.f497b.descendingIterator();
        while (descendingIterator.hasNext()) {
            n nVar = (n) descendingIterator.next();
            if (nVar.f489a) {
                q0 q0Var = (q0) nVar;
                int i10 = q0Var.f1550d;
                Object obj = q0Var.f1551e;
                switch (i10) {
                    case 0:
                        c1 c1Var = (c1) obj;
                        c1Var.y(true);
                        if (c1Var.f1378h.f489a) {
                            c1Var.Q();
                            return;
                        } else {
                            c1Var.f1377g.b();
                            return;
                        }
                    case 1:
                        k0 k0Var = (k0) obj;
                        if (!k0Var.f8582g.isEmpty()) {
                            j3.c1 f10 = k0Var.f();
                            j.c(f10);
                            if (k0Var.n(f10.f8513o, true, false)) {
                                k0Var.b();
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        ((l) obj).u0().g();
                        return;
                    default:
                        ((ChatView) obj).y(false);
                        return;
                }
            }
        }
        Runnable runnable = this.f496a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void c() {
        boolean z10;
        Iterator descendingIterator = this.f497b.descendingIterator();
        while (true) {
            if (descendingIterator.hasNext()) {
                if (((n) descendingIterator.next()).f489a) {
                    z10 = true;
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f500e;
        if (onBackInvokedDispatcher != null) {
            OnBackInvokedCallback onBackInvokedCallback = this.f499d;
            if (z10 && !this.f501f) {
                p.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f501f = true;
            } else if (!z10 && this.f501f) {
                p.c(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f501f = false;
            }
        }
    }

    public r(Runnable runnable) {
        this.f497b = new ArrayDeque();
        this.f501f = false;
        this.f496a = runnable;
        if (b.a()) {
            this.f498c = new d0(2, this);
            this.f499d = p.a(new e(2, this));
        }
    }
}
