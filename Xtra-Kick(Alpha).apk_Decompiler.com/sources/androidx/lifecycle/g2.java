package androidx.lifecycle;

import java.io.Closeable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public final class g2 {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f1696a = new LinkedHashMap();

    public final void a() {
        for (w1 w1Var : this.f1696a.values()) {
            w1Var.f1783c = true;
            HashMap hashMap = w1Var.f1781a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    for (Object a10 : w1Var.f1781a.values()) {
                        w1.a(a10);
                    }
                }
            }
            LinkedHashSet linkedHashSet = w1Var.f1782b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    for (Closeable a11 : w1Var.f1782b) {
                        w1.a(a11);
                    }
                }
            }
            w1Var.b();
        }
        this.f1696a.clear();
    }
}
