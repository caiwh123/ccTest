package com.bluemobi.to;

import com.appcore.model.AbstractObject;
import com.bluemobi.constant.BaseConstant;

/**
 * @Description 返回结果传输对象 后台管理 以及 手机接口 都采用改对象返回结果
 * status  0成功  1失败 2token过期， 由于公司历史遗留问题，为了跟前端以及php保持一致，这里暂时使用0成功1失败。
 *         状态统一使用BaseConstant里面的STATUS_SUCCESS、STATUS_FAILURE和STATUS_TOKEN_INVALID便于后期修改
 * msg  返回附加消息
 * data 返回数据体
 * @author haojian 309444359@qq.com
 * @date 2015-11-8 下午12:24:17
 * 
 */
public class ResultTO extends AbstractObject {

    private static final long serialVersionUID = 1L;
    //返回状态  0成功  1失败 2token过期，状态统一使用BaseConstant里面的STATUS_SUCCESS、STATUS_FAILURE和STATUS_TOKEN_INVALID
    private int status;
    //附加消息
    private String msg;
    //数据体
    private Object data;

    public ResultTO() {

    }

    private ResultTO(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    
    /**
     * 成功，且无特殊附加消息时使用
     * @author haojian
     * @date 2015-11-8 下午12:33:36 
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newSuccessResultTO(Object data) {
        return ResultTO.newSuccessResultTO("success", data);
    }
    /**
     * 失败，且无特殊附加消息时使用
     * @author haojian
     * @date 2015-11-8 下午12:34:16 
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newFailResultTO(Object data) {
        return ResultTO.newSuccessResultTO("failure", data);
    }
    /**
     * token过期，且无特殊附加消息时使用
     * @author haojian
     * @date 2015-11-8 下午12:34:22 
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newTokenInvalidResultTO(Object data) {
        return ResultTO.newSuccessResultTO("token invalid", data);
    }
    /**
     * 成功 时候使用
     * @author haojian
     * @date 2015-11-8 下午12:35:22 
     * @param msg
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newSuccessResultTO(String msg, Object data) {
        return new ResultTO(BaseConstant.STATUS_SUCCESS, msg, data);
    }
    /**
     * 失败时候使用
     * @author haojian
     * @date 2015-11-8 下午12:35:43 
     * @param msg
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newFailResultTO(String msg, Object data) {
        return new ResultTO(BaseConstant.STATUS_FAILURE, msg, data);
    }
    
    /**
     * 传入参数为空时调用
     * @param msg
     * @return
     */
    public static ResultTO newFailResultTOByMsg(String msg) {
        return new ResultTO(BaseConstant.STATUS_FAILURE, msg, null);
    }
    
    /**
     * 传入参数为空时调用
     * @param msg
     * @return
     */
    public static ResultTO newSuccessResultTOByMsg(String msg) {
        return new ResultTO(BaseConstant.STATUS_SUCCESS, msg, null);
    }
    
    public static ResultTO newFailShowResultTOByMsg(String msg) {
        return new ResultTO(BaseConstant.STATUS_SHOW_FAILURE, msg, null);
    }

    /**
     * token 过期时候使用
     * @author haojian
     * @date 2015-11-8 下午12:35:56 
     * @param msg
     * @param data
     * @return
     * @return ResultTO
     */
    public static ResultTO newTokenInvalidResultTO(String msg, Object data) {
        return new ResultTO(BaseConstant.STATUS_TOKEN_INVALID, msg, data);
    }

    public int getStatus() {
//    	if(data instanceof java.util.HashMap){
//    		HashMap<Object, Object> map = (HashMap<Object, Object>)data;
//    		if(map.isEmpty()){
//    			status = 3;
//    		}
//    		ArrayList<Object> list = (ArrayList<Object>)map.get("dataList");
//    		if(list == null){
//    			
//    		}else if(list.size() == 0){
//    			status = 3;
//    		}
//    		
//    	}else if(data instanceof java.util.ArrayList){
//    		ArrayList<Object> list = (ArrayList<Object>)data;
//    		if(list.size()==0){
//    			status = 3;
//    		}
//    	}
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
//    	if(data instanceof java.util.HashMap){
//    		HashMap<Object, Object> map = (HashMap<Object, Object>)data;
//    		if(map.isEmpty()){
//    			msg = "查询的列表为空";
//    		}
//    		ArrayList<Object> list = (ArrayList<Object>)map.get("dataList");
//    		if(list == null){
//    			
//    		}else if(list.size() == 0){
//    			msg = "查询的列表为空";
//    		}
//    		
//    	}else if(data instanceof java.util.ArrayList){
//    		ArrayList<Object> list = (ArrayList<Object>)data;
//    		if(list.size()==0){
//    			msg = "查询的列表为空";
//    		}
//    	}
        return msg;
    }

    public void setMsg(String error) {
        this.msg = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
