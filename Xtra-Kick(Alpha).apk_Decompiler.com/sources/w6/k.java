package w6;

import androidx.recyclerview.widget.RecyclerView;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.ui.player.stream.StreamPlayerViewModel;
import pa.e;
import ra.c;

public final class k extends c {

    /* renamed from: h  reason: collision with root package name */
    public StreamPlayerViewModel f16149h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f16150i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ StreamPlayerViewModel f16151j;

    /* renamed from: k  reason: collision with root package name */
    public int f16152k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(StreamPlayerViewModel streamPlayerViewModel, e eVar) {
        super(eVar);
        this.f16151j = streamPlayerViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.f16150i = obj;
        this.f16152k |= RecyclerView.UNDEFINED_DURATION;
        return StreamPlayerViewModel.g(this.f16151j, (Stream) null, this);
    }
}
