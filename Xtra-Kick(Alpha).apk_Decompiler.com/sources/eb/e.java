package eb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import ya.a;

public final class e implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5334h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final Iterator f5335i;

    /* renamed from: j  reason: collision with root package name */
    public int f5336j;

    /* renamed from: k  reason: collision with root package name */
    public Object f5337k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ h f5338l;

    public e(f fVar) {
        this.f5338l = fVar;
        this.f5335i = fVar.f5339a.iterator();
        this.f5336j = -1;
    }

    public final void a() {
        int i10 = this.f5334h;
        int i11 = 1;
        h hVar = this.f5338l;
        Iterator it = this.f5335i;
        switch (i10) {
            case 0:
                break;
            default:
                if (it.hasNext()) {
                    Object next = it.next();
                    if (((Boolean) ((r) hVar).f5353c.invoke(next)).booleanValue()) {
                        this.f5336j = 1;
                        this.f5337k = next;
                        return;
                    }
                }
                this.f5336j = 0;
                return;
        }
        while (true) {
            if (it.hasNext()) {
                Object next2 = it.next();
                f fVar = (f) hVar;
                if (((Boolean) fVar.f5341c.invoke(next2)).booleanValue() == fVar.f5340b) {
                    this.f5337k = next2;
                }
            } else {
                i11 = 0;
            }
        }
        this.f5336j = i11;
    }

    public final boolean hasNext() {
        switch (this.f5334h) {
            case 0:
                if (this.f5336j == -1) {
                    a();
                }
                if (this.f5336j == 1) {
                    return true;
                }
                return false;
            default:
                if (this.f5336j == -1) {
                    a();
                }
                if (this.f5336j == 1) {
                    return true;
                }
                return false;
        }
    }

    public final Object next() {
        switch (this.f5334h) {
            case 0:
                if (this.f5336j == -1) {
                    a();
                }
                if (this.f5336j != 0) {
                    Object obj = this.f5337k;
                    this.f5337k = null;
                    this.f5336j = -1;
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                if (this.f5336j == -1) {
                    a();
                }
                if (this.f5336j != 0) {
                    Object obj2 = this.f5337k;
                    this.f5337k = null;
                    this.f5336j = -1;
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }

    public final void remove() {
        switch (this.f5334h) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(r rVar) {
        this.f5338l = rVar;
        this.f5335i = ((h) rVar.f5352b).iterator();
        this.f5336j = -1;
    }
}
