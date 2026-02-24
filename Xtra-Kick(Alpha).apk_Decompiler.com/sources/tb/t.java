package tb;

import android.support.v4.media.h;
import cc.g;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import la.v;
import pb.r1;
import sb.a;
import xa.j;

public final class t extends a {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f15020e = 1;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Object f15021f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(g gVar) {
        super(h.p(new StringBuilder(), gVar.f3105m, " writer"), true);
        this.f15021f = gVar;
    }

    public final long a() {
        r rVar = null;
        switch (this.f15020e) {
            case 0:
                u uVar = (u) this.f15021f;
                long nanoTime = System.nanoTime();
                Iterator it = uVar.f15026e.iterator();
                int i10 = 0;
                long j10 = Long.MIN_VALUE;
                int i11 = 0;
                while (it.hasNext()) {
                    r rVar2 = (r) it.next();
                    j.e("connection", rVar2);
                    synchronized (rVar2) {
                        if (uVar.a(rVar2, nanoTime) <= 0) {
                            i10++;
                            long j11 = nanoTime - rVar2.f15019s;
                            if (j11 > j10) {
                                j10 = j11;
                                rVar = rVar2;
                            }
                            v vVar = v.f9814a;
                            break;
                        } else {
                            i11++;
                            break;
                        }
                    }
                }
                long j12 = uVar.f15023b;
                if (j10 >= j12 || i10 > uVar.f15022a) {
                    j.c(rVar);
                    synchronized (rVar) {
                        if (!(!rVar.f15018r.isEmpty())) {
                            if (rVar.f15019s + j10 == nanoTime) {
                                rVar.f15012l = true;
                                uVar.f15026e.remove(rVar);
                                Socket socket = rVar.f15005e;
                                j.c(socket);
                                qb.h.c(socket);
                                if (uVar.f15026e.isEmpty()) {
                                    uVar.f15024c.a();
                                }
                            }
                        }
                    }
                    return 0;
                } else if (i10 > 0) {
                    return j12 - j10;
                } else {
                    if (i11 > 0) {
                        return j12;
                    }
                    return -1;
                }
            default:
                Object obj = this.f15021f;
                try {
                    if (((g) obj).i()) {
                        return 0;
                    }
                } catch (IOException e10) {
                    ((g) obj).c(e10, (r1) null);
                }
                return -1;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(u uVar, String str) {
        super(str, true);
        this.f15021f = uVar;
    }
}
