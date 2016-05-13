/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : autoqa

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2016-05-13 17:39:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answ_id` int(11) NOT NULL AUTO_INCREMENT,
  `answ_title` varchar(255) DEFAULT NULL,
  `answ_content` longtext,
  `key_words` varchar(255) DEFAULT NULL,
  `answ_time` datetime DEFAULT NULL,
  PRIMARY KEY (`answ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '什么是学分制？', '<p>简单来说，学分制可以理解为是一种教学管理制度，以学分作为计算学生学习量的单位，以绩点作为衡量学生学习质量的指标，以取得必要的最低学分作为毕业标准。学分制以选课制为前提，允许学生在一定范围内自主选择所学课程、自主安排学习进程。其目的是重视学生个性发展，发挥学生个性特长，充分体现因材施教的教学原则。我校至2005年起全日制本科各专业学生全面推行学分制。</p>', null, '2016-05-12 15:19:53');
INSERT INTO `answer` VALUES ('2', '什么是学分？它是怎么计算的？', '学分是计算学生学习量的单位，是学生修读课程所需时间的反映。原则上所有课程每16学时计1学分；课程设计、实习、工程训练等实践环节按1周计1学分 ；所修课程经考核合格（60分），即可获得相应课程的学分。', null, null);
INSERT INTO `answer` VALUES ('3', '转专业有些什么条件？', '转专业人数控制在年级专业人数的10%以内。一般来讲转往地质、采矿、农学、动物科学专业可不受比例限制。而且学生只能在同批次、同类别专业内申请转专业。对于建筑学、城市规划专业学生原则上只能转出，不能转入；艺、体专业学生不得转出，转入需参加专业技能考试。申请基本条件包括：在读一年级的本科生，所学必修课程平均学分绩点达到2.5；无违纪行为，未受到学校任何处分；如学生确有某种特殊困难或有专业特长者可提出申请并提供相应证明材料。', null, null);
INSERT INTO `answer` VALUES ('4', '申请辅修资格有什么条件？', '学校鼓励学有余力的同学拓宽专业面，适度文、理、工渗透，修读辅修专业。凡第三学期或第四学期以前所修课程平均学分绩点大于2.0的同学均可修读。辅修专业由开设学院负责制订指导性教学计划，并公布开设课程及学期，供全校其它专业同学选择。修读辅修专业由本人提出申请，经原所在学院和接受学院同意后，接受学院到教务处教务科备案，并指导同学在网上选课。辅修专业开设学院负责修读同学的教学管理及成绩审核工作，完成辅修专业教学计划的同学，经考核合格，可发给辅修专业毕业证书。', null, null);
INSERT INTO `answer` VALUES ('5', '如何申请双学位？', '双学位是指在校本科生在保证完成主修专业学习基础上再学习另外一个专业的学位课程，达到授予学位条件者，可同时获得另一个学科门类的学士学位。根据学校的有关规定，申请双学位工作一般在第八学期（临毕业前）进行，经自愿申请，学校审核同意，在两年时间内再完成另一个专业的学位课程，取得双学位专业修读资格的学生，依据该双学位专业培养方案和教学要求，按照主修专业的方式、方法和学校有关学分制管理规定参加选课、修课、考试（考核）、实习、实验和毕业设计（论文）等教学环节，并按该专业课程学分费用标准交纳修课费用。修读双学位专业的学生在校学习年限为，学制为4年的，学习年限为3—6年（不含休学时间）；学制为5年的，学习年限为4—7年（不含休学时间）。', null, null);
INSERT INTO `answer` VALUES ('6', '我可以提前毕业或延长学习年限吗？', '学校鼓励学有余力的同学提前毕业，学习年限一般为四年制专业3～6年，五年制专业4～7年。但从实际情况看，要想在三年或四年（五年制）时间内提前毕业并非易事，需要花费比其他同学夺得多的时间和精力。有的同学曾说：\"提前毕业几乎是\'不可能完成的任务\'\"，可想难度很大。因为多选课程会由于诸如自身时间限制、课程时间冲突等而无法实现。\r\n\r\n我们建议，同学们各学期课程分布应比较均衡、合理，避免出现某学期课程过多或过少，每学期正常修读的学分应控制在20-28，毕业学期的毕业实习和毕业设计(论文)的周数之和不超过18。如果对于未修课程学分数不超过20学分的同学可以申请为当年的预计毕业生，允许进行毕业实习和毕业设计（论文）；如未修课程学分数超过20学分的同学，应提出延长学习年限申请。\r\n\r\n根据学校规定，同学在第八学期（每年的6月份）提出申请，经审批同意后给予办理延长学习年限相关手续，编入下一个年级并跟班完成学习，对于补修课程不超过三门的同学，学校规定原则上可以申请不住校，在延长学习年限内不再缴纳学费，按所选课程学分计算费用并予以缴纳，其标准为专业学分学费全价。在延长学习年限后毕业时如符合毕业和授予学士学位条件的，颁发毕业证和学位证。同学们如果在学分制规定的学习年限内，课程修读考核后仍有不及格课程的学分累计低于20学分（不含毕业实习、毕业设计或论文），或者毕业学期课程（含毕业实习、毕业设计、论文）考核不及格，或者未修完教学计划规定的各类课程学分的同学将按照结业处理。在离校两年内，同学在每学期开学后一月内可向学校报名，申请选修不及格课程。教务处安排考试，所有课程考核合格后换发毕业证书。如果同学修业期满时，有20学分以上的课程（不含毕业设计（论文）和毕业实习）经考核后不及格者将按肄业处理。', null, null);
INSERT INTO `answer` VALUES ('7', '选课的时间安排是怎么样的？', '学生需要在每学期末选定下学期修读的课程。选课流程包含两个阶段，第一轮初选通常安排在第15周前后进行；第一轮初选课结束后，学校将根据选课情况调整教学安排，随后进行第二轮选课，通常在第17周前后进行。各阶段的具体时间及要求，以教务处通知公告为准。', null, null);
INSERT INTO `answer` VALUES ('8', '为什么有的课程安排了上课时间和地点，有的课程没有安排？', '没有安排时间的课程存在以下几种情况，一是实践类课程，需要预约实验或与任课教师联系上课时间；二是由学院自行安排上课时间的课程，学生需自行和开课学院联系查询上课时间。', null, null);
INSERT INTO `answer` VALUES ('9', '选课选错了，漏选了，该怎么办？', '在正常选课时期（选课系统开放），同学们可以自行在选课系统调整自己的选课；在非选课期间（选课系统关闭），却有特殊情况的（如学籍异动、学籍预警等）的同学可以向所在学院教学办申请选课调整，学院根据具体情况酌情处理。', null, null);
INSERT INTO `answer` VALUES ('10', '课程冲突了怎么办？', '正常选课通常不允许冲突，重新学习、辅修选课则允许冲突。冲突的课程，如任课老师有多个教学班，可以与任课老师商量在不冲突教学班上课，回原班考试。如无法调整的，要向任课老师说明情况，由学生自学并参加考试。', null, null);
INSERT INTO `answer` VALUES ('11', '为什么有的课程在系统上有考试安排，有的没有？', '课程考核通常分为两类，学院统排考和教师自排考，第一类均可在系统查询考试时间及地点，后一种则由任课老师通知考试，因此不在系统显示。统排考课程没有考试安排的同学，应首先查询是否选课，其次应查询是否没能按时交纳重修费导致无法考试。', null, null);
INSERT INTO `answer` VALUES ('12', '考试冲突了怎么办？', '通常情况下，学校及学院统排的考试会充分考虑学生情况，一般不会出现冲突，但教师自己安排的考试可能出现冲突，学生遇到考试冲突应当马上要求老师更改考试时间，如无法更改的，学生可就其中一门考试申请缓考。', null, null);
INSERT INTO `answer` VALUES ('13', '可以申请查卷吗？', '学生认为考试成绩存在巨大出入的，可向开课学院教学办申请要求查卷，由开课学院教学办及任课教师配合查卷。', null, null);
INSERT INTO `answer` VALUES ('14', '想要联系任课教师，怎样知道老师的联系方式？', '我们不会在互联网上公布任课教师的私人电话以及电子邮件。如果确需联系任课教师，可以咨询任课老师所在的教学办查询任课老师的电话或电子邮件地址。', null, null);
INSERT INTO `answer` VALUES ('15', '我今天补办了一卡通 但是不能刷一卡通 进图书馆', '补办的一卡通数据需要在当天晚上才能与图书馆门禁系统进行同步，第二天才能被识别。', null, null);
INSERT INTO `answer` VALUES ('16', '挂失后又找到了，可以在网站上解挂吗', '不可以，挂失可以在网上进行，但是解挂需要写卡操作，所以需要持卡在圈存机自助完成，也可以到校园卡服务中心由工作人员帮助完成。', null, null);
INSERT INTO `answer` VALUES ('17', '我用支付宝充值成功了，但是我的卡没用了，取不出来，可以把款退还回来么，怎么操作呀？我不想重新办卡了', '支付宝充值成功后就到了一卡通账户上，只能领取，没法退款。具体可以咨询校园卡服务中心工作人员，电话6089287', null, null);
INSERT INTO `answer` VALUES ('18', '很多很多天一直进不去，去了办卡的地方，他叫我去1-4 去了之后找到一个负责人，结果她的回复是 网络不稳定进不去很正常，她懒得上楼来帮我弄，叫我从一楼上来，问题是不是今天才没法进去， 是很多天都不能进去 ，在其位又不谋其职 到底谁能帮我解决这个问题 ，要是所有人都从一楼畅通无阻的进来 ，那么二楼设置门禁刷卡的意义又何在？', '一卡通系统补办卡或者新卡数据在每晚和图书馆门禁同步一次，所以当日补办的校园卡需要第二日才能通过门禁，有时会因为网络故障或者服务异常造成数据同步不完整，造成补卡多日仍然无法通过门禁的情况，我们会手动进行同步。但是门禁系统是图书馆，还是需要找他们核实一下，你的卡信息是不是已经同步到他们的门禁系统中。', null, null);
INSERT INTO `answer` VALUES ('20', '怎么看一卡通的充值记录，前段时间我用农行卡转账，延迟了好久，就是没有冲进去。但不知道农行卡的钱扣了没有？', '可以在一卡通服务中心或者通过服务电话由工作人员在系统中进行查询，', null, null);
INSERT INTO `answer` VALUES ('21', '一定要挂失了三天之后才能补办卡吗，万一紧急情况立即要用呢，可不可以不挂失直接补办呢', '是的，挂失满三天补办是写在系统中的，不满三天系统发卡不成功。特殊情况，如考试需要可以先打印卡片等满三天后才能对卡片写信息。', null, null);
INSERT INTO `answer` VALUES ('22', '通过支付宝进行充值，然而未到帐，这是为什么', '未到账是在支付宝显示的，还是在圈存机领取的时候提示的？针对这种情况请致电或者到校园卡服务中心有工作人员进行排查。', null, null);
INSERT INTO `answer` VALUES ('23', '挂了失的卡还是被人刷了', '这种现象一般是由于黑名单没有及时下发到被消费的pos机造成的，针对这种异常情况请到校园卡服务中心进行处理。', null, null);
INSERT INTO `answer` VALUES ('24', '技术支持', '服务对象：全校师生                办公电话：0816-6089287                        办公地址：东8C座201室服务简介\r\n       网络信息中心免费为全校提供网站架构、网络运维技术支持。', null, null);
INSERT INTO `answer` VALUES ('25', '机房传输线路接入', '其实都是', null, null);
INSERT INTO `answer` VALUES ('26', 'Windows系统自动更新', 'WSUS是Windows Server Update Services的简称。WSUS支持微软公司全部产品的更新，包括Windows操作系统、SQL Server、Office、Exchange Server等。我校的WSUS服务支持Windows操作系统、SQL Server、Office、Exchange Server等32位和64位的中、英版。\r\n     Windows自动更新服务是微软发布涉及其旗下产品安全和稳定性补丁的机制，以往这项服务是直接由用户（自动或手动）连接到微软服务器去更 新，但鉴于计算机安全问题愈来愈突出，当发生严重的系统安全问题时，校内用户的计算机系统出于各种原因无法及时得到安全更新，故我们把Windows自动 更新服务移植到本地校园网内，校园网的用户只需要做以下简单的配置就可以方便、及时地得到安全更新。 \r\n       地址为：http://wsus.swust.edu.cn\r\n       使用方法详见：http://wsus.swust.edu.cn', null, null);
INSERT INTO `answer` VALUES ('27', '网络天气', '系统简介\r\n       网络天气服务是网络信息中心提供的校内网络流量实时状态，反映当前校内各楼栋单位网络使用情况。 \r\n       地址为：点我查看', null, null);
INSERT INTO `answer` VALUES ('28', '虚拟主机', '系统简介\r\n       虚拟主机是由教育信息化推进办公室提供的一种网上应用服务，每一台虚拟主机都具有独立的域名，能提供WWW主页功能，各虚拟主机之间相对独立运行。\r\n       因资源有限，暂时未对外开放 ', null, null);
INSERT INTO `answer` VALUES ('29', '办公区IP地址申请', '服务简介\r\n       我校校园IP管理机制是由教育信息化推进办公室向各学院、部门信息管理人员分配了一段IP地址供部门内部自由协调分配，让各学院、部门内部上网管理更灵活。\r\n \r\nIP申请流程\r\n       01. 校园IP管理机制\r\n       教育信息化推进办公室向各学院、部门信息管理人员分配了一段IP地址供部门内部自由协调分配\r\n       02. 准备申请\r\n       教学办公区新增上网点，向本部门信息管理员提出需求，本部门管理员无法解决致电6089289咨询。\r\n       03. 填写申请表     \r\n       IP地址申请登记表，点我下载\r\n       04. 提交申请表\r\n       将申请表交到东8C座201室。   教育信息化推进办公室根据需要派人开通物理链路。\r\n       05. 申请完成', null, null);
INSERT INTO `answer` VALUES ('30', '网站系统制作开发', '系统简介\r\n       网站信息管理平台（JWEBPLUS）是教育信息化推进办公室架构的个性化门户信息平台工具，可以快速搭建部门级信息门户网站。在信息管理方面，系统提供多种信息维护模式，可以实现对信息从起草、审核、发布、冻结、退回、修改、存档等一列操作。\r\n\r\n申请流程\r\n01. 准备申请\r\n       准备使用WEBPLUS网站管理平台\r\n02. 填写申请表\r\n       申请网站制作系统需要填写：网站制作系统管理IP地址申请表， 域名注册申请表， 二级域名备案表，点我下载\r\n03. 提交申请表\r\n       将申请表交到东8C座201室，教育信息化推进办公室于五个工作日内开通，并通知申请人。\r\n04. 申请成功\r\n       正常访问网站并管理网站', null, null);
INSERT INTO `answer` VALUES ('31', '服务器托管服务', '服务简介\r\n    服务器托管服务系教育信息化推进办公室为各学 院、部门提供的一种扩展服务，用户可以将服务器委托存放在教育信息化推进办公室中心机房， 教育信息化推进办公室为托管单位提供存放服务器的物理位置、空调、网络、电源设施，其服务器上运行服务及数据安全由托管部门自行负责维护。\r\n \r\n服务器托管流程\r\n      01. 填写申请表\r\n            1、服务器托管申请表及托管协议，点我下载\r\n            2、托管服务器需对外访问或需要相应的域名，请填写域名注册相关资料，点我下载\r\n     02. 提交申请表  \r\n            将申请表交到东8C座201室， 教育信息化推进办公室审核能否达到用户需求\r\n     03.  教育信息化推进办公室准备基础设施\r\n            1、设备放置机柜位置（不含机架、散力架等），\r\n            2、网络接口调配，\r\n            3、网络连接普通网线（不含光口特殊接口卡及跳线），\r\n            4、新的IP地址调配，\r\n            5、域名映射\r\n     04. 通知用户搬迁\r\n            通知用户搬迁设备，并提交以下纸质签章手续：\r\n           1、服务器托管申请表\r\n           2、服务器托管协议\r\n           3、域名变更申请表\r\n    05. 托管完成   \r\n\r\n托管服务器取回维护或取走（取走不在托管)流程\r\n\r\n        01. 托管服务变更\r\n因托管单位原因需取走或取回维护设备\r\n         02. 填写申请表\r\n托管服务器变更申请表，点我下载\r\n          03. 提交申请表\r\n将申请表交到东8C座201室\r\n        04. 托管单位取换设备\r\n托管单位根据变更申请取走或取回维护托管设备\r\n        05. 托管完成    \r\n\r\n委托他人维护托管服务器证明\r\n    委托他人维护托管服务器证明表，点我下载\r\n\r\n托管服务器变更（如更换新服务器等），需填写“托管服务器基本信息变更申请表”。', null, null);
INSERT INTO `answer` VALUES ('32', '电子邮件系统', '系统地址：http://mail.swust.edu.cn\r\n系统简介\r\n    我校E-MAIL服务采用的是Coremail 公司的邮件产品，Coremail邮件系统是国内拥有自主知识产权的专业电子邮件系统，是著名的运营商级邮件系统，在中国大陆已发展超过3亿终端用户，深 受网易邮箱、139.com等知名运营商及美的、宝钢等500强企业所信赖，是中国用户实际使用最广泛、最频繁的邮件系统。该系统目前每个信箱容量设定为 1G，邮件数量上限为1000封，允许发送和接受的附件上限是10M。\r\n教职工及对公邮件申请流程的两种\r\n       第一种方式：无纸化网上申请（通过OA）\r\n        01.登录OA系统\r\n        02.点击“事务办理－事务申请－邮箱域名门户－学校邮箱申请”，按提示相关信息完成填写，转交下一步即可。。\r\n\r\n       第二种方式：使用纸质文件\r\n       01. 准备申请\r\n       学校教师准备使用学校邮件系统，填写申请表，点我下载\r\n       02. 提交申请表 \r\n       将申请表交到东8C座201室，教育信息化推进办公室现场审核并开通。\r\n       03.申请完成；提示：首次登录系统后请修改密码\r\n\r\n研究生申请流程\r\n       01.准备申请\r\n        请带上学生证或一卡通到逸夫图书馆1楼21号（即学校宽带用户收费处）填写申请表，申请表点我下载。\r\n       02.接收申请表\r\n         教育信息化推进办公室处理申请\r\n       03.申请人查询结果\r\n        申请人带上证件每周一到逸夫图书馆1楼21号查询结果。\r\n       04.申请完成\r\n\r\n密码修改流程的两种方式：\r\n      第一种方式：无纸化网上申请修改 （通过OA）\r\n        01.登录OA系统\r\n        02.点击“事务办理－事务申请－邮箱域名门户－学校邮箱密码修改”，按提示相关信息完成填写，转交下一步即可。。\r\n\r\n       第二种方式：\r\n       01. 不能登录 \r\n       因密码不正确无法正常登录邮件系统\r\n       02. 修改密码\r\n       自动修改：使用系统自带的密码找回功能，找回密码\r\n       人工修改：带上有效证件到东8C座201室修改。\r\n       03. 密码修改成功                 \r\n       正常登录\r\n邮件系统帮助文档\r\n       注：邮件使用帮助：http://mail.swust.edu.cn/common/help/faq/faq_simple_zh_CN.htm', null, null);
INSERT INTO `answer` VALUES ('33', 'DNS域名解析服务', '系统地址：主DNS服务器（202.115.160.33），辅助DNS服务器（202.115.160.36；202.115.160.39）\r\n                办公区上网配置IP相关信息时请将三个DNS都加上。DNS自动配置软件，请点我下载。\r\n系统简介\r\n     DNS 是计算机域名系统 (Domain Name System 或Domain Name Service) 的缩写，DNS服务是一项将域名解析为IP的服务，此项服务系教育信息化推进办公室为各院系、部门建立各自部门内网站所提供的基础性专项服务。 教育信息化推进办公室提供两台专供域名解析的服务器。其中一台主DNS服务器（202.115.160.33），二台辅助DNS服务器 （202.115.160.36和202.115.160.39）。\r\nWEB域名申请流程方式有两种：\r\n       第一种方式：无纸化网上申请注册（通过OA）\r\n        01.登录OA系统\r\n        02.点击“事务办理－事务申请－邮箱域名门户”即可看见“学校域名注册申请”审批。\r\n         \r\n       第二种方式：使用纸质文件\r\n       01. 准备申请\r\n       学校各单位准备新建向公众开放的WEB站点\r\n       02. 填写申请表 \r\n       填写域名注册申请表，点我下载 \r\n       填写二级网站备案表，点我下载\r\n       03. 提交申请\r\n       将申请表交到东8C座201室， 教育信息化推进办公室审核是否符合要求，两个工作日内开通，并通知申请人。\r\n       04.申请完成 \r\nWEB域名变更流程\r\n      01. 域名变更\r\n       因其它原因需要变更域名\r\n       02. 变更申请\r\n       填写域名变更申请表，点我下载\r\n       03. 提交申请\r\n       将申请表交到东8C座201室， 教育信息化推进办公室审核是否符合要求，两个工作日内开通，并通知申请人。\r\n       04. 申请完成    \r\n二级网站备案表，点我下载  \r\n      填好备案表后请交到东8C座201室，咨询电话6089282.', null, null);
INSERT INTO `answer` VALUES ('34', 'VPN 服务', '系统简介\r\n       我校的VPN（Virtual Private Network，虚拟专用网络）是指在公众网络上通过隧道方式所建立的我校校园网的独立通道，此独立通道拥有与在学校办公区上网相同的功能。通过此业务， 我校用户能轻松地在校外对图书馆资源http://www.lib.swust.edu.cn/、 OA网络智能办公系统 http://oa.swust.edu.cn/等仅能在校内访问的网络资源进行安全访问和管理。\r\n       使用方法：用户名和密码即为学校门户登录相同，默认状态下全校教师均已开通。\r\n        教育信息化推进办公室提供的VPN与图书馆提供的VPN区别如下：\r\n       图书馆的VPN：1、需要申请，2、根据读者申请需要开通指定访问权限。点我详细了解图书馆VPN系统\r\n        教育信息化推进办公室的VPN：1、全校教师只要能正常登录学校门户系统即可登录VPN，2、默认开通权限为访问学校所有资源。\r\n \r\nVPN密码修改流程\r\n       01. 密码不正确不能登录    \r\n       密码不正确无法正常登录VPN\r\n       02. 修改密码\r\n       通过密码保护找回：登录门户站点，使用门户系统自带的密码找回功能，找回密码人工修改：带上有效证件到东8C座201室。\r\n       03. 修改成功    \r\n       正常登录', null, null);
INSERT INTO `answer` VALUES ('35', '信息门户服务', '系统地址:http://urp.swust.edu.cn\r\n \r\n系统简介\r\n    西南科技大学信息门户是一套企业级信息服务平台，它将校内各业务系统、信息服务系统和其它应用资源系统集中整合到一个用户可定制的界面上，通过单点登录、统一认证，为校内用户和用户单位提供形式多样的个性化服务。\r\n \r\n首次登录流程\r\n     01. 首次登录            \r\n     首次登录信息门户：点我打开站点\r\n     02. 输入用户名和密码\r\n     学生登录：用户名为学号，密码为身份证去掉最后一位后倒数六位。\r\n     教师登录：用户名为工号，密码为6位生日。\r\n     03. 点击登录\r\n     正常登录。\r\n     如不能正常登录请致电6089282，咨询或使用\"密码找回功能\"\r\n     04. 登录成功进入页面        \r\n\r\n 密码修改流程的两种方式\r\n        第一种方式：无纸化网络申请修改（通过OA）\r\n        01.登录OA系统\r\n        02.点击“事务办理－事务申请－邮箱域名门户”即可看见校园门户密码修改。\r\n       \r\n        第二种方式：使用纸质文件\r\n        01. 不能正常登录    \r\n        密码不正确无法正常登录门户系统\r\n        02. 修改密码\r\n        自动修改：使用系统自带的密码找回功能找回密码\r\n        人工修改：带上有效证件到东8C座201室修改\r\n        03. 密码修改成功              \r\n        正常登录 ', null, null);
INSERT INTO `answer` VALUES ('36', '学生.家属区宽带服务', '缴费地点：西区西7办公楼309室    东区逸夫图书信息中心1楼21号\r\n\r\n服务时间\r\n       星期1-星期5 （上午：8:30--12:00  下午:13:30--18:00）\r\n       星期6-星期日（上午：9:00--12:00  下午:15:00--17:00）\r\n       星期6-星期日只安排了东区逸夫图书信息中心1楼21号缴费点营业,节假日另行通知。\r\n\r\n服务流程\r\n        01.用户申报故障\r\n        用户网络异常或不能上网致电6089289或10000申报故障。\r\n        02.致电用户，双方互助排查故障\r\n        维护人员联系故障用户电话指导处理，如不能处理则预约时间上门处理。\r\n        03.现场处理，恢复正常\r\n        维护人员处理完成故障后提交给调度人员回单，故障处理完成。', null, null);
INSERT INTO `answer` VALUES ('37', '办公区网络服务', '服务流程\r\n     01. 用户申报故障\r\n用户不能上网致电6089289申报故障 \r\n     02. 致电用户，双方互助排查故障\r\n     电话询问用户故障现象并判断故障位置及原因，若因用户端IP设置不当，远程指导用户处理，若故障不能排除或其它原因维护人员上门现场处理。\r\n     03. 现场处理恢复正常\r\n上门处理端口及交换机等故障，故障排除，上网正常。', null, null);
INSERT INTO `answer` VALUES ('38', '学校主页信息发布', '教育信息化推进办公室是西南科技大学主 页的建设和技术支持管理单位， 教育信息化推进办公室对主页信息发布的机制、流程、权限和技术手段进行规范化管理。在西南科技大学主页出现的信息，须通过本部门信息化主管领导、学校保密 办、学校分管领导审批后，方可在西南科技大学主页上进行发布。\r\n    学校主页上新闻管理部门：宣传部， 教育信息化推进办公室协助。\r\n    学校主页学术交流信息管理部门：科技处， 教育信息化推进办公室协助。 \r\n    学校主页公告与通知、招标及商业信息、其它栏目等管理部门： 教育信息化推进办公室。\r\n\r\n学校主页信息发布流程的两种方式\r\n\r\n        第一种方式：无纸化网络签发（通过OA）\r\n        01.登录OA系统\r\n        02.点击“事务办理－事务申请－邮箱域名门户”即可看见学校主页信息发布审批。\r\n\r\n       第二种方式：使用纸质文件\r\n        01.准备在主页上发布信息 \r\n       准备将信息公开发布到学校主页上\r\n       02. 填写保密审查表 西南科技大学信息公开保密审查表，点我下载。\r\n       03. 提交表格\r\n       将保密审查表和发布信息的纸质稿及电子稿交到东8C座201室。\r\n       04. 信息发布\r\n       教育信息化推进办公室于一个工作日内发布到指定栏目。\r\n       05. 发布完成 。 ', null, null);
INSERT INTO `answer` VALUES ('47', '1111111111111', '<p>22222222222222222</p>', null, '2016-04-21 14:58:49');
INSERT INTO `answer` VALUES ('72', '时间回到房间', '<p><img src=\"ueditor/jsp/upload/image/20160421/1461225638784088178.png\" title=\"1461225638784088178.png\" alt=\"校园自动问答系统.png\"/></p>', null, '2016-04-21 16:00:44');
INSERT INTO `answer` VALUES ('73', '决定减肥是开发', '<p>啊使得开发商的</p><p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160421/1461225676366069714.png\" style=\"width: 280px; height: 203px;\" title=\"1461225676366069714.png\" width=\"280\" height=\"203\"/><img src=\"ueditor/jsp/upload/image/20160421/1461225676386089284.png\" title=\"1461225676386089284.png\" width=\"314\" height=\"187\" style=\"width: 314px; height: 187px;\"/></p><p>哈哈哈</p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a href=\"http://ueditor/jsp/upload/file/20160421/1461225766571091401.zip\" target=\"_self\" title=\"apache-tomcat-7.0.23.zip\" textvalue=\"apache-tomcat-7.0.23.zip\">apache-tomcat-7.0.23.zip</a></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"ueditor/jsp/upload/file/20160421/1461225797142018935.zip\" title=\"20160229185656chromecj.com.zip\">20160229185656chromecj.com.zip</a></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"ueditor/jsp/upload/file/20160421/1461225809954044916.zip\" title=\"20160229185656chromecj.com.zip\">20160229185656chromecj.com.zip</a></p><p><br/></p>', null, '2016-04-21 16:04:04');
INSERT INTO `answer` VALUES ('74', '手机电话费就是', '<p>杀的好风景<img src=\"ueditor/jsp/upload/image/20160421/1461226333564033538.png\" title=\"1461226333564033538.png\" alt=\"校园自动问答系统 (1).png\"/></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"ueditor/jsp/upload/file/20160421/1461226343393013425.rar\" title=\"apache-maven-3.2.5.rar\">apache-maven-3.2.5.rar</a></p><p><br/></p>', null, '2016-04-21 16:12:28');
INSERT INTO `answer` VALUES ('75', '', '<p>1<br/></p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>11</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p><br/></p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>11</p><p><br/></p><p>1</p><p>11</p><p>1</p><p>1</p><p><br/></p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p>1</p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p><p><br/></p>', null, '2016-04-21 16:13:48');
INSERT INTO `answer` VALUES ('76', '啊都很规范和', '<p>阿斯顿</p>', null, '2016-04-21 16:34:53');
INSERT INTO `answer` VALUES ('77', '收到回复', '<p><img src=\"ueditor/jsp/upload/image/20160421/1461227880356015051.png\" title=\"1461227880356015051.png\" alt=\"自动问答系统流程图-new.png\"/></p>', null, '2016-04-21 16:38:02');
INSERT INTO `answer` VALUES ('78', '撒谎的功夫', '<p>啊圣诞节会飞</p><p><img src=\"ueditor/jsp/upload/image/20160421/1461227901120070303.png\" style=\"\" title=\"1461227901120070303.png\"/></p><p><img src=\"ueditor/jsp/upload/image/20160421/1461227905188014894.png\" style=\"\" title=\"1461227905188014894.png\"/></p><p><br/></p>', null, '2016-04-21 16:38:29');
INSERT INTO `answer` VALUES ('79', '就是大姐夫', '<p>是否还记得</p>', null, '2016-04-21 16:41:29');
INSERT INTO `answer` VALUES ('80', '时代河坊街萨芬卡死jfk的沙发', '<p><img src=\"ueditor/jsp/upload/image/20160423/1461384310639040441.png\" style=\"\" title=\"1461384310639040441.png\"/></p><p><img src=\"ueditor/jsp/upload/image/20160423/1461384310687021366.png\" style=\"\" title=\"1461384310687021366.png\"/></p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"ueditor/jsp/upload/file/20160423/1461384321738062295.zip\" title=\"apache-tomcat-7.0.23.zip\">apache-tomcat-7.0.23.zip</a></p><p><br/></p>', null, '2016-04-23 12:05:30');
INSERT INTO `answer` VALUES ('81', '沙发上啊就是看到jfk啦解放', '<p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160423/1461412093895000972.png\" title=\"1461412093895000972.png\" alt=\"1ab90065eb3e780481a37aea4e451222_b.png\"/></p><p style=\"text-align: center;\">时间的话放假撒法</p><p>哈哈</p><p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_rar.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"ueditor/jsp/upload/file/20160423/1461412149863037220.zip\" title=\"ueditor1_4_3_2-utf8-jsp.zip\">ueditor1_4_3_2-utf8-jsp.zip</a></p><p><br/></p>', null, '2016-04-23 19:49:13');
INSERT INTO `answer` VALUES ('82', '啊都很开放接口撒发货的', '<p><img src=\"ueditor/jsp/upload/image/20160423/1461412363959099848.png\" title=\"1461412363959099848.png\" alt=\"1461412363959099848.png\" width=\"16\" height=\"16\" border=\"0\" vspace=\"0\" style=\"width: 16px; height: 16px;\"/></p>', null, '2016-04-23 19:53:08');
INSERT INTO `answer` VALUES ('83', '时代河坊街就是快递放假啊考试辅导和卡上的疯狂？', '<p>sajfhdjksahfewahf</p>', null, '2016-04-25 13:56:12');
INSERT INTO `answer` VALUES ('84', '是冬季护肤开始疯狂的撒酒疯', '<p>asjhdfkjaheifawe f</p>', null, '2016-04-25 14:11:35');
INSERT INTO `answer` VALUES ('85', '是冬季护肤开始疯狂的撒酒疯', '<p>safdsafdsaf</p>', null, '2016-04-25 14:15:03');
INSERT INTO `answer` VALUES ('86', '时代河坊街就是快递放假啊考试辅导和卡上的疯狂？', '<p><img src=\"ueditor/jsp/upload/image/20160425/1461568572609072445.png\" title=\"1461568572609072445.png\" alt=\"test.png\"/></p>', null, '2016-04-25 15:16:14');
INSERT INTO `answer` VALUES ('87', '为什么为什么为什么为什么？', '<p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160425/1461569621455095279.png\" title=\"1461569621455095279.png\" alt=\"test.png\"/></p><p style=\"text-align: center;\">不为什么！！！！！<br/></p>', null, '2016-04-25 15:33:58');
INSERT INTO `answer` VALUES ('88', '写的好卡家的撒udfk', '<p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160425/1461569893380009630.png\" title=\"1461569893380009630.png\" alt=\"test.png\"/></p><p style=\"text-align: center;\">傻逼！啊</p>', null, '2016-04-25 15:38:28');
INSERT INTO `answer` VALUES ('89', '这是什么？', '<h1><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;;\">用来测试用来测试用来测试！</span></h1>', null, '2016-04-25 15:39:17');
INSERT INTO `answer` VALUES ('90', '设计的疯狂撒酒疯', '<p><img src=\"ueditor/jsp/upload/image/20160501/1462103339769006861.png\" title=\"1462103339769006861.png\" alt=\"1461568572609072445.png\"/></p>', null, '2016-05-01 19:49:01');
INSERT INTO `answer` VALUES ('91', '他们说快些一首情歌雅俗共赏', '<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204); border-bottom-width: 2px; border-bottom-style: solid; padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\"><span style=\"font-family: 微软雅黑, &#39;Microsoft YaHei&#39;; font-size: 20px;\">雅俗共赏：许嵩</span></h1><p><br/></p><p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160501/1462104429289023276.jpg\" style=\"\" title=\"1462104429289023276.jpg\"/></p><p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160501/1462104429403003955.jpg\" style=\"\" title=\"1462104429403003955.jpg\"/></p><p style=\"text-align: center;\"><img src=\"ueditor/jsp/upload/image/20160501/1462104429402075585.jpg\" style=\"\" title=\"1462104429402075585.jpg\"/></p><p><br/></p>', null, '2016-05-01 20:08:19');
INSERT INTO `answer` VALUES ('92', '啦啦啦嘻嘻', '<p><img src=\"ueditor/jsp/upload/image/20160501/1462104605935040991.jpg\" title=\"1462104605935040991.jpg\" alt=\"657ACA4F9353BB75D9892C26CCD23735.jpg\"/></p>', null, '2016-05-01 20:10:08');
INSERT INTO `answer` VALUES ('93', '我真的不知道该怎么改了，改什么啊？！', '<p style=\"text-align: center;\"><span style=\"color: rgb(79, 129, 189);\">我只想说改个僚子啊</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(79, 129, 189);\"><img src=\"ueditor/jsp/upload/image/20160509/1462783195912085406.jpg\" title=\"1462783195912085406.jpg\" alt=\"657ACA4F9353BB75D9892C26CCD23735.jpg\"/></span></p>', null, '2016-05-09 16:40:00');
INSERT INTO `answer` VALUES ('94', '我真的不知道该怎么改了，改什么啊？！', '<p style=\"text-align: center;\"><span style=\"color: rgb(79, 129, 189);\">我只想说改个僚子啊</span></p><p style=\"text-align: center;\"><span style=\"color: rgb(79, 129, 189);\"><img src=\"ueditor/jsp/upload/image/20160509/1462783195912085406.jpg\" title=\"1462783195912085406.jpg\" alt=\"657ACA4F9353BB75D9892C26CCD23735.jpg\"/></span></p><p><span style=\"color: rgb(79, 129, 189);\">hehe</span></p>', null, '2016-05-11 15:39:12');
INSERT INTO `answer` VALUES ('95', '还是等到风景哈地方还是咖啡？？？？？？？？？', '<p style=\"text-align: center;\">黑手党教父哈是发动机卡号发卡号发<br/></p><p style=\"text-align: center;\"><img src=\"/file/test.jpg\"/></p>', null, '2016-05-13 09:49:17');
INSERT INTO `answer` VALUES ('98', '还是进口的风口浪尖ask发货', '<p style=\"text-align: center;\"><img src=\"/ueditor/jsp/upload/image/20160511/1462977710748053329.jpg\" style=\"\" title=\"1462977710748053329.jpg\"/></p><p style=\"text-align: center;\"><img src=\"/ueditor/jsp/upload/image/20160511/1462977710766028365.jpg\" title=\"1462977710766028365.jpg\"/></p><p><br/></p>', null, '2016-05-11 22:47:22');
INSERT INTO `answer` VALUES ('99', '你是真的不知道啊', '<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204); border-bottom-width: 2px; border-bottom-style: solid; padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\">这是标题</h1><p><br/></p><p style=\"text-align: center;\"><img src=\"/ueditor/jsp/upload/image/20160511/1462979086275069978.png\" style=\"\" title=\"1462979086275069978.png\"/></p><p style=\"text-align: center;\"><img src=\"/ueditor/jsp/upload/image/20160511/1462979104922019839.jpg\" style=\"\" title=\"1462979104922019839.jpg\"/></p><p><br/></p>', null, '2016-05-12 13:45:34');
INSERT INTO `answer` VALUES ('100', '像单纯的小猫', '<p>哈哈</p>', null, '2016-05-11 23:09:07');
INSERT INTO `answer` VALUES ('101', '你想知道想知道不', '<h1 label=\"标题居中\" style=\"font-size: 32px; font-weight: bold; border-bottom-color: rgb(204, 204, 204); border-bottom-width: 2px; border-bottom-style: solid; padding: 0px 4px 0px 0px; text-align: center; margin: 0px 0px 20px;\">许嵩：VAE</h1><p><br/></p><p style=\"text-align: center;\"><img src=\"/ueditor/jsp/upload/image/20160511/1462981556336034064.jpg\" title=\"1462981556336034064.jpg\" alt=\"95D199E8D4532E454B8694FE5EB78FA1.jpg\"/></p>', null, '2016-05-11 23:50:08');
INSERT INTO `answer` VALUES ('102', '嘿嘿嘿', '<p style=\"line-height: 16px;\"><img style=\"vertical-align: middle; margin-right: 2px;\" src=\"http://localhost:8080/CAQAS/dialogs/attachment/fileTypeImages/icon_txt.gif\"/><a style=\"font-size:12px; color:#0066cc;\" href=\"/ueditor/jsp/upload/file/20160511/1462982046088054403.txt\" title=\"数据库修改备注.txt\">数据库修改备注.txt</a></p><p><br/></p>', null, '2016-05-11 23:55:32');
INSERT INTO `answer` VALUES ('104', '乐乐乐', '<p><span style=\"font-size: 14px;\">么么</span><br/></p>', null, '2016-05-12 16:28:42');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) DEFAULT NULL,
  `cate_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cate_id`),
  KEY `cate_user_id` (`cate_user_id`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`cate_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '教务', '2');
INSERT INTO `category` VALUES ('2', '地方', '2');
INSERT INTO `category` VALUES ('7', '哈哈', '2');
INSERT INTO `category` VALUES ('9', 'hehe', '3');
INSERT INTO `category` VALUES ('10', '新增类', '4');
INSERT INTO `category` VALUES ('11', '生活类', '2');
INSERT INTO `category` VALUES ('12', '网络类', '2');
INSERT INTO `category` VALUES ('13', '心理类', '2');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '计算机科学与技术');
INSERT INTO `department` VALUES ('3', '信息学院');
INSERT INTO `department` VALUES ('4', '文学与艺术学院');
INSERT INTO `department` VALUES ('5', '环境与资源');
INSERT INTO `department` VALUES ('6', '材料科学与工程');
INSERT INTO `department` VALUES ('7', '生命学院');
INSERT INTO `department` VALUES ('8', '理学院');
INSERT INTO `department` VALUES ('9', '经管学院');
INSERT INTO `department` VALUES ('10', '法学院');
INSERT INTO `department` VALUES ('11', '马克思主义学院');
INSERT INTO `department` VALUES ('12', '外国语学院');
INSERT INTO `department` VALUES ('13', '体育学科部');
INSERT INTO `department` VALUES ('14', '成人教育学院');
INSERT INTO `department` VALUES ('15', '应用技术学院');
INSERT INTO `department` VALUES ('17', '软件专业');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feed_id` int(11) NOT NULL AUTO_INCREMENT,
  `feed_ip` varchar(255) DEFAULT NULL,
  `feed_time` datetime DEFAULT NULL,
  `feed_is_useful` int(1) DEFAULT NULL,
  `feed_ques_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`feed_id`),
  KEY `feed_ques_id` (`feed_ques_id`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`feed_ques_id`) REFERENCES `question` (`ques_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('15', '0:0:0:0:0:0:0:1', '2016-05-13 16:36:45', '1', '2');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `ques_id` int(11) NOT NULL AUTO_INCREMENT,
  `ques_title` varchar(255) DEFAULT NULL,
  `search_num` int(11) NOT NULL DEFAULT '0',
  `ques_answ_id` int(11) DEFAULT NULL,
  `ques_create_time` datetime DEFAULT NULL,
  `ques_isuse_num` int(11) DEFAULT '0',
  `ques_nouse_num` int(11) DEFAULT '0',
  `ques_user_id` int(11) DEFAULT NULL,
  `ques_cate_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ques_id`),
  KEY `ques_answ_id` (`ques_answ_id`),
  KEY `ques_cate_id` (`ques_cate_id`),
  KEY `ques_user_id` (`ques_user_id`),
  CONSTRAINT `question_ibfk_2` FOREIGN KEY (`ques_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `question_ibfk_3` FOREIGN KEY (`ques_cate_id`) REFERENCES `category` (`cate_id`),
  CONSTRAINT `question_ibfk_4` FOREIGN KEY (`ques_answ_id`) REFERENCES `answer` (`answ_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '什么是学分制？', '151', '1', '2016-04-24 10:42:46', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('2', '什么是学分？它是怎么计算的？', '101', '2', '2016-04-24 10:48:32', '1', '0', '2', '13');
INSERT INTO `question` VALUES ('3', '转专业有些什么条件？', '37', '3', '2016-04-24 10:48:59', '0', '0', '2', '11');
INSERT INTO `question` VALUES ('4', '申请辅修资格有什么条件？', '93', '4', '2016-04-24 10:49:23', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('5', '这是什么？', '23', '89', '2016-04-25 15:39:17', '0', '0', '2', '7');
INSERT INTO `question` VALUES ('6', '啦啦啦嘻嘻', '10', '92', '2016-05-01 20:10:08', '0', '0', '2', '7');
INSERT INTO `question` VALUES ('8', '如何申请双学位？', '152', '5', '2016-04-24 10:51:49', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('9', '我可以提前毕业或延长学习年限吗？', '128', '6', '2016-04-24 10:52:06', '0', '0', '2', '2');
INSERT INTO `question` VALUES ('10', '写的好卡家的撒udfk', '6', '88', '2016-04-25 15:38:28', '0', '0', '2', '2');
INSERT INTO `question` VALUES ('11', '选课的时间安排是怎么样的？', '7', '7', '2016-04-24 10:52:54', '0', '0', '2', '13');
INSERT INTO `question` VALUES ('12', '为什么有的课程安排了上课时间和地点，有的课程没有安排？', '7', '8', '2016-04-24 10:53:13', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('18', '为什么为什么为什么为什么？', '5', '87', '2016-04-25 11:59:19', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('19', '时代河坊街就是快递放假啊考试辅导和卡上的疯狂？', '11', '86', '2016-04-25 13:01:13', '0', '0', '2', '12');
INSERT INTO `question` VALUES ('20', '时代河坊街萨芬卡死jfk的沙发', '5', '80', '2016-04-25 13:36:20', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('21', '沙发上啊就是看到jfk啦解放', '12', '81', '2016-04-25 13:36:30', '0', '0', '2', '11');
INSERT INTO `question` VALUES ('23', '是冬季护肤开始疯狂的撒酒疯', '12', '85', '2016-04-25 14:11:21', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('25', '设计的疯狂撒酒疯', '19', '90', '2016-05-01 19:49:01', '0', '0', '4', '10');
INSERT INTO `question` VALUES ('26', '他们说快些一首情歌雅俗共赏', '30', '91', '2016-05-01 20:08:19', '0', '0', '3', '9');
INSERT INTO `question` VALUES ('27', '中枪中奖感觉都一样', '0', null, '2016-05-01 20:15:45', '0', '0', '3', '9');
INSERT INTO `question` VALUES ('39', '到底哪些是学分制', '33', '1', '2016-05-12 15:20:31', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('44', '我真的不知道该怎么改了，改什么啊？！', '8', '94', '2016-05-11 15:39:12', '0', '0', '2', '7');
INSERT INTO `question` VALUES ('46', '像单纯的小猫', '1', '100', '2016-05-11 23:09:07', '0', '0', '2', null);
INSERT INTO `question` VALUES ('47', '还是等到风景哈地方还是咖啡？？？？？？？？？', '1', '95', '2016-05-13 09:49:17', '0', '0', '2', null);
INSERT INTO `question` VALUES ('48', '还是进口的风口浪尖ask发货', '0', '98', '2016-05-11 22:47:22', '0', '0', '2', '7');
INSERT INTO `question` VALUES ('49', '你是真的不知道啊', '2', '99', '2016-05-12 13:45:34', '0', '0', '2', null);
INSERT INTO `question` VALUES ('50', '你想知道想知道不？？？', '14', '101', '2016-05-11 23:50:08', '0', '0', '2', null);
INSERT INTO `question` VALUES ('51', '嘿嘿嘿作为一个标题啊！！！', '1', '102', '2016-05-11 23:55:32', '0', '0', '2', null);
INSERT INTO `question` VALUES ('53', '学分制的概念是什么？？？', '34', '1', '2016-05-12 15:20:23', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('54', '学分制de概念', '27', '1', '2016-05-12 15:21:44', '0', '0', '2', '1');
INSERT INTO `question` VALUES ('55', '乐乐乐', '1', '88', '2016-05-13 09:50:29', '0', '0', '2', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL COMMENT '0：管理员，1：普通部门用户',
  `user_mail` varchar(255) DEFAULT NULL,
  `user_dep_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_dep_id` (`user_dep_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`user_dep_id`) REFERENCES `department` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '0', '23432432@163.com', null);
INSERT INTO `user` VALUES ('2', 'dongbaog', 'admin', '1', '1573543038@qq.com', '1');
INSERT INTO `user` VALUES ('3', 'swust', '123456', '1', 'haha@163.com', '17');
INSERT INTO `user` VALUES ('4', 'baobao', '123456', '1', 'lelele@163.com', '17');
