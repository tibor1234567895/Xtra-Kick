package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.c0;
import androidx.fragment.app.c1;
import androidx.lifecycle.g0;
import b4.e0;
import com.bumptech.glide.manager.f;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.manager.t;
import d5.w;
import e5.k;
import e5.m;
import f5.h;
import f5.j;
import g5.b;
import g5.d;
import g5.g;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.i0;
import q.e;
import q5.a;
import w5.p;

public final class c implements ComponentCallbacks2 {

    /* renamed from: o  reason: collision with root package name */
    public static volatile c f3162o;

    /* renamed from: p  reason: collision with root package name */
    public static volatile boolean f3163p;

    /* renamed from: h  reason: collision with root package name */
    public final e5.c f3164h;

    /* renamed from: i  reason: collision with root package name */
    public final h f3165i;

    /* renamed from: j  reason: collision with root package name */
    public final h f3166j;

    /* renamed from: k  reason: collision with root package name */
    public final k f3167k;

    /* renamed from: l  reason: collision with root package name */
    public final t f3168l;

    /* renamed from: m  reason: collision with root package name */
    public final f f3169m;

    /* renamed from: n  reason: collision with root package name */
    public final ArrayList f3170n = new ArrayList();

    public c(Context context, w wVar, h hVar, e5.c cVar, k kVar, t tVar, f fVar, int i10, e0 e0Var, e eVar, List list, List list2, a aVar, e0 e0Var2) {
        this.f3164h = cVar;
        k kVar2 = kVar;
        this.f3167k = kVar2;
        this.f3165i = hVar;
        this.f3168l = tVar;
        this.f3169m = fVar;
        this.f3166j = new h(context, kVar2, new i0(this, list2, aVar), new t5.e(), e0Var, eVar, list, wVar, e0Var2, i10);
    }

