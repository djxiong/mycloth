/*******�˵�*********/
ALTER TABLE menu ADD servicename VARCHAR(50);

/******�ͻ�********/
ALTER TABLE customer ADD industry VARCHAR(50) COMMENT '��ҵ';
ALTER TABLE customer ADD custClass VARCHAR(50) COMMENT '�ͻ��ȼ�';
ALTER TABLE customer ADD custAttr VARCHAR(50) COMMENT '��˾����';
ALTER TABLE customer ADD remark VARCHAR(2000) COMMENT '��ע';
ALTER TABLE customer ADD custCity VARCHAR(50) COMMENT '���ڵ���';
ALTER TABLE customer ADD custType VARCHAR(50) COMMENT '�ͻ�����';

/********�ͻ���ϵ��********/
ALTER TABLE CustomerContactPerson ADD mobilePhone VARCHAR(50) COMMENT '�ֻ�';

/*******Ա����Ϣ��********/
ALTER TABLE staff MODIFY COLUMN state VARCHAR(50);

/**********����ѱ�***************/
ALTER TABLE servicefee ADD serviceFeeFId INT DEFAULT 0 AFTER serviceFeeID;
ALTER TABLE ServiceFee ADD dayFeeType VARCHAR(50) COMMENT '����㷽ʽ';
ALTER TABLE ServiceFee ADD dayFee VARCHAR(50) COMMENT '��������';
ALTER TABLE ServiceFee ADD monthFeeType VARCHAR(50) COMMENT '�½��㷽ʽ';
ALTER TABLE ServiceFee ADD monthFee VARCHAR(50) COMMENT '�·��ý���';
ALTER TABLE ServiceFee ADD delayDay int COMMENT '�ӳ�ʱ��';

