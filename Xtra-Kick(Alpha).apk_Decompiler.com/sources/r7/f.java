package r7;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import xa.j;
import z5.m;

public final /* synthetic */ class f implements View.OnLongClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f13848h;

    public /* synthetic */ f(m mVar) {
        this.f13848h = mVar;
    }

    public final boolean onLongClick(View view) {
        int i10 = ChatView.I;
        m mVar = this.f13848h;
        j.f("$this_with", mVar);
        mVar.f17716c.getText().clear();
        return true;
    }
}
