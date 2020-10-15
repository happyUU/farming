package com.crc.farming.utils;

import java.util.Random;

public class RandomAvatarUtils {

    public static final String[] listAvatar = {
            "https://d.lanrentuku.com/down/png/1402/vegie_icons/mushroom.png",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2752797459,1425459356&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601742900411&di=c70f104359fc32c4f85dbf1c69873c9c&imgtype=0&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D2777576427%2C2554189742%26fm%3D214%26gp%3D0.jpg",
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3695156849,1842963923&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601743051601&di=ff8cea27d0b78e0483433a57acb42b23&imgtype=0&src=http%3A%2F%2Fbangimg1.dahe.cn%2Fforum%2F201604%2F15%2F225126kmc37q1sbwyhuw2b.gif",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3954706291,60046294&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1601743114955&di=1ac900e34bc3273cfb6688609ba9af3a&imgtype=0&src=http%3A%2F%2Fwww.autoimg.cn%2Falbum%2F2010%2F4%2F15%2F7a50c1b9-333b-4924-845e-d20e61438eff.gif"
    };


    /**
     * 随机获得头像的路径
     *
     * @return
     */
    public static String getAvatar() {
        //该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n
        int index = new Random().nextInt(listAvatar.length);

        return listAvatar[index];
    }



}
