package net.developerly.support.wechat.entity;

/**
 * 微信错误信息
 *
 * @author LY
 * @create 2017/06/01
 **/
public class ErrorCode {
    /**
     * 错误编码
     */
    private String errcode;
    /**
     * 错误信息
     */
    private String errmsg;
    /**
     * 微信消息ID
     */
    private String msgid;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public boolean isSuccess(){
        return ERROR_0.equals(errcode);
    }

    // 以下为全局返回码
    public static final String ERROR_NEGATIVE_1 = "-1";     // 系统繁忙，此时请开发者稍候再试
    public static final String ERROR_0 = "0";			    // 请求成功
    public static final String ERROR_40001 = "40001";	    // 获取access_token时AppSecret错误，或者access_token无效
    public static final String ERROR_40002 = "40002";	    // 不合法的凭证类型
    public static final String ERROR_40003 = "40003";	    // 不合法的OpenID
    public static final String ERROR_40004 = "40004";	    // 不合法的媒体文件类型
    public static final String ERROR_40005 = "40005";	    // 不合法的文件类型
    public static final String ERROR_40006 = "40006";	    // 不合法的文件大小
    public static final String ERROR_40007 = "40007";	    // 不合法的媒体文件id
    public static final String ERROR_40008 = "40008";	    // 不合法的消息类型
    public static final String ERROR_40009 = "40009";	    // 不合法的图片文件大小
    public static final String ERROR_40010 = "40010";	    // 不合法的语音文件大小
    public static final String ERROR_40011 = "40011";	    // 不合法的视频文件大小
    public static final String ERROR_40012 = "40012";	    // 不合法的缩略图文件大小
    public static final String ERROR_40013 = "40013";	    // 不合法的APPID
    public static final String ERROR_40014 = "40014";	    // 不合法的access_token
    public static final String ERROR_40015 = "40015";	    // 不合法的菜单类型
    public static final String ERROR_40016 = "40016";	    // 不合法的按钮个数
    public static final String ERROR_40017 = "40017";	    // 不合法的按钮个数
    public static final String ERROR_40018 = "40018";	    // 不合法的按钮名字长度
    public static final String ERROR_40019 = "40019";	    // 不合法的按钮KEY长度
    public static final String ERROR_40020 = "40020";	    // 不合法的按钮URL长度
    public static final String ERROR_40021 = "40021";	    // 不合法的菜单版本号
    public static final String ERROR_40022 = "40022";	    // 不合法的子菜单级数
    public static final String ERROR_40023 = "40023";	    // 不合法的子菜单按钮个数
    public static final String ERROR_40024 = "40024";	    // 不合法的子菜单按钮类型
    public static final String ERROR_40025 = "40025";	    // 不合法的子菜单按钮名字长度
    public static final String ERROR_40026 = "40026"; 	    // 不合法的子菜单按钮KEY长度
    public static final String ERROR_40027 = "40027";	    // 不合法的子菜单按钮URL长度
    public static final String ERROR_40028 = "40028";	    // 不合法的自定义菜单使用用户
    public static final String ERROR_40029 = "40029";	    // 不合法的oauth_code
    public static final String ERROR_40030 = "40030";	    // 不合法的refresh_token
    public static final String ERROR_40031 = "40031";	    // 不合法的openid列表
    public static final String ERROR_40032 = "40032";	    // 不合法的openid列表长度
    public static final String ERROR_40033 = "40033";	    // 不合法的请求字符，不能包含\\uxxxx格式的字符
    public static final String ERROR_40035 = "40035";	    // 不合法的参数
    public static final String ERROR_40038 = "40038";	    // 不合法的请求格式
    public static final String ERROR_40039 = "40039";	    // 不合法的URL长度
    public static final String ERROR_40050 = "40050";	    // 不合法的分组id
    public static final String ERROR_40051 = "40051";	    // 分组名字不合法
    public static final String ERROR_40060 = "40060";	    // 删除单篇图文时，指定的 article_idx 不合法
    public static final String ERROR_40117 = "40117";	    // 分组名字不合法
    public static final String ERROR_40118 = "40118";	    // 删除单篇图文时，指定的 article_idx 不合法
    public static final String ERROR_40119 = "40119";	    // button类型错误
    public static final String ERROR_40120 = "40120";	    // button类型错误
    public static final String ERROR_40121 = "40121";	    // 不合法的media_id类型
    public static final String ERROR_40132 = "40132";	    // 微信号不合法
    public static final String ERROR_40137 = "40137";	    // 不支持的图片格式
    public static final String ERROR_40155 = "40155";	    // 请勿添加其他公众号的主页链接
    public static final String ERROR_41001 = "41001";	    // 缺少access_token参数
    public static final String ERROR_41002 = "41002";	    // 缺少appid参数
    public static final String ERROR_41003 = "41003";	    // 缺少refresh_token参数
    public static final String ERROR_41004 = "41004";	    // 缺少secret参数
    public static final String ERROR_41005 = "41005";	    // 缺少多媒体文件数据
    public static final String ERROR_41006 = "41006";	    // 缺少media_id参数
    public static final String ERROR_41007 = "41007";	    // 缺少子菜单数据
    public static final String ERROR_41008 = "41008";	    // 缺少oauth code
    public static final String ERROR_41009 = "41009";	    // 缺少openid
    public static final String ERROR_42001 = "42001";	    // access_token超时
    public static final String ERROR_42002 = "42002";	    // refresh_token超时
    public static final String ERROR_42003 = "42003";	    // oauth_code超时
    public static final String ERROR_42007 = "42007";	    // 用户修改微信密码，accesstoken和refreshtoken失效，需要重新授权
    public static final String ERROR_43001 = "43001";	    // 需要GET请求
    public static final String ERROR_43002 = "43002";	    // 需要POST请求
    public static final String ERROR_43003 = "43003";	    // 需要HTTPS请求
    public static final String ERROR_43004 = "43004";	    // 需要接收者关注
    public static final String ERROR_43005 = "43005";	    // 需要好友关系
    public static final String ERROR_43019 = "43019";	    // 需要将接收者从黑名单中移除
    public static final String ERROR_44001 = "44001";	    // 多媒体文件为空
    public static final String ERROR_44002 = "44002";	    // POST的数据包为空
    public static final String ERROR_44003 = "44003";	    // 图文消息内容为空
    public static final String ERROR_44004 = "44004";	    // 文本消息内容为空
    public static final String ERROR_45001 = "45001";	    // 多媒体文件大小超过限制
    public static final String ERROR_45002 = "45002";	    // 消息内容超过限制
    public static final String ERROR_45003 = "45003";	    // 标题字段超过限制
    public static final String ERROR_45004 = "45004";	    // 描述字段超过限制
    public static final String ERROR_45005 = "45005";	    // 链接字段超过限制
    public static final String ERROR_45006 = "45006";	    // 图片链接字段超过限制
    public static final String ERROR_45007 = "45007";	    // 语音播放时间超过限制
    public static final String ERROR_45008 = "45008";	    // 图文消息超过限制
    public static final String ERROR_45009 = "45009";	    // 接口调用超过限制
    public static final String ERROR_45010 = "45010";	    // 创建菜单个数超过限制
    public static final String ERROR_45011 = "45011";	    // API调用太频繁，请稍候再试
    public static final String ERROR_45015 = "45015";	    // 回复时间超过限制
    public static final String ERROR_45016 = "45016";	    // 系统分组，不允许修改
    public static final String ERROR_45017 = "45017";	    // 分组名字过长
    public static final String ERROR_45018 = "45018";	    // 分组数量超过上限
    public static final String ERROR_45047 = "45047";	    // 客服接口下行条数超过上限
    public static final String ERROR_46001 = "46001";	    // 不存在媒体数据
    public static final String ERROR_46002 = "46002";	    // 不存在的菜单版本
    public static final String ERROR_46003 = "46003";	    // 不存在的菜单数据
    public static final String ERROR_46004 = "46004";	    // 不存在的用户
    public static final String ERROR_47001 = "47001";	    // 解析JSON/XML内容错误
    public static final String ERROR_48001 = "48001";	    // api功能未授权
    public static final String ERROR_48002 = "48002";	    // 粉丝拒收消息（粉丝在公众号选项中，关闭了“接收消息”）
    public static final String ERROR_48004 = "48004";	    // api接口被封禁，请登录mp.weixin.qq.com查看详情
    public static final String ERROR_48005 = "48005";	    // api禁止删除被自动回复和自定义菜单引用的素材
    public static final String ERROR_48006 = "48006";	    // api禁止清零调用次数，因为清零次数达到上限
    public static final String ERROR_50001 = "50001";	    // 用户未授权该api
    public static final String ERROR_50002 = "50002";	    // 用户受限，可能是违规后接口被封禁
    public static final String ERROR_61451 = "61451";	    // 参数错误(invalid parameter)
    public static final String ERROR_61452 = "61452";	    // 无效客服账号(invalid kf_account)
    public static final String ERROR_61453 = "61453";	    // 客服帐号已存在(kf_account exsited)
    public static final String ERROR_61454 = "61454";	    // 客服帐号名长度超过限制(仅允许10个英文字符，不包括@及@后的公众号的微信号)(invalid   kf_acount length)
    public static final String ERROR_61455 = "61455";	    // 客服帐号名包含非法字符(仅允许英文+数字)(illegal character in     kf_account)
    public static final String ERROR_61456 = "61456";	    // 客服帐号个数超过限制(10个客服账号)(kf_account count exceeded)
    public static final String ERROR_61457 = "61457";	    // 无效头像文件类型(invalid   file type)
    public static final String ERROR_61450 = "61450";	    // 系统错误(system error)
    public static final String ERROR_61500 = "61500";	    // 日期格式错误
    public static final String ERROR_65301 = "65301";	    // 不存在此menuid对应的个性化菜单
    public static final String ERROR_65302 = "65302";	    // 没有相应的用户
    public static final String ERROR_65303 = "65303";	    // 没有默认菜单，不能创建个性化菜单
    public static final String ERROR_65304 = "65304";	    // MatchRule信息为空
    public static final String ERROR_65305 = "65305";	    // 个性化菜单数量受限
    public static final String ERROR_65306 = "65306";	    // 不支持个性化菜单的帐号
    public static final String ERROR_65307 = "65307";	    // 个性化菜单信息为空
    public static final String ERROR_65308 = "65308";	    // 包含没有响应类型的button
    public static final String ERROR_65309 = "65309";	    // 个性化菜单开关处于关闭状态
    public static final String ERROR_65310 = "65310";	    // 填写了省份或城市信息，国家信息不能为空
    public static final String ERROR_65311 = "65311";	    // 填写了城市信息，省份信息不能为空
    public static final String ERROR_65312 = "65312";	    // 不合法的国家信息
    public static final String ERROR_65313 = "65313";	    // 不合法的省份信息
    public static final String ERROR_65314 = "65314";	    // 不合法的城市信息
    public static final String ERROR_65316 = "65316";	    // 该公众号的菜单设置了过多的域名外跳（最多跳转到3个域名的链接）
    public static final String ERROR_65317 = "65317";	    // 不合法的URL

