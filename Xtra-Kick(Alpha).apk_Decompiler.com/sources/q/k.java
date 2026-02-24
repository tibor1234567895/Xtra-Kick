package q;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class k {

    /* renamed from: k  reason: collision with root package name */
    public static Object[] f13075k;

    /* renamed from: l  reason: collision with root package name */
    public static int f13076l;

    /* renamed from: m  reason: collision with root package name */
    public static Object[] f13077m;

    /* renamed from: n  reason: collision with root package name */
    public static int f13078n;

    /* renamed from: h  reason: collision with root package name */
    public int[] f13079h;

    /* renamed from: i  reason: collision with root package name */
    public Object[] f13080i;

    /* renamed from: j  reason: collision with root package name */
    public int f13081j;

    public k() {
        this.f13079h = g.f13060a;
        this.f13080i = g.f13061b;
        this.f13081j = 0;
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (k.class) {
                Object[] objArr = f13077m;
                if (objArr != null) {
                    this.f13080i = objArr;
                    f13077m = (Object[]) objArr[0];
                    this.f13079h = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f13078n--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (k.class) {
                Object[] objArr2 = f13075k;
                if (objArr2 != null) {
                    this.f13080i = objArr2;
                    f13075k = (Object[]) objArr2[0];
                    this.f13079h = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f13076l--;
                    return;
                }
            }
        }
        this.f13079h = new int[i10];
        this.f13080i = new Object[(i10 << 1)];
    }

    public static void c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (k.class) {
                if (f13078n < 10) {
                    objArr[0] = f13077m;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f13077m = objArr;
                    f13078n++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (k.class) {
                if (f13076l < 10) {
                    objArr[0] = f13075k;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f13075k = objArr;
                    f13076l++;
                }
            }
        }
    }

    public final void b(int i10) {
        int i11 = this.f13081j;
        int[] iArr = this.f13079h;
        if (iArr.length < i10) {
            Object[] objArr = this.f13080i;
            a(i10);
            if (this.f13081j > 0) {
                System.arraycopy(iArr, 0, this.f13079h, 0, i11);
                System.arraycopy(objArr, 0, this.f13080i, 0, i11 << 1);
            }
            c(iArr, objArr, i11);
        }
        if (this.f13081j != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f13081j;
        if (i10 > 0) {
            int[] iArr = this.f13079h;
            Object[] objArr = this.f13080i;
            this.f13079h = g.f13060a;
            this.f13080i = g.f13061b;
            this.f13081j = 0;
            c(iArr, objArr, i10);
        }
        if (this.f13081j > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final int d(int i10, Object obj) {
        int i11 = this.f13081j;
        if (i11 == 0) {
            return -1;
        }
        try {
            int a10 = g.a(i11, i10, this.f13079h);
            if (a10 < 0 || obj.equals(this.f13080i[a10 << 1])) {
                return a10;
            }
            int i12 = a10 + 1;
            while (i12 < i11 && this.f13079h[i12] == i10) {
                if (obj.equals(this.f13080i[i12 << 1])) {
                    return i12;
                }
                i12++;
            }
            int i13 = a10 - 1;
            while (i13 >= 0 && this.f13079h[i13] == i10) {
                if (obj.equals(this.f13080i[i13 << 1])) {
                    return i13;
                }
                i13--;
            }
            return ~i12;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof k) {
                k kVar = (k) obj;
                if (this.f13081j != kVar.f13081j) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f13081j; i10++) {
                    Object h10 = h(i10);
                    Object l10 = l(i10);
                    Object orDefault = kVar.getOrDefault(h10, (Object) null);
                    if (l10 == null) {
                        if (orDefault != null || !kVar.containsKey(h10)) {
                            return false;
                        }
                    } else if (!l10.equals(orDefault)) {
                        return false;
                    }
                }
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (this.f13081j != map.size()) {
                    return false;
                }
                for (int i11 = 0; i11 < this.f13081j; i11++) {
                    Object h11 = h(i11);
                    Object l11 = l(i11);
                    Object obj2 = map.get(h11);
                    if (l11 == null) {
                        if (obj2 != null || !map.containsKey(h11)) {
                            return false;
                        }
                    } else if (!l11.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
        }
    }

    public final int f() {
        int i10 = this.f13081j;
        if (i10 == 0) {
            return -1;
        }
        try {
            int a10 = g.a(i10, 0, this.f13079h);
            if (a10 < 0 || this.f13080i[a10 << 1] == null) {
                return a10;
            }
            int i11 = a10 + 1;
            while (i11 < i10 && this.f13079h[i11] == 0) {
                if (this.f13080i[i11 << 1] == null) {
                    return i11;
                }
                i11++;
            }
            int i12 = a10 - 1;
            while (i12 >= 0 && this.f13079h[i12] == 0) {
                if (this.f13080i[i12 << 1] == null) {
                    return i12;
                }
                i12--;
            }
            return ~i11;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* access modifiers changed from: package-private */
    public final int g(Object obj) {
        int i10 = this.f13081j * 2;
        Object[] objArr = this.f13080i;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public final Object get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int e10 = e(obj);
        return e10 >= 0 ? this.f13080i[(e10 << 1) + 1] : obj2;
    }

    public final Object h(int i10) {
        return this.f13080i[i10 << 1];
    }

    public int hashCode() {
        int[] iArr = this.f13079h;
        Object[] objArr = this.f13080i;
        int i10 = this.f13081j;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            i13 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return i13;
    }

    public void i(e eVar) {
        int i10 = eVar.f13081j;
        b(this.f13081j + i10);
        if (this.f13081j != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(eVar.h(i11), eVar.l(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(eVar.f13079h, 0, this.f13079h, 0, i10);
            System.arraycopy(eVar.f13080i, 0, this.f13080i, 0, i10 << 1);
            this.f13081j = i10;
        }
    }

    public final boolean isEmpty() {
        return this.f13081j <= 0;
    }

    public Object j(int i10) {
        Object[] objArr = this.f13080i;
        int i11 = i10 << 1;
        Object obj = objArr[i11 + 1];
        int i12 = this.f13081j;
        if (i12 <= 1) {
            clear();
        } else {
            int i13 = i12 - 1;
            int[] iArr = this.f13079h;
            int i14 = 8;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i13) {
                    int i15 = i10 + 1;
                    int i16 = i13 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f13080i;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f13080i;
                int i17 = i13 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                if (i12 > 8) {
                    i14 = i12 + (i12 >> 1);
                }
                a(i14);
                if (i12 == this.f13081j) {
                    if (i10 > 0) {
                        System.arraycopy(iArr, 0, this.f13079h, 0, i10);
                        System.arraycopy(objArr, 0, this.f13080i, 0, i11);
                    }
                    if (i10 < i13) {
                        int i18 = i10 + 1;
                        int i19 = i13 - i10;
                        System.arraycopy(iArr, i18, this.f13079h, i10, i19);
                        System.arraycopy(objArr, i18 << 1, this.f13080i, i11, i19 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i12 == this.f13081j) {
                this.f13081j = i13;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return obj;
    }

    public Object k(int i10, Object obj) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f13080i;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        return obj2;
    }

    public final Object l(int i10) {
        return this.f13080i[(i10 << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i10;
        int i11;
        int i12 = this.f13081j;
        if (obj == null) {
            i11 = f();
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            i11 = d(hashCode, obj);
        }
        if (i11 >= 0) {
            int i13 = (i11 << 1) + 1;
            Object[] objArr = this.f13080i;
            Object obj3 = objArr[i13];
            objArr[i13] = obj2;
            return obj3;
        }
        int i14 = ~i11;
        int[] iArr = this.f13079h;
        if (i12 >= iArr.length) {
            int i15 = 8;
            if (i12 >= 8) {
                i15 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i15 = 4;
            }
            Object[] objArr2 = this.f13080i;
            a(i15);
            if (i12 == this.f13081j) {
                int[] iArr2 = this.f13079h;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f13080i, 0, objArr2.length);
                }
                c(iArr, objArr2, i12);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i14 < i12) {
            int[] iArr3 = this.f13079h;
            int i16 = i14 + 1;
            System.arraycopy(iArr3, i14, iArr3, i16, i12 - i14);
            Object[] objArr3 = this.f13080i;
            System.arraycopy(objArr3, i14 << 1, objArr3, i16 << 1, (this.f13081j - i14) << 1);
        }
        int i17 = this.f13081j;
        if (i12 == i17) {
            int[] iArr4 = this.f13079h;
            if (i14 < iArr4.length) {
                iArr4[i14] = i10;
                Object[] objArr4 = this.f13080i;
                int i18 = i14 << 1;
                objArr4[i18] = obj;
                objArr4[i18 + 1] = obj2;
                this.f13081j = i17 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object orDefault = getOrDefault(obj, (Object) null);
        if (orDefault == null) {
            return put(obj, obj2);
        }
        return orDefault;
    }

    public final Object remove(Object obj) {
        int e10 = e(obj);
        if (e10 >= 0) {
            return j(e10);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int e10 = e(obj);
        if (e10 >= 0) {
            return k(e10, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f13081j;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f13081j * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f13081j; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object h10 = h(i10);
            if (h10 != this) {
                sb2.append(h10);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object l10 = l(i10);
            if (l10 != this) {
                sb2.append(l10);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public k(int i10) {
        if (i10 == 0) {
            this.f13079h = g.f13060a;
            this.f13080i = g.f13061b;
        } else {
            a(i10);
        }
        this.f13081j = 0;
    }

    public final boolean remove(Object obj, Object obj2) {
        int e10 = e(obj);
        if (e10 < 0) {
            return false;
        }
        Object l10 = l(e10);
        if (obj2 != l10 && (obj2 == null || !obj2.equals(l10))) {
            return false;
        }
        j(e10);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int e10 = e(obj);
        if (e10 < 0) {
            return false;
        }
        Object l10 = l(e10);
        if (l10 != obj2 && (obj2 == null || !obj2.equals(l10))) {
            return false;
        }
        k(e10, obj3);
        return true;
    }
}
