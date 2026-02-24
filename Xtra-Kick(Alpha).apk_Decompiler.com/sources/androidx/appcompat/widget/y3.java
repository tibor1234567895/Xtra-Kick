package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;

public final class y3 implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SearchView f1132h;

    public y3(SearchView searchView) {
        this.f1132h = searchView;
    }

    public final void onClick(View view) {
        String str;
        SearchView searchView = this.f1132h;
        ImageView imageView = searchView.A;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f657w;
        if (view == imageView) {
            searchView.y(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.T;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
            }
        } else if (view == searchView.C) {
            searchView.o();
        } else if (view == searchView.B) {
            searchView.s();
        } else if (view == searchView.D) {
            SearchableInfo searchableInfo = searchView.f652k0;
            if (searchableInfo != null) {
                try {
                    if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        Intent intent = new Intent(searchView.O);
                        ComponentName searchActivity = searchableInfo.getSearchActivity();
                        if (searchActivity == null) {
                            str = null;
                        } else {
                            str = searchActivity.flattenToShortString();
                        }
                        intent.putExtra("calling_package", str);
                        searchView.getContext().startActivity(intent);
                    } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        searchView.getContext().startActivity(searchView.m(searchView.P, searchableInfo));
                    }
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                }
            }
        } else if (view == searchAutoComplete) {
            searchView.n();
        }
    }
}
