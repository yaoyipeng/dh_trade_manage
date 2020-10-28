-- 创建用户
CREATE USER yypssm IDENTIFIED BY 123456;
-- 赋权限
-- 登录权限
GRANT CONNECT to yypssm;
-- 资源使用权限
GRANT RESOURCE to yypssm;

/*drop table FACTORY_C cascade constraints;*/

/*==============================================================*/
/* Table: FACTORY_C                                             */
/*==============================================================*/
create table FACTORY_C 
(
   FACTORY_ID           VARCHAR2(40)         not null,
   FULL_NAME            VARCHAR2(200),
   FACTORY_NAME         VARCHAR2(50),
   CONTACTOR            VARCHAR2(30),
   PHONE                VARCHAR2(20),
   MOBILE               VARCHAR2(20),
   FAX                  VARCHAR2(20),
   CNOTE                CLOB,
   CTYPE                INTEGER,
   STATE                CHAR(1),
   INSPECTOR            VARCHAR2(30),
   ORDER_NO             INTEGER,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_FACTORY_C primary key (FACTORY_ID)
);

comment on column FACTORY_C.CTYPE is
'SYS_CODE_B 0103';

comment on column FACTORY_C.STATE is
'1正常2停止';




/*alter table ITEMS_C
   drop constraint FK_ITEMS_C_REFERENCE_FACTORY_;

drop table ITEMS_C cascade constraints;*/

/*==============================================================*/
/* Table: ITEMS_C                                               */
/*==============================================================*/
create table ITEMS_C 
(
   ITEMS_ID             VARCHAR2(40)         not null,
   ITEM_NO              VARCHAR2(40),
   ITEM_IMAGE           VARCHAR2(200),
   DESCRIPTION          VARCHAR2(200),
   FACTORY_ID           VARCHAR2(40),
   FACTORY              VARCHAR2(250),
   PRICE                NUMBER(10,3),
   SIZE_LENGHT          NUMBER(10,3),
   SIZE_WIDTH           NUMBER(10,3),
   SIZE_HEIGHT          NUMBER(10,3),
   COLOR                VARCHAR2(200),
   PACKING              VARCHAR2(20),
   PACKING_UNIT         VARCHAR2(10),
   TYPE20               NUMBER(10,3),
   TYPE40               NUMBER(10,3),
   TYPE40HC             NUMBER(10,3),
   QTY                  INTEGER,
   CBM                  NUMBER(10,3),
   MPSIZE_LENGHT        NUMBER(10,3),
   MPSIZE_WIDTH         NUMBER(10,3),
   MPSIZE_HEIGHT        NUMBER(10,3),
   CNOTE                VARCHAR2(500),
   INPUT_TIME           DATE,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_ITEMS_C primary key (ITEMS_ID)
);

comment on column ITEMS_C.COLOR is
'会写很多内容';

comment on column ITEMS_C.PACKING_UNIT is
'PCS/SETS';

comment on column ITEMS_C.CNOTE is
'NOTE';

comment on column ITEMS_C.INPUT_TIME is
'CREATEDATE';

alter table ITEMS_C
   add constraint FK_ITEMS_C_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);


/*drop table USER_TEMP_B cascade constraints;*/

/*==============================================================*/
/* Table: USER_TEMP_B                                           */
/*==============================================================*/
create table USER_TEMP_B 
(
   USER_TEMP_ID         VARCHAR2(40)         not null,
   KEY_CLASS            VARCHAR2(30),
   KEY_NAME             VARCHAR2(30),
   KEY_CONTENT          VARCHAR2(3000),
   STATE                INTEGER,
   ORDER_NO             INTEGER,
   CNOTE                VARCHAR2(50),
   UPDATE_BY            VARCHAR2(40),
   UPDATE_TIME          DATE,
   constraint PK_USER_TEMP_B primary key (USER_TEMP_ID)
);

comment on column USER_TEMP_B.STATE is
'0停用1启用';


/*drop table CONTRACT_C cascade constraints;*/

