package m6;

import android.app.Application;
import com.github.andreyasadchy.xtra.ui.download.VideoDownloadViewModel;
import com.woxthebox.draglistview.R;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import ra.i;
import wa.p;
import xa.j;

public final class c0 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ VideoDownloadViewModel f10629i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(VideoDownloadViewModel videoDownloadViewModel, e eVar) {
        super(2, eVar);
        this.f10629i = videoDownloadViewModel;
    }

    public final e create(Object obj, e eVar) {
        return new c0(this.f10629i, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((c0) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        h0.O1(obj);
        VideoDownloadViewModel videoDownloadViewModel = this.f10629i;
        Application application = videoDownloadViewModel.f1665d;
        j.d("null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication", application);
        h0.X1(application, R.string.video_subscribers_only);
        videoDownloadViewModel.f3396g.l((Object) null);
        return v.f9814a;
    }
}
