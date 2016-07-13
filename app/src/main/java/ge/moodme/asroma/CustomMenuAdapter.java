package ge.moodme.asroma;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMenuAdapter extends ArrayAdapter<String> {
    private String eachCategory;
    private TextView categoryNameText;
    private TextView playerName1;
    private TextView playerName2;
    private TextView playerName3;
    private ImageView playerAvatar1;
    private ImageView playerAvatar2;
    private ImageView playerAvatar3;

    public CustomMenuAdapter(Context context, String[] categories) {
        super(context, R.layout.custom_row_category, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.custom_row_category, parent,false);
        eachCategory = getItem(position);
        setupWidgets(convertView, eachCategory);

        if(position!= getPosition(eachCategory))
        {
            convertView.setBackgroundColor(Color.RED);
        }
        else
        {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }

    void setupWidgets(View view, String s){
        /*widget declaration and init for custom ListView*/
        categoryNameText = (TextView)view.findViewById(R.id.categoryTextView);
        playerName1 = (TextView)view.findViewById(R.id.textViewName1);
        playerName2 = (TextView)view.findViewById(R.id.textViewName2);
        playerName3 = (TextView)view.findViewById(R.id.textViewName3);
        playerAvatar1 = (ImageView)view.findViewById(R.id.imageViewSample1);
        playerAvatar2 = (ImageView)view.findViewById(R.id.imageViewSample2);
        playerAvatar3 = (ImageView)view.findViewById(R.id.imageViewSample3);

        /* Set properties to widget views */
        categoryNameText.setText(s);
    }
}
