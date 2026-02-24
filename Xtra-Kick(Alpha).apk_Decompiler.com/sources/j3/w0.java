package j3;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.h;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.k;
import b0.q0;
import hb.c2;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import jb.a;
import kb.k1;
import kb.o0;
import kb.t;
import kb.t0;
import la.v;
import ma.l;
import ma.z;
import n3.g0;
import n3.m;
import n3.q;
import n3.s0;
import n3.v0;
import n3.y5;
import pa.e;
import wa.p;
import xa.j;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8714a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f8715b;

    /* renamed from: c  reason: collision with root package name */
    public Object f8716c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8717d;

    /* renamed from: e  reason: collision with root package name */
    public Object f8718e;

    public w0(Context context) {
        Intent intent;
        j.f("context", context);
        this.f8714a = context;
        if (context instanceof Activity) {
            intent = new Intent(context, context.getClass());
        } else {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent == null) {
                intent = new Intent();
            }
        }
        intent.addFlags(268468224);
        this.f8715b = intent;
        this.f8717d = new ArrayList();
    }

    public final q0 a() {
        if (((h1) this.f8716c) != null) {
            List list = (List) this.f8717d;
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = list.iterator();
                c1 c1Var = null;
                while (true) {
                    boolean hasNext = it.hasNext();
                    int i10 = 0;
                    Object obj = this.f8714a;
                    if (hasNext) {
                        v0 v0Var = (v0) it.next();
                        int i11 = v0Var.f8712a;
                        c1 b10 = b(i11);
                        if (b10 != null) {
                            int[] c10 = b10.c(c1Var);
                            int length = c10.length;
                            while (i10 < length) {
                                arrayList.add(Integer.valueOf(c10[i10]));
                                arrayList2.add(v0Var.f8713b);
                                i10++;
                            }
                            c1Var = b10;
                        } else {
                            c1.f8505q.getClass();
                            StringBuilder s10 = h.s("Navigation destination ", a1.b((Context) obj, i11), " cannot be found in the navigation graph ");
                            s10.append((h1) this.f8716c);
                            throw new IllegalArgumentException(s10.toString());
                        }
                    } else {
                        int[] I = z.I(arrayList);
                        Intent intent = (Intent) this.f8715b;
                        intent.putExtra("android-support-nav:controller:deepLinkIds", I);
                        intent.putParcelableArrayListExtra("android-support-nav:controller:deepLinkArgs", arrayList2);
                        q0 q0Var = new q0((Context) obj);
                        Intent intent2 = new Intent(intent);
                        ComponentName component = intent2.getComponent();
                        if (component == null) {
                            component = intent2.resolveActivity(q0Var.f2408i.getPackageManager());
                        }
                        if (component != null) {
                            q0Var.a(component);
                        }
                        ArrayList arrayList3 = q0Var.f2407h;
                        arrayList3.add(intent2);
                        int size = arrayList3.size();
                        while (i10 < size) {
                            Intent intent3 = (Intent) arrayList3.get(i10);
                            if (intent3 != null) {
                                intent3.putExtra("android-support-nav:controller:deepLinkIntent", intent);
                            }
                            i10++;
                        }
                        return q0Var;
                    }
                }
            } else {
                throw new IllegalStateException("You must call setDestination() or addDestination() before constructing the deep link".toString());
            }
        } else {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link".toString());
        }
    }

    public final c1 b(int i10) {
        l lVar = new l();
        h1 h1Var = (h1) this.f8716c;
        j.c(h1Var);
        lVar.d(h1Var);
        while (!lVar.isEmpty()) {
            c1 c1Var = (c1) lVar.j();
            if (c1Var.f8513o == i10) {
                return c1Var;
            }
            if (c1Var instanceof h1) {
                g1 g1Var = new g1((h1) c1Var);
                while (g1Var.hasNext()) {
                    lVar.d((c1) g1Var.next());
                }
            }
        }
        return null;
    }

    public final void c(y5 y5Var, p pVar) {
        ReentrantLock reentrantLock = (ReentrantLock) this.f8717d;
        reentrantLock.lock();
        if (y5Var != null) {
            try {
                this.f8716c = y5Var;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        pVar.g((s0) this.f8714a, (s0) this.f8715b);
        v vVar = v.f9814a;
        reentrantLock.unlock();
    }

    public final void d() {
        for (v0 v0Var : (List) this.f8717d) {
            int i10 = v0Var.f8712a;
            if (b(i10) == null) {
                c1.f8505q.getClass();
                StringBuilder s10 = h.s("Navigation destination ", a1.b((Context) this.f8714a, i10), " cannot be found in the navigation graph ");
                s10.append((h1) this.f8716c);
                throw new IllegalArgumentException(s10.toString());
            }
        }
    }

    public /* synthetic */ w0(ViewGroup viewGroup, View view, View view2, View view3, ViewGroup viewGroup2, int i10) {
        this.f8714a = viewGroup;
        this.f8715b = view;
        this.f8716c = view2;
        this.f8717d = view3;
        this.f8718e = viewGroup2;
    }

    public w0(j1 j1Var) {
        this(j1Var.f8576a);
        this.f8716c = j1Var.h();
    }

    public w0(t tVar, f0 f0Var) {
        j.f("scope", f0Var);
        this.f8714a = new g0();
        kb.s0 a10 = t0.a(1, Integer.MAX_VALUE, a.SUSPEND);
        this.f8715b = a10;
        this.f8716c = new k1(a10, new q(this, (e) null));
        c2 b12 = h0.b1(f0Var, (pa.h) null, 2, new n3.p(tVar, this, (e) null), 1);
        b12.L(new k(4, this));
        v vVar = v.f9814a;
        this.f8717d = b12;
        this.f8718e = new o0(new m(this, (e) null));
    }

    public w0(v0 v0Var) {
        j.f("this$0", v0Var);
        this.f8718e = v0Var;
        this.f8714a = new s0(v0Var);
        this.f8715b = new s0((v0) this.f8718e);
        this.f8717d = new ReentrantLock();
    }
}
