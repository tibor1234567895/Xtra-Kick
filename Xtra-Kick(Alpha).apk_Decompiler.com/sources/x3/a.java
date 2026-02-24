package x3;

import a4.b;
import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import androidx.fragment.app.y;
import com.woxthebox.draglistview.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f16645d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f16646e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f16647a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f16648b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final Context f16649c;

    public a(Context context) {
        this.f16649c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f16645d == null) {
            synchronized (f16646e) {
                if (f16645d == null) {
                    f16645d = new a(context);
                }
            }
        }
        return f16645d;
    }

    public final void a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f16649c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = this.f16648b;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, (String) null))) {
                        Class<?> cls = Class.forName(next);
                        if (b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e10) {
                throw new y((Throwable) e10);
            }
        }
    }

    public final Object b(Class cls, HashSet hashSet) {
        Object obj;
        if (b.a()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!hashSet.contains(cls)) {
            HashMap hashMap = this.f16647a;
            if (!hashMap.containsKey(cls)) {
                hashSet.add(cls);
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> dependencies = bVar.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class cls2 : dependencies) {
                        if (!hashMap.containsKey(cls2)) {
                            b(cls2, hashSet);
                        }
                    }
                }
                obj = bVar.a(this.f16649c);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } else {
                obj = hashMap.get(cls);
            }
            Trace.endSection();
            return obj;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }
}
