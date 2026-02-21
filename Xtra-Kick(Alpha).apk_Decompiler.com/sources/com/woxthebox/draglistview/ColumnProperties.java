package com.woxthebox.draglistview;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.o1;
import androidx.recyclerview.widget.q1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColumnProperties {
    private int mColumnBackgroundColor;
    private Drawable mColumnBackgroundDrawable;
    private View mColumnDragView;
    private Integer mColumnWidth;
    private DragItemAdapter mDragItemAdapter;
    private View mFooter;
    private boolean mHasFixedItemSize;
    private View mHeader;
    private List<o1> mItemDecorations;
    private int mItemsSectionBackgroundColor;
    private q1 mLayoutManager;

    public static class Builder {
        private int mColumnBackgroundColor = 0;
        private Drawable mColumnBackgroundDrawable = null;
        private View mColumnDragView = null;
        private Integer mColumnWidth = null;
        private DragItemAdapter mDragItemAdapter;
        private View mFooter = null;
        private boolean mHasFixedItemSize = false;
        private View mHeader = null;
        private ArrayList<o1> mItemDecoration = new ArrayList<>();
        private int mItemsSectionBackgroundColor = 0;
        private q1 mLayoutManager = null;

        private Builder(DragItemAdapter dragItemAdapter) {
            this.mDragItemAdapter = dragItemAdapter;
        }

        public static Builder newBuilder(DragItemAdapter dragItemAdapter) {
            return new Builder(dragItemAdapter);
        }

        public Builder addItemDecorations(o1... o1VarArr) {
            Collections.addAll(this.mItemDecoration, o1VarArr);
            return this;
        }

        public ColumnProperties build() {
            return new ColumnProperties(this.mDragItemAdapter, this.mLayoutManager, this.mItemDecoration, this.mHasFixedItemSize, this.mColumnBackgroundColor, this.mItemsSectionBackgroundColor, this.mColumnDragView, this.mHeader, this.mFooter, this.mColumnWidth, this.mColumnBackgroundDrawable);
        }

        public Builder setColumnBackgroundColor(int i10) {
            this.mColumnBackgroundColor = i10;
            return this;
        }

        public Builder setColumnBackgroundDrawable(Drawable drawable) {
            this.mColumnBackgroundDrawable = drawable;
            return this;
        }

        public Builder setColumnDragView(View view) {
            this.mColumnDragView = view;
            return this;
        }

        public Builder setColumnWidth(Integer num) {
            this.mColumnWidth = num;
            return this;
        }

        public Builder setFooter(View view) {
            this.mFooter = view;
            return this;
        }

        public Builder setHasFixedItemSize(boolean z10) {
            this.mHasFixedItemSize = z10;
            return this;
        }

        public Builder setHeader(View view) {
            this.mHeader = view;
            return this;
        }

        public Builder setItemsSectionBackgroundColor(int i10) {
            this.mItemsSectionBackgroundColor = i10;
            return this;
        }

        public Builder setLayoutManager(q1 q1Var) {
            this.mLayoutManager = q1Var;
            return this;
        }
    }

    private ColumnProperties(DragItemAdapter dragItemAdapter, q1 q1Var, List<o1> list, boolean z10, int i10, int i11, View view, View view2, View view3, Integer num, Drawable drawable) {
        this.mDragItemAdapter = dragItemAdapter;
        this.mLayoutManager = q1Var;
        this.mItemDecorations = list;
        this.mHasFixedItemSize = z10;
        this.mColumnBackgroundColor = i10;
        this.mItemsSectionBackgroundColor = i11;
        this.mHeader = view2;
        this.mFooter = view3;
        this.mColumnDragView = view;
        this.mColumnWidth = num;
        this.mColumnBackgroundDrawable = drawable;
    }

    public int getColumnBackgroundColor() {
        return this.mColumnBackgroundColor;
    }

    public Drawable getColumnBackgroundDrawable() {
        return this.mColumnBackgroundDrawable;
    }

    public View getColumnDragView() {
        return this.mColumnDragView;
    }

    public Integer getColumnWidth() {
        return this.mColumnWidth;
    }

    public DragItemAdapter getDragItemAdapter() {
        return this.mDragItemAdapter;
    }

    public View getFooter() {
        return this.mFooter;
    }

    public View getHeader() {
        return this.mHeader;
    }

    public List<o1> getItemDecorations() {
        return this.mItemDecorations;
    }

    public int getItemsSectionBackgroundColor() {
        return this.mItemsSectionBackgroundColor;
    }

    public q1 getLayoutManager() {
        return this.mLayoutManager;
    }

    public boolean hasFixedItemSize() {
        return this.mHasFixedItemSize;
    }
}
