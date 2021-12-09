package com.greenhi.lalababy.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.greenhi.lalababy.R;
import com.greenhi.lalababy.utils.ScreenUtils;

public class Home3Activity extends AppCompatActivity {

    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏和状态栏透明
        ScreenUtils.transparencyBar(this);
        //改变状态栏文字颜色
        ScreenUtils.setAndroidNativeLightStatusBar(this,true);
        setContentView(R.layout.activity_home3);
        tvContent = findViewById(R.id.tv_content1_home3);
        tvContent.setText("                               过敏原合辑\n" +
                "吸入型的过敏源:\n" +
                "常见型的过敏源就是吸入型过敏，宝宝闻到刺激性的物品，就容易出现皮肤过敏或者打喷嚏的情况。\n" +
                "(1)吸入型的过敏源通常就是香水、杀虫剂、油漆类，宝宝的衣物如果是羊毛化纤类，也很容易引起过敏情况；\n" +
                "(2)宝宝外出的时候，接触到的花粉、粉尘，也可能会引起宝宝过敏，因此家长要避免让宝宝接触到这类刺激性气味的过敏源。尤其在温暖的春夏季节，室内阴暗处和潮湿地毯都容易滋生病菌，家长要注意室内的清洁和定期通风，杀虫剂最好选择宝宝适用的，宝宝的衣服要最好是纯棉舒适的。带孩子外出的时候，尽量做好防护措施，给宝宝戴上口罩，防止吸入粉尘、花粉。\n" +
                "食物过敏：\n" +
                "食物过敏这种情况通常发生在辅食宝宝或者奶粉宝宝身上。某类奶粉中的成分在吸收进宝宝身体后可能会产生排异反应；或者喂宝宝辅食的时候，鸡蛋、牛奶、海鲜引起宝宝腹痛、呕吐的情况，宝宝可能是食物过敏了。为了避免这类情况发生，宝宝在6个月之前最好的食物应该是母乳，每个妈妈的母乳都是给自家宝宝量身定制的，因此母乳宝宝不会有过敏情况；宝宝爱过敏，还有可能是自身的免疫力低下，母乳能给宝宝增加保护力。\n" +
                "\n" +
                "* 奶及奶制品 牛奶是诱发婴幼儿过敏的最常见食物。\n" +
                "* 禽蛋类 鸡蛋、鹌鹑蛋及蛋制品会导致各年龄段患者的过敏，蛋清中的卵白蛋白是诱发过敏的主要成分。\n" +
                "* 海产品和水产品 包括鱼类、虾类、蟹类、鱿鱼、贝类等，特别是不新鲜的海产品更容易诱发过敏。\n" +
                "* 黄豆及豆制品、花生、芝麻、菜豆等 其他豆类如绿豆、红豆以及青豆、芸豆等均可诱发过敏症状。\n" +
                "* 小麦、玉米、荞麦和谷类等 此外面粉中的螨也是引起过敏的重要原因。孩子爱吃的爆玉米花也可诱发过敏。\n" +
                "* 坚果类 核桃、开心果、腰果、大杏仁、棒子、松子和栗子等果仁经常引起过敏，而且可以诱发较重的过敏症状。\n" +
                "* 水果类 生吃水果容易诱发过敏症状，特别是水果的种子和果皮，比如桃子的果皮更容易诱发过敏。\n" +
                "* 某些肉类及其肉制品 牛肉、羊肉和猪肉等以及各种家禽类，如鸡、鸭、鹅和鹌鹑等，腐败的肉类易诱发喘息症状。\n" +
                "* 某些蔬菜 茼蒿、芫荽、蘑菇、西红柿、菜豆、土豆、胡萝卜和芹菜等。\n" +
                "* 具有特殊气味的食物 大葱、大蒜、辣椒、葱、生姜以及不少调味品，如胡椒粉、芥末油、五香粉、咖喱粉和孜然粉等，还包括酒类等。");
    }
}