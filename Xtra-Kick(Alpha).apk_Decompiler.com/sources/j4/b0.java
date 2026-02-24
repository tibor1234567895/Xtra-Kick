package j4;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;

public final class b0 extends c {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f8732h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ c0 f8733i;

    /* renamed from: j  reason: collision with root package name */
    public int f8734j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var, e eVar) {
        super(eVar);
        this.f8733i = c0Var;
    }

    public final Object invokeSuspend(Object obj) {
        this.f8732h = obj;
        this.f8734j |= RecyclerView.UNDEFINED_DURATION;
        return this.f8733i.c((Drawable) null, this);
    }
}
