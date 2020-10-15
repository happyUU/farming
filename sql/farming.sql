/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.18 : Database - farmproduct
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`farmproduct` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `farmproduct`;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `articleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章标题',
  `date` datetime DEFAULT NULL COMMENT '文章发表日期',
  `visitnum` int(12) DEFAULT '0' COMMENT '访问量',
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章发表网站',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '文章内容',
  `id` int(20) DEFAULT NULL COMMENT '专家(用户)id',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文章图片',
  PRIMARY KEY (`articleid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `article` */

insert  into `article`(`articleid`,`title`,`date`,`visitnum`,`source`,`content`,`id`,`picture`) values 
(1,'蔬菜定植做好棚室隔离','2019-10-14 11:09:00',273,'山东科技报','经过夏季的高温闷棚，棚里病虫基本被消灭，\r\n但很多棚里仍然会很快出现病虫为害，尤其是蓟马等害虫，\r\n这是什么原因呢？其实，这些病虫大都是外界再次传播进来的。\r\n蔬菜定植前，一定要做好棚室的隔离，避免人员、苗子等传播病虫害。\r\n\r\n1.隔离棚室内外\r\n\r\n棚室周围铺设防草布，通风口设置严密的防虫网，\r\n是隔离棚室内外，防止虫害传播的重要手段，\r\n这个问题已经介绍过多次，这里不再赘述。\r\n\r\n2.人员进出消毒\r\n\r\n棚内经过闷棚干净了，但棚室外面仍然大量存在病虫，\r\n尤其是拔园后茎秆等堆积在棚室周围，导致棚室周围病菌、\r\n线虫数量众多。每天的进出，也是导致病虫传播的重要途径。\r\n可在棚室门口撒施2米以上的石灰粉，或者进出更换鞋子，\r\n可以起到一定的消毒作用，避免病虫随人员传播。\r\n\r\n3.做好苗子检查\r\n\r\n很多菜农反映，苗子栽上十多天，棚里蓟马就很多了，\r\n可闷棚、防虫网都好好的，怎么就这么多虫子呢？\r\n其实，苗子也是携带病虫的重要途径。想要让苗子生长良好，\r\n首先要确保苗子健壮，仔细检查苗子生长点、叶片、茎秆、根系等部位，\r\n全面细致，一旦发现有病斑或蓟马、茶黄螨等为害症状，\r\n要先做好苗子消毒，再进棚定植。苗子定植前，\r\n可用枯草芽孢杆菌、哈茨木霉菌、蜡质芽孢杆菌等针对性处理，\r\n消除病菌、线虫等潜在隐患。发现虫害，\r\n则可以用金龟子绿僵菌配合多杀菌素、苦参碱等进行处理。\r\n\r\n棚里干净，病虫害又进不了棚，就可以保证棚里环境良好，\r\n病虫绝迹，才能从根本上避免大量使用化学药剂。',18,'articleimage/arti1.jpg'),
(2,'樱桃树秋剪“四措施” 　','2019-10-03 11:04:00',110,'湖北农业报','　8-10月，大樱桃树处于花芽形态分化后期，此时修剪，可以改善树体结构和光照条件，促进养分积累，充实枝芽，复壮内膛。\r\n\r\n一、疏枝\r\n\r\n疏枝主要是疏除冠内的萌蘖、干枯枝、徒长枝、竞争枝、病虫枝、细弱枝、下垂枝、过密枝、重叠枝和轮生枝，以及枝头和枝组先端当年抽生的强旺条，以打开树冠光路，改善内膛光照，充实花芽。\r\n\r\n一年中，一棵树最多疏2个大枝，但不要形成对口伤。\r\n\r\n二、拉枝\r\n\r\n实践证明，大樱桃秋季拉枝开角比春季拉枝效果好。8-9月是秋拉枝的最佳时间，这期间拉枝开角，能使所有芽发育均衡，背上直立枝少，效果较好。\r\n\r\n大樱桃第一层主枝基角约80度，梢角65～70度，辅养枝开角至80～90度，拉枝开角时要注意及时移动拉绳或坠物，防止梢角向心生长。\r\n\r\n三、缩剪\r\n\r\n在处理枝条时，首先对春夏修剪时缓放2年以上的临时枝，夏“摘心”当年抽生的徒长枝和大叶芽枝，以及多年生大、中型枝组和辅养枝，按空间需要进行回缩修剪，以抑前促后，集中营养，促进花芽形成。另外，对生长势弱的枝组，留2～3个枝回缩复壮。\r\n\r\n四、摘心\r\n\r\n在9月下旬进行最后1次摘心，充实枝条，增强抗寒力，有利安全越冬。',24,'articleimage/arti2.jpg'),
(3,'大棚蔬菜施底肥应注意啥','2019-10-18 10:58:00',103,'河北农科报','　蔬菜复种指数高、产量高、需肥量大，而底肥对蔬菜的产量、品质及土壤性状影响又很大，是施肥中最基本的一个环节，对蔬菜作物生长发育至关重要。\r\n\r\n因此，必须合理施用底肥，在施底肥时应注意以下的问题：\r\n\r\n根据蔬菜目标产量确定施肥量\r\n\r\n确定大棚底肥施用数量，必须考虑土壤肥力高低和蔬菜需肥量大小等。一般氮肥总用量的30%、磷肥的80%、钾肥的50%作为底肥，生物肥和微肥尽可能一次全部底施。\r\n\r\n如秋茬番茄产量大体在8000～9000公斤，在此产量范围内每生产1000公斤番茄需吸收氮4.4公斤、五氧化二磷1.1公斤、氧化钾4.8公斤，氮、磷、钾比例为1∶0.25∶1.1，还需较多的钙、硼等。其中底肥宜选高磷型肥料，追施选用低磷型肥料。\r\n\r\n底肥用量以40～50公斤为宜，氮、磷、钾大体比例为1∶1∶0.75；追施用量75～85公斤，氮、磷、钾比例为1∶0.2∶0.85。\r\n\r\n确保有机肥用量足\r\n\r\n有机肥（包括农家肥、厩肥和饼肥）最适宜作底肥施用，对土壤肥力较高的老龄大棚更要多施一些生物有机肥作底肥。要保持棚内土壤肥力和有机质不降低或略有升高，就必须向大棚土壤中补充有机肥料。\r\n\r\n根据大棚土壤有机质的变化规律和有机氮与无机氮之比为1∶0.4～1时产量最高的原则进行推算，要保持大棚土壤有机质在2%以上，以保证较高的产量，每年应施入有机质含量为30%的有机肥料不低于2000公斤/亩才行。\r\n\r\n依天气及生长特点确定底肥施用方法\r\n\r\n施用底肥时要以腐熟土杂肥、粪肥等大体积的粗制有机肥为主，每亩用量6～8立方米，以增加土壤有机质和碳素物质，同时配合少量的优质生物有机肥（一般用量100～150公斤）和缓释型硫酸钾复合肥75～100公斤。\r\n\r\n采用控释肥来调控底肥中氮肥的释放速度，避免高温发生旺长，防止根部病害。坐果后要分次随水冲施含氮磷钾的全元素肥料。',18,'articleimage/arti3.jpg'),
(4,'寒露时节，如何打理好大棚蔬菜？','2019-10-19 13:46:00',102,'惠农网','　　寒露时节天气逐渐从凉爽到寒冷进行过度，此时呈现一幅秋高气爽的景象，对于大棚蔬菜来说，也十分有利于其生长，同时也是冬春棚菜地力培育和育苗有利时期。但在寒露时节，大棚蔬菜也容易滋生各种病虫害，对于作物的影响十分严重。那么寒露时节，如何打理好大棚蔬菜呢?\r\n\r\n寒露时节大棚蔬菜管理\r\n\r\n1、加强田间管理\r\n\r\n种植叶菜类、瓜类和茄瓜类，应加强田间管理，灌水、防旱，追施肥料，促进生长，喷施无公害农药防治病虫害，及时采收，供应市场。\r\n\r\n2、培育地力\r\n\r\n利用晴好天气，翻种棚菜田园，暴晒、风化土壤，施用有机肥，喷施土壤消毒剂，杀菌灭虫，提高肥力。新菜园区，可增添钢管大棚和竹棚，逐渐扩大蔬菜保护地种植面积。\r\n\r\n3、大棚的更新和维修\r\n\r\n老菜区已使用数年的竹棚如严重损坏，务必进行重新更新。以提高冬春菜棚防冻保温功能。\r\n\r\n寒露时节大棚蔬菜管理要点\r\n\r\n4、冬春棚菜苗及管理\r\n\r\n在冬春棚菜育苗时期，应做好购种、种子处理、消毒、浸种催芽工作。\r\n\r\n5、病虫害防治\r\n\r\n（1）叶菜类蔬菜病虫害防治。主要有跳甲、小菜蛾、蚜虫、斜纹夜蛾等害虫。大白菜干烧心病、软腐病、病毒病、根肿病、霜霉菌等病害发生。可用除尽或农地乐或京保尔(甲维盐)或杜邦安打或海正三令等防治斜纹夜蛾和小菜蛾，用乐斯本防治跳甲。白菜软腐病用农用链霉素或可杀得或猛克菌加清腐等药剂防治。\r\n\r\n（2）秋季豆类病虫害防治。豆类主要有潜叶蝇、豆野螟、煤霉病、锈病、枯萎病等病虫害发生，应做好防治工作。豇豆可用52.25%农地乐1200倍液或安打4000倍液加灭虫灵1500倍液防治豆荚螟，喷施50%潜克5000倍液或阿维菌素防治潜叶蝇，防治烟粉虱可选用20%兰宁(啶虫脒)2000倍或20%大丰收6号2000倍液加绿颖200倍液。\r\n\r\n（3）根结线虫病和黄萎病的防治。种植和育苗的茄子、番茄、黄瓜、芹菜等可能遭受根结线虫病危害。可采用移栽前破膜挖穴撒施5%好年冬G或福气我G(每穴2-3克)进行防治。',18,'articleimage/arti4.jpg'),
(5,'攻克杂交水稻难关','2019-10-08 04:51:00',104,'新疆日报','　　1973年10月，在苏州召开的全国水稻科研会议上，袁隆平正式宣告中国籼型杂交水稻“三系”配套成功。这一成果是以袁隆平为代表的科研人员多年来潜心研究的结晶。1960年7月，时任湖南黔阳农校教师的袁隆平在试验田里发现一株天然杂交稻，萌发了研究杂交水稻、提高粮食产量的念头。1966年，袁隆平发表了他的第一篇重要论文《水稻的雄性不孕性》，杂交水稻研究由此迈出坚实的第一步。\r\n1974年，湖南开始试种杂交水稻。1976年，全国示范推广面积扩大到208万多亩，全部增产20以上。1976年全国粮食总产量达到28631万吨，比1965年增长47.2。从1976年到1987年，中国的杂交水稻累计增产1亿吨以上，每年增产的稻谷可以养活6000多万人。\r\n杂交水稻种植面积的推广，为我国粮食增产作出了巨大贡献。我国可以豪迈地宣布：用不足世界10的耕地解决了占世界22人口的粮食问题。',1,'articleimage/arti5.jpg');

