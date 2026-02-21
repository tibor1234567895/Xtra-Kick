package ma;

import android.support.v4.media.h;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import wb.j0;
import xa.j;

public final class l extends h {

    /* renamed from: k  reason: collision with root package name */
    public static final k f10815k = new k(0);

    /* renamed from: l  reason: collision with root package name */
    public static final Object[] f10816l = new Object[0];

    /* renamed from: h  reason: collision with root package name */
    public int f10817h;

    /* renamed from: i  reason: collision with root package name */
    public Object[] f10818i;

    /* renamed from: j  reason: collision with root package name */
    public int f10819j;

    public l() {
        this.f10818i = f10816l;
    }

    public final int a() {
        return this.f10819j;
    }

    public final void add(int i10, Object obj) {
        c cVar = f.f10810h;
        int i11 = this.f10819j;
        cVar.getClass();
        c.b(i10, i11);
        int i12 = this.f10819j;
        if (i10 == i12) {
            d(obj);
        } else if (i10 == 0) {
            c(obj);
        } else {
            f(i12 + 1);
            int i13 = i(this.f10817h + i10);
            int i14 = this.f10819j;
            if (i10 < ((i14 + 1) >> 1)) {
                if (i13 == 0) {
                    Object[] objArr = this.f10818i;
                    j.f("<this>", objArr);
                    i13 = objArr.length;
                }
                int i15 = i13 - 1;
                int i16 = this.f10817h;
                if (i16 == 0) {
                    Object[] objArr2 = this.f10818i;
                    j.f("<this>", objArr2);
                    i16 = objArr2.length;
                }
                int i17 = i16 - 1;
                int i18 = this.f10817h;
                Object[] objArr3 = this.f10818i;
                if (i15 >= i18) {
                    objArr3[i17] = objArr3[i18];
                    o.d(i18, i18 + 1, i15 + 1, objArr3, objArr3);
                } else {
                    o.d(i18 - 1, i18, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.f10818i;
                    objArr4[objArr4.length - 1] = objArr4[0];
                    o.d(0, 1, i15 + 1, objArr4, objArr4);
                }
                this.f10818i[i15] = obj;
                this.f10817h = i17;
            } else {
                int i19 = i(i14 + this.f10817h);
                Object[] objArr5 = this.f10818i;
                if (i13 < i19) {
                    o.d(i13 + 1, i13, i19, objArr5, objArr5);
                } else {
                    o.d(1, 0, i19, objArr5, objArr5);
                    Object[] objArr6 = this.f10818i;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    o.d(i13 + 1, i13, objArr6.length - 1, objArr6, objArr6);
                }
                this.f10818i[i13] = obj;
            }
            this.f10819j++;
        }
    }

    public final boolean addAll(int i10, Collection collection) {
        j.f("elements", collection);
        c cVar = f.f10810h;
        int i11 = this.f10819j;
        cVar.getClass();
        c.b(i10, i11);
        if (collection.isEmpty()) {
            return false;
        }
        int i12 = this.f10819j;
        if (i10 == i12) {
            return addAll(collection);
        }
        f(collection.size() + i12);
        int i13 = i(this.f10819j + this.f10817h);
        int i14 = i(this.f10817h + i10);
        int size = collection.size();
        if (i10 < ((this.f10819j + 1) >> 1)) {
            int i15 = this.f10817h;
            int i16 = i15 - size;
            if (i14 < i15) {
                Object[] objArr = this.f10818i;
                o.d(i16, i15, objArr.length, objArr, objArr);
                Object[] objArr2 = this.f10818i;
                int length = objArr2.length - size;
                if (size >= i14) {
                    o.d(length, 0, i14, objArr2, objArr2);
                } else {
                    o.d(length, 0, size, objArr2, objArr2);
                    Object[] objArr3 = this.f10818i;
                    o.d(0, size, i14, objArr3, objArr3);
                }
            } else if (i16 >= 0) {
                Object[] objArr4 = this.f10818i;
                o.d(i16, i15, i14, objArr4, objArr4);
            } else {
                Object[] objArr5 = this.f10818i;
                i16 += objArr5.length;
                int i17 = i14 - i15;
                int length2 = objArr5.length - i16;
                if (length2 >= i17) {
                    o.d(i16, i15, i14, objArr5, objArr5);
                } else {
                    o.d(i16, i15, i15 + length2, objArr5, objArr5);
                    Object[] objArr6 = this.f10818i;
                    o.d(0, this.f10817h + length2, i14, objArr6, objArr6);
                }
            }
            this.f10817h = i16;
            i14 -= size;
            if (i14 < 0) {
                i14 += this.f10818i.length;
            }
        } else {
            int i18 = i14 + size;
            if (i14 < i13) {
                int i19 = size + i13;
                Object[] objArr7 = this.f10818i;
                if (i19 > objArr7.length) {
                    if (i18 >= objArr7.length) {
                        i18 -= objArr7.length;
                    } else {
                        int length3 = i13 - (i19 - objArr7.length);
                        o.d(0, length3, i13, objArr7, objArr7);
                        Object[] objArr8 = this.f10818i;
                        o.d(i18, i14, length3, objArr8, objArr8);
                    }
                }
                o.d(i18, i14, i13, objArr7, objArr7);
            } else {
                Object[] objArr9 = this.f10818i;
                o.d(size, 0, i13, objArr9, objArr9);
                Object[] objArr10 = this.f10818i;
                if (i18 >= objArr10.length) {
                    o.d(i18 - objArr10.length, i14, objArr10.length, objArr10, objArr10);
                } else {
                    o.d(0, objArr10.length - size, objArr10.length, objArr10, objArr10);
                    Object[] objArr11 = this.f10818i;
                    o.d(i18, i14, objArr11.length - size, objArr11, objArr11);
                }
            }
        }
        e(i14, collection);
        return true;
    }

    public final Object b(int i10) {
        c cVar = f.f10810h;
        int i11 = this.f10819j;
        cVar.getClass();
        c.a(i10, i11);
        if (i10 == r.d(this)) {
            return k();
        }
        if (i10 == 0) {
            return j();
        }
        int i12 = i(this.f10817h + i10);
        Object[] objArr = this.f10818i;
        Object obj = objArr[i12];
        if (i10 < (this.f10819j >> 1)) {
            int i13 = this.f10817h;
            if (i12 >= i13) {
                o.d(i13 + 1, i13, i12, objArr, objArr);
            } else {
                o.d(1, 0, i12, objArr, objArr);
                Object[] objArr2 = this.f10818i;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i14 = this.f10817h;
                o.d(i14 + 1, i14, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f10818i;
            int i15 = this.f10817h;
            objArr3[i15] = null;
            this.f10817h = g(i15);
        } else {
            int i16 = i(r.d(this) + this.f10817h);
            Object[] objArr4 = this.f10818i;
            int i17 = i12 + 1;
            if (i12 <= i16) {
                o.d(i12, i17, i16 + 1, objArr4, objArr4);
            } else {
                o.d(i12, i17, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f10818i;
                objArr5[objArr5.length - 1] = objArr5[0];
                o.d(0, 1, i16 + 1, objArr5, objArr5);
            }
            this.f10818i[i16] = null;
        }
        this.f10819j--;
        return obj;
    }

    public final void c(Object obj) {
        f(this.f10819j + 1);
        int i10 = this.f10817h;
        if (i10 == 0) {
            Object[] objArr = this.f10818i;
            j.f("<this>", objArr);
            i10 = objArr.length;
        }
        int i11 = i10 - 1;
        this.f10817h = i11;
        this.f10818i[i11] = obj;
        this.f10819j++;
    }

    public final void clear() {
        int i10 = i(this.f10819j + this.f10817h);
        int i11 = this.f10817h;
        if (i11 < i10) {
            o.f(this.f10818i, (j0) null, i11, i10);
        } else if (!isEmpty()) {
            Object[] objArr = this.f10818i;
            o.f(objArr, (j0) null, this.f10817h, objArr.length);
            o.f(this.f10818i, (j0) null, 0, i10);
        }
        this.f10817h = 0;
        this.f10819j = 0;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(Object obj) {
        f(a() + 1);
        this.f10818i[i(a() + this.f10817h)] = obj;
        this.f10819j = a() + 1;
    }

    public final void e(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f10818i.length;
        while (i10 < length && it.hasNext()) {
            this.f10818i[i10] = it.next();
            i10++;
        }
        int i11 = this.f10817h;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f10818i[i12] = it.next();
        }
        this.f10819j = collection.size() + a();
    }

    public final void f(int i10) {
        if (i10 >= 0) {
            Object[] objArr = this.f10818i;
            if (i10 > objArr.length) {
                if (objArr == f10816l) {
                    if (i10 < 10) {
                        i10 = 10;
                    }
                    this.f10818i = new Object[i10];
                    return;
                }
                int length = objArr.length;
                f10815k.getClass();
                int i11 = length + (length >> 1);
                if (i11 - i10 < 0) {
                    i11 = i10;
                }
                if (i11 - 2147483639 > 0) {
                    if (i10 > 2147483639) {
                        i11 = Integer.MAX_VALUE;
                    } else {
                        i11 = 2147483639;
                    }
                }
                Object[] objArr2 = new Object[i11];
                Object[] objArr3 = this.f10818i;
                o.d(0, this.f10817h, objArr3.length, objArr3, objArr2);
                Object[] objArr4 = this.f10818i;
                int length2 = objArr4.length;
                int i12 = this.f10817h;
                o.d(length2 - i12, 0, i12, objArr4, objArr2);
                this.f10817h = 0;
                this.f10818i = objArr2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.f10818i[this.f10817h];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final int g(int i10) {
        Object[] objArr = this.f10818i;
        j.f("<this>", objArr);
        if (i10 == objArr.length - 1) {
            return 0;
        }
        return i10 + 1;
    }

    public final Object get(int i10) {
        c cVar = f.f10810h;
        int i11 = this.f10819j;
        cVar.getClass();
        c.a(i10, i11);
        return this.f10818i[i(this.f10817h + i10)];
    }

    public final Object h() {
        if (isEmpty()) {
            return null;
        }
        return this.f10818i[i(r.d(this) + this.f10817h)];
    }

    public final int i(int i10) {
        Object[] objArr = this.f10818i;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    public final int indexOf(Object obj) {
        int i10 = i(a() + this.f10817h);
        int i11 = this.f10817h;
        if (i11 < i10) {
            while (i11 < i10) {
                if (!j.a(obj, this.f10818i[i11])) {
                    i11++;
                }
            }
            return -1;
        } else if (i11 < i10) {
            return -1;
        } else {
            int length = this.f10818i.length;
            while (true) {
                if (i11 >= length) {
                    int i12 = 0;
                    while (i12 < i10) {
                        if (j.a(obj, this.f10818i[i12])) {
                            i11 = i12 + this.f10818i.length;
                        } else {
                            i12++;
                        }
                    }
                    return -1;
                } else if (j.a(obj, this.f10818i[i11])) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        return i11 - this.f10817h;
    }

    public final boolean isEmpty() {
        return a() == 0;
    }

    public final Object j() {
        if (!isEmpty()) {
            Object[] objArr = this.f10818i;
            int i10 = this.f10817h;
            Object obj = objArr[i10];
            objArr[i10] = null;
            this.f10817h = g(i10);
            this.f10819j = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object k() {
        if (!isEmpty()) {
            int i10 = i(r.d(this) + this.f10817h);
            Object[] objArr = this.f10818i;
            Object obj = objArr[i10];
            objArr[i10] = null;
            this.f10819j = a() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object last() {
        if (!isEmpty()) {
            return this.f10818i[i(r.d(this) + this.f10817h)];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final int lastIndexOf(Object obj) {
        int i10;
        int i11 = i(this.f10819j + this.f10817h);
        int i12 = this.f10817h;
        if (i12 < i11) {
            i10 = i11 - 1;
            if (i12 <= i10) {
                while (!j.a(obj, this.f10818i[i10])) {
                    if (i10 != i12) {
                        i10--;
                    }
                }
            }
            return -1;
        }
        if (i12 > i11) {
            int i13 = i11 - 1;
            while (true) {
                if (-1 >= i13) {
                    Object[] objArr = this.f10818i;
                    j.f("<this>", objArr);
                    int length = objArr.length - 1;
                    int i14 = this.f10817h;
                    if (i14 <= length) {
                        while (!j.a(obj, this.f10818i[i10])) {
                            if (i10 != i14) {
                                length = i10 - 1;
                            }
                        }
                    }
                } else if (j.a(obj, this.f10818i[i13])) {
                    i10 = i13 + this.f10818i.length;
                    break;
                } else {
                    i13--;
                }
            }
        }
        return -1;
        return i10 - this.f10817h;
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        b(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean removeAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            xa.j.f(r0, r12)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0096
            java.lang.Object[] r0 = r11.f10818i
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0096
        L_0x0019:
            int r0 = r11.f10817h
            int r3 = r11.f10819j
            int r3 = r3 + r0
            int r0 = r11.i(r3)
            int r3 = r11.f10817h
            r4 = 0
            if (r3 >= r0) goto L_0x0047
            r5 = r3
        L_0x0028:
            if (r3 >= r0) goto L_0x0041
            java.lang.Object[] r6 = r11.f10818i
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003d
            java.lang.Object[] r7 = r11.f10818i
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003e
        L_0x003d:
            r1 = 1
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0041:
            java.lang.Object[] r12 = r11.f10818i
            ma.o.f(r12, r4, r5, r0)
            goto L_0x0089
        L_0x0047:
            java.lang.Object[] r5 = r11.f10818i
            int r5 = r5.length
            r6 = r3
            r7 = 0
        L_0x004c:
            if (r3 >= r5) goto L_0x0067
            java.lang.Object[] r8 = r11.f10818i
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0063
            java.lang.Object[] r8 = r11.f10818i
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0064
        L_0x0063:
            r7 = 1
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x0067:
            int r3 = r11.i(r6)
            r5 = r3
        L_0x006c:
            if (r1 >= r0) goto L_0x0088
            java.lang.Object[] r3 = r11.f10818i
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0084
            java.lang.Object[] r3 = r11.f10818i
            r3[r5] = r6
            int r5 = r11.g(r5)
            goto L_0x0085
        L_0x0084:
            r7 = 1
        L_0x0085:
            int r1 = r1 + 1
            goto L_0x006c
        L_0x0088:
            r1 = r7
        L_0x0089:
            if (r1 == 0) goto L_0x0096
            int r12 = r11.f10817h
            int r5 = r5 - r12
            if (r5 >= 0) goto L_0x0094
            java.lang.Object[] r12 = r11.f10818i
            int r12 = r12.length
            int r5 = r5 + r12
        L_0x0094:
            r11.f10819j = r5
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.l.removeAll(java.util.Collection):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean retainAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            xa.j.f(r0, r12)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0093
            java.lang.Object[] r0 = r11.f10818i
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0093
        L_0x0019:
            int r0 = r11.f10817h
            int r3 = r11.f10819j
            int r3 = r3 + r0
            int r0 = r11.i(r3)
            int r3 = r11.f10817h
            r4 = 0
            if (r3 >= r0) goto L_0x0046
            r5 = r3
        L_0x0028:
            if (r3 >= r0) goto L_0x0040
            java.lang.Object[] r6 = r11.f10818i
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x003c
            java.lang.Object[] r7 = r11.f10818i
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003d
        L_0x003c:
            r1 = 1
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0040:
            java.lang.Object[] r12 = r11.f10818i
            ma.o.f(r12, r4, r5, r0)
            goto L_0x0086
        L_0x0046:
            java.lang.Object[] r5 = r11.f10818i
            int r5 = r5.length
            r6 = r3
            r7 = 0
        L_0x004b:
            if (r3 >= r5) goto L_0x0065
            java.lang.Object[] r8 = r11.f10818i
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x0061
            java.lang.Object[] r8 = r11.f10818i
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0062
        L_0x0061:
            r7 = 1
        L_0x0062:
            int r3 = r3 + 1
            goto L_0x004b
        L_0x0065:
            int r3 = r11.i(r6)
            r5 = r3
        L_0x006a:
            if (r1 >= r0) goto L_0x0085
            java.lang.Object[] r3 = r11.f10818i
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x0081
            java.lang.Object[] r3 = r11.f10818i
            r3[r5] = r6
            int r5 = r11.g(r5)
            goto L_0x0082
        L_0x0081:
            r7 = 1
        L_0x0082:
            int r1 = r1 + 1
            goto L_0x006a
        L_0x0085:
            r1 = r7
        L_0x0086:
            if (r1 == 0) goto L_0x0093
            int r12 = r11.f10817h
            int r5 = r5 - r12
            if (r5 >= 0) goto L_0x0091
            java.lang.Object[] r12 = r11.f10818i
            int r12 = r12.length
            int r5 = r5 + r12
        L_0x0091:
            r11.f10819j = r5
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.l.retainAll(java.util.Collection):boolean");
    }

    public final Object set(int i10, Object obj) {
        c cVar = f.f10810h;
        int i11 = this.f10819j;
        cVar.getClass();
        c.a(i10, i11);
        int i12 = i(this.f10817h + i10);
        Object[] objArr = this.f10818i;
        Object obj2 = objArr[i12];
        objArr[i12] = obj;
        return obj2;
    }

    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    public l(int i10) {
        Object[] objArr;
        if (i10 == 0) {
            objArr = f10816l;
        } else if (i10 > 0) {
            objArr = new Object[i10];
        } else {
            throw new IllegalArgumentException(h.i("Illegal Capacity: ", i10));
        }
        this.f10818i = objArr;
    }

    public final Object[] toArray(Object[] objArr) {
        j.f("array", objArr);
        int length = objArr.length;
        int i10 = this.f10819j;
        if (length < i10) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i10);
            j.d("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>", newInstance);
            objArr = (Object[]) newInstance;
        }
        int i11 = i(this.f10819j + this.f10817h);
        int i12 = this.f10817h;
        if (i12 < i11) {
            o.d(0, i12, i11, this.f10818i, objArr);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f10818i;
            o.d(0, this.f10817h, objArr2.length, objArr2, objArr);
            Object[] objArr3 = this.f10818i;
            o.d(objArr3.length - this.f10817h, 0, i11, objArr3, objArr);
        }
        int length2 = objArr.length;
        int i13 = this.f10819j;
        if (length2 > i13) {
            objArr[i13] = null;
        }
        return objArr;
    }

    public final boolean addAll(Collection collection) {
        j.f("elements", collection);
        if (collection.isEmpty()) {
            return false;
        }
        f(collection.size() + a());
        e(i(a() + this.f10817h), collection);
        return true;
    }

    public final boolean add(Object obj) {
        d(obj);
        return true;
    }
}
