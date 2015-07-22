package comericxu1983.github.androidtouchgestures;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yushi on 15/7/12.
 */
public class TouchView extends View {
    private static final String TAG = "eric_debug";

    public TouchView(Context context) {
        super(context);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public comericxu1983.github.androidtouchgestures.TouchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }


//    @Override
    public boolean onTouchEvent2(MotionEvent event) {
        Log.d(TAG, "event:" + event);
//
        int action = event.getActionMasked();
        int index = event.getActionIndex();
//
        Log.d(TAG, String.format("onTouchEvent:action:%d, index:%d", action, index));
//
//        float x, y;
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                Log.d(TAG, "ACTION_DOWN");
//
//                x = event.getX();
//                y = event.getY();
//                Log.d(TAG, "x:" + x + ", y:" + y);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                Log.d(TAG, "ACTION_MOVE");
//
//                x = event.getX();
//                y = event.getY();
//                Log.d(TAG, "x:" + x + ", y:" + y);
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.d(TAG, "ACTION_UP");
//                x = event.getX();
//                y = event.getY();
//                Log.d(TAG, "x:" + x + ", y:" + y);
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                Log.d(TAG, "Action was CANCEL");
//                break;
//
//            case MotionEvent.ACTION_OUTSIDE:
//                Log.d(TAG, "Movement occurred outside bounds of current screen element");
//                break;
//        }


//        return super.onTouchEvent(event);

        return true;

    }
}
