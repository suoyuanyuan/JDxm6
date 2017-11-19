package test.bawei.jdxm6.bean;

import java.util.List;

/**
 * Created by 索园 on 2017/11/16.
 */

public class DingList {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-11-16T16:32:54","orderid":1824,"price":99.99,"status":0,"title":null,"uid":2253},{"createtime":"2017-11-16T17:48:57","orderid":1831,"price":99.99,"status":0,"title":null,"uid":2253},{"createtime":"2017-11-16T20:00:59","orderid":1845,"price":99.99,"status":0,"title":null,"uid":2253},{"createtime":"2017-11-16T20:01:10","orderid":1847,"price":1,"status":0,"title":null,"uid":2253},{"createtime":"2017-11-16T20:05:00","orderid":1848,"price":99.99,"status":0,"title":null,"uid":2253}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-16T16:32:54
         * orderid : 1824
         * price : 99.99
         * status : 0
         * title : null
         * uid : 2253
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private Object title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTitle() {
            return title;
        }

        public void setTitle(Object title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
