package bekerov.psu.quickkeep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import bekerov.psu.quickkeep.item.Item;
import bekerov.psu.quickkeep.itemadapter.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Item item = new Item();
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);

        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        mItemAdapter = new ItemAdapter(this, items);
        lvMain.setAdapter(mItemAdapter);

        //lvMain.add

    }
}
