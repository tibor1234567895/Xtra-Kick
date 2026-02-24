package cb;

import hb.h0;
import ya.a;

public class b implements Iterable, a {

    /* renamed from: k  reason: collision with root package name */
    public static final a f3062k = new a(0);

    /* renamed from: h  reason: collision with root package name */
    public final int f3063h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3064i;

    /* renamed from: j  reason: collision with root package name */
    public final int f3065j;

    public b(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i12 != Integer.MIN_VALUE) {
            this.f3063h = i10;
            this.f3064i = h0.B0(i10, i11, i12);
            this.f3065j = i12;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final c iterator() {
        return new c(this.f3063h, this.f3064i, this.f3065j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0013, code lost:
        r3 = (cb.b) r3;
        r0 = r3.f3063h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof cb.b
            if (r0 == 0) goto L_0x0029
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0013
            r0 = r3
            cb.b r0 = (cb.b) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0027
        L_0x0013:
            cb.b r3 = (cb.b) r3
            int r0 = r3.f3063h
            int r1 = r2.f3063h
            if (r1 != r0) goto L_0x0029
            int r0 = r2.f3064i
            int r1 = r3.f3064i
            if (r0 != r1) goto L_0x0029
            int r0 = r2.f3065j
            int r3 = r3.f3065j
            if (r0 != r3) goto L_0x0029
        L_0x0027:
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cb.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3063h * 31) + this.f3064i) * 31) + this.f3065j;
    }

    public boolean isEmpty() {
        int i10 = this.f3065j;
        int i11 = this.f3064i;
        int i12 = this.f3063h;
        if (i10 > 0) {
            if (i12 > i11) {
                return true;
            }
        } else if (i12 < i11) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2;
        int i10 = this.f3064i;
        int i11 = this.f3063h;
        int i12 = this.f3065j;
        if (i12 > 0) {
            sb2.append(i11);
            sb2.append("..");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(i12);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append(" downTo ");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(-i12);
        }
        return sb2.toString();
    }
}
