-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`
(
    `table_id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_name`        varchar(200)  DEFAULT '' COMMENT '表名称',
    `table_comment`     varchar(500)  DEFAULT '' COMMENT '表描述',
    `sub_table_name`    varchar(64)   DEFAULT NULL COMMENT '关联子表的表名',
    `sub_table_fk_name` varchar(64)   DEFAULT NULL COMMENT '子表关联的外键名',
    `class_name`        varchar(100)  DEFAULT '' COMMENT '实体类名称',
    `tpl_category`      varchar(200)  DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作 sub主子表操作）',
    `package_name`      varchar(100)  DEFAULT NULL COMMENT '生成包路径',
    `module_name`       varchar(30)   DEFAULT NULL COMMENT '生成模块名',
    `business_name`     varchar(30)   DEFAULT NULL COMMENT '生成业务名',
    `function_name`     varchar(50)   DEFAULT NULL COMMENT '生成功能名',
    `function_author`   varchar(50)   DEFAULT NULL COMMENT '生成功能作者',
    `form_col_num`      int(1) DEFAULT '1' COMMENT '表单布局（单列 双列 三列）',
    `gen_type`          char(1)       DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
    `gen_path`          varchar(200)  DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
    `options`           varchar(1000) DEFAULT NULL COMMENT '其它生成选项',
    `create_by`         varchar(64)   DEFAULT '' COMMENT '创建者',
    `create_time`       datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`         varchar(64)   DEFAULT '' COMMENT '更新者',
    `update_time`       datetime      DEFAULT NULL COMMENT '更新时间',
    `remark`            varchar(500)  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表';

-- ----------------------------
-- Records of gen_table
-- ----------------------------

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`
(
    `column_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `table_id`       bigint(20) DEFAULT NULL COMMENT '归属表编号',
    `column_name`    varchar(200) DEFAULT NULL COMMENT '列名称',
    `column_comment` varchar(500) DEFAULT NULL COMMENT '列描述',
    `column_type`    varchar(100) DEFAULT NULL COMMENT '列类型',
    `java_type`      varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
    `java_field`     varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
    `is_pk`          char(1)      DEFAULT NULL COMMENT '是否主键（1是）',
    `is_increment`   char(1)      DEFAULT NULL COMMENT '是否自增（1是）',
    `is_required`    char(1)      DEFAULT NULL COMMENT '是否必填（1是）',
    `is_insert`      char(1)      DEFAULT NULL COMMENT '是否为插入字段（1是）',
    `is_edit`        char(1)      DEFAULT NULL COMMENT '是否编辑字段（1是）',
    `is_list`        char(1)      DEFAULT NULL COMMENT '是否列表字段（1是）',
    `is_query`       char(1)      DEFAULT NULL COMMENT '是否查询字段（1是）',
    `query_type`     varchar(200) DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
    `html_type`      varchar(200) DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    `dict_type`      varchar(200) DEFAULT '' COMMENT '字典类型',
    `sort`           int(11) DEFAULT NULL COMMENT '排序',
    `create_by`      varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`    datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`column_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='代码生成业务表字段';


-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`
(
    `config_id`    int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
    `config_name`  varchar(100) DEFAULT '' COMMENT '参数名称',
    `config_key`   varchar(100) DEFAULT '' COMMENT '参数键名',
    `config_value` varchar(500) DEFAULT '' COMMENT '参数键值',
    `config_type`  char(1)      DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config`
