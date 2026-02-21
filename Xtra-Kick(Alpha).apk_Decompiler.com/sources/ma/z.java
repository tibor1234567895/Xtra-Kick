package ma;

import android.support.v4.media.h;
import androidx.fragment.app.k;
import fb.n;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import la.i;
import pa.e;
import qa.d;
import r3.c;
import wa.l;
import xa.j;

public class z extends y {
    public static final Object A(List list) {
        j.f("<this>", list);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static final Comparable B(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) < 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static final ArrayList C(Iterable iterable, Collection collection) {
        j.f("<this>", collection);
        j.f("elements", iterable);
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        w.k(iterable, arrayList2);
        return arrayList2;
    }

    public static final ArrayList D(Object obj, Collection collection) {
        j.f("<this>", collection);
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static final List E(Iterable iterable) {
        j.f("<this>", iterable);
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return J(iterable);
        }
        List L = L(iterable);
        Collections.reverse(L);
        return L;
    }

    public static final List F(List list, Comparator comparator) {
        j.f("<this>", list);
        if (list.size() <= 1) {
            return J(list);
        }
        Object[] array = list.toArray(new Object[0]);
        j.f("<this>", array);
        if (array.length > 1) {
            Arrays.sort(array, comparator);
        }
        return o.b(array);
    }

    public static final List G(List list, int i10) {
        boolean z10;
        int i11 = 0;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(h.j("Requested element count ", i10, " is less than zero.").toString());
        } else if (i10 == 0) {
            return b0.f10801h;
        } else {
            if (i10 >= list.size()) {
                return J(list);
            }
            if (i10 == 1) {
                return q.b(r(list));
            }
            ArrayList arrayList = new ArrayList(i10);
            for (Object add : list) {
                arrayList.add(add);
                i11++;
                if (i11 == i10) {
                    break;
                }
            }
            return r.f(arrayList);
        }
    }

    public static final void H(Iterable iterable, AbstractCollection abstractCollection) {
        j.f("<this>", iterable);
        for (Object add : iterable) {
            abstractCollection.add(add);
        }
    }

