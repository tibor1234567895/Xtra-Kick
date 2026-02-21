package d9;

import java.util.NoSuchElementException;

public final class x0 extends i2 {

    /* renamed from: h  reason: collision with root package name */
    public boolean f4699h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f4700i;

    public x0(Object obj) {
        this.f4700i = obj;
    }

    public final boolean hasNext() {
        return !this.f4699h;
    }

    public final Object next() {
        if (!this.f4699h) {
            this.f4699h = true;
            return this.f4700i;
        }
        throw new NoSuchElementException();
    }
}
