/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2012/11/7 14:49:33                           */
/*==============================================================*/

CREATE DATABASE `cloth` DEFAULT CHARACTER SET gb2312 COLLATE gb2312_chinese_ci;
USE `cloth`;

CREATE TABLE IF NOT EXISTS ReturnRecord
(
   returnRecordID        int not null AUTO_INCREMENT comment '������',
   clothID               int not null comment '�˻���װ',
   returnDate      	date comment '�˻�����',
   reason          varchar(300)  comment '�˻�ԭ��',
   count     int  comment '�˻�����',
   primary key (returnRecordID)
);

CREATE TABLE IF NOT EXISTS OrderHistory
(
   orderHistoryID        int not null AUTO_INCREMENT comment 'orderHistoryID��',
   clothID               int not null comment '������·�',
   customerID            int  comment '������',
   consumption 			float NOT NULL COMMENT '���ѽ��',
   consumeDate      	date comment '��������',
   orderNumber          varchar(50)  comment '������',
   state             	varchar(50)  comment '����״̬',
   exchangedOrderID     int  comment '�������Ķ���ID',
   primary key (orderHistoryID)
);


CREATE TABLE IF NOT EXISTS Cloth
(
   clothID               int not null AUTO_INCREMENT comment 'clothID��',
   name             varchar(50)  comment '����',
   size             varchar(50)  comment '�ߴ�',
   color               int  comment '��ɫ',
   barCode             varchar(50)  comment '����',
   count               int  comment '����',
   salesOffType             varchar(50) comment '��������',
   salesOff 		float  COMMENT '���۱�������',
   originalPrice 	float  COMMENT '�ɱ���',
   price 			float COMMENT '�۸�',
   stockDate 	    date comment '��������',
   primary key (clothID)
);


CREATE TABLE IF NOT EXISTS Customer2
(
   customer2ID               int not null AUTO_INCREMENT comment 'customer2ID��',
   name             varchar(50) not null comment '����',
   phone             varchar(50)  comment '�绰����',
   customerNumber             varchar(50)  comment '�ͻ����',
   primary key (customer2ID)
);


