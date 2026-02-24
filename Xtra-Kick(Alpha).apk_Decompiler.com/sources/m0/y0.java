package m0;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import b0.b0;
import e.a;
import java.util.Objects;

public final class y0 {
    private y0() {
    }

    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static i b(View view, i iVar) {
        ContentInfo s10 = iVar.f10099a.s();
        Objects.requireNonNull(s10);
        ContentInfo o10 = b0.o(s10);
        ContentInfo n10 = view.performReceiveContent(o10);
        if (n10 == null) {
            return null;
        }
        if (n10 == o10) {
            return iVar;
        }
        return new i(new a(n10));
    }

    public static void c(View view, String[] strArr, z zVar) {
        if (zVar == null) {
            view.setOnReceiveContentListener(strArr, (OnReceiveContentListener) null);
        } else {
            view.setOnReceiveContentListener(strArr, new z0(zVar));
        }
    }
}
