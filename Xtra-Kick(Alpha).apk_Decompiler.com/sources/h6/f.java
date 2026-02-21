package h6;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import fb.y;
import hb.h0;
import j3.d1;
import j3.k0;
import q6.a;
import q6.b;
import q6.g;
import q6.h;
import r7.w;
import r7.z;
import xa.j;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7654h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7655i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f7656j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CharSequence f7657k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f7658l;

    public /* synthetic */ f(Object obj, int i10, CharSequence charSequence, Object obj2, int i11) {
        this.f7654h = i11;
        this.f7656j = obj;
        this.f7655i = i10;
        this.f7657k = charSequence;
        this.f7658l = obj2;
    }

    public final void onClick(View view) {
        d1 d1Var;
        int i10 = this.f7654h;
        Object obj = this.f7658l;
        CharSequence charSequence = this.f7657k;
        Object obj2 = this.f7656j;
        switch (i10) {
            case 0:
                ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) obj2;
                int i11 = this.f7655i;
                String str = (String) charSequence;
                Stream stream = (Stream) obj;
                int i12 = ChannelPagerFragment.f3334r0;
                j.f("this$0", channelPagerFragment);
                j.f("$gameSlug", str);
                k0 V = h0.V(channelPagerFragment);
                if (h0.l1(channelPagerFragment.f0()).getBoolean("ui_gamepager", true)) {
                    d1Var = g.a(h.f13361a, i11, str, stream.getGameName(), stream.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    d1Var = a.a(b.f13350a, i11, str, stream.getGameName(), stream.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V.m(d1Var);
                return;
            default:
                ClipboardManager clipboardManager = (ClipboardManager) obj2;
                z zVar = (z) obj;
                w wVar = z.D0;
                j.f("$msg", charSequence);
                j.f("this$0", zVar);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("label", charSequence.subSequence(y.t(charSequence, ':', 0, false, 6) + 2, charSequence.length()).toString()));
                }
                zVar.l0();
                return;
        }
    }
}
