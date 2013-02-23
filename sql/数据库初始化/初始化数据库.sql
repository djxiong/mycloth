/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/11/7 14:49:33                           */
/*==============================================================*/

CREATE DATABASE `cloth` DEFAULT CHARACTER SET gb2312 COLLATE gb2312_chinese_ci;
USE `cloth`;

CREATE TABLE IF NOT EXISTS ReturnRecord
(
   returnRecordID        int not null AUTO_INCREMENT comment '主键。',
   clothID               int not null comment '退货服装',
   returnDate      	date comment '退货日期',
   reason          varchar(300)  comment '退货原因',
   count     int  comment '退货数量',
   primary key (returnRecordID)
);

CREATE TABLE IF NOT EXISTS OrderHistory
(
   orderHistoryID        int not null AUTO_INCREMENT comment 'orderHistoryID。',
   clothID               int not null comment '购买的衣服',
   customerID            int  comment '购买者',
   consumption 			float NOT NULL COMMENT '消费金额',
   consumeDate      	date comment '消费日期',
   orderNumber          varchar(50)  comment '订单号',
   state             	varchar(50)  comment '订单状态',
   exchangedOrderID     int  comment '被换货的订单ID',
   primary key (orderHistoryID)
);


CREATE TABLE IF NOT EXISTS Cloth
(
   clothID               int not null AUTO_INCREMENT comment 'clothID。',
   name             varchar(50)  comment '名称',
   size             varchar(50)  comment '尺寸',
   color               int  comment '颜色',
   barCode             varchar(50)  comment '条码',
   count               int  comment '数量',
   salesOffType             varchar(50) comment '降价类型',
   salesOff 		float  COMMENT '降价比例或金额',
   originalPrice 	float  COMMENT '成本价',
   price 			float COMMENT '价格',
   stockDate 	    date comment '进货日期',
   primary key (clothID)
);


CREATE TABLE IF NOT EXISTS Customer2
(
   customer2ID               int not null AUTO_INCREMENT comment 'customer2ID。',
   name             varchar(50) not null comment '姓名',
   phone             varchar(50)  comment '电话号码',
   customerNumber             varchar(50)  comment '客户编号',
   primary key (customer2ID)
);


