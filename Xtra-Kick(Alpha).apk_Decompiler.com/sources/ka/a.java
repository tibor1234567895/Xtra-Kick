package ka;

import dagger.Lazy;
import javax.inject.Provider;

public final class a implements Provider, Lazy {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f9256c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile Provider f9257a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f9258b = f9256c;

    public a(Provider provider) {
        this.f9257a = provider;
    }

    public static Provider a(Provider provider) {
        return provider instanceof a ? provider : new a(provider);
    }

    public final Object get() {
        boolean z10;
        Object obj = this.f9258b;
        Object obj2 = f9256c;
        if (obj == obj2) {
            synchronized (this) {
                obj = this.f9258b;
                if (obj == obj2) {
                    obj = this.f9257a.get();
                    Object obj3 = this.f9258b;
                    if (obj3 != obj2) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        if (obj3 != obj) {
                            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + obj + ". This is likely due to a circular dependency.");
                        }
                    }
                    this.f9258b = obj;
                    this.f9257a = null;
                }
            }
        }
        return obj;
    }
}