VALUES ('1', '主框架页-默认皮肤样式名称', 'sys.index.skinName', ' skin-red', 'Y', 'admin', '2024-11-12 16:09:48', '',
        null, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config`
VALUES ('2', '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '初始化密码 123456');
INSERT INTO `sys_config`
VALUES ('3', '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-light', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
INSERT INTO `sys_config`
VALUES ('4', '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2024-11-12 16:09:48',
        '', null, '是否开启注册用户功能（true开启，false关闭）');
INSERT INTO `sys_config`
VALUES ('5', '用户管理-密码字符范围', 'sys.account.chrtype', '0', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）');
INSERT INTO `sys_config`
VALUES ('6', '用户管理-初始密码修改策略', 'sys.account.initPasswordModify', '1', 'Y', 'admin', '2024-11-12 16:09:48',
        '', null, '0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config`
VALUES ('7', '用户管理-账号密码更新周期', 'sys.account.passwordValidateDays', '0', 'Y', 'admin', '2024-11-12 16:09:48',
        '', null,
        '密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框');
INSERT INTO `sys_config`
VALUES ('8', '主框架页-菜单导航显示风格', 'sys.index.menuStyle', 'default', 'Y', 'admin', '2024-11-12 16:09:48', '',
        null, '菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）');
INSERT INTO `sys_config`
VALUES ('9', '主框架页-是否开启页脚', 'sys.index.footer', 'true', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '是否开启底部页脚显示（true显示，false隐藏）');
INSERT INTO `sys_config`
VALUES ('10', '主框架页-是否开启页签', 'sys.index.tagsView', 'true', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '是否开启菜单多页签显示（true显示，false隐藏）');
INSERT INTO `sys_config`
VALUES ('11', '用户登录-黑名单列表', 'sys.login.blackIPList', '', 'Y', 'admin', '2024-11-12 16:09:48', '', null,
        '设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`
(
    `dept_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
    `parent_id`   bigint(20) DEFAULT '0' COMMENT '父部门id',
    `ancestors`   varchar(50) DEFAULT '' COMMENT '祖级列表',
    `dept_name`   varchar(30) DEFAULT '' COMMENT '部门名称',
    `order_num`   int(4) DEFAULT '0' COMMENT '显示顺序',
    `leader`      varchar(20) DEFAULT NULL COMMENT '负责人',
    `phone`       varchar(11) DEFAULT NULL COMMENT '联系电话',
    `email`       varchar(50) DEFAULT NULL COMMENT '邮箱',
    `status`      char(1)     DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
    `del_flag`    char(1)     DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`   varchar(64) DEFAULT '' COMMENT '创建者',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64) DEFAULT '' COMMENT '更新者',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept`
VALUES ('100', '0', '0', '智慧党建', '0', '', '', '', '0', '0', '', '2024-11-12 16:09:48', '', null);
INSERT INTO `sys_dept`
VALUES ('101', '100', '0,100', '第一党小组', '1', '', '', '', '0', '0', 'admin', '2024-11-12 16:09:48', '', null);
INSERT INTO `sys_dept`
VALUES ('200', '100', '0,100', '第二党小组', '2', '', '', '', '0', '0', 'admin', '2024-11-12 16:09:48', '', null);
INSERT INTO `sys_dept`
VALUES ('201', '100', '0,100', '第三党小组', '3', '', '', '', '0', '0', 'admin', '2024-11-12 16:09:48', '', null);
INSERT INTO `sys_dept`
VALUES ('202', '100', '0,100', '第四党小组', '4', '', '', '', '0', '0', 'admin', '2024-11-12 16:09:48', '', null);
INSERT INTO `sys_dept`
VALUES ('203', '100', '0,100', '第五党小组', '5', '', '', '', '0', '0', 'admin', '2024-11-12 16:09:48', '', null);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`
(
    `dict_code`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
    `dict_sort`   int(4) DEFAULT '0' COMMENT '字典排序',
    `dict_label`  varchar(100) DEFAULT '' COMMENT '字典标签',
    `dict_value`  varchar(100) DEFAULT '' COMMENT '字典键值',
    `dict_type`   varchar(100) DEFAULT '' COMMENT '字典类型',
    `css_class`   varchar(100) DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
    `list_class`  varchar(100) DEFAULT NULL COMMENT '表格回显样式',
    `is_default`  char(1)      DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
    `status`      char(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data`
VALUES ('1', '1', '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null, '性别男');
INSERT INTO `sys_dict_data`
VALUES ('2', '2', '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null, '性别女');
INSERT INTO `sys_dict_data`
VALUES ('3', '3', '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null, '性别未知');
INSERT INTO `sys_dict_data`
VALUES ('4', '1', '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '显示菜单');
INSERT INTO `sys_dict_data`
VALUES ('5', '2', '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '隐藏菜单');
INSERT INTO `sys_dict_data`
VALUES ('6', '1', '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '正常状态');
INSERT INTO `sys_dict_data`
VALUES ('7', '2', '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '停用状态');
INSERT INTO `sys_dict_data`
VALUES ('8', '1', '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '正常状态');
INSERT INTO `sys_dict_data`
VALUES ('9', '2', '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '停用状态');
INSERT INTO `sys_dict_data`
VALUES ('10', '1', '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '默认分组');
INSERT INTO `sys_dict_data`
VALUES ('11', '2', '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '系统分组');
INSERT INTO `sys_dict_data`
VALUES ('12', '1', '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '系统默认是');
INSERT INTO `sys_dict_data`
VALUES ('13', '2', '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '系统默认否');
INSERT INTO `sys_dict_data`
VALUES ('14', '1', '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '通知');
INSERT INTO `sys_dict_data`
VALUES ('15', '2', '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '公告');
INSERT INTO `sys_dict_data`
VALUES ('16', '1', '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '正常状态');
INSERT INTO `sys_dict_data`
VALUES ('17', '2', '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '关闭状态');
INSERT INTO `sys_dict_data`
VALUES ('18', '99', '其他', '0', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '其他操作');
INSERT INTO `sys_dict_data`
VALUES ('19', '1', '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '新增操作');
INSERT INTO `sys_dict_data`
VALUES ('20', '2', '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '修改操作');
INSERT INTO `sys_dict_data`
VALUES ('21', '3', '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '删除操作');
INSERT INTO `sys_dict_data`
VALUES ('22', '4', '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '授权操作');
INSERT INTO `sys_dict_data`
VALUES ('23', '5', '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '导出操作');
INSERT INTO `sys_dict_data`
VALUES ('24', '6', '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '导入操作');
INSERT INTO `sys_dict_data`
VALUES ('25', '7', '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '强退操作');
INSERT INTO `sys_dict_data`
VALUES ('26', '8', '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '生成操作');
INSERT INTO `sys_dict_data`
VALUES ('27', '9', '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '清空操作');
INSERT INTO `sys_dict_data`
VALUES ('28', '1', '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '正常状态');
INSERT INTO `sys_dict_data`
VALUES ('29', '2', '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2024-11-12 16:09:48', '', null,
        '停用状态');
INSERT INTO `sys_dict_data`
VALUES ('100', '1', '待审核', '1', 'tb_news_status', '', 'info', 'Y', '0', 'admin', '2020-05-07 11:24:02', 'admin',
        '2020-05-07 15:02:26', '审核中');
INSERT INTO `sys_dict_data`
VALUES ('101', '2', '审核通过', '2', 'tb_news_status', '', 'danger', 'Y', '0', 'admin', '2020-05-07 11:24:44', 'admin',
        '2020-05-07 11:25:24', '审核通过');
INSERT INTO `sys_dict_data`
VALUES ('102', '3', '审核不通过', '3', 'tb_news_status', null, 'warning', 'Y', '0', 'admin', '2020-05-07 11:25:11', '',
        null, '审核不通过');
INSERT INTO `sys_dict_data`
VALUES ('103', '1', '低', '1', 'tb_work_grade', '', 'primary', 'Y', '0', 'admin', '2020-05-15 15:19:29', 'admin',
        '2020-05-15 15:20:05', '低');
INSERT INTO `sys_dict_data`
VALUES ('104', '2', '中', '2', 'tb_work_grade', null, 'success', 'Y', '0', 'admin', '2020-05-15 15:19:52', '', null,
        '中');
INSERT INTO `sys_dict_data`
VALUES ('105', '3', '高', '3', 'tb_work_grade', '', 'warning', 'Y', '0', 'admin', '2020-05-15 15:20:39', 'admin',
        '2020-05-15 15:21:24', '高');
INSERT INTO `sys_dict_data`
VALUES ('106', '4', '紧急', '4', 'tb_work_grade', '', 'danger', 'Y', '0', 'admin', '2020-05-15 15:21:09', 'admin',
        '2020-05-15 15:21:19', '紧急');
INSERT INTO `sys_dict_data`
VALUES ('107', '1', '待执行', '1', 'tb_work_status', null, 'success', 'Y', '0', 'admin', '2020-05-15 17:18:24', '',
        null, '待执行');
INSERT INTO `sys_dict_data`
VALUES ('108', '2', '执行中', '2', 'tb_work_status', '', 'info', 'Y', '0', 'admin', '2020-05-15 17:18:59', 'admin',
        '2020-05-15 17:19:11', '执行中');
INSERT INTO `sys_dict_data`
VALUES ('109', '5', '已完成', '5', 'tb_work_status', '', 'warning', 'Y', '0', 'admin', '2020-05-15 17:19:41', 'admin',
        '2020-05-18 18:29:03', '已完成');
INSERT INTO `sys_dict_data`
VALUES ('110', '3', '待验证', '3', 'tb_work_status', '', 'success', 'Y', '0', 'admin', '2020-05-15 17:20:16', 'admin',
        '2020-05-18 18:30:07', '待验证');
INSERT INTO `sys_dict_data`
VALUES ('111', '4', '退回', '4', 'tb_work_status', '', 'danger', 'Y', '0', 'admin', '2020-05-15 17:20:53', 'admin',
        '2020-05-18 18:29:17', '退回');
INSERT INTO `sys_dict_data`
VALUES ('112', '1', '执行中', '1', 'tb_deal_status', null, 'primary', 'Y', '0', 'admin', '2020-05-18 14:11:44', '',
        null, '处理状态');
INSERT INTO `sys_dict_data`
VALUES ('113', '2', '已完成', '2', 'tb_deal_status', null, 'warning', 'Y', '0', 'admin', '2020-05-18 14:12:10', '',
        null, '处理状态');
INSERT INTO `sys_dict_data`
VALUES ('115', '1', '不同意', '3', 'tb_check_status', '', 'success', 'Y', '0', 'admin', '2020-05-19 10:34:51', 'admin',
        '2020-05-19 11:42:23', '不同意');
INSERT INTO `sys_dict_data`
VALUES ('116', '2', '同意', '4', 'tb_check_status', '', 'success', 'Y', '0', 'admin', '2020-05-19 10:35:15', 'admin',
        '2020-05-19 11:42:30', '同意');
INSERT INTO `sys_dict_data`
VALUES ('117', '1', '单选题', '1', 'tb_question_type', null, 'primary', 'Y', '0', 'admin', '2020-06-05 10:15:09', '',
        null, null);
INSERT INTO `sys_dict_data`
VALUES ('118', '2', '多选题', '3', 'tb_question_type', '', 'success', 'Y', '0', 'admin', '2020-06-05 10:15:28', 'admin',
        '2020-06-08 10:32:44', '');
INSERT INTO `sys_dict_data`
VALUES ('119', '3', '判断题', '2', 'tb_question_type', '', 'warning', 'Y', '0', 'admin', '2020-06-05 10:15:48', 'admin',
        '2020-06-08 10:32:35', '');
INSERT INTO `sys_dict_data`
VALUES ('120', '4', '简答题', '4', 'tb_question_type', null, 'danger', 'Y', '0', 'admin', '2020-06-05 10:16:07', '',
        null, null);
INSERT INTO `sys_dict_data`
VALUES ('121', '1', '未开始考试', '0', 'tb_pager_status', '', 'success', 'Y', '0', 'admin', '2020-06-06 14:16:47',
        'admin', '2020-06-19 16:14:00', '');
INSERT INTO `sys_dict_data`
VALUES ('122', '2', '进行中', '1', 'tb_pager_status', null, 'info', 'Y', '0', 'admin', '2020-06-06 14:17:02', '', null,
        null);
INSERT INTO `sys_dict_data`
VALUES ('123', '2', '已结束', '2', 'tb_pager_status', null, 'danger', 'Y', '0', 'admin', '2020-06-06 14:17:22', '',
        null, null);
INSERT INTO `sys_dict_data`
VALUES ('124', '1', '未发布', '0', 'tb_pager_publish', null, 'success', 'Y', '0', 'admin', '2020-06-19 15:43:35', '',
        null, '未发布');
INSERT INTO `sys_dict_data`
VALUES ('125', '2', '已发布', '1', 'tb_pager_publish', '', 'danger', 'Y', '0', 'admin', '2020-06-19 15:43:54', 'admin',
        '2020-06-19 18:34:54', '发布成功');
INSERT INTO `sys_dict_data`
VALUES ('126', '1', '未确认', '0', 'tb_confirm_status', null, 'primary', 'Y', '0', 'admin', '2020-06-24 14:22:27', '',
        null, '未确认');
INSERT INTO `sys_dict_data`
VALUES ('127', '2', '已确认', '1', 'tb_confirm_status', '', 'success', 'Y', '0', 'admin', '2020-06-24 14:22:56',
        'admin', '2020-06-24 14:23:03', '已确认');
INSERT INTO `sys_dict_data`
VALUES ('128', '1', '未开始', '0', 'tb_vote_status', null, 'primary', 'Y', '0', 'admin', '2020-06-30 18:10:42', '',
        null, '未开始');
INSERT INTO `sys_dict_data`
VALUES ('129', '2', '进行中', '1', 'tb_vote_status', null, 'success', 'Y', '0', 'admin', '2020-06-30 18:10:58', '',
        null, '进行中');
INSERT INTO `sys_dict_data`
VALUES ('130', '3', '已结束', '2', 'tb_vote_status', null, 'danger', 'Y', '0', 'admin', '2020-06-30 18:11:19', '', null,
        '已结束');
INSERT INTO `sys_dict_data`
VALUES ('131', '1', '未投票', '0', 'tb_select_status', null, 'success', 'Y', '0', 'admin', '2020-07-01 15:37:25', '',
        null, '未投票');
INSERT INTO `sys_dict_data`
VALUES ('132', '2', '已投票', '1', 'tb_select_status', '', 'danger', 'Y', '0', 'admin', '2020-07-01 15:37:42', 'admin',
        '2020-07-01 15:37:48', '已投票');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`
(
    `dict_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
    `dict_name`   varchar(100) DEFAULT '' COMMENT '字典名称',
    `dict_type`   varchar(100) DEFAULT '' COMMENT '字典类型',
    `status`      char(1)      DEFAULT '0' COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`dict_id`),
    UNIQUE KEY `dict_type` (`dict_type`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type`
VALUES ('1', '用户性别', 'sys_user_sex', '0', 'admin', '2024-11-12 16:09:48', '', null, '用户性别列表');
INSERT INTO `sys_dict_type`
VALUES ('2', '菜单状态', 'sys_show_hide', '0', 'admin', '2024-11-12 16:09:48', '', null, '菜单状态列表');
INSERT INTO `sys_dict_type`
VALUES ('3', '系统开关', 'sys_normal_disable', '0', 'admin', '2024-11-12 16:09:48', '', null, '系统开关列表');
INSERT INTO `sys_dict_type`
VALUES ('4', '任务状态', 'sys_job_status', '0', 'admin', '2024-11-12 16:09:48', '', null, '任务状态列表');
INSERT INTO `sys_dict_type`
VALUES ('5', '任务分组', 'sys_job_group', '0', 'admin', '2024-11-12 16:09:48', '', null, '任务分组列表');
INSERT INTO `sys_dict_type`
VALUES ('6', '系统是否', 'sys_yes_no', '0', 'admin', '2024-11-12 16:09:48', '', null, '系统是否列表');
INSERT INTO `sys_dict_type`
VALUES ('7', '通知类型', 'sys_notice_type', '0', 'admin', '2024-11-12 16:09:48', '', null, '通知类型列表');
INSERT INTO `sys_dict_type`
VALUES ('8', '通知状态', 'sys_notice_status', '0', 'admin', '2024-11-12 16:09:48', '', null, '通知状态列表');
INSERT INTO `sys_dict_type`
VALUES ('9', '操作类型', 'sys_oper_type', '0', 'admin', '2024-11-12 16:09:48', '', null, '操作类型列表');
INSERT INTO `sys_dict_type`
VALUES ('10', '系统状态', 'sys_common_status', '0', 'admin', '2024-11-12 16:09:48', '', null, '登录状态列表');
INSERT INTO `sys_dict_type`
VALUES ('100', '审核状态', 'tb_news_status', '0', 'admin', '2020-05-07 11:23:02', '', null, '审核状态列表');
INSERT INTO `sys_dict_type`
VALUES ('101', '任务等级', 'tb_work_grade', '0', 'admin', '2020-05-15 15:15:35', '', null, '任务等级');
INSERT INTO `sys_dict_type`
VALUES ('102', '任务状态', 'tb_work_status', '0', 'admin', '2020-05-15 17:17:35', '', null, '任务状态');
INSERT INTO `sys_dict_type`
VALUES ('103', '处理状态', 'tb_deal_status', '0', 'admin', '2020-05-18 14:11:15', '', null, '处理状态');
INSERT INTO `sys_dict_type`
VALUES ('104', '验证状态', 'tb_check_status', '0', 'admin', '2020-05-19 10:34:23', '', null, '验证状态');
INSERT INTO `sys_dict_type`
VALUES ('105', '题目类型', 'tb_question_type', '0', 'admin', '2020-06-05 10:14:37', '', null, '题目类型');
INSERT INTO `sys_dict_type`
VALUES ('106', '考试状态', 'tb_pager_status', '0', 'admin', '2020-06-06 14:11:54', '', null, '考试状态');
INSERT INTO `sys_dict_type`
VALUES ('107', '考试发布状态', 'tb_pager_publish', '0', 'admin', '2020-06-19 15:43:09', '', null, '考试发布状态');
INSERT INTO `sys_dict_type`
VALUES ('108', '分数确认状态', 'tb_confirm_status', '0', 'admin', '2020-06-24 14:21:47', '', null, '分数状态');
INSERT INTO `sys_dict_type`
VALUES ('109', '选举发布状态', 'tb_vote_status', '0', 'admin', '2020-06-30 18:09:02', '', null, '选举发布状态');
INSERT INTO `sys_dict_type`
VALUES ('110', '投票状态', 'tb_select_status', '0', 'admin', '2020-07-01 15:36:59', '', null, '投票状态');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`
(
    `job_id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
    `job_name`        varchar(64)  NOT NULL DEFAULT '' COMMENT '任务名称',
    `job_group`       varchar(64)  NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
    `invoke_target`   varchar(500) NOT NULL COMMENT '调用目标字符串',
    `cron_expression` varchar(255)          DEFAULT '' COMMENT 'cron执行表达式',
    `misfire_policy`  varchar(20)           DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
    `concurrent`      char(1)               DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
    `status`          char(1)               DEFAULT '0' COMMENT '状态（0正常 1暂停）',
    `create_by`       varchar(64)           DEFAULT '' COMMENT '创建者',
    `create_time`     datetime              DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)           DEFAULT '' COMMENT '更新者',
    `update_time`     datetime              DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(500)          DEFAULT '' COMMENT '备注信息',
    PRIMARY KEY (`job_id`, `job_name`, `job_group`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job`
VALUES ('1', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin',
        '2024-11-12 16:09:48', '', null, '');
INSERT INTO `sys_job`
VALUES ('2', '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin',
        '2024-11-12 16:09:48', '', null, '');
INSERT INTO `sys_job`
VALUES ('3', '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)',
        '0/20 * * * * ?', '3', '1', '1', 'admin', '2024-11-12 16:09:48', '', null, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`
(
    `job_log_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
    `job_name`       varchar(64)  NOT NULL COMMENT '任务名称',
    `job_group`      varchar(64)  NOT NULL COMMENT '任务组名',
    `invoke_target`  varchar(500) NOT NULL COMMENT '调用目标字符串',
    `job_message`    varchar(500)  DEFAULT NULL COMMENT '日志信息',
    `status`         char(1)       DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
    `exception_info` varchar(2000) DEFAULT '' COMMENT '异常信息',
    `create_time`    datetime      DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`job_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`
(
    `info_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
    `login_name`     varchar(50)  DEFAULT '' COMMENT '登录账号',
    `ipaddr`         varchar(128) DEFAULT '' COMMENT '登录IP地址',
    `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
    `browser`        varchar(50)  DEFAULT '' COMMENT '浏览器类型',
    `os`             varchar(50)  DEFAULT '' COMMENT '操作系统',
    `status`         char(1)      DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
    `msg`            varchar(255) DEFAULT '' COMMENT '提示消息',
    `login_time`     datetime     DEFAULT NULL COMMENT '访问时间',
    PRIMARY KEY (`info_id`),
    KEY              `idx_sys_logininfor_s` (`status`),
    KEY              `idx_sys_logininfor_lt` (`login_time`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor`
VALUES ('100', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '密码输入错误1次',
        '2024-11-12 16:10:22');
INSERT INTO `sys_logininfor`
VALUES ('101', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '密码输入错误2次',
        '2024-11-12 16:10:30');
INSERT INTO `sys_logininfor`
VALUES ('102', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '验证码错误', '2024-11-12 16:11:04');
INSERT INTO `sys_logininfor`
VALUES ('103', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '0', '登录成功', '2024-11-12 16:11:08');
INSERT INTO `sys_logininfor`
VALUES ('104', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '密码输入错误1次',
        '2024-11-12 16:13:52');
INSERT INTO `sys_logininfor`
VALUES ('105', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '密码输入错误2次',
        '2024-11-12 16:13:58');
INSERT INTO `sys_logininfor`
VALUES ('106', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '0', '登录成功', '2024-11-12 16:14:40');
INSERT INTO `sys_logininfor`
VALUES ('107', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '1', '验证码错误', '2024-11-12 16:44:57');
INSERT INTO `sys_logininfor`
VALUES ('108', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '0', '登录成功', '2024-11-12 16:45:01');
INSERT INTO `sys_logininfor`
VALUES ('109', 'admin', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10', '0', '登录成功', '2024-11-12 16:52:34');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`
(
    `menu_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
    `menu_name`   varchar(50) NOT NULL COMMENT '菜单名称',
    `parent_id`   bigint(20) DEFAULT '0' COMMENT '父菜单ID',
    `order_num`   int(4) DEFAULT '0' COMMENT '显示顺序',
    `url`         varchar(200) DEFAULT '#' COMMENT '请求地址',
    `target`      varchar(20)  DEFAULT '' COMMENT '打开方式（menuItem页签 menuBlank新窗口）',
    `menu_type`   char(1)      DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
    `visible`     char(1)      DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
    `is_refresh`  char(1)      DEFAULT '1' COMMENT '是否刷新（0刷新 1不刷新）',
    `perms`       varchar(100) DEFAULT NULL COMMENT '权限标识',
    `icon`        varchar(100) DEFAULT '#' COMMENT '菜单图标',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2146 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu`
VALUES ('1', '系统管理', '0', '11', '#', 'menuItem', 'M', '1', '1', '', 'fa fa-gear', 'admin', '2018-03-16 11:33:00',
        'admin', '2020-06-30 17:37:52', '系统管理目录');
INSERT INTO `sys_menu`
VALUES ('2', '系统监控', '0', '12', '#', 'menuItem', 'M', '1', '1', '', 'fa fa-video-camera', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-07-03 14:41:49', '系统监控目录');
INSERT INTO `sys_menu`
VALUES ('3', '系统工具', '0', '10', '#', 'menuItem', 'M', '1', '1', '', 'fa fa-bars', 'admin', '2018-03-16 11:33:00',
        'admin', '2020-05-29 11:04:46', '系统工具目录');
INSERT INTO `sys_menu`
VALUES ('100', '党员信息', '2000', '2', '/system/user', 'menuItem', 'C', '0', '1', 'system:user:view,system:detail',
        '#', 'admin', '2018-03-16 11:33:00', 'admin', '2020-06-12 11:19:07', '用户管理菜单');
INSERT INTO `sys_menu`
VALUES ('101', '角色管理', '2000', '4', '/system/role', 'menuItem', 'C', '0', '1', 'system:role:view', '#', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-05-06 14:51:40', '角色管理菜单');
INSERT INTO `sys_menu`
VALUES ('102', '菜单管理', '1', '3', '/system/menu', '', 'C', '0', '1', 'system:menu:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单');
INSERT INTO `sys_menu`
VALUES ('103', '党组织架构', '2000', '1', '/system/dept', 'menuItem', 'C', '0', '1', 'system:dept:view', '#', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-06-12 11:20:33', '部门管理菜单');
INSERT INTO `sys_menu`
VALUES ('104', '职务管理', '2000', '3', '/system/post', 'menuItem', 'C', '1', '1', 'system:post:view', '#', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-06-30 11:45:02', '岗位管理菜单');
INSERT INTO `sys_menu`
VALUES ('105', '字典管理', '1', '6', '/system/dict', '', 'C', '0', '1', 'system:dict:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '字典管理菜单');
INSERT INTO `sys_menu`
VALUES ('106', '参数设置', '1', '7', '/system/config', 'menuItem', 'C', '1', '1', 'system:config:view', '#', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-05-06 14:43:16', '参数设置菜单');
INSERT INTO `sys_menu`
VALUES ('107', '通知公告', '2027', '3', '/system/notice', 'menuItem', 'C', '0', '1', 'system:notice:view', '#', 'admin',
        '2018-03-16 11:33:00', 'admin', '2020-06-12 14:39:30', '通知公告菜单');
INSERT INTO `sys_menu`
VALUES ('108', '日志管理', '1', '9', '#', 'menuItem', 'M', '1', '1', '', '#', 'admin', '2018-03-16 11:33:00', 'admin',
        '2020-05-06 14:43:48', '日志管理菜单');
INSERT INTO `sys_menu`
VALUES ('109', '在线用户', '2', '1', '/monitor/online', '', 'C', '0', '1', 'monitor:online:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '在线用户菜单');
INSERT INTO `sys_menu`
VALUES ('110', '定时任务', '2', '2', '/monitor/job', '', 'C', '0', '1', 'monitor:job:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '定时任务菜单');
INSERT INTO `sys_menu`
VALUES ('111', '数据监控', '2', '3', '/monitor/data', '', 'C', '0', '1', 'monitor:data:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '数据监控菜单');
INSERT INTO `sys_menu`
VALUES ('112', '服务监控', '2', '3', '/monitor/server', '', 'C', '0', '1', 'monitor:server:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '服务监控菜单');
INSERT INTO `sys_menu`
VALUES ('113', '表单构建', '3', '1', '/tool/build', '', 'C', '0', '1', 'tool:build:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '表单构建菜单');
INSERT INTO `sys_menu`
VALUES ('114', '代码生成', '3', '2', '/tool/gen', '', 'C', '0', '1', 'tool:gen:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '代码生成菜单');
INSERT INTO `sys_menu`
VALUES ('115', '系统接口', '3', '3', '/tool/swagger', '', 'C', '0', '1', 'tool:swagger:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '系统接口菜单');
INSERT INTO `sys_menu`
VALUES ('500', '操作日志', '108', '1', '/monitor/operlog', '', 'C', '0', '1', 'monitor:operlog:view', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '操作日志菜单');
INSERT INTO `sys_menu`
VALUES ('501', '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', '1', 'monitor:logininfor:view', '#',
        'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '登录日志菜单');
INSERT INTO `sys_menu`
VALUES ('1000', '用户查询', '100', '1', '#', '', 'F', '0', '1', 'system:user:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1001', '用户新增', '100', '2', '#', '', 'F', '0', '1', 'system:user:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1002', '用户修改', '100', '3', '#', '', 'F', '0', '1', 'system:user:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1003', '用户删除', '100', '4', '#', '', 'F', '0', '1', 'system:user:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1004', '用户导出', '100', '5', '#', '', 'F', '0', '1', 'system:user:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1005', '用户导入', '100', '6', '#', '', 'F', '0', '1', 'system:user:import', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1006', '重置密码', '100', '7', '#', '', 'F', '0', '1', 'system:user:resetPwd', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1007', '角色查询', '101', '1', '#', '', 'F', '0', '1', 'system:role:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1008', '角色新增', '101', '2', '#', '', 'F', '0', '1', 'system:role:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1009', '角色修改', '101', '3', '#', '', 'F', '0', '1', 'system:role:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1010', '角色删除', '101', '4', '#', '', 'F', '0', '1', 'system:role:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1011', '角色导出', '101', '5', '#', '', 'F', '0', '1', 'system:role:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1012', '菜单查询', '102', '1', '#', '', 'F', '0', '1', 'system:menu:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1013', '菜单新增', '102', '2', '#', '', 'F', '0', '1', 'system:menu:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1014', '菜单修改', '102', '3', '#', '', 'F', '0', '1', 'system:menu:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1015', '菜单删除', '102', '4', '#', '', 'F', '0', '1', 'system:menu:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1016', '部门查询', '103', '1', '#', '', 'F', '0', '1', 'system:dept:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1017', '部门新增', '103', '2', '#', '', 'F', '0', '1', 'system:dept:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1018', '部门修改', '103', '3', '#', '', 'F', '0', '1', 'system:dept:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1019', '部门删除', '103', '4', '#', '', 'F', '0', '1', 'system:dept:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1020', '岗位查询', '104', '1', '#', '', 'F', '0', '1', 'system:post:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1021', '岗位新增', '104', '2', '#', '', 'F', '0', '1', 'system:post:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1022', '岗位修改', '104', '3', '#', '', 'F', '0', '1', 'system:post:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1023', '岗位删除', '104', '4', '#', '', 'F', '0', '1', 'system:post:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1024', '岗位导出', '104', '5', '#', '', 'F', '0', '1', 'system:post:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1025', '字典查询', '105', '1', '#', '', 'F', '0', '1', 'system:dict:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1026', '字典新增', '105', '2', '#', '', 'F', '0', '1', 'system:dict:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1027', '字典修改', '105', '3', '#', '', 'F', '0', '1', 'system:dict:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1028', '字典删除', '105', '4', '#', '', 'F', '0', '1', 'system:dict:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1029', '字典导出', '105', '5', '#', '', 'F', '0', '1', 'system:dict:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1030', '参数查询', '106', '1', '#', '', 'F', '0', '1', 'system:config:list', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1031', '参数新增', '106', '2', '#', '', 'F', '0', '1', 'system:config:add', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1032', '参数修改', '106', '3', '#', '', 'F', '0', '1', 'system:config:edit', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1033', '参数删除', '106', '4', '#', '', 'F', '0', '1', 'system:config:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1034', '参数导出', '106', '5', '#', '', 'F', '0', '1', 'system:config:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1035', '公告查询', '107', '1', '#', '', 'F', '0', '1', 'system:notice:list', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1036', '公告新增', '107', '2', '#', '', 'F', '0', '1', 'system:notice:add', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1037', '公告修改', '107', '3', '#', '', 'F', '0', '1', 'system:notice:edit', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1038', '公告删除', '107', '4', '#', '', 'F', '0', '1', 'system:notice:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1039', '操作查询', '500', '1', '#', '', 'F', '0', '1', 'monitor:operlog:list', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1040', '操作删除', '500', '2', '#', '', 'F', '0', '1', 'monitor:operlog:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1041', '详细信息', '500', '3', '#', '', 'F', '0', '1', 'monitor:operlog:detail', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1042', '日志导出', '500', '4', '#', '', 'F', '0', '1', 'monitor:operlog:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1043', '登录查询', '501', '1', '#', '', 'F', '0', '1', 'monitor:logininfor:list', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1044', '登录删除', '501', '2', '#', '', 'F', '0', '1', 'monitor:logininfor:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1045', '日志导出', '501', '3', '#', '', 'F', '0', '1', 'monitor:logininfor:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1046', '账户解锁', '501', '4', '#', '', 'F', '0', '1', 'monitor:logininfor:unlock', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1047', '在线查询', '109', '1', '#', '', 'F', '0', '1', 'monitor:online:list', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1048', '批量强退', '109', '2', '#', '', 'F', '0', '1', 'monitor:online:batchForceLogout', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1049', '单条强退', '109', '3', '#', '', 'F', '0', '1', 'monitor:online:forceLogout', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1050', '任务查询', '110', '1', '#', '', 'F', '0', '1', 'monitor:job:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1051', '任务新增', '110', '2', '#', '', 'F', '0', '1', 'monitor:job:add', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1052', '任务修改', '110', '3', '#', '', 'F', '0', '1', 'monitor:job:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1053', '任务删除', '110', '4', '#', '', 'F', '0', '1', 'monitor:job:remove', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1054', '状态修改', '110', '5', '#', '', 'F', '0', '1', 'monitor:job:changeStatus', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1055', '任务详细', '110', '6', '#', '', 'F', '0', '1', 'monitor:job:detail', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1056', '任务导出', '110', '7', '#', '', 'F', '0', '1', 'monitor:job:export', '#', 'admin',
        '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1057', '生成查询', '114', '1', '#', '', 'F', '0', '1', 'tool:gen:list', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1058', '生成修改', '114', '2', '#', '', 'F', '0', '1', 'tool:gen:edit', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1059', '生成删除', '114', '3', '#', '', 'F', '0', '1', 'tool:gen:remove', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1060', '预览代码', '114', '4', '#', '', 'F', '0', '1', 'tool:gen:preview', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('1061', '生成代码', '114', '5', '#', '', 'F', '0', '1', 'tool:gen:code', '#', 'admin', '2018-03-16 11:33:00',
        'ry', '2018-03-16 11:33:00', '');
INSERT INTO `sys_menu`
VALUES ('2000', '党组织管理', '0', '6', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-bars', 'admin',
        '2020-05-06 14:47:10', 'admin', '2020-06-12 11:36:34', '');
INSERT INTO `sys_menu`
VALUES ('2001', '党建动态', '0', '2', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-bar-chart', 'admin',
        '2020-05-06 15:16:03', 'admin', '2020-06-22 10:49:14', '');
INSERT INTO `sys_menu`
VALUES ('2002', '党建动态', '2001', '2', '/module/news', 'menuItem', 'C', '0', '1', 'module:news:view', '#', 'admin',
        '2020-05-06 15:26:10', 'admin', '2020-06-22 10:49:33', '');
INSERT INTO `sys_menu`
VALUES ('2003', '党建分类', '2001', '1', '/module/type', 'menuItem', 'C', '0', '1', 'module:type:view', '#', 'admin',
        '2020-05-06 15:48:56', 'admin', '2020-06-22 10:49:56', '');
INSERT INTO `sys_menu`
VALUES ('2004', '我的审核', '2001', '3', '/module/news/approval', 'menuItem', 'C', '0', '1', 'module:news', '#',
        'admin', '2020-05-07 14:55:56', 'admin', '2020-06-22 10:50:43', '');
INSERT INTO `sys_menu`
VALUES ('2005', '党建资讯', '0', '2', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-binoculars', 'admin',
        '2020-05-07 17:27:46', 'admin', '2020-06-12 14:33:36', '');
INSERT INTO `sys_menu`
VALUES ('2006', '领导视察', '2005', '3', '/module/inspect', 'menuItem', 'C', '0', '1', 'module:inspect:view', '#',
        'admin', '2020-05-07 17:30:09', 'admin', '2020-06-12 14:48:54', '');
INSERT INTO `sys_menu`
VALUES ('2007', '单位交流', '2005', '2', '/module/exchange', 'menuItem', 'C', '0', '1', 'module:exchange:view', '#',
        'admin', '2020-05-08 10:26:15', 'admin', '2020-05-25 16:00:11', '');
INSERT INTO `sys_menu`
VALUES ('2008', '荣誉奖项', '2109', '3', '/module/award', 'menuItem', 'C', '0', '1', 'module:award:view', '#', 'admin',
        '2020-05-08 10:49:04', 'admin', '2020-06-22 10:53:10', '');
INSERT INTO `sys_menu`
VALUES ('2009', '暖心故事', '2005', '4', '/module/story', 'menuItem', 'C', '0', '1', 'module:story:view', '#', 'admin',
        '2020-05-08 11:12:15', 'admin', '2020-05-25 16:23:42', '');
INSERT INTO `sys_menu`
VALUES ('2010', '典型事迹', '2005', '5', '/module/deed', 'menuItem', 'C', '0', '1', 'module:deed:view', '#', 'admin',
        '2020-05-08 11:28:24', 'admin', '2020-05-25 16:23:51', '');
INSERT INTO `sys_menu`
VALUES ('2011', '十大亮点', '2005', '6', '/module/light', 'menuItem', 'C', '0', '1', 'module:light:view', '#', 'admin',
        '2020-05-08 14:55:06', 'admin', '2020-05-25 16:24:02', '');
INSERT INTO `sys_menu`
VALUES ('2012', '党组活动', '0', '3', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-asterisk', 'admin',
        '2020-05-09 11:27:39', 'admin', '2020-05-09 11:27:54', '');
INSERT INTO `sys_menu`
VALUES ('2013', '会议记录', '2012', '1', '/module/record', 'menuItem', 'C', '0', '1', 'module:record:view', '#',
        'admin', '2020-05-09 11:28:55', 'admin', '2020-05-25 15:44:00', '');
INSERT INTO `sys_menu`
VALUES ('2014', '学习计划', '2012', '2', '/module/plan', 'menuItem', 'C', '0', '1', 'module:plan:view', '#', 'admin',
        '2020-05-09 11:30:09', 'admin', '2020-05-25 15:44:12', '');
INSERT INTO `sys_menu`
VALUES ('2015', '心得体会', '2012', '3', '/module/feel', 'menuItem', 'C', '0', '1', 'module:feel:view', '#', 'admin',
        '2020-05-09 15:38:04', 'admin', '2020-05-25 15:47:29', '');
INSERT INTO `sys_menu`
VALUES ('2016', '分享美文', '2012', '4', '/module/article', 'menuItem', 'C', '0', '1', 'module:article:view', '#',
        'admin', '2020-05-09 16:34:03', 'admin', '2020-05-25 15:47:46', '');
INSERT INTO `sys_menu`
VALUES ('2017', '小组故事', '2012', '5', '/module/tale', 'menuItem', 'C', '0', '1', 'module:tale:view', '#', 'admin',
        '2020-05-09 17:17:53', 'admin', '2020-05-25 15:54:13', '');
INSERT INTO `sys_menu`
VALUES ('2018', '问题墙', '2012', '7', '/module/problem', 'menuItem', 'C', '0', '1', 'module:problem:view', '#',
        'admin', '2020-05-11 10:50:46', 'admin', '2020-05-25 15:54:22', '');
INSERT INTO `sys_menu`
VALUES ('2019', '所有任务', '2020', '8', '/module/work', 'menuItem', 'C', '0', '1', 'module:work,module:dist', '#',
        'admin', '2020-05-15 14:57:59', 'admin', '2020-06-01 18:46:47', '');
INSERT INTO `sys_menu`
VALUES ('2020', '任务管理', '0', '4', '#', 'menuItem', 'M', '1', '1', '', 'fa fa-assistive-listening-systems', 'admin',
        '2020-05-20 10:55:33', 'admin', '2020-06-22 10:51:37', '');
INSERT INTO `sys_menu`
VALUES ('2021', '我创建任务', '2020', '2', '/module/work/myWork', 'menuItem', 'C', '0', '1', 'module:work,module:dist',
        '#', 'admin', '2020-05-20 10:58:37', 'admin', '2020-06-01 18:46:39', '');
INSERT INTO `sys_menu`
VALUES ('2022', '分配给我任务', '2020', '1', '/module/work/toWork', 'menuItem', 'C', '0', '1',
        'module:work,module:flow,module:dist', '#', '123456', '2020-05-20 11:48:04', 'admin', '2020-06-01 18:46:31',
        '');
INSERT INTO `sys_menu`
VALUES ('2023', '任务流程', '2020', '9', '/module/flow', 'menuItem', 'C', '1', '1', 'module:flow', '#', '123456',
        '2020-05-20 11:56:49', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2024', '学分管理', '0', '7', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-bars', 'admin', '2020-05-21 18:19:33',
        'admin', '2020-06-12 14:42:27', '');
INSERT INTO `sys_menu`
VALUES ('2025', '成员学分', '2024', '1', '/module/learn/userRank', 'menuItem', 'C', '0', '1', 'module:learn', '#',
        'admin', '2020-05-21 18:20:39', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2026', '小组学分', '2024', '2', '/module/learn/deptRank', 'menuItem', 'C', '0', '1', 'module:learn', '#',
        'admin', '2020-05-21 18:21:43', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2027', '首页', '0', '1', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-cc', 'admin', '2020-05-25 10:54:48',
        'admin', '2020-06-12 14:38:53', '');
INSERT INTO `sys_menu`
VALUES ('2028', '轮播图', '2027', '1', '/module/picture', 'menuItem', 'C', '0', '1', 'module:picture:view', '#',
        'admin', '2020-05-25 10:57:41', 'admin', '2020-06-12 14:38:59', '');
INSERT INTO `sys_menu`
VALUES ('2029', '图片新增', '2028', '1', '#', 'menuItem', 'F', '0', '1', 'module:picture:add', '#', 'admin',
        '2020-05-25 15:28:07', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2030', '图片修改', '2028', '2', '#', 'menuItem', 'F', '0', '1', 'module:picture:edit', '#', 'admin',
        '2020-05-25 15:28:27', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2031', '图片查询', '2028', '3', '#', 'menuItem', 'F', '0', '1', 'module:picture:list', '#', 'admin',
        '2020-05-25 15:28:53', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2032', '图片删除', '2028', '4', '#', 'menuItem', 'F', '0', '1', 'module:picture:remove', '#', 'admin',
        '2020-05-25 15:29:47', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2033', '分类新增', '2003', '1', '#', 'menuItem', 'F', '0', '1', 'module:type:add', '#', 'admin',
        '2020-05-25 15:35:40', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2034', '分类修改', '2003', '2', '#', 'menuItem', 'F', '0', '1', 'module:type:edit', '#', 'admin',
        '2020-05-25 15:36:26', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2035', '分类删除', '2003', '3', '#', 'menuItem', 'F', '0', '1', 'module:type:remove', '#', 'admin',
        '2020-05-25 15:36:58', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2036', '分类查询', '2003', '4', '#', 'menuItem', 'F', '0', '1', 'module:type:list', '#', 'admin',
        '2020-05-25 15:37:26', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2037', '资讯新增', '2002', '1', '#', 'menuItem', 'F', '0', '1', 'module:news:add', '#', 'admin',
        '2020-05-25 15:38:39', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2038', '资讯修改', '2002', '2', '#', 'menuItem', 'F', '0', '1', 'module:news:edit', '#', 'admin',
        '2020-05-25 15:39:08', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2039', '资讯删除', '2002', '3', '#', 'menuItem', 'F', '0', '1', 'module:news:remove', '#', 'admin',
        '2020-05-25 15:39:33', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2040', '资讯查询', '2002', '4', '#', 'menuItem', 'F', '0', '1', 'module:news:list', '#', 'admin',
        '2020-05-25 15:39:57', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2041', '会议新增', '2013', '1', '#', 'menuItem', 'F', '0', '1', 'module:record:add', '#', 'admin',
        '2020-05-25 15:41:26', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2042', '会议修改', '2013', '2', '#', 'menuItem', 'F', '0', '1', 'module:record:edit', '#', 'admin',
        '2020-05-25 15:41:58', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2043', '会议删除', '2013', '3', '#', 'menuItem', 'F', '0', '1', 'module:record:remove', '#', 'admin',
        '2020-05-25 15:42:21', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2044', '会议查询', '2013', '4', '#', 'menuItem', 'F', '0', '1', 'module:record:list', '#', 'admin',
        '2020-05-25 15:42:45', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2045', '学习新增', '2014', '1', '#', 'menuItem', 'F', '0', '1', 'module:plan:add', '#', 'admin',
        '2020-05-25 15:43:30', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2046', '学习修改', '2014', '2', '#', 'menuItem', 'F', '0', '1', 'module:plan:edit', '#', 'admin',
        '2020-05-25 15:44:34', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2047', '学习删除', '2014', '3', '#', 'menuItem', 'F', '0', '1', 'module:plan:remove', '#', 'admin',
        '2020-05-25 15:45:00', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2048', '学习查询', '2014', '4', '#', 'menuItem', 'F', '0', '1', 'module:plan:list', '#', 'admin',
        '2020-05-25 15:45:19', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2049', '体会新增', '2015', '1', '#', 'menuItem', 'F', '0', '1', 'module:feel:add', '#', 'admin',
        '2020-05-25 15:46:02', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2050', '体会修改', '2015', '2', '#', 'menuItem', 'F', '0', '1', 'module:feel:edit', '#', 'admin',
        '2020-05-25 15:46:27', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2051', '体会删除', '2015', '3', '#', 'menuItem', 'F', '0', '1', 'module:feel:remove', '#', 'admin',
        '2020-05-25 15:46:50', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2052', '体会查询', '2015', '4', '#', 'menuItem', 'F', '0', '1', 'module:feel:list', '#', 'admin',
        '2020-05-25 15:47:13', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2053', '美文新增', '2016', '1', '#', 'menuItem', 'F', '0', '1', 'module:article:add', '#', 'admin',
        '2020-05-25 15:48:17', 'admin', '2020-05-25 15:48:58', '');
INSERT INTO `sys_menu`
VALUES ('2054', '美文修改', '2016', '2', '#', 'menuItem', 'F', '0', '1', 'module:article:edit', '#', 'admin',
        '2020-05-25 15:48:40', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2055', '美文删除', '2016', '3', '#', 'menuItem', 'F', '0', '1', 'module:article:remove', '#', 'admin',
        '2020-05-25 15:49:24', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2056', '美文查询', '2016', '4', '#', 'menuItem', 'F', '0', '1', 'module:article:list', '#', 'admin',
        '2020-05-25 15:49:51', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2057', '故事新增', '2017', '1', '#', 'menuItem', 'F', '0', '1', 'module:tale:add', '#', 'admin',
        '2020-05-25 15:50:44', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2058', '故事修改', '2017', '2', '#', 'menuItem', 'F', '0', '1', 'module:tale:edit', '#', 'admin',
        '2020-05-25 15:51:12', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2059', '故事删除', '2017', '3', '#', 'menuItem', 'F', '0', '1', 'module:tale:remove', '#', 'admin',
        '2020-05-25 15:51:43', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2060', '故事查询', '2017', '4', '#', 'menuItem', 'F', '0', '1', 'module:tale:list', '#', 'admin',
        '2020-05-25 15:52:11', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2061', '问题新增', '2018', '1', '#', 'menuItem', 'F', '0', '1', 'module:problem:add', '#', 'admin',
        '2020-05-25 15:52:48', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2062', '问题修改', '2018', '2', '#', 'menuItem', 'F', '0', '1', 'module:problem:edit', '#', 'admin',
        '2020-05-25 15:53:13', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2063', '问题删除', '2018', '3', '#', 'menuItem', 'F', '0', '1', 'module:problem:remove', '#', 'admin',
        '2020-05-25 15:53:35', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2064', '问题查询', '2018', '4', '#', 'menuItem', 'F', '0', '1', 'module:problem:list', '#', 'admin',
        '2020-05-25 15:54:00', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2065', '视察新增', '2006', '1', '#', 'menuItem', 'F', '0', '1', 'module:inspect:add', '#', 'admin',
        '2020-05-25 15:56:05', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2066', '视察修改', '2006', '2', '#', 'menuItem', 'F', '0', '1', 'module:inspect:edit', '#', 'admin',
        '2020-05-25 15:56:53', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2067', '视察删除', '2006', '3', '#', 'menuItem', 'F', '0', '1', 'module:inspect:remove', '#', 'admin',
        '2020-05-25 15:57:19', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2068', '视察查询', '2006', '4', '#', 'menuItem', 'F', '0', '1', 'module:inspect:list', '#', 'admin',
        '2020-05-25 15:57:45', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2069', '交流新增', '2007', '1', '#', 'menuItem', 'F', '0', '1', 'module:exchange:add', '#', 'admin',
        '2020-05-25 15:58:43', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2070', '交流修改', '2007', '2', '#', 'menuItem', 'F', '0', '1', 'module:exchange:edit', '#', 'admin',
        '2020-05-25 15:59:06', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2071', '交流删除', '2007', '3', '#', 'menuItem', 'F', '0', '1', 'module:exchange:remove', '#', 'admin',
        '2020-05-25 15:59:29', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2072', '交流查询', '2007', '4', '#', 'menuItem', 'F', '0', '1', 'module:exchange:list', '#', 'admin',
        '2020-05-25 15:59:49', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2073', '荣誉新增', '2008', '1', '#', 'menuItem', 'F', '0', '1', 'module:award:add', '#', 'admin',
        '2020-05-25 16:01:01', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2074', '荣誉修改', '2008', '2', '#', 'menuItem', 'F', '0', '1', 'module:award:edit', '#', 'admin',
        '2020-05-25 16:01:22', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2075', '荣誉删除', '2008', '3', '#', 'menuItem', 'F', '0', '1', 'module:award:remove', '#', 'admin',
        '2020-05-25 16:01:45', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2076', '荣誉查询', '2008', '4', '#', 'menuItem', 'F', '0', '1', 'module:award:list', '#', 'admin',
        '2020-05-25 16:02:08', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2077', '暖心故事新增', '2009', '1', '#', 'menuItem', 'F', '0', '1', 'module:story:add', '#', 'admin',
        '2020-05-25 16:03:11', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2078', '暖心故事修改', '2009', '2', '#', 'menuItem', 'F', '0', '1', 'module:story:edit', '#', 'admin',
        '2020-05-25 16:03:35', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2079', '暖心故事删除', '2009', '3', '#', 'menuItem', 'F', '0', '1', 'module:story:remove', '#', 'admin',
        '2020-05-25 16:03:59', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2080', '暖心故事查询', '2009', '4', '#', 'menuItem', 'F', '0', '1', 'module:story:list', '#', 'admin',
        '2020-05-25 16:04:23', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2081', '典型事迹新增', '2010', '1', '#', 'menuItem', 'F', '0', '1', 'module:deed:add', '#', 'admin',
        '2020-05-25 16:05:20', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2082', '典型事迹修改', '2010', '2', '#', 'menuItem', 'F', '0', '1', 'module:deed:edit', '#', 'admin',
        '2020-05-25 16:05:45', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2083', '典型事迹删除', '2010', '3', '#', 'menuItem', 'F', '0', '1', 'module:deed:remove', '#', 'admin',
        '2020-05-25 16:06:08', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2084', '典型事迹查询', '2010', '4', '#', 'menuItem', 'F', '0', '1', 'module:deed:list', '#', 'admin',
        '2020-05-25 16:06:30', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2085', '十大亮点新增', '2011', '1', '#', 'menuItem', 'F', '0', '1', 'module:light:add', '#', 'admin',
        '2020-05-25 16:07:01', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2086', '十大亮点修改', '2011', '2', '#', 'menuItem', 'F', '0', '1', 'module:light:edit', '#', 'admin',
        '2020-05-25 16:07:36', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2087', '十大亮点删除', '2011', '3', '#', 'menuItem', 'F', '0', '1', 'module:light:remove', '#', 'admin',
        '2020-05-25 16:09:16', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2088', '十大亮点查询', '2011', '4', '#', 'menuItem', 'F', '0', '1', 'module:light:list', '#', 'admin',
        '2020-05-25 16:09:48', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2089', '题库管理', '0', '8', '#', 'menuItem', 'M', '0', '1', null, 'fa fa-birthday-cake', 'admin',
        '2020-06-04 17:49:11', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2090', '题库分类', '2089', '1', '/module/questiontype', 'menuItem', 'C', '0', '1', 'module:questiontype:view',
        '#', 'admin', '2020-06-04 17:52:00', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2091', '题库分类添加', '2090', '1', '#', 'menuItem', 'F', '0', '1', 'module:questiontype:add', '#', 'admin',
        '2020-06-04 17:53:21', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2092', '题库分类修改', '2090', '2', '#', 'menuItem', 'F', '0', '1', 'module:questiontype:edit', '#', 'admin',
        '2020-06-04 17:53:48', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2094', '题库分类删除', '2090', '3', '#', 'menuItem', 'F', '0', '1', 'module:questiontype:remove', '#', 'admin',
        '2020-06-04 17:55:37', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2095', '题库分类查询', '2090', '4', '#', 'menuItem', 'F', '0', '1', 'module:questiontype:list', '#', 'admin',
        '2020-06-04 17:56:00', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2096', '题库列表', '2089', '2', '/module/question', 'menuItem', 'C', '0', '1', 'module:question:view', '#',
        'admin', '2020-06-05 09:38:56', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2097', '考试管理', '0', '9', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-bookmark', 'admin',
        '2020-06-05 11:56:19', 'admin', '2020-06-05 14:18:42', '');
INSERT INTO `sys_menu`
VALUES ('2098', '考试列表', '2097', '1', '/module/pager', 'menuItem', 'C', '0', '1',
        'module:pager:view,module:pageruser', '#', 'admin', '2020-06-05 11:57:46', 'admin', '2020-06-22 12:01:47', '');
INSERT INTO `sys_menu`
VALUES ('2099', '试卷新增', '2098', '1', '#', 'menuItem', 'F', '0', '1', 'module:pager:add', '#', 'admin',
        '2020-06-05 11:58:46', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2100', '试卷修改', '2098', '2', '#', 'menuItem', 'F', '0', '1', 'module:pager:edit', '#', 'admin',
        '2020-06-05 11:59:12', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2101', '试卷删除', '2098', '3', '#', 'menuItem', 'F', '0', '1', 'module:pager:remove', '#', 'admin',
        '2020-06-05 11:59:36', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2102', '试卷查询', '2098', '4', '#', 'menuItem', 'F', '0', '1', 'module:pager:list', '#', 'admin',
        '2020-06-05 12:00:05', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2103', '答卷管理', '2097', '2', '/module/answer/count', 'menuItem', 'C', '0', '1', 'module:answer:view', '#',
        'admin', '2020-06-08 11:42:41', 'admin', '2020-06-08 15:22:00', '');
INSERT INTO `sys_menu`
VALUES ('2104', '答卷查询', '2103', '1', '#', 'menuItem', 'F', '0', '1', 'module:pager:list', '#', 'admin',
        '2020-06-08 15:26:28', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2105', '题库添加', '2096', '1', '#', 'menuItem', 'F', '0', '1', 'module:question:add', '#', 'admin',
        '2020-06-20 14:43:05', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2106', '题库修改', '2096', '2', '#', 'menuItem', 'F', '0', '1', 'module:question:edit', '#', 'admin',
        '2020-06-20 14:43:35', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2107', '题库删除', '2096', '3', '#', 'menuItem', 'F', '0', '1', 'module:question:remove', '#', 'admin',
        '2020-06-20 14:44:04', 'admin', '2020-06-20 14:45:50', '');
INSERT INTO `sys_menu`
VALUES ('2108', '题库查询', '2096', '4', '#', 'menuItem', 'F', '0', '1', 'module:question:list', '#', 'admin',
        '2020-06-20 14:44:22', 'admin', '2020-06-20 14:46:04', '');
INSERT INTO `sys_menu`
VALUES ('2109', '荣誉奖项', '0', '5', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-audio-description', 'admin',
        '2020-06-22 10:52:21', 'admin', '2020-06-22 10:52:36', '');
INSERT INTO `sys_menu`
VALUES ('2110', '考试人查询', '2098', '5', '#', 'menuItem', 'F', '0', '1', 'module:pageruser:list', '#', 'admin',
        '2020-06-22 11:11:13', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2112', '违规违纪', '0', '6', '#', 'menuItem', 'M', '0', '1', null, 'fa fa-globe', 'admin',
        '2020-06-22 15:25:08', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2113', '违规违纪', '2112', '1', '/module/violate', 'menuItem', 'C', '0', '1', 'module:violate:view', '#',
        'admin', '2020-06-22 15:32:32', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2114', '违纪新增', '2113', '1', '#', 'menuItem', 'F', '0', '1', 'module:violate:add', '#', 'admin',
        '2020-06-22 15:33:34', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2115', '违纪修改', '2113', '2', '#', 'menuItem', 'F', '0', '1', 'module:violate:edit', '#', 'admin',
        '2020-06-22 15:34:04', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2116', '违纪删除', '2113', '3', '#', 'menuItem', 'F', '0', '1', 'module:violate:remove', '#', 'admin',
        '2020-06-22 15:34:28', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2117', '违纪查询', '2113', '4', '#', 'menuItem', 'F', '0', '1', 'module:violate:list', '#', 'admin',
        '2020-06-22 15:34:58', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2118', '选举管理', '0', '7', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-book', 'admin', '2020-06-30 17:33:53',
        'admin', '2020-07-03 15:27:59', '');
INSERT INTO `sys_menu`
VALUES ('2119', '党代表管理', '2118', '1', '/vote/vote', 'menuItem', 'C', '0', '1',
        'vote:vote:view,vote:voteuser,vote:vote:userby', '#', 'admin', '2020-06-30 17:37:56', 'admin',
        '2020-07-01 16:03:50', '');
INSERT INTO `sys_menu`
VALUES ('2120', '党代表查询', '2119', '4', '#', 'menuItem', 'F', '0', '1', 'vote:vote:list', '#', 'admin',
        '2020-07-01 10:33:30', 'admin', '2020-07-01 10:36:08', '');
INSERT INTO `sys_menu`
VALUES ('2121', '党代表新增', '2119', '1', '#', 'menuItem', 'F', '0', '1', 'vote:vote:add', '#', 'admin',
        '2020-07-01 10:34:30', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2122', '党代表修改', '2119', '2', '#', 'menuItem', 'F', '0', '1', 'vote:vote:edit', '#', 'admin',
        '2020-07-01 10:35:29', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2123', '党代表删除', '2119', '3', '#', 'menuItem', 'F', '0', '1', 'vote:vote:remove', '#', 'admin',
        '2020-07-01 10:36:39', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2127', '换届管理', '2118', '2', '/vote/voteChange', 'menuItem', 'C', '0', '1',
        'vote:vote:view,vote:voteuser,vote:voteuser', '#', 'admin', '2020-07-03 10:35:23', 'admin',
        '2020-07-03 10:58:35', '');
INSERT INTO `sys_menu`
VALUES ('2128', '在线学习', '0', '7', '#', 'menuItem', 'M', '0', '1', '', 'fa fa-credit-card', 'admin',
        '2020-07-09 17:30:04', 'admin', '2020-07-09 17:38:34', '');
INSERT INTO `sys_menu`
VALUES ('2129', '学习管理', '2128', '2', '/module/newsLearn', 'menuItem', 'C', '0', '1', 'module:news', '#', 'admin',
        '2020-07-09 17:39:37', 'admin', '2020-07-10 11:34:39', '');
INSERT INTO `sys_menu`
VALUES ('2130', '学习新增', '2129', '1', '#', 'menuItem', 'F', '0', '1', 'module:news:add', '#', 'admin',
        '2020-07-09 17:49:11', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2131', '学习修改', '2129', '2', '#', 'menuItem', 'F', '0', '1', 'module:news:edit', '#', 'admin',
        '2020-07-09 17:49:45', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2132', '学习删除', '2129', '3', '#', 'menuItem', 'F', '0', '1', 'module:news:remove', '#', 'admin',
        '2020-07-09 17:50:12', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2133', '学习查询', '2129', '4', '#', 'menuItem', 'F', '0', '1', 'module:news:list', '#', 'admin',
        '2020-07-09 17:50:39', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2134', '学习分类', '2128', '1', '/module/typeLearn', 'menuItem', 'C', '0', '1', 'module:type:view', '#',
        'admin', '2020-07-09 18:08:10', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2135', '学习分类新增', '2134', '1', '#', 'menuItem', 'F', '0', '1', 'module:type:add', '#', 'admin',
        '2020-07-09 18:10:17', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2136', '学习分类修改', '2134', '2', '#', 'menuItem', 'F', '0', '1', 'module:type:edit', '#', 'admin',
        '2020-07-09 18:10:50', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2137', '学习分类删除', '2134', '3', '#', 'menuItem', 'F', '0', '1', 'module:type:remove', '#', 'admin',
        '2020-07-09 18:11:17', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2138', '学习分类查询', '2134', '4', '#', 'menuItem', 'F', '0', '1', 'module:type:list', '#', 'admin',
        '2020-07-09 18:11:48', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2139', '学习审核', '2128', '3', '/module/newsLearn/approval', 'menuItem', 'C', '0', '1', 'module:new', '#',
        'admin', '2020-07-10 11:33:19', 'admin', '2020-07-10 15:00:22', '');
INSERT INTO `sys_menu`
VALUES ('2140', '换届新增', '2127', '1', '#', 'menuItem', 'F', '0', '1', 'vote:vote:add', '#', 'admin',
        '2020-07-10 15:19:44', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2141', '换届修改', '2127', '2', '#', 'menuItem', 'F', '0', '1', 'vote:vote:edit', '#', 'admin',
        '2020-07-10 15:20:09', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2142', '换届删除', '2127', '3', '#', 'menuItem', 'F', '0', '1', 'vote:vote:remove', '#', 'admin',
        '2020-07-10 15:21:03', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2143', '换届查询', '2127', '4', '#', 'menuItem', 'F', '0', '1', 'vote:vote:list', '#', 'admin',
        '2020-07-10 15:21:28', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2144', '学习收藏', '2128', '4', '/module/collect', 'menuItem', 'C', '0', '1', 'module:collect:view', '#',
        'admin', '2020-07-10 16:27:14', '', null, '');
INSERT INTO `sys_menu`
VALUES ('2145', '收藏查询', '2144', '1', '#', 'menuItem', 'F', '0', '1', 'module:collect:list', '#', 'admin',
        '2020-07-10 16:27:54', '', null, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`
(
    `notice_id`      int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
    `notice_title`   varchar(50) NOT NULL COMMENT '公告标题',
    `notice_type`    char(1)     NOT NULL COMMENT '公告类型（1通知 2公告）',
    `notice_content` longblob COMMENT '公告内容',
    `status`         char(1)                         DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
    `create_by`      varchar(64)                     DEFAULT '' COMMENT '创建者',
    `create_time`    datetime                        DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)                     DEFAULT '' COMMENT '更新者',
    `update_time`    datetime                        DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(255)                    DEFAULT NULL COMMENT '备注',
    `user_id`        int(20) DEFAULT NULL COMMENT '审核人id',
    `user_name`      varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '审核人名称',
    PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice`
VALUES ('15', '通知公告', '1',
        0x3C703E3C7370616E207374796C653D22636F6C6F723A207267622839302C2039302C203930293B20666F6E742D66616D696C793A202671756F743B536F757263652048616E2053616E7320434E2671756F743B3B20666F6E742D73697A653A20313670783B206261636B67726F756E642D636F6C6F723A20726762283234382C203234382C20323438293B223EE5B9B3E58FB0E694AFE68C81E5859AE7BB84E7BB87E7BB99E5859AE59198E58F91E98081E9809AE79FA5E585ACE5918AEFBC8CE588A9E794A8E6898BE69CBAE6B688E681AFE68EA8E98081E7AD89E696B9E5BC8FE58F8AE697B6E68F90E98692E79BB8E585B3E5859AE7BB84E7BB87E5928CE5859AE59198EFBC8CE4BEBFE4BA8EE6B688E681AFE79A84E4B88AE68385E4B88BE8BEBEEFBC8CE7A1AEE4BF9DE4BFA1E681AFE9809AE79585EFBC8CE68F90E58D87E4BA86E5859AE5BBBAE5B7A5E4BD9CE69588E78E87E38082E9809AE79FA5E5B7B2E8AFBBE69CAAE8AFBBE78AB6E68081E4B880E79BAEE4BA86E784B6E38082E5859AE7BB84E7BB87E7AEA1E79086E59198E58FAFE5AFB9E69CAAE8AFBBE585ACE5918AE5859AE59198E8BF9BE8A18CE2809CE4B880E994AEE582ACE58A9EE2809DEFBC9BE5859AE59198E58FAFE59CA8E7A7BBE58AA8E7ABAFE694B6E588B0E582ACE58A9EE9809AE79FA5EFBC8CE68F90E58D87E6B4BBE58AA8E69588E78E87E380823C2F7370616E3E3C62723E3C2F703E,
        '2', 'admin', '2020-08-10 18:29:24', '', '2024-11-11 10:57:30', null, '1', '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`
(
    `oper_id`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
    `title`          varchar(50)   DEFAULT '' COMMENT '模块标题',
    `business_type`  int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
    `method`         varchar(200)  DEFAULT '' COMMENT '方法名称',
    `request_method` varchar(10)   DEFAULT '' COMMENT '请求方式',
    `operator_type`  int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
    `oper_name`      varchar(50)   DEFAULT '' COMMENT '操作人员',
    `dept_name`      varchar(50)   DEFAULT '' COMMENT '部门名称',
    `oper_url`       varchar(255)  DEFAULT '' COMMENT '请求URL',
    `oper_ip`        varchar(128)  DEFAULT '' COMMENT '主机地址',
    `oper_location`  varchar(255)  DEFAULT '' COMMENT '操作地点',
    `oper_param`     varchar(2000) DEFAULT '' COMMENT '请求参数',
    `json_result`    varchar(2000) DEFAULT '' COMMENT '返回参数',
    `status`         int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
    `error_msg`      varchar(2000) DEFAULT '' COMMENT '错误消息',
    `oper_time`      datetime      DEFAULT NULL COMMENT '操作时间',
    `cost_time`      bigint(20) DEFAULT '0' COMMENT '消耗时间',
    PRIMARY KEY (`oper_id`),
    KEY              `idx_sys_oper_log_bt` (`business_type`),
    KEY              `idx_sys_oper_log_s` (`status`),
    KEY              `idx_sys_oper_log_ot` (`oper_time`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`
(
    `post_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
    `post_code`   varchar(64) NOT NULL COMMENT '岗位编码',
    `post_name`   varchar(50) NOT NULL COMMENT '岗位名称',
    `post_sort`   int(4) NOT NULL COMMENT '显示顺序',
    `status`      char(1)     NOT NULL COMMENT '状态（0正常 1停用）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post`
VALUES ('1', '7', '党小组长', '7', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2020-05-22 15:17:12', '');
INSERT INTO `sys_post`
VALUES ('6', '1', '支部书记', '1', '0', 'admin', '2020-05-22 15:18:56', '', '2020-05-22 15:17:12', '');
INSERT INTO `sys_post`
VALUES ('7', '2', '支部副书记', '2', '0', 'admin', '2020-05-22 15:19:20', '', '2020-05-22 15:17:12', '');
INSERT INTO `sys_post`
VALUES ('8', '3', '组织委员', '3', '0', 'admin', '2020-05-22 15:19:49', '', '2020-05-22 15:17:12', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `role_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `role_name`   varchar(30)  NOT NULL COMMENT '角色名称',
    `role_key`    varchar(100) NOT NULL COMMENT '角色权限字符串',
    `role_sort`   int(4) NOT NULL COMMENT '显示顺序',
    `data_scope`  char(1)      DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    `status`      char(1)      NOT NULL COMMENT '角色状态（0正常 1停用）',
    `del_flag`    char(1)      DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`
VALUES ('1', '管理员', 'admin', '1', '1', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00',
        '管理员');
INSERT INTO `sys_role`
VALUES ('2', '党小组管理员', '1', '2', '3', '0', '0', 'admin', '2018-03-16 11:33:00', 'admin', '2018-03-16 11:33:00',
        '组长');
INSERT INTO `sys_role`
VALUES ('7', '123', '123', '1', '1', '0', '0', 'admin', '2020-08-18 14:33:07', 'admin', '2018-03-16 11:33:00', null);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`
(
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
    PRIMARY KEY (`role_id`, `dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`
(
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
    PRIMARY KEY (`role_id`, `menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu`
VALUES ('2', '100');
INSERT INTO `sys_role_menu`
VALUES ('2', '101');
INSERT INTO `sys_role_menu`
VALUES ('2', '103');
INSERT INTO `sys_role_menu`
VALUES ('2', '104');
INSERT INTO `sys_role_menu`
VALUES ('2', '107');
INSERT INTO `sys_role_menu`
VALUES ('2', '1000');
INSERT INTO `sys_role_menu`
VALUES ('2', '1001');
INSERT INTO `sys_role_menu`
VALUES ('2', '1002');
INSERT INTO `sys_role_menu`
VALUES ('2', '1003');
INSERT INTO `sys_role_menu`
VALUES ('2', '1004');
INSERT INTO `sys_role_menu`
VALUES ('2', '1005');
INSERT INTO `sys_role_menu`
VALUES ('2', '1006');
INSERT INTO `sys_role_menu`
VALUES ('2', '1007');
INSERT INTO `sys_role_menu`
VALUES ('2', '1008');
INSERT INTO `sys_role_menu`
VALUES ('2', '1009');
INSERT INTO `sys_role_menu`
VALUES ('2', '1010');
INSERT INTO `sys_role_menu`
VALUES ('2', '1011');
INSERT INTO `sys_role_menu`
VALUES ('2', '1016');
INSERT INTO `sys_role_menu`
VALUES ('2', '1017');
INSERT INTO `sys_role_menu`
VALUES ('2', '1018');
INSERT INTO `sys_role_menu`
VALUES ('2', '1019');
INSERT INTO `sys_role_menu`
VALUES ('2', '1020');
INSERT INTO `sys_role_menu`
VALUES ('2', '1021');
INSERT INTO `sys_role_menu`
VALUES ('2', '1022');
INSERT INTO `sys_role_menu`
VALUES ('2', '1023');
INSERT INTO `sys_role_menu`
VALUES ('2', '1024');
INSERT INTO `sys_role_menu`
VALUES ('2', '1035');
INSERT INTO `sys_role_menu`
VALUES ('2', '1036');
INSERT INTO `sys_role_menu`
VALUES ('2', '1037');
INSERT INTO `sys_role_menu`
VALUES ('2', '2000');
INSERT INTO `sys_role_menu`
VALUES ('2', '2001');
INSERT INTO `sys_role_menu`
VALUES ('2', '2002');
INSERT INTO `sys_role_menu`
VALUES ('2', '2003');
INSERT INTO `sys_role_menu`
VALUES ('2', '2005');
INSERT INTO `sys_role_menu`
VALUES ('2', '2006');
INSERT INTO `sys_role_menu`
VALUES ('2', '2007');
INSERT INTO `sys_role_menu`
VALUES ('2', '2008');
INSERT INTO `sys_role_menu`
VALUES ('2', '2009');
INSERT INTO `sys_role_menu`
VALUES ('2', '2010');
INSERT INTO `sys_role_menu`
VALUES ('2', '2011');
INSERT INTO `sys_role_menu`
VALUES ('2', '2012');
INSERT INTO `sys_role_menu`
VALUES ('2', '2013');
INSERT INTO `sys_role_menu`
VALUES ('2', '2014');
INSERT INTO `sys_role_menu`
VALUES ('2', '2015');
INSERT INTO `sys_role_menu`
VALUES ('2', '2016');
INSERT INTO `sys_role_menu`
VALUES ('2', '2017');
INSERT INTO `sys_role_menu`
VALUES ('2', '2018');
INSERT INTO `sys_role_menu`
VALUES ('2', '2019');
INSERT INTO `sys_role_menu`
VALUES ('2', '2020');
INSERT INTO `sys_role_menu`
VALUES ('2', '2021');
INSERT INTO `sys_role_menu`
VALUES ('2', '2022');
INSERT INTO `sys_role_menu`
VALUES ('2', '2023');
INSERT INTO `sys_role_menu`
VALUES ('2', '2024');
INSERT INTO `sys_role_menu`
VALUES ('2', '2025');
INSERT INTO `sys_role_menu`
VALUES ('2', '2027');
INSERT INTO `sys_role_menu`
VALUES ('2', '2028');
INSERT INTO `sys_role_menu`
VALUES ('2', '2029');
INSERT INTO `sys_role_menu`
VALUES ('2', '2030');
INSERT INTO `sys_role_menu`
VALUES ('2', '2031');
INSERT INTO `sys_role_menu`
VALUES ('2', '2032');
INSERT INTO `sys_role_menu`
VALUES ('2', '2033');
INSERT INTO `sys_role_menu`
VALUES ('2', '2034');
INSERT INTO `sys_role_menu`
VALUES ('2', '2035');
INSERT INTO `sys_role_menu`
VALUES ('2', '2036');
INSERT INTO `sys_role_menu`
VALUES ('2', '2037');
INSERT INTO `sys_role_menu`
VALUES ('2', '2038');
INSERT INTO `sys_role_menu`
VALUES ('2', '2039');
INSERT INTO `sys_role_menu`
VALUES ('2', '2040');
INSERT INTO `sys_role_menu`
VALUES ('2', '2041');
INSERT INTO `sys_role_menu`
VALUES ('2', '2042');
INSERT INTO `sys_role_menu`
VALUES ('2', '2043');
INSERT INTO `sys_role_menu`
VALUES ('2', '2044');
INSERT INTO `sys_role_menu`
VALUES ('2', '2045');
INSERT INTO `sys_role_menu`
VALUES ('2', '2046');
INSERT INTO `sys_role_menu`
VALUES ('2', '2047');
INSERT INTO `sys_role_menu`
VALUES ('2', '2048');
INSERT INTO `sys_role_menu`
VALUES ('2', '2049');
INSERT INTO `sys_role_menu`
VALUES ('2', '2050');
INSERT INTO `sys_role_menu`
VALUES ('2', '2051');
INSERT INTO `sys_role_menu`
VALUES ('2', '2052');
INSERT INTO `sys_role_menu`
VALUES ('2', '2053');
INSERT INTO `sys_role_menu`
VALUES ('2', '2054');
INSERT INTO `sys_role_menu`
VALUES ('2', '2055');
INSERT INTO `sys_role_menu`
VALUES ('2', '2056');
INSERT INTO `sys_role_menu`
VALUES ('2', '2057');
INSERT INTO `sys_role_menu`
VALUES ('2', '2058');
INSERT INTO `sys_role_menu`
VALUES ('2', '2059');
INSERT INTO `sys_role_menu`
VALUES ('2', '2060');
INSERT INTO `sys_role_menu`
VALUES ('2', '2061');
INSERT INTO `sys_role_menu`
VALUES ('2', '2062');
INSERT INTO `sys_role_menu`
VALUES ('2', '2063');
INSERT INTO `sys_role_menu`
VALUES ('2', '2064');
INSERT INTO `sys_role_menu`
VALUES ('2', '2065');
INSERT INTO `sys_role_menu`
VALUES ('2', '2066');
INSERT INTO `sys_role_menu`
VALUES ('2', '2067');
INSERT INTO `sys_role_menu`
VALUES ('2', '2068');
INSERT INTO `sys_role_menu`
VALUES ('2', '2069');
INSERT INTO `sys_role_menu`
VALUES ('2', '2070');
INSERT INTO `sys_role_menu`
VALUES ('2', '2071');
INSERT INTO `sys_role_menu`
VALUES ('2', '2072');
INSERT INTO `sys_role_menu`
VALUES ('2', '2073');
INSERT INTO `sys_role_menu`
VALUES ('2', '2074');
INSERT INTO `sys_role_menu`
VALUES ('2', '2075');
INSERT INTO `sys_role_menu`
VALUES ('2', '2076');
INSERT INTO `sys_role_menu`
VALUES ('2', '2077');
INSERT INTO `sys_role_menu`
VALUES ('2', '2078');
INSERT INTO `sys_role_menu`
VALUES ('2', '2079');
INSERT INTO `sys_role_menu`
VALUES ('2', '2080');
INSERT INTO `sys_role_menu`
VALUES ('2', '2081');
INSERT INTO `sys_role_menu`
VALUES ('2', '2082');
INSERT INTO `sys_role_menu`
VALUES ('2', '2083');
INSERT INTO `sys_role_menu`
VALUES ('2', '2084');
INSERT INTO `sys_role_menu`
VALUES ('2', '2085');
INSERT INTO `sys_role_menu`
VALUES ('2', '2086');
INSERT INTO `sys_role_menu`
VALUES ('2', '2087');
INSERT INTO `sys_role_menu`
VALUES ('2', '2088');
INSERT INTO `sys_role_menu`
VALUES ('2', '2089');
INSERT INTO `sys_role_menu`
VALUES ('2', '2090');
INSERT INTO `sys_role_menu`
VALUES ('2', '2091');
INSERT INTO `sys_role_menu`
VALUES ('2', '2092');
INSERT INTO `sys_role_menu`
VALUES ('2', '2094');
INSERT INTO `sys_role_menu`
VALUES ('2', '2095');
INSERT INTO `sys_role_menu`
VALUES ('2', '2096');
INSERT INTO `sys_role_menu`
VALUES ('2', '2097');
INSERT INTO `sys_role_menu`
VALUES ('2', '2098');
INSERT INTO `sys_role_menu`
VALUES ('2', '2099');
INSERT INTO `sys_role_menu`
VALUES ('2', '2100');
INSERT INTO `sys_role_menu`
VALUES ('2', '2101');
INSERT INTO `sys_role_menu`
VALUES ('2', '2102');
INSERT INTO `sys_role_menu`
VALUES ('2', '2103');
INSERT INTO `sys_role_menu`
VALUES ('2', '2104');
INSERT INTO `sys_role_menu`
VALUES ('2', '2105');
INSERT INTO `sys_role_menu`
VALUES ('2', '2106');
INSERT INTO `sys_role_menu`
VALUES ('2', '2107');
INSERT INTO `sys_role_menu`
VALUES ('2', '2108');
INSERT INTO `sys_role_menu`
VALUES ('2', '2109');
INSERT INTO `sys_role_menu`
VALUES ('2', '2110');
INSERT INTO `sys_role_menu`
VALUES ('2', '2112');
INSERT INTO `sys_role_menu`
VALUES ('2', '2113');
INSERT INTO `sys_role_menu`
VALUES ('2', '2114');
INSERT INTO `sys_role_menu`
VALUES ('2', '2115');
INSERT INTO `sys_role_menu`
VALUES ('2', '2116');
INSERT INTO `sys_role_menu`
VALUES ('2', '2117');
INSERT INTO `sys_role_menu`
VALUES ('2', '2118');
INSERT INTO `sys_role_menu`
VALUES ('2', '2119');
INSERT INTO `sys_role_menu`
VALUES ('2', '2120');
INSERT INTO `sys_role_menu`
VALUES ('2', '2121');
INSERT INTO `sys_role_menu`
VALUES ('2', '2122');
INSERT INTO `sys_role_menu`
VALUES ('2', '2123');
INSERT INTO `sys_role_menu`
VALUES ('2', '2127');
INSERT INTO `sys_role_menu`
VALUES ('2', '2128');
INSERT INTO `sys_role_menu`
VALUES ('2', '2129');
INSERT INTO `sys_role_menu`
VALUES ('2', '2130');
INSERT INTO `sys_role_menu`
VALUES ('2', '2131');
INSERT INTO `sys_role_menu`
VALUES ('2', '2132');
INSERT INTO `sys_role_menu`
VALUES ('2', '2133');
INSERT INTO `sys_role_menu`
VALUES ('2', '2134');
INSERT INTO `sys_role_menu`
VALUES ('2', '2135');
INSERT INTO `sys_role_menu`
VALUES ('2', '2136');
INSERT INTO `sys_role_menu`
VALUES ('2', '2137');
INSERT INTO `sys_role_menu`
VALUES ('2', '2138');
INSERT INTO `sys_role_menu`
VALUES ('2', '2139');
INSERT INTO `sys_role_menu`
VALUES ('2', '2140');
INSERT INTO `sys_role_menu`
VALUES ('2', '2141');
INSERT INTO `sys_role_menu`
VALUES ('2', '2142');
INSERT INTO `sys_role_menu`
VALUES ('2', '2143');
INSERT INTO `sys_role_menu`
VALUES ('2', '2144');
INSERT INTO `sys_role_menu`
VALUES ('2', '2145');
INSERT INTO `sys_role_menu`
VALUES ('7', '1');
INSERT INTO `sys_role_menu`
VALUES ('7', '2');
INSERT INTO `sys_role_menu`
VALUES ('7', '3');
INSERT INTO `sys_role_menu`
VALUES ('7', '100');
INSERT INTO `sys_role_menu`
VALUES ('7', '101');
INSERT INTO `sys_role_menu`
VALUES ('7', '102');
INSERT INTO `sys_role_menu`
VALUES ('7', '103');
INSERT INTO `sys_role_menu`
VALUES ('7', '104');
INSERT INTO `sys_role_menu`
VALUES ('7', '105');
INSERT INTO `sys_role_menu`
VALUES ('7', '106');
INSERT INTO `sys_role_menu`
VALUES ('7', '107');
INSERT INTO `sys_role_menu`
VALUES ('7', '108');
INSERT INTO `sys_role_menu`
VALUES ('7', '109');
INSERT INTO `sys_role_menu`
VALUES ('7', '110');
INSERT INTO `sys_role_menu`
VALUES ('7', '111');
INSERT INTO `sys_role_menu`
VALUES ('7', '112');
INSERT INTO `sys_role_menu`
VALUES ('7', '113');
INSERT INTO `sys_role_menu`
VALUES ('7', '114');
INSERT INTO `sys_role_menu`
VALUES ('7', '115');
INSERT INTO `sys_role_menu`
VALUES ('7', '500');
INSERT INTO `sys_role_menu`
VALUES ('7', '501');
INSERT INTO `sys_role_menu`
VALUES ('7', '1000');
INSERT INTO `sys_role_menu`
VALUES ('7', '1001');
INSERT INTO `sys_role_menu`
VALUES ('7', '1002');
INSERT INTO `sys_role_menu`
VALUES ('7', '1003');
INSERT INTO `sys_role_menu`
VALUES ('7', '1004');
INSERT INTO `sys_role_menu`
VALUES ('7', '1005');
INSERT INTO `sys_role_menu`
VALUES ('7', '1006');
INSERT INTO `sys_role_menu`
VALUES ('7', '1007');
INSERT INTO `sys_role_menu`
VALUES ('7', '1008');
INSERT INTO `sys_role_menu`
VALUES ('7', '1009');
INSERT INTO `sys_role_menu`
VALUES ('7', '1010');
INSERT INTO `sys_role_menu`
VALUES ('7', '1011');
INSERT INTO `sys_role_menu`
VALUES ('7', '1012');
INSERT INTO `sys_role_menu`
VALUES ('7', '1013');
INSERT INTO `sys_role_menu`
VALUES ('7', '1014');
INSERT INTO `sys_role_menu`
VALUES ('7', '1015');
INSERT INTO `sys_role_menu`
VALUES ('7', '1016');
INSERT INTO `sys_role_menu`
VALUES ('7', '1017');
INSERT INTO `sys_role_menu`
VALUES ('7', '1018');
INSERT INTO `sys_role_menu`
VALUES ('7', '1019');
INSERT INTO `sys_role_menu`
VALUES ('7', '1020');
INSERT INTO `sys_role_menu`
VALUES ('7', '1021');
INSERT INTO `sys_role_menu`
VALUES ('7', '1022');
INSERT INTO `sys_role_menu`
VALUES ('7', '1023');
INSERT INTO `sys_role_menu`
VALUES ('7', '1024');
INSERT INTO `sys_role_menu`
VALUES ('7', '1025');
INSERT INTO `sys_role_menu`
VALUES ('7', '1026');
INSERT INTO `sys_role_menu`
VALUES ('7', '1027');
INSERT INTO `sys_role_menu`
VALUES ('7', '1028');
INSERT INTO `sys_role_menu`
VALUES ('7', '1029');
INSERT INTO `sys_role_menu`
VALUES ('7', '1030');
INSERT INTO `sys_role_menu`
VALUES ('7', '1031');
INSERT INTO `sys_role_menu`
VALUES ('7', '1032');
INSERT INTO `sys_role_menu`
VALUES ('7', '1033');
INSERT INTO `sys_role_menu`
VALUES ('7', '1034');
INSERT INTO `sys_role_menu`
VALUES ('7', '1035');
INSERT INTO `sys_role_menu`
VALUES ('7', '1036');
INSERT INTO `sys_role_menu`
VALUES ('7', '1037');
INSERT INTO `sys_role_menu`
VALUES ('7', '1038');
INSERT INTO `sys_role_menu`
VALUES ('7', '1039');
INSERT INTO `sys_role_menu`
VALUES ('7', '1040');
INSERT INTO `sys_role_menu`
VALUES ('7', '1041');
INSERT INTO `sys_role_menu`
VALUES ('7', '1042');
INSERT INTO `sys_role_menu`
VALUES ('7', '1043');
INSERT INTO `sys_role_menu`
VALUES ('7', '1044');
INSERT INTO `sys_role_menu`
VALUES ('7', '1045');
INSERT INTO `sys_role_menu`
VALUES ('7', '1046');
INSERT INTO `sys_role_menu`
VALUES ('7', '1047');
INSERT INTO `sys_role_menu`
VALUES ('7', '1048');
INSERT INTO `sys_role_menu`
VALUES ('7', '1049');
INSERT INTO `sys_role_menu`
VALUES ('7', '1050');
INSERT INTO `sys_role_menu`
VALUES ('7', '1051');
INSERT INTO `sys_role_menu`
VALUES ('7', '1052');
INSERT INTO `sys_role_menu`
VALUES ('7', '1053');
INSERT INTO `sys_role_menu`
VALUES ('7', '1054');
INSERT INTO `sys_role_menu`
VALUES ('7', '1055');
INSERT INTO `sys_role_menu`
VALUES ('7', '1056');
INSERT INTO `sys_role_menu`
VALUES ('7', '1057');
INSERT INTO `sys_role_menu`
VALUES ('7', '1058');
INSERT INTO `sys_role_menu`
VALUES ('7', '1059');
INSERT INTO `sys_role_menu`
VALUES ('7', '1060');
INSERT INTO `sys_role_menu`
VALUES ('7', '1061');
INSERT INTO `sys_role_menu`
VALUES ('7', '2000');
INSERT INTO `sys_role_menu`
VALUES ('7', '2001');
INSERT INTO `sys_role_menu`
VALUES ('7', '2002');
INSERT INTO `sys_role_menu`
VALUES ('7', '2003');
INSERT INTO `sys_role_menu`
VALUES ('7', '2004');
INSERT INTO `sys_role_menu`
VALUES ('7', '2005');
INSERT INTO `sys_role_menu`
VALUES ('7', '2006');
INSERT INTO `sys_role_menu`
VALUES ('7', '2007');
INSERT INTO `sys_role_menu`
VALUES ('7', '2008');
INSERT INTO `sys_role_menu`
VALUES ('7', '2009');
INSERT INTO `sys_role_menu`
VALUES ('7', '2010');
INSERT INTO `sys_role_menu`
VALUES ('7', '2011');
INSERT INTO `sys_role_menu`
VALUES ('7', '2012');
INSERT INTO `sys_role_menu`
VALUES ('7', '2013');
INSERT INTO `sys_role_menu`
VALUES ('7', '2014');
INSERT INTO `sys_role_menu`
VALUES ('7', '2015');
INSERT INTO `sys_role_menu`
VALUES ('7', '2016');
INSERT INTO `sys_role_menu`
VALUES ('7', '2017');
INSERT INTO `sys_role_menu`
VALUES ('7', '2018');
INSERT INTO `sys_role_menu`
VALUES ('7', '2019');
INSERT INTO `sys_role_menu`
VALUES ('7', '2020');
INSERT INTO `sys_role_menu`
VALUES ('7', '2021');
INSERT INTO `sys_role_menu`
VALUES ('7', '2022');
INSERT INTO `sys_role_menu`
VALUES ('7', '2023');
INSERT INTO `sys_role_menu`
VALUES ('7', '2024');
INSERT INTO `sys_role_menu`
VALUES ('7', '2025');
INSERT INTO `sys_role_menu`
VALUES ('7', '2026');
INSERT INTO `sys_role_menu`
VALUES ('7', '2027');
INSERT INTO `sys_role_menu`
VALUES ('7', '2028');
INSERT INTO `sys_role_menu`
VALUES ('7', '2029');
INSERT INTO `sys_role_menu`
VALUES ('7', '2030');
INSERT INTO `sys_role_menu`
VALUES ('7', '2031');
INSERT INTO `sys_role_menu`
VALUES ('7', '2032');
INSERT INTO `sys_role_menu`
VALUES ('7', '2033');
INSERT INTO `sys_role_menu`
VALUES ('7', '2034');
INSERT INTO `sys_role_menu`
VALUES ('7', '2035');
INSERT INTO `sys_role_menu`
VALUES ('7', '2036');
INSERT INTO `sys_role_menu`
VALUES ('7', '2037');
INSERT INTO `sys_role_menu`
VALUES ('7', '2038');
INSERT INTO `sys_role_menu`
VALUES ('7', '2039');
INSERT INTO `sys_role_menu`
VALUES ('7', '2040');
INSERT INTO `sys_role_menu`
VALUES ('7', '2041');
INSERT INTO `sys_role_menu`
VALUES ('7', '2042');
INSERT INTO `sys_role_menu`
VALUES ('7', '2043');
INSERT INTO `sys_role_menu`
VALUES ('7', '2044');
INSERT INTO `sys_role_menu`
VALUES ('7', '2045');
INSERT INTO `sys_role_menu`
VALUES ('7', '2046');
INSERT INTO `sys_role_menu`
VALUES ('7', '2047');
INSERT INTO `sys_role_menu`
VALUES ('7', '2048');
INSERT INTO `sys_role_menu`
VALUES ('7', '2049');
INSERT INTO `sys_role_menu`
VALUES ('7', '2050');
INSERT INTO `sys_role_menu`
VALUES ('7', '2051');
INSERT INTO `sys_role_menu`
VALUES ('7', '2052');
INSERT INTO `sys_role_menu`
VALUES ('7', '2053');
INSERT INTO `sys_role_menu`
VALUES ('7', '2054');
INSERT INTO `sys_role_menu`
VALUES ('7', '2055');
INSERT INTO `sys_role_menu`
VALUES ('7', '2056');
INSERT INTO `sys_role_menu`
VALUES ('7', '2057');
INSERT INTO `sys_role_menu`
VALUES ('7', '2058');
INSERT INTO `sys_role_menu`
VALUES ('7', '2059');
INSERT INTO `sys_role_menu`
VALUES ('7', '2060');
INSERT INTO `sys_role_menu`
VALUES ('7', '2061');
INSERT INTO `sys_role_menu`
VALUES ('7', '2062');
INSERT INTO `sys_role_menu`
VALUES ('7', '2063');
INSERT INTO `sys_role_menu`
VALUES ('7', '2064');
INSERT INTO `sys_role_menu`
VALUES ('7', '2065');
INSERT INTO `sys_role_menu`
VALUES ('7', '2066');
INSERT INTO `sys_role_menu`
VALUES ('7', '2067');
INSERT INTO `sys_role_menu`
VALUES ('7', '2068');
INSERT INTO `sys_role_menu`
VALUES ('7', '2069');
INSERT INTO `sys_role_menu`
VALUES ('7', '2070');
INSERT INTO `sys_role_menu`
VALUES ('7', '2071');
INSERT INTO `sys_role_menu`
VALUES ('7', '2072');
INSERT INTO `sys_role_menu`
VALUES ('7', '2073');
INSERT INTO `sys_role_menu`
VALUES ('7', '2074');
INSERT INTO `sys_role_menu`
VALUES ('7', '2075');
INSERT INTO `sys_role_menu`
VALUES ('7', '2076');
INSERT INTO `sys_role_menu`
VALUES ('7', '2077');
INSERT INTO `sys_role_menu`
VALUES ('7', '2078');
INSERT INTO `sys_role_menu`
VALUES ('7', '2079');
INSERT INTO `sys_role_menu`
VALUES ('7', '2080');
INSERT INTO `sys_role_menu`
VALUES ('7', '2081');
INSERT INTO `sys_role_menu`
VALUES ('7', '2082');
INSERT INTO `sys_role_menu`
VALUES ('7', '2083');
INSERT INTO `sys_role_menu`
VALUES ('7', '2084');
INSERT INTO `sys_role_menu`
VALUES ('7', '2085');
INSERT INTO `sys_role_menu`
VALUES ('7', '2086');
INSERT INTO `sys_role_menu`
VALUES ('7', '2087');
INSERT INTO `sys_role_menu`
VALUES ('7', '2088');
INSERT INTO `sys_role_menu`
VALUES ('7', '2089');
INSERT INTO `sys_role_menu`
VALUES ('7', '2090');
INSERT INTO `sys_role_menu`
VALUES ('7', '2091');
INSERT INTO `sys_role_menu`
VALUES ('7', '2092');
INSERT INTO `sys_role_menu`
VALUES ('7', '2094');
INSERT INTO `sys_role_menu`
VALUES ('7', '2095');
INSERT INTO `sys_role_menu`
VALUES ('7', '2096');
INSERT INTO `sys_role_menu`
VALUES ('7', '2097');
INSERT INTO `sys_role_menu`
VALUES ('7', '2098');
INSERT INTO `sys_role_menu`
VALUES ('7', '2099');
INSERT INTO `sys_role_menu`
VALUES ('7', '2100');
INSERT INTO `sys_role_menu`
VALUES ('7', '2101');
INSERT INTO `sys_role_menu`
VALUES ('7', '2102');
INSERT INTO `sys_role_menu`
VALUES ('7', '2103');
INSERT INTO `sys_role_menu`
VALUES ('7', '2104');
INSERT INTO `sys_role_menu`
VALUES ('7', '2105');
INSERT INTO `sys_role_menu`
VALUES ('7', '2106');
INSERT INTO `sys_role_menu`
VALUES ('7', '2107');
INSERT INTO `sys_role_menu`
VALUES ('7', '2108');
INSERT INTO `sys_role_menu`
VALUES ('7', '2109');
INSERT INTO `sys_role_menu`
VALUES ('7', '2110');
INSERT INTO `sys_role_menu`
VALUES ('7', '2112');
INSERT INTO `sys_role_menu`
VALUES ('7', '2113');
INSERT INTO `sys_role_menu`
VALUES ('7', '2114');
INSERT INTO `sys_role_menu`
VALUES ('7', '2115');
INSERT INTO `sys_role_menu`
VALUES ('7', '2116');
INSERT INTO `sys_role_menu`
VALUES ('7', '2117');
INSERT INTO `sys_role_menu`
VALUES ('7', '2118');
INSERT INTO `sys_role_menu`
VALUES ('7', '2119');
INSERT INTO `sys_role_menu`
VALUES ('7', '2120');
INSERT INTO `sys_role_menu`
VALUES ('7', '2121');
INSERT INTO `sys_role_menu`
VALUES ('7', '2122');
INSERT INTO `sys_role_menu`
VALUES ('7', '2123');
INSERT INTO `sys_role_menu`
VALUES ('7', '2127');
INSERT INTO `sys_role_menu`
VALUES ('7', '2128');
INSERT INTO `sys_role_menu`
VALUES ('7', '2129');
INSERT INTO `sys_role_menu`
VALUES ('7', '2130');
INSERT INTO `sys_role_menu`
VALUES ('7', '2131');
INSERT INTO `sys_role_menu`
VALUES ('7', '2132');
INSERT INTO `sys_role_menu`
VALUES ('7', '2133');
INSERT INTO `sys_role_menu`
VALUES ('7', '2134');
INSERT INTO `sys_role_menu`
VALUES ('7', '2135');
INSERT INTO `sys_role_menu`
VALUES ('7', '2136');
INSERT INTO `sys_role_menu`
VALUES ('7', '2137');
INSERT INTO `sys_role_menu`
VALUES ('7', '2138');
INSERT INTO `sys_role_menu`
VALUES ('7', '2139');
INSERT INTO `sys_role_menu`
VALUES ('7', '2140');
INSERT INTO `sys_role_menu`
VALUES ('7', '2141');
INSERT INTO `sys_role_menu`
VALUES ('7', '2142');
INSERT INTO `sys_role_menu`
VALUES ('7', '2143');
INSERT INTO `sys_role_menu`
VALUES ('7', '2144');
INSERT INTO `sys_role_menu`
VALUES ('7', '2145');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `user_id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id`         bigint(20) DEFAULT NULL COMMENT '部门ID',
    `login_name`      varchar(30) NOT NULL COMMENT '登录账号',
    `user_name`       varchar(30)                     DEFAULT '' COMMENT '用户昵称',
    `user_type`       varchar(2)                      DEFAULT '00' COMMENT '用户类型（00系统用户 01注册用户）',
    `email`           varchar(50)                     DEFAULT '' COMMENT '用户邮箱',
    `phonenumber`     varchar(11)                     DEFAULT '' COMMENT '手机号码',
    `sex`             char(1)                         DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
    `avatar`          varchar(100)                    DEFAULT '' COMMENT '头像路径',
    `password`        varchar(50)                     DEFAULT '' COMMENT '密码',
    `salt`            varchar(20)                     DEFAULT '' COMMENT '盐加密',
    `status`          char(1)                         DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
    `del_flag`        char(1)                         DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
    `login_ip`        varchar(128)                    DEFAULT '' COMMENT '最后登录IP',
    `login_date`      datetime                        DEFAULT NULL COMMENT '最后登录时间',
    `nation`          varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '民族',
    `year`            varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '出生年月',
    `family`          varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '家庭出生',
    `place`           varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '籍贯',
    `old_level`       varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '原有文化程度',
    `new_level`       varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '现有文化程度',
    `party_post`      varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '党内职务',
    `admin_post`      varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '行政职务',
    `work_time`       varchar(50) CHARACTER SET utf8  DEFAULT NULL COMMENT '参加工作时间',
    `job_name`        varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '职称',
    `refer`           varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '介绍人',
    `party_time`      varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '入党时间',
    `positive_time`   varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '转正时间',
    `office`          varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '科室',
    `id_card`         varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '身份证号',
    `pwd_update_date` datetime                        DEFAULT NULL COMMENT '密码最后更新时间',
    `create_by`       varchar(64)                     DEFAULT '' COMMENT '创建者',
    `create_time`     datetime                        DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)                     DEFAULT '' COMMENT '更新者',
    `update_time`     datetime                        DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(500)                    DEFAULT NULL COMMENT '备注',
    `user_file`       varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人履历',
    `file_name`       varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '履历文件名称',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES ('1', '101', 'admin', '管理员', '00', 'ry@163.com', '15888888888', '男', '', '29c67a30398638269fe600f73a054934',
        '111111', '0', '0', '127.0.0.1', '2024-11-12 16:52:35', '汉', '1963.05', '贫农', '云县', '大专', '大专', '',
        '主任', '1983.09', '主任', '', '1996-10-18', '1997-10-18', '', '', null, 'admin', '2024-11-12 16:09:48', '',
        '2024-11-12 16:52:34', '管理员', null, null);
INSERT INTO `sys_user`
VALUES ('107', '101', '沈天行', '沈天行', '00', '', '13864548321', '男', '', 'd828bf683bbdfa54c695cb8fc63ede33',
        'f0f238', '0', '2', '27.27.20.7', null, '汉', '1963.05', '贫农', '云县', '中专', '大专', '支部书记',
        '输血科主任', '1983.09', '主任', '俸新荣', '1996-10-18', '1997-10-18', '输血科', '53352382339494949', null,
        'admin', '2024-11-12 16:09:48', '', null, '测试员', null, null);
INSERT INTO `sys_user`
VALUES ('198', '200', '李梅', '李梅', '00', '', '13834564335', '女', '', 'd5c8b28fcb130a65f66812d876447eb1', '96c960',
        '0', '0', '27.27.20.7', null, '汉', '1970.06', '湖北', '湖北', '大学', '大学', '支部', '输血科主任',
        'Sat Mar 02 00:00:00 CST 1996', '主任', '张', '1998-05-06', '1999-02-03', '输血科', '420634854954533', null, '',
        null, '', null, null, null, null);
INSERT INTO `sys_user`
VALUES ('199', '200', '123', '123', '00', '', '18827529696', '1', '', '4a278806f19f06a2ca1cb517892ade62', '054841', '0',
        '0', '', null, '', '1', '', '1', '1', '', '', '', '1', '1', '', '2020-08-05', '2020-08-19', '1', '1', null, '',
        null, '', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user_online
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_online`;
CREATE TABLE `sys_user_online`
(
    `sessionId`        varchar(50) NOT NULL DEFAULT '' COMMENT '用户会话id',
    `login_name`       varchar(50)          DEFAULT '' COMMENT '登录账号',
    `dept_name`        varchar(50)          DEFAULT '' COMMENT '部门名称',
    `ipaddr`           varchar(128)         DEFAULT '' COMMENT '登录IP地址',
    `login_location`   varchar(255)         DEFAULT '' COMMENT '登录地点',
    `browser`          varchar(50)          DEFAULT '' COMMENT '浏览器类型',
    `os`               varchar(50)          DEFAULT '' COMMENT '操作系统',
    `status`           varchar(10)          DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
    `start_timestamp`  datetime             DEFAULT NULL COMMENT 'session创建时间',
    `last_access_time` datetime             DEFAULT NULL COMMENT 'session最后访问时间',
    `expire_time`      int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
    PRIMARY KEY (`sessionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='在线用户记录';

-- ----------------------------
-- Records of sys_user_online
-- ----------------------------
INSERT INTO `sys_user_online`
VALUES ('03219e71-da81-4c67-a26f-6e4cf134cc24', 'admin', '第一党小组', '127.0.0.1', '内网IP', 'Chrome 13', 'Windows 10',
        'on_line', '2024-11-12 16:44:53', '2024-11-12 16:52:35', '1800000');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`
(
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
    PRIMARY KEY (`user_id`, `post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post`
VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`
(
    `user_id` bigint(20) NOT NULL COMMENT '用户ID',
    `role_id` bigint(20) NOT NULL COMMENT '角色ID',
    PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role`
VALUES ('1', '1');
INSERT INTO `sys_user_role`
VALUES ('198', '2');
INSERT INTO `sys_user_role`
VALUES ('199', '2');

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`
(
    `article_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`         int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`         int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`       varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `article_time`    datetime     DEFAULT NULL COMMENT '分享时间',
    `article_title`   varchar(500) DEFAULT NULL COMMENT '美文标题',
    `article_content` longtext COMMENT '美文内容',
    `article_img`     longtext COMMENT '美文图片',
    `article_video`   longtext COMMENT '美文视频',
    `status`          varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`       varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='分享美文表';

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article`
VALUES ('12', '101', '107', '苗睿智', '2020-05-26 10:41:58', '人民日报批\"四风\"新表现:官僚主义造成新形式主义',
        '<p><img src=\"http://io.hllincheng.cn/Fug0coMqYkriJ2lzUxjJvtbMfoTI\" data-filename=\"2020/06/09/35cab1744ccb9d9b796b4312ecfdc3aa.jpg\" style=\"width: 100%;\">人民日报批\"四风\"新表现:官僚主义造成新形式主义\r\n　　“纠正‘四风’不能止步，作风建设永远在路上”。近日，习近平总书记就形式主义、官僚主义新表现作出指示，要求抓住主要矛盾，针对突出问题，拿出过硬措施，扎扎实实地改。\r\n　　为深入学习贯彻习近平总书记指示精神，人民日报今起推出“坚决纠正‘四风’新表现”系列评论，探讨表象与根源，剖析问题与对策，探索持之以恒正风肃纪的途径和方式，与广大读者一起激荡清风、塑造新风。\r\n　　——编者\r\n　　“踢皮球、打太极、拖字诀还是不少。”“小鬼难缠，办事难只是换了个马甲。”“脸不失微笑，门始终敞开，可事就是不办。”翻看我们刊发过的干部群众反映“四风”问题的投稿，“新衙门作风”占了不少篇幅。\r\n　　落实习近平总书记的重要指示，坚决防止不良风气反弹回潮，“门好进、脸好看、事难办”的服务作风问题，是一个重点整改内容。“门难进、脸难看、话难听”等服务作风老问题，好比如芒在背的硬钉子，容易发现，清理也不算难；“只微笑不办事”“不贪不占也不干”“能推则推，能躲就躲”等“四风”新表现，则像干部群众所形容的，是如鲠在喉的软钉子，更加隐蔽、更难甄别、更难拔除。\r\n　　为什么会“脸好看，事难办”？这是因为，脸好看容易，是面子工程；事好办相对比较难，也是里子工程。这样一个难易、里外的对比，不难看出，背后是一种“官僚主义导致的形式主义”。这里说的官僚主义，是那种只唯领导、不管群众的为官心态，是那种只顾表面、不顾实效的价值排序，是割裂了对党负责和对群众负责，是离散了政策措施的初衷、执行和效果。有当官心态而没有为民心态，才会不办事或者不好好办事，只是把“脸好看”变成一种免责工具、当做一种考核绩效、视为一种政治正确而已。因为心态上的官僚主义，而导致了行动上的形式主义。\r\n　　如果说“四风”是隔开党和群众无形的墙，那么办事难这个老问题的新表现，则可谓是拦在作风改进之路上的笑面虎。支持创业嘘寒问暖却不解决实际问题，创业者步履维艰；以“清”为名对企业家敬而远之，民营企业在坐等中错失机遇；脱贫项目“嗷嗷待哺”，扶贫资金却长期趴窝不动……服务作风不严不实，实际难题不管不问，政策执行就会出现“两种温度”：上级温度高、决心大、力度大，到了基层温度层层递减、力度绵软无力；政策效果便会产生“两种感受”：政府部门自我感觉良好，老百姓的实际获得感却寥寥可数。长此以往，埋单的必然是党群关系，受阻的必然是改革发展步伐。\r\n　　“天下事，以实则治，以文则不治。”口号喊得响亮不如把事办得敞亮。说实话，事情不好办，原因很多。有时候是流程繁杂，盖个章得跑断腿；有时候是分工不明，你推我来我推他。不管是客观的方式方法问题，还是主观的思想作风问题，说到底，结果都是一样的，那就是事情不好办、群众不满意。所以，脸好看了只是开始，最终还要优化流程、明确分工，提高服务水平和办事能力，真正让群众满意，否则笑脸也不过是一种形式主义。以讲效率、抓落实，办实事、求实效的好效果检验好作风，人民群众的信任和支持才会水涨船高。正如中央一再强调的，不解决问题就是最大的形式主义；群众满不满意，是检验作风建设的唯一标准。\r\n　　有读者来信，热情称赞有关部门“拆掉围墙”“敞开办公室大门”的举措，因为这向群众释放了便民服务的善意。不患无策，只怕无心。敞开真心真意、全心全意为群众服务的大门、心门，才能防止“门虽设而常关”，疏远了党和政府同人民群众的距离。反“四风”既要改面子，更需换里子，作风改到深处是在思想和灵魂上动手术。十九大报告对持之以恒正风肃纪划定“全称要求”：“凡是群众反映强烈的问题都要严肃认真对待，凡是损害群众利益的行为都要坚决纠正”。往思想教育的熔炉中持续添火，拧紧刚性约束的螺丝扣，清除思想中的微生物，才能实现从“不敢”“不能”到“不想”的深层次转变。\r\n　　上世纪90年代初市场经济大门刚刚开启，福建福州开发区因为管理体制不顺、部门工作效率不高，导致招商引资成效不彰。现场办公会上时任福州市委书记的习近平提出，“马尾的事，特事特办，马上就办”。“马上就办”成为福州打造效能政府、加强作风建设的突破口。新时代新起点，无论实现经济高质量增长还是不断满足人民日益增长的美好生活需要，都比以往任何时候更需要优良服务作风的托举。“新时代要有新气象，更要有新作为”，让“事好办”成趋势，让“办好事”更普遍，正是新气象、新作为的直接检验。</p>',
        null, null, '0', '', '2020-05-26 10:41:59', '', '2020-06-09 08:30:35', null);

-- ----------------------------
-- Table structure for tb_award
-- ----------------------------
DROP TABLE IF EXISTS `tb_award`;
CREATE TABLE `tb_award`
(
    `award_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `award_title`   varchar(255) DEFAULT NULL COMMENT '奖项标题',
    `award_pic`     varchar(500) DEFAULT NULL COMMENT '封面图',
    `award_content` longtext COMMENT '奖项内容',
    `status`        varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`     varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`   datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`award_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖项表 ';

-- ----------------------------
-- Records of tb_award
-- ----------------------------

-- ----------------------------
-- Table structure for tb_collect
-- ----------------------------
DROP TABLE IF EXISTS `tb_collect`;
CREATE TABLE `tb_collect`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     int(20) DEFAULT NULL COMMENT '用户id',
    `new_id`      int(20) DEFAULT NULL COMMENT '学习id',
    `status`      varchar(2)   DEFAULT '1' COMMENT '状态',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='学习收藏表';

-- ----------------------------
-- Records of tb_collect
-- ----------------------------
INSERT INTO `tb_collect`
VALUES ('6', '1', '90', '1', '', '2020-08-11 10:40:02', '', null, null);

-- ----------------------------
-- Table structure for tb_deed
-- ----------------------------
DROP TABLE IF EXISTS `tb_deed`;
CREATE TABLE `tb_deed`
(
    `deed_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `deed_title`   varchar(255) DEFAULT NULL COMMENT '事迹标题',
    `deed_pic`     varchar(500) DEFAULT NULL COMMENT '封面图',
    `deed_content` longtext COMMENT '事迹内容',
    `status`       varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`deed_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='事迹表';

-- ----------------------------
-- Records of tb_deed
-- ----------------------------
INSERT INTO `tb_deed`
VALUES ('9', '疫情防控先进个人---李海龙', 'http://io.hllincheng.cn/lp6p6s9d-939VnUCCyNh8G2u1wOY',
        '<p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">李海龙同志，男，现年</font>31岁，2015年参加工作，现为延安市强制隔离戒毒所管教三大队民警。自参加工作以来，一直都默默耕耘，无私奉献，</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">长期战斗在工作的第一线，</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">得到同事和领导的认可。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">戒毒场所就像一个围城，都说戒毒场所的民警要耐得住孤独、守得住寂寞</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">。面对日复一日的工作，他</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">一干就是</font>5年</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">，始终坚守在自己的岗位，把平凡的工作做到不平凡。始终</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">坚持依法、科学、人性化管理，坚持</font>“用法、用情、用心”来感化“顽石”，平均每月与戒毒人员进行个别谈话近</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\">150</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">人次，教育矫治强制隔离戒毒人员多达数千人。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">在长期的工作中，与同事以及戒毒人员都建立起了彼此的信任。生活中，帮助同事，工作中，解决戒毒人员遇到的各种困难。是同事的好帮手，是戒毒人员的知心人。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">在此次疫情爆发后，更是第一时间主动请缨参战我所第一批次封闭监管战斗值班，战斗在防控第一线。在防控工作中，</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">他</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">始终能够以大无畏的精神，顾全大局、坚守初心、勇担使命，充分发挥战斗模范作用，冲锋在前，恪尽职守，无私奉献，连续战斗在疫情防控第一线，用热血和汗水谱写出戒毒监管民警的壮丽诗篇。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">在防控期间，他为了缓解戒毒人员恐慌焦躁的情绪，每日为戒毒人员普及防疫知识，通报全国疫情的最新动态，并每日对戒毒人员测量体温和对监区进行消毒，及时掌握戒毒人员心理和健康状况。同时罗列重点人员，根据不同情况妥善处理。为进一步保障戒毒所疫情期间的安全稳定献出了一份力。与此同时，他的妻子也在自己的战斗岗位上连续战斗十几个昼夜了。原本他们计划今年一定要为家里添丁入口，然而聚少离多的工作性质和突如其来的疫情，让他们的计划不得不无限期延迟。要知道，他的战斗岗位离爱人的战斗岗位只有数十公里，在当今迅捷的交通下这叫距离吗！然而，他们选择深入战</font>“疫”一线，守护一方平安，为这场战“疫”奉献着自己的力量，他和他的爱人就是防疫战中的两位“战士”，尽管，他们近在咫尺，却因抗“疫”斗争相隔天涯。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">他是个少言寡语的人，不擅表达，只能用默默的行动在说话。面对疫情、迎难而上、冲锋在前，兑现人民警察</font>“随时准备为党和人民牺牲一切”的庄严承诺。战争尚未结束，他久久为功、始终如一地认真细致的检查监区安全防控工作，全程观察测量戒毒学员健康体征，一丝不苟的按照规范进行消毒操作；生活中，无微不至地对戒毒学员生活照顾，一日三餐，污物处理，事无巨细；耐心地对戒毒学员进行心理安抚，疏导不良情绪；及时的通过戒毒学员家属微信群安抚家属们的担心情绪。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;line-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">他始终坚信，发扬吃苦耐劳、艰苦奋斗的延安精神，继续坚守在战</font>“疫”一线，通过自己和战友们的不懈努力，定能取得防疫攻坚战的最终胜利，扬我圣地铁警雄风！</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-autospace:ideograph-numeric;mso-pagination:none;line-height:28.0000pt;\r\nmso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p>&nbsp;</o:p></span></p>',
        '0', '梁美东', '2020-06-01 08:10:09', '', null, null);

-- ----------------------------
-- Table structure for tb_exchange
-- ----------------------------
DROP TABLE IF EXISTS `tb_exchange`;
CREATE TABLE `tb_exchange`
(
    `exchange_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `exchange_title`   varchar(255) DEFAULT NULL COMMENT '交流标题',
    `exchange_pic`     varchar(500) DEFAULT NULL COMMENT '封面图',
    `exchange_content` longtext COMMENT '交流内容',
    `status`           varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`        varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`        varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`      datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`           varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`exchange_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交流表';

-- ----------------------------
-- Records of tb_exchange
-- ----------------------------

-- ----------------------------
-- Table structure for tb_feel
-- ----------------------------
DROP TABLE IF EXISTS `tb_feel`;
CREATE TABLE `tb_feel`
(
    `feel_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`      int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`      int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`    varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `feel_time`    datetime     DEFAULT NULL COMMENT '提交时间',
    `feel_title`   varchar(255) DEFAULT NULL COMMENT '标题',
    `feel_content` longtext COMMENT '内容',
    `feel_img`     longtext COMMENT '图片',
    `feel_video`   longtext COMMENT '视频',
    `status`       varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`feel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='心得体会表';

-- ----------------------------
-- Records of tb_feel
-- ----------------------------
INSERT INTO `tb_feel`
VALUES ('7', '101', '107', '张娟', '2020-05-26 10:06:57', '《习近平总书记来陕考察》学习心得       张静',
        '<p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\"><span style=\"mso-spacerun:\'yes\';font-family:宋体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:22.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"宋体\">《习近平总书记来陕考察》学习心得</font></span><span style=\"mso-spacerun:\'yes\';font-family:宋体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:22.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\"><span style=\"mso-spacerun:\'yes\';font-family:楷体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"楷体\">第一党小组</font> &nbsp;<font face=\"楷体\">张</font> &nbsp;<font face=\"楷体\">静</font></span><span style=\"mso-spacerun:\'yes\';font-family:楷体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"center\" style=\"text-align:center;\"><span style=\"mso-spacerun:\'yes\';font-family:楷体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"楷体\">（</font>2020年4月27日）</span><span style=\"mso-spacerun:\'yes\';font-family:楷体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent: 32pt;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">2020年4月24日晚，第三封闭值班分队的战友们一起在多媒体会议室观看了《习近平总书记来陕考察》的视频。习总书记此行陕西，先后来到商洛、安康、西安等地，深入自然保护区、贫困山区、社区、学校、企业等，了解秦岭生态环境保护、脱贫攻坚、复工复产等情况，还亲自为“柞水木耳”做了推广。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent: 32pt;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">陕西是中华民族和华夏文明的发祥地之一，也是中国革命文化的重要传承地之一。此次来陕考察，总书记特别强调了两种精神：一是</font>“西迁精神，”另一个就是“延安精神”。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent: 32pt;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">“西迁精神”的核心是爱国主义，精髓是听党指挥跟党走，与党和国家、与民族和人民同呼吸共命运。历史证明，在共产党的领导下，我们取得了了一个又一个胜利，今天的幸福生活也得益于一代又一代共产党人的艰苦奋斗。2020年初，我们经历了一场百年不遇的疫情，面对这突如其来的灾难，国家一声令下，万千医护人员驰援武汉，广大公安干警、社区服务者主动放弃休假，全员上岗，在这场没有硝烟的战役中，他们义无反顾、奋勇当先，共同为打赢这场抗击疫情的阻击战奋斗着。截止4月26日，武汉住院患者全部清零，我们取得了抗击疫情的阶段性胜利，这些都离不开党的坚强领导。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent: 32pt;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">“延安精神”是中国共产党创造的一种革命精神，是我们党宝贵的精神财富，广大党员干部要用延安精神滋养初心、淬炼灵魂，从中汲取信仰的力量、查找党性差距、校准前进的方向。要把政治建设摆在首位，严肃党内政治生活，严格落实中央八项规定及其实施细则，坚决破除形式主义、官僚主义，构建一体推进不敢腐、不能腐、不想腐体制机制，为各项事业发展提供坚强保障。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent: 32pt;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">新时代，我们要继续发扬党的这些优秀精神，在不断学习中坚定理想信念，在实际工作中践行初心使命，为做好新时代延安戒毒工作奋力拼搏。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p>',
        null, null, '0', '', '2020-05-26 10:06:59', '', '2020-06-01 13:32:56', null);

-- ----------------------------
-- Table structure for tb_inspect
-- ----------------------------
DROP TABLE IF EXISTS `tb_inspect`;
CREATE TABLE `tb_inspect`
(
    `inspect_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `inspect_title`   varchar(255) DEFAULT NULL COMMENT '视察标题',
    `inspect_pic`     varchar(500) DEFAULT NULL COMMENT '封面图',
    `inspect_content` longtext COMMENT '视察内容',
    `status`          varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`       varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`inspect_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视察表';

-- ----------------------------
-- Records of tb_inspect
-- ----------------------------

-- ----------------------------
-- Table structure for tb_learn
-- ----------------------------
DROP TABLE IF EXISTS `tb_learn`;
CREATE TABLE `tb_learn`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     int(20) DEFAULT NULL COMMENT '用户id',
    `user_name`   varchar(255) DEFAULT NULL COMMENT '用户姓名',
    `type`        varchar(1)   DEFAULT NULL COMMENT '学分类型 (1 学习 2 签到)',
    `new_id`      int(20) DEFAULT NULL COMMENT '资讯id',
    `status`      varchar(20)  DEFAULT '1' COMMENT '状态 (1 未学习 (未签到) 2 已学习 (已签到))',
    `score`       int(255) DEFAULT NULL COMMENT '学分',
    `sign_time`   varchar(255) DEFAULT NULL COMMENT '签到时间',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='学分表';

-- ----------------------------
-- Records of tb_learn
-- ----------------------------
INSERT INTO `tb_learn`
VALUES ('1', '1', null, '1', '54', '2', '1', null, '', '2020-06-06 10:38:49', '', null, null);
INSERT INTO `tb_learn`
VALUES ('78', '1', null, '1', null, '1', '1', '2020-07-09 09:21:32', '', '2020-07-09 09:21:33', '', null, null);
INSERT INTO `tb_learn`
VALUES ('79', '1', null, '1', '90', '2', '1', null, '', '2020-07-11 14:27:03', '', null, null);
INSERT INTO `tb_learn`
VALUES ('80', '1', null, '1', '90', '2', '1', null, '', '2020-07-11 14:28:15', '', null, null);
INSERT INTO `tb_learn`
VALUES ('81', '1', null, '1', '90', '2', '1', null, '', '2020-07-11 14:31:00', '', null, null);
INSERT INTO `tb_learn`
VALUES ('82', '1', null, '1', '53', '2', '1', null, '', '2020-07-25 14:38:06', '', null, null);
INSERT INTO `tb_learn`
VALUES ('83', '1', null, '1', null, '1', '1', '2020-08-03 09:01:09', '', '2020-08-03 09:01:10', '', null, null);
INSERT INTO `tb_learn`
VALUES ('84', '1', null, '1', '51', '2', '1', null, '', '2020-08-04 17:02:28', '', null, null);
INSERT INTO `tb_learn`
VALUES ('85', '1', null, '1', '55', '2', '1', null, '', '2020-08-05 19:10:43', '', null, null);
INSERT INTO `tb_learn`
VALUES ('86', '1', null, '1', null, '1', '1', '2020-08-11 10:25:08', '', '2020-08-11 10:25:09', '', null, null);

-- ----------------------------
-- Table structure for tb_light
-- ----------------------------
DROP TABLE IF EXISTS `tb_light`;
CREATE TABLE `tb_light`
(
    `light_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `light_title`   varchar(255) DEFAULT NULL COMMENT '亮点标题',
    `light_pic`     varchar(500) DEFAULT NULL COMMENT '亮点主图',
    `light_content` longtext COMMENT '亮点内容',
    `status`        varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`     varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`   datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`light_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='亮点表';

-- ----------------------------
-- Records of tb_light
-- ----------------------------
INSERT INTO `tb_light`
VALUES ('11', '亮点三   完善制度建设抓党建', 'http://io.hllincheng.cn/FrnyGSzkNBAZkMy8opKWJ3zHqAT6',
        '<p><img src=\"http://io.hllincheng.cn/FnB0Rj2NgEst3-A-cPNXW9eVrhH4\" data-filename=\"2020/06/02/25f79fbc64271de37eacea2e4b4c06e4.png\" style=\"width: 100%;\"></p><p><img src=\"http://io.hllincheng.cn/lkr7yGzZ6QNhX_Y3NeepcBUGPW4y\" data-filename=\"2020/06/02/c9894175245c2c9f0536c0c0d6e00b9b.JPG\" style=\"width: 100%;\"></p><p><img src=\"http://io.hllincheng.cn/ljm7QgHJt9TeiNtMVG_KSGs9fHN7\" data-filename=\"2020/06/02/ed2885d14176157fedffb1e87b27b75e.JPG\" style=\"width: 100%;\"></p><p class=\"MsoNormal\" style=\"text-align: center; \"><span style=\"mso-spacerun:\'yes\';font-family:黑体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"黑体\">党建引领，队伍凝聚力、战斗力不断提高。</font></span><span style=\"mso-spacerun:\'yes\';font-family:黑体;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">按照中央</font>“两学一做常态化、制度化”建设总体要求，以党组织“四化”建设为标准，严格贯彻落实“三项机制”，努力实现党建引领促队伍建设追赶超越的良好局面。 </span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.2500pt;mso-list:l0 level1 lfo1;\"><!--[if !supportLists]--><span style=\"font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';font-weight:bold;\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">（一）</span><!--[endif]--><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">建设标准化。</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">党员活动室标准化。以规范化、标准化为目标，严格按照</font>“完善功能、一室多用”标准建设，安装电化教育设施，为学习教育的高效开展提供了硬件保障，为我所所党建工作规范化和党建工作整体水平提高起到了积极的推动作用。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.2500pt;\"><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">（二）组织合理化。</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">针对戒毒工作的特殊性，为进一步抓实党建工作，把党员按岗位和轮值模式分为</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">五</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">个党小组，各党小组切实按照日学习、日讨论要求进行学习交流，解决了过去集中学习不便开展的瓶颈问题。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:31.5000pt;mso-char-indent-count:1.9600;\"><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">（三）形式多样化。一是</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">所内距离市区</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">40</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">公里，每日上下班往返需至少两个小时车程，为解决</font>“工学”矛盾，合理利用时间，所内专门在通勤车上安装车载</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">DV,</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">播放</font>“党章党规，系列讲话”及党的相关知识音视频资料，大幅提升了党员素质；</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">二</font></span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">是</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">严格落实</font>“三会一课”制度，扎实开展了“党员民警大讨论”“三个课堂”“走进七大会址”</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">、开展</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">“</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">不忘初心、</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">牢记使命</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">”主题</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">教育</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">，深化</font>“忠诚、干净、担当”三堂课教育活动，坚定党员民警政治立场，强化党性修养；</span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">四是</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">组织召开民主生活会。以党小组为单位，所有党员民警、积极分子等均参加民主生活会，所领导以普通党员身份参加了民主生活会，带头深入开展批评与自我批评。增强了党员队伍的先进性和纯洁性，促使教育矫治工作更上一台阶。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">&nbsp;</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.2500pt;\"><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">（四）党课常态化。</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">所内党支部提出</font>“党员讲党课、人人谈感受”主题活动，每名党员轮流讲党课，每次党课后人人谈体会，提升了党员民警素质，提高了队伍凝聚力、向心力、战斗力。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" style=\"text-indent:32.1500pt;mso-char-indent-count:2.0000;\"><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">（五）宣传信息化。</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">加大了两学一做宣传教育力度，</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\">&nbsp;</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">利用公安内网，在所内、市局、省厅网页推送两学一做专题宣传</font></span><b><span style=\"font-family: 仿宋; color: rgb(255, 0, 0); font-size: 16pt;\">19</span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">篇，在所内微信公众号推送</font></span><b><span style=\"font-family: 仿宋; color: rgb(255, 0, 0); font-size: 16pt;\">89</span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><font face=\"仿宋\">篇，增强了教育活动的多样性、渗透性，让</font>“不忘初心 牢记使命”主题教育学习走进党员民警心中。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:\'Times New Roman\';\r\nfont-size:16.0000pt;mso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"16\" style=\"margin-top:0.0000pt;margin-bottom:0.0000pt;line-height:28.0000pt;\r\nmso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\">&nbsp;&nbsp;&nbsp;&nbsp;<font face=\"仿宋\">党建工作多措并举，推动所内民警个人修养和队伍整体素质实现</font></span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">四个显著提升</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\"><font face=\"仿宋\">：班子及民警之间主动沟通、高度配合、齐心协力干事业劲头</font></span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">显著提升</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\"><font face=\"仿宋\">；团队精神和团队力量充分发挥，民警凝聚力、战斗力和向心力</font></span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">显著提升</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\"><font face=\"仿宋\">；民警衡量工作的标准、爱所如家的意识</font></span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">显著提升</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\"><font face=\"仿宋\">；</font>“扎根场所、建功立业”的干事创业意识</span><b><span style=\"font-family: 仿宋; font-size: 16pt;\"><font face=\"仿宋\">显著提升</font></span></b><span style=\"mso-spacerun:\'yes\';font-family:仿宋;mso-bidi-font-family:宋体;\r\nfont-size:16.0000pt;mso-font-kerning:0.0000pt;\"><font face=\"仿宋\">。为各项戒毒业务工作的高效开展奠定了坚实基础。</font></span><span style=\"font-family: 仿宋; font-size: 16pt;\"><o:p></o:p></span></p>',
        '0', '蔡学儒', '2020-06-02 13:55:52', '蔡学儒', '2020-06-02 15:59:46', null);

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`
(
    `new_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `new_title`   varchar(255) DEFAULT NULL COMMENT '资讯标题',
    `new_pic`     varchar(255) DEFAULT NULL COMMENT '封面图',
    `new_type_id` varchar(20)  DEFAULT NULL COMMENT '资讯分类id',
    `dept_id`     int(20) DEFAULT NULL COMMENT '上传至部门id',
    `new_content` longtext COMMENT '资讯内容',
    `new_file`    longtext COMMENT '上传文件地址',
    `new_video`   longtext COMMENT '上传视频地址',
    `user_id`     int(20) DEFAULT NULL COMMENT '审核人id',
    `user_name`   varchar(255) DEFAULT NULL COMMENT '审核人名称',
    `status`      varchar(20)  DEFAULT NULL COMMENT '审核状态(1 待审核 2 审核通过  )',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    `type`        varchar(255) DEFAULT NULL COMMENT '类型(1 资讯 2 在线学习)',
    PRIMARY KEY (`new_id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COMMENT='资讯表';

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news`
VALUES ('90', '学习d', 'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '5', '211', '<p>学习内容</p>',
        null, '', '1', '管理员', '2', 'admin', '2020-07-10 15:00:58', '', '2020-08-19 15:54:22', null, '2');
INSERT INTO `tb_news`
VALUES ('91', '凝神聚力抓改革促发展', 'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '2', '200',
        '<h1 style=\"margin-right: auto; margin-bottom: 15px; margin-left: auto; outline: 0px; border: 0px; font-size: 24px; font-weight: bold; text-align: center; font-family: 微软雅黑; line-height: 32px; color: rgb(0, 0, 0);\">凝神聚力抓改革促发展</h1><h2 id=\"ftitle\" style=\"margin-top: 0px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; font-size: 16px; text-align: center; color: rgb(0, 0, 0); font-family: 宋体;\">——基层一线减负见闻</h2><p class=\"sou1\" style=\"margin: 20px auto 0px; outline: 0px; border: 0px; text-align: center; width: 790.391px; font-family: 宋体; font-size: 12px;\">本报记者 张 洋 吴储岐</p><p class=\"sou\" style=\"margin: 10px auto 0px; outline: 0px; border: 0px; width: 790.391px; text-align: center; font-family: 宋体; font-size: 12px;\">2024年11月11日09:03&nbsp;&nbsp;&nbsp;&nbsp;来源：<a href=\"http://paper.people.com.cn/rmrb/html/2024-11/11/nw.D110000renmrb_20241111_4-01.htm\" target=\"_blank\" style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px; color: rgb(0, 0, 0);\">人民网－人民日报</a></p><div class=\"show_text\" style=\"margin: 10px auto; outline: 0px; border: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 26.6px; font-family: 宋体; width: 758.125px; height: auto;\"><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">习近平总书记近日在湖北考察时强调：“要持续为基层减负，让基层干部能够用更多时间和精力来服务群众。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">新时代以来，以习近平同志为核心的党中央驰而不息抓作风，持续深化整治形式主义为基层减负。今年8月，中办、国办印发《整治形式主义为基层减负若干规定》，着力健全长效机制，让基层少些形式主义、多些实干担当，有更多时间精力抓落实。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">近日，记者走基层、看一线，同基层干部深入交流，了解到基层负担轻了、干劲足了，凝神聚力抓改革促发展，基层减负取得实实在在的成效。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><strong style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">发文开会少了，抓落实时间多了</strong></p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“过去，手机日历记得满满的，还要打开铃声、时刻留意，生怕漏忘哪一项会议通知。”黑龙江省绥芬河市阜宁镇党委书记秦玉涛说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">打开过去的手机日历数了数，有时一天开三四个会，“哪个会都得去，不去就会被认为不重视。但是，会开得多了、时间长了，两眼昏花、腰酸背疼，干工作的精力都会受到影响。”秦玉涛说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">如今，“发文开会才算重视”的思维发生了转变。秦玉涛到上级部门参会的次数少了，给村干部开会的频次也大幅压减。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">前几日，为了不耽误参会的村干部调度秋收任务，阜宁镇把安全生产、秸秆禁烧、项目建设等事项放在一起说。“80分钟，全是干货，实实在在解决问题。”阜宁镇北寒村党支部书记宋德国说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">精简会议、严控发文、多项工作一同部署……基层干部的感受很直观，“轻松多了，有更多的时间抓落实、干实事了。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">发展电子商务是阜宁镇的重点工作。按以往，部署会、协调会、推进会，会议应该是一个接一个，可是近半年时间，只召开了一次全镇干部大会，会上一并作了分工安排，然后紧盯责任落实。秦玉涛说：“开短会、说短话，‘捞稠的说’，关键是实打实干事。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“为推进乡村全面振兴，我们还要建特色民宿和农家乐，冰雪项目也在谋划中。”在去村庄调研的路上，秦玉涛谈起下一步的工作思路。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><strong style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">迎检少了，走访多了</strong></p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">临近中午，湖南省郴州市苏仙区许家洞镇711矿区的长者食堂，迎来一批用餐的老人，仅需几元钱，就可以吃上热腾腾的三菜一汤。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">开办长者食堂，是许家洞镇干部入户走访、收集群众诉求的成果之一。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“以前走访没这么勤，很多心思都花在迎检上了。”许家洞镇党委书记雷科说，“有时，一个月迎检就有四五次。住宿、吃饭、用车……事事都要费心安排。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">如今，督、检、考不断瘦身，而且工作方式也变了，能看现场就不看材料，能暗访就不明查。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“我们来反馈防溺水工作的一些漏洞。”前阵子，苏仙区委督查室的暗访组突然来到镇政府。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“你们情况掌握得这么细？”雷科惊讶地问。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“我们来好几次了，没发现问题就走了。这次发现个别山塘水库的救生圈有缺损，就赶紧过来找你们。”苏仙区委督查室主任朱银珍说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“感谢你们指导帮助。”雷科说，“过去迎检总想着推荐个好点位，如今‘四不两直’，接待安排减少了，更需要我们把功夫用在平时。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">这变化，惠及的是老百姓。“我们村是合并村，部分偏远区域的群众来村委会，要绕行将近1个小时。”许家洞镇兰王庙村党总支书记许海兵介绍，村里反映情况后，镇干部多次来村调研，实地体验路线，征求村民意见，两个月就修成了一条直通村委会的道路。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“迎检少了，走访多了，同样还是忙，但忙的意义大不一样了。”许海兵说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><strong style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">工作留痕少了，服务百姓时间多了</strong></p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“叔叔阿姨，把这个选项设置为快捷键放在桌面，就可以快速买车票了。”山西省太原市万柏林区兴华街道滨河社区活动室，社区党委书记胡佳正在讲授智能手机应用，十几位老人围坐在一起，边听边操作。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“我可算知道年轻人为啥爱玩手机了，门道这么多。没人手把手教，我们哪里懂哟！”76岁的社区居民张莲莲笑着说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“以前填表格、建台账、报数据、打卡五花八门的APP，我们几乎被拴在办公室了，把这应付完，就已经很累了。”胡佳说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">现在，万柏林区依托县区智慧社区平台开发了“一键报表”“一键证明”模块，“指尖上的形式主义”被有力遏制，各类报表减少192种。“重复性报表、临时性报表大幅精简。估算下来，每月社区填报表时间大幅缩减。”胡佳说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">痕迹少了，实绩多了。如今，干部坐办公室的时间少了，和群众在一起的时间多了。助老送餐、帮代办服务、防诈骗等学习班……社区活动越来越丰富，居民由衷点赞。“社区干部真为咱干实事！”张莲莲笑着说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><strong style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">墙上牌子少了，群众脸上笑容多了</strong></p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“在家门口办喜宴，社区提供免费场所，干部当司仪，一桌喜宴400元，比外边饭店便宜多了，能省两三万元。”在山东省诸城市枳沟镇乔庄社区昆阳馆，新人刘明、李秀正在举办婚礼，新郎父亲刘连庄喜气洋洋地说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">很难想象，热热闹闹的昆阳馆，曾一度房门紧闭、冷冷清清，20多块牌子挂在不同房间门口，有的门口甚至挂了两三块牌子。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">基层阵地是服务群众的场所。“如今，牌子都摘下来了，我们把昆阳馆建成社区综合文化中心，里面有老年食堂、宴会厅、农家书屋、科普馆、书画室。”乔庄社区党委书记刘正光说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“白天来下棋、写字，晚上来跳舞，别提多高兴了。”村民芷传臻笑得合不拢嘴。乔庄社区群众还自发成立腰鼓队、秧歌队、舞蹈队等，每月一场文艺演出，每年举办社区艺术节。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">减牌子，也让基层的履职事项更明晰了，更能集中精力干事创业了。如今，社区规划建设了工业园，社区党委领办成立两个农民专业合作社，创办了社区服务公司，帮助2200余名群众实现家门口就业。“村民的日子芝麻开花节节高，大家都乐开了花。”刘正光说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><strong style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">干部借调少了，为基层赋能多了</strong></p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">阳光洒在江西省会昌县清溪乡的山间，紫山药喜获丰收。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“咱这山药今年能卖完吗？”干活的村民们抬起头，向着地头喊一声。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">“没问题！前几天我们又联系了一家商超，能销1000多斤。”清溪乡人大副主席邓国清一边帮农，一边大声回应。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">此前，邓国清3次被借调到上级部门工作，他坦言：“毕竟是借调，时间一久总感觉不踏实，乡里的工作也变得断断续续。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">会昌县明确完善借调规范程序，加大监督检查，确保违规借调清理到人、清退到位。半年前，邓国清回到清溪乡，一门心思扑在为民服务上。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">干部借调少了，倒逼县直单位改进作风、提高效率、优化工作部署，而基层力量更充实了，他们有更多精力扎根田间地头。“长远看，对双方都是有利的。”会昌县委组织部副部长曾伟星说。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">一手抓减负，一手抓赋能。会昌县大力推动县直单位干部下基层，到一线去现场办公、解决问题。邓国清感受真切：“为了拓展紫山药的销路，商务局、农业农村局的干部带着我们搞市场调研，请大企业、大客户实地考察。今年农户的收益肯定少不了。”</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">减出实效，激发活力。如今，广大基层干部轻装上阵、放手干事，一心一意抓落实，在改革发展一线不断取得新突破、创造新业绩。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><span id=\"paper_num\" style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">《 人民日报 》（ 2024年11月11日 01 版）</span></p></div><div class=\"edit\" style=\"margin: 20px auto; outline: 0px; border: 0px; text-align: right; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 25.2px; font-family: 宋体; width: 790.391px;\">(责编：王珂园、王先进)</div>',
        null, '', '1', '管理员', '2', 'admin', '2020-08-10 14:13:39', '', '2024-11-11 10:33:45', null, '1');
INSERT INTO `tb_news`
VALUES ('92', '二〇二四年中央和国家机关“四强”党支部建设经验总交流会在京举行',
        'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '2', '101',
        '<h1 style=\"margin-right: auto; margin-bottom: 15px; margin-left: auto; outline: 0px; border: 0px; font-size: 24px; font-weight: bold; text-align: center; font-family: 微软雅黑; line-height: 32px; color: rgb(0, 0, 0);\">二〇二四年中央和国家机关“四强”党支部建设经验总交流会在京举行</h1><p class=\"sou\" style=\"margin: 10px auto 0px; outline: 0px; border: 0px; width: 790.391px; text-align: center; font-family: 宋体; font-size: 12px;\">2024年11月11日09:30&nbsp;&nbsp;&nbsp;&nbsp;来源：<a href=\"http://paper.people.com.cn/rmrb/html/2024-11/09/nw.D110000renmrb_20241109_5-05.htm\" target=\"_blank\" style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px; color: rgb(0, 0, 0);\">人民网－人民日报</a></p><div class=\"show_text\" style=\"margin: 10px auto; outline: 0px; border: 0px; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 26.6px; font-family: 宋体; width: 758.125px; height: auto;\"><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">本报北京11月8日电&nbsp;&nbsp;（记者耿磊）2024年中央和国家机关“四强”党支部建设经验总交流会11月8日在京举行。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">会议强调，中央和国家机关党支部要在学习贯彻党的二十届三中全会精神和习近平总书记重要指示精神上当好先锋，把党的组织优势转化为推动高质量发展、推进中国式现代化的强大动能，用实际行动彰显第一方阵风向标作用。要大力建设时时对标、学以致用的学习型党支部，把学习成效转化为推动改革落实的工作实绩。要积极做好支部工作和业务工作深度融合的文章，真正让推动改革落实和高质量发展成为检验党性的考场、创先争优的赛场、实战拼搏的战场。要着力营造风清气正的政治生态，把党员更多精力引导到抓改革、促发展上。要严格落实党支部具体责任，更加明晰抓什么，更加明确怎么干，更加强化硬约束，确保责任真落地。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">交流会上，来自中央和国家机关8个部门的党支部代表从落实习近平总书记重要指示精神、服务“国之大者”、坚持人民至上、走好群众路线、破解难题、发挥党建引领作用、党建和业务融合、发挥战斗堡垒作用等方面交流了“四强”党支部建设经验。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\">中央和国家机关工委领导班子成员，中央和国家机关工委各部门、直属事业单位党组织书记，中央和国家机关各部门机关党委常务副书记和基层党组织书记代表，共约700人参加会议。</p><p style=\"margin-top: 10px; margin-right: auto; margin-left: auto; outline: 0px; border: 0px; text-indent: 2em; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; font-size: 18px; line-height: 36px; font-family: 微软雅黑;\"><span id=\"paper_num\" style=\"margin: 0px; padding: 0px; outline: 0px; border: 0px;\">《 人民日报 》（ 2024年11月09日 05 版）</span></p></div><div class=\"edit\" style=\"margin: 20px auto; outline: 0px; border: 0px; text-align: right; font-variant-numeric: normal; font-variant-east-asian: normal; font-stretch: normal; line-height: 25.2px; font-family: 宋体; width: 790.391px;\">(责编：王珂园、王先进)</div>',
        null, '', '1', '管理员', '2', 'admin', '2020-08-10 18:09:43', '', '2024-11-11 10:33:14', null, '1');

-- ----------------------------
-- Table structure for tb_news_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_news_type`;
CREATE TABLE `tb_news_type`
(
    `type_id`     int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `type_name`   varchar(255) DEFAULT NULL COMMENT '分类名称',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    `type`        varchar(255) DEFAULT NULL COMMENT '类型(1 资讯 2 在线学习)',
    PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='资讯分类表';

-- ----------------------------
-- Records of tb_news_type
-- ----------------------------
INSERT INTO `tb_news_type`
VALUES ('1', '党建风采', 'admin', '2020-05-06 15:52:05', 'admin', '2020-06-12 14:37:26', null, '1');
INSERT INTO `tb_news_type`
VALUES ('2', '党建要闻', 'admin', '2020-05-06 15:50:58', 'admin', '2020-08-10 14:17:44', null, '1');
INSERT INTO `tb_news_type`
VALUES ('4', '党风廉政', 'admin', '2020-05-11 15:56:38', '', null, null, '1');
INSERT INTO `tb_news_type`
VALUES ('5', '学习', 'admin', '2020-07-10 15:00:55', '', null, null, '2');
INSERT INTO `tb_news_type`
VALUES ('6', '党章', 'admin', '2020-07-10 18:16:17', '', null, null, '2');

-- ----------------------------
-- Table structure for tb_news_upload
-- ----------------------------
DROP TABLE IF EXISTS `tb_news_upload`;
CREATE TABLE `tb_news_upload`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `new_id`      int(20) DEFAULT NULL COMMENT '资讯id',
    `new_file`    longtext COMMENT '上传文件地址',
    `new_video`   longtext COMMENT '上传视频地址',
    `status`      varchar(20)  DEFAULT NULL COMMENT '状态',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资讯上传表';

-- ----------------------------
-- Records of tb_news_upload
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pager
-- ----------------------------
DROP TABLE IF EXISTS `tb_pager`;
CREATE TABLE `tb_pager`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '试卷名称',
    `user_id`     varchar(255)                       DEFAULT NULL COMMENT '考试对象',
    `start_time`  datetime                           DEFAULT NULL COMMENT '试卷开始时间',
    `end_time`    datetime                           DEFAULT NULL COMMENT '试卷结束时间',
    `ks_time`     int(20) DEFAULT '0' COMMENT '考试时间(分钟)',
    `score`       int(11) DEFAULT NULL COMMENT '总分',
    `pass_score`  int(11) DEFAULT '0' COMMENT '合格分数',
    `publish`     int(1) DEFAULT NULL COMMENT '是否发布',
    `status`      varchar(20)                        DEFAULT '0' COMMENT '状态（0未开始 1进行中2 考试结束）',
    `create_by`   varchar(64)                        DEFAULT '' COMMENT '创建者',
    `create_time` datetime                           DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)                        DEFAULT '' COMMENT '更新者',
    `update_time` datetime                           DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255)                       DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='试卷表';

-- ----------------------------
-- Records of tb_pager
-- ----------------------------
INSERT INTO `tb_pager`
VALUES ('9', '测试', '107,1', null, null, '40', null, '0', null, '1', 'admin', '2020-08-11 10:58:07', 'admin',
        '2020-08-11 10:58:10', null);

-- ----------------------------
-- Table structure for tb_pager_answer
-- ----------------------------
DROP TABLE IF EXISTS `tb_pager_answer`;
CREATE TABLE `tb_pager_answer`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `pager_id`    int(11) DEFAULT NULL COMMENT '试卷id',
    `question_id` int(11) DEFAULT NULL COMMENT '题目id',
    `user_id`     int(11) DEFAULT NULL COMMENT '用户id',
    `answer`      varchar(255) DEFAULT NULL COMMENT '用户答案',
    `is_right`    varchar(1)   DEFAULT NULL COMMENT '答案是否正确(1正确 2 错误)',
    `mark`        int(11) DEFAULT NULL COMMENT '得分',
    `status`      varchar(255) DEFAULT '0' COMMENT '批改状态 0待批改 1 错误 2 正确  ',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` date         DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷答案表';

-- ----------------------------
-- Records of tb_pager_answer
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pager_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_pager_user`;
CREATE TABLE `tb_pager_user`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     int(20) DEFAULT NULL COMMENT '考试对象',
    `pager_id`    int(20) DEFAULT NULL COMMENT '试卷id',
    `mark`        int(255) DEFAULT NULL COMMENT '得分',
    `status`      varchar(20)  DEFAULT NULL COMMENT '状态（0未开始 1进行中2 考试结束）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    `confirm`     varchar(50)  DEFAULT '0' COMMENT '确认最后分数(0未确认 1已确认)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='考试对象表';

-- ----------------------------
-- Records of tb_pager_user
-- ----------------------------
INSERT INTO `tb_pager_user`
VALUES ('17', '107', '9', '0', '0', 'admin', '2020-08-11 10:58:07', '', null, null, '0');
INSERT INTO `tb_pager_user`
VALUES ('18', '1', '9', '0', '0', 'admin', '2020-08-11 10:58:07', '', null, null, '0');

-- ----------------------------
-- Table structure for tb_picture
-- ----------------------------
DROP TABLE IF EXISTS `tb_picture`;
CREATE TABLE `tb_picture`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `title`       varchar(255) DEFAULT NULL COMMENT '标题',
    `photo`       varchar(500) DEFAULT NULL COMMENT '图片地址',
    `content`     longtext COMMENT '内容详情',
    `status`      varchar(255) DEFAULT NULL COMMENT '状态',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='首页轮播图';

-- ----------------------------
-- Records of tb_picture
-- ----------------------------
INSERT INTO `tb_picture`
VALUES ('12', null, 'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '<p><br></p>', null,
        '',
        '2020-07-27 16:41:57', '', '2024-11-11 10:55:50', null);
INSERT INTO `tb_picture`
VALUES ('13', null, 'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '<p><br></p>', null,
        '',
        '2020-07-27 16:42:54', '', null, null);
INSERT INTO `tb_picture`
VALUES ('14', null, 'http://localhost:8099/profile/upload/2024/11/13/ban1_20241113101439A001.png', '<p><br></p>', null,
        '',
        '2020-07-27 16:43:23', '', null, null);

-- ----------------------------
-- Table structure for tb_plan
-- ----------------------------
DROP TABLE IF EXISTS `tb_plan`;
CREATE TABLE `tb_plan`
(
    `plan_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`      int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`      int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`    varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `plan_time`    datetime     DEFAULT NULL COMMENT '提交时间',
    `plan_title`   varchar(255) DEFAULT NULL COMMENT '学习计划标题',
    `plan_content` longtext COMMENT '学习计划内容',
    `plan_img`     longtext COMMENT '图片',
    `plan_video`   longtext COMMENT '视频',
    `status`       varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='学习计划表';

-- ----------------------------
-- Records of tb_plan
-- ----------------------------
INSERT INTO `tb_plan`
VALUES ('10', '101', '107', '赵夏', '2020-05-26 15:33:43', '“不忘初心、牢记使命”主题教育 理论学习内容',
        '延安市强制隔离戒毒所第五党小组\r\n“不忘初心、牢记使命”主题教育\r\n理论学习内容\r\n\r\n一、习近平系列重要讲话\r\n1.最新重要讲话以及对延安的重要指示批示、回信寄语；\r\n2.在“不忘初心、牢记使命”主题教育工作会议上的重要讲话；\r\n3.在中央政治局第十五次集体学习时的重要讲话；\r\n4.在中央和国家机关党的建设工作会议上的重要讲话；\r\n5.习近平在内蒙古考察并指导开展“不忘初心、牢记使命”主题\r\n教育时的重要讲话。\r\n二、集体学习内容\r\n《习近平关于“不忘初心、牢记使命”重要论述选编》\r\n1.认真学习党章  严格遵守党章；\r\n2.解决好人民群众最关心最直接最现实的利益问题，不断增强人民群众获得感、幸福感、满意感；\r\n3.着力培养选拔党和人民需要的好干部；\r\n4.领导干部要在改进作风上发挥示范作用；\r\n5.加强纪律建设，把守纪律讲规矩摆在更加重要的位置；\r\n6.忠于党、忠于人民、无私奉献是共产党人的优秀品质；\r\n7.着力践行以人民为中心的发展思想；\r\n8.坚定不移推进全面从严治党；\r\n9.牢固树立“四个意识”，维护党中央权威；\r\n10.党必须勇于自我革命；\r\n11.新时代要有新气象，更要有新作为；\r\n12.走得再远都不能忘记来时的路；\r\n13.坚持和发展中国特色社会主义要一以贯之；\r\n14.学习马克思主义基本理论是共产党人的必修课；\r\n15.加强党的政治建设；\r\n16.理想信念是中国共产党人的政治灵魂；\r\n17.着力践行以人民为中心的发展思想；\r\n18.人民对美好生活的向往，就是我们的奋斗目标。\r\n三、个人自学内容\r\n1.习近平总书记在中国共产党第十九次全国代表大会上的报告;\r\n2.《中国共产党党章》；\r\n3.《习近平关于“不忘初心、牢记使命”重要论述摘编》；\r\n4.《习近平新时代中国特色社会主义思想学习纲要》；\r\n5.《习近平关于“不忘初心、牢记使命”重要论述选编》内以下文章：\r\n（1）“决胜全面建成小康社会，夺取新时代中国特色社会主义伟大胜利”；\r\n（2）“中国梦，复兴路”；\r\n（3）“关于坚持和发展中国特色社会主义的几个问题”；\r\n（4）“在第十二届全国人民代表大会第一次会议上的讲话”；\r\n（5）“推动全党学习和掌握历史唯物主义，更好认识规律，更加能动地推动工作”；\r\n（6）“在纪念毛泽东同志诞辰一百二十周年座谈会上的讲话”；\r\n（7）“领导干部要在改进作风上发挥示范作用”；\r\n（8）“做焦裕禄式的县委书记”；\r\n（9）“在纪念邓小平同志诞辰一百一十周年座谈会上的讲话”；\r\n（10）“辩证唯物主义是中国共产党人的世界观和方法论”；\r\n（11）“领导干部要践行三严三实”；\r\n（12）“在中央扶贫开发工作会议上的讲话”；\r\n（13）“在庆祝中国共产党成立九十五周年大会上的讲话”；\r\n（14）“人民军队必须永志不忘的红色血脉”；\r\n（15）“推进党的建设新的伟大工程要一以贯之”；\r\n（16）“学习马克思基本理论是共产党人的必修课”；\r\n（17）“在纪念马克思诞辰二百周年大会上的讲话”；\r\n（18）“广大干部特别是年轻干部要做到信念坚定、政治强、本领高、作风硬”。\r\n四、要求：\r\n1.党小组开展集体学习和自学相结合；\r\n2.所有党小组成员要按时完成自学内容。\r\n',
        null, null, '0', '', '2020-05-26 15:33:43', '', null, null);
INSERT INTO `tb_plan`
VALUES ('11', '101', '107', '赵夏', '2020-05-26 15:34:58', '“不忘初心、牢记使命”主题教育 11月份理论学习计划',
        '延安市强制隔离戒毒所第五党小组\r\n“不忘初心、牢记使命”主题教育\r\n11月份理论学习计划\r\n\r\n时间	学习内容\r\n\r\n4\r\n日\r\n至\r\n10日	集\r\n中学\r\n习	《中共党史简明读本 》\r\n第一章：中国共产党的创立；第二章：在大革命的洪流中；\r\n第三章：掀起土地革命的风暴；第四章：抗日战争的中流砥柱。\r\n	个\r\n人\r\n自\r\n学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第十二章：带领人民创造更加幸福美好生活——关于新时代中国特色社会主义社会建设；\r\n第十三章：建设美丽中国——关于新时代中国特色社会主义生态文明建设。\r\n11日\r\n至\r\n17日	集中学习	《中共党史简明读本 》\r\n第五章：夺取民主革命的全国胜利；第六章：从新民主主义向社会主义的过渡；\r\n第七章：党对社会主义建设道路的曲折探索。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第十四章：坚决维护国家主权、安全、发展利益——关于新时代坚持总体国家安全观；\r\n第十五章：把人民军队全面建成世界一流军队——关于新时代国防和军队建设。\r\n18日\r\n至\r\n24日	集中学习	《中共党史简明读本 》\r\n第八章： “文化大革命”的内乱及其抵制；第九章：开辟社会主义事业发展新时期；\r\n第十章：建设中国特色社会主义。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第十六章：实现祖国完全统一是中华民族根本利益所在——关于新时代坚持“一国两制”和推进祖国统一；\r\n第十七章：推动构建人类命运共同体——关于新时代中国特色大国外交。\r\n25日\r\n至\r\n30日	集中学习	《中共党史简明读本 》\r\n第十一章：加快改革开放与中国特色社会主义道路的丰富发展；\r\n第十二章： 新世纪新阶段中国特色社会主义道路新发展；\r\n第十三章：十八大以来治国理政新实践。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第十八章：把党建设得更加坚强有力——关于新时代坚持和发展中国特色社会主义的政治保证；\r\n第十九章：掌握马克思主义思想方法和工作方法——关于新时代坚持和发展中国特色社会主义的能力建设。\r\n备\r\n注	1.党小组集中学习每周不得少于一次，按时完成学习任务；\r\n2.支部委员需参加所在党小组的集中学习；\r\n',
        null, null, '0', '', '2020-05-26 15:34:58', '', null, null);
INSERT INTO `tb_plan`
VALUES ('12', '101', '107', '赵夏', '2020-05-26 15:35:21', '“不忘初心、牢记使命”主题教育 10月份理论学习计划',
        '延安市强制隔离戒毒所第五党小组\r\n“不忘初心、牢记使命”主题教育\r\n10月份理论学习计划\r\n\r\n时间	学习内容\r\n\r\n8\r\n日\r\n至\r\n13日	集\r\n中学\r\n习	《习近平关于“不忘初心、牢记使命”论述摘编 》\r\n第二章：新时代中国共产党的历史使命；\r\n第九章：加强学习，深入开展调查研究，全面增强执政本领。\r\n	个\r\n人\r\n自\r\n学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第四章：实现中华民族伟大复兴的中国梦——关于新时代坚持和发展中国特色；\r\n第五章：开启全面建设社会主义现代化国家新征程——关于新时代坚持和发展中国特色社会主义的战略安排。\r\n\r\n14日\r\n至\r\n20日	集中学习	《习近平关于“不忘初心、牢记使命”论述摘编 》\r\n第四章：坚定理想信念，始终是共产党人安身立命的根本；\r\n第五章：把政治建设摆在首位，不断增强“四个意识”、坚定“四个自信”、做到“两个维护”。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第六章：中国共产党领导是中国特色社会主义最本质的特征——关于新时代坚持和发展中国特色社会主义的领导力量；\r\n第七章：将全面深化改革进行到底——关于新时代坚持和发展中国特色社会主义的根本动力。\r\n21日\r\n至\r\n27日	集中学习	《习近平关于“不忘初心、牢记使命”论述摘编 》\r\n第六章：坚持以人民为中心，把群众观点和群众路线深深根植于思想中、具体落实到行动上；\r\n第七章：勇于自我革命，同一切影响党的先进性、弱化党的纯洁性的问题作坚决斗争。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第八章：全面推进依法治国——关于新时代坚持和发展中国特色社会主义的本质要求；\r\n第九章：以新发展理念引领经济高质量发展——关于新时代中国特色社会主义经济建设。\r\n28日\r\n至\r\n11月\r\n3\r\n日	集中学习	《习近平关于“不忘初心、牢记使命”论述摘编 》\r\n第三章：用新时代中国特色社会主义思想武装全党；\r\n第十章：新时代要有新气象，更要有新作为。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n第十章：发展社会主义民主政治——关于新时代中国特色社会主义政治建设；\r\n第十一章：推动社会主义文化繁荣兴盛——关于新时代中国特色社会主义文化建设。\r\n备\r\n注	1.党小组集中学习每周不得少于一次，按时完成学习任务；\r\n2.支部委员需参加所在党小组的集中学习；\r\n',
        null, null, '0', '', '2020-05-26 15:35:21', '', null, null);
INSERT INTO `tb_plan`
VALUES ('13', '101', '107', '赵夏', '2020-05-26 15:35:45', '“不忘初心、牢记使命”主题教育 9月份理论学习计划',
        '延安市强制隔离戒毒所第五党小组\r\n“不忘初心、牢记使命”主题教育\r\n9月份理论学习计划\r\n\r\n时间	学习内容\r\n\r\n16\r\n日\r\n至\r\n22\r\n日	集\r\n中学\r\n习	1.习近平最新重要讲话以及对延安的重要指示批示、回信寄语；\r\n2.习近平在“不忘初心、牢记使命”主题教育工作会议上的重要讲话；\r\n3.习近平在中央政治局第十五次集体学习时的重要讲话；\r\n4.习近平在中央和国家机关党的建设工作会议上的重要讲话；\r\n5.习近平在内蒙古考察并指导开展“不忘初心、牢记使命”主题教育时的重要讲话。\r\n	个\r\n人\r\n自\r\n学	习近平总书记在中国共产党第十九次全国代表大会上的报告\r\n\r\n23\r\n日\r\n至\r\n30\r\n日	集中学习	《习近平关于“不忘初心、牢记使命”论述摘编 》\r\n\r\n第一章：中国共产党人的初心和使命，就是为中国人民谋幸福，为中华民族谋复兴；\r\n\r\n第八章：坚决整治形式主义、官僚主义，加强真抓实干的工作作风。\r\n	个人自学	《习近平新时代中国特色社会主义思想学习纲要》\r\n篇首语：习近平新时代中国特色社会主义思想是党和国家必须长期坚持的指导思想；\r\n第一章：中国特色社会主义进入新时代——关于我国发展新的历史地位；\r\n第二章：当代中国发展进步的根本方向——关于新时代坚持和发展中国特色社会主义；\r\n第三章：坚持以人民为中心——关于新时代坚持和发展中国特色社会主义的根本立场。\r\n备\r\n注	1.党小组集中学习每周不得少于一次，按时完成学习任务；\r\n2.支部委员需参加所在党小组的集中学习。\r\n',
        null, null, '0', '', '2020-05-26 15:35:45', '', null, null);

-- ----------------------------
-- Table structure for tb_problem
-- ----------------------------
DROP TABLE IF EXISTS `tb_problem`;
CREATE TABLE `tb_problem`
(
    `problem_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`         int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`         int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`       varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `problem_time`    datetime     DEFAULT NULL COMMENT '提交时间',
    `problem_title`   varchar(500) DEFAULT NULL COMMENT '问题标题',
    `problem_content` longtext COMMENT '问题描述',
    `problem_img`     longtext COMMENT '问题图片',
    `problem_video`   longtext COMMENT '问题视频',
    `status`          varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`       varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`problem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='问题墙表';

-- ----------------------------
-- Records of tb_problem
-- ----------------------------
INSERT INTO `tb_problem`
VALUES ('6', '101', '107', null, '2020-05-26 15:23:57', '个人自查自纠剖析材料--- 张永胜',
        '延安市强制隔离戒毒所党支部《关于开展“忠诚、担当、纪律、形象”教育和清理纠正不正之风的实施方案》个人自查自纠剖析材料\r\n\r\n第五党小组 张永胜\r\n通过学习市局党委《关于开展“忠诚、担当、纪律、形象”教育和清理纠正不正之风的实施方案》和《延安市强制隔离戒毒所关于开展“忠诚、担当、纪律、形象”教育和清理纠正不正之风的实施方案》后，我本人严格按照“五个聚焦”开展自查自纠，现将自查自纠问题与整改措施呈报党组织，并恳请同志们对我监督批评，以便我进一步改进作风，更好树立“忠诚、担当、纪律、形象”的人民公安形象，助力我所教育矫治工作更上台阶。\r\n一、存在问题\r\n思想政治方面：学用结合还不够紧密，没有做到彻底的融会贯通。\r\n执法办案方面：对最新执法手段掌握的慢，习惯于使用老方法。\r\n纪律作风方面：在日常工作中，不能事事做到积极主动作为，存在等靠思想。\r\n廉洁自律方面：无\r\n监督管理方面：批评和自我批评的利器运用不充分。\r\n二、产生问题根源\r\n经过分析以上缺点，在深入自我解剖之后，让我认识到了问题的严重性。按照具体情况具体分析的方法进行剖析，让我意识到“忠诚、担当、纪律、形象”的人民公安形象是极其重要的，让我对自己自身存在的问题来一次大解剖，通过分析，我认为出现这些问题的思想根源在于： \r\n（一）抓思想政治学习的力度不够，主观上对学习的强烈渴求有所减弱，学习的自觉性、主动性有所放松，在把握运用党的新思想新论断武装头脑、分析解决问题、指导具体工作方面，创造力和创新性不足。  \r\n（二）在解放思想、更新观念，创新工作方法和手段方面有所欠缺。研究情况多，解决问题少，缺乏创造性开展工作，改革意识有待于加强。  \r\n（三）有时担心影响同事团结，工作中过分追求一团和气，怕得罪人，想当“老好人”。\r\n三、今后努力方向\r\n针对查摆出来的问题，下一步我将从三个方面加强改进。一是进一步树牢宗旨意识。作为一名共产党员，结合“不忘初心、牢记使命”主题教育，牢固树立“四个意识”、坚定“四个自信”、做到“两个维护”，在具体工作中，努力为广大群众排忧解难，更加关心戒毒人员的生活，使自己的一言一行都要从优秀党员的良好形象出发。\r\n二是进一步抓好理论武装。坚持把补精神之“钙”、铸思想之“魂”放在首位。突出抓好党章党规和习近平新时代中国特色社会主义思想的学习，学习更加深入，做到进入思想、推动工作;头脑更加清醒，做到立场坚定、旗帜鲜明;贯彻更加坚决，做到信念坚定、对党忠诚。\r\n三是进一步强化纪律意识。严格遵守《关于新形势下党内政治生活的若干准则》和《中国共产党党内监督条例》，扎实履行党风廉政建设责任制，坚持按法纪、按规矩、按程序办事，切实筑牢拒腐防变的思想防线。认真执行中央八项规定和实施细则，妥善处理好同事、同学及朋友相处之道，任何时候都不能放松对自己的要求。时刻谨记自己手中的权力是党和人民赋予的，要求别人做的，自己带头做，要求别人不做的，自己坚决不做，努力做到公私分明。\r\n',
        null, null, '0', '', '2020-05-26 15:23:57', '', null, null);

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `type_id`       int(11) DEFAULT NULL COMMENT '题库分类id',
    `question_type` int(11) DEFAULT NULL COMMENT '1.单选题  2.判断题 3 多选题 .4.简答题',
    `title`         varchar(500) DEFAULT NULL COMMENT '标题',
    `difficult`     varchar(11)  DEFAULT NULL COMMENT '题目难度',
    `answer_a`      varchar(300) DEFAULT NULL COMMENT '答案A',
    `answer_b`      varchar(300) DEFAULT NULL COMMENT '答案B',
    `answer_c`      varchar(300) DEFAULT NULL COMMENT '答案C',
    `answer_d`      varchar(300) DEFAULT NULL COMMENT '答案D',
    `answer_e`      varchar(300) DEFAULT NULL COMMENT '答案E',
    `answer`        varchar(500) DEFAULT NULL COMMENT '答案',
    `content`       longtext COMMENT '题内容',
    `introduce`     varchar(500) DEFAULT NULL COMMENT '解析',
    `score`         int(255) DEFAULT NULL COMMENT '分数',
    `status`        varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`     varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`   datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='题目表';

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question`
VALUES ('3', '2', '1', '在新时期,邓小平提出的\"四有\"新人指的是', null, '有知识、有能力、有文化、有纪律',
        '有理想、有道德、有文化、有纪律', '有素质、有本领、有道德、有理想', '有理想、有信念、有才华、有纪律', null, 'B', null,
        null, '5', '0', 'admin', '2020-06-08 10:15:48', 'admin', '2020-06-11 14:22:28', null);
INSERT INTO `tb_question`
VALUES ('4', '2', '1', '人才素质的灵魂是()', null, '德', '智', '体', '美', null, 'A', null, null, '5', '0', 'admin',
        '2020-06-08 10:20:02', '', null, null);
INSERT INTO `tb_question`
VALUES ('5', '2', '3', '高举中国特色社会主义伟大旗帜，是', null, '历史的选择', '时代的选择', '政治的选择', '人民的选择',
        null, 'ABD', null, null, '5', '0', 'admin', '2020-06-08 10:25:48', '', null, null);

-- ----------------------------
-- Table structure for tb_question_pager
-- ----------------------------
DROP TABLE IF EXISTS `tb_question_pager`;
CREATE TABLE `tb_question_pager`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `question_id` int(11) DEFAULT NULL COMMENT '题目id',
    `pager_id`    int(11) DEFAULT NULL COMMENT '试卷id',
    `rank`        int(20) DEFAULT '1' COMMENT '排序',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='题目试卷关联表';

-- ----------------------------
-- Records of tb_question_pager
-- ----------------------------
INSERT INTO `tb_question_pager`
VALUES ('16', '5', '9', '1');
INSERT INTO `tb_question_pager`
VALUES ('17', '3', '9', '1');
INSERT INTO `tb_question_pager`
VALUES ('18', '4', '9', '1');

-- ----------------------------
-- Table structure for tb_question_type
-- ----------------------------
DROP TABLE IF EXISTS `tb_question_type`;
CREATE TABLE `tb_question_type`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(255) DEFAULT NULL COMMENT '科目名称',
    `status`      varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='题库分类表';

-- ----------------------------
-- Records of tb_question_type
-- ----------------------------
INSERT INTO `tb_question_type`
VALUES ('2', '思想政治课', '0', 'admin', '2020-06-04 18:22:04', 'admin', '2020-06-08 10:04:45', null);

-- ----------------------------
-- Table structure for tb_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_record`;
CREATE TABLE `tb_record`
(
    `record_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`        int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`        int(20) DEFAULT NULL COMMENT '记录人id',
    `user_name`      varchar(255) DEFAULT NULL COMMENT '记录人姓名',
    `record_time`    datetime     DEFAULT NULL COMMENT '记录时间',
    `record_title`   varchar(255) DEFAULT NULL COMMENT '会议记录标题',
    `record_content` longtext COMMENT '会议记录内容',
    `record_img`     longtext COMMENT '记录图片',
    `record_video`   longtext COMMENT '记录视频',
    `status`         varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`      varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`    date         DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='会议记录表';

-- ----------------------------
-- Records of tb_record
-- ----------------------------
INSERT INTO `tb_record`
VALUES ('71', '101', '107', null, '2020-05-30 14:04:58', '会议记录（一）',
        '<p><img src=\"http://io.hllincheng.cn/FodYmS2Rr_OpCba3Cin74Z4RI4r0\" data-filename=\"2020/05/30/603595678d7c99e9729c0516ce627191.png\" style=\"width: 100%;\"></p><p class=\"MsoNormal\" align=\"justify\" style=\"margin: 0pt; text-indent: 32pt; padding: 0pt; word-break: break-all; text-align: justify; vertical-align: baseline; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">2</span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\">020年1月12日，延安市强制隔离戒毒所党支部第二党小组在交接班前召开党小组集体学习，会议由杨洁同志主持，党支部群工委员樊烨宏、带班领导王文新参加了此次会议。﻿</span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"margin: 0pt; text-indent: 32pt; padding: 0pt; word-break: break-all; text-align: justify; vertical-align: baseline; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">首先，</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">杨洁同志组织学习《强制隔离戒毒所执法细则》第三章</font>“管理”内容。</span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"margin: 0pt; text-indent: 32pt; padding: 0pt; word-break: break-all; text-align: justify; vertical-align: baseline; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">其次，</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">﻿党小组组长蔡学儒组织学习《习近平新时代中国特色社会主义思想学习纲要》</font>——第五章 开启全面建设社会主义国家新征程 第一节、第二节内容。</span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"margin: 0pt; text-indent: 32pt; padding: 0pt; word-break: break-all; text-align: justify; vertical-align: baseline; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">再次，</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">副大队长李锋讲到：加强与戒毒人员谈心谈话，做好本职工作，确保监区安全稳定；群工委员樊烨宏讲到：</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">一是，加强学习</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">《强制隔离戒毒所管理办法》与《强制隔离戒毒所执法细则》指导工作的意见，在学习的同时要多多结合工作实际进行学习；</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">二是，</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">加强与戒毒人员谈心谈话，尤其是与戒毒人员七日跟踪谈话，在谈话的过程中排除安全隐患</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">。</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"margin: 0pt; text-indent: 32pt; padding: 0pt; word-break: break-all; text-align: justify; vertical-align: baseline; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">最后，带班领导王文新强调，</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><font face=\"仿宋\">临近年关，监区值班民警要严格按照值班巡视制度加强巡视，加强安全管理。</font></span><span style=\"font-family: 仿宋; letter-spacing: 0pt; font-size: 16pt; background-image: initial; background-position: initial; background-size: initial; background-repeat: initial; background-attachment: initial; background-origin: initial; background-clip: initial;\"><o:p></o:p></span></p>',
        null, null, '0', '', '2020-05-30', '', null, null);

-- ----------------------------
-- Table structure for tb_reply
-- ----------------------------
DROP TABLE IF EXISTS `tb_reply`;
CREATE TABLE `tb_reply`
(
    `reply_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`       int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`       int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`     varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `reply_time`    datetime     DEFAULT NULL COMMENT '提交时间',
    `reply_title`   varchar(500) DEFAULT NULL COMMENT '回音标题',
    `reply_content` longtext COMMENT '回音内容',
    `reply_img`     longtext COMMENT '回音图片',
    `reply_video`   longtext COMMENT '回音视频',
    `status`        varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`     varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`   datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='回音壁表';

-- ----------------------------
-- Records of tb_reply
-- ----------------------------
INSERT INTO `tb_reply`
VALUES ('2', '200', '1', null, '2020-05-09 00:00:00', '标题', '内容',
        'http://qa06snok8.bkt.clouddn.com/FvQVWKUKhZcncpZMdQG1fv7cq12Z',
        'http://qa06snok8.bkt.clouddn.com/lsMkz9iQ8qkOiRk36QAcgo1vmNx_', '0', '', '2020-05-09 15:56:06', '', null,
        null);

-- ----------------------------
-- Table structure for tb_story
-- ----------------------------
DROP TABLE IF EXISTS `tb_story`;
CREATE TABLE `tb_story`
(
    `story_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `story_title`   varchar(255) DEFAULT NULL COMMENT '故事标题',
    `story_pic`     varchar(500) DEFAULT NULL COMMENT '封面图',
    `story_content` longtext COMMENT '故事内容',
    `status`        varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`     varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`   datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`story_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='暖心故事表';

-- ----------------------------
-- Records of tb_story
-- ----------------------------
INSERT INTO `tb_story`
VALUES ('11', '礼赞新时代 奋斗的青春最出彩', 'http://io.hllincheng.cn/FuB0LUGo253VwlJaq7QxBYO78vp-',
        '<div class=\"m-ct-tt-bd\" style=\"padding-top: 25px; padding-bottom: 10px; color: rgb(43, 43, 43); height: auto; min-height: 60px; overflow: hidden; font-family: Arial, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsum, STXihei, 华文细黑, sans-serif;\"><div class=\"m-ct-tt\" style=\"font-weight: bold; font-size: 26px; line-height: 60px; height: auto; text-align: center;\">礼赞新时代 奋斗的青春最出彩</div><div class=\"m-ct-dtt\" style=\"font-weight: bold; font-size: 24px; line-height: 40px; height: auto; text-align: center;\"></div></div><div class=\"m-ct-crm\" style=\"color: rgb(43, 43, 43); height: 40px; line-height: 40px; background-color: rgb(249, 249, 249); font-family: Arial, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsum, STXihei, 华文细黑, sans-serif;\"><span style=\"margin: 0px 10px; font-size: 15px; float: left;\">来源：延安市公安局</span><span style=\"margin: 0px 10px; font-size: 15px; float: left;\">更新时间：2020-05-08 16:16</span><div class=\"m-ct-print print-link no-print\" style=\"padding-top: 10px; float: right;\"><div class=\"share\"><div class=\"fenx\" style=\"margin-top: -8px;\"><div class=\"bdsharebuttonbox bdshare-button-style0-24\" data-bd-bind=\"1590851175018\" style=\"zoom: 1;\"><a href=\"http://gaj.yanan.gov.cn/jwzx/jwyw/54668.htm#\" class=\"bds_sqq\" data-cmd=\"sqq\" title=\"分享到QQ好友\" style=\"color: rgb(43, 43, 43); float: left; font-size: 18px; padding-left: 25px; line-height: 24px; height: 24px; background-image: url(&quot;../img/share/icons_0_24.png?v=4c3f13b3.png&quot;); background-repeat: no-repeat; margin: 6px 6px 6px 0px; background-position: 0px -2652px;\"></a><a href=\"http://gaj.yanan.gov.cn/jwzx/jwyw/54668.htm#\" class=\"bds_weixin\" data-cmd=\"weixin\" title=\"分享到微信\" style=\"color: rgb(43, 43, 43); float: left; font-size: 18px; padding-left: 25px; line-height: 24px; height: 24px; background-image: url(&quot;../img/share/icons_0_24.png?v=4c3f13b3.png&quot;); background-repeat: no-repeat; margin: 6px 6px 6px 0px; background-position: 0px -1612px;\"></a><a href=\"http://gaj.yanan.gov.cn/jwzx/jwyw/54668.htm#\" class=\"bds_tsina\" data-cmd=\"tsina\" title=\"分享到新浪微博\" style=\"color: rgb(43, 43, 43); float: left; font-size: 18px; padding-left: 25px; line-height: 24px; height: 24px; background-image: url(&quot;../img/share/icons_0_24.png?v=4c3f13b3.png&quot;); background-repeat: no-repeat; margin: 6px 6px 6px 0px; background-position: 0px -104px;\"></a><a href=\"http://gaj.yanan.gov.cn/jwzx/jwyw/54668.htm#\" class=\"bds_copy\" data-cmd=\"copy\" title=\"分享到复制网址\" style=\"color: rgb(43, 43, 43); float: left; font-size: 18px; padding-left: 25px; line-height: 24px; height: 24px; background-image: url(&quot;../img/share/icons_0_24.png?v=4c3f13b3.png&quot;); background-repeat: no-repeat; margin: 6px 6px 6px 0px; background-position: 0px -2288px;\"></a></div></div></div></div></div><div class=\"m-ct-artcle\" style=\"padding-top: 30px; padding-bottom: 30px; color: rgb(43, 43, 43); border-bottom: 1px dashed rgb(229, 229, 229); height: auto; overflow: hidden; line-height: 36px; font-size: 15px; font-family: Arial, &quot;Helvetica Neue&quot;, &quot;Microsoft YaHei New&quot;, &quot;Microsoft Yahei&quot;, 微软雅黑, Simsum, STXihei, 华文细黑, sans-serif;\"><p style=\"margin-bottom: 0px; line-height: 36px;\"></p><p style=\"margin-bottom: 0px; line-height: 36px; text-indent: 2em;\"><span style=\"border: 1px none windowtext; padding: 0px;\">为深入学习习近平新时代中国特色社会主义思想，丰富“学用新思想、奋进新时代”学习竞赛活动方式，大力弘扬五四精神，集中展示新时代延安青年民警的精神品格和价值追求，激励和引导广大青年民辅警用奋斗青春书写芳华人生。</span></p><p style=\"margin-bottom: 0px; line-height: 36px; text-indent: 2em;\"><span style=\"border: 1px none windowtext; padding: 0px;\">4</span><span style=\"border: 1px none windowtext; padding: 0px;\">月29日下午,“学用新思想 奋进新时代”主题分享会在延安市公安局警苑书屋举行，市局机关60余名青年民辅警代表参加了分享会。市委组织部、市委宣传部、共青团延安市委、延安市直属机关委员会领导应邀出席了分享会。</span></p><p style=\"margin-bottom: 0px; line-height: 36px; text-indent: 2em;\"><span style=\"border: 1px none windowtext; padding: 0px;\">分享会从市局网安支队支队长田晓阳推荐的经典影片《忠诚与背叛》中拉开了序幕“我们的事业不会显赫一时，但将永远存在！”这是忠诚者发出的正义之声，在今日听起来仍旧振聋发聩。天下至德莫大于忠，忠诚是公安队伍的政治本色，是每个青年民警立身行事的必修课，电影《忠诚与背叛》就是这样一部用革命事迹讲述忠诚的影片，对于我们理解忠诚内涵，培养忠诚意识，永葆忠诚本色具有强烈的感染力和教育意义。爱国是最大的忠诚通过市局政治部综合处副处长李洪林分享的书目《五四运动史》让我们仿佛听到了那个激荡年代飞扬的青春之歌“爱国、进步、民主、科学”的五四精神在百年未有之大变局的今日中国更加焕发出蓬勃的生命力，激励着广大青年前行。在分享会的特殊访谈环节扎根基层派出所为民解难的优秀所长李军阳和致力于公益事业24年的“警察爸爸”王椰林分别讲述了自己“无奋斗、不青春”的别样人生。在他们娓娓道来的讲述背后，是他们用青春描绘的人生画卷，用热血铺成的漫漫长路，也是生命熔铸的不朽丰碑。市局强制隔离戒毒所民警张静、吕艳艳、崔晓博、蔡学儒创作的诗歌《青春礼赞新时代》，描绘了戒毒所民警在高墙内用心耕耘、默默坚守、青春无悔的感人故事。“孩子，你的小花要送给谁呢？妈妈，我要送给那些为武汉拼过命的白衣天使与警察叔叔!”市公安局交警支队民警温丽与儿子李安哲的朗诵《致武汉：我想送你一朵小花》，用最温柔的童声发出直抵人心般最震撼的话语，引起了在场所有听众的共鸣。政治部民警张家语演唱歌曲《当那一天来临》时，全场青年民辅警代表齐唱“放心吧祖国、放心吧亲人，为了胜利我要勇敢前进。”这是圣地青年民警发出的最嘹亮的青春口号，将整场分享会推向了高潮。</span></p><p style=\"margin-bottom: 0px; line-height: 36px; text-indent: 2em;\"><span style=\"border: 1px none windowtext; padding: 0px;\">市委组织部四级调研员王育宏在点评时指出，延安市公安局将“五四”精神与“学用新思想、奋进新时代”学习竞赛活动相结合，整场分享会形式多样内容丰富。抓住广大青年民辅警这个学习“主力军”、干事“生力军”，通过身边优秀民警的青春奋斗故事激励更多青年民辅警去为公安工作奉献青春，实现人生理想。</span></p><p style=\"margin-bottom: 0px; line-height: 36px; text-align: center;\"><img src=\"http://gaj.yanan.gov.cn/upload/CMSyagaj/202005/20200508m3fbhx2rmz.jpg\" title=\"1.5.jpg\" alt=\"1.5.jpg\" style=\"width: 100%;\"></p><p style=\"margin-bottom: 0px; line-height: 36px; text-align: center;\"><img src=\"http://gaj.yanan.gov.cn/upload/CMSyagaj/202005/2020050886szymvcnh.jpg\" title=\"1.3.jpg\" alt=\"1.3.jpg\" style=\"width: 100%;\"></p><p style=\"margin-bottom: 0px; line-height: 36px; text-align: center;\"><img src=\"http://gaj.yanan.gov.cn/upload/CMSyagaj/202005/20200508pgvvuzlwro.jpg\" title=\"1.1.jpg\" style=\"width: 100%;\"></p></div>',
        '0', '蔡学儒', '2020-05-30 23:08:15', '', null, null);

-- ----------------------------
-- Table structure for tb_tale
-- ----------------------------
DROP TABLE IF EXISTS `tb_tale`;
CREATE TABLE `tb_tale`
(
    `tale_id`      int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dept_id`      int(20) DEFAULT NULL COMMENT '部门id',
    `user_id`      int(20) DEFAULT NULL COMMENT '提交人id',
    `user_name`    varchar(255) DEFAULT NULL COMMENT '提交人姓名',
    `tale_time`    datetime     DEFAULT NULL COMMENT '提交时间',
    `tale_title`   varchar(500) DEFAULT NULL COMMENT '故事标题',
    `tale_content` longtext COMMENT '故事内容',
    `tale_img`     longtext COMMENT '故事图片',
    `tale_video`   longtext COMMENT '故事视频',
    `status`       varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`    varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`  datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`tale_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='小组故事表';

-- ----------------------------
-- Records of tb_tale
-- ----------------------------
INSERT INTO `tb_tale`
VALUES ('14', '101', '107', '刘毅', '2020-05-27 17:22:31', '抗疫战场上的“橡树”与“木棉”',
        '<p class=\"MsoNormal\" align=\"center\" style=\"text-autospace:ideograph-numeric;mso-pagination:none;text-align:center;\r\nline-height:28.0000pt;mso-line-height-rule:exactly;\"><img src=\"http://io.hllincheng.cn/FpmR9nAjoziW8CtcCV1FcjpL6UPA\" data-filename=\"2020/06/08/543d5096c07b3bb24a9696248143924e.jpg\" style=\"width: 100%;\"><br></p><p class=\"MsoNormal\" align=\"justify\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;text-align:justify;text-justify:inter-ideograph;\r\nline-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">都说上阵父子兵、打虎亲兄弟，在延安市强制隔离戒毒所阻击疫情的防线上却有这样一对夫妻拍档，用实干笃定前行，用忠诚践行人民警察的使命担当</font>——疫情不去、我们不退。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;text-align:justify;text-justify:inter-ideograph;\r\nline-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">抗疫战场上高峰如橡树一样挺拔，牢牢扎根在抗疫第一线，身体力行的履行党员义务，严格落实执行上级交办的各项任务。丝毫不顾眼疾（视网膜脱落），利用自己计算机特长，准备计算机操作课件，为全体民警传授计算机操作知识。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;text-align:justify;text-justify:inter-ideograph;\r\nline-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">后勤保障线上高巧平</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">如木棉一样红硕，从细节处入手做实从优待警工作，将温暖警心落实到极致，为一线抗疫的民警消除后顾之忧。</font></span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p><p class=\"MsoNormal\" align=\"justify\" style=\"text-indent:32.0000pt;mso-char-indent-count:2.0000;text-autospace:ideograph-numeric;\r\nmso-pagination:none;text-align:justify;text-justify:inter-ideograph;\r\nline-height:28.0000pt;mso-line-height-rule:exactly;\"><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><font face=\"仿宋_GB2312\">根紧握在地下，叶相触在云里，每一阵风过他们都相互致意，鼓励对方加油。他们一起分担寒潮、霹雳，坚韧不拔的立足本职岗位。他们一起共享雾霭、流岚，洋溢着青春的光华，谱写着新时代的赞歌，他们有着共同的名字</font>——警察。</span><span style=\"mso-spacerun:\'yes\';font-family:仿宋_GB2312;font-size:16.0000pt;\r\nmso-font-kerning:1.0000pt;\"><o:p></o:p></span></p>',
        null, null, '0', '', '2020-05-27 17:22:31', '', '2020-06-08 16:56:03', null);

-- ----------------------------
-- Table structure for tb_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_detail`;
CREATE TABLE `tb_user_detail`
(
    `detail_id`   int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`     int(20) DEFAULT NULL COMMENT '用户id',
    `user_file`   varchar(500) DEFAULT NULL COMMENT '履历文件',
    `start_time`  varchar(255) DEFAULT NULL COMMENT '开始时间',
    `end_time`    varchar(255) DEFAULT NULL COMMENT '结束时间',
    `introduce`   longtext COMMENT '履历介绍',
    `status`      varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='个人履历表';

-- ----------------------------
-- Records of tb_user_detail
-- ----------------------------
INSERT INTO `tb_user_detail`
VALUES ('1', '102', null, '2018-2019', null, '当选市领导干部', '0', 'admin', '2020-05-21 11:31:31', '', null, null);
INSERT INTO `tb_user_detail`
VALUES ('2', '102', null, '2019-2020', null, '当选省领导干部', '0', 'admin', '2020-05-21 11:32:22', 'admin',
        '2020-05-21 11:32:33', null);
INSERT INTO `tb_user_detail`
VALUES ('3', '128', null, '2020 - 2021', null, null, '0', '苗睿智', '2020-05-25 16:42:57', '', null, null);
INSERT INTO `tb_user_detail`
VALUES ('4', '130', 'http://qa06snok8.bkt.clouddn.com/Fp-4h2axyRpfGQpzmD35n9DHaPip,', null, null, null, '0', 'admin',
        '2020-05-25 17:42:06', '', null, null);

-- ----------------------------
-- Table structure for tb_violate
-- ----------------------------
DROP TABLE IF EXISTS `tb_violate`;
CREATE TABLE `tb_violate`
(
    `id`          int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `name`        varchar(255) DEFAULT NULL COMMENT '姓名',
    `event`       longtext COMMENT '事件',
    `punish`      longtext COMMENT '处罚',
    `start_time`  varchar(255) DEFAULT NULL COMMENT '开始时间',
    `end_time`    varchar(255) DEFAULT NULL COMMENT '结束时间',
    `status`      varchar(20)  DEFAULT '0' COMMENT '状态（0正常 1关闭）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='违规违纪表';

-- ----------------------------
-- Records of tb_violate
-- ----------------------------
INSERT INTO `tb_violate`
VALUES ('4', '张三', '<p>不遵守交通规则，违反交通次序</p>', '<p>罚款100元</p>', '2020-06-11', '2020-06-30', '0', 'admin',
        '2020-06-23 09:33:44', '', '2020-06-23 09:45:53', null);

-- ----------------------------
-- Table structure for tb_vote
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote`;
CREATE TABLE `tb_vote`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `title`       varchar(500) DEFAULT NULL COMMENT '标题',
    `content`     longtext COMMENT '内容',
    `status`      varchar(20)  DEFAULT '0' COMMENT '发布状态（0未开始 1进行中 2 已结束）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    `type`        varchar(20)  DEFAULT NULL COMMENT '类型(1 党代表管理  2换届管理)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='选举任务表';

-- ----------------------------
-- Records of tb_vote
-- ----------------------------
INSERT INTO `tb_vote`
VALUES ('11', '党代表选举', '<p><a href=\"http://localhost:8099/index\">党代表选举</a><br></p>', '2', 'admin',
        '2020-07-03 14:24:08', 'admin', '2020-07-03 14:34:44', '备注', '1');
INSERT INTO `tb_vote`
VALUES ('13', '换届11', '<p>选举组长</p>', '1', 'admin', '2020-07-06 10:42:13', 'admin', '2020-07-06 10:42:18', null,
        '2');
INSERT INTO `tb_vote`
VALUES ('14', '123', '<p>123<br></p>', '2', 'admin', '2020-07-24 14:43:53', 'admin', '2020-07-27 11:37:28', null, '1');
INSERT INTO `tb_vote`
VALUES ('15', '选举党员代表', '<p><br></p>', '1', 'admin', '2020-07-27 11:37:14', 'admin', '2020-07-27 11:37:22',
        '选举大佬', '1');
INSERT INTO `tb_vote`
VALUES ('16', '选举发布',
        '<p><span style=\"color: rgb(51, 51, 51); font-family: &quot;Microsoft YaHei&quot;, 微软雅黑; text-indent: 28px; background-color: rgb(244, 244, 244);\">根据选举法的规定，在直接选举中，有三种投票方式，即设立投票站、召开选举大会和设立流动票箱。选举委员会应当根据各选区选民分布状况，按照方便选民投票的原则来确定具体投票方式。投票选举在直接选举时，由选举委员会主持；在间接选举时，由各该级人大主席团主持。各级人大代表选举，一律采用无记名投票的方法。选举人对于代表候选人可以投赞成票，可以投反对票，可以另选其他任何选民，也可以弃权。选民可以经选举委员会同意委托投票。</span><br></p>',
        '1', 'admin', '2020-08-11 10:29:21', 'admin', '2020-08-11 10:29:31', null, '1');
INSERT INTO `tb_vote`
VALUES ('17', '书记选举', '<p>选举内容。。。</p>', '1', 'admin', '2020-08-11 10:44:48', 'admin', '2020-08-11 10:44:52',
        null, '1');
INSERT INTO `tb_vote`
VALUES ('18', '选举22', '<p>内容232</p>', '2', 'admin', '2020-08-11 10:50:44', 'admin', '2020-08-19 15:32:58', null,
        '1');

-- ----------------------------
-- Table structure for tb_vote_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote_record`;
CREATE TABLE `tb_vote_record`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `vote_id`         int(20) DEFAULT NULL COMMENT '选择任务id',
    `vote_user_id`    int(20) DEFAULT NULL COMMENT '选举人id',
    `vote_user_by_id` int(20) DEFAULT NULL COMMENT '被选举人id',
    `vote_count`      int(20) DEFAULT NULL COMMENT '票数',
    `status`          varchar(20)  DEFAULT '0' COMMENT '状态',
    `create_by`       varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time`     datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time`     datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`          varchar(255) DEFAULT NULL COMMENT '备注',
    `type`            varchar(20)  DEFAULT NULL COMMENT '类型(1 党代表管理  2换届管理)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='投票记录表';

-- ----------------------------
-- Records of tb_vote_record
-- ----------------------------
INSERT INTO `tb_vote_record`
VALUES ('16', '11', '25', '11', '1', '0', '', '2020-07-03 14:33:55', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('17', '11', '24', '11', '1', '0', '', '2020-07-03 14:34:07', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('21', '13', '28', '13', '1', '0', '', '2020-07-08 17:43:33', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('23', '15', '32', '17', '1', '0', '', '2020-07-27 11:57:01', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('24', '16', '33', '19', '1', '0', '', '2020-08-11 10:35:59', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('25', '16', '33', '19', '1', '0', '', '2020-08-11 10:36:03', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('26', '16', '33', '19', '1', '0', '', '2020-08-11 10:36:20', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('27', '16', '33', '19', '1', '0', '', '2020-08-11 10:36:26', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('28', '16', '34', '19', '1', '0', '', '2020-08-11 10:39:24', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('29', '16', '34', '19', '1', '0', '', '2020-08-11 10:39:29', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('30', '16', '34', '18', '1', '0', '', '2020-08-11 10:39:53', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('31', '17', '35', '21', '1', '0', '', '2020-08-11 10:45:41', '', null, null, null);
INSERT INTO `tb_vote_record`
VALUES ('32', '18', '37', '23', '1', '0', '', '2020-08-11 10:51:37', '', null, null, null);

-- ----------------------------
-- Table structure for tb_vote_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote_user`;
CREATE TABLE `tb_vote_user`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     int(20) DEFAULT NULL COMMENT '选举人id',
    `vote_id`     int(20) DEFAULT NULL COMMENT '选举任务id',
    `status`      varchar(20)  DEFAULT '0' COMMENT '状态（0未投票 1已投票）',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    `type`        varchar(20)  DEFAULT NULL COMMENT '类型(1 党代表管理  2换届管理)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='选举人表';

-- ----------------------------
-- Records of tb_vote_user
-- ----------------------------
INSERT INTO `tb_vote_user`
VALUES ('24', '107', '11', '1', 'admin', '2020-07-03 14:24:08', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('25', '1', '11', '1', 'admin', '2020-07-03 14:24:08', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('28', '1', '13', '1', 'admin', '2020-07-06 10:42:13', '', null, null, '2');
INSERT INTO `tb_vote_user`
VALUES ('29', '107', '14', '0', 'admin', '2020-07-24 14:43:53', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('30', '1', '14', '0', 'admin', '2020-07-24 14:43:53', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('31', '107', '15', '0', 'admin', '2020-07-27 11:37:14', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('32', '1', '15', '1', 'admin', '2020-07-27 11:37:14', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('33', '107', '16', '1', 'admin', '2020-08-11 10:29:21', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('34', '1', '16', '1', 'admin', '2020-08-11 10:29:21', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('35', '1', '17', '1', 'admin', '2020-08-11 10:44:48', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('36', '107', '17', '0', 'admin', '2020-08-11 10:44:48', '', null, null, '1');
INSERT INTO `tb_vote_user`
VALUES ('37', '1', '18', '1', 'admin', '2020-08-11 10:50:44', '', null, null, '1');

-- ----------------------------
-- Table structure for tb_vote_user_by
-- ----------------------------
DROP TABLE IF EXISTS `tb_vote_user_by`;
CREATE TABLE `tb_vote_user_by`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `user_id`     int(20) DEFAULT NULL COMMENT '被选举人id',
    `vote_id`     int(20) DEFAULT NULL COMMENT '选举任务id',
    `vote_count`  int(20) DEFAULT '0' COMMENT '票数',
    `status`      varchar(20)  DEFAULT '0' COMMENT '状态',
    `create_by`   varchar(64)  DEFAULT '' COMMENT '创建者',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(64)  DEFAULT '' COMMENT '更新者',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) DEFAULT NULL COMMENT '备注',
    `type`        varchar(20)  DEFAULT NULL COMMENT '类型(1 党代表管理  2换届管理)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='被选举人表';

-- ----------------------------
-- Records of tb_vote_user_by
-- ----------------------------
INSERT INTO `tb_vote_user_by`
VALUES ('11', '1', '11', '0', '0', 'admin', '2020-07-03 14:24:08', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('13', '107', '13', '0', '0', 'admin', '2020-07-06 10:42:13', '', null, null, '2');
INSERT INTO `tb_vote_user_by`
VALUES ('14', '1', '13', '0', '0', 'admin', '2020-07-06 10:42:13', '', null, null, '2');
INSERT INTO `tb_vote_user_by`
VALUES ('15', '1', '14', '0', '0', 'admin', '2020-07-24 14:43:53', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('16', '107', '14', '0', '0', 'admin', '2020-07-24 14:43:53', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('17', '107', '15', '0', '0', 'admin', '2020-07-27 11:37:14', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('18', '198', '16', '0', '0', 'admin', '2020-08-11 10:29:21', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('19', '107', '16', '0', '0', 'admin', '2020-08-11 10:29:21', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('20', '1', '16', '0', '0', 'admin', '2020-08-11 10:29:21', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('21', '198', '17', '0', '0', 'admin', '2020-08-11 10:44:48', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('22', '107', '17', '0', '0', 'admin', '2020-08-11 10:44:48', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('23', '1', '18', '0', '0', 'admin', '2020-08-11 10:50:44', '', null, null, '1');
INSERT INTO `tb_vote_user_by`
VALUES ('24', '107', '18', '0', '0', 'admin', '2020-08-11 10:50:44', '', null, null, '1');

-- ----------------------------
-- Table structure for tb_work
-- ----------------------------
DROP TABLE IF EXISTS `tb_work`;
CREATE TABLE `tb_work`
(
    `work_id`    int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `title`      varchar(255)  DEFAULT NULL COMMENT '标题',
    `grade`      varchar(20)   DEFAULT NULL COMMENT '等级',
    `introduce`  varchar(4000) DEFAULT NULL COMMENT '说明',
    `start_time` varchar(255)  DEFAULT NULL COMMENT '开始时间',
    `end_time`   varchar(255)  DEFAULT NULL COMMENT '截至时间',
    `user_id`    int(20) DEFAULT NULL COMMENT '操作人id',
    `user_name`  varchar(255)  DEFAULT NULL COMMENT '操作人姓名',
    `user_time`  datetime      DEFAULT NULL COMMENT '操作时间',
    `dist_id`    int(11) DEFAULT NULL COMMENT '分配给id',
    `dist_name`  varchar(255)  DEFAULT NULL COMMENT '分配给',
    `score`      varchar(255)  DEFAULT NULL COMMENT '分值',
    `work_file`  varchar(255)  DEFAULT NULL COMMENT '文件',
    `status`     varchar(10)   DEFAULT NULL COMMENT '状态(1 待执行 2 执行中 3 待验证 4 退回 5 已完成)',
    PRIMARY KEY (`work_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';

-- ----------------------------
-- Records of tb_work
-- ----------------------------

-- ----------------------------
-- Table structure for tb_work_dist
-- ----------------------------
DROP TABLE IF EXISTS `tb_work_dist`;
CREATE TABLE `tb_work_dist`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `dist_id`   int(11) NOT NULL COMMENT '分配给id',
    `dist_name` varchar(255) DEFAULT NULL COMMENT '分配给',
    `work_id`   int(11) DEFAULT NULL COMMENT '任务id',
    `score`     varchar(255) DEFAULT NULL COMMENT '分值',
    `work_file` varchar(255) DEFAULT NULL COMMENT '文件',
    `status`    varchar(10)  DEFAULT NULL COMMENT '状态(1 待执行 2 执行中 3 待验证 4 退回 5 已完成)',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8 COMMENT='任务分配表';

-- ----------------------------
-- Records of tb_work_dist
-- ----------------------------
INSERT INTO `tb_work_dist`
VALUES ('131', '1', null, '23', null, null, '1');

-- ----------------------------
-- Table structure for tb_work_flow
-- ----------------------------
DROP TABLE IF EXISTS `tb_work_flow`;
CREATE TABLE `tb_work_flow`
(
    `flow_id`        int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `work_id`        int(20) DEFAULT NULL COMMENT '任务id',
    `dist_id`        int(20) DEFAULT NULL COMMENT '分配表id',
    `deal_id`        int(20) DEFAULT NULL COMMENT '处理人id',
    `deal_name`      varchar(255)  DEFAULT NULL COMMENT '处理人姓名',
    `current_status` varchar(255)  DEFAULT NULL COMMENT '当前状态',
    `level`          varchar(255)  DEFAULT NULL COMMENT '等级(1 执行人 2 验证人)',
    `deal_status`    varchar(255)  DEFAULT NULL COMMENT '执行状态(1 执行中 2 已完成 3不同意  4 同意) ',
    `action_name`    varchar(255)  DEFAULT NULL COMMENT '动作(1执行人执行 2 提交人验证)',
    `deal_explain`   varchar(4000) DEFAULT NULL COMMENT '执行说明',
    `deal_time`      datetime      DEFAULT NULL COMMENT '执行时间',
    `create_by`      varchar(64)   DEFAULT '' COMMENT '创建者',
    `create_time`    datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(64)   DEFAULT '' COMMENT '更新者',
    `update_time`    datetime      DEFAULT NULL COMMENT '更新时间',
    `remark`         varchar(255)  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`flow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务流程表';

-- ----------------------------
-- Records of tb_work_flow
-- ----------------------------
