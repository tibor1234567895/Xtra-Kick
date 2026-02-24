package m0;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import b0.b0;
import e.a;

public final class e implements f {

    /* renamed from: h  reason: collision with root package name */
    public final ContentInfo.Builder f10070h;

    public e(ClipData clipData, int i10) {
        b0.p();
        this.f10070h = b0.l(clipData, i10);
    }

    public final i a() {
        return new i(new a(this.f10070h.build()));
    }

    public final void c(Bundle bundle) {
        this.f10070h.setExtras(bundle);
    }

    public final void e(Uri uri) {
        this.f10070h.setLinkUri(uri);
    }

    public final void g(int i10) {
        this.f10070h.setFlags(i10);
    }
}
