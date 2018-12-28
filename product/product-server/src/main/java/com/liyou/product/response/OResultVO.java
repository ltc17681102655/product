package com.liyou.product.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kang.lu
 */
public class OResultVO extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 4740142776111225391L;
    
    private int ResultCode = 0;
    
    private Object Body;
    
    private String ErrMsg;
    
    public OResultVO() {
    }
    
    public OResultVO(Object body) {
        super();
        this.ResultCode = 0;
        this.ErrMsg = "";
        Body = body;
    }
    
    public OResultVO(int ResultCode, String ErrMsg) {
        super();
        this.ResultCode = ResultCode;
        this.ErrMsg = ErrMsg;
        
    }
    
    public OResultVO(int resultCode, Object body, String errMsg) {
        super();
        ResultCode = resultCode;
        Body = body;
        ErrMsg = errMsg;
    }
    
    
    public OResultVO(int resultCode, Object body) {
        super();
        ResultCode = resultCode;
        Body = body;
    }
    
    public int getResultCode() {
        return ResultCode;
    }
    
    public void setResultCode(int resultCode) {
        ResultCode = resultCode;
    }
    
    public Object getBody() {
        return Body;
    }
    
    public void setBody(Object body) {
        Body = body;
    }
    
    public String getErrMsg() {
        return ErrMsg;
    }
    
    public void setErrMsg(String errMsg) {
        ErrMsg = errMsg;
    }
    
    public OResultVO success() {
        this.ErrMsg = null;
        Map<String, String> map = new HashMap<>();
        map.put("success", "true");
        this.Body = map;
        this.ResultCode = 0;
        return this;
    }
    
    public OResultVO failure(int resultCode, String msg) {
        this.ErrMsg = msg;
        this.Body = null;
        this.ResultCode = resultCode;
        return this;
    }
}
