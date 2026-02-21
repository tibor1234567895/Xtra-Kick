package r7;

import android.view.KeyEvent;
import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import xa.j;

public final /* synthetic */ class e implements View.OnKeyListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ChatView f13847h;

    public /* synthetic */ e(ChatView chatView) {
        this.f13847h = chatView;
    }

    public final boolean onKey(View view, int i10, KeyEvent keyEvent) {
        int i11 = ChatView.I;
        ChatView chatView = this.f13847h;
        j.f("this$0", chatView);
        if (keyEvent.getAction() == 0 && i10 == 66) {
            return chatView.w();
        }
        return false;
    }
}
