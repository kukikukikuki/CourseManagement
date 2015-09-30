package com.CMprojtest.coursemanagement;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.CMprojtest.coursemanagement.R;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	ArrayList<HashMap<String, String>> al;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lv = (ListView) findViewById(R.id.listView1);
		al = new ArrayList<HashMap<String, String>>();
		AssetManager am = this.getAssets();
		InputStream is = null;
		try {

			is = am.open("computer.xls");
			Workbook wb = Workbook.getWorkbook(is);
			// 获取该工作表中的第一个工作表
			Sheet sheet = wb.getSheet(0);
			int row = sheet.getRows();
			HashMap<String, String> hm;
			for (int i = 0; i < row; ++i) {
				Cell cellnianji = sheet.getCell(0, i);
				Cell cellzhuanye = sheet.getCell(1, i);
				Cell cellzhuanyerenshu = sheet.getCell(2, i);
				Cell cellkechengmingcheng = sheet.getCell(3, i);
				Cell cellxuanxiuleixing = sheet.getCell(4, i);
				Cell cellxuefen = sheet.getCell(5, i);
				Cell cellxueshi = sheet.getCell(6, i);
				Cell cellshijianxueshi = sheet.getCell(7, i);
				Cell cellshangjixueshi = sheet.getCell(8, i);
				Cell cellqiyizhouxu = sheet.getCell(9, i);
				Cell cellrenkejiaoshi = sheet.getCell(10, i);
				Cell cellbeizhu = sheet.getCell(11, i);
				System.out.println(cellnianji.getContents() + ":"
						+ cellzhuanye.getContents() + ":"
						+ cellzhuanyerenshu.getContents() + ":"
						+ cellkechengmingcheng.getContents() + ":"
						+ cellxuanxiuleixing.getContents() + ":"
						+ cellxuefen.getContents() + ":"
						+ cellxueshi.getContents() + ":"
						+ cellshijianxueshi.getContents() + ":"
						+ cellshangjixueshi.getContents() + ":"
						+ cellqiyizhouxu.getContents() + ":"
						+ cellrenkejiaoshi.getContents() + ":"
						+ cellbeizhu.getContents());
				hm = new HashMap<String, String>();
				hm.put("NIANJI", cellnianji.getContents());
				hm.put("ZHUANYE", cellzhuanye.getContents());
				hm.put("ZHUANYERENSHU", cellzhuanyerenshu.getContents());
				hm.put("KECHENGMINGCHENG", cellkechengmingcheng.getContents());
				hm.put("XUANKEXINXI", cellxuanxiuleixing.getContents());
				hm.put("XUEFEN", cellxuefen.getContents());
				hm.put("XUESHI", cellxueshi.getContents());
				hm.put("SHIJIANXUESHI", cellshijianxueshi.getContents());
				hm.put("SHANGJIXUESHI", cellshangjixueshi.getContents());
				hm.put("QIYIZHOUXU", cellqiyizhouxu.getContents());
				hm.put("RENKEJIAOSHIR", cellrenkejiaoshi.getContents());
				hm.put("BEIZHU", cellbeizhu.getContents());
				al.add(hm);
			}
			SimpleAdapter sa = new SimpleAdapter(this, al,
					R.layout.lastview_item, new String[] { "NIANJI", "ZHUANYE",
							"ZHUANYERENSHU", "KECHENGMINGCHENG", "XUANKEXINXI",
							"XUEFEN", "XUESHI", "SHIJIANXUESHI",
							"SHANGJIXUESHI", "QIYIZHOUXU", "RENKEJIAOSHIR",
							"BEIZHU" }, new int[] { R.id.tv_nianji,
							R.id.tv_zhuanye, R.id.tv_zhuanyerenshu,
							R.id.tv_kechengmingcheng, R.id.tv_xuanxiuleixing,
							R.id.tv_xuefen, R.id.tv_xueshi,
							R.id.tv_shijianxueshi, R.id.tv_shangjixueshi,
							R.id.tv_qiqizhouxu, R.id.tv_renkejiaoshi,
							R.id.tv_beizhu });
			lv.setAdapter(sa);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
