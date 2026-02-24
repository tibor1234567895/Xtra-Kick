package k5;

public final class o extends t {
    public final int a(int i10, int i11, int i12, int i13) {
        return 1;
    }

    public final float b(int i10, int i11, int i12, int i13) {
        int ceil = (int) Math.ceil((double) Math.max(((float) i11) / ((float) i13), ((float) i10) / ((float) i12)));
        int i14 = 1;
        int max = Math.max(1, Integer.highestOneBit(ceil));
        if (max >= ceil) {
            i14 = 0;
        }
        return 1.0f / ((float) (max << i14));
    }
}
