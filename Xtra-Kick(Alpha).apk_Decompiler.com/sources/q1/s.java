package q1;

import e.a;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13241h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f13242i;

    public /* synthetic */ s(int i10, Object obj) {
        this.f13241h = i10;
        this.f13242i = obj;
    }

    public final void run() {
        int i10 = this.f13241h;
        Object obj = this.f13242i;
        switch (i10) {
            case 0:
                ((v) obj).A();
                return;
            case 1:
                v vVar = (v) obj;
                vVar.J = true;
                vVar.A();
                return;
            default:
                ((a) obj).H();
                return;
        }
    }
}
