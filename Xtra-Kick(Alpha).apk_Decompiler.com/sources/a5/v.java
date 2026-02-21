package a5;

import b5.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import v5.b;

public final class v implements j {

    /* renamed from: b  reason: collision with root package name */
    public final j f196b;

    /* renamed from: c  reason: collision with root package name */
    public final int f197c;

    public v(b bVar, int i10) {
        this.f196b = bVar;
        this.f197c = i10;
    }

    public final void b(MessageDigest messageDigest) {
        messageDigest.update(ByteBuffer.allocate(12).putInt(this.f197c).array());
        this.f196b.b(messageDigest);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f196b.equals(vVar.f196b) && this.f197c == vVar.f197c;
    }

    public final int hashCode() {
        return (this.f196b.hashCode() * 31) + this.f197c;
    }
}
