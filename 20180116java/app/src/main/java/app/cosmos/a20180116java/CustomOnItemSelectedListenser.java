package app.cosmos.a20180116java;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by sec on 2018-01-17.
 */

public class CustomOnItemSelectedListenser implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        Toast.makeText(parent.getContext(),"OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