/*Table structure for table `article_comment` */

DROP TABLE IF EXISTS `article_comment`;

CREATE TABLE `article_comment` (
  `articleid` int(10) DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `comment_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `article_comment` */

insert  into `article_comment`(`articleid`,`comment`,`name`,`comment_date`) values 
(1,'挺实用的，感谢','张先生','2020-10-05'),
(1,'不错','张先生1','2020-10-02'),
(2,'nice','张先生3','2020-10-05'),
(3,'good','张先生4','2020-10-02'),
(4,'已收藏','张先生5','2020-10-04'),
(5,'感谢','张先生6','2020-10-03'),
(1,'真的有效','刘女士','2020-10-06'),
(2,'不错','张三','2020-10-06'),
(2,'324','张三','2020-10-06'),
(2,'213','张三','2020-10-06'),
(2,'yes','张三','2020-10-06'),
(4,'感谢','张三','2020-10-14');

/*Table structure for table `leave_message` */

DROP TABLE IF EXISTS `leave_message`;

CREATE TABLE `leave_message` (
  `name` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `leave_message` */

insert  into `leave_message`(`name`,`email`,`message`) values 
('李四','123@qq.com','很实用，感谢'),
('张三','123@qq.com','nice'),
('张三','123@qq.com','有点意思');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `id` int(11) DEFAULT NULL COMMENT '用户id',
  `ordertime` date DEFAULT NULL,
  PRIMARY KEY (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=1008646217 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order` */

insert  into `order`(`orderid`,`id`,`ordertime`) values 
(1008610832,1,'2020-10-15'),
(1008612345,2,'2020-10-02'),
(1008614453,2,'2020-10-04'),
(1008615456,3,'2020-10-01'),
(1008616758,4,'2020-10-08'),
(1008616813,1,'2020-10-14'),
(1008617754,5,'2020-10-04'),
(1008618752,6,'2020-09-30'),
(1008639866,1,'2020-10-15'),
(1008642340,1,'2020-10-14');

/*Table structure for table `order_product` */

DROP TABLE IF EXISTS `order_product`;

CREATE TABLE `order_product` (
  `orderid` int(50) DEFAULT NULL,
  `product_id` int(50) DEFAULT NULL,
  `product_num` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order_product` */

insert  into `order_product`(`orderid`,`product_id`,`product_num`) values 
(1008612345,1,1),
(1008615456,2,2),
(1008614453,3,1),
(1008615456,4,2),
(1008616758,5,1),
(1008616813,6,4),
(1008617754,2,3),
(1008642340,3,2),
(1008642340,4,1),
(1008618752,3,2),
(1008610832,1,1),
(1008639866,2,1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `product_price` double(10,2) DEFAULT NULL COMMENT '商品价格',
  `product_stock` int(50) DEFAULT NULL COMMENT '商品库存',
  `product_classification` varchar(255) DEFAULT NULL COMMENT '商品分类',
  `product_place` varchar(255) DEFAULT NULL COMMENT '商品产地',
  `product_description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `product_image` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `id` int(11) DEFAULT NULL COMMENT '卖家id（即用户表中的id）',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `product` */

insert  into `product`(`product_id`,`product_name`,`product_price`,`product_stock`,`product_classification`,`product_place`,`product_description`,`product_image`,`id`) values 
(1,'速生99—生菜种子',20.00,10000,'蔬菜','370700','特征特性：散叶品种，植株生长速度快，生育期45天左右。植株中等大小，叶形大，有褶皱，叶缘波状，叶色浅绿，商品性好。抗叶灼病。耐寒性强\r\n。生菜性质甘凉，因其茎叶中含有莴苣素，故味微苦，有清热提神、镇痛催眠、降低胆固醇、辅助治疗神经衰弱等功效。','product/product_1.jpg',2),
(2,'红缨子高粱',20.00,2000,'大田','411381','高粱米味甘，性温、涩，和胃消积，温中涩肠，主治脾虚湿困，消化不良等症。高粱米中的蛋白质以醇溶性蛋白质为多，色氨酸、赖氨酸等人体必需的氨基酸较少，是一种不完全的蛋白质，人体不易吸收。如将其与其他粮食混合食用，则可提高营养价值。','product/product_2.jpg',2),
(3,'云南普洱茶',10.00,20000,'茶叶','350500','普洱茶讲究冲泡技巧和品饮艺术，其饮用方法丰富，既可清饮，也可混饮。普洱茶茶汤橙黄浓厚，香气高锐持久，香型独特，滋味浓醇，经久耐泡。普洱茶具有降低血脂、减肥、抑菌助消化、暖胃、生津、止渴、醒酒解毒等多种功效。','product/product_3.jpg',7),
(4,'红华香杂交胡萝卜种子',10.00,20000,'蔬菜','530000','日本进口杂交一代种子，耐抽苔性良好，可以春秋两季使用，播种后105-110天左右收获，根长20厘米左右，颜色红色，条形美观。它有防癌的作用，并认为这主要是胡萝卜素在人体内能转化成维生素A的功劳','product/product_4.jpg',2),
(5,'石枣苗',12.00,2000,'水果','361100','石枣树形美观、整齐，初夏开花，白色苞片覆盖全树，苞片美观而显眼，微风吹动如同群蝶翩翩起舞，十分别致;秋季红果满树，能使人感受到硕果累累、丰收喜悦的气氛。','product/product_5.jpg',7),
(6,'秭归脐橙',8.00,20000,'水果','420527','宜昌是柑橘之乡，秭归属于宜昌的高山地区，位于三峡大坝上游，海拔最低在185以上，因为三峡大坝就有185米，独特的高山气候，加上充足的雨水，使得这里主产的脐橙以皮薄肉嫩.甘甜爽口而著。','product/product_6.jpg',7),
(8,'西瓜',15.00,100,'水果','中国海南','西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。','product/190641.jpg',7),
(9,'葵花籽',50.00,100,'种子','中国海南','葵花籽，即向日葵的果实，可供食用和油用。葵花籽富含不饱和脂肪酸，多种维生素和微量元素，加上其味道可口，因而成为一种十分受人们欢迎的休闲零食和食用油源。','articleimage/arti4.jpg',7);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `status` int(3) DEFAULT NULL COMMENT '0:farmer ; 1:expert ; 2:seller;3:reporter',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`telephone`,`email`,`address`,`password`,`status`) values 
(1,'张三','11147483647','123@qq.com','北京市沙河区','123456',1),
(2,'赵晓教授','1665437861','123@qq.com','北京市沙河区','123456',3),
(3,'李店主','1887652998','123@qq.com','北京市沙河区','123456',2),
(4,'aaaaa','18702654203','123@outlook.com','北京市沙河区','123456',1),
(5,'旺旺','123456','123@qq.com','北京市沙河区','123456',1),
(6,'七夕','123456','123@qq.com','北京市沙河区','123456',1),
(7,'刘店主','123456','123@qq.com','北京市沙河区','123456',2),
(60,'赵四','19982765330','123@qq.com','北京市沙河区','123456',1),
(61,'李教授','19982765330','123@out.com','北京市沙河区','123456',3),
(62,'刘教授','12345678901','123@outlook.com','北京市沙河区','123456',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
