package p1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import j1.l0;
import java.util.Arrays;
import java.util.Iterator;

public final class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f12458a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(k kVar, Looper looper) {
        super(looper);
        this.f12458a = kVar;
    }

    public final void handleMessage(Message message) {
        byte[] bArr = (byte[]) message.obj;
        if (bArr != null) {
            Iterator it = this.f12458a.f12483m.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                eVar.p();
                if (Arrays.equals(eVar.f12444v, bArr)) {
                    if (message.what == 2 && eVar.f12427e == 0 && eVar.f12438p == 4) {
                        int i10 = l0.f8453a;
                        eVar.i(false);
                        return;
                    }
                    return;
                }
            }
        }
    }
}
