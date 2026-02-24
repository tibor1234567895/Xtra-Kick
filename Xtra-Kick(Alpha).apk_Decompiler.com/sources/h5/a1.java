package h5;

import android.content.ContentResolver;
import android.net.Uri;
import b5.n;
import com.bumptech.glide.load.data.a;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.data.q;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import v5.b;

public final class a1 implements i0 {

    /* renamed from: b  reason: collision with root package name */
    public static final Set f7552b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "content", "android.resource"})));

    /* renamed from: a  reason: collision with root package name */
    public final z0 f7553a;

    public a1(z0 z0Var) {
        this.f7553a = z0Var;
    }

    public final h0 a(Object obj, int i10, int i11, n nVar) {
        e eVar;
        Uri uri = (Uri) obj;
        b bVar = new b(uri);
        y0 y0Var = (y0) this.f7553a;
        int i12 = y0Var.f7627a;
        ContentResolver contentResolver = y0Var.f7628b;
        switch (i12) {
            case 0:
                eVar = new a(contentResolver, uri, 0);
                break;
            case 1:
                eVar = new a(contentResolver, uri, 1);
                break;
            default:
                eVar = new q(contentResolver, uri);
                break;
        }
        return new h0(bVar, eVar);
    }

    public final boolean b(Object obj) {
        return f7552b.contains(((Uri) obj).getScheme());
    }
}