/*==============================================================*/
/* Table: Agreement                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Agreement
(
   custID               int not null comment 'custID��',
   compID               int not null comment 'compID��',
   fileCode             varchar(50) not null comment 'Э���š�',
   fileID               int comment '����ID��',
   userID               int comment 'userID��',
   agreeSignedDate      date comment 'ǩ��Э��ʱ�䡣',
   agreeExpireDate      date comment 'Э�鵽��ʱ�䡣',
   primary key (fileCode, custID, compID)
);

alter table Agreement comment '��ͬЭ�顣';

/*==============================================================*/
/* Table: Company                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Company
(
   compID               int not null comment 'compID��',
   fcompID              int comment '���ڵ㡣',
   compCode             varchar(50) comment '��˾���롣',
   compName             varchar(50) comment '��˾���ơ�',
   compLegalPerson      varchar(50) comment '���ˡ�',
   seq                  int comment 'seq��',
   primary key (compID)
);

alter table Company comment '��˾���š�';

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Customer
(
   custID               int not null comment 'custID��',
   fCustID              int comment 'fCustID��',
   custCode             varchar(50) comment '�ͻ����롣',
   custName             varchar(50) comment '�ͻ����ơ�',
   custLegalPerson      varchar(50) comment '���ˡ�',
   address              varchar(50) comment '��ַ��',
   phone                varchar(50) comment '�绰��',
   serviceFeeID         int comment 'Ĭ�Ϸ����ID��',
   serviceFeeDelay      int comment '�������Ч�ӳ�������',
   primary key (custID)
);

alter table Customer comment '�ͻ���';

/*==============================================================*/
/* Table: CustomerContactPerson                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS CustomerContactPerson
(
   contactID            int not null comment 'contactID��',
   custID               int comment 'custID��',
   contactCode          varchar(50) comment '��ϵ�˱��롣',
   contactName          varchar(50) comment '��ϵ��������',
   contactSex           varchar(10) comment '�Ա�',
   phone                varchar(50) comment '�绰��',
   email                varchar(50) comment '�����ʼ���',
   address              varchar(50) comment '��ַ��',
   dept                 varchar(50) comment '���š�',
   pos                  varchar(50) comment 'ְλ��',
   primary key (contactID)
);

alter table CustomerContactPerson comment '�ͻ���ϵ�ˡ�';

/*==============================================================*/
/* Table: Dict                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Dict
(
   dictID               int not null comment 'dictID��',
   fDictID              int comment 'fDictID��',
   dictCode             varchar(50) comment 'dictCode��',
   dictName             varchar(50) comment 'dictName��',
   seq                  int comment 'seq��',
   primary key (dictID)
);

alter table Dict comment '�����ֵ䡣';

/*==============================================================*/
/* Table: File                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS File
(
   fileID               int not null comment 'fileID��',
   fileCode             varchar(50) comment '������š�',
   fileName             varchar(50) comment '�������ơ�',
   fileType             varchar(50) comment '�������͡�',
   fileDate             varchar(50) comment '��дʱ�䡣',
   fileUserID           int comment '��д�ˡ�',
   fileOutDate          date comment '��Чʱ�䡣',
   fileManagerID        int comment '��������Ա��',
   fileExamineID        int comment '���Ա��',
   state                int comment '״̬��',
   electronicFile       varchar(200) comment '���ӵ���',
   scanningElement      varchar(200) comment 'ɨ�����',
   fileLocation         varchar(50) comment '����λ�á�',
   primary key (fileID)
);

alter table File comment '������';

/*==============================================================*/
/* Table: Menu                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Menu
(
   menuID               int not null AUTO_INCREMENT comment 'menuID��',
   fMenuID              int comment 'fMenuID��',
   menuName             varchar(50) comment 'menuName��',
   winClass             varchar(200) comment '������',
   isShow               int comment 'isShow��',
   seq                  int comment 'seq��',
   primary key (menuID)
);

alter table Menu comment '�˵�ģ���';

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Role
(
   roleID               int not null AUTO_INCREMENT comment 'roleID��',
   roleName             varchar(50) comment 'roleName��',
   primary key (roleID)
);

alter table Role comment '��ɫ��';

/*==============================================================*/
/* Table: RoleMenuMap                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS RoleMenuMap
(
   menuID               int not null comment 'menuID��',
   roleID               int not null comment 'roleID��',
   roleMenuID           int not null AUTO_INCREMENT comment 'roleMenuID��',
   primary key (roleMenuID)
);

alter table RoleMenuMap comment '��ɫ-�˵���';

/*==============================================================*/
/* Table: RoleUserMap                                           */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS RoleUserMap
(
   roleID               int not null comment 'roleID��',
   userID               int not null comment 'userID��',
   roleUserID           int not null AUTO_INCREMENT comment 'roleUserID��',
   primary key (roleUserID)
);

alter table RoleUserMap comment '��ɫ-�û���';

/*==============================================================*/
/* Table: ServiceFee                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS ServiceFee
(
   serviceFeeID         int not null comment '�����ID��',
   serviceFeeCode       varchar(50) comment '����ѱ��롣',
   serviceFeeName       varchar(50) comment '��������ơ�',
   serviceFeeMethod     varchar(50) comment 'java��������',
   primary key (serviceFeeID)
);

alter table ServiceFee comment '����ѡ�';

/*==============================================================*/
/* Table: Staff                                                 */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS Staff
(
   staffID              int not null comment 'staffID��',
   staffCode            varchar(50) comment 'Ա����š�',
   staffName            varchar(50) comment 'Ա��������',
   staffSex             varchar(10) comment '�Ա�',
   identityCard         varchar(50) comment '���֤��',
   address              varchar(50) comment 'סַ��',
   phone                varchar(50) comment '�绰��',
   homeAddress          varchar(50) comment '�������ڵء�',
   homePhone            varchar(50) comment '��ͥ�绰��',
   state                varchar(50) comment '״̬��',
   wageNumber           varchar(50) comment '���ʿ��š�',
   wageBank             varchar(50) comment '�����С�',
   primary key (staffID)
);

