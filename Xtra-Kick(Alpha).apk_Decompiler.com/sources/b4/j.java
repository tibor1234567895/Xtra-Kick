package b4;

import android.view.View;
import java.util.ArrayList;

public final class j implements t {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f2548a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2549b;

    public j(View view, ArrayList arrayList) {
        this.f2548a = view;
        this.f2549b = arrayList;
    }

    public final void a(u uVar) {
        uVar.v(this);
        this.f2548a.setVisibility(8);
        ArrayList arrayList = this.f2549b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((View) arrayList.get(i10)).setVisibility(0);
        }
    }

    public final void b(u uVar) {
        uVar.v(this);
        uVar.a(this);
    }

    public final void c() {
    }

    public final void d() {
    }

    public final void e() {
    }
}
