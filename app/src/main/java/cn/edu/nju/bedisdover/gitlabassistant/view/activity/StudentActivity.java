package cn.edu.nju.bedisdover.gitlabassistant.view.activity;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import cn.edu.nju.bedisdover.gitlabassistant.R;
import cn.edu.nju.bedisdover.gitlabassistant.view.adapter.ViewPagerAdapter;
import cn.edu.nju.bedisdover.gitlabassistant.view.fragment.StudentFragment;

public class StudentActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bnv_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        createView();
    }

    private void createView() {
        initBottomNav();
        initViewPager();
    }

    private void initBottomNav() {
        bnv_student = (BottomNavigationView) findViewById(R.id.bottom_nav_student);

        bnv_student.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.tab_menu_homework:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.tab_menu_exercise:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.tab_menu_exam:
                    viewPager.setCurrentItem(2);
                    break;
            }
            return false;
        });
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.vp_student);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bnv_student.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bnv_student.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new StudentFragment("/course/2/homework"));
        adapter.addFragment(new StudentFragment("/course/2/exercise"));
        adapter.addFragment(new StudentFragment("/course/2/exam"));

        viewPager.setAdapter(adapter);
    }
}
