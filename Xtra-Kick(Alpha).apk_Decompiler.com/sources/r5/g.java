package r5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f13832a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f13833b = new HashMap();

    public final synchronized List a(String str) {
        List list;
        if (!this.f13832a.contains(str)) {
            this.f13832a.add(str);
        }
        list = (List) this.f13833b.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f13833b.put(str, list);
        }
        return list;
    }

    public final synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList;
        boolean z10;
        arrayList = new ArrayList();
        Iterator it = this.f13832a.iterator();
        while (it.hasNext()) {
            List<f> list = (List) this.f13833b.get((String) it.next());
            if (list != null) {
                for (f fVar : list) {
                    if (!fVar.f13829a.isAssignableFrom(cls) || !cls2.isAssignableFrom(fVar.f13830b)) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    if (z10 && !arrayList.contains(fVar.f13830b)) {
                        arrayList.add(fVar.f13830b);
                    }
                }
            }
        }
        return arrayList;
    }
}
