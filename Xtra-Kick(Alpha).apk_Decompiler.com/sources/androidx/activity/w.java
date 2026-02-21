package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import c6.b;
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import e6.s0;
import f6.d;
import la.v;
import wa.a;
import xa.k;

public final class w extends k implements a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f531h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f532i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f533j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f534k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f535l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        super(0);
        this.f531h = i10;
        this.f532i = obj;
        this.f533j = obj2;
        this.f534k = obj3;
        this.f535l = obj4;
    }

    public final Object b() {
        int i10 = this.f531h;
        Object obj = this.f535l;
        Object obj2 = this.f534k;
        Object obj3 = this.f533j;
        switch (i10) {
            case 0:
                View view = (View) this.f532i;
                view.getViewTreeObserver().removeOnScrollChangedListener((ViewTreeObserver.OnScrollChangedListener) obj3);
                view.removeOnLayoutChangeListener((View.OnLayoutChangeListener) obj2);
                view.removeOnAttachStateChangeListener((x) obj);
                return v.f9814a;
            default:
                return new d(((ChannelVideosViewModel) obj3).f3517j.f13360h, (s0) obj2, (b) obj);
        }
    }
}
