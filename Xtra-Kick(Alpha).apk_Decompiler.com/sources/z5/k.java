package z5;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.flexbox.FlexboxLayout;
import p9.j;
import p9.s;
import q9.h;
import s9.b;
import t9.o;
import u9.a;
import u9.f;
import y9.l;
import y9.p;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final Object f17684a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f17685b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f17686c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f17687d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f17688e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f17689f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f17690g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f17691h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f17692i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f17693j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f17694k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f17695l;

    public k(CardView cardView, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, FlexboxLayout flexboxLayout, TextView textView2, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, ImageView imageView, TextView textView5, TextView textView6) {
        this.f17684a = cardView;
        this.f17685b = textView;
        this.f17691h = linearLayout;
        this.f17692i = linearLayout2;
        this.f17693j = flexboxLayout;
        this.f17686c = textView2;
        this.f17694k = constraintLayout;
        this.f17687d = textView3;
        this.f17688e = textView4;
        this.f17695l = imageView;
        this.f17689f = textView5;
        this.f17690g = textView6;
    }

    public k(j jVar, p pVar, h hVar, a aVar, l.h hVar2, Handler handler, s9.a aVar2, i iVar) {
        j jVar2 = jVar;
        p pVar2 = pVar;
        h hVar3 = hVar;
        a aVar3 = aVar;
        l.h hVar4 = hVar2;
        Handler handler2 = handler;
        i iVar2 = iVar;
        xa.j.g("handlerWrapper", pVar2);
        xa.j.g("fetchDatabaseManagerWrapper", hVar3);
        xa.j.g("downloadProvider", aVar3);
        xa.j.g("groupInfoProvider", hVar4);
        xa.j.g("uiHandler", handler2);
        xa.j.g("downloadManagerCoordinator", aVar2);
        xa.j.g("listenerCoordinator", iVar2);
        this.f17689f = jVar2;
        this.f17690g = pVar2;
        this.f17691h = hVar3;
        this.f17692i = aVar3;
        this.f17693j = hVar4;
        this.f17694k = handler2;
        this.f17695l = iVar2;
        a aVar4 = r2;
        a aVar5 = new a(hVar3, 0);
        this.f17686c = aVar5;
        w9.a aVar6 = r6;
        w9.a aVar7 = new w9.a(jVar2.f12676a);
        this.f17687d = aVar7;
        y9.h hVar5 = jVar2.f12681f;
        int i10 = jVar2.f12678c;
        long j10 = jVar2.f12679d;
        l lVar = jVar2.f12683h;
        boolean z10 = jVar2.f12685j;
        b bVar = new b(hVar5, i10, j10, lVar, aVar6, z10, aVar4, aVar2, iVar, jVar2.f12686k, jVar2.f12688m, jVar2.f12676a, jVar2.f12677b, hVar2, jVar2.f12692q, jVar2.f12693r);
        this.f17684a = bVar;
        l lVar2 = jVar2.f12683h;
        int i11 = jVar2.f12678c;
        Context context = jVar2.f12676a;
        f fVar = r2;
        Context context2 = context;
        f fVar2 = new f(pVar2, aVar3, bVar, aVar7, lVar2, iVar, i11, context2, jVar2.f12677b, jVar2.f12689n);
        this.f17685b = fVar;
        p9.p pVar3 = jVar2.f12682g;
        xa.j.g("<set-?>", pVar3);
        fVar.f15448i = pVar3;
        String str = jVar2.f12677b;
        l lVar3 = jVar2.f12683h;
        boolean z11 = jVar2.f12684i;
        y9.h hVar6 = jVar2.f12681f;
        p9.k kVar = jVar2.f12686k;
        y9.b bVar2 = jVar2.f12688m;
        s sVar = jVar2.f12689n;
        s sVar2 = sVar;
        y9.b bVar3 = bVar2;
        t9.a aVar8 = r1;
        t9.a aVar9 = new t9.a(str, hVar, bVar, fVar, lVar3, z11, hVar6, kVar, iVar, handler, bVar3, hVar2, sVar2, jVar2.f12691p);
        this.f17688e = aVar8;
        hVar.J(new o(this));
    }
}
