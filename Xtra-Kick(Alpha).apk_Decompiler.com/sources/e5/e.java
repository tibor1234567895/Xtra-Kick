package e5;

public final class e implements a {
    public final int a(Object obj) {
        return ((byte[]) obj).length;
    }

    public final int b() {
        return 1;
    }

    public final String getTag() {
        return "ByteArrayPool";
    }

    public final Object newArray(int i10) {
        return new byte[i10];
    }
}
