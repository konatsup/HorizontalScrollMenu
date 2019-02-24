package com.konatsup.horizontalscrollmenu;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        //PackageManagerのオブジェクトを取得
        PackageManager pm = this.getPackageManager();

        //インストール済パッケージ情報を取得する
        List<ApplicationInfo> list = pm.getInstalledApplications(0);

        //パッケージ情報をリストビューに追記
        for (ApplicationInfo ai : list) {
            arrayAdapter.add(ai.packageName);
            listView.setAdapter(arrayAdapter);
        }
    }
}
