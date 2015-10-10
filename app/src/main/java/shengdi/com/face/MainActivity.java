package shengdi.com.face;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Bitmap imgMarker;
    private int width, height;
    private Bitmap imgTemp;

    private LinearLayout ll1;
    private TextView tvExplain;
    private ImageView iv;
    private LinearLayout ll2;
    private TextView tvText;
    private EditText etContent;
    private Button btnGenerate;

    private void assignViews() {
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        tvExplain = (TextView) findViewById(R.id.tv_explain);
        iv = (ImageView) findViewById(R.id.iv);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        tvText = (TextView) findViewById(R.id.tv_text);
        etContent = (EditText) findViewById(R.id.et_content);
        btnGenerate = (Button) findViewById(R.id.btn_generate);
    }
    private Drawable water(int id,float x,float y,float size,String text){
        imgMarker = BitmapFactory.decodeResource(getResources(),id);
        width = imgMarker.getWidth();
        height = imgMarker.getHeight();
        Bitmap newb = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newb);
        canvas.drawBitmap(imgMarker, 0, 0, null);
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DEV_KERN_TEXT_FLAG);
        textPaint.setTextSize(size);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(Color.BLACK);
        canvas.drawText(text, x, y, textPaint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        return (Drawable)new BitmapDrawable(getResources(),newb);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("表情生成器");
        assignViews();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String text = etContent.getText().toString();
                Drawable dw=water(R.drawable.jpg_21,0,50,30,"你好啊");
                iv.setBackgroundDrawable(dw);

            }
        });
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
}
