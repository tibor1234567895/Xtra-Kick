package androidx.recyclerview.widget;

import android.view.ViewGroup;
import i0.m;
import i0.n;
import java.util.List;

public abstract class g1 {
    private boolean mHasStableIds = false;
    private final h1 mObservable = new h1();
    private f1 mStateRestorationPolicy = f1.ALLOW;

    public final void bindViewHolder(k2 k2Var, int i10) {
        boolean z10;
        if (k2Var.mBindingAdapter == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            k2Var.mPosition = i10;
            if (hasStableIds()) {
                k2Var.mItemId = getItemId(i10);
            }
            k2Var.setFlags(1, 519);
            int i11 = n.f7952a;
            m.a("RV OnBindView");
        }
        k2Var.mBindingAdapter = this;
        onBindViewHolder(k2Var, i10, k2Var.getUnmodifiedPayloads());
        if (z10) {
            k2Var.clearPayload();
            ViewGroup.LayoutParams layoutParams = k2Var.itemView.getLayoutParams();
            if (layoutParams instanceof r1) {
                ((r1) layoutParams).f2186j = true;
            }
            int i12 = n.f7952a;
            m.b();
        }
    }

    public boolean canRestoreState() {
        int ordinal = this.mStateRestorationPolicy.ordinal();
        return ordinal != 1 ? ordinal != 2 : getItemCount() > 0;
    }

    public final k2 createViewHolder(ViewGroup viewGroup, int i10) {
        try {
            int i11 = n.f7952a;
            m.a("RV CreateView");
            k2 onCreateViewHolder = onCreateViewHolder(viewGroup, i10);
            if (onCreateViewHolder.itemView.getParent() == null) {
                onCreateViewHolder.mItemViewType = i10;
                m.b();
                return onCreateViewHolder;
            }
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
        } catch (Throwable th) {
            int i12 = n.f7952a;
            m.b();
            throw th;
        }
    }

    public int findRelativeAdapterPositionIn(g1 g1Var, k2 k2Var, int i10) {
        if (g1Var == this) {
            return i10;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i10) {
        return -1;
    }

    public int getItemViewType(int i10) {
        return 0;
    }

    public final f1 getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int i10) {
        this.mObservable.d(i10, 1, (Object) null);
    }

    public final void notifyItemInserted(int i10) {
        this.mObservable.e(i10, 1);
    }

    public final void notifyItemMoved(int i10, int i11) {
        this.mObservable.c(i10, i11);
    }

    public final void notifyItemRangeChanged(int i10, int i11) {
        this.mObservable.d(i10, i11, (Object) null);
    }

    public final void notifyItemRangeInserted(int i10, int i11) {
        this.mObservable.e(i10, i11);
    }

    public final void notifyItemRangeRemoved(int i10, int i11) {
        this.mObservable.f(i10, i11);
    }

    public final void notifyItemRemoved(int i10) {
        this.mObservable.f(i10, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(k2 k2Var, int i10);

    public void onBindViewHolder(k2 k2Var, int i10, List<Object> list) {
        onBindViewHolder(k2Var, i10);
    }

    public abstract k2 onCreateViewHolder(ViewGroup viewGroup, int i10);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(k2 k2Var) {
        return false;
    }

    public void onViewAttachedToWindow(k2 k2Var) {
    }

    public void onViewDetachedFromWindow(k2 k2Var) {
    }

    public void onViewRecycled(k2 k2Var) {
    }

    public void registerAdapterDataObserver(i1 i1Var) {
        this.mObservable.registerObserver(i1Var);
    }

    public void setHasStableIds(boolean z10) {
        if (!hasObservers()) {
            this.mHasStableIds = z10;
            return;
        }
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }

    public void setStateRestorationPolicy(f1 f1Var) {
        this.mStateRestorationPolicy = f1Var;
        this.mObservable.g();
    }

    public void unregisterAdapterDataObserver(i1 i1Var) {
        this.mObservable.unregisterObserver(i1Var);
    }

    public final void notifyItemChanged(int i10, Object obj) {
        this.mObservable.d(i10, 1, obj);
    }

    public final void notifyItemRangeChanged(int i10, int i11, Object obj) {
        this.mObservable.d(i10, i11, obj);
    }
}
