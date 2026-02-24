package na;

import hb.h0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import ma.f;
import ma.h;
import ma.k;
import ma.l;
import ma.m;
import ma.o;
import xa.j;

public final class c extends h implements RandomAccess, Serializable {

    /* renamed from: h  reason: collision with root package name */
    public Object[] f11767h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11768i;

    /* renamed from: j  reason: collision with root package name */
    public int f11769j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f11770k;

    /* renamed from: l  reason: collision with root package name */
    public final c f11771l;

    /* renamed from: m  reason: collision with root package name */
    public final c f11772m;

    public c() {
        this(h0.h(10), 0, 0, false, (c) null, (c) null);
    }

    public final int a() {
        return this.f11769j;
    }

    public final void add(int i10, Object obj) {
        e();
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.b(i10, i11);
        d(this.f11768i + i10, obj);
    }

    public final boolean addAll(int i10, Collection collection) {
        j.f("elements", collection);
        e();
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.b(i10, i11);
        int size = collection.size();
        c(this.f11768i + i10, collection, size);
        return size > 0;
    }

    public final Object b(int i10) {
        e();
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.a(i10, i11);
        return g(this.f11768i + i10);
    }

    public final void c(int i10, Collection collection, int i11) {
        c cVar = this.f11771l;
        if (cVar != null) {
            cVar.c(i10, collection, i11);
            this.f11767h = cVar.f11767h;
            this.f11769j += i11;
            return;
        }
        f(i10, i11);
        Iterator it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f11767h[i10 + i12] = it.next();
        }
    }

    public final void clear() {
        e();
        h(this.f11768i, this.f11769j);
    }

    public final void d(int i10, Object obj) {
        c cVar = this.f11771l;
        if (cVar != null) {
            cVar.d(i10, obj);
            this.f11767h = cVar.f11767h;
            this.f11769j++;
            return;
        }
        f(i10, 1);
        this.f11767h[i10] = obj;
    }

    public final void e() {
        boolean z10;
        c cVar;
        if (this.f11770k || ((cVar = this.f11772m) != null && cVar.f11770k)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 == r7) goto L_0x0031
            boolean r1 = r8 instanceof java.util.List
            r2 = 0
            if (r1 == 0) goto L_0x0030
            java.util.List r8 = (java.util.List) r8
            java.lang.Object[] r1 = r7.f11767h
            int r3 = r7.f11769j
            int r4 = r8.size()
            if (r3 == r4) goto L_0x0015
            goto L_0x0027
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r3) goto L_0x002c
            int r5 = r7.f11768i
            int r5 = r5 + r4
            r5 = r1[r5]
            java.lang.Object r6 = r8.get(r4)
            boolean r5 = xa.j.a(r5, r6)
            if (r5 != 0) goto L_0x0029
        L_0x0027:
            r8 = 0
            goto L_0x002d
        L_0x0029:
            int r4 = r4 + 1
            goto L_0x0016
        L_0x002c:
            r8 = 1
        L_0x002d:
            if (r8 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: na.c.equals(java.lang.Object):boolean");
    }

    public final void f(int i10, int i11) {
        int i12 = this.f11769j + i11;
        if (this.f11771l != null) {
            throw new IllegalStateException();
        } else if (i12 >= 0) {
            Object[] objArr = this.f11767h;
            if (i12 > objArr.length) {
                k kVar = l.f10815k;
                int length = objArr.length;
                kVar.getClass();
                int i13 = length + (length >> 1);
                if (i13 - i12 < 0) {
                    i13 = i12;
                }
                if (i13 - 2147483639 > 0) {
                    if (i12 > 2147483639) {
                        i13 = Integer.MAX_VALUE;
                    } else {
                        i13 = 2147483639;
                    }
                }
                Object[] objArr2 = this.f11767h;
                j.f("<this>", objArr2);
                Object[] copyOf = Arrays.copyOf(objArr2, i13);
                j.e("copyOf(this, newSize)", copyOf);
                this.f11767h = copyOf;
            }
            Object[] objArr3 = this.f11767h;
            o.d(i10 + i11, i10, this.f11768i + this.f11769j, objArr3, objArr3);
            this.f11769j += i11;
        } else {
            throw new OutOfMemoryError();
        }
    }

    public final Object g(int i10) {
        c cVar = this.f11771l;
        if (cVar != null) {
            this.f11769j--;
            return cVar.g(i10);
        }
        Object[] objArr = this.f11767h;
        Object obj = objArr[i10];
        int i11 = this.f11769j;
        int i12 = this.f11768i;
        o.d(i10, i10 + 1, i11 + i12, objArr, objArr);
        Object[] objArr2 = this.f11767h;
        j.f("<this>", objArr2);
        objArr2[(i12 + this.f11769j) - 1] = null;
        this.f11769j--;
        return obj;
    }

    public final Object get(int i10) {
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.a(i10, i11);
        return this.f11767h[this.f11768i + i10];
    }

    public final void h(int i10, int i11) {
        c cVar = this.f11771l;
        if (cVar != null) {
            cVar.h(i10, i11);
        } else {
            Object[] objArr = this.f11767h;
            o.d(i10, i10 + i11, this.f11769j, objArr, objArr);
            Object[] objArr2 = this.f11767h;
            int i12 = this.f11769j;
            h0.t1(i12 - i11, i12, objArr2);
        }
        this.f11769j -= i11;
    }

    public final int hashCode() {
        int i10;
        Object[] objArr = this.f11767h;
        int i11 = this.f11769j;
        int i12 = 1;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[this.f11768i + i13];
            int i14 = i12 * 31;
            if (obj != null) {
                i10 = obj.hashCode();
            } else {
                i10 = 0;
            }
            i12 = i14 + i10;
        }
        return i12;
    }

    public final int i(int i10, int i11, Collection collection, boolean z10) {
        c cVar = this.f11771l;
        if (cVar != null) {
            int i12 = cVar.i(i10, i11, collection, z10);
            this.f11769j -= i12;
            return i12;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = i10 + i13;
            if (collection.contains(this.f11767h[i15]) == z10) {
                Object[] objArr = this.f11767h;
                i13++;
                objArr[i14 + i10] = objArr[i15];
                i14++;
            } else {
                i13++;
            }
        }
        int i16 = i11 - i14;
        Object[] objArr2 = this.f11767h;
        o.d(i10 + i14, i11 + i10, this.f11769j, objArr2, objArr2);
        Object[] objArr3 = this.f11767h;
        int i17 = this.f11769j;
        h0.t1(i17 - i16, i17, objArr3);
        this.f11769j -= i16;
        return i16;
    }

    public final int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f11769j; i10++) {
            if (j.a(this.f11767h[this.f11768i + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.f11769j == 0;
    }

    public final Iterator iterator() {
        return new b(this, 0);
    }

    public final int lastIndexOf(Object obj) {
        for (int i10 = this.f11769j - 1; i10 >= 0; i10--) {
            if (j.a(this.f11767h[this.f11768i + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    public final ListIterator listIterator() {
        return new b(this, 0);
    }

    public final boolean remove(Object obj) {
        e();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            b(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(Collection collection) {
        j.f("elements", collection);
        e();
        return i(this.f11768i, this.f11769j, collection, false) > 0;
    }

    public final boolean retainAll(Collection collection) {
        j.f("elements", collection);
        e();
        return i(this.f11768i, this.f11769j, collection, true) > 0;
    }

    public final Object set(int i10, Object obj) {
        e();
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.a(i10, i11);
        Object[] objArr = this.f11767h;
        int i12 = this.f11768i + i10;
        Object obj2 = objArr[i12];
        objArr[i12] = obj;
        return obj2;
    }

    public final List subList(int i10, int i11) {
        ma.c cVar = f.f10810h;
        int i12 = this.f11769j;
        cVar.getClass();
        ma.c.c(i10, i11, i12);
        Object[] objArr = this.f11767h;
        int i13 = this.f11768i + i10;
        int i14 = i11 - i10;
        boolean z10 = this.f11770k;
        c cVar2 = this.f11772m;
        return new c(objArr, i13, i14, z10, this, cVar2 == null ? this : cVar2);
    }

    public final Object[] toArray() {
        Object[] objArr = this.f11767h;
        int i10 = this.f11769j;
        int i11 = this.f11768i;
        int i12 = i10 + i11;
        j.f("<this>", objArr);
        m.a(i12, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i11, i12);
        j.e("copyOfRange(this, fromIndex, toIndex)", copyOfRange);
        return copyOfRange;
    }

    public final String toString() {
        Object[] objArr = this.f11767h;
        int i10 = this.f11769j;
        StringBuilder sb2 = new StringBuilder((i10 * 3) + 2);
        sb2.append("[");
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(objArr[this.f11768i + i11]);
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }

    public c(Object[] objArr, int i10, int i11, boolean z10, c cVar, c cVar2) {
        this.f11767h = objArr;
        this.f11768i = i10;
        this.f11769j = i11;
        this.f11770k = z10;
        this.f11771l = cVar;
        this.f11772m = cVar2;
    }

    public final boolean add(Object obj) {
        e();
        d(this.f11768i + this.f11769j, obj);
        return true;
    }

    public final boolean addAll(Collection collection) {
        j.f("elements", collection);
        e();
        int size = collection.size();
        c(this.f11768i + this.f11769j, collection, size);
        return size > 0;
    }

    public final ListIterator listIterator(int i10) {
        ma.c cVar = f.f10810h;
        int i11 = this.f11769j;
        cVar.getClass();
        ma.c.b(i10, i11);
        return new b(this, i10);
    }

    public final Object[] toArray(Object[] objArr) {
        j.f("destination", objArr);
        int length = objArr.length;
        int i10 = this.f11769j;
        int i11 = this.f11768i;
        if (length < i10) {
            Object[] copyOfRange = Arrays.copyOfRange(this.f11767h, i11, i10 + i11, objArr.getClass());
            j.e("copyOfRange(array, offse…h, destination.javaClass)", copyOfRange);
            return copyOfRange;
        }
        o.d(0, i11, i10 + i11, this.f11767h, objArr);
        int length2 = objArr.length;
        int i12 = this.f11769j;
        if (length2 > i12) {
            objArr[i12] = null;
        }
        return objArr;
    }
}