/*==============================================================*/
/* Table: CONTRACT_C                                            */
/*==============================================================*/
create table CONTRACT_C 
(
   CONTRACT_ID          VARCHAR2(40)         not null,
   OFFEROR              VARCHAR2(200),
   CONTRACT_NO          VARCHAR2(20),
   SIGNING_DATE         DATE,
   INPUT_BY             VARCHAR2(30),
   CHECK_BY             VARCHAR2(30),
   INSPECTOR            VARCHAR2(30),
   TOTAL_AMOUNT         NUMBER(10,2),
   REQUEST              VARCHAR2(200),
   CUSTOM_NAME          VARCHAR2(200),
   SHIP_TIME            DATE,
   IMPORT_NUM           INTEGER,
   DELIVERY_PERIOD      DATE,
   REMARK               VARCHAR2(600),
   PRINT_STYLE          CHAR(1),
   OLD_STATE            INTEGER,
   STATE                INTEGER,
   OUT_STATE            INTEGER,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   TRADE_TERMS          VARCHAR2(30),
   constraint PK_CONTRACT_C primary key (CONTRACT_ID)
);

comment on column CONTRACT_C.IMPORT_NUM is
'打印时标识几个星,对应说明中的内容';

comment on column CONTRACT_C.PRINT_STYLE is
'宽2:一页两个货物  窄1:一页一个货物';

comment on column CONTRACT_C.OLD_STATE is
'归档前状态, 方便回退';

comment on column CONTRACT_C.STATE is
'0归档 1草稿 2待报运

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

comment on column CONTRACT_C.OUT_STATE is
'0未走货 1部分 2全部

归档后, 其他选择合同的地方均去除.
表示合同已完成, 不论是否合同的货物是否全部真的走完, 因为有赔付等其他情况';

/*alter table CONTRACT_PRODUCT_C
   drop constraint FK_CONTRACT_REFERENCE_CONTRACT;

alter table CONTRACT_PRODUCT_C
   drop constraint FK_CONTRACT_REFERENCE_FACTORY_;

drop table CONTRACT_PRODUCT_C cascade constraints;*/

/*==============================================================*/
/* Table: CONTRACT_PRODUCT_C                                    */
/*==============================================================*/
create table CONTRACT_PRODUCT_C 
(
   CONTRACT_PRODUCT_ID  VARCHAR2(40)         not null,
   CONTRACT_ID          VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER,
   constraint PK_CONTRACT_PRODUCT_C primary key (CONTRACT_PRODUCT_ID)
);

comment on column CONTRACT_PRODUCT_C.LOADING_RATE is
'x/y';

comment on column CONTRACT_PRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column CONTRACT_PRODUCT_C.FINISHED is
'0是1否';

comment on column CONTRACT_PRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

comment on column CONTRACT_PRODUCT_C.EX_UNIT is
'$/￥';

comment on column CONTRACT_PRODUCT_C.NO_TAX is
'收购单价';

comment on column CONTRACT_PRODUCT_C.TAX is
'收购单价';

comment on column CONTRACT_PRODUCT_C.COST_PRICE is
'自动计算=数量x含税/1.17标准值';

comment on column CONTRACT_PRODUCT_C.COST_TAX is
'自动计算=数量x含税-收购成本金额';

comment on column CONTRACT_PRODUCT_C.ACCESSORIES is
'0是1否';

alter table CONTRACT_PRODUCT_C
   add constraint FK_CONTRACT_REFERENCE_CONTRACT foreign key (CONTRACT_ID)
      references CONTRACT_C (CONTRACT_ID);

alter table CONTRACT_PRODUCT_C
   add constraint FK_CONTRACT_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);


/*alter table EXT_CPRODUCT_C
   drop constraint FK_EXT_CPRO_REFERENCE_FACTORY_;

alter table EXT_CPRODUCT_C
   drop constraint FK_EXT_CPRO_REFERENCE_CONTRACT;

drop table EXT_CPRODUCT_C cascade constraints;*/

