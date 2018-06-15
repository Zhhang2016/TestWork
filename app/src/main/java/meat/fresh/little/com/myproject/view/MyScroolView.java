package meat.fresh.little.com.myproject.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

/**
 * 创建日期：2018/6/15
 * 描述: Edittext中的文字过长时候，如果再次获取焦点则会使EditText向上滚动过多以至于无法正常显示文本
 *
 * @author: zhaoh
 */
public class MyScroolView extends ScrollView {
    public MyScroolView(Context context) {
        super(context);
    }

    public MyScroolView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScroolView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        if (child instanceof EditText){
            return true;
        }
        return false;
    }
}
