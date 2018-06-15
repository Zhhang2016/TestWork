package meat.fresh.little.com.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import meat.fresh.little.com.myproject.ui.TestScroolViewConflictEditText;
import meat.fresh.little.com.myproject.util.CommonTools;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.bt_clcik)
    Button btClcik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    public void onClick(View view) {
        CommonTools.startActivity(this, TestScroolViewConflictEditText.class);
    }

    private void initView() {

    }
}
