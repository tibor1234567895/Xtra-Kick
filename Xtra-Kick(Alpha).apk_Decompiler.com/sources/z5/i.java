package z5;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.andreyasadchy.xtra.util.TextWithCanvas;
import com.google.android.flexbox.FlexboxLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l.h;
import la.v;
import p9.l;
import t9.q;
import t9.w;
import u9.a;
import xa.j;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17663a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f17664b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f17665c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f17666d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f17667e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f17668f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f17669g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f17670h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f17671i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f17672j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f17673k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f17674l;

    public i(CardView cardView, TextView textView, ImageView imageView, TextView textView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView3, FlexboxLayout flexboxLayout, ConstraintLayout constraintLayout, TextView textView4, TextView textView5) {
        this.f17664b = cardView;
        this.f17665c = textView;
        this.f17667e = imageView;
        this.f17668f = textView2;
        this.f17673k = linearLayout;
        this.f17674l = linearLayout2;
        this.f17670h = textView3;
        this.f17666d = flexboxLayout;
        this.f17669g = constraintLayout;
        this.f17671i = textView4;
        this.f17672j = textView5;
    }

    public final void a(int i10, l lVar) {
        synchronized (this.f17664b) {
            Set set = (Set) ((Map) this.f17665c).get(Integer.valueOf(i10));
            if (set == null) {
                set = new LinkedHashSet();
            }
            set.add(new WeakReference(lVar));
            ((Map) this.f17665c).put(Integer.valueOf(i10), set);
            v vVar = v.f9814a;
        }
    }

    public final void b() {
        synchronized (this.f17664b) {
            ((Map) this.f17665c).clear();
            ((Map) this.f17668f).clear();
            ((List) this.f17670h).clear();
            ((Map) this.f17672j).clear();
            v vVar = v.f9814a;
        }
    }

    public final CardView c() {
        int i10 = this.f17663a;
        Object obj = this.f17664b;
        switch (i10) {
            case 0:
                return (CardView) obj;
            default:
                return (CardView) obj;
        }
    }

    public final void d(int i10, l lVar) {
        j.g("fetchListener", lVar);
        synchronized (this.f17664b) {
            Set set = (Set) ((Map) this.f17665c).get(Integer.valueOf(i10));
            Iterator it = set != null ? set.iterator() : null;
            if (it != null) {
                while (true) {
                    if (it.hasNext()) {
                        if (j.a((l) ((WeakReference) it.next()).get(), lVar)) {
                            it.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            v vVar = v.f9814a;
        }
    }

    public i(CardView cardView, TextView textView, FlexboxLayout flexboxLayout, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout, TextWithCanvas textWithCanvas, TextWithCanvas textWithCanvas2, ImageView imageView2, TextView textView3, TextWithCanvas textWithCanvas3) {
        this.f17664b = cardView;
        this.f17665c = textView;
        this.f17666d = flexboxLayout;
        this.f17667e = imageView;
        this.f17668f = textView2;
        this.f17669g = constraintLayout;
        this.f17671i = textWithCanvas;
        this.f17672j = textWithCanvas2;
        this.f17673k = imageView2;
        this.f17670h = textView3;
        this.f17674l = textWithCanvas3;
    }

    public i(NestedScrollView nestedScrollView, RecyclerView recyclerView, TextView textView, RecyclerView recyclerView2, TextView textView2, NestedScrollView nestedScrollView2, TextView textView3, RecyclerView recyclerView3, TextView textView4, RecyclerView recyclerView4, TextView textView5) {
        this.f17664b = nestedScrollView;
        this.f17667e = recyclerView;
        this.f17665c = textView;
        this.f17673k = recyclerView2;
        this.f17668f = textView2;
        this.f17674l = nestedScrollView2;
        this.f17670h = textView3;
        this.f17666d = recyclerView3;
        this.f17671i = textView4;
        this.f17669g = recyclerView4;
        this.f17672j = textView5;
    }

    public i(String str, h hVar, a aVar, Handler handler) {
        j.g("namespace", str);
        j.g("uiHandler", handler);
        this.f17673k = str;
        this.f17674l = hVar;
        this.f17666d = aVar;
        this.f17669g = handler;
        this.f17664b = new Object();
        this.f17665c = new LinkedHashMap();
        this.f17668f = new LinkedHashMap();
        this.f17670h = new ArrayList();
        this.f17671i = (Handler) q.f14900h.b();
        this.f17672j = new LinkedHashMap();
        this.f17667e = new w(this);
    }
}
