package v;

import u.f;

public final class j extends q {
    public j(f fVar) {
        super(fVar);
        fVar.f15086d.f();
        fVar.f15088e.f();
        this.f15546f = ((u.j) fVar).f15156v0;
    }

    public final void a(d dVar) {
        f fVar = this.f15548h;
        if (fVar.f15510c && !fVar.f15517j) {
            fVar.d((int) ((((float) ((f) fVar.f15519l.get(0)).f15514g) * ((u.j) this.f15542b).f15152r0) + 0.5f));
        }
    }

    public final void d() {
        q qVar;
        f fVar = this.f15542b;
        u.j jVar = (u.j) fVar;
        int i10 = jVar.f15153s0;
        int i11 = jVar.f15154t0;
        int i12 = jVar.f15156v0;
        f fVar2 = this.f15548h;
        if (i12 == 1) {
            if (i10 != -1) {
                fVar2.f15519l.add(fVar.U.f15086d.f15548h);
                this.f15542b.U.f15086d.f15548h.f15518k.add(fVar2);
                fVar2.f15513f = i10;
            } else if (i11 != -1) {
                fVar2.f15519l.add(fVar.U.f15086d.f15549i);
                this.f15542b.U.f15086d.f15549i.f15518k.add(fVar2);
                fVar2.f15513f = -i11;
            } else {
                fVar2.f15509b = true;
                fVar2.f15519l.add(fVar.U.f15086d.f15549i);
                this.f15542b.U.f15086d.f15549i.f15518k.add(fVar2);
            }
            m(this.f15542b.f15086d.f15548h);
            qVar = this.f15542b.f15086d;
        } else {
            if (i10 != -1) {
                fVar2.f15519l.add(fVar.U.f15088e.f15548h);
                this.f15542b.U.f15088e.f15548h.f15518k.add(fVar2);
                fVar2.f15513f = i10;
            } else if (i11 != -1) {
                fVar2.f15519l.add(fVar.U.f15088e.f15549i);
                this.f15542b.U.f15088e.f15549i.f15518k.add(fVar2);
                fVar2.f15513f = -i11;
            } else {
                fVar2.f15509b = true;
                fVar2.f15519l.add(fVar.U.f15088e.f15549i);
                this.f15542b.U.f15088e.f15549i.f15518k.add(fVar2);
            }
            m(this.f15542b.f15088e.f15548h);
            qVar = this.f15542b.f15088e;
        }
        m(qVar.f15549i);
    }

    public final void e() {
        f fVar = this.f15542b;
        int i10 = ((u.j) fVar).f15156v0;
        f fVar2 = this.f15548h;
        if (i10 == 1) {
            fVar.Z = fVar2.f15514g;
        } else {
            fVar.f15081a0 = fVar2.f15514g;
        }
    }

    public final void f() {
        this.f15548h.c();
    }

    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f15548h;
        fVar2.f15518k.add(fVar);
        fVar.f15519l.add(fVar2);
    }
}
