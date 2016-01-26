package com.ldy.animdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

/**
 * 功能介绍： NineOldAndroids是github上的一个开源项目，其作用是
 *          为了在低版本android上（API11以下）使用属性动画。
 *
 * 原理: 主要就是判断当前sdk版本，如果大于API11，那么就调用官方的API，
 *      否则自己实现动画效果。另外，在API
 *
 * 使用: 它与官方的属性动画基本一致。比如ObjectAnimator、ValueAnimator等等。
 *
 * Created by ldy on 2015/11/21.
 */
public abstract class AnimFragment extends Fragment {

    protected TextView mView;
    protected TextView mTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anim, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView = (TextView) view.findViewById(R.id.view);
        mTitle = (TextView) view.findViewById(R.id.title);
        mTitle.setText(getTitle());
        view.findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnimStart(mView);
            }
        });

        view.findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnimReset(mView);
            }
        });
    }

    protected void onAnimStart(View view) {}

    protected abstract String getTitle();

    protected void onAnimReset(View view) {
        reset(view);
    }

    /**
     * ViewHelper
     *
     * 兼容以前的api，因为像setAlpha,setTranslationX等方法在低版本中是没有的，
     * 所以NineOldAndroids提供了ViewHelper类，使得我们不必关心API版本。
     *
     * 原理（比如setAlpha方法）：
     * 判断当前sdk版本是否是API11以下,如果是的话那么NEEDS_PROXY为true。
     * 调用AnimatorProxy类中的wrap方法，将view进行包装，然后调用setAlpha方法设置mAlpha变量，
     * 并调用invalidate方法刷新视图，刷新过程中，会调用applyTransformation方法更新透明度
     *
     * @param view
     */
    protected final void reset(View view) {

        ViewHelper.setAlpha(view, 1f);

        ViewHelper.setScaleX(view, 1f);
        ViewHelper.setScaleY(view, 1f);

        ViewHelper.setTranslationX(view, 0f); // 设置该组件在X 方向上位移
        ViewHelper.setTranslationY(view, 0f); // 设置该组件在Y 方向上位移

        ViewHelper.setRotation(view, 0f);
        ViewHelper.setRotationY(view, 0f);
        ViewHelper.setRotationX(view, 0f);

        ViewHelper.setPivotX(view, view.getMeasuredWidth() / 2.0f); // 设置X变换中心
        ViewHelper.setPivotY(view, view.getMeasuredHeight() / 2.0f);// 设置Y变换中心
    }
}
