package q1;

import java.util.LinkedHashMap;
import java.util.Map;

public final class e extends LinkedHashMap {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13151h = 4;

    public e(int i10) {
        super(i10, 1.0f, false);
    }

    public final boolean removeEldestEntry(Map.Entry entry) {
        return size() > this.f13151h;
    }
}
