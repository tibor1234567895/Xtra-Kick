package f6;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import n3.g4;
import pa.e;
import ra.c;

public final class j extends c {

    /* renamed from: h  reason: collision with root package name */
    public ArrayList f5857h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f5858i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ k f5859j;

    /* renamed from: k  reason: collision with root package name */
    public int f5860k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(k kVar, e eVar) {
        super(eVar);
        this.f5859j = kVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f5858i = obj;
        this.f5860k |= RecyclerView.UNDEFINED_DURATION;
        return this.f5859j.b((g4) null, this);
    }
}
