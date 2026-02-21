package i6;

import androidx.lifecycle.m0;
import androidx.lifecycle.o0;
import androidx.lifecycle.u1;
import androidx.lifecycle.v1;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import la.v;
import wa.a;
import xa.k;

public final class n extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8330h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8331i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(ChatViewModel chatViewModel, int i10) {
        super(0);
        this.f8330h = i10;
        this.f8331i = chatViewModel;
    }

    public final Object b() {
        int i10 = this.f8330h;
        ChatViewModel chatViewModel = this.f8331i;
        switch (i10) {
            case 0:
                List list = ChatViewModel.A;
                chatViewModel.d().j(new ArrayList());
                return v.f9814a;
            case 1:
                o0 o0Var = new o0();
                o0Var.l(Collections.synchronizedList(new ArrayList(chatViewModel.f3365v + 1)));
                return o0Var;
            default:
                m0 m0Var = new m0();
                m0Var.m(chatViewModel.f3353j, new v1(4, new u1(m0Var, 6, chatViewModel)));
                return m0Var;
        }
    }
}
