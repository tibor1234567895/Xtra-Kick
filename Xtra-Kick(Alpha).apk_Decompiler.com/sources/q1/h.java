package q1;

import java.util.List;
import java.util.NoSuchElementException;
import r1.j;
import x1.d;

public final class h implements d {

    /* renamed from: b  reason: collision with root package name */
    public final long f13158b;

    /* renamed from: c  reason: collision with root package name */
    public long f13159c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final List f13160d;

    /* renamed from: e  reason: collision with root package name */
    public final long f13161e;

    public h(long j10, List list) {
        this.f13158b = (long) (list.size() - 1);
        this.f13161e = j10;
        this.f13160d = list;
    }

    public final long a() {
        long j10 = this.f13159c;
        if (j10 < 0 || j10 > this.f13158b) {
            throw new NoSuchElementException();
        }
        j jVar = (j) this.f13160d.get((int) j10);
        return this.f13161e + jVar.f13570l + jVar.f13568j;
    }

    public final long b() {
        long j10 = this.f13159c;
        if (j10 < 0 || j10 > this.f13158b) {
            throw new NoSuchElementException();
        }
        return this.f13161e + ((j) this.f13160d.get((int) j10)).f13570l;
    }

    public final boolean next() {
        boolean z10;
        long j10 = this.f13159c + 1;
        this.f13159c = j10;
        if (j10 > this.f13158b) {
            z10 = true;
        } else {
            z10 = false;
        }
        return !z10;
    }
}
