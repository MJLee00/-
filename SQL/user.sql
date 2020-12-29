Create database passingplatform;

DROP TABLE IF EXISTS `log`;
create TABLE `log`(
    `logid` int not null auto_increment,
    `detail` varchar(100) ,
    `createtime` datetime ,
    `level` int ,
    `operator` varchar(45) ,
    primary key (logid)
)engine =InnoDB auto_increment=1 default charset=utf8mb4 collate=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `inherittoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `inherittoken` (
  `inheritTokenid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `inheritTokenname` varchar(45) NOT NULL,
  `inheritTokencontent` text NOT NULL,
  `inheritTokenimg` varchar(45) NOT NULL,
  `creattime` datetime NOT NULL,
  PRIMARY KEY (`inheritTokenid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inherittoken`
--

LOCK TABLES `inherittoken` WRITE;
/*!40000 ALTER TABLE `inherittoken` DISABLE KEYS */;
INSERT INTO `inherittoken` VALUES (1,3,'变脸','wewewe','aviater1.jpg','2020-11-15 15:49:39'),
                                  (2,3,'变脸','wewewe','aviater1.jpg','2020-11-15 15:50:00'),
                                  (3,3,'变脸','wewewe','aviater1.jpg','2020-11-15 15:50:00'),
                                  (4,3,'变脸','wewewe','aviater1.jpg','2020-11-15 15:50:00'),
                                  (5,3,'变脸','wewewe','aviater1.jpg','2020-11-15 15:50:00');
/*!40000 ALTER TABLE `inherittoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `message` (
  `messageid` int(11) NOT NULL AUTO_INCREMENT,
  `senderid` int(11) NOT NULL,
  `receiverid` int(11) NOT NULL,
  `content` text NOT NULL,
  `sendtime` datetime NOT NULL,
  `ifread` int(11) NOT NULL,

  `type` int NOT NULL comment '0拜师1令牌2评论',
  `typeid`  int unsigned not null comment '消息类型表的id',
  PRIMARY KEY (`messageid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,11,3,'拜师消息','2020-11-15 15:49:39',1,'0',1),
                             (2,1,11,'拜师消息','2020-11-16 14:08:37',1,'0',2),
                             (3,11,44,'申请令牌消息','2020-11-16 14:52:23',0,'1',3),
                             (4,11,43,'评论消息','2020-11-16 14:52:59',0,'2',4),
                             (5,11,44,'评论消息','2020-11-16 15:04:01',0,'2',5);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `teachertouser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teachertouser` (
  `idTeacherToUser` int(11) NOT NULL AUTO_INCREMENT,
  `teacherid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `starttime` datetime NOT NULL,
  PRIMARY KEY (`idTeacherToUser`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachertouser`
--

LOCK TABLES `teachertouser` WRITE;
/*!40000 ALTER TABLE `teachertouser` DISABLE KEYS */;
insert into `teachertouser` values ('1','3','1','2020-11-25'),
                                   ('2','4','1','2020-11-25'),
                                   ('3','5','1','2020-11-25'),
                                   ('4','6','1','2020-11-25'),
                                   ('5','7','1','2020-11-25'),
                                   ('6','3','11','2020-11-25'),
                                   ('7','3','12','2020-11-25'),
                                   ('8','3','13','2020-11-25'),
                                   ('9','3','14','2020-11-25'),
                                   ('10','3','15','2020-11-25');
/*!40000 ALTER TABLE `teachertouser` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `works`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `works` (
  `worksid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `worksname` varchar(255) NOT NULL,
  `workscontent` text NOT NULL,
  `vedio` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `publishtime` datetime NOT NULL,
  PRIMARY KEY (`worksid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `works`
--

LOCK TABLES `works` WRITE;
/*!40000 ALTER TABLE `works` DISABLE KEYS */;
INSERT INTO `works` VALUES (1,3,'new','szcnbwd','dw','dw','1000-01-01 00:00:00'),(2,3,'变脸','wewewe','test.mp4','aviater1.jpg','2020-11-15 16:14:05'),
                           (3,3,'new','szcnbwd','test.mp4','aviater1.jpg','2020-11-15 16:14:26'),
                           (4,3,'edddde','dddwdwdddd','test.mp4','aviater1.jpg','2020-11-15 16:16:15'),
                           (5,3,'new','szcnbwd','test.mp4','aviater1.jpg','2020-11-15 16:18:03')
                   ;
/*!40000 ALTER TABLE `works` ENABLE KEYS */;
UNLOCK TABLES;
drop table  user,teacher;
create table if not exists `user`(
    `id` int unsigned not null auto_increment,
    `account` varchar(100) not null,
    `password` varchar (100) not null,
    `type` int default 2 comment '1老师2学生3管理员',
    `nickname` varchar (100) ,
    `profileImage` varchar (100),
    `sex` int default 1,
    `intro` varchar (1000),
    `name` varchar (1000),
    `phone` varchar (100),
    `email` varchar (100),
    primary key (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


create table if not exists `teacher`(
    `uid` int unsigned not null ,
    `businessname` varchar(100) not null ,
    `businesslogo` varchar(100) not null ,
    `mainitem` int default 1  ,
    `commitment` varchar(100) not null ,
    `imageone` varchar(100) not null ,
    `imagetwo` varchar(100) not null ,
    `businessplan` varchar(1000) not null ,
    `sequence` int default 1,
    `courseid` int ,

    primary key (`uid`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


#6个学生
insert into user (id,account,profileImage, password, nickname,intro) VALUES
(1,"student","aviater1.jpg","123123","stu","test");


insert into user (id,account,profileImage, password, nickname,intro) VALUES
(11,"student1","aviater1.jpg","123123","stu","test");


insert into user (id,account,profileImage, password, nickname,intro) VALUES
(12,"student2","aviater1.jpg","123123","stu","test");


insert into user (id,account,profileImage, password, nickname,intro) VALUES
(13,"student3","aviater1.jpg","123123","stu","test");


insert into user (id,account,profileImage, password, nickname,intro) VALUES
(14,"student4","aviater1.jpg","123123","stu","test");


insert into user (id,account,profileImage, password, nickname,intro) VALUES
(15,"student5","aviater1.jpg","123123","stu","test");

#管理员
insert into user (id,account,profileImage,    password, nickname,type,intro) VALUES
(2,"admin","aviater1.jpg","123123","admin",3,"test");

#5个老师
insert into user (id,account,profileImage, password, nickname,type,intro) VALUES
(3,"teacher","aviater1.jpg","123123","teacher",1,"test");
insert into teacher(uid, businessname, businesslogo, commitment, imageone, imagetwo, businessplan, courseid) VALUES
(3,"书画","src","src","src","src","好好学习",1);

insert into user (id,account,profileImage, password, nickname,type,intro) VALUES
(4,"teacher1","aviater1.jpg","123123","a",1,"test");
insert into teacher(uid, businessname, businesslogo, commitment, imageone, imagetwo, businessplan, courseid) VALUES
(4,"书画","src","src","src","src","好好学习",1);

insert into user (id,account,profileImage, password, nickname,type,intro) VALUES
(5,"teacher2","aviater1.jpg","123123","b",1,"test");
insert into teacher(uid, businessname, businesslogo, commitment, imageone, imagetwo, businessplan, courseid) VALUES
(5,"书画","src","src","src","src","好好学习",1);

insert into user (id,account,profileImage, password, nickname,type,intro) VALUES
(6,"teacher3","aviater1.jpg","123123","c",1,"test");
insert into teacher(uid, businessname, businesslogo, commitment, imageone, imagetwo, businessplan, courseid) VALUES
(6,"书画","src","src","src","src","好好学习",1);

insert into user (id,account,profileImage,password, nickname,type,intro) VALUES
(7,"teacher4","aviater1.jpg","123123","d",1,"test");
insert into teacher(uid, businessname, businesslogo, commitment, imageone, imagetwo, businessplan, courseid) VALUES
(7,"书画","src","src","src","src","好好学习",1);



drop table if exists courseIntro;
create table if not exists `courseIntro`(
    `id` int unsigned not null auto_increment ,
    `teacherid` int unsigned not null ,
    `teachername` varchar(100) not null ,
    `title` varchar(100) not null ,
    `intro` varchar(100)not null ,
    `abstract` varchar(100) not null ,
    `summurize`  varchar(100) not null ,
    `goal` varchar(100) not null ,
    `outline` varchar(100) not null ,
    `reference` varchar(100) not null ,
    `people` int not null ,
    `sequence` int default 0,
    `src` varchar(100) not null ,
    primary key (`id`)
)engine=InnoDB  auto_increment=1 default char set =utf8;
insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小明','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,0,'aviater1.jpg');

insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小红','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,1,'aviater1.jpg');
insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小张','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,2,'aviater1.jpg');
insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小蓝','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,3,'aviater1.jpg');
insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小lb','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,5,'aviater1.jpg');
insert into courseIntro(teacherid, teachername, title, intro, abstract, summurize, goal, outline, reference, people,sequence,src) VALUES
('3','小zi','文化传承','课程简介:名师推荐_唐诗宋词_幼儿教育_教育专区。名师推荐 袀 推荐 xxx 女,xxxxxxxxxxxxxxxx教育科学研究院小学部xxxxxxxxxxxxxxxxxxxxxxxxxxxx主任,'
,'xxxxxxxxx','xxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxxxxxx',40,4,'aviater1.jpg');

