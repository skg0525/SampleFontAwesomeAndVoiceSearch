package com.iamskg.utilities;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Shivam on 9/5/16.
 */
public class AwesomeFontsTextView extends TextView {

    private Context context;


    public AwesomeFontsTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        init();
    }

    public AwesomeFontsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public AwesomeFontsTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {

        //Using this to prevent IDE errors when trying to view XML in edit because Fontmanager calls need context.
        // Context not there in layout view XML.  Edit mode is not true when running
        //app
        Typeface fontAwesome = Typeface.createFromAsset(context.getAssets(), "fontawesome-webfont.ttf");
        if (!isInEditMode())
            setTypeface(fontAwesome);

    }
}
