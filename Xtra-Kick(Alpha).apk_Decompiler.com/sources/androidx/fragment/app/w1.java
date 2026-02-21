package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.c1;
import m0.o0;

public final class w1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1592h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1593i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1594j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1595k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1596l;

    public w1(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1592h = i10;
        this.f1593i = arrayList;
        this.f1594j = arrayList2;
        this.f1595k = arrayList3;
        this.f1596l = arrayList4;
    }

    public final void run() {
        for (int i10 = 0; i10 < this.f1592h; i10++) {
            WeakHashMap weakHashMap = c1.f10054a;
            o0.v((View) this.f1593i.get(i10), (String) this.f1594j.get(i10));
            o0.v((View) this.f1595k.get(i10), (String) this.f1596l.get(i10));
        }
    }
}
