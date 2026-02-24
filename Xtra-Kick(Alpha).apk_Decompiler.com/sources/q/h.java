package q;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class h implements Iterator {

    /* renamed from: h  reason: collision with root package name */
    public int f13062h;

    /* renamed from: i  reason: collision with root package name */
    public int f13063i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13064j;

    public h(int i10) {
        this.f13062h = i10;
    }

    public final boolean hasNext() {
        return this.f13063i < this.f13062h;
    }

    public final Object next() {
        Object obj;
        if (hasNext()) {
            int i10 = this.f13063i;
            a aVar = (a) this;
            int i11 = aVar.f13040k;
            Object obj2 = aVar.f13041l;
            switch (i11) {
                case 0:
                    obj = ((e) obj2).h(i10);
                    break;
                case 1:
                    obj = ((e) obj2).l(i10);
                    break;
                default:
                    obj = ((f) obj2).f13058i[i10];
                    break;
            }
            this.f13063i++;
            this.f13064j = true;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        if (this.f13064j) {
            int i10 = this.f13063i - 1;
            this.f13063i = i10;
            a aVar = (a) this;
            int i11 = aVar.f13040k;
            Object obj = aVar.f13041l;
            switch (i11) {
                case 0:
                    ((e) obj).j(i10);
                    break;
                case 1:
                    ((e) obj).j(i10);
                    break;
                default:
                    ((f) obj).e(i10);
                    break;
            }
            this.f13062h--;
            this.f13064j = false;
            return;
        }
        throw new IllegalStateException();
    }
}