    public static final int[] I(List list) {
        int[] iArr = new int[list.size()];
        Iterator it = list.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Number) it.next()).intValue();
            i10++;
        }
        return iArr;
    }

    public static final List J(Iterable iterable) {
        Object obj;
        j.f("<this>", iterable);
        if (!(iterable instanceof Collection)) {
            return r.f(L(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b0.f10801h;
        }
        if (size != 1) {
            return K(collection);
        }
        if (iterable instanceof List) {
            obj = ((List) iterable).get(0);
        } else {
            obj = iterable.iterator().next();
        }
        return q.b(obj);
    }

    public static final ArrayList K(Collection collection) {
        j.f("<this>", collection);
        return new ArrayList(collection);
    }

    public static final List L(Iterable iterable) {
        j.f("<this>", iterable);
        if (iterable instanceof Collection) {
            return K((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        H(iterable, arrayList);
        return arrayList;
    }

    public static final Set M(Collection collection) {
        j.f("<this>", collection);
        return new LinkedHashSet(collection);
    }

    public static final Set N(Iterable iterable) {
        Object obj;
        j.f("<this>", iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return d0.f10804h;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(i0.a(collection.size()));
                H(iterable, linkedHashSet);
                return linkedHashSet;
            }
            if (iterable instanceof List) {
                obj = ((List) iterable).get(0);
            } else {
                obj = iterable.iterator().next();
            }
            Set singleton = Collections.singleton(obj);
            j.e("singleton(element)", singleton);
            return singleton;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        H(iterable, linkedHashSet2);
        int size2 = linkedHashSet2.size();
        if (size2 == 0) {
            return d0.f10804h;
        }
        if (size2 != 1) {
            return linkedHashSet2;
        }
        Set singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
        j.e("singleton(element)", singleton2);
        return singleton2;
    }

    public static final ArrayList O(ArrayList arrayList, ArrayList arrayList2) {
        Iterator it = arrayList.iterator();
        Iterator it2 = arrayList2.iterator();
        ArrayList arrayList3 = new ArrayList(Math.min(s.i(arrayList), s.i(arrayList2)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList3.add(new i(it.next(), it2.next()));
        }
        return arrayList3;
    }

    public static final ArrayList m(List list, int i10) {
        boolean z10;
        ArrayList arrayList;
        Iterator it;
        int i11;
        boolean z11;
        j.f("<this>", list);
        if (i10 <= 0 || i10 <= 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (list instanceof RandomAccess) {
                int size = list.size();
                int i12 = size / i10;
                if (size % i10 == 0) {
                    i11 = 0;
                } else {
                    i11 = 1;
                }
                arrayList = new ArrayList(i12 + i11);
                int i13 = 0;
                while (true) {
                    if (i13 < 0 || i13 >= size) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11) {
                        break;
                    }
                    int i14 = size - i13;
                    if (i10 <= i14) {
                        i14 = i10;
                    }
                    ArrayList arrayList2 = new ArrayList(i14);
                    for (int i15 = 0; i15 < i14; i15++) {
                        arrayList2.add(list.get(i15 + i13));
                    }
                    arrayList.add(arrayList2);
                    i13 += i10;
                }
            } else {
                arrayList = new ArrayList();
                Iterator it2 = list.iterator();
                j.f("iterator", it2);
                if (!it2.hasNext()) {
                    it = a0.f10798h;
                } else {
                    q0 q0Var = new q0(i10, i10, it2, false, true, (e) null);
                    eb.i iVar = new eb.i();
                    iVar.f5348k = d.a(iVar, iVar, q0Var);
                    it = iVar;
                }
                while (it.hasNext()) {
                    arrayList.add((List) it.next());
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(h.j("size ", i10, " must be greater than zero.").toString());
    }

    public static final boolean n(Collection collection, Serializable serializable) {
        j.f("<this>", collection);
        return collection.contains(serializable);
    }

    public static final Object o(Collection collection) {
        j.f("<this>", collection);
        boolean z10 = collection instanceof List;
        if (z10) {
            return ((List) collection).get(0);
        }
        c cVar = new c(0, 1);
        if (z10) {
            List list = (List) collection;
            if (r.d(list) >= 0) {
                return list.get(0);
            }
        } else {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                return it.next();
            }
        }
        cVar.invoke(0);
        return null;
    }

    public static final Object p(Collection collection, int i10) {
        j.f("<this>", collection);
        if (collection instanceof List) {
            return v((List) collection, i10);
        }
        if (i10 < 0) {
            return null;
        }
        int i11 = 0;
        for (Object next : collection) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return next;
            }
            i11 = i12;
        }
        return null;
    }

    public static final ArrayList q(Iterable iterable) {
        j.f("<this>", iterable);
        ArrayList arrayList = new ArrayList();
        for (Object next : iterable) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static final Object r(Collection collection) {
        j.f("<this>", collection);
        if (collection instanceof List) {
            return s((List) collection);
        }
        Iterator it = collection.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object s(List list) {
        j.f("<this>", list);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final Object t(Collection collection) {
        j.f("<this>", collection);
        if (collection instanceof List) {
            List list = (List) collection;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final Object u(List list) {
        j.f("<this>", list);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final Object v(List list, int i10) {
        j.f("<this>", list);
        if (i10 < 0 || i10 > r.d(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final void w(Iterable iterable, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar) {
        j.f("<this>", iterable);
        j.f("separator", charSequence);
        j.f("prefix", charSequence2);
        j.f("postfix", charSequence3);
        j.f("truncated", charSequence4);
        sb2.append(charSequence2);
        int i11 = 0;
        for (Object next : iterable) {
            i11++;
            if (i11 > 1) {
                sb2.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            n.a(sb2, next, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            sb2.append(charSequence4);
        }
        sb2.append(charSequence3);
    }

    public static String y(Iterable iterable, String str, String str2, String str3, k kVar, int i10) {
        String str4;
        String str5;
        int i11;
        CharSequence charSequence;
        k kVar2;
        if ((i10 & 1) != 0) {
            str = ", ";
        }
        String str6 = str;
        if ((i10 & 2) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i10 & 4) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i10 & 8) != 0) {
            i11 = -1;
        } else {
            i11 = 0;
        }
        if ((i10 & 16) != 0) {
            charSequence = "...";
        } else {
            charSequence = null;
        }
        if ((i10 & 32) != 0) {
            kVar2 = null;
        } else {
            kVar2 = kVar;
        }
        j.f("<this>", iterable);
        j.f("separator", str6);
        j.f("prefix", str4);
        j.f("postfix", str5);
        j.f("truncated", charSequence);
        StringBuilder sb2 = new StringBuilder();
        w(iterable, sb2, str6, str4, str5, i11, charSequence, kVar2);
        String sb3 = sb2.toString();
        j.e("joinTo(StringBuilder(), …ed, transform).toString()", sb3);
        return sb3;
    }

    public static final Object z(List list) {
        j.f("<this>", list);
        if (!list.isEmpty()) {
            return list.get(r.d(list));
        }
        throw new NoSuchElementException("List is empty.");
    }
}
