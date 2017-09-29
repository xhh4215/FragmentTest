package com.example.xiaoheihei;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /***
     *  Fragment 的状态和回调
     *  1 运行的状态 fragment所在的activity运行的状态的时候他也处于运行状态 可见
     *  2 暂停的状态 fragment所在的activity暂停的状体的时候他也处于暂停状态
     *  3 停止的状态 fragment所在的activity停止的状态的时候也也处于停止状态 不可见 进行fragment的替换等操作
     *  4 销毁的状态 fragment所衣依附的activity处于销毁的状态的时候 ，或者通过
     *    fragmentmanager进行fragment的消除等操作
     *  Fragment 提供的附加的生命方法
     *   1 onAttach() 碎片和活动建立联系的时候回调方法
     *   2 onCreateView() 为碎片创建视图的时候调用的方法
     *   3 onActivityCreated() 确保碎片和相关联的活动一定创建完毕的时候调用
     *   4 onDestroyView() 当与碎片相关联的视图被移除的时候调用
     *   5 onDetach() 碎片和活动解除关联的时候的回调方法
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }
    private void replaceFragment(Fragment fragment){
        /**
         *  FragmentManager提供了findFragmentById()提供一个在Activity中获取fragment
         *  通过getActivity()在fragment中获取Activity对象 就是获取Content
         */

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,fragment);
        transaction.commit();
    }
}
