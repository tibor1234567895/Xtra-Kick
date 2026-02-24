package p0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

public final class f implements g {

    /* renamed from: h  reason: collision with root package name */
    public final InputContentInfo f12407h;

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        a.e();
        this.f12407h = a.c(uri, clipDescription, uri2);
    }

    public final Object f() {
        return this.f12407h;
    }

    public final Uri g() {
        return this.f12407h.getContentUri();
    }

    public final ClipDescription getDescription() {
        return this.f12407h.getDescription();
    }

    public final void h() {
        this.f12407h.requestPermission();
    }

    public final Uri i() {
        return this.f12407h.getLinkUri();
    }

    public f(Object obj) {
        this.f12407h = a.d(obj);
    }
}
