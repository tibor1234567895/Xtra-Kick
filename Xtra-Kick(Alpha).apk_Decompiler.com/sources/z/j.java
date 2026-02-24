package z;

import java.util.ArrayList;
import java.util.HashSet;
import q.k;
import s.f;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final f f17342a = new f(10, 1);

    /* renamed from: b  reason: collision with root package name */
    public final k f17343b = new k();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f17344c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet f17345d = new HashSet();

    public final void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (!arrayList.contains(obj)) {
            if (!hashSet.contains(obj)) {
                hashSet.add(obj);
                ArrayList arrayList2 = (ArrayList) this.f17343b.getOrDefault(obj, (Object) null);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        a(arrayList2.get(i10), arrayList, hashSet);
                    }
                }
                hashSet.remove(obj);
                arrayList.add(obj);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
