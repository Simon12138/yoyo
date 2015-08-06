package com.seu.yoyoschoolbeta.core;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.seu.yoyoschoolbeta.R;

public class FreeGoodsActivity extends AppCompatActivity{

    public static final String FREE_GOODS_TITLE = "闲置";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_goods);

        initToolbar();
        initFreeGoodsFragment(savedInstanceState);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.free_goods_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle(FREE_GOODS_TITLE);
//        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }

    private void initFreeGoodsFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            FreeGoodsFragment tabFragment = new FreeGoodsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.free_goods_fragment, tabFragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_free_goods, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
//            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
//                try {
//                    Method m = menu.getClass().getDeclaredMethod(
//                            "setOptionalIconsVisible", Boolean.TYPE);
//                    m.setAccessible(true);
//                    m.invoke(menu, true);
//                } catch (Exception e) {
//                }
//            }
//        }
//        return super.onMenuOpened(featureId, menu);
//    }
}
