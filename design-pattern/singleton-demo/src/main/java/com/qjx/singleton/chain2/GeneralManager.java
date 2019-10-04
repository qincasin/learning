package com.qjx.singleton.chain2;

public class GeneralManager extends Handler{
    @Override
    public String handleFeeRequest(String user, double fee) {

        String str ="";
        if(fee>1000){
            if("张三".equals(user)){
                str = "成功：总经理同意【" + user + "】的聚餐费用，金额为" + fee + "元";

            }else {
                str = "失败：总经理不同意【" + user + "】的聚餐费用，金额为" + fee + "元";
            }
        }else {
            if(getHandler()!=null){
                return getHandler().handleFeeRequest(user,fee);
            }
        }
        return str;
    }
}
