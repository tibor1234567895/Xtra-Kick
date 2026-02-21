package q9;

import androidx.appcompat.widget.j3;
import com.tonyodev.fetch2.database.DownloadDatabase;
import java.util.Map;
import p9.d;
import p9.f;
import p9.p;
import p9.r;
import p9.x;
import r3.l;
import u3.o;
import xa.j;

public final class b extends l {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f13431d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ j3 f13432e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(j3 j3Var, DownloadDatabase downloadDatabase, int i10) {
        super(downloadDatabase, 0);
        this.f13431d = i10;
        this.f13432e = j3Var;
    }

    public final String e() {
        switch (this.f13431d) {
            case 0:
                return "DELETE FROM `requests` WHERE `_id` = ?";
            default:
                return "UPDATE OR REPLACE `requests` SET `_id` = ?,`_namespace` = ?,`_url` = ?,`_file` = ?,`_group` = ?,`_priority` = ?,`_headers` = ?,`_written_bytes` = ?,`_total_bytes` = ?,`_status` = ?,`_error` = ?,`_network_type` = ?,`_created` = ?,`_tag` = ?,`_enqueue_action` = ?,`_identifier` = ?,`_download_on_enqueue` = ?,`_extras` = ?,`_auto_retry_max_attempts` = ?,`_auto_retry_attempts` = ? WHERE `_id` = ?";
        }
    }

    public final /* bridge */ /* synthetic */ void h(o oVar, Object obj) {
        switch (this.f13431d) {
            case 0:
                l(oVar, (e) obj);
                return;
            default:
                l(oVar, (e) obj);
                return;
        }
    }

    public final void l(o oVar, e eVar) {
        switch (this.f13431d) {
            case 0:
                oVar.g0(1, (long) eVar.f13433h);
                return;
            default:
                oVar.g0(1, (long) eVar.f13433h);
                String str = eVar.f13434i;
                if (str == null) {
                    oVar.F(2);
                } else {
                    oVar.q(2, str);
                }
                String str2 = eVar.f13435j;
                if (str2 == null) {
                    oVar.F(3);
                } else {
                    oVar.q(3, str2);
                }
                String str3 = eVar.f13436k;
                if (str3 == null) {
                    oVar.F(4);
                } else {
                    oVar.q(4, str3);
                }
                oVar.g0(5, (long) eVar.f13437l);
                j3 j3Var = this.f13432e;
                r rVar = eVar.f13438m;
                ((a) j3Var.f896c).getClass();
                j.g("priority", rVar);
                oVar.g0(6, (long) rVar.f12715h);
                Map map = eVar.f13439n;
                ((a) j3Var.f896c).getClass();
                oVar.q(7, a.i(map));
                oVar.g0(8, eVar.f13440o);
                oVar.g0(9, eVar.f13441p);
                x xVar = eVar.f13442q;
                ((a) j3Var.f896c).getClass();
                j.g("status", xVar);
                oVar.g0(10, (long) xVar.f12744h);
                f fVar = eVar.f13443r;
                ((a) j3Var.f896c).getClass();
                j.g("error", fVar);
                oVar.g0(11, (long) fVar.f12655h);
                p pVar = eVar.f13444s;
                ((a) j3Var.f896c).getClass();
                j.g("networkType", pVar);
                oVar.g0(12, (long) pVar.f12709h);
                oVar.g0(13, eVar.f13445t);
                String str4 = eVar.f13446u;
                if (str4 == null) {
                    oVar.F(14);
                } else {
                    oVar.q(14, str4);
                }
                d dVar = eVar.f13447v;
                ((a) j3Var.f896c).getClass();
                j.g("enqueueAction", dVar);
                oVar.g0(15, (long) dVar.f12636h);
                oVar.g0(16, eVar.f13448w);
                oVar.g0(17, eVar.f13449x ? 1 : 0);
                y9.j jVar = eVar.f13450y;
                ((a) j3Var.f896c).getClass();
                oVar.q(18, a.d(jVar));
                oVar.g0(19, (long) eVar.f13451z);
                oVar.g0(20, (long) eVar.A);
                oVar.g0(21, (long) eVar.f13433h);
                return;
        }
    }
}
