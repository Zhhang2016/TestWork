package meat.fresh.little.com.myproject.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import meat.fresh.little.com.myproject.R;

/**
 * 创建日期：2018/6/14
 * 描述: 测试ScroolViewListView 冲突解决
 *
 * @author: zhaoh
 */
public class TestScroolViewAndListViewConflict extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_conflict);
    }
}
