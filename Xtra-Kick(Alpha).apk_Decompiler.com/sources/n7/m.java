package n7;

import androidx.activity.w;
import c6.b;
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import e6.s0;
import hb.h0;
import kb.j;
import la.v;
import n3.r3;
import pa.e;
import qa.a;
import ra.i;
import wa.q;

public final class m extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public int f11749i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ j f11750j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f11751k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ChannelVideosViewModel f11752l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ s0 f11753m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ b f11754n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(e eVar, ChannelVideosViewModel channelVideosViewModel, s0 s0Var, b bVar) {
        super(3, eVar);
        this.f11752l = channelVideosViewModel;
        this.f11753m = s0Var;
        this.f11754n = bVar;
    }

    public final Object e(Object obj, Object obj2, Object obj3) {
        m mVar = new m((e) obj3, this.f11752l, this.f11753m, this.f11754n);
        mVar.f11750j = (j) obj;
        mVar.f11751k = obj2;
        return mVar.invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11749i;
        if (i10 == 0) {
            h0.O1(obj);
            this.f11749i = 1;
            if (h0.Q(this.f11750j, (kb.i) new e.a(new r3(30, 3, 30), (wa.a) new w((i) this.f11751k, this.f11752l, this.f11753m, this.f11754n, 1)).f4852i, this) == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return v.f9814a;
    }
}
