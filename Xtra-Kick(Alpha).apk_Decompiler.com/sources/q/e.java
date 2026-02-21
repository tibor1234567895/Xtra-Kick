package q;

import d9.w;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class e extends k implements Map {

    /* renamed from: o  reason: collision with root package name */
    public w f13048o;

    /* renamed from: p  reason: collision with root package name */
    public b f13049p;

    /* renamed from: q  reason: collision with root package name */
    public d f13050q;

    public e() {
    }

    public e(e eVar) {
        if (eVar != null) {
            i(eVar);
        }
    }

    public final Set entrySet() {
        w wVar = this.f13048o;
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(2, this);
        this.f13048o = wVar2;
        return wVar2;
    }

    public final Set keySet() {
        b bVar = this.f13049p;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f13049p = bVar2;
        return bVar2;
    }

    public final boolean m(Collection collection) {
        int i10 = this.f13081j;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (!collection.contains(h(i11))) {
                j(i11);
            }
        }
        return i10 != this.f13081j;
    }

    public final Object[] n(int i10, Object[] objArr) {
        int i11 = this.f13081j;
        if (objArr.length < i11) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i11);
        }
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = this.f13080i[(i12 << 1) + i10];
        }
        if (objArr.length > i11) {
            objArr[i11] = null;
        }
        return objArr;
    }

    public final void putAll(Map map) {
        b(map.size() + this.f13081j);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final Collection values() {
        d dVar = this.f13050q;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.f13050q = dVar2;
        return dVar2;
    }
}
