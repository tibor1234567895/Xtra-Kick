package t9;

import p9.f;

public final class e implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f14846h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f14847i;

    public /* synthetic */ e(int i10, Object obj) {
        this.f14846h = i10;
        this.f14847i = obj;
    }

    public final void run() {
        int i10 = this.f14846h;
        Object obj = this.f14847i;
        switch (i10) {
            case 0:
                m mVar = (m) obj;
                if (!mVar.c()) {
                    a aVar = mVar.f14883j;
                    mVar.f14882i.post(new d(this, aVar.v(true), aVar.v(false)));
                    return;
                }
                return;
            default:
                i iVar = ((i) obj).f14858b;
                if (iVar != null) {
                    iVar.a(f.ENQUEUE_NOT_SUCCESSFUL);
                    return;
                }
                return;
        }
    }
}
