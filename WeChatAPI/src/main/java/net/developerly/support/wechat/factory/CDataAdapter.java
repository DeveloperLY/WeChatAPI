package net.developerly.support.wechat.factory;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author LY
 * @create 2017/06/04
 **/
public class CDataAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String arg0) throws Exception {
        return "<![CDATA[" + arg0 + "]]>";
    }

    @Override
    public String unmarshal(String arg0) throws Exception {
        return arg0;
    }
}
