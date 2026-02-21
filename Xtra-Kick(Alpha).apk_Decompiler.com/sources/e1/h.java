package e1;

import android.os.Bundle;
import android.os.Messenger;

public final class h implements k {

    /* renamed from: a  reason: collision with root package name */
    public Object f4907a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f4908b;

    public h(Bundle bundle, String str) {
        if (str != null) {
            this.f4907a = str;
            this.f4908b = bundle;
            return;
        }
        throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
    }

    public final c0 a() {
        Object obj = this.f4908b;
        if (((a0) obj).f4891l != null) {
            return ((a0) obj).f4891l.f4919d;
        }
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    public final void onCreate() {
        this.f4907a = new Messenger(((a0) this.f4908b).f4892m);
    }
}
