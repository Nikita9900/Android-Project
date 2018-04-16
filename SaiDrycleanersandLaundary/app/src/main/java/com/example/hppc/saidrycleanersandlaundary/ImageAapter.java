package com.example.hppc.saidrycleanersandlaundary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAapter extends BaseAdapter {
    private Context ctx;
    private Integer image_id[] = {R.mipmap.img1,
            R.mipmap.img2,
            R.mipmap.img3,
            R.mipmap.img4,
    };
    public int[] mThumbIds;

    public ImageAapter(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    public int getCount()
    {
        return image_id.length;

    }
    @Override
    public Object getItem(int arg0)
    {
        return null;
    }
    @Override
    public long getItemId(int arg0)
    {
        return 0;
    }
    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2)
    {
        ImageView img;
        if (arg1==null)
        {
            img=new ImageView(ctx);
            img.setLayoutParams(new GridView.LayoutParams(160,160));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setPadding(8,8,8,8);

        }
        else
        {
            img=(ImageView) arg1;
        }
        img.setImageResource(image_id[arg0]);
        return img;
    }

}
