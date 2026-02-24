package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.h;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import hb.h0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kb.e1;
import kb.l0;
import la.i;
import ma.j0;
import t3.d;
import xa.j;

public final class j1 {

    /* renamed from: f  reason: collision with root package name */
    public static final i1 f1711f = new i1(0);

    /* renamed from: g  reason: collision with root package name */
    public static final Class[] f1712g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f1713a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f1714b;

    /* renamed from: c  reason: collision with root package name */
    public final LinkedHashMap f1715c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashMap f1716d;

    /* renamed from: e  reason: collision with root package name */
    public final h1 f1717e;

    public j1() {
        this.f1713a = new LinkedHashMap();
        this.f1714b = new LinkedHashMap();
        this.f1715c = new LinkedHashMap();
        this.f1716d = new LinkedHashMap();
        this.f1717e = new h1(this, 1);
    }

    public static Bundle a(j1 j1Var) {
        o0 o0Var;
        j.f("this$0", j1Var);
        Iterator it = j0.g(j1Var.f1714b).entrySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            LinkedHashMap linkedHashMap = j1Var.f1713a;
            boolean z10 = false;
            if (hasNext) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Bundle a10 = ((d) entry.getValue()).a();
                j.f("key", str);
                f1711f.getClass();
                if (a10 != null) {
                    Class[] clsArr = f1712g;
                    int length = clsArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        Class cls = clsArr[i10];
                        j.c(cls);
                        if (cls.isInstance(a10)) {
                            break;
                        }
                        i10++;
                    }
                }
                z10 = true;
                if (z10) {
                    Object obj = j1Var.f1715c.get(str);
                    if (obj instanceof o0) {
                        o0Var = (o0) obj;
                    } else {
                        o0Var = null;
                    }
                    if (o0Var != null) {
                        o0Var.l(a10);
                    } else {
                        linkedHashMap.put(str, a10);
                    }
                    l0 l0Var = (l0) j1Var.f1716d.get(str);
                    if (l0Var != null) {
                        ((e1) l0Var).k(a10);
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder("Can't put value with type ");
                    j.c(a10);
                    sb2.append(a10.getClass());
                    sb2.append(" into saved state");
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else {
                Set<String> keySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str2 : keySet) {
                    arrayList.add(str2);
                    arrayList2.add(linkedHashMap.get(str2));
                }
                return h0.r(new i("keys", arrayList), new i("values", arrayList2));
            }
        }
    }

    public final boolean b(String str) {
        return this.f1713a.containsKey(str);
    }

    public final Object c(String str) {
        LinkedHashMap linkedHashMap = this.f1713a;
        try {
            return linkedHashMap.get(str);
        } catch (ClassCastException unused) {
            linkedHashMap.remove(str);
            h.y(this.f1715c.remove(str));
            this.f1716d.remove(str);
            return null;
        }
    }

    public j1(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f1713a = linkedHashMap;
        this.f1714b = new LinkedHashMap();
        this.f1715c = new LinkedHashMap();
        this.f1716d = new LinkedHashMap();
        this.f1717e = new h1(this, 0);
        linkedHashMap.putAll(hashMap);
    }
}
