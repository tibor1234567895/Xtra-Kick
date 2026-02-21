package androidx.emoji2.text;

import j1.l0;
import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1242a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f1243b;

    public /* synthetic */ a(String str, int i10) {
        this.f1242a = i10;
        this.f1243b = str;
    }

    public final Thread newThread(Runnable runnable) {
        int i10 = this.f1242a;
        String str = this.f1243b;
        switch (i10) {
            case 0:
                Thread thread = new Thread(runnable, str);
                thread.setPriority(10);
                return thread;
            default:
                int i11 = l0.f8453a;
                return new Thread(runnable, str);
        }
    }
}
