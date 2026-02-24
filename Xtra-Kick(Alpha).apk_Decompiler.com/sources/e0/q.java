package e0;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import l9.o;
import l9.p;

public final class q implements p {

    /* renamed from: h  reason: collision with root package name */
    public final int f4883h;

    public /* synthetic */ q(int i10) {
        this.f4883h = i10;
    }

    public Object i() {
        switch (this.f4883h) {
            case 0:
                return new ConcurrentHashMap();
            case 1:
                return new TreeMap();
            case 2:
                return new LinkedHashMap();
            case 3:
                return new o();
            case 4:
                return new TreeSet();
            case Constants.MAX_COMPATIBILITY_VERSION:
                return new LinkedHashSet();
            case 6:
                return new ArrayDeque();
            case 7:
                return new ArrayList();
            default:
                return new ConcurrentSkipListMap();
        }
    }
}
