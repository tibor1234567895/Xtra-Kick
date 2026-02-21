package b5;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface j {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f2629a = Charset.forName("UTF-8");

    void b(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
