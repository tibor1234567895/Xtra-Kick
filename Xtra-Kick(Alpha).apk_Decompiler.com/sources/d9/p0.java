package d9;

import c9.q;
import java.util.NoSuchElementException;

public final class p0 extends j2 {

    /* renamed from: h  reason: collision with root package name */
    public final int f4644h;

    /* renamed from: i  reason: collision with root package name */
    public int f4645i;

    /* renamed from: j  reason: collision with root package name */
    public final r0 f4646j;

    public p0(int i10, r0 r0Var) {
        int size = r0Var.size();
        q.d(i10, size);
        this.f4644h = size;
        this.f4645i = i10;
        this.f4646j = r0Var;
    }

    /* renamed from: a */
    public final boolean hasNext() {
        return this.f4645i < this.f4644h;
    }

    /* renamed from: b */
    public final boolean hasPrevious() {
        return this.f4645i > 0;
    }

    /* renamed from: c */
    public final Object next() {
        if (hasNext()) {
            int i10 = this.f4645i;
            this.f4645i = i10 + 1;
            return this.f4646j.get(i10);
        }
        throw new NoSuchElementException();
    }

    /* renamed from: d */
    public final Object previous() {
        if (hasPrevious()) {
            int i10 = this.f4645i - 1;
            this.f4645i = i10;
            return this.f4646j.get(i10);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f4645i;
    }

    public final int previousIndex() {
        return this.f4645i - 1;
    }
}
