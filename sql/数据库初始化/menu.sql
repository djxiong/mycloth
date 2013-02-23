INSERT INTO `menu` (`menuid`, `fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1, 0, '系统管理', NULL, NULL, NULL, NULL),
(2, 1, '基本信息', NULL, NULL, NULL, NULL),
(3, 1, '菜单管理', 'com.hros.bas.vaadin.MenuForm', NULL, NULL, NULL),
(6, 1, '公司部门管理', 'com.hros.bas.vaadin.BaseObjectForm', NULL, NULL, 'companyServiceImpl'),
(7, 1, '数据字典', 'com.hros.bas.vaadin.BaseObjectForm', NULL, 2, 'dictServiceImpl'),
(8, 1, '客户关系管理', 'com.hros.customer.vaadin.CustomerForm', NULL, 3, NULL);

/****社保管理****/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1, '社保管理', 'com.hros.insurance.vaadin.InsuranceForm', NULL, 3, NULL);


/********入离职********/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1,'入职管理','com.hros.staffstate.vaadin.Entry',NULL,NULL,NULL),
(1,'离职管理','com.hros.staffstate.vaadin.Quit',NULL,NULL,NULL);
/********员工管理********/
INSERT INTO `menu` (`fMenuID`, `menuName`, `winClass`, `isShow`, `seq`, `servicename`) VALUES
(1,'员工管理','com.hros.staffmanage.vaadin.StaffWindow',NULL,NULL,NULL);


