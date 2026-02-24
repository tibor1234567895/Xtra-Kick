package androidx.recyclerview.widget;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f1925a;

    /* renamed from: b  reason: collision with root package name */
    public int f1926b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1927c;

    /* renamed from: d  reason: collision with root package name */
    public int f1928d;

    public a(Object obj, int i10, int i11, int i12) {
        this.f1925a = i10;
        this.f1926b = i11;
        this.f1928d = i12;
        this.f1927c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        int i10 = this.f1925a;
        if (i10 != aVar.f1925a) {
            return false;
        }
        if (i10 == 8 && Math.abs(this.f1928d - this.f1926b) == 1 && this.f1928d == aVar.f1926b && this.f1926b == aVar.f1928d) {
            return true;
        }
        if (this.f1928d != aVar.f1928d || this.f1926b != aVar.f1926b) {
            return false;
        }
        Object obj2 = this.f1927c;
        Object obj3 = aVar.f1927c;
        if (obj2 != null) {
            if (!obj2.equals(obj3)) {
                return false;
            }
        } else if (obj3 != null) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f1925a * 31) + this.f1926b) * 31) + this.f1928d;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[");
        int i10 = this.f1925a;
        if (i10 == 1) {
            str = "add";
        } else if (i10 == 2) {
            str = "rm";
        } else if (i10 == 4) {
            str = "up";
        } else if (i10 != 8) {
            str = "??";
        } else {
            str = "mv";
        }
        sb2.append(str);
        sb2.append(",s:");
        sb2.append(this.f1926b);
        sb2.append("c:");
        sb2.append(this.f1928d);
        sb2.append(",p:");
        sb2.append(this.f1927c);
        sb2.append("]");
        return sb2.toString();
    }
}
