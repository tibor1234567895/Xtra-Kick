package e1;

import android.media.VolumeProvider;
import h3.x3;
import h3.y3;
import j1.l0;

public final class j0 extends VolumeProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y3 f4924a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(y3 y3Var, int i10, int i11, int i12, String str) {
        super(i10, i11, i12, str);
        this.f4924a = y3Var;
    }

    public final void onAdjustVolume(int i10) {
        y3 y3Var = this.f4924a;
        y3Var.getClass();
        l0.L(y3Var.f7494e, new x3(y3Var, i10, 0));
    }

    public final void onSetVolumeTo(int i10) {
        y3 y3Var = this.f4924a;
        y3Var.getClass();
        l0.L(y3Var.f7494e, new x3(y3Var, i10, 1));
    }
}
