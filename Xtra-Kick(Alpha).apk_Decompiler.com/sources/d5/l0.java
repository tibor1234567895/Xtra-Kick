package d5;

import android.support.v4.media.n;
import android.support.v4.media.session.u;
import com.bumptech.glide.load.data.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l0.d;

public final class l0 {

    /* renamed from: a  reason: collision with root package name */
    public final d f4424a;

    /* renamed from: b  reason: collision with root package name */
    public final List f4425b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4426c;

    public l0(Class cls, Class cls2, Class cls3, List list, u uVar) {
        this.f4424a = uVar;
        if (!list.isEmpty()) {
            this.f4425b = list;
            this.f4426c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public final o0 a(int i10, int i11, n nVar, b5.n nVar2, g gVar) {
        o0 o0Var;
        d dVar = this.f4424a;
        Object j10 = dVar.j();
        w5.n.b(j10);
        List list = (List) j10;
        try {
            List list2 = this.f4425b;
            int size = list2.size();
            o0Var = null;
            for (int i12 = 0; i12 < size; i12++) {
                o0Var = ((o) list2.get(i12)).a(i10, i11, nVar, nVar2, gVar);
                if (o0Var != null) {
                    break;
                }
            }
        } catch (i0 e10) {
            list.add(e10);
        } catch (Throwable th) {
            dVar.e(list);
            throw th;
        }
        if (o0Var != null) {
            dVar.e(list);
            return o0Var;
        }
        throw new i0(this.f4426c, new ArrayList(list));
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f4425b.toArray()) + '}';
    }
}
