package p7;

import android.support.v4.media.h;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import xa.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f12602a;

    /* renamed from: b  reason: collision with root package name */
    public final VideoSortEnum f12603b;

    /* renamed from: c  reason: collision with root package name */
    public final VideoPeriodEnum f12604c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastTypeEnum f12605d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12606e;

    public e(Boolean bool, VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum, int i10) {
        j.f("sort", videoSortEnum);
        j.f("period", videoPeriodEnum);
        j.f("broadcastType", broadcastTypeEnum);
        this.f12602a = bool;
        this.f12603b = videoSortEnum;
        this.f12604c = videoPeriodEnum;
        this.f12605d = broadcastTypeEnum;
        this.f12606e = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return j.a(this.f12602a, eVar.f12602a) && this.f12603b == eVar.f12603b && this.f12604c == eVar.f12604c && this.f12605d == eVar.f12605d && this.f12606e == eVar.f12606e;
    }

    public final int hashCode() {
        Boolean bool = this.f12602a;
        int hashCode = bool == null ? 0 : bool.hashCode();
        int hashCode2 = this.f12603b.hashCode();
        return ((this.f12605d.hashCode() + ((this.f12604c.hashCode() + ((hashCode2 + (hashCode * 31)) * 31)) * 31)) * 31) + this.f12606e;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("Filter(saveSort=");
        sb2.append(this.f12602a);
        sb2.append(", sort=");
        sb2.append(this.f12603b);
        sb2.append(", period=");
        sb2.append(this.f12604c);
        sb2.append(", broadcastType=");
        sb2.append(this.f12605d);
        sb2.append(", languageIndex=");
        return h.o(sb2, this.f12606e, ")");
    }
}
