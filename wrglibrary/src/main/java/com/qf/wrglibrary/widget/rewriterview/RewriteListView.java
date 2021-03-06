package com.qf.wrglibrary.widget.rewriterview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/10/1 0001.
 * Author by RuiGan
 */

public class   RewriteListView extends ListView {


    public RewriteListView(Context context) {
        super(context);
    }

    public RewriteListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RewriteListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override

/**   只重写该方法，达到使ListView适应ScrollView的效果   */

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
