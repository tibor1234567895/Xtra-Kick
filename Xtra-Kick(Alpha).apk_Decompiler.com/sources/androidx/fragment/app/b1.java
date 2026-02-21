package androidx.fragment.app;

import android.os.Bundle;
import android.support.v4.media.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b1 implements z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1329a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1330b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c1 f1331c;

    public /* synthetic */ b1(c1 c1Var, String str, int i10) {
        this.f1329a = i10;
        this.f1331c = c1Var;
        this.f1330b = str;
    }

    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        String str;
        StringBuilder sb2;
        int i10;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        int i11 = this.f1329a;
        String str2 = this.f1330b;
        c1 c1Var = this.f1331c;
        switch (i11) {
            case 0:
                e eVar = (e) c1Var.f1380j.remove(str2);
                if (eVar == null) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.f1322t) {
                        Iterator it2 = aVar.f1533a.iterator();
                        while (it2.hasNext()) {
                            c0 c0Var = ((o1) it2.next()).f1522b;
                            if (c0Var != null) {
                                hashMap.put(c0Var.f1356l, c0Var);
                            }
                        }
                    }
                }
                List<String> list = eVar.f1400h;
                HashMap hashMap2 = new HashMap(list.size());
                for (String str3 : list) {
                    c0 c0Var2 = (c0) hashMap.get(str3);
                    if (c0Var2 != null) {
                        hashMap2.put(c0Var2.f1356l, c0Var2);
                    } else {
                        Bundle i12 = c1Var.f1373c.i((Bundle) null, str3);
                        if (i12 != null) {
                            ClassLoader classLoader = c1Var.f1392v.f1403i.getClassLoader();
                            c0 u10 = ((l1) i12.getParcelable("state")).u(c1Var.G(), classLoader);
                            u10.f1353i = i12;
                            if (i12.getBundle("savedInstanceState") == null) {
                                u10.f1353i.putBundle("savedInstanceState", new Bundle());
                            }
                            Bundle bundle = i12.getBundle("arguments");
                            if (bundle != null) {
                                bundle.setClassLoader(classLoader);
                            }
                            u10.j0(bundle);
                            hashMap2.put(u10.f1356l, u10);
                        }
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                for (c cVar : eVar.f1401i) {
                    cVar.getClass();
                    a aVar2 = new a(c1Var);
                    cVar.u(aVar2);
                    int i13 = 0;
                    while (true) {
                        ArrayList arrayList6 = cVar.f1336i;
                        if (i13 < arrayList6.size()) {
                            String str4 = (String) arrayList6.get(i13);
                            if (str4 != null) {
                                c0 c0Var3 = (c0) hashMap2.get(str4);
                                if (c0Var3 != null) {
                                    ((o1) aVar2.f1533a.get(i13)).f1522b = c0Var3;
                                } else {
                                    throw new IllegalStateException("Restoring FragmentTransaction " + cVar.f1340m + " failed due to missing saved state for Fragment (" + str4 + ")");
                                }
                            }
                            i13++;
                        } else {
                            arrayList5.add(aVar2);
                        }
                    }
                }
                Iterator it3 = arrayList5.iterator();
                boolean z10 = false;
                while (it3.hasNext()) {
                    ((a) it3.next()).a(arrayList3, arrayList4);
                    z10 = true;
                }
                return z10;
            default:
                int C = c1Var.C(true, -1, str2);
                if (C < 0) {
                    return false;
                }
                int i14 = C;
                while (i14 < c1Var.f1374d.size()) {
                    a aVar3 = (a) c1Var.f1374d.get(i14);
                    if (aVar3.f1548p) {
                        i14++;
                    } else {
                        c1Var.e0(new IllegalArgumentException("saveBackStack(\"" + str2 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar3 + " that did not use setReorderingAllowed(true)."));
                        throw null;
                    }
                }
                HashSet hashSet = new HashSet();
                int i15 = C;
                while (i15 < c1Var.f1374d.size()) {
                    a aVar4 = (a) c1Var.f1374d.get(i15);
                    HashSet hashSet2 = new HashSet();
                    HashSet hashSet3 = new HashSet();
                    Iterator it4 = aVar4.f1533a.iterator();
                    while (it4.hasNext()) {
                        o1 o1Var = (o1) it4.next();
                        c0 c0Var4 = o1Var.f1522b;
                        if (c0Var4 != null) {
                            if (!o1Var.f1523c || (i10 = o1Var.f1521a) == 1 || i10 == 2 || i10 == 8) {
                                hashSet.add(c0Var4);
                                hashSet2.add(c0Var4);
                            }
                            int i16 = o1Var.f1521a;
                            if (i16 == 1 || i16 == 2) {
                                hashSet3.add(c0Var4);
                            }
                        }
                    }
                    hashSet2.removeAll(hashSet3);
                    if (!hashSet2.isEmpty()) {
                        StringBuilder s10 = h.s("saveBackStack(\"", str2, "\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                        if (hashSet2.size() == 1) {
                            sb2 = new StringBuilder(" ");
                            sb2.append(hashSet2.iterator().next());
                        } else {
                            sb2 = new StringBuilder("s ");
                            sb2.append(hashSet2);
                        }
                        s10.append(sb2.toString());
                        s10.append(" in ");
                        s10.append(aVar4);
                        s10.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                        c1Var.e0(new IllegalArgumentException(s10.toString()));
                        throw null;
                    }
                    i15++;
                }
                ArrayDeque arrayDeque = new ArrayDeque(hashSet);
                while (!arrayDeque.isEmpty()) {
                    c0 c0Var5 = (c0) arrayDeque.removeFirst();
                    if (c0Var5.I) {
                        StringBuilder s11 = h.s("saveBackStack(\"", str2, "\") must not contain retained fragments. Found ");
                        if (hashSet.contains(c0Var5)) {
                            str = "direct reference to retained ";
                        } else {
                            str = "retained child ";
                        }
                        s11.append(str);
                        s11.append("fragment ");
                        s11.append(c0Var5);
                        c1Var.e0(new IllegalArgumentException(s11.toString()));
                        throw null;
                    }
                    Iterator it5 = c0Var5.B.f1373c.e().iterator();
                    while (it5.hasNext()) {
                        c0 c0Var6 = (c0) it5.next();
                        if (c0Var6 != null) {
                            arrayDeque.addLast(c0Var6);
                        }
                    }
                }
                ArrayList arrayList7 = new ArrayList();
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    arrayList7.add(((c0) it6.next()).f1356l);
                }
                ArrayList arrayList8 = new ArrayList(c1Var.f1374d.size() - C);
                for (int i17 = C; i17 < c1Var.f1374d.size(); i17++) {
                    arrayList8.add((Object) null);
                }
                e eVar2 = new e(arrayList7, arrayList8);
                int size = c1Var.f1374d.size() - 1;
                while (size >= C) {
                    a aVar5 = (a) c1Var.f1374d.remove(size);
                    a aVar6 = new a(aVar5);
                    ArrayList arrayList9 = aVar6.f1533a;
                    int size2 = arrayList9.size();
                    while (true) {
                        size2--;
                        if (size2 >= 0) {
                            o1 o1Var2 = (o1) arrayList9.get(size2);
                            if (o1Var2.f1523c) {
                                if (o1Var2.f1521a == 8) {
                                    o1Var2.f1523c = false;
                                    size2--;
                                    arrayList9.remove(size2);
                                } else {
                                    int i18 = o1Var2.f1522b.E;
                                    o1Var2.f1521a = 2;
                                    o1Var2.f1523c = false;
                                    for (int i19 = size2 - 1; i19 >= 0; i19--) {
                                        o1 o1Var3 = (o1) arrayList9.get(i19);
                                        if (o1Var3.f1523c && o1Var3.f1522b.E == i18) {
                                            arrayList9.remove(i19);
                                            size2--;
                                        }
                                    }
                                }
                            }
                        } else {
                            arrayList8.set(size - C, new c(aVar6));
                            aVar5.f1322t = true;
                            arrayList3.add(aVar5);
                            arrayList4.add(Boolean.TRUE);
                            size--;
                        }
                    }
                }
                c1Var.f1380j.put(str2, eVar2);
                return true;
        }
    }
}
