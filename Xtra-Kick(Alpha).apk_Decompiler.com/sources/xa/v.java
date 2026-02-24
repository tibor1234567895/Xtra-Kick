package xa;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final w f16819a;

    static {
        w wVar = null;
        try {
            wVar = (w) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (wVar == null) {
            wVar = new w();
        }
        f16819a = wVar;
    }

    public static e a(Class cls) {
        f16819a.getClass();
        return new e(cls);
    }
}
