package v;

import java.util.ArrayList;
import java.util.Iterator;

public class f implements d {

    /* renamed from: a  reason: collision with root package name */
    public q f15508a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15509b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f15510c = false;

    /* renamed from: d  reason: collision with root package name */
    public final q f15511d;

    /* renamed from: e  reason: collision with root package name */
    public int f15512e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f15513f;

    /* renamed from: g  reason: collision with root package name */
    public int f15514g;

    /* renamed from: h  reason: collision with root package name */
    public int f15515h = 1;

    /* renamed from: i  reason: collision with root package name */
    public g f15516i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f15517j = false;

    /* renamed from: k  reason: collision with root package name */
    public final ArrayList f15518k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    public final ArrayList f15519l = new ArrayList();

    public f(q qVar) {
        this.f15511d = qVar;
    }

    public final void a(d dVar) {
        ArrayList arrayList = this.f15519l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((f) it.next()).f15517j) {
                return;
            }
        }
        this.f15510c = true;
        q qVar = this.f15508a;
        if (qVar != null) {
            qVar.a(this);
        }
        if (this.f15509b) {
            this.f15511d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        f fVar = null;
        int i10 = 0;
        while (it2.hasNext()) {
            f fVar2 = (f) it2.next();
            if (!(fVar2 instanceof g)) {
                i10++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i10 == 1 && fVar.f15517j) {
            g gVar = this.f15516i;
            if (gVar != null) {
                if (gVar.f15517j) {
                    this.f15513f = this.f15515h * gVar.f15514g;
                } else {
                    return;
                }
            }
            d(fVar.f15514g + this.f15513f);
        }
        q qVar2 = this.f15508a;
        if (qVar2 != null) {
            qVar2.a(this);
        }
    }

    public final void b(d dVar) {
        this.f15518k.add(dVar);
        if (this.f15517j) {
            dVar.a(dVar);
        }
    }

    public final void c() {
        this.f15519l.clear();
        this.f15518k.clear();
        this.f15517j = false;
        this.f15514g = 0;
        this.f15510c = false;
        this.f15509b = false;
    }

    public void d(int i10) {
        if (!this.f15517j) {
            this.f15517j = true;
            this.f15514g = i10;
            Iterator it = this.f15518k.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                dVar.a(dVar);
            }
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15511d.f15542b.f15097i0);
        sb2.append(Constants.EXT_TAG_END);
        sb2.append(q0.f.m(this.f15512e));
        sb2.append("(");
        if (this.f15517j) {
            obj = Integer.valueOf(this.f15514g);
        } else {
            obj = "unresolved";
        }
        sb2.append(obj);
        sb2.append(") <t=");
        sb2.append(this.f15519l.size());
        sb2.append(":d=");
        sb2.append(this.f15518k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
