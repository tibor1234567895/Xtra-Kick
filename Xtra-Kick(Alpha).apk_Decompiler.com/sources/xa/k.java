package xa;

import java.io.Serializable;

public abstract class k implements h, Serializable {
    private final int arity;

    public k(int i10) {
        this.arity = i10;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        v.f16819a.getClass();
        String a10 = w.a(this);
        j.e("renderLambdaToString(this)", a10);
        return a10;
    }
}