/*==============================================================*/
/* Table: EXT_CPRODUCT_C                                        */
/*==============================================================*/
create table EXT_CPRODUCT_C 
(
   EXT_CPRODUCT_ID      VARCHAR2(40)         not null,
   FACTORY_ID           VARCHAR2(40),
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   CTYPE                INTEGER,
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER,
   constraint PK_EXT_CPRODUCT_C primary key (EXT_CPRODUCT_ID)
);

comment on column EXT_CPRODUCT_C.CTYPE is
'SYS_CODE=0104';

comment on column EXT_CPRODUCT_C.LOADING_RATE is
'x/y';

comment on column EXT_CPRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXT_CPRODUCT_C.FINISHED is
'0是1否';

comment on column EXT_CPRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

comment on column EXT_CPRODUCT_C.EX_UNIT is
'$/￥';

comment on column EXT_CPRODUCT_C.NO_TAX is
'收购单价';

comment on column EXT_CPRODUCT_C.TAX is
'收购单价';

comment on column EXT_CPRODUCT_C.COST_PRICE is
'自动计算=数量x含税/1.17标准值';

comment on column EXT_CPRODUCT_C.COST_TAX is
'自动计算=数量x含税-收购成本金额';

comment on column EXT_CPRODUCT_C.ACCESSORIES is
'0是1否';

alter table EXT_CPRODUCT_C
   add constraint FK_EXT_CPRO_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table EXT_CPRODUCT_C
   add constraint FK_EXT_CPRO_REFERENCE_CONTRACT foreign key (CONTRACT_PRODUCT_ID)
      references CONTRACT_PRODUCT_C (CONTRACT_PRODUCT_ID);

/*drop table EXPORT_C cascade constraints;*/

/*==============================================================*/
/* Table: EXPORT_C                                              */
/*==============================================================*/
create table EXPORT_C 
(
   EXPORT_ID            VARCHAR2(40)         not null,
   INPUT_DATE           DATE,
   CONTRACT_IDS         VARCHAR2(200),
   CUSTOMER_CONTRACT    VARCHAR2(200),
   LCNO                 VARCHAR2(10),
   CONSIGNEE            VARCHAR2(100),
   MARKS                VARCHAR2(1000),
   SHIPMENT_PORT        VARCHAR2(100),
   DESTINATION_PORT     VARCHAR2(100),
   TRANSPORT_MODE       VARCHAR2(10),
   PRICE_CONDITION      VARCHAR2(10),
   REMARK               VARCHAR2(100),
   BOX_NUM              INTEGER,
   CNUMBER              INTEGER,
   PACKING_UNIT         VARCHAR2(10),
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   CSIZE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   STATE                INTEGER,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_EXPORT_C primary key (EXPORT_ID)
);

comment on column EXPORT_C.CUSTOMER_CONTRACT is
'客户的合同号,可选择多个合同';

comment on column EXPORT_C.LCNO is
'L/C T/T';

comment on column EXPORT_C.TRANSPORT_MODE is
'SEA/AIR';

comment on column EXPORT_C.PRICE_CONDITION is
'FBO/CIF';

comment on column EXPORT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXPORT_C.AMOUNT is
'自动计算: 数量x单价';

comment on column EXPORT_C.NO_TAX is
'收购单价';

comment on column EXPORT_C.TAX is
'收购单价';

comment on column EXPORT_C.COST_PRICE is
'自动计算=数量x含税/1.17标准值';

comment on column EXPORT_C.COST_TAX is
'自动计算=数量x含税-收购成本金额';

comment on column EXPORT_C.STATE is
'0草稿 1上报';

/*alter table EXPORT_PRODUCT_C
   drop constraint FK_EXPORT_P_REFERENCE_FACTORY_;

alter table EXPORT_PRODUCT_C
   drop constraint FK_EXPORT_P_REFERENCE_EXPORT_C;

drop table EXPORT_PRODUCT_C cascade constraints;*/

