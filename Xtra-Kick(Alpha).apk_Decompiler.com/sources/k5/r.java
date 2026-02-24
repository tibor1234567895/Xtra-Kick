package k5;

public final class r extends t {
    public final int a(int i10, int i11, int i12, int i13) {
        return t.f9175g ? 2 : 1;
    }

    public final float b(int i10, int i11, int i12, int i13) {
        if (t.f9175g) {
            return Math.min(((float) i12) / ((float) i10), ((float) i13) / ((float) i11));
        }
        int max = Math.max(i11 / i13, i10 / i12);
        if (max == 0) {
            return 1.0f;
        }
        return 1.0f / ((float) Integer.highestOneBit(max));
    }
}
