package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.support.v4.media.h;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import la.v;
import p9.b;
import t9.w;

public final class k1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f905h = 0;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f906i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f907j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f908k;

    public k1(TextView textView, Typeface typeface, int i10) {
        this.f907j = textView;
        this.f908k = typeface;
        this.f906i = i10;
    }

    public final void run() {
        switch (this.f905h) {
            case 0:
                ((TextView) this.f907j).setTypeface((Typeface) this.f908k, this.f906i);
                return;
            default:
                synchronized (((w) this.f907j).f14914a.f17664b) {
                    Iterator it = ((List) ((w) this.f907j).f14914a.f17670h).iterator();
                    if (!it.hasNext()) {
                        v vVar = v.f9814a;
                    } else {
                        h.y(it.next());
                        throw null;
                    }
                }
                return;
        }
    }

    public k1(w wVar, b bVar, int i10) {
        this.f907j = wVar;
        this.f908k = bVar;
        this.f906i = i10;
    }
}
