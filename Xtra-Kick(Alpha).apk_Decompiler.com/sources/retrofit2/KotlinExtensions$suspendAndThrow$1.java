package retrofit2;

import androidx.recyclerview.widget.RecyclerView;
import ra.c;
import ra.e;

@e(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
public final class KotlinExtensions$suspendAndThrow$1 extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public KotlinExtensions$suspendAndThrow$1(pa.e eVar) {
        super(eVar);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= RecyclerView.UNDEFINED_DURATION;
        return KotlinExtensions.suspendAndThrow((Exception) null, this);
    }
}
