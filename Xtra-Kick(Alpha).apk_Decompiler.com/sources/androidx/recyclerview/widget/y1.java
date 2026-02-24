package androidx.recyclerview.widget;

import android.support.v4.media.h;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import hb.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import m0.c;
import m0.c1;

public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f2250a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f2251b = null;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f2252c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final List f2253d;

    /* renamed from: e  reason: collision with root package name */
    public int f2254e;

    /* renamed from: f  reason: collision with root package name */
    public int f2255f;

    /* renamed from: g  reason: collision with root package name */
    public x1 f2256g;

    /* renamed from: h  reason: collision with root package name */
    public i2 f2257h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2258i;

    public y1(RecyclerView recyclerView) {
        this.f2258i = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f2250a = arrayList;
        this.f2253d = Collections.unmodifiableList(arrayList);
        this.f2254e = 2;
        this.f2255f = 2;
    }

    public static void e(ViewGroup viewGroup, boolean z10) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                e((ViewGroup) childAt, true);
            }
        }
        if (z10) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }
    }

    public final void a(k2 k2Var, boolean z10) {
        c cVar;
        RecyclerView.clearNestedRecyclerViewIfNotNested(k2Var);
        View view = k2Var.itemView;
        RecyclerView recyclerView = this.f2258i;
        m2 m2Var = recyclerView.mAccessibilityDelegate;
        if (m2Var != null) {
            c j10 = m2Var.j();
            if (j10 instanceof l2) {
                cVar = (c) ((l2) j10).f2076e.remove(view);
            } else {
                cVar = null;
            }
            c1.p(view, cVar);
        }
        if (z10) {
            if (recyclerView.mRecyclerListeners.size() <= 0) {
                g1 g1Var = recyclerView.mAdapter;
                if (g1Var != null) {
                    g1Var.onViewRecycled(k2Var);
                }
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.c(k2Var);
                }
            } else {
                h.y(recyclerView.mRecyclerListeners.get(0));
                throw null;
            }
        }
        k2Var.mBindingAdapter = null;
        k2Var.mOwnerRecyclerView = null;
        x1 c10 = c();
        c10.getClass();
        int itemViewType = k2Var.getItemViewType();
        ArrayList arrayList = c10.a(itemViewType).f2225a;
        if (((w1) c10.f2232a.get(itemViewType)).f2226b <= arrayList.size()) {
            h0.u(k2Var.itemView);
            return;
        }
        k2Var.resetInternal();
        arrayList.add(k2Var);
    }

    public final int b(int i10) {
        RecyclerView recyclerView = this.f2258i;
        if (i10 < 0 || i10 >= recyclerView.mState.b()) {
            StringBuilder r10 = h.r("invalid position ", i10, ". State item count is ");
            r10.append(recyclerView.mState.b());
            r10.append(recyclerView.exceptionLabel());
            throw new IndexOutOfBoundsException(r10.toString());
        } else if (!recyclerView.mState.f2024g) {
            return i10;
        } else {
            return recyclerView.mAdapterHelper.f(i10, 0);
        }
    }

    public final x1 c() {
        if (this.f2256g == null) {
            this.f2256g = new x1();
            f();
        }
        return this.f2256g;
    }

    public final View d(int i10) {
        return m(i10, Long.MAX_VALUE).itemView;
    }

    public final void f() {
        if (this.f2256g != null) {
            RecyclerView recyclerView = this.f2258i;
            if (recyclerView.mAdapter != null && recyclerView.isAttachedToWindow()) {
                x1 x1Var = this.f2256g;
                x1Var.f2234c.add(recyclerView.mAdapter);
            }
        }
    }

    public final void g(g1 g1Var, boolean z10) {
        x1 x1Var = this.f2256g;
        if (x1Var != null) {
            Set set = x1Var.f2234c;
            set.remove(g1Var);
            if (set.size() == 0 && !z10) {
                int i10 = 0;
                while (true) {
                    SparseArray sparseArray = x1Var.f2232a;
                    if (i10 < sparseArray.size()) {
                        ArrayList arrayList = ((w1) sparseArray.get(sparseArray.keyAt(i10))).f2225a;
                        for (int i11 = 0; i11 < arrayList.size(); i11++) {
                            h0.u(((k2) arrayList.get(i11)).itemView);
                        }
                        i10++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void h() {
        ArrayList arrayList = this.f2252c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            i(size);
        }
        arrayList.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            i0 i0Var = this.f2258i.mPrefetchRegistry;
            int[] iArr = i0Var.f2047c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            i0Var.f2048d = 0;
        }
    }

    public final void i(int i10) {
        ArrayList arrayList = this.f2252c;
        a((k2) arrayList.get(i10), true);
        arrayList.remove(i10);
    }

    public final void j(View view) {
        k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean isTmpDetached = childViewHolderInt.isTmpDetached();
        RecyclerView recyclerView = this.f2258i;
        if (isTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        k(childViewHolderInt);
        if (recyclerView.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
            recyclerView.mItemAnimator.i(childViewHolderInt);
        }
    }

    public final void k(k2 k2Var) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean isScrap = k2Var.isScrap();
        boolean z15 = false;
        RecyclerView recyclerView = this.f2258i;
        if (isScrap || k2Var.itemView.getParent() != null) {
            StringBuilder sb2 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            sb2.append(k2Var.isScrap());
            sb2.append(" isAttached:");
            if (k2Var.itemView.getParent() != null) {
                z15 = true;
            }
            sb2.append(z15);
            sb2.append(recyclerView.exceptionLabel());
            throw new IllegalArgumentException(sb2.toString());
        } else if (k2Var.isTmpDetached()) {
            StringBuilder sb3 = new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
            sb3.append(k2Var);
            throw new IllegalArgumentException(h.h(recyclerView, sb3));
        } else if (!k2Var.shouldIgnore()) {
            boolean doesTransientStatePreventRecycling = k2Var.doesTransientStatePreventRecycling();
            g1 g1Var = recyclerView.mAdapter;
            if (g1Var == null || !doesTransientStatePreventRecycling || !g1Var.onFailedToRecycleView(k2Var)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10 || k2Var.isRecyclable()) {
                if (this.f2255f <= 0 || k2Var.hasAnyOfTheFlags(526)) {
                    z12 = false;
                } else {
                    ArrayList arrayList = this.f2252c;
                    int size = arrayList.size();
                    if (size >= this.f2255f && size > 0) {
                        i(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0) {
                        i0 i0Var = recyclerView.mPrefetchRegistry;
                        int i10 = k2Var.mPosition;
                        if (i0Var.f2047c != null) {
                            int i11 = i0Var.f2048d * 2;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= i11) {
                                    break;
                                } else if (i0Var.f2047c[i12] == i10) {
                                    z13 = true;
                                    break;
                                } else {
                                    i12 += 2;
                                }
                            }
                        }
                        z13 = false;
                        if (!z13) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                                int i13 = ((k2) arrayList.get(size)).mPosition;
                                i0 i0Var2 = recyclerView.mPrefetchRegistry;
                                if (i0Var2.f2047c != null) {
                                    int i14 = i0Var2.f2048d * 2;
                                    int i15 = 0;
                                    while (true) {
                                        if (i15 >= i14) {
                                            break;
                                        } else if (i0Var2.f2047c[i15] == i13) {
                                            z14 = true;
                                            continue;
                                            break;
                                        } else {
                                            i15 += 2;
                                        }
                                    }
                                }
                                z14 = false;
                                continue;
                            } while (z14);
                            size++;
                        }
                    }
                    arrayList.add(size, k2Var);
                    z12 = true;
                }
                if (!z12) {
                    a(k2Var, true);
                    z15 = true;
                }
                z11 = z12;
            } else {
                z11 = false;
            }
            recyclerView.mViewInfoStore.c(k2Var);
            if (!z11 && !z15 && doesTransientStatePreventRecycling) {
                h0.u(k2Var.itemView);
                k2Var.mBindingAdapter = null;
                k2Var.mOwnerRecyclerView = null;
            }
        } else {
            throw new IllegalArgumentException(h.h(recyclerView, new StringBuilder("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
        }
    }

    public final void l(View view) {
        ArrayList arrayList;
        k2 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f2258i;
        if (!hasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.f2251b == null) {
                this.f2251b = new ArrayList();
            }
            childViewHolderInt.setScrapContainer(this, true);
            arrayList = this.f2251b;
        } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || recyclerView.mAdapter.hasStableIds()) {
            childViewHolderInt.setScrapContainer(this, false);
            arrayList = this.f2250a;
        } else {
            throw new IllegalArgumentException(h.h(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
        }
        arrayList.add(childViewHolderInt);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: androidx.recyclerview.widget.k2} */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02d2, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0487, code lost:
        if (r6 == false) goto L_0x0489;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x034c  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x050d  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0512  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x052b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.recyclerview.widget.k2 m(int r20, long r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            androidx.recyclerview.widget.RecyclerView r2 = r0.f2258i
            if (r1 < 0) goto L_0x0533
            androidx.recyclerview.widget.g2 r3 = r2.mState
            int r3 = r3.b()
            if (r1 >= r3) goto L_0x0533
            androidx.recyclerview.widget.g2 r3 = r2.mState
            boolean r3 = r3.f2024g
            r4 = 0
            r5 = 32
            if (r3 == 0) goto L_0x0088
            java.util.ArrayList r3 = r0.f2251b
            if (r3 == 0) goto L_0x0081
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0024
            goto L_0x0081
        L_0x0024:
            r6 = 0
        L_0x0025:
            if (r6 >= r3) goto L_0x0042
            java.util.ArrayList r7 = r0.f2251b
            java.lang.Object r7 = r7.get(r6)
            androidx.recyclerview.widget.k2 r7 = (androidx.recyclerview.widget.k2) r7
            boolean r8 = r7.wasReturnedFromScrap()
            if (r8 != 0) goto L_0x003f
            int r8 = r7.getLayoutPosition()
            if (r8 != r1) goto L_0x003f
            r7.addFlags(r5)
            goto L_0x0082
        L_0x003f:
            int r6 = r6 + 1
            goto L_0x0025
        L_0x0042:
            androidx.recyclerview.widget.g1 r6 = r2.mAdapter
            boolean r6 = r6.hasStableIds()
            if (r6 == 0) goto L_0x0081
            androidx.recyclerview.widget.b r6 = r2.mAdapterHelper
            int r6 = r6.f(r1, r4)
            if (r6 <= 0) goto L_0x0081
            androidx.recyclerview.widget.g1 r7 = r2.mAdapter
            int r7 = r7.getItemCount()
            if (r6 >= r7) goto L_0x0081
            androidx.recyclerview.widget.g1 r7 = r2.mAdapter
            long r6 = r7.getItemId(r6)
            r8 = 0
        L_0x0061:
            if (r8 >= r3) goto L_0x0081
            java.util.ArrayList r9 = r0.f2251b
            java.lang.Object r9 = r9.get(r8)
            androidx.recyclerview.widget.k2 r9 = (androidx.recyclerview.widget.k2) r9
            boolean r10 = r9.wasReturnedFromScrap()
            if (r10 != 0) goto L_0x007e
            long r10 = r9.getItemId()
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x007e
            r9.addFlags(r5)
            r7 = r9
            goto L_0x0082
        L_0x007e:
            int r8 = r8 + 1
            goto L_0x0061
        L_0x0081:
            r7 = 0
        L_0x0082:
            if (r7 == 0) goto L_0x0086
            r3 = 1
            goto L_0x008a
        L_0x0086:
            r3 = 0
            goto L_0x008a
        L_0x0088:
            r3 = 0
            r7 = 0
        L_0x008a:
            java.util.ArrayList r6 = r0.f2252c
            java.util.ArrayList r8 = r0.f2250a
            r9 = -1
            if (r7 != 0) goto L_0x022a
            int r7 = r8.size()
            r10 = 0
        L_0x0096:
            if (r10 >= r7) goto L_0x00c5
            java.lang.Object r11 = r8.get(r10)
            androidx.recyclerview.widget.k2 r11 = (androidx.recyclerview.widget.k2) r11
            boolean r12 = r11.wasReturnedFromScrap()
            if (r12 != 0) goto L_0x00c2
            int r12 = r11.getLayoutPosition()
            if (r12 != r1) goto L_0x00c2
            boolean r12 = r11.isInvalid()
            if (r12 != 0) goto L_0x00c2
            androidx.recyclerview.widget.g2 r12 = r2.mState
            boolean r12 = r12.f2024g
            if (r12 != 0) goto L_0x00bc
            boolean r12 = r11.isRemoved()
            if (r12 != 0) goto L_0x00c2
        L_0x00bc:
            r11.addFlags(r5)
        L_0x00bf:
            r7 = r11
            goto L_0x01a7
        L_0x00c2:
            int r10 = r10 + 1
            goto L_0x0096
        L_0x00c5:
            androidx.recyclerview.widget.k r7 = r2.mChildHelper
            java.util.ArrayList r10 = r7.f2065c
            int r11 = r10.size()
            r12 = 0
        L_0x00ce:
            if (r12 >= r11) goto L_0x00f5
            java.lang.Object r13 = r10.get(r12)
            android.view.View r13 = (android.view.View) r13
            androidx.recyclerview.widget.e1 r14 = r7.f2063a
            r14.getClass()
            androidx.recyclerview.widget.k2 r14 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r13)
            int r15 = r14.getLayoutPosition()
            if (r15 != r1) goto L_0x00f2
            boolean r15 = r14.isInvalid()
            if (r15 != 0) goto L_0x00f2
            boolean r14 = r14.isRemoved()
            if (r14 != 0) goto L_0x00f2
            goto L_0x00f6
        L_0x00f2:
            int r12 = r12 + 1
            goto L_0x00ce
        L_0x00f5:
            r13 = 0
        L_0x00f6:
            if (r13 == 0) goto L_0x017f
            androidx.recyclerview.widget.k2 r7 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r13)
            androidx.recyclerview.widget.k r10 = r2.mChildHelper
            androidx.recyclerview.widget.e1 r11 = r10.f2063a
            androidx.recyclerview.widget.RecyclerView r11 = r11.f1972a
            int r11 = r11.indexOfChild(r13)
            if (r11 < 0) goto L_0x016b
            androidx.recyclerview.widget.j r12 = r10.f2064b
            boolean r14 = r12.d(r11)
            if (r14 == 0) goto L_0x0157
            r12.a(r11)
            r10.k(r13)
            androidx.recyclerview.widget.k r10 = r2.mChildHelper
            androidx.recyclerview.widget.e1 r11 = r10.f2063a
            androidx.recyclerview.widget.RecyclerView r11 = r11.f1972a
            int r11 = r11.indexOfChild(r13)
            if (r11 != r9) goto L_0x0123
            goto L_0x012b
        L_0x0123:
            androidx.recyclerview.widget.j r10 = r10.f2064b
            boolean r12 = r10.d(r11)
            if (r12 == 0) goto L_0x012d
        L_0x012b:
            r10 = -1
            goto L_0x0133
        L_0x012d:
            int r10 = r10.b(r11)
            int r10 = r11 - r10
        L_0x0133:
            if (r10 == r9) goto L_0x0143
            androidx.recyclerview.widget.k r11 = r2.mChildHelper
            r11.c(r10)
            r0.l(r13)
            r10 = 8224(0x2020, float:1.1524E-41)
            r7.addFlags(r10)
            goto L_0x01a7
        L_0x0143:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "layout index should not be -1 after unhiding a view:"
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r2 = android.support.v4.media.h.h(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0157:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "trying to unhide a view that was not hidden"
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x016b:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "view is not a child, cannot hide "
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x017f:
            int r7 = r6.size()
            r10 = 0
        L_0x0184:
            if (r10 >= r7) goto L_0x01a6
            java.lang.Object r11 = r6.get(r10)
            androidx.recyclerview.widget.k2 r11 = (androidx.recyclerview.widget.k2) r11
            boolean r12 = r11.isInvalid()
            if (r12 != 0) goto L_0x01a3
            int r12 = r11.getLayoutPosition()
            if (r12 != r1) goto L_0x01a3
            boolean r12 = r11.isAttachedToTransitionOverlay()
            if (r12 != 0) goto L_0x01a3
            r6.remove(r10)
            goto L_0x00bf
        L_0x01a3:
            int r10 = r10 + 1
            goto L_0x0184
        L_0x01a6:
            r7 = 0
        L_0x01a7:
            if (r7 == 0) goto L_0x022a
            boolean r10 = r7.isRemoved()
            if (r10 == 0) goto L_0x01b4
            androidx.recyclerview.widget.g2 r10 = r2.mState
            boolean r10 = r10.f2024g
            goto L_0x01f1
        L_0x01b4:
            int r10 = r7.mPosition
            if (r10 < 0) goto L_0x0216
            androidx.recyclerview.widget.g1 r11 = r2.mAdapter
            int r11 = r11.getItemCount()
            if (r10 >= r11) goto L_0x0216
            androidx.recyclerview.widget.g2 r10 = r2.mState
            boolean r10 = r10.f2024g
            if (r10 != 0) goto L_0x01d5
            androidx.recyclerview.widget.g1 r10 = r2.mAdapter
            int r11 = r7.mPosition
            int r10 = r10.getItemViewType(r11)
            int r11 = r7.getItemViewType()
            if (r10 == r11) goto L_0x01d5
            goto L_0x01ee
        L_0x01d5:
            androidx.recyclerview.widget.g1 r10 = r2.mAdapter
            boolean r10 = r10.hasStableIds()
            if (r10 == 0) goto L_0x01f0
            long r10 = r7.getItemId()
            androidx.recyclerview.widget.g1 r12 = r2.mAdapter
            int r13 = r7.mPosition
            long r12 = r12.getItemId(r13)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x01ee
            goto L_0x01f0
        L_0x01ee:
            r10 = 0
            goto L_0x01f1
        L_0x01f0:
            r10 = 1
        L_0x01f1:
            if (r10 != 0) goto L_0x0214
            r10 = 4
            r7.addFlags(r10)
            boolean r10 = r7.isScrap()
            if (r10 == 0) goto L_0x0206
            android.view.View r10 = r7.itemView
            r2.removeDetachedView(r10, r4)
            r7.unScrap()
            goto L_0x020f
        L_0x0206:
            boolean r10 = r7.wasReturnedFromScrap()
            if (r10 == 0) goto L_0x020f
            r7.clearReturnedFromScrapFlag()
        L_0x020f:
            r0.k(r7)
            r7 = 0
            goto L_0x022a
        L_0x0214:
            r3 = 1
            goto L_0x022a
        L_0x0216:
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Inconsistency detected. Invalid view holder adapter position"
            r3.<init>(r4)
            r3.append(r7)
            java.lang.String r2 = android.support.v4.media.h.h(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x022a:
            if (r7 != 0) goto L_0x03f3
            androidx.recyclerview.widget.b r12 = r2.mAdapterHelper
            int r12 = r12.f(r1, r4)
            if (r12 < 0) goto L_0x03c2
            androidx.recyclerview.widget.g1 r13 = r2.mAdapter
            int r13 = r13.getItemCount()
            if (r12 >= r13) goto L_0x03c2
            androidx.recyclerview.widget.g1 r13 = r2.mAdapter
            int r13 = r13.getItemViewType(r12)
            androidx.recyclerview.widget.g1 r14 = r2.mAdapter
            boolean r14 = r14.hasStableIds()
            if (r14 == 0) goto L_0x02d9
            androidx.recyclerview.widget.g1 r7 = r2.mAdapter
            long r14 = r7.getItemId(r12)
            int r7 = r8.size()
            int r7 = r7 + r9
        L_0x0255:
            if (r7 < 0) goto L_0x02a6
            java.lang.Object r16 = r8.get(r7)
            r10 = r16
            androidx.recyclerview.widget.k2 r10 = (androidx.recyclerview.widget.k2) r10
            long r17 = r10.getItemId()
            int r11 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r11 != 0) goto L_0x02a3
            boolean r11 = r10.wasReturnedFromScrap()
            if (r11 != 0) goto L_0x02a3
            int r11 = r10.getItemViewType()
            if (r13 != r11) goto L_0x028a
            r10.addFlags(r5)
            boolean r5 = r10.isRemoved()
            if (r5 == 0) goto L_0x0288
            androidx.recyclerview.widget.g2 r5 = r2.mState
            boolean r5 = r5.f2024g
            if (r5 != 0) goto L_0x0288
            r5 = 2
            r6 = 14
            r10.setFlags(r5, r6)
        L_0x0288:
            r7 = r10
            goto L_0x02d4
        L_0x028a:
            r8.remove(r7)
            android.view.View r11 = r10.itemView
            r2.removeDetachedView(r11, r4)
            android.view.View r10 = r10.itemView
            androidx.recyclerview.widget.k2 r10 = androidx.recyclerview.widget.RecyclerView.getChildViewHolderInt(r10)
            r11 = 0
            r10.mScrapContainer = r11
            r10.mInChangeScrap = r4
            r10.clearReturnedFromScrapFlag()
            r0.k(r10)
        L_0x02a3:
            int r7 = r7 + -1
            goto L_0x0255
        L_0x02a6:
            int r5 = r6.size()
            int r5 = r5 + r9
        L_0x02ab:
            if (r5 < 0) goto L_0x02d2
            java.lang.Object r7 = r6.get(r5)
            androidx.recyclerview.widget.k2 r7 = (androidx.recyclerview.widget.k2) r7
            long r10 = r7.getItemId()
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 != 0) goto L_0x02cf
            boolean r8 = r7.isAttachedToTransitionOverlay()
            if (r8 != 0) goto L_0x02cf
            int r8 = r7.getItemViewType()
            if (r13 != r8) goto L_0x02cb
            r6.remove(r5)
            goto L_0x02d4
        L_0x02cb:
            r0.i(r5)
            goto L_0x02d2
        L_0x02cf:
            int r5 = r5 + -1
            goto L_0x02ab
        L_0x02d2:
            r5 = 0
            r7 = r5
        L_0x02d4:
            if (r7 == 0) goto L_0x02d9
            r7.mPosition = r12
            r3 = 1
        L_0x02d9:
            if (r7 != 0) goto L_0x0314
            androidx.recyclerview.widget.i2 r5 = r0.f2257h
            if (r5 == 0) goto L_0x0314
            android.view.View r5 = r5.a()
            if (r5 == 0) goto L_0x0314
            androidx.recyclerview.widget.k2 r7 = r2.getChildViewHolder(r5)
            if (r7 == 0) goto L_0x0303
            boolean r5 = r7.shouldIgnore()
            if (r5 != 0) goto L_0x02f2
            goto L_0x0314
        L_0x02f2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
            r3.<init>(r4)
            java.lang.String r2 = android.support.v4.media.h.h(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0303:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
            r3.<init>(r4)
            java.lang.String r2 = android.support.v4.media.h.h(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x0314:
            if (r7 != 0) goto L_0x035f
            androidx.recyclerview.widget.x1 r5 = r19.c()
            android.util.SparseArray r5 = r5.f2232a
            java.lang.Object r5 = r5.get(r13)
            androidx.recyclerview.widget.w1 r5 = (androidx.recyclerview.widget.w1) r5
            if (r5 == 0) goto L_0x0349
            java.util.ArrayList r5 = r5.f2225a
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x0349
            int r6 = r5.size()
            int r6 = r6 + r9
        L_0x0331:
            if (r6 < 0) goto L_0x0349
            java.lang.Object r7 = r5.get(r6)
            androidx.recyclerview.widget.k2 r7 = (androidx.recyclerview.widget.k2) r7
            boolean r7 = r7.isAttachedToTransitionOverlay()
            if (r7 != 0) goto L_0x0346
            java.lang.Object r5 = r5.remove(r6)
            androidx.recyclerview.widget.k2 r5 = (androidx.recyclerview.widget.k2) r5
            goto L_0x034a
        L_0x0346:
            int r6 = r6 + -1
            goto L_0x0331
        L_0x0349:
            r5 = 0
        L_0x034a:
            if (r5 == 0) goto L_0x035e
            r5.resetInternal()
            boolean r6 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
            if (r6 == 0) goto L_0x035e
            android.view.View r6 = r5.itemView
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x035e
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            e(r6, r4)
        L_0x035e:
            r7 = r5
        L_0x035f:
            if (r7 != 0) goto L_0x03f3
            long r5 = r2.getNanoTime()
            r7 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r9 = (r21 > r7 ? 1 : (r21 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0389
            androidx.recyclerview.widget.x1 r7 = r0.f2256g
            androidx.recyclerview.widget.w1 r7 = r7.a(r13)
            long r7 = r7.f2227c
            r9 = 0
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x0384
            long r7 = r7 + r5
            int r9 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r9 >= 0) goto L_0x0382
            goto L_0x0384
        L_0x0382:
            r7 = 0
            goto L_0x0385
        L_0x0384:
            r7 = 1
        L_0x0385:
            if (r7 != 0) goto L_0x0389
            r1 = 0
            return r1
        L_0x0389:
            androidx.recyclerview.widget.g1 r7 = r2.mAdapter
            androidx.recyclerview.widget.k2 r7 = r7.createViewHolder(r2, r13)
            boolean r8 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r8 == 0) goto L_0x03a2
            android.view.View r8 = r7.itemView
            androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r8)
            if (r8 == 0) goto L_0x03a2
            java.lang.ref.WeakReference r9 = new java.lang.ref.WeakReference
            r9.<init>(r8)
            r7.mNestedRecyclerView = r9
        L_0x03a2:
            long r8 = r2.getNanoTime()
            androidx.recyclerview.widget.x1 r10 = r0.f2256g
            long r8 = r8 - r5
            androidx.recyclerview.widget.w1 r5 = r10.a(r13)
            long r10 = r5.f2227c
            r12 = 0
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x03b6
            goto L_0x03bf
        L_0x03b6:
            r12 = 4
            long r10 = r10 / r12
            r14 = 3
            long r10 = r10 * r14
            long r8 = r8 / r12
            long r8 = r8 + r10
        L_0x03bf:
            r5.f2227c = r8
            goto L_0x03f3
        L_0x03c2:
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Inconsistency detected. Invalid item position "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r1 = "(offset:"
            r4.append(r1)
            r4.append(r12)
            java.lang.String r1 = ").state:"
            r4.append(r1)
            androidx.recyclerview.widget.g2 r1 = r2.mState
            int r1 = r1.b()
            r4.append(r1)
            java.lang.String r1 = r2.exceptionLabel()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            throw r3
        L_0x03f3:
            if (r3 == 0) goto L_0x0433
            androidx.recyclerview.widget.g2 r5 = r2.mState
            boolean r5 = r5.f2024g
            if (r5 != 0) goto L_0x0433
            r5 = 8192(0x2000, float:1.14794E-41)
            boolean r6 = r7.hasAnyOfTheFlags(r5)
            if (r6 == 0) goto L_0x0433
            r7.setFlags(r4, r5)
            androidx.recyclerview.widget.g2 r5 = r2.mState
            boolean r5 = r5.f2027j
            if (r5 == 0) goto L_0x0433
            androidx.recyclerview.widget.n1.e(r7)
            androidx.recyclerview.widget.n1 r5 = r2.mItemAnimator
            r7.getUnmodifiedPayloads()
            r5.getClass()
            androidx.recyclerview.widget.m1 r5 = new androidx.recyclerview.widget.m1
            r5.<init>()
            android.view.View r6 = r7.itemView
            int r8 = r6.getLeft()
            r5.f2084a = r8
            int r8 = r6.getTop()
            r5.f2085b = r8
            r6.getRight()
            r6.getBottom()
            r2.recordAnimationInfoIfBouncedHiddenView(r7, r5)
        L_0x0433:
            androidx.recyclerview.widget.g2 r5 = r2.mState
            boolean r5 = r5.f2024g
            if (r5 == 0) goto L_0x0442
            boolean r5 = r7.isBound()
            if (r5 == 0) goto L_0x0442
            r7.mPreLayoutPosition = r1
            goto L_0x0489
        L_0x0442:
            boolean r5 = r7.isBound()
            if (r5 == 0) goto L_0x0454
            boolean r5 = r7.needsUpdate()
            if (r5 != 0) goto L_0x0454
            boolean r5 = r7.isInvalid()
            if (r5 == 0) goto L_0x0489
        L_0x0454:
            androidx.recyclerview.widget.b r5 = r2.mAdapterHelper
            int r4 = r5.f(r1, r4)
            r5 = 0
            r7.mBindingAdapter = r5
            r7.mOwnerRecyclerView = r2
            int r6 = r7.getItemViewType()
            long r8 = r2.getNanoTime()
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r12 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x048c
            androidx.recyclerview.widget.x1 r10 = r0.f2256g
            androidx.recyclerview.widget.w1 r6 = r10.a(r6)
            long r10 = r6.f2228d
            r12 = 0
            int r6 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x0486
            long r10 = r10 + r8
            int r6 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r6 >= 0) goto L_0x0484
            goto L_0x0486
        L_0x0484:
            r6 = 0
            goto L_0x0487
        L_0x0486:
            r6 = 1
        L_0x0487:
            if (r6 != 0) goto L_0x048c
        L_0x0489:
            r1 = 0
            goto L_0x0505
        L_0x048c:
            androidx.recyclerview.widget.g1 r6 = r2.mAdapter
            r6.bindViewHolder(r7, r4)
            long r10 = r2.getNanoTime()
            androidx.recyclerview.widget.x1 r4 = r0.f2256g
            int r6 = r7.getItemViewType()
            long r10 = r10 - r8
            androidx.recyclerview.widget.w1 r4 = r4.a(r6)
            long r8 = r4.f2228d
            r12 = 0
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 != 0) goto L_0x04a9
            goto L_0x04b2
        L_0x04a9:
            r12 = 4
            long r8 = r8 / r12
            r14 = 3
            long r8 = r8 * r14
            long r10 = r10 / r12
            long r10 = r10 + r8
        L_0x04b2:
            r4.f2228d = r10
            boolean r4 = r2.isAccessibilityEnabled()
            if (r4 == 0) goto L_0x04fc
            android.view.View r4 = r7.itemView
            java.util.WeakHashMap r6 = m0.c1.f10054a
            int r6 = m0.i0.c(r4)
            if (r6 != 0) goto L_0x04c8
            r6 = 1
            m0.i0.s(r4, r6)
        L_0x04c8:
            androidx.recyclerview.widget.m2 r6 = r2.mAccessibilityDelegate
            if (r6 != 0) goto L_0x04cd
            goto L_0x04fc
        L_0x04cd:
            m0.c r6 = r6.j()
            boolean r8 = r6 instanceof androidx.recyclerview.widget.l2
            if (r8 == 0) goto L_0x04f9
            r8 = r6
            androidx.recyclerview.widget.l2 r8 = (androidx.recyclerview.widget.l2) r8
            r8.getClass()
            android.view.View$AccessibilityDelegate r9 = m0.c1.c(r4)
            if (r9 != 0) goto L_0x04e2
            goto L_0x04f0
        L_0x04e2:
            boolean r5 = r9 instanceof m0.a
            if (r5 == 0) goto L_0x04eb
            m0.a r9 = (m0.a) r9
            m0.c r5 = r9.f10038a
            goto L_0x04f0
        L_0x04eb:
            m0.c r5 = new m0.c
            r5.<init>(r9)
        L_0x04f0:
            if (r5 == 0) goto L_0x04f9
            if (r5 == r8) goto L_0x04f9
            java.util.WeakHashMap r8 = r8.f2076e
            r8.put(r4, r5)
        L_0x04f9:
            m0.c1.p(r4, r6)
        L_0x04fc:
            androidx.recyclerview.widget.g2 r4 = r2.mState
            boolean r4 = r4.f2024g
            if (r4 == 0) goto L_0x0504
            r7.mPreLayoutPosition = r1
        L_0x0504:
            r1 = 1
        L_0x0505:
            android.view.View r4 = r7.itemView
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            if (r4 != 0) goto L_0x0512
            android.view.ViewGroup$LayoutParams r2 = r2.generateDefaultLayoutParams()
            goto L_0x051c
        L_0x0512:
            boolean r5 = r2.checkLayoutParams(r4)
            if (r5 != 0) goto L_0x0524
            android.view.ViewGroup$LayoutParams r2 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r4)
        L_0x051c:
            androidx.recyclerview.widget.r1 r2 = (androidx.recyclerview.widget.r1) r2
            android.view.View r4 = r7.itemView
            r4.setLayoutParams(r2)
            goto L_0x0527
        L_0x0524:
            r2 = r4
            androidx.recyclerview.widget.r1 r2 = (androidx.recyclerview.widget.r1) r2
        L_0x0527:
            r2.f2184h = r7
            if (r3 == 0) goto L_0x052f
            if (r1 == 0) goto L_0x052f
            r1 = 1
            goto L_0x0530
        L_0x052f:
            r1 = 0
        L_0x0530:
            r2.f2187k = r1
            return r7
        L_0x0533:
            java.lang.IndexOutOfBoundsException r3 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Invalid item position "
            r4.<init>(r5)
            r4.append(r1)
            java.lang.String r5 = "("
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = "). Item count:"
            r4.append(r1)
            androidx.recyclerview.widget.g2 r1 = r2.mState
            int r1 = r1.b()
            r4.append(r1)
            java.lang.String r1 = r2.exceptionLabel()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.y1.m(int, long):androidx.recyclerview.widget.k2");
    }

    public final void n(k2 k2Var) {
        (k2Var.mInChangeScrap ? this.f2251b : this.f2250a).remove(k2Var);
        k2Var.mScrapContainer = null;
        k2Var.mInChangeScrap = false;
        k2Var.clearReturnedFromScrapFlag();
    }

    public final void o() {
        q1 q1Var = this.f2258i.mLayout;
        this.f2255f = this.f2254e + (q1Var != null ? q1Var.f2152q : 0);
        ArrayList arrayList = this.f2252c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f2255f; size--) {
            i(size);
        }
    }
}
