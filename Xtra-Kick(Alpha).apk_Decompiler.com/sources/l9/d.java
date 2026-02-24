package l9;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public final class d implements WildcardType, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Type f9759h;

    /* renamed from: i  reason: collision with root package name */
    public final Type f9760i;

    public d(Type[] typeArr, Type[] typeArr2) {
        boolean z10;
        boolean z11;
        boolean z12 = true;
        if (typeArr2.length <= 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a(z10);
        if (typeArr.length == 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.a(z11);
        if (typeArr2.length == 1) {
            typeArr2[0].getClass();
            e.b(typeArr2[0]);
            Class<Object> cls = Object.class;
            a.a(typeArr[0] != cls ? false : z12);
            this.f9760i = e.a(typeArr2[0]);
            this.f9759h = cls;
            return;
        }
        typeArr[0].getClass();
        e.b(typeArr[0]);
        this.f9760i = null;
        this.f9759h = e.a(typeArr[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && e.c(this, (WildcardType) obj);
    }

    public final Type[] getLowerBounds() {
        Type type = this.f9760i;
        if (type == null) {
            return e.f9761a;
        }
        return new Type[]{type};
    }

    public final Type[] getUpperBounds() {
        return new Type[]{this.f9759h};
    }

    public final int hashCode() {
        Type type = this.f9760i;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f9759h.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f9760i;
        if (type != null) {
            return "? super " + e.h(type);
        }
        Class<Object> cls = Object.class;
        Type type2 = this.f9759h;
        if (type2 == cls) {
            return "?";
        }
        return "? extends " + e.h(type2);
    }
}
