package com.greenhi.lalababy.item;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ItemDataJournal {
    private String phoneNum,day,year,age,title,content;

    public ItemDataJournal() {
    }

    public ItemDataJournal(@Nullable String phoneNum, String day, String year, String age, String title, String content) {
        this.phoneNum=phoneNum;
        this.day = day;
        this.year = year;
        this.age = age;
        this.title = title;
        this.content = content;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemDataJournal{" +
                "phoneNum='" + phoneNum + '\'' +
                ", day='" + day + '\'' +
                ", year='" + year + '\'' +
                ", age='" + age + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    /**
     * 根据json对象获取List<DataModel>集合
     * @param json 数据
     * @return
     */
    public static List<ItemDataJournal> getGsonList(String json) {
        List<ItemDataJournal> dataList;
        try {
            JSONObject rootObject = new JSONObject(json);
            //JSONObject dataObject = rootObject.getJSONObject("data");
            //JSONObject dataObject = rootObject.getJSONObject("records");

            /**
             * JSONArray的构造方法获取JSONArray对象
             */
            //JSONArray jsonArray = new JSONArray(recordObject.getString("feeds"));
            //Log.i(TAG, "jsonarray.length():"+jsonArray.length());

            /**
             * 获取JSONObject对象的属性关键字
             */
            //Iterator<String> iterators = recordObject.keys();
//            while (iterators.hasNext()) {
//                Log.i(TAG, "iterators: " + iterators.next());
//            }
            JSONArray records = rootObject.getJSONArray("records");
            dataList = new ArrayList<>();
            for (int i = 0; i < records.length(); i++) {
                JSONObject record = records.getJSONObject(i);
                ItemDataJournal model = new Gson().fromJson(record.toString(), new TypeToken<ItemDataJournal>() {
                }.getType());
                //Log.i(TAG, "DataModel: " + model.toString());
                dataList.add(model);
            }
            return dataList;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
