package e6;

import com.github.andreyasadchy.xtra.model.VideoPosition;
import java.util.LinkedHashMap;
import java.util.List;
import ma.i0;
import ma.s;
import wa.l;
import xa.j;
import xa.k;

public final class x1 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public static final x1 f5269h = new x1();

    public x1() {
        super(1);
    }

    public final Object invoke(Object obj) {
        List<VideoPosition> list = (List) obj;
        j.f("list", list);
        int a10 = i0.a(s.i(list));
        if (a10 < 16) {
            a10 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(a10);
        for (VideoPosition videoPosition : list) {
            linkedHashMap.put(Long.valueOf(videoPosition.getId()), Long.valueOf(videoPosition.getPosition()));
        }
        return linkedHashMap;
    }
}
