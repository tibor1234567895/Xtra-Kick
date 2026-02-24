package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1672a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map f1673b;

    public d(HashMap hashMap) {
        this.f1673b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            r rVar = (r) entry.getValue();
            List list = (List) this.f1672a.get(rVar);
            if (list == null) {
                list = new ArrayList();
                this.f1672a.put(rVar, list);
            }
            list.add((e) entry.getKey());
        }
    }

    public static void a(List list, d0 d0Var, r rVar, Object obj) {
        if (list != null) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = (e) list.get(size);
                eVar.getClass();
                try {
                    int i10 = eVar.f1674a;
                    Method method = eVar.f1675b;
                    if (i10 == 0) {
                        method.invoke(obj, new Object[0]);
                    } else if (i10 == 1) {
                        method.invoke(obj, new Object[]{d0Var});
                    } else if (i10 == 2) {
                        method.invoke(obj, new Object[]{d0Var, rVar});
                    }
                    size--;
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException("Failed to call observer method", e10.getCause());
                } catch (IllegalAccessException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
    }
}
