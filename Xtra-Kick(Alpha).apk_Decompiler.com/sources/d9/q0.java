package d9;

import c9.q;
import java.util.Iterator;
import java.util.ListIterator;

public final class q0 extends r0 {

    /* renamed from: j  reason: collision with root package name */
    public final transient int f4647j;

    /* renamed from: k  reason: collision with root package name */
    public final transient int f4648k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ r0 f4649l;

    public q0(r0 r0Var, int i10, int i11) {
        this.f4649l = r0Var;
        this.f4647j = i10;
        this.f4648k = i11;
    }

    public final Object[] c() {
        return this.f4649l.c();
    }

    public final int d() {
        return this.f4649l.e() + this.f4647j + this.f4648k;
    }

    public final int e() {
        return this.f4649l.e() + this.f4647j;
    }

    public final boolean f() {
        return true;
    }

    public final Object get(int i10) {
        q.b(i10, this.f4648k);
        return this.f4649l.get(i10 + this.f4647j);
    }

    public final Iterator iterator() {
        return listIterator(0);
    }

    public final ListIterator listIterator() {
        return listIterator(0);
    }

    /* renamed from: o */
    public final r0 subList(int i10, int i11) {
        q.e(i10, i11, this.f4648k);
        int i12 = this.f4647j;
        return this.f4649l.subList(i10 + i12, i11 + i12);
    }

    public final int size() {
        return this.f4648k;
    }

    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
        return listIterator(i10);
    }
}
