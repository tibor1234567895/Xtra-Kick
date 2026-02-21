package jb;

import h3.u1;
import hb.h0;
import hb.k;
import wa.l;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final l f8900a = new l(-1, (l) null, (c) null, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final int f8901b = h0.N1("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: c  reason: collision with root package name */
    public static final int f8902c = h0.N1("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: d  reason: collision with root package name */
    public static final u1 f8903d = new u1("BUFFERED", 2);

    /* renamed from: e  reason: collision with root package name */
    public static final u1 f8904e = new u1("SHOULD_BUFFER", 2);

    /* renamed from: f  reason: collision with root package name */
    public static final u1 f8905f = new u1("S_RESUMING_BY_RCV", 2);

    /* renamed from: g  reason: collision with root package name */
    public static final u1 f8906g = new u1("RESUMING_BY_EB", 2);

    /* renamed from: h  reason: collision with root package name */
    public static final u1 f8907h = new u1("POISONED", 2);

    /* renamed from: i  reason: collision with root package name */
    public static final u1 f8908i = new u1("DONE_RCV", 2);

    /* renamed from: j  reason: collision with root package name */
    public static final u1 f8909j = new u1("INTERRUPTED_SEND", 2);

    /* renamed from: k  reason: collision with root package name */
    public static final u1 f8910k = new u1("INTERRUPTED_RCV", 2);

    /* renamed from: l  reason: collision with root package name */
    public static final u1 f8911l = new u1("CHANNEL_CLOSED", 2);

    /* renamed from: m  reason: collision with root package name */
    public static final u1 f8912m = new u1("SUSPEND", 2);

    /* renamed from: n  reason: collision with root package name */
    public static final u1 f8913n = new u1("SUSPEND_NO_WAITER", 2);

    /* renamed from: o  reason: collision with root package name */
    public static final u1 f8914o = new u1("FAILED", 2);

    /* renamed from: p  reason: collision with root package name */
    public static final u1 f8915p = new u1("NO_RECEIVE_RESULT", 2);

    /* renamed from: q  reason: collision with root package name */
    public static final u1 f8916q = new u1("CLOSE_HANDLER_CLOSED", 2);

    /* renamed from: r  reason: collision with root package name */
    public static final u1 f8917r = new u1("CLOSE_HANDLER_INVOKED", 2);

    /* renamed from: s  reason: collision with root package name */
    public static final u1 f8918s = new u1("NO_CLOSE_CAUSE", 2);

    public static final boolean a(k kVar, Object obj, l lVar) {
        u1 f10 = kVar.f(obj, lVar);
        if (f10 == null) {
            return false;
        }
        kVar.n(f10);
        return true;
    }
}