/*==============================================================*/
/* Table: EXPORT_PRODUCT_C                                      */
/*==============================================================*/
create table EXPORT_PRODUCT_C 
(
   EXPORT_PRODUCT_ID    VARCHAR2(40)         not null,
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   EXPORT_ID            VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   CONTRACT_ID          VARCHAR2(40),
   CONTRACT_NO          VARCHAR2(20),
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER,
   constraint PK_EXPORT_PRODUCT_C primary key (EXPORT_PRODUCT_ID)
);

comment on column EXPORT_PRODUCT_C.CONTRACT_PRODUCT_ID is
'标识从哪个合同货物而来';

comment on column EXPORT_PRODUCT_C.LOADING_RATE is
'x/y';

comment on column EXPORT_PRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXPORT_PRODUCT_C.FINISHED is
'0是1否';

comment on column EXPORT_PRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

comment on column EXPORT_PRODUCT_C.EX_PRICE is
'sales confirmation 中的价格（手填）';

comment on column EXPORT_PRODUCT_C.EX_UNIT is
'$/￥';

comment on column EXPORT_PRODUCT_C.NO_TAX is
'空着,EXCEL手工填';

comment on column EXPORT_PRODUCT_C.TAX is
'收购单价=合同单价';

comment on column EXPORT_PRODUCT_C.COST_PRICE is
'自动计算=数量x含税/1.17标准值';

comment on column EXPORT_PRODUCT_C.COST_TAX is
'自动计算=数量x含税-收购成本金额';

comment on column EXPORT_PRODUCT_C.ACCESSORIES is
'0是1否';

alter table EXPORT_PRODUCT_C
   add constraint FK_EXPORT_P_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table EXPORT_PRODUCT_C
   add constraint FK_EXPORT_P_REFERENCE_EXPORT_C foreign key (EXPORT_ID)
      references EXPORT_C (EXPORT_ID);

/*alter table EXT_EPRODUCT_C
   drop constraint FK_EXT_EPRO_REFERENCE_FACTORY_;

alter table EXT_EPRODUCT_C
   drop constraint FK_EXT_EPRO_REFERENCE_EXPORT_P;

drop table EXT_EPRODUCT_C cascade constraints;*/

/*==============================================================*/
/* Table: EXT_EPRODUCT_C                                        */
/*==============================================================*/
create table EXT_EPRODUCT_C 
(
   EXT_EPRODUCT_ID      VARCHAR2(40)         not null,
   FACTORY_ID           VARCHAR2(40),
   CTYPE                VARCHAR2(40),
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER,
   EXPORT_PRODUCT_ID    VARCHAR2(40),
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   constraint PK_EXT_EPRODUCT_C primary key (EXT_EPRODUCT_ID)
);

comment on column EXT_EPRODUCT_C.FACTORY_ID is
'标识从哪个合同货物而来';

comment on column EXT_EPRODUCT_C.LOADING_RATE is
'x/y';

comment on column EXT_EPRODUCT_C.PACKING_UNIT is
'PCS/SETS';

comment on column EXT_EPRODUCT_C.AMOUNT is
'自动计算: 数量x单价';

comment on column EXT_EPRODUCT_C.EX_PRICE is
'sales confirmation 中的价格（手填）';

comment on column EXT_EPRODUCT_C.EX_UNIT is
'$/￥';

comment on column EXT_EPRODUCT_C.NO_TAX is
'空着,EXCEL手工填';

comment on column EXT_EPRODUCT_C.TAX is
'收购单价=合同单价';

comment on column EXT_EPRODUCT_C.COST_PRICE is
'自动计算=数量x含税/1.17标准值';

comment on column EXT_EPRODUCT_C.COST_TAX is
'自动计算=数量x含税-收购成本金额';

comment on column EXT_EPRODUCT_C.ACCESSORIES is
'0是1否';

alter table EXT_EPRODUCT_C
   add constraint FK_EXT_EPRO_REFERENCE_FACTORY_ foreign key (FACTORY_ID)
      references FACTORY_C (FACTORY_ID);

alter table EXT_EPRODUCT_C
   add constraint FK_EXT_EPRO_REFERENCE_EXPORT_P foreign key (EXPORT_PRODUCT_ID)
      references EXPORT_PRODUCT_C (EXPORT_PRODUCT_ID);

