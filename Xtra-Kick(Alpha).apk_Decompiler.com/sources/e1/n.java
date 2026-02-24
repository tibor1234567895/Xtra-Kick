package e1;

import android.os.Messenger;
import java.util.ArrayList;

public class n implements k {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f4929a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public m f4930b;

    /* renamed from: c  reason: collision with root package name */
    public Messenger f4931c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a0 f4932d;

    public n(a0 a0Var) {
        this.f4932d = a0Var;
    }

    public c0 a() {
        j jVar = this.f4932d.f4891l;
        if (jVar != null) {
            return jVar.f4919d;
        }
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
    }

    public void onCreate() {
        m mVar = new m(this, this.f4932d);
        this.f4930b = mVar;
        mVar.onCreate();
    }
}
