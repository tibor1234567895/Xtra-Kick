package r5;

import b5.q;
import java.util.ArrayList;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f13836a = new ArrayList();

    public final synchronized q a(Class cls) {
        int size = this.f13836a.size();
        for (int i10 = 0; i10 < size; i10++) {
            h hVar = (h) this.f13836a.get(i10);
            if (hVar.f13834a.isAssignableFrom(cls)) {
                return hVar.f13835b;
            }
        }
        return null;
    }
}
