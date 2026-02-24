package q6;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.c;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import e6.c1;
import e6.e1;
import hb.f0;
import hb.h0;
import hb.p0;
import java.io.File;
import la.v;
import pa.e;
import qa.a;
import ra.i;
import wa.p;

public final class m extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f13371i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f13372j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f13373k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f13374l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ GamePagerViewModel f13375m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f13376n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f13377o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(int i10, String str, Context context, GamePagerViewModel gamePagerViewModel, String str2, String str3, e eVar) {
        super(2, eVar);
        this.f13372j = i10;
        this.f13373k = str;
        this.f13374l = context;
        this.f13375m = gamePagerViewModel;
        this.f13376n = str2;
        this.f13377o = str3;
    }

    public final e create(Object obj, e eVar) {
        return new m(this.f13372j, this.f13373k, this.f13374l, this.f13375m, this.f13376n, this.f13377o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((m) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Context context = this.f13374l;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f13371i;
        GamePagerViewModel gamePagerViewModel = this.f13375m;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f13372j;
            if (i11 != 0) {
                try {
                    String str = this.f13373k;
                    if (str != null) {
                        c.e(context).m().F(str).D(new l(context, i11));
                    }
                } catch (Exception e10) {
                    Log.e("NOP", "error", e10);
                }
                String file = context.getFilesDir().toString();
                String str2 = File.separator;
                String absolutePath = new File(file + str2 + "box_art" + str2 + i11 + ".png").getAbsolutePath();
                e1 e1Var = gamePagerViewModel.f3422d;
                LocalFollowGame localFollowGame = new LocalFollowGame(new Integer(i11), this.f13376n, this.f13377o, absolutePath);
                this.f13371i = 1;
                e1Var.getClass();
                Object c22 = h0.c2(p0.f7834b, new c1(e1Var, localFollowGame, (e) null), this);
                if (c22 != aVar) {
                    c22 = v.f9814a;
                }
                if (c22 == aVar) {
                    return aVar;
                }
            }
            return v.f9814a;
        } else if (i10 == 1) {
            try {
                h0.O1(obj);
            } catch (Exception unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        gamePagerViewModel.f3423e.j(new la.i(Boolean.TRUE, (Object) null));
        return v.f9814a;
    }
}
