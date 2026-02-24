package k5;

public final class n extends t {
    public final int a(int i10, int i11, int i12, int i13) {
        return 2;
    }

    public final float b(int i10, int i11, int i12, int i13) {
        int min = Math.min(i11 / i13, i10 / i12);
        if (min == 0) {
            return 1.0f;
        }
        return 1.0f / ((float) Integer.highestOneBit(min));
    }
}
