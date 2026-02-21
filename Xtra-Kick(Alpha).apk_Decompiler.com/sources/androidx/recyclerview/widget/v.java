package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final List f2214a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f2215b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f2216c;

    /* renamed from: d  reason: collision with root package name */
    public final t f2217d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2218e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2219f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f2220g = true;

    public v(t tVar, ArrayList arrayList, int[] iArr, int[] iArr2) {
        u uVar;
        t tVar2;
        int[] iArr3;
        int[] iArr4;
        int i10;
        u uVar2;
        int i11;
        int i12;
        int i13;
        this.f2214a = arrayList;
        this.f2215b = iArr;
        this.f2216c = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.f2217d = tVar;
        int e10 = tVar.e();
        this.f2218e = e10;
        int d10 = tVar.d();
        this.f2219f = d10;
        if (arrayList.isEmpty()) {
            uVar = null;
        } else {
            uVar = (u) arrayList.get(0);
        }
        if (!(uVar != null && uVar.f2199a == 0 && uVar.f2200b == 0)) {
            arrayList.add(0, new u(0, 0, 0));
        }
        arrayList.add(new u(e10, d10, 0));
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            tVar2 = this.f2217d;
            iArr3 = this.f2216c;
            iArr4 = this.f2215b;
            if (!hasNext) {
                break;
            }
            u uVar3 = (u) it.next();
            for (int i14 = 0; i14 < uVar3.f2201c; i14++) {
                int i15 = uVar3.f2199a + i14;
                int i16 = uVar3.f2200b + i14;
                if (tVar2.a(i15, i16)) {
                    i13 = 1;
                } else {
                    i13 = 2;
                }
                iArr4[i15] = (i16 << 4) | i13;
                iArr3[i16] = (i15 << 4) | i13;
            }
        }
        if (this.f2220g) {
            Iterator it2 = arrayList.iterator();
            int i17 = 0;
            while (it2.hasNext()) {
                u uVar4 = (u) it2.next();
                while (true) {
                    i10 = uVar4.f2199a;
                    if (i17 >= i10) {
                        break;
                    }
                    if (iArr4[i17] == 0) {
                        int size = arrayList.size();
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            if (i18 >= size) {
                                break;
                            }
                            uVar2 = (u) arrayList.get(i18);
                            while (true) {
                                i11 = uVar2.f2200b;
                                if (i19 >= i11) {
                                    break;
                                } else if (iArr3[i19] != 0 || !tVar2.b(i17, i19)) {
                                    i19++;
                                } else {
                                    if (tVar2.a(i17, i19)) {
                                        i12 = 8;
                                    } else {
                                        i12 = 4;
                                    }
                                    iArr4[i17] = (i19 << 4) | i12;
                                    iArr3[i19] = i12 | (i17 << 4);
                                }
                            }
                            i19 = uVar2.f2201c + i11;
                            i18++;
                        }
                    }
                    i17++;
                }
                i17 = uVar4.f2201c + i10;
            }
        }
    }

    public static x c(ArrayDeque arrayDeque, int i10, boolean z10) {
        x xVar;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                xVar = null;
                break;
            }
            xVar = (x) it.next();
            if (xVar.f2229a == i10 && xVar.f2231c == z10) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            x xVar2 = (x) it.next();
            int i11 = xVar2.f2230b;
            xVar2.f2230b = z10 ? i11 - 1 : i11 + 1;
        }
        return xVar;
    }

    public final int a(int i10) {
        int i11 = this.f2218e;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i10 + ", old list size = " + i11);
        }
        int i12 = this.f2215b[i10];
        if ((i12 & 15) == 0) {
            return -1;
        }
        return i12 >> 4;
    }

    public final void b(x0 x0Var) {
        i iVar;
        int[] iArr;
        t tVar;
        int i10;
        List list;
        v vVar = this;
        x0 x0Var2 = x0Var;
        if (x0Var2 instanceof i) {
            iVar = (i) x0Var2;
        } else {
            iVar = new i(x0Var2);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        List list2 = vVar.f2214a;
        int size = list2.size() - 1;
        int i11 = vVar.f2218e;
        int i12 = vVar.f2219f;
        int i13 = i11;
        while (size >= 0) {
            u uVar = (u) list2.get(size);
            int i14 = uVar.f2199a;
            int i15 = uVar.f2201c;
            int i16 = i14 + i15;
            int i17 = uVar.f2200b;
            int i18 = i15 + i17;
            while (true) {
                iArr = vVar.f2215b;
                tVar = vVar.f2217d;
                if (i13 <= i16) {
                    break;
                }
                i13--;
                int i19 = iArr[i13];
                if ((i19 & 12) != 0) {
                    list = list2;
                    int i20 = i19 >> 4;
                    x c10 = c(arrayDeque, i20, false);
                    if (c10 != null) {
                        i10 = i12;
                        int i21 = (i11 - c10.f2230b) - 1;
                        iVar.b(i13, i21);
                        if ((i19 & 4) != 0) {
                            iVar.d(i21, 1, tVar.c(i13, i20));
                        }
                    } else {
                        i10 = i12;
                        arrayDeque.add(new x(i13, (i11 - i13) - 1, true));
                    }
                } else {
                    list = list2;
                    i10 = i12;
                    iVar.a(i13, 1);
                    i11--;
                }
                list2 = list;
                i12 = i10;
            }
            List list3 = list2;
            int i22 = i12;
            while (i12 > i18) {
                i12--;
                int i23 = vVar.f2216c[i12];
                if ((i23 & 12) != 0) {
                    int i24 = i23 >> 4;
                    x c11 = c(arrayDeque, i24, true);
                    if (c11 == null) {
                        arrayDeque.add(new x(i12, i11 - i13, false));
                    } else {
                        iVar.b((i11 - c11.f2230b) - 1, i13);
                        if ((i23 & 4) != 0) {
                            iVar.d(i13, 1, tVar.c(i24, i12));
                        }
                    }
                } else {
                    iVar.c(i13, 1);
                    i11++;
                }
                vVar = this;
            }
            i13 = uVar.f2199a;
            int i25 = i13;
            int i26 = i17;
            for (int i27 = 0; i27 < i15; i27++) {
                if ((iArr[i25] & 15) == 2) {
                    iVar.d(i25, 1, tVar.c(i25, i26));
                }
                i25++;
                i26++;
            }
            size--;
            vVar = this;
            i12 = i17;
            list2 = list3;
        }
        iVar.e();
    }
}
