package d9;

import c9.r;
import c9.s;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import k1.q;

public final class f2 {
    private f2() {
    }

    public static boolean a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static b2 b(Set set, q qVar) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof b2) {
                b2 b2Var = (b2) sortedSet;
                r rVar = b2Var.f4597i;
                rVar.getClass();
                return new c2((SortedSet) b2Var.f4596h, new s(Arrays.asList(new r[]{rVar, qVar})));
            }
            sortedSet.getClass();
            return new c2(sortedSet, qVar);
        } else if (set instanceof b2) {
            b2 b2Var2 = (b2) set;
            r rVar2 = b2Var2.f4597i;
            rVar2.getClass();
            return new b2((Set) b2Var2.f4596h, new s(Arrays.asList(new r[]{rVar2, qVar})));
        } else {
            set.getClass();
            return new b2(set, qVar);
        }
    }

    public static int c(Set set) {
        Iterator it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static a2 d(u0 u0Var, u0 u0Var2) {
        if (u0Var == null) {
            throw new NullPointerException("set1");
        } else if (u0Var2 != null) {
            return new a2(u0Var, u0Var2);
        } else {
            throw new NullPointerException("set2");
        }
    }
}
