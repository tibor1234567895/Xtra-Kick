package d9;

public final class h0 {
    private h0() {
    }

    public static int a(int i10) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i10) * -862048943), 15)) * 461845907);
    }

    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
