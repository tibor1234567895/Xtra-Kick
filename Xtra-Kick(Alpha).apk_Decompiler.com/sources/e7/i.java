package e7;

import f6.y;
import wa.a;
import xa.k;

public final class i extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5311h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f5312i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(String str, int i10) {
        super(0);
        this.f5311h = i10;
        this.f5312i = str;
    }

    public final Object b() {
        String str = this.f5312i;
        int i10 = this.f5311h;
        switch (i10) {
            case 0:
                switch (i10) {
                    case 0:
                        return new y(str, 0);
                    default:
                        return new y(str, 1);
                }
            default:
                switch (i10) {
                    case 0:
                        return new y(str, 0);
                    default:
                        return new y(str, 1);
                }
        }
    }
}
