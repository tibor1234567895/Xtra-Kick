package f6;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import n3.g4;
import pa.e;
import ra.c;

public final class m extends c {

    /* renamed from: h  reason: collision with root package name */
    public p f5863h;

    /* renamed from: i  reason: collision with root package name */
    public g4 f5864i;

    /* renamed from: j  reason: collision with root package name */
    public List f5865j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f5866k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ p f5867l;

    /* renamed from: m  reason: collision with root package name */
    public int f5868m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(p pVar, e eVar) {
        super(eVar);
        this.f5867l = pVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5866k = obj;
        this.f5868m |= RecyclerView.UNDEFINED_DURATION;
        return this.f5867l.b((g4) null, this);
    }
}
