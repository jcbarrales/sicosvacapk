package lania.edu.mx.sicosvac;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lania.edu.mx.sicosvac.Fragmentos.MenoresFragment;
import lania.edu.mx.sicosvac.Fragmentos.NotificacionesFragment;
import lania.edu.mx.sicosvac.General.PageAdapterTutoresProfile;

public class tutor_profile extends AppCompatActivity {
    private int tutor_id;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);

            context = this;

        String nombre = getIntent().getStringExtra("nombre");
        String usuario = getIntent().getStringExtra("usuario");
        tutor_id = getIntent().getIntExtra("tutorID",0);

        ((TextView) findViewById(R.id.nameTexteventsprofile)).setText(nombre);
        ((TextView) findViewById(R.id.txtUserPerfil)).setText(usuario);


        tabLayout = (TabLayout)findViewById(R.id.Maintabs);
        viewPager = (ViewPager)findViewById(R.id.viewpagerinitial);

        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(setupViewPager());

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF") );

        wrapTabIndicatorToTitle(tabLayout, 80, 80);

        setupTabIconsBar();
        tabLayout.getTabAt(1).select();
        tabLayout.getTabAt(0).select();


    }

    private PagerAdapter setupViewPager() { //Adding fragments to ViewPager
        Log.w("ViewPagerMain", "Pager In");

        PageAdapterTutoresProfile adapter = new PageAdapterTutoresProfile(getSupportFragmentManager());


        MenoresFragment Fragment1 = MenoresFragment.newInstance("0","0");
        NotificacionesFragment Fragment2 = NotificacionesFragment.newInstance("0","0");


        adapter.addFrag(Fragment1,"Menores");
        adapter.addFrag(Fragment2, "notificaciones");


        Log.w("PagerMain", "Pager Out");

        return adapter;

    }

    private void setupTabIconsBar() { //Adding custom view to tab

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("MENORES");
        tabOne.setTextColor(Color.WHITE);

        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("NOTIFICACIONES");
        tabTwo.setTextColor(Color.WHITE);

        tabLayout.getTabAt(1).setCustomView(tabTwo);

    }

    private void settingMargin(ViewGroup.MarginLayoutParams layoutParams, int start, int end) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            layoutParams.setMarginStart(start);
            layoutParams.setMarginEnd(end);
            layoutParams.leftMargin = start;
            layoutParams.rightMargin = end;
        } else {
            layoutParams.leftMargin = start;
            layoutParams.rightMargin = end;
        }
    }

    public void logouteventsprofile(View view){

        SplashActivity.logout(tutor_profile.this);

    }

    public void wrapTabIndicatorToTitle(TabLayout tabLayout, int externalMargin, int internalMargin) {
        View tabStrip = tabLayout.getChildAt(0);
        if (tabStrip instanceof ViewGroup) {
            ViewGroup tabStripGroup = (ViewGroup) tabStrip;
            int childCount = ((ViewGroup) tabStrip).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View tabView = tabStripGroup.getChildAt(i);
                //set minimum width to 0 for instead for small texts, indicator is not wrapped as expected
                tabView.setMinimumWidth(0);
                // set padding to 0 for wrapping indicator as title
                tabView.setPadding(0, tabView.getPaddingTop(), 0, tabView.getPaddingBottom());
                // setting custom margin between tabs
                if (tabView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) tabView.getLayoutParams();
                    if (i == 0) {
                        // left
                        settingMargin(layoutParams, externalMargin, internalMargin);
                    } else if (i == childCount - 1) {
                        // right
                        settingMargin(layoutParams, internalMargin, externalMargin);
                    } else {
                        // internal
                        settingMargin(layoutParams, internalMargin, internalMargin);
                    }
                }
            }

            tabLayout.requestLayout();
        }
    }




}
