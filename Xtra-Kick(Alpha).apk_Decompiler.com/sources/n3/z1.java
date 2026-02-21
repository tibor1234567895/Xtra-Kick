package n3;

import android.content.Context;
import androidx.lifecycle.p1;
import com.github.andreyasadchy.xtra.ui.follow.channels.FollowedChannelsViewModel;
import com.github.andreyasadchy.xtra.ui.streams.common.StreamsViewModel;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import hb.h0;
import hb.l1;
import kb.j;
import la.v;
import o6.l;
import o6.n;
import pa.e;
import qa.a;
import ra.i;
import wa.q;

public final class z1 extends i implements q {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f11602i;

    /* renamed from: j  reason: collision with root package name */
    public int f11603j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ j f11604k;

    /* renamed from: l  reason: collision with root package name */
    public /* synthetic */ Object f11605l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Object f11606m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Object f11607n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z1(e eVar, Object obj, Object obj2, int i10) {
        super(3, eVar);
        this.f11602i = i10;
        this.f11606m = obj;
        this.f11607n = obj2;
    }

    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3) {
        switch (this.f11602i) {
            case 0:
                return l((j) obj, obj2, (e) obj3);
            case 1:
                return l((j) obj, obj2, (e) obj3);
            case 2:
                return l((j) obj, obj2, (e) obj3);
            default:
                return l((j) obj, obj2, (e) obj3);
        }
    }

    public final Object invokeSuspend(Object obj) {
        kb.i iVar;
        r3 r3Var;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f11602i;
        Object obj2 = this.f11607n;
        Object obj3 = this.f11606m;
        switch (i10) {
            case 0:
                int i11 = this.f11603j;
                if (i11 == 0) {
                    h0.O1(obj);
                    j jVar = this.f11604k;
                    t1 t1Var = (t1) this.f11605l;
                    i2 i2Var = (i2) obj3;
                    g3 g3Var = t1Var.f11486a;
                    d5 d5Var = (d5) obj2;
                    i2Var.getClass();
                    if (d5Var == null) {
                        iVar = g3Var.f11207n;
                    } else {
                        h2 h2Var = new h2(d5Var, g3Var, new h1(), (e) null);
                        l1 l1Var = t1Var.f11488c;
                        xa.j.f("controller", l1Var);
                        iVar = h0.G1(new x(l1Var, h2Var, (e) null));
                    }
                    u3 u3Var = new u3(iVar, new u1(i2Var, t1Var.f11486a, i2Var.f11254e));
                    this.f11603j = 1;
                    if (jVar.a(u3Var, this) == aVar) {
                        return aVar;
                    }
                } else if (i11 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
            case 1:
                int i12 = this.f11603j;
                if (i12 == 0) {
                    h0.O1(obj);
                    FollowedChannelsViewModel followedChannelsViewModel = (FollowedChannelsViewModel) obj3;
                    Context context = (Context) obj2;
                    this.f11603j = 1;
                    if (h0.Q(this.f11604k, (kb.i) new e.a(new r3(15, 5, 15), (wa.a) new n(followedChannelsViewModel, context, (l) this.f11605l)).f4852i, this) == aVar) {
                        return aVar;
                    }
                } else if (i12 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
            case 2:
                int i13 = this.f11603j;
                if (i13 == 0) {
                    h0.O1(obj);
                    j jVar2 = this.f11604k;
                    j7.i iVar2 = (j7.i) this.f11605l;
                    if (xa.j.a(h0.l1((Context) obj3).getString("compactStreamsV2", "disabled"), "all")) {
                        r3Var = new r3(30, 10, 30);
                    } else {
                        r3Var = new r3(30, 3, 30);
                    }
                    this.f11603j = 1;
                    if (h0.Q(jVar2, (kb.i) new e.a(r3Var, (wa.a) new p1(18, (StreamsViewModel) obj2)).f4852i, this) == aVar) {
                        return aVar;
                    }
                } else if (i13 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
            default:
                int i14 = this.f11603j;
                if (i14 == 0) {
                    h0.O1(obj);
                    this.f11603j = 1;
                    if (h0.Q(this.f11604k, (kb.i) new e.a(new r3(30, 3, 30), (wa.a) new y3((p7.e) this.f11605l, (Context) obj3, (GameVideosViewModel) obj2, 1)).f4852i, this) == aVar) {
                        return aVar;
                    }
                } else if (i14 == 1) {
                    h0.O1(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return v.f9814a;
        }
    }

    public final Object l(j jVar, Object obj, e eVar) {
        int i10 = this.f11602i;
        Object obj2 = this.f11607n;
        Object obj3 = this.f11606m;
        switch (i10) {
            case 0:
                z1 z1Var = new z1(eVar, (i2) obj3, (d5) obj2, 0);
                z1Var.f11604k = jVar;
                z1Var.f11605l = obj;
                return z1Var.invokeSuspend(v.f9814a);
            case 1:
                z1 z1Var2 = new z1(eVar, (FollowedChannelsViewModel) obj3, (Context) obj2, 1);
                z1Var2.f11604k = jVar;
                z1Var2.f11605l = obj;
                return z1Var2.invokeSuspend(v.f9814a);
            case 2:
                z1 z1Var3 = new z1(eVar, (Context) obj3, (StreamsViewModel) obj2, 2);
                z1Var3.f11604k = jVar;
                z1Var3.f11605l = obj;
                return z1Var3.invokeSuspend(v.f9814a);
            default:
                z1 z1Var4 = new z1(eVar, (Context) obj3, (GameVideosViewModel) obj2, 3);
                z1Var4.f11604k = jVar;
                z1Var4.f11605l = obj;
                return z1Var4.invokeSuspend(v.f9814a);
        }
    }
}
