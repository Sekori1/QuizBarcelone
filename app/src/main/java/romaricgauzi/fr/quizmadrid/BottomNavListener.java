package romaricgauzi.fr.quizmadrid;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

public class BottomNavListener implements ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    public BottomNavListener(BottomNavigationView bottomNavigationView, ViewPager viewPager) {
        this.bottomNavigationView = bottomNavigationView;
        this.viewPager = viewPager;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_android:
                viewPager.setCurrentItem(0);
                break;
            case R.id.action_logo:
                viewPager.setCurrentItem(1);
                break;
            case R.id.action_landscape:
                viewPager.setCurrentItem(2);
                break;
            case R.id.action_bottom_4:
                viewPager.setCurrentItem(3);
                break;
        }
        return true;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.action_android);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.action_logo);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.action_landscape);
                break;
            case 3:
                bottomNavigationView.setSelectedItemId(R.id.action_bottom_4);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
