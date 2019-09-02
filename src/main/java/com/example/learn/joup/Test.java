package com.example.learn.joup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
    public static void main(String[] args) {
        String htmlContent = "\"<p><strong><img src=\\\"//pic.to8to.com/attch/day_190601/20190601_9af6cd26464d85fce16bFcXglOwtNeHp.jpg?\\\" title=\\\"集成墙面经销商代理\\\" border=\\\"0\\\" hspace=\\\"0\\\" vspace=\\\"0\\\" alt=\\\"集成墙面经销商代理\\\" /></strong></p>\\n<p><strong>集成墙面经销商代理</strong>的价格差异。随着集成墙的普及，越来越多的家庭将墙体作为首选墙体材料。市场上较常见的规格是宽度600MM和300MM。在同一个广场的情况下，价格越窄，价格越便宜。有很多人感到困惑。欧洲集成墙小系列将于今天向您介绍。</p>\\n<p><strong>集成墙面经销商代理</strong>价格差异由以下原因引起：</p>\\n<p>1。600MM集成墙面需要一定的密度和强度，以确保成型过程中的稳定性，因为它的板面较宽，因此很难切角。但是，一体化的墙面(300MM或400MM等)低于600mm，随着宽度的减小，成型的基本材料和条件也减少了，因此切角是不可避免的，这就是为什么目前的低端市场。该产品基本上使用了300MM或400MM板的重要原因之一。&nbsp;</p>\\n<p>2.在设备投资方面，无论是基板的生产还是成品的加工，宽板的设备投资是窄板的2-3倍。土巴兔&nbsp;</p>\\n<p>3.在技术要求方面，宽板在原料配方和加工方面的技术要求远高于窄板。集成墙板规格一般有300-400-600平缝V型接缝，宽度分别为30CM，40CM和60CM。&nbsp;V型缝合竹纤维墙板具有比较优势，可以减少房屋墙体不平度问题引起的安装问题，减少墙板间隙，并提出整体墙面装饰与线条匹配。</p>\\n<p><strong>集成墙面经销商代理</strong>价格是很多人关注的问题，那么整体墙的价格/性能比是多少?市场上整体<strong>集成墙面经销商代理</strong>墙的价格在120-300元/平方米左右，制造商直接生产45-180元/平方米的定制价格，而十几个或几个平墙涂料或几十个平板。它是昂贵的。然而，大多数人不知道的是，购买集成墙的成本几乎等于安装成本。与传统材料不同，集成墙面安装不需要雇佣特定的安装团队。普通的木工可以很容易地做到这一点。一个约100平方米的房间可以在三天内组装，节省了大量的劳动和工作时间。</p>\\n<p><img src=\\\"//pic.to8to.com/attch/day_190601/20190601_3a530a4604e1fd20883eXrkWiqbUBBd1.jpg?\\\" title=\\\"集成墙面经销商代理\\\" border=\\\"0\\\" hspace=\\\"0\\\" vspace=\\\"0\\\" alt=\\\"集成墙面经销商代理\\\" /></p>\\n<p>以上就是关于<strong>集成墙面经销商代理</strong>问题的分析，希望能帮到你!</p>\\n<script>var _hmt = _hmt || [];\\r\\n(function() {\\r\\n  var hm = document.createElement(\\\"script\\\");\\r\\n  hm.src = \\\"https://hm.baidu.com/hm.js?b1d27fb0b411949e1a1f5a5aefb6af88\\\";\\r\\n  var s = document.getElementsByTagName(\\\"script\\\")[0]; \\r\\n  s.parentNode.insertBefore(hm, s);\\r\\n})();\\r\\n</script>\"";
        System.out.println(htmlContent);
        Document doc = Jsoup.parse(htmlContent);
        Elements links = doc.getElementsByTag("p");
        for(Element link:links){
            String ss = "ss";
            link.text(ss);
            System.out.println(link.text());
        }
        String end =doc.html();
    }
}
