package p1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.n;
import android.util.Pair;
import d9.p0;
import d9.r0;
import j1.l0;
import java.util.Set;

public final class c extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f12418a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(e eVar, Looper looper) {
        super(looper);
        this.f12418a = eVar;
    }

    public final void handleMessage(Message message) {
        i1.c cVar;
        Pair pair = (Pair) message.obj;
        Object obj = pair.first;
        Object obj2 = pair.second;
        int i10 = message.what;
        e eVar = this.f12418a;
        if (i10 != 0) {
            if (i10 == 1 && obj == eVar.f12446x && eVar.j()) {
                eVar.f12446x = null;
                if (obj2 instanceof Exception) {
                    eVar.l((Exception) obj2, false);
                    return;
                }
                try {
                    byte[] bArr = (byte[]) obj2;
                    c0 c0Var = eVar.f12424b;
                    int i11 = eVar.f12427e;
                    if (i11 == 3) {
                        byte[] bArr2 = eVar.f12445w;
                        int i12 = l0.f8453a;
                        c0Var.e(bArr2, bArr);
                        cVar = new i1.c(7);
                    } else {
                        byte[] e10 = c0Var.e(eVar.f12444v, bArr);
                        if (!((i11 != 2 && (i11 != 0 || eVar.f12445w == null)) || e10 == null || e10.length == 0)) {
                            eVar.f12445w = e10;
                        }
                        eVar.f12438p = 4;
                        cVar = new i1.c(8);
                    }
                    eVar.h(cVar);
                } catch (Exception e11) {
                    eVar.l(e11, true);
                }
            }
        } else if (obj != eVar.f12447y) {
        } else {
            if (eVar.f12438p == 2 || eVar.j()) {
                eVar.f12447y = null;
                boolean z10 = obj2 instanceof Exception;
                n nVar = eVar.f12425c;
                if (z10) {
                    nVar.y((Exception) obj2, false);
                    return;
                }
                try {
                    eVar.f12424b.g((byte[]) obj2);
                    nVar.f338j = null;
                    r0 j10 = r0.j((Set) nVar.f337i);
                    ((Set) nVar.f337i).clear();
                    p0 l10 = j10.listIterator(0);
                    while (l10.hasNext()) {
                        e eVar2 = (e) l10.next();
                        if (eVar2.m()) {
                            eVar2.i(true);
                        }
                    }
                } catch (Exception e12) {
                    nVar.y(e12, true);
                }
            }
        }
    }
}
