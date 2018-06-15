package meat.fresh.little.com.myproject.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import meat.fresh.little.com.myproject.R;

/**
 * 创建日期：2018/6/14
 * 描述: 测试ScroolViewListView 冲突解决
 *
 * @author: zhaoh
 */
public class TestScroolViewConflictEditText extends Activity {

    @BindView(R.id.sv)
    ScrollView sv;
    @BindView(R.id.my_edit)
    EditText myEdit;

    public static final String TAG = "TestScroolViewConflict";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_conflict);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        myEdit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == R.id.my_edit) {
                    if(isCanScrool(myEdit)){
                         v.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    switch (event.getAction()&MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });


    }


    public boolean isCanScrool(EditText editText) {
        // TestScroolViewConflict: scroolY==78;scroolRange==378;eventHeght==300;diff==78
//        Log打印可以看出EidtText滑动的距离 scroolY
        // //滚动的距离
        int scroolY = editText.getScrollY();
        // 内容加关滚动的距离
        int scroolRange = editText.getLayout().getHeight();
        //空间实际显示的高度
        int eventHeight = editText.getHeight() - editText.getCompoundPaddingTop() - editText.getCompoundPaddingBottom();
        //EidtText空间总内容的高度和实际显示高度的Diff;

        int diff = scroolRange - eventHeight;
        if (diff == 0) {
            return false;
        }

        Log.e(TAG, "scroolY==" + scroolY + ";scroolRange==" + scroolRange + ";eventHeght==" + eventHeight + ";diff==" + diff);

        return (scroolY > 0) || (scroolY < diff - 1);
    }
}
