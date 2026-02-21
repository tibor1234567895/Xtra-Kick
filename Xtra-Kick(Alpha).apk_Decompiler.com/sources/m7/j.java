package m7;

import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import hb.h0;
import la.i;

public final class j {
    private j() {
    }

    public /* synthetic */ j(int i10) {
        this();
    }

    public static m a(j jVar, VideoSortEnum videoSortEnum, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum, Integer num, boolean z10, boolean z11, boolean z12, int i10) {
        if ((i10 & 1) != 0) {
            videoSortEnum = VideoSortEnum.VIEWS;
        }
        if ((i10 & 2) != 0) {
            videoPeriodEnum = VideoPeriodEnum.ALL;
        }
        if ((i10 & 4) != 0) {
            broadcastTypeEnum = BroadcastTypeEnum.ALL;
        }
        if ((i10 & 8) != 0) {
            num = 0;
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        if ((i10 & 32) != 0) {
            z11 = false;
        }
        if ((i10 & 64) != 0) {
            z12 = false;
        }
        jVar.getClass();
        m mVar = new m();
        mVar.j0(h0.r(new i("sort", videoSortEnum), new i("period", videoPeriodEnum), new i("type", broadcastTypeEnum), new i("language", num), new i("save_sort", Boolean.valueOf(z10)), new i("save_default", Boolean.valueOf(z11)), new i("clip_channel", Boolean.valueOf(z12))));
        return mVar;
    }
}
