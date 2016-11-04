-- 初始化数据
insert into sys_user(`user_name`,`display_name`,`sex`,`password`,`mobile_phone`,`email`,`register_time`)  
values ('admin','超级管理员',1,'e10adc3949ba59abbe56e057f20f883e','13510086407','lieeking@qq.com',now());

-- 默认的前台模版
INSERT INTO `billard_t`.`systemconfig` (`id`, `keyword`, `valuestr`) VALUES ('1', 'template_name', 'easyui');
