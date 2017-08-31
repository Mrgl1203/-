package com.gl.slidetry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gl.slidetry.fragment.LeftFragment;
import com.gl.slidetry.fragment.MainFragment;
import com.gl.slidetry.fragment.RightFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        final SlidingMenu slidMenu = new SlidingMenu(this);
        //指定菜单模式，(左侧菜单，右侧菜单或者双侧菜单)
        slidMenu.setMode(SlidingMenu.LEFT_RIGHT);
        //设置左侧页面的布局文件
        slidMenu.setMenu(R.layout.left_menu);

        //用于设置双侧菜单中右侧菜单的显示内容
        slidMenu.setSecondaryMenu(R.layout.right_menu);
        //设置菜单的宽度
        //方式一： 设置菜单宽度
//        slidMenu.setBehindWidth();
        //方式二： 设置剩余宽度
        slidMenu.setBehindOffset(300);

         /*
        * 设置当菜单打开时触摸的起始位置
        * SlidingMenu.TOUCHMODE_MARGIN   必须从边缘开始滑动
        * SlidingMenu.TOUCHMODE_NONE   怎么滑都不行，
        * SlidingMenu.TOUCHMODE_FULLSCREEN  满屏任意位置均可
        * */
        slidMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

      /* * 参数2:
        * SlidingMenu.SLIDING_WINDOW 菜单高度包含标题栏高度
        * SlidingMenu.SLIDING_CONTENT  菜单高度不包含标题栏高度
        * */
        slidMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        //设置菜单与内容边缘的阴影效果
        slidMenu.setShadowWidth(100);
        //设置菜单边缘阴影图像,左侧右侧
        slidMenu.setShadowDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
        slidMenu.setSecondaryShadowDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
//        滑动时透明度的改变的能力
        slidMenu.setFadeEnabled(true);
//        设置菜单的渐变度，范围0-1,0为完全不渐变，1为完全渐变
        slidMenu.setFadeDegree(1.0f);
//        设置滑动层与内容层的滚动比例，即内容部分滑动4像素，菜单部分滑动1像素
//        slidMenu.setBehindScrollScale(0.25f);
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new MainFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.left_frame, new LeftFragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.second_frame, new RightFragment()).commit();

        findViewById(R.id.leftshow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidMenu.showMenu();
            }
        });

        findViewById(R.id.righttshow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidMenu.showSecondaryMenu();
            }
        });
    }

}
