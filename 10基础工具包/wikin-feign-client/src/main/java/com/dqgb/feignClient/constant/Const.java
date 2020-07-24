//package com.dqgb.feignClient.constant;
//
//import lombok.Getter;
//
///**
// * 常量
// *
// * @author :技术部-zhangjs
// * @className ResourceConst
// * @Description 常量
// * @date 2019年9月23日 下午1:55:43
// */
//public class Const {
//    /**
//     * 系统常量
//     */
//    public static class System{
//        /**
//         * 编码
//         */
//        public static final String CHARSET="UTF-8";
//        public static final String DEFAULT_CHARSET = "iso8859-1";
//    }
//    /**
//     * 日志类型
//     *
//     * @author :技术部-zhangjs
//     * @className ResourceConst
//     * @Description 日志类型
//     * @date 2019年9月23日 下午1:55:43
//     */
//    public static class LogType {
//        /**
//         * 添加日志
//         */
//        public static final String ADD = "Service Log(ADD) ";
//        /**
//         * 删除日志
//         */
//        public static final String DELETE = "Service Log(DELETE) ";
//        /**
//         * 修改日志
//         */
//        public static final String MODIFY = "Service Log(MODIFY) ";
//        /**
//         * 查询日志
//         */
//        public static final String SEARCH = "Service Log(SEARCH) ";
//    }
//
//    /**
//     * 通知类型
//     *
//     * @author :技术部-zhangjs
//     * @className ResourceConst
//     * @Description 通知类型
//     * @date 2019年9月23日 下午1:55:43
//     */
//    public static class NoticeType {
//        /**
//         * 发送通知给指定的人
//         */
//        public static final Integer SEND_TO_USERS = 1;
//        /**
//         * 发送通知给指定的部门
//         */
//        public static final Integer SEND_TO_DEPTS = 2;
//        /**
//         * 发送通知给指定的角色
//         */
//        public static final Integer SEND_TO_ROLES = 3;
//        /**
//         * 发送通知给指定部门下的指定角色
//         */
//        public static final Integer SEND_TO_DEPT_AND_ROLE = 4;
//        /**
//         * 发送短信通知
//         */
//        public static final Integer SMS_NOTICE = 0;
//        /**
//         * 发送站内通知
//         */
//        public static final Integer INSIDE_NOTICE = 1;
//    }
//
//    /**
//     * 响应编码
//     *
//     * @author :技术部-zhangjs
//     * @className ResponseMsg
//     * @Description 响应编码
//     * @date 2019年9月23日 下午2:04:57
//     */
//    public enum ResponseMsg {
//        /**
//         * 操作成功
//         */
//        SUCCESS("000000", "操作成功"),
//        /**
//         * 失败
//         */
//        FAILED("999999", "操作失败"),
//        /**
//         * 非法参数
//         */
//        ILLEGAL_PARAM("000001", "非法的参数"),
//        /**
//         * 没有对应的结果数据
//         */
//        NO_MAPPING_RESULT("000002", "没有对应的结果数据"),
//        /**
//         * 查询详情，修改，删除失败，因为数据不存在
//         */
//        REF_OBJ_NOT_EXISIT("000003", "查询的数据不存在"),
//        /**
//         * 已经被使用
//         */
//        OBJ_BEEN_USED("000004", "已经被使用"),
//        /**
//         * 不允许被删除
//         */
//        DELETE_FORBIDDEN("000005", "不允许被删除"),
//        /**
//         * 不允许被修改
//         */
//        MODIFY_FORBIDDEN("000006", "不允许被修改"),
//        /**
//         * 参数类型转换错误
//         */
//        CLASS_CAST_ERROR("000007", "参数类型转换错误"),
//        /**
//         * 数据库操作错误
//         */
//        DATABASE_OPERATION_ERROR("000008", "数据库操作错误"),
//        /**
//         *  IO异常
//         */
//        IO_EXCEPTION("000009", "IO异常"),
//        /**
//         * 请求超时
//         */
//        TIME_OUT_EXCEPTION("000010", "请求超时"),
//        /**
//         * 数据保存失败：数据类型错误
//         */
//        CLASS_CAST_EXCEPTION ("000011", "数据保存失败：数据类型错误"),
//        /**
//         * 数组下标越界
//         */
//        INDEX_OUT_OF_BOUNDS_EXCEPTION("000012", "数组下标越界"),
//        /**
//         * 空指针
//         */
//        NULL_POINTER_EXCEPTION("000013", "空指针"),
//        /**
//         * 插入数据与该表所对应的字段长度或类型不一致
//         */
//        SQL_LENGTH_EXCEPTION("000014", "插入数据与该表所对应的字段长度或类型不一致"),
//        /**
//         * 实体内的属性与数据库表的字段不一致
//         */
//        SQL_FILED_EXCEPTION("000015", "实体内的属性与数据库表的字段不一致"),
//        /**
//         * 内存溢出
//         */
//        OUT_OF_MEMORY_ERROR("000016", "内存溢出");
//        @Getter
//        private String code;
//        @Getter
//        private String msg;
//
//        ResponseMsg(String code, String msg) {
//            this.code = code;
//            this.msg = msg;
//        }
//    }
//
//    /***
//     * 资源类型
//     *
//     * @className ResourceType
//     * @author :技术部-zhangjs
//     * @Description 资源类型
//     * @date 2019年9月23日 下午1:55:43
//     */
//    public enum ResourceType {
//        /**
//         * 应用
//         */
//        APPLICATION("01", "应用"),
//        /**
//         * 模块
//         */
//        MODULE("02", "模块"),
//        /**
//         * 菜单
//         */
//        MENU("03", "菜单"),
//        /**
//         * 接口
//         */
//        API("04", "接口"),
//        /**
//         * 按钮
//         */
//        BUTTON("05", "按钮");
//
//        /**
//         * 资源类型编码
//         */
//        @Getter
//        private String code;
//        /**
//         * 说明
//         */
//        @Getter
//        private String msg;
//
//        ResourceType(String code, String msg) {
//            this.code = code;
//            this.msg = msg;
//        }
//
//    }
//    /***
//     * 删除类型
//     *
//     * @className ResourceType
//     * @author :技术部-zhangjs
//     * @Description 删除类型
//     * @date 2019年9月23日 下午1:55:43
//     */
//    public static class DeleteType{
//        public static Integer DELETED=1;
//        public static Integer NOT_DELETED=0;
//    }
//    /**
//     * http状态码
//     *
//     * @author :技术部-zhangjs
//     * @className HttpStatus
//     * @Description http状态码
//     * @date 2019年9月23日 下午1:55:43
//     */
//
//    public static enum HttpStatus {
//        /**
//         * 服务器成功返回请求的数据
//         */
//        OK(200, "服务器成功返回请求的数据"),
//        /**
//         * 新建或修改数据成功
//         */
//        CREATED_OR_UPDATE_OK(201, "新建或修改数据成功"),
//        /**
//         * 一个请求已经进入后台排队（异步任务）
//         */
//        QUEUE_UP(202, "一个请求已经进入后台排队（异步任务）"),
//        /**
//         * 删除数据成功
//         */
//        DELETE_OK(204, "删除数据成功"),
//        /**
//         * 发出的请求有错误，服务器没有进行新建或修改数据的操作
//         */
//        BAD_REQUEST(400, "发出的请求有错误，服务器没有进行新建或修改数据的操作"),
//        /**
//         * 用户没有权限（令牌、用户名、密码错误）
//         */
//        NO_AUTHORIZED(401, "用户没有权限（令牌、用户名、密码错误）"),
//        /**
//         * 用户得到授权，但是访问是被禁止的
//         */
//        FORBIDDEN(403, "用户得到授权，但是访问是被禁止的"),
//        /**
//         * 发出的请求针对的是不存在的记录，服务器没有进行操作
//         */
//        NOT_FOUND(404, "发出的请求针对的是不存在的记录，服务器没有进行操作"),
//        /**
//         * 请求的格式不可得
//         */
//        NOT_ACCEPTABLE(406, "请求的格式不可得"),
//        /**
//         * 请求的资源被永久删除，且不会再得到的
//         */
//        GONE(410, "请求的资源被永久删除，且不会再得到的"),
//        /**
//         * 服务器发生错误，请检查服务器
//         */
//        INTERNAL_SERVER_ERROR(500, "服务器发生错误，请检查服务器"),
//        /**
//         * 网关错误
//         */
//        BAD_GATEWAY(502, "网关错误"),
//        /**
//         * 服务不可用，服务器暂时过载或维护
//         */
//        SERVICE_UNAVAILABLE(503, "服务不可用，服务器暂时过载或维护。"),
//        /**
//         * 网关超时
//         */
//        GATEWAY_TIMEOUT(504, "网关超时");
//        @Getter
//        private Integer code;
//        @Getter
//        private String message;
//
//        HttpStatus(Integer code, String message) {
//            this.code = code;
//            this.message = message;
//        }
//    }
//
//}
