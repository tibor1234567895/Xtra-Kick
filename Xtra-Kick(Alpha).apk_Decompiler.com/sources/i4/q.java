package i4;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;
import pa.e;
import ra.c;
import s4.i;

public final class q extends c {

    /* renamed from: h  reason: collision with root package name */
    public t f8257h;

    /* renamed from: i  reason: collision with root package name */
    public s4.q f8258i;

    /* renamed from: j  reason: collision with root package name */
    public i f8259j;

    /* renamed from: k  reason: collision with root package name */
    public i f8260k;

    /* renamed from: l  reason: collision with root package name */
    public Bitmap f8261l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f8262m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ t f8263n;

    /* renamed from: o  reason: collision with root package name */
    public int f8264o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(t tVar, e eVar) {
        super(eVar);
        this.f8263n = tVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f8262m = obj;
        this.f8264o |= RecyclerView.UNDEFINED_DURATION;
        return t.a(this.f8263n, (i) null, this);
    }
}
