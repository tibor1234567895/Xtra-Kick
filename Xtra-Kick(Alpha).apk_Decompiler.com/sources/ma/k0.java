package ma;

import cb.e;
import fb.h;
import java.util.List;
import xa.j;

public final class k0 extends f {

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10813i = 1;

    /* renamed from: j  reason: collision with root package name */
    public final Object f10814j;

    public k0(h hVar) {
        this.f10814j = hVar;
    }

    public final int a() {
        int i10 = this.f10813i;
        Object obj = this.f10814j;
        switch (i10) {
            case 0:
                return ((List) obj).size();
            default:
                return ((h) obj).f6004a.groupCount() + 1;
        }
    }

    public final /* bridge */ boolean contains(Object obj) {
        switch (this.f10813i) {
            case 1:
                if (!(obj instanceof String)) {
                    return false;
                }
                return super.contains((String) obj);
            default:
                return super.contains(obj);
        }
    }

    public final Object get(int i10) {
        int i11 = this.f10813i;
        Object obj = this.f10814j;
        switch (i11) {
            case 0:
                List list = (List) obj;
                if (new e(0, r.d(this)).b(i10)) {
                    return list.get(r.d(this) - i10);
                }
                StringBuilder r10 = android.support.v4.media.h.r("Element index ", i10, " must be in range [");
                r10.append(new e(0, r.d(this)));
                r10.append("].");
                throw new IndexOutOfBoundsException(r10.toString());
            default:
                String group = ((h) obj).f6004a.group(i10);
                if (group == null) {
                    return "";
                }
                return group;
        }
    }

    public final /* bridge */ int indexOf(Object obj) {
        switch (this.f10813i) {
            case 1:
                if (!(obj instanceof String)) {
                    return -1;
                }
                return super.indexOf((String) obj);
            default:
                return super.indexOf(obj);
        }
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        switch (this.f10813i) {
            case 1:
                if (!(obj instanceof String)) {
                    return -1;
                }
                return super.lastIndexOf((String) obj);
            default:
                return super.lastIndexOf(obj);
        }
    }

    public k0(List list) {
        j.f("delegate", list);
        this.f10814j = list;
    }
}
