package com.example.learn.web.controller;

import com.example.learn.web.costant.Constant;
import com.example.learn.web.dto.RspDTO;
import com.example.learn.web.dto.UserDTO;
import com.example.learn.web.exception.BizException;
import com.example.learn.web.service.UserService;
import com.example.learn.web.vo.UserVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RestControllerAdvice
public class ValidController {

    @Autowired
    private UserService userService;
    /**
     * 走串行校验
     *
     * @param userVO
     * @return
     */
    public Object saveDepressed(@RequestBody UserVO userVO){
        String mobile  = userVO.getMobile();

        //手动逐个 参数校验~ 写法
        if (StringUtils.isBlank(mobile)) {
            return RspDTO.paramFail("mobile:手机号码不能为空");
        } else if (!Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}$", mobile)) {
            return RspDTO.paramFail("mobile:手机号码格式不对");
        }

        //抛出自定义异常等~写法
        if (StringUtils.isBlank(userVO.getUsername())) {
            throw new BizException(Constant.PARAM_FAIL_CODE, "用户名不能为空");
        }

        // 比如写一个map返回
        if (StringUtils.isBlank(userVO.getSex())) {
            Map<String, Object> result = new HashMap<>(5);
            result.put("code", Constant.PARAM_FAIL_CODE);
            result.put("msg", "性别不能为空");
            return result;
        }

        userService.save(userVO);
        return RspDTO.success();