    public static final String ERROR_9001001 = "9001001";	    // POST数据参数不合法
    public static final String ERROR_9001002 = "9001002";	    // 远端服务不可用
    public static final String ERROR_9001003 = "9001003";	    // Ticket不合法
    public static final String ERROR_9001004 = "9001004";	    // 获取摇周边用户信息失败
    public static final String ERROR_9001005 = "9001005";	    // 获取商户信息失败
    public static final String ERROR_9001006 = "9001006";	    // 获取OpenID失败
    public static final String ERROR_9001007 = "9001007";	    // 上传文件缺失
    public static final String ERROR_9001008 = "9001008";	    // 上传素材的文件类型不合法
    public static final String ERROR_9001009 = "9001009";	    // 上传素材的文件尺寸不合法
    public static final String ERROR_9001010 = "9001010";	    // 上传失败
    public static final String ERROR_9001020 = "9001020";	    // 帐号不合法
    public static final String ERROR_9001021 = "9001021";	    // 已有设备激活率低于50%，不能新增设备
    public static final String ERROR_9001022 = "9001022";	    // 设备申请数不合法，必须为大于0的数字
    public static final String ERROR_9001023 = "9001023";	    // 已存在审核中的设备ID申请
    public static final String ERROR_9001024 = "9001024";	    // 一次查询设备ID数量不能超过50
    public static final String ERROR_9001025 = "9001025";	    // 设备ID不合法
    public static final String ERROR_9001026 = "9001026";	    // 页面ID不合法
    public static final String ERROR_9001027 = "9001027";	    // 页面参数不合法
    public static final String ERROR_9001028 = "9001028";	    // 一次删除页面ID数量不能超过10
    public static final String ERROR_9001029 = "9001029";	    // 页面已应用在设备中，请先解除应用关系再删除
    public static final String ERROR_9001030 = "9001030";	    // 一次查询页面ID数量不能超过50
    public static final String ERROR_9001031 = "9001031";	    // 时间区间不合法
    public static final String ERROR_9001032 = "9001032";	    // 保存设备与页面的绑定关系参数错误
    public static final String ERROR_9001033 = "9001033";	    // 门店ID不合法
    public static final String ERROR_9001034 = "9001034";	    // 设备备注信息过长
    public static final String ERROR_9001035 = "9001035";	    // 设备申请参数不合法
    public static final String ERROR_9001036 = "9001036";	    // 查询起始值begin不合法

}
