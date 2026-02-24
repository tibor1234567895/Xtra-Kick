package m6;

import android.view.KeyEvent;
import android.widget.TextView;
import com.github.andreyasadchy.xtra.model.VideoDownloadInfo;
import xa.j;
import z5.c;

public final /* synthetic */ class v implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f10670a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoDownloadInfo f10672c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ VideoDownloadInfo f10673d;

    public /* synthetic */ v(z zVar, c cVar, VideoDownloadInfo videoDownloadInfo, VideoDownloadInfo videoDownloadInfo2) {
        this.f10670a = zVar;
        this.f10671b = cVar;
        this.f10672c = videoDownloadInfo;
        this.f10673d = videoDownloadInfo2;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        w wVar = z.D0;
        z zVar = this.f10670a;
        j.f("this$0", zVar);
        c cVar = this.f10671b;
        j.f("$this_with", cVar);
        VideoDownloadInfo videoDownloadInfo = this.f10672c;
        j.f("$this_with$1", videoDownloadInfo);
        VideoDownloadInfo videoDownloadInfo2 = this.f10673d;
        j.f("$videoInfo", videoDownloadInfo2);
        if (i10 != 6) {
            return false;
        }
        z.u0(zVar, cVar, videoDownloadInfo, videoDownloadInfo2);
        return true;
    }
}
