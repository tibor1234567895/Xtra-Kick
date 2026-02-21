package l9;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

public final class o extends AbstractMap implements Serializable {

    /* renamed from: o  reason: collision with root package name */
    public static final j f9785o = new j();

    /* renamed from: h  reason: collision with root package name */
    public final Comparator f9786h = f9785o;

    /* renamed from: i  reason: collision with root package name */
    public n f9787i;

    /* renamed from: j  reason: collision with root package name */
    public int f9788j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9789k = 0;

    /* renamed from: l  reason: collision with root package name */
    public final n f9790l = new n();

    /* renamed from: m  reason: collision with root package name */
    public l f9791m;

    /* renamed from: n  reason: collision with root package name */
    public l f9792n;

    public final n a(Object obj, boolean z10) {
        int i10;
        n nVar;
        n nVar2 = this.f9787i;
        j jVar = f9785o;
        Comparator comparator = this.f9786h;
        if (nVar2 != null) {
            Comparable comparable = comparator == jVar ? (Comparable) obj : null;
            while (true) {
                Object obj2 = nVar2.f9782m;
                i10 = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i10 == 0) {
                    return nVar2;
                }
                n nVar3 = i10 < 0 ? nVar2.f9778i : nVar2.f9779j;
                if (nVar3 == null) {
                    break;
                }
                nVar2 = nVar3;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        n nVar4 = this.f9790l;
        if (nVar2 != null) {
            nVar = new n(nVar2, obj, nVar4, nVar4.f9781l);
            if (i10 < 0) {
                nVar2.f9778i = nVar;
            } else {
                nVar2.f9779j = nVar;
            }
            c(nVar2, true);
        } else if (comparator != jVar || (obj instanceof Comparable)) {
            nVar = new n(nVar2, obj, nVar4, nVar4.f9781l);
            this.f9787i = nVar;
        } else {
            throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
        }
        this.f9788j++;
        this.f9789k++;
        return nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final l9.n b(java.util.Map.Entry r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r6.getKey()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x000d
            l9.n r0 = r5.a(r0, r2)     // Catch:{ ClassCastException -> 0x000d }
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            if (r0 == 0) goto L_0x0028
            java.lang.Object r3 = r0.f9783n
            java.lang.Object r6 = r6.getValue()
            r4 = 1
            if (r3 == r6) goto L_0x0024
            if (r3 == 0) goto L_0x0022
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r6 = 0
            goto L_0x0025
        L_0x0024:
            r6 = 1
        L_0x0025:
            if (r6 == 0) goto L_0x0028
            r2 = 1
        L_0x0028:
            if (r2 == 0) goto L_0x002b
            r1 = r0
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.o.b(java.util.Map$Entry):l9.n");
    }

    public final void c(n nVar, boolean z10) {
        while (nVar != null) {
            n nVar2 = nVar.f9778i;
            n nVar3 = nVar.f9779j;
            int i10 = 0;
            int i11 = nVar2 != null ? nVar2.f9784o : 0;
            int i12 = nVar3 != null ? nVar3.f9784o : 0;
            int i13 = i11 - i12;
            if (i13 == -2) {
                n nVar4 = nVar3.f9778i;
                n nVar5 = nVar3.f9779j;
                int i14 = nVar5 != null ? nVar5.f9784o : 0;
                if (nVar4 != null) {
                    i10 = nVar4.f9784o;
                }
                int i15 = i10 - i14;
                if (i15 != -1 && (i15 != 0 || z10)) {
                    g(nVar3);
                }
                f(nVar);
                if (z10) {
                    return;
                }
            } else if (i13 == 2) {
                n nVar6 = nVar2.f9778i;
                n nVar7 = nVar2.f9779j;
                int i16 = nVar7 != null ? nVar7.f9784o : 0;
                if (nVar6 != null) {
                    i10 = nVar6.f9784o;
                }
                int i17 = i10 - i16;
                if (i17 != 1 && (i17 != 0 || z10)) {
                    f(nVar2);
                }
                g(nVar);
                if (z10) {
                    return;
                }
            } else if (i13 == 0) {
                nVar.f9784o = i11 + 1;
                if (z10) {
                    return;
                }
            } else {
                nVar.f9784o = Math.max(i11, i12) + 1;
                if (!z10) {
                    return;
                }
            }
            nVar = nVar.f9777h;
        }
    }

    public final void clear() {
        this.f9787i = null;
        this.f9788j = 0;
        this.f9789k++;
        n nVar = this.f9790l;
        nVar.f9781l = nVar;
        nVar.f9780k = nVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x000b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean containsKey(java.lang.Object r2) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0008
            l9.n r2 = r1.a(r2, r0)     // Catch:{ ClassCastException -> 0x0008 }
            goto L_0x0009
        L_0x0008:
            r2 = 0
        L_0x0009:
            if (r2 == 0) goto L_0x000c
            r0 = 1
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.o.containsKey(java.lang.Object):boolean");
    }

    public final void d(n nVar, boolean z10) {
        n nVar2;
        int i10;
        n nVar3;
        if (z10) {
            n nVar4 = nVar.f9781l;
            nVar4.f9780k = nVar.f9780k;
            nVar.f9780k.f9781l = nVar4;
        }
        n nVar5 = nVar.f9778i;
        n nVar6 = nVar.f9779j;
        n nVar7 = nVar.f9777h;
        int i11 = 0;
        if (nVar5 == null || nVar6 == null) {
            if (nVar5 != null) {
                e(nVar, nVar5);
                nVar.f9778i = null;
            } else if (nVar6 != null) {
                e(nVar, nVar6);
                nVar.f9779j = null;
            } else {
                e(nVar, (n) null);
            }
            c(nVar7, false);
            this.f9788j--;
            this.f9789k++;
            return;
        }
        if (nVar5.f9784o > nVar6.f9784o) {
            do {
                nVar2 = nVar5;
                nVar5 = nVar5.f9779j;
            } while (nVar5 != null);
        } else {
            do {
                n nVar8 = nVar6;
                nVar6 = nVar6.f9778i;
                nVar3 = nVar8;
            } while (nVar6 != null);
            nVar2 = nVar3;
        }
        d(nVar2, false);
        n nVar9 = nVar.f9778i;
        if (nVar9 != null) {
            i10 = nVar9.f9784o;
            nVar2.f9778i = nVar9;
            nVar9.f9777h = nVar2;
            nVar.f9778i = null;
        } else {
            i10 = 0;
        }
        n nVar10 = nVar.f9779j;
        if (nVar10 != null) {
            i11 = nVar10.f9784o;
            nVar2.f9779j = nVar10;
            nVar10.f9777h = nVar2;
            nVar.f9779j = null;
        }
        nVar2.f9784o = Math.max(i10, i11) + 1;
        e(nVar, nVar2);
    }

    public final void e(n nVar, n nVar2) {
        n nVar3 = nVar.f9777h;
        nVar.f9777h = null;
        if (nVar2 != null) {
            nVar2.f9777h = nVar3;
        }
        if (nVar3 == null) {
            this.f9787i = nVar2;
        } else if (nVar3.f9778i == nVar) {
            nVar3.f9778i = nVar2;
        } else {
            nVar3.f9779j = nVar2;
        }
    }

    public final Set entrySet() {
        l lVar = this.f9791m;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 0);
        this.f9791m = lVar2;
        return lVar2;
    }

    public final void f(n nVar) {
        n nVar2 = nVar.f9778i;
        n nVar3 = nVar.f9779j;
        n nVar4 = nVar3.f9778i;
        n nVar5 = nVar3.f9779j;
        nVar.f9779j = nVar4;
        if (nVar4 != null) {
            nVar4.f9777h = nVar;
        }
        e(nVar, nVar3);
        nVar3.f9778i = nVar;
        nVar.f9777h = nVar3;
        int i10 = 0;
        int max = Math.max(nVar2 != null ? nVar2.f9784o : 0, nVar4 != null ? nVar4.f9784o : 0) + 1;
        nVar.f9784o = max;
        if (nVar5 != null) {
            i10 = nVar5.f9784o;
        }
        nVar3.f9784o = Math.max(max, i10) + 1;
    }

    public final void g(n nVar) {
        n nVar2 = nVar.f9778i;
        n nVar3 = nVar.f9779j;
        n nVar4 = nVar2.f9778i;
        n nVar5 = nVar2.f9779j;
        nVar.f9778i = nVar5;
        if (nVar5 != null) {
            nVar5.f9777h = nVar;
        }
        e(nVar, nVar2);
        nVar2.f9779j = nVar;
        nVar.f9777h = nVar2;
        int i10 = 0;
        int max = Math.max(nVar3 != null ? nVar3.f9784o : 0, nVar5 != null ? nVar5.f9784o : 0) + 1;
        nVar.f9784o = max;
        if (nVar4 != null) {
            i10 = nVar4.f9784o;
        }
        nVar2.f9784o = Math.max(max, i10) + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0009
            r1 = 0
            l9.n r3 = r2.a(r3, r1)     // Catch:{ ClassCastException -> 0x0009 }
            goto L_0x000a
        L_0x0009:
            r3 = r0
        L_0x000a:
            if (r3 == 0) goto L_0x000e
            java.lang.Object r0 = r3.f9783n
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.o.get(java.lang.Object):java.lang.Object");
    }

    public final Set keySet() {
        l lVar = this.f9792n;
        if (lVar != null) {
            return lVar;
        }
        l lVar2 = new l(this, 1);
        this.f9792n = lVar2;
        return lVar2;
    }

    public final Object put(Object obj, Object obj2) {
        if (obj != null) {
            n a10 = a(obj, true);
            Object obj3 = a10.f9783n;
            a10.f9783n = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000a
            r1 = 0
            l9.n r3 = r2.a(r3, r1)     // Catch:{ ClassCastException -> 0x0009 }
            goto L_0x000b
        L_0x0009:
        L_0x000a:
            r3 = r0
        L_0x000b:
            if (r3 == 0) goto L_0x0011
            r1 = 1
            r2.d(r3, r1)
        L_0x0011:
            if (r3 == 0) goto L_0x0015
            java.lang.Object r0 = r3.f9783n
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.o.remove(java.lang.Object):java.lang.Object");
    }

    public final int size() {
        return this.f9788j;
    }
}
