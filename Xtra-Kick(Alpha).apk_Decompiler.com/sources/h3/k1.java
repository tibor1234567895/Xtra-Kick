package h3;

import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.o;
import java.util.Collections;
import java.util.List;

public final class k1 {

    /* renamed from: a  reason: collision with root package name */
    public final o f7152a;

    /* renamed from: b  reason: collision with root package name */
    public final PlaybackStateCompat f7153b;

    /* renamed from: c  reason: collision with root package name */
    public final MediaMetadataCompat f7154c;

    /* renamed from: d  reason: collision with root package name */
    public final List f7155d;

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f7156e;

    /* renamed from: f  reason: collision with root package name */
    public final int f7157f;

    /* renamed from: g  reason: collision with root package name */
    public final int f7158g;

    public k1() {
        this.f7152a = null;
        this.f7153b = null;
        this.f7154c = null;
        this.f7155d = Collections.emptyList();
        this.f7156e = null;
        this.f7157f = 0;
        this.f7158g = 0;
    }

    public k1(o oVar, PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat, List list, CharSequence charSequence, int i10, int i11) {
        this.f7152a = oVar;
        this.f7153b = playbackStateCompat;
        this.f7154c = mediaMetadataCompat;
        list.getClass();
        this.f7155d = list;
        this.f7156e = charSequence;
        this.f7157f = i10;
        this.f7158g = i11;
    }

    public k1(k1 k1Var) {
        this.f7152a = k1Var.f7152a;
        this.f7153b = k1Var.f7153b;
        this.f7154c = k1Var.f7154c;
        this.f7155d = k1Var.f7155d;
        this.f7156e = k1Var.f7156e;
        this.f7157f = k1Var.f7157f;
        this.f7158g = k1Var.f7158g;
    }
}
