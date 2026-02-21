package e6;

import androidx.recyclerview.widget.RecyclerView;
import com.github.andreyasadchy.xtra.model.ui.StreamSortEnum;
import pa.e;
import ra.c;

public final class f extends c {

    /* renamed from: h  reason: collision with root package name */
    public x f5111h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5112i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ x f5113j;

    /* renamed from: k  reason: collision with root package name */
    public int f5114k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(x xVar, e eVar) {
        super(eVar);
        this.f5113j = xVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5112i = obj;
        this.f5114k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5113j.c(0, (String) null, (StreamSortEnum) null, this);
    }
}
