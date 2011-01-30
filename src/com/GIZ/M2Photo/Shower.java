package com.GIZ.M2Photo;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//import android.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Shower extends Activity {
    /** Called when the activity is first created. */
	public List<String> myStudentlist = new ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewer);        
        
        myStudentlist.add("55432");
        myStudentlist.add("78155");
        myStudentlist.add("52898");
        myStudentlist.add("54866");    
        myStudentlist.add("80534");
        
        this.PolulateTableLayout();
    }

    public void PolulateTableLayout()
    {
    	TableLayout atableLayout = (TableLayout) findViewById(R.id.TableLayout01);    	   	
    	
    	for(int i=0;i<this.myStudentlist.size();i++)
    	{
    		TableRow aRow = new TableRow(this);
    		
    		ImageView aPhoto = new ImageView(this); // ImageView
	        Drawable drawable = LoadImageFromWebOperations("http://www.campus-booster.net/actorpictures/"+this.myStudentlist.get(i)+".jpg");	        
	        aPhoto.setImageDrawable(drawable);	        
	        aPhoto.setMaxHeight(30);
	        aPhoto.setMaxWidth(30);	       
    		
    		TextView aId = new TextView(this);
    		aId.setText(this.myStudentlist.get(i));
    		
    		aRow.addView(aPhoto);
    		aRow.addView(aId);
    		atableLayout.addView(aRow);
    	}
    }
    	
    	private Drawable LoadImageFromWebOperations(String url)
    		   {
    		        try
    		        {
    		            InputStream is = (InputStream) new URL(url).getContent();
    		            Drawable d = Drawable.createFromStream(is, "src name");
    		            return d;
    		        }
    		        catch (Exception e) {
    		            System.out.println("Exc="+e);
    		            return null;
    		        }
    		    }
    
}