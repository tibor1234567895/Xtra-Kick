package w6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import hb.f0;
import hb.h0;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f16145i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ StreamPlayerViewModel f16146j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Context f16147k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Stream f16148l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(StreamPlayerViewModel streamPlayerViewModel, Context context, Stream stream, e eVar) {
        super(2, eVar);
        this.f16146j = streamPlayerViewModel;
        this.f16147k = context;
        this.f16148l = stream;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f16146j, this.f16147k, this.f16148l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f16145i;
        if (i10 == 0) {
            h0.O1(obj);
            StreamPlayerViewModel streamPlayerViewModel = this.f16146j;
            Stream stream = this.f16148l;
            this.f16145i = 1;
            if (StreamPlayerViewModel.g(streamPlayerViewModel, stream, this) == aVar) {
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
        return v.f9814a;
    }
}
