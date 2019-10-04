package com.qjx.singleton.chain2;

/**
 * 项目经理处理
 */
public class ProjectManager extends Handler{

    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";
        if(fee<500){
            if("张三".equals(user)){
                str = "成功：项目经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }else {
                str = "失败：项目经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        }else {
            if(getHandler()!=null){
                return getHandler().handleFeeRequest(user,fee);
            }
        }

        return str;
    }
}
