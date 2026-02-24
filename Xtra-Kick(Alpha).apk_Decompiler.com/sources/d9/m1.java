package d9;

import c9.w;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;

public final class m1 extends b {

    /* renamed from: n  reason: collision with root package name */
    public final transient w f4633n;

    public m1(Map map, h1 h1Var) {
        super(map);
        this.f4633n = h1Var;
    }

    public final f b() {
        Map map = this.f4592l;
        return map instanceof NavigableMap ? new i(this, (NavigableMap) map) : map instanceof SortedMap ? new l(this, (SortedMap) map) : new f(this, map);
    }

    public final h d() {
        Map map = this.f4592l;
        return map instanceof NavigableMap ? new j(this, (NavigableMap) map) : map instanceof SortedMap ? new m(this, (SortedMap) map) : new h(this, map);
    }
}
