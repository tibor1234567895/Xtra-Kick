package va;

import java.io.File;
import xa.j;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f15971b;

    /* renamed from: c  reason: collision with root package name */
    public File[] f15972c;

    /* renamed from: d  reason: collision with root package name */
    public int f15973d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f15974e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ e f15975f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(e eVar, File file) {
        super(file);
        j.f("rootDir", file);
        this.f15975f = eVar;
    }

    public final File a() {
        boolean z10 = this.f15974e;
        File file = this.f15983a;
        e eVar = this.f15975f;
        if (!z10 && this.f15972c == null) {
            eVar.f15982k.getClass();
            File[] listFiles = file.listFiles();
            this.f15972c = listFiles;
            if (listFiles == null) {
                eVar.f15982k.getClass();
                this.f15974e = true;
            }
        }
        File[] fileArr = this.f15972c;
        if (fileArr != null) {
            int i10 = this.f15973d;
            j.c(fileArr);
            if (i10 < fileArr.length) {
                File[] fileArr2 = this.f15972c;
                j.c(fileArr2);
                int i11 = this.f15973d;
                this.f15973d = i11 + 1;
                return fileArr2[i11];
            }
        }
        if (!this.f15971b) {
            this.f15971b = true;
            return file;
        }
        eVar.f15982k.getClass();
        return null;
    }
}