    /* JADX INFO: finally extract failed */
    public static c a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f3162o == null) {
            Context applicationContext = context.getApplicationContext();
            try {
                generatedAppGlideModule = GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{applicationContext.getApplicationContext()});
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (InstantiationException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (IllegalAccessException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e13);
            }
            synchronized (c.class) {
                if (f3162o == null) {
                    if (!f3163p) {
                        f3163p = true;
                        try {
                            c(context, generatedAppGlideModule);
                            f3163p = false;
                        } catch (Throwable th) {
                            f3163p = false;
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                }
            }
        }
        return f3162o;
    }

    public static t b(Context context) {
        if (context != null) {
            return a(context).f3168l;
        }
        throw new NullPointerException("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    }

    public static void c(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        List<q5.c> list;
        s sVar;
        List list2;
        int i10;
        g gVar = new g();
        Context applicationContext = context.getApplicationContext();
        List emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            Log.isLoggable("ManifestParser", 3);
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        if (Log.isLoggable("ManifestParser", 2)) {
                            Objects.toString(applicationInfo.metaData);
                        }
                        for (String next : applicationInfo.metaData.keySet()) {
                            if ("GlideModule".equals(applicationInfo.metaData.get(next))) {
                                arrayList.add(l.a.b(next));
                                Log.isLoggable("ManifestParser", 3);
                            }
                        }
                        Log.isLoggable("ManifestParser", 3);
                        list = arrayList;
                    }
                }
                Log.isLoggable("ManifestParser", 3);
                list = arrayList;
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("Unable to find metadata to parse GlideModules", e10);
            }
        } else {
            list = emptyList;
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set d10 = generatedAppGlideModule.d();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                q5.c cVar = (q5.c) it.next();
                if (d10.contains(cVar.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        cVar.toString();
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (q5.c cVar2 : list) {
                cVar2.getClass().toString();
            }
        }
        if (generatedAppGlideModule != null) {
            sVar = generatedAppGlideModule.e();
        } else {
            sVar = null;
        }
        gVar.f3184n = sVar;
        for (q5.c a10 : list) {
            a10.a();
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a();
        }
        if (gVar.f3177g == null) {
            int i11 = g.f6838j;
            g5.a aVar = new g5.a(0);
            d dVar = g5.f.f6836a;
            if (g.f6838j == 0) {
                g.f6838j = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            int i12 = g.f6838j;
            if (!TextUtils.isEmpty("source")) {
                gVar.f3177g = new g(new ThreadPoolExecutor(i12, i12, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(aVar, "source", dVar, false)));
            } else {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
            }
        }
        if (gVar.f3178h == null) {
            int i13 = g.f6838j;
            g5.a aVar2 = new g5.a(0);
            d dVar2 = g5.f.f6836a;
            if (!TextUtils.isEmpty("disk-cache")) {
                gVar.f3178h = new g(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(aVar2, "disk-cache", dVar2, true)));
            } else {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
            }
        }
        if (gVar.f3185o == null) {
            if (g.f6838j == 0) {
                g.f6838j = Math.min(4, Runtime.getRuntime().availableProcessors());
            }
            if (g.f6838j >= 4) {
                i10 = 2;
            } else {
                i10 = 1;
            }
            g5.a aVar3 = new g5.a(0);
            d dVar3 = g5.f.f6836a;
            if (!TextUtils.isEmpty("animation")) {
                gVar.f3185o = new g(new ThreadPoolExecutor(i10, i10, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(aVar3, "animation", dVar3, true)));
            } else {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
            }
        }
        if (gVar.f3180j == null) {
            gVar.f3180j = new b2.e(new j(applicationContext));
        }
        if (gVar.f3181k == null) {
            gVar.f3181k = new f();
        }
        if (gVar.f3174d == null) {
            int i14 = gVar.f3180j.f2428a;
            if (i14 > 0) {
                gVar.f3174d = new m((long) i14);
            } else {
                gVar.f3174d = new e5.d();
            }
        }
        if (gVar.f3175e == null) {
            gVar.f3175e = new k(gVar.f3180j.f2430c);
        }
        if (gVar.f3176f == null) {
            gVar.f3176f = new h((long) gVar.f3180j.f2429b);
        }
        if (gVar.f3179i == null) {
            gVar.f3179i = new f5.g(applicationContext);
        }
        if (gVar.f3173c == null) {
            gVar.f3173c = new w(gVar.f3176f, gVar.f3179i, gVar.f3178h, gVar.f3177g, new g(new ThreadPoolExecutor(0, Integer.MAX_VALUE, g.f6837i, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(new g5.a(0), "source-unlimited", g5.f.f6836a, false))), gVar.f3185o);
        }
        List list3 = gVar.f3186p;
        if (list3 == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list3);
        }
        gVar.f3186p = list2;
        i iVar = gVar.f3172b;
        iVar.getClass();
        e0 e0Var = new e0(iVar);
        t tVar = new t(gVar.f3184n, e0Var);
        c cVar3 = r1;
        c cVar4 = new c(applicationContext, gVar.f3173c, gVar.f3176f, gVar.f3174d, gVar.f3175e, tVar, gVar.f3181k, gVar.f3182l, gVar.f3183m, gVar.f3171a, gVar.f3186p, list, generatedAppGlideModule, e0Var);
        c cVar5 = cVar3;
        applicationContext.registerComponentCallbacks(cVar5);
        f3162o = cVar5;
    }

    public static s e(Context context) {
        return b(context).b(context);
    }

    public static s f(c0 c0Var) {
        boolean z10;
        boolean z11;
        View view;
        t b10 = b(c0Var.v());
        b10.getClass();
        if (c0Var.v() != null) {
            char[] cArr = p.f16126a;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return b10.b(c0Var.v().getApplicationContext());
            }
            if (c0Var.t() != null) {
                c0Var.t();
                b10.f3282m.a();
            }
            c1 u10 = c0Var.u();
            Context v10 = c0Var.v();
            c a10 = a(v10.getApplicationContext());
            o oVar = b10.f3283n;
            g0 g0Var = c0Var.V;
            if (!c0Var.F() || c0Var.G() || (view = c0Var.M) == null || view.getWindowToken() == null || c0Var.M.getVisibility() != 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            return oVar.a(v10, a10, g0Var, u10, z11);
        }
        throw new NullPointerException("You cannot start a load on a fragment before it is attached or after it is destroyed");
    }

    public final void d(s sVar) {
        synchronized (this.f3170n) {
            if (this.f3170n.contains(sVar)) {
                this.f3170n.remove(sVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
        p.a();
        this.f3165i.e(0);
        this.f3164h.e();
        this.f3167k.a();
    }

    public final void onTrimMemory(int i10) {
        p.a();
        synchronized (this.f3170n) {
            Iterator it = this.f3170n.iterator();
            while (it.hasNext()) {
                ((s) it.next()).getClass();
            }
        }
        this.f3165i.f(i10);
        this.f3164h.a(i10);
        this.f3167k.i(i10);
    }
}
