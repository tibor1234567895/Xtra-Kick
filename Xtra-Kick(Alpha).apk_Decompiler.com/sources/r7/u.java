package r7;

import android.view.View;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import fb.a;
import fb.y;
import i6.e;
import xa.j;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13872h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ z f13873i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CharSequence f13874j;

    public /* synthetic */ u(z zVar, CharSequence charSequence, int i10) {
        this.f13872h = i10;
        this.f13873i = zVar;
        this.f13874j = charSequence;
    }

    public final void onClick(View view) {
        int i10 = this.f13872h;
        CharSequence charSequence = this.f13874j;
        z zVar = this.f13873i;
        switch (i10) {
            case 0:
                w wVar = z.D0;
                j.f("this$0", zVar);
                j.f("$msg", charSequence);
                x xVar = zVar.C0;
                if (xVar != null) {
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < charSequence.length(); i11++) {
                        char charAt = charSequence.charAt(i11);
                        if (!a.b(charAt)) {
                            if (charAt != ':') {
                                sb2.append(charAt);
                            } else {
                                String sb3 = sb2.toString();
                                j.e("userName.toString()", sb3);
                                k5.a aVar = ((e) xVar).f8315o0;
                                j.c(aVar);
                                ((ChatView) aVar.f9125j).u(sb3);
                                zVar.l0();
                                return;
                            }
                        }
                    }
                    String sb32 = sb2.toString();
                    j.e("userName.toString()", sb32);
                    k5.a aVar2 = ((e) xVar).f8315o0;
                    j.c(aVar2);
                    ((ChatView) aVar2.f9125j).u(sb32);
                    zVar.l0();
                    return;
                }
                j.l("listener");
                throw null;
            default:
                w wVar2 = z.D0;
                j.f("this$0", zVar);
                j.f("$msg", charSequence);
                x xVar2 = zVar.C0;
                if (xVar2 != null) {
                    String obj = charSequence.subSequence(y.t(charSequence, ':', 0, false, 6) + 2, charSequence.length()).toString();
                    j.f("message", obj);
                    k5.a aVar3 = ((e) xVar2).f8315o0;
                    j.c(aVar3);
                    ((ChatView) aVar3.f9125j).setMessage(obj);
                    zVar.l0();
                    return;
                }
                j.l("listener");
                throw null;
        }
    }
}
