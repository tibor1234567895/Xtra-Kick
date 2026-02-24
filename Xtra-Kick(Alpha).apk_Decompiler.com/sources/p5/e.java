package p5;

import java.util.ArrayList;
import java.util.Iterator;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f12573a = new ArrayList();

    public final synchronized c a(Class cls, Class cls2) {
        boolean z10;
        if (cls2.isAssignableFrom(cls)) {
            return f.f12574h;
        }
        Iterator it = this.f12573a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!dVar.f12570a.isAssignableFrom(cls) || !cls2.isAssignableFrom(dVar.f12571b)) {
                z10 = false;
                continue;
            } else {
                z10 = true;
                continue;
            }
            if (z10) {
                return dVar.f12572c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    public final synchronized ArrayList b(Class cls, Class cls2) {
        boolean z10;
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator it = this.f12573a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!dVar.f12570a.isAssignableFrom(cls) || !cls2.isAssignableFrom(dVar.f12571b)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 && !arrayList.contains(dVar.f12571b)) {
                arrayList.add(dVar.f12571b);
            }
        }
        return arrayList;
    }
}
