package cb;

public final class j extends g {
    static {
        new i(0);
        new j(1, 0);
    }

    public j(long j10, long j11) {
        super(j10, j11);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            if (!isEmpty() || !((j) obj).isEmpty()) {
                j jVar = (j) obj;
                if (this.f3072h == jVar.f3072h) {
                    if (this.f3073i == jVar.f3073i) {
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j10 = this.f3072h;
        long j11 = ((long) 31) * (j10 ^ (j10 >>> 32));
        long j12 = this.f3073i;
        return (int) (j11 + (j12 ^ (j12 >>> 32)));
    }

    public final boolean isEmpty() {
        return this.f3072h > this.f3073i;
    }

    public final String toString() {
        return this.f3072h + ".." + this.f3073i;
    }
}
