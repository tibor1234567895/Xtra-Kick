package q6;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.LocalFollowGame;
import com.github.andreyasadchy.xtra.ui.games.GamePagerViewModel;
import e6.a1;
import e6.e1;
import hb.d1;
import hb.f0;
import hb.h0;
import hb.p0;
import java.io.File;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;

public final class n extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public String f13378i;

    /* renamed from: j  reason: collision with root package name */
    public int f13379j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f13380k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Context f13381l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ GamePagerViewModel f13382m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f13383n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ String f13384o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(int i10, Context context, GamePagerViewModel gamePagerViewModel, String str, String str2, e eVar) {
        super(2, eVar);
        this.f13380k = i10;
        this.f13381l = context;
        this.f13382m = gamePagerViewModel;
        this.f13383n = str;
        this.f13384o = str2;
    }

    public final e create(Object obj, e eVar) {
        return new n(this.f13380k, this.f13381l, this.f13382m, this.f13383n, this.f13384o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((n) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f13379j;
        GamePagerViewModel gamePagerViewModel = this.f13382m;
        if (i10 == 0) {
            h0.O1(obj);
            int i11 = this.f13380k;
            if (i11 != 0) {
                String file = this.f13381l.getFilesDir().toString();
                String str2 = File.separator;
                String absolutePath = new File(file + str2 + "box_art" + str2 + i11 + ".png").getAbsolutePath();
                e1 e1Var = gamePagerViewModel.f3422d;
                this.f13378i = absolutePath;
                this.f13379j = 1;
                e1Var.getClass();
                obj = h0.c2(p0.f7834b, new a1(e1Var, i11, (e) null), this);
                if (obj == aVar) {
                    return aVar;
                }
                str = absolutePath;
            }
            return v.f9814a;
        } else if (i10 == 1) {
            str = this.f13378i;
            h0.O1(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LocalFollowGame localFollowGame = (LocalFollowGame) obj;
        if (localFollowGame != null) {
            e1 e1Var2 = gamePagerViewModel.f3422d;
            localFollowGame.setGameName(this.f13383n);
            localFollowGame.setGameSlug(this.f13384o);
            localFollowGame.setBoxArt(str);
            e1Var2.getClass();
            h0.b1(d1.f7786h, (h) null, 0, new e6.d1(e1Var2, localFollowGame, (e) null), 3);
        }
        return v.f9814a;
    }
}
