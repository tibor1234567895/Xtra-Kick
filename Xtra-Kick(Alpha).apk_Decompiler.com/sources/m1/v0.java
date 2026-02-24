package m1;

import pb.r1;

public final class v0 extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v0(int i10) {
        super(i10 != 1 ? i10 != 2 ? i10 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.");
    }

    public v0(r1 r1Var) {
        super("HTTP " + r1Var.f12964k + ": " + r1Var.f12963j);
    }
}
