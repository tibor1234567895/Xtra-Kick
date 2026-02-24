package r7;

import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.google.android.flexbox.FlexboxLayout;
import hb.h0;
import xa.j;
import z5.m;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13837h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f13838i;

    public /* synthetic */ b(m mVar, int i10) {
        this.f13837h = i10;
        this.f13838i = mVar;
    }

    public final void run() {
        int i10 = this.f13837h;
        m mVar = this.f13838i;
        switch (i10) {
            case 0:
                int i11 = ChatView.I;
                j.f("$this_with", mVar);
                FlexboxLayout flexboxLayout = mVar.f17719f;
                j.e("flexbox", flexboxLayout);
                h0.J0(flexboxLayout);
                return;
            default:
                j.f("$this_with", mVar);
                FlexboxLayout flexboxLayout2 = mVar.f17719f;
                j.e("flexbox", flexboxLayout2);
                h0.J0(flexboxLayout2);
                return;
        }
    }
}
