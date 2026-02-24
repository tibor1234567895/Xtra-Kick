package e1;

import android.service.media.MediaBrowserService;
import com.google.gson.internal.bind.l;

public class o extends m {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ p f4933i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(p pVar, a0 a0Var) {
        super(pVar, a0Var);
        this.f4933i = pVar;
    }

    public final void onLoadItem(String str, MediaBrowserService.Result result) {
        l lVar = new l(result);
        p pVar = this.f4933i;
        pVar.getClass();
        a0 a0Var = pVar.f4934e;
        a0Var.f4891l = a0Var.f4888i;
        lVar.g((Object) null);
        a0Var.f4891l = null;
    }
}
