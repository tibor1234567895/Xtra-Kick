package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

public abstract class w1 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1781a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashSet f1782b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1783c = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    public void b() {
    }

    public final Object c(String str, Object obj) {
        Object obj2;
        synchronized (this.f1781a) {
            obj2 = this.f1781a.get(str);
            if (obj2 == null) {
                this.f1781a.put(str, obj);
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f1783c) {
            a(obj);
        }
        return obj;
    }
}
