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
