package h5;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c0 implements z {

    /* renamed from: b  reason: collision with root package name */
    public final Map f7559b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Map f7560c;

    public c0(Map map) {
        this.f7559b = Collections.unmodifiableMap(map);
    }

    public final Map a() {
        if (this.f7560c == null) {
            synchronized (this) {
                if (this.f7560c == null) {
                    this.f7560c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f7560c;
    }

    public final HashMap b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f7559b.entrySet()) {
            List list = (List) entry.getValue();
            StringBuilder sb2 = new StringBuilder();
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = ((b0) list.get(i10)).f7556a;
                if (!TextUtils.isEmpty(str)) {
                    sb2.append(str);
                    if (i10 != list.size() - 1) {
                        sb2.append(Constants.COMMA_CHAR);
                    }
                }
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                hashMap.put(entry.getKey(), sb3);
            }
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c0) {
            return this.f7559b.equals(((c0) obj).f7559b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7559b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.f7559b + '}';
    }
}
