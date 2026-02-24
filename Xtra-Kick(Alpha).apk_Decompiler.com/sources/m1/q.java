package m1;

import c9.w;
import v1.z;

public final /* synthetic */ class q implements w {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10438h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f10439i;

    public /* synthetic */ q(int i10, Object obj) {
        this.f10438h = i10;
        this.f10439i = obj;
    }

    public final Object get() {
        int i10 = this.f10438h;
        Object obj = this.f10439i;
        switch (i10) {
            case 0:
                return (l) obj;
            case 1:
                return Boolean.valueOf(((u0) obj).G);
            default:
                try {
                    return (z) ((Class) obj).getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
        }
    }
}
