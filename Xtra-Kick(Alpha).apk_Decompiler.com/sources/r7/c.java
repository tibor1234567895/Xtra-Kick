package r7;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import r3.b0;
import xa.j;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13843h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatView f13844i;

    public /* synthetic */ c(ChatView chatView, int i10) {
        this.f13843h = i10;
        this.f13844i = chatView;
    }

    public final void onClick(View view) {
        int i10 = this.f13843h;
        ChatView chatView = this.f13844i;
        switch (i10) {
            case 0:
                int i11 = ChatView.I;
                j.f("this$0", chatView);
                chatView.post(new b0(chatView, 5, view));
                return;
            default:
                int i12 = ChatView.I;
                j.f("this$0", chatView);
                chatView.w();
                return;
        }
    }
}
