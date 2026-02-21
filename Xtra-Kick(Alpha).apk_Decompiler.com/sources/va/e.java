package va;

import java.io.File;
import java.util.ArrayDeque;
import la.g;
import ma.b;
import s.i;
import xa.j;

public final class e extends b {

    /* renamed from: j  reason: collision with root package name */
    public final ArrayDeque f15981j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ g f15982k;

    public e(g gVar) {
        this.f15982k = gVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f15981j = arrayDeque;
        boolean isDirectory = gVar.f15984a.isDirectory();
        File file = gVar.f15984a;
        if (isDirectory) {
            arrayDeque.push(b(file));
        } else if (file.isFile()) {
            arrayDeque.push(new c(file));
        } else {
            this.f10799h = 3;
        }
    }

    public final void a() {
        File file;
        File a10;
        while (true) {
            ArrayDeque arrayDeque = this.f15981j;
            f fVar = (f) arrayDeque.peek();
            if (fVar == null) {
                file = null;
                break;
            }
            a10 = fVar.a();
            if (a10 == null) {
                arrayDeque.pop();
            } else if (j.a(a10, fVar.f15983a) || !a10.isDirectory() || arrayDeque.size() >= this.f15982k.f15986c) {
                file = a10;
            } else {
                arrayDeque.push(b(a10));
            }
        }
        file = a10;
        if (file != null) {
            this.f10800i = file;
            this.f10799h = 1;
            return;
        }
        this.f10799h = 3;
    }

    public final a b(File file) {
        int a10 = i.a(this.f15982k.f15985b);
        if (a10 == 0) {
            return new d(this, file);
        }
        if (a10 == 1) {
            return new b(this, file);
        }
        throw new g();
    }
}
