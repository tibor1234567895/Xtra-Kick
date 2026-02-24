package xb;

import org.conscrypt.Conscrypt;

public final class h {
    private h() {
    }

    public /* synthetic */ h(int i10) {
        this();
    }

    public static boolean a() {
        Conscrypt.Version version = Conscrypt.version();
        if (version == null) {
            return false;
        }
        return version.major() != 2 ? version.major() > 2 : version.minor() != 1 ? version.minor() > 1 : version.patch() >= 0;
    }

    public static boolean b() {
        return j.f16834f;
    }
}
