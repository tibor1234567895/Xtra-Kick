package n3;

import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jb.a;
import jb.c;
import la.g;
import la.v;
import ma.q;
import ma.r;
import ma.z;
import xa.j;

public final class l3 {

    /* renamed from: a  reason: collision with root package name */
    public final r3 f11308a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f11309b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f11310c;

    /* renamed from: d  reason: collision with root package name */
    public int f11311d;

    /* renamed from: e  reason: collision with root package name */
    public int f11312e;

    /* renamed from: f  reason: collision with root package name */
    public int f11313f;

    /* renamed from: g  reason: collision with root package name */
    public int f11314g;

    /* renamed from: h  reason: collision with root package name */
    public int f11315h;

    /* renamed from: i  reason: collision with root package name */
    public final c f11316i = h0.a(-1, (a) null, 6);

    /* renamed from: j  reason: collision with root package name */
    public final c f11317j = h0.a(-1, (a) null, 6);

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap f11318k = new LinkedHashMap();

    /* renamed from: l  reason: collision with root package name */
    public final h1 f11319l;

    public l3(r3 r3Var) {
        this.f11308a = r3Var;
        ArrayList arrayList = new ArrayList();
        this.f11309b = arrayList;
        this.f11310c = arrayList;
        h1 h1Var = new h1();
        h1Var.c(d1.REFRESH, x0.f11553b);
        v vVar = v.f9814a;
        this.f11319l = h1Var;
    }

    public final o4 a(y5 y5Var) {
        Integer num;
        int i10;
        ArrayList arrayList = this.f11310c;
        List J = z.J(arrayList);
        r3 r3Var = this.f11308a;
        if (y5Var == null) {
            num = null;
        } else {
            int d10 = d();
            int i11 = -this.f11311d;
            int d11 = r.d(arrayList) - this.f11311d;
            int i12 = y5Var.f11592e;
            if (i11 < i12) {
                int i13 = i11;
                while (true) {
                    int i14 = i13 + 1;
                    if (i13 > d11) {
                        i10 = r3Var.f11458a;
                    } else {
                        i10 = ((k4) arrayList.get(i13 + this.f11311d)).f11287a.size();
                    }
                    d10 += i10;
                    if (i14 >= i12) {
                        break;
                    }
                    i13 = i14;
                }
            }
            int i15 = d10 + y5Var.f11593f;
            if (i12 < i11) {
                i15 -= r3Var.f11458a;
            }
            num = Integer.valueOf(i15);
        }
        return new o4(J, num, r3Var, d());
    }

    public final void b(o1 o1Var) {
        boolean z10;
        int i10;
        c cVar;
        int a10 = o1Var.a();
        ArrayList arrayList = this.f11310c;
        int i11 = 0;
        if (a10 <= arrayList.size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            LinkedHashMap linkedHashMap = this.f11318k;
            d1 d1Var = o1Var.f11371a;
            linkedHashMap.remove(d1Var);
            z0.f11599b.getClass();
            this.f11319l.c(d1Var, z0.f11601d);
            int ordinal = d1Var.ordinal();
            ArrayList arrayList2 = this.f11309b;
            int i12 = o1Var.f11374d;
            if (ordinal == 1) {
                int a11 = o1Var.a();
                for (int i13 = 0; i13 < a11; i13++) {
                    arrayList2.remove(0);
                }
                this.f11311d -= o1Var.a();
                if (i12 != Integer.MIN_VALUE) {
                    i11 = i12;
                }
                this.f11312e = i11;
                i10 = this.f11314g + 1;
                this.f11314g = i10;
                cVar = this.f11316i;
            } else if (ordinal == 2) {
                int a12 = o1Var.a();
                for (int i14 = 0; i14 < a12; i14++) {
                    arrayList2.remove(arrayList.size() - 1);
                }
                if (i12 != Integer.MIN_VALUE) {
                    i11 = i12;
                }
                this.f11313f = i11;
                i10 = this.f11315h + 1;
                this.f11315h = i10;
                cVar = this.f11317j;
            } else {
                throw new IllegalArgumentException(j.k("cannot drop ", d1Var));
            }
            cVar.h(Integer.valueOf(i10));
            return;
        }
        throw new IllegalStateException(("invalid drop count. have " + arrayList.size() + " but wanted to drop " + o1Var.a()).toString());
    }

