package d5;

import java.util.concurrent.Executor;
import s5.g;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final g f4508a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f4509b;

    public z(g gVar, Executor executor) {
        this.f4508a = gVar;
        this.f4509b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            return this.f4508a.equals(((z) obj).f4508a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f4508a.hashCode();
    }
}
