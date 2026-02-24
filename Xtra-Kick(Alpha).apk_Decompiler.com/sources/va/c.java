package va;

import java.io.File;
import xa.j;

public final class c extends f {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15976b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(File file) {
        super(file);
        j.f("rootFile", file);
    }

    public final File a() {
        if (this.f15976b) {
            return null;
        }
        this.f15976b = true;
        return this.f15983a;
    }
}
