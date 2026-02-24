package androidx.fragment.app;

import android.view.View;
import b4.m;
import d9.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import ma.z;
import q.e;
import xa.j;

public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    public static final v1 f1552a = new v1();

    /* renamed from: b  reason: collision with root package name */
    public static final x1 f1553b;

    static {
        x1 x1Var;
        new q1();
        try {
            x1Var = m.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            x1Var = null;
        }
        f1553b = x1Var;
    }

    private q1() {
    }

    public static final String a(e eVar, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((w) eVar.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (j.a(entry.getValue(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add((String) key.getKey());
        }
        return (String) z.u(arrayList);
    }

    public static final void b(ArrayList arrayList, int i10) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(i10);
        }
    }
}