/*alter table HOME_PACKING_LIST_C
   drop constraint FK_HOME_PAC_REFERENCE_EXPORT_C;

drop table HOME_PACKING_LIST_C cascade constraints;*/

/*==============================================================*/
/* Table: HOME_PACKING_LIST_C                                   */
/*==============================================================*/
create table HOME_PACKING_LIST_C 
(
   HOME_PACKING_LIST_ID VARCHAR2(40)         not null,
   EXPORT_ID            VARCHAR2(40),
   SELLER               VARCHAR2(200),
   BUYER                VARCHAR2(200),
   MARKS                VARCHAR2(200),
   DESCRIPTIONS         VARCHAR2(200),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_HOME_PACKING_LIST_C primary key (HOME_PACKING_LIST_ID)
);

alter table HOME_PACKING_LIST_C
   add constraint FK_HOME_PAC_REFERENCE_EXPORT_C foreign key (EXPORT_ID)
      references EXPORT_C (EXPORT_ID);


/*alter table PACKING_LIST_C
   drop constraint FK_PACKING__REFERENCE_EXPORT_C;

drop table PACKING_LIST_C cascade constraints;*/

/*==============================================================*/
/* Table: PACKING_LIST_C                                        */
/*==============================================================*/
create table PACKING_LIST_C 
(
   PACKING_LIST_ID      VARCHAR2(40)         not null,
   EXPORT_ID            VARCHAR2(40),
   SELLER               VARCHAR2(200),
   BUYER                VARCHAR2(200),
   INVOICE_NO           VARCHAR2(30),
   INVOICE_DATE         DATE,
   MARKS                VARCHAR2(200),
   DESCRIPTIONS         VARCHAR2(200),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   EXPORT_NOS           VARCHAR2(200),
   STATE                INTEGER,
   EXPORT_IDS           VARCHAR2(200),
   constraint PK_PACKING_LIST_C primary key (PACKING_LIST_ID)
);

comment on column PACKING_LIST_C.INVOICE_NO is
'选择';

alter table PACKING_LIST_C
   add constraint FK_PACKING__REFERENCE_EXPORT_C foreign key (EXPORT_ID)
      references EXPORT_C (EXPORT_ID);

/*alter table SHIPPING_ORDER_C
   drop constraint FK_SHIPPING_REFERENCE_PACKING_;

drop table SHIPPING_ORDER_C cascade constraints;*/

/*==============================================================*/
/* Table: SHIPPING_ORDER_C                                      */
/*==============================================================*/
create table SHIPPING_ORDER_C 
(
   SHIPPING_ORDER_ID    VARCHAR2(40)         not null,
   PACKING_LIST_ID      VARCHAR2(40),
   ORDER_TYPE           CHAR(1),
   SHIPPER              VARCHAR2(200),
   CONSIGNEE            VARCHAR2(200),
   NOTIFY_PARTY         VARCHAR2(200),
   LC_NO                VARCHAR2(30),
   PORT_OF_LOADING      VARCHAR2(30),
   PORT_OF_TRANS        VARCHAR2(30),
   PORT_OF_DISCHARGE    VARCHAR2(30),
   LOADING_DATE         DATE,
   LIMIT_DATE           DATE,
   IS_BATCH             CHAR(1),
   IS_TRANS             CHAR(1),
   COPY_NUM             VARCHAR2(20),
   CNOTE                VARCHAR2(200),
   SPECIAL_CONDITION    VARCHAR2(200),
   FREIGHT              VARCHAR2(200),
   CHECK_BY             VARCHAR2(30),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_SHIPPING_ORDER_C primary key (SHIPPING_ORDER_ID)
);

comment on column SHIPPING_ORDER_C.ORDER_TYPE is
'0海运/1空运';

comment on column SHIPPING_ORDER_C.IS_BATCH is
'0是1否';

comment on column SHIPPING_ORDER_C.IS_TRANS is
'0是1否';

