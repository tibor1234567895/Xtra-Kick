package na;

import hb.h0;
import java.util.Map;
import xa.j;
import ya.a;

public final class f implements Map.Entry, a {

    /* renamed from: h  reason: collision with root package name */
    public final h f11774h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11775i;

    public f(h hVar, int i10) {
        j.f("map", hVar);
        this.f11774h = hVar;
        this.f11775i = i10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return j.a(entry.getKey(), getKey()) && j.a(entry.getValue(), getValue());
        }
    }

    public final Object getKey() {
        return this.f11774h.f11780h[this.f11775i];
    }

    public final Object getValue() {
        Object[] objArr = this.f11774h.f11781i;
        j.c(objArr);
        return objArr[this.f11775i];
    }

    public final int hashCode() {
        Object key = getKey();
        int i10 = 0;
        int hashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        if (value != null) {
            i10 = value.hashCode();
        }
        return hashCode ^ i10;
    }

    public final Object setValue(Object obj) {
        h hVar = this.f11774h;
        hVar.b();
        Object[] objArr = hVar.f11781i;
        if (objArr == null) {
            objArr = h0.h(hVar.f11780h.length);
            hVar.f11781i = objArr;
        }
        int i10 = this.f11775i;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getKey());
        sb2.append('=');
        sb2.append(getValue());
        return sb2.toString();
    }
}
