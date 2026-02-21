package ma;

import java.util.Iterator;
import java.util.NoSuchElementException;
import s.i;
import ya.a;

public abstract class b implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public int f10799h = 2;

    /* renamed from: i  reason: collision with root package name */
    public Object f10800i;

    public abstract void a();

    public final boolean hasNext() {
        boolean z10;
        int i10 = this.f10799h;
        if (i10 != 4) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int a10 = i.a(i10);
            if (a10 != 0) {
                if (a10 == 2) {
                    return false;
                }
                this.f10799h = 4;
                a();
                if (this.f10799h == 1) {
                    return true;
                }
                return false;
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final Object next() {
        if (hasNext()) {
            this.f10799h = 2;
            return this.f10800i;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
