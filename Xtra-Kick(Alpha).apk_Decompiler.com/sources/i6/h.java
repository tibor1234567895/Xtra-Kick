package i6;

import androidx.lifecycle.o0;
import com.github.andreyasadchy.xtra.model.chat.LiveChatMessage;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import java.util.List;
import t7.m;

public abstract class h implements m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8317a;

    public h(ChatViewModel chatViewModel) {
        this.f8317a = chatViewModel;
    }

    public void a(LiveChatMessage liveChatMessage) {
        List list = ChatViewModel.A;
        ChatViewModel chatViewModel = this.f8317a;
        List list2 = (List) chatViewModel.d().d();
        if (list2 != null) {
            list2.add(liveChatMessage);
        }
        ((o0) chatViewModel.f3367x.getValue()).j(liveChatMessage);
    }

    public abstract void b();

    public abstract void c(CharSequence charSequence);

    public abstract void d();

    public abstract void e();
}
