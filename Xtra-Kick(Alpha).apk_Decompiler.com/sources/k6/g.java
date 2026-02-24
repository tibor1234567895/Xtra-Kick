package k6;

import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import xa.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f9219a;

    /* renamed from: b  reason: collision with root package name */
    public final VideoPeriodEnum f9220b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9221c;

    public g(Boolean bool, VideoPeriodEnum videoPeriodEnum, int i10) {
        j.f("period", videoPeriodEnum);
        this.f9219a = bool;
        this.f9220b = videoPeriodEnum;
        this.f9221c = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return j.a(this.f9219a, gVar.f9219a) && this.f9220b == gVar.f9220b && this.f9221c == gVar.f9221c;
    }

    public final int hashCode() {
        Boolean bool = this.f9219a;
        return ((this.f9220b.hashCode() + ((bool == null ? 0 : bool.hashCode()) * 31)) * 31) + this.f9221c;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Filter(saveSort=");
        sb2.append(this.f9219a);
        sb2.append(", period=");
        sb2.append(this.f9220b);
        sb2.append(", languageIndex=");
        return h.o(sb2, this.f9221c, ")");
    }
}
