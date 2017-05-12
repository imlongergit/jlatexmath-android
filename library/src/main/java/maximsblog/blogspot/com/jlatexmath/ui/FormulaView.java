package maximsblog.blogspot.com.jlatexmath.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import maximsblog.blogspot.com.jlatexmath.core.AjLatexMath;
import maximsblog.blogspot.com.jlatexmath.core.Insets;
import maximsblog.blogspot.com.jlatexmath.core.TeXConstants;
import maximsblog.blogspot.com.jlatexmath.core.TeXFormula;
import maximsblog.blogspot.com.jlatexmath.core.TeXIcon;

/**
 * @author liuxiaolong
 */
public class FormulaView extends View {

    private static final int DEFAULT_TEXT_SIZE = 16;

    private TeXFormula teXFormula;
    private TeXIcon teXIcon;
    private int textSize = DEFAULT_TEXT_SIZE;

    public FormulaView(Context context) {
        super(context);
    }

    public FormulaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FormulaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTex(@NonNull String tex) {
        teXFormula = new TeXFormula(tex);
        teXIcon = teXFormula.new TeXIconBuilder()
                .setStyle(TeXConstants.STYLE_DISPLAY)
                .setSize(textSize)
                .setWidth(TeXConstants.UNIT_PIXEL, getResources().getDisplayMetrics().widthPixels, TeXConstants.ALIGN_LEFT)
                .setIsMaxWidth(true)
                .setInterLineSpacing(TeXConstants.UNIT_PIXEL,
                        AjLatexMath.getLeading(textSize)).build();
        teXIcon.setInsets(new Insets(5, 5, 5, 5));
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = MeasureSpec.getSize(widthMeasureSpec);
        } else {
            width = teXIcon.getIconWidth();
        }
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int height;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = MeasureSpec.getSize(heightMeasureSpec);
        } else {
            height = teXIcon.getIconHeight();
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        teXIcon.paintIcon(canvas, 0, 0);
    }
}
