package l2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final ByteArrayOutputStream f9532a;

    /* renamed from: b  reason: collision with root package name */
    public final DataOutputStream f9533b;

    public d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f9532a = byteArrayOutputStream;
        this.f9533b = new DataOutputStream(byteArrayOutputStream);
    }
}
