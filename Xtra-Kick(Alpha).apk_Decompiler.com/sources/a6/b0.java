package a6;

import m.d;
import r3.n0;

public final class b0 extends d {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f218d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b0(n0 n0Var, int i10) {
        super(n0Var);
        this.f218d = i10;
    }

    public final String e() {
        switch (this.f218d) {
            case 0:
                return "UPDATE videos SET last_watch_position = ? WHERE id = ?";
            default:
                return "UPDATE videos SET last_watch_position = null";
        }
    }
}
