package net.developerly.support.wechat.utils;

import net.developerly.support.wechat.cgi.HandleTicket;
import net.developerly.support.wechat.cgi.HandleToken;
import net.developerly.support.wechat.cgi.web.UserToken;
import net.developerly.support.wechat.entity.ErrorCode;
import net.developerly.support.wechat.exception.WeChatException;
import net.developerly.support.wechat.exception.WeChatJsonParserException;

/**
 * 微信请求工具类
 *
 * @author LY
 * @create 2017/06/03
 **/
public class ResultsUtils {
    public static HandleTicket.Ticket toTicket(final byte[] datas) throws WeChatException {
        HandleTicket.Ticket ticket = new HandleTicket.Ticket();
        try {
            ticket=JsonUtils.toBean(HandleTicket.Ticket.class, datas);
        } catch (WeChatJsonParserException e) {
            toException(datas);
        }
        return ticket;
    }

    public static void toException(final byte[] datas) throws WeChatException {
        ErrorCode code = toErrorCode(datas);

        if (isErrorCode(code)&&!isOK(code)) {
            throw new WeChatException(code.getErrcode(), code.getErrmsg());
        }
    }


    public static HandleToken.Token toToken(final byte[] datas) throws WeChatException {
        HandleToken.Token token = new HandleToken.Token();
        try {
            token=JsonUtils.toBean(HandleToken.Token.class, datas);
        } catch (WeChatJsonParserException e) {
            toException(datas);
        }
        return token;
    }

    public static UserToken.Token toUserToken(final byte[] datas) throws WeChatException {
        UserToken.Token token = new UserToken.Token();
        try {
            token = JsonUtils.toBean(UserToken.Token.class, datas);
        } catch (WeChatJsonParserException e) {
            toException(datas);
        }
        return token;
    }

    public static String toDataStr(final byte[] datas) throws WeChatException {
        toException(datas);
        return new String(datas, CharsetUtils.UTF8);
    }


    private static ErrorCode toErrorCode(final byte[] datas) {
        ErrorCode code = null;
        try {
            code=JsonUtils.toBean(ErrorCode.class, datas);
        } catch (WeChatJsonParserException e) {
            // TODO 屏蔽异常，返回null
        }
        return code;
    }


    private static boolean isErrorCode(final ErrorCode code) {
        return code != null;
    }


    private static boolean isOK(final ErrorCode code) {
        return isErrorCode(code) && code.isSuccess();
    }
}
