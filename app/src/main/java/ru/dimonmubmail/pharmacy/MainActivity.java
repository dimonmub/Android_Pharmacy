package ru.dimonmubmail.pharmacy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView lvSimple;
    ArrayAdapterItem adapter;
    ArrayList<Medicine> info;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] texts = { "Анаферон", "Арбидол", "Граммидин",
                "Но-шпа", "Стрепсилс" };
        int img = R.drawable.ic_launcher;

        info = new ArrayList<Medicine>();
        info.add(new Medicine("180", "Материа Медика", true));
        info.add(new Medicine("250", "Фармстандарт", false));
        info.add(new Medicine("175", "Валента", true));
        info.add(new Medicine("110", "Хиноин", false));
        info.add(new Medicine("130", "Рекитт Бенкизер", true));

        ObjectItem[] data = new ObjectItem[texts.length];

        for (int i = 0; i < texts.length; i++) {
            data[i] = new ObjectItem(img, texts[i]);
        }

        adapter = new ArrayAdapterItem(this, R.layout.item, data);

        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(adapter);
        lvSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra(ItemActivity.EXTRA_ITEM, info.get(i));
                startActivity(intent);
            }
        });
    }
}