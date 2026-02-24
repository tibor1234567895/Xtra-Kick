package j4;

import androidx.recyclerview.widget.RecyclerView;
import ob.f;
import ra.c;

public final class e extends c {

    /* renamed from: h  reason: collision with root package name */
    public Object f8741h;

    /* renamed from: i  reason: collision with root package name */
    public f f8742i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f8743j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ f f8744k;

    /* renamed from: l  reason: collision with root package name */
    public int f8745l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, pa.e eVar) {
        super(eVar);
        this.f8744k = fVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f8743j = obj;
        this.f8745l |= RecyclerView.UNDEFINED_DURATION;
        return this.f8744k.a(this);
    }
}
