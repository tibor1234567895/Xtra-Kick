package i6;

import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import hb.c2;
import hb.h0;
import java.util.concurrent.CancellationException;
import n3.w1;
import wa.a;
import xa.j;

public final class o extends h {

    /* renamed from: b  reason: collision with root package name */
    public final String f8332b;

    /* renamed from: c  reason: collision with root package name */
    public final double f8333c;

    /* renamed from: d  reason: collision with root package name */
    public final a f8334d;

    /* renamed from: e  reason: collision with root package name */
    public t6.o f8335e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8336f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(ChatViewModel chatViewModel, String str, double d10, w1 w1Var) {
        super(chatViewModel);
        this.f8336f = chatViewModel;
        this.f8332b = str;
        this.f8333c = d10;
        this.f8334d = w1Var;
    }

    public final void b() {
        t6.o oVar = this.f8335e;
        if (oVar != null) {
            c2 c2Var = oVar.f14646f;
            if (c2Var != null) {
                c2Var.e((CancellationException) null);
                oVar.f14644d.cancel();
                return;
            }
            j.l("offsetJob");
            throw null;
        }
    }

    public final void c(CharSequence charSequence) {
    }

    public final void d() {
        e();
        ChatViewModel chatViewModel = this.f8336f;
        this.f8335e = new t6.o(chatViewModel.f3347d, this.f8332b, this.f8333c, this.f8334d, this, new n(chatViewModel, 0), h0.I0(chatViewModel));
    }

    public final void e() {
        t6.o oVar = this.f8335e;
        if (oVar != null) {
            c2 c2Var = oVar.f14646f;
            if (c2Var != null) {
                c2Var.e((CancellationException) null);
                oVar.f14644d.cancel();
                return;
            }
            j.l("offsetJob");
            throw null;
        }
    }
}
