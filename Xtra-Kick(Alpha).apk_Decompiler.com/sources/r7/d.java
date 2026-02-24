package r7;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import xa.j;
import xa.s;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f13845a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f13846b;

    public /* synthetic */ d(i iVar, s sVar) {
        this.f13845a = iVar;
        this.f13846b = sVar;
    }

    public final void onFocusChange(View view, boolean z10) {
        int i10 = ChatView.I;
        i iVar = this.f13845a;
        j.f("$this_apply", iVar);
        s sVar = this.f13846b;
        j.f("$previousSize", sVar);
        if (z10 && iVar.getCount() != sVar.f16816h) {
            sVar.f16816h = iVar.getCount();
            iVar.notifyDataSetChanged();
        }
        iVar.setNotifyOnChange(z10);
    }
}
