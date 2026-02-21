package w6;

import android.view.View;
import androidx.fragment.app.c1;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import h3.b0;
import h6.r;
import h6.s;
import hb.h0;
import j3.k0;
import s7.g;
import xa.j;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f16130h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ f f16131i;

    public /* synthetic */ b(f fVar, int i10) {
        this.f16130h = i10;
        this.f16131i = fVar;
    }

    public final void onClick(View view) {
        int i10 = this.f16130h;
        f fVar = this.f16131i;
        switch (i10) {
            case 0:
                d dVar = f.H0;
                j.f("this$0", fVar);
                g gVar = g.f14374a;
                c1 u10 = fVar.u();
                j.e("childFragmentManager", u10);
                gVar.getClass();
                g.a(u10, (String) null, false);
                return;
            case 1:
                d dVar2 = f.H0;
                j.f("this$0", fVar);
                fVar.T0();
                return;
            case 2:
                d dVar3 = f.H0;
                j.f("this$0", fVar);
                b0 s02 = fVar.s0();
                if (s02 != null) {
                    s02.R();
                    return;
                }
                return;
            case 3:
                d dVar4 = f.H0;
                j.f("this$0", fVar);
                fVar.S0();
                return;
            default:
                d dVar5 = f.H0;
                j.f("this$0", fVar);
                k0 V = h0.V(fVar);
                r rVar = s.f7686a;
                Stream stream = fVar.G0;
                if (stream != null) {
                    int channelId = stream.getChannelId();
                    Stream stream2 = fVar.G0;
                    if (stream2 != null) {
                        String channelSlug = stream2.getChannelSlug();
                        Stream stream3 = fVar.G0;
                        if (stream3 != null) {
                            String channelName = stream3.getChannelName();
                            Stream stream4 = fVar.G0;
                            if (stream4 != null) {
                                V.m(r.a(rVar, channelId, channelSlug, channelName, stream4.getChannelLogo(), false, 0, 48));
                                fVar.u0().g();
                                return;
                            }
                            j.l("stream");
                            throw null;
                        }
                        j.l("stream");
                        throw null;
                    }
                    j.l("stream");
                    throw null;
                }
                j.l("stream");
                throw null;
        }
    }
}
