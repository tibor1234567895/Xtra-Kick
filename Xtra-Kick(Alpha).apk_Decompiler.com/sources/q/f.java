package q;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public final class f implements Collection, Set {

    /* renamed from: k  reason: collision with root package name */
    public static Object[] f13051k;

    /* renamed from: l  reason: collision with root package name */
    public static int f13052l;

    /* renamed from: m  reason: collision with root package name */
    public static Object[] f13053m;

    /* renamed from: n  reason: collision with root package name */
    public static int f13054n;

    /* renamed from: o  reason: collision with root package name */
    public static final Object f13055o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public static final Object f13056p = new Object();

    /* renamed from: h  reason: collision with root package name */
    public int[] f13057h;

    /* renamed from: i  reason: collision with root package name */
    public Object[] f13058i;

    /* renamed from: j  reason: collision with root package name */
    public int f13059j;

    public f() {
        this(0);
    }

    public static void b(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (f13056p) {
                if (f13054n < 10) {
                    objArr[0] = f13053m;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f13053m = objArr;
                    f13054n++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f13055o) {
                if (f13052l < 10) {
                    objArr[0] = f13051k;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f13051k = objArr;
                    f13052l++;
                }
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 8) {
            synchronized (f13056p) {
                Object[] objArr = f13053m;
                if (objArr != null) {
                    try {
                        this.f13058i = objArr;
                        f13053m = (Object[]) objArr[0];
                        int[] iArr = (int[]) objArr[1];
                        this.f13057h = iArr;
                        if (iArr != null) {
                            objArr[1] = null;
                            objArr[0] = null;
                            f13054n--;
                            return;
                        }
                    } catch (ClassCastException unused) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                    f13053m = null;
                    f13054n = 0;
                }
            }
        } else if (i10 == 4) {
            synchronized (f13055o) {
                Object[] objArr2 = f13051k;
                if (objArr2 != null) {
                    try {
                        this.f13058i = objArr2;
                        f13051k = (Object[]) objArr2[0];
                        int[] iArr2 = (int[]) objArr2[1];
                        this.f13057h = iArr2;
                        if (iArr2 != null) {
                            objArr2[1] = null;
                            objArr2[0] = null;
                            f13052l--;
                            return;
                        }
                    } catch (ClassCastException unused2) {
                    }
                    System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                    f13051k = null;
                    f13052l = 0;
                }
            }
        }
        this.f13057h = new int[i10];
        this.f13058i = new Object[i10];
    }

    public final boolean add(Object obj) {
        int i10;
        int i11;
        int i12 = this.f13059j;
        if (obj == null) {
            i11 = d();
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            i11 = c(hashCode, obj);
        }
        if (i11 >= 0) {
            return false;
        }
        int i13 = ~i11;
        int[] iArr = this.f13057h;
        if (i12 >= iArr.length) {
            int i14 = 8;
            if (i12 >= 8) {
                i14 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i14 = 4;
            }
            Object[] objArr = this.f13058i;
            a(i14);
            if (i12 == this.f13059j) {
                int[] iArr2 = this.f13057h;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f13058i, 0, objArr.length);
                }
                b(iArr, objArr, i12);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i12) {
            int[] iArr3 = this.f13057h;
            int i15 = i13 + 1;
            int i16 = i12 - i13;
            System.arraycopy(iArr3, i13, iArr3, i15, i16);
            Object[] objArr2 = this.f13058i;
            System.arraycopy(objArr2, i13, objArr2, i15, i16);
        }
        int i17 = this.f13059j;
        if (i12 == i17) {
            int[] iArr4 = this.f13057h;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                this.f13058i[i13] = obj;
                this.f13059j = i17 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final boolean addAll(Collection collection) {
        int size = collection.size() + this.f13059j;
        int i10 = this.f13059j;
        int[] iArr = this.f13057h;
        boolean z10 = false;
        if (iArr.length < size) {
            Object[] objArr = this.f13058i;
            a(size);
            int i11 = this.f13059j;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f13057h, 0, i11);
                System.arraycopy(objArr, 0, this.f13058i, 0, this.f13059j);
            }
            b(iArr, objArr, this.f13059j);
        }
        if (this.f13059j == i10) {
            for (Object add : collection) {
                z10 |= add(add);
            }
            return z10;
        }
        throw new ConcurrentModificationException();
    }

    public final int c(int i10, Object obj) {
        int i11 = this.f13059j;
        if (i11 == 0) {
            return -1;
        }
        try {
            int a10 = g.a(i11, i10, this.f13057h);
            if (a10 < 0 || obj.equals(this.f13058i[a10])) {
                return a10;
            }
            int i12 = a10 + 1;
            while (i12 < i11 && this.f13057h[i12] == i10) {
                if (obj.equals(this.f13058i[i12])) {
                    return i12;
                }
                i12++;
            }
            int i13 = a10 - 1;
            while (i13 >= 0 && this.f13057h[i13] == i10) {
                if (obj.equals(this.f13058i[i13])) {
                    return i13;
                }
                i13--;
            }
            return ~i12;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final void clear() {
        int i10 = this.f13059j;
        if (i10 != 0) {
            int[] iArr = this.f13057h;
            Object[] objArr = this.f13058i;
            this.f13057h = g.f13060a;
            this.f13058i = g.f13061b;
            this.f13059j = 0;
            b(iArr, objArr, i10);
        }
        if (this.f13059j != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean contains(Object obj) {
        return (obj == null ? d() : c(obj.hashCode(), obj)) >= 0;
    }

    public final boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final int d() {
        int i10 = this.f13059j;
        if (i10 == 0) {
            return -1;
        }
        try {
            int a10 = g.a(i10, 0, this.f13057h);
            if (a10 < 0 || this.f13058i[a10] == null) {
                return a10;
            }
            int i11 = a10 + 1;
            while (i11 < i10 && this.f13057h[i11] == 0) {
                if (this.f13058i[i11] == null) {
                    return i11;
                }
                i11++;
            }
            int i12 = a10 - 1;
            while (i12 >= 0 && this.f13057h[i12] == 0) {
                if (this.f13058i[i12] == null) {
                    return i12;
                }
                i12--;
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final void e(int i10) {
        int i11 = this.f13059j;
        Object[] objArr = this.f13058i;
        Object obj = objArr[i10];
        if (i11 <= 1) {
            clear();
            return;
        }
        int i12 = i11 - 1;
        int[] iArr = this.f13057h;
        int i13 = 8;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i12) {
                int i14 = i10 + 1;
                int i15 = i12 - i10;
                System.arraycopy(iArr, i14, iArr, i10, i15);
                Object[] objArr2 = this.f13058i;
                System.arraycopy(objArr2, i14, objArr2, i10, i15);
            }
            this.f13058i[i12] = null;
        } else {
            if (i11 > 8) {
                i13 = i11 + (i11 >> 1);
            }
            a(i13);
            if (i10 > 0) {
                System.arraycopy(iArr, 0, this.f13057h, 0, i10);
                System.arraycopy(objArr, 0, this.f13058i, 0, i10);
            }
            if (i10 < i12) {
                int i16 = i10 + 1;
                int i17 = i12 - i10;
                System.arraycopy(iArr, i16, this.f13057h, i10, i17);
                System.arraycopy(objArr, i16, this.f13058i, i10, i17);
            }
        }
        if (i11 == this.f13059j) {
            this.f13059j = i12;
            return;
        }
        throw new ConcurrentModificationException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f13059j != set.size()) {
                return false;
            }
            int i10 = 0;
            while (i10 < this.f13059j) {
                try {
                    if (!set.contains(this.f13058i[i10])) {
                        return false;
                    }
                    i10++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f13057h;
        int i10 = this.f13059j;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public final boolean isEmpty() {
        return this.f13059j <= 0;
    }

    public final Iterator iterator() {
        return new a(this);
    }

    public final boolean remove(Object obj) {
        int i10;
        if (obj == null) {
            i10 = d();
        } else {
            i10 = c(obj.hashCode(), obj);
        }
        if (i10 < 0) {
            return false;
        }
        e(i10);
        return true;
    }

    public final boolean removeAll(Collection collection) {
        boolean z10 = false;
        for (Object remove : collection) {
            z10 |= remove(remove);
        }
        return z10;
    }

    public final boolean retainAll(Collection collection) {
        boolean z10 = false;
        for (int i10 = this.f13059j - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f13058i[i10])) {
                e(i10);
                z10 = true;
            }
        }
        return z10;
    }

    public final int size() {
        return this.f13059j;
    }

    public final Object[] toArray() {
        int i10 = this.f13059j;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f13058i, 0, objArr, 0, i10);
        return objArr;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f13059j * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f13059j; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object obj = this.f13058i[i10];
            if (obj != this) {
                sb2.append(obj);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public f(int i10) {
        if (i10 == 0) {
            this.f13057h = g.f13060a;
            this.f13058i = g.f13061b;
        } else {
            a(i10);
        }
        this.f13059j = 0;
    }

    public final Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f13059j) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f13059j);
        }
        System.arraycopy(this.f13058i, 0, objArr, 0, this.f13059j);
        int length = objArr.length;
        int i10 = this.f13059j;
        if (length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }
}
