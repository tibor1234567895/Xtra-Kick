package q;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public final class c implements Iterator, Map.Entry {

    /* renamed from: h  reason: collision with root package name */
    public int f13043h;

    /* renamed from: i  reason: collision with root package name */
    public int f13044i = -1;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13045j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ e f13046k;

    public c(e eVar) {
        this.f13046k = eVar;
        this.f13043h = eVar.f13081j - 1;
    }

    public final boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (!this.f13045j) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Map.Entry)) {
            return false;
        } else {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i10 = this.f13044i;
            e eVar = this.f13046k;
            Object h10 = eVar.h(i10);
            if (key == h10 || (key != null && key.equals(h10))) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                return false;
            }
            Object value = entry.getValue();
            Object l10 = eVar.l(this.f13044i);
            if (value == l10 || (value != null && value.equals(l10))) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return true;
            }
            return false;
        }
    }

    public final Object getKey() {
        if (this.f13045j) {
            return this.f13046k.h(this.f13044i);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final Object getValue() {
        if (this.f13045j) {
            return this.f13046k.l(this.f13044i);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final boolean hasNext() {
        return this.f13044i < this.f13043h;
    }

    public final int hashCode() {
        if (this.f13045j) {
            int i10 = this.f13044i;
            e eVar = this.f13046k;
            Object h10 = eVar.h(i10);
            Object l10 = eVar.l(this.f13044i);
            int i11 = 0;
            int hashCode = h10 == null ? 0 : h10.hashCode();
            if (l10 != null) {
                i11 = l10.hashCode();
            }
            return hashCode ^ i11;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final Object next() {
        if (hasNext()) {
            this.f13044i++;
            this.f13045j = true;
            return this;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        if (this.f13045j) {
            this.f13046k.j(this.f13044i);
            this.f13044i--;
            this.f13043h--;
            this.f13045j = false;
            return;
        }
        throw new IllegalStateException();
    }

    public final Object setValue(Object obj) {
        if (this.f13045j) {
            return this.f13046k.k(this.f13044i, obj);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + Constants.ATTRIBUTE_SEPARATOR + getValue();
    }
}
