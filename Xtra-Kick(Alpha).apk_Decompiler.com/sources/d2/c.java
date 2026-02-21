package d2;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4150a = {1, 2, 3, 6};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4151b = {48000, 44100, 32000};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f4152c = {24000, 22050, 16000};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f4153d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f4154e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f4155f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    private c() {
    }

    public static int a(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0 || i10 >= 3 || i11 < 0 || i12 >= 19) {
            return -1;
        }
        int i13 = f4151b[i10];
        if (i13 == 44100) {
            return ((i11 % 2) + f4155f[i12]) * 2;
        }
        int i14 = f4154e[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }
}
