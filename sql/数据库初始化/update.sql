/*******菜单*********/
ALTER TABLE menu ADD servicename VARCHAR(50);

/******客户********/
ALTER TABLE customer ADD industry VARCHAR(50) COMMENT '行业';
ALTER TABLE customer ADD custClass VARCHAR(50) COMMENT '客户等级';
ALTER TABLE customer ADD custAttr VARCHAR(50) COMMENT '公司属性';
ALTER TABLE customer ADD remark VARCHAR(2000) COMMENT '备注';
ALTER TABLE customer ADD custCity VARCHAR(50) COMMENT '所在地区';
ALTER TABLE customer ADD custType VARCHAR(50) COMMENT '客户类型';

/********客户联系人********/
ALTER TABLE CustomerContactPerson ADD mobilePhone VARCHAR(50) COMMENT '手机';

/*******员工信息表********/
ALTER TABLE staff MODIFY COLUMN state VARCHAR(50);

/**********服务费表***************/
ALTER TABLE servicefee ADD serviceFeeFId INT DEFAULT 0 AFTER serviceFeeID;
ALTER TABLE ServiceFee ADD dayFeeType VARCHAR(50) COMMENT '天结算方式';
ALTER TABLE ServiceFee ADD dayFee VARCHAR(50) COMMENT '天计算比例';
ALTER TABLE ServiceFee ADD monthFeeType VARCHAR(50) COMMENT '月结算方式';
ALTER TABLE ServiceFee ADD monthFee VARCHAR(50) COMMENT '月费用结算';
ALTER TABLE ServiceFee ADD delayDay int COMMENT '延迟时间';

