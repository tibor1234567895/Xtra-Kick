package j9;

import l9.o;

public final class v extends s {

    /* renamed from: h  reason: collision with root package name */
    public final o f8878h = new o();

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof v) && ((v) obj).f8878h.equals(this.f8878h));
    }

    public final s f(String str) {
        return (s) this.f8878h.get(str);
    }

    public final int hashCode() {
        return this.f8878h.hashCode();
    }
}
