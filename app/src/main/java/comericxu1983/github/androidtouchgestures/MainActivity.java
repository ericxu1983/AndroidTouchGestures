package comericxu1983.github.androidtouchgestures;

import android.graphics.Matrix;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener,
        ScaleGestureDetector.OnScaleGestureListener {

    private static final String TAG = "mydebug";
    private GestureDetectorCompat mDetector;
    private ScaleGestureDetector scaleDetector;
    private ImageView iv;


    private static final int INVALID_POINTER_ID = -1;
    private int fingerId = INVALID_POINTER_ID;
    float initialPosX = 0;
    float initialPosY = 0;
    float lastPosX = 0;
    float lastPosY = 0;
    float diffPosX = 0;
    float diffPosY = 0;
    float totalDiffPosX = 0;
    float totalDiffPosY = 0;

    Handler longPressHandler = new Handler();
    boolean longPressTimerFlag = false;
    long longPressStartTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        iv = (ImageView) findViewById(R.id.iv);

        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);

        scaleDetector = new ScaleGestureDetector(this, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
    public boolean onTouchEvent2(MotionEvent event) {
        Log.d(TAG, "event:" + event);

        int action = event.getActionMasked();
        int index = event.getActionIndex();
        int pointerId = event.getPointerId(index);
//
        Log.d(TAG, String.format("onTouchEvent:action:%d, index:%d, pointerId:%d", action, index, pointerId));
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

        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapConfirmed:" + motionEvent);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap:" + motionEvent);

        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTapEvent:" + motionEvent);
        return true;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        Log.d(TAG, "onDown:" + motionEvent);

        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        Log.d(TAG, "onShowPress:" + motionEvent);


    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Log.d(TAG, "onSingleTapUp:" + motionEvent);

        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float distanceX, float distanceY) {
        Log.d(TAG, String.format("onScroll:e1:%s, e2:%s, distanceX:%f, distanceY:%f", motionEvent, motionEvent1, distanceX, distanceY));

        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        Log.d(TAG, "onLongPress:" + motionEvent);

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
        Log.d(TAG, "onFling:e1:" + motionEvent + ", e2:" + motionEvent1 + ", velocityX:" + velocityX + ", velocityY:" + velocityY);

        return true;
    }

//    @Override
    public boolean onTouchEventScale(MotionEvent event) {
//        mDetector.onTouchEvent(event);

        return scaleDetector.onTouchEvent(event);

//        return super.onTouchEvent(event);
    }

    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        Log.d(TAG, "onScale:" + scaleGestureDetector);

        float scaleFactor = scaleGestureDetector.getScaleFactor();

        Log.d(TAG, "scaleFactor:" + scaleFactor);

        Matrix matrix = new Matrix();
        matrix.setScale(scaleFactor, scaleFactor);



        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

    }

//    @Override
    public boolean onTouchEventTestDrag(MotionEvent event) {
//        Called when a touch screen event was not handled by any of the views under it.
// This is most useful to process touch events that happen outside of your window bounds,
// where there is no view to receive it.

//        return super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent event:" + event);
        int action = event.getActionMasked();
        int index = event.getActionIndex();
        int pointerId = event.getPointerId(index);

        if (action == MotionEvent.ACTION_DOWN) {
            fingerId = pointerId;
            initialPosX = event.getX(fingerId);
            initialPosY = event.getY(fingerId);

            lastPosX = initialPosX;
            lastPosY = initialPosY;

            Log.d(TAG, "got action_down:" + this);

        } else if (action == MotionEvent.ACTION_MOVE) {
            if (pointerId == fingerId) {

                float posX = event.getX(fingerId);
                float posY = event.getY(fingerId);

                diffPosX = posX - lastPosX;
                diffPosY = posY - lastPosY;

                totalDiffPosX += diffPosX;
                totalDiffPosY += diffPosY;

                lastPosX = posX;
                lastPosY = posY;

                Log.d(TAG, "got action move:" + this);

            }
        }
        else if (action == MotionEvent.ACTION_UP) {
            if (pointerId == fingerId) {
                fingerId = INVALID_POINTER_ID;

                reset();

                Log.d(TAG, "got action_up:" + this);

            }
        }

//        Return true if you have consumed the event, false if you haven't. The default implementation always returns false.
        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Called when a touch screen event was not handled by any of the views under it.
// This is most useful to process touch events that happen outside of your window bounds,
// where there is no view to receive it.

//        return super.onTouchEvent(event);

        Log.d(TAG, "onTouchEvent event:" + event);
        int action = event.getActionMasked();
        int index = event.getActionIndex();
        int pointerId = event.getPointerId(index);

        if (action == MotionEvent.ACTION_DOWN) {
            fingerId = pointerId;
            initialPosX = event.getX(fingerId);
            initialPosY = event.getY(fingerId);

            startLongPressTimer();

        } else if (action == MotionEvent.ACTION_MOVE) {
            if (pointerId == fingerId) {

                float posX = event.getX(fingerId);
                float posY = event.getY(fingerId);

                float diffPosX = posX - initialPosX;
                float diffPosY = posY - initialPosY;

                float tolerance = 5; //5px
                if (diffPosX > tolerance || diffPosY > tolerance) {
                    Log.e(TAG, "diffPos > tolerance, stop long press");
                    stopLongPressTimer();
                    return true;
                }
            }

        }
        else if (action == MotionEvent.ACTION_UP) {
            if (pointerId == fingerId) {
                fingerId = INVALID_POINTER_ID;

                reset();
                stopLongPressTimer();

                Log.d(TAG, "got action_up:" + this);
            }
        }

//        Return true if you have consumed the event, false if you haven't. The default implementation always returns false.
        return true;
    }

    private void stopLongPressTimer() {
        if (longPressTimerFlag) {
            longPressTimerFlag = false;

            //todo eric delete postDelayed
//            longPressHandler.removeCallbacks();
        }
    }

    private void startLongPressTimer() {
        longPressTimerFlag = true;
        longPressStartTime = System.currentTimeMillis();

        startLongPressTimerImpl();

    }

    private void startLongPressTimerImpl() {
        longPressHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                longPressTimerProcedure();

                if (longPressTimerFlag) {
                    startLongPressTimerImpl();
                }
            }
        }, 100);
    }

    private void longPressTimerProcedure() {
        long currentTime = System.currentTimeMillis();
        long diffTime = currentTime - longPressStartTime;

        long longPressTimeMillis = 2 * 1000;
        if (diffTime >= longPressTimeMillis) {
            Log.i(TAG, "find longPress");

            vibrate();
        }
    }

    private void vibrate() {

    }


    private void reset() {
        initialPosX = 0;
        initialPosY = 0;
        lastPosX = 0;
        lastPosY = 0;
        diffPosX = 0;
        diffPosY = 0;
        totalDiffPosX = 0;
        totalDiffPosY = 0;

    }

    @Override
    public String toString() {
        return "MainActivity{" +
                "fingerId=" + fingerId +
                ", initialPosX=" + initialPosX +
                ", initialPosY=" + initialPosY +
                ", lastPosX=" + lastPosX +
                ", lastPosY=" + lastPosY +
                ", diffPosX=" + diffPosX +
                ", diffPosY=" + diffPosY +
                ", totalDiffPosX=" + totalDiffPosX +
                ", totalDiffPosY=" + totalDiffPosY +
                '}';
    }
}


