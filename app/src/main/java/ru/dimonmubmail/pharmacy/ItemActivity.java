package ru.dimonmubmail.pharmacy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;


public class ItemActivity extends Activity {

    public static final String EXTRA_ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Medicine extraMedicine = (Medicine)getIntent().getSerializableExtra(EXTRA_ITEM);

        TextView cost = (TextView) findViewById(R.id.cost);
        cost.setText("Цена:" + extraMedicine.getCost());

        TextView pc = (TextView) findViewById(R.id.pharmaceuticalCompany);
        pc.setText("Производитель:" + extraMedicine.getPc());

        CheckBox inStock = (CheckBox) findViewById(R.id.inStock);
        inStock.setChecked(extraMedicine.getInStock());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
