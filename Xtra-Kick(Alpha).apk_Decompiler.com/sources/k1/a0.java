package k1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f8964a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public Map f8965b;

    public final synchronized Map a() {
        if (this.f8965b == null) {
            this.f8965b = Collections.unmodifiableMap(new HashMap(this.f8964a));
        }
        return this.f8965b;
    }
}
