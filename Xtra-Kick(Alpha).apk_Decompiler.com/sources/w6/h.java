package w6;

import android.net.Uri;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import e6.s1;
import e6.z1;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class h extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16137i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ StreamPlayerViewModel f16138j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f16139k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(StreamPlayerViewModel streamPlayerViewModel, String str, e eVar) {
        super(2, eVar);
        this.f16138j = streamPlayerViewModel;
        this.f16139k = str;
    }

    public final e create(Object obj, e eVar) {
        return new h(this.f16138j, this.f16139k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((h) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16137i;
        Uri uri = null;
        StreamPlayerViewModel streamPlayerViewModel = this.f16138j;
        if (i10 == 0) {
            h0.O1(obj);
            z1 z1Var = streamPlayerViewModel.f3444n;
            String str = this.f16139k;
            this.f16137i = 1;
            z1Var.getClass();
            obj = h0.c2(p0.f7834b, new s1(z1Var, str, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        uri = (Uri) obj;
        streamPlayerViewModel.f3446p.j(uri);
        return v.f9814a;
    }
}
