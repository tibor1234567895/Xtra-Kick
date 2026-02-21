package t7;

import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import i6.m;
import java.util.List;
import xa.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final m f14681a;

    /* renamed from: b  reason: collision with root package name */
    public final m f14682b;

    /* renamed from: c  reason: collision with root package name */
    public final c6.b f14683c;

    public b(m mVar, m mVar2, c6.b bVar) {
        j.f("callbackMessage", mVar);
        j.f("callback", mVar2);
        this.f14681a = mVar;
        this.f14682b = mVar2;
        this.f14683c = bVar;
    }

    public final void a(String str, String str2, String str3, String str4) {
        j.f("message", str);
        l lVar = new l(str, str2, str3, str4, 24);
        m mVar = this.f14682b;
        mVar.getClass();
        List list = ChatViewModel.A;
        mVar.f8329i.e().j(lVar);
    }
}