alter table SHIPPING_ORDER_C
   add constraint FK_SHIPPING_REFERENCE_PACKING_ foreign key (PACKING_LIST_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);

/*alter table INVOICE_C
   drop constraint FK_INVOICE__REFERENCE_PACKING_;

drop table INVOICE_C cascade constraints;*/

/*==============================================================*/
/* Table: INVOICE_C                                             */
/*==============================================================*/
create table INVOICE_C 
(
   INVOICE_ID           VARCHAR2(40)         not null,
   PACKING_LIST_ID      VARCHAR2(40),
   SC_NO                VARCHAR2(30),
   BL_NO                VARCHAR2(30),
   TRADE_TERMS          VARCHAR2(30),
   DESCRIPTIONS         VARCHAR2(200),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_INVOICE_C primary key (INVOICE_ID)
);

alter table INVOICE_C
   add constraint FK_INVOICE__REFERENCE_PACKING_ foreign key (PACKING_LIST_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);

/*alter table FINANCE_C
   drop constraint FK_FINANCE__REFERENCE_PACKING_;

drop table FINANCE_C cascade constraints;*/

/*==============================================================*/
/* Table: FINANCE_C                                             */
/*==============================================================*/
create table FINANCE_C 
(
   FINANCE_ID           VARCHAR2(40)         not null,
   PACKING_LIST_ID      VARCHAR2(40),
   INPUT_DATE           DATE,
   INPUT_BY             VARCHAR2(30),
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_FINANCE_C primary key (FINANCE_ID)
);

alter table FINANCE_C
   add constraint FK_FINANCE__REFERENCE_PACKING_ foreign key (PACKING_LIST_ID)
      references PACKING_LIST_C (PACKING_LIST_ID);


/*drop table FEEDBACK_C cascade constraints;*/

/*==============================================================*/
/* Table: FEEDBACK_C                                            */
/*==============================================================*/
create table FEEDBACK_C 
(
   FEEDBACK_ID          VARCHAR2(40)         not null,
   INPUT_BY             VARCHAR2(20),
   INPUT_TIME           TIMESTAMP,
   TITLE                VARCHAR2(200),
   CONTENT              VARCHAR2(2000),
   CLASS_TYPE           CHAR(1),
   TEL                  VARCHAR2(20),
   ANSWER_BY            VARCHAR2(20),
   ANSWER_TIME          TIMESTAMP,
   SOLVE_METHOD         VARCHAR2(2000),
   RESOLUTION           CHAR(1),
   DIFFICULTY           CHAR(1),
   IS_SHARE             CHAR(1),
   STATE                INTEGER,
   CREATE_BY            VARCHAR2(40),
   CREATE_DEPT          VARCHAR2(40),
   CREATE_TIME          DATE,
   constraint PK_FEEDBACK_C primary key (FEEDBACK_ID)
);

comment on column FEEDBACK_C.CLASS_TYPE is
'1管理2安全3建议4其他';

comment on column FEEDBACK_C.RESOLUTION is
'1已修改2无需修改3重复问题4描述不完整5无法再现6其他';

comment on column FEEDBACK_C.DIFFICULTY is
'1极难2比较难3有难度4一般';

comment on column FEEDBACK_C.IS_SHARE is
'0不公开1公开';

comment on column FEEDBACK_C.STATE is
'0未处理1已处理';

/*drop table SYS_CODE_B cascade constraints;*/

/*==============================================================*/
/* Table: SYS_CODE_B                                            */
/*==============================================================*/
create table SYS_CODE_B 
(
   SYS_CODE_ID          VARCHAR2(40)         not null,
   NAME                 VARCHAR2(100),
   PARENT_ID            VARCHAR2(40),
   PARENT_NAME          VARCHAR2(100),
   LAYER_NUM            INTEGER,
   IS_LEAF              INTEGER,
   QUOTE_NUM            INTEGER,
   CNOTE                VARCHAR2(100),
   ICO                  VARCHAR2(20),
   ORDER_NO             INTEGER,
   STATE                CHAR(1),
   CREATED_BY           VARCHAR2(40),
   CREATED_TIME         TIMESTAMP,
   UPDATED_BY           VARCHAR2(40),
   UPDATED_TIME         TIMESTAMP,
   constraint PK_SYS_CODE_B primary key (SYS_CODE_ID)
);

