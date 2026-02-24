package fb;

import androidx.fragment.app.k;
import cb.e;
import cb.l;
import eb.q;
import java.util.Iterator;
import java.util.regex.Matcher;
import m0.h1;
import ma.a;
import xa.j;

public final class g extends a {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ h f6003h;

    public g(h hVar) {
        this.f6003h = hVar;
    }

    public final int a() {
        return this.f6003h.f6004a.groupCount() + 1;
    }

    public final f b(int i10) {
        h hVar = this.f6003h;
        Matcher matcher = hVar.f6004a;
        e c10 = l.c(matcher.start(i10), matcher.end(i10));
        if (Integer.valueOf(c10.f3063h).intValue() < 0) {
            return null;
        }
        String group = hVar.f6004a.group(i10);
        j.e("matchResult.group(index)", group);
        return new f(group, c10);
    }

    public final /* bridge */ boolean contains(Object obj) {
        boolean z10;
        if (obj == null) {
            z10 = true;
        } else {
            z10 = obj instanceof f;
        }
        if (!z10) {
            return false;
        }
        return super.contains((f) obj);
    }

    public final boolean isEmpty() {
        return false;
    }

    public final Iterator iterator() {
        return q.c(new h1(1, new e(0, size() - 1)), new k(18, this)).iterator();
    }
}
