package r7;

import android.view.View;
import com.github.andreyasadchy.xtra.model.ui.User;
import i6.e;
import xa.j;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13875h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z f13876i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ User f13877j;

    public /* synthetic */ v(z zVar, User user, int i10) {
        this.f13875h = i10;
        this.f13876i = zVar;
        this.f13877j = user;
    }

    public final void onClick(View view) {
        int i10 = this.f13875h;
        User user = this.f13877j;
        z zVar = this.f13876i;
        switch (i10) {
            case 0:
                w wVar = z.D0;
                j.f("this$0", zVar);
                j.f("$user", user);
                x xVar = zVar.C0;
                if (xVar != null) {
                    ((e) xVar).r0(user.getChannelId(), user.getChannelSlug(), user.getChannelName(), user.getChannelLogo());
                    zVar.l0();
                    return;
                }
                j.l("listener");
                throw null;
            default:
                w wVar2 = z.D0;
                j.f("this$0", zVar);
                j.f("$user", user);
                x xVar2 = zVar.C0;
                if (xVar2 != null) {
                    ((e) xVar2).r0(user.getChannelId(), user.getChannelSlug(), user.getChannelName(), user.getChannelLogo());
                    zVar.l0();
                    return;
                }
                j.l("listener");
                throw null;
        }
    }
}
