package o7;

import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import xa.j;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final VideoSortEnum f12293a;

    /* renamed from: b  reason: collision with root package name */
    public final VideoPeriodEnum f12294b;

    /* renamed from: c  reason: collision with root package name */
    public final BroadcastTypeEnum f12295c;

    public e() {
        this((VideoSortEnum) null, (BroadcastTypeEnum) null, 7);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (o7.e) r5;
        r1 = r5.f12293a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof o7.e
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            o7.e r5 = (o7.e) r5
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r1 = r5.f12293a
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r3 = r4.f12293a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r1 = r4.f12294b
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r3 = r5.f12294b
            if (r1 == r3) goto L_0x001a
            return r2
        L_0x001a:
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r1 = r4.f12295c
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r5 = r5.f12295c
            if (r1 == r5) goto L_0x0021
            return r2
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode = this.f12294b.hashCode();
        return this.f12295c.hashCode() + ((hashCode + (this.f12293a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Filter(sort=" + this.f12293a + ", period=" + this.f12294b + ", broadcastType=" + this.f12295c + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(VideoSortEnum videoSortEnum, BroadcastTypeEnum broadcastTypeEnum, int i10) {
        this((i10 & 1) != 0 ? VideoSortEnum.TIME : videoSortEnum, (i10 & 2) != 0 ? VideoPeriodEnum.ALL : null, (i10 & 4) != 0 ? BroadcastTypeEnum.ALL : broadcastTypeEnum);
    }

    public e(VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum) {
        j.f("sort", videoSortEnum);
        j.f("period", videoPeriodEnum);
        j.f("broadcastType", broadcastTypeEnum);
        this.f12293a = videoSortEnum;
        this.f12294b = videoPeriodEnum;
        this.f12295c = broadcastTypeEnum;
    }
}
