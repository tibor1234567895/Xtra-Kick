package f6;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import n3.g4;
import pa.e;
import ra.c;

public final class g extends c {

    /* renamed from: h  reason: collision with root package name */
    public h f5849h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f5850i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f5851j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ h f5852k;

    /* renamed from: l  reason: collision with root package name */
    public int f5853l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(h hVar, e eVar) {
        super(eVar);
        this.f5852k = hVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5851j = obj;
        this.f5853l |= RecyclerView.UNDEFINED_DURATION;
        return this.f5852k.b((g4) null, this);
    }
}
