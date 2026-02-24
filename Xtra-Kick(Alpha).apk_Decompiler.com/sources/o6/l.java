package o6;

import com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum;
import com.github.andreyasadchy.xtra.model.ui.FollowSortEnum;
import xa.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final FollowSortEnum f12263a;

    /* renamed from: b  reason: collision with root package name */
    public final FollowOrderEnum f12264b;

    public l() {
        this(FollowSortEnum.LAST_BROADCAST, FollowOrderEnum.DESC);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (o6.l) r5;
        r1 = r5.f12263a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof o6.l
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            o6.l r5 = (o6.l) r5
            com.github.andreyasadchy.xtra.model.ui.FollowSortEnum r1 = r5.f12263a
            com.github.andreyasadchy.xtra.model.ui.FollowSortEnum r3 = r4.f12263a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r1 = r4.f12264b
            com.github.andreyasadchy.xtra.model.ui.FollowOrderEnum r5 = r5.f12264b
            if (r1 == r5) goto L_0x001a
            return r2
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o6.l.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return this.f12264b.hashCode() + (this.f12263a.hashCode() * 31);
    }

    public final String toString() {
        return "Filter(sort=" + this.f12263a + ", order=" + this.f12264b + ")";
    }

    public l(FollowSortEnum followSortEnum, FollowOrderEnum followOrderEnum) {
        j.f("sort", followSortEnum);
        j.f("order", followOrderEnum);
        this.f12263a = followSortEnum;
        this.f12264b = followOrderEnum;
    }
}
