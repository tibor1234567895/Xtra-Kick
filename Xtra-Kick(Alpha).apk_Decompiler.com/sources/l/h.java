package l;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.emoji2.text.d0;
import androidx.emoji2.text.u;
import androidx.fragment.app.c0;
import androidx.lifecycle.j1;
import ca.c;
import com.woxthebox.draglistview.R;
import e4.a;
import ga.b;
import ga.d;
import j1.l0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import l0.f;
import l9.p;
import l9.t;
import l9.x;
import la.v;
import m.o;
import p1.q;
import p1.r;
import q.k;
import v1.g0;
import v1.w;
import xa.j;
import y5.a0;
import y5.f0;

public final class h implements b, g0, r, a0, f0, p {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f9446h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f9447i;

    /* renamed from: j  reason: collision with root package name */
    public Object f9448j;

    /* renamed from: k  reason: collision with root package name */
    public Object f9449k;

    /* renamed from: l  reason: collision with root package name */
    public Object f9450l;

    public h(Context context, ActionMode.Callback callback) {
        this.f9446h = 0;
        this.f9448j = context;
        this.f9447i = callback;
        this.f9449k = new ArrayList();
        this.f9450l = new k();
    }

    public static h j(View view) {
        int i10 = R.id.sortByImage;
        ImageView imageView = (ImageView) a.a(view, R.id.sortByImage);
        if (imageView != null) {
            i10 = R.id.sortByText;
            TextView textView = (TextView) a.a(view, R.id.sortByText);
            if (textView != null) {
                i10 = R.id.sortText;
                TextView textView2 = (TextView) a.a(view, R.id.sortText);
                if (textView2 != null) {
                    return new h((ConstraintLayout) view, imageView, textView, textView2, 7);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public final void C(int i10, v1.a0 a0Var) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).c();
        }
    }

    public final void E(int i10, v1.a0 a0Var, int i11) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).d(i11);
        }
    }

    public final void H(int i10, v1.a0 a0Var, Exception exc) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).e(exc);
        }
    }

    public final void I(int i10, v1.a0 a0Var, v1.r rVar, w wVar) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).o(rVar, t(wVar));
        }
    }

    public final void J(int i10, v1.a0 a0Var, v1.r rVar, w wVar, IOException iOException, boolean z10) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).l(rVar, t(wVar), iOException, z10);
        }
    }

    public final void M(int i10, v1.a0 a0Var, v1.r rVar, w wVar) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).i(rVar, t(wVar));
        }
    }

    public final void T(int i10, v1.a0 a0Var) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).b();
        }
    }

    public final void U(int i10, v1.a0 a0Var) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).a();
        }
    }

    public final /* synthetic */ void W() {
    }

    public final b a(c0 c0Var) {
        c0Var.getClass();
        this.f9450l = c0Var;
        return this;
    }

    public final d b(j1 j1Var) {
        j1Var.getClass();
        this.f9449k = j1Var;
        return this;
    }

    public final d c(c cVar) {
        cVar.getClass();
        this.f9450l = cVar;
        return this;
    }

    public final void d(int i10, v1.a0 a0Var, w wVar) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).c(t(wVar));
        }
    }

    public final boolean e(c cVar, o oVar) {
        return ((ActionMode.Callback) this.f9447i).onPrepareActionMode(m(cVar), r(oVar));
    }

    public final boolean f(c cVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f9447i).onActionItemClicked(m(cVar), new m.w((Context) this.f9448j, (g0.b) menuItem));
    }

    public final boolean g(c cVar, o oVar) {
        return ((ActionMode.Callback) this.f9447i).onCreateActionMode(m(cVar), r(oVar));
    }

    public final void h(c cVar) {
        ((ActionMode.Callback) this.f9447i).onDestroyActionMode(m(cVar));
    }

    public final Object i() {
        try {
            return ((x) this.f9447i).b((Class) this.f9448j);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + ((Type) this.f9449k) + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e10);
        }
    }

    public final void k() {
        synchronized (this.f9447i) {
            Iterator it = ((Map) this.f9448j).entrySet().iterator();
            while (it.hasNext()) {
                if (((WeakReference) ((Map.Entry) it.next()).getValue()).get() == null) {
                    it.remove();
                }
            }
            v vVar = v.f9814a;
        }
    }

    public final void l() {
        synchronized (this.f9447i) {
            ((Map) this.f9448j).clear();
            v vVar = v.f9814a;
        }
    }

    public final i m(c cVar) {
        int size = ((ArrayList) this.f9449k).size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = (i) ((ArrayList) this.f9449k).get(i10);
            if (iVar != null && iVar.f9452b == cVar) {
                return iVar;
            }
        }
        i iVar2 = new i((Context) this.f9448j, cVar);
        ((ArrayList) this.f9449k).add(iVar2);
        return iVar2;
    }

    public final v9.a n(int i10, y9.v vVar) {
        v9.a aVar;
        synchronized (this.f9447i) {
            WeakReference weakReference = (WeakReference) ((Map) this.f9448j).get(Integer.valueOf(i10));
            if (weakReference != null) {
                aVar = (v9.a) weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new v9.a((String) this.f9449k);
                aVar.a(((u9.a) this.f9450l).f15440a.G(i10), (p9.b) null, vVar);
                ((Map) this.f9448j).put(Integer.valueOf(i10), new WeakReference(aVar));
            }
        }
        return aVar;
    }

    public final void o(int i10, v1.a0 a0Var, w wVar) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).p(t(wVar));
        }
    }

    public final void p(int i10, v1.a0 a0Var) {
        if (s(i10, a0Var)) {
            ((q) this.f9449k).f();
        }
    }

    public final void q(int i10, p9.b bVar, y9.v vVar) {
        j.g("download", bVar);
        synchronized (this.f9447i) {
            n(i10, vVar).a(((u9.a) this.f9450l).a(i10, bVar), bVar, vVar);
        }
    }

    public final Menu r(o oVar) {
        Menu menu = (Menu) ((k) this.f9450l).getOrDefault(oVar, (Object) null);
        if (menu != null) {
            return menu;
        }
        m.f0 f0Var = new m.f0((Context) this.f9448j, oVar);
        ((k) this.f9450l).put(oVar, f0Var);
        return f0Var;
    }

    public final boolean s(int i10, v1.a0 a0Var) {
        v1.a0 a0Var2;
        Object obj = this.f9447i;
        if (a0Var != null) {
            a0Var2 = ((v1.j) this.f9450l).s(obj, a0Var);
            if (a0Var2 == null) {
                return false;
            }
        } else {
            a0Var2 = null;
        }
        int u10 = ((v1.j) this.f9450l).u(i10, obj);
        v1.f0 f0Var = (v1.f0) this.f9448j;
        if (f0Var.f15618a != u10 || !l0.a(f0Var.f15619b, a0Var2)) {
            this.f9448j = new v1.f0(((v1.j) this.f9450l).f15558c.f15620c, u10, a0Var2);
        }
        q qVar = (q) this.f9449k;
        if (qVar.f12505a == u10 && l0.a(qVar.f12506b, a0Var2)) {
            return true;
        }
        this.f9449k = new q(((v1.j) this.f9450l).f15559d.f12507c, u10, a0Var2);
        return true;
    }

    public final w t(w wVar) {
        long j10 = wVar.f15823f;
        Object obj = this.f9447i;
        long t10 = ((v1.j) this.f9450l).t(j10, obj);
        long j11 = wVar.f15824g;
        long t11 = ((v1.j) this.f9450l).t(j11, obj);
        return (t10 == wVar.f15823f && t11 == j11) ? wVar : new w(wVar.f15818a, wVar.f15819b, wVar.f15820c, wVar.f15821d, wVar.f15822e, t10, t11);
    }

    public final void u(int i10, p9.b bVar, y9.v vVar) {
        j.g("download", bVar);
        synchronized (this.f9447i) {
            WeakReference weakReference = (WeakReference) ((Map) this.f9448j).get(Integer.valueOf(i10));
            v9.a aVar = weakReference != null ? (v9.a) weakReference.get() : null;
            if (aVar != null) {
                aVar.a(((u9.a) this.f9450l).a(i10, bVar), bVar, vVar);
                v vVar2 = v.f9814a;
            }
        }
    }

    public final void w(int i10, v1.a0 a0Var, v1.r rVar, w wVar) {
        if (s(i10, a0Var)) {
            ((v1.f0) this.f9448j).f(rVar, t(wVar));
        }
    }

    public h(Typeface typeface, v0.b bVar) {
        this.f9446h = 1;
        this.f9450l = typeface;
        this.f9447i = bVar;
        this.f9449k = new d0(1024);
        this.f9448j = new char[(bVar.b() * 2)];
        int b10 = bVar.b();
        for (int i10 = 0; i10 < b10; i10++) {
            u uVar = new u(this, i10);
            Character.toChars(uVar.c(), (char[]) this.f9448j, i10 * 2);
            f.a("invalid metadata codepoint length", uVar.b() > 0);
            ((d0) this.f9449k).a(uVar, 0, uVar.b() - 1);
        }
    }

    public /* synthetic */ h(ViewGroup viewGroup, View view, TextView textView, View view2, int i10) {
        this.f9446h = i10;
        this.f9447i = viewGroup;
        this.f9448j = view;
        this.f9449k = textView;
        this.f9450l = view2;
    }

    public h(String str, u9.a aVar) {
        this.f9446h = 9;
        j.g("namespace", str);
        this.f9449k = str;
        this.f9450l = aVar;
        this.f9447i = new Object();
        this.f9448j = new LinkedHashMap();
    }

    public h(k5.a aVar, Class cls, Type type) {
        Object obj;
        this.f9446h = 8;
        this.f9450l = aVar;
        this.f9448j = cls;
        this.f9449k = type;
        Class<ObjectStreamClass> cls2 = ObjectStreamClass.class;
        Class<Class> cls3 = Class.class;
        try {
            Class<?> cls4 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls4.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            obj = new t(cls4.getMethod("allocateInstance", new Class[]{cls3}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod("getConstructorId", new Class[]{cls3});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = cls2.getDeclaredMethod("newInstance", new Class[]{cls3, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                obj = new l9.u(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{cls3, cls3});
                    declaredMethod3.setAccessible(true);
                    obj = new l9.v(declaredMethod3);
                } catch (Exception unused3) {
                    obj = new l9.w();
                }
            }
        }
        this.f9447i = obj;
    }

    public h(v1.j jVar, Object obj) {
        this.f9446h = 2;
        this.f9450l = jVar;
        this.f9448j = jVar.a((v1.a0) null);
        this.f9449k = new q(jVar.f15559d.f12507c, 0, (v1.a0) null);
        this.f9447i = obj;
    }

    public h(y5.h hVar, y5.c cVar) {
        this.f9446h = 4;
        this.f9447i = hVar;
        this.f9448j = cVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(y5.h hVar, y5.c cVar, int i10) {
        this(hVar, cVar);
        this.f9446h = 4;
    }
}
