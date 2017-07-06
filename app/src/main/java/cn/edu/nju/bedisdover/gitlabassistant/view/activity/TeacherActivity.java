package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.util.BNVHelper;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.ViewPagerAdapter;
import cn.edu.nju.bedisdover.gitlabassistant.view.fragment.GroupFragment;
import cn.edu.nju.bedisdover.gitlabassistant.view.fragment.TeacherFragment;

public class TeacherActivity extends AppCompatActivity {
    
    @BindView(R.id.vp_teacher)
    ViewPager viewPager;
    
    @BindView(R.id.bottom_nav_teacher)
    BottomNavigationView bnv_teacher;

    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        ButterKnife.bind(this);

        initBottomNav();
        initViewPager();
    }

    private void initBottomNav() {
        bnv_teacher.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.tab_menu_class:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.tab_menu_homework:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.tab_menu_exercise:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.tab_menu_exam:
                    viewPager.setCurrentItem(3);
                    break;
            }
            return false;
        });

        BNVHelper.disableShiftMode(bnv_teacher);
    }

    private void initViewPager() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bnv_teacher.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bnv_teacher.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new GroupFragment());
        adapter.addFragment(new TeacherFragment("/course/2/homework"));
        adapter.addFragment(new TeacherFragment("/course/2/exercise"));
        adapter.addFragment(new TeacherFragment("/course/2/exam"));

        viewPager.setAdapter(adapter);
    }
}
