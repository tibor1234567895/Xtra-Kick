package i0;

import android.os.LocaleList;
import g.a0;
import java.util.Locale;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public final LocaleList f7951a;

    public l(Object obj) {
        this.f7951a = a0.i(obj);
    }

    public final String a() {
        return this.f7951a.toLanguageTags();
    }

    public final Object b() {
        return this.f7951a;
    }

    public final boolean equals(Object obj) {
        return this.f7951a.equals(((k) obj).b());
    }

    public final Locale get(int i10) {
        return this.f7951a.get(i10);
    }

    public final int hashCode() {
        return this.f7951a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f7951a.isEmpty();
    }

    public final int size() {
        return this.f7951a.size();
    }

    public final String toString() {
        return this.f7951a.toString();
    }
}