    public final o1 c(d1 d1Var, a6 a6Var) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        Object obj;
        int i13;
        j.f("loadType", d1Var);
        j.f("hint", a6Var);
        r3 r3Var = this.f11308a;
        o1 o1Var = null;
        if (r3Var.f11462e == Integer.MAX_VALUE) {
            return null;
        }
        ArrayList arrayList = this.f11310c;
        if (arrayList.size() <= 2) {
            return null;
        }
        Iterator it = arrayList.iterator();
        int i14 = 0;
        int i15 = 0;
        while (it.hasNext()) {
            i15 += ((k4) it.next()).f11287a.size();
        }
        int i16 = r3Var.f11462e;
        if (i15 <= i16) {
            return null;
        }
        if (d1Var != d1.REFRESH) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i17 = 0;
            int i18 = 0;
            while (i17 < arrayList.size()) {
                Iterator it2 = arrayList.iterator();
                int i19 = 0;
                while (it2.hasNext()) {
                    i19 += ((k4) it2.next()).f11287a.size();
                }
                if (i19 - i18 <= i16) {
                    break;
                }
                int[] iArr = i3.f11256a;
                if (iArr[d1Var.ordinal()] == 2) {
                    obj = arrayList.get(i17);
                } else {
                    obj = arrayList.get(r.d(arrayList) - i17);
                }
                int size = ((k4) obj).f11287a.size();
                if (iArr[d1Var.ordinal()] == 2) {
                    i13 = a6Var.f11051a;
                } else {
                    i13 = a6Var.f11052b;
                }
                if ((i13 - i18) - size < r3Var.f11459b) {
                    break;
                }
                i18 += size;
                i17++;
            }
            if (i17 != 0) {
                int[] iArr2 = i3.f11256a;
                if (iArr2[d1Var.ordinal()] == 2) {
                    i10 = -this.f11311d;
                } else {
                    i10 = (r.d(arrayList) - this.f11311d) - (i17 - 1);
                }
                if (iArr2[d1Var.ordinal()] == 2) {
                    i11 = (i17 - 1) - this.f11311d;
                } else {
                    i11 = r.d(arrayList) - this.f11311d;
                }
                if (r3Var.f11460c) {
                    if (d1Var == d1.PREPEND) {
                        i12 = d();
                    } else {
                        if (r3Var.f11460c) {
                            i14 = this.f11313f;
                        }
                        i12 = i14;
                    }
                    i14 = i12 + i18;
                }
                o1Var = new o1(d1Var, i10, i11, i14);
            }
            return o1Var;
        }
        throw new IllegalArgumentException(j.k("Drop LoadType must be PREPEND or APPEND, but got ", d1Var).toString());
    }

    public final int d() {
        if (this.f11308a.f11460c) {
            return this.f11312e;
        }
        return 0;
    }

    public final boolean e(int i10, d1 d1Var, k4 k4Var) {
        boolean z10;
        d1 d1Var2;
        int i11;
        j.f("loadType", d1Var);
        j.f("page", k4Var);
        int ordinal = d1Var.ordinal();
        ArrayList arrayList = this.f11309b;
        ArrayList arrayList2 = this.f11310c;
        int i12 = 0;
        int i13 = k4Var.f11290d;
        int i14 = k4Var.f11291e;
        if (ordinal != 0) {
            LinkedHashMap linkedHashMap = this.f11318k;
            List list = k4Var.f11287a;
            if (ordinal != 1) {
                if (ordinal == 2) {
                    if (!(!arrayList2.isEmpty())) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    } else if (i10 != this.f11315h) {
                        return false;
                    } else {
                        arrayList.add(k4Var);
                        if (i14 == Integer.MIN_VALUE) {
                            if (this.f11308a.f11460c) {
                                i11 = this.f11313f;
                            } else {
                                i11 = 0;
                            }
                            int size = i11 - list.size();
                            if (size < 0) {
                                i14 = 0;
                            } else {
                                i14 = size;
                            }
                        }
                        if (i14 != Integer.MIN_VALUE) {
                            i12 = i14;
                        }
                        this.f11313f = i12;
                        d1Var2 = d1.APPEND;
                    }
                }
            } else if (!(!arrayList2.isEmpty())) {
                throw new IllegalStateException("should've received an init before prepend".toString());
            } else if (i10 != this.f11314g) {
                return false;
            } else {
                arrayList.add(0, k4Var);
                this.f11311d++;
                if (i13 == Integer.MIN_VALUE) {
                    int d10 = d() - list.size();
                    if (d10 < 0) {
                        i13 = 0;
                    } else {
                        i13 = d10;
                    }
                }
                if (i13 != Integer.MIN_VALUE) {
                    i12 = i13;
                }
                this.f11312e = i12;
                d1Var2 = d1.PREPEND;
            }
            linkedHashMap.remove(d1Var2);
        } else if (arrayList2.isEmpty()) {
            if (i10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList.add(k4Var);
                this.f11311d = 0;
                if (i14 == Integer.MIN_VALUE) {
                    i14 = 0;
                }
                this.f11313f = i14;
                if (i13 != Integer.MIN_VALUE) {
                    i12 = i13;
                }
                this.f11312e = i12;
            } else {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
        } else {
            throw new IllegalStateException("cannot receive multiple init calls".toString());
        }
        return true;
    }

    public final q1 f(k4 k4Var, d1 d1Var) {
        int i10;
        int i11;
        j.f("<this>", k4Var);
        int ordinal = d1Var.ordinal();
        int i12 = 0;
        if (ordinal == 0) {
            i10 = 0;
        } else if (ordinal == 1) {
            i10 = 0 - this.f11311d;
        } else if (ordinal == 2) {
            i10 = (this.f11310c.size() - this.f11311d) - 1;
        } else {
            throw new g();
        }
        List b10 = q.b(new u5(k4Var.f11287a, i10));
        int ordinal2 = d1Var.ordinal();
        r3 r3Var = this.f11308a;
        h1 h1Var = this.f11319l;
        if (ordinal2 == 0) {
            p1 p1Var = q1.f11420g;
            int d10 = d();
            if (r3Var.f11460c) {
                i12 = this.f11313f;
            }
            c1 d11 = h1Var.d();
            p1Var.getClass();
            return p1.a(b10, d10, i12, d11, (c1) null);
        } else if (ordinal2 == 1) {
            p1 p1Var2 = q1.f11420g;
            int d12 = d();
            c1 d13 = h1Var.d();
            p1Var2.getClass();
            return new q1(d1.PREPEND, b10, d12, -1, d13, (c1) null);
        } else if (ordinal2 == 2) {
            p1 p1Var3 = q1.f11420g;
            if (r3Var.f11460c) {
                i11 = this.f11313f;
            } else {
                i11 = 0;
            }
            c1 d14 = h1Var.d();
            p1Var3.getClass();
            return new q1(d1.APPEND, b10, -1, i11, d14, (c1) null);
        } else {
            throw new g();
        }
    }
}
