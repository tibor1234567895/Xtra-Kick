package m0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import e.a;
import java.util.Objects;
import q0.b0;

public final class z0 implements OnReceiveContentListener {

    /* renamed from: a  reason: collision with root package name */
    public final z f10164a;

    public z0(z zVar) {
        this.f10164a = zVar;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        i iVar = new i(new a(contentInfo));
        i a10 = ((b0) this.f10164a).a(view, iVar);
        if (a10 == null) {
            return null;
        }
        if (a10 == iVar) {
            return contentInfo;
        }
        ContentInfo s10 = a10.f10099a.s();
        Objects.requireNonNull(s10);
        return b0.b0.o(s10);
    }
}
