package ja;

public final class c {
    private c() {
    }

    public static void a(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
