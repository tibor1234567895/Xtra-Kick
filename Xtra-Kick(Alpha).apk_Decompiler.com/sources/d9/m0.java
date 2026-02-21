package d9;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

public abstract class m0 extends AbstractCollection implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public static final Object[] f4632h = new Object[0];

    public r0 a() {
        if (isEmpty()) {
            p0 p0Var = r0.f4657i;
            return r1.f4658l;
        }
        Object[] array = toArray();
        p0 p0Var2 = r0.f4657i;
        return r0.h(array.length, array);
    }

    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public int b(int i10, Object[] objArr) {
        i2 g10 = iterator();
        while (g10.hasNext()) {
            objArr[i10] = g10.next();
            i10++;
        }
        return i10;
    }

    public Object[] c() {
        return null;
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    public int d() {
        throw new UnsupportedOperationException();
    }

    public int e() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean f();

    /* renamed from: g */
    public abstract i2 iterator();

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(f4632h);
    }

    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        if (objArr.length < size) {
            Object[] c10 = c();
            if (c10 != null) {
                return Arrays.copyOfRange(c10, e(), d(), objArr.getClass());
            }
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        b(0, objArr);
        return objArr;
    }
}
