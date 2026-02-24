package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13910h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f13911i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Callback f13912j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f13913k;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Object obj, int i10) {
        this.f13910h = i10;
        this.f13911i = r12;
        this.f13912j = callback;
        this.f13913k = obj;
    }

    public final void run() {
        int i10 = this.f13910h;
        Callback callback = this.f13912j;
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r22 = this.f13911i;
        Object obj = this.f13913k;
        switch (i10) {
            case 0:
                r22.lambda$onResponse$0(callback, (Response) obj);
                return;
            default:
                r22.lambda$onFailure$1(callback, (Throwable) obj);
                return;
        }
    }
}
