INSERT INTO `menu` (`menuid`, `fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1, 0, 'ϵͳ����', NULL, NULL, NULL, NULL),
(2, 1, '������Ϣ', NULL, NULL, NULL, NULL),
(3, 1, '�˵�����', 'com.hros.bas.vaadin.MenuForm', NULL, NULL, NULL),
(6, 1, '��˾���Ź���', 'com.hros.bas.vaadin.BaseObjectForm', NULL, NULL, 'companyServiceImpl'),
(7, 1, '�����ֵ�', 'com.hros.bas.vaadin.BaseObjectForm', NULL, 2, 'dictServiceImpl'),
(8, 1, '�ͻ���ϵ����', 'com.hros.customer.vaadin.CustomerForm', NULL, 3, NULL);

/****�籣����****/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1, '�籣����', 'com.hros.insurance.vaadin.InsuranceForm', NULL, 3, NULL);


/********����ְ********/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1,'��ְ����','com.hros.staffstate.vaadin.Entry',NULL,NULL,NULL),
(1,'��ְ����','com.hros.staffstate.vaadin.Quit',NULL,NULL,NULL);
/********Ա������********/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1,'Ա������','com.hros.staffmanage.vaadin.StaffWindow',NULL,NULL,NULL);


