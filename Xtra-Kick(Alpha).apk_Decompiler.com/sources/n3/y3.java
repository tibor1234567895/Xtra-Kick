package n3;

import android.content.Context;
import bc.e;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import com.woxthebox.draglistview.R;
import f6.u;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import la.v;
import ma.p;
import ma.s;
import pb.m;
import pb.m0;
import wa.a;
import xa.j;
import xa.k;
import xa.q;

public final class y3 extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f11586h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f11587i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f11588j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f11589k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y3(Object obj, Object obj2, Object obj3, int i10) {
        super(0);
        this.f11586h = i10;
        this.f11587i = obj;
        this.f11588j = obj2;
        this.f11589k = obj3;
    }

    public final List a() {
        List<Certificate> list;
        int i10 = this.f11586h;
        Object obj = this.f11589k;
        Object obj2 = this.f11588j;
        Object obj3 = this.f11587i;
        switch (i10) {
            case 2:
                e eVar = ((m) obj3).f12902b;
                if (eVar == null || (list = eVar.a((String) obj, (List) obj2)) == null) {
                    list = (List) obj2;
                }
                ArrayList arrayList = new ArrayList(s.i(list));
                for (Certificate certificate : list) {
                    j.d("null cannot be cast to non-null type java.security.cert.X509Certificate", certificate);
                    arrayList.add((X509Certificate) certificate);
                }
                return arrayList;
            default:
                e eVar2 = ((m) obj3).f12902b;
                j.c(eVar2);
                return eVar2.a(((pb.a) obj).f12763i.f12992d, ((m0) obj2).a());
        }
    }

    public final Object b() {
        String str;
        int i10 = this.f11586h;
        Object obj = this.f11589k;
        Object obj2 = this.f11588j;
        Object obj3 = this.f11587i;
        switch (i10) {
            case 0:
                ((g) obj3).f11166c = (n3) obj2;
                ((q) obj).f16814h = true;
                return v.f9814a;
            case 1:
                p7.e eVar = (p7.e) obj3;
                GameVideosViewModel gameVideosViewModel = (GameVideosViewModel) obj;
                String[] stringArray = ((Context) obj2).getResources().getStringArray(R.array.gqlUserLanguageValues);
                j.e("context.resources.getStr…ay.gqlUserLanguageValues)", stringArray);
                List j10 = p.j(stringArray);
                int i11 = eVar.f12606e;
                if (i11 != 0) {
                    str = (String) j10.get(i11);
                } else {
                    str = null;
                }
                int i12 = gameVideosViewModel.f3526j.f13353a;
                if (str != null) {
                    j.e("this as java.lang.String).toLowerCase(Locale.ROOT)", str.toLowerCase(Locale.ROOT));
                }
                if (str != null) {
                    ma.q.b(str);
                }
                BroadcastTypeEnum broadcastTypeEnum = BroadcastTypeEnum.ALL;
                BroadcastTypeEnum broadcastTypeEnum2 = eVar.f12605d;
                if (broadcastTypeEnum2 != broadcastTypeEnum) {
                    j.e("this as java.lang.String).toUpperCase(Locale.ROOT)", broadcastTypeEnum2.getValue().toUpperCase(Locale.ROOT));
                }
                VideoSortEnum videoSortEnum = eVar.f12603b;
                j.e("this as java.lang.String).toUpperCase(Locale.ROOT)", videoSortEnum.getValue().toUpperCase(Locale.ROOT));
                return new u(eVar.f12604c, broadcastTypeEnum2, videoSortEnum);
            case 2:
                return a();
            default:
                return a();
        }
    }
}
