package j7;

import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final StreamSortEnum f8841a;

    public i() {
        this(0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f8841a == ((i) obj).f8841a;
    }

    public final int hashCode() {
        return this.f8841a.hashCode();
    }

    public final String toString() {
        return "Filter(sort=" + this.f8841a + ")";
    }

    public /* synthetic */ i(int i10) {
        this(StreamSortEnum.VIEWERS_HIGH);
    }

    public i(StreamSortEnum streamSortEnum) {
        j.f("sort", streamSortEnum);
        this.f8841a = streamSortEnum;
    }
}