alter table Staff comment 'Ա����';

/*==============================================================*/
/* Table: StaffState                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS StaffState
(
   staffID              int not null comment 'staffID��',
   userID               int not null comment 'userID��',
   custID               int not null comment 'custID��',
   entryDate            date not null comment '��ְʱ�䡣',
   entryFileID          int comment '��ְ����ID��',
   agreeSignedDate      date comment '��ͬǩ��ʱ�䡣',
   agreeExpireDate      date comment '��ͬ����ʱ�䡣',
   agreeRenewDate       date comment '��ͬ��ǩʱ�䡣',
   toPostDate           date comment '����ʱ�䡣',
   livePostDate         date comment '���ʱ�䡣',
   quitApplayDate       date comment '��ְ����ʱ�䡣',
   quitDate             date comment '��ְʱ�䡣',
   quitFileID           int comment '��ְ����ID��',
   quitUserID           int comment '��ְ����ԱID��',
   probation            date comment '�����ڡ�',
   jobCode              varchar(50) comment '���š�',
   post                 varchar(50) comment '��λ��',
   joinInsuranceDate    date comment '�α�ʱ�䡣',
   disInsuranceDate     date comment 'ͣ��ʱ�䡣',
   insuranceID          int comment '�籣ID��',
   insurancelInDate     date comment '�籣��Чʱ�䡣',
   insurancelOutDate    date comment '�籣����ʱ�䡣',
   serviceFeeID         int comment '�����ID��',
   serviceFeeDelay      int comment '�������Ч�ӳ�������',
   primary key (staffID, userID, custID, entryDate)
);

alter table StaffState comment 'Ա������ְ����';

/*==============================================================*/
/* Table: UserInfo                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS UserInfo
(
   userID               int not null comment 'userID��',
   userCode             varchar(50) comment '���롣',
   userName             varchar(50) comment '������',
   userSex              varchar(10) comment '�Ա�',
   loginName            varchar(50) comment '��½����',
   password             varchar(50) comment '���롣',
   identityCard         varchar(50) comment '���֤��',
   address              varchar(200) comment '��ַ��',
   phone                varchar(50) comment '�绰��',
   shortPhone           varchar(50) comment '�绰�̺š�',
   compID               int comment '������˾��',
   deptID               int comment '�������š�',
   posID                int comment 'ְλ��',
   customersID          varchar(200) comment '����Ŀͻ�����ʽ�磺,001,002,',
   compsID              varchar(200) comment '����Ĺ�˾����ʽ�磺,001,002,',
   seq                  int comment 'seq��',
   primary key (userID)
);

alter table UserInfo comment '�û���';

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
  `insuranceID` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `insuranceName` varchar(200)  NOT NULL COMMENT '�籣����',
  `treeNodeID` int(11) NOT NULL COMMENT '�������ڵ�ID',
  PRIMARY KEY (`insuranceID`)
);

CREATE TABLE IF NOT EXISTS `InsuranceDetail` (
  `insuranceDetailName` varchar(200)  NOT NULL COMMENT '��������',
  `base` float NOT NULL COMMENT '���ɻ���',
  `companyRate` float NOT NULL COMMENT '��˾���ɱ���',
  `personalRate` float NOT NULL COMMENT '���˽��ɱ���',
  `insuranceDetailID` int(11) NOT NULL AUTO_INCREMENT COMMENT '��������',
  `insuranceID` int(11) NOT NULL COMMENT '�籣ID',
  PRIMARY KEY (`insuranceDetailID`)
);

CREATE TABLE IF NOT EXISTS `InsuranceHistory` (
  `insuranceDetailName` varchar(200)  NOT NULL COMMENT '��������',
  `base` float NOT NULL COMMENT '���ɻ���',
  `companyRate` float NOT NULL COMMENT '��˾���ɱ���',
  `personalRate` float NOT NULL COMMENT '���˽��ɱ���',
  `payDate` date NOT NULL COMMENT '�籣��������',
  `destDate` date NOT NULL COMMENT '�籣��Ŀ��',
  `insuranceHistoryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '�籣��ʷ��¼����',
  `staffManageID` int(11) NOT NULL COMMENT 'Ա��ID',
  PRIMARY KEY (`insuranceHistoryID`)
);

CREATE TABLE IF NOT EXISTS `TreeNode` (
  `treeNodeName` varchar(200)  NOT NULL COMMENT '�ڵ�����',
  `itemTableName` varchar(200)  NOT NULL COMMENT '������Ԫ�ر���',
  `treeNodeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '�ڵ�����',
  `parentID` int(11) COMMENT '���ڵ�ID',
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
   personCostId         int not null auto_increment comment 'personCostId��',
   staffID              int comment 'staffID��',
   userID               int comment 'userID��',
   custID               int comment 'custID��',
   entryDate            date comment '��ְʱ�䡣',
   staffStateId         int comment '����ְ��ϢID��',
   payStart             date comment '���ѿ�ʼʱ�䡣',
   payEnd               date comment '���ѽ���ʱ�䡣',
   pay                  double comment '���á�',
   primary key (personCostId)
);

alter table PersonCost comment '��Ƹ����';

INSERT INTO `menu` (`menuID`, `fMenuID`, `menuName`, `winClass`, `isShow`, `seq`) VALUES
(1, 0, '�ճ�����', 'com.hros.cloth.vaadin.ClothForm', NULL, 0),
(2, 1, '��������', 'com.hros.cloth.vaadin.ClothForm', NULL, 0),
(3, 1, '�ͻ�����', 'com.hros.cloth.vaadin.CustomerForm', NULL, 0),
(4, 1, '����', 'com.hros.cloth.vaadin.OrderForm', NULL, 0),
(7, 0, 'ϵͳ����', 'com.hros.user.vaadin.RoleForm', NULL, 0),
(8, 7, '��ɫ', 'com.hros.user.vaadin.RoleForm', NULL, 0),
(15, 1, 'ͳ��', 'com.hros.cloth.vaadin.StaticsForm', NULL, 0),
(16, 7, '��ɫ�û�', 'com.hros.user.vaadin.RoleUserForm', NULL, 0),
(17, 7, '�û���ɫ', 'com.hros.user.vaadin.UserRoleForm', NULL, 0),
(19, 1, '����', 'com.hros.cloth.vaadin.CancelOrderForm', NULL, 0),
(20, 7, '�û�', 'com.hros.user.vaadin.UserForm', NULL, 0);

INSERT INTO `cloth` (`clothID`, `name`, `size`, `color`, `barCode`, `count`, `salesOffType`, `salesOff`, `originalPrice`, `price`, `stockDate`) VALUES
(29, '���޷�', 'M', -7012419, '11111', 10, 'SALES_OFF_TYPE_ORIGINAL', NULL, 50, 150, '2012-12-28');


INSERT INTO `customer2` (`customer2ID`, `name`, `phone`,`customerNumber`) VALUES
(1, '�˿ͼ�', '123','001');

INSERT INTO `role` (`roleID`, `roleName`) VALUES
(2, '�ۻ�Ա'),
(3, '�ϰ�');

INSERT INTO `userinfo` (`userID`, `userCode`, `userName`, `userSex`, `loginName`, `password`, `identityCard`, `address`, `phone`, `shortPhone`, `compID`, `deptID`, `posID`, `customersID`, `compsID`, `seq`) VALUES
(26, NULL, '�ۻ�Ա��', NULL, 'abc', '123456', NULL, NULL, '138000034', NULL, 0, 0, 0, '', '', 0),
(27, '111', '����', NULL, 'admin', '123456', '1234567890123456', '', '13909050217', '12345', 5, 0, 0, '', '', 0);