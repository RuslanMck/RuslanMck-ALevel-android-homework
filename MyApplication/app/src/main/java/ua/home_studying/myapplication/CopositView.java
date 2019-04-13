package ua.home_studying.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CopositView extends FrameLayout {

    FontTextVIew ftvName;

    ImageView imgAvatar;

    public CopositView(Context context) {
        super(context);
    }

    public CopositView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public CopositView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    public CopositView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initView(context);
        TypedArrayWrapper.readTypedArray(context, attrs, R.styleable.CopositView, this::readArray);

    }

    private void readArray(TypedArray typedArray) {
        imgAvatar.setImageDrawable(typedArray.getDrawable(R.styleable.CopositView_drawId));
        ftvName.setText(typedArray.getString(R.styleable.CopositView_name));
        ftvName.setupTypeafeByEnum(typedArray.getInt(R.styleable.CopositView_ftv_font, 0));
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_composite_view, this, true);
        imgAvatar=findViewById(R.id.img_acount_avatar);
        ftvName=findViewById(R.id.txt_acount_name);
        }

}