drop table if exists  CourseDetail;
create table `CourseDetail`(
    `id` int unsigned not null  auto_increment,
    `score` varchar(1000) not null ,
    `scoretitle` varchar(1000) not null ,
    `bulletin` varchar(1000) not null ,
    `bulletintitle` varchar(1000)   not null ,
    `title` varchar(100) not null ,
    `tag` varchar(100) not null ,
    `author` varchar(100) not null ,
    `src` varchar(100) not null ,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set=utf8;
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小明','aviater1.jpg');
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小红','aviater1.jpg');
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小张','aviater1.jpg');
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小蓝','aviater1.jpg');
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小lb','aviater1.jpg');
insert  into coursedetail(score, scoretitle, bulletin, bulletintitle,title,tag,author,src) VALUES
('本课程满分100分，由单元测验、期末考试、课程讨论情况三部分组成： 1.单元测验占50%：课程安排单元测验5次，每次占总分的10%。测验题均为客观题(单选题、多选2.题、判断题、填空题)。 3.期末考试占40%：期末考试成绩占总分的40%，试题均为客观题。 4.课程讨论占10%：“课堂交流区”中的讨论情况占总成绩的10%，学习者在活跃度(需要在“课堂交流区”中回复的数量达到10次以上)达到标准即可获得10分，否则不得分。',
 '评分标准','第8讲材料发布','大家好，今天8:00发布第8讲的学习材料。 在第7讲中我们分析了自上而下分析的基本问题，介绍了消除文法的左递归和消除回溯的方法， 给出了文法可以进行自上而下分析的LL(1)条件。针对满足LL(1)条件的文法，我们可以设计自上而下分析方法了。 今天发布的第8讲介绍了一种设计自上而下分析的方法——递归下降分析器。祝大家学习进步！ 《编译原理》课程组',
 '西方现代艺术欣赏','国家精品','小zi','aviater1.jpg');
#课件
drop table if exists Courseware;
create  table `Courseware`(
    `id` int unsigned not null auto_increment,
    `courseid` int unsigned not null ,
    `video` varchar(100) not null ,
    `title` varchar(100) not null ,
    `document` varchar(100) not null,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第一讲 文化传承','E:/近世代数/01 集合与映射.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第二讲 文化传承','E:/近世代数/02 半群与群.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第三讲 文化传承','E:/近世代数/03 正规子群与商群.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第四讲 文化传承','E:/近世代数/04 环.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第五讲 文化传承','E:/近世代数/05 商环、欧氏环.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第六讲 文化传承','E:/近世代数/06 有限域.pdf');
insert into courseware(courseid, video, title, document)
values (1,'test.mp4','第七讲 文化传承','E:/近世代数/01 集合与映射.pdf');



#测试题
drop table if exists Testing;
create  table  `Testing`(
    `id` int unsigned not null  auto_increment,
    `courseid` int unsigned not null ,
    `endTime` varchar(100) not null,
    `testtitle` varchar(100) not null ,
    `title` varchar(100) not null ,
    `content` varchar(1000) not null ,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert into Testing(courseid, endTime,title,testtitle,content) VALUES (1,'截止日期:2020/12/02 10:00','第一章：现代艺术导论','第一章测验','本章测验均为客观题型，其中判断题每题1分，单选题每题2分，多选题每题4分。多次提交后以最高值为最终得分。
截止时间           2020/12/02 10:00
                         请务必在截止时间之前提交，截止时间后的提交不再计分
有效分数           0.00/20.00
                         你的每一次测验系统都将为你计分，并提取最高得分作为你的有效分数
有效提交次数    0/3
        ');
insert into Testing(courseid, endTime,title,testtitle,content) VALUES (1,'截止日期:2020/12/02 10:00','第二章：现代艺术导论','第二章测验','         本章测验均为客观题型，其中判断题每题1分，单选题每题2分，多选题每题4分。多次提交后以最高值为最终得分。
截止时间           2020/12/02 10:00
                         请务必在截止时间之前提交，截止时间后的提交不再计分
有效分数           0.00/20.00
                         你的每一次测验系统都将为你计分，并提取最高得分作为你的有效分数
有效提交次数    0/3
        ');
insert into Testing(courseid, endTime,title,testtitle,content) VALUES (1,'截止日期:2020/12/02 10:00','第三章：现代艺术导论','第三章测验','         本章测验均为客观题型，其中判断题每题1分，单选题每题2分，多选题每题4分。多次提交后以最高值为最终得分。
截止时间           2020/12/02 10:00
                         请务必在截止时间之前提交，截止时间后的提交不再计分
有效分数           0.00/20.00
                         你的每一次测验系统都将为你计分，并提取最高得分作为你的有效分数
有效提交次数    0/3
        ');
insert into Testing(courseid, endTime,title,testtitle,content) VALUES (1,'截止日期:2020/12/02 10:00','第四章：现代艺术导论','第四章测验','         本章测验均为客观题型，其中判断题每题1分，单选题每题2分，多选题每题4分。多次提交后以最高值为最终得分。
截止时间           2020/12/02 10:00
                         请务必在截止时间之前提交，截止时间后的提交不再计分
有效分数           0.00/20.00
                         你的每一次测验系统都将为你计分，并提取最高得分作为你的有效分数
有效提交次数    0/3
        ');
insert into Testing(courseid, endTime,title,testtitle,content) VALUES (1,'截止日期:2020/12/02 10:00','第五章：现代艺术导论','第五章测验','         本章测验均为客观题型，其中判断题每题1分，单选题每题2分，多选题每题4分。多次提交后以最高值为最终得分。
截止时间           2020/12/02 10:00
                         请务必在截止时间之前提交，截止时间后的提交不再计分
有效分数           0.00/20.00
                         你的每一次测验系统都将为你计分，并提取最高得分作为你的有效分数
有效提交次数    0/3
        ');

#每一道题
drop table if exists Topics;
create table `Topics`(
    `id` int unsigned not null auto_increment,
    `testingid` int unsigned not null ,
    `title` varchar(100) not null ,

    `type` int not null comment '1单选2多选3判断4填空',
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert into Topics(testingid, title, type) VALUES (1,'单选',1);
insert into Topics(testingid, title, type) VALUES (1,'单选',1);

insert into Topics(testingid, title, type) VALUES (1,'多选',2);
insert into Topics(testingid, title, type) VALUES (1,'多选',2);

insert into Topics(testingid, title, type) VALUES (1,'判断题',3);
insert into Topics(testingid, title, type) VALUES (1,'判断题',3);

insert into Topics(testingid, title, type) values (1,'填空',4);
insert into Topics(testingid, title, type) values (1,'填空',4);


#选项
drop table if exists `option`;
create table `option`(
    `id` int unsigned not null auto_increment,
    `content` varchar(100) not null ,
    `answer` varchar(100) not null ,
    `topicid` int unsigned not null ,
    `score` int default 0,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert into `option` (content, answer, topicid,score) values ('a选项题目','true',1,2);
insert into `option` (content, answer,topicid , score) values ('b选项题目','false',1,0);
insert into `option` (content, answer,topicid, score) values ('c选项题目','false',1,0);
insert into `option` (content, answer,topicid, score) values ('d选项题目','false',1,0);
insert into `option` (content, answer, topicid,score) values ('a选项题目','true',2,2);
insert into `option` (content, answer,topicid , score) values ('b选项题目','false',2,0);
insert into `option` (content, answer,topicid, score) values ('c选项题目','false',2,0);
insert into `option` (content, answer,topicid, score) values ('d选项题目','false',2,0);

insert into `option` (content, answer,topicid, score) values ('a选项题目','true',3,2);
insert into `option` (content, answer,topicid, score) values ('b选项题目','true',3,2);
insert into `option` (content, answer,topicid, score) values ('c选项题目','false',3,0);
insert into `option` (content, answer,topicid, score) values ('d选项题目','false',3,0);
insert into `option` (content, answer,topicid, score) values ('a选项题目','true',4,2);
insert into `option` (content, answer,topicid, score) values ('b选项题目','true',4,2);
insert into `option` (content, answer,topicid, score) values ('c选项题目','false',4,0);
insert into `option` (content, answer,topicid, score) values ('d选项题目','false',4,0);

insert into `option` (content, answer,topicid, score) values ('判断题123123123','false',5,2);
insert into `option` (content, answer,topicid, score) values ('判断题123123123','false',6,2);

insert into `option` (content, answer,topicid, score) values ('请问犬瘟热犬瘟热','答案是123',7,4);
insert into `option` (content, answer,topicid, score) values ('请问犬瘟热犬瘟热','答案是123',8,4);




drop table if exists Recruit;
create table `Recruit`(
    `id` int unsigned not null auto_increment,
    `teacherid` int unsigned not null ,
    `maxcount` int unsigned,
    `count` int unsigned,
    `content` varchar(100) not null ,
    `title` varchar(100) not null,
    `img` varchar(45) not null ,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');
insert  into recruit (teacherid,maxcount, count, content, title,img) VALUES (3,30,5,'文化传承','招募','aviater1.jpg');


drop table if exists applyTeacher;
create table `applyTeacher`(
    `id` int unsigned not null auto_increment,
    `applyid` int unsigned not null ,
    `selfintro` varchar(100) not null ,
    `reason` varchar(100) not null ,
    `advangtage` varchar(100) not null ,
    `prize` varchar(100)  ,
    `name` varchar(100) not null ,
    `phone` varchar(100) not null ,
    `email` varchar(100)  not null,
    `isConfirmed` bool default false,
    `recruitid` int unsigned not null,
    primary key (`id`)
)engine=InnoDB auto_increment=1 default char set =utf8;
insert into applyTeacher(applyid, selfintro, reason, advangtage, prize, name, phone, email, isConfirmed, recruitid) VALUES
(1,'自我介绍','原因','优势','奖项','小明','1579123123','12391203@qq.com',false,1);
