package q;

import android.view.View;
import android.view.ViewGroup;
import eb.b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ma.f;
import xa.j;
import ya.a;

public class m implements Iterator, a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13087h;

    /* renamed from: i  reason: collision with root package name */
    public int f13088i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f13089j;

    public /* synthetic */ m(int i10, Object obj) {
        this.f13087h = i10;
        this.f13089j = obj;
    }

    public final boolean hasNext() {
        int i10 = this.f13087h;
        Object obj = this.f13089j;
        switch (i10) {
            case 0:
                if (this.f13088i < ((l) obj).g()) {
                    return true;
                }
                return false;
            case 1:
                if (this.f13088i < ((ViewGroup) obj).getChildCount()) {
                    return true;
                }
                return false;
            case 2:
                if (this.f13088i < ((f) obj).a()) {
                    return true;
                }
                return false;
            case 3:
                if (this.f13088i < ((Object[]) obj).length) {
                    return true;
                }
                return false;
        }
        while (this.f13088i > 0) {
            Iterator it = (Iterator) obj;
            if (!it.hasNext()) {
                return ((Iterator) obj).hasNext();
            }
            it.next();
            this.f13088i--;
        }
        return ((Iterator) obj).hasNext();
    }

    public final Object next() {
        int i10 = this.f13087h;
        Object obj = this.f13089j;
        switch (i10) {
            case 0:
                int i11 = this.f13088i;
                this.f13088i = i11 + 1;
                return ((l) obj).h(i11);
            case 1:
                int i12 = this.f13088i;
                this.f13088i = i12 + 1;
                View childAt = ((ViewGroup) obj).getChildAt(i12);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            case 2:
                if (hasNext()) {
                    int i13 = this.f13088i;
                    this.f13088i = i13 + 1;
                    return ((f) obj).get(i13);
                }
                throw new NoSuchElementException();
            case 3:
                try {
                    int i14 = this.f13088i;
                    this.f13088i = i14 + 1;
                    return ((Object[]) obj)[i14];
                } catch (ArrayIndexOutOfBoundsException e10) {
                    this.f13088i--;
                    throw new NoSuchElementException(e10.getMessage());
                }
        }
        while (this.f13088i > 0) {
            Iterator it = (Iterator) obj;
            if (!it.hasNext()) {
                return ((Iterator) obj).next();
            }
            it.next();
            this.f13088i--;
        }
        return ((Iterator) obj).next();
    }

    public final void remove() {
        switch (this.f13087h) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                int i10 = this.f13088i - 1;
                this.f13088i = i10;
                ((ViewGroup) this.f13089j).removeViewAt(i10);
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public m(b bVar) {
        this.f13087h = 4;
        this.f13089j = bVar.f5331a.iterator();
        this.f13088i = bVar.f5332b;
    }

    public m(Object[] objArr) {
        this.f13087h = 3;
        j.f("array", objArr);
        this.f13089j = objArr;
    }
}
