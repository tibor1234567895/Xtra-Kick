package androidx.recyclerview.widget;

public final class c1 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1952h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f1953i;

    public /* synthetic */ c1(RecyclerView recyclerView, int i10) {
        this.f1952h = i10;
        this.f1953i = recyclerView;
    }

    public final void run() {
        int i10 = this.f1952h;
        RecyclerView recyclerView = this.f1953i;
        switch (i10) {
            case 0:
                if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                    if (!recyclerView.mIsAttached) {
                        recyclerView.requestLayout();
                        return;
                    } else if (recyclerView.mLayoutSuppressed) {
                        recyclerView.mLayoutWasDefered = true;
                        return;
                    } else {
                        recyclerView.consumePendingUpdateOperations();
                        return;
                    }
                } else {
                    return;
                }
            default:
                n1 n1Var = recyclerView.mItemAnimator;
                if (n1Var != null) {
                    n1Var.l();
                }
                recyclerView.mPostedAnimatorRunner = false;
                return;
        }
    }
}
