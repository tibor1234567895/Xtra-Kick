package r7;

import android.widget.Button;
import com.github.andreyasadchy.xtra.model.ui.User;
import la.i;
import la.v;
import wa.l;
import xa.j;
import xa.k;
import z5.a;

public final class y extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13878h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z f13879i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ a f13880j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(int i10, z zVar, a aVar) {
        super(1);
        this.f13878h = i10;
        this.f13879i = zVar;
        this.f13880j = aVar;
    }

    public final Object invoke(Object obj) {
        User user = (User) obj;
        if (user != null) {
            z.E0.add(new i(user, Integer.valueOf(this.f13878h)));
            this.f13879i.s0(user);
        } else {
            Button button = this.f13880j.f17590l;
            j.e("viewProfile", button);
            button.setVisibility(0);
        }
        return v.f9814a;
    }
}
