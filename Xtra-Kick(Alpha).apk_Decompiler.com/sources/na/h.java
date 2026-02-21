package na;

import cb.e;
import hb.h0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import xa.j;
import ya.c;

public final class h implements Map, Serializable, c {

    /* renamed from: t  reason: collision with root package name */
    public static final d f11779t = new d(0);

    /* renamed from: h  reason: collision with root package name */
    public Object[] f11780h;

    /* renamed from: i  reason: collision with root package name */
    public Object[] f11781i = null;

    /* renamed from: j  reason: collision with root package name */
    public int[] f11782j = new int[8];

    /* renamed from: k  reason: collision with root package name */
    public int[] f11783k;

    /* renamed from: l  reason: collision with root package name */
    public int f11784l;

    /* renamed from: m  reason: collision with root package name */
    public int f11785m;

    /* renamed from: n  reason: collision with root package name */
    public int f11786n;

    /* renamed from: o  reason: collision with root package name */
    public int f11787o;

    /* renamed from: p  reason: collision with root package name */
    public j f11788p;

    /* renamed from: q  reason: collision with root package name */
    public k f11789q;

    /* renamed from: r  reason: collision with root package name */
    public i f11790r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11791s;

    public h() {
        Object[] h10 = h0.h(8);
        f11779t.getClass();
        int highestOneBit = Integer.highestOneBit(24);
        this.f11780h = h10;
        this.f11783k = new int[highestOneBit];
        this.f11784l = 2;
        this.f11785m = 0;
        this.f11786n = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int g10 = g(obj);
            int i10 = this.f11784l * 2;
            int length = this.f11783k.length / 2;
            if (i10 > length) {
                i10 = length;
            }
            int i11 = 0;
            while (true) {
                int[] iArr = this.f11783k;
                int i12 = iArr[g10];
                if (i12 <= 0) {
                    int i13 = this.f11785m;
                    Object[] objArr = this.f11780h;
                    if (i13 >= objArr.length) {
                        e(1);
                    } else {
                        int i14 = i13 + 1;
                        this.f11785m = i14;
                        objArr[i13] = obj;
                        this.f11782j[i13] = g10;
                        iArr[g10] = i14;
                        this.f11787o++;
                        if (i11 > this.f11784l) {
                            this.f11784l = i11;
                        }
                        return i13;
                    }
                } else if (j.a(this.f11780h[i12 - 1], obj)) {
                    return -i12;
                } else {
                    i11++;
                    if (i11 > i10) {
                        h(this.f11783k.length * 2);
                        break;
                    }
                    int i15 = g10 - 1;
                    if (g10 == 0) {
                        g10 = this.f11783k.length - 1;
                    } else {
                        g10 = i15;
                    }
                }
            }
        }
    }

    public final void b() {
        if (this.f11791s) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean c(Collection collection) {
        j.f("m", collection);
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!d((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final void clear() {
        b();
        cb.c a10 = new e(0, this.f11785m - 1).iterator();
        while (a10.f3068j) {
            int a11 = a10.a();
            int[] iArr = this.f11782j;
            int i10 = iArr[a11];
            if (i10 >= 0) {
                this.f11783k[i10] = 0;
                iArr[a11] = -1;
            }
        }
        h0.t1(0, this.f11785m, this.f11780h);
        Object[] objArr = this.f11781i;
        if (objArr != null) {
            h0.t1(0, this.f11785m, objArr);
        }
        this.f11787o = 0;
        this.f11785m = 0;
    }

    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public final boolean containsValue(Object obj) {
        int i10;
        int i11 = this.f11785m;
        while (true) {
            i10 = -1;
            i11--;
            if (i11 < 0) {
                break;
            } else if (this.f11782j[i11] >= 0) {
                Object[] objArr = this.f11781i;
                j.c(objArr);
                if (j.a(objArr[i11], obj)) {
                    i10 = i11;
                    break;
                }
            }
        }
        return i10 >= 0;
    }

    public final boolean d(Map.Entry entry) {
        j.f("entry", entry);
        int f10 = f(entry.getKey());
        if (f10 < 0) {
            return false;
        }
        Object[] objArr = this.f11781i;
        j.c(objArr);
        return j.a(objArr[f10], entry.getValue());
    }

    public final void e(int i10) {
        boolean z10;
        Object[] objArr;
        Object[] objArr2 = this.f11780h;
        int length = objArr2.length;
        int i11 = this.f11785m;
        int i12 = length - i11;
        int i13 = i11 - this.f11787o;
        int i14 = 1;
        if (i12 >= i10 || i12 + i13 < i10 || i13 < objArr2.length / 4) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            h(this.f11783k.length);
            return;
        }
        int i15 = i11 + i10;
        if (i15 < 0) {
            throw new OutOfMemoryError();
        } else if (i15 > objArr2.length) {
            int length2 = (objArr2.length * 3) / 2;
            if (i15 <= length2) {
                i15 = length2;
            }
            Object[] copyOf = Arrays.copyOf(objArr2, i15);
            j.e("copyOf(this, newSize)", copyOf);
            this.f11780h = copyOf;
            Object[] objArr3 = this.f11781i;
            if (objArr3 != null) {
                objArr = Arrays.copyOf(objArr3, i15);
                j.e("copyOf(this, newSize)", objArr);
            } else {
                objArr = null;
            }
            this.f11781i = objArr;
            int[] copyOf2 = Arrays.copyOf(this.f11782j, i15);
            j.e("copyOf(this, newSize)", copyOf2);
            this.f11782j = copyOf2;
            f11779t.getClass();
            if (i15 >= 1) {
                i14 = i15;
            }
            int highestOneBit = Integer.highestOneBit(i14 * 3);
            if (highestOneBit > this.f11783k.length) {
                h(highestOneBit);
            }
        }
    }

    public final Set entrySet() {
        i iVar = this.f11790r;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f11790r = iVar2;
        return iVar2;
    }

    public final boolean equals(Object obj) {
        boolean z10;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f11787o != map.size() || !c(map.entrySet())) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return true;
            }
        }
        return false;
    }

    public final int f(Object obj) {
        int g10 = g(obj);
        int i10 = this.f11784l;
        while (true) {
            int i11 = this.f11783k[g10];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (j.a(this.f11780h[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            int i13 = g10 - 1;
            if (g10 == 0) {
                g10 = this.f11783k.length - 1;
            } else {
                g10 = i13;
            }
        }
    }

    public final int g(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * -1640531527) >>> this.f11786n;
    }

    public final Object get(Object obj) {
        int f10 = f(obj);
        if (f10 < 0) {
            return null;
        }
        Object[] objArr = this.f11781i;
        j.c(objArr);
        return objArr[f10];
    }

    public final void h(int i10) {
        boolean z10;
        int i11;
        if (this.f11785m > this.f11787o) {
            Object[] objArr = this.f11781i;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i11 = this.f11785m;
                if (i12 >= i11) {
                    break;
                }
                if (this.f11782j[i12] >= 0) {
                    Object[] objArr2 = this.f11780h;
                    objArr2[i13] = objArr2[i12];
                    if (objArr != null) {
                        objArr[i13] = objArr[i12];
                    }
                    i13++;
                }
                i12++;
            }
            h0.t1(i13, i11, this.f11780h);
            if (objArr != null) {
                h0.t1(i13, this.f11785m, objArr);
            }
            this.f11785m = i13;
        }
        int[] iArr = this.f11783k;
        if (i10 != iArr.length) {
            this.f11783k = new int[i10];
            f11779t.getClass();
            this.f11786n = Integer.numberOfLeadingZeros(i10) + 1;
        } else {
            Arrays.fill(iArr, 0, iArr.length, 0);
        }
        int i14 = 0;
        while (i14 < this.f11785m) {
            int i15 = i14 + 1;
            int g10 = g(this.f11780h[i14]);
            int i16 = this.f11784l;
            while (true) {
                int[] iArr2 = this.f11783k;
                if (iArr2[g10] == 0) {
                    iArr2[g10] = i15;
                    this.f11782j[i14] = g10;
                    z10 = true;
                    break;
                }
                i16--;
                if (i16 < 0) {
                    z10 = false;
                    break;
                }
                int i17 = g10 - 1;
                if (g10 == 0) {
                    g10 = iArr2.length - 1;
                } else {
                    g10 = i17;
                }
            }
            if (z10) {
                i14 = i15;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    public final int hashCode() {
        int i10;
        int i11;
        e eVar = new e(this, 0);
        int i12 = 0;
        while (eVar.hasNext()) {
            int i13 = eVar.f11777i;
            h hVar = eVar.f11776h;
            if (i13 < hVar.f11785m) {
                eVar.f11777i = i13 + 1;
                eVar.f11778j = i13;
                Object obj = hVar.f11780h[i13];
                if (obj != null) {
                    i10 = obj.hashCode();
                } else {
                    i10 = 0;
                }
                Object[] objArr = hVar.f11781i;
                j.c(objArr);
                Object obj2 = objArr[eVar.f11778j];
                if (obj2 != null) {
                    i11 = obj2.hashCode();
                } else {
                    i11 = 0;
                }
                eVar.a();
                i12 += i10 ^ i11;
            } else {
                throw new NoSuchElementException();
            }
        }
        return i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f11780h
            java.lang.String r1 = "<this>"
            xa.j.f(r1, r0)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.f11782j
            r0 = r0[r12]
            int r1 = r11.f11784l
            int r1 = r1 * 2
            int[] r2 = r11.f11783k
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            r2 = 0
            r3 = r1
            r4 = 0
            r1 = r0
        L_0x001e:
            int r5 = r0 + -1
            r6 = -1
            if (r0 != 0) goto L_0x0028
            int[] r0 = r11.f11783k
            int r0 = r0.length
            int r0 = r0 + r6
            goto L_0x0029
        L_0x0028:
            r0 = r5
        L_0x0029:
            int r4 = r4 + 1
            int r5 = r11.f11784l
            if (r4 <= r5) goto L_0x0034
            int[] r0 = r11.f11783k
            r0[r1] = r2
            goto L_0x0063
        L_0x0034:
            int[] r5 = r11.f11783k
            r7 = r5[r0]
            if (r7 != 0) goto L_0x003d
            r5[r1] = r2
            goto L_0x0063
        L_0x003d:
            if (r7 >= 0) goto L_0x0042
            r5[r1] = r6
            goto L_0x005a
        L_0x0042:
            java.lang.Object[] r5 = r11.f11780h
            int r8 = r7 + -1
            r5 = r5[r8]
            int r5 = r11.g(r5)
            int r5 = r5 - r0
            int[] r9 = r11.f11783k
            int r10 = r9.length
            int r10 = r10 + r6
            r5 = r5 & r10
            if (r5 < r4) goto L_0x005c
            r9[r1] = r7
            int[] r4 = r11.f11782j
            r4[r8] = r1
        L_0x005a:
            r1 = r0
            r4 = 0
        L_0x005c:
            int r3 = r3 + r6
            if (r3 >= 0) goto L_0x001e
            int[] r0 = r11.f11783k
            r0[r1] = r6
        L_0x0063:
            int[] r0 = r11.f11782j
            r0[r12] = r6
            int r12 = r11.f11787o
            int r12 = r12 + r6
            r11.f11787o = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: na.h.i(int):void");
    }

    public final boolean isEmpty() {
        return this.f11787o == 0;
    }

    public final Set keySet() {
        j jVar = this.f11788p;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this);
        this.f11788p = jVar2;
        return jVar2;
    }

    public final Object put(Object obj, Object obj2) {
        b();
        int a10 = a(obj);
        Object[] objArr = this.f11781i;
        if (objArr == null) {
            objArr = h0.h(this.f11780h.length);
            this.f11781i = objArr;
        }
        if (a10 < 0) {
            int i10 = (-a10) - 1;
            Object obj3 = objArr[i10];
            objArr[i10] = obj2;
            return obj3;
        }
        objArr[a10] = obj2;
        return null;
    }

    public final void putAll(Map map) {
        j.f("from", map);
        b();
        Set<Map.Entry> entrySet = map.entrySet();
        if (!entrySet.isEmpty()) {
            e(entrySet.size());
            for (Map.Entry entry : entrySet) {
                int a10 = a(entry.getKey());
                Object[] objArr = this.f11781i;
                if (objArr == null) {
                    objArr = h0.h(this.f11780h.length);
                    this.f11781i = objArr;
                }
                if (a10 >= 0) {
                    objArr[a10] = entry.getValue();
                } else {
                    int i10 = (-a10) - 1;
                    if (!j.a(entry.getValue(), objArr[i10])) {
                        objArr[i10] = entry.getValue();
                    }
                }
            }
        }
    }

    public final Object remove(Object obj) {
        b();
        int f10 = f(obj);
        if (f10 < 0) {
            f10 = -1;
        } else {
            i(f10);
        }
        if (f10 < 0) {
            return null;
        }
        Object[] objArr = this.f11781i;
        j.c(objArr);
        Object obj2 = objArr[f10];
        objArr[f10] = null;
        return obj2;
    }

    public final int size() {
        return this.f11787o;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder((this.f11787o * 3) + 2);
        sb2.append("{");
        int i10 = 0;
        e eVar = new e(this, 0);
        while (eVar.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            int i11 = eVar.f11777i;
            h hVar = eVar.f11776h;
            if (i11 < hVar.f11785m) {
                eVar.f11777i = i11 + 1;
                eVar.f11778j = i11;
                Object obj = hVar.f11780h[i11];
                if (j.a(obj, hVar)) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append('=');
                Object[] objArr = hVar.f11781i;
                j.c(objArr);
                Object obj2 = objArr[eVar.f11778j];
                if (j.a(obj2, hVar)) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                eVar.a();
                i10++;
            } else {
                throw new NoSuchElementException();
            }
        }
        sb2.append("}");
        String sb3 = sb2.toString();
        j.e("sb.toString()", sb3);
        return sb3;
    }

    public final Collection values() {
        k kVar = this.f11789q;
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this);
        this.f11789q = kVar2;
        return kVar2;
    }
}