        // 很差的参数校验
        //javax.validation 使用它来校验
    }

    /**
     * 走参数校验注解
     *
     * @param userDTO
     * @return
     */
    @PostMapping("/save/valid")
    public RspDTO save(@RequestBody @Validated UserDTO userDTO) {
        userService.save(userDTO);
        return RspDTO.success();
    }
    @RequestMapping("/test111")
    public Object test111(){
        String content = "<p>美景如茶需慢慢细品，北海拥有得天独厚的旅游优势，将自然的魅力带到触手可及的地方，而<a href=\"https://beihai.focus.cn/loupan/110123818.html\" target=\"_blank\" data-mp-source=\"insert\" style=\"color: rgb(47, 56, 213);\"><b>银滩西区</b></a>则是北海重点打造的旅游区域，打造的是休闲旅游度假模式。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/xf/dt/ab1cad7c-7eb8-4b2a-b5c5-e71ee58f3985.gif\"></p>\n" +
                "<p>（图片来源与网络）</p>\n" +
                "<p>银滩西区规划区位于北海市主城区南部，东起金春路，西至新世纪大道，北至金海岸大道，南至北部湾岸线。</p>\n" +
                "<p>规划的银海西区的道路网以“四横五纵”的方格网状布局形式。“四横”：金海岸大道、美景路、侨景路、海景大道（沿海段）。“五纵”：新世纪大道、西藏路、经三路、云南路、浙江路。值得一提的是金海岸大道西段的通车，将银滩、侨港、冠头岭这几个北海 的旅游景点“串”在了一起，银滩西区的交通路网系统逐步完善，畅达全城。“四带”是指沿金春路、新世纪大道、侨港大道、侨景路的四个绿化景观带。“六园”是指分别位于新世纪大道南端、西藏路西侧、经二路南端、经四路北端、经五路西侧、浙江路南端的六个社区公园绿地。“四带六园”将会成为北海城市之“肺”，对北海城市进行生态补偿，成为另一种形式的环境景观。</p>\n" +
                "<p><a href=\"https://beihai.focus.cn/loupan/110123818.html\" target=\"_blank\" data-mp-source=\"insert\" style=\"color: rgb(47, 56, 213);\"><b>荣和银滩蓝湾</b></a>位于北海市银滩西旅游度假区，新世纪大道与美景路交汇（新世纪南延长线南端）。项目地址优越，东邻“天下第一滩”银滩、侨港风情街，南与北部湾细沙大海为伴，西接千亩高尔夫球场、冠头岭国家森林公园，北连城市主干道新世纪大道；项目连接了北海两个国家4A级景区，楼下即为延续数公里的纯天然沙滩，畅享一线海景风光。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/xf/dt/2e0c2844-313d-45c0-81c5-c3aecfd50214.JPEG\"></p>\n" +
                "<p>荣和银滩蓝湾项目区位图</p>\n" +
                "<p>荣和集团成立于1993年，秉承着“为客户创造幸福，为社会创造财富，为员工创造机遇，为企业创造效益”的核心价值观与经营理念，到现在已有了26年的辉煌发展，成为一家以房地产开发和不动产经营为主，集酒店、物业服务、专业市场、金融等为一体的大型民营股份制企业集团。集团具有中国房地产开发企业一级资质。荣和银滩蓝湾则是荣和首进北海的第一个项目，项目定位为世界滨海旅居目的地，配套丰富，将打造集住宅、旅游、休闲、文化为一体的高端旅游项目，是北部湾地区投资度假的不二之选。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/xf/dt/5f4d937a-d0d8-4a52-aeb8-34afe2f844c7.JPEG\"></p>\n" +
                "<p>荣和银滩蓝湾项目实景图</p>\n" +
                "<p>荣和银滩蓝湾目前<b>新房项目一期即将面市</b>，售楼部及样板间目前正在装修中，开盘时间待定，项目价格待定，敬请期待。详情请咨询荣和银滩蓝湾售楼部免费电话：400-032-4608 转 399109。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/zx/duplication/ac244d36-8170-4fb2-998d-8cf649c818ff.png\"></p>\n" +
                "<p>荣和银滩蓝湾55㎡1+1房户型平面图</p>\n" +
                "<p>荣和银滩蓝湾55㎡1+1房户型点评：客厅朝南，主卧朝南；餐厅客厅连通绿化阳台，生活一脉相承；双阳台设计，悠享更多室外时光；超大生活阳台，阳光、清风轻松入室。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/zx/duplication/4aa11f5d-33f2-4158-b289-7a3513a2ae09.png\"></p>\n" +
                "<p>荣和银滩蓝湾75㎡2+1房户型平面图</p>\n" +
                "<p>荣和银滩蓝湾75㎡2+1房户型点评：超大生活阳台可改一房，买2房得三房，超高性价比；餐厅客厅与绿化阳台连通，营造更开阔的生活空间。</p>\n" +
                "<p class=\"pi\"><img src=\"https://t-img.51f.com/sh740wsh/zx/duplication/095d18f8-aa7c-4053-b8a9-bec065b224b3.png\"></p>\n" +
                "<p>荣和银滩蓝湾85㎡2+1房户型平面图</p>\n" +
                "<p>荣和银滩蓝湾85㎡2+1房户型点评：双阳台设计，其中生活阳台可改一房，买2房得3房，超高性价比；餐厅客厅与绿化阳台相通，生活空间更自由舒畅。</p>\n" +
                "<p>银滩西区，稀缺地块，高品位的度假胜地，<a href=\"https://beihai.focus.cn/loupan/110123818.html\" target=\"_blank\" data-mp-source=\"insert\" style=\"color: rgb(47, 56, 213);\">旅居大盘</a>荣和银滩蓝湾，你值得拥有。 </p>\n" +
                "<p>\n" +
                " <projectcard projectid=\"110123818\" class=\"project-card\" style=\"padding-bottom:2px;border-bottom:1px solid #eb5237; user-select: none; -webkit-touch-callout: none; -webkit-user-select: none; -khtml-user-select: none; -moz-user-select: none; -ms-user-select: none;\">\n" +
                "  荣和银滩蓝湾\n" +
                " </projectcard></p>\n" +
                "<p> </p>\n" +
                "<p><br></p>";
        int cityId = 220;
        userService.getSegmentedContent(content,220);
        return null;
    }

}
