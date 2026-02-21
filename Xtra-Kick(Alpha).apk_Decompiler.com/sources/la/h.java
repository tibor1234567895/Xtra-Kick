package la;

import xa.j;

public final class h extends Error {
    public h() {
        this("An operation is not implemented.");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(String str) {
        super(str);
        j.f("message", str);
    }
}
