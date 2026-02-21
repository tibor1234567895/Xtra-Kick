package com.woxthebox.draglistview;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.DragItemAdapter.ViewHolder;
import java.util.Collections;
import java.util.List;

public abstract class DragItemAdapter<T, VH extends ViewHolder> extends g1 {
    private long mDragItemId = -1;
    private DragStartCallback mDragStartCallback;
    private long mDropTargetId = -1;
    protected List<T> mItemList;

    public interface DragStartCallback {
        boolean isDragging();

        boolean startDrag(View view, long j10);
    }

    public static abstract class ViewHolder extends k2 {
        /* access modifiers changed from: private */
        public DragStartCallback mDragStartCallback;
        public View mGrabView;
        public long mItemId;

        public ViewHolder(final View view, int i10, boolean z10) {
            super(view);
            View findViewById = view.findViewById(i10);
            this.mGrabView = findViewById;
            if (z10) {
                findViewById.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        if (ViewHolder.this.mDragStartCallback == null) {
                            return false;
                        }
                        if (ViewHolder.this.mDragStartCallback.startDrag(view, ViewHolder.this.mItemId)) {
                            return true;
                        }
                        View view2 = view;
                        ViewHolder viewHolder = ViewHolder.this;
                        if (view2 == viewHolder.mGrabView) {
                            return viewHolder.onItemLongClicked(view);
                        }
                        return false;
                    }
                });
            } else {
                findViewById.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        if (ViewHolder.this.mDragStartCallback == null) {
                            return false;
                        }
                        if (motionEvent.getAction() == 0 && ViewHolder.this.mDragStartCallback.startDrag(view, ViewHolder.this.mItemId)) {
                            return true;
                        }
                        if (!ViewHolder.this.mDragStartCallback.isDragging()) {
                            View view2 = view;
                            ViewHolder viewHolder = ViewHolder.this;
                            if (view2 == viewHolder.mGrabView) {
                                return viewHolder.onItemTouch(view, motionEvent);
                            }
                        }
                        return false;
                    }
                });
            }
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    ViewHolder.this.onItemClicked(view);
                }
            });
            if (view != this.mGrabView) {
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return ViewHolder.this.onItemLongClicked(view);
                    }
                });
                view.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return ViewHolder.this.onItemTouch(view, motionEvent);
                    }
                });
            }
        }

        public void onItemClicked(View view) {
        }

        public boolean onItemLongClicked(View view) {
            return false;
        }

        public boolean onItemTouch(View view, MotionEvent motionEvent) {
            return false;
        }

        public void setDragStartCallback(DragStartCallback dragStartCallback) {
            this.mDragStartCallback = dragStartCallback;
        }
    }

    public DragItemAdapter() {
        setHasStableIds(true);
    }

    public void addItem(int i10, T t10) {
        List<T> list = this.mItemList;
        if (list != null && list.size() >= i10) {
            this.mItemList.add(i10, t10);
            notifyItemInserted(i10);
        }
    }

    public void changeItemPosition(int i10, int i11) {
        List<T> list = this.mItemList;
        if (list != null && list.size() > i10 && this.mItemList.size() > i11) {
            this.mItemList.add(i11, this.mItemList.remove(i10));
            notifyItemMoved(i10, i11);
        }
    }

    public long getDropTargetId() {
        return this.mDropTargetId;
    }

    public int getItemCount() {
        List<T> list = this.mItemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final long getItemId(int i10) {
        return getUniqueItemId(i10);
    }

    public List<T> getItemList() {
        return this.mItemList;
    }

    public int getPositionForItem(T t10) {
        int itemCount = getItemCount();
        for (int i10 = 0; i10 < itemCount; i10++) {
            if (this.mItemList.get(i10) == t10) {
                return i10;
            }
        }
        return -1;
    }

    public int getPositionForItemId(long j10) {
        int itemCount = getItemCount();
        for (int i10 = 0; i10 < itemCount; i10++) {
            if (j10 == getItemId(i10)) {
                return i10;
            }
        }
        return -1;
    }

    public abstract long getUniqueItemId(int i10);

    public Object removeItem(int i10) {
        List<T> list = this.mItemList;
        if (list == null || list.size() <= i10 || i10 < 0) {
            return null;
        }
        T remove = this.mItemList.remove(i10);
        notifyItemRemoved(i10);
        return remove;
    }

    public void setDragItemId(long j10) {
        this.mDragItemId = j10;
    }

    public void setDragStartedListener(DragStartCallback dragStartCallback) {
        this.mDragStartCallback = dragStartCallback;
    }

    public void setDropTargetId(long j10) {
        this.mDropTargetId = j10;
    }

    public void setItemList(List<T> list) {
        this.mItemList = list;
        notifyDataSetChanged();
    }

    public void swapItems(int i10, int i11) {
        List<T> list = this.mItemList;
        if (list != null && list.size() > i10 && this.mItemList.size() > i11) {
            Collections.swap(this.mItemList, i10, i11);
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(VH vh, int i10) {
        long itemId = getItemId(i10);
        vh.mItemId = itemId;
        vh.itemView.setVisibility(this.mDragItemId == itemId ? 4 : 0);
        vh.setDragStartCallback(this.mDragStartCallback);
    }

    public void onViewRecycled(VH vh) {
        vh.setDragStartCallback((DragStartCallback) null);
    }
}
