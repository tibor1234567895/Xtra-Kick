package e1;

import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.u;
import com.google.gson.internal.bind.l;

public final class r extends o {

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ s f4936j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(s sVar, a0 a0Var) {
        super(sVar, a0Var);
        this.f4936j = sVar;
    }

    public final void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
        u.p(bundle);
        s sVar = this.f4936j;
        a0 a0Var = sVar.f4937f;
        j jVar = a0Var.f4888i;
        q qVar = new q(sVar, str, new l(result), bundle);
        a0Var.f4891l = jVar;
        qVar.f4944c = 1;
        a0Var.b(qVar);
        a0Var.f4891l = null;
        sVar.f4937f.f4891l = null;
    }
}
