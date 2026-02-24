package p0;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import e.a;

public final class d extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f12405a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(InputConnection inputConnection, c cVar) {
        super(inputConnection, false);
        this.f12405a = cVar;
    }

    public final boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle) {
        a aVar = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            aVar = new a(15, (Object) new f(inputContentInfo));
        }
        if (this.f12405a.k(aVar, i10, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i10, bundle);
    }
}
