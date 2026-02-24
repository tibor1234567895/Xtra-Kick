package p1;

import android.media.MediaDrm;

public final /* synthetic */ class f0 implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h0 f12455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f12456b;

    public /* synthetic */ f0(h0 h0Var, g gVar) {
        this.f12455a = h0Var;
        this.f12456b = gVar;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
        h0 h0Var = this.f12455a;
        g gVar = this.f12456b;
        h0Var.getClass();
        h hVar = gVar.f12457a.f12495y;
        hVar.getClass();
        hVar.obtainMessage(i10, bArr).sendToTarget();
    }
}
