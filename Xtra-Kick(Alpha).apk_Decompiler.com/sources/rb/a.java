package rb;

import fb.w;

public final class a {
    private a() {
    }

    public /* synthetic */ a(int i10) {
        this();
    }

    public static boolean a(String str) {
        return !w.g("Connection", str) && !w.g("Keep-Alive", str) && !w.g("Proxy-Authenticate", str) && !w.g("Proxy-Authorization", str) && !w.g("TE", str) && !w.g("Trailers", str) && !w.g("Transfer-Encoding", str) && !w.g("Upgrade", str);
    }
}
