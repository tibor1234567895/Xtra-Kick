package com.github.andreyasadchy.xtra.ui.login;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.woxthebox.draglistview.R;
import hb.h0;
import r6.a;

public final class LoginActivity extends a {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h0.g(this);
        View inflate = getLayoutInflater().inflate(R.layout.activity_login, (ViewGroup) null, false);
        int i10 = R.id.havingTrouble;
        if (((TextView) e4.a.a(inflate, R.id.havingTrouble)) != null) {
            i10 = R.id.progressBar;
            if (((ProgressBar) e4.a.a(inflate, R.id.progressBar)) != null) {
                i10 = R.id.webView;
                if (((WebView) e4.a.a(inflate, R.id.webView)) != null) {
                    i10 = R.id.webViewContainer;
                    if (((LinearLayout) e4.a.a(inflate, R.id.webViewContainer)) != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
                        switch (3) {
                        }
                        setContentView((View) constraintLayout);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }
}
