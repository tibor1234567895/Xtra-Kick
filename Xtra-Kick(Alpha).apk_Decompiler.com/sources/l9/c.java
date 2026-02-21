package l9;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public final class c implements ParameterizedType, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public final Type f9756h;

    /* renamed from: i  reason: collision with root package name */
    public final Type f9757i;

    /* renamed from: j  reason: collision with root package name */
    public final Type[] f9758j;

    public c(Type type, Type type2, Type... typeArr) {
        Type type3;
        boolean z10;
        if (type2 instanceof Class) {
            Class cls = (Class) type2;
            boolean z11 = true;
            if (Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (type == null && !z10) {
                z11 = false;
            }
            a.a(z11);
        }
        if (type == null) {
            type3 = null;
        } else {
            type3 = e.a(type);
        }
        this.f9756h = type3;
        this.f9757i = e.a(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f9758j = typeArr2;
        int length = typeArr2.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f9758j[i10].getClass();
            e.b(this.f9758j[i10]);
            Type[] typeArr3 = this.f9758j;
            typeArr3[i10] = e.a(typeArr3[i10]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && e.c(this, (ParameterizedType) obj);
    }

    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f9758j.clone();
    }

    public final Type getOwnerType() {
        return this.f9756h;
    }

    public final Type getRawType() {
        return this.f9757i;
    }

    public final int hashCode() {
        int i10;
        int hashCode = Arrays.hashCode(this.f9758j) ^ this.f9757i.hashCode();
        Type type = this.f9756h;
        if (type != null) {
            i10 = type.hashCode();
        } else {
            i10 = 0;
        }
        return hashCode ^ i10;
    }

    public final String toString() {
        Type[] typeArr = this.f9758j;
        int length = typeArr.length;
        Type type = this.f9757i;
        if (length == 0) {
            return e.h(type);
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 30);
        sb2.append(e.h(type));
        sb2.append("<");
        sb2.append(e.h(typeArr[0]));
        for (int i10 = 1; i10 < length; i10++) {
            sb2.append(", ");
            sb2.append(e.h(typeArr[i10]));
        }
        sb2.append(">");
        return sb2.toString();
    }
}
