package meat.fresh.little.com.myproject.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 创建日期：2018/6/14
 * 描述: 一些操作的工具类
 *
 * @author: zhaoh
 */
public class CommonTools {


    public static void startActivity(Context context, Class classes) {
        startActivity(context, classes, null);
    }

    public static void startActivity(Context context, Class classes, Bundle bundle) {
        Intent intent = new Intent(context, classes);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

}
