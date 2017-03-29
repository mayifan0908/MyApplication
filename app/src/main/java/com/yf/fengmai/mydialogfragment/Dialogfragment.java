package com.yf.fengmai.mydialogfragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by fengmai on 2017/3/29.
 */

public class Dialogfragment extends DialogFragment{
    private Button mbtok;
    private int mrequestcode;
    private Dismisslistener mdismisslistener;
    public static interface Dismisslistener{
        public void onDialogDismiss(int requestCode,int resultCode);
    }
    public static final Dialogfragment getinstance(){
       Dialogfragment dlg=new Dialogfragment();
        return dlg;
    }

    public Dialogfragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //它的功能是启用窗体的扩展特性。参数是 Window 类中定义的常量。FEATURE_NO_TITLE无标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
        getDialog().setCanceledOnTouchOutside(false);
        //dialog弹出后会点击屏幕或物理返回键，dialog消失 false则消失
        setCancelable(true);
        // 背景透明，只有动画时才能看到，如对话框下陷上弹前，背景只是对话框本身大小且在将要显示的位置
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view=inflater.inflate(R.layout.prompt_dialog,null);
        mbtok= (Button) view.findViewById(R.id.dlg_ok);
        mbtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        final Animation anim= AnimationUtils.loadAnimation(getActivity(),R.anim.guide);
        anim.setDuration(700);
        view.startAnimation(anim);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
}
}
