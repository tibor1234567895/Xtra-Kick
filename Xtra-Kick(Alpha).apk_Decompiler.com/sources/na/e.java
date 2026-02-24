package na;

import java.util.Iterator;
import java.util.NoSuchElementException;
import xa.j;
import ya.a;

public final class e extends g implements Iterator, a {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f11773k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(h hVar, int i10) {
        super(hVar);
        this.f11773k = i10;
        if (i10 == 1) {
            j.f("map", hVar);
            super(hVar);
        } else if (i10 != 2) {
            j.f("map", hVar);
        } else {
            j.f("map", hVar);
            super(hVar);
        }
    }

    public final Object next() {
        int i10 = this.f11773k;
        h hVar = this.f11776h;
        switch (i10) {
            case 0:
                int i11 = this.f11777i;
                if (i11 < hVar.f11785m) {
                    this.f11777i = i11 + 1;
                    this.f11778j = i11;
                    f fVar = new f(hVar, i11);
                    a();
                    return fVar;
                }
                throw new NoSuchElementException();
            case 1:
                int i12 = this.f11777i;
                if (i12 < hVar.f11785m) {
                    this.f11777i = i12 + 1;
                    this.f11778j = i12;
                    Object obj = hVar.f11780h[i12];
                    a();
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                int i13 = this.f11777i;
                if (i13 < hVar.f11785m) {
                    this.f11777i = i13 + 1;
                    this.f11778j = i13;
                    Object[] objArr = hVar.f11781i;
                    j.c(objArr);
                    Object obj2 = objArr[this.f11778j];
                    a();
                    return obj2;
                }
                throw new NoSuchElementException();
        }
    }
}
