package j0;

import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.KeyEvent;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import h3.g2;
import h3.x2;
import h9.v;
import j1.l0;
import j1.p;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import n0.x;
import pb.v1;
import s1.z;

public final class h implements z, v, x {

    /* renamed from: h  reason: collision with root package name */
    public int f8395h;

    /* renamed from: i  reason: collision with root package name */
    public Object f8396i;

    public h(int i10) {
        int[] iArr = new int[i10];
        this.f8396i = iArr;
        this.f8395h = iArr.length / 2;
    }

    public final MediaCodecInfo a(int i10) {
        if (((MediaCodecInfo[]) this.f8396i) == null) {
            this.f8396i = new MediaCodecList(this.f8395h).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f8396i)[i10];
    }

    public final boolean b(View view) {
        ((BottomSheetBehavior) this.f8396i).E(this.f8395h);
        return true;
    }

    public final void c(Throwable th) {
    }

    public final void d(Object obj) {
        l0.L(((x2) this.f8396i).f7437g.f7239l, new p((Object) this, this.f8395h, (Object) (List) obj, 4));
    }

    public final boolean e(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    public final int f() {
        if (((MediaCodecInfo[]) this.f8396i) == null) {
            this.f8396i = new MediaCodecList(this.f8395h).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f8396i).length;
    }

    public final boolean g(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    public final boolean h() {
        return true;
    }

    public final PendingIntent i(g2 g2Var, long j10) {
        int i10;
        int i11 = 0;
        if (j10 == 8 || j10 == 9) {
            i10 = 87;
        } else if (j10 == 6 || j10 == 7) {
            i10 = 88;
        } else if (j10 == 3) {
            i10 = 86;
        } else if (j10 == 12) {
            i10 = 90;
        } else if (j10 == 11) {
            i10 = 89;
        } else if (j10 == 1) {
            i10 = 85;
        } else {
            i10 = 0;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(g2Var.f7047a.f7229b);
        Service service = (Service) this.f8396i;
        intent.setComponent(new ComponentName(service, service.getClass()));
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i10));
        int i12 = l0.f8453a;
        if (i12 >= 26 && j10 == 1 && !g2Var.b().y()) {
            return PendingIntent.getForegroundService((Service) this.f8396i, i10, intent, 67108864);
        }
        Service service2 = (Service) this.f8396i;
        if (i12 >= 23) {
            i11 = 67108864;
        }
        return PendingIntent.getService(service2, i10, intent, i11);
    }

    public final int j(int i10) {
        return ((int[]) this.f8396i)[i10 + this.f8395h];
    }

    public final v1 k() {
        boolean z10;
        if (this.f8395h < ((List) this.f8396i).size()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i10 = this.f8395h;
            this.f8395h = i10 + 1;
            return (v1) ((List) this.f8396i).get(i10);
        }
        throw new NoSuchElementException();
    }

    public /* synthetic */ h(int i10, Object obj) {
        this.f8396i = obj;
        this.f8395h = i10;
    }

    public h(int i10, i[] iVarArr) {
        this.f8395h = i10;
        this.f8396i = iVarArr;
    }

    public h(Service service) {
        this.f8395h = 0;
        this.f8396i = service;
    }

    public h(ArrayList arrayList) {
        this.f8396i = arrayList;
    }

    public h(boolean z10, boolean z11) {
        this.f8395h = (z10 || z11) ? 1 : 0;
    }
}
