package com.kouyy.training.dowith.oldJava;

/**
 * sql拼接
 */
public class Demo{
    public static void main(String[] args) throws InterruptedException {
        Integer[] ids={5862,4743,1582};
//        print_tagId(ids);
//        mathFun();
        print2_tagId(ids);
    }


    public static void print_tagNmae(String... str){

        String sql1="select t.id from \n" +
                "(select DISTINCT id ,tag_id from information_tag ) t\n" +
                "where t.tag_id in\n" +
                "(select id from tag where tag_name in (";

        StringBuilder sb=new StringBuilder();
        sb.append("?");
        if(str.length>1){
            for (int i = 0; i < str.length-1; i++) {
                sb.append(",?");
            }
        }
        String sql2=sb.toString();
        String sql3=") group by t.id having count(*)=";
        String sql4=str.length+"";

        String sql=sql1+sql2+sql3+sql4;
        System.out.println(sql);
    }


    public static void print_tagId(Integer... ids){

        String sql1="SELECT\n" +
                "\tid,\n" +
                "\tinformation_id,\n" +
                "\tinformation_type,\n" +
                "\tnews_type,\n" +
                "\ttitle_length,\n" +
                "\tcontent_length,\n" +
                "\tpublish_time,\n" +
                "\tcreate_time,\n" +
                "\tupdate_time\n" +
                "FROM\n" +
                "\tinformation_info\n" +
                "WHERE\n" +
                "\tid IN (\n" +
                "\t\tSELECT\n" +
                "\t\t\tt.id\n" +
                "\t\tFROM\n" +
                "\t\t\t(\n" +
                "\t\t\t\tSELECT DISTINCT\n" +
                "\t\t\t\t\tid,\n" +
                "\t\t\t\t\ttag_id\n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\tinformation_tag\n" +
                "\t\t\t) t\n" +
                "\t\tWHERE\n" +
                "\t\t\tt.tag_id IN (";

        StringBuilder sb=new StringBuilder();
        sb.append("?");
        if(ids.length>1){
            for (int i = 0; i < ids.length-1; i++) {
                sb.append(",?");
            }
        }
        String sql2=sb.toString();
        String sql3=") group by t.id having count(*)=";
        String sql4=ids.length+") AND publish_time >=?";

        String sql=sql1+sql2+sql3+sql4;
        System.out.println(sql);
    }


    public static void print2_tagId(Integer... ids){
        String sql1="SELECT\n" +
                " i.id,\n" +
                " i.information_type,\n" +
                " i.news_type,\n" +
                " i.title_length,\n" +
                " i.content_length,\n" +
                " i.publish_time,\n" +
                " i.create_time,\n" +
                " i.update_time\n" +
                " FROM \n" +
                " (\n" +
                " SELECT id,SUM(num)  FROM \n" +
                " ( SELECT  id,tag_id,1 num FROM information_tag  WHERE  tag_id IN (";

        StringBuilder sb=new StringBuilder();
        sb.append("?");
        if(ids.length>1){
            for (int i = 0; i < ids.length-1; i++) {
                sb.append(",?");
            }
        }
        String sql2=sb.toString();
        String sql3=") GROUP BY id,tag_id )a \n" +
                " GROUP BY id   HAVING SUM(num)=";




        String sql4=ids.length+") m INNER JOIN\n" +
                "information_info  i ON i.id=m.id \n" +
                "WHERE i.publish_time>=?";

        String sql=sql1+sql2+sql3+sql4;
        System.out.println(sql);
    }


}
