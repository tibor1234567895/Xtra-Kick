package e5;

import android.util.Log;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import w5.n;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final g f5051a;

    /* renamed from: b  reason: collision with root package name */
    public final j f5052b;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f5053c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f5054d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5055e;

    /* renamed from: f  reason: collision with root package name */
    public int f5056f;

    public k() {
        this.f5051a = new g();
        this.f5052b = new j();
        this.f5053c = new HashMap();
        this.f5054d = new HashMap();
        this.f5055e = 4194304;
    }

    public final synchronized void a() {
        c(0);
    }

    public final void b(int i10, Class cls) {
        NavigableMap g10 = g(cls);
        Integer num = (Integer) g10.get(Integer.valueOf(i10));
        if (num != null) {
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i10);
            if (intValue == 1) {
                g10.remove(valueOf);
            } else {
                g10.put(valueOf, Integer.valueOf(num.intValue() - 1));
            }
        } else {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
        }
    }

    public final void c(int i10) {
        while (this.f5056f > i10) {
            Object c10 = this.f5051a.c();
            n.b(c10);
            a e10 = e(c10.getClass());
            this.f5056f -= e10.b() * e10.a(c10);
            b(e10.a(c10), c10.getClass());
            if (Log.isLoggable(e10.getTag(), 2)) {
                e10.getTag();
                e10.a(c10);
            }
        }
    }

    public final synchronized Object d(int i10, Class cls) {
        i iVar;
        boolean z10;
        Integer num = (Integer) g(cls).ceilingKey(Integer.valueOf(i10));
        boolean z11 = false;
        if (num != null) {
            int i11 = this.f5056f;
            if (i11 != 0) {
                if (this.f5055e / i11 < 2) {
                    z10 = false;
                    if (z10 || num.intValue() <= i10 * 8) {
                        z11 = true;
                    }
                }
            }
            z10 = true;
            z11 = true;
        }
        if (z11) {
            j jVar = this.f5052b;
            int intValue = num.intValue();
            iVar = (i) jVar.b();
            iVar.f5049b = intValue;
            iVar.f5050c = cls;
        } else {
            i iVar2 = (i) this.f5052b.b();
            iVar2.f5049b = i10;
            iVar2.f5050c = cls;
            iVar = iVar2;
        }
        return f(iVar, cls);
    }

    public final a e(Class cls) {
        HashMap hashMap = this.f5054d;
        a aVar = (a) hashMap.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (cls.equals(byte[].class)) {
                aVar = new e();
            } else {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            hashMap.put(cls, aVar);
        }
        return aVar;
    }

    public final Object f(i iVar, Class cls) {
        a e10 = e(cls);
        Object a10 = this.f5051a.a(iVar);
        if (a10 != null) {
            this.f5056f -= e10.b() * e10.a(a10);
            b(e10.a(a10), cls);
        }
        if (a10 != null) {
            return a10;
        }
        if (Log.isLoggable(e10.getTag(), 2)) {
            e10.getTag();
        }
        return e10.newArray(iVar.f5049b);
    }

    public final NavigableMap g(Class cls) {
        HashMap hashMap = this.f5053c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        hashMap.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void h(Object obj) {
        boolean z10;
        Class<?> cls = obj.getClass();
        a e10 = e(cls);
        int a10 = e10.a(obj);
        int b10 = e10.b() * a10;
        int i10 = 1;
        if (b10 <= this.f5055e / 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i iVar = (i) this.f5052b.b();
            iVar.f5049b = a10;
            iVar.f5050c = cls;
            this.f5051a.b(iVar, obj);
            NavigableMap g10 = g(cls);
            Integer num = (Integer) g10.get(Integer.valueOf(iVar.f5049b));
            Integer valueOf = Integer.valueOf(iVar.f5049b);
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            g10.put(valueOf, Integer.valueOf(i10));
            this.f5056f += b10;
            c(this.f5055e);
        }
    }

    public final synchronized void i(int i10) {
        if (i10 >= 40) {
            try {
                a();
            } catch (Throwable th) {
                throw th;
            }
        } else if (i10 >= 20 || i10 == 15) {
            c(this.f5055e / 2);
        }
    }

    public k(int i10) {
        this.f5051a = new g();
        this.f5052b = new j();
        this.f5053c = new HashMap();
        this.f5054d = new HashMap();
        this.f5055e = i10;
    }
}