/*历史合同表*/


create table CONTRACT_HIS_C
(
  CONTRACT_ID     VARCHAR2(40) primary key not null,
  OFFEROR         VARCHAR2(200),
  CONTRACT_NO     VARCHAR2(50),
  SIGNING_DATE    TIMESTAMP(6),
  INPUT_BY        VARCHAR2(30),
  CHECK_BY        VARCHAR2(30),
  INSPECTOR       VARCHAR2(30),
  TOTAL_AMOUNT    NUMBER(10,2),
  REQUEST        VARCHAR2(2000),
  CUSTOM_NAME     VARCHAR2(200),
  SHIP_TIME       TIMESTAMP(6),
  IMPORT_NUM      INTEGER,
  DELIVERY_PERIOD TIMESTAMP(6),
  REMARK          VARCHAR2(600),
  PRINT_STYLE     CHAR(1),
  OLD_STATE       INTEGER,
  STATE           INTEGER,
  OUT_STATE       INTEGER,
  CREATE_BY       VARCHAR2(40),
  CREATE_DEPT     VARCHAR2(40),
  CREATE_TIME     TIMESTAMP(6),
  TRADE_TERMS     VARCHAR2(30)
);


create table CONTRACT_PRODUCT_HIS_C
(
   CONTRACT_PRODUCT_ID  VARCHAR2(40)    primary key     not null,
   CONTRACT_ID          VARCHAR2(40),
   FACTORY_ID           VARCHAR2(40),
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER
);

create table EXT_CPRODUCT_HIS_C
(
  EXT_CPRODUCT_ID     VARCHAR2(40) primary key not null,
   FACTORY_ID           VARCHAR2(40),
   CONTRACT_PRODUCT_ID  VARCHAR2(40),
   CTYPE                INTEGER,
   PRODUCT_NAME         VARCHAR2(200),
   PRODUCT_NO           VARCHAR2(50),
   PRODUCT_IMAGE        VARCHAR2(200),
   PRODUCT_DESC         VARCHAR2(600),
   LOADING_RATE         VARCHAR2(30),
   PACKING_UNIT         VARCHAR2(10),
   CNUMBER              INTEGER,
   OUT_NUMBER           INTEGER,
   FINISHED             SMALLINT,
   GROSS_WEIGHT         NUMBER(10,2),
   NET_WEIGHT           NUMBER(10,2),
   SIZE_LENGHT          NUMBER(10,2),
   SIZE_WIDTH           NUMBER(10,2),
   SIZE_HEIGHT          NUMBER(10,2),
   PRODUCT_REQUEST      VARCHAR2(2000),
   FACTORY              VARCHAR2(200),
   PRICE                NUMBER(10,2),
   AMOUNT               NUMBER(10,2),
   CUNIT                VARCHAR2(10),
   BOX_NUM              INTEGER,
   EX_PRICE             NUMBER(10,2),
   EX_UNIT              VARCHAR2(10),
   NO_TAX               NUMBER(10,2),
   TAX                  NUMBER(10,2),
   COST_PRICE           NUMBER(10,2),
   COST_TAX             NUMBER(10,2),
   ACCESSORIES          SMALLINT,
   ORDER_NO             INTEGER
);

/*数据库压力测试*/
/*
create table "online_t" 
(
   A1                   VARCHAR2(2)          not null,
   constraint PK_ONLINE_T primary key (A1)
);

create table "login_log_p" 
(
   LOGIN_LOG_ID         VARCHAR2(40)         not null,
   LOGIN_NAME           VARCHAR2(30),
   IP_ADDRESS           VARCHAR2(20),
   LOGIN_TIME           DATE,
   constraint PK_LOGIN_LOG_P primary key (LOGIN_LOG_ID)
);
*/