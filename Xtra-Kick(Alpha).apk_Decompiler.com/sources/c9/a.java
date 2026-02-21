package c9;

import java.util.Iterator;
import java.util.NoSuchElementException;
import s.i;

public abstract class a implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public int f3028h = 2;

    /* renamed from: i  reason: collision with root package name */
    public Object f3029i;

    public abstract String a();

    public final boolean hasNext() {
        boolean z10;
        int i10 = this.f3028h;
        if (i10 != 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int a10 = i.a(i10);
            if (a10 == 0) {
                return true;
            }
            if (a10 == 2) {
                return false;
            }
            this.f3028h = 4;
            this.f3029i = a();
            if (this.f3028h == 3) {
                return false;
            }
            this.f3028h = 1;
            return true;
        }
        throw new IllegalStateException();
    }

    public final Object next() {
        if (hasNext()) {
            this.f3028h = 2;
            Object obj = this.f3029i;
            this.f3029i = null;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
