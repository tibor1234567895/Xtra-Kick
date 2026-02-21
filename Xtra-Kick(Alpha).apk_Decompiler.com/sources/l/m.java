package l;

import android.view.View;
import androidx.appcompat.widget.d5;
import m0.o1;
import m0.p1;

public final class m extends p1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f9488a = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9489b;

    /* renamed from: c  reason: collision with root package name */
    public int f9490c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f9491d;

    public m(d5 d5Var, int i10) {
        this.f9491d = d5Var;
        this.f9490c = i10;
        this.f9489b = false;
    }

    public final void a() {
        int i10 = this.f9488a;
        Object obj = this.f9491d;
        switch (i10) {
            case 0:
                int i11 = this.f9490c + 1;
                this.f9490c = i11;
                n nVar = (n) obj;
                if (i11 == nVar.f9492a.size()) {
                    o1 o1Var = nVar.f9495d;
                    if (o1Var != null) {
                        o1Var.a();
                    }
                    this.f9490c = 0;
                    this.f9489b = false;
                    nVar.f9496e = false;
                    return;
                }
                return;
            default:
                if (!this.f9489b) {
                    ((d5) obj).f791a.setVisibility(this.f9490c);
                    return;
                }
                return;
        }
    }

    public final void b(View view) {
        switch (this.f9488a) {
            case 1:
                this.f9489b = true;
                return;
            default:
                return;
        }
    }

    public final void c() {
        int i10 = this.f9488a;
        Object obj = this.f9491d;
        switch (i10) {
            case 0:
                if (!this.f9489b) {
                    this.f9489b = true;
                    o1 o1Var = ((n) obj).f9495d;
                    if (o1Var != null) {
                        o1Var.c();
                        return;
                    }
                    return;
                }
                return;
            default:
                ((d5) obj).f791a.setVisibility(0);
                return;
        }
    }

    public m(n nVar) {
        this.f9491d = nVar;
        this.f9489b = false;
        this.f9490c = 0;
    }
}
