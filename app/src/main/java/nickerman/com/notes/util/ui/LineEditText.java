package nickerman.com.notes.util.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.View;

public class LineEditText extends AppCompatEditText {
    private Rect mRect;
    private Paint mPaint;

    public LineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mRect = new Rect();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(0xFFFFD966);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int height = ((View) this.getParent()).getHeight();
        int lineHeight = getLineHeight();
        int numberOfLine = height / lineHeight;

        Rect r = this.mRect;
        Paint paint = this.mPaint;
        int baseLine = getLineBounds(0, r);

        for (int i = 0; i < numberOfLine; i++) {
            canvas.drawLine(r.left, baseLine + 1, r.right, baseLine + 1, paint);
            baseLine += lineHeight;
        }

        super.onDraw(canvas);
    }
}
