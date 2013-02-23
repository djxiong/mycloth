INSERT INTO `insurance` (`insuranceID`, `insuranceName`, `treeNodeID`) VALUES
(8, '基本城镇五险', 7);

INSERT INTO `insurancedetail` (`insuranceDetailName`, `base`, `companyRate`, `personalRate`, `insuranceDetailID`, `insuranceID`) VALUES
('退休门诊', 1786.5, 13, 0, 1, 8),
('医疗门诊', 1786.5, 12, 0, 2, 8),
('工伤', 1786.5, 5, 0, 3, 8);