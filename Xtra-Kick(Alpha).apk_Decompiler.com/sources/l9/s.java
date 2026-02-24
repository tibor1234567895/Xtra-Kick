package l9;

public final class s {
    private s() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        throw new j9.t((java.lang.Exception) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        throw new j9.t((java.lang.Exception) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        return j9.u.f8877h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        throw new j9.t((java.lang.Exception) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        throw new j9.t((java.lang.Exception) r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017 A[ExcHandler: IOException (r1v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001e A[ExcHandler: MalformedJsonException (r1v4 'e' com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0010 A[ExcHandler: NumberFormatException (r1v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j9.s a(com.google.gson.stream.JsonReader r1) {
        /*
            r1.peek()     // Catch:{ EOFException -> 0x0025, MalformedJsonException -> 0x001e, IOException -> 0x0017, NumberFormatException -> 0x0010 }
            com.google.gson.internal.bind.i0 r0 = com.google.gson.internal.bind.s0.A     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001e, IOException -> 0x0017, NumberFormatException -> 0x0010 }
            r0.getClass()     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001e, IOException -> 0x0017, NumberFormatException -> 0x0010 }
            j9.s r1 = com.google.gson.internal.bind.i0.d(r1)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001e, IOException -> 0x0017, NumberFormatException -> 0x0010 }
            return r1
        L_0x000d:
            r1 = move-exception
            r0 = 0
            goto L_0x0027
        L_0x0010:
            r1 = move-exception
            j9.t r0 = new j9.t
            r0.<init>((java.lang.Exception) r1)
            throw r0
        L_0x0017:
            r1 = move-exception
            j9.t r0 = new j9.t
            r0.<init>((java.lang.Exception) r1)
            throw r0
        L_0x001e:
            r1 = move-exception
            j9.t r0 = new j9.t
            r0.<init>((java.lang.Exception) r1)
            throw r0
        L_0x0025:
            r1 = move-exception
            r0 = 1
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            j9.u r1 = j9.u.f8877h
            return r1
        L_0x002c:
            j9.t r0 = new j9.t
            r0.<init>((java.lang.Exception) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.s.a(com.google.gson.stream.JsonReader):j9.s");
    }
}
