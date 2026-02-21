package ba;

import ja.b;

public final class a {
    private a() {
    }

    public static Object a(Class cls, Object obj) {
        if (obj instanceof ja.a) {
            return cls.cast(obj);
        }
        if (obj instanceof b) {
            return a(cls, ((b) obj).c());
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", new Object[]{obj.getClass(), ja.a.class, b.class}));
    }
}
