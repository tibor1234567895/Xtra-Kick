package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import u.f;
import u.i;
import u.n;
import x.p;
import x.r;

public class Flow extends r {

    /* renamed from: q  reason: collision with root package name */
    public i f1164q;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1164q = new i();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f16499b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 0) {
                    this.f1164q.W0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    i iVar = this.f1164q;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    iVar.f15161t0 = dimensionPixelSize;
                    iVar.f15162u0 = dimensionPixelSize;
                    iVar.f15163v0 = dimensionPixelSize;
                    iVar.f15164w0 = dimensionPixelSize;
                } else if (index == 18) {
                    i iVar2 = this.f1164q;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    iVar2.f15163v0 = dimensionPixelSize2;
                    iVar2.f15165x0 = dimensionPixelSize2;
                    iVar2.f15166y0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f1164q.f15164w0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f1164q.f15165x0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f1164q.f15161t0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f1164q.f15166y0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f1164q.f15162u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f1164q.U0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f1164q.E0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f1164q.F0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f1164q.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f1164q.I0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f1164q.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f1164q.J0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f1164q.K0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f1164q.M0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f1164q.O0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f1164q.N0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f1164q.P0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f1164q.L0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f1164q.S0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f1164q.T0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f1164q.Q0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f1164q.R0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f1164q.V0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f16350k = this.f1164q;
        i();
    }

    public final void h(f fVar, boolean z10) {
        i iVar = this.f1164q;
        int i10 = iVar.f15163v0;
        if (i10 <= 0 && iVar.f15164w0 <= 0) {
            return;
        }
        if (z10) {
            iVar.f15165x0 = iVar.f15164w0;
            iVar.f15166y0 = i10;
            return;
        }
        iVar.f15165x0 = i10;
        iVar.f15166y0 = iVar.f15164w0;
    }

    public final void j(n nVar, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (nVar != null) {
            nVar.R(mode, size, mode2, size2);
            setMeasuredDimension(nVar.A0, nVar.B0);
            return;
        }
        setMeasuredDimension(0, 0);
    }

    public final void onMeasure(int i10, int i11) {
        j(this.f1164q, i10, i11);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f1164q.M0 = f10;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f1164q.G0 = i10;
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f1164q.N0 = f10;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f1164q.H0 = i10;
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f1164q.S0 = i10;
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f1164q.K0 = f10;
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f1164q.Q0 = i10;
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f1164q.E0 = i10;
        requestLayout();
    }

    public void setLastHorizontalBias(float f10) {
        this.f1164q.O0 = f10;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i10) {
        this.f1164q.I0 = i10;
        requestLayout();
    }

    public void setLastVerticalBias(float f10) {
        this.f1164q.P0 = f10;
        requestLayout();
    }

    public void setLastVerticalStyle(int i10) {
        this.f1164q.J0 = i10;
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f1164q.V0 = i10;
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f1164q.W0 = i10;
        requestLayout();
    }

    public void setPadding(int i10) {
        i iVar = this.f1164q;
        iVar.f15161t0 = i10;
        iVar.f15162u0 = i10;
        iVar.f15163v0 = i10;
        iVar.f15164w0 = i10;
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f1164q.f15162u0 = i10;
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f1164q.f15165x0 = i10;
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f1164q.f15166y0 = i10;
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f1164q.f15161t0 = i10;
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f1164q.T0 = i10;
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f1164q.L0 = f10;
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f1164q.R0 = i10;
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f1164q.F0 = i10;
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f1164q.U0 = i10;
        requestLayout();
    }
}
