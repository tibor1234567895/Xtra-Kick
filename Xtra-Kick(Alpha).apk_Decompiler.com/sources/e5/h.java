package e5;

public final class h implements a {
    public final int a(Object obj) {
        return ((int[]) obj).length;
    }

    public final int b() {
        return 4;
    }

    public final String getTag() {
        return "IntegerArrayPool";
    }

    public final Object newArray(int i10) {
        return new int[i10];
    }
}
