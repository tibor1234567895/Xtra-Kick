package d9;

import java.util.List;
import java.util.ListIterator;

public final class o extends e implements ListIterator {

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ p f4641l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(p pVar) {
        super((n) pVar);
        this.f4641l = pVar;
    }

    public final void add(Object obj) {
        p pVar = this.f4641l;
        boolean isEmpty = pVar.isEmpty();
        b().add(obj);
        pVar.f4643m.f4593m++;
        if (isEmpty) {
            pVar.a();
        }
    }

    public final ListIterator b() {
        a();
        return (ListIterator) this.f4605i;
    }

    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    public final int nextIndex() {
        return b().nextIndex();
    }

    public final Object previous() {
        return b().previous();
    }

    public final int previousIndex() {
        return b().previousIndex();
    }

    public final void set(Object obj) {
        b().set(obj);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(p pVar, int i10) {
        super((n) pVar, ((List) pVar.f4635i).listIterator(i10));
        this.f4641l = pVar;
    }
}