/*==============================================================*/
/* Table: Agreement                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Agreement
(
   custID               int not null comment 'custID。',
   compID               int not null comment 'compID。',
   fileCode             varchar(50) not null comment '协议编号。',
   fileID               int comment '档案ID。',
   userID               int comment 'userID。',
   agreeSignedDate      date comment '签订协议时间。',
   agreeExpireDate      date comment '协议到期时间。',
   primary key (fileCode, custID, compID)
);

alter table Agreement comment '合同协议。';

/*==============================================================*/
/* Table: Company                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Company
(
   compID               int not null comment 'compID。',
   fcompID              int comment '父节点。',
   compCode             varchar(50) comment '公司编码。',
   compName             varchar(50) comment '公司名称。',
   compLegalPerson      varchar(50) comment '法人。',
   seq                  int comment 'seq。',
   primary key (compID)
);

alter table Company comment '公司部门。';

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Customer
(
   custID               int not null comment 'custID。',
   fCustID              int comment 'fCustID。',
   custCode             varchar(50) comment '客户编码。',
   custName             varchar(50) comment '客户名称。',
   custLegalPerson      varchar(50) comment '法人。',
   address              varchar(50) comment '地址。',
   phone                varchar(50) comment '电话。',
   serviceFeeID         int comment '默认服务费ID。',
   serviceFeeDelay      int comment '服务费生效延迟天数。',
   primary key (custID)
);

alter table Customer comment '客户。';

/*==============================================================*/
/* Table: CustomerContactPerson                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS CustomerContactPerson
(
   contactID            int not null comment 'contactID。',
   custID               int comment 'custID。',
   contactCode          varchar(50) comment '联系人编码。',
   contactName          varchar(50) comment '联系人姓名。',
   contactSex           varchar(10) comment '性别。',
   phone                varchar(50) comment '电话。',
   email                varchar(50) comment '电子邮件。',
   address              varchar(50) comment '地址。',
   dept                 varchar(50) comment '部门。',
   pos                  varchar(50) comment '职位。',
   primary key (contactID)
);

alter table CustomerContactPerson comment '客户联系人。';

/*==============================================================*/
/* Table: Dict                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Dict
(
   dictID               int not null comment 'dictID。',
   fDictID              int comment 'fDictID。',
   dictCode             varchar(50) comment 'dictCode。',
   dictName             varchar(50) comment 'dictName。',
   seq                  int comment 'seq。',
   primary key (dictID)
);

alter table Dict comment '数据字典。';

/*==============================================================*/
/* Table: File                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS File
(
   fileID               int not null comment 'fileID。',
   fileCode             varchar(50) comment '档案编号。',
   fileName             varchar(50) comment '档案名称。',
   fileType             varchar(50) comment '档案类型。',
   fileDate             varchar(50) comment '编写时间。',
   fileUserID           int comment '编写人。',
   fileOutDate          date comment '有效时间。',
   fileManagerID        int comment '档案管理员。',
   fileExamineID        int comment '审核员。',
   state                int comment '状态。',
   electronicFile       varchar(200) comment '电子档。',
   scanningElement      varchar(200) comment '扫描件。',
   fileLocation         varchar(50) comment '档案位置。',
   primary key (fileID)
);

alter table File comment '档案。';

/*==============================================================*/
/* Table: Menu                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Menu
(
   menuID               int not null AUTO_INCREMENT comment 'menuID。',
   fMenuID              int comment 'fMenuID。',
   menuName             varchar(50) comment 'menuName。',
   winClass             varchar(200) comment '类名。',
   isShow               int comment 'isShow。',
   seq                  int comment 'seq。',
   primary key (menuID)
);

alter table Menu comment '菜单模块表。';

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Role
(
   roleID               int not null AUTO_INCREMENT comment 'roleID。',
   roleName             varchar(50) comment 'roleName。',
   primary key (roleID)
);

alter table Role comment '角色。';

/*==============================================================*/
/* Table: RoleMenuMap                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS RoleMenuMap
(
   menuID               int not null comment 'menuID。',
   roleID               int not null comment 'roleID。',
   roleMenuID           int not null AUTO_INCREMENT comment 'roleMenuID。',
   primary key (roleMenuID)
);

alter table RoleMenuMap comment '角色-菜单。';

/*==============================================================*/
/* Table: RoleUserMap                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS RoleUserMap
(
   roleID               int not null comment 'roleID。',
   userID               int not null comment 'userID。',
   roleUserID           int not null AUTO_INCREMENT comment 'roleUserID。',
   primary key (roleUserID)
);

alter table RoleUserMap comment '角色-用户。';

/*==============================================================*/
/* Table: ServiceFee                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS ServiceFee
(
   serviceFeeID         int not null comment '服务费ID。',
   serviceFeeCode       varchar(50) comment '服务费编码。',
   serviceFeeName       varchar(50) comment '服务费名称。',
   serviceFeeMethod     varchar(50) comment 'java方法名。',
   primary key (serviceFeeID)
);

alter table ServiceFee comment '服务费。';

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Staff
(
   staffID              int not null comment 'staffID。',
   staffCode            varchar(50) comment '员工编号。',
   staffName            varchar(50) comment '员工姓名。',
   staffSex             varchar(10) comment '性别。',
   identityCard         varchar(50) comment '身份证。',
   address              varchar(50) comment '住址。',
   phone                varchar(50) comment '电话。',
   homeAddress          varchar(50) comment '户口所在地。',
   homePhone            varchar(50) comment '家庭电话。',
   state                varchar(50) comment '状态。',
   wageNumber           varchar(50) comment '工资卡号。',
   wageBank             varchar(50) comment '开户行。',
   primary key (staffID)
);

alter table Staff comment '员工。';

/*==============================================================*/
/* Table: StaffState                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS StaffState
(
   staffID              int not null comment 'staffID。',
   userID               int not null comment 'userID。',
   custID               int not null comment 'custID。',
   entryDate            date not null comment '入职时间。',
   entryFileID          int comment '入职档案ID。',
   agreeSignedDate      date comment '合同签订时间。',
   agreeExpireDate      date comment '合同到期时间。',
   agreeRenewDate       date comment '合同续签时间。',
   toPostDate           date comment '到岗时间。',
   livePostDate         date comment '离岗时间。',
   quitApplayDate       date comment '离职申请时间。',
   quitDate             date comment '离职时间。',
   quitFileID           int comment '离职档案ID。',
   quitUserID           int comment '离职办理员ID。',
   probation            date comment '试用期。',
   jobCode              varchar(50) comment '工号。',
   post                 varchar(50) comment '岗位。',
   joinInsuranceDate    date comment '参保时间。',
   disInsuranceDate     date comment '停保时间。',
   insuranceID          int comment '社保ID。',
   insurancelInDate     date comment '社保生效时间。',
   insurancelOutDate    date comment '社保过期时间。',
   serviceFeeID         int comment '服务费ID。',
   serviceFeeDelay      int comment '服务费生效延迟天数。',
   primary key (staffID, userID, custID, entryDate)
);

alter table StaffState comment '员工入离职办理。';

/*==============================================================*/
/* Table: UserInfo                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS UserInfo
(
   userID               int not null comment 'userID。',
   userCode             varchar(50) comment '编码。',
   userName             varchar(50) comment '姓名。',
   userSex              varchar(10) comment '性别。',
   loginName            varchar(50) comment '登陆名。',
   password             varchar(50) comment '密码。',
   identityCard         varchar(50) comment '身份证。',
   address              varchar(200) comment '地址。',
   phone                varchar(50) comment '电话。',
   shortPhone           varchar(50) comment '电话短号。',
   compID               int comment '所属公司。',
   deptID               int comment '所属部门。',
   posID                int comment '职位。',
   customersID          varchar(200) comment '管理的客户。格式如：,001,002,',
   compsID              varchar(200) comment '管理的公司。格式如：,001,002,',
   seq                  int comment 'seq。',
   primary key (userID)
);

alter table UserInfo comment '用户。';

alter table Agreement add constraint FK_CompCustomerMapping foreign key (compID)
      references Company (compID) on delete restrict on update restrict;

alter table Agreement add constraint FK_CustomerCompMapping foreign key (custID)
      references Customer (custID) on delete restrict on update restrict;

alter table Agreement add constraint FK_FileAgreementMapping foreign key (fileID)
      references File (fileID) on delete restrict on update restrict;

alter table Agreement add constraint FK_UserAgreementMapping foreign key (userID)
      references UserInfo (userID) on delete restrict on update restrict;

alter table Customer add constraint FK_ServiceCustomerMapping foreign key (serviceFeeID)
      references ServiceFee (serviceFeeID) on delete restrict on update restrict;

alter table CustomerContactPerson add constraint FK_CustomerContactPersonMapping foreign key (custID)
      references Customer (custID) on delete restrict on update restrict;

alter table RoleMenuMap add constraint FK_MenuRoleMapping foreign key (menuID)
      references Menu (menuID) on delete restrict on update restrict;

alter table RoleMenuMap add constraint FK_RoleMenuMapping foreign key (roleID)
      references Role (roleID) on delete restrict on update restrict;

alter table RoleUserMap add constraint FK_RoleUserMapping foreign key (roleID)
      references Role (roleID) on delete restrict on update restrict;

alter table RoleUserMap add constraint FK_UserRoleMapping foreign key (userID)
      references UserInfo (userID) on delete restrict on update restrict;

alter table StaffState add constraint FK_CustomerStaffMapping foreign key (custID)
      references Customer (custID) on delete restrict on update restrict;

alter table StaffState add constraint FK_EntryFileMapping foreign key (entryFileID)
      references File (fileID) on delete restrict on update restrict;

alter table StaffState add constraint FK_QuitFileMapping foreign key (quitFileID)
      references File (fileID) on delete restrict on update restrict;

alter table StaffState add constraint FK_ServiceUserMapping foreign key (serviceFeeID)
      references ServiceFee (serviceFeeID) on delete restrict on update restrict;

alter table StaffState add constraint FK_StaffUserMapping foreign key (staffID)
      references Staff (staffID) on delete restrict on update restrict;

alter table StaffState add constraint FK_UserStaffMapping foreign key (userID)
      references UserInfo (userID) on delete restrict on update restrict;

CREATE TABLE IF NOT EXISTS `Insurance` (
  `insuranceID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `insuranceName` varchar(200)  NOT NULL COMMENT '社保名称',
  `treeNodeID` int(11) NOT NULL COMMENT '所属树节点ID',
  PRIMARY KEY (`insuranceID`)
);

CREATE TABLE IF NOT EXISTS `InsuranceDetail` (
  `insuranceDetailName` varchar(200)  NOT NULL COMMENT '保险名称',
  `base` float NOT NULL COMMENT '缴纳基数',
  `companyRate` float NOT NULL COMMENT '公司缴纳比例',
  `personalRate` float NOT NULL COMMENT '个人缴纳比例',
  `insuranceDetailID` int(11) NOT NULL AUTO_INCREMENT COMMENT '保险主键',
  `insuranceID` int(11) NOT NULL COMMENT '社保ID',
  PRIMARY KEY (`insuranceDetailID`)
);

CREATE TABLE IF NOT EXISTS `InsuranceHistory` (
  `insuranceDetailName` varchar(200)  NOT NULL COMMENT '保险名称',
  `base` float NOT NULL COMMENT '缴纳基数',
  `companyRate` float NOT NULL COMMENT '公司缴纳比例',
  `personalRate` float NOT NULL COMMENT '个人缴纳比例',
  `payDate` date NOT NULL COMMENT '社保缴纳日期',
  `destDate` date NOT NULL COMMENT '社保的目标',
  `insuranceHistoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '社保历史记录主键',
  `staffManageID` int(11) NOT NULL COMMENT '员工ID',
  PRIMARY KEY (`insuranceHistoryID`)
);

CREATE TABLE IF NOT EXISTS `TreeNode` (
  `treeNodeName` varchar(200)  NOT NULL COMMENT '节点名称',
  `itemTableName` varchar(200)  NOT NULL COMMENT '包含的元素表名',
  `treeNodeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '节点主键',
  `parentID` int(11) COMMENT '父节点ID',
  PRIMARY KEY (`treeNodeID`)
);

alter table dict change dictid dictid int(11) not null AUTO_INCREMENT;
alter table company change compid compid int(11) not null AUTO_INCREMENT;
alter table customer change custid custid int(11) not null AUTO_INCREMENT;
alter table file change fileid fileid int(11) not null AUTO_INCREMENT;
alter table menu change menuid menuid int(11) not null AUTO_INCREMENT;
alter table serviceFee change serviceFeeID serviceFeeID int(11) not null AUTO_INCREMENT;
alter table serviceFee change serviceFeeID serviceFeeID int(11) not null AUTO_INCREMENT;
alter table staff change staffid staffid int(11) not null AUTO_INCREMENT;
alter table userinfo change userid userid int(11) not null AUTO_INCREMENT;
alter table CustomerContactPerson change contactID contactID int(11) not null AUTO_INCREMENT;

create table IF NOT EXISTS PersonCost
(
   personCostId         int not null auto_increment comment 'personCostId。',
   staffID              int comment 'staffID。',
   userID               int comment 'userID。',
   custID               int comment 'custID。',
   entryDate            date comment '入职时间。',
   staffStateId         int comment '入离职信息ID。',
   payStart             date comment '付费开始时间。',
   payEnd               date comment '付费结束时间。',
   pay                  double comment '费用。',
   primary key (personCostId)
);

alter table PersonCost comment '招聘费用';

INSERT INTO `menu` (`menuID`, `fMenuID`, `menuName`, `winClass`, `isShow`, `seq`) VALUES
(1, 0, '日常管理', 'com.hros.cloth.vaadin.ClothForm', NULL, 0),
(2, 1, '货物整理', 'com.hros.cloth.vaadin.ClothForm', NULL, 0),
(3, 1, '客户管理', 'com.hros.cloth.vaadin.CustomerForm', NULL, 0),
(4, 1, '出货', 'com.hros.cloth.vaadin.OrderForm', NULL, 0),
(7, 0, '系统管理', 'com.hros.user.vaadin.RoleForm', NULL, 0),
(8, 7, '角色', 'com.hros.user.vaadin.RoleForm', NULL, 0),
(15, 1, '统计', 'com.hros.cloth.vaadin.StaticsForm', NULL, 0),
(16, 7, '角色用户', 'com.hros.user.vaadin.RoleUserForm', NULL, 0),
(17, 7, '用户角色', 'com.hros.user.vaadin.UserRoleForm', NULL, 0),
(19, 1, '换货', 'com.hros.cloth.vaadin.CancelOrderForm', NULL, 0),
(20, 7, '用户', 'com.hros.user.vaadin.UserForm', NULL, 0);

INSERT INTO `cloth` (`clothID`, `name`, `size`, `color`, `barCode`, `count`, `salesOffType`, `salesOff`, `originalPrice`, `price`, `stockDate`) VALUES
(29, '羽绒服', 'M', -7012419, '11111', 10, 'SALES_OFF_TYPE_ORIGINAL', NULL, 50, 150, '2012-12-28');


INSERT INTO `customer2` (`customer2ID`, `name`, `phone`,`customerNumber`) VALUES
(1, '顾客甲', '123','001');

INSERT INTO `role` (`roleID`, `roleName`) VALUES
(2, '售货员'),
(3, '老板');

INSERT INTO `userinfo` (`userID`, `userCode`, `userName`, `userSex`, `loginName`, `password`, `identityCard`, `address`, `phone`, `shortPhone`, `compID`, `deptID`, `posID`, `customersID`, `compsID`, `seq`) VALUES
(26, NULL, '售货员甲', NULL, 'abc', '123456', NULL, NULL, '138000034', NULL, 0, 0, 0, '', '', 0),
(27, '111', '熊琼', NULL, 'admin', '123456', '1234567890123456', '', '13909050217', '12345', 5, 0, 0, '', '', 0);