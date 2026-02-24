package d9;

import java.util.NoSuchElementException;
import s.i;

public abstract class a extends i2 {

    /* renamed from: h  reason: collision with root package name */
    public int f4588h = 2;

    /* renamed from: i  reason: collision with root package name */
    public Object f4589i;

    public abstract Object a();

    public final boolean hasNext() {
        boolean z10;
        int i10 = this.f4588h;
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
            this.f4588h = 4;
            this.f4589i = a();
            if (this.f4588h == 3) {
                return false;
            }
            this.f4588h = 1;
            return true;
        }
        throw new IllegalStateException();
    }

    public final Object next() {
        if (hasNext()) {
            this.f4588h = 2;
            Object obj = this.f4589i;
            this.f4589i = null;
            return obj;
        }
        throw new NoSuchElementException();
    }
}
