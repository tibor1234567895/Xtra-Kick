package androidx.emoji2.text;

import java.util.concurrent.ThreadPoolExecutor;
import l.h;

public final class s extends n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n f1280a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f1281b;

    public s(n nVar, ThreadPoolExecutor threadPoolExecutor) {
        this.f1280a = nVar;
        this.f1281b = threadPoolExecutor;
    }

    public final void a(Throwable th) {
        ThreadPoolExecutor threadPoolExecutor = this.f1281b;
        try {
            this.f1280a.a(th);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    public final void b(h hVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f1281b;
        try {
            this.f1280a.b(hVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
