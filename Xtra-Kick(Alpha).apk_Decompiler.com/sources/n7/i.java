package n7;

import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f11733a;

    /* renamed from: b  reason: collision with root package name */
    public final VideoSortEnum f11734b;

    /* renamed from: c  reason: collision with root package name */
    public final VideoPeriodEnum f11735c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastTypeEnum f11736d;

    public i(Boolean bool, VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum) {
        j.f("sort", videoSortEnum);
        j.f("period", videoPeriodEnum);
        j.f("broadcastType", broadcastTypeEnum);
        this.f11733a = bool;
        this.f11734b = videoSortEnum;
        this.f11735c = videoPeriodEnum;
        this.f11736d = broadcastTypeEnum;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return j.a(this.f11733a, iVar.f11733a) && this.f11734b == iVar.f11734b && this.f11735c == iVar.f11735c && this.f11736d == iVar.f11736d;
    }

    public final int hashCode() {
        Boolean bool = this.f11733a;
        int hashCode = bool == null ? 0 : bool.hashCode();
        int hashCode2 = this.f11734b.hashCode();
        return this.f11736d.hashCode() + ((this.f11735c.hashCode() + ((hashCode2 + (hashCode * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Filter(saveSort=" + this.f11733a + ", sort=" + this.f11734b + ", period=" + this.f11735c + ", broadcastType=" + this.f11736d + ")";
    }
}
